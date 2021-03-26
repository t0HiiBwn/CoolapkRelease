package cn.bertsir.zbar.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class PermissionConstants {
    public static final String CALENDAR = "android.permission-group.CALENDAR";
    public static final String CAMERA = "android.permission-group.CAMERA";
    public static final String CONTACTS = "android.permission-group.CONTACTS";
    private static final String[] GROUP_CALENDAR = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};
    private static final String[] GROUP_CAMERA = {"android.permission.CAMERA"};
    private static final String[] GROUP_CONTACTS = {"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS"};
    private static final String[] GROUP_LOCATION = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    private static final String[] GROUP_MICROPHONE = {"android.permission.RECORD_AUDIO"};
    private static final String[] GROUP_PHONE = {"android.permission.READ_PHONE_STATE", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS"};
    private static final String[] GROUP_SENSORS = {"android.permission.BODY_SENSORS"};
    private static final String[] GROUP_SMS = {"android.permission.SEND_SMS", "android.permission.RECEIVE_SMS", "android.permission.READ_SMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.RECEIVE_MMS"};
    private static final String[] GROUP_STORAGE = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    public static final String LOCATION = "android.permission-group.LOCATION";
    public static final String MICROPHONE = "android.permission-group.MICROPHONE";
    public static final String PHONE = "android.permission-group.PHONE";
    public static final String SENSORS = "android.permission-group.SENSORS";
    public static final String SMS = "android.permission-group.SMS";
    public static final String STORAGE = "android.permission-group.STORAGE";

    @Retention(RetentionPolicy.SOURCE)
    public @interface Permission {
    }

    public static String[] getPermissions(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1639857183:
                if (str.equals("android.permission-group.CONTACTS")) {
                    c = 0;
                    break;
                }
                break;
            case -1410061184:
                if (str.equals("android.permission-group.PHONE")) {
                    c = 1;
                    break;
                }
                break;
            case -1250730292:
                if (str.equals("android.permission-group.CALENDAR")) {
                    c = 2;
                    break;
                }
                break;
            case -1140935117:
                if (str.equals("android.permission-group.CAMERA")) {
                    c = 3;
                    break;
                }
                break;
            case 421761675:
                if (str.equals("android.permission-group.SENSORS")) {
                    c = 4;
                    break;
                }
                break;
            case 828638019:
                if (str.equals("android.permission-group.LOCATION")) {
                    c = 5;
                    break;
                }
                break;
            case 852078861:
                if (str.equals("android.permission-group.STORAGE")) {
                    c = 6;
                    break;
                }
                break;
            case 1581272376:
                if (str.equals("android.permission-group.MICROPHONE")) {
                    c = 7;
                    break;
                }
                break;
            case 1795181803:
                if (str.equals("android.permission-group.SMS")) {
                    c = '\b';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return GROUP_CONTACTS;
            case 1:
                return GROUP_PHONE;
            case 2:
                return GROUP_CALENDAR;
            case 3:
                return GROUP_CAMERA;
            case 4:
                return GROUP_SENSORS;
            case 5:
                return GROUP_LOCATION;
            case 6:
                return GROUP_STORAGE;
            case 7:
                return GROUP_MICROPHONE;
            case '\b':
                return GROUP_SMS;
            default:
                return new String[]{str};
        }
    }
}
