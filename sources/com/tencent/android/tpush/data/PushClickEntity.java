package com.tencent.android.tpush.data;

import java.io.Serializable;

/* compiled from: ProGuard */
public class PushClickEntity implements Serializable {
    private static final long serialVersionUID = -166678396447407161L;
    public long accessId = 0;
    public int action = 0;
    public long broadcastId = 0;
    public long clickTime = 0;
    public String groupId = "";
    public long msgId = 0;
    public String pkgName = "";
    public long timestamp = 0;
    public long type = 1;

    public PushClickEntity() {
    }

    public PushClickEntity(long j, long j2, long j3, long j4, String str, long j5, long j6, int i, String str2) {
        this.msgId = j;
        this.accessId = j2;
        this.broadcastId = j3;
        this.timestamp = j4;
        this.pkgName = str;
        this.type = j5;
        this.clickTime = j6;
        this.action = i;
        this.groupId = str2;
    }
}
