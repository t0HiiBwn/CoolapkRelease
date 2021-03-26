package com.tencent.imsdk;

import java.util.ArrayList;
import java.util.List;

public class TIMConversationSucc {
    private boolean isFinished;
    private long nextTs;
    private List<TIMConversation> timConversationList = new ArrayList();

    public long getNextTs() {
        return this.nextTs;
    }

    public boolean isFinished() {
        return this.isFinished;
    }

    public List<TIMConversation> getConversationList() {
        return this.timConversationList;
    }

    private void setConversationList(List<TIMConversation> list) {
        this.timConversationList = list;
    }
}
