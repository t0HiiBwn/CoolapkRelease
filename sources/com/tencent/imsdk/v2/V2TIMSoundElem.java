package com.tencent.imsdk.v2;

import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMSoundElem;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.conversation.ProgressInfo;
import com.tencent.imsdk.v2.V2TIMElem;

public class V2TIMSoundElem extends V2TIMElem {
    public String getPath() {
        if (getTIMElem() == null) {
            return null;
        }
        return ((TIMSoundElem) getTIMElem()).getPath();
    }

    public String getUUID() {
        if (getTIMElem() == null) {
            return null;
        }
        return ((TIMSoundElem) getTIMElem()).getUuid();
    }

    public int getDataSize() {
        if (getTIMElem() == null) {
            return 0;
        }
        return (int) ((TIMSoundElem) getTIMElem()).getDataSize();
    }

    public int getDuration() {
        if (getTIMElem() == null) {
            return 0;
        }
        return (int) ((TIMSoundElem) getTIMElem()).getDuration();
    }

    public void downloadSound(String str, final V2TIMDownloadCallback v2TIMDownloadCallback) {
        if (getTIMElem() != null) {
            TIMSoundElem tIMSoundElem = (TIMSoundElem) getTIMElem();
            AnonymousClass1 r1 = null;
            if (v2TIMDownloadCallback != null) {
                r1 = new TIMValueCallBack<ProgressInfo>() {
                    /* class com.tencent.imsdk.v2.V2TIMSoundElem.AnonymousClass1 */

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
            tIMSoundElem.getSoundToFile(str, r1, new TIMCallBack() {
                /* class com.tencent.imsdk.v2.V2TIMSoundElem.AnonymousClass2 */

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
            ((TIMSoundElem) getTIMElem()).getUrl(new TIMValueCallBack<String>() {
                /* class com.tencent.imsdk.v2.V2TIMSoundElem.AnonymousClass3 */

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
        return "V2TIMSoundElem--->uuid:" + getUUID() + ", sender local path:" + getPath() + ", duration:" + getDuration() + ", dataSize:" + getDataSize();
    }
}
