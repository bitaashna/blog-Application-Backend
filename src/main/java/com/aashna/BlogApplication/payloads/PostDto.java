package com.aashna.BlogApplication.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class PostDto implements Serializable {

    private static final long serialVersionUID = 4439114469417994313L;

    private Integer postId;

    private String title;

    private String content;

    private Date addedDate;

    private UserDto user;

    private Set<CommentDto> comments = new HashSet<>();

    private CategoryDto category;
}
