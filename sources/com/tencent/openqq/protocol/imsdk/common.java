package com.tencent.openqq.protocol.imsdk;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class common {

    public static final class CmdErrorCode extends MessageMicro<CmdErrorCode> {
        public static final int BYTES_ERR_MSG_FIELD_NUMBER = 2;
        public static final int UINT32_CODE_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_code", "bytes_err_msg"}, new Object[]{0, ByteStringMicro.EMPTY}, CmdErrorCode.class);
        public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_code = PBField.initUInt32(0);
    }

    private common() {
    }
}
