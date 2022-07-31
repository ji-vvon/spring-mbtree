package com.mbtree.sping.web;

import com.mbtree.sping.service.messages.MessagesService;
import com.mbtree.sping.web.dto.MessagesResponseDto;
import com.mbtree.sping.web.dto.MessagesSaveRequestDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MessagesApiController {

    private final MessagesService messagesService;

    @PostMapping("/message/send")
    public Long save(@RequestBody MessagesSaveRequestDto requestDto){
        return messagesService.save(requestDto);
    }

    @GetMapping("/message/{messageId}")
    public MessagesResponseDto findById (@PathVariable Long messageId){
        return messagesService.findById(messageId);
    }

    @DeleteMapping("/message/delete/{messageId}")
    public Long delete (@PathVariable Long messageId){
        messagesService.delete(messageId);
        return messageId;
    }
}
