package com.tencent.imsdk.v2;

import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMSnapshot;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.TIMVideoElem;
import com.tencent.imsdk.conversation.ProgressInfo;
import com.tencent.imsdk.v2.V2TIMElem;

public class V2TIMVideoElem extends V2TIMElem {
    public String getVideoPath() {
        if (getTIMElem() == null) {
            return null;
        }
        return ((TIMVideoElem) getTIMElem()).getVideoPath();
    }

    public String getVideoUUID() {
        if (getTIMElem() == null) {
            return null;
        }
        TIMVideoElem tIMVideoElem = (TIMVideoElem) getTIMElem();
        if (tIMVideoElem.getVideoInfo() != null) {
            return tIMVideoElem.getVideoInfo().getUuid();
        }
        return null;
    }

    public int getVideoSize() {
        if (getTIMElem() == null) {
            return 0;
        }
        TIMVideoElem tIMVideoElem = (TIMVideoElem) getTIMElem();
        if (tIMVideoElem.getVideoInfo() != null) {
            return (int) tIMVideoElem.getVideoInfo().getSize();
        }
        return 0;
    }

    public int getDuration() {
        if (getTIMElem() == null) {
            return 0;
        }
        TIMVideoElem tIMVideoElem = (TIMVideoElem) getTIMElem();
        if (tIMVideoElem.getVideoInfo() != null) {
            return (int) tIMVideoElem.getVideoInfo().getDuaration();
        }
        return 0;
    }

    public void downloadVideo(String str, final V2TIMDownloadCallback v2TIMDownloadCallback) {
        if (getTIMElem() != null) {
            TIMVideoElem tIMVideoElem = (TIMVideoElem) getTIMElem();
            AnonymousClass1 r2 = null;
            if (v2TIMDownloadCallback != null) {
                r2 = new TIMValueCallBack<ProgressInfo>() {
                    /* class com.tencent.imsdk.v2.V2TIMVideoElem.AnonymousClass1 */

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
            if (tIMVideoElem.getVideoInfo() != null) {
                tIMVideoElem.getVideoInfo().getVideo(str, r2, new TIMCallBack() {
                    /* class com.tencent.imsdk.v2.V2TIMVideoElem.AnonymousClass2 */

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
                v2TIMDownloadCallback.onError(6017, "timVideo is null");
            }
        } else if (v2TIMDownloadCallback != null) {
            v2TIMDownloadCallback.onError(6017, "getTIMElem is null");
        }
    }

    public void getVideoUrl(final V2TIMValueCallback<String> v2TIMValueCallback) {
        if (getTIMElem() != null) {
            TIMVideoElem tIMVideoElem = (TIMVideoElem) getTIMElem();
            if (tIMVideoElem.getVideoInfo() != null) {
                tIMVideoElem.getVideoInfo().getUrl(new TIMValueCallBack<String>() {
                    /* class com.tencent.imsdk.v2.V2TIMVideoElem.AnonymousClass3 */

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
                v2TIMValueCallback.onError(6017, "videoInfo is null");
            }
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(6017, "elem is null");
        }
    }

    public String getSnapshotPath() {
        if (getTIMElem() == null) {
            return null;
        }
        return ((TIMVideoElem) getTIMElem()).getSnapshotPath();
    }

    public String getSnapshotUUID() {
        if (getTIMElem() == null) {
            return null;
        }
        return ((TIMVideoElem) getTIMElem()).getSnapshotInfo().getUuid();
    }

    public int getSnapshotSize() {
        if (getTIMElem() == null) {
            return 0;
        }
        TIMVideoElem tIMVideoElem = (TIMVideoElem) getTIMElem();
        if (tIMVideoElem.getSnapshotInfo() != null) {
            return (int) tIMVideoElem.getSnapshotInfo().getSize();
        }
        return 0;
    }

    public int getSnapshotWidth() {
        if (getTIMElem() == null) {
            return 0;
        }
        TIMVideoElem tIMVideoElem = (TIMVideoElem) getTIMElem();
        if (tIMVideoElem.getSnapshotInfo() != null) {
            return (int) tIMVideoElem.getSnapshotInfo().getWidth();
        }
        return 0;
    }

    public int getSnapshotHeight() {
        if (getTIMElem() == null) {
            return 0;
        }
        TIMVideoElem tIMVideoElem = (TIMVideoElem) getTIMElem();
        if (tIMVideoElem.getSnapshotInfo() != null) {
            return (int) tIMVideoElem.getSnapshotInfo().getHeight();
        }
        return 0;
    }

    public void downloadSnapshot(String str, final V2TIMDownloadCallback v2TIMDownloadCallback) {
        if (getTIMElem() != null) {
            TIMVideoElem tIMVideoElem = (TIMVideoElem) getTIMElem();
            if (tIMVideoElem.getSnapshotInfo() != null) {
                TIMSnapshot snapshotInfo = tIMVideoElem.getSnapshotInfo();
                if (snapshotInfo != null) {
                    AnonymousClass4 r1 = null;
                    if (v2TIMDownloadCallback != null) {
                        r1 = new TIMValueCallBack<ProgressInfo>() {
                            /* class com.tencent.imsdk.v2.V2TIMVideoElem.AnonymousClass4 */

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
                    snapshotInfo.getImage(str, r1, new TIMCallBack() {
                        /* class com.tencent.imsdk.v2.V2TIMVideoElem.AnonymousClass5 */

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
                    v2TIMDownloadCallback.onError(6017, "timSnapshot is null");
                }
            }
        }
    }

    public void getSnapshotUrl(final V2TIMValueCallback<String> v2TIMValueCallback) {
        if (getTIMElem() != null) {
            TIMVideoElem tIMVideoElem = (TIMVideoElem) getTIMElem();
            if (tIMVideoElem.getSnapshotInfo() != null) {
                tIMVideoElem.getSnapshotInfo().getUrl(new TIMValueCallBack<String>() {
                    /* class com.tencent.imsdk.v2.V2TIMVideoElem.AnonymousClass6 */

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
                v2TIMValueCallback.onError(6017, "snapshotInfo is null");
            }
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(6017, "elem is null");
        }
    }

    public String toString() {
        return "V2TIMVideoElem--->video uuid:" + getVideoUUID() + ", snapshot uuid:" + getSnapshotUUID() + ", duration:" + getDuration() + ", sender local video path:" + getVideoPath() + ", video size:" + getVideoSize() + ", sender local snapshot path" + getSnapshotPath() + ", snapshot height:" + getSnapshotHeight() + ", snapshot width:" + getSnapshotWidth() + ", snapshot size:" + getSnapshotSize();
    }
}
