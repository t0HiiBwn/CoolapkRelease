package com.tencent.openqq.protocol.imsdk;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class report_im_push {

    public static final class ReqBody extends MessageMicro<ReqBody> {
        public static final int BYTES_TASK_ID_FIELD_NUMBER = 4;
        public static final int UINT32_CLIENT_TYPE_FIELD_NUMBER = 6;
        public static final int UINT32_RAND_FIELD_NUMBER = 3;
        public static final int UINT32_REPORT_TYPE_FIELD_NUMBER = 5;
        public static final int UINT32_SEQ_FIELD_NUMBER = 2;
        public static final int UINT64_TINYID_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48}, new String[]{"uint64_tinyid", "uint32_seq", "uint32_rand", "bytes_task_id", "uint32_report_type", "uint32_client_type"}, new Object[]{0L, 0, 0, ByteStringMicro.EMPTY, 0, 0}, ReqBody.class);
        public final PBBytesField bytes_task_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_rand = PBField.initUInt32(0);
        public final PBUInt32Field uint32_report_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
        public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0);
    }

    public static final class RspBody extends MessageMicro<RspBody> {
        public static final int UINT32_ERROR_CODE_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_error_code"}, new Object[]{0}, RspBody.class);
        public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
    }

    private report_im_push() {
    }
}
