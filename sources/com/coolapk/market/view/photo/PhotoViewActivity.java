package com.coolapk.market.view.photo;

import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.request.RequestListener;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.app.TranslucentActivity;
import com.coolapk.market.databinding.ItemPhotoViewBinding;
import com.coolapk.market.databinding.PhotoBinding;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideRequest;
import com.coolapk.market.imageloader.GlideRequests;
import com.coolapk.market.local.DataConfig;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.network.HttpClientFactory;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.NotchUtil;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.base.FragmentStatePagerAdapter;
import com.coolapk.market.viewholder.v8.image.ImageArgs;
import com.coolapk.market.widget.CatchErrorViewPager;
import com.coolapk.market.widget.subsamplingview.ImageSource;
import com.coolapk.market.widget.subsamplingview.SubsamplingScaleImageView;
import com.coolapk.market.widget.view.ImageLoadProgressBar;
import com.coolapk.market.widget.view.PhotoViewCompat;
import com.coolapk.market.widget.view.SwipeScaleView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0003\u001d\u001e\u001fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0015H\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/coolapk/market/view/photo/PhotoViewActivity;", "Lcom/coolapk/market/view/base/BaseActivity;", "Lcom/coolapk/market/app/TranslucentActivity;", "()V", "binding", "Lcom/coolapk/market/databinding/PhotoBinding;", "getBinding", "()Lcom/coolapk/market/databinding/PhotoBinding;", "setBinding", "(Lcom/coolapk/market/databinding/PhotoBinding;)V", "data", "Ljava/util/ArrayList;", "Lcom/coolapk/market/view/photo/PhotoViewUrl;", "feedType", "", "inMessage", "", "transitionHelper", "Lcom/coolapk/market/view/photo/PhotoViewTransitionHelper;", "isNavigationBarTranslucent", "onBackPressed", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSetStatusBarColor", "Companion", "ImageFragment", "ImageViewPagerAdapter", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PhotoViewActivity.kt */
public final class PhotoViewActivity extends BaseActivity implements TranslucentActivity {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_FEED_TYPE = "feed_type";
    public static final String EXTRA_INDEX = "index";
    public static final String EXTRA_IN_MESSAGE = "in_message";
    public static final String EXTRA_PHOTO_VIEW_URLS = "photoViewUrl";
    public PhotoBinding binding;
    private ArrayList<PhotoViewUrl> data;
    private String feedType;
    private boolean inMessage;
    private PhotoViewTransitionHelper transitionHelper;

    @Override // com.coolapk.market.app.TranslucentActivity
    public boolean isNavigationBarTranslucent() {
        return true;
    }

    public static final /* synthetic */ ArrayList access$getData$p(PhotoViewActivity photoViewActivity) {
        ArrayList<PhotoViewUrl> arrayList = photoViewActivity.data;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
        }
        return arrayList;
    }

    public static final /* synthetic */ PhotoViewTransitionHelper access$getTransitionHelper$p(PhotoViewActivity photoViewActivity) {
        PhotoViewTransitionHelper photoViewTransitionHelper = photoViewActivity.transitionHelper;
        if (photoViewTransitionHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("transitionHelper");
        }
        return photoViewTransitionHelper;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/photo/PhotoViewActivity$Companion;", "", "()V", "EXTRA_FEED_TYPE", "", "EXTRA_INDEX", "EXTRA_IN_MESSAGE", "EXTRA_PHOTO_VIEW_URLS", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PhotoViewActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final PhotoBinding getBinding() {
        PhotoBinding photoBinding = this.binding;
        if (photoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return photoBinding;
    }

    public final void setBinding(PhotoBinding photoBinding) {
        Intrinsics.checkNotNullParameter(photoBinding, "<set-?>");
        this.binding = photoBinding;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00f3: APUT  
      (r8v0 java.lang.Object[])
      (1 ??[boolean, int, float, short, byte, char])
      (wrap: java.lang.Integer : 0x00ef: INVOKE  (r4v3 java.lang.Integer) = 
      (wrap: int : 0x00eb: INVOKE  (r4v2 int) = (r4v1 java.util.ArrayList<com.coolapk.market.view.photo.PhotoViewUrl>) type: VIRTUAL call: java.util.ArrayList.size():int)
     type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
     */
    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "window");
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        decorView.setSystemUiVisibility(5894);
        BaseActivity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        if (activity.getRequestedOrientation() == 2) {
            NotchUtil notchUtil = NotchUtil.INSTANCE;
            Window window2 = getWindow();
            Intrinsics.checkNotNullExpressionValue(window2, "window");
            notchUtil.blockStatusCutout(window2);
        } else {
            NotchUtil notchUtil2 = NotchUtil.INSTANCE;
            Window window3 = getWindow();
            Intrinsics.checkNotNullExpressionValue(window3, "window");
            BaseActivity activity2 = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity2, "activity");
            notchUtil2.extendStatusCutout(window3, activity2);
        }
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, 2131559079);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…iew(this, R.layout.photo)");
        this.binding = (PhotoBinding) contentView;
        this.feedType = getIntent().getStringExtra("feed_type");
        this.inMessage = getIntent().getBooleanExtra("in_message", false);
        ArrayList<PhotoViewUrl> parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("photoViewUrl");
        Intrinsics.checkNotNull(parcelableArrayListExtra);
        this.data = parcelableArrayListExtra;
        int intExtra = getIntent().getIntExtra("index", 0);
        ArrayList<PhotoViewUrl> arrayList = this.data;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
        }
        this.transitionHelper = new PhotoViewTransitionHelper(this, arrayList, intExtra);
        PhotoBinding photoBinding = this.binding;
        if (photoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        CatchErrorViewPager catchErrorViewPager = photoBinding.viewPager;
        Intrinsics.checkNotNullExpressionValue(catchErrorViewPager, "binding.viewPager");
        catchErrorViewPager.addOnPageChangeListener(new PhotoViewActivity$onCreate$1(this, catchErrorViewPager));
        PhotoBinding photoBinding2 = this.binding;
        if (photoBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = photoBinding2.infoView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.infoView");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(catchErrorViewPager.getCurrentItem() + 1);
        ArrayList<PhotoViewUrl> arrayList2 = this.data;
        if (arrayList2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
        }
        objArr[1] = Integer.valueOf(arrayList2.size());
        String format = String.format(locale, "%d/%d", Arrays.copyOf(objArr, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
        textView.setText(format);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        ArrayList<PhotoViewUrl> arrayList3 = this.data;
        if (arrayList3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
        }
        ImageViewPagerAdapter imageViewPagerAdapter = new ImageViewPagerAdapter(this, supportFragmentManager, arrayList3);
        catchErrorViewPager.setAdapter(imageViewPagerAdapter);
        catchErrorViewPager.setCurrentItem(intExtra);
        catchErrorViewPager.addOnPageChangeListener(new PhotoViewActivity$onCreate$2(catchErrorViewPager));
        PhotoBinding photoBinding3 = this.binding;
        if (photoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        SwipeScaleView swipeScaleView = photoBinding3.swipeScaleView;
        Intrinsics.checkNotNullExpressionValue(swipeScaleView, "binding.swipeScaleView");
        swipeScaleView.setOnGestureListener(new PhotoViewActivity$onCreate$3(imageViewPagerAdapter, catchErrorViewPager));
        swipeScaleView.setOnSwipeListener(new PhotoViewActivity$onCreate$4(this));
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            NotchUtil notchUtil = NotchUtil.INSTANCE;
            Window window = getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "window");
            notchUtil.blockStatusCutout(window);
            return;
        }
        NotchUtil notchUtil2 = NotchUtil.INSTANCE;
        Window window2 = getWindow();
        Intrinsics.checkNotNullExpressionValue(window2, "window");
        BaseActivity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        notchUtil2.extendStatusCutout(window2, activity);
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        PhotoViewTransitionHelper photoViewTransitionHelper = this.transitionHelper;
        if (photoViewTransitionHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("transitionHelper");
        }
        photoViewTransitionHelper.doFinishAnimation();
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        ThemeUtils.setTranslucentStatusBar(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0006J\u001a\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\u0012\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010!\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020*H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/coolapk/market/view/photo/PhotoViewActivity$ImageFragment;", "Lcom/coolapk/market/view/base/BaseFragment;", "()V", "activityInitTime", "", "allowExit", "", "feedType", "", "helper", "Lcom/coolapk/market/view/photo/PhotoViewTransitionHelper;", "imageUrl", "Lcom/coolapk/market/view/photo/PhotoViewUrl;", "imageUrls", "", "inMessage", "isLoadTaskStarted", "photoBinding", "Lcom/coolapk/market/databinding/ItemPhotoViewBinding;", "position", "", "canSwipe", "getGlideUrl", "Lcom/bumptech/glide/load/model/GlideUrl;", "url", "isCoolApkHeader", "initData", "", "loadCompressed", "loadSource", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onImageFileLoaded", "resource", "Ljava/io/File;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PhotoViewActivity.kt */
    public static final class ImageFragment extends BaseFragment {
        public static final Companion Companion = new Companion(null);
        private static final String KEY_FEED_TYPE = "EXTRA_FEED_TYPE";
        private static final String KEY_IMAGE_URL = "IMAGE_URL";
        private static final String KEY_IN_MESSAGE = "EXTRA_IN_MESSAGE";
        private static final String KEY_POSITION = "EXTRA_POSITION";
        private long activityInitTime;
        private boolean allowExit;
        private String feedType;
        private PhotoViewTransitionHelper helper;
        private PhotoViewUrl imageUrl;
        private List<PhotoViewUrl> imageUrls;
        private boolean inMessage;
        private boolean isLoadTaskStarted;
        private ItemPhotoViewBinding photoBinding;
        private int position = -1;

        public static final /* synthetic */ PhotoViewTransitionHelper access$getHelper$p(ImageFragment imageFragment) {
            PhotoViewTransitionHelper photoViewTransitionHelper = imageFragment.helper;
            if (photoViewTransitionHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helper");
            }
            return photoViewTransitionHelper;
        }

        public static final /* synthetic */ List access$getImageUrls$p(ImageFragment imageFragment) {
            List<PhotoViewUrl> list = imageFragment.imageUrls;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageUrls");
            }
            return list;
        }

        public static final /* synthetic */ ItemPhotoViewBinding access$getPhotoBinding$p(ImageFragment imageFragment) {
            ItemPhotoViewBinding itemPhotoViewBinding = imageFragment.photoBinding;
            if (itemPhotoViewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            return itemPhotoViewBinding;
        }

        @Override // com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            ArrayList parcelableArrayList = requireArguments().getParcelableArrayList("IMAGE_URL");
            Intrinsics.checkNotNull(parcelableArrayList);
            this.imageUrls = parcelableArrayList;
            this.feedType = requireArguments().getString("EXTRA_FEED_TYPE");
            this.position = requireArguments().getInt("EXTRA_POSITION");
            this.inMessage = requireArguments().getBoolean("EXTRA_IN_MESSAGE");
            List<PhotoViewUrl> list = this.imageUrls;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageUrls");
            }
            this.imageUrl = list.get(this.position);
        }

        @Override // androidx.fragment.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
            ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558852, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…o_view, container, false)");
            ItemPhotoViewBinding itemPhotoViewBinding = (ItemPhotoViewBinding) inflate;
            this.photoBinding = itemPhotoViewBinding;
            if (itemPhotoViewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            return itemPhotoViewBinding.getRoot();
        }

        @Override // androidx.fragment.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            FragmentActivity activity = getActivity();
            if (!(activity instanceof PhotoViewActivity)) {
                activity = null;
            }
            PhotoViewActivity photoViewActivity = (PhotoViewActivity) activity;
            Intrinsics.checkNotNull(photoViewActivity);
            this.helper = PhotoViewActivity.access$getTransitionHelper$p(photoViewActivity);
            ItemPhotoViewBinding itemPhotoViewBinding = this.photoBinding;
            if (itemPhotoViewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            TextView textView = itemPhotoViewBinding.loadSourceButton;
            Intrinsics.checkNotNullExpressionValue(textView, "photoBinding.loadSourceButton");
            textView.setVisibility(8);
            if (UiUtils.hasNavigationBar(getActivity())) {
                ItemPhotoViewBinding itemPhotoViewBinding2 = this.photoBinding;
                if (itemPhotoViewBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                TextView textView2 = itemPhotoViewBinding2.loadSourceButton;
                Intrinsics.checkNotNullExpressionValue(textView2, "photoBinding.loadSourceButton");
                ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, DisplayUtils.dp2px(getActivity(), (float) 64));
                ItemPhotoViewBinding itemPhotoViewBinding3 = this.photoBinding;
                if (itemPhotoViewBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                TextView textView3 = itemPhotoViewBinding3.loadSourceButton;
                Intrinsics.checkNotNullExpressionValue(textView3, "photoBinding.loadSourceButton");
                textView3.setLayoutParams(marginLayoutParams);
            }
            ItemPhotoViewBinding itemPhotoViewBinding4 = this.photoBinding;
            if (itemPhotoViewBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            PhotoViewCompat photoViewCompat = itemPhotoViewBinding4.gifImageView;
            Intrinsics.checkNotNullExpressionValue(photoViewCompat, "photoBinding.gifImageView");
            photoViewCompat.setScaleType(ImageView.ScaleType.FIT_CENTER);
            ItemPhotoViewBinding itemPhotoViewBinding5 = this.photoBinding;
            if (itemPhotoViewBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            PhotoViewCompat photoViewCompat2 = itemPhotoViewBinding5.thumbnailView;
            Intrinsics.checkNotNullExpressionValue(photoViewCompat2, "photoBinding.thumbnailView");
            photoViewCompat2.setScaleType(ImageView.ScaleType.FIT_CENTER);
            ItemPhotoViewBinding itemPhotoViewBinding6 = this.photoBinding;
            if (itemPhotoViewBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            itemPhotoViewBinding6.gifImageView.enable();
            ItemPhotoViewBinding itemPhotoViewBinding7 = this.photoBinding;
            if (itemPhotoViewBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            itemPhotoViewBinding7.thumbnailView.enable();
            ItemPhotoViewBinding itemPhotoViewBinding8 = this.photoBinding;
            if (itemPhotoViewBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            itemPhotoViewBinding8.gifImageView.enableRotate();
            ItemPhotoViewBinding itemPhotoViewBinding9 = this.photoBinding;
            if (itemPhotoViewBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            itemPhotoViewBinding9.thumbnailView.enableRotate();
            this.activityInitTime = System.currentTimeMillis();
            PhotoViewActivity$ImageFragment$onActivityCreated$listener$1 photoViewActivity$ImageFragment$onActivityCreated$listener$1 = new PhotoViewActivity$ImageFragment$onActivityCreated$listener$1(this);
            ItemPhotoViewBinding itemPhotoViewBinding10 = this.photoBinding;
            if (itemPhotoViewBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            ViewUtil.clickListener(itemPhotoViewBinding10.imageView, photoViewActivity$ImageFragment$onActivityCreated$listener$1);
            ItemPhotoViewBinding itemPhotoViewBinding11 = this.photoBinding;
            if (itemPhotoViewBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            ViewUtil.clickListener(itemPhotoViewBinding11.gifImageView, photoViewActivity$ImageFragment$onActivityCreated$listener$1);
            ItemPhotoViewBinding itemPhotoViewBinding12 = this.photoBinding;
            if (itemPhotoViewBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            ViewUtil.clickListener(itemPhotoViewBinding12.thumbnailView, photoViewActivity$ImageFragment$onActivityCreated$listener$1);
            PhotoViewActivity$ImageFragment$onActivityCreated$longClickListener$1 photoViewActivity$ImageFragment$onActivityCreated$longClickListener$1 = new PhotoViewActivity$ImageFragment$onActivityCreated$longClickListener$1(this);
            ItemPhotoViewBinding itemPhotoViewBinding13 = this.photoBinding;
            if (itemPhotoViewBinding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            itemPhotoViewBinding13.imageView.setOnLongClickListener(photoViewActivity$ImageFragment$onActivityCreated$longClickListener$1);
            ItemPhotoViewBinding itemPhotoViewBinding14 = this.photoBinding;
            if (itemPhotoViewBinding14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            itemPhotoViewBinding14.gifImageView.setOnLongClickListener(photoViewActivity$ImageFragment$onActivityCreated$longClickListener$1);
            ItemPhotoViewBinding itemPhotoViewBinding15 = this.photoBinding;
            if (itemPhotoViewBinding15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            itemPhotoViewBinding15.thumbnailView.setOnLongClickListener(photoViewActivity$ImageFragment$onActivityCreated$longClickListener$1);
            ItemPhotoViewBinding itemPhotoViewBinding16 = this.photoBinding;
            if (itemPhotoViewBinding16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            SubsamplingScaleImageView subsamplingScaleImageView = itemPhotoViewBinding16.imageView;
            Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView, "photoBinding.imageView");
            subsamplingScaleImageView.setMaxScale(1.5f);
            ItemPhotoViewBinding itemPhotoViewBinding17 = this.photoBinding;
            if (itemPhotoViewBinding17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            PhotoViewCompat photoViewCompat3 = itemPhotoViewBinding17.thumbnailView;
            Intrinsics.checkNotNullExpressionValue(photoViewCompat3, "photoBinding.thumbnailView");
            photoViewCompat3.setMaxScale(1.5f);
            ItemPhotoViewBinding itemPhotoViewBinding18 = this.photoBinding;
            if (itemPhotoViewBinding18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            ImageLoadProgressBar imageLoadProgressBar = itemPhotoViewBinding18.progressBar;
            Intrinsics.checkNotNullExpressionValue(imageLoadProgressBar, "photoBinding.progressBar");
            imageLoadProgressBar.setVisibility(8);
            ItemPhotoViewBinding itemPhotoViewBinding19 = this.photoBinding;
            if (itemPhotoViewBinding19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            ImageLoadProgressBar imageLoadProgressBar2 = itemPhotoViewBinding19.progressBar;
            Intrinsics.checkNotNullExpressionValue(imageLoadProgressBar2, "photoBinding.progressBar");
            imageLoadProgressBar2.setTextColor(AppHolder.getAppTheme().getColorAccent());
            ItemPhotoViewBinding itemPhotoViewBinding20 = this.photoBinding;
            if (itemPhotoViewBinding20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            ImageLoadProgressBar imageLoadProgressBar3 = itemPhotoViewBinding20.progressBar;
            Intrinsics.checkNotNullExpressionValue(imageLoadProgressBar3, "photoBinding.progressBar");
            imageLoadProgressBar3.setRingProgressColor(AppHolder.getAppTheme().getColorAccent());
            ItemPhotoViewBinding itemPhotoViewBinding21 = this.photoBinding;
            if (itemPhotoViewBinding21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            SubsamplingScaleImageView subsamplingScaleImageView2 = itemPhotoViewBinding21.imageView;
            Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView2, "photoBinding.imageView");
            subsamplingScaleImageView2.setContentDescription(r2);
            ItemPhotoViewBinding itemPhotoViewBinding22 = this.photoBinding;
            if (itemPhotoViewBinding22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            PhotoViewCompat photoViewCompat4 = itemPhotoViewBinding22.gifImageView;
            Intrinsics.checkNotNullExpressionValue(photoViewCompat4, "photoBinding.gifImageView");
            photoViewCompat4.setContentDescription(r2);
            ItemPhotoViewBinding itemPhotoViewBinding23 = this.photoBinding;
            if (itemPhotoViewBinding23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            PhotoViewCompat photoViewCompat5 = itemPhotoViewBinding23.thumbnailView;
            Intrinsics.checkNotNullExpressionValue(photoViewCompat5, "photoBinding.thumbnailView");
            photoViewCompat5.setContentDescription(r2);
            if (getUserVisibleHint()) {
                initData();
                return;
            }
            AppSetting appSetting = AppHolder.getAppSetting();
            Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
            if (appSetting.isWifiAvailable()) {
                ItemPhotoViewBinding itemPhotoViewBinding24 = this.photoBinding;
                if (itemPhotoViewBinding24 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                itemPhotoViewBinding24.getRoot().postDelayed(new PhotoViewActivity$ImageFragment$onActivityCreated$1(this), 800);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x007f  */
        public final void initData() {
            boolean z;
            if (!this.isLoadTaskStarted) {
                ItemPhotoViewBinding itemPhotoViewBinding = this.photoBinding;
                if (itemPhotoViewBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                ImageLoadProgressBar imageLoadProgressBar = itemPhotoViewBinding.progressBar;
                Intrinsics.checkNotNullExpressionValue(imageLoadProgressBar, "photoBinding.progressBar");
                imageLoadProgressBar.setAlpha(0.0f);
                ItemPhotoViewBinding itemPhotoViewBinding2 = this.photoBinding;
                if (itemPhotoViewBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                itemPhotoViewBinding2.progressBar.postDelayed(new PhotoViewActivity$ImageFragment$initData$1(this), 500);
                this.isLoadTaskStarted = true;
                PhotoViewUrl photoViewUrl = this.imageUrl;
                if (photoViewUrl == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
                }
                if (!TextUtils.isEmpty(photoViewUrl.getCurrentDisplay())) {
                    PhotoViewUrl photoViewUrl2 = this.imageUrl;
                    if (photoViewUrl2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
                    }
                    Integer needCoolapkHeader = photoViewUrl2.getNeedCoolapkHeader();
                    if (needCoolapkHeader != null && needCoolapkHeader.intValue() == 1 && this.inMessage) {
                        ImageArgs.Companion companion = ImageArgs.Companion;
                        PhotoViewUrl photoViewUrl3 = this.imageUrl;
                        if (photoViewUrl3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
                        }
                        String currentDisplay = photoViewUrl3.getCurrentDisplay();
                        Intrinsics.checkNotNull(currentDisplay);
                        z = companion.isGifPicture(currentDisplay);
                        if (!AppHolder.getAppSetting().shouldLoadSourcePhoto()) {
                            PhotoViewUrl photoViewUrl4 = this.imageUrl;
                            if (photoViewUrl4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
                            }
                            if (!TextUtils.isEmpty(photoViewUrl4.getCompress())) {
                                ImageArgs.Companion companion2 = ImageArgs.Companion;
                                PhotoViewUrl photoViewUrl5 = this.imageUrl;
                                if (photoViewUrl5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
                                }
                                if (!companion2.isGifPicture(photoViewUrl5.getSource()) && !z) {
                                    ItemPhotoViewBinding itemPhotoViewBinding3 = this.photoBinding;
                                    if (itemPhotoViewBinding3 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                                    }
                                    TextView textView = itemPhotoViewBinding3.loadSourceButton;
                                    Intrinsics.checkNotNullExpressionValue(textView, "photoBinding.loadSourceButton");
                                    textView.setVisibility(0);
                                    loadCompressed();
                                    ItemPhotoViewBinding itemPhotoViewBinding4 = this.photoBinding;
                                    if (itemPhotoViewBinding4 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                                    }
                                    itemPhotoViewBinding4.loadSourceButton.setOnClickListener(new PhotoViewActivity$ImageFragment$initData$2(this));
                                    return;
                                }
                            }
                        }
                        loadSource();
                    }
                }
                z = false;
                if (!AppHolder.getAppSetting().shouldLoadSourcePhoto()) {
                }
                loadSource();
            }
        }

        public final boolean canSwipe() {
            if (!this.allowExit) {
                return false;
            }
            ItemPhotoViewBinding itemPhotoViewBinding = this.photoBinding;
            if (itemPhotoViewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            SubsamplingScaleImageView subsamplingScaleImageView = itemPhotoViewBinding.imageView;
            Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView, "photoBinding.imageView");
            if (subsamplingScaleImageView.isImageLoaded()) {
                ItemPhotoViewBinding itemPhotoViewBinding2 = this.photoBinding;
                if (itemPhotoViewBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                if (itemPhotoViewBinding2.imageView.canScrollHorizontally(1)) {
                    return false;
                }
                ItemPhotoViewBinding itemPhotoViewBinding3 = this.photoBinding;
                if (itemPhotoViewBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                if (itemPhotoViewBinding3.imageView.canScrollHorizontally(-1)) {
                    return false;
                }
                ItemPhotoViewBinding itemPhotoViewBinding4 = this.photoBinding;
                if (itemPhotoViewBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                if (!itemPhotoViewBinding4.imageView.canScrollVertically(-1)) {
                    return true;
                }
                return false;
            }
            ItemPhotoViewBinding itemPhotoViewBinding5 = this.photoBinding;
            if (itemPhotoViewBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            PhotoViewCompat photoViewCompat = itemPhotoViewBinding5.gifImageView;
            Intrinsics.checkNotNullExpressionValue(photoViewCompat, "photoBinding.gifImageView");
            if (photoViewCompat.getDrawable() != null) {
                ItemPhotoViewBinding itemPhotoViewBinding6 = this.photoBinding;
                if (itemPhotoViewBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                if (itemPhotoViewBinding6.gifImageView.canScrollHorizontallySelf(1.0f)) {
                    return false;
                }
                ItemPhotoViewBinding itemPhotoViewBinding7 = this.photoBinding;
                if (itemPhotoViewBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                if (itemPhotoViewBinding7.gifImageView.canScrollHorizontallySelf(-1.0f)) {
                    return false;
                }
                ItemPhotoViewBinding itemPhotoViewBinding8 = this.photoBinding;
                if (itemPhotoViewBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                if (!itemPhotoViewBinding8.gifImageView.canScrollVerticallySelf(-1.0f)) {
                    return true;
                }
                return false;
            }
            ItemPhotoViewBinding itemPhotoViewBinding9 = this.photoBinding;
            if (itemPhotoViewBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            PhotoViewCompat photoViewCompat2 = itemPhotoViewBinding9.thumbnailView;
            Intrinsics.checkNotNullExpressionValue(photoViewCompat2, "photoBinding.thumbnailView");
            if (photoViewCompat2.getDrawable() == null) {
                return false;
            }
            ItemPhotoViewBinding itemPhotoViewBinding10 = this.photoBinding;
            if (itemPhotoViewBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            PhotoViewCompat photoViewCompat3 = itemPhotoViewBinding10.thumbnailView;
            Intrinsics.checkNotNullExpressionValue(photoViewCompat3, "photoBinding.thumbnailView");
            if (!photoViewCompat3.isShown()) {
                return false;
            }
            ItemPhotoViewBinding itemPhotoViewBinding11 = this.photoBinding;
            if (itemPhotoViewBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            if (itemPhotoViewBinding11.thumbnailView.canScrollHorizontallySelf(1.0f)) {
                return false;
            }
            ItemPhotoViewBinding itemPhotoViewBinding12 = this.photoBinding;
            if (itemPhotoViewBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            if (itemPhotoViewBinding12.thumbnailView.canScrollHorizontallySelf(-1.0f)) {
                return false;
            }
            ItemPhotoViewBinding itemPhotoViewBinding13 = this.photoBinding;
            if (itemPhotoViewBinding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            if (!itemPhotoViewBinding13.thumbnailView.canScrollVerticallySelf(-1.0f)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Type inference failed for: r0v11, types: [com.coolapk.market.imageloader.GlideRequest] */
        /* JADX WARN: Type inference failed for: r0v18, types: [com.coolapk.market.imageloader.GlideRequest] */
        /* JADX WARN: Type inference failed for: r0v32, types: [com.coolapk.market.imageloader.GlideRequest] */
        /* access modifiers changed from: private */
        /* JADX WARNING: Unknown variable types count: 3 */
        public final void loadCompressed() {
            PhotoViewUrl photoViewUrl = this.imageUrl;
            if (photoViewUrl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
            }
            Uri parse = Uri.parse(photoViewUrl.getSource());
            Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(imageUrl.source)");
            String path = parse.getPath();
            Intrinsics.checkNotNull(path);
            Intrinsics.checkNotNullExpressionValue(path, "Uri.parse(imageUrl.source).path!!");
            if (ImageArgs.Companion.isGifPicture(path)) {
                GlideRequests with = GlideApp.with(this);
                PhotoViewUrl photoViewUrl2 = this.imageUrl;
                if (photoViewUrl2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
                }
                GlideRequest diskCacheStrategy = with.load(photoViewUrl2.getSource()).onlyRetrieveFromCache(true).fitCenter().diskCacheStrategy(DiskCacheStrategy.DATA);
                ItemPhotoViewBinding itemPhotoViewBinding = this.photoBinding;
                if (itemPhotoViewBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                Intrinsics.checkNotNullExpressionValue(diskCacheStrategy.into((GlideRequest) new PhotoViewActivity$ImageFragment$loadCompressed$1(this, itemPhotoViewBinding.gifImageView)), "GlideApp.with(this)\n    …                       })");
            } else {
                GlideRequest<File> downloadOnly = GlideApp.with(this).downloadOnly();
                PhotoViewUrl photoViewUrl3 = this.imageUrl;
                if (photoViewUrl3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
                }
                Intrinsics.checkNotNullExpressionValue(downloadOnly.load(photoViewUrl3.getSource()).onlyRetrieveFromCache(true).into((GlideRequest<File>) new PhotoViewActivity$ImageFragment$loadCompressed$2(this)), "GlideApp.with(this)\n    …                       })");
            }
            ItemPhotoViewBinding itemPhotoViewBinding2 = this.photoBinding;
            if (itemPhotoViewBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            ImageLoadProgressBar imageLoadProgressBar = itemPhotoViewBinding2.progressBar;
            PhotoViewUrl photoViewUrl4 = this.imageUrl;
            if (photoViewUrl4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
            }
            imageLoadProgressBar.setMonitorUrl(photoViewUrl4.getCompress());
            if (this.inMessage) {
                GlideRequests with2 = GlideApp.with(this);
                PhotoViewUrl photoViewUrl5 = this.imageUrl;
                if (photoViewUrl5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
                }
                GlideRequest fitCenter = with2.load((Object) getGlideUrl(photoViewUrl5.getCompress(), true)).diskCacheStrategy(DiskCacheStrategy.DATA).fitCenter();
                ItemPhotoViewBinding itemPhotoViewBinding3 = this.photoBinding;
                if (itemPhotoViewBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                Intrinsics.checkNotNullExpressionValue(fitCenter.into((GlideRequest) new PhotoViewActivity$ImageFragment$loadCompressed$3(this, itemPhotoViewBinding3.thumbnailView)), "GlideApp.with(this)\n    …                       })");
                return;
            }
            GlideRequests with3 = GlideApp.with(this);
            PhotoViewUrl photoViewUrl6 = this.imageUrl;
            if (photoViewUrl6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
            }
            GlideRequest fitCenter2 = with3.load(photoViewUrl6.getCompress()).diskCacheStrategy(DiskCacheStrategy.DATA).fitCenter();
            ItemPhotoViewBinding itemPhotoViewBinding4 = this.photoBinding;
            if (itemPhotoViewBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            Intrinsics.checkNotNullExpressionValue(fitCenter2.into((GlideRequest) new PhotoViewActivity$ImageFragment$loadCompressed$4(this, itemPhotoViewBinding4.thumbnailView)), "GlideApp.with(this)\n    …                       })");
        }

        /* JADX WARN: Type inference failed for: r2v10, types: [com.coolapk.market.imageloader.GlideRequest] */
        /* JADX WARN: Type inference failed for: r0v12, types: [com.coolapk.market.imageloader.GlideRequest] */
        /* JADX WARN: Type inference failed for: r2v17, types: [com.coolapk.market.imageloader.GlideRequest] */
        /* JADX WARN: Type inference failed for: r0v22, types: [com.coolapk.market.imageloader.GlideRequest] */
        /* JADX WARN: Type inference failed for: r1v6, types: [com.coolapk.market.imageloader.GlideRequest] */
        /* JADX WARN: Type inference failed for: r1v17, types: [com.coolapk.market.imageloader.GlideRequest] */
        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x01a3  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x01b4  */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x0231  */
        /* JADX WARNING: Unknown variable types count: 6 */
        public final void loadSource() {
            boolean z;
            ItemPhotoViewBinding itemPhotoViewBinding;
            ItemPhotoViewBinding itemPhotoViewBinding2 = this.photoBinding;
            if (itemPhotoViewBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            ImageLoadProgressBar imageLoadProgressBar = itemPhotoViewBinding2.progressBar;
            PhotoViewUrl photoViewUrl = this.imageUrl;
            if (photoViewUrl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
            }
            imageLoadProgressBar.setMonitorUrl(photoViewUrl.getSource());
            PhotoViewUrl photoViewUrl2 = this.imageUrl;
            if (photoViewUrl2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
            }
            Uri parse = Uri.parse(photoViewUrl2.getSource());
            Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(imageUrl.source)");
            String path = parse.getPath();
            Intrinsics.checkNotNull(path);
            Intrinsics.checkNotNullExpressionValue(path, "Uri.parse(imageUrl.source).path!!");
            PhotoViewUrl photoViewUrl3 = this.imageUrl;
            if (photoViewUrl3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
            }
            boolean z2 = false;
            if (!TextUtils.isEmpty(photoViewUrl3.getCurrentDisplay())) {
                PhotoViewUrl photoViewUrl4 = this.imageUrl;
                if (photoViewUrl4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
                }
                Integer needCoolapkHeader = photoViewUrl4.getNeedCoolapkHeader();
                if (needCoolapkHeader != null && needCoolapkHeader.intValue() == 1) {
                    ImageArgs.Companion companion = ImageArgs.Companion;
                    PhotoViewUrl photoViewUrl5 = this.imageUrl;
                    if (photoViewUrl5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
                    }
                    String currentDisplay = photoViewUrl5.getCurrentDisplay();
                    Intrinsics.checkNotNull(currentDisplay);
                    z = companion.isGifPicture(currentDisplay);
                    if (!ImageArgs.Companion.isGifPicture(path) || z) {
                        itemPhotoViewBinding = this.photoBinding;
                        if (itemPhotoViewBinding == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                        }
                        SubsamplingScaleImageView subsamplingScaleImageView = itemPhotoViewBinding.imageView;
                        Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView, "photoBinding.imageView");
                        subsamplingScaleImageView.setVisibility(8);
                        if (!z) {
                            ImageFragment imageFragment = this;
                            GlideRequests with = GlideApp.with(imageFragment);
                            PhotoViewUrl photoViewUrl6 = this.imageUrl;
                            if (photoViewUrl6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
                            }
                            String source = photoViewUrl6.getSource();
                            PhotoViewUrl photoViewUrl7 = this.imageUrl;
                            if (photoViewUrl7 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
                            }
                            Integer needCoolapkHeader2 = photoViewUrl7.getNeedCoolapkHeader();
                            if (needCoolapkHeader2 != null && needCoolapkHeader2.intValue() == 1) {
                                z2 = true;
                            }
                            GlideRequest diskCacheStrategy = with.load((Object) getGlideUrl(source, z2)).diskCacheStrategy(DiskCacheStrategy.DATA);
                            GlideRequests with2 = GlideApp.with(imageFragment);
                            PhotoViewUrl photoViewUrl8 = this.imageUrl;
                            if (photoViewUrl8 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
                            }
                            GlideRequest listener = diskCacheStrategy.thumbnail((RequestBuilder) with2.load(photoViewUrl8.getCompress()).diskCacheStrategy(DiskCacheStrategy.DATA)).fitCenter().listener((RequestListener) new PhotoViewActivity$ImageFragment$loadSource$1(this));
                            ItemPhotoViewBinding itemPhotoViewBinding3 = this.photoBinding;
                            if (itemPhotoViewBinding3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                            }
                            Intrinsics.checkNotNullExpressionValue(listener.into((GlideRequest) new PhotoViewActivity$ImageFragment$loadSource$2(this, itemPhotoViewBinding3.gifImageView)), "GlideApp.with(this)\n    …                       })");
                            return;
                        }
                        ImageFragment imageFragment2 = this;
                        GlideRequests with3 = GlideApp.with(imageFragment2);
                        PhotoViewUrl photoViewUrl9 = this.imageUrl;
                        if (photoViewUrl9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
                        }
                        GlideRequest diskCacheStrategy2 = with3.load(photoViewUrl9.getSource()).diskCacheStrategy(DiskCacheStrategy.DATA);
                        GlideRequests with4 = GlideApp.with(imageFragment2);
                        PhotoViewUrl photoViewUrl10 = this.imageUrl;
                        if (photoViewUrl10 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
                        }
                        GlideRequest listener2 = diskCacheStrategy2.thumbnail((RequestBuilder) with4.load(photoViewUrl10.getCompress()).diskCacheStrategy(DiskCacheStrategy.DATA)).fitCenter().listener((RequestListener) new PhotoViewActivity$ImageFragment$loadSource$3(this));
                        ItemPhotoViewBinding itemPhotoViewBinding4 = this.photoBinding;
                        if (itemPhotoViewBinding4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                        }
                        Intrinsics.checkNotNullExpressionValue(listener2.into((GlideRequest) new PhotoViewActivity$ImageFragment$loadSource$4(this, itemPhotoViewBinding4.gifImageView)), "GlideApp.with(this)\n    …                       })");
                        return;
                    }
                    PhotoViewUrl photoViewUrl11 = this.imageUrl;
                    if (photoViewUrl11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
                    }
                    Integer needCoolapkHeader3 = photoViewUrl11.getNeedCoolapkHeader();
                    if (needCoolapkHeader3 != null && needCoolapkHeader3.intValue() == 1) {
                        ImageFragment imageFragment3 = this;
                        GlideRequests with5 = GlideApp.with(imageFragment3);
                        PhotoViewUrl photoViewUrl12 = this.imageUrl;
                        if (photoViewUrl12 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
                        }
                        String compress = photoViewUrl12.getCompress();
                        PhotoViewUrl photoViewUrl13 = this.imageUrl;
                        if (photoViewUrl13 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
                        }
                        Integer needCoolapkHeader4 = photoViewUrl13.getNeedCoolapkHeader();
                        with5.load((Object) getGlideUrl(compress, needCoolapkHeader4 != null && needCoolapkHeader4.intValue() == 1)).diskCacheStrategy(DiskCacheStrategy.DATA).fitCenter().listener((RequestListener) new PhotoViewActivity$ImageFragment$loadSource$5(this)).into((GlideRequest) new PhotoViewActivity$ImageFragment$loadSource$6(this));
                        GlideRequest<File> downloadOnly = GlideApp.with(imageFragment3).downloadOnly();
                        PhotoViewUrl photoViewUrl14 = this.imageUrl;
                        if (photoViewUrl14 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
                        }
                        String source2 = photoViewUrl14.getSource();
                        PhotoViewUrl photoViewUrl15 = this.imageUrl;
                        if (photoViewUrl15 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
                        }
                        Integer needCoolapkHeader5 = photoViewUrl15.getNeedCoolapkHeader();
                        if (needCoolapkHeader5 != null && needCoolapkHeader5.intValue() == 1) {
                            z2 = true;
                        }
                        Intrinsics.checkNotNullExpressionValue(downloadOnly.load((Object) getGlideUrl(source2, z2)).listener((RequestListener<File>) new PhotoViewActivity$ImageFragment$loadSource$7(this)).into((GlideRequest<File>) new PhotoViewActivity$ImageFragment$loadSource$8(this)), "GlideApp.with(this)\n    …                       })");
                        return;
                    }
                    ImageFragment imageFragment4 = this;
                    GlideRequests with6 = GlideApp.with(imageFragment4);
                    PhotoViewUrl photoViewUrl16 = this.imageUrl;
                    if (photoViewUrl16 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
                    }
                    with6.load(photoViewUrl16.getCompress()).diskCacheStrategy(DiskCacheStrategy.DATA).fitCenter().listener((RequestListener) new PhotoViewActivity$ImageFragment$loadSource$9(this)).into((GlideRequest) new PhotoViewActivity$ImageFragment$loadSource$10(this));
                    GlideRequest<File> downloadOnly2 = GlideApp.with(imageFragment4).downloadOnly();
                    PhotoViewUrl photoViewUrl17 = this.imageUrl;
                    if (photoViewUrl17 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("imageUrl");
                    }
                    Intrinsics.checkNotNullExpressionValue(downloadOnly2.load(photoViewUrl17.getSource()).listener((RequestListener<File>) new PhotoViewActivity$ImageFragment$loadSource$11(this)).into((GlideRequest<File>) new PhotoViewActivity$ImageFragment$loadSource$12(this)), "GlideApp.with(this)\n    …                       })");
                    return;
                }
            }
            z = false;
            if (!ImageArgs.Companion.isGifPicture(path)) {
            }
            itemPhotoViewBinding = this.photoBinding;
            if (itemPhotoViewBinding == null) {
            }
            SubsamplingScaleImageView subsamplingScaleImageView = itemPhotoViewBinding.imageView;
            Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView, "photoBinding.imageView");
            subsamplingScaleImageView.setVisibility(8);
            if (!z) {
            }
        }

        /* JADX WARN: Type inference failed for: r11v2, types: [com.coolapk.market.imageloader.GlideRequest] */
        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b5, code lost:
            if (r6 > ((float) 5)) goto L_0x0081;
         */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00c7  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00cc  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x0104  */
        /* JADX WARNING: Unknown variable types count: 1 */
        public final void onImageFileLoaded(File file) {
            boolean z;
            ItemPhotoViewBinding itemPhotoViewBinding = this.photoBinding;
            if (itemPhotoViewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            TextView textView = itemPhotoViewBinding.loadSourceButton;
            Intrinsics.checkNotNullExpressionValue(textView, "photoBinding.loadSourceButton");
            textView.setVisibility(8);
            boolean z2 = true;
            this.allowExit = true;
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            ItemPhotoViewBinding itemPhotoViewBinding2 = this.photoBinding;
            if (itemPhotoViewBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            View root = itemPhotoViewBinding2.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "photoBinding.root");
            Float valueOf = Float.valueOf((float) root.getHeight());
            ItemPhotoViewBinding itemPhotoViewBinding3 = this.photoBinding;
            if (itemPhotoViewBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
            }
            View root2 = itemPhotoViewBinding3.getRoot();
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
                if (((float) options.outHeight) / ((float) options.outWidth) <= floatValue / floatValue2) {
                    z2 = false;
                }
                if (!z) {
                    ItemPhotoViewBinding itemPhotoViewBinding4 = this.photoBinding;
                    if (itemPhotoViewBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                    }
                    SubsamplingScaleImageView subsamplingScaleImageView = itemPhotoViewBinding4.imageView;
                    Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView, "photoBinding.imageView");
                    subsamplingScaleImageView.setVisibility(0);
                    ItemPhotoViewBinding itemPhotoViewBinding5 = this.photoBinding;
                    if (itemPhotoViewBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                    }
                    itemPhotoViewBinding5.imageView.setImage(ImageSource.uri(file.getAbsolutePath()));
                    ItemPhotoViewBinding itemPhotoViewBinding6 = this.photoBinding;
                    if (itemPhotoViewBinding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                    }
                    itemPhotoViewBinding6.imageView.setOnImageEventListener(new PhotoViewActivity$ImageFragment$onImageFileLoaded$1(this, z2, floatValue2, floatValue));
                    return;
                }
                if (z2) {
                    ItemPhotoViewBinding itemPhotoViewBinding7 = this.photoBinding;
                    if (itemPhotoViewBinding7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                    }
                    PhotoViewCompat photoViewCompat = itemPhotoViewBinding7.gifImageView;
                    Intrinsics.checkNotNullExpressionValue(photoViewCompat, "photoBinding.gifImageView");
                    photoViewCompat.setScaleType(ImageView.ScaleType.FIT_START);
                }
                ItemPhotoViewBinding itemPhotoViewBinding8 = this.photoBinding;
                if (itemPhotoViewBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                PhotoViewCompat photoViewCompat2 = itemPhotoViewBinding8.gifImageView;
                Intrinsics.checkNotNullExpressionValue(photoViewCompat2, "photoBinding.gifImageView");
                photoViewCompat2.setVisibility(0);
                ItemPhotoViewBinding itemPhotoViewBinding9 = this.photoBinding;
                if (itemPhotoViewBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                SubsamplingScaleImageView subsamplingScaleImageView2 = itemPhotoViewBinding9.imageView;
                Intrinsics.checkNotNullExpressionValue(subsamplingScaleImageView2, "photoBinding.imageView");
                subsamplingScaleImageView2.setVisibility(8);
                ItemPhotoViewBinding itemPhotoViewBinding10 = this.photoBinding;
                if (itemPhotoViewBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                itemPhotoViewBinding10.gifImageView.enable();
                GlideRequest listener = GlideApp.with(requireActivity()).load(Uri.fromFile(file)).override(Integer.MIN_VALUE, Integer.MIN_VALUE).diskCacheStrategy(DiskCacheStrategy.NONE).dontTransform().listener((RequestListener) new PhotoViewActivity$ImageFragment$onImageFileLoaded$2(this));
                ItemPhotoViewBinding itemPhotoViewBinding11 = this.photoBinding;
                if (itemPhotoViewBinding11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoBinding");
                }
                Intrinsics.checkNotNullExpressionValue(listener.into((GlideRequest) new PhotoViewActivity$ImageFragment$onImageFileLoaded$3(this, itemPhotoViewBinding11.gifImageView)), "GlideApp.with(requireAct…                       })");
                return;
            }
            z = true;
            if (((float) options.outHeight) / ((float) options.outWidth) <= floatValue / floatValue2) {
            }
            if (!z) {
            }
        }

        private final GlideUrl getGlideUrl(String str, boolean z) {
            LazyHeaders.Builder builder = new LazyHeaders.Builder();
            if (z) {
                try {
                    DataManager instance = DataManager.getInstance();
                    Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                    DataConfig dataConfig = instance.getDataConfig();
                    Intrinsics.checkNotNullExpressionValue(dataConfig, "dataConfig");
                    List<String> coolMarketHeaders = dataConfig.getCoolMarketHeaders();
                    for (int i = 0; i < coolMarketHeaders.size(); i += 2) {
                        builder.addHeader(coolMarketHeaders.get(i), coolMarketHeaders.get(i + 1));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                HttpClientFactory instance2 = HttpClientFactory.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance2, "HttpClientFactory.getInstance()");
                CookieJar cookieJar = instance2.getCoolMarketHttpClient().cookieJar();
                HttpUrl.Companion companion = HttpUrl.Companion;
                Intrinsics.checkNotNull(str);
                List<Cookie> loadForRequest = cookieJar.loadForRequest(companion.get(str));
                StringBuilder sb = new StringBuilder();
                for (Cookie cookie : loadForRequest) {
                    sb.append(cookie.name() + "=" + cookie.value() + ";");
                }
                builder.addHeader("Cookie", sb.toString());
            } else {
                DataManager instance3 = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance3, "DataManager.getInstance()");
                DataConfig dataConfig2 = instance3.getDataConfig();
                Intrinsics.checkNotNullExpressionValue(dataConfig2, "DataManager.getInstance().dataConfig");
                builder.setHeader("User-Agent", Html.escapeHtml(dataConfig2.getUserAgent()));
            }
            return new GlideUrl(str, builder.build());
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000eJ.\u0010\b\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/photo/PhotoViewActivity$ImageFragment$Companion;", "", "()V", "KEY_FEED_TYPE", "", "KEY_IMAGE_URL", "KEY_IN_MESSAGE", "KEY_POSITION", "newInstance", "Lcom/coolapk/market/view/photo/PhotoViewActivity$ImageFragment;", "imageUrl", "Lcom/coolapk/market/view/photo/PhotoViewUrl;", "sign", "position", "", "imageUrls", "", "inMessage", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: PhotoViewActivity.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final ImageFragment newInstance(PhotoViewUrl photoViewUrl, String str, int i) {
                Intrinsics.checkNotNullParameter(photoViewUrl, "imageUrl");
                Bundle bundle = new Bundle();
                bundle.putParcelable("IMAGE_URL", photoViewUrl);
                bundle.putString("EXTRA_FEED_TYPE", str);
                bundle.putInt("EXTRA_POSITION", i);
                ImageFragment imageFragment = new ImageFragment();
                imageFragment.setArguments(bundle);
                return imageFragment;
            }

            public final ImageFragment newInstance(List<PhotoViewUrl> list, String str, int i, boolean z) {
                Intrinsics.checkNotNullParameter(list, "imageUrls");
                Bundle bundle = new Bundle();
                if (!(list instanceof ArrayList)) {
                    list = null;
                }
                bundle.putParcelableArrayList("IMAGE_URL", (ArrayList) list);
                bundle.putString("EXTRA_FEED_TYPE", str);
                bundle.putInt("EXTRA_POSITION", i);
                bundle.putBoolean("EXTRA_IN_MESSAGE", z);
                ImageFragment imageFragment = new ImageFragment();
                imageFragment.setArguments(bundle);
                return imageFragment;
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/photo/PhotoViewActivity$ImageViewPagerAdapter;", "Lcom/coolapk/market/view/base/FragmentStatePagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "data", "", "Lcom/coolapk/market/view/photo/PhotoViewUrl;", "(Lcom/coolapk/market/view/photo/PhotoViewActivity;Landroidx/fragment/app/FragmentManager;Ljava/util/List;)V", "getCount", "", "getItem", "Lcom/coolapk/market/view/photo/PhotoViewActivity$ImageFragment;", "position", "getItemTag", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PhotoViewActivity.kt */
    private final class ImageViewPagerAdapter extends FragmentStatePagerAdapter {
        private final List<PhotoViewUrl> data;
        final /* synthetic */ PhotoViewActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ImageViewPagerAdapter(PhotoViewActivity photoViewActivity, FragmentManager fragmentManager, List<PhotoViewUrl> list) {
            super(fragmentManager);
            Intrinsics.checkNotNullParameter(fragmentManager, "fm");
            Intrinsics.checkNotNullParameter(list, "data");
            this.this$0 = photoViewActivity;
            this.data = list;
        }

        @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
        public ImageFragment getItem(int i) {
            return ImageFragment.Companion.newInstance(this.data, this.this$0.feedType, i, this.this$0.inMessage);
        }

        @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
        public String getItemTag(int i) {
            return "FRAGMENT_" + i;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.data.size();
        }
    }
}
