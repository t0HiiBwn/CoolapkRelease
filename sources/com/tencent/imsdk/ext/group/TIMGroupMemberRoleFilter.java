package com.tencent.imsdk.ext.group;

public enum TIMGroupMemberRoleFilter {
    All(0),
    Owner(1),
    Admin(2),
    Normal(4);
    
    private long filter = 0;

    private TIMGroupMemberRoleFilter(long j) {
        this.filter = j;
    }

    public long value() {
        return this.filter;
    }
}
