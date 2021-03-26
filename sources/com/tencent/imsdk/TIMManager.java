package com.tencent.imsdk;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.imsdk.conversation.ConversationManager;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.manager.BaseManager;
import java.util.List;

public class TIMManager {
    private static final String TAG = "TIMManager";
    public static final int TIM_STATUS_LOGINED = 1;
    public static final int TIM_STATUS_LOGINING = 2;
    public static final int TIM_STATUS_LOGOUT = 3;
    private static BaseManager mBase;
    private static TIMManager mInstance = new TIMManager();
    private ConversationManager mConversationManager = ConversationManager.getInstance();

    private TIMManager() {
        mBase = BaseManager.getInstance();
    }

    public static TIMManager getInstance() {
        return mInstance;
    }

    public boolean init(Context context, TIMSdkConfig tIMSdkConfig) {
        return mBase.init(context, tIMSdkConfig);
    }

    public boolean unInit() {
        return mBase.unInit();
    }

    public TIMSdkConfig getSdkConfig() {
        return mBase.getmSdkConfig();
    }

    public void setUserConfig(TIMUserConfig tIMUserConfig) {
        QLog.i("TIMManager", "setUserConfig: userConfig=" + tIMUserConfig);
        mBase.setUserConfig(tIMUserConfig);
    }

    public TIMUserConfig getUserConfig() {
        return mBase.getUserConfig();
    }

    public void addMessageListener(TIMMessageListener tIMMessageListener) {
        this.mConversationManager.addMessageListener(tIMMessageListener);
    }

    public void removeMessageListener(TIMMessageListener tIMMessageListener) {
        this.mConversationManager.removeMessageListener(tIMMessageListener);
    }

    public boolean isInited() {
        return mBase.isInited();
    }

    public void login(String str, String str2, TIMCallBack tIMCallBack) {
        QLog.v("TIMManager", "login : userID = " + str);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            QLog.e("TIMManager", "userSig is empty");
            tIMCallBack.onError(6017, "userID or userSig is empty");
            return;
        }
        mBase.login(str, str2, false, tIMCallBack);
    }

    public void autoLogin(String str, TIMCallBack tIMCallBack) {
        QLog.i("TIMManager", "autoLogin : userID = " + str);
        if (TextUtils.isEmpty(str)) {
            QLog.e("TIMManager", "userID is empty");
            tIMCallBack.onError(6017, "userID is empty");
            return;
        }
        mBase.login(str, "", false, tIMCallBack);
    }

    public void logout(TIMCallBack tIMCallBack) {
        QLog.i("TIMManager", "logout: userID=" + getLoginUser());
        mBase.logout(tIMCallBack);
    }

    public int getLoginStatus() {
        return mBase.getLoginStatus();
    }

    public String getLoginUser() {
        return mBase.getLoginUser();
    }

    public List<TIMConversation> getConversationList() {
        return this.mConversationManager.getConversationList();
    }

    public TIMConversation getConversation(TIMConversationType tIMConversationType, String str) {
        QLog.i("TIMManager", "getConversation: type = " + tIMConversationType.ordinal() + ", conversationId = " + str);
        return this.mConversationManager.getConversation(tIMConversationType, str);
    }

    public boolean deleteConversation(TIMConversationType tIMConversationType, String str) {
        this.mConversationManager.deleteConversation(tIMConversationType, str);
        return true;
    }

    public boolean deleteConversationAndLocalMsgs(TIMConversationType tIMConversationType, String str) {
        QLog.i("TIMManager", "deleteConversationAndLocalMsgs: type = " + tIMConversationType.ordinal() + ", conversationId = " + str);
        this.mConversationManager.deleteConversationAndLocalMsgs(tIMConversationType, str);
        return true;
    }

    public void setOfflinePushToken(TIMOfflinePushToken tIMOfflinePushToken, TIMCallBack tIMCallBack) {
        mBase.setToken(tIMOfflinePushToken, tIMCallBack);
    }

    public void setOfflinePushSettings(TIMOfflinePushSettings tIMOfflinePushSettings) {
        QLog.i("TIMManager", "setOfflinePushSettings: settings enable = " + tIMOfflinePushSettings.isEnabled() + ", c2c remind sound = " + tIMOfflinePushSettings.getC2cMsgRemindSound() + "group msg remind sound = " + tIMOfflinePushSettings.getGroupMsgRemindSound() + ", video sound = " + tIMOfflinePushSettings.getVideoSound());
        mBase.setOfflinePushConfig(tIMOfflinePushSettings);
    }

    public void getOfflinePushSettings(TIMValueCallBack<TIMOfflinePushSettings> tIMValueCallBack) {
        mBase.getOfflinePushConfig(tIMValueCallBack);
    }

    @Deprecated
    public void setOfflinePushListener(TIMOfflinePushListener tIMOfflinePushListener) {
        QLog.i("TIMManager", "setOfflinePushListener: " + tIMOfflinePushListener);
        this.mConversationManager.setOfflinePushListener(tIMOfflinePushListener);
    }

    public void doBackground(TIMBackgroundParam tIMBackgroundParam, TIMCallBack tIMCallBack) {
        QLog.i("TIMManager", "doBackground called, c2cUnread = " + tIMBackgroundParam.getC2cUnread() + ", groupUnread = " + tIMBackgroundParam.getGroupUnread());
        mBase.doBackground(tIMBackgroundParam, tIMCallBack);
    }

    public void doForeground(TIMCallBack tIMCallBack) {
        QLog.i("TIMManager", "doForeground called");
        mBase.doForeground(tIMCallBack);
    }

    public int initStorage(String str, TIMCallBack tIMCallBack) {
        return mBase.initStorage(str, tIMCallBack);
    }

    public String getVersion() {
        return BaseManager.getInstance().getVersion();
    }

    public void addMessageUpdateListener(TIMMessageUpdateListener tIMMessageUpdateListener) {
        this.mConversationManager.addMessageUpdateListener(tIMMessageUpdateListener);
    }

    public void removeMessageUpdateListener(TIMMessageUpdateListener tIMMessageUpdateListener) {
        this.mConversationManager.removeMessageUpdateListener(tIMMessageUpdateListener);
    }

    public TIMNetworkStatus getNetworkStatus() {
        return mBase.getNetworkStatus();
    }

    public long getServerTimeDiff() {
        return mBase.getServerTimeDiff();
    }

    public long getServerTime() {
        return mBase.getServerTime();
    }
}
