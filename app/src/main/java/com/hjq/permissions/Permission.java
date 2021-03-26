package com.hjq.permissions;

public final class Permission {
    public static final String ACCEPT_HANDOVER = "android.permission.ACCEPT_HANDOVER";
    public static final String ACCESS_BACKGROUND_LOCATION = "android.permission.ACCESS_BACKGROUND_LOCATION";
    public static final String ACCESS_COARSE_LOCATION = "android.permission.ACCESS_COARSE_LOCATION";
    public static final String ACCESS_FINE_LOCATION = "android.permission.ACCESS_FINE_LOCATION";
    public static final String ACCESS_MEDIA_LOCATION = "android.permission.ACCESS_MEDIA_LOCATION";
    public static final String ACTIVITY_RECOGNITION = "android.permission.ACTIVITY_RECOGNITION";
    public static final String ADD_VOICEMAIL = "com.android.voicemail.permission.ADD_VOICEMAIL";
    public static final String ANSWER_PHONE_CALLS = "android.permission.ANSWER_PHONE_CALLS";
    public static final String BODY_SENSORS = "android.permission.BODY_SENSORS";
    public static final String CALL_PHONE = "android.permission.CALL_PHONE";
    public static final String CAMERA = "android.permission.CAMERA";
    public static final String GET_ACCOUNTS = "android.permission.GET_ACCOUNTS";
    public static final String MANAGE_EXTERNAL_STORAGE = "android.permission.MANAGE_EXTERNAL_STORAGE";
    public static final String NOTIFICATION_SERVICE = "android.permission.ACCESS_NOTIFICATION_POLICY";
    public static final String PROCESS_OUTGOING_CALLS = "android.permission.PROCESS_OUTGOING_CALLS";
    public static final String READ_CALENDAR = "android.permission.READ_CALENDAR";
    public static final String READ_CALL_LOG = "android.permission.READ_CALL_LOG";
    public static final String READ_CONTACTS = "android.permission.READ_CONTACTS";
    @Deprecated
    public static final String READ_EXTERNAL_STORAGE = "android.permission.READ_EXTERNAL_STORAGE";
    public static final String READ_PHONE_NUMBERS = "android.permission.READ_PHONE_NUMBERS";
    public static final String READ_PHONE_STATE = "android.permission.READ_PHONE_STATE";
    public static final String READ_SMS = "android.permission.READ_SMS";
    public static final String RECEIVE_MMS = "android.permission.RECEIVE_MMS";
    public static final String RECEIVE_SMS = "android.permission.RECEIVE_SMS";
    public static final String RECEIVE_WAP_PUSH = "android.permission.RECEIVE_WAP_PUSH";
    public static final String RECORD_AUDIO = "android.permission.RECORD_AUDIO";
    public static final String REQUEST_INSTALL_PACKAGES = "android.permission.REQUEST_INSTALL_PACKAGES";
    public static final String SEND_SMS = "android.permission.SEND_SMS";
    public static final String SYSTEM_ALERT_WINDOW = "android.permission.SYSTEM_ALERT_WINDOW";
    public static final String USE_SIP = "android.permission.USE_SIP";
    public static final String WRITE_CALENDAR = "android.permission.WRITE_CALENDAR";
    public static final String WRITE_CALL_LOG = "android.permission.WRITE_CALL_LOG";
    public static final String WRITE_CONTACTS = "android.permission.WRITE_CONTACTS";
    @Deprecated
    public static final String WRITE_EXTERNAL_STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";
    public static final String WRITE_SETTINGS = "android.permission.WRITE_SETTINGS";

    public static final class Group {
        public static final String[] CALENDAR = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};
        public static final String[] CONTACTS = {"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS"};
        public static final String[] LOCATION = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION"};
        public static final String[] SENSORS = {"android.permission.BODY_SENSORS", "android.permission.ACTIVITY_RECOGNITION"};
        @Deprecated
        public static final String[] STORAGE = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    }

    private Permission() {
    }
}
