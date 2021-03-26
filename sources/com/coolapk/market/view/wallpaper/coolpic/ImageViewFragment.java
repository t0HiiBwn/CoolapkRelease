package com.coolapk.market.view.wallpaper.coolpic;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.CoolPicImgLayoutBinding;
import com.coolapk.market.extend.ExtraExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideRequest;
import com.coolapk.market.imageloader.GlideRequests;
import com.coolapk.market.manager.AppPictureSizeManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.photo.PhotoViewUrl;
import com.coolapk.market.widget.photoview.PhotoView;
import com.coolapk.market.widget.subsamplingview.ImageSource;
import com.coolapk.market.widget.subsamplingview.SubsamplingScaleImageView;
import com.coolapk.market.widget.view.ImageLoadProgressBar;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u0004H\u0002J\u0006\u0010\u001c\u001a\u00020\u000eJ\u0006\u0010\u001d\u001a\u00020\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0002J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\u0012\u0010 \u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J&\u0010$\u001a\u0004\u0018\u00010\u00182\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020+H\u0002J\u0006\u0010,\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/coolapk/market/view/wallpaper/coolpic/ImageViewFragment;", "Lcom/coolapk/market/view/base/BaseFragment;", "()V", "activityInitTime", "", "feed", "Lcom/coolapk/market/model/Feed;", "feedType", "", "imageUrl", "Lcom/coolapk/market/view/photo/PhotoViewUrl;", "imageUrls", "", "isCompressUrl", "", "isImgShown", "isLoadTaskStarted", "photoBinding", "Lcom/coolapk/market/databinding/CoolPicImgLayoutBinding;", "position", "", "alphaView", "", "view", "Landroid/view/View;", "isShown", "visibleOnStart", "time", "canScroll", "initData", "isTooLongPic", "loadSource", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onImageFileLoaded", "resource", "Ljava/io/File;", "reloadPic", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ImageViewFragment.kt */
public final class ImageViewFragment extends BaseFragment {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_FEED = "EXTRA_FEED";
    private static final String KEY_IMAGE_URL = "IMAGE_URL";
    private static final String KEY_POSITION = "EXTRA_POSITION";
    private long activityInitTime;
    private Feed feed;
    private String feedType;
    private PhotoViewUrl imageUrl;
    private List<PhotoViewUrl> imageUrls;
    private boolean isCompressUrl;
    private boolean isImgShown;
    private boolean isLoadTaskStarted;
    private CoolPicImgLayoutBinding photoBinding;
    private int position = -1;

    public static final /* synthetic */ List access$getImageUrls$p(ImageViewFragment imageViewFragment) {
        List<PhotoViewUrl> list = imageViewFragment.imageUrls;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageUrls");
        }
        return list;
    }

    public static final /* synthetic */ CoolPicImgLayoutBinding access$getPhotoBinding$p(ImageViewFragment imageViewFragment) {
        CoolPicImgLayoutBinding coolPicImgLayoutBinding = imageViewFragment.photoBinding;
        if (coolPicImgLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
        }
        return coolPicImgLayoutBinding;
    }

    @Override // com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.feed = (Feed) requireArguments().getParcelable("EXTRA_FEED");
        ArrayList parcelableArrayList = requireArguments().getParcelableArrayList("IMAGE_URL");
        Intrinsics.checkNotNull(parcelableArrayList);
        this.imageUrls = parcelableArrayList;
        Feed feed2 = this.feed;
        this.feedType = feed2 != null ? feed2.getFeedType() : null;
        this.position = requireArguments().getInt("EXTRA_POSITION");
        List<PhotoViewUrl> list = this.imageUrls;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageUrls");
        }
        this.imageUrl = list.get(this.position);
    }

    private final boolean isTooLongPic() {
        AppPictureSizeManager instance = AppPictureSizeManager.getInstance();
        PhotoViewUrl photoViewUrl = this.imageUrl;
        if (photoViewUrl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
        }
        AppPictureSizeManager.PictureSize size = instance.getSize(photoViewUrl.getSource());
        if (size == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(size, "AppPictureSizeManager.ge…l.source) ?: return false");
        int height = size.getHeight();
        int width = size.getWidth();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Resources resources = requireActivity.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "requireActivity().resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (height / width > displayMetrics.heightPixels / displayMetrics.widthPixels) {
            return true;
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558489, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…layout, container, false)");
        CoolPicImgLayoutBinding coolPicImgLayoutBinding = (CoolPicImgLayoutBinding) inflate;
        this.photoBinding = coolPicImgLayoutBinding;
        if (coolPicImgLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
        }
        return coolPicImgLayoutBinding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getUserVisibleHint()) {
            initData();
        }
        CoolPicImgLayoutBinding coolPicImgLayoutBinding = this.photoBinding;
        if (coolPicImgLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
        }
        coolPicImgLayoutBinding.gifImageView.enableRotate();
        CoolPicImgLayoutBinding coolPicImgLayoutBinding2 = this.photoBinding;
        if (coolPicImgLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
        }
        PhotoView photoView = coolPicImgLayoutBinding2.gifImageView;
        Intrinsics.checkNotNullExpressionValue(photoView, "photoBinding.gifImageView");
        photoView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        CoolPicImgLayoutBinding coolPicImgLayoutBinding3 = this.photoBinding;
        if (coolPicImgLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
        }
        coolPicImgLayoutBinding3.gifImageView.enable();
        this.activityInitTime = System.currentTimeMillis();
        ImageViewFragment$onActivityCreated$longClickListener$1 imageViewFragment$onActivityCreated$longClickListener$1 = new ImageViewFragment$onActivityCreated$longClickListener$1(this);
        CoolPicImgLayoutBinding coolPicImgLayoutBinding4 = this.photoBinding;
        if (coolPicImgLayoutBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
        }
        coolPicImgLayoutBinding4.gifImageView.setOnLongClickListener(imageViewFragment$onActivityCreated$longClickListener$1);
        CoolPicImgLayoutBinding coolPicImgLayoutBinding5 = this.photoBinding;
        if (coolPicImgLayoutBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
        }
        ImageLoadProgressBar imageLoadProgressBar = coolPicImgLayoutBinding5.progressBar;
        Intrinsics.checkNotNullExpressionValue(imageLoadProgressBar, "photoBinding.progressBar");
        imageLoadProgressBar.setVisibility(8);
        CoolPicImgLayoutBinding coolPicImgLayoutBinding6 = this.photoBinding;
        if (coolPicImgLayoutBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
        }
        ImageLoadProgressBar imageLoadProgressBar2 = coolPicImgLayoutBinding6.progressBar;
        Intrinsics.checkNotNullExpressionValue(imageLoadProgressBar2, "photoBinding.progressBar");
        imageLoadProgressBar2.setTextColor(AppHolder.getAppTheme().getColorAccent());
        CoolPicImgLayoutBinding coolPicImgLayoutBinding7 = this.photoBinding;
        if (coolPicImgLayoutBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
        }
        ImageLoadProgressBar imageLoadProgressBar3 = coolPicImgLayoutBinding7.progressBar;
        Intrinsics.checkNotNullExpressionValue(imageLoadProgressBar3, "photoBinding.progressBar");
        imageLoadProgressBar3.setRingProgressColor(AppHolder.getAppTheme().getColorAccent());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0114, code lost:
        if (r0.gifImageView.canScrollHorizontally(-1) == false) goto L_0x0116;
     */
    public final boolean canScroll() {
        if (isTooLongPic()) {
            CoolPicImgLayoutBinding coolPicImgLayoutBinding = this.photoBinding;
            if (coolPicImgLayoutBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            SubsamplingScaleImageView subsamplingScaleImageView = coolPicImgLayoutBinding.imageView;
            Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView, "photoBinding.imageView");
            if (subsamplingScaleImageView.isImageLoaded()) {
                CoolPicImgLayoutBinding coolPicImgLayoutBinding2 = this.photoBinding;
                if (coolPicImgLayoutBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                if (!coolPicImgLayoutBinding2.imageView.canScrollHorizontally(1)) {
                    return false;
                }
                CoolPicImgLayoutBinding coolPicImgLayoutBinding3 = this.photoBinding;
                if (coolPicImgLayoutBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                if (!coolPicImgLayoutBinding3.imageView.canScrollHorizontally(-1)) {
                    return false;
                }
                CoolPicImgLayoutBinding coolPicImgLayoutBinding4 = this.photoBinding;
                if (coolPicImgLayoutBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                if (!coolPicImgLayoutBinding4.imageView.canScrollVertically(-1)) {
                    return false;
                }
                CoolPicImgLayoutBinding coolPicImgLayoutBinding5 = this.photoBinding;
                if (coolPicImgLayoutBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                if (!coolPicImgLayoutBinding5.imageView.canScrollVertically(1)) {
                    return false;
                }
            } else {
                CoolPicImgLayoutBinding coolPicImgLayoutBinding6 = this.photoBinding;
                if (coolPicImgLayoutBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                PhotoView photoView = coolPicImgLayoutBinding6.gifImageView;
                Intrinsics.checkNotNullExpressionValue(photoView, "photoBinding.gifImageView");
                if (photoView.getDrawable() == null) {
                    return false;
                }
                CoolPicImgLayoutBinding coolPicImgLayoutBinding7 = this.photoBinding;
                if (coolPicImgLayoutBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                if (!coolPicImgLayoutBinding7.gifImageView.canScrollHorizontally(1)) {
                    return false;
                }
                CoolPicImgLayoutBinding coolPicImgLayoutBinding8 = this.photoBinding;
                if (coolPicImgLayoutBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                if (!coolPicImgLayoutBinding8.gifImageView.canScrollHorizontally(-1)) {
                    return false;
                }
                CoolPicImgLayoutBinding coolPicImgLayoutBinding9 = this.photoBinding;
                if (coolPicImgLayoutBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                if (!coolPicImgLayoutBinding9.gifImageView.canScrollVertically(-1)) {
                    return false;
                }
                CoolPicImgLayoutBinding coolPicImgLayoutBinding10 = this.photoBinding;
                if (coolPicImgLayoutBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                if (!coolPicImgLayoutBinding10.gifImageView.canScrollVertically(1)) {
                    return false;
                }
            }
        } else {
            CoolPicImgLayoutBinding coolPicImgLayoutBinding11 = this.photoBinding;
            if (coolPicImgLayoutBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            SubsamplingScaleImageView subsamplingScaleImageView2 = coolPicImgLayoutBinding11.imageView;
            Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView2, "photoBinding.imageView");
            if (subsamplingScaleImageView2.isImageLoaded()) {
                CoolPicImgLayoutBinding coolPicImgLayoutBinding12 = this.photoBinding;
                if (coolPicImgLayoutBinding12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                SubsamplingScaleImageView subsamplingScaleImageView3 = coolPicImgLayoutBinding12.imageView;
                Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView3, "photoBinding.imageView");
                float scale = subsamplingScaleImageView3.getScale();
                CoolPicImgLayoutBinding coolPicImgLayoutBinding13 = this.photoBinding;
                if (coolPicImgLayoutBinding13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                SubsamplingScaleImageView subsamplingScaleImageView4 = coolPicImgLayoutBinding13.imageView;
                Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView4, "photoBinding.imageView");
                if (scale <= subsamplingScaleImageView4.getMinScale()) {
                    return false;
                }
            } else {
                CoolPicImgLayoutBinding coolPicImgLayoutBinding14 = this.photoBinding;
                if (coolPicImgLayoutBinding14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                PhotoView photoView2 = coolPicImgLayoutBinding14.gifImageView;
                Intrinsics.checkNotNullExpressionValue(photoView2, "photoBinding.gifImageView");
                if (photoView2.getDrawable() == null) {
                    return false;
                }
                CoolPicImgLayoutBinding coolPicImgLayoutBinding15 = this.photoBinding;
                if (coolPicImgLayoutBinding15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                if (coolPicImgLayoutBinding15.gifImageView.canScrollHorizontally(1)) {
                    CoolPicImgLayoutBinding coolPicImgLayoutBinding16 = this.photoBinding;
                    if (coolPicImgLayoutBinding16 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                    }
                }
                CoolPicImgLayoutBinding coolPicImgLayoutBinding17 = this.photoBinding;
                if (coolPicImgLayoutBinding17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                if (!coolPicImgLayoutBinding17.gifImageView.canScrollVertically(-1)) {
                    return false;
                }
                CoolPicImgLayoutBinding coolPicImgLayoutBinding18 = this.photoBinding;
                if (coolPicImgLayoutBinding18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                if (!coolPicImgLayoutBinding18.gifImageView.canScrollVertically(1)) {
                    return false;
                }
            }
        }
        return true;
    }

    static /* synthetic */ void alphaView$default(ImageViewFragment imageViewFragment, View view, boolean z, int i, long j, int i2, Object obj) {
        int i3 = (i2 & 4) != 0 ? 0 : i;
        if ((i2 & 8) != 0) {
            j = 300;
        }
        imageViewFragment.alphaView(view, z, i3, j);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0012: APUT  (r0v2 float[]), (0 ??[int, short, byte, char]), (r4v0 float) */
    private final void alphaView(View view, boolean z, int i, long j) {
        if (!this.isImgShown) {
            float[] fArr = new float[2];
            float f = 0.0f;
            fArr[0] = z ? 1.0f : 0.0f;
            if (!z) {
                f = 1.0f;
            }
            fArr[1] = f;
            ObjectAnimator duration = ObjectAnimator.ofFloat(view, "alpha", fArr).setDuration(j);
            Intrinsics.checkNotNullExpressionValue(duration, "ObjectAnimator.ofFloat(v…       .setDuration(time)");
            ExtraExtendsKt.addListeners(duration, new ImageViewFragment$alphaView$2(this, view, i), new ImageViewFragment$alphaView$1(view, z));
            duration.start();
        }
    }

    public final void initData() {
        if (!this.isLoadTaskStarted && isAdded()) {
            CoolPicImgLayoutBinding coolPicImgLayoutBinding = this.photoBinding;
            if (coolPicImgLayoutBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            ImageLoadProgressBar imageLoadProgressBar = coolPicImgLayoutBinding.progressBar;
            Intrinsics.checkNotNullExpressionValue(imageLoadProgressBar, "photoBinding.progressBar");
            imageLoadProgressBar.setAlpha(0.0f);
            CoolPicImgLayoutBinding coolPicImgLayoutBinding2 = this.photoBinding;
            if (coolPicImgLayoutBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            coolPicImgLayoutBinding2.progressBar.postDelayed(new ImageViewFragment$initData$1(this), 500);
            this.isLoadTaskStarted = true;
            loadSource();
        }
    }

    public final void reloadPic() {
        FragmentActivity activity = getActivity();
        if (activity instanceof CoolPicDetailActivity) {
            ((CoolPicDetailActivity) activity).setDonotCompress(true);
        }
        CoolPicImgLayoutBinding coolPicImgLayoutBinding = this.photoBinding;
        if (coolPicImgLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
        }
        GlideRequests with = GlideApp.with(coolPicImgLayoutBinding.gifImageView);
        CoolPicImgLayoutBinding coolPicImgLayoutBinding2 = this.photoBinding;
        if (coolPicImgLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
        }
        with.clear(coolPicImgLayoutBinding2.gifImageView);
        loadSource();
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private final void loadSource() {
        CoolPicImgLayoutBinding coolPicImgLayoutBinding = this.photoBinding;
        if (coolPicImgLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
        }
        PhotoView photoView = coolPicImgLayoutBinding.gifImageView;
        Intrinsics.checkNotNullExpressionValue(photoView, "photoBinding.gifImageView");
        photoView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        CoolPicImgLayoutBinding coolPicImgLayoutBinding2 = this.photoBinding;
        if (coolPicImgLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
        }
        ImageLoadProgressBar imageLoadProgressBar = coolPicImgLayoutBinding2.progressBar;
        PhotoViewUrl photoViewUrl = this.imageUrl;
        if (photoViewUrl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
        }
        imageLoadProgressBar.setMonitorUrl(photoViewUrl.getSource());
        ImageViewFragment imageViewFragment = this;
        GlideRequests with = GlideApp.with(imageViewFragment);
        PhotoViewUrl photoViewUrl2 = this.imageUrl;
        if (photoViewUrl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
        }
        with.load(photoViewUrl2.getCompress()).diskCacheStrategy(DiskCacheStrategy.DATA).listener((RequestListener) new ImageViewFragment$loadSource$1(this)).into((GlideRequest) new ImageViewFragment$loadSource$2(this));
        FragmentActivity activity = getActivity();
        if (activity instanceof CoolPicDetailActivity) {
            CoolPicDetailActivity coolPicDetailActivity = (CoolPicDetailActivity) activity;
            PhotoViewUrl photoViewUrl3 = this.imageUrl;
            if (photoViewUrl3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
            }
            this.isCompressUrl = coolPicDetailActivity.isCompressUrl(photoViewUrl3.getSource());
        }
        GlideRequest<File> downloadOnly = GlideApp.with(imageViewFragment).downloadOnly();
        boolean z = this.isCompressUrl;
        PhotoViewUrl photoViewUrl4 = this.imageUrl;
        if (photoViewUrl4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
        }
        String compress = photoViewUrl4.getCompress();
        PhotoViewUrl photoViewUrl5 = this.imageUrl;
        if (photoViewUrl5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
        }
        String source = photoViewUrl5.getSource();
        if (!z) {
            compress = source;
        }
        downloadOnly.load(compress).listener((RequestListener<File>) new ImageViewFragment$loadSource$3(this)).into((GlideRequest<File>) new ImageViewFragment$loadSource$4(this));
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x009f, code lost:
        if (r4 > ((float) 5)) goto L_0x00a3;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final void onImageFileLoaded(File file) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        boolean z = true;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        CoolPicImgLayoutBinding coolPicImgLayoutBinding = this.photoBinding;
        if (coolPicImgLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
        }
        View root = coolPicImgLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "photoBinding.root");
        Float valueOf = Float.valueOf((float) root.getHeight());
        CoolPicImgLayoutBinding coolPicImgLayoutBinding2 = this.photoBinding;
        if (coolPicImgLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
        }
        View root2 = coolPicImgLayoutBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "photoBinding.root");
        Pair pair = new Pair(valueOf, Float.valueOf((float) root2.getWidth()));
        float floatValue = ((Number) pair.component1()).floatValue();
        float floatValue2 = ((Number) pair.component2()).floatValue();
        if (((float) (options.outHeight * options.outWidth)) <= floatValue * floatValue2 * 2.0f) {
            if (!(options.outWidth == 0 || options.outHeight == 0)) {
                float f = (float) 2;
                if (((float) options.outWidth) > floatValue2 * f || ((float) options.outHeight) > f * floatValue) {
                    float f2 = (((float) options.outHeight) * 1.0f) / ((float) options.outWidth);
                    if (f2 < 1.0f) {
                        f2 = ((float) 1) / f2;
                    }
                }
            }
            z = false;
        }
        if (z) {
            CoolPicImgLayoutBinding coolPicImgLayoutBinding3 = this.photoBinding;
            if (coolPicImgLayoutBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            PhotoView photoView = coolPicImgLayoutBinding3.gifImageView;
            Intrinsics.checkNotNullExpressionValue(photoView, "photoBinding.gifImageView");
            photoView.setVisibility(8);
            CoolPicImgLayoutBinding coolPicImgLayoutBinding4 = this.photoBinding;
            if (coolPicImgLayoutBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            SubsamplingScaleImageView subsamplingScaleImageView = coolPicImgLayoutBinding4.imageView;
            Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView, "photoBinding.imageView");
            subsamplingScaleImageView.setVisibility(0);
            CoolPicImgLayoutBinding coolPicImgLayoutBinding5 = this.photoBinding;
            if (coolPicImgLayoutBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            coolPicImgLayoutBinding5.imageView.setImage(ImageSource.uri(file.getAbsolutePath()));
            CoolPicImgLayoutBinding coolPicImgLayoutBinding6 = this.photoBinding;
            if (coolPicImgLayoutBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            coolPicImgLayoutBinding6.imageView.setOnImageEventListener(new ImageViewFragment$onImageFileLoaded$1(this, floatValue2, floatValue));
            return;
        }
        CoolPicImgLayoutBinding coolPicImgLayoutBinding7 = this.photoBinding;
        if (coolPicImgLayoutBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
        }
        LinearLayout linearLayout = coolPicImgLayoutBinding7.frontView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "photoBinding.frontView");
        alphaView$default(this, linearLayout, true, 0, 0, 12, null);
        CoolPicImgLayoutBinding coolPicImgLayoutBinding8 = this.photoBinding;
        if (coolPicImgLayoutBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
        }
        PhotoView photoView2 = coolPicImgLayoutBinding8.gifImageView;
        Intrinsics.checkNotNullExpressionValue(photoView2, "photoBinding.gifImageView");
        photoView2.setVisibility(0);
        CoolPicImgLayoutBinding coolPicImgLayoutBinding9 = this.photoBinding;
        if (coolPicImgLayoutBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
        }
        SubsamplingScaleImageView subsamplingScaleImageView2 = coolPicImgLayoutBinding9.imageView;
        Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView2, "photoBinding.imageView");
        subsamplingScaleImageView2.setVisibility(8);
        CoolPicImgLayoutBinding coolPicImgLayoutBinding10 = this.photoBinding;
        if (coolPicImgLayoutBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
        }
        coolPicImgLayoutBinding10.gifImageView.enable();
        Intrinsics.checkNotNullExpressionValue(GlideApp.with(requireActivity()).load(Uri.fromFile(file)).override(Integer.MIN_VALUE, Integer.MIN_VALUE).diskCacheStrategy(DiskCacheStrategy.NONE).dontTransform().listener((RequestListener) new ImageViewFragment$onImageFileLoaded$2(this)).into((GlideRequest) new ImageViewFragment$onImageFileLoaded$3(this)), "GlideApp.with(requireAct… }\n                    })");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/wallpaper/coolpic/ImageViewFragment$Companion;", "", "()V", "KEY_FEED", "", "KEY_IMAGE_URL", "KEY_POSITION", "newInstance", "Lcom/coolapk/market/view/wallpaper/coolpic/ImageViewFragment;", "imageUrls", "", "Lcom/coolapk/market/view/photo/PhotoViewUrl;", "feed", "Lcom/coolapk/market/model/Feed;", "position", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ImageViewFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ImageViewFragment newInstance(List<PhotoViewUrl> list, Feed feed, int i) {
            Intrinsics.checkNotNullParameter(list, "imageUrls");
            Intrinsics.checkNotNullParameter(feed, "feed");
            Bundle bundle = new Bundle();
            if (!(list instanceof ArrayList)) {
                list = null;
            }
            bundle.putParcelableArrayList("IMAGE_URL", (ArrayList) list);
            bundle.putParcelable("EXTRA_FEED", feed);
            bundle.putInt("EXTRA_POSITION", i);
            ImageViewFragment imageViewFragment = new ImageViewFragment();
            imageViewFragment.setArguments(bundle);
            return imageViewFragment;
        }
    }
}
