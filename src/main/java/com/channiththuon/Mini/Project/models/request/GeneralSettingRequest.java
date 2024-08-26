package com.channiththuon.Mini.Project.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GeneralSettingRequest {

    @NotBlank(message = "Site title is mandatory")
    private String siteTitle;

    private String siteLogo;
    private String sitePhone;
    private String siteAddress;
}
