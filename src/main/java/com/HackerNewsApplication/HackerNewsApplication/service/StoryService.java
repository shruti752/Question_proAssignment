package com.HackerNewsApplication.HackerNewsApplication.service;

import com.HackerNewsApplication.HackerNewsApplication.entity.Story;
import com.HackerNewsApplication.HackerNewsApplication.jpa.StoryRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class StoryService {
    private final static String HACKER_NEWS_API_URL = "https://hacker-news.firebaseio.com/v0";
    private final static String TOP_STORIES_ENDPOINT = "/topstories.json";
    private final static String ITEM_ENDPOINT = "/item/";

    private final static int MAX_COMMENTS = 10;
    @Autowired
    private StoryRepository storyRepository;

    public List<Story> getTopStories() {
        // Get the current time and calculate 15 minutes ago
        LocalDateTime fifteenMinutesAgo = LocalDateTime.now();

        // Get the list of top story IDs from the Hacker News API
        RestTemplate restTemplate = new RestTemplate();
        Long[] topStoryIds = restTemplate.getForObject(HACKER_NEWS_API_URL + TOP_STORIES_ENDPOINT, Long[].class);

        // Fetch each story by ID and save it to the database
        for (int i = 0; i < 10 && i < topStoryIds.length; i++) {
            Long storyId = topStoryIds[i];
            Story story = restTemplate.getForObject(HACKER_NEWS_API_URL + ITEM_ENDPOINT + storyId + ".json", Story.class);
            if (story != null) {
                story.setSubmissionTime(fifteenMinutesAgo);
                storyRepository.save(story);
            }
        }
        //  LocalDateTime localDateTime = fifteenMinutesAgo.minusSeconds(15 * 60);


        // Retrieve the top 10 stories ranked by score in the last 15 minutes
        return storyRepository.findBySubmissionTimeGreaterThanEqualOrderByScoreDesc(fifteenMinutesAgo);


    }

    public List<Story> getPastStories() {
        // Retrieve all the stories served previously from the 1st endpoint (/top-stories)
        return storyRepository.findAll();
    }

}
