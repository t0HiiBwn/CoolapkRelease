package com.tencent.openqq.protocol.imsdk;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.openqq.protocol.imsdk.common;
import com.tencent.openqq.protocol.imsdk.msg_common;

public final class general {

    public static final class ReqBody extends MessageMicro<ReqBody> {
        public static final int MSG_MSG_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_msg"}, new Object[]{null}, ReqBody.class);
        public msg_common.Msg msg_msg = new msg_common.Msg();
    }

    public static final class RspBody extends MessageMicro<RspBody> {
        public static final int BYTES_RSP_DATA_FIELD_NUMBER = 2;
        public static final int MSG_CMD_ERROR_CODE_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_cmd_error_code", "bytes_rsp_data"}, new Object[]{null, ByteStringMicro.EMPTY}, RspBody.class);
        public final PBBytesField bytes_rsp_data = PBField.initBytes(ByteStringMicro.EMPTY);
        public common.CmdErrorCode msg_cmd_error_code = new common.CmdErrorCode();
    }

    private general() {
    }
}
