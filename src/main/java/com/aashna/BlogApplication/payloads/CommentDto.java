package com.aashna.BlogApplication.payloads;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CommentDto implements Serializable {

    private static final long serialVersionUID = 4439114469417994312L;

    private Integer id;

    private String content;

}
