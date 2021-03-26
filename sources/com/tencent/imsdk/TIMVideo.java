package com.tencent.imsdk;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.imsdk.conversation.Msg;
import com.tencent.imsdk.conversation.ProgressInfo;
import com.tencent.imsdk.log.QLog;
import java.util.ArrayList;
import java.util.List;

public class TIMVideo {
    private static final String TAG = "TIMVideo";
    private static Handler mainHandler = new Handler(Looper.getMainLooper());
    private long businessId = 0;
    private int downloadFlag = 0;
    private long duaration;
    private String identifier = "";
    private long size;
    private String type = "";
    private List<String> urls = new ArrayList();
    private String uuid = "";

    protected void setIdentifier(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.identifier = str;
        }
    }

    void addUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.urls.add(str);
        }
    }

    public void getUrl(final TIMValueCallBack<String> tIMValueCallBack) {
        if (tIMValueCallBack == null) {
            QLog.e(TAG, "getUrl, callback is null");
        } else if (this.downloadFlag != 2) {
            Msg.requestDownloadUrl(2, (int) this.businessId, this.uuid, new TIMValueCallBack<List<String>>() {
                /* class com.tencent.imsdk.TIMVideo.AnonymousClass1 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    String str2 = TIMVideo.TAG;
                    QLog.e(str2, "requestDownloadUrl failed, code: " + i + "|desc: " + str);
                    tIMValueCallBack.onError(i, str);
                }

                public void onSuccess(List<String> list) {
                    if (list.size() == 0) {
                        QLog.e(TIMVideo.TAG, "requestDownloadUrl success, but urls size is zero!");
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

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        if (str != null) {
            this.type = str;
        }
    }

    public long getDuaration() {
        return this.duaration;
    }

    public void setDuaration(long j) {
        this.duaration = j;
    }

    public String getUuid() {
        return this.uuid;
    }

    void setUuid(String str) {
        if (str != null) {
            this.uuid = str;
        }
    }

    public long getSize() {
        return this.size;
    }

    void setSize(long j) {
        this.size = j;
    }

    public void getVideo(String str, TIMCallBack tIMCallBack) {
        getVideo(str, null, tIMCallBack);
    }

    public void getVideo(final String str, final TIMValueCallBack<ProgressInfo> tIMValueCallBack, final TIMCallBack tIMCallBack) {
        if (tIMCallBack == null) {
            QLog.e(TAG, "getVideo cb is null, ignore");
        } else if (this.downloadFlag == 2) {
            for (String str2 : this.urls) {
                Msg.downloadToFile(15, str2, str, tIMValueCallBack, tIMCallBack);
            }
        } else if (TextUtils.isEmpty(this.uuid)) {
            tIMCallBack.onError(6021, "uuid is empty");
        } else {
            Msg.requestDownloadUrl(2, (int) this.businessId, this.uuid, new TIMValueCallBack<List<String>>() {
                /* class com.tencent.imsdk.TIMVideo.AnonymousClass2 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    QLog.e("TIMVideo", "requestDownloadUrl failed, code: " + i + "|desc: " + str);
                    tIMCallBack.onError(i, str);
                }

                public void onSuccess(List<String> list) {
                    for (String str : list) {
                        Msg.downloadToFile(15, str, str, tIMValueCallBack, tIMCallBack);
                    }
                }
            });
        }
    }
}
