package com.blankj.utilcode.constant;

import android.os.Build;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class PermissionConstants {
    public static final String ACTIVITY_RECOGNITION = "ACTIVITY_RECOGNITION";
    public static final String CALENDAR = "CALENDAR";
    public static final String CAMERA = "CAMERA";
    public static final String CONTACTS = "CONTACTS";
    private static final String[] GROUP_ACTIVITY_RECOGNITION = {"android.permission.ACTIVITY_RECOGNITION"};
    private static final String[] GROUP_CALENDAR = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};
    private static final String[] GROUP_CAMERA = {"android.permission.CAMERA"};
    private static final String[] GROUP_CONTACTS = {"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS"};
    private static final String[] GROUP_LOCATION = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION"};
    private static final String[] GROUP_MICROPHONE = {"android.permission.RECORD_AUDIO"};
    private static final String[] GROUP_PHONE = {"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS", "android.permission.ANSWER_PHONE_CALLS"};
    private static final String[] GROUP_PHONE_BELOW_O = {"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS"};
    private static final String[] GROUP_SENSORS = {"android.permission.BODY_SENSORS"};
    private static final String[] GROUP_SMS = {"android.permission.SEND_SMS", "android.permission.RECEIVE_SMS", "android.permission.READ_SMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.RECEIVE_MMS"};
    private static final String[] GROUP_STORAGE = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    public static final String LOCATION = "LOCATION";
    public static final String MICROPHONE = "MICROPHONE";
    public static final String PHONE = "PHONE";
    public static final String SENSORS = "SENSORS";
    public static final String SMS = "SMS";
    public static final String STORAGE = "STORAGE";

    @Retention(RetentionPolicy.SOURCE)
    public @interface PermissionGroup {
    }

    public static String[] getPermissions(String str) {
        if (str == null) {
            return new String[0];
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1611296843:
                if (str.equals("LOCATION")) {
                    c = 0;
                    break;
                }
                break;
            case -1596608551:
                if (str.equals("SENSORS")) {
                    c = 1;
                    break;
                }
                break;
            case -1166291365:
                if (str.equals("STORAGE")) {
                    c = 2;
                    break;
                }
                break;
            case 82233:
                if (str.equals("SMS")) {
                    c = 3;
                    break;
                }
                break;
            case 76105038:
                if (str.equals("PHONE")) {
                    c = 4;
                    break;
                }
                break;
            case 140654183:
                if (str.equals("ACTIVITY_RECOGNITION")) {
                    c = 5;
                    break;
                }
                break;
            case 215175251:
                if (str.equals("CONTACTS")) {
                    c = 6;
                    break;
                }
                break;
            case 604302142:
                if (str.equals("CALENDAR")) {
                    c = 7;
                    break;
                }
                break;
            case 1856013610:
                if (str.equals("MICROPHONE")) {
                    c = '\b';
                    break;
                }
                break;
            case 1980544805:
                if (str.equals("CAMERA")) {
                    c = '\t';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return GROUP_LOCATION;
            case 1:
                return GROUP_SENSORS;
            case 2:
                return GROUP_STORAGE;
            case 3:
                return GROUP_SMS;
            case 4:
                if (Build.VERSION.SDK_INT < 26) {
                    return GROUP_PHONE_BELOW_O;
                }
                return GROUP_PHONE;
            case 5:
                return GROUP_ACTIVITY_RECOGNITION;
            case 6:
                return GROUP_CONTACTS;
            case 7:
                return GROUP_CALENDAR;
            case '\b':
                return GROUP_MICROPHONE;
            case '\t':
                return GROUP_CAMERA;
            default:
                return new String[]{str};
        }
    }
}
