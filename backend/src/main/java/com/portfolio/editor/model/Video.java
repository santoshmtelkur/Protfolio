package com.portfolio.editor.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name="videos")
public class Video {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @Column(nullable=false) private String title;
  @Column(length=1200) private String description;
  @Column(nullable=false) private String category;
  @Column(nullable=false, length=1500) private String videoUrl;
  @Column(nullable=false) private String publicId;
  private String thumbnailUrl;
  @Column(nullable=false) private Instant createdAt = Instant.now();
  private boolean featured;

  public Long getId(){return id;} public String getTitle(){return title;} public void setTitle(String v){title=v;}
  public String getDescription(){return description;} public void setDescription(String v){description=v;}
  public String getCategory(){return category;} public void setCategory(String v){category=v;}
  public String getVideoUrl(){return videoUrl;} public void setVideoUrl(String v){videoUrl=v;}
  public String getPublicId(){return publicId;} public void setPublicId(String v){publicId=v;}
  public String getThumbnailUrl(){return thumbnailUrl;} public void setThumbnailUrl(String v){thumbnailUrl=v;}
  public Instant getCreatedAt(){return createdAt;} public boolean isFeatured(){return featured;} public void setFeatured(boolean v){featured=v;}
}
