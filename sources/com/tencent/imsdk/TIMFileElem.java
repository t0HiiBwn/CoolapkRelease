package com.tencent.imsdk;

import android.text.TextUtils;
import com.tencent.imsdk.conversation.Msg;
import com.tencent.imsdk.conversation.ProgressInfo;
import com.tencent.imsdk.log.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TIMFileElem extends TIMElem {
    private static final String TAG = "TIMFileElem";
    private long businessId = 0;
    private int downloadFlag = 0;
    private String fileName;
    private long fileSize;
    private String path;
    private int taskId;
    private List<String> urls = new ArrayList();
    private String uuid = null;

    public TIMFileElem() {
        this.type = TIMElemType.File;
    }

    void addUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.urls.add(str);
        }
    }

    public void getUrl(final TIMValueCallBack<String> tIMValueCallBack) {
        if (tIMValueCallBack == null) {
            QLog.e("TIMFileElem", "getUrl, callback is null");
        } else if (this.downloadFlag != 2) {
            Msg.requestDownloadUrl(1, (int) this.businessId, this.uuid, new TIMValueCallBack<List<String>>() {
                /* class com.tencent.imsdk.TIMFileElem.AnonymousClass1 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    QLog.e("TIMFileElem", "requestDownloadUrl failed, code: " + i + "|desc: " + str);
                    tIMValueCallBack.onError(i, str);
                }

                public void onSuccess(List<String> list) {
                    if (list.size() == 0) {
                        QLog.e("TIMFileElem", "requestDownloadUrl success, but urls size is zero!");
                        tIMValueCallBack.onError(6017, "requestDownloadUrl rsp urls is empty");
                        return;
                    }
                    tIMValueCallBack.onSuccess(list.get(0));
                }
            });
        } else if (this.urls.size() > 0) {
            tIMValueCallBack.onSuccess(this.urls.get(0));
        } else {
            QLog.e("TIMFileElem", "cos urls size is zero!");
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

    public void getToFile(String str, TIMCallBack tIMCallBack) {
        getToFile(str, null, tIMCallBack);
    }

    public void getToFile(final String str, final TIMValueCallBack<ProgressInfo> tIMValueCallBack, final TIMCallBack tIMCallBack) {
        if (tIMCallBack == null) {
            QLog.e("TIMFileElem", "getToFile callback is null, ignore");
            return;
        }
        QLog.i("TIMFileElem", "download file, downloadFlag: " + this.downloadFlag);
        if (this.downloadFlag == 2) {
            for (String str2 : this.urls) {
                Msg.downloadToFile(7, str2, str, tIMValueCallBack, tIMCallBack);
            }
        } else if (TextUtils.isEmpty(this.uuid)) {
            tIMCallBack.onError(6021, "uuid is empty");
        } else {
            Msg.requestDownloadUrl(1, (int) this.businessId, this.uuid, new TIMValueCallBack<List<String>>() {
                /* class com.tencent.imsdk.TIMFileElem.AnonymousClass2 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    QLog.e("TIMFileElem", "requestDownloadUrl failed, code: " + i + "|desc: " + str);
                    tIMCallBack.onError(i, str);
                }

                public void onSuccess(List<String> list) {
                    for (String str : list) {
                        Msg.downloadToFile(7, str, str, tIMValueCallBack, tIMCallBack);
                    }
                }
            });
        }
    }

    public String getUuid() {
        return this.uuid;
    }

    void setUuid(String str) {
        this.uuid = str;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    void setFileSize(long j) {
        this.fileSize = j;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.path = str;
            this.fileSize = new File(str).length();
        }
    }

    public int getTaskId() {
        return this.taskId;
    }

    void setTaskId(int i) {
        this.taskId = i;
    }
}
