package com.eazybytes.SimpleWebApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.apache.logging.log4j.message.Message;
@Data
@Entity
@Table(name = "address")
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressId;

    @NotBlank(message = "Address line 1 cannot be blank")
    @Size(min=5, message = "Address line 1 must be at least 5 characters long")
    private String address1;

    private String address2;

    @NotBlank(message = "City must not be blank")
    @Size(min = 2, message = "City must be at least 2 characters long")
    private String city;

    @NotBlank(message = "State must not be blank")
    @Size(min = 2, message = "State must be at least 2 characters long")
    private String state;

    @NotBlank(message = "ZipCode must not be blank")
    @Pattern(regexp="^[0-9]{5}$", message = "ZipCode must be exactly 5 digits")
    private String zipCode;
}
