package com.alibaba.alibclinkpartner.smartlink.data;

import java.io.Serializable;
import java.util.List;

public class SafeConfig implements Serializable {
    private long validtime;
    private List<String> whiteList;

    public long getValidtime() {
        return this.validtime;
    }

    public List<String> getWhiteList() {
        return this.whiteList;
    }

    public void setValidtime(long j) {
        this.validtime = j;
    }

    public void setWhiteList(List<String> list) {
        this.whiteList = list;
    }
}
