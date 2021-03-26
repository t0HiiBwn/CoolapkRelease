package com.tencent.openqq.protocol.imsdk;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class head {
    public static final int ANYCONN_DEVICE = 1;
    public static final int ANYCONN_USER = 3;
    public static final int ANYCONN_VENDOR = 2;
    public static final int DEVICE_TYPE_MAC = 4;
    public static final int DEVICE_TYPE_PAD = 3;
    public static final int DEVICE_TYPE_PC = 1;
    public static final int DEVICE_TYPE_PHONE = 2;
    public static final int DOMAIN_QQ = 1;
    public static final int OS_TYPE_ANDROID = 2;
    public static final int OS_TYPE_IOS = 1;
    public static final int PRODUCT_TYPE_QQ = 1;
    public static final int PRODUCT_TYPE_TIM = 2;
    public static final int SVR_TYPE_CONN = 3;
    public static final int SVR_TYPE_IMAGENT = 2;
    public static final int SVR_TYPE_OPEN_PLATFORM = 5;
    public static final int SVR_TYPE_SHARP_APP_SVR = 4;
    public static final int SVR_TYPE_SSO = 1;
    public static final int UINTYPE_DIN = 4;
    public static final int UINTYPE_MOBILE = 6;
    public static final int UINTYPE_QCALL = 2;
    public static final int UINTYPE_QCALL_VISITOR = 3;
    public static final int UINTYPE_QQ = 1;
    public static final int UINTYPE_TINYID = 5;

    public static final class AndroidOfflineInfo extends MessageMicro<AndroidOfflineInfo> {
        public static final int BYTES_SOUND_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_sound"}, new Object[]{ByteStringMicro.EMPTY}, AndroidOfflineInfo.class);
        public final PBBytesField bytes_sound = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    public static final class AnyConnC2CInfo extends MessageMicro<AnyConnC2CInfo> {
        public static final int ENUM_FROM_NODE_TYPE_FIELD_NUMBER = 3;
        public static final int ENUM_TO_NODE_TYPE_FIELD_NUMBER = 4;
        public static final int UINT64_FROM_UIN_FIELD_NUMBER = 1;
        public static final int UINT64_TO_UIN_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint64_from_uin", "uint64_to_uin", "enum_from_node_type", "enum_to_node_type"}, new Object[]{0L, 0L, 1, 1}, AnyConnC2CInfo.class);
        public final PBEnumField enum_from_node_type = PBField.initEnum(1);
        public final PBEnumField enum_to_node_type = PBField.initEnum(1);
        public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
    }

    public static final class ApnsOfflineInfo extends MessageMicro<ApnsOfflineInfo> {
        public static final int BYTES_SOUND_FIELD_NUMBER = 1;
        public static final int UINT32_BADGE_MODE_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_sound", "uint32_badge_mode"}, new Object[]{ByteStringMicro.EMPTY, 0}, ApnsOfflineInfo.class);
        public final PBBytesField bytes_sound = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_badge_mode = PBField.initUInt32(0);
    }

    public static final class C2CHead extends MessageMicro<C2CHead> {
        public static final int BYTES_AUTH_BUF_FIELD_NUMBER = 7;
        public static final int BYTES_AUTH_PIC_SIG_FIELD_NUMBER = 5;
        public static final int BYTES_AUTH_SIG_FIELD_NUMBER = 6;
        public static final int STRING_PHONE_NUMBER_FIELD_NUMBER = 11;
        public static final int UINT32_CC_CMD_FIELD_NUMBER = 4;
        public static final int UINT32_CC_TYPE_FIELD_NUMBER = 3;
        public static final int UINT32_CLIENT_TIME_FIELD_NUMBER = 9;
        public static final int UINT32_RAND_FIELD_NUMBER = 10;
        public static final int UINT32_SERVER_TIME_FIELD_NUMBER = 8;
        public static final int UINT64_FROM_UIN_FIELD_NUMBER = 2;
        public static final int UINT64_TO_UIN_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 64, 72, 80, 90}, new String[]{"uint64_to_uin", "uint64_from_uin", "uint32_cc_type", "uint32_cc_cmd", "bytes_auth_pic_sig", "bytes_auth_sig", "bytes_auth_buf", "uint32_server_time", "uint32_client_time", "uint32_rand", "string_phone_number"}, new Object[]{0L, 0L, 0, 0, ByteStringMicro.EMPTY, ByteStringMicro.EMPTY, ByteStringMicro.EMPTY, 0, 0, 0, ""}, C2CHead.class);
        public final PBBytesField bytes_auth_buf = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_auth_pic_sig = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_auth_sig = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBStringField string_phone_number = PBField.initString("");
        public final PBUInt32Field uint32_cc_cmd = PBField.initUInt32(0);
        public final PBUInt32Field uint32_cc_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_client_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_rand = PBField.initUInt32(0);
        public final PBUInt32Field uint32_server_time = PBField.initUInt32(0);
        public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
    }

    public static final class C2CInfo extends MessageMicro<C2CInfo> {
        public static final int BYTES_FROM_UIN_NICK_FIELD_NUMBER = 3;
        public static final int ENUM_FROM_UIN_TYPE_FIELD_NUMBER = 5;
        public static final int ENUM_TO_DOMAIN_FIELD_NUMBER = 11;
        public static final int ENUM_TO_UIN_BINDED_TYPE_FIELD_NUMBER = 12;
        public static final int ENUM_TO_UIN_TYPE_FIELD_NUMBER = 6;
        public static final int MSG_FROM_PHONEINFO_FIELD_NUMBER = 9;
        public static final int MSG_TO_PHONEINFO_FIELD_NUMBER = 10;
        public static final int UINT32_FROM_INDENTITY_FOR_CLIENT_FIELD_NUMBER = 8;
        public static final int UINT64_FROM_UIN_BINDED_FIELD_NUMBER = 4;
        public static final int UINT64_FROM_UIN_FIELD_NUMBER = 1;
        public static final int UINT64_TO_UIN_BINDED_FIELD_NUMBER = 7;
        public static final int UINT64_TO_UIN_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48, 56, 64, 74, 82, 88, 96}, new String[]{"uint64_from_uin", "uint64_to_uin", "bytes_from_uin_nick", "uint64_from_uin_binded", "enum_from_uin_type", "enum_to_uin_type", "uint64_to_uin_binded", "uint32_from_indentity_for_client", "msg_from_phoneinfo", "msg_to_phoneinfo", "enum_to_domain", "enum_to_uin_binded_type"}, new Object[]{0L, 0L, ByteStringMicro.EMPTY, 0L, 1, 1, 0L, 0, null, null, 1, 1}, C2CInfo.class);
        public final PBBytesField bytes_from_uin_nick = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBEnumField enum_from_uin_type = PBField.initEnum(1);
        public final PBEnumField enum_to_domain = PBField.initEnum(1);
        public final PBEnumField enum_to_uin_binded_type = PBField.initEnum(1);
        public final PBEnumField enum_to_uin_type = PBField.initEnum(1);
        public PhoneInfo msg_from_phoneinfo = new PhoneInfo();
        public PhoneInfo msg_to_phoneinfo = new PhoneInfo();
        public final PBUInt32Field uint32_from_indentity_for_client = PBField.initUInt32(0);
        public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_from_uin_binded = PBField.initUInt64(0);
        public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_to_uin_binded = PBField.initUInt64(0);
    }

    public static final class C2CTempInfo extends MessageMicro<C2CTempInfo> {
        public static final int BYTES_FROM_UIN_NICK_FIELD_NUMBER = 5;
        public static final int ENUM_FROM_UIN_TYPE_FIELD_NUMBER = 3;
        public static final int ENUM_TO_DOMAIN_FIELD_NUMBER = 12;
        public static final int ENUM_TO_UIN_BINDED_TYPE_FIELD_NUMBER = 13;
        public static final int ENUM_TO_UIN_TYPE_FIELD_NUMBER = 4;
        public static final int MSG_FROM_PHONEINFO_FIELD_NUMBER = 10;
        public static final int MSG_TMP_SIG_FIELD_NUMBER = 9;
        public static final int MSG_TO_PHONEINFO_FIELD_NUMBER = 11;
        public static final int UINT32_FROM_INDENTITY_FOR_CLIENT_FIELD_NUMBER = 8;
        public static final int UINT64_FROM_UIN_BINDED_FIELD_NUMBER = 6;
        public static final int UINT64_FROM_UIN_FIELD_NUMBER = 1;
        public static final int UINT64_TO_UIN_BINDED_FIELD_NUMBER = 7;
        public static final int UINT64_TO_UIN_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 64, 74, 82, 90, 96, 104}, new String[]{"uint64_from_uin", "uint64_to_uin", "enum_from_uin_type", "enum_to_uin_type", "bytes_from_uin_nick", "uint64_from_uin_binded", "uint64_to_uin_binded", "uint32_from_indentity_for_client", "msg_tmp_sig", "msg_from_phoneinfo", "msg_to_phoneinfo", "enum_to_domain", "enum_to_uin_binded_type"}, new Object[]{0L, 0L, 1, 1, ByteStringMicro.EMPTY, 0L, 0L, 0, null, null, null, 1, 1}, C2CTempInfo.class);
        public final PBBytesField bytes_from_uin_nick = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBEnumField enum_from_uin_type = PBField.initEnum(1);
        public final PBEnumField enum_to_domain = PBField.initEnum(1);
        public final PBEnumField enum_to_uin_binded_type = PBField.initEnum(1);
        public final PBEnumField enum_to_uin_type = PBField.initEnum(1);
        public PhoneInfo msg_from_phoneinfo = new PhoneInfo();
        public TmpMsgToken msg_tmp_sig = new TmpMsgToken();
        public PhoneInfo msg_to_phoneinfo = new PhoneInfo();
        public final PBUInt32Field uint32_from_indentity_for_client = PBField.initUInt32(0);
        public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_from_uin_binded = PBField.initUInt64(0);
        public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_to_uin_binded = PBField.initUInt64(0);
    }

    public static final class C2SInfo extends MessageMicro<C2SInfo> {
        public static final int ENUM_DEST_SVR_TYPE_FIELD_NUMBER = 2;
        public static final int ENUM_FROM_UIN_TYPE_FIELD_NUMBER = 3;
        public static final int UINT64_FROM_UIN_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_from_uin", "enum_dest_svr_type", "enum_from_uin_type"}, new Object[]{0L, 1, 1}, C2SInfo.class);
        public final PBEnumField enum_dest_svr_type = PBField.initEnum(1);
        public final PBEnumField enum_from_uin_type = PBField.initEnum(1);
        public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    }

    public static final class CSHead extends MessageMicro<CSHead> {
        public static final int UINT32_ACTUAL_IP_FIELD_NUMBER = 16;
        public static final int UINT32_APP_ID_FIELD_NUMBER = 21;
        public static final int UINT32_CLIENT_IP_FIELD_NUMBER = 10;
        public static final int UINT32_CLIENT_PORT_FIELD_NUMBER = 11;
        public static final int UINT32_CLIENT_TYPE_FIELD_NUMBER = 6;
        public static final int UINT32_COMMAND_FIELD_NUMBER = 2;
        public static final int UINT32_CONN_IP_FIELD_NUMBER = 12;
        public static final int UINT32_CONN_PORT_FIELD_NUMBER = 13;
        public static final int UINT32_FLAG_FIELD_NUMBER = 17;
        public static final int UINT32_IDC_ID_FIELD_NUMBER = 24;
        public static final int UINT32_INSTANCE_ID_FIELD_NUMBER = 22;
        public static final int UINT32_INTERFACE_IP_FIELD_NUMBER = 14;
        public static final int UINT32_INTERFACE_PORT_FIELD_NUMBER = 15;
        public static final int UINT32_LOCALID_FIELD_NUMBER = 8;
        public static final int UINT32_PUBNO_FIELD_NUMBER = 7;
        public static final int UINT32_RESULT_FIELD_NUMBER = 20;
        public static final int UINT32_RETRY_TIMES_FIELD_NUMBER = 5;
        public static final int UINT32_SEQ_FIELD_NUMBER = 3;
        public static final int UINT32_SUBCMD_FIELD_NUMBER = 19;
        public static final int UINT32_TIMESTAMP_FIELD_NUMBER = 18;
        public static final int UINT32_TIMEZONE_FIELD_NUMBER = 9;
        public static final int UINT32_VERSION_FIELD_NUMBER = 4;
        public static final int UINT64_SESSION_ID_FIELD_NUMBER = 23;
        public static final int UINT64_UIN_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 85, 88, 101, 104, 117, 120, 133, 136, 149, 152, 160, 168, 176, 184, 192}, new String[]{"uint64_uin", "uint32_command", "uint32_seq", "uint32_version", "uint32_retry_times", "uint32_client_type", "uint32_pubno", "uint32_localid", "uint32_timezone", "uint32_client_ip", "uint32_client_port", "uint32_conn_ip", "uint32_conn_port", "uint32_interface_ip", "uint32_interface_port", "uint32_actual_ip", "uint32_flag", "uint32_timestamp", "uint32_subcmd", "uint32_result", "uint32_app_id", "uint32_instance_id", "uint64_session_id", "uint32_idc_id"}, new Object[]{0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0L, 0}, CSHead.class);
        public final PBFixed32Field uint32_actual_ip = PBField.initFixed32(0);
        public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
        public final PBFixed32Field uint32_client_ip = PBField.initFixed32(0);
        public final PBUInt32Field uint32_client_port = PBField.initUInt32(0);
        public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_command = PBField.initUInt32(0);
        public final PBFixed32Field uint32_conn_ip = PBField.initFixed32(0);
        public final PBUInt32Field uint32_conn_port = PBField.initUInt32(0);
        public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_idc_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_instance_id = PBField.initUInt32(0);
        public final PBFixed32Field uint32_interface_ip = PBField.initFixed32(0);
        public final PBUInt32Field uint32_interface_port = PBField.initUInt32(0);
        public final PBUInt32Field uint32_localid = PBField.initUInt32(0);
        public final PBUInt32Field uint32_pubno = PBField.initUInt32(0);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBUInt32Field uint32_retry_times = PBField.initUInt32(0);
        public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
        public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
        public final PBFixed32Field uint32_timestamp = PBField.initFixed32(0);
        public final PBUInt32Field uint32_timezone = PBField.initUInt32(0);
        public final PBUInt32Field uint32_version = PBField.initUInt32(0);
        public final PBUInt64Field uint64_session_id = PBField.initUInt64(0);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    }

    public static final class ConfInfo extends MessageMicro<ConfInfo> {
        public static final int BYTES_COMBINED_CONF_NAME_FIELD_NUMBER = 10;
        public static final int BYTES_CONF_NAME_FIELD_NUMBER = 8;
        public static final int BYTES_FROM_UIN_NICK_FIELD_NUMBER = 5;
        public static final int BYTES_TO_PHONE_NUMBER_FIELD_NUMBER = 9;
        public static final int ENUM_FROM_UIN_TYPE_FIELD_NUMBER = 3;
        public static final int ENUM_TO_UIN_TYPE_FIELD_NUMBER = 4;
        public static final int UINT32_FROM_UIN_IMAGE_ID_FIELD_NUMBER = 7;
        public static final int UINT64_CONF_UIN_FIELD_NUMBER = 6;
        public static final int UINT64_FROM_UIN_FIELD_NUMBER = 1;
        public static final int UINT64_TO_UIN_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 66, 74, 82}, new String[]{"uint64_from_uin", "uint64_to_uin", "enum_from_uin_type", "enum_to_uin_type", "bytes_from_uin_nick", "uint64_conf_uin", "uint32_from_uin_image_id", "bytes_conf_name", "bytes_to_phone_number", "bytes_combined_conf_name"}, new Object[]{0L, 0L, 1, 1, ByteStringMicro.EMPTY, 0L, 0, ByteStringMicro.EMPTY, ByteStringMicro.EMPTY, ByteStringMicro.EMPTY}, ConfInfo.class);
        public final PBBytesField bytes_combined_conf_name = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_conf_name = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_from_uin_nick = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_to_phone_number = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBEnumField enum_from_uin_type = PBField.initEnum(1);
        public final PBEnumField enum_to_uin_type = PBField.initEnum(1);
        public final PBUInt32Field uint32_from_uin_image_id = PBField.initUInt32(0);
        public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
    }

    public static final class ContentHead extends MessageMicro<ContentHead> {
        public static final int UINT32_CLIENT_TIME_FIELD_NUMBER = 6;
        public static final int UINT32_RAND_FIELD_NUMBER = 4;
        public static final int UINT32_SEQ_FIELD_NUMBER = 3;
        public static final int UINT32_SERVER_SEQ_FIELD_NUMBER = 8;
        public static final int UINT32_SERVER_TIME_FIELD_NUMBER = 5;
        public static final int UINT32_SUBTYPE_FIELD_NUMBER = 2;
        public static final int UINT32_TYPE_FIELD_NUMBER = 1;
        public static final int UINT32_USER_CMD_FIELD_NUMBER = 7;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64}, new String[]{"uint32_type", "uint32_subtype", "uint32_seq", "uint32_rand", "uint32_server_time", "uint32_client_time", "uint32_user_cmd", "uint32_server_seq"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0}, ContentHead.class);
        public final PBUInt32Field uint32_client_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_rand = PBField.initUInt32(0);
        public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
        public final PBUInt32Field uint32_server_seq = PBField.initUInt32(0);
        public final PBUInt32Field uint32_server_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_subtype = PBField.initUInt32(0);
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_user_cmd = PBField.initUInt32(0);
    }

    public static final class DeltaHead extends MessageMicro<DeltaHead> {
        public static final int BYTES_ACK_COOKIE_FIELD_NUMBER = 5;
        public static final int BYTES_COOKIE_FIELD_NUMBER = 4;
        public static final int UINT32_FLAGS_FIELD_NUMBER = 7;
        public static final int UINT32_RESULT_FIELD_NUMBER = 6;
        public static final int UINT64_ACK_OFFSET_FIELD_NUMBER = 3;
        public static final int UINT64_OFFSET_FIELD_NUMBER = 2;
        public static final int UINT64_TOTAL_LEN_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48, 56}, new String[]{"uint64_total_len", "uint64_offset", "uint64_ack_offset", "bytes_cookie", "bytes_ack_cookie", "uint32_result", "uint32_flags"}, new Object[]{0L, 0L, 0L, ByteStringMicro.EMPTY, ByteStringMicro.EMPTY, 0, 0}, DeltaHead.class);
        public final PBBytesField bytes_ack_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_flags = PBField.initUInt32(0);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBUInt64Field uint64_ack_offset = PBField.initUInt64(0);
        public final PBUInt64Field uint64_offset = PBField.initUInt64(0);
        public final PBUInt64Field uint64_total_len = PBField.initUInt64(0);
    }

    public static final class GroupInfo extends MessageMicro<GroupInfo> {
        public static final int BYTES_FROM_UIN_HEADURL_FIELD_NUMBER = 11;
        public static final int BYTES_FROM_UIN_NICK_FIELD_NUMBER = 5;
        public static final int BYTES_GROUP_ID_FIELD_NUMBER = 12;
        public static final int BYTES_GROUP_NAME_FIELD_NUMBER = 8;
        public static final int ENUM_FROM_UIN_TYPE_FIELD_NUMBER = 3;
        public static final int ENUM_TO_UIN_TYPE_FIELD_NUMBER = 4;
        public static final int MSG_FROM_UIN_EXTRA_INFO_FIELD_NUMBER = 14;
        public static final int UINT32_MSG_FLAG_FIELD_NUMBER = 13;
        public static final int UINT64_FROM_UIN_BINDED_FIELD_NUMBER = 9;
        public static final int UINT64_FROM_UIN_FIELD_NUMBER = 1;
        public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 7;
        public static final int UINT64_GROUP_UIN_FIELD_NUMBER = 6;
        public static final int UINT64_TO_UIN_BINDED_FIELD_NUMBER = 10;
        public static final int UINT64_TO_UIN_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 66, 72, 80, 90, 98, 104, 114}, new String[]{"uint64_from_uin", "uint64_to_uin", "enum_from_uin_type", "enum_to_uin_type", "bytes_from_uin_nick", "uint64_group_uin", "uint64_group_code", "bytes_group_name", "uint64_from_uin_binded", "uint64_to_uin_binded", "bytes_from_uin_headurl", "bytes_group_id", "uint32_msg_flag", "msg_from_uin_extra_info"}, new Object[]{0L, 0L, 1, 1, ByteStringMicro.EMPTY, 0L, 0L, ByteStringMicro.EMPTY, 0L, 0L, ByteStringMicro.EMPTY, ByteStringMicro.EMPTY, 0, null}, GroupInfo.class);
        public final PBBytesField bytes_from_uin_headurl = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_from_uin_nick = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_group_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBEnumField enum_from_uin_type = PBField.initEnum(1);
        public final PBEnumField enum_to_uin_type = PBField.initEnum(1);
        public UinExtaInfo msg_from_uin_extra_info = new UinExtaInfo();
        public final PBUInt32Field uint32_msg_flag = PBField.initUInt32(0);
        public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_from_uin_binded = PBField.initUInt64(0);
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_to_uin_binded = PBField.initUInt64(0);
    }

    public static final class GroupOpenAppDefinedData extends MessageMicro<GroupOpenAppDefinedData> {
        public static final int BYTES_KEY_FIELD_NUMBER = 1;
        public static final int BYTES_VALUE_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_key", "bytes_value"}, new Object[]{ByteStringMicro.EMPTY, ByteStringMicro.EMPTY}, GroupOpenAppDefinedData.class);
        public final PBBytesField bytes_key = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    public static final class Head extends MessageMicro<Head> {
        public static final int MSG_C2C_HEAD_FIELD_NUMBER = 8;
        public static final int MSG_CS_HEAD_FIELD_NUMBER = 2;
        public static final int MSG_DELTA_HEAD_FIELD_NUMBER = 7;
        public static final int MSG_HTTPCONN_HEAD_FIELD_NUMBER = 4;
        public static final int MSG_INST_CTRL_FIELD_NUMBER = 10;
        public static final int MSG_LOGIN_SIG_FIELD_NUMBER = 6;
        public static final int MSG_MSG_HEAD_FIELD_NUMBER = 12;
        public static final int MSG_S2C_HEAD_FIELD_NUMBER = 3;
        public static final int MSG_SCONN_HEAD_FIELD_NUMBER = 9;
        public static final int MSG_SERVICE_HEAD_FIELD_NUMBER = 11;
        public static final int UINT32_HEAD_TYPE_FIELD_NUMBER = 1;
        public static final int UINT32_PAINT_FLAG_FIELD_NUMBER = 5;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 58, 66, 74, 82, 90, 98}, new String[]{"uint32_head_type", "msg_cs_head", "msg_s2c_head", "msg_httpconn_head", "uint32_paint_flag", "msg_login_sig", "msg_delta_head", "msg_c2c_head", "msg_sconn_head", "msg_inst_ctrl", "msg_service_head", "msg_msg_head"}, new Object[]{0, null, null, null, 0, null, null, null, null, null, null, null}, Head.class);
        public C2CHead msg_c2c_head = new C2CHead();
        public CSHead msg_cs_head = new CSHead();
        public DeltaHead msg_delta_head = new DeltaHead();
        public HttpConnHead msg_httpconn_head = new HttpConnHead();
        public InstCtrl msg_inst_ctrl = new InstCtrl();
        public LoginSig msg_login_sig = new LoginSig();
        public MsgHead msg_msg_head = new MsgHead();
        public S2CHead msg_s2c_head = new S2CHead();
        public SConnHead msg_sconn_head = new SConnHead();
        public ServiceHead msg_service_head = new ServiceHead();
        public final PBUInt32Field uint32_head_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_paint_flag = PBField.initUInt32(0);
    }

    public static final class HttpConnHead extends MessageMicro<HttpConnHead> {
        public static final int BYTES_KEY_FIELD_NUMBER = 18;
        public static final int MSG_REDIRECT_FIELD_NUMBER = 22;
        public static final int UINT32_CLIENT_IP_FIELD_NUMBER = 11;
        public static final int UINT32_CLIENT_PORT_FIELD_NUMBER = 12;
        public static final int UINT32_CLIENT_TYPE_FIELD_NUMBER = 7;
        public static final int UINT32_COMMAND_FIELD_NUMBER = 2;
        public static final int UINT32_COMPRESS_TYPE_FIELD_NUMBER = 19;
        public static final int UINT32_ERROR_CODE_FIELD_NUMBER = 21;
        public static final int UINT32_FLAG_FIELD_NUMBER = 17;
        public static final int UINT32_LOCAL_ID_FIELD_NUMBER = 9;
        public static final int UINT32_ORIGIN_SIZE_FIELD_NUMBER = 20;
        public static final int UINT32_PUB_NO_FIELD_NUMBER = 8;
        public static final int UINT32_QZHTTP_IP_FIELD_NUMBER = 13;
        public static final int UINT32_QZHTTP_PORT_FIELD_NUMBER = 14;
        public static final int UINT32_RETRY_TIMES_FIELD_NUMBER = 6;
        public static final int UINT32_SEQ_FIELD_NUMBER = 4;
        public static final int UINT32_SPP_IP_FIELD_NUMBER = 15;
        public static final int UINT32_SPP_PORT_FIELD_NUMBER = 16;
        public static final int UINT32_SUB_COMMAND_FIELD_NUMBER = 3;
        public static final int UINT32_TIME_ZONE_FIELD_NUMBER = 10;
        public static final int UINT32_VERSION_FIELD_NUMBER = 5;
        public static final int UINT64_UIN_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 93, 96, 109, 112, 125, 128, 136, 146, 152, 160, 168, 178}, new String[]{"uint64_uin", "uint32_command", "uint32_sub_command", "uint32_seq", "uint32_version", "uint32_retry_times", "uint32_client_type", "uint32_pub_no", "uint32_local_id", "uint32_time_zone", "uint32_client_ip", "uint32_client_port", "uint32_qzhttp_ip", "uint32_qzhttp_port", "uint32_spp_ip", "uint32_spp_port", "uint32_flag", "bytes_key", "uint32_compress_type", "uint32_origin_size", "uint32_error_code", "msg_redirect"}, new Object[]{0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ByteStringMicro.EMPTY, 0, 0, 0, null}, HttpConnHead.class);
        public final PBBytesField bytes_key = PBField.initBytes(ByteStringMicro.EMPTY);
        public RedirectMsg msg_redirect = new RedirectMsg();
        public final PBFixed32Field uint32_client_ip = PBField.initFixed32(0);
        public final PBUInt32Field uint32_client_port = PBField.initUInt32(0);
        public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_command = PBField.initUInt32(0);
        public final PBUInt32Field uint32_compress_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
        public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_local_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_origin_size = PBField.initUInt32(0);
        public final PBUInt32Field uint32_pub_no = PBField.initUInt32(0);
        public final PBFixed32Field uint32_qzhttp_ip = PBField.initFixed32(0);
        public final PBUInt32Field uint32_qzhttp_port = PBField.initUInt32(0);
        public final PBUInt32Field uint32_retry_times = PBField.initUInt32(0);
        public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
        public final PBFixed32Field uint32_spp_ip = PBField.initFixed32(0);
        public final PBUInt32Field uint32_spp_port = PBField.initUInt32(0);
        public final PBUInt32Field uint32_sub_command = PBField.initUInt32(0);
        public final PBUInt32Field uint32_time_zone = PBField.initUInt32(0);
        public final PBUInt32Field uint32_version = PBField.initUInt32(0);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    }

    public static final class InstCond extends MessageMicro<InstCond> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], InstCond.class);
    }

    public static final class InstCtrl extends MessageMicro<InstCtrl> {
        public static final int MSG_FROM_INST_FIELD_NUMBER = 3;
        public static final int RPT_MSG_EXCLUDE_INST_FIELD_NUMBER = 2;
        public static final int RPT_MSG_SEND_TO_INST_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"rpt_msg_send_to_inst", "rpt_msg_exclude_inst", "msg_from_inst"}, new Object[]{null, null, null}, InstCtrl.class);
        public InstInfo msg_from_inst = new InstInfo();
        public final PBRepeatMessageField<InstInfo> rpt_msg_exclude_inst = PBField.initRepeatMessage(InstInfo.class);
        public final PBRepeatMessageField<InstInfo> rpt_msg_send_to_inst = PBField.initRepeatMessage(InstInfo.class);
    }

    public static final class InstInfo extends MessageMicro<InstInfo> {
        public static final int BYTES_GUID_FIELD_NUMBER = 7;
        public static final int BYTES_PLATFORM_NAME_FIELD_NUMBER = 11;
        public static final int ENUM_DEVICE_TYPE_FIELD_NUMBER = 10;
        public static final int UINT32_APPPID_FIELD_NUMBER = 1;
        public static final int UINT32_INSTID_FIELD_NUMBER = 2;
        public static final int UINT32_OPEN_APPID_FIELD_NUMBER = 4;
        public static final int UINT32_PLATFORM_FIELD_NUMBER = 3;
        public static final int UINT32_PRODUCTID_FIELD_NUMBER = 5;
        public static final int UINT32_SSO_BID_FIELD_NUMBER = 6;
        public static final int UINT32_VER_MAX_FIELD_NUMBER = 9;
        public static final int UINT32_VER_MIN_FIELD_NUMBER = 8;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 64, 72, 80, 90}, new String[]{"uint32_apppid", "uint32_instid", "uint32_platform", "uint32_open_appid", "uint32_productid", "uint32_sso_bid", "bytes_guid", "uint32_ver_min", "uint32_ver_max", "enum_device_type", "bytes_platform_name"}, new Object[]{0, 0, 0, 0, 0, 0, ByteStringMicro.EMPTY, 0, 0, 1, ByteStringMicro.EMPTY}, InstInfo.class);
        public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_platform_name = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBEnumField enum_device_type = PBField.initEnum(1);
        public final PBUInt32Field uint32_apppid = PBField.initUInt32(0);
        public final PBUInt32Field uint32_instid = PBField.initUInt32(0);
        public final PBUInt32Field uint32_open_appid = PBField.initUInt32(0);
        public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
        public final PBUInt32Field uint32_productid = PBField.initUInt32(0);
        public final PBUInt32Field uint32_sso_bid = PBField.initUInt32(0);
        public final PBUInt32Field uint32_ver_max = PBField.initUInt32(0);
        public final PBUInt32Field uint32_ver_min = PBField.initUInt32(0);
    }

    public static final class LoginSig extends MessageMicro<LoginSig> {
        public static final int BYTES_SIG_FIELD_NUMBER = 2;
        public static final int UINT32_APP_ID_FIELD_NUMBER = 3;
        public static final int UINT32_TYPE_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_type", "bytes_sig", "uint32_app_id"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, LoginSig.class);
        public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    }

    public static final class MsgDestroyTimeConfigInfo extends MessageMicro<MsgDestroyTimeConfigInfo> {
        public static final int MSG_CLIENT_TIME_CONFIG_FIELD_NUMBER = 1;
        public static final int MSG_SERVER_TIME_CONFIG_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_client_time_config", "msg_server_time_config"}, new Object[]{null, null}, MsgDestroyTimeConfigInfo.class);
        public MsgDestroyTimeInfo msg_client_time_config = new MsgDestroyTimeInfo();
        public MsgDestroyTimeInfo msg_server_time_config = new MsgDestroyTimeInfo();
    }

    public static final class MsgDestroyTimeInfo extends MessageMicro<MsgDestroyTimeInfo> {
        public static final int UINT32_SET_TIME_FIELD_NUMBER = 2;
        public static final int UINT32_SET_TIME_US_FIELD_NUMBER = 4;
        public static final int UINT32_TIME_LENGTH_FIELD_NUMBER = 1;
        public static final int UINT64_SET_QCALLID_FIELD_NUMBER = 3;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint32_time_length", "uint32_set_time", "uint64_set_qcallid", "uint32_set_time_us"}, new Object[]{0, 0, 0L, 0}, MsgDestroyTimeInfo.class);
        public final PBUInt32Field uint32_set_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_set_time_us = PBField.initUInt32(0);
        public final PBUInt32Field uint32_time_length = PBField.initUInt32(0);
        public final PBUInt64Field uint64_set_qcallid = PBField.initUInt64(0);
    }

    public static final class MsgEncryptInfo extends MessageMicro<MsgEncryptInfo> {
        public static final int BYTES_AUTH_KEY_FIELD_NUMBER = 4;
        public static final int BYTES_MSG_DIGEST_FIELD_NUMBER = 2;
        public static final int UINT32_ENCRYPT_FLAG_FIELD_NUMBER = 1;
        public static final int UINT64_AUTH_KEY_ID_FIELD_NUMBER = 3;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"uint32_encrypt_flag", "bytes_msg_digest", "uint64_auth_key_id", "bytes_auth_key"}, new Object[]{0, ByteStringMicro.EMPTY, 0L, ByteStringMicro.EMPTY}, MsgEncryptInfo.class);
        public final PBBytesField bytes_auth_key = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_msg_digest = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_encrypt_flag = PBField.initUInt32(0);
        public final PBUInt64Field uint64_auth_key_id = PBField.initUInt64(0);
    }

    public static final class MsgExtraInfo extends MessageMicro<MsgExtraInfo> {
        public static final int BYTES_FROM_UIN_NICK_FIELD_NUMBER = 12;
        public static final int BYTES_IDENTIFIER_FIELD_NUMBER = 11;
        public static final int BYTES_PUSH_TASK_ID_FIELD_NUMBER = 15;
        public static final int MSG_DESTROY_TIME_CONFIG_FIELD_NUMBER = 3;
        public static final int MSG_ENCRYPT_INFO_FIELD_NUMBER = 8;
        public static final int MSG_OFFLINE_PUSH_INFO_FIELD_NUMBER = 14;
        public static final int MSG_UIN_EXTRA_INFO_FIELD_NUMBER = 4;
        public static final int UINT32_MSG_COMPATIBILITY_TYPE_FIELD_NUMBER = 6;
        public static final int UINT32_MSG_LIFETIME_FIELD_NUMBER = 2;
        public static final int UINT32_MSG_PRIORITY_FIELD_NUMBER = 10;
        public static final int UINT32_MUTLI_INST_SYNC_FIELD_NUMBER = 9;
        public static final int UINT32_NOTIFY_FLAG_FIELD_NUMBER = 1;
        public static final int UINT32_PLACE_MSG_FIELD_NUMBER = 5;
        public static final int UINT32_SYNC_FROM_OLD_SYSTEM_FIELD_NUMBER = 7;
        public static final int UINT64_MSG_ID_CRC_FIELD_NUMBER = 16;
        public static final int UINT64_STAT_FLAG_FIELD_NUMBER = 13;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48, 56, 66, 72, 80, 90, 98, 104, 114, 122, 128}, new String[]{"uint32_notify_flag", "uint32_msg_lifetime", "msg_destroy_time_config", "msg_uin_extra_info", "uint32_place_msg", "uint32_msg_compatibility_type", "uint32_sync_from_old_system", "msg_encrypt_info", "uint32_mutli_inst_sync", "uint32_msg_priority", "bytes_identifier", "bytes_from_uin_nick", "uint64_stat_flag", "msg_offline_push_info", "bytes_push_task_id", "uint64_msg_id_crc"}, new Object[]{0, 0, null, null, 0, 0, 0, null, 0, 0, ByteStringMicro.EMPTY, ByteStringMicro.EMPTY, 0L, null, ByteStringMicro.EMPTY, 0L}, MsgExtraInfo.class);
        public final PBBytesField bytes_from_uin_nick = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_identifier = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_push_task_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public MsgDestroyTimeConfigInfo msg_destroy_time_config = new MsgDestroyTimeConfigInfo();
        public MsgEncryptInfo msg_encrypt_info = new MsgEncryptInfo();
        public OfflinePushInfo msg_offline_push_info = new OfflinePushInfo();
        public UinExtaInfo msg_uin_extra_info = new UinExtaInfo();
        public final PBUInt32Field uint32_msg_compatibility_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_msg_lifetime = PBField.initUInt32(0);
        public final PBUInt32Field uint32_msg_priority = PBField.initUInt32(0);
        public final PBUInt32Field uint32_mutli_inst_sync = PBField.initUInt32(0);
        public final PBUInt32Field uint32_notify_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_place_msg = PBField.initUInt32(0);
        public final PBUInt32Field uint32_sync_from_old_system = PBField.initUInt32(0);
        public final PBUInt64Field uint64_msg_id_crc = PBField.initUInt64(0);
        public final PBUInt64Field uint64_stat_flag = PBField.initUInt64(0);
    }

    public static final class MsgHead extends MessageMicro<MsgHead> {
        public static final int MSG_CONTENT_HEAD_FIELD_NUMBER = 1;
        public static final int MSG_EXTRA_INFO_FIELD_NUMBER = 4;
        public static final int MSG_QQLOGIN_SIG_FIELD_NUMBER = 3;
        public static final int MSG_ROUTINE_HEAD_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"msg_content_head", "msg_routine_head", "msg_qqlogin_sig", "msg_extra_info"}, new Object[]{null, null, null, null}, MsgHead.class);
        public ContentHead msg_content_head = new ContentHead();
        public MsgExtraInfo msg_extra_info = new MsgExtraInfo();
        public QQLoginSig msg_qqlogin_sig = new QQLoginSig();
        public RoutineHead msg_routine_head = new RoutineHead();
    }

    public static final class MsgTransInfo extends MessageMicro<MsgTransInfo> {
        public static final int TRANS_CODE_FIELD_NUMBER = 2;
        public static final int TRANS_MSG_FIELD_NUMBER = 3;
        public static final int TRANS_TYPE_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"trans_type", "trans_code", "trans_msg"}, new Object[]{0, 0, ByteStringMicro.EMPTY}, MsgTransInfo.class);
        public final PBUInt32Field trans_code = PBField.initUInt32(0);
        public final PBBytesField trans_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field trans_type = PBField.initUInt32(0);
    }

    public static final class MultiCastInfo extends MessageMicro<MultiCastInfo> {
        public static final int MSG_FROM_UIN_INFO_FIELD_NUMBER = 1;
        public static final int RPT_MSG_TO_UIN_INFO_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_from_uin_info", "rpt_msg_to_uin_info"}, new Object[]{null, null}, MultiCastInfo.class);
        public UinInfo msg_from_uin_info = new UinInfo();
        public final PBRepeatMessageField<UinInfo> rpt_msg_to_uin_info = PBField.initRepeatMessage(UinInfo.class);
    }

    public static final class OfflinePushInfo extends MessageMicro<OfflinePushInfo> {
        public static final int BYTES_DESC_FIELD_NUMBER = 1;
        public static final int BYTES_EXT_FIELD_NUMBER = 2;
        public static final int BYTES_SOUND_FIELD_NUMBER = 3;
        public static final int BYTES_TITLE_FIELD_NUMBER = 8;
        public static final int MSG_ANDROID_INFO_FIELD_NUMBER = 10;
        public static final int MSG_APNS_INFO_FIELD_NUMBER = 9;
        public static final int RPT_UINT32_ANDROID_CERTS_FIELD_NUMBER = 6;
        public static final int RPT_UINT32_APNS_CERTS_FIELD_NUMBER = 5;
        public static final int UINT32_NOTIFY_MODE_FIELD_NUMBER = 7;
        public static final int UINT32_PUSH_FLAG_FIELD_NUMBER = 4;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 56, 66, 74, 82}, new String[]{"bytes_desc", "bytes_ext", "bytes_sound", "uint32_push_flag", "rpt_uint32_apns_certs", "rpt_uint32_android_certs", "uint32_notify_mode", "bytes_title", "msg_apns_info", "msg_android_info"}, new Object[]{ByteStringMicro.EMPTY, ByteStringMicro.EMPTY, ByteStringMicro.EMPTY, 0, 0, 0, 0, ByteStringMicro.EMPTY, null, null}, OfflinePushInfo.class);
        public final PBBytesField bytes_desc = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_ext = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_sound = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
        public AndroidOfflineInfo msg_android_info = new AndroidOfflineInfo();
        public ApnsOfflineInfo msg_apns_info = new ApnsOfflineInfo();
        public final PBRepeatField<Integer> rpt_uint32_android_certs = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
        public final PBRepeatField<Integer> rpt_uint32_apns_certs = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
        public final PBUInt32Field uint32_notify_mode = PBField.initUInt32(0);
        public final PBUInt32Field uint32_push_flag = PBField.initUInt32(0);
    }

    public static final class PhoneInfo extends MessageMicro<PhoneInfo> {
        public static final int BYTES_NATION_FIELD_NUMBER = 1;
        public static final int BYTES_PREFIX_FIELD_NUMBER = 2;
        public static final int BYTES_UIN_MOBILE_FIELD_NUMBER = 3;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"bytes_nation", "bytes_prefix", "bytes_uin_mobile"}, new Object[]{ByteStringMicro.EMPTY, ByteStringMicro.EMPTY, ByteStringMicro.EMPTY}, PhoneInfo.class);
        public final PBBytesField bytes_nation = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_prefix = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_uin_mobile = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    public static final class QQLoginSig extends MessageMicro<QQLoginSig> {
        public static final int BYTES_SIG_FIELD_NUMBER = 3;
        public static final int UINT32_APPID_FIELD_NUMBER = 4;
        public static final int UINT32_TYPE_FIELD_NUMBER = 2;
        public static final int UINT64_UIN_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"uint64_uin", "uint32_type", "bytes_sig", "uint32_appid"}, new Object[]{0L, 0, ByteStringMicro.EMPTY, 0}, QQLoginSig.class);
        public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    }

    public static final class RedirectMsg extends MessageMicro<RedirectMsg> {
        public static final int UINT32_LAST_REDIRECT_IP_FIELD_NUMBER = 1;
        public static final int UINT32_LAST_REDIRECT_PORT_FIELD_NUMBER = 2;
        public static final int UINT32_REDIRECT_COUNT_FIELD_NUMBER = 5;
        public static final int UINT32_REDIRECT_IP_FIELD_NUMBER = 3;
        public static final int UINT32_REDIRECT_PORT_FIELD_NUMBER = 4;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{13, 16, 29, 32, 40}, new String[]{"uint32_last_redirect_ip", "uint32_last_redirect_port", "uint32_redirect_ip", "uint32_redirect_port", "uint32_redirect_count"}, new Object[]{0, 0, 0, 0, 0}, RedirectMsg.class);
        public final PBFixed32Field uint32_last_redirect_ip = PBField.initFixed32(0);
        public final PBUInt32Field uint32_last_redirect_port = PBField.initUInt32(0);
        public final PBUInt32Field uint32_redirect_count = PBField.initUInt32(0);
        public final PBFixed32Field uint32_redirect_ip = PBField.initFixed32(0);
        public final PBUInt32Field uint32_redirect_port = PBField.initUInt32(0);
    }

    public static final class RoutineHead extends MessageMicro<RoutineHead> {
        public static final int MSG_C2C_INFO_FIELD_NUMBER = 2;
        public static final int MSG_C2C_TEMP_INFO_FIELD_NUMBER = 3;
        public static final int MSG_C2S_INFO_FIELD_NUMBER = 6;
        public static final int MSG_CONF_INFO_FIELD_NUMBER = 5;
        public static final int MSG_GROUP_INFO_FIELD_NUMBER = 4;
        public static final int MSG_INST_CTRL_FIELD_NUMBER = 1;
        public static final int MSG_MULTI_CAST_INFO_FIELD_NUMBER = 7;
        public static final int MSG_TEAM_INFO_FIELD_NUMBER = 8;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66}, new String[]{"msg_inst_ctrl", "msg_c2c_info", "msg_c2c_temp_info", "msg_group_info", "msg_conf_info", "msg_c2s_info", "msg_multi_cast_info", "msg_team_info"}, new Object[]{null, null, null, null, null, null, null, null}, RoutineHead.class);
        public C2CInfo msg_c2c_info = new C2CInfo();
        public C2CTempInfo msg_c2c_temp_info = new C2CTempInfo();
        public C2SInfo msg_c2s_info = new C2SInfo();
        public ConfInfo msg_conf_info = new ConfInfo();
        public GroupInfo msg_group_info = new GroupInfo();
        public InstCtrl msg_inst_ctrl = new InstCtrl();
        public MultiCastInfo msg_multi_cast_info = new MultiCastInfo();
        public TeamInfo msg_team_info = new TeamInfo();
    }

    public static final class S2CHead extends MessageMicro<S2CHead> {
        public static final int UINT32_MSG_ID_FIELD_NUMBER = 4;
        public static final int UINT32_MSG_TYPE_FIELD_NUMBER = 2;
        public static final int UINT32_RAND_FIELD_NUMBER = 9;
        public static final int UINT32_RELAY_IP_FIELD_NUMBER = 5;
        public static final int UINT32_RELAY_PORT_FIELD_NUMBER = 6;
        public static final int UINT32_SAVE_CTRL_FIELD_NUMBER = 11;
        public static final int UINT32_SERVER_TIME_FIELD_NUMBER = 8;
        public static final int UINT32_SUB_MSGTYPE_FIELD_NUMBER = 1;
        public static final int UINT32_USER_DEF_SUB_CMD_FIELD_NUMBER = 10;
        public static final int UINT64_FROM_UIN_FIELD_NUMBER = 3;
        public static final int UINT64_TO_UIN_FIELD_NUMBER = 7;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 45, 48, 56, 64, 72, 80, 88}, new String[]{"uint32_sub_msgtype", "uint32_msg_type", "uint64_from_uin", "uint32_msg_id", "uint32_relay_ip", "uint32_relay_port", "uint64_to_uin", "uint32_server_time", "uint32_rand", "uint32_user_def_sub_cmd", "uint32_save_ctrl"}, new Object[]{0, 0, 0L, 0, 0, 0, 0L, 0, 0, 0, 0}, S2CHead.class);
        public final PBUInt32Field uint32_msg_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_rand = PBField.initUInt32(0);
        public final PBFixed32Field uint32_relay_ip = PBField.initFixed32(0);
        public final PBUInt32Field uint32_relay_port = PBField.initUInt32(0);
        public final PBUInt32Field uint32_save_ctrl = PBField.initUInt32(0);
        public final PBUInt32Field uint32_server_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_sub_msgtype = PBField.initUInt32(0);
        public final PBUInt32Field uint32_user_def_sub_cmd = PBField.initUInt32(0);
        public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
    }

    public static final class SConnHead extends MessageMicro<SConnHead> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], SConnHead.class);
    }

    public static final class ServiceHead extends MessageMicro<ServiceHead> {
        public static final int ENUM_SOURCE_SVR_TYPE_FIELD_NUMBER = 1;
        public static final int MSG_FROM_INST_FIELD_NUMBER = 4;
        public static final int MSG_SIG_FIELD_NUMBER = 6;
        public static final int STRING_SERVICE_CMD_FIELD_NUMBER = 5;
        public static final int UINT32_CLIENT_IP_FIELD_NUMBER = 7;
        public static final int UINT32_CLIENT_PORT_FIELD_NUMBER = 8;
        public static final int UINT32_SEQ_FIELD_NUMBER = 2;
        public static final int UINT64_UIN_FIELD_NUMBER = 3;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 56, 64}, new String[]{"enum_source_svr_type", "uint32_seq", "uint64_uin", "msg_from_inst", "string_service_cmd", "msg_sig", "uint32_client_ip", "uint32_client_port"}, new Object[]{1, 0, 0L, null, "", null, 0, 0}, ServiceHead.class);
        public final PBEnumField enum_source_svr_type = PBField.initEnum(1);
        public InstInfo msg_from_inst = new InstInfo();
        public Signature msg_sig = new Signature();
        public final PBStringField string_service_cmd = PBField.initString("");
        public final PBUInt32Field uint32_client_ip = PBField.initUInt32(0);
        public final PBUInt32Field uint32_client_port = PBField.initUInt32(0);
        public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    }

    public static final class Signature extends MessageMicro<Signature> {
        public static final int BYTES_SESSION_KEY_FIELD_NUMBER = 3;
        public static final int UINT32_KEY_TYPE_FIELD_NUMBER = 1;
        public static final int UINT32_SESSION_APP_ID_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_key_type", "uint32_session_app_id", "bytes_session_key"}, new Object[]{0, 0, ByteStringMicro.EMPTY}, Signature.class);
        public final PBBytesField bytes_session_key = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_key_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_session_app_id = PBField.initUInt32(0);
    }

    public static final class TeamInfo extends MessageMicro<TeamInfo> {
        public static final int BYTES_CONF_NAME_FIELD_NUMBER = 8;
        public static final int BYTES_FROM_UIN_CARD_NAME_FIELD_NUMBER = 9;
        public static final int BYTES_FROM_UIN_NICK_FIELD_NUMBER = 5;
        public static final int BYTES_TO_PHONE_NUMBER_FIELD_NUMBER = 10;
        public static final int ENUM_FROM_UIN_TYPE_FIELD_NUMBER = 3;
        public static final int ENUM_TO_UIN_TYPE_FIELD_NUMBER = 4;
        public static final int UINT32_FROM_UIN_IMAGE_ID_FIELD_NUMBER = 7;
        public static final int UINT64_FROM_UIN_FIELD_NUMBER = 1;
        public static final int UINT64_TEAM_UIN_FIELD_NUMBER = 6;
        public static final int UINT64_TO_UIN_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 66, 74, 82}, new String[]{"uint64_from_uin", "uint64_to_uin", "enum_from_uin_type", "enum_to_uin_type", "bytes_from_uin_nick", "uint64_team_uin", "uint32_from_uin_image_id", "bytes_conf_name", "bytes_from_uin_card_name", "bytes_to_phone_number"}, new Object[]{0L, 0L, 1, 1, ByteStringMicro.EMPTY, 0L, 0, ByteStringMicro.EMPTY, ByteStringMicro.EMPTY, ByteStringMicro.EMPTY}, TeamInfo.class);
        public final PBBytesField bytes_conf_name = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_from_uin_card_name = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_from_uin_nick = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_to_phone_number = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBEnumField enum_from_uin_type = PBField.initEnum(1);
        public final PBEnumField enum_to_uin_type = PBField.initEnum(1);
        public final PBUInt32Field uint32_from_uin_image_id = PBField.initUInt32(0);
        public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_team_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
    }

    public static final class TermInfo extends MessageMicro<TermInfo> {
        public static final int DEVICE_FIELD_NUMBER = 2;
        public static final int OS_FIELD_NUMBER = 3;
        public static final int PRODUCT_FIELD_NUMBER = 1;
        public static final int VERSION_ID_FIELD_NUMBER = 5;
        public static final int VERSION_NO_FIELD_NUMBER = 4;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"product", "device", "os", "version_no", "version_id"}, new Object[]{1, 1, 1, 0, 0}, TermInfo.class);
        public final PBEnumField device = PBField.initEnum(1);
        public final PBEnumField os = PBField.initEnum(1);
        public final PBEnumField product = PBField.initEnum(1);
        public final PBUInt32Field version_id = PBField.initUInt32(0);
        public final PBUInt32Field version_no = PBField.initUInt32(0);
    }

    public static final class TmpMsgToken extends MessageMicro<TmpMsgToken> {
        public static final int BYTES_BUF_FIELD_NUMBER = 1;
        public static final int UINT32_C2C_TYPE_FIELD_NUMBER = 2;
        public static final int UINT32_SERVICE_TYPE_FIELD_NUMBER = 3;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"bytes_buf", "uint32_c2c_type", "uint32_service_type"}, new Object[]{ByteStringMicro.EMPTY, 0, 0}, TmpMsgToken.class);
        public final PBBytesField bytes_buf = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_c2c_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
    }

    public static final class UinExtaInfo extends MessageMicro<UinExtaInfo> {
        public static final int BYTES_NAME_CARD_FIELD_NUMBER = 3;
        public static final int BYTES_USER_ID_FIELD_NUMBER = 6;
        public static final int RPT_MSG_APP_DEFINED_DATA_ACCOUNT_FIELD_NUMBER = 4;
        public static final int RPT_MSG_APP_DEFINED_DATA_GROUP_MEMBER_FIELD_NUMBER = 5;
        public static final int UINT32_MSG_FLAG_FIELD_NUMBER = 1;
        public static final int UINT32_ROLE_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50}, new String[]{"uint32_msg_flag", "uint32_role", "bytes_name_card", "rpt_msg_app_defined_data_account", "rpt_msg_app_defined_data_group_member", "bytes_user_id"}, new Object[]{0, 0, ByteStringMicro.EMPTY, null, null, ByteStringMicro.EMPTY}, UinExtaInfo.class);
        public final PBBytesField bytes_name_card = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_user_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatMessageField<GroupOpenAppDefinedData> rpt_msg_app_defined_data_account = PBField.initRepeatMessage(GroupOpenAppDefinedData.class);
        public final PBRepeatMessageField<GroupOpenAppDefinedData> rpt_msg_app_defined_data_group_member = PBField.initRepeatMessage(GroupOpenAppDefinedData.class);
        public final PBUInt32Field uint32_msg_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_role = PBField.initUInt32(0);
    }

    public static final class UinInfo extends MessageMicro<UinInfo> {
        public static final int ENUM_UIN_TYPE_FIELD_NUMBER = 2;
        public static final int MSG_UIN_EXTRA_INFO_FIELD_NUMBER = 3;
        public static final int UINT64_UIN_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint64_uin", "enum_uin_type", "msg_uin_extra_info"}, new Object[]{0L, 1, null}, UinInfo.class);
        public final PBEnumField enum_uin_type = PBField.initEnum(1);
        public UinExtaInfo msg_uin_extra_info = new UinExtaInfo();
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    }

    private head() {
    }
}
