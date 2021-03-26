package com.tencent.android.tpush.service.protocol;

/* compiled from: ProGuard */
public enum MessageType {
    REGISTER("register"),
    ACCOUNT("account"),
    UNREGISTER("unregister"),
    TAG_INFO("tag"),
    UPDATE_OTHER_TOKEN("update_channel_token"),
    PUSH_MESSAGE("push"),
    PUSH_VERIFY("push_stat"),
    COMMON_REPORT("common_report"),
    ATTRIBUTE_INFO("attribute");
    
    private String str;

    private MessageType(String str2) {
        this.str = str2;
    }

    public String getStr() {
        return this.str;
    }
}
