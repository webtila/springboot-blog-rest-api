package com.springboot.blog.springbootblogrestapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name="posts",uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
public class Post {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(name="title",nullable = false)
    private String title;
    @Column(name="description",nullable = false)
    private String description;
    @Column(name="content",nullable = false)
    private String content;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL,orphanRemoval = true )
    private Set<Comment> comments = new HashSet<>();


    //Category won't load immediately on loading post cause of Fetch Type Lazy,
    //Category can be called by getCategory from Post Entity Object
    @ManyToOne (fetch = FetchType.LAZY)
    //foreign key
    @JoinColumn(name="category_id")
    private Category category;

}
