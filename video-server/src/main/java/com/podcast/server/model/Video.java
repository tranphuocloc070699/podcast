package com.podcast.server.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "tbl_video"
)
public class Video {

    @Id
//    @SequenceGenerator(
//            name = "tbl_video_id_seq",
//            sequenceName = "tbl_video_id_seq",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "tbl_video_id_seq"
//    )
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column()
    private String name;

    @Column()
    private String url;
    
    @Column(name="created_at")
    private Date createdAt;
    
    @Column(name="updated_at")
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        updatedAt = new Date();
    }
    
    @PreUpdate
    protected void onUpdate(){
        updatedAt = new Date();
    }

}
