package com.tencent.imsdk.conversation;

import com.tencent.imsdk.ext.message.TIMMessageLocator;
import com.tencent.imsdk.ext.message.TIMMessageReceipt;
import java.util.List;

public interface MessageListener {
    void onRecvMessage(List<Msg> list);

    void onRecvMessageReceipts(List<TIMMessageReceipt> list);

    void onRevokeMessage(List<TIMMessageLocator> list);

    void onUpdateMessage(List<Msg> list);

    void onUploadProgress(Msg msg, int i, long j, long j2);
}
