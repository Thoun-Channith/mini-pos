package com.channiththuon.Mini.Project.models.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CompanyRequest {

    @NotBlank(message = "Company cannot be empty")
    private String companyName;

    private String companyLocalName;

    private String companyEngName;

    @Email(message = "Invalid email address")
    private String companyEmail;

    private String companyPhone;

    private String companyAddress;

    private String vatNumber;

    private String imagePath;

    private String image;
}
