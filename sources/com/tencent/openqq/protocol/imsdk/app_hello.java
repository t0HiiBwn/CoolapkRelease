package com.tencent.openqq.protocol.imsdk;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class app_hello {

    public static final class ReqBody extends MessageMicro<ReqBody> {
        public static final int UINT32_APP_STATUS_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_app_status"}, new Object[]{0}, ReqBody.class);
        public final PBUInt32Field uint32_app_status = PBField.initUInt32(0);
    }

    public static final class RspBody extends MessageMicro<RspBody> {
        public static final int STR_ERR_MSG_FIELD_NUMBER = 2;
        public static final int UINT32_ERROR_CODE_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_error_code", "str_err_msg"}, new Object[]{0, ""}, RspBody.class);
        public final PBStringField str_err_msg = PBField.initString("");
        public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
    }

    private app_hello() {
    }
}
