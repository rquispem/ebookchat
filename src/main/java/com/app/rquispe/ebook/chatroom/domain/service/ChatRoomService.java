package com.app.rquispe.ebook.chatroom.domain.service;

import com.app.rquispe.ebook.chatroom.domain.model.ChatRoom;

import java.util.List;

public interface ChatRoomService {
    ChatRoom save(ChatRoom chatRoom);
    List<ChatRoom> findAll();

    ChatRoom findById(String chatRoomId);
}
