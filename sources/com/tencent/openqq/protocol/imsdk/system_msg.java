package com.tencent.openqq.protocol.imsdk;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.openqq.protocol.imsdk.common;
import com.tencent.openqq.protocol.imsdk.head;

public final class system_msg {

    public static final class InviteQQToMultiSharp extends MessageMicro<InviteQQToMultiSharp> {
        public static final int RPT_UINT64_UIN_LIST_FIELD_NUMBER = 2;
        public static final int UINT64_CONF_CODE_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_conf_code", "rpt_uint64_uin_list"}, new Object[]{0L, 0L}, InviteQQToMultiSharp.class);
        public final PBRepeatField<Long> rpt_uint64_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        public final PBUInt64Field uint64_conf_code = PBField.initUInt64(0);
    }

    public static final class ReqBody extends MessageMicro<ReqBody> {
        public static final int MSG_INVITE_QQ_INFO_FIELD_NUMBER = 3;
        public static final int MSG_MSG_HEAD_FIELD_NUMBER = 1;
        public static final int UINT32_OP_TYPE_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"msg_msg_head", "uint32_op_type", "msg_invite_qq_info"}, new Object[]{null, 0, null}, ReqBody.class);
        public InviteQQToMultiSharp msg_invite_qq_info = new InviteQQToMultiSharp();
        public head.MsgHead msg_msg_head = new head.MsgHead();
        public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
    }

    public static final class RspBody extends MessageMicro<RspBody> {
        public static final int MSG_CMD_ERROR_CODE_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_cmd_error_code"}, new Object[]{null}, RspBody.class);
        public common.CmdErrorCode msg_cmd_error_code = new common.CmdErrorCode();
    }

    private system_msg() {
    }
}
