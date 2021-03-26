package com.coolapk.market.util;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.Window;
import com.ypz.bangscreentools.BangScreenSupport;
import com.ypz.bangscreentools.HuaWeiBangScreen;
import com.ypz.bangscreentools.MiuiBangScreen;
import com.ypz.bangscreentools.OppoBangScreen;
import com.ypz.bangscreentools.PBangScreen;
import com.ypz.bangscreentools.PhoneManufacturersJudgeTools;
import com.ypz.bangscreentools.VivoBangScreen;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/util/NotchUtil;", "", "()V", "support", "Lcom/ypz/bangscreentools/BangScreenSupport;", "blockStatusCutout", "", "window", "Landroid/view/Window;", "extendStatusCutout", "context", "Landroid/content/Context;", "hasStatusCutout", "", "EmptyScreenSupport", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NotchUtil.kt */
public final class NotchUtil {
    public static final NotchUtil INSTANCE = new NotchUtil();
    private static final BangScreenSupport support;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i < 26) {
            support = new EmptyScreenSupport();
        } else if (i < 28) {
            PhoneManufacturersJudgeTools pMJTools = PhoneManufacturersJudgeTools.getPMJTools();
            Intrinsics.checkNotNullExpressionValue(pMJTools, "tools");
            if (pMJTools.isHuaWei()) {
                support = new HuaWeiBangScreen();
            } else if (pMJTools.isMiui()) {
                support = new MiuiBangScreen() {
                    /* class com.coolapk.market.util.NotchUtil.AnonymousClass1 */

                    @Override // com.ypz.bangscreentools.MiuiBangScreen, com.ypz.bangscreentools.BangScreenSupport
                    public void extendStatusCutout(Window window, Context context) {
                        if (window != null) {
                            int statusBarColor = window.getStatusBarColor();
                            super.extendStatusCutout(window, context);
                            window.setStatusBarColor(statusBarColor);
                        }
                    }
                };
            } else if (pMJTools.isVivo()) {
                support = new VivoBangScreen();
            } else if (pMJTools.isOppo()) {
                support = new OppoBangScreen();
            } else {
                support = new EmptyScreenSupport();
            }
        } else {
            support = new PBangScreen();
        }
    }

    private NotchUtil() {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/util/NotchUtil$EmptyScreenSupport;", "Lcom/ypz/bangscreentools/BangScreenSupport;", "()V", "extendStatusCutout", "", "window", "Landroid/view/Window;", "context", "Landroid/content/Context;", "fullscreen", "getBangSize", "", "Landroid/graphics/Rect;", "hasNotBangScreen", "", "setWindowLayoutBlockNotch", "transparentStatusCutout", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: NotchUtil.kt */
    private static final class EmptyScreenSupport implements BangScreenSupport {
        @Override // com.ypz.bangscreentools.BangScreenSupport
        public void extendStatusCutout(Window window, Context context) {
            Intrinsics.checkNotNullParameter(window, "window");
            Intrinsics.checkNotNullParameter(context, "context");
        }

        @Override // com.ypz.bangscreentools.BangScreenSupport
        public void fullscreen(Window window, Context context) {
            Intrinsics.checkNotNullParameter(window, "window");
            Intrinsics.checkNotNullParameter(context, "context");
        }

        @Override // com.ypz.bangscreentools.BangScreenSupport
        public boolean hasNotBangScreen(Window window) {
            Intrinsics.checkNotNullParameter(window, "window");
            return false;
        }

        @Override // com.ypz.bangscreentools.BangScreenSupport
        public void setWindowLayoutBlockNotch(Window window) {
            Intrinsics.checkNotNullParameter(window, "window");
        }

        @Override // com.ypz.bangscreentools.BangScreenSupport
        public void transparentStatusCutout(Window window, Context context) {
            Intrinsics.checkNotNullParameter(window, "window");
            Intrinsics.checkNotNullParameter(context, "context");
        }

        @Override // com.ypz.bangscreentools.BangScreenSupport
        public List<Rect> getBangSize(Window window) {
            Intrinsics.checkNotNullParameter(window, "window");
            return new ArrayList();
        }
    }

    public final void extendStatusCutout(Window window, Context context) {
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(context, "context");
        support.extendStatusCutout(window, context);
    }

    public final void blockStatusCutout(Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        support.setWindowLayoutBlockNotch(window);
    }

    public final boolean hasStatusCutout(Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        return support.hasNotBangScreen(window);
    }
}
