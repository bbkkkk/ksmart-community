package com.ksmart.common.dto;

import cn.hutool.core.util.PageUtil;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class PageData<T> {
    private int pageSize;
    private int currentPage;
    private long totalCount;
    private int totalPage;
    private boolean lastPage;
    private boolean firstPage;
    private List<T> pageContent;

    public static <T> PageData getInstance(int currentPage, int pageSize, long totalCount, List<T> pageContent) {
        int totalPage = PageUtil.totalPage((int) totalCount, pageSize);
        boolean firstPage = false;
        boolean lastPage = false;
        if (currentPage <= 1) {
            firstPage = true;
            lastPage = false;
        } else if (currentPage == totalPage) {
            firstPage = false;
            lastPage = true;
        }

        return new <T>PageData().setCurrentPage(currentPage).setPageSize(pageSize).setTotalPage(totalPage).setTotalCount(totalCount).setFirstPage(firstPage).setLastPage(lastPage).setPageContent(pageContent);
    }

}
