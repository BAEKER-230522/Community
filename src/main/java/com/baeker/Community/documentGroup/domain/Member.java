package com.baeker.Community.documentGroup.domain;

import com.baeker.Community.documentGroup.domain.embedded.Posting;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Document
@Getter
@Builder(toBuilder = true, access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class Member {

    @Id
    private String id;
    private Long memberId;

    @Builder.Default
    private List<Posting> postings = new ArrayList<>();


    public static Member create(Long memberId) {
        return Member.builder()
                .memberId(memberId)
                .build();
    }

    public void writePost(Posting posting) {
        this.postings.add(posting);
    }
}
