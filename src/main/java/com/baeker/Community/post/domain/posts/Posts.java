package com.baeker.Community.post.domain.posts;

import com.baeker.Community.global.dto.reqDto.CreatePostsReqDto;
import com.baeker.Community.member.domain.embedded.Posting;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Document
@Getter
@Builder(toBuilder = true, access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class Posts {

    @Id
    private String id;
    private Long missionId;

    @Field("postings")
    @Builder.Default
    private Map<Long, PersonalPosts> postings = new HashMap<>();


    public static Posts create(CreatePostsReqDto dto) {
        Posts posts = Posts.builder()
                .missionId(dto.getMissionId())
                .build();

        for (Long memberId : dto.getMemberIdList())
            posts.settingMember(memberId, dto.getTitleList());

        return posts;
    }

    private void settingMember(Long memberId, List<String> titleList) {
        List<Posting> postings =  new ArrayList<>();
        for (String title : titleList)
            postings.add(new Posting(memberId, title));

        PersonalPosts posts = new PersonalPosts(memberId, postings);
        this.postings.put(memberId, posts);
    }

    public void writePost(Long memberId, Posting posting) {
        List<Posting> postList = this.postings.get(memberId).getPostings();

        for (Posting post : postList)
            if (post.getTitle().equals(posting.getTitle()))
                postList.remove(post);

        postList.add(posting);
    }
}
