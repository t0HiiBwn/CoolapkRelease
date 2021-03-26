package com.tencent.openqq.protocol.imsdk;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.openqq.protocol.imsdk.common;

public final class sharp {

    public static final class RspBody extends MessageMicro<RspBody> {
        public static final int BYTES_RSP_DATA_FIELD_NUMBER = 2;
        public static final int ENUM_UIN_TYPE_FOR_INVITE_FIELD_NUMBER = 4;
        public static final int MSG_CMD_ERROR_CODE_FIELD_NUMBER = 1;
        public static final int UINT64_UIN_FOR_INVITE_FIELD_NUMBER = 3;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"msg_cmd_error_code", "bytes_rsp_data", "uint64_uin_for_invite", "enum_uin_type_for_invite"}, new Object[]{null, ByteStringMicro.EMPTY, 0L, 1}, RspBody.class);
        public final PBBytesField bytes_rsp_data = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBEnumField enum_uin_type_for_invite = PBField.initEnum(1);
        public common.CmdErrorCode msg_cmd_error_code = new common.CmdErrorCode();
        public final PBUInt64Field uint64_uin_for_invite = PBField.initUInt64(0);
    }

    private sharp() {
    }
}
