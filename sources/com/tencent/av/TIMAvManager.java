package com.tencent.av;

import android.text.TextUtils;
import com.tencent.av.Message.AvMsg;
import com.tencent.av.Message.AvMsg0x32;
import com.tencent.av.Message.TIMAvMessageListener;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMManager;
import com.tencent.imsdk.TIMUser;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.utils.IMFunc;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.openqq.protocol.imsdk.gv_comm_operate;
import com.tencent.openqq.protocol.imsdk.msg;
import com.tencent.openqq.protocol.imsdk.videoinvitation;
import com.tencent.timint.TIMIntManager;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class TIMAvManager {
    protected static final char[] hexArray = "0123456789ABCDEF".toCharArray();
    static ConcurrentHashMap<String, TIMAvManager> mutiMap = new ConcurrentHashMap<>();
    private static final String tag = "MSF.C.TIMAvManager";
    private TIMAvMessageListener messageListener;
    public Random random = new Random();
    private TIMUser user;

    public TIMAvMessageListener getMessageListener() {
        return this.messageListener;
    }

    public void setMessageListener(TIMAvMessageListener tIMAvMessageListener) {
        this.messageListener = tIMAvMessageListener;
    }

    public int getSdkAppId() {
        return TIMManager.getInstance().getSdkConfig().getSdkAppId();
    }

    private TIMAvManager(String str) {
        TIMUser tIMUser = new TIMUser();
        this.user = tIMUser;
        tIMUser.setIdentifier(str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        TIMIntManager.getInstance().userIdToTinyId(arrayList, new TIMValueCallBack<List<TIMUser>>() {
            /* class com.tencent.av.TIMAvManager.AnonymousClass1 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                QLog.e("MSF.C.TIMAvManager", "code: " + i + "  desc:" + str);
            }

            public void onSuccess(List<TIMUser> list) {
                if (list.size() == 1) {
                    QLog.i("MSF.C.TIMAvManager", "user identifier:" + TIMAvManager.this.user.getIdentifier() + " res identifier:" + list.get(0).getIdentifier());
                    TIMAvManager.this.user = list.get(0);
                }
            }
        });
    }

    public static TIMAvManager getInstance() {
        String loginUser = TIMManager.getInstance().getLoginUser();
        if (TextUtils.isEmpty(loginUser)) {
            QLog.w("MSF.C.TIMAvManager", "current login user is empty");
        }
        for (Map.Entry<String, TIMAvManager> entry : mutiMap.entrySet()) {
            if (entry.getKey() == loginUser) {
                return entry.getValue();
            }
        }
        TIMAvManager tIMAvManager = new TIMAvManager(loginUser);
        mutiMap.putIfAbsent(loginUser, tIMAvManager);
        return tIMAvManager;
    }

    public void MsgNotify(byte[] bArr) {
        if (this.messageListener != null) {
            AvMsg0x32 avMsg0x32 = new AvMsg0x32(this.user.getIdentifier());
            avMsg0x32.receive(bArr);
            this.messageListener.onNewMessages(avMsg0x32);
        }
    }

    public void requestSpeedTest(final TIMPingCallBack tIMPingCallBack) {
        if (TextUtils.isEmpty(this.user.getIdentifier())) {
            tIMPingCallBack.onError(6014, "current not login");
            return;
        }
        int sdkAppId = getSdkAppId();
        final ByteBuffer allocate = ByteBuffer.allocate(19);
        allocate.put((byte) 2).putShort(1).putShort(7).putShort(6).putInt(sdkAppId).putInt(23678484).putShort(0).putShort(0);
        if (this.user.getTinyId() == 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.user.getIdentifier());
            TIMIntManager.getInstance().userIdToTinyId(arrayList, new TIMValueCallBack<List<TIMUser>>() {
                /* class com.tencent.av.TIMAvManager.AnonymousClass2 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    QLog.e("MSF.C.TIMAvManager", "code: " + i + "  desc:" + str);
                    tIMPingCallBack.onError(i, str);
                }

                public void onSuccess(List<TIMUser> list) {
                    if (list.size() != 1) {
                        tIMPingCallBack.onError(-2, "List TIMUser size not equal 1");
                        return;
                    }
                    TIMAvManager.this.user = list.get(0);
                    TIMIntManager.getInstance().requestMultiVideoInfo(NetworkUtil.formReq(TIMAvManager.this.user.getTinyId(), 208, 0, "", allocate.array()), new TIMValueCallBack<byte[]>() {
                        /* class com.tencent.av.TIMAvManager.AnonymousClass2.AnonymousClass1 */

                        @Override // com.tencent.imsdk.TIMValueCallBack
                        public void onError(int i, String str) {
                            tIMPingCallBack.onError(i, str);
                        }

                        public void onSuccess(byte[] bArr) {
                            PingUtil.getInstance().init(bArr, tIMPingCallBack);
                            PingUtil.getInstance().setUser(TIMAvManager.this.user);
                            PingUtil.getInstance().start();
                        }
                    });
                }
            });
            return;
        }
        TIMIntManager.getInstance().requestMultiVideoInfo(NetworkUtil.formReq(this.user.getTinyId(), 208, 0, "", allocate.array()), new TIMValueCallBack<byte[]>() {
            /* class com.tencent.av.TIMAvManager.AnonymousClass3 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                tIMPingCallBack.onError(i, str);
            }

            public void onSuccess(byte[] bArr) {
                PingUtil.getInstance().init(bArr, tIMPingCallBack);
                PingUtil.getInstance().setUser(TIMAvManager.this.user);
                PingUtil.getInstance().start();
            }
        });
    }

    public void requestSpeedTestStop() {
        PingUtil.getInstance().stop();
    }

    public void requestMultiVideoInvitation(int i, int i2, int i3, int i4, byte[] bArr, List<TIMUser> list, final TIMCallBack tIMCallBack) {
        QLog.i("MSF.C.TIMAvManager", "---- Enter requestMultiVideoInvitation -----");
        if (TextUtils.isEmpty(this.user.getIdentifier())) {
            tIMCallBack.onError(6014, "current user not login. id: " + this.user.getIdentifier());
        } else if (bArr != null && bArr.length > 128) {
            tIMCallBack.onError(-1, "自定义信息长度不能超过128字节");
        } else if (list.size() <= 0) {
            tIMCallBack.onError(-1, "邀请人数至少为一人");
        } else {
            videoinvitation.MsgBody msgBody = new videoinvitation.MsgBody();
            msgBody.int32_buss_type.set(i);
            msgBody.int32_auth_type.set(i2);
            msgBody.uint32_auth_id.set(i3);
            msgBody.uint32_sdk_appid.set(getSdkAppId());
            msgBody.int32_request_type.set(i4);
            if (bArr != null) {
                msgBody.bytes_buff.set(ByteStringMicro.copyFrom(bArr));
            }
            msgBody.msg_sender.set(new videoinvitation.UserInfo());
            ArrayList arrayList = new ArrayList();
            for (TIMUser tIMUser : list) {
                videoinvitation.UserInfo userInfo = new videoinvitation.UserInfo();
                userInfo.bytes_appid.set(ByteStringMicro.copyFromUtf8(tIMUser.getAppIdAt3rd()));
                userInfo.bytes_openid.set(ByteStringMicro.copyFromUtf8(tIMUser.getIdentifier()));
                arrayList.add(userInfo);
            }
            msgBody.rpt_msg_receiver_list.set(arrayList);
            msg.MsgBody msgBody2 = new msg.MsgBody();
            msgBody2.msg_content.set(ByteStringMicro.copyFrom(msgBody.toByteArray()));
            TIMIntManager.getInstance().request("openim.videoinvitaion", msgBody2.toByteArray(), new TIMValueCallBack<byte[]>() {
                /* class com.tencent.av.TIMAvManager.AnonymousClass4 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    tIMCallBack.onError(i, str);
                }

                public void onSuccess(byte[] bArr) {
                    try {
                        new videoinvitation.RsqMsgBody().mergeFrom(bArr);
                    } catch (Throwable th) {
                        QLog.e("MSF.C.TIMAvManager", IMFunc.getExceptionInfo(th));
                    }
                }
            });
        }
    }

    public void ResponseToVideoInvitation(AvMsg.Type type, AvMsg avMsg, TIMCallBack tIMCallBack) {
        avMsg.setMsgType(type);
        avMsg.response(tIMCallBack);
    }

    private static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = hexArray;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    public enum RateType {
        RATE_TYPE_ORIGINAL(0),
        RATE_TYPE_550(10),
        RATE_TYPE_900(20);
        
        private int value = 0;

        private RateType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum RecordType {
        VIDEO(0),
        AUDIO(1);
        
        private int value = 0;

        private RecordType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum StreamEncode {
        HLS(1),
        FLV(2),
        RAW(4),
        RTMP(5),
        HLS_AND_RTMP(6);
        
        private int encode;

        private StreamEncode(int i) {
            this.encode = i;
        }

        int getEncode() {
            return this.encode;
        }
    }

    private enum SourceType {
        CAMERA(0),
        SECONDARY_STREAM(1);
        
        private int type;

        private SourceType(int i) {
            this.type = i;
        }

        int getValue() {
            return this.type;
        }
    }

    private enum SDKType {
        Normal(1),
        IOTCamara(2),
        CoastCamara(3);
        
        private int type;

        private SDKType(int i) {
            this.type = i;
        }

        int getSdkType() {
            return this.type;
        }
    }

    public enum RecordFileType {
        NONE(0),
        RECORD_HLS(1),
        RECORD_FLV(2),
        RECORD_HLS_FLV(3),
        RECORD_MP4(4),
        RECORD_HLS_MP4(5),
        RECORD_FLV_MP4(6),
        RECORD_HLS_FLV_MP4(7),
        RECORD_MP3(16);
        
        private int type;

        private RecordFileType(int i) {
            this.type = i;
        }

        int getType() {
            return this.type;
        }
    }

    public class RoomInfo {
        int relationId;
        int roomId;

        public RoomInfo() {
        }

        public void setRelationId(int i) {
            this.relationId = i;
        }

        public void setRoomId(int i) {
            this.roomId = i;
        }
    }

    public class StreamParam {
        String chnldescr = "";
        String chnlname = "";
        String chnlpasswd = "";
        StreamEncode encode;
        boolean isAudioOnly = false;
        boolean isRecord = false;
        boolean isWatermark = false;
        List<RateType> rates = new ArrayList();
        RecordFileType recordFileType = RecordFileType.NONE;
        SDKType sdktype = SDKType.Normal;
        SourceType stype = SourceType.CAMERA;
        long watermarkId = 0;

        public StreamParam() {
        }

        public void setEncode(StreamEncode streamEncode) {
            this.encode = streamEncode;
        }

        public void setChannelName(String str) {
            this.chnlname = str;
        }

        public void setChannelDescr(String str) {
            this.chnldescr = str;
        }

        public void setRecordFileType(RecordFileType recordFileType2) {
            this.recordFileType = recordFileType2;
        }

        private void setSdkType(SDKType sDKType) {
            this.sdktype = sDKType;
        }

        public void setAudioOnly() {
            this.isAudioOnly = true;
        }

        private void setChannelPasswd(String str) {
            this.chnlpasswd = str;
        }

        private void setSourceType(SourceType sourceType) {
            this.stype = sourceType;
        }

        private void enableRecord(boolean z) {
            this.isRecord = z;
        }

        private void enableWatermark(boolean z) {
            this.isWatermark = z;
        }

        private void setWatermarkId(long j) {
            this.watermarkId = j;
        }

        private void addRateType(RateType rateType) {
            this.rates.add(rateType);
        }
    }

    public class LiveUrl {
        int encodeType;
        int rate = 0;
        String url;

        public LiveUrl() {
        }

        void setEncode(int i) {
            this.encodeType = i;
        }

        public int getEncode() {
            return this.encodeType;
        }

        public String getUrl() {
            String str = this.url;
            return str == null ? "" : str;
        }

        void setUrl(String str) {
            this.url = str;
        }

        public RateType getRateType() {
            RateType[] values = RateType.values();
            for (RateType rateType : values) {
                if (rateType.getValue() == this.rate) {
                    return rateType;
                }
            }
            return RateType.RATE_TYPE_ORIGINAL;
        }

        void setRateType(int i) {
            this.rate = i;
        }
    }

    public class StreamRes {
        long chnlId;
        long taskId;
        List<LiveUrl> urls = new ArrayList();

        public StreamRes() {
        }

        public List<LiveUrl> getUrls() {
            return this.urls;
        }

        public long getChnlId() {
            return this.chnlId;
        }

        public long getTaskId() {
            return this.taskId;
        }
    }

    public class RecordParam {
        int classId;
        String filename = "";
        boolean isScreenShot = false;
        boolean isTransCode = false;
        boolean isWaterMark = false;
        RecordType recordType = RecordType.VIDEO;
        SDKType sdktype = SDKType.Normal;
        SourceType stype = SourceType.CAMERA;
        List<String> tags = new ArrayList();

        public RecordParam() {
        }

        public void setRecordType(RecordType recordType2) {
            if (recordType2 != null) {
                this.recordType = recordType2;
            }
        }

        public RecordType getRecordType() {
            return this.recordType;
        }

        private void setSourceType(SourceType sourceType) {
            this.stype = sourceType;
        }

        public void setFilename(String str) {
            this.filename = str;
        }

        public String filename() {
            return this.filename;
        }

        public void addTag(String str) {
            this.tags.add(str);
        }

        public List<String> tags() {
            return this.tags;
        }

        public void setClassId(int i) {
            this.classId = i;
        }

        public int classId() {
            return this.classId;
        }

        public void setTransCode(boolean z) {
            this.isTransCode = z;
        }

        public boolean isTransCode() {
            return this.isTransCode;
        }

        public void setSreenShot(boolean z) {
            this.isScreenShot = z;
        }

        public boolean isScreenShot() {
            return this.isScreenShot;
        }

        public void setWaterMark(boolean z) {
            this.isWaterMark = z;
        }

        public boolean isWaterMark() {
            return this.isWaterMark;
        }

        private void setSdkType(SDKType sDKType) {
            this.sdktype = sDKType;
        }

        private SDKType getSdkType() {
            return this.sdktype;
        }
    }

    private class StreamerRecorderContext {
        int authKey;
        int authType;
        int busiType;
        List<Long> chnlIDs;
        int operation;
        RecordParam recordParam;
        int roomId;
        int sdkAppId;
        String sig;
        StreamParam streamParam;
        int subcmd;
        long uin;

        private StreamerRecorderContext() {
        }

        public String toString() {
            return "StreamerRecorderContext{sdkappid:" + this.sdkAppId + ", roomId:" + this.roomId + ", subcmd:" + this.subcmd + ", oper:" + this.operation;
        }
    }

    public void requestMultiVideoStreamerStart(RoomInfo roomInfo, StreamParam streamParam, final TIMValueCallBack<StreamRes> tIMValueCallBack) {
        final StreamerRecorderContext streamerRecorderContext = new StreamerRecorderContext();
        streamerRecorderContext.busiType = 7;
        streamerRecorderContext.authType = 6;
        streamerRecorderContext.authKey = roomInfo.relationId;
        streamerRecorderContext.roomId = roomInfo.roomId;
        streamerRecorderContext.streamParam = streamParam;
        streamerRecorderContext.sdkAppId = getSdkAppId();
        streamerRecorderContext.uin = this.user.getTinyId();
        streamerRecorderContext.operation = 1;
        streamerRecorderContext.subcmd = 320;
        if (this.user.getTinyId() == 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.user.getIdentifier());
            TIMIntManager.getInstance().userIdToTinyId(arrayList, new TIMValueCallBack<List<TIMUser>>() {
                /* class com.tencent.av.TIMAvManager.AnonymousClass5 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    QLog.e("MSF.C.TIMAvManager", "code: " + i + "  desc:" + str);
                    tIMValueCallBack.onError(i, str);
                }

                public void onSuccess(List<TIMUser> list) {
                    if (list.size() != 1) {
                        tIMValueCallBack.onError(-2, "List TIMUser size not equal 1");
                        return;
                    }
                    TIMAvManager.this.user = list.get(0);
                    streamerRecorderContext.uin = TIMAvManager.this.user.getTinyId();
                    TIMAvManager.this.requestMultiVideoStreamerRelay(streamerRecorderContext, tIMValueCallBack);
                }
            });
            return;
        }
        requestMultiVideoStreamerRelay(streamerRecorderContext, tIMValueCallBack);
    }

    public void requestMultiVideoStreamerStop(RoomInfo roomInfo, List<Long> list, boolean z, final TIMCallBack tIMCallBack) {
        if (TextUtils.isEmpty(this.user.getIdentifier())) {
            tIMCallBack.onError(6014, "current user not login. id: " + this.user.getIdentifier());
            return;
        }
        StreamParam streamParam = new StreamParam();
        if (z) {
            streamParam.setAudioOnly();
        }
        final StreamerRecorderContext streamerRecorderContext = new StreamerRecorderContext();
        streamerRecorderContext.busiType = 7;
        streamerRecorderContext.authType = 6;
        streamerRecorderContext.authKey = roomInfo.relationId;
        streamerRecorderContext.roomId = roomInfo.roomId;
        streamerRecorderContext.chnlIDs = list;
        streamerRecorderContext.sdkAppId = getSdkAppId();
        streamerRecorderContext.uin = this.user.getTinyId();
        streamerRecorderContext.operation = 2;
        streamerRecorderContext.subcmd = 320;
        streamerRecorderContext.streamParam = streamParam;
        if (this.user.getTinyId() == 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.user.getIdentifier());
            TIMIntManager.getInstance().userIdToTinyId(arrayList, new TIMValueCallBack<List<TIMUser>>() {
                /* class com.tencent.av.TIMAvManager.AnonymousClass6 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    QLog.e("MSF.C.TIMAvManager", "code: " + i + "  desc:" + str);
                    tIMCallBack.onError(i, str);
                }

                public void onSuccess(List<TIMUser> list) {
                    if (list.size() != 1) {
                        tIMCallBack.onError(-2, "List TIMUser size not equal 1");
                        return;
                    }
                    TIMAvManager.this.user = list.get(0);
                    streamerRecorderContext.uin = TIMAvManager.this.user.getTinyId();
                    TIMAvManager.this.requestMultiVideoStreamerRelay(streamerRecorderContext, new TIMValueCallBack<StreamRes>() {
                        /* class com.tencent.av.TIMAvManager.AnonymousClass6.AnonymousClass1 */

                        @Override // com.tencent.imsdk.TIMValueCallBack
                        public void onError(int i, String str) {
                            tIMCallBack.onError(i, str);
                        }

                        public void onSuccess(StreamRes streamRes) {
                            tIMCallBack.onSuccess();
                        }
                    });
                }
            });
            return;
        }
        requestMultiVideoStreamerRelay(streamerRecorderContext, new TIMValueCallBack<StreamRes>() {
            /* class com.tencent.av.TIMAvManager.AnonymousClass7 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                tIMCallBack.onError(i, str);
            }

            public void onSuccess(StreamRes streamRes) {
                tIMCallBack.onSuccess();
            }
        });
    }

    public void requestMultiVideoRecorderStart(RoomInfo roomInfo, RecordParam recordParam, final TIMCallBack tIMCallBack) {
        if (TextUtils.isEmpty(this.user.getIdentifier())) {
            tIMCallBack.onError(6014, "current user not login. id: " + this.user.getIdentifier());
            return;
        }
        final StreamerRecorderContext streamerRecorderContext = new StreamerRecorderContext();
        streamerRecorderContext.busiType = 7;
        streamerRecorderContext.authType = 6;
        streamerRecorderContext.authKey = roomInfo.relationId;
        streamerRecorderContext.roomId = roomInfo.roomId;
        streamerRecorderContext.sdkAppId = getSdkAppId();
        streamerRecorderContext.uin = this.user.getTinyId();
        streamerRecorderContext.recordParam = recordParam;
        streamerRecorderContext.operation = 1;
        streamerRecorderContext.subcmd = 322;
        if (this.user.getTinyId() == 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.user.getIdentifier());
            TIMIntManager.getInstance().userIdToTinyId(arrayList, new TIMValueCallBack<List<TIMUser>>() {
                /* class com.tencent.av.TIMAvManager.AnonymousClass8 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    QLog.e("MSF.C.TIMAvManager", "code: " + i + "  desc:" + str);
                    tIMCallBack.onError(i, str);
                }

                public void onSuccess(List<TIMUser> list) {
                    if (list.size() != 1) {
                        tIMCallBack.onError(-2, "List TIMUser size not equal 1");
                        return;
                    }
                    TIMAvManager.this.user = list.get(0);
                    streamerRecorderContext.uin = TIMAvManager.this.user.getTinyId();
                    TIMAvManager.this.requestMultiVideoRecorderRelay(streamerRecorderContext, new TIMValueCallBack<List<String>>() {
                        /* class com.tencent.av.TIMAvManager.AnonymousClass8.AnonymousClass1 */

                        @Override // com.tencent.imsdk.TIMValueCallBack
                        public void onError(int i, String str) {
                            tIMCallBack.onError(i, str);
                        }

                        public void onSuccess(List<String> list) {
                            tIMCallBack.onSuccess();
                        }
                    });
                }
            });
            return;
        }
        requestMultiVideoRecorderRelay(streamerRecorderContext, new TIMValueCallBack<List<String>>() {
            /* class com.tencent.av.TIMAvManager.AnonymousClass9 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                tIMCallBack.onError(i, str);
            }

            public void onSuccess(List<String> list) {
                tIMCallBack.onSuccess();
            }
        });
    }

    public void requestMultiVideoRecorderStop(RoomInfo roomInfo, boolean z, final TIMValueCallBack<List<String>> tIMValueCallBack) {
        if (TextUtils.isEmpty(this.user.getIdentifier())) {
            tIMValueCallBack.onError(6014, "current user not login. id: " + this.user.getIdentifier());
            return;
        }
        RecordParam recordParam = new RecordParam();
        if (z) {
            recordParam.setRecordType(RecordType.AUDIO);
        }
        final StreamerRecorderContext streamerRecorderContext = new StreamerRecorderContext();
        streamerRecorderContext.busiType = 7;
        streamerRecorderContext.authType = 6;
        streamerRecorderContext.authKey = roomInfo.relationId;
        streamerRecorderContext.roomId = roomInfo.roomId;
        streamerRecorderContext.sig = null;
        streamerRecorderContext.sdkAppId = getSdkAppId();
        streamerRecorderContext.uin = this.user.getTinyId();
        streamerRecorderContext.operation = 2;
        streamerRecorderContext.subcmd = 322;
        streamerRecorderContext.recordParam = recordParam;
        if (this.user.getTinyId() == 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.user.getIdentifier());
            TIMIntManager.getInstance().userIdToTinyId(arrayList, new TIMValueCallBack<List<TIMUser>>() {
                /* class com.tencent.av.TIMAvManager.AnonymousClass10 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    QLog.e("MSF.C.TIMAvManager", "code: " + i + "  desc:" + str);
                    tIMValueCallBack.onError(i, str);
                }

                public void onSuccess(List<TIMUser> list) {
                    if (list.size() != 1) {
                        tIMValueCallBack.onError(-2, "List TIMUser size not equal 1");
                        return;
                    }
                    TIMAvManager.this.user = list.get(0);
                    streamerRecorderContext.uin = TIMAvManager.this.user.getTinyId();
                    TIMAvManager.this.requestMultiVideoRecorderRelay(streamerRecorderContext, tIMValueCallBack);
                }
            });
            return;
        }
        requestMultiVideoRecorderRelay(streamerRecorderContext, tIMValueCallBack);
    }

    void requestMultiVideoStreamerRelay(StreamerRecorderContext streamerRecorderContext, final TIMValueCallBack<StreamRes> tIMValueCallBack) {
        if (streamerRecorderContext.sig != null && streamerRecorderContext.sig.getBytes().length > 256) {
            IMContext.getInstance().runOnMainThread(new Runnable() {
                /* class com.tencent.av.TIMAvManager.AnonymousClass11 */

                @Override // java.lang.Runnable
                public void run() {
                    tIMValueCallBack.onError(-1, "Invalid signature, length is limited to 256 bytes");
                }
            });
        }
        QLog.i("MSF.C.TIMAvManager", "requestMultiVideoStreamerRelay, " + streamerRecorderContext.toString());
        gv_comm_operate.GVCommOprHead gVCommOprHead = new gv_comm_operate.GVCommOprHead();
        gVCommOprHead.uint32_buss_type.set(streamerRecorderContext.busiType);
        gVCommOprHead.uint32_auth_type.set(streamerRecorderContext.authType);
        gVCommOprHead.uint32_auth_key.set(streamerRecorderContext.authKey);
        gVCommOprHead.uint64_uin.set(streamerRecorderContext.uin);
        gVCommOprHead.uint32_sdk_appid.set(streamerRecorderContext.sdkAppId);
        gv_comm_operate.ReqBody reqBody = new gv_comm_operate.ReqBody();
        reqBody.req_0x6.setHasFlag(true);
        reqBody.req_0x6.uint32_oper.set(streamerRecorderContext.operation);
        if (streamerRecorderContext.streamParam != null) {
            if (streamerRecorderContext.streamParam.encode != null) {
                reqBody.req_0x6.uint32_live_code.set(streamerRecorderContext.streamParam.encode.getEncode());
            }
            reqBody.req_0x6.uint32_sdk_type.set(streamerRecorderContext.streamParam.sdktype.getSdkType());
            if (!TextUtils.isEmpty(streamerRecorderContext.streamParam.chnlname)) {
                reqBody.req_0x6.str_channel_name.set(streamerRecorderContext.streamParam.chnlname);
            }
            if (!TextUtils.isEmpty(streamerRecorderContext.streamParam.chnldescr)) {
                reqBody.req_0x6.str_channel_describe.set(streamerRecorderContext.streamParam.chnldescr);
            }
            if (!TextUtils.isEmpty(streamerRecorderContext.streamParam.chnlpasswd)) {
                reqBody.req_0x6.str_player_pwd.set(streamerRecorderContext.streamParam.chnlpasswd);
            }
            reqBody.req_0x6.uint32_push_data_type.set(streamerRecorderContext.streamParam.stype.getValue());
            if (streamerRecorderContext.streamParam.isRecord) {
                reqBody.req_0x6.uint32_tape_flag.set(1);
            }
            if (streamerRecorderContext.streamParam.isAudioOnly) {
                reqBody.req_0x6.uint32_push_flag.set(1);
            }
            if (streamerRecorderContext.streamParam.isWatermark) {
                reqBody.req_0x6.uint32_watermark_flag.set(1);
                reqBody.req_0x6.uint32_watermark_id.set((int) streamerRecorderContext.streamParam.watermarkId);
            }
            if (streamerRecorderContext.streamParam.rates.size() > 0) {
                for (RateType rateType : streamerRecorderContext.streamParam.rates) {
                    reqBody.req_0x6.rpt_rate_type.add(Integer.valueOf(rateType.getValue()));
                }
            }
            if (streamerRecorderContext.streamParam.recordFileType != RecordFileType.NONE) {
                reqBody.req_0x6.uint32_record_type.set(streamerRecorderContext.streamParam.recordFileType.getType());
            }
        }
        if (streamerRecorderContext.chnlIDs != null) {
            reqBody.req_0x6.uint64_channel_id.set(streamerRecorderContext.chnlIDs);
        }
        TIMIntManager.getInstance().requestMultiVideoInfo(NetworkUtil.formReq(this.user.getTinyId(), streamerRecorderContext.subcmd, streamerRecorderContext.roomId, streamerRecorderContext.sig, gVCommOprHead.toByteArray(), reqBody.toByteArray()), new TIMValueCallBack<byte[]>() {
            /* class com.tencent.av.TIMAvManager.AnonymousClass12 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(int i, String str) {
                IMContext.getInstance().runOnMainThread(new Runnable() {
                    /* class com.tencent.av.TIMAvManager.AnonymousClass12.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        tIMValueCallBack.onError(6001, "parse streamer rsp failed");
                    }
                });
            }

            public void onSuccess(byte[] bArr) {
                final gv_comm_operate.RspBody rspBody = new gv_comm_operate.RspBody();
                byte[] parseRsp = NetworkUtil.parseRsp(bArr);
                if (parseRsp == null) {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        /* class com.tencent.av.TIMAvManager.AnonymousClass12.AnonymousClass2 */

                        @Override // java.lang.Runnable
                        public void run() {
                            tIMValueCallBack.onError(6001, "parse streamer rsp failed");
                        }
                    });
                    return;
                }
                try {
                    rspBody.mergeFrom(parseRsp);
                    if (rspBody.rsp_0x6.uint32_result.get() != 0) {
                        QLog.d("MSF.C.TIMAvManager", "streamer svr ret: " + rspBody.rsp_0x6.uint32_result.get() + " err: " + rspBody.rsp_0x6.str_errorinfo.get());
                        IMContext.getInstance().runOnMainThread(new Runnable() {
                            /* class com.tencent.av.TIMAvManager.AnonymousClass12.AnonymousClass4 */

                            @Override // java.lang.Runnable
                            public void run() {
                                tIMValueCallBack.onError(rspBody.rsp_0x6.uint32_result.get(), rspBody.rsp_0x6.str_errorinfo.get());
                            }
                        });
                        return;
                    }
                    final StreamRes streamRes = new StreamRes();
                    streamRes.urls = new ArrayList();
                    QLog.d("MSF.C.TIMAvManager", "live url list size: " + rspBody.rsp_0x6.msg_live_url.size());
                    for (gv_comm_operate.LiveUrl liveUrl : rspBody.rsp_0x6.msg_live_url.get()) {
                        LiveUrl liveUrl2 = new LiveUrl();
                        liveUrl2.setEncode(liveUrl.uint32_type.get());
                        liveUrl2.setUrl(liveUrl.string_play_url.get());
                        liveUrl2.setRateType(liveUrl.rate_type.get());
                        streamRes.urls.add(liveUrl2);
                    }
                    streamRes.chnlId = rspBody.rsp_0x6.uint64_channel_id.get();
                    streamRes.taskId = (long) rspBody.rsp_0x6.uint32_tape_task_id.get();
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        /* class com.tencent.av.TIMAvManager.AnonymousClass12.AnonymousClass5 */

                        @Override // java.lang.Runnable
                        public void run() {
                            tIMValueCallBack.onSuccess(streamRes);
                        }
                    });
                } catch (Throwable th) {
                    QLog.e("MSF.C.TIMAvManager", IMFunc.getExceptionInfo(th));
                    QLog.e("MSF.C.TIMAvManager", "parse streamer svr rsp failed");
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        /* class com.tencent.av.TIMAvManager.AnonymousClass12.AnonymousClass3 */

                        @Override // java.lang.Runnable
                        public void run() {
                            tIMValueCallBack.onError(6001, "parse streamer rsp failed");
                        }
                    });
                }
            }
        });
    }

    void requestMultiVideoRecorderRelay(StreamerRecorderContext streamerRecorderContext, final TIMValueCallBack<List<String>> tIMValueCallBack) {
        if (streamerRecorderContext.sig != null && streamerRecorderContext.sig.getBytes().length > 256) {
            IMContext.getInstance().runOnMainThread(new Runnable() {
                /* class com.tencent.av.TIMAvManager.AnonymousClass13 */

                @Override // java.lang.Runnable
                public void run() {
                    tIMValueCallBack.onError(-1, "Invalid signature, length is limited to 256 bytes");
                }
            });
        }
        QLog.i("MSF.C.TIMAvManager", "requestMultiVideoRecorderRelay, " + streamerRecorderContext.toString());
        gv_comm_operate.GVCommOprHead gVCommOprHead = new gv_comm_operate.GVCommOprHead();
        gVCommOprHead.uint32_buss_type.set(streamerRecorderContext.busiType);
        gVCommOprHead.uint32_auth_type.set(streamerRecorderContext.authType);
        gVCommOprHead.uint32_auth_key.set(streamerRecorderContext.authKey);
        gVCommOprHead.uint64_uin.set(streamerRecorderContext.uin);
        gVCommOprHead.uint32_sdk_appid.set(streamerRecorderContext.sdkAppId);
        gv_comm_operate.ReqBody reqBody = new gv_comm_operate.ReqBody();
        reqBody.req_0x5.setHasFlag(true);
        reqBody.req_0x5.uint32_oper.set(streamerRecorderContext.operation);
        reqBody.req_0x5.uint32_seq.set(this.random.nextInt());
        if (streamerRecorderContext.recordParam != null) {
            if (streamerRecorderContext.recordParam.filename() != null) {
                reqBody.req_0x5.string_file_name.set(streamerRecorderContext.recordParam.filename());
            }
            reqBody.req_0x5.uint32_classid.set(streamerRecorderContext.recordParam.classId());
            reqBody.req_0x5.uint32_IsTransCode.set(streamerRecorderContext.recordParam.isTransCode() ? 1 : 0);
            reqBody.req_0x5.uint32_IsScreenShot.set(streamerRecorderContext.recordParam.isScreenShot() ? 1 : 0);
            reqBody.req_0x5.uint32_IsWaterMark.set(streamerRecorderContext.recordParam.isWaterMark() ? 1 : 0);
            for (String str : streamerRecorderContext.recordParam.tags()) {
                reqBody.req_0x5.string_tags.add(str);
            }
            reqBody.req_0x5.uint32_sdk_type.set(streamerRecorderContext.recordParam.sdktype.getSdkType());
            reqBody.req_0x5.uint32_record_data_type.set(streamerRecorderContext.recordParam.stype.getValue());
            if (streamerRecorderContext.recordParam.recordType != RecordType.VIDEO) {
                reqBody.req_0x5.uint32_record_type.set(streamerRecorderContext.recordParam.recordType.getValue());
            }
        }
        TIMIntManager.getInstance().requestMultiVideoInfo(NetworkUtil.formReq(this.user.getTinyId(), streamerRecorderContext.subcmd, streamerRecorderContext.roomId, streamerRecorderContext.sig, gVCommOprHead.toByteArray(), reqBody.toByteArray()), new TIMValueCallBack<byte[]>() {
            /* class com.tencent.av.TIMAvManager.AnonymousClass14 */

            @Override // com.tencent.imsdk.TIMValueCallBack
            public void onError(final int i, final String str) {
                IMContext.getInstance().runOnMainThread(new Runnable() {
                    /* class com.tencent.av.TIMAvManager.AnonymousClass14.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        tIMValueCallBack.onError(i, str);
                    }
                });
            }

            public void onSuccess(byte[] bArr) {
                final gv_comm_operate.RspBody rspBody = new gv_comm_operate.RspBody();
                byte[] parseRsp = NetworkUtil.parseRsp(bArr);
                if (parseRsp == null) {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        /* class com.tencent.av.TIMAvManager.AnonymousClass14.AnonymousClass2 */

                        @Override // java.lang.Runnable
                        public void run() {
                            tIMValueCallBack.onError(6001, "parse recorder rsp failed");
                        }
                    });
                    return;
                }
                try {
                    rspBody.mergeFrom(parseRsp);
                    if (rspBody.rsp_0x5.uint32_result.get() != 0) {
                        QLog.d("MSF.C.TIMAvManager", "recorder svr ret: " + rspBody.rsp_0x5.uint32_result.get() + " err: " + rspBody.rsp_0x5.str_errorinfo.get());
                        IMContext.getInstance().runOnMainThread(new Runnable() {
                            /* class com.tencent.av.TIMAvManager.AnonymousClass14.AnonymousClass4 */

                            @Override // java.lang.Runnable
                            public void run() {
                                tIMValueCallBack.onError(rspBody.rsp_0x5.uint32_result.get(), rspBody.rsp_0x5.str_errorinfo.get());
                            }
                        });
                        return;
                    }
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        /* class com.tencent.av.TIMAvManager.AnonymousClass14.AnonymousClass5 */

                        @Override // java.lang.Runnable
                        public void run() {
                            tIMValueCallBack.onSuccess(rspBody.rsp_0x5.str_fileID.get());
                        }
                    });
                } catch (Throwable th) {
                    QLog.e("MSF.C.TIMAvManager", IMFunc.getExceptionInfo(th));
                    QLog.e("MSF.C.TIMAvManager", "parse recorder svr rsp failed");
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        /* class com.tencent.av.TIMAvManager.AnonymousClass14.AnonymousClass3 */

                        @Override // java.lang.Runnable
                        public void run() {
                            tIMValueCallBack.onError(6001, "parse recorder rsp failed");
                        }
                    });
                }
            }
        });
    }
}
