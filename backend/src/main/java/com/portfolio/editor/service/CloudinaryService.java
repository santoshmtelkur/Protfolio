package com.portfolio.editor.service;
import com.cloudinary.*; import com.cloudinary.utils.ObjectUtils; import org.springframework.beans.factory.annotation.Value; import org.springframework.stereotype.Service; import org.springframework.web.multipart.MultipartFile;
import java.util.Map;
@Service public class CloudinaryService {
 private final Cloudinary cloud;
 public CloudinaryService(@Value("${cloudinary.cloud-name}")String name,@Value("${cloudinary.api-key}")String key,@Value("${cloudinary.api-secret}")String secret){cloud=new Cloudinary(ObjectUtils.asMap("cloud_name",name,"api_key",key,"api_secret",secret,"secure",true));}
 public Map upload(MultipartFile file)throws Exception{return cloud.uploader().upload(file.getBytes(),ObjectUtils.asMap("resource_type","video","folder","editor-portfolio"));}
 public void delete(String publicId)throws Exception{cloud.uploader().destroy(publicId,ObjectUtils.asMap("resource_type","video"));}
}
