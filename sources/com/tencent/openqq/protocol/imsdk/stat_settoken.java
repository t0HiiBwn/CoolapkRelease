package com.tencent.openqq.protocol.imsdk;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.openqq.protocol.imsdk.common;

public final class stat_settoken {

    public static final class ReqBody extends MessageMicro<ReqBody> {
        public static final int BYTES_TOKEN_ID_FIELD_NUMBER = 1;
        public static final int STR_EMPTY_SOUND_FIELD_NUMBER = 10;
        public static final int STR_EXTENDS_FIELD_NUMBER = 2;
        public static final int STR_PUSH_SOUND_FIELD_NUMBER = 9;
        public static final int STR_VIDEO_SOUND_FIELD_NUMBER = 11;
        public static final int UINT32_BUSIID_FIELD_NUMBER = 12;
        public static final int UINT32_ENTER_VERSION_FIELD_NUMBER = 6;
        public static final int UINT32_INST_TYPE_FIELD_NUMBER = 13;
        public static final int UINT32_ONLINE_PUSH_FIELD_NUMBER = 5;
        public static final int UINT32_PHOTO_PUSH_FIELD_NUMBER = 7;
        public static final int UINT32_PUSH_MSG_FIELD_NUMBER = 3;
        public static final int UINT32_PUSH_WITHOUT_CONTENT_FIELD_NUMBER = 8;
        public static final int UINT32_PUSH_ZONE_FIELD_NUMBER = 4;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56, 64, 74, 82, 90, 96, 104}, new String[]{"bytes_token_id", "str_extends", "uint32_push_msg", "uint32_push_zone", "uint32_online_push", "uint32_enter_version", "uint32_photo_push", "uint32_push_without_content", "str_push_sound", "str_empty_sound", "str_video_sound", "uint32_busiid", "uint32_inst_type"}, new Object[]{ByteStringMicro.EMPTY, "", 0, 0, 0, 0, 0, 0, "", "", "", 0, 0}, ReqBody.class);
        public final PBBytesField bytes_token_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBStringField str_empty_sound = PBField.initString("");
        public final PBStringField str_extends = PBField.initString("");
        public final PBStringField str_push_sound = PBField.initString("");
        public final PBStringField str_video_sound = PBField.initString("");
        public final PBUInt32Field uint32_busiid = PBField.initUInt32(0);
        public final PBUInt32Field uint32_enter_version = PBField.initUInt32(0);
        public final PBUInt32Field uint32_inst_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_online_push = PBField.initUInt32(0);
        public final PBUInt32Field uint32_photo_push = PBField.initUInt32(0);
        public final PBUInt32Field uint32_push_msg = PBField.initUInt32(0);
        public final PBUInt32Field uint32_push_without_content = PBField.initUInt32(0);
        public final PBUInt32Field uint32_push_zone = PBField.initUInt32(0);
    }

    public static final class RspBody extends MessageMicro<RspBody> {
        public static final int BYTES_TOKEN_ID_FIELD_NUMBER = 3;
        public static final int ENUM_CMD_ERROR_CODE_FIELD_NUMBER = 1;
        public static final int STR_ERRMSG_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"enum_cmd_error_code", "str_errmsg", "bytes_token_id"}, new Object[]{null, "", ByteStringMicro.EMPTY}, RspBody.class);
        public final PBBytesField bytes_token_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public common.CmdErrorCode enum_cmd_error_code = new common.CmdErrorCode();
        public final PBStringField str_errmsg = PBField.initString("");
    }

    private stat_settoken() {
    }
}
