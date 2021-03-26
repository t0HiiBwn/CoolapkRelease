package com.alibaba.sdk.android.oss.model;

public enum StorageClass {
    Standard("Standard"),
    IA("IA"),
    Archive("Archive"),
    Unknown("Unknown");
    
    private String storageClassString;

    private StorageClass(String str) {
        this.storageClassString = str;
    }

    public static StorageClass parse(String str) {
        StorageClass[] values = values();
        for (StorageClass storageClass : values) {
            if (storageClass.toString().equals(str)) {
                return storageClass;
            }
        }
        throw new IllegalArgumentException("Unable to parse " + str);
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return this.storageClassString;
    }
}
