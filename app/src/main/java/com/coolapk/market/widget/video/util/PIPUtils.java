package com.coolapk.market.widget.video.util;

import android.app.Activity;
import android.app.Application;
import android.app.PictureInPictureParams;
import android.os.Build;
import android.util.Rational;
import com.coolapk.market.AppHolder;
import com.coolapk.market.widget.video.SharedPlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\n¨\u0006\f"}, d2 = {"Lcom/coolapk/market/widget/video/util/PIPUtils;", "", "()V", "enterPicInPicMode", "", "activity", "Landroid/app/Activity;", "player", "Lcom/coolapk/market/widget/video/SharedPlayer;", "isInPicInPicMode", "", "supportPicInPicMode", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PIPUtils.kt */
public final class PIPUtils {
    public static final PIPUtils INSTANCE = new PIPUtils();

    private PIPUtils() {
    }

    public final boolean supportPicInPicMode() {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        Application application = AppHolder.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "context");
        return application.getPackageManager().hasSystemFeature("android.software.picture_in_picture");
    }

    public final void enterPicInPicMode(Activity activity, SharedPlayer sharedPlayer) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(sharedPlayer, "player");
        if (Build.VERSION.SDK_INT >= 26) {
            activity.enterPictureInPictureMode(new PictureInPictureParams.Builder().setAspectRatio(new Rational((int) (sharedPlayer.getRenderAspect() * ((float) 100)), 100)).build());
        }
    }

    public final boolean isInPicInPicMode(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return activity.isInPictureInPictureMode();
    }
}
