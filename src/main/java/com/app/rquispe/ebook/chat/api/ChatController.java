package com.app.rquispe.ebook.chat.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ChatController {

    @RequestMapping("/chat")
    public ModelAndView getRooms() {
        ModelAndView modelAndView = new ModelAndView("chat");
//        List<ChatRoom> chatRooms = chatRoomService.findAll();
//        modelAndView.addObject("chatRooms", chatRooms);
        return modelAndView;
    }
}
