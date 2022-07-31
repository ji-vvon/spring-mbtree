package com.mbtree.sping.web.dto;

import com.mbtree.sping.domain.messages.Messages;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MessagesSaveRequestDto {
    private Long writerId;
    private Long treeId;
    private String content;

    @Builder
    public MessagesSaveRequestDto(Long writerId, Long treeId, String content) {
        this.writerId = writerId;
        this.treeId = treeId;
        this.content = content;
    }

    public Messages toEntity() {
        return Messages.builder()
                .writerId(writerId)
                .treeId(treeId)
                .content(content)
                .build();
    }
}
