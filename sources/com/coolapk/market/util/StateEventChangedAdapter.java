package com.coolapk.market.util;

import com.coolapk.market.event.AppEvent;
import com.coolapk.market.event.DownloadEvent;
import com.coolapk.market.event.Event;
import com.coolapk.market.event.InstallEvent;
import com.coolapk.market.event.UninstallEvent;
import com.coolapk.market.extend.EventBusExtendsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0017J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\fH\u0017J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000eH\u0017J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0010H\u0017¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/util/StateEventChangedAdapter;", "", "()V", "notifyEventChanged", "", "event", "Lcom/coolapk/market/event/Event;", "onAppEventChanged", "Lcom/coolapk/market/event/AppEvent;", "onAttach", "onDetach", "onDownloadEventChanged", "Lcom/coolapk/market/event/DownloadEvent;", "onInstallEventChanged", "Lcom/coolapk/market/event/InstallEvent;", "onUninstallEventChanged", "Lcom/coolapk/market/event/UninstallEvent;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: StateEventChangedAdapter.kt */
public class StateEventChangedAdapter {
    protected void notifyEventChanged(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    public void onAttach() {
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeRegister(eventBus, this);
    }

    public void onDetach() {
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeUnregister(eventBus, this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDownloadEventChanged(DownloadEvent downloadEvent) {
        Intrinsics.checkNotNullParameter(downloadEvent, "event");
        notifyEventChanged(downloadEvent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onInstallEventChanged(InstallEvent installEvent) {
        Intrinsics.checkNotNullParameter(installEvent, "event");
        notifyEventChanged(installEvent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onUninstallEventChanged(UninstallEvent uninstallEvent) {
        Intrinsics.checkNotNullParameter(uninstallEvent, "event");
        notifyEventChanged(uninstallEvent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAppEventChanged(AppEvent appEvent) {
        Intrinsics.checkNotNullParameter(appEvent, "event");
        notifyEventChanged(appEvent);
    }
}
