package com.HackerNewsApplication.HackerNewsApplication.jpa;

import com.HackerNewsApplication.HackerNewsApplication.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface StoryRepository  extends JpaRepository<Story,Long> {
    List<Story> findBySubmissionTimeGreaterThanEqualOrderByScoreDesc(LocalDateTime fifteenMinutesAgo);





}
