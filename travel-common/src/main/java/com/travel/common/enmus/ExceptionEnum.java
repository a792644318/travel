package com.travel.common.enmus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ExceptionEnum {

    QUERY_CATEGORY_ERROR(500,"查询分类异常"),
    QUERY_ROUTE_ERROR(500,"查询线路异常")
    ;
    private int code;
    private String msg;

}
