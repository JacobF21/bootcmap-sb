package com.demo.demo_forum.mapper;

import org.springframework.stereotype.Component;
import com.demo.demo_forum.entity.PostEntity;
import com.demo.demo_forum.entity.UserEntity;
import com.demo.demo_forum.model.Post;

@Component
public class PostEntityMapper {
    
  public PostEntity map(Post post) {
        PostEntity postEntity = new PostEntity();
        postEntity.setId(post.getPostId());
        postEntity.setTitle(post.getTitle());
        postEntity.setBody(post.getBody());
        
        UserEntity userEntity = new UserEntity();
        userEntity.setId(post.getUserId());
        postEntity.setUser(userEntity);
        
        return postEntity;
    }

    public Post map(PostEntity postEntity) {

      return Post.builder().userId(postEntity.getUser().getId())//
                 .title(postEntity.getTitle())
                 .body(postEntity.getBody())
                 .postId(postEntity.getId())
                 .build();
  }
}
