package com.tencent.openqq.protocol.imsdk;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.openqq.protocol.imsdk.common;
import com.tencent.openqq.protocol.imsdk.msg_common;

public final class msg_push {

    public static final class ReqBody extends MessageMicro<ReqBody> {
        public static final int BYTES_SESSION_DATA_FIELD_NUMBER = 2;
        public static final int MSG_MSG_FIELD_NUMBER = 1;
        public static final int UINT32_FLAG_FIELD_NUMBER = 3;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"msg_msg", "bytes_session_data", "uint32_flag"}, new Object[]{null, ByteStringMicro.EMPTY, 0}, ReqBody.class);
        public final PBBytesField bytes_session_data = PBField.initBytes(ByteStringMicro.EMPTY);
        public msg_common.Msg msg_msg = new msg_common.Msg();
        public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    }

    public static final class RspBody extends MessageMicro<RspBody> {
        public static final int BYTES_SESSION_DATA_FIELD_NUMBER = 2;
        public static final int MSG_CMD_ERROR_CODE_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_cmd_error_code", "bytes_session_data"}, new Object[]{null, ByteStringMicro.EMPTY}, RspBody.class);
        public final PBBytesField bytes_session_data = PBField.initBytes(ByteStringMicro.EMPTY);
        public common.CmdErrorCode msg_cmd_error_code = new common.CmdErrorCode();
    }

    private msg_push() {
    }
}
