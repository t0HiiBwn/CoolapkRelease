package com.alibaba.sdk.android.oss.model;

public enum ObjectPermission {
    Private("private"),
    PublicRead("public-read"),
    PublicReadWrite("public-read-write"),
    Default("default"),
    Unknown("");
    
    private String permissionString;

    private ObjectPermission(String str) {
        this.permissionString = str;
    }

    public static ObjectPermission parsePermission(String str) {
        ObjectPermission[] objectPermissionArr = {Private, PublicRead, PublicReadWrite, Default};
        for (int i = 0; i < 4; i++) {
            ObjectPermission objectPermission = objectPermissionArr[i];
            if (objectPermission.permissionString.equals(str)) {
                return objectPermission;
            }
        }
        return Unknown;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return this.permissionString;
    }
}
