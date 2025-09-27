package com.eazybytes.SimpleWebApp.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Profile{
    @NotBlank(message = "Name must not be blank")
    @Size(min = 3, message = "Name must be atleast 3 characters long")
    private String name;

    @NotBlank(message = "Mobile number must not be blank")
    @Pattern(regexp = "(^$|[0-9]{11})", message = "Mobile number must be atleast 11 digits")
    private String mobileNumber;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotBlank(message = "Address must not be blank")
    @Size(min = 5, message = "Address must be 5 characters long")
    private String address1;

    private String address2;

    @NotBlank(message = "City must not be blank")
    @Size(min = 5, message = "City must be 5 characters long")
    private String city;

    @NotBlank(message = "State must not be blank")
    @Size(min = 5, message = "State must be 5 characters long")
    private String state;

    @NotBlank(message = "Zip code must not be blank")
    @Pattern(regexp="(^$|[0-9]{5})",message = "Zip Code must be 5 digits")
    private String zipCode;
}
