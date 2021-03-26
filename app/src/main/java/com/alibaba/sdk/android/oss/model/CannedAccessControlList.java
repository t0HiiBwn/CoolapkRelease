package com.alibaba.sdk.android.oss.model;

public enum CannedAccessControlList {
    Private("private"),
    PublicRead("public-read"),
    PublicReadWrite("public-read-write"),
    Default("default");
    
    private String ACLString;

    private CannedAccessControlList(String str) {
        this.ACLString = str;
    }

    public static CannedAccessControlList parseACL(String str) {
        CannedAccessControlList[] values = values();
        for (CannedAccessControlList cannedAccessControlList : values) {
            if (cannedAccessControlList.toString().equals(str)) {
                return cannedAccessControlList;
            }
        }
        return null;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return this.ACLString;
    }
}
