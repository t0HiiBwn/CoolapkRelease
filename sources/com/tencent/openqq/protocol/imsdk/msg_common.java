package com.tencent.openqq.protocol.imsdk;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.openqq.protocol.imsdk.head;
import com.tencent.openqq.protocol.imsdk.msg;

public final class msg_common {
    public static final int SYNC_BEGIN = 0;
    public static final int SYNC_CLIENT_OUT = 4;
    public static final int SYNC_CONTINUE = 1;
    public static final int SYNC_END = 2;
    public static final int SYNC_FINI = 3;

    public static final class InnerMsg extends MessageMicro<InnerMsg> {
        public static final int MSG_HEAD_FIELD_NUMBER = 1;
        public static final int MSG_MSG_BODY_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_head", "msg_msg_body"}, new Object[]{null, null}, InnerMsg.class);
        public head.Head msg_head = new head.Head();
        public msg.MsgBody msg_msg_body = new msg.MsgBody();
    }

    public static final class Msg extends MessageMicro<Msg> {
        public static final int MSG_MSG_BODY_FIELD_NUMBER = 2;
        public static final int MSG_MSG_HEAD_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_msg_head", "msg_msg_body"}, new Object[]{null, null}, Msg.class);
        public msg.MsgBody msg_msg_body = new msg.MsgBody();
        public head.MsgHead msg_msg_head = new head.MsgHead();
    }

    public static final class MsgKey extends MessageMicro<MsgKey> {
        public static final int UINT32_RAND_FIELD_NUMBER = 4;
        public static final int UINT32_SEQ_FIELD_NUMBER = 3;
        public static final int UINT64_FROM_UIN_FIELD_NUMBER = 1;
        public static final int UINT64_TO_UIN_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint64_from_uin", "uint64_to_uin", "uint32_seq", "uint32_rand"}, new Object[]{0L, 0L, 0, 0}, MsgKey.class);
        public final PBUInt32Field uint32_rand = PBField.initUInt32(0);
        public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
        public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
    }

    private msg_common() {
    }
}
