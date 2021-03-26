package com.tencent.imsdk;

import android.text.TextUtils;
import com.tencent.imsdk.conversation.Msg;
import com.tencent.imsdk.conversation.ProgressInfo;
import com.tencent.imsdk.log.QLog;
import java.util.ArrayList;
import java.util.List;

public class TIMSnapshot {
    private static final String TAG = "TIMSnapshot";
    private long businessId = 0;
    private int downloadFlag = 0;
    private long height;
    private long size;
    private String type = "";
    private List<String> urls = new ArrayList();
    private String uuid = "";
    private long width;

    void addUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.urls.add(str);
        }
    }

    public void getUrl(final TIMValueCallBack<String> tIMValueCallBack) {
        if (tIMValueCallBack == null) {
            QLog.e(TAG, "getUrl, callback is null");
        } else if (this.downloadFlag != 2) {
            Msg.requestDownloadUrl(1, (int) this.businessId, this.uuid, new TIMValueCallBack<List<String>>() {
                /* class com.tencent.imsdk.TIMSnapshot.AnonymousClass1 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    String str2 = TIMSnapshot.TAG;
                    QLog.e(str2, "requestDownloadUrl failed, code: " + i + "|desc: " + str);
                    tIMValueCallBack.onError(i, str);
                }

                public void onSuccess(List<String> list) {
                    if (list.size() == 0) {
                        QLog.e(TIMSnapshot.TAG, "requestDownloadUrl success, but urls size is zero!");
                        tIMValueCallBack.onError(6017, "requestDownloadUrl rsp urls is empty");
                        return;
                    }
                    tIMValueCallBack.onSuccess(list.get(0));
                }
            });
        } else if (this.urls.size() > 0) {
            tIMValueCallBack.onSuccess(this.urls.get(0));
        } else {
            QLog.e(TAG, "cos urls size is zero!");
            tIMValueCallBack.onError(6017, "cos url is null");
        }
    }

    long getBusinessId() {
        return this.businessId;
    }

    void setBusinessId(long j) {
        this.businessId = j;
    }

    int getDownloadFlag() {
        return this.downloadFlag;
    }

    void setDownloadFlag(int i) {
        this.downloadFlag = i;
    }

    public String getUuid() {
        return this.uuid;
    }

    void setUuid(String str) {
        this.uuid = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
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

    public void setHeight(long j) {
        this.height = j;
    }

    public long getWidth() {
        return this.width;
    }

    public void setWidth(long j) {
        this.width = j;
    }

    public void getImage(String str, TIMCallBack tIMCallBack) {
        getImage(str, null, tIMCallBack);
    }

    public void getImage(final String str, final TIMValueCallBack<ProgressInfo> tIMValueCallBack, final TIMCallBack tIMCallBack) {
        if (tIMCallBack == null) {
            QLog.e(TAG, "getImage cb is null, ignore");
        } else if (this.downloadFlag == 2) {
            for (String str2 : this.urls) {
                Msg.downloadToFile(4, str2, str, tIMValueCallBack, tIMCallBack);
            }
        } else if (TextUtils.isEmpty(this.uuid)) {
            tIMCallBack.onError(6021, "uuid is empty");
        } else {
            Msg.requestDownloadUrl(0, (int) this.businessId, this.uuid, new TIMValueCallBack<List<String>>() {
                /* class com.tencent.imsdk.TIMSnapshot.AnonymousClass2 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    QLog.e("TIMSnapthot", "requestDownloadUrl failed, code: " + i + "|desc: " + str);
                    tIMCallBack.onError(i, str);
                }

                public void onSuccess(List<String> list) {
                    for (String str : list) {
                        Msg.downloadToFile(4, str, str, tIMValueCallBack, tIMCallBack);
                    }
                }
            });
        }
    }
}
