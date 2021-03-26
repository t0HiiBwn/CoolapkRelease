package com.tencent.imsdk;

import java.util.HashMap;
import java.util.Map;

public class TIMProfileSystemElem extends TIMElem {
    private String fromUser = "";
    private Map<String, Object> itemMap = new HashMap();
    private int subType = 0;

    public TIMProfileSystemElem() {
        this.type = TIMElemType.ProfileTips;
    }

    public int getSubType() {
        return this.subType;
    }

    public String getFromUser() {
        return this.fromUser;
    }

    public Map<String, Object> getItemMap() {
        return this.itemMap;
    }
}
