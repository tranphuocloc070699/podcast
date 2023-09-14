package com.podcast.server.repository;

import com.podcast.server.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository  extends JpaRepository<Video,Integer>{
}
