package com.tencent.openqq.protocol.imsdk;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msgcomm {

    public static final class MsgElement extends MessageMicro<MsgElement> {
        public static final int MSGCONTENT_FIELD_NUMBER = 2;
        public static final int MSGTYPE_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"MsgType", "MsgContent"}, new Object[]{"", ""}, MsgElement.class);
        public final PBStringField MsgContent = PBField.initString("");
        public final PBStringField MsgType = PBField.initString("");
    }

    public static final class MsgInfo extends MessageMicro<MsgInfo> {
        public static final int FROMOPENID_FIELD_NUMBER = 1;
        public static final int FROMTINYID_FIELD_NUMBER = 2;
        public static final int MSGREADED_FIELD_NUMBER = 8;
        public static final int MSGSEQID_FIELD_NUMBER = 6;
        public static final int MSGTIMESTAMP_FIELD_NUMBER = 5;
        public static final int MSG_FIELD_NUMBER = 7;
        public static final int TOOPENID_FIELD_NUMBER = 3;
        public static final int TOTINYID_FIELD_NUMBER = 4;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 48, 58, 64}, new String[]{"FromOpenid", "FromTinyid", "ToOpenid", "ToTinyid", "MsgTimestamp", "MsgSeqId", "Msg", "MsgReaded"}, new Object[]{"", 0L, "", 0L, 0, 0L, null, 0}, MsgInfo.class);
        public final PBStringField FromOpenid = PBField.initString("");
        public final PBUInt64Field FromTinyid = PBField.initUInt64(0);
        public final PBRepeatMessageField<MsgElement> Msg = PBField.initRepeatMessage(MsgElement.class);
        public final PBUInt32Field MsgReaded = PBField.initUInt32(0);
        public final PBUInt64Field MsgSeqId = PBField.initUInt64(0);
        public final PBUInt32Field MsgTimestamp = PBField.initUInt32(0);
        public final PBStringField ToOpenid = PBField.initString("");
        public final PBUInt64Field ToTinyid = PBField.initUInt64(0);
    }

    public static final class UserInfo extends MessageMicro<UserInfo> {
        public static final int HEADURL_FIELD_NUMBER = 3;
        public static final int NICKNAME_FIELD_NUMBER = 4;
        public static final int OPENID_FIELD_NUMBER = 1;
        public static final int REMARK_FIELD_NUMBER = 5;
        public static final int TINYID_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42}, new String[]{"Openid", "Tinyid", "HeadURL", "NickName", "Remark"}, new Object[]{"", 0L, "", "", ""}, UserInfo.class);
        public final PBStringField HeadURL = PBField.initString("");
        public final PBStringField NickName = PBField.initString("");
        public final PBStringField Openid = PBField.initString("");
        public final PBStringField Remark = PBField.initString("");
        public final PBUInt64Field Tinyid = PBField.initUInt64(0);
    }

    private msgcomm() {
    }
}
