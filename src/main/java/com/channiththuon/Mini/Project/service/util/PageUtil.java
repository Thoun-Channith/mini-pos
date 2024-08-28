package com.channiththuon.Mini.Project.service.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PageUtil {
    public static final int DEFAULT_PAGE_LIMIT = 2;
    public static final int DEFAULT_PAGE_NUMBER = 1;
    public static final String PAGE_LIMIT = "_limit";
    public static final String PAGE_NUMBER = "_page";

    public static Pageable getPageable(int pageNumber, int pageSize) {
        if (pageNumber < DEFAULT_PAGE_NUMBER) {
            pageNumber = DEFAULT_PAGE_NUMBER;
        }
        if (pageSize < 1) {
            pageSize = DEFAULT_PAGE_LIMIT;
        }
        return PageRequest.of(pageNumber - 1, pageSize);
    }
}


