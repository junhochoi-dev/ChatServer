package com.project.chatserver.domain.type;

public enum MessageType {
    CHANNEL_IN, CHANNEL_OUT,

    MESSAGE_TXT, MESSAGE_IMG, MESSAGE_NOTIFICATION,

    LOGIN, // 채팅방 리스트
    UPDATE, // 갱신된 채팅방 하나씩
    LOGOUT
}
