package com.coolapk.market.view.product;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.LinearLayout;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.model.Product;
import com.coolapk.market.model.ShareFeedInfo;
import com.coolapk.market.model.Video;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.feedv8.FeedArgsFactory;
import com.coolapk.market.view.feedv8.FeedArgsFactoryKt;
import com.coolapk.market.view.feedv8.ShareFeedV8Activity;
import com.coolapk.market.widget.video.VideoModelKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0014J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0014¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/product/ProductShareVideoActivity;", "Lcom/coolapk/market/view/feedv8/ShareFeedV8Activity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onShareInfoLoadError", "e", "", "onShareInfoLoaded", "info", "Lcom/coolapk/market/model/ShareFeedInfo;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductShareVideoActivity.kt */
public final class ProductShareVideoActivity extends ShareFeedV8Activity {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_DATA = "extra_data";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/product/ProductShareVideoActivity$Companion;", "", "()V", "EXTRA_DATA", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductShareVideoActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.feedv8.ShareFeedV8Activity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout linearLayout = getBinding$presentation_coolapkAppRelease().bottomAreaView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.bottomAreaView");
        linearLayout.setVisibility(8);
    }

    @Override // com.coolapk.market.view.feedv8.ShareFeedV8Activity
    protected void onShareInfoLoaded(ShareFeedInfo shareFeedInfo) {
        Intrinsics.checkNotNullParameter(shareFeedInfo, "info");
        Video parseJsonAsVideo = VideoModelKt.parseJsonAsVideo(shareFeedInfo.getMediaInfo());
        if (parseJsonAsVideo != null) {
            Parcelable parcelableExtra = getIntent().getParcelableExtra("extra_data");
            Intrinsics.checkNotNull(parcelableExtra);
            Intrinsics.checkNotNullExpressionValue(parcelableExtra, "intent.getParcelableExtra<Product>(EXTRA_DATA)!!");
            Product product = (Product) parcelableExtra;
            FeedMultiPart.Builder insertProductMedia = FeedArgsFactoryKt.applyProduct(FeedArgsFactory.multiPartForFeed(), product).insertProductMedia(true);
            FeedMultiPart.Builder mediaType = insertProductMedia.message(' ' + parseJsonAsVideo.getName() + ' ').extraPic(shareFeedInfo.getLogo()).extraTitle(shareFeedInfo.getTitle()).extraUrl(shareFeedInfo.getUrl()).extraInfo(shareFeedInfo.getDescription()).mediaType(shareFeedInfo.getMediaType());
            String mediaUrl = shareFeedInfo.getMediaUrl();
            String str = "";
            if (mediaUrl == null) {
                mediaUrl = str;
            }
            FeedMultiPart.Builder mediaUrl2 = mediaType.mediaUrl(mediaUrl);
            String mediaPic = shareFeedInfo.getMediaPic();
            if (mediaPic == null) {
                mediaPic = str;
            }
            FeedMultiPart.Builder mediaPic2 = mediaUrl2.mediaPic(mediaPic);
            String mediaInfo = shareFeedInfo.getMediaInfo();
            if (mediaInfo == null) {
                mediaInfo = str;
            }
            FeedMultiPart.Builder mediaInfo2 = mediaPic2.mediaInfo(mediaInfo);
            String packageName = shareFeedInfo.getPackageName();
            if (packageName != null) {
                str = packageName;
            }
            FeedMultiPart build = mediaInfo2.extraKey(str).build();
            BaseActivity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            FeedUIConfig.Builder uiConfigForFeed = FeedArgsFactory.uiConfigForFeed(activity);
            BaseActivity activity2 = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity2, "activity");
            ActionManager.startSubmitFeedV8Activity(getActivity(), FeedArgsFactoryKt.applyProduct(uiConfigForFeed, activity2, product).title("发视频").isExtraViewVisible(false).isPickPhotoContainerVisible(false).addPhotoMenuEnable(false).isRemoveExtraViewVisible(true).build(), build);
        } else {
            Parcelable parcelableExtra2 = getIntent().getParcelableExtra("extra_data");
            Intrinsics.checkNotNull(parcelableExtra2);
            Intrinsics.checkNotNullExpressionValue(parcelableExtra2, "intent.getParcelableExtra<Product>(EXTRA_DATA)!!");
            Product product2 = (Product) parcelableExtra2;
            FeedMultiPart build2 = FeedArgsFactoryKt.applyProduct(FeedArgsFactory.multiPartForFeed(), product2).insertProductMedia(true).build();
            BaseActivity activity3 = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity3, "activity");
            FeedUIConfig.Builder uiConfigForFeed2 = FeedArgsFactory.uiConfigForFeed(activity3);
            BaseActivity activity4 = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity4, "activity");
            ActionManager.startSubmitFeedV8Activity(getActivity(), FeedArgsFactoryKt.applyProduct(uiConfigForFeed2, activity4, product2).title("发视频").build(), build2);
        }
        finish();
        overridePendingTransition(0, 0);
    }

    @Override // com.coolapk.market.view.feedv8.ShareFeedV8Activity
    protected void onShareInfoLoadError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        Parcelable parcelableExtra = getIntent().getParcelableExtra("extra_data");
        Intrinsics.checkNotNull(parcelableExtra);
        Intrinsics.checkNotNullExpressionValue(parcelableExtra, "intent.getParcelableExtra<Product>(EXTRA_DATA)!!");
        Product product = (Product) parcelableExtra;
        FeedMultiPart build = FeedArgsFactoryKt.applyProduct(FeedArgsFactory.multiPartForFeed(), product).insertProductMedia(true).build();
        BaseActivity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        FeedUIConfig.Builder uiConfigForFeed = FeedArgsFactory.uiConfigForFeed(activity);
        BaseActivity activity2 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        ActionManager.startSubmitFeedV8Activity(getActivity(), FeedArgsFactoryKt.applyProduct(uiConfigForFeed, activity2, product).title("发视频").build(), build);
        getActivity().finish();
        getActivity().overridePendingTransition(0, 0);
    }
}
