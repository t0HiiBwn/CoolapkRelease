package com.coolapk.market.viewholder.v8.image;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.ImageLoaderOptions;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.databinding.ItemCoolPicImageViewBinding;
import com.coolapk.market.databinding.ItemFeedImageBinding;
import com.coolapk.market.event.ActivityPauseEvent;
import com.coolapk.market.event.ActivityResumeEvent;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideImageHelper;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.AppPictureSizeManager;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import com.coolapk.market.widget.MainSpareHandler;
import com.coolapk.market.widget.hotplug.ViewPartPool;
import com.coolapk.market.widget.view.ControlGifImageView;
import com.coolapk.market.widget.view.DividerLineView;
import com.coolapk.market.widget.view.ImageLoadProgressBar;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 k2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0003klmB\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u0012H\u0002J\b\u0010W\u001a\u00020UH\u0002J\u001e\u0010X\u001a\u00020Y2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010[\u001a\u00020\u0012H\u0002J\u0010\u0010\\\u001a\u00020 2\u0006\u0010]\u001a\u00020^H\u0002J\u0010\u0010_\u001a\u00020U2\u0006\u0010[\u001a\u00020\u0012H\u0002J\u0016\u0010`\u001a\u00020U2\f\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0014J\u001a\u0010b\u001a\u00020\u00022\u0006\u0010c\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u00010^H\u0014J\u0010\u0010f\u001a\u00020U2\u0006\u0010g\u001a\u00020\u0012H\u0002J\b\u0010h\u001a\u00020UH\u0016J\b\u0010i\u001a\u00020UH\u0014J\b\u0010j\u001a\u00020UH\u0002R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000eR\u001e\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001bj\b\u0012\u0004\u0012\u00020\u0004`\u001cX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001bj\b\u0012\u0004\u0012\u00020\u001e`\u001cX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020 0\u001bj\b\u0012\u0004\u0012\u00020 `\u001cX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00040\"X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\"X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001bj\b\u0012\u0004\u0012\u00020\u0004`\u001cX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000eR\u0012\u0010(\u001a\u00060)R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR\u001b\u0010-\u001a\u00020.8BX\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b/\u00100R\u001a\u00103\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\f\"\u0004\b5\u0010\u000eR\u001a\u00106\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\f\"\u0004\b8\u0010\u000eR\u001a\u00109\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\f\"\u0004\b;\u0010\u000eR\u001a\u0010<\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0014\"\u0004\b>\u0010\u0016R\u001a\u0010?\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0014\"\u0004\bA\u0010\u0016R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010D\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\f\"\u0004\bF\u0010\u000eR&\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00040\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR&\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010I\"\u0004\bN\u0010KR\u001a\u0010O\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\f\"\u0004\bQ\u0010\u000eR\u000e\u0010R\u001a\u00020SX\u000e¢\u0006\u0002\n\u0000¨\u0006n"}, d2 = {"Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemCoolPicImageViewBinding;", "", "", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroidx/databinding/DataBindingComponent;)V", "bindList", "centerCropWhenOne", "", "getCenterCropWhenOne", "()Z", "setCenterCropWhenOne", "(Z)V", "getComponent", "()Landroidx/databinding/DataBindingComponent;", "constrainMaxHeightWhenOne", "", "getConstrainMaxHeightWhenOne", "()I", "setConstrainMaxHeightWhenOne", "(I)V", "coverSizeWhenOne", "getCoverSizeWhenOne", "setCoverSizeWhenOne", "currentDisplayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "currentImageArgs", "Lcom/coolapk/market/viewholder/v8/image/ImageArgs;", "currentImageViewPartList", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart$ImageViewPart;", "defaultThumbUrlProviderForLoad", "Lkotlin/Function1;", "defaultThumbUrlProviderForNewActivity", "fullDisplayList", "fullSizeWhenOne", "getFullSizeWhenOne", "setFullSizeWhenOne", "handler", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart$GifControlHandler;", "horizonExpandWhenTriple", "getHorizonExpandWhenTriple", "setHorizonExpandWhenTriple", "imageCountView", "Landroid/widget/TextView;", "getImageCountView", "()Landroid/widget/TextView;", "imageCountView$delegate", "Lkotlin/Lazy;", "imageViewClickable", "getImageViewClickable", "setImageViewClickable", "inFeedNews", "getInFeedNews", "setInFeedNews", "inSecondHand", "getInSecondHand", "setInSecondHand", "internalMaxShowCount", "getInternalMaxShowCount", "setInternalMaxShowCount", "maxShowCount", "getMaxShowCount", "setMaxShowCount", "measureAndAddViewRunnable", "Ljava/lang/Runnable;", "squareWhenOne", "getSquareWhenOne", "setSquareWhenOne", "thumbUrlProviderForLoad", "getThumbUrlProviderForLoad", "()Lkotlin/jvm/functions/Function1;", "setThumbUrlProviderForLoad", "(Lkotlin/jvm/functions/Function1;)V", "thumbUrlProviderForNewActivity", "getThumbUrlProviderForNewActivity", "setThumbUrlProviderForNewActivity", "v9LikeMode", "getV9LikeMode", "setV9LikeMode", "viewPool", "Lcom/coolapk/market/widget/hotplug/ViewPartPool;", "cacheImageViews", "", "requireCount", "detachAllChildView", "getMostSuitableImageBinder", "Lcom/coolapk/market/viewholder/v8/image/ImageBinder;", "list", "width", "getUnusedImageViewPart", "frameView", "Landroid/view/ViewGroup;", "measureView", "onBindToContent", "data", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "onImageClick", "position", "onRecycled", "onViewCreated", "removeMeasureAndAddViewRunnable", "Companion", "GifControlHandler", "ImageViewPart", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NinePicViewPart.kt */
public final class NinePicViewPart extends BindingViewPart<ItemCoolPicImageViewBinding, List<? extends String>> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558668;
    private static final SparseIntArray sProgressMap = new SparseIntArray();
    private List<String> bindList;
    private boolean centerCropWhenOne;
    private final DataBindingComponent component;
    private int constrainMaxHeightWhenOne;
    private boolean coverSizeWhenOne;
    private ArrayList<String> currentDisplayList;
    private final ArrayList<ImageArgs> currentImageArgs;
    private final ArrayList<ImageViewPart> currentImageViewPartList;
    private final Function1<ImageArgs, String> defaultThumbUrlProviderForLoad;
    private final Function1<String, String> defaultThumbUrlProviderForNewActivity;
    private final ArrayList<String> fullDisplayList;
    private boolean fullSizeWhenOne;
    private GifControlHandler handler;
    private boolean horizonExpandWhenTriple;
    private final Lazy imageCountView$delegate;
    private boolean imageViewClickable;
    private boolean inFeedNews;
    private boolean inSecondHand;
    private int internalMaxShowCount;
    private int maxShowCount;
    private Runnable measureAndAddViewRunnable;
    private boolean squareWhenOne;
    private Function1<? super ImageArgs, String> thumbUrlProviderForLoad;
    private Function1<? super String, String> thumbUrlProviderForNewActivity;
    private boolean v9LikeMode;
    private ViewPartPool viewPool;

    private final void cacheImageViews(int i) {
    }

    /* access modifiers changed from: private */
    public final TextView getImageCountView() {
        return (TextView) this.imageCountView$delegate.getValue();
    }

    public NinePicViewPart(DataBindingComponent dataBindingComponent) {
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.component = dataBindingComponent;
        ViewPartPool viewPartPool = KotlinExtendKt.getViewPartPool(dataBindingComponent);
        this.viewPool = viewPartPool == null ? new ViewPartPool() : viewPartPool;
        this.handler = new GifControlHandler();
        NinePicViewPart$defaultThumbUrlProviderForLoad$1 ninePicViewPart$defaultThumbUrlProviderForLoad$1 = new NinePicViewPart$defaultThumbUrlProviderForLoad$1(this);
        this.defaultThumbUrlProviderForLoad = ninePicViewPart$defaultThumbUrlProviderForLoad$1;
        NinePicViewPart$defaultThumbUrlProviderForNewActivity$1 ninePicViewPart$defaultThumbUrlProviderForNewActivity$1 = new NinePicViewPart$defaultThumbUrlProviderForNewActivity$1(this);
        this.defaultThumbUrlProviderForNewActivity = ninePicViewPart$defaultThumbUrlProviderForNewActivity$1;
        this.maxShowCount = 9;
        this.imageViewClickable = true;
        this.thumbUrlProviderForLoad = ninePicViewPart$defaultThumbUrlProviderForLoad$1;
        this.thumbUrlProviderForNewActivity = ninePicViewPart$defaultThumbUrlProviderForNewActivity$1;
        this.internalMaxShowCount = Integer.MAX_VALUE;
        this.imageCountView$delegate = LazyKt.lazy(new NinePicViewPart$imageCountView$2(this));
        this.currentDisplayList = new ArrayList<>();
        this.currentImageViewPartList = new ArrayList<>();
        this.currentImageArgs = new ArrayList<>();
        this.fullDisplayList = new ArrayList<>();
    }

    public final DataBindingComponent getComponent() {
        return this.component;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public /* bridge */ /* synthetic */ void onBindToContent(List<? extends String> list) {
        onBindToContent((List<String>) list);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "sProgressMap", "Landroid/util/SparseIntArray;", "shouldShowView", "", "data", "", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: NinePicViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean shouldShowView(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "data");
            if (!list.isEmpty()) {
                if (list.size() != 1) {
                    return true;
                }
                if (!(list.get(0).length() == 0)) {
                    return true;
                }
            }
            return false;
        }
    }

    public final int getMaxShowCount() {
        return this.maxShowCount;
    }

    public final void setMaxShowCount(int i) {
        this.maxShowCount = i;
    }

    public final boolean getFullSizeWhenOne() {
        return this.fullSizeWhenOne;
    }

    public final void setFullSizeWhenOne(boolean z) {
        this.fullSizeWhenOne = z;
    }

    public final boolean getImageViewClickable() {
        return this.imageViewClickable;
    }

    public final void setImageViewClickable(boolean z) {
        this.imageViewClickable = z;
    }

    public final boolean getHorizonExpandWhenTriple() {
        return this.horizonExpandWhenTriple;
    }

    public final void setHorizonExpandWhenTriple(boolean z) {
        this.horizonExpandWhenTriple = z;
    }

    public final boolean getCenterCropWhenOne() {
        return this.centerCropWhenOne;
    }

    public final void setCenterCropWhenOne(boolean z) {
        this.centerCropWhenOne = z;
    }

    public final boolean getCoverSizeWhenOne() {
        return this.coverSizeWhenOne;
    }

    public final void setCoverSizeWhenOne(boolean z) {
        this.coverSizeWhenOne = z;
    }

    public final boolean getSquareWhenOne() {
        return this.squareWhenOne;
    }

    public final void setSquareWhenOne(boolean z) {
        this.squareWhenOne = z;
    }

    public final int getConstrainMaxHeightWhenOne() {
        return this.constrainMaxHeightWhenOne;
    }

    public final void setConstrainMaxHeightWhenOne(int i) {
        this.constrainMaxHeightWhenOne = i;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super com.coolapk.market.viewholder.v8.image.ImageArgs, java.lang.String>, kotlin.jvm.functions.Function1<com.coolapk.market.viewholder.v8.image.ImageArgs, java.lang.String> */
    public final Function1<ImageArgs, String> getThumbUrlProviderForLoad() {
        return this.thumbUrlProviderForLoad;
    }

    public final void setThumbUrlProviderForLoad(Function1<? super ImageArgs, String> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.thumbUrlProviderForLoad = function1;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super java.lang.String, java.lang.String>, kotlin.jvm.functions.Function1<java.lang.String, java.lang.String> */
    public final Function1<String, String> getThumbUrlProviderForNewActivity() {
        return this.thumbUrlProviderForNewActivity;
    }

    public final void setThumbUrlProviderForNewActivity(Function1<? super String, String> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.thumbUrlProviderForNewActivity = function1;
    }

    public final boolean getInSecondHand() {
        return this.inSecondHand;
    }

    public final void setInSecondHand(boolean z) {
        this.inSecondHand = z;
    }

    public final boolean getV9LikeMode() {
        return this.v9LikeMode;
    }

    public final void setV9LikeMode(boolean z) {
        this.v9LikeMode = z;
    }

    public final boolean getInFeedNews() {
        return this.inFeedNews;
    }

    public final void setInFeedNews(boolean z) {
        this.inFeedNews = z;
    }

    public final int getInternalMaxShowCount() {
        return this.internalMaxShowCount;
    }

    public final void setInternalMaxShowCount(int i) {
        this.internalMaxShowCount = i;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemCoolPicImageViewBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558668, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…OUT_ID, viewGroup, false)");
        return (ItemCoolPicImageViewBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        MaxWidthFrameLayout maxWidthFrameLayout = ((ItemCoolPicImageViewBinding) getBinding()).frameView;
        Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout, "binding.frameView");
        ViewGroup.LayoutParams layoutParams = maxWidthFrameLayout.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            marginLayoutParams.bottomMargin = 0;
            marginLayoutParams.topMargin = DisplayUtils.dp2px(getContext(), 8.0f);
        }
        ((ItemCoolPicImageViewBinding) getBinding()).frameView.setMaxWidth(Math.min(DisplayUtils.getWidthPixels(getContext()), DisplayUtils.getHeightPixels(getContext())));
        ((ItemCoolPicImageViewBinding) getBinding()).frameView.addOnAttachStateChangeListener(this.handler);
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        super.onRecycled();
        List emptyList = Collections.emptyList();
        Intrinsics.checkNotNullExpressionValue(emptyList, "Collections.emptyList()");
        bindToContent(emptyList);
        this.maxShowCount = 9;
        this.fullSizeWhenOne = false;
        this.coverSizeWhenOne = false;
        this.imageViewClickable = true;
        this.horizonExpandWhenTriple = false;
        this.centerCropWhenOne = false;
        this.squareWhenOne = false;
        this.constrainMaxHeightWhenOne = 0;
        this.inSecondHand = false;
        this.thumbUrlProviderForLoad = this.defaultThumbUrlProviderForLoad;
        this.thumbUrlProviderForNewActivity = this.defaultThumbUrlProviderForNewActivity;
        this.v9LikeMode = false;
        removeMeasureAndAddViewRunnable();
        this.handler.clearAll();
    }

    private final void removeMeasureAndAddViewRunnable() {
        Runnable runnable = this.measureAndAddViewRunnable;
        if (runnable != null) {
            ((ItemCoolPicImageViewBinding) getBinding()).frameView.removeCallbacks(runnable);
        }
        this.measureAndAddViewRunnable = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003f, code lost:
        if (r2 != false) goto L_0x00b4;
     */
    protected void onBindToContent(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        super.onBindToContent((NinePicViewPart) list);
        removeMeasureAndAddViewRunnable();
        this.bindList = list;
        ((ItemCoolPicImageViewBinding) getBinding()).executePendingBindings();
        MaxWidthFrameLayout maxWidthFrameLayout = ((ItemCoolPicImageViewBinding) getBinding()).frameView;
        Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout, "binding.frameView");
        if (!list.isEmpty()) {
            boolean z = true;
            if (list.size() == 1) {
                if (list.get(0).length() != 0) {
                    z = false;
                }
            }
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            int i = this.maxShowCount;
            if (size <= i || i <= 0) {
                arrayList.addAll(list);
            } else {
                arrayList.addAll(list.subList(0, i));
            }
            if (!Intrinsics.areEqual(this.currentDisplayList, arrayList)) {
                detachAllChildView();
                this.currentDisplayList.clear();
                this.currentDisplayList.addAll(arrayList);
                this.fullDisplayList.clear();
                this.fullDisplayList.addAll(list);
                maxWidthFrameLayout.setVisibility(0);
                maxWidthFrameLayout.requestLayout();
                ((ItemCoolPicImageViewBinding) getBinding()).frameView.setOnMeasureWidth(new NinePicViewPart$onBindToContent$1(this));
                MainSpareHandler.Companion.getSInstance().post(new NinePicViewPart$onBindToContent$2(this, this.currentDisplayList.size()));
                return;
            }
            return;
        }
        maxWidthFrameLayout.setVisibility(8);
        maxWidthFrameLayout.requestLayout();
        detachAllChildView();
        this.currentDisplayList.clear();
        this.currentImageArgs.clear();
        this.currentImageViewPartList.clear();
        this.fullDisplayList.clear();
        ((ItemCoolPicImageViewBinding) getBinding()).frameView.setOnMeasureWidth(null);
    }

    /* access modifiers changed from: private */
    public final void measureView(int i) {
        MaxWidthFrameLayout maxWidthFrameLayout = ((ItemCoolPicImageViewBinding) getBinding()).frameView;
        Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout, "binding.frameView");
        if (i > 0) {
            detachAllChildView();
            ImageBinder mostSuitableImageBinder = getMostSuitableImageBinder(this.currentDisplayList, i);
            ArrayList<ImageArgs> imagePreArgs = mostSuitableImageBinder.getImagePreArgs();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(imagePreArgs, 10));
            Iterator<T> it2 = imagePreArgs.iterator();
            while (it2.hasNext()) {
                arrayList.add(ImageArgs.copy$default(it2.next(), null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, 127, null));
            }
            maxWidthFrameLayout.getLayoutParams().height = (int) mostSuitableImageBinder.getOutContainerHeight();
            maxWidthFrameLayout.requestLayout();
            removeMeasureAndAddViewRunnable();
            this.measureAndAddViewRunnable = new NinePicViewPart$measureView$1(this, arrayList, maxWidthFrameLayout);
            ((ItemCoolPicImageViewBinding) getBinding()).frameView.post(this.measureAndAddViewRunnable);
        }
    }

    /* access modifiers changed from: private */
    public final ImageViewPart getUnusedImageViewPart(ViewGroup viewGroup) {
        ImageViewPart imageViewPart = (ImageViewPart) this.viewPool.getRecycledViewPart(2131558714);
        if (imageViewPart != null) {
            imageViewPart.setParentViewPart(this);
            return imageViewPart;
        }
        ImageViewPart imageViewPart2 = new ImageViewPart(this.component);
        imageViewPart2.setParentViewPart(this);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(frameView.context)");
        imageViewPart2.createView(from, viewGroup);
        return imageViewPart2;
    }

    /* access modifiers changed from: private */
    public final void detachAllChildView() {
        ((ItemCoolPicImageViewBinding) getBinding()).frameView.removeAllViews();
        Iterator<T> it2 = this.currentImageViewPartList.iterator();
        while (it2.hasNext()) {
            this.viewPool.putRecycledViewPart(it2.next(), 2131558714);
        }
        this.currentImageViewPartList.clear();
    }

    private final ImageBinder getMostSuitableImageBinder(List<String> list, int i) {
        ConstrainMaxHeightBinder constrainMaxHeightBinder;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        this.internalMaxShowCount = Integer.MAX_VALUE;
        for (T t : list) {
            AppPictureSizeManager.PictureSize size2 = AppPictureSizeManager.getInstance().getSize(t);
            arrayList.add(new ImageArgs(t, size2 != null ? ((float) size2.getWidth()) / ((float) size2.getHeight()) : 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, 124, null));
        }
        if (this.inSecondHand) {
            constrainMaxHeightBinder = NinePicBindersKt.getVERTICAL_BINDER();
        } else if (this.squareWhenOne && size == 1) {
            constrainMaxHeightBinder = NinePicBindersKt.getSINGLE_SQUARE_BINDER();
        } else if (this.fullSizeWhenOne && size == 1) {
            constrainMaxHeightBinder = NinePicBindersKt.getFULL_SIZE_SINGLE_BINDER();
        } else if (this.centerCropWhenOne && size == 1) {
            constrainMaxHeightBinder = NinePicBindersKt.getCENTER_CROP_SINGLE_BINDER();
        } else if (this.coverSizeWhenOne && size == 1) {
            constrainMaxHeightBinder = NinePicBindersKt.getCOVER_SIZE_SINGLE_BINDER();
        } else if (this.constrainMaxHeightWhenOne > 0 && size == 1) {
            constrainMaxHeightBinder = ConstrainMaxHeightBinder.Companion.newInstance(this.constrainMaxHeightWhenOne);
        } else if (this.horizonExpandWhenTriple && size == 3) {
            constrainMaxHeightBinder = NinePicBindersKt.getTRIPLE_EXPANDED_BINDER();
        } else if (this.inFeedNews && size == 3) {
            constrainMaxHeightBinder = NinePicBindersKt.getTRIPLE_EXPANDED_FEED_NEWS_BINDER();
        } else if (size == 1) {
            constrainMaxHeightBinder = NinePicBindersKt.getSINGLE_BINDER();
        } else if (this.v9LikeMode) {
            constrainMaxHeightBinder = NinePicBindersKt.getAUTO_BINDER();
        } else if (size == 2) {
            constrainMaxHeightBinder = NinePicBindersKt.getTWO_PICS_BINDER();
        } else if (size <= 5) {
            constrainMaxHeightBinder = NinePicBindersKt.getTHREE_PICS_BINDER();
            this.internalMaxShowCount = 3;
        } else if (size <= 8) {
            constrainMaxHeightBinder = NinePicBindersKt.getSIX_PICS_BINDER();
            this.internalMaxShowCount = 6;
        } else {
            constrainMaxHeightBinder = NinePicBindersKt.getNINE_PICS_BINDER();
            this.internalMaxShowCount = 9;
        }
        constrainMaxHeightBinder.reset();
        constrainMaxHeightBinder.setup(arrayList);
        constrainMaxHeightBinder.calculate((float) i);
        return constrainMaxHeightBinder;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0001\u001eB\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0003H\u0014J\u001a\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0014J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\u000e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart$ImageViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemFeedImageBinding;", "Lcom/coolapk/market/viewholder/v8/image/ImageArgs;", "Lcom/coolapk/market/widget/view/ControlGifImageView$Callback;", "Ljava/lang/Runnable;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroidx/databinding/DataBindingComponent;)V", "getComponent", "()Landroidx/databinding/DataBindingComponent;", "data", "parentViewPart", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "selectedItemBackground", "Landroid/graphics/drawable/Drawable;", "onBindToContent", "", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onGifDisplayFinish", "onGifLoaded", "onRecycled", "onViewCreated", "run", "setParentViewPart", "viewPart", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: NinePicViewPart.kt */
    public static final class ImageViewPart extends BindingViewPart<ItemFeedImageBinding, ImageArgs> implements ControlGifImageView.Callback, Runnable {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558714;
        private final DataBindingComponent component;
        private ImageArgs data;
        private NinePicViewPart parentViewPart;
        private Drawable selectedItemBackground;

        public ImageViewPart(DataBindingComponent dataBindingComponent) {
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            this.component = dataBindingComponent;
        }

        public final DataBindingComponent getComponent() {
            return this.component;
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart$ImageViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: NinePicViewPart.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.coolapk.market.viewholder.iview.BindingViewPart
        public ItemFeedImageBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
            ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558714, viewGroup, false, this.component);
            Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…wGroup, false, component)");
            return (ItemFeedImageBinding) inflate;
        }

        @Override // com.coolapk.market.viewholder.iview.ViewPart
        protected void onViewCreated() {
            super.onViewCreated();
            GlideImageHelper.setClickToLoad(((ItemFeedImageBinding) getBinding()).imageView, true);
            if (Build.VERSION.SDK_INT >= 23) {
                ControlGifImageView controlGifImageView = ((ItemFeedImageBinding) getBinding()).imageView;
                Intrinsics.checkNotNullExpressionValue(controlGifImageView, "binding.imageView");
                this.selectedItemBackground = controlGifImageView.getForeground();
            }
        }

        public final void setParentViewPart(NinePicViewPart ninePicViewPart) {
            Intrinsics.checkNotNullParameter(ninePicViewPart, "viewPart");
            this.parentViewPart = ninePicViewPart;
        }

        @Override // com.coolapk.market.viewholder.iview.ViewPart, com.coolapk.market.viewholder.iview.Recyclable
        public void onRecycled() {
            super.onRecycled();
            this.parentViewPart = null;
            ControlGifImageView controlGifImageView = ((ItemFeedImageBinding) getBinding()).imageView;
            Intrinsics.checkNotNullExpressionValue(controlGifImageView, "binding.imageView");
            Context context = controlGifImageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "binding.imageView.context");
            Activity activityNullable = UiUtils.getActivityNullable(context);
            if (activityNullable != null && !activityNullable.isDestroyed()) {
                GlideApp.with(activityNullable).clear(((ItemFeedImageBinding) getBinding()).imageView);
            }
            ((ItemFeedImageBinding) getBinding()).imageView.setOnClickListener(null);
            ((ItemFeedImageBinding) getBinding()).imageView.setImageDrawable(null);
            ((ItemFeedImageBinding) getBinding()).imageView.setCallBack(null);
            ((ItemFeedImageBinding) getBinding()).progressBar.setMonitorUrl(null);
            ((ItemFeedImageBinding) getBinding()).imageView.removeCallbacks(this);
        }

        /* access modifiers changed from: protected */
        public void onBindToContent(ImageArgs imageArgs) {
            Intrinsics.checkNotNullParameter(imageArgs, "data");
            super.onBindToContent((ImageViewPart) imageArgs);
            View root = ((ItemFeedImageBinding) getBinding()).getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
            if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
                layoutParams = null;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            if (layoutParams2 != null) {
                layoutParams2.height = (int) imageArgs.getOutHeight();
                layoutParams2.width = (int) imageArgs.getOutWidth();
            }
            View root2 = ((ItemFeedImageBinding) getBinding()).getRoot();
            root2.setX(imageArgs.getOutOffsetX());
            root2.setY(imageArgs.getOutOffsetY());
            ((ItemFeedImageBinding) getBinding()).imageView.setImageResource(ResourceUtils.getDayNightPlaceHolder(2131231702));
            this.data = imageArgs;
            ((ItemFeedImageBinding) getBinding()).imageView.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            NinePicViewPart ninePicViewPart;
            ImageArgs imageArgs = this.data;
            if (imageArgs != null && (ninePicViewPart = this.parentViewPart) != null) {
                ArrayList arrayList = ninePicViewPart.currentDisplayList;
                GifControlHandler gifControlHandler = ninePicViewPart.handler;
                Function1<ImageArgs, String> thumbUrlProviderForLoad = ninePicViewPart.getThumbUrlProviderForLoad();
                boolean imageViewClickable = ninePicViewPart.getImageViewClickable();
                NinePicViewPart$ImageViewPart$run$onImageClick$1 ninePicViewPart$ImageViewPart$run$onImageClick$1 = new NinePicViewPart$ImageViewPart$run$onImageClick$1(ninePicViewPart);
                List list = ninePicViewPart.bindList;
                FrameLayout frameLayout = ((ItemFeedImageBinding) getBinding()).frameView;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.frameView");
                ViewExtendsKt.darkForegroundIfNeed(frameLayout);
                float dp = (float) NumberExtendsKt.getDp((Number) 8);
                DividerLineView dividerLineView = ((ItemFeedImageBinding) getBinding()).dividerView;
                dividerLineView.setTopLeftRadius(imageArgs.hasFlag(1) ? dp : 0.0f);
                dividerLineView.setTopRightRadius(imageArgs.hasFlag(2) ? dp : 0.0f);
                dividerLineView.setBottomRightRadius(imageArgs.hasFlag(8) ? dp : 0.0f);
                if (!imageArgs.hasFlag(4)) {
                    dp = 0.0f;
                }
                dividerLineView.setBottomLeftRadius(dp);
                dividerLineView.setBorderColor(AppHolder.getAppTheme().isDarkTheme() ? 0 : AppHolder.getAppTheme().getCurrencyColorDivider());
                dividerLineView.setBorderWidthPx((float) NumberExtendsKt.getDp(Double.valueOf(0.5d)));
                ControlGifImageView controlGifImageView = ((ItemFeedImageBinding) getBinding()).imageView;
                Intrinsics.checkNotNullExpressionValue(controlGifImageView, "binding.imageView");
                BinderHelperKt.updateClipFlag$default(controlGifImageView, imageArgs.getOutFlags(), 0, 2, null);
                boolean z = arrayList.size() == 1;
                ((ItemFeedImageBinding) getBinding()).imageView.setCallBack(this);
                String inSource = imageArgs.getInSource();
                int indexOf = arrayList.indexOf(inSource);
                boolean z2 = imageArgs.isGifUrl() && AppHolder.getAppSetting().shouldLoadSourcePhoto();
                boolean z3 = indexOf == gifControlHandler.getCurrentGifIndex();
                ControlGifImageView controlGifImageView2 = ((ItemFeedImageBinding) getBinding()).imageView;
                Intrinsics.checkNotNullExpressionValue(controlGifImageView2, "binding.imageView");
                controlGifImageView2.setContentDescription("图片 " + (indexOf + 1));
                String str = (!z2 || !z3) ? null : inSource;
                String invoke = thumbUrlProviderForLoad.invoke(imageArgs);
                ((ItemFeedImageBinding) getBinding()).setImgUrl(invoke);
                if (imageViewClickable) {
                    ControlGifImageView controlGifImageView3 = ((ItemFeedImageBinding) getBinding()).imageView;
                    Intrinsics.checkNotNullExpressionValue(controlGifImageView3, "binding.imageView");
                    ViewExtendsKt.setUtilClickListener(controlGifImageView3, new NinePicViewPart$ImageViewPart$run$2(ninePicViewPart$ImageViewPart$run$onImageClick$1, indexOf));
                } else {
                    ((ItemFeedImageBinding) getBinding()).imageView.setOnClickListener(null);
                    ControlGifImageView controlGifImageView4 = ((ItemFeedImageBinding) getBinding()).imageView;
                    Intrinsics.checkNotNullExpressionValue(controlGifImageView4, "binding.imageView");
                    controlGifImageView4.setClickable(false);
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    ControlGifImageView controlGifImageView5 = ((ItemFeedImageBinding) getBinding()).imageView;
                    Intrinsics.checkNotNullExpressionValue(controlGifImageView5, "binding.imageView");
                    controlGifImageView5.setForeground(imageViewClickable ? this.selectedItemBackground : null);
                }
                NinePicViewPart$ImageViewPart$run$3 ninePicViewPart$ImageViewPart$run$3 = null;
                if (z && imageArgs.getInRatio() == 1.0f && AppPictureSizeManager.getInstance().getSize(inSource) == null) {
                    ControlGifImageView controlGifImageView6 = ((ItemFeedImageBinding) getBinding()).imageView;
                    Intrinsics.checkNotNullExpressionValue(controlGifImageView6, "binding.imageView");
                    controlGifImageView6.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ninePicViewPart$ImageViewPart$run$3 = new NinePicViewPart$ImageViewPart$run$3(this, inSource, arrayList, list, ninePicViewPart);
                } else {
                    ControlGifImageView controlGifImageView7 = ((ItemFeedImageBinding) getBinding()).imageView;
                    Intrinsics.checkNotNullExpressionValue(controlGifImageView7, "binding.imageView");
                    controlGifImageView7.setScaleType(ImageView.ScaleType.MATRIX);
                }
                AppHolder.getContextImageLoader().displayImage(getContext(), str != null ? str : invoke, (ImageView) ((ItemFeedImageBinding) getBinding()).imageView, ImageLoaderOptions.newBuilder().useAnimate(true).thumbnail(str == null ? null : invoke).placeHolderRes(2131231702).build(), ninePicViewPart$ImageViewPart$run$3, (OnBitmapTransformListener) null);
                ControlGifImageView controlGifImageView8 = ((ItemFeedImageBinding) getBinding()).imageView;
                Intrinsics.checkNotNullExpressionValue(controlGifImageView8, "binding.imageView");
                controlGifImageView8.setScaleType(ImageView.ScaleType.MATRIX);
                ((ItemFeedImageBinding) getBinding()).progressBar.setMonitorUrl(str);
                TextViewBindingAdapters.setGifIndicatorVisibility(((ItemFeedImageBinding) getBinding()).gifIndicator, str != null ? null : invoke, imageArgs.hasFlag(8));
            }
        }

        @Override // com.coolapk.market.widget.view.ControlGifImageView.Callback
        public void onGifDisplayFinish() {
            NinePicViewPart ninePicViewPart = this.parentViewPart;
            if (ninePicViewPart != null) {
                ninePicViewPart.handler.onLoadFinished();
            }
        }

        @Override // com.coolapk.market.widget.view.ControlGifImageView.Callback
        public void onGifLoaded() {
            ImageLoadProgressBar imageLoadProgressBar = ((ItemFeedImageBinding) getBinding()).progressBar;
            Intrinsics.checkNotNullExpressionValue(imageLoadProgressBar, "binding.progressBar");
            if (imageLoadProgressBar.isShown()) {
                ((ItemFeedImageBinding) getBinding()).progressBar.onDownloaded();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void onImageClick(int i) {
        Rect[] rectArr = new Rect[this.fullDisplayList.size()];
        String[] strArr = new String[this.fullDisplayList.size()];
        int i2 = 0;
        for (T t : this.currentImageViewPartList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            ControlGifImageView controlGifImageView = ((ItemFeedImageBinding) t2.getBinding()).imageView;
            Intrinsics.checkNotNullExpressionValue(controlGifImageView, "imageViewPart.binding.imageView");
            rectArr[i2] = ViewExtendsKt.getGlobalRectInsetPadding(controlGifImageView);
            strArr[i2] = ((ItemFeedImageBinding) t2.getBinding()).getImgUrl();
            i2 = i3;
        }
        Activity activity = UiUtils.getActivity(getContext());
        Intrinsics.checkNotNullExpressionValue(activity, "UiUtils.getActivity(context)");
        Object[] array = this.fullDisplayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        String[] strArr2 = (String[]) array;
        ArrayList<String> arrayList = this.fullDisplayList;
        Function1<? super String, String> function1 = this.thumbUrlProviderForNewActivity;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator<T> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(function1.invoke(it2.next()));
        }
        Object[] array2 = arrayList2.toArray(new String[0]);
        Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
        ActionManagerCompat.startPhotoViewActivity$default(activity, strArr2, (String[]) array2, i, "", strArr, rectArr, false, null, 256, null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0018H\u0007J\u0006\u0010\u0019\u001a\u00020\u000fJ\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0004H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006 "}, d2 = {"Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart$GifControlHandler;", "Landroid/view/View$OnAttachStateChangeListener;", "(Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;)V", "currentGifIndex", "", "getCurrentGifIndex", "()I", "setCurrentGifIndex", "(I)V", "isGifAvailable", "", "()Z", "setGifAvailable", "(Z)V", "checkGif", "", "clearAll", "getShownGifList", "", "Lcom/coolapk/market/viewholder/v8/image/ImageArgs;", "onActivityPause", "event", "Lcom/coolapk/market/event/ActivityPauseEvent;", "onActivityResume", "Lcom/coolapk/market/event/ActivityResumeEvent;", "onLoadFinished", "onViewAttachedToWindow", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "postToRefresh", "index", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: NinePicViewPart.kt */
    public final class GifControlHandler implements View.OnAttachStateChangeListener {
        private int currentGifIndex = -1;
        private boolean isGifAvailable = true;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public GifControlHandler() {
        }

        public final boolean isGifAvailable() {
            return this.isGifAvailable;
        }

        public final void setGifAvailable(boolean z) {
            this.isGifAvailable = z;
        }

        public final int getCurrentGifIndex() {
            return this.currentGifIndex;
        }

        public final void setCurrentGifIndex(int i) {
            this.currentGifIndex = i;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Intrinsics.checkNotNullParameter(view, "v");
            if (EventBus.getDefault().isRegistered(this)) {
                EventBus.getDefault().unregister(this);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Intrinsics.checkNotNullParameter(view, "v");
            if (!EventBus.getDefault().isRegistered(this)) {
                EventBus.getDefault().register(this);
            }
        }

        @Subscribe
        public final void onActivityResume(ActivityResumeEvent activityResumeEvent) {
            Intrinsics.checkNotNullParameter(activityResumeEvent, "event");
            View root = ((ItemCoolPicImageViewBinding) NinePicViewPart.this.getBinding()).getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            Context context = root.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
            Activity activityNullable = UiUtils.getActivityNullable(context);
            Intrinsics.checkNotNull(activityNullable);
            if (!activityNullable.isFinishing() && activityResumeEvent.isSameActivity(activityNullable)) {
                this.isGifAvailable = true;
                if (this.currentGifIndex < 0) {
                    int i = NinePicViewPart.sProgressMap.get(NinePicViewPart.this.currentDisplayList.hashCode(), this.currentGifIndex);
                    this.currentGifIndex = i;
                    if (i >= 0) {
                        postToRefresh(i);
                    }
                }
            }
        }

        @Subscribe
        public final void onActivityPause(ActivityPauseEvent activityPauseEvent) {
            Intrinsics.checkNotNullParameter(activityPauseEvent, "event");
            View root = ((ItemCoolPicImageViewBinding) NinePicViewPart.this.getBinding()).getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            Context context = root.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
            Activity activityNullable = UiUtils.getActivityNullable(context);
            Intrinsics.checkNotNull(activityNullable);
            if (!activityNullable.isFinishing() && activityPauseEvent.isSameActivity(activityNullable)) {
                this.isGifAvailable = false;
                if (this.currentGifIndex >= 0) {
                    NinePicViewPart.sProgressMap.put(NinePicViewPart.this.currentDisplayList.hashCode(), this.currentGifIndex);
                    int i = this.currentGifIndex;
                    this.currentGifIndex = -1;
                    postToRefresh(i);
                }
            }
        }

        public final void checkGif() {
            int i;
            if (this.isGifAvailable || (i = this.currentGifIndex) < 0) {
                List<ImageArgs> shownGifList = getShownGifList();
                if (!shownGifList.isEmpty() && this.currentGifIndex < 0) {
                    int indexOf = NinePicViewPart.this.currentImageArgs.indexOf(shownGifList.get(0));
                    this.currentGifIndex = indexOf;
                    postToRefresh(indexOf);
                    return;
                }
                return;
            }
            this.currentGifIndex = -1;
            postToRefresh(i);
        }

        public final void onLoadFinished() {
            List<ImageArgs> shownGifList = getShownGifList();
            if (!shownGifList.isEmpty()) {
                if (this.currentGifIndex < 0) {
                    int indexOf = NinePicViewPart.this.currentImageArgs.indexOf(shownGifList.get(0));
                    this.currentGifIndex = indexOf;
                    postToRefresh(indexOf);
                } else if (shownGifList.size() != 1) {
                    int indexOf2 = shownGifList.indexOf(NinePicViewPart.this.currentImageArgs.get(this.currentGifIndex));
                    int i = this.currentGifIndex;
                    if (indexOf2 == CollectionsKt.getLastIndex(shownGifList)) {
                        this.currentGifIndex = NinePicViewPart.this.currentImageArgs.indexOf(shownGifList.get(0));
                    } else {
                        this.currentGifIndex = NinePicViewPart.this.currentImageArgs.indexOf(shownGifList.get(indexOf2 + 1));
                    }
                    postToRefresh(i);
                    postToRefresh(this.currentGifIndex);
                    if (this.currentGifIndex >= 0) {
                        NinePicViewPart.sProgressMap.put(NinePicViewPart.this.currentDisplayList.hashCode(), this.currentGifIndex);
                    }
                }
            }
        }

        private final List<ImageArgs> getShownGifList() {
            ArrayList arrayList = new ArrayList();
            for (Object obj : NinePicViewPart.this.currentImageArgs) {
                ImageArgs imageArgs = (ImageArgs) obj;
                if (imageArgs.isGifUrl() && imageArgs.canBeShow()) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }

        private final void postToRefresh(int i) {
            ((ItemCoolPicImageViewBinding) NinePicViewPart.this.getBinding()).getRoot().post(new NinePicViewPart$GifControlHandler$postToRefresh$1(this, i));
        }

        public final void clearAll() {
            this.currentGifIndex = -1;
        }
    }
}
