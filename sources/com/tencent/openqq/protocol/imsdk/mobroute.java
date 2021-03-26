package com.tencent.openqq.protocol.imsdk;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobroute {

    public static final class MobRouteSSOList extends MessageMicro<MobRouteSSOList> {
        public static final int UINT32_TIMEOUT_FIELD_NUMBER = 1;
        public static final int VEC_HTTPLIST_FIELD_NUMBER = 3;
        public static final int VEC_TCPLIST_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_timeout", "vec_tcplist", "vec_httplist"}, new Object[]{0, null, null}, MobRouteSSOList.class);
        public final PBUInt32Field uint32_timeout = PBField.initUInt32(0);
        public final PBRepeatMessageField<MobRouteSSOListInfo> vec_httplist = PBField.initRepeatMessage(MobRouteSSOListInfo.class);
        public final PBRepeatMessageField<MobRouteSSOListInfo> vec_tcplist = PBField.initRepeatMessage(MobRouteSSOListInfo.class);
    }

    public static final class MobRouteSSOListInfo extends MessageMicro<MobRouteSSOListInfo> {
        public static final int STRING_IP_FIELD_NUMBER = 1;
        public static final int UINT32_PORT_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"string_ip", "uint32_port"}, new Object[]{"", 0}, MobRouteSSOListInfo.class);
        public final PBStringField string_ip = PBField.initString("");
        public final PBUInt32Field uint32_port = PBField.initUInt32(0);
    }

    public static final class MobRouteSSOListReq extends MessageMicro<MobRouteSSOListReq> {
        public static final int STRING_IMEI_FIELD_NUMBER = 6;
        public static final int STRING_IMSI_FIELD_NUMBER = 3;
        public static final int STRING_UIN_FIELD_NUMBER = 2;
        public static final int UINT32_APPID_FIELD_NUMBER = 5;
        public static final int UINT32_NETTYPE_FIELD_NUMBER = 4;
        public static final int UINT32_UINTYPE_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 50}, new String[]{"uint32_uintype", "string_uin", "string_imsi", "uint32_nettype", "uint32_appid", "string_imei"}, new Object[]{0, "", "", 0, 0, ""}, MobRouteSSOListReq.class);
        public final PBStringField string_imei = PBField.initString("");
        public final PBStringField string_imsi = PBField.initString("");
        public final PBStringField string_uin = PBField.initString("");
        public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
        public final PBUInt32Field uint32_nettype = PBField.initUInt32(0);
        public final PBUInt32Field uint32_uintype = PBField.initUInt32(0);
    }

    private mobroute() {
    }
}
