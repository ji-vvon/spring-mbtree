package com.mbtree.sping.domain.messages;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    private Long writerId;

    private Long treeId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Builder
    public Messages(Long writerId, Long treeId, String content) {
        this.writerId = writerId;
        this.treeId = treeId;
        this.content = content;
    }

}
