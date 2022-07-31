package com.mbtree.sping.web.dto;

import com.mbtree.sping.domain.messages.Messages;

public class MessagesResponseDto {
    private Long messageId;
    private Long writerId;
    private Long treeId;
    private String content;

    public MessagesResponseDto(Messages entity) {
        this.messageId = entity.getMessageId();
        this.writerId = entity.getWriterId();
        this.treeId = entity.getTreeId();
        this.content = entity.getContent();
    }
}
