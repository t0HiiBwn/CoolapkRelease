package com.tencent.openqq.protocol.imsdk;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_open_common {

    public static final class FriendInfo extends MessageMicro<FriendInfo> {
        public static final int AVATARURL_FIELD_NUMBER = 4;
        public static final int CITY_FIELD_NUMBER = 8;
        public static final int COUNTRY_FIELD_NUMBER = 6;
        public static final int GENDER_FIELD_NUMBER = 5;
        public static final int NICK_FIELD_NUMBER = 3;
        public static final int OPENID_FIELD_NUMBER = 2;
        public static final int PROVINCE_FIELD_NUMBER = 7;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 26, 34, 40, 50, 58, 66}, new String[]{"openid", "nick", "avatarurl", "gender", "country", "province", "city"}, new Object[]{ByteStringMicro.EMPTY, ByteStringMicro.EMPTY, ByteStringMicro.EMPTY, 0, ByteStringMicro.EMPTY, ByteStringMicro.EMPTY, ByteStringMicro.EMPTY}, FriendInfo.class);
        public final PBBytesField avatarurl = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField country = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field gender = PBField.initUInt32(0);
        public final PBBytesField nick = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField openid = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField province = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    public static final class IMUserId extends MessageMicro<IMUserId> {
        public static final int TINYID_FIELD_NUMBER = 4;
        public static final int UIDTYPE_FIELD_NUMBER = 1;
        public static final int UIN_FIELD_NUMBER = 5;
        public static final int USERAPPID_FIELD_NUMBER = 2;
        public static final int USERID_FIELD_NUMBER = 3;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40}, new String[]{"uidtype", "userappid", "userid", "tinyid", "uin"}, new Object[]{ByteStringMicro.EMPTY, 0, ByteStringMicro.EMPTY, 0L, 0L}, IMUserId.class);
        public final PBUInt64Field tinyid = PBField.initUInt64(0);
        public final PBBytesField uidtype = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt64Field uin = PBField.initUInt64(0);
        public final PBUInt32Field userappid = PBField.initUInt32(0);
        public final PBBytesField userid = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    public static final class SdkData extends MessageMicro<SdkData> {
        public static final int SDKAPPID_FIELD_NUMBER = 1;
        public static final int SDKAPPTOKEN_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"sdkappid", "sdkapptoken"}, new Object[]{0, ByteStringMicro.EMPTY}, SdkData.class);
        public final PBUInt32Field sdkappid = PBField.initUInt32(0);
        public final PBBytesField sdkapptoken = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    public static final class UserId extends MessageMicro<UserId> {
        public static final int OPENID_FIELD_NUMBER = 1;
        public static final int UIN_FIELD_NUMBER = 2;
        public static final int UIN_TYPE_FIELD_NUMBER = 3;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"openid", "uin", "uin_type"}, new Object[]{ByteStringMicro.EMPTY, 0L, 0}, UserId.class);
        public final PBBytesField openid = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt64Field uin = PBField.initUInt64(0);
        public final PBUInt32Field uin_type = PBField.initUInt32(0);
    }

    public static final class UserStatus extends MessageMicro<UserStatus> {
        public static final int NETWORK_TYPE_FIELD_NUMBER = 3;
        public static final int OPENID_FIELD_NUMBER = 1;
        public static final int STATUS_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"openid", "status", "network_type"}, new Object[]{ByteStringMicro.EMPTY, 0, 0}, UserStatus.class);
        public final PBUInt32Field network_type = PBField.initUInt32(0);
        public final PBBytesField openid = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field status = PBField.initUInt32(0);
    }

    private im_open_common() {
    }
}
