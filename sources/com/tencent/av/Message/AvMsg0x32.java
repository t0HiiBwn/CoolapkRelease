package com.tencent.av.Message;

import com.tencent.av.Message.AvMsg;
import com.tencent.imsdk.TIMCallBack;

public class AvMsg0x32 extends AvMsg {
    private String identifer = "";

    @Override // com.tencent.av.Message.AvMsg
    public void receive(byte[] bArr) {
    }

    @Override // com.tencent.av.Message.AvMsg
    public void response(TIMCallBack tIMCallBack) {
    }

    @Override // com.tencent.av.Message.AvMsg
    public void send(TIMCallBack tIMCallBack) {
    }

    public AvMsg0x32(String str) {
        this.identifer = str;
    }

    private void set0x32MsgType(int i) {
        if (i == 0) {
            setMsgType(AvMsg.Type.MutiAvInvitation);
        } else if (i == 1) {
            setMsgType(AvMsg.Type.MutiAvCancel);
        } else if (i == 2) {
            setMsgType(AvMsg.Type.MutiAvAccept);
        } else if (i == 3) {
            setMsgType(AvMsg.Type.MutiAvReject);
        }
    }

    /* renamed from: com.tencent.av.Message.AvMsg0x32$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$av$Message$AvMsg$Type;

        static {
            int[] iArr = new int[AvMsg.Type.values().length];
            $SwitchMap$com$tencent$av$Message$AvMsg$Type = iArr;
            try {
                iArr[AvMsg.Type.MutiAvInvitation.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$av$Message$AvMsg$Type[AvMsg.Type.MutiAvCancel.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$av$Message$AvMsg$Type[AvMsg.Type.MutiAvAccept.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$av$Message$AvMsg$Type[AvMsg.Type.MutiAvReject.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private int get0x32MsgType() {
        int i = AnonymousClass1.$SwitchMap$com$tencent$av$Message$AvMsg$Type[getMsgType().ordinal()];
        if (i == 2) {
            return 1;
        }
        if (i != 3) {
            return i != 4 ? 0 : 3;
        }
        return 2;
    }
}
