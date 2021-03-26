package com.tencent.openqq.protocol.imsdk;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.openqq.protocol.imsdk.common;

public final class stat_set_pushsound {

    public static final class Config extends MessageMicro<Config> {
        public static final int BYTES_C2C_SOUND_FIELD_NUMBER = 2;
        public static final int BYTES_GRP_SOUND_FIELD_NUMBER = 3;
        public static final int BYTES_VIDEO_SOUND_FIELD_NUMBER = 4;
        public static final int UINT32_OPENPUSH_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint32_openpush", "bytes_c2c_sound", "bytes_grp_sound", "bytes_video_sound"}, new Object[]{0, ByteStringMicro.EMPTY, ByteStringMicro.EMPTY, ByteStringMicro.EMPTY}, Config.class);
        public final PBBytesField bytes_c2c_sound = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_grp_sound = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField bytes_video_sound = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_openpush = PBField.initUInt32(0);
    }

    public static final class ReqBody extends MessageMicro<ReqBody> {
        public static final int MSG_CONFIG_FIELD_NUMBER = 2;
        public static final int UINT32_PLATFORM_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_platform", "msg_config"}, new Object[]{0, null}, ReqBody.class);
        public Config msg_config = new Config();
        public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
    }

    public static final class RspBody extends MessageMicro<RspBody> {
        public static final int ENUM_CMD_ERROR_CODE_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"enum_cmd_error_code"}, new Object[]{null}, RspBody.class);
        public common.CmdErrorCode enum_cmd_error_code = new common.CmdErrorCode();
    }

    private stat_set_pushsound() {
    }
}
