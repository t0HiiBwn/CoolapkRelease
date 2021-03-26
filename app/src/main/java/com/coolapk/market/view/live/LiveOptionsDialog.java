package com.coolapk.market.view.live;

import android.os.Bundle;
import com.coolapk.market.model.Live;
import com.coolapk.market.model.LiveMessage;
import com.coolapk.market.model.User;
import com.coolapk.market.view.base.MultiItemDialogFragment;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/view/live/LiveOptionsDialog;", "Lcom/coolapk/market/view/base/MultiItemDialogFragment;", "()V", "addToBroadcast", "", "getAddToBroadcast", "()Z", "addToBroadcast$delegate", "Lkotlin/Lazy;", "liveContext", "Lcom/coolapk/market/view/live/LiveContext;", "getLiveContext", "()Lcom/coolapk/market/view/live/LiveContext;", "liveContext$delegate", "liveMessage", "Lcom/coolapk/market/model/LiveMessage;", "getLiveMessage", "()Lcom/coolapk/market/model/LiveMessage;", "liveMessage$delegate", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveOptionsDialog.kt */
public final class LiveOptionsDialog extends MultiItemDialogFragment {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_ADD_TO_BROADCAST = "ADD_TO_BROADCAST";
    public static final String KEY_LIVE_MESSAGE = "LIVE_MESSAGE";
    private final Lazy addToBroadcast$delegate = LazyKt.lazy(new LiveOptionsDialog$addToBroadcast$2(this));
    private final Lazy liveContext$delegate = LazyKt.lazy(new LiveOptionsDialog$liveContext$2(this));
    private final Lazy liveMessage$delegate = LazyKt.lazy(new LiveOptionsDialog$liveMessage$2(this));

    /* access modifiers changed from: private */
    public final boolean getAddToBroadcast() {
        return ((Boolean) this.addToBroadcast$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public final LiveContext getLiveContext() {
        return (LiveContext) this.liveContext$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final LiveMessage getLiveMessage() {
        return (LiveMessage) this.liveMessage$delegate.getValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/live/LiveOptionsDialog$Companion;", "", "()V", "KEY_ADD_TO_BROADCAST", "", "KEY_LIVE_MESSAGE", "newInstance", "Lcom/coolapk/market/view/live/LiveOptionsDialog;", "liveMessage", "Lcom/coolapk/market/model/LiveMessage;", "addToBroadcast", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LiveOptionsDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveOptionsDialog newInstance(LiveMessage liveMessage, boolean z) {
            Intrinsics.checkNotNullParameter(liveMessage, "liveMessage");
            LiveOptionsDialog liveOptionsDialog = new LiveOptionsDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable("LIVE_MESSAGE", liveMessage);
            bundle.putBoolean("ADD_TO_BROADCAST", z);
            Unit unit = Unit.INSTANCE;
            liveOptionsDialog.setArguments(bundle);
            return liveOptionsDialog;
        }
    }

    @Override // com.coolapk.market.view.base.MultiItemDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Live live = getLiveContext().getLiveViewModel().getLive();
        Intrinsics.checkNotNull(live);
        String id = live.getId();
        Intrinsics.checkNotNull(id);
        Intrinsics.checkNotNullExpressionValue(id, "live!!.id!!");
        LiveMessage liveMessage = getLiveMessage();
        Intrinsics.checkNotNullExpressionValue(liveMessage, "liveMessage");
        User userInfo = liveMessage.getUserInfo();
        Intrinsics.checkNotNull(userInfo);
        Intrinsics.checkNotNullExpressionValue(userInfo, "liveMessage.userInfo!!");
        String uid = userInfo.getUid();
        Intrinsics.checkNotNull(uid);
        updateDataList(new LiveOptionsDialog$onActivityCreated$1(this, id, live, uid));
    }
}
