package com.HackerNewsApplication.HackerNewsApplication.jpa;

import com.HackerNewsApplication.HackerNewsApplication.entity.Comment1;
import com.HackerNewsApplication.HackerNewsApplication.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository  extends JpaRepository<Comment1, Long> {
    List<Comment1> findTop10ByStoryOrderByTotalChildCommentsDesc(Story story);

}
