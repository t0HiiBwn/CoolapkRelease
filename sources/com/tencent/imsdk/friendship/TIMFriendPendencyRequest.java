package com.tencent.imsdk.friendship;

public class TIMFriendPendencyRequest {
    private int numPerPage = 100;
    private long seq;
    private int timPendencyType;
    private long timestamp;

    public long getSeq() {
        return this.seq;
    }

    public void setSeq(long j) {
        this.seq = j;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public int getNumPerPage() {
        return this.numPerPage;
    }

    public void setNumPerPage(int i) {
        this.numPerPage = i;
    }

    public int getTimPendencyGetType() {
        return this.timPendencyType;
    }

    public void setTimPendencyGetType(int i) {
        this.timPendencyType = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TIMFriendPendencyRequest{\n");
        stringBuffer.append("\t\tseq='");
        stringBuffer.append(this.seq);
        stringBuffer.append("',\n");
        stringBuffer.append("\t\ttimestamp='");
        stringBuffer.append(this.timestamp);
        stringBuffer.append("',\n");
        stringBuffer.append("\t\tnumPerPage='");
        stringBuffer.append(this.numPerPage);
        stringBuffer.append("',\n");
        stringBuffer.append("\t\ttimPendencyGetType='");
        stringBuffer.append(this.timPendencyType);
        stringBuffer.append("'\n");
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
