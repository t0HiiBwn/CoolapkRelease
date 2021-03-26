package com.alibaba.alibclinkpartner.smartlink.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MAtrixAppData implements Serializable {
    public Map<String, MatrixAppInfoDetail> appinfo = new HashMap();
    public String sign;
    public String validtime;
    public String version;
}
