package com.alibaba.baichuan.trade.biz.core.config.model;

import java.io.Serializable;
import java.util.List;

public class RouteConfigDO implements Serializable {
    private static final long serialVersionUID = 2104552409271203724L;
    private List<ActionDO> action;
    private int[] index;
    private String match;

    public List<ActionDO> getAction() {
        return this.action;
    }

    public int[] getIndex() {
        return this.index;
    }

    public String getMatch() {
        return this.match;
    }

    public void setAction(List<ActionDO> list) {
        this.action = list;
    }

    public void setIndex(int[] iArr) {
        this.index = iArr;
    }

    public void setMatch(String str) {
        this.match = str;
    }
}
