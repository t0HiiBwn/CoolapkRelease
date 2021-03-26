package com.coolapk.market.viewholder.v8.image;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemCoolPicImageBinding;
import com.coolapk.market.databinding.ItemCoolPicImageViewBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideImageHelper;
import com.coolapk.market.manager.AppPictureSizeManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import com.coolapk.market.widget.hotplug.ViewPartPool;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import com.coolapk.market.widget.view.ScalingImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 (2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002()B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u001e\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0003H\u0014J\u001a\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\b\u0010'\u001a\u00020\u0016H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/coolapk/market/viewholder/v8/image/CoolPicViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemCoolPicImageViewBinding;", "Lcom/coolapk/market/model/Feed;", "component", "Lcom/coolapk/market/binding/FragmentBindingComponent;", "(Lcom/coolapk/market/binding/FragmentBindingComponent;)V", "bindFeed", "getComponent", "()Lcom/coolapk/market/binding/FragmentBindingComponent;", "currentDisplayList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "params", "getParams", "()Ljava/lang/String;", "setParams", "(Ljava/lang/String;)V", "viewPartPool", "Lcom/coolapk/market/widget/hotplug/ViewPartPool;", "detachAndCacheChildView", "", "getMostSuitableImageBinder", "Lcom/coolapk/market/viewholder/v8/image/ImageBinder;", "list", "", "width", "", "getUnusedImageView", "Lcom/coolapk/market/viewholder/v8/image/CoolPicViewPart$ImageViewPart;", "measureView", "onBindToContent", "data", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onRecycled", "Companion", "ImageViewPart", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolPicViewPart.kt */
public final class CoolPicViewPart extends BindingViewPart<ItemCoolPicImageViewBinding, Feed> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558668;
    private static final Function1<String, String> thumbUrlProvider = new CoolPicViewPart$Companion$thumbUrlProvider$1(ImageArgs.Companion);
    private Feed bindFeed;
    private final FragmentBindingComponent component;
    private ArrayList<String> currentDisplayList = new ArrayList<>();
    private String params;
    private final ViewPartPool viewPartPool;

    public CoolPicViewPart(FragmentBindingComponent fragmentBindingComponent) {
        Intrinsics.checkNotNullParameter(fragmentBindingComponent, "component");
        this.component = fragmentBindingComponent;
        ViewPartPool viewPartPool2 = KotlinExtendKt.getViewPartPool(fragmentBindingComponent);
        this.viewPartPool = viewPartPool2 == null ? new ViewPartPool() : viewPartPool2;
    }

    public final FragmentBindingComponent getComponent() {
        return this.component;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/viewholder/v8/image/CoolPicViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "thumbUrlProvider", "Lkotlin/Function1;", "", "Lcom/coolapk/market/viewholder/v8/image/ThumbUrlProvider;", "getThumbUrlProvider", "()Lkotlin/jvm/functions/Function1;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CoolPicViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Function1<String, String> getThumbUrlProvider() {
            return CoolPicViewPart.thumbUrlProvider;
        }
    }

    public final String getParams() {
        return this.params;
    }

    public final void setParams(String str) {
        this.params = str;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemCoolPicImageViewBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558668, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…OUT_ID, viewGroup, false)");
        return (ItemCoolPicImageViewBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        super.onRecycled();
        this.bindFeed = null;
        this.params = null;
        this.currentDisplayList.clear();
        detachAndCacheChildView();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0045, code lost:
        if (r2 != false) goto L_0x0076;
     */
    public void onBindToContent(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "data");
        super.onBindToContent((CoolPicViewPart) feed);
        this.bindFeed = feed;
        ((ItemCoolPicImageViewBinding) getBinding()).executePendingBindings();
        MaxWidthFrameLayout maxWidthFrameLayout = ((ItemCoolPicImageViewBinding) getBinding()).frameView;
        Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout, "binding.frameView");
        List<String> picArray = feed.getPicArray();
        if (!picArray.isEmpty()) {
            boolean z = true;
            if (picArray.size() == 1) {
                String str = picArray.get(0);
                Intrinsics.checkNotNullExpressionValue(str, "list.get(0)");
                if (str.length() != 0) {
                    z = false;
                }
            }
            if (!Intrinsics.areEqual(this.currentDisplayList, picArray)) {
                this.currentDisplayList.clear();
                this.currentDisplayList.addAll(picArray);
                maxWidthFrameLayout.setVisibility(0);
                maxWidthFrameLayout.requestLayout();
                ((ItemCoolPicImageViewBinding) getBinding()).frameView.setOnMeasureWidth(new CoolPicViewPart$onBindToContent$1(this));
                return;
            }
            return;
        }
        maxWidthFrameLayout.setVisibility(8);
        maxWidthFrameLayout.requestLayout();
        detachAndCacheChildView();
        this.currentDisplayList.clear();
        ((ItemCoolPicImageViewBinding) getBinding()).frameView.setOnMeasureWidth(null);
    }

    /* access modifiers changed from: private */
    public final void measureView(int i) {
        MaxWidthFrameLayout maxWidthFrameLayout = ((ItemCoolPicImageViewBinding) getBinding()).frameView;
        Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout, "binding.frameView");
        detachAndCacheChildView();
        ImageBinder mostSuitableImageBinder = getMostSuitableImageBinder(this.currentDisplayList, i);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(mostSuitableImageBinder.getImagePreArgs());
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ImageArgs imageArgs = (ImageArgs) it2.next();
            ImageViewPart unusedImageView = getUnusedImageView();
            maxWidthFrameLayout.addView(unusedImageView.getView());
            Intrinsics.checkNotNullExpressionValue(imageArgs, "imageArg");
            unusedImageView.bindToContent(imageArgs);
            unusedImageView.getView().setTag(2131363510, unusedImageView);
            ViewExtendsKt.setUtilClickListener(unusedImageView.getView(), new CoolPicViewPart$measureView$1(this, imageArgs, mostSuitableImageBinder, maxWidthFrameLayout));
        }
        maxWidthFrameLayout.getLayoutParams().height = (int) mostSuitableImageBinder.getOutContainerHeight();
    }

    private final ImageViewPart getUnusedImageView() {
        ImageViewPart imageViewPart = (ImageViewPart) this.viewPartPool.getRecycledViewPart(2131558667);
        if (imageViewPart != null) {
            return imageViewPart;
        }
        ImageViewPart imageViewPart2 = new ImageViewPart(this.component);
        ItemCoolPicImageViewBinding itemCoolPicImageViewBinding = (ItemCoolPicImageViewBinding) getBinding();
        View root = itemCoolPicImageViewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        LayoutInflater from = LayoutInflater.from(root.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(binding.root.context)");
        imageViewPart2.createView(from, itemCoolPicImageViewBinding.frameView);
        return imageViewPart2;
    }

    private final void detachAndCacheChildView() {
        MaxWidthFrameLayout maxWidthFrameLayout = ((ItemCoolPicImageViewBinding) getBinding()).frameView;
        Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout, "binding.frameView");
        int childCount = maxWidthFrameLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            Object tag = ((ItemCoolPicImageViewBinding) getBinding()).frameView.getChildAt(i).getTag(2131363510);
            if (!(tag instanceof ImageViewPart)) {
                tag = null;
            }
            ImageViewPart imageViewPart = (ImageViewPart) tag;
            Intrinsics.checkNotNull(imageViewPart);
            this.viewPartPool.putRecycledViewPart(imageViewPart, 2131558667);
        }
        ((ItemCoolPicImageViewBinding) getBinding()).frameView.removeAllViews();
    }

    private final ImageBinder getMostSuitableImageBinder(List<String> list, int i) {
        CoolPicViewPartKt$T1_BINDER$1 coolPicViewPartKt$T1_BINDER$1;
        float f;
        float floatValue;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (T t : list) {
            AppPictureSizeManager.PictureSize size2 = AppPictureSizeManager.getInstance().getSize(t);
            if (size2 != null) {
                floatValue = ((float) size2.getWidth()) / ((float) size2.getHeight());
            } else {
                if (list.size() == 1) {
                    Feed feed = this.bindFeed;
                    if (feed != null) {
                        floatValue = Float.valueOf(KotlinExtendKt.getPicRatio(feed)).floatValue();
                    }
                }
                f = 1.0f;
                arrayList.add(new ImageArgs(t, f, 0.0f, 0.0f, 0.0f, 0.0f, 0, 124, null));
            }
            f = floatValue;
            arrayList.add(new ImageArgs(t, f, 0.0f, 0.0f, 0.0f, 0.0f, 0, 124, null));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((ImageArgs) obj).isVertical()) {
                arrayList2.add(obj);
            }
        }
        int size3 = arrayList2.size();
        if (size == 9) {
            coolPicViewPartKt$T1_BINDER$1 = CoolPicViewPartKt.access$getT9_OTHER_BINDER$p();
        } else if (size == 8) {
            coolPicViewPartKt$T1_BINDER$1 = CoolPicViewPartKt.access$getT8_OTHER_BINDER$p();
        } else if (size == 7) {
            coolPicViewPartKt$T1_BINDER$1 = CoolPicViewPartKt.access$getT7_OTHER_BINDER$p();
        } else if (size == 6) {
            coolPicViewPartKt$T1_BINDER$1 = CoolPicViewPartKt.access$getT6_OTHER_BINDER$p();
        } else if (size == 5) {
            coolPicViewPartKt$T1_BINDER$1 = CoolPicViewPartKt.access$getT5_OTHER_BINDER$p();
        } else if (size == 4 && size3 == 3) {
            coolPicViewPartKt$T1_BINDER$1 = CoolPicViewPartKt.access$getT4_V3_H1_BINDER$p();
        } else if (size == 4) {
            coolPicViewPartKt$T1_BINDER$1 = CoolPicViewPartKt.access$getT4_OTHER_BINDER$p();
        } else if (size == 3 && size3 == 0) {
            coolPicViewPartKt$T1_BINDER$1 = CoolPicViewPartKt.access$getT3_H3_BINDER$p();
        } else if (size == 3) {
            coolPicViewPartKt$T1_BINDER$1 = CoolPicViewPartKt.access$getT3_V1H2_BINDER$p();
        } else if (size == 2) {
            coolPicViewPartKt$T1_BINDER$1 = CoolPicViewPartKt.access$getT2_BINDER$p();
        } else if (size == 1) {
            coolPicViewPartKt$T1_BINDER$1 = CoolPicViewPartKt.access$getT1_BINDER$p();
        } else {
            coolPicViewPartKt$T1_BINDER$1 = CoolPicViewPartKt.access$getT1_BINDER$p();
        }
        coolPicViewPartKt$T1_BINDER$1.reset();
        coolPicViewPartKt$T1_BINDER$1.setup(arrayList);
        coolPicViewPartKt$T1_BINDER$1.calculate((float) i);
        return coolPicViewPartKt$T1_BINDER$1;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0014J\u001a\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/viewholder/v8/image/CoolPicViewPart$ImageViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemCoolPicImageBinding;", "Lcom/coolapk/market/viewholder/v8/image/ImageArgs;", "component", "Lcom/coolapk/market/binding/FragmentBindingComponent;", "(Lcom/coolapk/market/binding/FragmentBindingComponent;)V", "getComponent", "()Lcom/coolapk/market/binding/FragmentBindingComponent;", "onBindToContent", "", "data", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onRecycled", "onViewCreated", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CoolPicViewPart.kt */
    public static final class ImageViewPart extends BindingViewPart<ItemCoolPicImageBinding, ImageArgs> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558667;
        private final FragmentBindingComponent component;

        public ImageViewPart(FragmentBindingComponent fragmentBindingComponent) {
            Intrinsics.checkNotNullParameter(fragmentBindingComponent, "component");
            this.component = fragmentBindingComponent;
        }

        public final FragmentBindingComponent getComponent() {
            return this.component;
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/v8/image/CoolPicViewPart$ImageViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: CoolPicViewPart.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.coolapk.market.viewholder.iview.BindingViewPart
        public ItemCoolPicImageBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
            ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558667, viewGroup, false, this.component);
            Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…wGroup, false, component)");
            return (ItemCoolPicImageBinding) inflate;
        }

        @Override // com.coolapk.market.viewholder.iview.ViewPart
        protected void onViewCreated() {
            super.onViewCreated();
            GlideImageHelper.setClickToLoad(((ItemCoolPicImageBinding) getBinding()).imageView, true);
        }

        /* access modifiers changed from: protected */
        public void onBindToContent(ImageArgs imageArgs) {
            Intrinsics.checkNotNullParameter(imageArgs, "data");
            super.onBindToContent((ImageViewPart) imageArgs);
            ScalingImageView scalingImageView = ((ItemCoolPicImageBinding) getBinding()).imageView;
            Intrinsics.checkNotNullExpressionValue(scalingImageView, "binding.imageView");
            View root = ((ItemCoolPicImageBinding) getBinding()).getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = (int) imageArgs.getOutHeight();
            layoutParams2.width = (int) imageArgs.getOutWidth();
            View root2 = ((ItemCoolPicImageBinding) getBinding()).getRoot();
            root2.setX(imageArgs.getOutOffsetX());
            root2.setY(imageArgs.getOutOffsetY());
            ScalingImageView scalingImageView2 = ((ItemCoolPicImageBinding) getBinding()).imageView;
            Intrinsics.checkNotNullExpressionValue(scalingImageView2, "binding.imageView");
            BinderHelperKt.updateClipFlag$default(scalingImageView2, imageArgs.getOutFlags(), 0, 2, null);
            Object container = this.component.getContainer();
            if (container != null) {
                Intrinsics.checkNotNullExpressionValue(container, "component.container.elvis { return }");
                String suitableUrl = imageArgs.getSuitableUrl(CoolPicViewPart.Companion.getThumbUrlProvider());
                scalingImageView.setScaleType(ImageView.ScaleType.MATRIX);
                AppHolder.getFragmentImageLoader().displayImage((Fragment) container, suitableUrl, scalingImageView, 2131231707);
                ViewExtendsKt.darkForegroundIfNeed(scalingImageView);
            }
        }

        @Override // com.coolapk.market.viewholder.iview.ViewPart, com.coolapk.market.viewholder.iview.Recyclable
        public void onRecycled() {
            super.onRecycled();
            ((ItemCoolPicImageBinding) getBinding()).itemView.setOnClickListener(null);
            ((ItemCoolPicImageBinding) getBinding()).imageView.setImageDrawable(null);
            ScalingImageView scalingImageView = ((ItemCoolPicImageBinding) getBinding()).imageView;
            Intrinsics.checkNotNullExpressionValue(scalingImageView, "binding.imageView");
            Context context = scalingImageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "binding.imageView.context");
            Activity activityNullable = UiUtils.getActivityNullable(context);
            if (activityNullable != null && !activityNullable.isDestroyed()) {
                GlideApp.with(activityNullable).clear(((ItemCoolPicImageBinding) getBinding()).imageView);
            }
        }
    }
}
