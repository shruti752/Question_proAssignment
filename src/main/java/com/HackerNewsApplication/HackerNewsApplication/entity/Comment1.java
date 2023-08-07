package com.HackerNewsApplication.HackerNewsApplication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "comments")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Comment1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "comment_Text")
    private String commentText;
    @Column(name = "hackerNewsHandle")
    private String hackerNewsHandle;
    @Column(name = "childCommentsCount")
    private Integer totalChildComments;
    @ManyToOne
    @JoinColumn(name = "story_id")
    private Story story;


}
