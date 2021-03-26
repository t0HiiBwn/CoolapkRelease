package com.tencent.openqq.protocol.imsdk;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_common {
    public static final int ADDRESS_LIST_TMP_MSG = 302;
    public static final int ADD_FRIEND_MB_C2C_TMP_MSG = 307;
    public static final int BOTH_FRIEND = 3;
    public static final int BUSINESS_MB_WPA_C2C_TMP_MSG = 306;
    public static final int BU_FRIEND = 520;
    public static final int CONFERENCE = 2;
    public static final int CONTACTS_CIRCLE_C2C_TMP_MSG = 308;
    public static final int DISCUSS = 3;
    public static final int FWD_FRIEND = 1;
    public static final int GROUP = 1;
    public static final int GRP_CONFERENCE = 513;
    public static final int GRP_GROUP = 512;
    public static final int GRP_HRTX = 514;
    public static final int GRP_PUBGROUP = 516;
    public static final int IMAGENT_MSF_TMP_MSG = 301;
    public static final int IMAGENT_TMP_C2C_MSG = 300;
    public static final int MSF_WPA_TMP_MSG = 300;
    public static final int MSG_PUSH = 515;
    public static final int NEARBY_PEOPLE_TMP_DATE_MSG = 310;
    public static final int NEARBY_PEOPLE_TMP_MSG = 304;
    public static final int NEARBY_PEOPLE_TMP_OWN_MSG = 305;
    public static final int QQ_SEARCH_TMP_C2C_MSG = 309;
    public static final int REV_FRIEND = 2;
    public static final int RICH_STATUS_TMP_MSG = 303;
    public static final int UNKNOW = 0;
    public static final int WPA_PAIPAI = 275;
    public static final int WPA_QZONE = 270;

    public static final class BladeSoulToken extends MessageMicro<BladeSoulToken> {
        public static final int APP_ID_FIELD_NUMBER = 3;
        public static final int KEY_TIME_FIELD_NUMBER = 4;
        public static final int KEY_VER_FIELD_NUMBER = 1;
        public static final int RANDOM_FIELD_NUMBER = 5;
        public static final int UIN_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"key_ver", "uin", "app_id", "key_time", "random"}, new Object[]{0, 0L, 0, 0, 0}, BladeSoulToken.class);
        public final PBUInt32Field app_id = PBField.initUInt32(0);
        public final PBUInt32Field key_time = PBField.initUInt32(0);
        public final PBUInt32Field key_ver = PBField.initUInt32(0);
        public final PBUInt32Field random = PBField.initUInt32(0);
        public final PBUInt64Field uin = PBField.initUInt64(0);
    }

    public static final class GroupInfo extends MessageMicro<GroupInfo> {
        public static final int GROUP_ID_FIELD_NUMBER = 1;
        public static final int GROUP_TYPE_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"group_id", "group_type"}, new Object[]{0L, 1}, GroupInfo.class);
        public final PBUInt64Field group_id = PBField.initUInt64(0);
        public final PBEnumField group_type = PBField.initEnum(1);
    }

    public static final class Signature extends MessageMicro<Signature> {
        public static final int KEY_TYPE_FIELD_NUMBER = 1;
        public static final int SESSION_APP_ID_FIELD_NUMBER = 2;
        public static final int SESSION_KEY_FIELD_NUMBER = 3;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"key_type", "session_app_id", "session_key"}, new Object[]{0, 0, ByteStringMicro.EMPTY}, Signature.class);
        public final PBUInt32Field key_type = PBField.initUInt32(0);
        public final PBUInt32Field session_app_id = PBField.initUInt32(0);
        public final PBBytesField session_key = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    public static final class Token extends MessageMicro<Token> {
        public static final int BUF_FIELD_NUMBER = 1;
        public static final int BYTES_SIGT_FIELD_NUMBER = 4;
        public static final int C2C_TYPE_FIELD_NUMBER = 2;
        public static final int SERVICE_TYPE_FIELD_NUMBER = 3;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"buf", "c2c_type", "service_type", "bytes_sigt"}, new Object[]{ByteStringMicro.EMPTY, 0, 0, ByteStringMicro.EMPTY}, Token.class);
        public final PBBytesField buf = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_sigt = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field c2c_type = PBField.initUInt32(0);
        public final PBUInt32Field service_type = PBField.initUInt32(0);
    }

    public static final class User extends MessageMicro<User> {
        public static final int APP_ID_FIELD_NUMBER = 2;
        public static final int APP_TYPE_FIELD_NUMBER = 4;
        public static final int CLIENT_IP_FIELD_NUMBER = 5;
        public static final int EQUIP_KEY_FIELD_NUMBER = 10;
        public static final int INSTANCE_ID_FIELD_NUMBER = 3;
        public static final int LANGUAGE_FIELD_NUMBER = 9;
        public static final int PLATFORM_ID_FIELD_NUMBER = 8;
        public static final int STR_PHONE_NUMBER_FIELD_NUMBER = 7;
        public static final int UIN_FIELD_NUMBER = 1;
        public static final int VERSION_FIELD_NUMBER = 6;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 45, 48, 58, 64, 72, 82}, new String[]{"uin", "app_id", "instance_id", "app_type", "client_ip", "version", "str_phone_number", "platform_id", "language", "equip_key"}, new Object[]{0L, 0, 0, 0, 0, 0, "", 0, 0, ByteStringMicro.EMPTY}, User.class);
        public final PBUInt32Field app_id = PBField.initUInt32(0);
        public final PBUInt32Field app_type = PBField.initUInt32(0);
        public final PBFixed32Field client_ip = PBField.initFixed32(0);
        public final PBBytesField equip_key = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field instance_id = PBField.initUInt32(0);
        public final PBUInt32Field language = PBField.initUInt32(0);
        public final PBUInt32Field platform_id = PBField.initUInt32(0);
        public final PBStringField str_phone_number = PBField.initString("");
        public final PBUInt64Field uin = PBField.initUInt64(0);
        public final PBUInt32Field version = PBField.initUInt32(0);
    }

    private im_common() {
    }
}
