package com.tencent.imsdk.v2;

import com.tencent.imsdk.v2.V2TIMElem;

public interface V2TIMDownloadCallback extends V2TIMCallback {
    void onProgress(V2TIMElem.V2ProgressInfo v2ProgressInfo);
}
