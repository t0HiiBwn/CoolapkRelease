package com.tencent.imsdk.v2;

import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMImage;
import com.tencent.imsdk.TIMImageElem;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.conversation.ProgressInfo;
import com.tencent.imsdk.v2.V2TIMElem;
import java.util.ArrayList;
import java.util.List;

public class V2TIMImageElem extends V2TIMElem {
    public static final int V2TIM_IMAGE_TYPE_LARGE = 2;
    public static final int V2TIM_IMAGE_TYPE_ORIGIN = 0;
    public static final int V2TIM_IMAGE_TYPE_THUMB = 1;
    private TIMImageElem timImageElem;

    public String getPath() {
        if (getTIMElem() == null) {
            return null;
        }
        TIMImageElem tIMImageElem = (TIMImageElem) getTIMElem();
        this.timImageElem = tIMImageElem;
        return tIMImageElem.getPath();
    }

    public List<V2TIMImage> getImageList() {
        if (getTIMElem() == null) {
            return null;
        }
        this.timImageElem = (TIMImageElem) getTIMElem();
        ArrayList arrayList = new ArrayList();
        for (TIMImage tIMImage : this.timImageElem.getImageList()) {
            V2TIMImage v2TIMImage = new V2TIMImage();
            v2TIMImage.setTIMImage(tIMImage);
            arrayList.add(v2TIMImage);
        }
        return arrayList;
    }

    public class V2TIMImage {
        private TIMImage timImage;

        public V2TIMImage() {
        }

        void setTIMImage(TIMImage tIMImage) {
            this.timImage = tIMImage;
        }

        public String getUUID() {
            TIMImage tIMImage = this.timImage;
            if (tIMImage != null) {
                return tIMImage.getUuid();
            }
            return null;
        }

        public int getType() {
            TIMImage tIMImage = this.timImage;
            if (tIMImage != null) {
                return tIMImage.getType().value();
            }
            return 0;
        }

        public int getSize() {
            TIMImage tIMImage = this.timImage;
            if (tIMImage != null) {
                return (int) tIMImage.getSize();
            }
            return 0;
        }

        public int getWidth() {
            TIMImage tIMImage = this.timImage;
            if (tIMImage != null) {
                return (int) tIMImage.getWidth();
            }
            return 0;
        }

        public int getHeight() {
            TIMImage tIMImage = this.timImage;
            if (tIMImage != null) {
                return (int) tIMImage.getHeight();
            }
            return 0;
        }

        public String getUrl() {
            TIMImage tIMImage = this.timImage;
            if (tIMImage == null) {
                return null;
            }
            return tIMImage.getUrl();
        }

        public void downloadImage(String str, final V2TIMDownloadCallback v2TIMDownloadCallback) {
            if (this.timImage != null) {
                AnonymousClass1 r0 = null;
                if (v2TIMDownloadCallback != null) {
                    r0 = new TIMValueCallBack<ProgressInfo>() {
                        /* class com.tencent.imsdk.v2.V2TIMImageElem.V2TIMImage.AnonymousClass1 */

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
                this.timImage.getImage(str, r0, new TIMCallBack() {
                    /* class com.tencent.imsdk.v2.V2TIMImageElem.V2TIMImage.AnonymousClass2 */

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
                v2TIMDownloadCallback.onError(6017, "timImage is null");
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("V2TIMImageElem--->");
        sb.append(", localPath=");
        sb.append(getPath());
        for (V2TIMImage v2TIMImage : getImageList()) {
            sb.append(", type:");
            sb.append(v2TIMImage.getType());
            sb.append(", uuid:");
            sb.append(v2TIMImage.getUUID());
            sb.append(", height:");
            sb.append(v2TIMImage.getHeight());
            sb.append(", width:");
            sb.append(v2TIMImage.getWidth());
            sb.append(", size:");
            sb.append(v2TIMImage.getSize());
        }
        return sb.toString();
    }
}
