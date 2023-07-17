package com.aashna.BlogApplication.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto implements Serializable {
    private static final long serialVersionUID = 4439114469417994331L;

    private Integer categoryId;

    @NotNull
    @Size(min = 4, message = "Min size of category title is 4")
    private String categoryTitle;

    @NotNull
    @Size(min = 10, message = "Min size of category Description is 10")
    private String categoryDescription;

}