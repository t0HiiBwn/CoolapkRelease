package com.tencent.imsdk.v2;

import com.tencent.imsdk.TIMConversation;
import com.tencent.imsdk.TIMConversationSucc;
import java.util.ArrayList;
import java.util.List;

public class V2TIMConversationResult {
    private TIMConversationSucc timConversationSucc;
    private List<V2TIMConversation> v2TIMConversationList = new ArrayList();

    V2TIMConversationResult(TIMConversationSucc tIMConversationSucc) {
        this.timConversationSucc = tIMConversationSucc;
        for (TIMConversation tIMConversation : tIMConversationSucc.getConversationList()) {
            V2TIMConversation v2TIMConversation = new V2TIMConversation();
            v2TIMConversation.setTIMConversation(tIMConversation);
            this.v2TIMConversationList.add(v2TIMConversation);
        }
    }

    public long getNextSeq() {
        TIMConversationSucc tIMConversationSucc = this.timConversationSucc;
        if (tIMConversationSucc != null) {
            return tIMConversationSucc.getNextTs();
        }
        return 0;
    }

    public boolean isFinished() {
        TIMConversationSucc tIMConversationSucc = this.timConversationSucc;
        if (tIMConversationSucc != null) {
            return tIMConversationSucc.isFinished();
        }
        return false;
    }

    public List<V2TIMConversation> getConversationList() {
        return this.v2TIMConversationList;
    }
}
