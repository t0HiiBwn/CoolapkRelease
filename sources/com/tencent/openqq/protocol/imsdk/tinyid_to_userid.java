package com.tencent.openqq.protocol.imsdk;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.openqq.protocol.imsdk.common;
import com.tencent.openqq.protocol.imsdk.im_open_common;

public final class tinyid_to_userid {

    public static final class ReqBody extends MessageMicro<ReqBody> {
        public static final int SDKDATA_FIELD_NUMBER = 1;
        public static final int TINYID_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"sdkdata", "tinyid"}, new Object[]{null, 0L}, ReqBody.class);
        public im_open_common.SdkData sdkdata = new im_open_common.SdkData();
        public final PBRepeatField<Long> tinyid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    }

    public static final class RspBody extends MessageMicro<RspBody> {
        public static final int ENUM_CMD_ERROR_CODE_FIELD_NUMBER = 1;
        public static final int USERID_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"enum_cmd_error_code", "userid"}, new Object[]{null, null}, RspBody.class);
        public common.CmdErrorCode enum_cmd_error_code = new common.CmdErrorCode();
        public final PBRepeatMessageField<im_open_common.IMUserId> userid = PBField.initRepeatMessage(im_open_common.IMUserId.class);
    }

    private tinyid_to_userid() {
    }
}
