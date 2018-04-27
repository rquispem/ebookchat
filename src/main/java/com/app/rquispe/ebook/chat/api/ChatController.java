package com.app.rquispe.ebook.chat.api;

import com.app.rquispe.ebook.chatroom.domain.model.ChatRoom;
import com.app.rquispe.ebook.chatroom.domain.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ChatController {

    @Autowired
    private ChatRoomService chatRoomService;

    @RequestMapping("/chat")
    public ModelAndView getRooms() {
        ModelAndView modelAndView = new ModelAndView("chat");
        List<ChatRoom> chatRooms = chatRoomService.findAll();
        modelAndView.addObject("chatRooms", chatRooms);
        return modelAndView;
    }
}
