package com.coolapk.market.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Environment;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.FileUtils;
import com.bumptech.glide.load.Key;
import com.coolapk.market.AppHolder;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideRequest;
import com.coolapk.market.imageloader.GlideRequests;
import com.coolapk.market.imageloader.StringSignature;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.CoolFileUtils;
import com.coolapk.market.util.UiUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\u0013R\u000e\u0010\b\u001a\u00020\u0001X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/widget/PostButtonView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "buttonBackgroundView", "customImageView", "Landroid/widget/ImageView;", "iconView", "outputFiles", "Ljava/io/File;", "size", "", "buildBackground", "Landroid/graphics/drawable/Drawable;", "init", "", "updateCustomImageView", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PostButtonView.kt */
public final class PostButtonView extends FrameLayout {
    private FrameLayout buttonBackgroundView;
    private ImageView customImageView;
    private ImageView iconView;
    private File outputFiles;
    private final int size;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PostButtonView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PostButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.size = ConvertUtils.dp2px(52.0f);
        init();
    }

    private final void init() {
        File file = new File(getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES), "post_button_custom.jpg");
        if (file.exists()) {
            FileUtils.rename(file, "post_button_custom");
        }
        this.outputFiles = new File(getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES), "post_button_custom");
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setClipToPadding(false);
        frameLayout.setClipChildren(false);
        View view = new View(frameLayout.getContext());
        view.setBackgroundResource(2131231827);
        view.setDuplicateParentStateEnabled(true);
        int i = this.size;
        frameLayout.addView(view, new FrameLayout.LayoutParams(i, i));
        ImageView imageView = new ImageView(frameLayout.getContext());
        this.iconView = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconView");
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        frameLayout.addView(imageView, layoutParams);
        ImageView imageView2 = new ImageView(frameLayout.getContext());
        this.customImageView = imageView2;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customImageView");
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ConvertUtils.dp2px(38.0f), ConvertUtils.dp2px(38.0f));
        layoutParams2.gravity = 17;
        Unit unit2 = Unit.INSTANCE;
        frameLayout.addView(imageView2, layoutParams2);
        Unit unit3 = Unit.INSTANCE;
        this.buttonBackgroundView = frameLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttonBackgroundView");
        }
        addView(frameLayout);
        setClipChildren(false);
        setClipToPadding(false);
        setBackground(buildBackground());
        setElevation((float) ConvertUtils.dp2px(5.0f));
        setOnClickListener(new PostButtonView$init$2(this));
        setOnLongClickListener(new PostButtonView$init$3(this));
        updateCustomImageView();
    }

    private final Drawable buildBackground() {
        return new ShapeDrawable(new PostButtonView$buildBackground$1());
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d2  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final void updateCustomImageView() {
        int i;
        boolean z;
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
                        i = 2131231128;
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
            if (i == 2131231489) {
                File file = this.outputFiles;
                if (file == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("outputFiles");
                }
                if (file.exists()) {
                    z = true;
                    if (z) {
                        ImageView imageView = this.iconView;
                        if (imageView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("iconView");
                        }
                        imageView.setImageDrawable(null);
                        FrameLayout frameLayout = this.buttonBackgroundView;
                        if (frameLayout == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("buttonBackgroundView");
                        }
                        frameLayout.setBackgroundResource(2131231830);
                        ImageView imageView2 = this.customImageView;
                        if (imageView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("customImageView");
                        }
                        GlideRequests with = GlideApp.with(imageView2);
                        File file2 = this.outputFiles;
                        if (file2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("outputFiles");
                        }
                        GlideRequest circleCrop = with.load(CoolFileUtils.wrap(file2.getPath())).circleCrop();
                        File file3 = this.outputFiles;
                        if (file3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("outputFiles");
                        }
                        GlideRequest signature = circleCrop.signature((Key) new StringSignature(String.valueOf(file3.lastModified())));
                        ImageView imageView3 = this.customImageView;
                        if (imageView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("customImageView");
                        }
                        signature.into(imageView3);
                        ImageView imageView4 = this.customImageView;
                        if (imageView4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("customImageView");
                        }
                        imageView4.setVisibility(0);
                        return;
                    }
                    ImageView imageView5 = this.iconView;
                    if (imageView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("iconView");
                    }
                    imageView5.setImageResource(i);
                    FrameLayout frameLayout2 = this.buttonBackgroundView;
                    if (frameLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("buttonBackgroundView");
                    }
                    frameLayout2.setBackgroundResource(2131231829);
                    FrameLayout frameLayout3 = this.buttonBackgroundView;
                    if (frameLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("buttonBackgroundView");
                    }
                    UiUtils.setDrawableSolidColors(frameLayout3.getBackground(), new int[]{1}, AppHolder.getAppTheme().getColorAccent());
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
                    return;
                }
            }
            z = false;
            if (z) {
            }
        }
        i = 0;
        if (i == 2131231489) {
        }
        z = false;
        if (z) {
        }
    }
}
