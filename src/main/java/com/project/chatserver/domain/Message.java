package com.project.chatserver.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
public class Message {
    @Id
    private String id;



    private Timestamp createdTime;
}
