package com.kk.taurus.playerbase.extension;

import android.os.Bundle;
import com.kk.taurus.playerbase.receiver.IReceiverGroup;

public interface DelegateReceiverEventSender {
    void sendEvent(int i, Bundle bundle, IReceiverGroup.OnReceiverFilter onReceiverFilter);

    void sendObject(String str, Object obj, IReceiverGroup.OnReceiverFilter onReceiverFilter);
}
