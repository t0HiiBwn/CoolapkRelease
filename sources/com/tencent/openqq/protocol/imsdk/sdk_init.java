package com.tencent.openqq.protocol.imsdk;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.openqq.protocol.imsdk.common;
import com.tencent.openqq.protocol.imsdk.im_open_common;

public final class sdk_init {

    public static final class ReqBody extends MessageMicro<ReqBody> {
        public static final int BYTES_USER_APPID_FIELD_NUMBER = 9;
        public static final int GUID_FIELD_NUMBER = 7;
        public static final int SDKAPPID_FIELD_NUMBER = 1;
        public static final int SDKAPPTOKEN_FIELD_NUMBER = 2;
        public static final int SDKDATA_FIELD_NUMBER = 8;
        public static final int UIDTYPE_FIELD_NUMBER = 3;
        public static final int USERAPPID_FIELD_NUMBER = 4;
        public static final int USERID_FIELD_NUMBER = 5;
        public static final int USERKEY_FIELD_NUMBER = 6;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 58, 66, 74}, new String[]{"sdkappid", "sdkapptoken", "uidtype", "userappid", "userid", "userkey", "guid", "sdkdata", "bytes_user_appid"}, new Object[]{0, ByteStringMicro.EMPTY, ByteStringMicro.EMPTY, 0, ByteStringMicro.EMPTY, ByteStringMicro.EMPTY, ByteStringMicro.EMPTY, null, ByteStringMicro.EMPTY}, ReqBody.class);
        public final PBBytesField bytes_user_appid = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField guid = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field sdkappid = PBField.initUInt32(0);
        public final PBBytesField sdkapptoken = PBField.initBytes(ByteStringMicro.EMPTY);
        public im_open_common.SdkData sdkdata = new im_open_common.SdkData();
        public final PBBytesField uidtype = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field userappid = PBField.initUInt32(0);
        public final PBBytesField userid = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField userkey = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    public static final class RspBody extends MessageMicro<RspBody> {
        public static final int A2_FIELD_NUMBER = 4;
        public static final int D2KEY_FIELD_NUMBER = 6;
        public static final int D2_FIELD_NUMBER = 5;
        public static final int ENUM_CMD_ERROR_CODE_FIELD_NUMBER = 1;
        public static final int TINYID_FIELD_NUMBER = 3;
        public static final int UIN_FIELD_NUMBER = 7;
        public static final int USERID_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 56}, new String[]{"enum_cmd_error_code", "userid", "tinyid", "a2", "d2", "d2key", "uin"}, new Object[]{null, ByteStringMicro.EMPTY, 0L, ByteStringMicro.EMPTY, ByteStringMicro.EMPTY, ByteStringMicro.EMPTY, 0L}, RspBody.class);
        public final PBBytesField a2 = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField d2 = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField d2key = PBField.initBytes(ByteStringMicro.EMPTY);
        public common.CmdErrorCode enum_cmd_error_code = new common.CmdErrorCode();
        public final PBUInt64Field tinyid = PBField.initUInt64(0);
        public final PBUInt64Field uin = PBField.initUInt64(0);
        public final PBBytesField userid = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    private sdk_init() {
    }
}
