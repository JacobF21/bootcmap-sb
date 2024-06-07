package com.demo.demo_forum.mapper;

import org.springframework.stereotype.Component;
import com.demo.demo_forum.entity.CommentEntity;
import com.demo.demo_forum.entity.PostEntity;
import com.demo.demo_forum.model.Comment;

@Component
public class CommentEntityMapper {
    public CommentEntity map(Comment comment) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setId(comment.getCommentId());
        commentEntity.setName(comment.getName());
        commentEntity.setEmail(comment.getEmail());
        commentEntity.setBody(comment.getBody());
        
        PostEntity postEntity = new PostEntity();
        postEntity.setId(comment.getPostId());
        commentEntity.setPost(postEntity);
        
        return commentEntity;
    }
}
