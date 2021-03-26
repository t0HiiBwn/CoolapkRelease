package com.alibaba.baichuan.trade.common.adapter.mtop;

import java.io.Serializable;
import java.util.Map;

public class JSNetworkResponse implements Serializable {
    public byte[] byteData;
    public Map<String, Object> data;
    public String errorCode;
    public String errorMsg;
    public String httpCode;
    public boolean isSuccess;
    public String jsonData;
    public Object object;
    public String[] ret;

    public boolean isSuccess() {
        return this.isSuccess;
    }
}
