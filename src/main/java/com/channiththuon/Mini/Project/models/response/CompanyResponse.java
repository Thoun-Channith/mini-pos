package com.channiththuon.Mini.Project.models.response;

import lombok.Data;

@Data
public class CompanyResponse {
    private Long id;
    private String companyName;
    private String companyLocalName;
    private String companyEngName;
    private String companyEmail;
    private String companyPhone;
    private String companyAddress;
    private String vatNumber;
    private String imagePath;
    private String image;
}
