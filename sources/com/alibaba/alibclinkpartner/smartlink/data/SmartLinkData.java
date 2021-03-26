package com.alibaba.alibclinkpartner.smartlink.data;

import java.io.Serializable;
import java.util.List;

public class SmartLinkData implements Serializable {
    public String appConfigVersion;
    public List<SmartLinkDetail> data;
    public String sign;
    public String validtime;
    public String version;
}
