package com.project.chatserver.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Channel {
    @Id
    private String id;
}
