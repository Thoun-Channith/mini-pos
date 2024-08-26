package com.channiththuon.Mini.Project.models.response;

import lombok.Data;

@Data
public class CustomerResponse {
    private Long id;
    private String customerLocalName;
    private String customerEngName;
    private String customerEmail;
    private String customerPhone;
    private String customerAddress;
}
