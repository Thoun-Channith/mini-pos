package com.channiththuon.Mini.Project.models.dto;

import org.springframework.data.domain.Page;

import java.util.List;

public class PageDTO {
    private List<?> listData;
    private PaginationDTO paginationDTO;

    public PageDTO(Page<?> page){
        this.listData = page.getContent();
        this.paginationDTO = PaginationDTO.builder()
                .empty(page.isEmpty())
                .first(page.isFirst())
                .last(page.isLast())
                .pageSize(page.getPageable().getPageSize())
                .pageNumber(page.getPageable().getPageNumber() + 1)
                .totalPage(page.getTotalPages())
                .totalElement(page.getTotalElements())
                .numberOfElement(page.getNumberOfElements())
                .build();
    }
}
