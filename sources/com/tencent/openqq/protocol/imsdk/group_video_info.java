package com.tencent.openqq.protocol.imsdk;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_video_info {
    public static final int CMD_C2S_VIDEO_PUSH_REQ = 318;
    public static final int CMD_C2S_VIDEO_PUSH_RES = 319;
    public static final int CMD_C2S_VIDEO_RECORD_REQ = 316;
    public static final int CMD_C2S_VIDEO_RECORD_RES = 317;
    public static final int CMD_UNKNOWN = 0;
    public static final int ENCODE_FLV = 2;
    public static final int ENCODE_HLS = 1;
    public static final int ENCODE_RAW = 4;
    public static final int ENCODE_RTMP = 5;

    public static final class GroupVideoInfoBodyReq extends MessageMicro<GroupVideoInfoBodyReq> {
        public static final int MSG_PUSH_REQ_FIELD_NUMBER = 7;
        public static final int MSG_RECORD_REQ_FIELD_NUMBER = 6;
        public static final int UINT32_AUTH_KEY_FIELD_NUMBER = 3;
        public static final int UINT32_AUTH_TYPE_FIELD_NUMBER = 2;
        public static final int UINT32_BUSS_TYPE_FIELD_NUMBER = 1;
        public static final int UINT32_SDK_APPID_FIELD_NUMBER = 5;
        public static final int UINT64_UIN_FIELD_NUMBER = 4;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 58}, new String[]{"uint32_buss_type", "uint32_auth_type", "uint32_auth_key", "uint64_uin", "uint32_sdk_appid", "msg_record_req", "msg_push_req"}, new Object[]{0, 0, 0, 0L, 0, null, null}, GroupVideoInfoBodyReq.class);
        public VideoPushReq msg_push_req = new VideoPushReq();
        public VideoRecordReq msg_record_req = new VideoRecordReq();
        public final PBUInt32Field uint32_auth_key = PBField.initUInt32(0);
        public final PBUInt32Field uint32_auth_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_buss_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_sdk_appid = PBField.initUInt32(0);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    }

    public static final class GroupVideoInfoBodyRes extends MessageMicro<GroupVideoInfoBodyRes> {
        public static final int MSG_PUSH_RES_FIELD_NUMBER = 2;
        public static final int MSG_RECORD_RES_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_record_res", "msg_push_res"}, new Object[]{null, null}, GroupVideoInfoBodyRes.class);
        public VideoPushRes msg_push_res = new VideoPushRes();
        public VideoRecordRes msg_record_res = new VideoRecordRes();
    }

    public static final class LiveUrl extends MessageMicro<LiveUrl> {
        public static final int STRING_PLAY_URL_FIELD_NUMBER = 2;
        public static final int UINT32_TYPE_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_type", "string_play_url"}, new Object[]{0, ""}, LiveUrl.class);
        public final PBStringField string_play_url = PBField.initString("");
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    }

    public static final class VideoPushReq extends MessageMicro<VideoPushReq> {
        public static final int STR_CHANNEL_DESCRIBE_FIELD_NUMBER = 5;
        public static final int STR_CHANNEL_NAME_FIELD_NUMBER = 4;
        public static final int STR_PLAYER_PWD_FIELD_NUMBER = 6;
        public static final int UINT32_LIVE_CODE_FIELD_NUMBER = 2;
        public static final int UINT32_OPER_FIELD_NUMBER = 1;
        public static final int UINT32_SDK_TYPE_FIELD_NUMBER = 3;
        public static final int UINT64_CHANNEL_ID_FIELD_NUMBER = 7;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 56}, new String[]{"uint32_oper", "uint32_live_code", "uint32_sdk_type", "str_channel_name", "str_channel_describe", "str_player_pwd", "uint64_channel_id"}, new Object[]{0, 0, 0, "", "", "", 0L}, VideoPushReq.class);
        public final PBStringField str_channel_describe = PBField.initString("");
        public final PBStringField str_channel_name = PBField.initString("");
        public final PBStringField str_player_pwd = PBField.initString("");
        public final PBUInt32Field uint32_live_code = PBField.initUInt32(0);
        public final PBUInt32Field uint32_oper = PBField.initUInt32(0);
        public final PBUInt32Field uint32_sdk_type = PBField.initUInt32(0);
        public final PBRepeatField<Long> uint64_channel_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    }

    public static final class VideoPushRes extends MessageMicro<VideoPushRes> {
        public static final int MSG_LIVE_URL_FIELD_NUMBER = 2;
        public static final int STR_ERRORINFO_FIELD_NUMBER = 3;
        public static final int UINT32_RESULT_FIELD_NUMBER = 1;
        public static final int UINT64_CHANNEL_ID_FIELD_NUMBER = 4;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uint32_result", "msg_live_url", "str_errorinfo", "uint64_channel_id"}, new Object[]{0, null, "", 0L}, VideoPushRes.class);
        public final PBRepeatMessageField<LiveUrl> msg_live_url = PBField.initRepeatMessage(LiveUrl.class);
        public final PBStringField str_errorinfo = PBField.initString("");
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0);
    }

    public static final class VideoRecordReq extends MessageMicro<VideoRecordReq> {
        public static final int STRING_FILE_NAME_FIELD_NUMBER = 3;
        public static final int STRING_TAGS_FIELD_NUMBER = 4;
        public static final int UINT32_CLASSID_FIELD_NUMBER = 5;
        public static final int UINT32_ISSCREENSHOT_FIELD_NUMBER = 7;
        public static final int UINT32_ISTRANSCODE_FIELD_NUMBER = 6;
        public static final int UINT32_ISWATERMARK_FIELD_NUMBER = 8;
        public static final int UINT32_OPER_FIELD_NUMBER = 1;
        public static final int UINT32_SDK_TYPE_FIELD_NUMBER = 9;
        public static final int UINT32_SEQ_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48, 56, 64, 72}, new String[]{"uint32_oper", "uint32_seq", "string_file_name", "string_tags", "uint32_classid", "uint32_IsTransCode", "uint32_IsScreenShot", "uint32_IsWaterMark", "uint32_sdk_type"}, new Object[]{0, 0, "", "", 0, 0, 0, 0, 0}, VideoRecordReq.class);
        public final PBStringField string_file_name = PBField.initString("");
        public final PBRepeatField<String> string_tags = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBUInt32Field uint32_IsScreenShot = PBField.initUInt32(0);
        public final PBUInt32Field uint32_IsTransCode = PBField.initUInt32(0);
        public final PBUInt32Field uint32_IsWaterMark = PBField.initUInt32(0);
        public final PBUInt32Field uint32_classid = PBField.initUInt32(0);
        public final PBUInt32Field uint32_oper = PBField.initUInt32(0);
        public final PBUInt32Field uint32_sdk_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    }

    public static final class VideoRecordRes extends MessageMicro<VideoRecordRes> {
        public static final int STR_ERRORINFO_FIELD_NUMBER = 2;
        public static final int STR_FILEID_FIELD_NUMBER = 3;
        public static final int UINT32_RESULT_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_result", "str_errorinfo", "str_fileID"}, new Object[]{0, "", ""}, VideoRecordRes.class);
        public final PBStringField str_errorinfo = PBField.initString("");
        public final PBRepeatField<String> str_fileID = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    }

    private group_video_info() {
    }
}
