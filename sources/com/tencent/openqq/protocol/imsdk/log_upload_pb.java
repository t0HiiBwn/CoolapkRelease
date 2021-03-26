package com.tencent.openqq.protocol.imsdk;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class log_upload_pb {

    public static final class MsgBody extends MessageMicro<MsgBody> {
        public static final int BYTES_LOG_ID_FIELD_NUMBER = 4;
        public static final int BYTES_LOG_PATH_FIELD_NUMBER = 6;
        public static final int RPT_STRING_LOGTIME_FIELD_NUMBER = 2;
        public static final int RPT_STRING_TAG_FIELD_NUMBER = 3;
        public static final int RPT_UINT64_LOGTIME_FIELD_NUMBER = 1;
        public static final int UINT32_LOG_SIZE_FIELD_NUMBER = 5;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50}, new String[]{"rpt_uint64_logtime", "rpt_string_logtime", "rpt_string_tag", "bytes_log_id", "uint32_log_size", "bytes_log_path"}, new Object[]{0L, "", "", ByteStringMicro.EMPTY, 0, ByteStringMicro.EMPTY}, MsgBody.class);
        public final PBBytesField bytes_log_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_log_path = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatField<String> rpt_string_logtime = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBStringField rpt_string_tag = PBField.initString("");
        public final PBRepeatField<Long> rpt_uint64_logtime = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        public final PBUInt32Field uint32_log_size = PBField.initUInt32(0);
    }

    private log_upload_pb() {
    }
}
