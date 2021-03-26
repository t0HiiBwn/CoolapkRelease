package com.qq.e.comm.compliance;

import android.app.Activity;

public interface DownloadConfirmListener {
    void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack);
}
