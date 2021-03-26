package com.kk.taurus.playerbase.extension;

import android.os.Bundle;
import com.kk.taurus.playerbase.receiver.IReceiverGroup;

public final class ProducerEventSender implements ReceiverEventSender {
    private DelegateReceiverEventSender mEventSender;

    public ProducerEventSender(DelegateReceiverEventSender delegateReceiverEventSender) {
        this.mEventSender = delegateReceiverEventSender;
    }

    @Override // com.kk.taurus.playerbase.extension.ReceiverEventSender
    public void sendEvent(int i, Bundle bundle) {
        sendEvent(i, bundle, null);
    }

    @Override // com.kk.taurus.playerbase.extension.ReceiverEventSender
    public void sendEvent(int i, Bundle bundle, IReceiverGroup.OnReceiverFilter onReceiverFilter) {
        DelegateReceiverEventSender delegateReceiverEventSender = this.mEventSender;
        if (delegateReceiverEventSender != null) {
            delegateReceiverEventSender.sendEvent(i, bundle, onReceiverFilter);
        }
    }

    @Override // com.kk.taurus.playerbase.extension.ReceiverEventSender
    public void sendBoolean(String str, boolean z) {
        sendObject(str, Boolean.valueOf(z));
    }

    @Override // com.kk.taurus.playerbase.extension.ReceiverEventSender
    public void sendInt(String str, int i) {
        sendObject(str, Integer.valueOf(i));
    }

    @Override // com.kk.taurus.playerbase.extension.ReceiverEventSender
    public void sendString(String str, String str2) {
        sendObject(str, str2);
    }

    @Override // com.kk.taurus.playerbase.extension.ReceiverEventSender
    public void sendFloat(String str, float f) {
        sendObject(str, Float.valueOf(f));
    }

    @Override // com.kk.taurus.playerbase.extension.ReceiverEventSender
    public void sendLong(String str, long j) {
        sendObject(str, Long.valueOf(j));
    }

    @Override // com.kk.taurus.playerbase.extension.ReceiverEventSender
    public void sendDouble(String str, double d) {
        sendObject(str, Double.valueOf(d));
    }

    @Override // com.kk.taurus.playerbase.extension.ReceiverEventSender
    public void sendObject(String str, Object obj) {
        sendObject(str, obj, null);
    }

    @Override // com.kk.taurus.playerbase.extension.ReceiverEventSender
    public void sendBoolean(String str, boolean z, IReceiverGroup.OnReceiverFilter onReceiverFilter) {
        sendObject(str, Boolean.valueOf(z), onReceiverFilter);
    }

    @Override // com.kk.taurus.playerbase.extension.ReceiverEventSender
    public void sendInt(String str, int i, IReceiverGroup.OnReceiverFilter onReceiverFilter) {
        sendObject(str, Integer.valueOf(i), onReceiverFilter);
    }

    @Override // com.kk.taurus.playerbase.extension.ReceiverEventSender
    public void sendString(String str, String str2, IReceiverGroup.OnReceiverFilter onReceiverFilter) {
        sendObject(str, str2, onReceiverFilter);
    }

    @Override // com.kk.taurus.playerbase.extension.ReceiverEventSender
    public void sendFloat(String str, float f, IReceiverGroup.OnReceiverFilter onReceiverFilter) {
        sendObject(str, Float.valueOf(f), onReceiverFilter);
    }

    @Override // com.kk.taurus.playerbase.extension.ReceiverEventSender
    public void sendLong(String str, long j, IReceiverGroup.OnReceiverFilter onReceiverFilter) {
        sendObject(str, Long.valueOf(j), onReceiverFilter);
    }

    @Override // com.kk.taurus.playerbase.extension.ReceiverEventSender
    public void sendDouble(String str, double d, IReceiverGroup.OnReceiverFilter onReceiverFilter) {
        sendObject(str, Double.valueOf(d), onReceiverFilter);
    }

    @Override // com.kk.taurus.playerbase.extension.ReceiverEventSender
    public void sendObject(String str, Object obj, IReceiverGroup.OnReceiverFilter onReceiverFilter) {
        DelegateReceiverEventSender delegateReceiverEventSender = this.mEventSender;
        if (delegateReceiverEventSender != null) {
            delegateReceiverEventSender.sendObject(str, obj, onReceiverFilter);
        }
    }
}
