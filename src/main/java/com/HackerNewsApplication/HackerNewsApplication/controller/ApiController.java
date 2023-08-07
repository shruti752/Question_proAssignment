package com.HackerNewsApplication.HackerNewsApplication.controller;

import com.HackerNewsApplication.HackerNewsApplication.Dao.StoryDto;
import com.HackerNewsApplication.HackerNewsApplication.entity.Comment1;
import com.HackerNewsApplication.HackerNewsApplication.entity.Story;
import com.HackerNewsApplication.HackerNewsApplication.service.CommentService;
import com.HackerNewsApplication.HackerNewsApplication.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private StoryService storyService;
    @Autowired
    private CommentService commentService;


    @GetMapping("/top-stories")
    public ResponseEntity<List<Story>> getTopStories() {
        List<Story> topStories = storyService.getTopStories();
        return ResponseEntity.ok(topStories);
    }

    @GetMapping("/past-stories")
    public ResponseEntity<List<Story>> getPastStories() {
        List<Story> pastStories = storyService.getPastStories();
        return ResponseEntity.ok(pastStories);
    }

    @GetMapping("/comments/{storyId}")
    public ResponseEntity<List<Comment1>> getCommentsForStory(@PathVariable Long storyId) {
        List<Comment1> comments = commentService.getCommentsForStory(storyId);
        return ResponseEntity.ok(comments);
    }

}
