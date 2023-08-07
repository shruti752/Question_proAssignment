package com.HackerNewsApplication.HackerNewsApplication.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
    private Long id;
    @Column(name = "hacker_News_Handle")
    private String hackerNewsHandle;
}
