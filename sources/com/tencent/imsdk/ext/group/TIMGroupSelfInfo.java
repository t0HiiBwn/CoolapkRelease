package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.TIMGroupMemberInfo;
import com.tencent.imsdk.TIMGroupReceiveMessageOpt;

public class TIMGroupSelfInfo extends TIMGroupMemberInfo {
    private long recvOpt;

    public TIMGroupSelfInfo(String str) {
        super(str);
    }

    public TIMGroupSelfInfo(TIMGroupMemberInfo tIMGroupMemberInfo) {
        setTinyId(tIMGroupMemberInfo.getTinyId());
        setUser(tIMGroupMemberInfo.getUser());
        setMsgFlag(tIMGroupMemberInfo.getMsgFlag());
        setMsgSeq(tIMGroupMemberInfo.getMsgSeq());
        setJoinTime(tIMGroupMemberInfo.getJoinTime());
        setRole(tIMGroupMemberInfo.getRole());
        setNameCard(tIMGroupMemberInfo.getNameCard());
        setSilenceSeconds(tIMGroupMemberInfo.getSilenceSeconds());
        setCustomInfo(tIMGroupMemberInfo.getCustomInfo());
        setRecvOpt(tIMGroupMemberInfo.getMsgFlag());
    }

    public TIMGroupReceiveMessageOpt getRecvOpt() {
        if (this.recvOpt == TIMGroupReceiveMessageOpt.ReceiveAndNotify.getValue()) {
            return TIMGroupReceiveMessageOpt.ReceiveAndNotify;
        }
        if (this.recvOpt == TIMGroupReceiveMessageOpt.NotReceive.getValue()) {
            return TIMGroupReceiveMessageOpt.NotReceive;
        }
        if (this.recvOpt == TIMGroupReceiveMessageOpt.ReceiveNotNotify.getValue()) {
            return TIMGroupReceiveMessageOpt.ReceiveNotNotify;
        }
        return null;
    }

    void setRecvOpt(long j) {
        this.recvOpt = j;
    }
}
