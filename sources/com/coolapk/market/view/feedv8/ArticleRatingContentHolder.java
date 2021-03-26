package com.coolapk.market.view.feedv8;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import com.coolapk.market.databinding.SubmitProductArticleBottomBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0006H\u0010¢\u0006\u0002\b\u0007J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0014J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0010¢\u0006\u0002\b\u000fJ\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0010¢\u0006\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/feedv8/ArticleRatingContentHolder;", "Lcom/coolapk/market/view/feedv8/ArticleFeedContentHolder2;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "checkSubmittable", "", "checkSubmittable$presentation_coolapkAppRelease", "createArticleModelListWhenParseFailed", "", "Lcom/coolapk/market/view/feedv8/ArticleModel;", "onCreateContentView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "onCreateContentView$presentation_coolapkAppRelease", "prepareMultiFeed", "Lrx/Observable;", "Lcom/coolapk/market/model/FeedMultiPart;", "prepareMultiFeed$presentation_coolapkAppRelease", "ProductArticleBottomHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ArticleRatingContentHolder.kt */
public final class ArticleRatingContentHolder extends ArticleFeedContentHolder2 {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArticleRatingContentHolder(Activity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // com.coolapk.market.view.feedv8.ArticleFeedContentHolder2, com.coolapk.market.view.feedv8.ArticleFeedBaseContentHolder, com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public View onCreateContentView$presentation_coolapkAppRelease(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View onCreateContentView$presentation_coolapkAppRelease = super.onCreateContentView$presentation_coolapkAppRelease(layoutInflater);
        getAdapter().register(SimpleViewHolderFactor.Companion.withLayoutId(2131559165).constructor(new ArticleRatingContentHolder$onCreateContentView$1(this)).suitedMethod(ArticleRatingContentHolder$onCreateContentView$2.INSTANCE).build(), 0);
        getAdapter().register(SimpleViewHolderFactor.Companion.withLayoutId(2131559164).constructor(new ArticleRatingContentHolder$onCreateContentView$3(this)).suitedMethod(ArticleRatingContentHolder$onCreateContentView$4.INSTANCE).build(), 0);
        return onCreateContentView$presentation_coolapkAppRelease;
    }

    @Override // com.coolapk.market.view.feedv8.ArticleFeedContentHolder2
    protected List<ArticleModel> createArticleModelListWhenParseFailed() {
        ArrayList arrayList = new ArrayList();
        FeedMultiPart multiPart = getMultiPart();
        ArticleRatingContentHolder$createArticleModelListWhenParseFailed$handleText$1 articleRatingContentHolder$createArticleModelListWhenParseFailed$handleText$1 = new ArticleRatingContentHolder$createArticleModelListWhenParseFailed$handleText$1(arrayList);
        ArticleRatingContentHolder$createArticleModelListWhenParseFailed$handleImage$1 articleRatingContentHolder$createArticleModelListWhenParseFailed$handleImage$1 = new ArticleRatingContentHolder$createArticleModelListWhenParseFailed$handleImage$1(arrayList);
        String commentGood = multiPart.commentGood();
        Intrinsics.checkNotNullExpressionValue(commentGood, "multiPart.commentGood()");
        articleRatingContentHolder$createArticleModelListWhenParseFailed$handleText$1.invoke((ArticleRatingContentHolder$createArticleModelListWhenParseFailed$handleText$1) commentGood);
        String commentGoodPic = multiPart.commentGoodPic();
        Intrinsics.checkNotNullExpressionValue(commentGoodPic, "multiPart.commentGoodPic()");
        articleRatingContentHolder$createArticleModelListWhenParseFailed$handleImage$1.invoke((ArticleRatingContentHolder$createArticleModelListWhenParseFailed$handleImage$1) commentGoodPic);
        String commentBad = multiPart.commentBad();
        Intrinsics.checkNotNullExpressionValue(commentBad, "multiPart.commentBad()");
        articleRatingContentHolder$createArticleModelListWhenParseFailed$handleText$1.invoke((ArticleRatingContentHolder$createArticleModelListWhenParseFailed$handleText$1) commentBad);
        String commentBadPic = multiPart.commentBadPic();
        Intrinsics.checkNotNullExpressionValue(commentBadPic, "multiPart.commentBadPic()");
        articleRatingContentHolder$createArticleModelListWhenParseFailed$handleImage$1.invoke((ArticleRatingContentHolder$createArticleModelListWhenParseFailed$handleImage$1) commentBadPic);
        String commentGeneral = multiPart.commentGeneral();
        Intrinsics.checkNotNullExpressionValue(commentGeneral, "multiPart.commentGeneral()");
        articleRatingContentHolder$createArticleModelListWhenParseFailed$handleText$1.invoke((ArticleRatingContentHolder$createArticleModelListWhenParseFailed$handleText$1) commentGeneral);
        String commentGeneralPic = multiPart.commentGeneralPic();
        Intrinsics.checkNotNullExpressionValue(commentGeneralPic, "multiPart.commentGeneralPic()");
        articleRatingContentHolder$createArticleModelListWhenParseFailed$handleImage$1.invoke((ArticleRatingContentHolder$createArticleModelListWhenParseFailed$handleImage$1) commentGeneralPic);
        return arrayList;
    }

    @Override // com.coolapk.market.view.feedv8.ArticleFeedContentHolder2, com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public boolean checkSubmittable$presentation_coolapkAppRelease() {
        if (getMultiPart().ratingScore1() <= 0) {
            return false;
        }
        return super.checkSubmittable$presentation_coolapkAppRelease();
    }

    @Override // com.coolapk.market.view.feedv8.ArticleFeedContentHolder2, com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public Observable<FeedMultiPart> prepareMultiFeed$presentation_coolapkAppRelease() {
        FeedMultiPart build = getMultiPart().newBuilder().commentGood("").commentGoodPic("").commentBad("").commentBadPic("").commentGeneral("").commentGeneralPic("").build();
        Intrinsics.checkNotNullExpressionValue(build, "multiPart.newBuilder()\n …\n                .build()");
        updateMultiPart$presentation_coolapkAppRelease(build);
        return super.prepareMultiFeed$presentation_coolapkAppRelease();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/feedv8/ArticleRatingContentHolder$ProductArticleBottomHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "content", "Lcom/coolapk/market/view/feedv8/ArticleFeedContentHolder2;", "(Landroid/view/View;Lcom/coolapk/market/view/feedv8/ArticleFeedContentHolder2;)V", "getContent", "()Lcom/coolapk/market/view/feedv8/ArticleFeedContentHolder2;", "bindTo", "", "data", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ArticleRatingContentHolder.kt */
    private static final class ProductArticleBottomHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131559164;
        private final ArticleFeedContentHolder2 content;

        public final ArticleFeedContentHolder2 getContent() {
            return this.content;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ProductArticleBottomHolder(View view, ArticleFeedContentHolder2 articleFeedContentHolder2) {
            super(view, null, null);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(articleFeedContentHolder2, "content");
            this.content = articleFeedContentHolder2;
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "data");
            SubmitProductArticleBottomBinding submitProductArticleBottomBinding = (SubmitProductArticleBottomBinding) getBinding();
            View view = this.content.getExtraViewPart$presentation_coolapkAppRelease().getView();
            if (!Intrinsics.areEqual(view.getParent(), submitProductArticleBottomBinding.itemView)) {
                ViewExtendsKt.detachFromParent(view);
                submitProductArticleBottomBinding.itemView.addView(view);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feedv8/ArticleRatingContentHolder$ProductArticleBottomHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: ArticleRatingContentHolder.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }
}
