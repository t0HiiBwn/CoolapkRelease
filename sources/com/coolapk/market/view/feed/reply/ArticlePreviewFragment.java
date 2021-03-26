package com.coolapk.market.view.feed.reply;

import android.app.Application;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ConvertUtils;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.ImageLoaderOptions;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemArticleAnswerPreviewTopBinding;
import com.coolapk.market.databinding.ItemArticleFeedPreviewTopBinding;
import com.coolapk.market.databinding.ItemArticleViewImageBinding;
import com.coolapk.market.databinding.ItemArticleViewTextBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideRequests;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.AppPictureSizeManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.UtilExtendsKt;
import com.coolapk.market.view.base.AlphableToolbar;
import com.coolapk.market.view.base.refresh.LocalMultiTypeFragment;
import com.coolapk.market.view.feed.CommentHelper;
import com.coolapk.market.view.feedv8.ArticleCard;
import com.coolapk.market.view.feedv8.ArticleImage;
import com.coolapk.market.view.feedv8.ArticleModel;
import com.coolapk.market.view.feedv8.ArticleNative;
import com.coolapk.market.view.feedv8.ArticleShareUrl;
import com.coolapk.market.view.feedv8.ArticleText;
import com.coolapk.market.view.feedv8.BaseFeedContentHolder;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.FastReturnView;
import com.coolapk.market.widget.RecyclerScrollHeaderListener;
import com.coolapk.market.widget.decoration.ItemDecorations;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import com.coolapk.market.widget.view.ScalingImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\u0014\u0015\u0016\u0017\u0018B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0002R!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/coolapk/market/view/feed/reply/ArticlePreviewFragment;", "Lcom/coolapk/market/view/base/refresh/LocalMultiTypeFragment;", "", "()V", "articleModelList", "", "Lcom/coolapk/market/view/feedv8/ArticleModel;", "getArticleModelList", "()Ljava/util/List;", "articleModelList$delegate", "Lkotlin/Lazy;", "contentHolder", "Lcom/coolapk/market/view/feedv8/BaseFeedContentHolder;", "initData", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setupUI", "ArticlePreviewAnswerTopViewHolder", "ArticlePreviewImageViewHolder", "ArticlePreviewTextViewHolder", "ArticlePreviewTopViewHolder", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ArticlePreviewFragment.kt */
public final class ArticlePreviewFragment extends LocalMultiTypeFragment<Object> {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_ARTICLE_JSON = "ARTICLE_JSON";
    public static final String EXTRA_HANDLER = "BaseFeedContentHolder";
    private final Lazy articleModelList$delegate = LazyKt.lazy(new ArticlePreviewFragment$articleModelList$2(this));
    private BaseFeedContentHolder contentHolder;

    /* access modifiers changed from: private */
    public final List<ArticleModel> getArticleModelList() {
        return (List) this.articleModelList$delegate.getValue();
    }

    @JvmStatic
    public static final ArticlePreviewFragment newInstance(String str) {
        return Companion.newInstance(str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/feed/reply/ArticlePreviewFragment$Companion;", "", "()V", "EXTRA_ARTICLE_JSON", "", "EXTRA_HANDLER", "newInstance", "Lcom/coolapk/market/view/feed/reply/ArticlePreviewFragment;", "json", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ArticlePreviewFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ArticlePreviewFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "json");
            ArticlePreviewFragment articlePreviewFragment = new ArticlePreviewFragment();
            Bundle bundle = new Bundle();
            bundle.putString("ARTICLE_JSON", str);
            Unit unit = Unit.INSTANCE;
            articlePreviewFragment.setArguments(bundle);
            return articlePreviewFragment;
        }
    }

    @Override // com.coolapk.market.view.base.refresh.LocalMultiTypeFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        List<Entity> list;
        String str;
        FeedUIConfig uiConfig;
        FeedMultiPart multiPart;
        super.onActivityCreated(bundle);
        this.contentHolder = (BaseFeedContentHolder) AppHolder.getWeakValue("BaseFeedContentHolder");
        FragmentBindingComponent fragmentBindingComponent = new FragmentBindingComponent(this);
        BaseFeedContentHolder baseFeedContentHolder = this.contentHolder;
        AlphableToolbar alphableToolbar = null;
        if (Intrinsics.areEqual((baseFeedContentHolder == null || (multiPart = baseFeedContentHolder.getMultiPart()) == null) ? null : multiPart.type(), "answer")) {
            BaseMultiTypeAdapter.register$default(getAdapter(), SimpleViewHolderFactor.Companion.withLayoutId(2131558612).suitedMethod(ArticlePreviewFragment$onActivityCreated$1.INSTANCE).constructor(new ArticlePreviewFragment$onActivityCreated$2(fragmentBindingComponent)).build(), 0, 2, null);
        } else {
            BaseMultiTypeAdapter.register$default(getAdapter(), SimpleViewHolderFactor.Companion.withLayoutId(2131558618).suitedMethod(ArticlePreviewFragment$onActivityCreated$3.INSTANCE).constructor(new ArticlePreviewFragment$onActivityCreated$4(fragmentBindingComponent)).build(), 0, 2, null);
        }
        BaseFeedContentHolder baseFeedContentHolder2 = this.contentHolder;
        if (baseFeedContentHolder2 == null || (uiConfig = baseFeedContentHolder2.getUiConfig()) == null || (list = uiConfig.extraEntities()) == null) {
            list = CollectionsKt.emptyList();
        }
        List<Entity> list2 = list;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
        Iterator<T> it2 = list2.iterator();
        while (true) {
            str = "";
            if (!it2.hasNext()) {
                break;
            }
            T next = it2.next();
            T t = next;
            Intrinsics.checkNotNullExpressionValue(t, "it");
            String url = t.getUrl();
            if (url != null) {
                str = url;
            }
            linkedHashMap.put(str, next);
        }
        ArticlePreviewFragment$onActivityCreated$articlePresenter$1 articlePreviewFragment$onActivityCreated$articlePresenter$1 = new ArticlePreviewFragment$onActivityCreated$articlePresenter$1(this, linkedHashMap);
        getAdapter().setMatchAllFactor(SimpleViewHolderFactor.Companion.withLayoutId(2131558936).constructor(new ArticlePreviewFragment$onActivityCreated$5(fragmentBindingComponent)).suitedMethod(ArticlePreviewFragment$onActivityCreated$6.INSTANCE).build());
        BaseMultiTypeAdapter.register$default(getAdapter(), SimpleViewHolderFactor.Companion.withLayoutId(2131558621).suitedMethod(ArticlePreviewFragment$onActivityCreated$7.INSTANCE).constructor(new ArticlePreviewFragment$onActivityCreated$8(fragmentBindingComponent)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter(), SimpleViewHolderFactor.Companion.withLayoutId(2131558620).suitedMethod(ArticlePreviewFragment$onActivityCreated$9.INSTANCE).constructor(new ArticlePreviewFragment$onActivityCreated$10(fragmentBindingComponent)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter(), SimpleViewHolderFactor.Companion.withLayoutId(2131558613).constructor(new ArticlePreviewFragment$onActivityCreated$11(fragmentBindingComponent, articlePreviewFragment$onActivityCreated$articlePresenter$1)).suitedMethod(ArticlePreviewFragment$onActivityCreated$12.INSTANCE).resetItemViewType(2131562038).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter(), SimpleViewHolderFactor.Companion.withLayoutId(2131558613).suitedMethod(new ArticlePreviewFragment$onActivityCreated$13(articlePreviewFragment$onActivityCreated$articlePresenter$1)).constructor(new ArticlePreviewFragment$onActivityCreated$14(fragmentBindingComponent, articlePreviewFragment$onActivityCreated$articlePresenter$1)).build(), 0, 2, null);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setClipToPadding(false);
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        recyclerView2.setClipChildren(false);
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558612, 2131231062).type(2131558618, 2131231062).create());
        initData();
        FragmentActivity activity = getActivity();
        if (activity instanceof AlphableToolbar) {
            alphableToolbar = activity;
        }
        AlphableToolbar alphableToolbar2 = alphableToolbar;
        if (alphableToolbar2 != null) {
            alphableToolbar2.setToolbarTitle(str);
        }
        setupUI();
    }

    @Override // com.coolapk.market.app.InitBehavior
    public void initData() {
        HolderItem holderItem;
        List dataList = getDataList();
        List<ArticleModel> articleModelList = getArticleModelList();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(articleModelList, 10));
        int i = 0;
        for (T t : articleModelList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            if (t2 instanceof ArticleShareUrl) {
                holderItem = HolderItem.newBuilder().entityType(t2.getType().getLongName()).intValue(Integer.valueOf(i)).build();
            } else {
                if (t2 instanceof ArticleCard) {
                    t2 = (T) HolderItem.newBuilder().entityType(t2.getType().getLongName()).url(t2.getUrlKey()).intValue(Integer.valueOf(i)).build();
                }
                holderItem = t2;
            }
            arrayList.add(holderItem);
            i = i2;
        }
        dataList.addAll(arrayList);
        FastReturnView fastReturnView = (FastReturnView) UiUtils.findFirstChildViewByType(UiUtils.getContentView(getActivity()), FastReturnView.class);
        if (fastReturnView != null) {
            ViewExtendsKt.detachFromParent(fastReturnView);
        }
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.contentHolder = null;
    }

    private final void setupUI() {
        boolean z;
        T t;
        boolean z2;
        Iterator<T> it2 = getArticleModelList().iterator();
        while (true) {
            z = false;
            if (!it2.hasNext()) {
                t = null;
                break;
            }
            t = it2.next();
            if (t.getType() == ArticleModel.Type.Top) {
                z2 = true;
                continue;
            } else {
                z2 = false;
                continue;
            }
            if (z2) {
                break;
            }
        }
        if (!(t instanceof ArticleNative)) {
            t = null;
        }
        T t2 = t;
        if (t2 != null) {
            getRecyclerView().setPadding(0, 0, 0, ConvertUtils.dp2px(120.0f));
            FragmentActivity activity = getActivity();
            String imageUrl = t2.getImageUrl();
            if (imageUrl == null || imageUrl.length() == 0) {
                z = true;
            }
            if (z) {
                FragmentActivity fragmentActivity = activity;
                int actionBarSize = UiUtils.getActionBarSize(fragmentActivity) + UiUtils.getStatusBarHeight(fragmentActivity);
                RecyclerView recyclerView = getRecyclerView();
                recyclerView.setPadding(recyclerView.getPaddingLeft(), actionBarSize, recyclerView.getPaddingRight(), recyclerView.getPaddingBottom());
                if (activity instanceof AlphableToolbar) {
                    ((AlphableToolbar) activity).setToolbarAlpha(1.0f);
                    getRecyclerView().addOnScrollListener(new RecyclerScrollHeaderListener(actionBarSize + DisplayUtils.dp2px(fragmentActivity, 40.0f), new ArticlePreviewFragment$setupUI$2(activity, t2)));
                }
            } else if (activity instanceof AlphableToolbar) {
                FragmentActivity fragmentActivity2 = activity;
                float decorViewWidth = ((((float) DisplayUtils.getDecorViewWidth(fragmentActivity2)) * 0.45f) - ((float) UiUtils.getStatusBarHeight(fragmentActivity2))) - ((float) UiUtils.getActionBarSize(fragmentActivity2));
                ((AlphableToolbar) activity).setToolbarAlpha(0.0f);
                int i = (int) decorViewWidth;
                getRecyclerView().addOnScrollListener(new RecyclerScrollHeaderListener(i, new ArticlePreviewFragment$setupUI$3(activity)));
                getRecyclerView().addOnScrollListener(new RecyclerScrollHeaderListener(i + DisplayUtils.dp2px(fragmentActivity2, 40.0f), new ArticlePreviewFragment$setupUI$4(activity, t2)));
            }
            View view = getView();
            if (!(view instanceof FrameLayout)) {
                view = null;
            }
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout != null) {
                TextView textView = new TextView(activity);
                textView.setLayoutParams(new FrameLayout.LayoutParams(-1, ConvertUtils.dp2px(52.0f)));
                textView.setText(getString(2131886430));
                textView.setGravity(17);
                textView.setBackground(ShapeUtils.createSelectableItemBackgroundWith(textView.getContext(), new ColorDrawable(AppHolder.getAppTheme().getContentBackgroundColor())));
                textView.setTextColor(AppHolder.getAppTheme().getColorAccent());
                textView.setOnClickListener(new ArticlePreviewFragment$setupUI$$inlined$apply$lambda$1(this, activity));
                FrameLayout frameLayout2 = new FrameLayout(requireActivity());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 80;
                Unit unit = Unit.INSTANCE;
                frameLayout2.setLayoutParams(layoutParams);
                frameLayout2.addView(textView);
                FrameLayout frameLayout3 = frameLayout2;
                ViewExtendsKt.setTopElevation$default(frameLayout3, 0.0f, 1, null);
                frameLayout.addView(frameLayout3);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/feed/reply/ArticlePreviewFragment$ArticlePreviewTextViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "comp", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "bindTo", "", "data", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ArticlePreviewFragment.kt */
    public static final class ArticlePreviewTextViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558621;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ArticlePreviewTextViewHolder(View view, DataBindingComponent dataBindingComponent) {
            super(view, dataBindingComponent, null);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "comp");
            ItemArticleViewTextBinding itemArticleViewTextBinding = (ItemArticleViewTextBinding) getBinding();
            itemArticleViewTextBinding.etTitle.addTextChangedListener(new CommentHelper.EmotionTextModifier());
            TextView textView = itemArticleViewTextBinding.etTitle;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.etTitle");
            textView.setAutoLinkMask(15);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "data");
            ItemArticleViewTextBinding itemArticleViewTextBinding = (ItemArticleViewTextBinding) getBinding();
            TextView textView = itemArticleViewTextBinding.etTitle;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.etTitle");
            textView.setText(((ArticleText) obj).getText());
            TextView textView2 = itemArticleViewTextBinding.etTitle;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.etTitle");
            CharSequence text = textView2.getText();
            Intrinsics.checkNotNullExpressionValue(text, "binding.etTitle.text");
            LinkTextUtils.setRawWebUrlSpan(text, AppHolder.getAppTheme().getColorAccent());
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/reply/ArticlePreviewFragment$ArticlePreviewTextViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: ArticlePreviewFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/feed/reply/ArticlePreviewFragment$ArticlePreviewImageViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "comp", "Landroidx/databinding/DataBindingComponent;", "itemActionHandler", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "bindTo", "", "data", "", "setImageViewSize", "model", "Lcom/coolapk/market/view/feedv8/ArticleImage;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ArticlePreviewFragment.kt */
    public static final class ArticlePreviewImageViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558620;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ArticlePreviewImageViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "comp");
            ItemArticleViewImageBinding itemArticleViewImageBinding = (ItemArticleViewImageBinding) getBinding();
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{-1, 16777215});
            FrameLayout frameLayout = itemArticleViewImageBinding.longPicTextContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.longPicTextContainer");
            frameLayout.setBackground(gradientDrawable);
            ScalingImageView scalingImageView = itemArticleViewImageBinding.ivCover;
            Intrinsics.checkNotNullExpressionValue(scalingImageView, "binding.ivCover");
            scalingImageView.setScaleType(ImageView.ScaleType.FIT_START);
        }

        private final void setImageViewSize(ArticleImage articleImage) {
            int decorViewWidth = DisplayUtils.getDecorViewWidth(getContext()) - DisplayUtils.dp2px(getContext(), 32.0f);
            ItemArticleViewImageBinding itemArticleViewImageBinding = (ItemArticleViewImageBinding) getBinding();
            Uri parse = Uri.parse(StringUtils.notNull(articleImage.getImageUrl()));
            Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(StringUtils.notNull(model.imageUrl))");
            Uri safeFileUri = UtilExtendsKt.toSafeFileUri(parse);
            if (TextUtils.equals("file", safeFileUri.getScheme())) {
                Application application = AppHolder.getApplication();
                Intrinsics.checkNotNullExpressionValue(application, "AppHolder.getApplication()");
                Pair<Integer, Integer> bitmapSize = KotlinExtendKt.getBitmapSize(safeFileUri, application);
                float intValue = ((float) bitmapSize.component1().intValue()) / ((float) bitmapSize.component2().intValue());
                if (intValue < 0.45f) {
                    FrameLayout frameLayout = itemArticleViewImageBinding.longPicTextContainer;
                    Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.longPicTextContainer");
                    frameLayout.setVisibility(0);
                } else {
                    FrameLayout frameLayout2 = itemArticleViewImageBinding.longPicTextContainer;
                    Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.longPicTextContainer");
                    frameLayout2.setVisibility(8);
                }
                ScalingImageView scalingImageView = itemArticleViewImageBinding.ivCover;
                Intrinsics.checkNotNullExpressionValue(scalingImageView, "binding.ivCover");
                ViewGroup.LayoutParams layoutParams = scalingImageView.getLayoutParams();
                layoutParams.width = decorViewWidth;
                layoutParams.height = (int) ((((float) decorViewWidth) * 1.0f) / intValue);
                return;
            }
            FrameLayout frameLayout3 = itemArticleViewImageBinding.longPicTextContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.longPicTextContainer");
            frameLayout3.setVisibility(8);
            AppPictureSizeManager.PictureSize size = AppPictureSizeManager.getInstance().getSize(articleImage.getImageUrl());
            if (size != null) {
                ScalingImageView scalingImageView2 = itemArticleViewImageBinding.ivCover;
                Intrinsics.checkNotNullExpressionValue(scalingImageView2, "binding.ivCover");
                ViewGroup.LayoutParams layoutParams2 = scalingImageView2.getLayoutParams();
                layoutParams2.width = decorViewWidth;
                layoutParams2.height = (int) (((((float) decorViewWidth) * 1.0f) / ((float) size.getWidth())) * ((float) size.getHeight()));
                return;
            }
            ScalingImageView scalingImageView3 = itemArticleViewImageBinding.ivCover;
            Intrinsics.checkNotNullExpressionValue(scalingImageView3, "binding.ivCover");
            ViewGroup.LayoutParams layoutParams3 = scalingImageView3.getLayoutParams();
            layoutParams3.width = decorViewWidth;
            layoutParams3.height = decorViewWidth;
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/reply/ArticlePreviewFragment$ArticlePreviewImageViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: ArticlePreviewFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r1v8, types: [com.coolapk.market.imageloader.GlideRequest] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "data");
            DataBindingComponent component = getComponent();
            LifecycleOwner lifecycleOwner = null;
            if (!(component instanceof FragmentBindingComponent)) {
                component = null;
            }
            FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
            LifecycleOwner lifecycleOwner2 = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
            if (lifecycleOwner2 instanceof ArticlePreviewFragment) {
                lifecycleOwner = lifecycleOwner2;
            }
            ArticlePreviewFragment articlePreviewFragment = (ArticlePreviewFragment) lifecycleOwner;
            if (articlePreviewFragment != null) {
                ArticleImage articleImage = (ArticleImage) obj;
                ItemArticleViewImageBinding itemArticleViewImageBinding = (ItemArticleViewImageBinding) getBinding();
                TextView textView = itemArticleViewImageBinding.descriptionView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.descriptionView");
                textView.setText(articleImage.getText());
                TextView textView2 = itemArticleViewImageBinding.descriptionView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.descriptionView");
                textView2.setVisibility(TextUtils.isEmpty(articleImage.getText()) ? 8 : 0);
                setImageViewSize(articleImage);
                Uri parse = Uri.parse(StringUtils.notNull(articleImage.getImageUrl()));
                Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(StringUtils.notNull(model.imageUrl))");
                GlideApp.with(articlePreviewFragment.requireActivity()).load(UtilExtendsKt.toSafeFileUri(parse)).placeholder(2131231707).diskCacheStrategy(DiskCacheStrategy.NONE).into(itemArticleViewImageBinding.ivCover);
                TextView textView3 = itemArticleViewImageBinding.descriptionView;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.descriptionView");
                textView3.setText(articleImage.getText());
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u0019\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/feed/reply/ArticlePreviewFragment$ArticlePreviewTopViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "comp", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "binding", "Lcom/coolapk/market/databinding/ItemArticleFeedPreviewTopBinding;", "kotlin.jvm.PlatformType", "getBinding", "()Lcom/coolapk/market/databinding/ItemArticleFeedPreviewTopBinding;", "bindTo", "", "data", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ArticlePreviewFragment.kt */
    public static final class ArticlePreviewTopViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558618;
        private final ItemArticleFeedPreviewTopBinding binding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ArticlePreviewTopViewHolder(View view, DataBindingComponent dataBindingComponent) {
            super(view, dataBindingComponent, null);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "comp");
            ItemArticleFeedPreviewTopBinding itemArticleFeedPreviewTopBinding = (ItemArticleFeedPreviewTopBinding) getBinding();
            this.binding = itemArticleFeedPreviewTopBinding;
            Intrinsics.checkNotNullExpressionValue(itemArticleFeedPreviewTopBinding, "binding");
            itemArticleFeedPreviewTopBinding.setClick(this);
            Intrinsics.checkNotNullExpressionValue(itemArticleFeedPreviewTopBinding, "binding");
            itemArticleFeedPreviewTopBinding.setTransformer(new CircleTransform(false, 0, 3, null));
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/reply/ArticlePreviewFragment$ArticlePreviewTopViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: ArticlePreviewFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public final ItemArticleFeedPreviewTopBinding getBinding() {
            return this.binding;
        }

        /* JADX WARN: Type inference failed for: r0v16, types: [com.coolapk.market.imageloader.GlideRequest] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            ScalingImageView scalingImageView = this.binding.topImageView;
            Intrinsics.checkNotNullExpressionValue(scalingImageView, "binding.topImageView");
            ViewGroup.LayoutParams layoutParams = scalingImageView.getLayoutParams();
            layoutParams.width = DisplayUtils.getDecorViewWidth(getContext());
            layoutParams.height = (int) ((((float) layoutParams.width) / 20.0f) * ((float) 9));
            View view = this.binding.coverViewMask;
            Intrinsics.checkNotNullExpressionValue(view, "binding.coverViewMask");
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            ScalingImageView scalingImageView2 = this.binding.topImageView;
            Intrinsics.checkNotNullExpressionValue(scalingImageView2, "binding.topImageView");
            layoutParams2.height = scalingImageView2.getHeight();
            try {
                this.binding.executePendingBindings();
            } catch (Exception unused) {
            }
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.view.feedv8.ArticleNative");
            ArticleNative articleNative = (ArticleNative) obj;
            DataBindingComponent component = getComponent();
            if (!(component instanceof FragmentBindingComponent)) {
                component = null;
            }
            FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
            Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
            if (!(fragment instanceof ArticlePreviewFragment)) {
                fragment = null;
            }
            ArticlePreviewFragment articlePreviewFragment = (ArticlePreviewFragment) fragment;
            if (articlePreviewFragment != null) {
                TextView textView = this.binding.actionView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.actionView");
                textView.setVisibility(8);
                TextView textView2 = this.binding.titleView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
                textView2.setText(articleNative.getText());
                DataManager instance = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                LoginSession loginSession = instance.getLoginSession();
                ArticlePreviewFragment articlePreviewFragment2 = articlePreviewFragment;
                GlideRequests with = GlideApp.with(articlePreviewFragment2);
                Intrinsics.checkNotNullExpressionValue(loginSession, "session");
                with.load(loginSession.getUserAvatar()).transform(new CircleTransform(false, 0, 3, null)).into(this.binding.userAvatarView);
                TextView textView3 = this.binding.nameView;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.nameView");
                textView3.setText(loginSession.getUserName());
                TextView textView4 = this.binding.timeView;
                Intrinsics.checkNotNullExpressionValue(textView4, "binding.timeView");
                textView4.setText(getContext().getText(2131887068));
                TextView textView5 = this.binding.fromWhereView;
                Intrinsics.checkNotNullExpressionValue(textView5, "binding.fromWhereView");
                textView5.setVisibility(0);
                TextView textView6 = this.binding.fromWhereView;
                Intrinsics.checkNotNullExpressionValue(textView6, "binding.fromWhereView");
                textView6.setText("图文");
                View view2 = this.binding.coverViewMask;
                Intrinsics.checkNotNullExpressionValue(view2, "binding.coverViewMask");
                view2.setVisibility(8);
                String imageUrl = articleNative.getImageUrl();
                if (imageUrl == null || imageUrl.length() == 0) {
                    ScalingImageView scalingImageView3 = this.binding.topImageView;
                    Intrinsics.checkNotNullExpressionValue(scalingImageView3, "binding.topImageView");
                    scalingImageView3.setVisibility(8);
                    return;
                }
                ScalingImageView scalingImageView4 = this.binding.topImageView;
                Intrinsics.checkNotNullExpressionValue(scalingImageView4, "binding.topImageView");
                scalingImageView4.setVisibility(0);
                ScalingImageView scalingImageView5 = this.binding.topImageView;
                Intrinsics.checkNotNullExpressionValue(scalingImageView5, "binding.topImageView");
                scalingImageView5.setScaleType(ImageView.ScaleType.CENTER_CROP);
                AppHolder.getFragmentImageLoader().displayImage((Fragment) articlePreviewFragment2, articleNative.getImageUrl(), (ImageView) this.binding.topImageView, ImageLoaderOptions.newBuilder().placeHolderRes(2131231702).useAnimate(true).build(), (OnImageLoadListener) null, (OnBitmapTransformListener) null);
                ScalingImageView scalingImageView6 = this.binding.topImageView;
                Intrinsics.checkNotNullExpressionValue(scalingImageView6, "binding.topImageView");
                scalingImageView6.setScaleType(ImageView.ScaleType.MATRIX);
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onClick(view);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u0019\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/feed/reply/ArticlePreviewFragment$ArticlePreviewAnswerTopViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "comp", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "binding", "Lcom/coolapk/market/databinding/ItemArticleAnswerPreviewTopBinding;", "kotlin.jvm.PlatformType", "getBinding", "()Lcom/coolapk/market/databinding/ItemArticleAnswerPreviewTopBinding;", "bindTo", "", "data", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ArticlePreviewFragment.kt */
    public static final class ArticlePreviewAnswerTopViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558612;
        private final ItemArticleAnswerPreviewTopBinding binding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ArticlePreviewAnswerTopViewHolder(View view, DataBindingComponent dataBindingComponent) {
            super(view, dataBindingComponent, null);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "comp");
            ItemArticleAnswerPreviewTopBinding itemArticleAnswerPreviewTopBinding = (ItemArticleAnswerPreviewTopBinding) getBinding();
            this.binding = itemArticleAnswerPreviewTopBinding;
            Intrinsics.checkNotNullExpressionValue(itemArticleAnswerPreviewTopBinding, "binding");
            itemArticleAnswerPreviewTopBinding.setClick(this);
            Intrinsics.checkNotNullExpressionValue(itemArticleAnswerPreviewTopBinding, "binding");
            itemArticleAnswerPreviewTopBinding.setTransformer(new CircleTransform(false, 0, 3, null));
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public final ItemArticleAnswerPreviewTopBinding getBinding() {
            return this.binding;
        }

        /* JADX WARN: Type inference failed for: r6v14, types: [com.coolapk.market.imageloader.GlideRequest] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            try {
                this.binding.executePendingBindings();
            } catch (Exception unused) {
            }
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.view.feedv8.ArticleNative");
            TextView textView = this.binding.titleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
            textView.setText(((ArticleNative) obj).getText());
            DataBindingComponent component = getComponent();
            View view = null;
            if (!(component instanceof FragmentBindingComponent)) {
                component = null;
            }
            FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
            Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
            if (!(fragment instanceof ArticlePreviewFragment)) {
                fragment = null;
            }
            ArticlePreviewFragment articlePreviewFragment = (ArticlePreviewFragment) fragment;
            if (articlePreviewFragment != null) {
                DataManager instance = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                LoginSession loginSession = instance.getLoginSession();
                GlideRequests with = GlideApp.with(articlePreviewFragment);
                Intrinsics.checkNotNullExpressionValue(loginSession, "session");
                with.load(loginSession.getUserAvatar()).transform(new CircleTransform(false, 0, 3, null)).into(this.binding.userAvatarView);
                TextView textView2 = this.binding.nameView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.nameView");
                textView2.setText(loginSession.getUserName());
                TextView textView3 = this.binding.timeView;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.timeView");
                textView3.setText("刚刚");
                TextView textView4 = this.binding.fromWhereView;
                Intrinsics.checkNotNullExpressionValue(textView4, "binding.fromWhereView");
                textView4.setText("回答");
                TextView textView5 = this.binding.fromWhereView;
                Intrinsics.checkNotNullExpressionValue(textView5, "binding.fromWhereView");
                textView5.setVisibility(0);
                TextView textView6 = this.binding.actionView;
                Intrinsics.checkNotNullExpressionValue(textView6, "binding.actionView");
                textView6.setVisibility(8);
                TextView textView7 = this.binding.otherView;
                Intrinsics.checkNotNullExpressionValue(textView7, "binding.otherView");
                ViewParent parent = textView7.getParent();
                if (parent instanceof View) {
                    view = parent;
                }
                View view2 = view;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onClick(view);
            view.getId();
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/reply/ArticlePreviewFragment$ArticlePreviewAnswerTopViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: ArticlePreviewFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }
}
