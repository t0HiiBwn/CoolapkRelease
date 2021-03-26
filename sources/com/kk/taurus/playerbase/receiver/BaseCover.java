package com.kk.taurus.playerbase.receiver;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

public abstract class BaseCover extends BaseReceiver implements ICover, ICoverHandle, View.OnAttachStateChangeListener {
    private View mCoverView;

    @Override // com.kk.taurus.playerbase.receiver.ICover
    public int getCoverLevel() {
        return 0;
    }

    protected void onCoverAttachedToWindow() {
    }

    protected void onCoverDetachedToWindow() {
    }

    protected abstract View onCreateCoverView(Context context);

    public BaseCover(Context context) {
        super(context);
        View onCreateCoverView = onCreateCoverView(context);
        this.mCoverView = onCreateCoverView;
        onCreateCoverView.addOnAttachStateChangeListener(this);
    }

    @Override // com.kk.taurus.playerbase.receiver.ICoverHandle
    public final void requestPause(Bundle bundle) {
        notifyReceiverEvent(-66001, bundle);
    }

    @Override // com.kk.taurus.playerbase.receiver.ICoverHandle
    public final void requestResume(Bundle bundle) {
        notifyReceiverEvent(-66003, bundle);
    }

    @Override // com.kk.taurus.playerbase.receiver.ICoverHandle
    public final void requestSeek(Bundle bundle) {
        notifyReceiverEvent(-66005, bundle);
    }

    @Override // com.kk.taurus.playerbase.receiver.ICoverHandle
    public final void requestStop(Bundle bundle) {
        notifyReceiverEvent(-66007, bundle);
    }

    @Override // com.kk.taurus.playerbase.receiver.ICoverHandle
    public final void requestReset(Bundle bundle) {
        notifyReceiverEvent(-66009, bundle);
    }

    @Override // com.kk.taurus.playerbase.receiver.ICoverHandle
    public final void requestRetry(Bundle bundle) {
        notifyReceiverEvent(-660011, bundle);
    }

    @Override // com.kk.taurus.playerbase.receiver.ICoverHandle
    public final void requestReplay(Bundle bundle) {
        notifyReceiverEvent(-66013, bundle);
    }

    @Override // com.kk.taurus.playerbase.receiver.ICoverHandle
    public final void requestPlayDataSource(Bundle bundle) {
        notifyReceiverEvent(-66014, bundle);
    }

    @Override // com.kk.taurus.playerbase.receiver.ICoverHandle
    public final void requestNotifyTimer() {
        notifyReceiverEvent(-66015, null);
    }

    @Override // com.kk.taurus.playerbase.receiver.ICoverHandle
    public final void requestStopTimer() {
        notifyReceiverEvent(-66016, null);
    }

    protected final <T extends View> T findViewById(int i) {
        return (T) this.mCoverView.findViewById(i);
    }

    @Override // com.kk.taurus.playerbase.receiver.ICover
    public final void setCoverVisibility(int i) {
        this.mCoverView.setVisibility(i);
    }

    @Override // com.kk.taurus.playerbase.receiver.ICover
    public final View getView() {
        return this.mCoverView;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        onCoverAttachedToWindow();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        onCoverDetachedToWindow();
    }

    protected final int levelLow(int i) {
        return levelPriority(0, i);
    }

    protected final int levelMedium(int i) {
        return levelPriority(32, i);
    }

    protected final int levelHigh(int i) {
        return levelPriority(64, i);
    }

    private int levelPriority(int i, int i2) {
        return i + (i2 % 32);
    }
}
