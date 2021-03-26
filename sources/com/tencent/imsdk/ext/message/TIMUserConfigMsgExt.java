package com.tencent.imsdk.ext.message;

import com.tencent.imsdk.TIMUserConfig;
import com.tencent.imsdk.conversation.ConversationManager;

@Deprecated
public class TIMUserConfigMsgExt extends TIMUserConfig {
    public TIMUserConfigMsgExt(TIMUserConfig tIMUserConfig) {
        super(tIMUserConfig);
    }

    @Override // com.tencent.imsdk.TIMUserConfig
    @Deprecated
    public boolean isAutoReportEnabled() {
        return this.isAutoReportEnabled;
    }

    @Deprecated
    public TIMUserConfigMsgExt enableAutoReport(boolean z) {
        this.isAutoReportEnabled = z;
        return this;
    }

    @Override // com.tencent.imsdk.TIMUserConfig
    @Deprecated
    public boolean isReadReceiptEnabled() {
        return this.isReadReceiptEnabled;
    }

    @Override // com.tencent.imsdk.TIMUserConfig
    @Deprecated
    public TIMUserConfigMsgExt enableReadReceipt(boolean z) {
        this.isReadReceiptEnabled = z;
        return this;
    }

    @Override // com.tencent.imsdk.TIMUserConfig
    @Deprecated
    public TIMMessageReceiptListener getMessageReceiptListener() {
        return ConversationManager.getInstance().getReceiptListener();
    }

    @Override // com.tencent.imsdk.TIMUserConfig
    @Deprecated
    public TIMUserConfigMsgExt setMessageReceiptListener(TIMMessageReceiptListener tIMMessageReceiptListener) {
        ConversationManager.getInstance().setMessageReceiptListener(tIMMessageReceiptListener);
        return this;
    }

    @Override // com.tencent.imsdk.TIMUserConfig
    @Deprecated
    public TIMUserConfigMsgExt setMessageRevokedListener(TIMMessageRevokedListener tIMMessageRevokedListener) {
        ConversationManager.getInstance().setMessageRevokedListener(tIMMessageRevokedListener);
        return this;
    }

    @Override // com.tencent.imsdk.TIMUserConfig
    @Deprecated
    public TIMMessageRevokedListener getMessageRevokedListener() {
        return ConversationManager.getInstance().getRevokedListener();
    }
}
