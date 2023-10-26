package com.baeker.Community.post.domain;

import com.baeker.Community.global.dto.reqDto.CreateStudyPostDto;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@SuperBuilder(toBuilder = true)
@DiscriminatorValue("S")
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class StudyPost extends Post {

    private Long studyId;

    public static StudyPost write(Long memberId, CreateStudyPostDto dto) {
        return StudyPost.builder()
                .memberId(memberId)
                .studyId(dto.getStudyId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
    }

    //-- test 용 객체 생성 --//
    public static Post forTest(Long memberId, Long postId, Long studyId, String title, String content) {
        return StudyPost.builder()
                .id(postId)
                .studyId(studyId)
                .memberId(memberId)
                .title(title)
                .content(content)
                .build();
    }
}
