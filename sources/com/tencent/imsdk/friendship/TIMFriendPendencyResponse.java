package com.tencent.imsdk.friendship;

import java.util.ArrayList;
import java.util.List;

public class TIMFriendPendencyResponse {
    private List<TIMFriendPendencyItem> items = new ArrayList();
    private long seq;
    private long timestamp;
    private long unreadCnt;

    public long getSeq() {
        return this.seq;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public long getUnreadCnt() {
        return this.unreadCnt;
    }

    public List<TIMFriendPendencyItem> getItems() {
        return this.items;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        for (TIMFriendPendencyItem tIMFriendPendencyItem : this.items) {
            stringBuffer2.append(tIMFriendPendencyItem.toString());
        }
        stringBuffer.append("TIMFriendPendencyResponse{\n");
        stringBuffer.append("\t\tseq='");
        stringBuffer.append(this.seq);
        stringBuffer.append("',\n");
        stringBuffer.append("\t\ttimestamp='");
        stringBuffer.append(this.timestamp);
        stringBuffer.append("',\n");
        stringBuffer.append("\t\tunreadCnt='");
        stringBuffer.append(this.unreadCnt);
        stringBuffer.append("',\n");
        stringBuffer.append("\t\titems='");
        stringBuffer.append(stringBuffer2.toString());
        stringBuffer.append("'\n");
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
