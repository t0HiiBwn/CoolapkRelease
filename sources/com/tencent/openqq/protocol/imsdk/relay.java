package com.tencent.openqq.protocol.imsdk;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.openqq.protocol.imsdk.common;
import com.tencent.openqq.protocol.imsdk.im_open_common;

public final class relay {

    public static final class ReqBody extends MessageMicro<ReqBody> {
        public static final int REQBODY_FIELD_NUMBER = 2;
        public static final int SDKDATA_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"sdkdata", "reqbody"}, new Object[]{null, ByteStringMicro.EMPTY}, ReqBody.class);
        public final PBBytesField reqbody = PBField.initBytes(ByteStringMicro.EMPTY);
        public im_open_common.SdkData sdkdata = new im_open_common.SdkData();
    }

    public static final class RspBody extends MessageMicro<RspBody> {
        public static final int ENUM_CMD_ERROR_CODE_FIELD_NUMBER = 1;
        public static final int RSPBODY_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"enum_cmd_error_code", "rspbody"}, new Object[]{null, ByteStringMicro.EMPTY}, RspBody.class);
        public common.CmdErrorCode enum_cmd_error_code = new common.CmdErrorCode();
        public final PBBytesField rspbody = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    private relay() {
    }
}
