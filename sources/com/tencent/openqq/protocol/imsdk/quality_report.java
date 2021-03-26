package com.tencent.openqq.protocol.imsdk;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class quality_report {
    public static final int DEVICE_PAD = 3;
    public static final int DEVICE_PC = 1;
    public static final int DEVICE_PHONE = 2;
    public static final int DISCONNECTED = 0;
    public static final int NETWORK_2G = 2;
    public static final int NETWORK_3G = 3;
    public static final int NETWORK_4G = 4;
    public static final int NETWORK_UNKNOWN = 6;
    public static final int NETWORK_WAP = 1;
    public static final int NETWORK_WIFI = 5;
    public static final int OS_TYPE_ANDROID = 1;
    public static final int OS_TYPE_IOS = 2;
    public static final int OS_TYPE_WINDOWS = 3;

    public static final class CommonInfo extends MessageMicro<CommonInfo> {
        public static final int MSG_DEVICE_INFO_FIELD_NUMBER = 1;
        public static final int MSG_NETWORK_INFO_FIELD_NUMBER = 3;
        public static final int MSG_SYSTEM_INFO_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"msg_device_info", "msg_system_info", "msg_network_info"}, new Object[]{null, null, null}, CommonInfo.class);
        public DeviceInfo msg_device_info = new DeviceInfo();
        public NetworkInfo msg_network_info = new NetworkInfo();
        public SystemInfo msg_system_info = new SystemInfo();
    }

    public static final class DeviceInfo extends MessageMicro<DeviceInfo> {
        public static final int ENUM_DEVICE_TYPE_FIELD_NUMBER = 1;
        public static final int STR_DEVICE_BOARD_FIELD_NUMBER = 4;
        public static final int STR_DEVICE_BRAND_FIELD_NUMBER = 2;
        public static final int STR_DEVICE_CPU_ABI_FIELD_NUMBER = 5;
        public static final int STR_DEVICE_MODEL_FIELD_NUMBER = 3;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"enum_device_type", "str_device_brand", "str_device_model", "str_device_board", "str_device_cpu_abi"}, new Object[]{1, "", "", "", ""}, DeviceInfo.class);
        public final PBEnumField enum_device_type = PBField.initEnum(1);
        public final PBStringField str_device_board = PBField.initString("");
        public final PBStringField str_device_brand = PBField.initString("");
        public final PBStringField str_device_cpu_abi = PBField.initString("");
        public final PBStringField str_device_model = PBField.initString("");
    }

    public static final class NetworkInfo extends MessageMicro<NetworkInfo> {
        public static final int ENUM_NETWORK_TYPE_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"enum_network_type"}, new Object[]{0}, NetworkInfo.class);
        public final PBEnumField enum_network_type = PBField.initEnum(0);
    }

    public static final class ReportContent extends MessageMicro<ReportContent> {
        public static final int BYTES_REPORT_DATA_FIELD_NUMBER = 2;
        public static final int UINT32_TYPE_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_type", "bytes_report_data"}, new Object[]{0, ByteStringMicro.EMPTY}, ReportContent.class);
        public final PBBytesField bytes_report_data = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    }

    public static final class ReqBody extends MessageMicro<ReqBody> {
        public static final int MSG_COMMON_INFO_FIELD_NUMBER = 5;
        public static final int MSG_REPORT_CONTENT_FIELD_NUMBER = 6;
        public static final int UINT32_SDKAPPID_FIELD_NUMBER = 1;
        public static final int UINT32_SEQ_FIELD_NUMBER = 4;
        public static final int UINT32_TIMESTAMP_FIELD_NUMBER = 3;
        public static final int UINT64_FROM_UIN_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50}, new String[]{"uint32_sdkappid", "uint64_from_uin", "uint32_timestamp", "uint32_seq", "msg_common_info", "msg_report_content"}, new Object[]{0, 0L, 0, 0, null, null}, ReqBody.class);
        public CommonInfo msg_common_info = new CommonInfo();
        public ReportContent msg_report_content = new ReportContent();
        public final PBUInt32Field uint32_sdkappid = PBField.initUInt32(0);
        public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
        public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
        public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    }

    public static final class RspBody extends MessageMicro<RspBody> {
        public static final int STR_ERR_MSG_FIELD_NUMBER = 2;
        public static final int UINT32_RESULT_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_result", "str_err_msg"}, new Object[]{0, ""}, RspBody.class);
        public final PBStringField str_err_msg = PBField.initString("");
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    }

    public static final class SystemInfo extends MessageMicro<SystemInfo> {
        public static final int ENUM_OS_TYPE_FIELD_NUMBER = 1;
        public static final int STR_OS_VERSION_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"enum_os_type", "str_os_version"}, new Object[]{1, ""}, SystemInfo.class);
        public final PBEnumField enum_os_type = PBField.initEnum(1);
        public final PBStringField str_os_version = PBField.initString("");
    }

    private quality_report() {
    }
}
