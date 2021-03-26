package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class UpSendMsgReq implements IMessageEntity {
    @Packed
    private String collapseKey;
    @Packed
    private String data;
    @Packed
    private String msgId;
    @Packed
    private String msgType;
    @Packed
    private String packageName;
    @Packed
    private int receiptMode;
    @Packed
    private int sendMode;
    @Packed
    private String to;
    @Packed
    private String token;
    @Packed
    private int ttl;

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public String getMessageId() {
        return this.msgId;
    }

    public void setMessageId(String str) {
        this.msgId = str;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo(String str) {
        this.to = str;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String getMessageType() {
        return this.msgType;
    }

    public void setMessageType(String str) {
        this.msgType = str;
    }

    public int getTtl() {
        return this.ttl;
    }

    public void setTtl(int i) {
        this.ttl = i;
    }

    public String getCollapseKey() {
        return this.collapseKey;
    }

    public void setCollapseKey(String str) {
        this.collapseKey = str;
    }

    public int getSendMode() {
        return this.sendMode;
    }

    public void setSendMode(int i) {
        this.sendMode = i;
    }

    public int getReceiptMode() {
        return this.receiptMode;
    }

    public void setReceiptMode(int i) {
        this.receiptMode = i;
    }
}
