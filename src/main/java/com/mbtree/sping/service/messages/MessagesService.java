package com.mbtree.sping.service.messages;

import com.mbtree.sping.domain.messages.Messages;
import com.mbtree.sping.domain.messages.MessagesRepository;
import com.mbtree.sping.web.dto.MessagesResponseDto;
import com.mbtree.sping.web.dto.MessagesSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class MessagesService {
    private final MessagesRepository messagesRepository;

    @Transactional
    public long save(MessagesSaveRequestDto requestDto) {
        return messagesRepository.save(requestDto.toEntity()).getMessageId();
    }

    @Transactional
    public MessagesResponseDto findById(Long messageId) {
        Messages entity = messagesRepository.findById(messageId).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" +messageId));
        return new MessagesResponseDto(entity);
    }

    @Transactional
    public void delete(Long messageId) {
        Messages messages = messagesRepository.findById(messageId).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" +messageId));
        messagesRepository.delete(messages);
    }
}
