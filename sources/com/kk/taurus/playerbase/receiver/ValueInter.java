package com.kk.taurus.playerbase.receiver;

interface ValueInter {
    <T> T get(String str);

    boolean getBoolean(String str);

    boolean getBoolean(String str, boolean z);

    double getDouble(String str);

    double getDouble(String str, double d);

    float getFloat(String str);

    float getFloat(String str, float f);

    int getInt(String str);

    int getInt(String str, int i);

    long getLong(String str);

    long getLong(String str, long j);

    String getString(String str);

    void putBoolean(String str, boolean z);

    void putBoolean(String str, boolean z, boolean z2);

    void putDouble(String str, double d);

    void putDouble(String str, double d, boolean z);

    void putFloat(String str, float f);

    void putFloat(String str, float f, boolean z);

    void putInt(String str, int i);

    void putInt(String str, int i, boolean z);

    void putLong(String str, long j);

    void putLong(String str, long j, boolean z);

    void putObject(String str, Object obj);

    void putObject(String str, Object obj, boolean z);

    void putString(String str, String str2);

    void putString(String str, String str2, boolean z);
}
