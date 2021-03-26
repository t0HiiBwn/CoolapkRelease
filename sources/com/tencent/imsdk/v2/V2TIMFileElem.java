package com.tencent.imsdk.v2;

import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMFileElem;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.conversation.ProgressInfo;
import com.tencent.imsdk.v2.V2TIMElem;

public class V2TIMFileElem extends V2TIMElem {
    private TIMFileElem timFileElem;

    public String getPath() {
        if (getTIMElem() == null) {
            return null;
        }
        TIMFileElem tIMFileElem = (TIMFileElem) getTIMElem();
        this.timFileElem = tIMFileElem;
        return tIMFileElem.getPath();
    }

    public String getFileName() {
        if (getTIMElem() == null) {
            return null;
        }
        TIMFileElem tIMFileElem = (TIMFileElem) getTIMElem();
        this.timFileElem = tIMFileElem;
        return tIMFileElem.getFileName();
    }

    public String getUUID() {
        if (getTIMElem() == null) {
            return null;
        }
        TIMFileElem tIMFileElem = (TIMFileElem) getTIMElem();
        this.timFileElem = tIMFileElem;
        return tIMFileElem.getUuid();
    }

    public int getFileSize() {
        if (getTIMElem() == null) {
            return 0;
        }
        TIMFileElem tIMFileElem = (TIMFileElem) getTIMElem();
        this.timFileElem = tIMFileElem;
        return (int) tIMFileElem.getFileSize();
    }

    public void downloadFile(String str, final V2TIMDownloadCallback v2TIMDownloadCallback) {
        if (getTIMElem() != null) {
            this.timFileElem = (TIMFileElem) getTIMElem();
            AnonymousClass1 r0 = null;
            if (v2TIMDownloadCallback != null) {
                r0 = new TIMValueCallBack<ProgressInfo>() {
                    /* class com.tencent.imsdk.v2.V2TIMFileElem.AnonymousClass1 */

                    @Override // com.tencent.imsdk.TIMValueCallBack
                    public void onError(int i, String str) {
                        V2TIMDownloadCallback v2TIMDownloadCallback = v2TIMDownloadCallback;
                        if (v2TIMDownloadCallback != null) {
                            v2TIMDownloadCallback.onError(i, str);
                        }
                    }

                    public void onSuccess(ProgressInfo progressInfo) {
                        V2TIMElem.V2ProgressInfo v2ProgressInfo = new V2TIMElem.V2ProgressInfo(progressInfo.getCurrentSize(), progressInfo.getTotalSize());
                        V2TIMDownloadCallback v2TIMDownloadCallback = v2TIMDownloadCallback;
                        if (v2TIMDownloadCallback != null) {
                            v2TIMDownloadCallback.onProgress(v2ProgressInfo);
                        }
                    }
                };
            }
            this.timFileElem.getToFile(str, r0, new TIMCallBack() {
                /* class com.tencent.imsdk.v2.V2TIMFileElem.AnonymousClass2 */

                @Override // com.tencent.imsdk.TIMCallBack
                public void onError(int i, String str) {
                    V2TIMDownloadCallback v2TIMDownloadCallback = v2TIMDownloadCallback;
                    if (v2TIMDownloadCallback != null) {
                        v2TIMDownloadCallback.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.TIMCallBack
                public void onSuccess() {
                    V2TIMDownloadCallback v2TIMDownloadCallback = v2TIMDownloadCallback;
                    if (v2TIMDownloadCallback != null) {
                        v2TIMDownloadCallback.onSuccess();
                    }
                }
            });
        } else if (v2TIMDownloadCallback != null) {
            v2TIMDownloadCallback.onError(6017, "getTIMElem is null");
        }
    }

    public void getUrl(final V2TIMValueCallback<String> v2TIMValueCallback) {
        if (getTIMElem() != null) {
            ((TIMFileElem) getTIMElem()).getUrl(new TIMValueCallBack<String>() {
                /* class com.tencent.imsdk.v2.V2TIMFileElem.AnonymousClass3 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i, str);
                    }
                }

                public void onSuccess(String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onSuccess(str);
                    }
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(6017, "elem is null");
        }
    }

    public String toString() {
        return "V2TIMFileElem--->uuid:" + getUUID() + ", sender local path:" + getPath() + ", file name:" + getFileName() + ", file size:" + getFileSize();
    }
}
