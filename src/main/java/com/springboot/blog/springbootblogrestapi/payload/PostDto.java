package com.springboot.blog.springbootblogrestapi.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class PostDto {
    private Long id;
    //title should not be null or empty
    //title should have at least 2 character
    @NotEmpty
    @Size(min = 2,message = "Post title should have at least 2 characters")
    private String title;

    //post description should not be empty or null
    //post description should have at lease 10 character
    @NotEmpty
    @Size(min = 10,message = "Post description should have at least 10 characters")
    private String description;

     //post content should not be null or empty
    @NotEmpty
    private String content;

    //fetch related comment also while fetching post
    private Set<CommentDto>comments;

    //add category to different posts
    private Long categoryId;


}
