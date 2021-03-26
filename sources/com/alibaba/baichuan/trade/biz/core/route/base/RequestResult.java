package com.alibaba.baichuan.trade.biz.core.route.base;

public interface RequestResult {
    public static final int BIZ_CODE_NOT_FOUND = 1200;
    public static final int CODE_DATA_OR_URL_NULL = 1100;
    public static final int CODE_ERROR = 500;
    public static final int CODE_NOT_FOUND = 400;
    public static final int CODE_SUCCESS = 200;
    public static final int CODE_URL_FORBID_ERROR = 1000;
    public static final int CODE_URL_TYPE_NOT_FOUND = 1300;
    public static final int LAST_PARSE_NODE = 2000;
    public static final int URL_INTERCEPTOR_SUCCESS = 1700;
    public static final int URL_IS_NULL = 1600;
    public static final int URL_NOT_MATCHED = 1500;
    public static final int URL_ROUTE_INTERCEPT_NOT_FOUND = 1400;
}
