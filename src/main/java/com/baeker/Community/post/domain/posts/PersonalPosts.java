package com.baeker.Community.post.domain.posts;

import com.baeker.Community.member.domain.embedded.Posting;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalPosts {

    private Long memberId;
    private List<Posting> postings;
}
