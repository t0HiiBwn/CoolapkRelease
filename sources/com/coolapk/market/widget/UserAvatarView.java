package com.coolapk.market.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.AppCompatImageView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import com.makeramen.roundedimageview.RoundedDrawable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 $2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0015\u001a\u00020\bJ\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0014J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J0\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\nH\u0014J\b\u0010\"\u001a\u00020\u0014H\u0002J\u0012\u0010#\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/coolapk/market/widget/UserAvatarView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "autoRound", "", "avatarOutlineColor", "", "paint", "Landroid/graphics/Paint;", "vOffsetX", "vSignDrawable", "Landroid/graphics/drawable/Drawable;", "vSignSize", "verifyIcon", "", "bind", "", "round", "convertToOvalDrawable", "drawable", "onAttachedToWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "left", "top", "right", "bottom", "setDebugSign", "setImageDrawable", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserAvatarView.kt */
public final class UserAvatarView extends AppCompatImageView {
    public static final Companion Companion = new Companion(null);
    public static final String VERIFY_ICON_DEV_BLUE = "dev_blue";
    public static final String VERIFY_ICON_DEV_RED = "dev_red";
    public static final String VERIFY_ICON_DEV_YELLOW = "dev_yellow";
    public static final String VERIFY_ICON_STAR_BLUE = "star_blue";
    public static final String VERIFY_ICON_STAR_RED = "star_red";
    public static final String VERIFY_ICON_STAR_YELLOW = "star_yellow";
    public static final String VERIFY_ICON_V_BLUE = "v_blue";
    public static final String VERIFY_ICON_V_DEBUG = "v_test";
    public static final String VERIFY_ICON_V_GREED = "v_green";
    public static final String VERIFY_ICON_V_RED = "v_red";
    public static final String VERIFY_ICON_V_YELLOW = "v_yellow";
    private boolean autoRound = true;
    private final int avatarOutlineColor = AppHolder.getAppTheme().getContentBackgroundColor();
    private Paint paint;
    private int vOffsetX;
    private Drawable vSignDrawable;
    private int vSignSize;
    private String verifyIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserAvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth((float) NumberExtendsKt.getDp((Number) 1));
        paint2.setColor(-1);
        Unit unit = Unit.INSTANCE;
        this.paint = paint2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0012\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/widget/UserAvatarView$Companion;", "", "()V", "VERIFY_ICON_DEV_BLUE", "", "VERIFY_ICON_DEV_RED", "VERIFY_ICON_DEV_YELLOW", "VERIFY_ICON_STAR_BLUE", "VERIFY_ICON_STAR_RED", "VERIFY_ICON_STAR_YELLOW", "VERIFY_ICON_V_BLUE", "VERIFY_ICON_V_DEBUG", "VERIFY_ICON_V_GREED", "VERIFY_ICON_V_RED", "VERIFY_ICON_V_YELLOW", "verifyTextToIconColor", "", "verifyIcon", "verifyTextToIconRes", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserAvatarView.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int verifyTextToIconRes(String str) {
            if (str != null) {
                switch (str.hashCode()) {
                    case -825965949:
                        if (str.equals("v_blue")) {
                            return 2131231628;
                        }
                        break;
                    case -825436485:
                        if (str.equals("v_test")) {
                            return 2131231637;
                        }
                        break;
                    case 111918408:
                        if (str.equals("v_red")) {
                            return 2131231633;
                        }
                        break;
                    case 169640442:
                        if (str.equals("v_green")) {
                            return 2131231632;
                        }
                        break;
                    case 1099934276:
                        if (str.equals("dev_blue")) {
                            return 2131231629;
                        }
                        break;
                    case 1126632414:
                        if (str.equals("dev_yellow")) {
                            return 2131231631;
                        }
                        break;
                    case 1316189476:
                        if (str.equals("star_red")) {
                            return 2131231635;
                        }
                        break;
                    case 1467420765:
                        if (str.equals("v_yellow")) {
                            return 2131231638;
                        }
                        break;
                    case 1559517543:
                        if (str.equals("dev_red")) {
                            return 2131231630;
                        }
                        break;
                    case 2044984065:
                        if (str.equals("star_yellow")) {
                            return 2131231636;
                        }
                        break;
                    case 2146698791:
                        if (str.equals("star_blue")) {
                            return 2131231634;
                        }
                        break;
                }
            }
            return 0;
        }

        public final int verifyTextToIconColor(String str) {
            long j;
            if (str == null) {
                return -7829368;
            }
            String str2 = str;
            if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "yellow", false, 2, (Object) null)) {
                j = 4294940672L;
            } else if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "blue", false, 2, (Object) null)) {
                j = 4280391411L;
            } else if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "red", false, 2, (Object) null)) {
                j = 4294198070L;
            } else if (!StringsKt.contains$default((CharSequence) str2, (CharSequence) "green", false, 2, (Object) null)) {
                return -7829368;
            } else {
                j = 4279213400L;
            }
            return (int) j;
        }
    }

    public static /* synthetic */ void bind$default(UserAvatarView userAvatarView, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        userAvatarView.bind(str, z);
    }

    public final void bind(String str, boolean z) {
        if (!Intrinsics.areEqual(str, this.verifyIcon) || z != this.autoRound) {
            this.autoRound = z;
            this.verifyIcon = str;
            int verifyTextToIconRes = Companion.verifyTextToIconRes(str);
            this.vSignDrawable = verifyTextToIconRes != 0 ? getContext().getDrawable(verifyTextToIconRes) : null;
            invalidate();
        }
    }

    private final void setDebugSign() {
        this.verifyIcon = "v_test";
        this.autoRound = true;
        this.vSignDrawable = getContext().getDrawable(2131231637);
        invalidate();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        super.onLayout(z, i, i2, i3, i4);
        int i6 = i3 - i;
        int i7 = 0;
        if (i6 >= NumberExtendsKt.getDp((Number) 80)) {
            i5 = NumberExtendsKt.getDp((Number) 20);
        } else if (i6 >= NumberExtendsKt.getDp((Number) 60)) {
            i5 = NumberExtendsKt.getDp((Number) 16);
        } else if (i6 >= NumberExtendsKt.getDp((Number) 48)) {
            i5 = NumberExtendsKt.getDp((Number) 14);
        } else if (i6 >= NumberExtendsKt.getDp((Number) 40)) {
            i5 = NumberExtendsKt.getDp((Number) 12);
        } else if (i6 >= NumberExtendsKt.getDp((Number) 28)) {
            i5 = NumberExtendsKt.getDp((Number) 11);
        } else {
            i5 = i6 >= NumberExtendsKt.getDp((Number) 24) ? NumberExtendsKt.getDp((Number) 9) : 0;
        }
        this.vSignSize = i5;
        if (i6 < NumberExtendsKt.getDp((Number) 60)) {
            i7 = NumberExtendsKt.getDp((Number) 2);
        }
        this.vOffsetX = i7;
        this.paint.setStrokeWidth((float) NumberExtendsKt.getDp(i6 > NumberExtendsKt.getDp((Number) 32) ? 1 : Double.valueOf(0.75d)));
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        Drawable drawable = this.vSignDrawable;
        if (drawable != null && this.vSignSize > 0) {
            if (drawable != null) {
                drawable.setBounds((getWidth() - this.vSignSize) + this.vOffsetX, getHeight() - this.vSignSize, getWidth() + this.vOffsetX, getHeight());
            }
            Drawable drawable2 = this.vSignDrawable;
            if (drawable2 != null) {
                drawable2.draw(canvas);
            }
            float f = ((float) this.vSignSize) / 2.0f;
            this.paint.setColor(this.avatarOutlineColor);
            canvas.drawCircle((((float) getWidth()) - f) + ((float) this.vOffsetX), ((float) getHeight()) - f, f + (this.paint.getStrokeWidth() / ((float) 2)), this.paint);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(convertToOvalDrawable(drawable));
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
        }
    }

    private final Drawable convertToOvalDrawable(Drawable drawable) {
        if (!this.autoRound || (drawable instanceof TransitionDrawable)) {
            return drawable;
        }
        Drawable fromDrawable = RoundedDrawable.fromDrawable(drawable);
        if (fromDrawable instanceof RoundedDrawable) {
            ((RoundedDrawable) fromDrawable).setOval(true);
        }
        return fromDrawable;
    }
}
