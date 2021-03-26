package com.tencent.imsdk;

import com.tencent.imsdk.conversation.Msg;
import com.tencent.imsdk.conversation.ProgressInfo;
import com.tencent.imsdk.log.QLog;

public class TIMImage {
    private static final String TAG = ("imsdk." + TIMImage.class.getSimpleName());
    private long height;
    private long size;
    private TIMImageType type;
    private String url;
    private String uuid;
    private long width;

    public void getImage(String str, TIMCallBack tIMCallBack) {
        if (tIMCallBack != null) {
            getImage(str, null, tIMCallBack);
        }
    }

    public void getImage(String str, TIMValueCallBack<ProgressInfo> tIMValueCallBack, TIMCallBack tIMCallBack) {
        if (tIMCallBack != null) {
            String str2 = TAG;
            QLog.d(str2, "getImage from url: " + this.url);
            Msg.downloadToFile(4, this.url, str, tIMValueCallBack, tIMCallBack);
        }
    }

    public TIMImageType getType() {
        return this.type;
    }

    void setType(int i) {
        TIMImageType[] values = TIMImageType.values();
        for (TIMImageType tIMImageType : values) {
            if (i == tIMImageType.value()) {
                this.type = tIMImageType;
                return;
            }
        }
        this.type = TIMImageType.Original;
    }

    void setType(TIMImageType tIMImageType) {
        this.type = tIMImageType;
    }

    int getTypeValue() {
        return this.type.value();
    }

    public String getUuid() {
        return this.type.value() + "_" + this.uuid;
    }

    void setUuid(String str) {
        this.uuid = str;
    }

    public long getSize() {
        return this.size;
    }

    void setSize(long j) {
        this.size = j;
    }

    public long getHeight() {
        return this.height;
    }

    void setHeight(long j) {
        this.height = j;
    }

    public long getWidth() {
        return this.width;
    }

    void setWidth(long j) {
        this.width = j;
    }

    public String getUrl() {
        return this.url;
    }

    void setUrl(String str) {
        this.url = str;
    }
}
