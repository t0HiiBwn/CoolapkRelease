package com.tencent.imsdk.v2;

import java.util.List;

public abstract class V2TIMSignalingManager {
    public abstract void accept(String str, String str2, V2TIMCallback v2TIMCallback);

    public abstract void addInvitedSignaling(V2TIMSignalingInfo v2TIMSignalingInfo, V2TIMCallback v2TIMCallback);

    public abstract void addSignalingListener(V2TIMSignalingListener v2TIMSignalingListener);

    public abstract void cancel(String str, String str2, V2TIMCallback v2TIMCallback);

    public abstract V2TIMSignalingInfo getSignalingInfo(V2TIMMessage v2TIMMessage);

    public abstract String invite(String str, String str2, boolean z, V2TIMOfflinePushInfo v2TIMOfflinePushInfo, int i, V2TIMCallback v2TIMCallback);

    public abstract String inviteInGroup(String str, List<String> list, String str2, boolean z, int i, V2TIMCallback v2TIMCallback);

    public abstract void reject(String str, String str2, V2TIMCallback v2TIMCallback);

    public abstract void removeSignalingListener(V2TIMSignalingListener v2TIMSignalingListener);

    static V2TIMSignalingManager getInstance() {
        return V2TIMSignalingManagerImpl.getInstance();
    }
}
