package com.tencent.openqq.protocol.imsdk;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class log_report {

    public static final class ReqBody extends MessageMicro<ReqBody> {
        public static final int BYTES_ERR_MSG_FIELD_NUMBER = 2;
        public static final int BYTES_LOG_ID_FIELD_NUMBER = 3;
        public static final int UINT32_ERR_CODE_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_err_code", "bytes_err_msg", "bytes_log_id"}, new Object[]{0, ByteStringMicro.EMPTY, ByteStringMicro.EMPTY}, ReqBody.class);
        public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_log_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_err_code = PBField.initUInt32(0);
    }

    private log_report() {
    }
}
