package com.app.rquispe.ebook.chatroom.domain.repository;

import com.app.rquispe.ebook.chatroom.domain.model.ChatRoom;
import org.springframework.data.repository.CrudRepository;

public interface ChatRoomRepository extends CrudRepository<ChatRoom, String> {
}
