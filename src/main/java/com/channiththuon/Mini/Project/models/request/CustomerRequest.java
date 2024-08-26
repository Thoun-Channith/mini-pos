package com.channiththuon.Mini.Project.models.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerRequest {
    @NotBlank(message = "Local name is mandatory")
    private String customerLocalName;

    @NotBlank(message = "English name is mandatory")
    private String customerEngName;

    @Email(message = "Email should be valid")
    private String customerEmail;

    @NotBlank(message = "Phone is mandatory")
    private String customerPhone;

    private String customerAddress;
}
