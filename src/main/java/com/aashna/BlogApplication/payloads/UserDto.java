package com.aashna.BlogApplication.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class UserDto implements Serializable {
    private static final long serialVersionUID = 4439114469417994311L;

    private int id;

    @NotEmpty
    @Size(min = 4, message = "Username must be of 4 characters!!")
    private String name;

    @Email(message = "Email address is not valid !!")
    private String email;

    @NotEmpty
    @Size(min = 3, max = 10, message = "password must be min 3 chars and max 10 chars")
    private String password;

    @NotEmpty
    private String about;

}
