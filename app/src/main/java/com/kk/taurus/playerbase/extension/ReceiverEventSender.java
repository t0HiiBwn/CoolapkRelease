package com.kk.taurus.playerbase.extension;

import android.os.Bundle;
import com.kk.taurus.playerbase.receiver.IReceiverGroup;

public interface ReceiverEventSender {
    void sendBoolean(String str, boolean z);

    void sendBoolean(String str, boolean z, IReceiverGroup.OnReceiverFilter onReceiverFilter);

    void sendDouble(String str, double d);

    void sendDouble(String str, double d, IReceiverGroup.OnReceiverFilter onReceiverFilter);

    void sendEvent(int i, Bundle bundle);

    void sendEvent(int i, Bundle bundle, IReceiverGroup.OnReceiverFilter onReceiverFilter);

    void sendFloat(String str, float f);

    void sendFloat(String str, float f, IReceiverGroup.OnReceiverFilter onReceiverFilter);

    void sendInt(String str, int i);

    void sendInt(String str, int i, IReceiverGroup.OnReceiverFilter onReceiverFilter);

    void sendLong(String str, long j);

    void sendLong(String str, long j, IReceiverGroup.OnReceiverFilter onReceiverFilter);

    void sendObject(String str, Object obj);

    void sendObject(String str, Object obj, IReceiverGroup.OnReceiverFilter onReceiverFilter);

    void sendString(String str, String str2);

    void sendString(String str, String str2, IReceiverGroup.OnReceiverFilter onReceiverFilter);
}
