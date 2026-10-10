package com.portfolio.editor.dto;
import com.portfolio.editor.model.Video;
import java.time.Instant;
public record VideoResponse(Long id,String title,String description,String category,String videoUrl,String thumbnailUrl,Instant createdAt,boolean featured) {
  public static VideoResponse from(Video v){return new VideoResponse(v.getId(),v.getTitle(),v.getDescription(),v.getCategory(),v.getVideoUrl(),v.getThumbnailUrl(),v.getCreatedAt(),v.isFeatured());}
}
