package com.kk.taurus.playerbase.receiver;

import android.os.Bundle;

public interface IReceiver {
    void bindGroup(IReceiverGroup iReceiverGroup);

    void bindReceiverEventListener(OnReceiverEventListener onReceiverEventListener);

    void bindStateGetter(StateGetter stateGetter);

    String getKey();

    void onErrorEvent(int i, Bundle bundle);

    void onPlayerEvent(int i, Bundle bundle);

    Bundle onPrivateEvent(int i, Bundle bundle);

    void onProducerData(String str, Object obj);

    void onProducerEvent(int i, Bundle bundle);

    void onReceiverBind();

    void onReceiverEvent(int i, Bundle bundle);

    void onReceiverUnBind();
}
