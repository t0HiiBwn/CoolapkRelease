package com.coolapk.market.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blankj.utilcode.util.FileUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideRequest;
import com.coolapk.market.imageloader.StringSignature;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.CoolFileUtils;
import com.meg7.widget.SvgImageView;
import java.io.File;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\u0006\u0010\u0018\u001a\u00020\u0013R\u000e\u0010\b\u001a\u00020\u0001X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/coolapk/market/widget/PostButtonView2;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "buttonBackgroundView", "customImageView", "Landroid/widget/ImageView;", "iconView", "outputFiles", "Ljava/io/File;", "getOutputFiles", "()Ljava/io/File;", "outputFiles$delegate", "Lkotlin/Lazy;", "compat", "", "createIconPlay", "Landroid/graphics/drawable/Drawable;", "createPostButtonBg", "init", "updateCustomImageView", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PostButtonView2.kt */
public final class PostButtonView2 extends FrameLayout {
    private FrameLayout buttonBackgroundView;
    private ImageView customImageView;
    private ImageView iconView;
    private final Lazy outputFiles$delegate;

    private final File getOutputFiles() {
        return (File) this.outputFiles$delegate.getValue();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PostButtonView2(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PostButtonView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.outputFiles$delegate = LazyKt.lazy(PostButtonView2$outputFiles$2.INSTANCE);
        init();
    }

    private final void compat() {
        File file = new File(getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES), "post_button_custom.jpg");
        if (file.exists()) {
            FileUtils.rename(file, "post_button_custom");
        }
    }

    private final void init() {
        compat();
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setBackground(createPostButtonBg());
        ImageView imageView = new ImageView(frameLayout.getContext());
        this.iconView = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconView");
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        frameLayout.addView(imageView, layoutParams);
        SvgImageView svgImageView = new SvgImageView(frameLayout.getContext());
        this.customImageView = svgImageView;
        if (svgImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customImageView");
        }
        svgImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Field declaredField = SvgImageView.class.getDeclaredField("mSvgRawResourceId");
        Intrinsics.checkNotNullExpressionValue(declaredField, "this");
        declaredField.setAccessible(true);
        ImageView imageView2 = this.customImageView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customImageView");
        }
        declaredField.setInt(imageView2, 2131820545);
        ImageView imageView3 = this.customImageView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customImageView");
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(NumberExtendsKt.getDp((Number) 40), NumberExtendsKt.getDp((Number) 30));
        layoutParams2.gravity = 17;
        Unit unit2 = Unit.INSTANCE;
        frameLayout.addView(imageView3, layoutParams2);
        Unit unit3 = Unit.INSTANCE;
        this.buttonBackgroundView = frameLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttonBackgroundView");
        }
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(NumberExtendsKt.getDp((Number) 40), NumberExtendsKt.getDp((Number) 30));
        layoutParams3.gravity = 17;
        Unit unit4 = Unit.INSTANCE;
        addView(frameLayout, layoutParams3);
        setElevation((float) NumberExtendsKt.getDp((Number) 0));
        setZ((float) NumberExtendsKt.getDp((Number) 8));
        setOnClickListener(new PostButtonView2$init$3(this));
        setOnLongClickListener(new PostButtonView2$init$4(this));
        updateCustomImageView();
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c2  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final void updateCustomImageView() {
        int i;
        String preferencesString = DataManager.getInstance().getPreferencesString("POST_BUTTON_SETTING_KEY", "PLUS");
        if (preferencesString != null) {
            switch (preferencesString.hashCode()) {
                case 2459034:
                    if (preferencesString.equals("PLUS")) {
                        i = 2131231500;
                        break;
                    }
                    break;
                case 105615186:
                    if (preferencesString.equals("AIRPLANE")) {
                        i = 2131231495;
                        break;
                    }
                    break;
                case 1670194707:
                    if (preferencesString.equals("COOLAPK")) {
                        i = 2131231421;
                        break;
                    }
                    break;
                case 1999208305:
                    if (preferencesString.equals("CUSTOM")) {
                        i = 2131231489;
                        break;
                    }
                    break;
            }
            if (!(i != 2131231489 && getOutputFiles().exists())) {
                ImageView imageView = this.iconView;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("iconView");
                }
                imageView.setImageDrawable(null);
                GlideRequest signature = GlideApp.with(getContext()).load(CoolFileUtils.wrap(getOutputFiles().getPath())).signature(new StringSignature(String.valueOf(getOutputFiles().lastModified())));
                ImageView imageView2 = this.customImageView;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("customImageView");
                }
                signature.into(imageView2);
                ImageView imageView3 = this.customImageView;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("customImageView");
                }
                imageView3.setVisibility(0);
                FrameLayout frameLayout = this.buttonBackgroundView;
                if (frameLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("buttonBackgroundView");
                }
                frameLayout.setBackgroundTintList(ColorStateList.valueOf(-1));
                return;
            }
            if (i == 2131231495) {
                ImageView imageView4 = this.iconView;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("iconView");
                }
                imageView4.setImageDrawable(createIconPlay());
            } else {
                ImageView imageView5 = this.iconView;
                if (imageView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("iconView");
                }
                imageView5.setImageResource(i);
            }
            ImageView imageView6 = this.customImageView;
            if (imageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("customImageView");
            }
            imageView6.setImageDrawable(null);
            ImageView imageView7 = this.customImageView;
            if (imageView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("customImageView");
            }
            imageView7.setVisibility(8);
            FrameLayout frameLayout2 = this.buttonBackgroundView;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("buttonBackgroundView");
            }
            frameLayout2.setBackgroundTintList(ColorStateList.valueOf(AppHolder.getAppTheme().getColorAccent()));
            return;
        }
        i = 0;
        if (!(i != 2131231489 && getOutputFiles().exists())) {
        }
    }

    private final Drawable createIconPlay() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return PostButtonView2Kt.createSvgIconCompat(context, 2131231495, -1);
    }

    private final Drawable createPostButtonBg() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return PostButtonView2Kt.createSvgIconCompat(context, 2131231505, AppHolder.getAppTheme().getColorAccent());
    }
}
