package com.kk.taurus.playerbase.receiver;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.kk.taurus.playerbase.log.PLog;

public abstract class BaseReceiver implements IReceiver, StateGetter {
    private Context mContext;
    private IReceiverGroup mHostGroup;
    private String mKey;
    private OnReceiverEventListener mOnReceiverEventListener;
    private StateGetter mStateGetter;

    @Override // com.kk.taurus.playerbase.receiver.IReceiver
    public Bundle onPrivateEvent(int i, Bundle bundle) {
        return null;
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiver
    public void onProducerData(String str, Object obj) {
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiver
    public void onProducerEvent(int i, Bundle bundle) {
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiver
    public void onReceiverBind() {
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiver
    public void onReceiverUnBind() {
    }

    public BaseReceiver(Context context) {
        this.mContext = context;
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiver
    public final void bindGroup(IReceiverGroup iReceiverGroup) {
        this.mHostGroup = iReceiverGroup;
    }

    /* access modifiers changed from: protected */
    public final GroupValue getGroupValue() {
        return this.mHostGroup.getGroupValue();
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiver
    public final void bindStateGetter(StateGetter stateGetter) {
        this.mStateGetter = stateGetter;
    }

    @Override // com.kk.taurus.playerbase.receiver.StateGetter
    public final PlayerStateGetter getPlayerStateGetter() {
        StateGetter stateGetter = this.mStateGetter;
        if (stateGetter != null) {
            return stateGetter.getPlayerStateGetter();
        }
        return null;
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiver
    public final void bindReceiverEventListener(OnReceiverEventListener onReceiverEventListener) {
        this.mOnReceiverEventListener = onReceiverEventListener;
    }

    /* access modifiers changed from: protected */
    public final void notifyReceiverEvent(int i, Bundle bundle) {
        OnReceiverEventListener onReceiverEventListener = this.mOnReceiverEventListener;
        if (onReceiverEventListener != null) {
            onReceiverEventListener.onReceiverEvent(i, bundle);
        }
    }

    protected final Bundle notifyReceiverPrivateEvent(String str, int i, Bundle bundle) {
        if (this.mHostGroup == null || TextUtils.isEmpty(str)) {
            return null;
        }
        IReceiver receiver = this.mHostGroup.getReceiver(str);
        if (receiver != null) {
            return receiver.onPrivateEvent(i, bundle);
        }
        PLog.e("BaseReceiver", "not found receiver use you incoming key.");
        return null;
    }

    protected final Context getContext() {
        return this.mContext;
    }

    public Object getTag() {
        return getClass().getSimpleName();
    }

    void setKey(String str) {
        this.mKey = str;
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiver
    public final String getKey() {
        return this.mKey;
    }
}
