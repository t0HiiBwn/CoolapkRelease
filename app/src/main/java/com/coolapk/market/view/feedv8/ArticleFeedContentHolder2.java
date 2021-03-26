package com.coolapk.market.view.feedv8;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.databinding.SubmitFeedArticleBottomBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.model.ShareFeedInfo;
import com.coolapk.market.view.feedv8.ArticleModel;
import com.coolapk.market.view.feedv8.article.ArticleViewModel;
import com.coolapk.market.view.feedv8.util.HandleFocusRecyclerView;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.emotion.EmotionUtils;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 !2\u00020\u0001:\u0002 !B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0006H\u0010¢\u0006\u0002\b\u0007J\b\u0010\b\u001a\u00020\u0006H\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0014J\r\u0010\f\u001a\u00020\rH\u0010¢\u0006\u0002\b\u000eJ\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0010¢\u0006\u0002\b\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0002J\u0013\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001eH\u0010¢\u0006\u0002\b\u001f¨\u0006\""}, d2 = {"Lcom/coolapk/market/view/feedv8/ArticleFeedContentHolder2;", "Lcom/coolapk/market/view/feedv8/ArticleFeedBaseContentHolder;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "checkSubmittable", "", "checkSubmittable$presentation_coolapkAppRelease", "checkTextCountLength", "createArticleModelListWhenParseFailed", "", "Lcom/coolapk/market/view/feedv8/ArticleModel;", "generateDraftCopy", "Lcom/coolapk/market/model/FeedMultiPart;", "generateDraftCopy$presentation_coolapkAppRelease", "onCreateContentView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "onCreateContentView$presentation_coolapkAppRelease", "onExtraEntityLoaded", "", "entity", "Lcom/coolapk/market/model/Entity;", "onShareInfoLoaded", "info", "Lcom/coolapk/market/model/ShareFeedInfo;", "onSubmitButtonClick", "onTextContentChanged", "prepareMultiFeed", "Lrx/Observable;", "prepareMultiFeed$presentation_coolapkAppRelease", "ArticleBottomHolder", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ArticleFeedContentHolder2.kt */
public class ArticleFeedContentHolder2 extends ArticleFeedBaseContentHolder {
    public static final Companion Companion = new Companion(null);
    public static final int MAX_INPUT_TEXT = 12000;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ArticleViewModel.ActionType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ArticleViewModel.ActionType.CheckSubmittable.ordinal()] = 1;
            iArr[ArticleViewModel.ActionType.CheckTextLength.ordinal()] = 2;
            iArr[ArticleViewModel.ActionType.PickContacts.ordinal()] = 3;
            iArr[ArticleViewModel.ActionType.UpdateFirstTextPart.ordinal()] = 4;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArticleFeedContentHolder2(Activity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feedv8/ArticleFeedContentHolder2$Companion;", "", "()V", "MAX_INPUT_TEXT", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ArticleFeedContentHolder2.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.feedv8.ArticleFeedBaseContentHolder, com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public View onCreateContentView$presentation_coolapkAppRelease(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View onCreateContentView$presentation_coolapkAppRelease = super.onCreateContentView$presentation_coolapkAppRelease(layoutInflater);
        ContextBindingComponent contextBindingComponent = new ContextBindingComponent(getActivity());
        BaseMultiTypeAdapter.register$default(getAdapter(), SimpleViewHolderFactor.Companion.withLayoutId(2131559151).constructor(new ArticleFeedContentHolder2$onCreateContentView$1(this)).suitedMethod(ArticleFeedContentHolder2$onCreateContentView$2.INSTANCE).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter(), SimpleViewHolderFactor.Companion.withLayoutId(2131559152).constructor(new ArticleFeedContentHolder2$onCreateContentView$3(this)).suitedMethod(ArticleFeedContentHolder2$onCreateContentView$4.INSTANCE).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter(), SimpleViewHolderFactor.Companion.withLayoutId(2131558941).constructor(new ArticleFeedContentHolder2$onCreateContentView$5(this)).suitedMethod(new ArticleFeedContentHolder2$onCreateContentView$6(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter(), SimpleViewHolderFactor.Companion.withLayoutId(2131559149).constructor(new ArticleFeedContentHolder2$onCreateContentView$7(this)).suitedMethod(ArticleFeedContentHolder2$onCreateContentView$8.INSTANCE).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter(), SimpleViewHolderFactor.Companion.withLayoutId(2131558613).constructor(new ArticleFeedContentHolder2$onCreateContentView$9(this, contextBindingComponent)).suitedMethod(ArticleFeedContentHolder2$onCreateContentView$10.INSTANCE).build(), 0, 2, null);
        getAdapter().setMatchAllFactor(SimpleViewHolderFactor.Companion.withLayoutId(2131558929).constructor(new ArticleFeedContentHolder2$onCreateContentView$11(contextBindingComponent)).suitedMethod(ArticleFeedContentHolder2$onCreateContentView$12.INSTANCE).build());
        if (Intrinsics.areEqual(getMultiPart().type(), "answer")) {
            BaseMultiTypeAdapter.register$default(getAdapter(), SimpleViewHolderFactor.Companion.withLayoutId(2131559153).constructor(new ArticleFeedContentHolder2$onCreateContentView$13(this)).suitedMethod(ArticleFeedContentHolder2$onCreateContentView$14.INSTANCE).build(), 0, 2, null);
        } else {
            BaseMultiTypeAdapter.register$default(getAdapter(), SimpleViewHolderFactor.Companion.withLayoutId(2131559154).constructor(new ArticleFeedContentHolder2$onCreateContentView$15(this)).suitedMethod(ArticleFeedContentHolder2$onCreateContentView$16.INSTANCE).build(), 0, 2, null);
        }
        getArticleViewModel().getActions().observe(getLifecycleOwner(), new ArticleFeedContentHolder2$onCreateContentView$17(this));
        List<Entity> extraEntities = getUiConfig().extraEntities();
        Intrinsics.checkNotNullExpressionValue(extraEntities, "uiConfig.extraEntities()");
        for (T t : extraEntities) {
            ArticleViewModel articleViewModel = getArticleViewModel();
            Intrinsics.checkNotNullExpressionValue(t, "it");
            articleViewModel.insertExtraEntity(t, false);
        }
        ArrayList arrayList = new ArrayList();
        ArticleModel.Type type = ArticleModel.Type.Top;
        String messageCover = getMultiPart().messageCover();
        Intrinsics.checkNotNullExpressionValue(messageCover, "multiPart.messageCover()");
        String messageTitle = getMultiPart().messageTitle();
        Intrinsics.checkNotNullExpressionValue(messageTitle, "multiPart.messageTitle()");
        arrayList.add(new ArticleNative(type, messageCover, messageTitle));
        ArticleModel.Companion companion = ArticleModel.Companion;
        String message = getMultiPart().message();
        Intrinsics.checkNotNullExpressionValue(message, "multiPart.message()");
        List<ArticleModel> fromJson = companion.fromJson(message);
        if (fromJson.isEmpty()) {
            arrayList.addAll(createArticleModelListWhenParseFailed());
        } else {
            arrayList.addAll(fromJson);
        }
        arrayList.add(new ArticleNative(ArticleModel.Type.Bottom, "", ""));
        ArticleViewModel.updateDataList$default(getArticleViewModel(), false, false, new ArticleFeedContentHolder2$onCreateContentView$19(arrayList), 3, null);
        HandleFocusRecyclerView recyclerView$presentation_coolapkAppRelease = getRecyclerView$presentation_coolapkAppRelease();
        recyclerView$presentation_coolapkAppRelease.setPadding(recyclerView$presentation_coolapkAppRelease.getPaddingLeft(), recyclerView$presentation_coolapkAppRelease.getPaddingTop(), recyclerView$presentation_coolapkAppRelease.getPaddingRight(), ConvertUtils.dp2px(120.0f));
        return onCreateContentView$presentation_coolapkAppRelease;
    }

    protected List<ArticleModel> createArticleModelListWhenParseFailed() {
        ArrayList arrayList = new ArrayList();
        String message = getMultiPart().message();
        Intrinsics.checkNotNullExpressionValue(message, "multiPart.message()");
        arrayList.add(new ArticleText(message));
        List<ImageUrl> imageUriList = getMultiPart().imageUriList();
        Intrinsics.checkNotNullExpressionValue(imageUriList, "multiPart.imageUriList()");
        List<ImageUrl> list = CollectionsKt.toList(imageUriList);
        getMultiPart().imageUriList().clear();
        for (ImageUrl imageUrl : list) {
            Intrinsics.checkNotNullExpressionValue(imageUrl, "it");
            String sourceUrl = imageUrl.getSourceUrl();
            Intrinsics.checkNotNullExpressionValue(sourceUrl, "it.sourceUrl");
            arrayList.add(new ArticleImage(sourceUrl, ""));
            arrayList.add(new ArticleText(""));
        }
        return arrayList;
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onExtraEntityLoaded(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        if (entity instanceof FeedGoods) {
            ArticleViewModel.insertExtraEntity$default(getArticleViewModel(), entity, false, 2, null);
            getUiConfig().extraEntities().add(entity);
        }
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onShareInfoLoaded(ShareFeedInfo shareFeedInfo) {
        Intrinsics.checkNotNullParameter(shareFeedInfo, "info");
        getArticleViewModel().insertShareUrl(shareFeedInfo);
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public boolean checkSubmittable$presentation_coolapkAppRelease() {
        List<ArticleModel> value = getArticleViewModel().getDataList().getValue();
        Intrinsics.checkNotNull(value);
        Intrinsics.checkNotNullExpressionValue(value, "articleViewModel.dataList.value!!");
        List<ArticleModel> list = value;
        if (((ArticleText) SequencesKt.firstOrNull(SequencesKt.filter(SequencesKt.filterIsInstance(CollectionsKt.asSequence(list), ArticleText.class), ArticleFeedContentHolder2$checkSubmittable$1.INSTANCE))) == null) {
            return false;
        }
        ArrayList<ArticleText> arrayList = new ArrayList();
        for (T t : list) {
            if (t instanceof ArticleText) {
                arrayList.add(t);
            }
        }
        int i = 0;
        for (ArticleText articleText : arrayList) {
            i += articleText.getText().length();
        }
        if (i > 12000) {
            return false;
        }
        ArrayList<ArticleText> arrayList2 = new ArrayList();
        for (T t2 : list) {
            if (t2 instanceof ArticleText) {
                arrayList2.add(t2);
            }
        }
        int i2 = 0;
        for (ArticleText articleText2 : arrayList2) {
            i2 += EmotionUtils.getEmotionCount(articleText2.getText());
        }
        if (i2 > 100) {
            return false;
        }
        return super.checkSubmittable$presentation_coolapkAppRelease();
    }

    /* access modifiers changed from: private */
    public final void onTextContentChanged() {
        List<ArticleModel> value = getArticleViewModel().getDataList().getValue();
        Intrinsics.checkNotNull(value);
        Intrinsics.checkNotNullExpressionValue(value, "articleViewModel.dataList.value!!");
        ArrayList<ArticleText> arrayList = new ArrayList();
        for (T t : value) {
            if (t instanceof ArticleText) {
                arrayList.add(t);
            }
        }
        int i = 0;
        for (ArticleText articleText : arrayList) {
            i += EmotionUtils.getEmotionCount(articleText.getText());
        }
        if (!ArticleContentHelper.INSTANCE.checkEmotionCount(getActivity(), i)) {
            checkTextCountLength();
        }
    }

    private final boolean checkTextCountLength() {
        String str;
        List<ArticleModel> value = getArticleViewModel().getDataList().getValue();
        Intrinsics.checkNotNull(value);
        Intrinsics.checkNotNullExpressionValue(value, "articleViewModel.dataList.value!!");
        ArrayList<ArticleText> arrayList = new ArrayList();
        for (T t : value) {
            if (t instanceof ArticleText) {
                arrayList.add(t);
            }
        }
        int i = 0;
        for (ArticleText articleText : arrayList) {
            i += articleText.getText().length();
        }
        if (i > 12000) {
            str = "已超过字数上限" + (i - 12000) + (char) 23383;
        } else if (i == 12000) {
            str = "已达到图文字数上限";
        } else if (i == 11000) {
            str = "还可以输入" + (12000 - i) + (char) 23383;
        } else if (i == 11900) {
            str = "还可以输入" + (12000 - i) + (char) 23383;
        } else if (i >= 11980) {
            str = "还可以输入" + (12000 - i) + (char) 23383;
        } else {
            str = "";
        }
        String str2 = str;
        if (str2.length() > 0) {
            Toast.show$default(getActivity(), str, 0, false, 12, null);
        }
        if (str2.length() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onSubmitButtonClick() {
        super.onSubmitButtonClick();
        startSubmitFeed$presentation_coolapkAppRelease();
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public FeedMultiPart generateDraftCopy$presentation_coolapkAppRelease() {
        T t;
        List<ArticleModel> value = getArticleViewModel().getDataList().getValue();
        Intrinsics.checkNotNull(value);
        Intrinsics.checkNotNullExpressionValue(value, "articleViewModel.dataList.value!!");
        List<ArticleModel> list = value;
        if (list.isEmpty()) {
            return getMultiPart();
        }
        String str = null;
        String json$default = ArticleModelKt.toJson$default(list, false, 1, null);
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t = null;
                break;
            }
            t = it2.next();
            if (t instanceof ArticleNative) {
                break;
            }
        }
        if (!(t instanceof ArticleNative)) {
            t = null;
        }
        T t2 = t;
        FeedMultiPart.Builder isHtmlArticle = FeedMultiPart.builder(super.generateDraftCopy$presentation_coolapkAppRelease()).isHtmlArticle(true);
        String str2 = "";
        if (Intrinsics.areEqual("[]", json$default)) {
            json$default = str2;
        }
        FeedMultiPart.Builder message = isHtmlArticle.message(json$default);
        String imageUrl = t2 != null ? t2.getImageUrl() : null;
        if (imageUrl == null) {
            imageUrl = str2;
        }
        FeedMultiPart.Builder messageCover = message.messageCover(imageUrl);
        if (t2 != null) {
            str = t2.getText();
        }
        if (str != null) {
            str2 = str;
        }
        FeedMultiPart build = messageCover.messageTitle(str2).build();
        Intrinsics.checkNotNullExpressionValue(build, "FeedMultiPart.builder(su…\n                .build()");
        return build;
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public Observable<FeedMultiPart> prepareMultiFeed$presentation_coolapkAppRelease() {
        List<ArticleModel> value = getArticleViewModel().getDataList().getValue();
        Intrinsics.checkNotNull(value);
        Intrinsics.checkNotNullExpressionValue(value, "articleViewModel.dataList.value!!");
        List<ArticleModel> list = value;
        FeedMultiPart build = FeedMultiPart.builder(getMultiPart()).isHtmlArticle(true).message(ArticleModelKt.toJson$default(list, false, 1, null)).build();
        Intrinsics.checkNotNullExpressionValue(build, "FeedMultiPart.builder(mu…\n                .build()");
        updateMultiPart$presentation_coolapkAppRelease(build);
        FeedMultiPart multiPart = getMultiPart();
        List list2 = SequencesKt.toList(SequencesKt.filterNotNull(SequencesKt.map(CollectionsKt.asSequence(list), ArticleFeedContentHolder2$prepareMultiFeed$imageList$1.INSTANCE)));
        List<ImageUrl> imageUriList = multiPart.imageUriList();
        Intrinsics.checkNotNullExpressionValue(imageUriList, "localPart.imageUriList()");
        ArrayList arrayList = new ArrayList();
        for (T t : imageUriList) {
            T t2 = t;
            Intrinsics.checkNotNullExpressionValue(t2, "it");
            if (!Intrinsics.areEqual(t2.getSourceUrl(), t2.getCompressedUrl())) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = arrayList;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (Object obj : arrayList2) {
            ImageUrl imageUrl = (ImageUrl) obj;
            Intrinsics.checkNotNullExpressionValue(imageUrl, "it");
            linkedHashMap.put(imageUrl.getSourceUrl(), obj);
        }
        List<ImageUrl> list3 = list2;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        for (ImageUrl imageUrl2 : list3) {
            if (linkedHashMap.containsKey(imageUrl2.getSourceUrl())) {
                imageUrl2 = (ImageUrl) linkedHashMap.get(imageUrl2.getSourceUrl());
            }
            arrayList3.add(imageUrl2);
        }
        multiPart.imageUriList().clear();
        multiPart.imageUriList().addAll(arrayList3);
        Observable<R> map = super.prepareMultiFeed$presentation_coolapkAppRelease().map(new ArticleFeedContentHolder2$prepareMultiFeed$1(this));
        Intrinsics.checkNotNullExpressionValue(map, "super.prepareMultiFeed()…ltiPart\n                }");
        return map;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/feedv8/ArticleFeedContentHolder2$ArticleBottomHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "content", "Lcom/coolapk/market/view/feedv8/ArticleFeedContentHolder2;", "(Landroid/view/View;Lcom/coolapk/market/view/feedv8/ArticleFeedContentHolder2;)V", "getContent", "()Lcom/coolapk/market/view/feedv8/ArticleFeedContentHolder2;", "bindTo", "", "data", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ArticleFeedContentHolder2.kt */
    private static final class ArticleBottomHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131559149;
        private final ArticleFeedContentHolder2 content;

        public final ArticleFeedContentHolder2 getContent() {
            return this.content;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ArticleBottomHolder(View view, ArticleFeedContentHolder2 articleFeedContentHolder2) {
            super(view, null, null);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(articleFeedContentHolder2, "content");
            this.content = articleFeedContentHolder2;
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "data");
            SubmitFeedArticleBottomBinding submitFeedArticleBottomBinding = (SubmitFeedArticleBottomBinding) getBinding();
            View view = this.content.getExtraViewPart$presentation_coolapkAppRelease().getView();
            if (!Intrinsics.areEqual(view.getParent(), submitFeedArticleBottomBinding.itemView)) {
                ViewExtendsKt.detachFromParent(view);
                submitFeedArticleBottomBinding.itemView.addView(view);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feedv8/ArticleFeedContentHolder2$ArticleBottomHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: ArticleFeedContentHolder2.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }
}
