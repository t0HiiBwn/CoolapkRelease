package com.tencent.android.tpush.data;

import java.io.Serializable;

/* compiled from: ProGuard */
public class MessageId implements Serializable {
    public static final short FLAG_ACK = 1;
    public static final short FLAG_UNACK = 0;
    private static final long serialVersionUID = 8708157897391765794L;
    public long accessId;
    public byte apn;
    public long busiMsgId = 0;
    public long channelId = -1;
    public String date = "";
    public String groupId = "";
    public long host;
    public long id;
    public short isAck;
    public byte isp;
    public long msgType = -1;
    public long multiPkg = 0;
    public String nGroupId = "";
    public byte pact;
    public String pkgName;
    public int port;
    public int pushChannel;
    public long pushTime;
    public long receivedTime;
    public int revokeId = 0;
    public long serverTime;
    public String serviceHost;
    public String statTag = "";
    public long timestamp = 0;
    public long ttl;

    public boolean isMsgAcked() {
        return this.isAck == 1;
    }

    @Override // java.lang.Object
    public String toString() {
        return "MessageId [id=" + this.id + ", isAck=" + ((int) this.isAck) + ", isp=" + ((int) this.isp) + ", apn=" + ((int) this.apn) + ", accessId=" + this.accessId + ", receivedTime=" + this.receivedTime + ", pact=" + ((int) this.pact) + ", host=" + this.host + ", port=" + this.port + ", serviceHost=" + this.serviceHost + ", pkgName=" + this.pkgName + ", busiMsgId=" + this.busiMsgId + ", timestamp=" + this.timestamp + ", msgType=" + this.msgType + ", multiPkg=" + this.multiPkg + ", date=" + this.date + ", serverTime=" + this.serverTime + ", ttl=" + this.ttl + "], revokeId=" + this.revokeId;
    }
}
