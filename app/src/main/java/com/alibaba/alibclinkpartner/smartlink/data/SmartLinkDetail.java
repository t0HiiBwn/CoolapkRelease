package com.alibaba.alibclinkpartner.smartlink.data;

import java.io.Serializable;
import java.util.List;

public class SmartLinkDetail implements Serializable {
    public List<String> excludes;
    public List<String> patterns;
    public List<String> targets;
}
