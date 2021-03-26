package com.tencent.imsdk.v2;

public abstract class V2TIMSimpleMsgListener {
    public void onRecvC2CCustomMessage(String str, V2TIMUserInfo v2TIMUserInfo, byte[] bArr) {
    }

    public void onRecvC2CTextMessage(String str, V2TIMUserInfo v2TIMUserInfo, String str2) {
    }

    public void onRecvGroupCustomMessage(String str, String str2, V2TIMGroupMemberInfo v2TIMGroupMemberInfo, byte[] bArr) {
    }

    public void onRecvGroupTextMessage(String str, String str2, V2TIMGroupMemberInfo v2TIMGroupMemberInfo, String str3) {
    }
}
