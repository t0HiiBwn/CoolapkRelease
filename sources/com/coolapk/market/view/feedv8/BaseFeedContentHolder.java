package com.coolapk.market.view.feedv8;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.model.ShareFeedInfo;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.widget.emotion.BaseEmotion;
import com.coolapk.market.widget.emotion.EmotionPanel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\b&\u0018\u00002\u00020\u0001:\u0001qB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0002J\r\u0010*\u001a\u00020\u0015H\u0010¢\u0006\u0002\b+J\r\u0010,\u001a\u00020\u001cH\u0010¢\u0006\u0002\b-J\r\u0010.\u001a\u00020/H\u0010¢\u0006\u0002\b0J \u00101\u001a\u00020/2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u000206H\u0017J\u0015\u00107\u001a\u00020\b2\u0006\u00108\u001a\u000209H ¢\u0006\u0002\b:J\b\u0010;\u001a\u00020/H\u0016J\b\u0010<\u001a\u00020/H\u0016J\u0010\u0010=\u001a\u00020/2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010@\u001a\u00020/2\u0006\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020/H\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u00105\u001a\u000206H\u0016J\u0010\u0010E\u001a\u00020/2\u0006\u00105\u001a\u000206H\u0016J\u0016\u0010F\u001a\u00020/2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020&0(H\u0016J\u0010\u0010H\u001a\u00020/2\u0006\u00105\u001a\u000206H\u0016J\b\u0010I\u001a\u00020/H\u0016J\b\u0010J\u001a\u00020/H\u0016J\b\u0010K\u001a\u00020/H\u0016J#\u0010L\u001a\u00020/2\u0006\u0010M\u001a\u00020&2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020&0OH\u0000¢\u0006\u0002\bPJ\u0010\u0010Q\u001a\u00020/2\u0006\u0010R\u001a\u00020SH\u0016J\r\u0010T\u001a\u00020/H\u0000¢\u0006\u0002\bUJ\b\u0010V\u001a\u00020/H\u0016J\b\u0010W\u001a\u00020/H\u0016J\u0018\u0010X\u001a\u00020/2\u0006\u0010R\u001a\u00020&2\u0006\u0010Y\u001a\u00020&H\u0016J\b\u0010Z\u001a\u00020/H\u0016J\u0013\u0010[\u001a\b\u0012\u0004\u0012\u00020\u001c0\\H\u0010¢\u0006\u0002\b]J\r\u0010^\u001a\u00020/H\u0000¢\u0006\u0002\b_J\r\u0010`\u001a\u00020/H\u0000¢\u0006\u0002\baJ\r\u0010b\u001a\u00020/H\u0000¢\u0006\u0002\bcJ#\u0010d\u001a\u00020/2\u0006\u0010e\u001a\u0002032\f\u0010f\u001a\b\u0012\u0004\u0012\u00020&0(H\u0000¢\u0006\u0002\bgJ\u000e\u0010h\u001a\u00020/2\u0006\u0010\u0019\u001a\u00020\u001aJ\r\u0010i\u001a\u00020/H\u0000¢\u0006\u0002\bjJ\u0015\u0010k\u001a\u00020/2\u0006\u0010l\u001a\u00020\u001cH\u0000¢\u0006\u0002\bmJ\u0015\u0010n\u001a\u00020/2\u0006\u0010o\u001a\u00020\"H\u0000¢\u0006\u0002\bpR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8@X\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0012\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\nR\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006r"}, d2 = {"Lcom/coolapk/market/view/feedv8/BaseFeedContentHolder;", "Lcom/coolapk/market/widget/emotion/EmotionPanel$EmotionPanelListener;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "contentView$delegate", "Lkotlin/Lazy;", "extraViewPart", "Lcom/coolapk/market/view/feedv8/SubmitExtraViewPart;", "getExtraViewPart$presentation_coolapkAppRelease", "()Lcom/coolapk/market/view/feedv8/SubmitExtraViewPart;", "extraViewPart$delegate", "focusEditorView", "getFocusEditorView", "<set-?>", "", "isPostSucceed", "()Z", "isPosting", "listener", "Lcom/coolapk/market/view/feedv8/BaseFeedContentHolder$PostListener;", "multiPart", "Lcom/coolapk/market/model/FeedMultiPart;", "getMultiPart", "()Lcom/coolapk/market/model/FeedMultiPart;", "submitActivity", "Lcom/coolapk/market/view/feedv8/SubmitFeedV8Activity;", "uiConfig", "Lcom/coolapk/market/model/FeedUIConfig;", "getUiConfig", "()Lcom/coolapk/market/model/FeedUIConfig;", "buildImageString", "", "list", "", "Lcom/coolapk/market/model/ImageUrl;", "checkSubmittable", "checkSubmittable$presentation_coolapkAppRelease", "generateDraftCopy", "generateDraftCopy$presentation_coolapkAppRelease", "notifyUIChange", "", "notifyUIChange$presentation_coolapkAppRelease", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateContentView", "inflater", "Landroid/view/LayoutInflater;", "onCreateContentView$presentation_coolapkAppRelease", "onDeleteButtonClick", "onDestroy", "onEmotionClick", "emotions", "Lcom/coolapk/market/widget/emotion/BaseEmotion;", "onExtraEntityLoaded", "entity", "Lcom/coolapk/market/model/Entity;", "onPause", "onPickAppIntent", "onPickAtIntent", "onPickImageListChange", "pathList", "onPickTopicIntent", "onPreviewClicked", "onRemoveExtraEntity", "onRequestPickImage", "onRequestWebViewUrl", "url", "strings", "Ljava/util/ArrayList;", "onRequestWebViewUrl$presentation_coolapkAppRelease", "onShareInfoLoaded", "info", "Lcom/coolapk/market/model/ShareFeedInfo;", "onShareInfoRemove", "onShareInfoRemove$presentation_coolapkAppRelease", "onSubmitButtonClick", "onSubmitToButtonClick", "onVideoDataLoaded", "sourceUrl", "onVideoDataRemoved", "prepareMultiFeed", "Lrx/Observable;", "prepareMultiFeed$presentation_coolapkAppRelease", "requestCheckSubmittable", "requestCheckSubmittable$presentation_coolapkAppRelease", "requestConvertToArticleMode", "requestConvertToArticleMode$presentation_coolapkAppRelease", "requestPickContacts", "requestPickContacts$presentation_coolapkAppRelease", "requestPickPhotos", "count", "currentList", "requestPickPhotos$presentation_coolapkAppRelease", "setPostListener", "startSubmitFeed", "startSubmitFeed$presentation_coolapkAppRelease", "updateMultiPart", "part", "updateMultiPart$presentation_coolapkAppRelease", "updateUiConfig", "config", "updateUiConfig$presentation_coolapkAppRelease", "PostListener", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseFeedContentHolder.kt */
public abstract class BaseFeedContentHolder implements EmotionPanel.EmotionPanelListener {
    private final Activity activity;
    private final Lazy contentView$delegate = LazyKt.lazy(new BaseFeedContentHolder$contentView$2(this));
    private final Lazy extraViewPart$delegate = LazyKt.lazy(new BaseFeedContentHolder$extraViewPart$2(this));
    private boolean isPostSucceed;
    private boolean isPosting;
    private PostListener listener;
    private final SubmitFeedV8Activity submitActivity;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/feedv8/BaseFeedContentHolder$PostListener;", "", "onNewMessage", "", "message", "", "onPostResult", "e", "", "onPostStart", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BaseFeedContentHolder.kt */
    public interface PostListener {
        void onNewMessage(String str);

        void onPostResult(Throwable th);

        void onPostStart();
    }

    public final View getContentView() {
        return (View) this.contentView$delegate.getValue();
    }

    public final SubmitExtraViewPart getExtraViewPart$presentation_coolapkAppRelease() {
        return (SubmitExtraViewPart) this.extraViewPart$delegate.getValue();
    }

    public abstract View getFocusEditorView();

    public void notifyUIChange$presentation_coolapkAppRelease() {
    }

    public abstract View onCreateContentView$presentation_coolapkAppRelease(LayoutInflater layoutInflater);

    @Override // com.coolapk.market.widget.emotion.EmotionPanel.EmotionPanelListener
    public void onDeleteButtonClick() {
    }

    public void onDestroy() {
    }

    @Override // com.coolapk.market.widget.emotion.EmotionPanel.EmotionPanelListener
    public void onEmotionClick(BaseEmotion baseEmotion) {
        Intrinsics.checkNotNullParameter(baseEmotion, "emotions");
    }

    public void onPause() {
    }

    public void onPickAppIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
    }

    public void onPickAtIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
    }

    public void onPickImageListChange(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "pathList");
    }

    public void onPickTopicIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
    }

    public void onPreviewClicked() {
    }

    public void onRemoveExtraEntity() {
    }

    public void onRequestPickImage() {
    }

    public void onSubmitButtonClick() {
    }

    public void onSubmitToButtonClick() {
    }

    public void onVideoDataRemoved() {
    }

    public BaseFeedContentHolder(Activity activity2) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.activity = activity2;
        Objects.requireNonNull(activity2, "null cannot be cast to non-null type com.coolapk.market.view.feedv8.SubmitFeedV8Activity");
        this.submitActivity = (SubmitFeedV8Activity) activity2;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final boolean isPosting() {
        return this.isPosting;
    }

    public final boolean isPostSucceed() {
        return this.isPostSucceed;
    }

    public final FeedUIConfig getUiConfig() {
        return this.submitActivity.getUiConfig();
    }

    public final FeedMultiPart getMultiPart() {
        return this.submitActivity.getMultiPart();
    }

    public final void setPostListener(PostListener postListener) {
        Intrinsics.checkNotNullParameter(postListener, "listener");
        this.listener = postListener;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        getExtraViewPart$presentation_coolapkAppRelease().onActivityResult(i, i2, intent);
    }

    public void onExtraEntityLoaded(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        onShareInfoRemove$presentation_coolapkAppRelease();
        onVideoDataRemoved();
    }

    public void onShareInfoLoaded(ShareFeedInfo shareFeedInfo) {
        Intrinsics.checkNotNullParameter(shareFeedInfo, "info");
        onVideoDataRemoved();
        onRemoveExtraEntity();
        FeedMultiPart.Builder builder = FeedMultiPart.builder(getMultiPart());
        builder.extraTitle(shareFeedInfo.getTitle()).extraPic(shareFeedInfo.getLogo()).extraUrl(shareFeedInfo.getUrl()).extraInfo(shareFeedInfo.getDescription()).mediaType(shareFeedInfo.getMediaType()).mediaUrl(StringUtils.emptyIfNull(shareFeedInfo.getMediaUrl())).mediaPic(StringUtils.emptyIfNull(shareFeedInfo.getMediaPic()));
        FeedMultiPart build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        updateMultiPart$presentation_coolapkAppRelease(build);
        FeedUIConfig.Builder builder2 = FeedUIConfig.builder(getUiConfig());
        FeedUIConfig.Builder extraViewTitle = builder2.isExtraViewVisible(true).extraViewLogoUrl(shareFeedInfo.getLogo()).extraViewTitle(shareFeedInfo.getTitle());
        String url = shareFeedInfo.getUrl();
        if (url == null) {
            url = "";
        }
        extraViewTitle.extraViewContent(KotlinExtendKt.getSimpleHost(KotlinExtendKt.asUri(url))).isRemoveExtraViewVisible(true);
        FeedUIConfig build2 = builder2.build();
        Intrinsics.checkNotNullExpressionValue(build2, "uiConfigBuilder.build()");
        updateUiConfig$presentation_coolapkAppRelease(build2);
        notifyUIChange$presentation_coolapkAppRelease();
    }

    public final void onShareInfoRemove$presentation_coolapkAppRelease() {
        FeedMultiPart.Builder builder = FeedMultiPart.builder(getMultiPart());
        builder.extraTitle("").extraPic("").extraUrl("").extraInfo("").mediaType(0).mediaUrl("").mediaPic("");
        FeedMultiPart build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        updateMultiPart$presentation_coolapkAppRelease(build);
        FeedUIConfig.Builder builder2 = FeedUIConfig.builder(getUiConfig());
        builder2.isExtraViewVisible(false).extraViewContent("").extraViewLogoUrl("").extraViewTitle("").isRemoveExtraViewVisible(false);
        FeedUIConfig build2 = builder2.build();
        Intrinsics.checkNotNullExpressionValue(build2, "uiConfigBuilder.build()");
        updateUiConfig$presentation_coolapkAppRelease(build2);
        notifyUIChange$presentation_coolapkAppRelease();
    }

    public void onVideoDataLoaded(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "info");
        Intrinsics.checkNotNullParameter(str2, "sourceUrl");
        onShareInfoRemove$presentation_coolapkAppRelease();
        onRemoveExtraEntity();
    }

    public final void onRequestWebViewUrl$presentation_coolapkAppRelease(String str, ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(arrayList, "strings");
        this.submitActivity.onRequestWebViewUrl(str, arrayList);
    }

    public final void requestCheckSubmittable$presentation_coolapkAppRelease() {
        this.submitActivity.onRequestCheckSubmittable();
    }

    public final void updateMultiPart$presentation_coolapkAppRelease(FeedMultiPart feedMultiPart) {
        Intrinsics.checkNotNullParameter(feedMultiPart, "part");
        this.submitActivity.updateMultiPart(feedMultiPart);
    }

    public final void updateUiConfig$presentation_coolapkAppRelease(FeedUIConfig feedUIConfig) {
        Intrinsics.checkNotNullParameter(feedUIConfig, "config");
        this.submitActivity.updateUIConfig(feedUIConfig);
    }

    public final void requestPickPhotos$presentation_coolapkAppRelease(int i, List<String> list) {
        Intrinsics.checkNotNullParameter(list, "currentList");
        this.submitActivity.onRequestPickPhoto(i, list);
    }

    public final void requestPickContacts$presentation_coolapkAppRelease() {
        this.submitActivity.onRequestPickContacts();
    }

    public final void requestConvertToArticleMode$presentation_coolapkAppRelease() {
        this.submitActivity.onRequestConvertToArticleMode();
    }

    public boolean checkSubmittable$presentation_coolapkAppRelease() {
        return !this.isPosting;
    }

    public final void startSubmitFeed$presentation_coolapkAppRelease() {
        if (checkSubmittable$presentation_coolapkAppRelease() && !this.isPosting) {
            this.isPosting = true;
            prepareMultiFeed$presentation_coolapkAppRelease().observeOn(Schedulers.io()).flatMap(BaseFeedContentHolder$startSubmitFeed$1.INSTANCE).observeOn(AndroidSchedulers.mainThread()).map(RxUtils.checkResult()).subscribe((Subscriber<? super R>) new BaseFeedContentHolder$startSubmitFeed$2(this));
        }
    }

    public FeedMultiPart generateDraftCopy$presentation_coolapkAppRelease() {
        return getMultiPart();
    }

    public Observable<FeedMultiPart> prepareMultiFeed$presentation_coolapkAppRelease() {
        String str;
        ProgressDialog progressDialog = new ProgressDialog(this.activity);
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(0);
        progressDialog.setCanceledOnTouchOutside(false);
        if (!getMultiPart().imageUriList().isEmpty()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            str = String.format(Locale.getDefault(), "上传图片(%d/%d)", Arrays.copyOf(new Object[]{1, Integer.valueOf(getMultiPart().imageUriList().size())}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(locale, format, *args)");
        } else {
            str = "准备提交...";
        }
        try {
            progressDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        progressDialog.setMessage(str);
        PostListener postListener = this.listener;
        if (postListener != null) {
            postListener.onPostStart();
            postListener.onNewMessage(str);
        }
        Observable<FeedMultiPart> doOnUnsubscribe = Observable.just(true).flatMap(new BaseFeedContentHolder$prepareMultiFeed$2(this)).flatMap(new BaseFeedContentHolder$prepareMultiFeed$3(this)).flatMap(new BaseFeedContentHolder$prepareMultiFeed$4(this)).flatMap(new BaseFeedContentHolder$prepareMultiFeed$5(this, progressDialog)).observeOn(AndroidSchedulers.mainThread()).doOnNext(new BaseFeedContentHolder$prepareMultiFeed$6(this, progressDialog)).doOnUnsubscribe(new BaseFeedContentHolder$prepareMultiFeed$7(progressDialog));
        Intrinsics.checkNotNullExpressionValue(doOnUnsubscribe, "Observable.just(true)\n  …      }\n                }");
        return doOnUnsubscribe;
    }

    /* access modifiers changed from: private */
    public final String buildImageString(List<? extends ImageUrl> list) {
        if (!(!list.isEmpty())) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size() - 1;
        for (int i = 0; i < size; i++) {
            String compressedUrl = ((ImageUrl) list.get(i)).getCompressedUrl();
            if (compressedUrl == null || StringsKt.startsWith$default(compressedUrl, "file", false, 2, (Object) null)) {
                LogUtils.e("Something wrong %s", ((ImageUrl) list.get(i)).toString());
            } else if (!TextUtils.isEmpty(compressedUrl)) {
                sb.append(compressedUrl);
                sb.append(",");
            }
        }
        String compressedUrl2 = ((ImageUrl) list.get(CollectionsKt.getLastIndex(list))).getCompressedUrl();
        if (!TextUtils.isEmpty(compressedUrl2)) {
            sb.append(compressedUrl2);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        return sb2;
    }
}
