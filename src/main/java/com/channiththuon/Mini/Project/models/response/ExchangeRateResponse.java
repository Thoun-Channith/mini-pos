package com.channiththuon.Mini.Project.models.response;

import lombok.Data;

@Data
public class ExchangeRateResponse {

    private Long id;
    private Double exchangeRate;
    private boolean isDeleted;
}
