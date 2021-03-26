package com.tencent.imsdk;

import android.text.TextUtils;
import com.tencent.imsdk.conversation.Msg;
import com.tencent.imsdk.conversation.ProgressInfo;
import com.tencent.imsdk.log.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TIMSoundElem extends TIMElem {
    private static final String TAG = "TIMSoundElem";
    private long businessId = 0;
    private long dataSize = 0;
    private int downloadFlag = 0;
    private long duration = 0;
    private String path = "";
    private int taskId;
    private List<String> urls = new ArrayList();
    private String uuid = null;

    public TIMSoundElem() {
        this.type = TIMElemType.Sound;
    }

    void addUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.urls.add(str);
        }
    }

    public void getUrl(final TIMValueCallBack<String> tIMValueCallBack) {
        if (tIMValueCallBack == null) {
            QLog.e("TIMSoundElem", "getUrl, callback is null");
        } else if (this.downloadFlag != 2) {
            Msg.requestDownloadUrl(3, (int) this.businessId, this.uuid, new TIMValueCallBack<List<String>>() {
                /* class com.tencent.imsdk.TIMSoundElem.AnonymousClass1 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    QLog.e("TIMSoundElem", "requestDownloadUrl failed, code: " + i + "|desc: " + str);
                    tIMValueCallBack.onError(i, str);
                }

                public void onSuccess(List<String> list) {
                    if (list.size() == 0) {
                        QLog.e("TIMSoundElem", "requestDownloadUrl success, but urls size is zero!");
                        tIMValueCallBack.onError(6017, "requestDownloadUrl rsp urls is empty");
                        return;
                    }
                    tIMValueCallBack.onSuccess(list.get(0));
                }
            });
        } else if (this.urls.size() > 0) {
            tIMValueCallBack.onSuccess(this.urls.get(0));
        } else {
            QLog.e("TIMSoundElem", "cos urls size is zero!");
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

    public void getSoundToFile(String str, TIMCallBack tIMCallBack) {
        getSoundToFile(str, null, tIMCallBack);
    }

    public void getSoundToFile(final String str, final TIMValueCallBack<ProgressInfo> tIMValueCallBack, final TIMCallBack tIMCallBack) {
        if (tIMCallBack == null) {
            QLog.e("TIMSoundElem", "getSoundToFile cb is null, ignore");
        } else if (this.downloadFlag == 2) {
            for (String str2 : this.urls) {
                Msg.downloadToFile(5, str2, str, tIMValueCallBack, tIMCallBack);
            }
        } else if (TextUtils.isEmpty(this.uuid)) {
            tIMCallBack.onError(6021, "uuid is empty");
        } else {
            Msg.requestDownloadUrl(3, (int) this.businessId, this.uuid, new TIMValueCallBack<List<String>>() {
                /* class com.tencent.imsdk.TIMSoundElem.AnonymousClass2 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    QLog.e("TIMSoundElem", "requestDownloadUrl failed, code: " + i + "|desc: " + str);
                    tIMCallBack.onError(i, str);
                }

                public void onSuccess(List<String> list) {
                    for (String str : list) {
                        Msg.downloadToFile(5, str, str, tIMValueCallBack, tIMCallBack);
                    }
                }
            });
        }
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.path = str;
            this.dataSize = new File(str).length();
        }
    }

    public String getUuid() {
        return this.uuid;
    }

    void setUuid(String str) {
        this.uuid = str;
    }

    public long getDataSize() {
        return this.dataSize;
    }

    void setDataSize(long j) {
        this.dataSize = j;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public int getTaskId() {
        return this.taskId;
    }

    void setTaskId(int i) {
        this.taskId = i;
    }
}
