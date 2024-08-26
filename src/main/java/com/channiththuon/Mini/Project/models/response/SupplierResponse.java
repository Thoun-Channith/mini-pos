package com.channiththuon.Mini.Project.models.response;

import lombok.Data;

@Data
public class SupplierResponse {

    private Long id;
    private String supplierLocalName;
    private String supplierEngName;
    private String supplierEmail;
    private String supplierPhone;
    private String supplierAddress;
    private String vatNumber;
}
