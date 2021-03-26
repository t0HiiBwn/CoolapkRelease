package com.coolapk.market.widget;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.extend.ListExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.StringExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideRequest;
import com.coolapk.market.imageloader.GlideRequests;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.AppNotification;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.RomUtils;
import com.coolapk.market.util.ThemeUtilsCompat;
import com.coolapk.market.view.main.PageName;
import com.coolapk.market.widget.bubble.DragAndDropHelper;
import com.coolapk.market.widget.view.TabLayout;
import group.infotech.drawable.dsl.Drawable_dslKt;
import group.infotech.drawable.dsl.ShapesKt;
import group.infotech.drawable.dsl.Size;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020.H\u0002J\u0012\u00100\u001a\u0002012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u00102\u001a\u000201H\u0014J\b\u00103\u001a\u000201H\u0014J\u0010\u00104\u001a\u0002012\u0006\u00105\u001a\u000206H\u0007J\u001c\u00107\u001a\u0002012\b\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010 H\u0016J\u0006\u0010;\u001a\u000201J\u0006\u0010<\u001a\u000201J3\u0010=\u001a\u0002012\u0006\u0010>\u001a\u00020\u00192\u0006\u0010?\u001a\u00020\u00112\n\b\u0002\u0010@\u001a\u0004\u0018\u00010A2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010C¢\u0006\u0002\u0010DJ\u000e\u0010E\u001a\u0002012\u0006\u0010>\u001a\u00020\u0019J\b\u0010F\u001a\u000201H\u0002J\u0018\u0010G\u001a\u0002012\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0011H\u0002J\u000e\u0010K\u001a\u0002012\u0006\u0010L\u001a\u00020MJ\b\u0010N\u001a\u000201H\u0002J\b\u0010O\u001a\u000201H\u0002J\u000e\u0010P\u001a\u0002012\u0006\u0010Q\u001a\u00020\u0011J\u0006\u0010R\u001a\u000201J\u0006\u0010S\u001a\u000201J\b\u0010T\u001a\u000201H\u0002J\b\u0010U\u001a\u000201H\u0002J\u0006\u0010V\u001a\u000201J\b\u0010W\u001a\u000201H\u0002R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/coolapk/market/widget/SearchAppHeader;", "Lcom/coolapk/market/widget/BaseAppHeader;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "appManagerBadgeView", "Landroid/widget/TextView;", "appManagerIconView", "Landroid/widget/ImageView;", "appManagerView", "Landroid/view/View;", "avatarView", "barHeight", "", "boxLayout", "Landroid/widget/LinearLayout;", "centerTabContainer", "Landroid/widget/FrameLayout;", "communityImageView", "dividerView", "lastBottomViewPager", "Landroidx/viewpager/widget/ViewPager;", "lastBox2ViewPager", "leftLayout", "notificationBadgeView", "notificationIconView", "notificationView", "searchHintKeyword", "", "searchHintView", "searchIconView", "searchImageView", "searchView", "settingView", "settingViewLayout", "tintColor", "wrapLayout", "addImageBackground", "imageView", "onClickListener", "Landroid/view/View$OnClickListener;", "createBoxBackground", "Landroid/graphics/drawable/GradientDrawable;", "createMenuBackground", "initUI", "", "onAttachedToWindow", "onDetachedFromWindow", "onLoginEvent", "session", "Lcom/coolapk/market/local/LoginSession;", "onSharedPreferenceChanged", "sharedPreferences", "Landroid/content/SharedPreferences;", "key", "removeBottomView", "removeCenterTabView", "setBottomTabLayout", "viewPager", "tabMode", "tabListener", "Lcom/coolapk/market/widget/view/TabLayout$OnTabSelectedListener;", "actionMenu", "", "(Landroidx/viewpager/widget/ViewPager;ILcom/coolapk/market/widget/view/TabLayout$OnTabSelectedListener;Ljava/lang/Boolean;)V", "setBox2Layout", "setDefaultMode", "setDrawableTint", "drawable", "Landroid/graphics/drawable/Drawable;", "color", "setHeaderPageMode", "pageName", "Lcom/coolapk/market/view/main/PageName;", "setMePageMode", "setProductPageMode", "showAvatar", "visible", "updateAppManagerView", "updateNotificationView", "updateSearchBackground", "updateSearchHint", "updateTintColor", "updateUserAvatar", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SearchAppHeader.kt */
public final class SearchAppHeader extends BaseAppHeader implements SharedPreferences.OnSharedPreferenceChangeListener {
    private TextView appManagerBadgeView;
    private ImageView appManagerIconView;
    private View appManagerView;
    private ImageView avatarView;
    private final int barHeight;
    private LinearLayout boxLayout;
    private FrameLayout centerTabContainer;
    private ImageView communityImageView;
    private ImageView dividerView;
    private ViewPager lastBottomViewPager;
    private ViewPager lastBox2ViewPager;
    private FrameLayout leftLayout;
    private TextView notificationBadgeView;
    private ImageView notificationIconView;
    private View notificationView;
    private String searchHintKeyword;
    private TextView searchHintView;
    private ImageView searchIconView;
    private ImageView searchImageView;
    private View searchView;
    private ImageView settingView;
    private FrameLayout settingViewLayout;
    private int tintColor;
    private FrameLayout wrapLayout;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PageName.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[PageName.HOME.ordinal()] = 1;
            iArr[PageName.CENTER.ordinal()] = 2;
            iArr[PageName.MOBILE_BAR.ordinal()] = 3;
        }
    }

    public static final /* synthetic */ ImageView access$getAvatarView$p(SearchAppHeader searchAppHeader) {
        ImageView imageView = searchAppHeader.avatarView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        }
        return imageView;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SearchAppHeader(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchAppHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.barHeight = NumberExtendsKt.getDp((Number) 48);
        initUI(attributeSet);
    }

    private final void initUI(AttributeSet attributeSet) {
        int i;
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setContentDescription("个人主页");
        Unit unit = Unit.INSTANCE;
        this.avatarView = imageView;
        ImageView imageView2 = new ImageView(getContext());
        imageView2.setImageResource(2131231545);
        imageView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        Unit unit2 = Unit.INSTANCE;
        this.searchIconView = imageView2;
        View inflate = LayoutInflater.from(getContext()).inflate(2131558429, (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(cont…anager_view, null, false)");
        this.appManagerView = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appManagerView");
        }
        View findViewById = inflate.findViewById(2131362931);
        Intrinsics.checkNotNullExpressionValue(findViewById, "appManagerView.findViewById(R.id.menu_badge)");
        this.appManagerBadgeView = (TextView) findViewById;
        View view = this.appManagerView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appManagerView");
        }
        View findViewById2 = view.findViewById(2131362932);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "appManagerView.findViewById(R.id.menu_badge_icon)");
        this.appManagerIconView = (ImageView) findViewById2;
        View view2 = this.appManagerView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appManagerView");
        }
        view2.setOnClickListener(new SearchAppHeader$initUI$3(this));
        View inflate2 = LayoutInflater.from(getContext()).inflate(2131558430, (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "LayoutInflater.from(cont…_badge_view, null, false)");
        this.notificationView = inflate2;
        if (inflate2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationView");
        }
        View findViewById3 = inflate2.findViewById(2131362931);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "notificationView.findViewById(R.id.menu_badge)");
        this.notificationBadgeView = (TextView) findViewById3;
        View view3 = this.notificationView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationView");
        }
        View findViewById4 = view3.findViewById(2131362932);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "notificationView.findVie…yId(R.id.menu_badge_icon)");
        this.notificationIconView = (ImageView) findViewById4;
        View view4 = this.notificationView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationView");
        }
        view4.setOnClickListener(new SearchAppHeader$initUI$4(this));
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        if (loginSession.isAdmin()) {
            View view5 = this.notificationView;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notificationView");
            }
            view5.setOnLongClickListener(new SearchAppHeader$initUI$5(this));
        }
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        boolean isLightColorTheme = AppHolder.getAppTheme().isLightColorTheme();
        if (isLightColorTheme) {
            i = AppHolder.getAppTheme().getColorAccent();
        } else if (RomUtils.isMiui() && AppHolder.getAppTheme().isDarkTheme()) {
            i = Color.parseColor("#636363");
        } else if (!AppHolder.getAppTheme().isDarkTheme()) {
            i = -1;
        } else {
            i = ColorUtils.setAlphaComponent(AppHolder.getAppTheme().getMainTextColor(), 77);
        }
        int colorAccent = (isLightColorTheme || AppHolder.getAppTheme().isDarkTheme()) ? -1 : AppHolder.getAppTheme().getColorAccent();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(NumberExtendsKt.getDpf((Number) 12));
        Unit unit3 = Unit.INSTANCE;
        Drawable drawable = ResourceUtils.getDrawable(linearLayout.getContext(), ResourceUtils.resolveResId(linearLayout.getContext(), 16843534));
        Intrinsics.checkNotNullExpressionValue(drawable, "ResourceUtils.getDrawabl…electableItemBackground))");
        linearLayout.setBackground(Drawable_dslKt.layerDrawable(gradientDrawable, drawable));
        LinearLayout linearLayout2 = linearLayout;
        ViewExtendsKt.clipView$default(linearLayout2, 0, NumberExtendsKt.getDpf((Number) 12), 1, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(NumberExtendsKt.getDp((Number) 24), NumberExtendsKt.getDp((Number) 24));
        layoutParams.setMarginEnd(NumberExtendsKt.getDp((Number) 8));
        layoutParams.setMarginStart(NumberExtendsKt.getDp((Number) 8));
        Unit unit4 = Unit.INSTANCE;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(17);
        ImageView imageView3 = new ImageView(linearLayout.getContext());
        imageView3.setId(2131363148);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(NumberExtendsKt.getDp((Number) 9), NumberExtendsKt.getDp((Number) 9));
        Unit unit5 = Unit.INSTANCE;
        imageView3.setLayoutParams(layoutParams2);
        imageView3.setImageResource(2131231503);
        imageView3.setImageTintList(ColorStateList.valueOf(colorAccent));
        imageView3.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        Unit unit6 = Unit.INSTANCE;
        linearLayout.addView(imageView3);
        Unit unit7 = Unit.INSTANCE;
        frameLayout.addView(linearLayout2);
        frameLayout.setPadding(NumberExtendsKt.getDp((Number) 0), NumberExtendsKt.getDp((Number) 8), NumberExtendsKt.getDp((Number) 8), NumberExtendsKt.getDp((Number) 8));
        frameLayout.setOnClickListener(new SearchAppHeader$initUI$postButton$1$1(frameLayout));
        Unit unit8 = Unit.INSTANCE;
        FrameLayout frameLayout2 = new FrameLayout(getContext());
        View view6 = new View(frameLayout2.getContext());
        view6.setBackground(ResourceUtils.getDrawable(view6.getContext(), ResourceUtils.resolveResId(view6.getContext(), 16843868)));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(NumberExtendsKt.getDp((Number) 24), NumberExtendsKt.getDp((Number) 24));
        layoutParams3.gravity = 17;
        Unit unit9 = Unit.INSTANCE;
        view6.setLayoutParams(layoutParams3);
        Unit unit10 = Unit.INSTANCE;
        frameLayout2.addView(view6);
        AppCompatImageView appCompatImageView = new AppCompatImageView(frameLayout2.getContext());
        appCompatImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        appCompatImageView.setImageResource(2131231545);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 17;
        Unit unit11 = Unit.INSTANCE;
        appCompatImageView.setLayoutParams(layoutParams4);
        Unit unit12 = Unit.INSTANCE;
        AppCompatImageView appCompatImageView2 = appCompatImageView;
        this.searchImageView = appCompatImageView2;
        if (appCompatImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchImageView");
        }
        frameLayout2.addView(appCompatImageView2);
        frameLayout2.setOnClickListener(new SearchAppHeader$initUI$$inlined$apply$lambda$1(frameLayout2, this));
        frameLayout2.setVisibility(8);
        Unit unit13 = Unit.INSTANCE;
        this.searchView = frameLayout2;
        FrameLayout frameLayout3 = new FrameLayout(getContext());
        View view7 = new View(frameLayout3.getContext());
        view7.setBackground(ResourceUtils.getDrawable(view7.getContext(), ResourceUtils.resolveResId(view7.getContext(), 16843868)));
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(NumberExtendsKt.getDp((Number) 24), NumberExtendsKt.getDp((Number) 24));
        layoutParams5.gravity = 17;
        Unit unit14 = Unit.INSTANCE;
        view7.setLayoutParams(layoutParams5);
        Unit unit15 = Unit.INSTANCE;
        frameLayout3.addView(view7);
        AppCompatImageView appCompatImageView3 = new AppCompatImageView(frameLayout3.getContext());
        appCompatImageView3.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        appCompatImageView3.setImageResource(2131231564);
        appCompatImageView3.setContentDescription("设置");
        Unit unit16 = Unit.INSTANCE;
        AppCompatImageView appCompatImageView4 = appCompatImageView3;
        this.settingView = appCompatImageView4;
        if (appCompatImageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingView");
        }
        frameLayout3.addView(appCompatImageView4);
        frameLayout3.setOnClickListener(new SearchAppHeader$initUI$7$3(frameLayout3));
        frameLayout3.setVisibility(8);
        Unit unit17 = Unit.INSTANCE;
        this.settingViewLayout = frameLayout3;
        int pickThemeColor = ThemeUtilsCompat.INSTANCE.pickThemeColor(StringExtendsKt.colorInt("#757575"), StringExtendsKt.colorInt("#757575"), StringExtendsKt.colorInt("#FFFFFF"));
        TextView textView = new TextView(getContext());
        textView.setTextColor(pickThemeColor);
        textView.setHintTextColor(pickThemeColor);
        textView.setTextSize(14.0f);
        textView.setHint("搜索应用、动态");
        Unit unit18 = Unit.INSTANCE;
        this.searchHintView = textView;
        int pickThemeColor2 = ThemeUtilsCompat.INSTANCE.pickThemeColor(StringExtendsKt.colorInt("#4CFFFFFF"), StringExtendsKt.colorInt("#CCCCCC"), StringExtendsKt.colorInt("#CCCCCC"));
        ImageView imageView4 = new ImageView(getContext());
        imageView4.setImageDrawable(new ColorDrawable(pickThemeColor2));
        Unit unit19 = Unit.INSTANCE;
        this.dividerView = imageView4;
        LinearLayout linearLayout3 = new LinearLayout(getContext());
        linearLayout3.setClipChildren(false);
        linearLayout3.setClipToPadding(false);
        linearLayout3.setGravity(16);
        linearLayout3.setOrientation(0);
        linearLayout3.setOnClickListener(new SearchAppHeader$initUI$$inlined$apply$lambda$2(linearLayout3, this));
        int dp = NumberExtendsKt.getDp((Number) 20);
        int dp2 = NumberExtendsKt.getDp((Number) 20);
        ImageView imageView5 = this.searchIconView;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchIconView");
        }
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(dp, dp2);
        layoutParams6.setMarginStart(NumberExtendsKt.getDp((Number) 8));
        layoutParams6.setMarginEnd(NumberExtendsKt.getDp((Number) 8));
        Unit unit20 = Unit.INSTANCE;
        linearLayout3.addView(imageView5, layoutParams6);
        TextView textView2 = this.searchHintView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchHintView");
        }
        linearLayout3.addView(textView2, new LinearLayout.LayoutParams(0, -2, 1.0f));
        Unit unit21 = Unit.INSTANCE;
        this.boxLayout = linearLayout3;
        FrameLayout frameLayout4 = new FrameLayout(getContext());
        frameLayout4.setVisibility(8);
        Unit unit22 = Unit.INSTANCE;
        this.centerTabContainer = frameLayout4;
        updateSearchBackground();
        FrameLayout frameLayout5 = new FrameLayout(getContext());
        frameLayout5.addView(new Space(frameLayout5.getContext()), new FrameLayout.LayoutParams(0, this.barHeight));
        frameLayout5.setClipChildren(false);
        frameLayout5.setClipToPadding(false);
        LinearLayout linearLayout4 = this.boxLayout;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("boxLayout");
        }
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-1, NumberExtendsKt.getDp((Number) 30));
        layoutParams7.gravity = 16;
        Unit unit23 = Unit.INSTANCE;
        frameLayout5.addView(linearLayout4, layoutParams7);
        FrameLayout frameLayout6 = this.centerTabContainer;
        if (frameLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerTabContainer");
        }
        FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams8.gravity = 16;
        Unit unit24 = Unit.INSTANCE;
        frameLayout5.addView(frameLayout6, layoutParams8);
        Unit unit25 = Unit.INSTANCE;
        this.wrapLayout = frameLayout5;
        if (frameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wrapLayout");
        }
        setCenterView(frameLayout5);
        FrameLayout frameLayout7 = new FrameLayout(getContext());
        frameLayout7.setPadding(NumberExtendsKt.getDp((Number) 8), 0, NumberExtendsKt.getDp((Number) 0), 0);
        frameLayout7.addView(new Space(frameLayout7.getContext()), new FrameLayout.LayoutParams(0, this.barHeight));
        LinearLayout linearLayout5 = new LinearLayout(frameLayout7.getContext());
        linearLayout5.setGravity(16);
        linearLayout5.setOrientation(0);
        int dp3 = NumberExtendsKt.getDp((Number) 40);
        int dp4 = NumberExtendsKt.getDp((Number) 40);
        FrameLayout frameLayout8 = this.settingViewLayout;
        if (frameLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingViewLayout");
        }
        linearLayout5.addView(frameLayout8, new LinearLayout.LayoutParams(dp3, dp4));
        View view8 = this.appManagerView;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appManagerView");
        }
        linearLayout5.addView(view8, new LinearLayout.LayoutParams(dp3, dp4));
        View view9 = this.searchView;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchView");
        }
        linearLayout5.addView(view9, new LinearLayout.LayoutParams(dp3, dp4));
        View view10 = this.notificationView;
        if (view10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationView");
        }
        linearLayout5.addView(view10, new LinearLayout.LayoutParams(dp3, dp4));
        linearLayout5.addView(frameLayout);
        Unit unit26 = Unit.INSTANCE;
        FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams9.gravity = 16;
        Unit unit27 = Unit.INSTANCE;
        frameLayout7.addView(linearLayout5, layoutParams9);
        Unit unit28 = Unit.INSTANCE;
        setRightView(frameLayout7);
        FrameLayout frameLayout9 = new FrameLayout(getContext());
        frameLayout9.addView(new Space(frameLayout9.getContext()), new FrameLayout.LayoutParams(NumberExtendsKt.getDp((Number) 56), this.barHeight));
        FrameLayout frameLayout10 = new FrameLayout(frameLayout9.getContext());
        View view11 = new View(frameLayout10.getContext());
        view11.setBackgroundResource(ResourceUtils.resolveResId(view11.getContext(), 16843868));
        view11.setDuplicateParentStateEnabled(true);
        Unit unit29 = Unit.INSTANCE;
        frameLayout10.addView(view11, new FrameLayout.LayoutParams(NumberExtendsKt.getDp((Number) 24), NumberExtendsKt.getDp((Number) 24)));
        ImageView imageView6 = this.avatarView;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        }
        frameLayout10.addView(imageView6, new LinearLayout.LayoutParams(NumberExtendsKt.getDp((Number) 24), NumberExtendsKt.getDp((Number) 24)));
        Unit unit30 = Unit.INSTANCE;
        FrameLayout.LayoutParams layoutParams10 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams10.gravity = 17;
        Unit unit31 = Unit.INSTANCE;
        frameLayout9.addView(frameLayout10, layoutParams10);
        frameLayout9.setOnClickListener(new SearchAppHeader$initUI$$inlined$apply$lambda$3(frameLayout9, this));
        Unit unit32 = Unit.INSTANCE;
        this.leftLayout = frameLayout9;
        if (frameLayout9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftLayout");
        }
        setLeftView(frameLayout9);
        updateSearchHint();
        updateTintColor();
        updateUserAvatar();
        setClickable(true);
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1737665160) {
                if (hashCode == -1134679708 && str.equals("app_header_search_background_transparent")) {
                    updateSearchBackground();
                }
            } else if (str.equals("SEARCH_HINT_ARRAY")) {
                updateSearchHint();
            }
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout, android.view.View, android.view.ViewGroup
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        EventBus.getDefault().register(this);
        DataManager.getInstance().registerPreferenceChangeListener(this);
    }

    @Override // com.google.android.material.appbar.AppBarLayout, android.view.View, android.view.ViewGroup
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EventBus.getDefault().unregister(this);
        DataManager.getInstance().unregisterPreferenceChangeListener(this);
    }

    private final void updateSearchBackground() {
        AppSetting appSetting = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
        if (appSetting.isAppHeaderSearchBackgroundTransparent()) {
            LinearLayout linearLayout = this.boxLayout;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("boxLayout");
            }
            linearLayout.setBackground(null);
            return;
        }
        LinearLayout linearLayout2 = this.boxLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("boxLayout");
        }
        linearLayout2.setBackground(createBoxBackground());
    }

    private final FrameLayout addImageBackground(ImageView imageView, View.OnClickListener onClickListener) {
        View view = new View(getContext());
        view.setBackgroundResource(ResourceUtils.resolveResId(view.getContext(), 16843868));
        view.setDuplicateParentStateEnabled(true);
        int dp = NumberExtendsKt.getDp((Number) 24);
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dp, dp);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        frameLayout.addView(view, layoutParams);
        frameLayout.addView(imageView);
        frameLayout.setOnClickListener(onClickListener);
        return frameLayout;
    }

    private final void updateSearchHint() {
        AppSetting appSetting = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
        List<String> searchHint = appSetting.getSearchHint();
        Intrinsics.checkNotNullExpressionValue(searchHint, "AppHolder.getAppSetting().searchHint");
        boolean z = true;
        if (!searchHint.isEmpty()) {
            AppSetting appSetting2 = AppHolder.getAppSetting();
            Intrinsics.checkNotNullExpressionValue(appSetting2, "AppHolder.getAppSetting()");
            List<String> searchHint2 = appSetting2.getSearchHint();
            Intrinsics.checkNotNullExpressionValue(searchHint2, "AppHolder.getAppSetting().searchHint");
            this.searchHintKeyword = (String) ListExtendsKt.getRandomElement(searchHint2);
        }
        TextView textView = this.searchHintView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchHintView");
        }
        CharSequence text = textView.getText();
        Intrinsics.checkNotNullExpressionValue(text, "searchHintView.text");
        if (text.length() != 0) {
            z = false;
        }
        if (z) {
            TextView textView2 = this.searchHintView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchHintView");
            }
            textView2.setText(this.searchHintKeyword);
        }
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private final void updateUserAvatar() {
        int i = AppHolder.getAppTheme().isDarkTheme() ? 2131231163 : 2131231162;
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        if (loginSession.isLogin()) {
            GlideRequests with = GlideApp.with(getContext());
            DataManager instance2 = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
            LoginSession loginSession2 = instance2.getLoginSession();
            Intrinsics.checkNotNullExpressionValue(loginSession2, "DataManager.getInstance().loginSession");
            GlideRequest transform = with.load(loginSession2.getUserAvatar()).placeholder(i).diskCacheStrategy(DiskCacheStrategy.DATA).transform((Transformation<Bitmap>) new CircleTransform(false, 0, 3, null));
            ImageView imageView = this.avatarView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            }
            Intrinsics.checkNotNullExpressionValue(transform.into(imageView), "GlideApp.with(context)\n …        .into(avatarView)");
            return;
        }
        ImageView imageView2 = this.avatarView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        }
        imageView2.setImageResource(i);
    }

    public final void updateTintColor() {
        int pickThemeColor = ThemeUtilsCompat.INSTANCE.pickThemeColor(StringExtendsKt.colorInt("#757575"), StringExtendsKt.colorInt("#757575"), StringExtendsKt.colorInt("#FFFFFF"));
        this.tintColor = pickThemeColor;
        TextView textView = this.appManagerBadgeView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appManagerBadgeView");
        }
        textView.setTextColor(pickThemeColor);
        ImageView imageView = this.notificationIconView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationIconView");
        }
        imageView.setColorFilter(pickThemeColor, PorterDuff.Mode.SRC_IN);
        ImageView imageView2 = this.settingView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingView");
        }
        imageView2.setColorFilter(pickThemeColor, PorterDuff.Mode.SRC_IN);
        ImageView imageView3 = this.searchIconView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchIconView");
        }
        imageView3.setColorFilter(pickThemeColor, PorterDuff.Mode.SRC_IN);
        ImageView imageView4 = this.appManagerIconView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appManagerIconView");
        }
        imageView4.setColorFilter(pickThemeColor, PorterDuff.Mode.SRC_IN);
        ImageView imageView5 = this.searchImageView;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchImageView");
        }
        imageView5.setColorFilter(pickThemeColor, PorterDuff.Mode.SRC_IN);
    }

    public final void updateAppManagerView() {
        int i = 0;
        int size = DataManager.getInstance().getMobileAppUpgradeListFast(false).size();
        TextView textView = this.appManagerBadgeView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appManagerBadgeView");
        }
        textView.setText(size > 99 ? "99+" : String.valueOf(size));
        TextView textView2 = this.appManagerBadgeView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appManagerBadgeView");
        }
        if (size <= 0) {
            i = 8;
        }
        textView2.setVisibility(i);
    }

    public final void updateNotificationView() {
        AppNotification appNotification = AppHolder.getAppNotification();
        if (appNotification.hasNewNotification()) {
            TextView textView = this.notificationBadgeView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notificationBadgeView");
            }
            textView.setVisibility(0);
            String valueOf = appNotification.getAllCount(true) > 99 ? "99+" : String.valueOf(appNotification.getAllCount(true));
            TextView textView2 = this.notificationBadgeView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notificationBadgeView");
            }
            textView2.setText(valueOf);
            TextView textView3 = this.notificationBadgeView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notificationBadgeView");
            }
            DragAndDropHelper.withTarget(textView3).setDragListener(new SearchAppHeader$updateNotificationView$1(appNotification)).setPaintColor(getResources().getColor(2131100040)).apply();
        } else {
            TextView textView4 = this.notificationBadgeView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notificationBadgeView");
            }
            textView4.setOnTouchListener(null);
            TextView textView5 = this.notificationBadgeView;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notificationBadgeView");
            }
            textView5.setVisibility(8);
        }
        if (appNotification.getAllCount(true) > 0) {
            ImageView imageView = this.notificationIconView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notificationIconView");
            }
            imageView.setImageResource(2131231459);
        } else {
            ImageView imageView2 = this.notificationIconView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notificationIconView");
            }
            imageView2.setImageResource(2131231461);
        }
        ImageView imageView3 = this.notificationIconView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationIconView");
        }
        Drawable drawable = imageView3.getDrawable();
        Intrinsics.checkNotNullExpressionValue(drawable, "notificationIconView.drawable");
        setDrawableTint(drawable, this.tintColor);
    }

    public static /* synthetic */ void setBottomTabLayout$default(SearchAppHeader searchAppHeader, ViewPager viewPager, int i, TabLayout.OnTabSelectedListener onTabSelectedListener, Boolean bool, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            onTabSelectedListener = null;
        }
        if ((i2 & 8) != 0) {
            bool = false;
        }
        searchAppHeader.setBottomTabLayout(viewPager, i, onTabSelectedListener, bool);
    }

    public final void setBottomTabLayout(ViewPager viewPager, int i, TabLayout.OnTabSelectedListener onTabSelectedListener, Boolean bool) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        if (!Intrinsics.areEqual(this.lastBottomViewPager, viewPager)) {
            this.lastBottomViewPager = viewPager;
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setClipChildren(false);
            frameLayout.setClipToPadding(false);
            TabLayout tabLayout = new TabLayout(frameLayout.getContext());
            ViewExtendsKt.setV9TabColor(tabLayout, true);
            ViewExtendsKt.setV9TabUI(tabLayout, i);
            if (onTabSelectedListener != null) {
                tabLayout.addOnTabSelectedListener(onTabSelectedListener);
            }
            tabLayout.setupWithViewPager(viewPager);
            ViewExtendsKt.setDefaultDoubleClickListener(tabLayout, viewPager);
            Unit unit = Unit.INSTANCE;
            TabLayout tabLayout2 = tabLayout;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, NumberExtendsKt.getDp((Number) 44));
            layoutParams.topMargin = -NumberExtendsKt.getDp((Number) 8);
            if (Intrinsics.areEqual((Object) bool, (Object) true)) {
                layoutParams.rightMargin = NumberExtendsKt.getDp((Number) 44);
            }
            Unit unit2 = Unit.INSTANCE;
            frameLayout.addView(tabLayout2, layoutParams);
            if (Intrinsics.areEqual((Object) bool, (Object) true)) {
                FrameLayout frameLayout2 = new FrameLayout(frameLayout.getContext());
                frameLayout2.setClipChildren(false);
                frameLayout2.setClipToPadding(false);
                frameLayout2.setElevation((float) NumberExtendsKt.getDp((Number) 10));
                frameLayout2.setBackground(createMenuBackground());
                ImageView imageView = new ImageView(frameLayout2.getContext());
                imageView.setImageResource(2131231433);
                imageView.setImageTintList(ColorStateList.valueOf(ResourceUtils.resolveData(imageView.getContext(), 2130969533)));
                Unit unit3 = Unit.INSTANCE;
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(NumberExtendsKt.getDp((Number) 24), NumberExtendsKt.getDp((Number) 24));
                layoutParams2.gravity = 17;
                Unit unit4 = Unit.INSTANCE;
                frameLayout2.addView(imageView, layoutParams2);
                frameLayout2.setOnClickListener(new SearchAppHeader$setBottomTabLayout$bottomView$1$3$3(frameLayout2));
                frameLayout2.setContentDescription("全部频道");
                Unit unit5 = Unit.INSTANCE;
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(NumberExtendsKt.getDp((Number) 44), NumberExtendsKt.getDp((Number) 44));
                layoutParams3.topMargin = -NumberExtendsKt.getDp((Number) 8);
                layoutParams3.gravity = 5;
                Unit unit6 = Unit.INSTANCE;
                frameLayout.addView(frameLayout2, layoutParams3);
            }
            setBottomView(frameLayout);
        }
    }

    public final void setBox2Layout(ViewPager viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        if (!Intrinsics.areEqual(this.lastBox2ViewPager, viewPager)) {
            this.lastBox2ViewPager = viewPager;
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setClipChildren(false);
            frameLayout.setClipToPadding(false);
            TabLayout tabLayout = new TabLayout(frameLayout.getContext());
            ViewExtendsKt.setV9TabColor(tabLayout, true);
            ViewExtendsKt.setV9TabUI(tabLayout, 0);
            tabLayout.setupWithViewPager(viewPager);
            ViewExtendsKt.setDefaultDoubleClickListener(tabLayout, viewPager);
            Unit unit = Unit.INSTANCE;
            frameLayout.addView(tabLayout, new FrameLayout.LayoutParams(-2, NumberExtendsKt.getDp((Number) 44)));
            FrameLayout frameLayout2 = this.centerTabContainer;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("centerTabContainer");
            }
            frameLayout2.removeAllViews();
            FrameLayout frameLayout3 = this.centerTabContainer;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("centerTabContainer");
            }
            frameLayout3.addView(frameLayout);
        }
    }

    public final void removeBottomView() {
        setBottomView(null);
        this.lastBottomViewPager = null;
    }

    public final void removeCenterTabView() {
        FrameLayout frameLayout = this.centerTabContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerTabContainer");
        }
        frameLayout.removeAllViews();
        this.lastBox2ViewPager = null;
    }

    public final void setHeaderPageMode(PageName pageName) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        int i = WhenMappings.$EnumSwitchMapping$0[pageName.ordinal()];
        if (i == 1) {
            hideElevation();
            setDefaultMode();
        } else if (i == 2) {
            hideElevation();
            setMePageMode();
        } else if (i != 3) {
            hideElevation();
            setDefaultMode();
        } else {
            hideElevation();
            setDefaultMode();
        }
    }

    private final void setDefaultMode() {
        View view = this.searchView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchView");
        }
        view.setVisibility(8);
        ImageView imageView = this.avatarView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        }
        imageView.setVisibility(0);
        View view2 = this.appManagerView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appManagerView");
        }
        String appMode = AppHolder.getAppMetadata().getAppMode();
        view2.setVisibility(appMode == null || appMode.hashCode() != -1480249367 || !appMode.equals("community") ? 0 : 8);
        FrameLayout frameLayout = this.leftLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftLayout");
        }
        frameLayout.setVisibility(0);
        FrameLayout frameLayout2 = this.settingViewLayout;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingViewLayout");
        }
        frameLayout2.setVisibility(8);
        LinearLayout linearLayout = this.boxLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("boxLayout");
        }
        linearLayout.setVisibility(0);
    }

    private final void setMePageMode() {
        View view = this.searchView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchView");
        }
        view.setVisibility(8);
        ImageView imageView = this.avatarView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        }
        imageView.setVisibility(8);
        View view2 = this.appManagerView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appManagerView");
        }
        view2.setVisibility(8);
        FrameLayout frameLayout = this.leftLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftLayout");
        }
        frameLayout.setVisibility(8);
        FrameLayout frameLayout2 = this.settingViewLayout;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingViewLayout");
        }
        frameLayout2.setVisibility(0);
        LinearLayout linearLayout = this.boxLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("boxLayout");
        }
        linearLayout.setVisibility(8);
    }

    public final void showAvatar(int i) {
        ImageView imageView = this.avatarView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        }
        imageView.setVisibility(i);
        FrameLayout frameLayout = this.leftLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftLayout");
        }
        frameLayout.setVisibility(i);
    }

    private final void setProductPageMode() {
        View view = this.searchView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchView");
        }
        view.setVisibility(0);
        View view2 = this.appManagerView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appManagerView");
        }
        view2.setVisibility(8);
        LinearLayout linearLayout = this.boxLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("boxLayout");
        }
        linearLayout.setVisibility(8);
        FrameLayout frameLayout = this.leftLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftLayout");
        }
        frameLayout.setVisibility(8);
        FrameLayout frameLayout2 = this.settingViewLayout;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingViewLayout");
        }
        frameLayout2.setVisibility(8);
        FrameLayout frameLayout3 = this.centerTabContainer;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerTabContainer");
        }
        frameLayout3.setVisibility(0);
    }

    private final void setDrawableTint(Drawable drawable, int i) {
        DrawableCompat.setTint(DrawableCompat.wrap(drawable).mutate(), i);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onLoginEvent(LoginSession loginSession) {
        Intrinsics.checkNotNullParameter(loginSession, "session");
        updateUserAvatar();
    }

    private final GradientDrawable createMenuBackground() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        gradientDrawable.setColors(new int[]{ColorUtils.setAlphaComponent(AppHolder.getAppTheme().getColorPrimary(), (int) 229.5d), AppHolder.getAppTheme().getColorPrimary()});
        return gradientDrawable;
    }

    private final GradientDrawable createBoxBackground() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        ShapesKt.setSolidColor(gradientDrawable, ThemeUtilsCompat.INSTANCE.pickThemeColor(StringExtendsKt.colorInt("#14FFFFFF"), StringExtendsKt.colorInt("#F2F2F2"), StringExtendsKt.colorInt("#33FFFFFF")));
        Size size = new Size();
        size.setHeight(NumberExtendsKt.getDp((Number) 30));
        gradientDrawable.setSize(size.getWidth(), size.getHeight());
        gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 15));
        return gradientDrawable;
    }
}
