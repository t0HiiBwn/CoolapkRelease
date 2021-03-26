package com.qq.e.comm.net.rr;

import java.net.HttpURLConnection;
import java.util.Map;

public interface Request {

    public enum Method {
        GET,
        POST
    }

    void addHeader(String str, String str2);

    void addQuery(String str, String str2);

    int getConnectionTimeOut();

    Map<String, String> getHeaders();

    Method getMethod();

    byte[] getPostData() throws Exception;

    int getPriority();

    Map<String, String> getQuerys();

    int getSocketTimeOut();

    String getUrl();

    String getUrlWithParas();

    Response initResponse(HttpURLConnection httpURLConnection);

    boolean isAutoClose();

    void setConnectionTimeOut(int i);

    void setSocketTimeOut(int i);
}
