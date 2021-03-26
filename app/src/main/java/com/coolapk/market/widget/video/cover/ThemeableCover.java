package com.coolapk.market.widget.video.cover;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.coolapk.market.AppTheme;
import com.kk.taurus.playerbase.receiver.BaseCover;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/widget/video/cover/ThemeableCover;", "Lcom/kk/taurus/playerbase/receiver/BaseCover;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onClick", "", "v", "Landroid/view/View;", "onErrorEvent", "eventCode", "", "bundle", "Landroid/os/Bundle;", "onPlayerEvent", "onReceiverEvent", "onThemeChange", "appTheme", "Lcom/coolapk/market/AppTheme;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ThemableCover.kt */
public abstract class ThemeableCover extends BaseCover implements View.OnClickListener {
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiver
    public void onErrorEvent(int i, Bundle bundle) {
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiver
    public void onPlayerEvent(int i, Bundle bundle) {
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiver
    public void onReceiverEvent(int i, Bundle bundle) {
    }

    public void onThemeChange(AppTheme appTheme) {
        Intrinsics.checkNotNullParameter(appTheme, "appTheme");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ThemeableCover(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
