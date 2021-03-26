package com.tencent.openqq.protocol.imsdk;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class conn_room_sig {

    public static final class ConnRoomSig extends MessageMicro<ConnRoomSig> {
        public static final int STR_CONNED_THIRD_ACCOUNT_FIELD_NUMBER = 4;
        public static final int STR_THIRD_ACCOUNT_FIELD_NUMBER = 2;
        public static final int UINT32_CONNED_GROUPCODE_FIELD_NUMBER = 3;
        public static final int UINT32_CREATE_TIME_FIELD_NUMBER = 5;
        public static final int UINT32_EXPIRE_TIME_FIELD_NUMBER = 6;
        public static final int UINT32_GROUPCODE_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48}, new String[]{"uint32_groupcode", "str_third_account", "uint32_conned_groupcode", "str_conned_third_account", "uint32_create_time", "uint32_expire_time"}, new Object[]{0, "", 0, "", 0, 0}, ConnRoomSig.class);
        public final PBStringField str_conned_third_account = PBField.initString("");
        public final PBStringField str_third_account = PBField.initString("");
        public final PBUInt32Field uint32_conned_groupcode = PBField.initUInt32(0);
        public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_expire_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_groupcode = PBField.initUInt32(0);
    }

    private conn_room_sig() {
    }
}
