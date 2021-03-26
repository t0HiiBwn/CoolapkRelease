package com.tencent.imsdk.ext.group;

import java.util.ArrayList;
import java.util.List;

public class TIMGroupPendencyListGetSucc {
    private String identifer;
    private TIMGroupPendencyMeta meta;
    private List<TIMGroupPendencyItem> pendencies = new ArrayList();

    public String getIdentifer() {
        return this.identifer;
    }

    public void setIdentifer(String str) {
        this.identifer = str;
    }

    public TIMGroupPendencyMeta getMeta() {
        return this.meta;
    }

    public void setMeta(TIMGroupPendencyMeta tIMGroupPendencyMeta) {
        this.meta = tIMGroupPendencyMeta;
    }

    public void setPendencies(List<TIMGroupPendencyItem> list) {
        this.pendencies = list;
    }

    public TIMGroupPendencyMeta getPendencyMeta() {
        return this.meta;
    }

    public List<TIMGroupPendencyItem> getPendencies() {
        return this.pendencies;
    }
}
