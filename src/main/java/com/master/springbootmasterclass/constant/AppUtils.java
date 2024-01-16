package com.master.springbootmasterclass.constant;

import com.master.springbootmasterclass.response.Request.PaginationArgs;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Map;


import static com.master.springbootmasterclass.constant.AppConstant.*;


public class AppUtils {

    public static Map<String, Object> getParameters(Map<String, Object> parameters) {
        parameters.remove(PAGE_NO);
        parameters.remove(PAGE_SIZE);
        parameters.remove(SORT_BY);
        parameters.remove(ASC_OR_DESC);
        parameters.remove(ASC_OR_DESC);
        parameters.remove(PARAMERTES);
        return parameters;
    }
    public static Pageable getPageable(PaginationArgs paginationArgs) {
        Pageable pageable;
        String sortBy = paginationArgs.getSortBy();
        int pageNo = paginationArgs.getPageNo();
        int pageSize = paginationArgs.getPageSize();

        if(sortBy != null && sortBy.length() > 0) {
            if (paginationArgs.getAscOrDesc().equals(AscOrDescType.ASC)) {
                pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
            } else {
                pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
            }
        } else {
            pageable = PageRequest.of(pageNo, pageSize);
        }

        return pageable;
    }
}
