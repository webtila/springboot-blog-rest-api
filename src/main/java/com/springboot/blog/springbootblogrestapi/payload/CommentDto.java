package com.springboot.blog.springbootblogrestapi.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentDto {

    private Long id;

    @NotEmpty(message = "Name should not be null or empty")
    private String name;
    //email should not be null
    //email field validation
    @NotEmpty(message = "Email should not be null or empty")
    @Email
    private String email;

    //comment body should bot be null or empty
    //comment body must be minimum 10 character
    @NotEmpty
    @Size(min = 10,message = "Body should have more than 10 character")
    private String body;
}
