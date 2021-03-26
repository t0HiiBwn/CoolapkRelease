package com.tencent.imsdk.ext.message;

public interface TIMSendMsgToMultiUserCallback {
    void onError(int i, String str, TIMBatchOprDetailInfo tIMBatchOprDetailInfo);

    void onSuccess();
}
