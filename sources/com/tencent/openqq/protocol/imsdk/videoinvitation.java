package com.tencent.openqq.protocol.imsdk;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class videoinvitation {

    public static final class MsgBody extends MessageMicro<MsgBody> {
        public static final int BYTES_BUFF_FIELD_NUMBER = 5;
        public static final int INT32_AUTH_TYPE_FIELD_NUMBER = 2;
        public static final int INT32_BUSS_TYPE_FIELD_NUMBER = 1;
        public static final int INT32_REQUEST_TYPE_FIELD_NUMBER = 6;
        public static final int MSG_SENDER_FIELD_NUMBER = 7;
        public static final int RPT_MSG_RECEIVER_LIST_FIELD_NUMBER = 8;
        public static final int UINT32_AUTH_ID_FIELD_NUMBER = 3;
        public static final int UINT32_SDK_APPID_FIELD_NUMBER = 4;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 58, 66}, new String[]{"int32_buss_type", "int32_auth_type", "uint32_auth_id", "uint32_sdk_appid", "bytes_buff", "int32_request_type", "msg_sender", "rpt_msg_receiver_list"}, new Object[]{0, 0, 0, 0, ByteStringMicro.EMPTY, 0, null, null}, MsgBody.class);
        public final PBBytesField bytes_buff = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBInt32Field int32_auth_type = PBField.initInt32(0);
        public final PBInt32Field int32_buss_type = PBField.initInt32(0);
        public final PBInt32Field int32_request_type = PBField.initInt32(0);
        public UserInfo msg_sender = new UserInfo();
        public final PBRepeatMessageField<UserInfo> rpt_msg_receiver_list = PBField.initRepeatMessage(UserInfo.class);
        public final PBUInt32Field uint32_auth_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_sdk_appid = PBField.initUInt32(0);
    }

    public static final class ProcResult extends MessageMicro<ProcResult> {
        public static final int INT32_RESULT_FIELD_NUMBER = 2;
        public static final int MSG_RECEIVER_INFO_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"msg_receiver_info", "int32_result"}, new Object[]{null, 0}, ProcResult.class);
        public final PBInt32Field int32_result = PBField.initInt32(0);
        public UserInfo msg_receiver_info = new UserInfo();
    }

    public static final class RsqMsgBody extends MessageMicro<RsqMsgBody> {
        public static final int RPT_MSG_RESULT_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_result"}, new Object[]{null}, RsqMsgBody.class);
        public final PBRepeatMessageField<ProcResult> rpt_msg_result = PBField.initRepeatMessage(ProcResult.class);
    }

    public static final class UserInfo extends MessageMicro<UserInfo> {
        public static final int BYTES_ACOUNTTYPE_FIELD_NUMBER = 3;
        public static final int BYTES_APPID_FIELD_NUMBER = 1;
        public static final int BYTES_OPENID_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"bytes_appid", "bytes_openid", "bytes_acounttype"}, new Object[]{ByteStringMicro.EMPTY, ByteStringMicro.EMPTY, ByteStringMicro.EMPTY}, UserInfo.class);
        public final PBBytesField bytes_acounttype = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_appid = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_openid = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    private videoinvitation() {
    }
}
