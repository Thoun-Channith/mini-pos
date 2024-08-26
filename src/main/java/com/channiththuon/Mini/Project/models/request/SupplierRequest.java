package com.channiththuon.Mini.Project.models.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SupplierRequest {

    @NotBlank(message = "Supplier Local Name is mandatory")
    @Size(min = 3, max = 100, message = "Supplier Local Name must be between 3 and 100 characters")
    private String supplierLocalName;

    private String supplierEngName;

    @Email(message = "Please provide a valid email address")
    private String supplierEmail;

    private String supplierPhone;

    private String supplierAddress;

    private String vatNumber;
}
