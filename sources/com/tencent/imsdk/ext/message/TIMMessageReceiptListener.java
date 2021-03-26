package com.tencent.imsdk.ext.message;

import com.tencent.imsdk.common.IMBaseListener;
import java.util.List;

public interface TIMMessageReceiptListener extends IMBaseListener {
    void onRecvReceipt(List<TIMMessageReceipt> list);
}
