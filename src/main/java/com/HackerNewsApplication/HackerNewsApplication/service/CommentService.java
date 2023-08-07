package com.HackerNewsApplication.HackerNewsApplication.service;

import com.HackerNewsApplication.HackerNewsApplication.entity.Comment1;
import com.HackerNewsApplication.HackerNewsApplication.entity.Story;
import com.HackerNewsApplication.HackerNewsApplication.jpa.CommentRepository;
import com.HackerNewsApplication.HackerNewsApplication.jpa.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {
    private final static String HACKER_NEWS_API_URL = "https://hacker-news.firebaseio.com/v0";
    private final static String TOP_STORIES_ENDPOINT = "/topstories.json";
    private final static String ITEM_ENDPOINT = "/item/";

    private final static int MAX_COMMENTS = 10;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private StoryRepository storyRepository;
    LocalDateTime fifteenMinutesAgo = LocalDateTime.now();
    public List<Comment1> getCommentsForStory(Long StoryId) {
        // Retrieve the story using storyRepository.findById(storyId)
        Story story = storyRepository.findById(StoryId).orElse(null);
        if (story == null) {
            throw new IllegalArgumentException("Story not found");
        }

        // Fetch top 10 comments for the given story sorted by total number of child comments
        return commentRepository.findTop10ByStoryOrderByTotalChildCommentsDesc(story);
    }
}
