package com.tencent.openqq.protocol.imsdk;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class conn_room_comm {

    public static final class ConnRoomInfo extends MessageMicro<ConnRoomInfo> {
        public static final int UINT32_ACCESS_IP_FIELD_NUMBER = 5;
        public static final int UINT32_CENTER_IP_FIELD_NUMBER = 4;
        public static final int UINT32_GROUPCODE_FIELD_NUMBER = 1;
        public static final int UINT32_GROUP_STATE_FIELD_NUMBER = 8;
        public static final int UINT32_LOCATION_ID_FIELD_NUMBER = 6;
        public static final int UINT32_ROOM_NUM_FIELD_NUMBER = 3;
        public static final int UINT32_SHARE_TYPE_FIELD_NUMBER = 9;
        public static final int UINT32_TERMINAL_TYPE_FIELD_NUMBER = 7;
        public static final int UINT64_ACCOUNT_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72}, new String[]{"uint32_groupcode", "uint64_account", "uint32_room_num", "uint32_center_ip", "uint32_access_ip", "uint32_location_id", "uint32_terminal_type", "uint32_group_state", "uint32_share_type"}, new Object[]{0, 0L, 0, 0, 0, 0, 0, 0, 0}, ConnRoomInfo.class);
        public final PBUInt32Field uint32_access_ip = PBField.initUInt32(0);
        public final PBUInt32Field uint32_center_ip = PBField.initUInt32(0);
        public final PBUInt32Field uint32_group_state = PBField.initUInt32(0);
        public final PBUInt32Field uint32_groupcode = PBField.initUInt32(0);
        public final PBUInt32Field uint32_location_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_room_num = PBField.initUInt32(0);
        public final PBUInt32Field uint32_share_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_terminal_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_account = PBField.initUInt64(0);
    }

    public static final class TransferReq extends MessageMicro<TransferReq> {
        public static final int MSG_CONN_ROOM_INFO_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_conn_room_info"}, new Object[]{null}, TransferReq.class);
        public ConnRoomInfo msg_conn_room_info = new ConnRoomInfo();
    }

    public static final class TransferRes extends MessageMicro<TransferRes> {
        public static final int MSG_CONNED_ROOM_INFO_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_conned_room_info"}, new Object[]{null}, TransferRes.class);
        public ConnRoomInfo msg_conned_room_info = new ConnRoomInfo();
    }

    private conn_room_comm() {
    }
}
