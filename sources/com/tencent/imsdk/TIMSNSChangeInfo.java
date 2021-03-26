package com.tencent.imsdk;

import java.util.HashMap;
import java.util.Map;

public class TIMSNSChangeInfo {
    private Map<String, Object> itemMap = new HashMap();
    private String updateUser = "";

    public String getUpdateUser() {
        return this.updateUser;
    }

    public Map<String, Object> getItemMap() {
        return this.itemMap;
    }
}
