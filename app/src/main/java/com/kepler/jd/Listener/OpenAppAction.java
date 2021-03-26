package com.kepler.jd.Listener;

public interface OpenAppAction {
    public static final int OpenAppAction_result_APP = 0;
    public static final int OpenAppAction_result_BlackUrl = 4;
    public static final int OpenAppAction_result_ErrorScheme = 2;
    public static final int OpenAppAction_result_NetError = -1100;
    public static final int OpenAppAction_result_NoJDAPP = 3;
    public static final int OpenAppAction_result_uawakeId_empty = 5;
    public static final int OpenAppAction_start = 1;

    void onStatus(int i, String str);
}
