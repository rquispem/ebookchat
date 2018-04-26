package com.app.rquispe.ebook.chatroom.api;

import com.app.rquispe.ebook.chatroom.domain.model.ChatRoom;
import com.app.rquispe.ebook.chatroom.domain.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ChatRoomController {

    @Autowired
    private ChatRoomService chatRoomService;

    /*
     * @Secured("ROLE_ADMIN") annotation, tells Spring Security to allow only logged-in users with the role ROLE_ADMIN to
     * consume this endpoint. otherwise, it will automatically send a 403 FORBIDDEN status code to the client.
     *
     * Spring MVC will first convert the JSON in the HTTP request body (that’s
     * why you use the @RequestBody annotation) to the chatroom object and call
     * the createChatRoom method.
     *
     * will convert the new chatroom object into a JSON representation and append it to
     * the HTTP response body (that’s why you used the @ResponseBody annotation)
     */
    @Secured("ROLE_ADMIN")
    @RequestMapping(path = "/chatroom", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    public ChatRoom createChatRoom(@RequestBody ChatRoom chatRoom) {
        return chatRoomService.save(chatRoom);
    }
}
