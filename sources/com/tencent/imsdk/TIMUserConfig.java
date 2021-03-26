package com.tencent.imsdk;

import com.tencent.imsdk.common.IMBaseListener;
import com.tencent.imsdk.conversation.ConversationManager;
import com.tencent.imsdk.ext.message.TIMMessageReceiptListener;
import com.tencent.imsdk.ext.message.TIMMessageRevokedListener;
import com.tencent.imsdk.friendship.TIMFriendshipListener;
import com.tencent.imsdk.log.QLog;

public class TIMUserConfig {
    private static final String TAG = "TIMUserConfig";
    private TIMConnListener connListener;
    protected boolean disableStorage = false;
    protected TIMFriendshipListener friendshipListener;
    protected IMBaseListener groupAssistantListener;
    private TIMGroupEventListener groupEventListener;
    private TIMGroupSettings groupSettings = new TIMGroupSettings();
    protected boolean isAutoReportEnabled = true;
    protected boolean isReadReceiptEnabled = false;
    private TIMFriendProfileOption mTIMFriendProfileOption;
    protected IMBaseListener msgRevokedListener;
    protected IMBaseListener receiptListener;
    private TIMRefreshListener refreshListener;
    private TIMUploadProgressListener uploadProgressListener;
    private TIMUser user = new TIMUser();
    private TIMUserStatusListener userStatusListener;

    protected TIMUser getUser() {
        return this.user;
    }

    protected void setUser(TIMUser tIMUser) {
        if (tIMUser != null) {
            this.user = tIMUser;
        }
    }

    public TIMUserConfig() {
    }

    public TIMUserConfig(TIMUserConfig tIMUserConfig) {
        if (tIMUserConfig != null) {
            this.groupSettings = tIMUserConfig.getGroupSettings();
            this.mTIMFriendProfileOption = tIMUserConfig.getTIMFriendProfileOption();
            this.userStatusListener = tIMUserConfig.getUserStatusListener();
            this.uploadProgressListener = tIMUserConfig.getUploadProgressListener();
            this.receiptListener = tIMUserConfig.receiptListener;
            this.msgRevokedListener = tIMUserConfig.msgRevokedListener;
            this.refreshListener = tIMUserConfig.getRefreshListener();
            this.groupEventListener = tIMUserConfig.getGroupEventListener();
            this.friendshipListener = tIMUserConfig.friendshipListener;
            this.groupAssistantListener = tIMUserConfig.groupAssistantListener;
            this.connListener = tIMUserConfig.getConnectionListener();
            this.isAutoReportEnabled = tIMUserConfig.isAutoReportEnabled;
            this.isReadReceiptEnabled = tIMUserConfig.isReadReceiptEnabled;
            this.user = tIMUserConfig.getUser();
            this.disableStorage = tIMUserConfig.disableStorage;
        }
    }

    public TIMUserConfig setConnectionListener(TIMConnListener tIMConnListener) {
        this.connListener = tIMConnListener;
        return this;
    }

    public TIMConnListener getConnectionListener() {
        return this.connListener;
    }

    public TIMRefreshListener getRefreshListener() {
        return this.refreshListener;
    }

    public TIMUserConfig setRefreshListener(TIMRefreshListener tIMRefreshListener) {
        this.refreshListener = tIMRefreshListener;
        ConversationManager.getInstance().setRefreshListener(tIMRefreshListener);
        return this;
    }

    public TIMGroupSettings getGroupSettings() {
        return this.groupSettings;
    }

    public void setGroupSettings(TIMGroupSettings tIMGroupSettings) {
        this.groupSettings = tIMGroupSettings;
    }

    public TIMGroupEventListener getGroupEventListener() {
        return this.groupEventListener;
    }

    public TIMUserConfig setGroupEventListener(TIMGroupEventListener tIMGroupEventListener) {
        this.groupEventListener = tIMGroupEventListener;
        return this;
    }

    public TIMUploadProgressListener getUploadProgressListener() {
        return ConversationManager.getInstance().getUploadProgressListener();
    }

    public TIMUserConfig setUploadProgressListener(TIMUploadProgressListener tIMUploadProgressListener) {
        ConversationManager.getInstance().setUploadProgressListener(tIMUploadProgressListener);
        return this;
    }

    public TIMUserStatusListener getUserStatusListener() {
        return this.userStatusListener;
    }

    public TIMUserConfig setUserStatusListener(TIMUserStatusListener tIMUserStatusListener) {
        this.userStatusListener = tIMUserStatusListener;
        return this;
    }

    public TIMFriendshipListener getFriendshipListener() {
        return this.friendshipListener;
    }

    public void setFriendshipListener(TIMFriendshipListener tIMFriendshipListener) {
        this.friendshipListener = tIMFriendshipListener;
    }

    public IMBaseListener getGroupAssistantListener() {
        return this.groupAssistantListener;
    }

    public void setGroupAssistantListener(IMBaseListener iMBaseListener) {
        this.groupAssistantListener = iMBaseListener;
    }

    public boolean isAutoReportEnabled() {
        return this.isAutoReportEnabled;
    }

    public boolean isReadReceiptEnabled() {
        return this.isReadReceiptEnabled;
    }

    public void setReadReceiptEnabled(boolean z) {
        this.isReadReceiptEnabled = z;
    }

    public TIMUserConfig disableAutoReport(boolean z) {
        String str = TAG;
        QLog.i(str, "disableAutoReport called, disableAutoReport = " + z);
        this.isAutoReportEnabled = z ^ true;
        return this;
    }

    public TIMUserConfig enableReadReceipt(boolean z) {
        this.isReadReceiptEnabled = z;
        return this;
    }

    public TIMFriendProfileOption getTIMFriendProfileOption() {
        return this.mTIMFriendProfileOption;
    }

    public void setTIMFriendProfileOption(TIMFriendProfileOption tIMFriendProfileOption) {
        this.mTIMFriendProfileOption = tIMFriendProfileOption;
    }

    public TIMUserConfig setMessageReceiptListener(TIMMessageReceiptListener tIMMessageReceiptListener) {
        ConversationManager.getInstance().setMessageReceiptListener(tIMMessageReceiptListener);
        return this;
    }

    public TIMMessageReceiptListener getMessageReceiptListener() {
        return ConversationManager.getInstance().getReceiptListener();
    }

    public TIMUserConfig setMessageRevokedListener(TIMMessageRevokedListener tIMMessageRevokedListener) {
        ConversationManager.getInstance().setMessageRevokedListener(tIMMessageRevokedListener);
        return this;
    }

    public TIMMessageRevokedListener getMessageRevokedListener() {
        return ConversationManager.getInstance().getRevokedListener();
    }

    public void disableStorage() {
        this.disableStorage = true;
    }
}
