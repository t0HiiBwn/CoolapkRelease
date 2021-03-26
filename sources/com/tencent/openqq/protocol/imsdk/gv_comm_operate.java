package com.tencent.openqq.protocol.imsdk;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.openqq.protocol.imsdk.conn_room_comm;
import com.tencent.openqq.protocol.imsdk.conn_room_sig;

public final class gv_comm_operate {
    public static final int AUDIO = 1;
    public static final int ENCODE_FLV = 2;
    public static final int ENCODE_HLS = 1;
    public static final int ENCODE_HLS_AND_RTMP = 6;
    public static final int ENCODE_RAW = 4;
    public static final int ENCODE_RTMP = 5;
    public static final int RATE_TYPE_550 = 10;
    public static final int RATE_TYPE_900 = 20;
    public static final int RATE_TYPE_ORIGINAL = 0;
    public static final int RECORD_FLV = 2;
    public static final int RECORD_FLV_MP4 = 6;
    public static final int RECORD_HLS = 1;
    public static final int RECORD_HLS_FLV = 3;
    public static final int RECORD_HLS_FLV_MP4 = 7;
    public static final int RECORD_HLS_MP4 = 5;
    public static final int RECORD_MP4 = 4;
    public static final int VIDEO = 0;

    public static final class ConnRoomReq_0xa extends MessageMicro<ConnRoomReq_0xa> {
        public static final int MSG_CONN_ROOM_SIG_FIELD_NUMBER = 3;
        public static final int MSG_TRANSFER_REQ_FIELD_NUMBER = 4;
        public static final int UINT32_CONNED_GROUPCODE_FIELD_NUMBER = 1;
        public static final int UINT64_CONNED_ACCOUNT_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uint32_conned_groupcode", "uint64_conned_account", "msg_conn_room_sig", "msg_transfer_req"}, new Object[]{0, 0L, null, null}, ConnRoomReq_0xa.class);
        public conn_room_sig.ConnRoomSig msg_conn_room_sig = new conn_room_sig.ConnRoomSig();
        public conn_room_comm.TransferReq msg_transfer_req = new conn_room_comm.TransferReq();
        public final PBUInt32Field uint32_conned_groupcode = PBField.initUInt32(0);
        public final PBUInt64Field uint64_conned_account = PBField.initUInt64(0);
    }

    public static final class ConnRoomRsp_0xa extends MessageMicro<ConnRoomRsp_0xa> {
        public static final int MSG_TRANSFER_RES_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_transfer_res"}, new Object[]{null}, ConnRoomRsp_0xa.class);
        public conn_room_comm.TransferRes msg_transfer_res = new conn_room_comm.TransferRes();
    }

    public static final class CookieInfo extends MessageMicro<CookieInfo> {
        public static final int UINT32_REQ_IP_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_req_ip"}, new Object[]{0}, CookieInfo.class);
        public final PBUInt32Field uint32_req_ip = PBField.initUInt32(0);
    }

    public static final class GVCommOprHead extends MessageMicro<GVCommOprHead> {
        public static final int BYTES_COOKIE_BUFF_FIELD_NUMBER = 22;
        public static final int RPT_RELAY_INFO_FIELD_NUMBER = 7;
        public static final int RPT_TO_ACCOUNT_FIELD_NUMBER = 25;
        public static final int RPT_TO_OPENID_FIELD_NUMBER = 21;
        public static final int RPT_TO_UIN_FIELD_NUMBER = 12;
        public static final int STR_AV_TOKEN_FIELD_NUMBER = 11;
        public static final int STR_CLIENT_VERSION_FIELD_NUMBER = 24;
        public static final int STR_ERROR_MSG_FIELD_NUMBER = 9;
        public static final int STR_OPENID_FIELD_NUMBER = 20;
        public static final int UINT32_AUTH_KEY_FIELD_NUMBER = 5;
        public static final int UINT32_AUTH_TYPE_FIELD_NUMBER = 4;
        public static final int UINT32_BUSS_TYPE_FIELD_NUMBER = 3;
        public static final int UINT32_RESULT_FIELD_NUMBER = 8;
        public static final int UINT32_SDK_APPID_FIELD_NUMBER = 10;
        public static final int UINT32_SEQ_FIELD_NUMBER = 2;
        public static final int UINT32_SUB_CMD_FIELD_NUMBER = 1;
        public static final int UINT32_TERMINAL_TYPE_FIELD_NUMBER = 23;
        public static final int UINT64_UIN_FIELD_NUMBER = 6;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 64, 74, 80, 90, 96, 162, 170, 178, 184, 194, 200}, new String[]{"uint32_sub_cmd", "uint32_seq", "uint32_buss_type", "uint32_auth_type", "uint32_auth_key", "uint64_uin", "rpt_relay_info", "uint32_result", "str_error_msg", "uint32_sdk_appid", "str_av_token", "rpt_to_uin", "str_openid", "rpt_to_openid", "bytes_cookie_buff", "uint32_terminal_type", "str_client_version", "rpt_to_Account"}, new Object[]{0, 0, 0, 0, 0, 0L, null, 0, "", 0, "", 0L, "", "", ByteStringMicro.EMPTY, 0, "", 0L}, GVCommOprHead.class);
        public final PBBytesField bytes_cookie_buff = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatMessageField<RelayInfo> rpt_relay_info = PBField.initRepeatMessage(RelayInfo.class);
        public final PBRepeatField<Long> rpt_to_Account = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        public final PBRepeatField<String> rpt_to_openid = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBRepeatField<Long> rpt_to_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        public final PBStringField str_av_token = PBField.initString("");
        public final PBStringField str_client_version = PBField.initString("");
        public final PBStringField str_error_msg = PBField.initString("");
        public final PBStringField str_openid = PBField.initString("");
        public final PBUInt32Field uint32_auth_key = PBField.initUInt32(0);
        public final PBUInt32Field uint32_auth_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_buss_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBUInt32Field uint32_sdk_appid = PBField.initUInt32(0);
        public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
        public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
        public final PBUInt32Field uint32_terminal_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    }

    public static final class LiveUrl extends MessageMicro<LiveUrl> {
        public static final int RATE_TYPE_FIELD_NUMBER = 3;
        public static final int STRING_PLAY_URL_FIELD_NUMBER = 2;
        public static final int UINT32_TYPE_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_type", "string_play_url", "rate_type"}, new Object[]{0, "", 0}, LiveUrl.class);
        public final PBEnumField rate_type = PBField.initEnum(0);
        public final PBStringField string_play_url = PBField.initString("");
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    }

    public static final class RelayInfo extends MessageMicro<RelayInfo> {
        public static final int BYTES_CONTEXT_FIELD_NUMBER = 3;
        public static final int UINT32_CLIENT_IP_FIELD_NUMBER = 1;
        public static final int UINT32_CLIENT_PORT_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_client_ip", "uint32_client_port", "bytes_context"}, new Object[]{0, 0, ByteStringMicro.EMPTY}, RelayInfo.class);
        public final PBBytesField bytes_context = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_client_ip = PBField.initUInt32(0);
        public final PBUInt32Field uint32_client_port = PBField.initUInt32(0);
    }

    public static final class ReqBody extends MessageMicro<ReqBody> {
        public static final int REQ_0X101_FIELD_NUMBER = 101;
        public static final int REQ_0X1_FIELD_NUMBER = 1;
        public static final int REQ_0X2_FIELD_NUMBER = 2;
        public static final int REQ_0X3_FIELD_NUMBER = 3;
        public static final int REQ_0X4_FIELD_NUMBER = 4;
        public static final int REQ_0X5_FIELD_NUMBER = 5;
        public static final int REQ_0X6_FIELD_NUMBER = 6;
        public static final int REQ_0X7_FIELD_NUMBER = 7;
        public static final int REQ_0X8_FIELD_NUMBER = 8;
        public static final int REQ_0X9_FIELD_NUMBER = 9;
        public static final int REQ_0XA_FIELD_NUMBER = 10;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 810}, new String[]{"req_0x1", "req_0x2", "req_0x3", "req_0x4", "req_0x5", "req_0x6", "req_0x7", "req_0x8", "req_0x9", "req_0xa", "req_0x101"}, new Object[]{null, null, null, null, null, null, null, null, null, null, null}, ReqBody.class);
        public SubReq_0x1 req_0x1 = new SubReq_0x1();
        public SubReq_0x101 req_0x101 = new SubReq_0x101();
        public SubReq_0x2 req_0x2 = new SubReq_0x2();
        public SubReq_0x3 req_0x3 = new SubReq_0x3();
        public SubReq_0x4 req_0x4 = new SubReq_0x4();
        public SubReq_0x5 req_0x5 = new SubReq_0x5();
        public SubReq_0x6 req_0x6 = new SubReq_0x6();
        public SubReq_0x7 req_0x7 = new SubReq_0x7();
        public SpeedTestReq_0x8 req_0x8 = new SpeedTestReq_0x8();
        public SpeedResultReportReq_0x9 req_0x9 = new SpeedResultReportReq_0x9();
        public ConnRoomReq_0xa req_0xa = new ConnRoomReq_0xa();
    }

    public static final class RspBody extends MessageMicro<RspBody> {
        public static final int RSP_0X101_FIELD_NUMBER = 101;
        public static final int RSP_0X1_FIELD_NUMBER = 1;
        public static final int RSP_0X2_FIELD_NUMBER = 2;
        public static final int RSP_0X3_FIELD_NUMBER = 3;
        public static final int RSP_0X4_FIELD_NUMBER = 4;
        public static final int RSP_0X5_FIELD_NUMBER = 5;
        public static final int RSP_0X6_FIELD_NUMBER = 6;
        public static final int RSP_0X7_FIELD_NUMBER = 7;
        public static final int RSP_0X8_FIELD_NUMBER = 8;
        public static final int RSP_0X9_FIELD_NUMBER = 9;
        public static final int RSP_0XA_FIELD_NUMBER = 10;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 810}, new String[]{"rsp_0x1", "rsp_0x2", "rsp_0x3", "rsp_0x4", "rsp_0x5", "rsp_0x6", "rsp_0x7", "rsp_0x8", "rsp_0x9", "rsp_0xa", "rsp_0x101"}, new Object[]{null, null, null, null, null, null, null, null, null, null, null}, RspBody.class);
        public SubRsp_0x1 rsp_0x1 = new SubRsp_0x1();
        public SubRsp_0x101 rsp_0x101 = new SubRsp_0x101();
        public SubRsp_0x2 rsp_0x2 = new SubRsp_0x2();
        public SubRsp_0x3 rsp_0x3 = new SubRsp_0x3();
        public SubRsp_0x4 rsp_0x4 = new SubRsp_0x4();
        public SubRsp_0x5 rsp_0x5 = new SubRsp_0x5();
        public SubRsp_0x6 rsp_0x6 = new SubRsp_0x6();
        public SubRsp_0x7 rsp_0x7 = new SubRsp_0x7();
        public SpeedTestRsp_0x8 rsp_0x8 = new SpeedTestRsp_0x8();
        public SpeedResultReportRsp_0x9 rsp_0x9 = new SpeedResultReportRsp_0x9();
        public ConnRoomRsp_0xa rsp_0xa = new ConnRoomRsp_0xa();
    }

    public static final class SpeedAccessInf extends MessageMicro<SpeedAccessInf> {
        public static final int ACCESS_COUNTRY_FIELD_NUMBER = 4;
        public static final int ACCESS_IP_FIELD_NUMBER = 1;
        public static final int ACCESS_ISP_FIELD_NUMBER = 3;
        public static final int ACCESS_PORT_FIELD_NUMBER = 2;
        public static final int ACCESS_PROV_FIELD_NUMBER = 5;
        public static final int TEST_CNT_FIELD_NUMBER = 6;
        public static final int TEST_GAP_FIELD_NUMBER = 7;
        public static final int TEST_PKG_SIZE_FIELD_NUMBER = 9;
        public static final int TEST_TIMEOUT_FIELD_NUMBER = 8;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72}, new String[]{"access_ip", "access_port", "access_isp", "access_country", "access_prov", "test_cnt", "test_gap", "test_timeout", "test_pkg_size"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0}, SpeedAccessInf.class);
        public final PBUInt32Field access_country = PBField.initUInt32(0);
        public final PBUInt32Field access_ip = PBField.initUInt32(0);
        public final PBUInt32Field access_isp = PBField.initUInt32(0);
        public final PBUInt32Field access_port = PBField.initUInt32(0);
        public final PBUInt32Field access_prov = PBField.initUInt32(0);
        public final PBUInt32Field test_cnt = PBField.initUInt32(0);
        public final PBUInt32Field test_gap = PBField.initUInt32(0);
        public final PBUInt32Field test_pkg_size = PBField.initUInt32(0);
        public final PBUInt32Field test_timeout = PBField.initUInt32(0);
    }

    public static final class SpeedResultReportRsp_0x9 extends MessageMicro<SpeedResultReportRsp_0x9> {
        public static final int TEST_ID_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"test_id"}, new Object[]{0L}, SpeedResultReportRsp_0x9.class);
        public final PBUInt64Field test_id = PBField.initUInt64(0);
    }

    public static final class SpeedTestHeadPkt extends MessageMicro<SpeedTestHeadPkt> {
        public static final int ACCESS_CLIENT_IP_FIELD_NUMBER = 7;
        public static final int BUSS_TYPE_FIELD_NUMBER = 6;
        public static final int SDKAPPID_FIELD_NUMBER = 3;
        public static final int SEQ_FIELD_NUMBER = 4;
        public static final int TEST_ID_FIELD_NUMBER = 1;
        public static final int TIMESTAMP_FIELD_NUMBER = 5;
        public static final int UIN_FIELD_NUMBER = 2;
        public static final int UP_SEQ_FIELD_NUMBER = 8;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64}, new String[]{"test_id", "uin", "sdkappid", "seq", "timestamp", "buss_type", "access_client_ip", "up_seq"}, new Object[]{0L, 0L, 0, 0, 0L, 0, 0, 0}, SpeedTestHeadPkt.class);
        public final PBUInt32Field access_client_ip = PBField.initUInt32(0);
        public final PBUInt32Field buss_type = PBField.initUInt32(0);
        public final PBUInt32Field sdkappid = PBField.initUInt32(0);
        public final PBUInt32Field seq = PBField.initUInt32(0);
        public final PBUInt64Field test_id = PBField.initUInt64(0);
        public final PBUInt64Field timestamp = PBField.initUInt64(0);
        public final PBUInt64Field uin = PBField.initUInt64(0);
        public final PBRepeatField<Integer> up_seq = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    }

    public static final class SpeedTestReq_0x8 extends MessageMicro<SpeedTestReq_0x8> {
        public static final int CALL_TYPE_FIELD_NUMBER = 2;
        public static final int CLIENT_TYPE_FIELD_NUMBER = 4;
        public static final int NET_TYPE_FIELD_NUMBER = 3;
        public static final int OS_TYPE_FIELD_NUMBER = 7;
        public static final int OS_VERSION_FIELD_NUMBER = 8;
        public static final int ROOMID_FIELD_NUMBER = 1;
        public static final int SUPPORT_TYPE_FIELD_NUMBER = 5;
        public static final int TEST_PURPOSE_FIELD_NUMBER = 6;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 66}, new String[]{"roomid", "call_type", "net_type", "client_type", "support_type", "test_purpose", "os_type", "os_version"}, new Object[]{0L, 0L, 0, 0, 0, 0, 0, ByteStringMicro.EMPTY}, SpeedTestReq_0x8.class);
        public final PBUInt64Field call_type = PBField.initUInt64(0);
        public final PBUInt32Field client_type = PBField.initUInt32(0);
        public final PBUInt32Field net_type = PBField.initUInt32(0);
        public final PBUInt32Field os_type = PBField.initUInt32(0);
        public final PBBytesField os_version = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt64Field roomid = PBField.initUInt64(0);
        public final PBUInt32Field support_type = PBField.initUInt32(0);
        public final PBUInt32Field test_purpose = PBField.initUInt32(0);
    }

    public static final class SpeedTestResult extends MessageMicro<SpeedTestResult> {
        public static final int ACCESS_IP_FIELD_NUMBER = 1;
        public static final int ACCESS_PORT_FIELD_NUMBER = 2;
        public static final int AVG_RTT_FIELD_NUMBER = 6;
        public static final int CLIENTIP_FIELD_NUMBER = 3;
        public static final int DW_CONS_LOSS0_FIELD_NUMBER = 31;
        public static final int DW_CONS_LOSS1_FIELD_NUMBER = 32;
        public static final int DW_CONS_LOSS2_FIELD_NUMBER = 33;
        public static final int DW_CONS_LOSS3_FIELD_NUMBER = 34;
        public static final int DW_CONS_LOSSB3_FIELD_NUMBER = 35;
        public static final int DW_DISORDER_FIELD_NUMBER = 37;
        public static final int DW_SEQ_FIELD_NUMBER = 39;
        public static final int JITTER0_20_FIELD_NUMBER = 16;
        public static final int JITTER100_200_FIELD_NUMBER = 19;
        public static final int JITTER200_300_FIELD_NUMBER = 20;
        public static final int JITTER20_50_FIELD_NUMBER = 17;
        public static final int JITTER300_500_FIELD_NUMBER = 21;
        public static final int JITTER500_800_FIELD_NUMBER = 22;
        public static final int JITTER50_100_FIELD_NUMBER = 18;
        public static final int JITTER800_FIELD_NUMBER = 23;
        public static final int MAX_RTT_FIELD_NUMBER = 7;
        public static final int MIN_RTT_FIELD_NUMBER = 8;
        public static final int RTT0_50_FIELD_NUMBER = 9;
        public static final int RTT1000_FIELD_NUMBER = 15;
        public static final int RTT100_200_FIELD_NUMBER = 11;
        public static final int RTT200_300_FIELD_NUMBER = 12;
        public static final int RTT300_700_FIELD_NUMBER = 13;
        public static final int RTT50_100_FIELD_NUMBER = 10;
        public static final int RTT700_1000_FIELD_NUMBER = 14;
        public static final int T1_DWLOSS_FIELD_NUMBER = 25;
        public static final int T1_UPLOSS_FIELD_NUMBER = 24;
        public static final int TEST_CNT_FIELD_NUMBER = 4;
        public static final int TEST_PKG_SIZE_FIELD_NUMBER = 5;
        public static final int UP_CONS_LOSS0_FIELD_NUMBER = 26;
        public static final int UP_CONS_LOSS1_FIELD_NUMBER = 27;
        public static final int UP_CONS_LOSS2_FIELD_NUMBER = 28;
        public static final int UP_CONS_LOSS3_FIELD_NUMBER = 29;
        public static final int UP_CONS_LOSSB3_FIELD_NUMBER = 30;
        public static final int UP_DISORDER_FIELD_NUMBER = 36;
        public static final int UP_SEQ_FIELD_NUMBER = 38;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 136, 144, 152, 160, 168, 176, 184, 192, 200, 208, 216, 224, 232, 240, 248, 256, 264, 272, 280, 288, 296, 304, 312}, new String[]{"access_ip", "access_port", "clientip", "test_cnt", "test_pkg_size", "avg_rtt", "max_rtt", "min_rtt", "rtt0_50", "rtt50_100", "rtt100_200", "rtt200_300", "rtt300_700", "rtt700_1000", "rtt1000", "jitter0_20", "jitter20_50", "jitter50_100", "jitter100_200", "jitter200_300", "jitter300_500", "jitter500_800", "jitter800", "t1_uploss", "t1_dwloss", "up_cons_loss0", "up_cons_loss1", "up_cons_loss2", "up_cons_loss3", "up_cons_lossb3", "dw_cons_loss0", "dw_cons_loss1", "dw_cons_loss2", "dw_cons_loss3", "dw_cons_lossb3", "up_disorder", "dw_disorder", "up_seq", "dw_seq"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, SpeedTestResult.class);
        public final PBUInt32Field access_ip = PBField.initUInt32(0);
        public final PBUInt32Field access_port = PBField.initUInt32(0);
        public final PBUInt32Field avg_rtt = PBField.initUInt32(0);
        public final PBUInt32Field clientip = PBField.initUInt32(0);
        public final PBUInt32Field dw_cons_loss0 = PBField.initUInt32(0);
        public final PBUInt32Field dw_cons_loss1 = PBField.initUInt32(0);
        public final PBUInt32Field dw_cons_loss2 = PBField.initUInt32(0);
        public final PBUInt32Field dw_cons_loss3 = PBField.initUInt32(0);
        public final PBUInt32Field dw_cons_lossb3 = PBField.initUInt32(0);
        public final PBUInt32Field dw_disorder = PBField.initUInt32(0);
        public final PBRepeatField<Integer> dw_seq = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
        public final PBUInt32Field jitter0_20 = PBField.initUInt32(0);
        public final PBUInt32Field jitter100_200 = PBField.initUInt32(0);
        public final PBUInt32Field jitter200_300 = PBField.initUInt32(0);
        public final PBUInt32Field jitter20_50 = PBField.initUInt32(0);
        public final PBUInt32Field jitter300_500 = PBField.initUInt32(0);
        public final PBUInt32Field jitter500_800 = PBField.initUInt32(0);
        public final PBUInt32Field jitter50_100 = PBField.initUInt32(0);
        public final PBUInt32Field jitter800 = PBField.initUInt32(0);
        public final PBUInt32Field max_rtt = PBField.initUInt32(0);
        public final PBUInt32Field min_rtt = PBField.initUInt32(0);
        public final PBUInt32Field rtt0_50 = PBField.initUInt32(0);
        public final PBUInt32Field rtt1000 = PBField.initUInt32(0);
        public final PBUInt32Field rtt100_200 = PBField.initUInt32(0);
        public final PBUInt32Field rtt200_300 = PBField.initUInt32(0);
        public final PBUInt32Field rtt300_700 = PBField.initUInt32(0);
        public final PBUInt32Field rtt50_100 = PBField.initUInt32(0);
        public final PBUInt32Field rtt700_1000 = PBField.initUInt32(0);
        public final PBUInt32Field t1_dwloss = PBField.initUInt32(0);
        public final PBUInt32Field t1_uploss = PBField.initUInt32(0);
        public final PBUInt32Field test_cnt = PBField.initUInt32(0);
        public final PBUInt32Field test_pkg_size = PBField.initUInt32(0);
        public final PBUInt32Field up_cons_loss0 = PBField.initUInt32(0);
        public final PBUInt32Field up_cons_loss1 = PBField.initUInt32(0);
        public final PBUInt32Field up_cons_loss2 = PBField.initUInt32(0);
        public final PBUInt32Field up_cons_loss3 = PBField.initUInt32(0);
        public final PBUInt32Field up_cons_lossb3 = PBField.initUInt32(0);
        public final PBUInt32Field up_disorder = PBField.initUInt32(0);
        public final PBRepeatField<Integer> up_seq = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    }

    public static final class SpeedTestRsp_0x8 extends MessageMicro<SpeedTestRsp_0x8> {
        public static final int ACCESS_LIST_FIELD_NUMBER = 5;
        public static final int CLIENT_IP_FIELD_NUMBER = 1;
        public static final int RESULT_FIELD_NUMBER = 3;
        public static final int TEST_ID_FIELD_NUMBER = 2;
        public static final int TEST_TYPE_FIELD_NUMBER = 4;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"client_ip", "test_id", "result", "test_type", "access_list"}, new Object[]{0, 0L, 0, 0, null}, SpeedTestRsp_0x8.class);
        public final PBRepeatMessageField<SpeedAccessInf> access_list = PBField.initRepeatMessage(SpeedAccessInf.class);
        public final PBUInt32Field client_ip = PBField.initUInt32(0);
        public final PBSInt32Field result = PBField.initSInt32(0);
        public final PBUInt64Field test_id = PBField.initUInt64(0);
        public final PBUInt32Field test_type = PBField.initUInt32(0);
    }

    public static final class SubReq_0x1 extends MessageMicro<SubReq_0x1> {
        public static final int RPT_UINS_FIELD_NUMBER = 3;
        public static final int UINT32_DELETE_TYPE_FIELD_NUMBER = 2;
        public static final int UINT32_ROOM_NUM_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_room_num", "uint32_delete_type", "rpt_uins"}, new Object[]{0, 0, 0L}, SubReq_0x1.class);
        public final PBRepeatField<Long> rpt_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        public final PBUInt32Field uint32_delete_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_room_num = PBField.initUInt32(0);
    }

    public static final class SubReq_0x101 extends MessageMicro<SubReq_0x101> {
        public static final int BYTES_BUFF_FIELD_NUMBER = 3;
        public static final int UINT32_CLIENT_IP_FIELD_NUMBER = 1;
        public static final int UINT32_CLIENT_PORT_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_client_ip", "uint32_client_port", "bytes_buff"}, new Object[]{0, 0, ByteStringMicro.EMPTY}, SubReq_0x101.class);
        public final PBBytesField bytes_buff = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_client_ip = PBField.initUInt32(0);
        public final PBUInt32Field uint32_client_port = PBField.initUInt32(0);
    }

    public static final class SubReq_0x2 extends MessageMicro<SubReq_0x2> {
        public static final int RPT_UINS_FIELD_NUMBER = 4;
        public static final int STR_PRIVILEGE_MAP_FIELD_NUMBER = 5;
        public static final int UINT32_ROOM_NUM_FIELD_NUMBER = 1;
        public static final int UINT32_SET_PRIV_TYPE_FIELD_NUMBER = 3;
        public static final int UINT64_PRIVILEGE_MAP_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"uint32_room_num", "uint64_privilege_map", "uint32_set_priv_type", "rpt_uins", "str_privilege_map"}, new Object[]{0, 0L, 0, 0L, ""}, SubReq_0x2.class);
        public final PBRepeatField<Long> rpt_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        public final PBStringField str_privilege_map = PBField.initString("");
        public final PBUInt32Field uint32_room_num = PBField.initUInt32(0);
        public final PBUInt32Field uint32_set_priv_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_privilege_map = PBField.initUInt64(0);
    }

    public static final class SubReq_0x3 extends MessageMicro<SubReq_0x3> {
        public static final int UINT32_OP_TYPE_FIELD_NUMBER = 2;
        public static final int UINT32_RECV_IP_FIELD_NUMBER = 3;
        public static final int UINT32_RECV_PORT_FIELD_NUMBER = 4;
        public static final int UINT32_ROOM_NUM_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint32_room_num", "uint32_op_type", "uint32_recv_ip", "uint32_recv_port"}, new Object[]{0, 0, 0, 0}, SubReq_0x3.class);
        public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_recv_ip = PBField.initUInt32(0);
        public final PBUInt32Field uint32_recv_port = PBField.initUInt32(0);
        public final PBUInt32Field uint32_room_num = PBField.initUInt32(0);
    }

    public static final class SubReq_0x4 extends MessageMicro<SubReq_0x4> {
        public static final int UINT32_ROOM_NUM_FIELD_NUMBER = 1;
        public static final int UINT64_USER_UIN_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_room_num", "uint64_user_uin"}, new Object[]{0, 0L}, SubReq_0x4.class);
        public final PBUInt32Field uint32_room_num = PBField.initUInt32(0);
        public final PBUInt64Field uint64_user_uin = PBField.initUInt64(0);
    }

    public static final class SubReq_0x5 extends MessageMicro<SubReq_0x5> {
        public static final int STRING_FILE_NAME_FIELD_NUMBER = 3;
        public static final int STRING_TAGS_FIELD_NUMBER = 4;
        public static final int UINT32_CLASSID_FIELD_NUMBER = 5;
        public static final int UINT32_ISSCREENSHOT_FIELD_NUMBER = 7;
        public static final int UINT32_ISTRANSCODE_FIELD_NUMBER = 6;
        public static final int UINT32_ISWATERMARK_FIELD_NUMBER = 8;
        public static final int UINT32_OPER_FIELD_NUMBER = 1;
        public static final int UINT32_RECORD_APPID_FIELD_NUMBER = 11;
        public static final int UINT32_RECORD_DATA_TYPE_FIELD_NUMBER = 10;
        public static final int UINT32_RECORD_TYPE_FIELD_NUMBER = 12;
        public static final int UINT32_SDK_TYPE_FIELD_NUMBER = 9;
        public static final int UINT32_SEQ_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48, 56, 64, 72, 80, 88, 96}, new String[]{"uint32_oper", "uint32_seq", "string_file_name", "string_tags", "uint32_classid", "uint32_IsTransCode", "uint32_IsScreenShot", "uint32_IsWaterMark", "uint32_sdk_type", "uint32_record_data_type", "uint32_record_appid", "uint32_record_type"}, new Object[]{0, 0, "", "", 0, 0, 0, 0, 0, 0, 0, 0}, SubReq_0x5.class);
        public final PBStringField string_file_name = PBField.initString("");
        public final PBRepeatField<String> string_tags = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBUInt32Field uint32_IsScreenShot = PBField.initUInt32(0);
        public final PBUInt32Field uint32_IsTransCode = PBField.initUInt32(0);
        public final PBUInt32Field uint32_IsWaterMark = PBField.initUInt32(0);
        public final PBUInt32Field uint32_classid = PBField.initUInt32(0);
        public final PBUInt32Field uint32_oper = PBField.initUInt32(0);
        public final PBUInt32Field uint32_record_appid = PBField.initUInt32(0);
        public final PBUInt32Field uint32_record_data_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_record_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_sdk_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    }

    public static final class SubReq_0x6 extends MessageMicro<SubReq_0x6> {
        public static final int RPT_RATE_TYPE_FIELD_NUMBER = 13;
        public static final int STR_CHANNEL_DESCRIBE_FIELD_NUMBER = 5;
        public static final int STR_CHANNEL_NAME_FIELD_NUMBER = 4;
        public static final int STR_PLAYER_PWD_FIELD_NUMBER = 6;
        public static final int STR_STREAM_ID_FIELD_NUMBER = 19;
        public static final int UINT32_LIVE_CODE_FIELD_NUMBER = 2;
        public static final int UINT32_OPER_FIELD_NUMBER = 1;
        public static final int UINT32_PUSH_DATA_TYPE_FIELD_NUMBER = 8;
        public static final int UINT32_PUSH_DURATION_FIELD_NUMBER = 10;
        public static final int UINT32_PUSH_FLAG_FIELD_NUMBER = 20;
        public static final int UINT32_PUSH_IP_FIELD_NUMBER = 15;
        public static final int UINT32_PUSH_PORT_FIELD_NUMBER = 16;
        public static final int UINT32_RECORD_TYPE_FIELD_NUMBER = 14;
        public static final int UINT32_RESET_MOD_FIELD_NUMBER = 18;
        public static final int UINT32_ROOM_ID_FIELD_NUMBER = 17;
        public static final int UINT32_SDK_TYPE_FIELD_NUMBER = 3;
        public static final int UINT32_TAPE_FLAG_FIELD_NUMBER = 9;
        public static final int UINT32_WATERMARK_FLAG_FIELD_NUMBER = 11;
        public static final int UINT32_WATERMARK_ID_FIELD_NUMBER = 12;
        public static final int UINT64_CHANNEL_ID_FIELD_NUMBER = 7;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 136, 144, 154, 160}, new String[]{"uint32_oper", "uint32_live_code", "uint32_sdk_type", "str_channel_name", "str_channel_describe", "str_player_pwd", "uint64_channel_id", "uint32_push_data_type", "uint32_tape_flag", "uint32_push_duration", "uint32_watermark_flag", "uint32_watermark_id", "rpt_rate_type", "uint32_record_type", "uint32_push_ip", "uint32_push_port", "uint32_room_id", "uint32_reset_mod", "str_stream_id", "uint32_push_flag"}, new Object[]{0, 0, 0, "", "", "", 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", 0}, SubReq_0x6.class);
        public final PBRepeatField<Integer> rpt_rate_type = PBField.initRepeat(PBEnumField.__repeatHelper__);
        public final PBStringField str_channel_describe = PBField.initString("");
        public final PBStringField str_channel_name = PBField.initString("");
        public final PBStringField str_player_pwd = PBField.initString("");
        public final PBStringField str_stream_id = PBField.initString("");
        public final PBUInt32Field uint32_live_code = PBField.initUInt32(0);
        public final PBUInt32Field uint32_oper = PBField.initUInt32(0);
        public final PBUInt32Field uint32_push_data_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_push_duration = PBField.initUInt32(0);
        public final PBUInt32Field uint32_push_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_push_ip = PBField.initUInt32(0);
        public final PBUInt32Field uint32_push_port = PBField.initUInt32(0);
        public final PBUInt32Field uint32_record_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_reset_mod = PBField.initUInt32(0);
        public final PBUInt32Field uint32_room_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_sdk_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_tape_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_watermark_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_watermark_id = PBField.initUInt32(0);
        public final PBRepeatField<Long> uint64_channel_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    }

    public static final class SubReq_0x7 extends MessageMicro<SubReq_0x7> {
        public static final int UINT32_REQUEST_TYPE_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_request_type"}, new Object[]{0}, SubReq_0x7.class);
        public final PBUInt32Field uint32_request_type = PBField.initUInt32(0);
    }

    public static final class SubRsp_0x1 extends MessageMicro<SubRsp_0x1> {
        public static final int STR_ERR_MSG_FIELD_NUMBER = 2;
        public static final int UINT32_RESULT_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_result", "str_err_msg"}, new Object[]{0, ""}, SubRsp_0x1.class);
        public final PBStringField str_err_msg = PBField.initString("");
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    }

    public static final class SubRsp_0x101 extends MessageMicro<SubRsp_0x101> {
        public static final int INT32_RESULT_FIELD_NUMBER = 1;
        public static final int STR_ERR_MSG_FIELD_NUMBER = 2;
        public static final int UINT64_PRIVILEGE_MAP_FIELD_NUMBER = 3;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"int32_result", "str_err_msg", "uint64_privilege_map"}, new Object[]{0, "", 0L}, SubRsp_0x101.class);
        public final PBInt32Field int32_result = PBField.initInt32(0);
        public final PBStringField str_err_msg = PBField.initString("");
        public final PBUInt64Field uint64_privilege_map = PBField.initUInt64(0);
    }

    public static final class SubRsp_0x2 extends MessageMicro<SubRsp_0x2> {
        public static final int STR_ERR_MSG_FIELD_NUMBER = 2;
        public static final int UINT32_RESULT_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_result", "str_err_msg"}, new Object[]{0, ""}, SubRsp_0x2.class);
        public final PBStringField str_err_msg = PBField.initString("");
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    }

    public static final class SubRsp_0x3 extends MessageMicro<SubRsp_0x3> {
        public static final int STR_ERR_MSG_FIELD_NUMBER = 2;
        public static final int UINT32_RESULT_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_result", "str_err_msg"}, new Object[]{0, ""}, SubRsp_0x3.class);
        public final PBStringField str_err_msg = PBField.initString("");
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    }

    public static final class SubRsp_0x4 extends MessageMicro<SubRsp_0x4> {
        public static final int RPT_USER_INFO_FIELD_NUMBER = 3;
        public static final int STR_ERR_MSG_FIELD_NUMBER = 2;
        public static final int UINT32_RESULT_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_result", "str_err_msg", "rpt_user_info"}, new Object[]{0, "", null}, SubRsp_0x4.class);
        public final PBRepeatMessageField<UserInfo> rpt_user_info = PBField.initRepeatMessage(UserInfo.class);
        public final PBStringField str_err_msg = PBField.initString("");
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    }

    public static final class SubRsp_0x5 extends MessageMicro<SubRsp_0x5> {
        public static final int STR_ERRORINFO_FIELD_NUMBER = 2;
        public static final int STR_FILEID_FIELD_NUMBER = 3;
        public static final int UINT32_RESULT_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_result", "str_errorinfo", "str_fileID"}, new Object[]{0, "", ""}, SubRsp_0x5.class);
        public final PBStringField str_errorinfo = PBField.initString("");
        public final PBRepeatField<String> str_fileID = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    }

    public static final class SubRsp_0x6 extends MessageMicro<SubRsp_0x6> {
        public static final int MSG_LIVE_URL_FIELD_NUMBER = 2;
        public static final int STR_ERRORINFO_FIELD_NUMBER = 3;
        public static final int UINT32_RESULT_FIELD_NUMBER = 1;
        public static final int UINT32_TAPE_TASK_ID_FIELD_NUMBER = 5;
        public static final int UINT64_CHANNEL_ID_FIELD_NUMBER = 4;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, new String[]{"uint32_result", "msg_live_url", "str_errorinfo", "uint64_channel_id", "uint32_tape_task_id"}, new Object[]{0, null, "", 0L, 0}, SubRsp_0x6.class);
        public final PBRepeatMessageField<LiveUrl> msg_live_url = PBField.initRepeatMessage(LiveUrl.class);
        public final PBStringField str_errorinfo = PBField.initString("");
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBUInt32Field uint32_tape_task_id = PBField.initUInt32(0);
        public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0);
    }

    public static final class SubRsp_0x7 extends MessageMicro<SubRsp_0x7> {
        public static final int RPT_SHARE_USER_INFO_FIELD_NUMBER = 3;
        public static final int STR_ERR_MSG_FIELD_NUMBER = 2;
        public static final int UINT32_RESULT_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_result", "str_err_msg", "rpt_share_user_info"}, new Object[]{0, "", null}, SubRsp_0x7.class);
        public final PBRepeatMessageField<UserInfo> rpt_share_user_info = PBField.initRepeatMessage(UserInfo.class);
        public final PBStringField str_err_msg = PBField.initString("");
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    }

    public static final class UserInfo extends MessageMicro<UserInfo> {
        public static final int UINT32_TERMINAL_FLAG_FIELD_NUMBER = 2;
        public static final int UINT64_UIN_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_uin", "uint32_terminal_flag"}, new Object[]{0L, 0}, UserInfo.class);
        public final PBUInt32Field uint32_terminal_flag = PBField.initUInt32(0);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    }

    private gv_comm_operate() {
    }

    public static final class SpeedResultReportReq_0x9 extends MessageMicro<SpeedResultReportReq_0x9> {
        public static final int ACCESS_IP_FIELD_NUMBER = 16;
        public static final int ACCESS_PORT_FIELD_NUMBER = 17;
        public static final int CALL_TYPE_FIELD_NUMBER = 11;
        public static final int CLIENT_IP_FIELD_NUMBER = 10;
        public static final int CLIENT_TYPE_FIELD_NUMBER = 4;
        public static final int LATITUDE_FIELD_NUMBER = 9;
        public static final int LONGITUDE_FIELD_NUMBER = 8;
        public static final int NET_CHANGECNT_FIELD_NUMBER = 15;
        public static final int NET_NAME_FIELD_NUMBER = 6;
        public static final int NET_TYPE_FIELD_NUMBER = 5;
        public static final int RESULTS_FIELD_NUMBER = 14;
        public static final int ROOMID_FIELD_NUMBER = 3;
        public static final int SDKAPPID_FIELD_NUMBER = 12;
        public static final int TEST_ID_FIELD_NUMBER = 1;
        public static final int TEST_TIME_FIELD_NUMBER = 2;
        public static final int TEST_TYPE_FIELD_NUMBER = 13;
        public static final int WIFI_NAME_FIELD_NUMBER = 7;
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt32Field access_ip = PBField.initUInt32(0);
        public final PBUInt32Field access_port = PBField.initUInt32(0);
        public final PBUInt32Field call_type = PBField.initUInt32(0);
        public final PBUInt32Field client_ip = PBField.initUInt32(0);
        public final PBUInt32Field client_type = PBField.initUInt32(0);
        public final PBDoubleField latitude = PBField.initDouble(0.0d);
        public final PBDoubleField longitude = PBField.initDouble(0.0d);
        public final PBUInt32Field net_changecnt = PBField.initUInt32(0);
        public final PBBytesField net_name = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field net_type = PBField.initUInt32(0);
        public final PBRepeatMessageField<SpeedTestResult> results = PBField.initRepeatMessage(SpeedTestResult.class);
        public final PBUInt64Field roomid = PBField.initUInt64(0);
        public final PBUInt32Field sdkappid = PBField.initUInt32(0);
        public final PBUInt64Field test_id = PBField.initUInt64(0);
        public final PBUInt64Field test_time = PBField.initUInt64(0);
        public final PBUInt32Field test_type = PBField.initUInt32(0);
        public final PBBytesField wifi_name = PBField.initBytes(ByteStringMicro.EMPTY);

        static {
            Double valueOf = Double.valueOf(0.0d);
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 58, 65, 73, 80, 88, 96, 104, 114, 120, 128, 136}, new String[]{"test_id", "test_time", "roomid", "client_type", "net_type", "net_name", "wifi_name", "longitude", "latitude", "client_ip", "call_type", "sdkappid", "test_type", "results", "net_changecnt", "access_ip", "access_port"}, new Object[]{0L, 0L, 0L, 0, 0, ByteStringMicro.EMPTY, ByteStringMicro.EMPTY, valueOf, valueOf, 0, 0, 0, 0, null, 0, 0, 0}, SpeedResultReportReq_0x9.class);
        }
    }
}
