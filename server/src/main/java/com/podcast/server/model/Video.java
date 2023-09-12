package com.podcast.server.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "videos")
public class Video {

    @Id
    private int id;

    @Column
    private String name;

    @Column
    private String url;

    @Column(name="created_at")
   private String createdAt;

}
