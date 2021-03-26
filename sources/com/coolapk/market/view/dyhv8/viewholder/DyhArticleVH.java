package com.coolapk.market.view.dyhv8.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemDyhArticleV8Binding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.AppPictureSizeManager;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.PhotoUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.dyhv8.DyhViewModel;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000 .2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001.B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020\"H\u0002J\b\u0010&\u001a\u00020\"H\u0002J\u0010\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020\u0003H\u0016J\b\u0010)\u001a\u00020\"H\u0002J\b\u0010*\u001a\u00020\u001fH\u0002J\u0012\u0010+\u001a\u00020\"2\b\u0010,\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010-\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010\u0003H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/coolapk/market/view/dyhv8/viewholder/DyhArticleVH;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemDyhArticleV8Binding;", "Lcom/coolapk/market/model/DyhArticle;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "mCoverViewPart", "Lcom/coolapk/market/view/dyhv8/viewholder/ArticleCoverViewPart;", "mDyhArticle", "mDyhArticleContentViewPart", "Lcom/coolapk/market/view/dyhv8/viewholder/DyhArticleContentViewPart;", "mDyhArticleHeaderMiniViewPart", "Lcom/coolapk/market/view/dyhv8/viewholder/DyhArticleMiniHeaderViewPart;", "mDyhArticleSimpleHeaderViewPart", "Lcom/coolapk/market/view/dyhv8/viewholder/DyhArticleSimpleHeaderViewPart;", "mDyhViewModel", "Lcom/coolapk/market/view/dyhv8/DyhViewModel;", "mEmptyView", "Landroid/widget/Space;", "mHeaderViewPart", "Lcom/coolapk/market/view/dyhv8/viewholder/DyhArticleHeaderViewPart;", "mNinePicViewPart", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "mRightViewPart", "Lcom/coolapk/market/view/dyhv8/viewholder/ArticleRightCoverViewPart;", "showCover", "", "showRight", "bindContentViewPart", "", "bindCoverViewPart", "bindHeaderViewPart", "bindNineViewPart", "bindRightViewPart", "bindToContent", "dyhArticle", "fixStrangeLayoutBug", "isShowPicContainer", "onClick", "view", "onPopulateDyhImage", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DyhArticleVH.kt */
public final class DyhArticleVH extends GenericBindHolder<ItemDyhArticleV8Binding, DyhArticle> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558684;
    private ArticleCoverViewPart mCoverViewPart;
    private DyhArticle mDyhArticle;
    private DyhArticleContentViewPart mDyhArticleContentViewPart;
    private DyhArticleMiniHeaderViewPart mDyhArticleHeaderMiniViewPart;
    private DyhArticleSimpleHeaderViewPart mDyhArticleSimpleHeaderViewPart;
    private DyhViewModel mDyhViewModel = new DyhViewModel();
    private Space mEmptyView;
    private DyhArticleHeaderViewPart mHeaderViewPart;
    private NinePicViewPart mNinePicViewPart;
    private ArticleRightCoverViewPart mRightViewPart;
    private boolean showCover;
    private boolean showRight;

    public static final /* synthetic */ DyhArticle access$getMDyhArticle$p(DyhArticleVH dyhArticleVH) {
        DyhArticle dyhArticle = dyhArticleVH.mDyhArticle;
        if (dyhArticle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDyhArticle");
        }
        return dyhArticle;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DyhArticleVH(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ItemDyhArticleV8Binding itemDyhArticleV8Binding = (ItemDyhArticleV8Binding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemDyhArticleV8Binding, "binding");
        itemDyhArticleV8Binding.setClick(this);
        itemDyhArticleV8Binding.setTransformer(new CircleTransform(false, 0, 3, null));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/dyhv8/viewholder/DyhArticleVH$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhArticleVH.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(DyhArticle dyhArticle) {
        Intrinsics.checkNotNullParameter(dyhArticle, "dyhArticle");
        if (TextUtils.isEmpty(dyhArticle.getEntityTemplate())) {
            DyhArticle build = DyhArticle.newBuilder(dyhArticle).entityTemplate("article").build();
            Intrinsics.checkNotNullExpressionValue(build, "newDyhArticle");
            this.mDyhArticle = build;
        } else {
            this.mDyhArticle = dyhArticle;
        }
        ItemDyhArticleV8Binding itemDyhArticleV8Binding = (ItemDyhArticleV8Binding) getBinding();
        this.mDyhArticle = dyhArticle;
        Intrinsics.checkNotNullExpressionValue(itemDyhArticleV8Binding, "binding");
        itemDyhArticleV8Binding.setModel(dyhArticle);
        this.mDyhViewModel.setDyhArticle(dyhArticle);
        itemDyhArticleV8Binding.setViewModel(this.mDyhViewModel);
        if (!CollectionUtils.isEmpty(dyhArticle.getPicArr()) && CollectionUtils.safeSize(dyhArticle.getPicArr()) < 3) {
            List<String> picArr = dyhArticle.getPicArr();
            Intrinsics.checkNotNull(picArr);
            if (!TextUtils.isEmpty(picArr.get(0))) {
                AppPictureSizeManager.PictureSize size = AppPictureSizeManager.getInstance().getSize(dyhArticle.getPic());
                if (this.mDyhViewModel.isShowNews() && size != null) {
                    this.showCover = PhotoUtils.isCover(size.getWidth(), size.getHeight());
                    this.showRight = PhotoUtils.isRight(size.getWidth(), size.getHeight());
                }
            }
        }
        bindHeaderViewPart();
        bindContentViewPart();
        bindNineViewPart();
        if (this.mDyhViewModel.isShowNews()) {
            itemDyhArticleV8Binding.setSingleImg(null);
            if (this.showCover) {
                bindCoverViewPart();
                this.mDyhViewModel.setMaxWords(64);
            } else if (this.showRight) {
                bindRightViewPart();
                this.mDyhViewModel.setMaxWords(38);
            } else {
                this.mDyhViewModel.setMaxWords(120);
            }
        }
        FrameLayout frameLayout = itemDyhArticleV8Binding.coverView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.coverView");
        int i = 8;
        frameLayout.setVisibility((!this.showCover || !this.mDyhViewModel.isShowNews()) ? 8 : 0);
        FrameLayout frameLayout2 = itemDyhArticleV8Binding.rightImageLayout;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.rightImageLayout");
        frameLayout2.setVisibility((!this.showRight || !this.mDyhViewModel.isShowNews()) ? 8 : 0);
        FrameLayout frameLayout3 = itemDyhArticleV8Binding.contentContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.contentContainer");
        if (!this.showRight || !this.mDyhViewModel.isShowNews()) {
            i = 0;
        }
        frameLayout3.setVisibility(i);
        itemDyhArticleV8Binding.executePendingBindings();
        fixStrangeLayoutBug();
        this.showCover = false;
        this.showRight = false;
        itemDyhArticleV8Binding.executePendingBindings();
        itemDyhArticleV8Binding.getRoot().setOnLongClickListener(new DyhArticleVH$bindToContent$1(this));
    }

    private final void bindHeaderViewPart() {
        DyhArticle dyhArticle = this.mDyhArticle;
        if (dyhArticle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDyhArticle");
        }
        Space space = null;
        FrameLayout frameLayout = ((ItemDyhArticleV8Binding) getBinding()).headerContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.headerContainer");
        String entityTemplate = dyhArticle.getEntityTemplate();
        if (entityTemplate != null) {
            switch (entityTemplate.hashCode()) {
                case -732377866:
                    if (entityTemplate.equals("article")) {
                        if (this.mDyhArticleHeaderMiniViewPart == null) {
                            DataBindingComponent component = getComponent();
                            Intrinsics.checkNotNullExpressionValue(component, "component");
                            DyhArticleMiniHeaderViewPart dyhArticleMiniHeaderViewPart = new DyhArticleMiniHeaderViewPart(component, this.mDyhViewModel);
                            this.mDyhArticleHeaderMiniViewPart = dyhArticleMiniHeaderViewPart;
                            Intrinsics.checkNotNull(dyhArticleMiniHeaderViewPart);
                            LayoutInflater from = LayoutInflater.from(frameLayout.getContext());
                            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(parent.context)");
                            dyhArticleMiniHeaderViewPart.createView(from, frameLayout);
                        }
                        DyhArticleMiniHeaderViewPart dyhArticleMiniHeaderViewPart2 = this.mDyhArticleHeaderMiniViewPart;
                        Intrinsics.checkNotNull(dyhArticleMiniHeaderViewPart2);
                        dyhArticleMiniHeaderViewPart2.bindToContent(dyhArticle);
                        DyhArticleMiniHeaderViewPart dyhArticleMiniHeaderViewPart3 = this.mDyhArticleHeaderMiniViewPart;
                        Intrinsics.checkNotNull(dyhArticleMiniHeaderViewPart3);
                        space = dyhArticleMiniHeaderViewPart3.getView();
                        break;
                    }
                    break;
                case 817806260:
                    if (entityTemplate.equals("articleFeed")) {
                        if (this.mHeaderViewPart == null) {
                            DataBindingComponent component2 = getComponent();
                            Intrinsics.checkNotNullExpressionValue(component2, "component");
                            DyhArticleHeaderViewPart dyhArticleHeaderViewPart = new DyhArticleHeaderViewPart(component2, this.mDyhViewModel);
                            this.mHeaderViewPart = dyhArticleHeaderViewPart;
                            Intrinsics.checkNotNull(dyhArticleHeaderViewPart);
                            LayoutInflater from2 = LayoutInflater.from(frameLayout.getContext());
                            Intrinsics.checkNotNullExpressionValue(from2, "LayoutInflater.from(parent.context)");
                            dyhArticleHeaderViewPart.createView(from2, frameLayout);
                        }
                        DyhArticleHeaderViewPart dyhArticleHeaderViewPart2 = this.mHeaderViewPart;
                        Intrinsics.checkNotNull(dyhArticleHeaderViewPart2);
                        dyhArticleHeaderViewPart2.bindToContent(dyhArticle);
                        DyhArticleHeaderViewPart dyhArticleHeaderViewPart3 = this.mHeaderViewPart;
                        Intrinsics.checkNotNull(dyhArticleHeaderViewPart3);
                        space = dyhArticleHeaderViewPart3.getView();
                        break;
                    }
                    break;
                case 817910057:
                    if (entityTemplate.equals("articleItem")) {
                        if (this.mDyhArticleSimpleHeaderViewPart == null) {
                            DataBindingComponent component3 = getComponent();
                            Intrinsics.checkNotNullExpressionValue(component3, "component");
                            DyhArticleSimpleHeaderViewPart dyhArticleSimpleHeaderViewPart = new DyhArticleSimpleHeaderViewPart(component3, this.mDyhViewModel);
                            this.mDyhArticleSimpleHeaderViewPart = dyhArticleSimpleHeaderViewPart;
                            Intrinsics.checkNotNull(dyhArticleSimpleHeaderViewPart);
                            LayoutInflater from3 = LayoutInflater.from(frameLayout.getContext());
                            Intrinsics.checkNotNullExpressionValue(from3, "LayoutInflater.from(parent.context)");
                            dyhArticleSimpleHeaderViewPart.createView(from3, frameLayout);
                        }
                        DyhArticleSimpleHeaderViewPart dyhArticleSimpleHeaderViewPart2 = this.mDyhArticleSimpleHeaderViewPart;
                        Intrinsics.checkNotNull(dyhArticleSimpleHeaderViewPart2);
                        dyhArticleSimpleHeaderViewPart2.bindToContent(dyhArticle);
                        DyhArticleSimpleHeaderViewPart dyhArticleSimpleHeaderViewPart3 = this.mDyhArticleSimpleHeaderViewPart;
                        Intrinsics.checkNotNull(dyhArticleSimpleHeaderViewPart3);
                        space = dyhArticleSimpleHeaderViewPart3.getView();
                        break;
                    }
                    break;
                case 818045161:
                    if (entityTemplate.equals("articleNews")) {
                        if (this.mEmptyView == null) {
                            Space space2 = new Space(getContext());
                            space2.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
                            Unit unit = Unit.INSTANCE;
                            this.mEmptyView = space2;
                        }
                        Space space3 = this.mEmptyView;
                        Intrinsics.checkNotNull(space3);
                        space = space3;
                        break;
                    }
                    break;
            }
        }
        if (frameLayout.getChildAt(0) != space) {
            frameLayout.removeAllViews();
            frameLayout.addView(space);
        }
    }

    private final void bindNineViewPart() {
        if (this.mNinePicViewPart == null) {
            DataBindingComponent component = getComponent();
            Intrinsics.checkNotNullExpressionValue(component, "component");
            NinePicViewPart ninePicViewPart = new NinePicViewPart(component);
            this.mNinePicViewPart = ninePicViewPart;
            Intrinsics.checkNotNull(ninePicViewPart);
            LayoutInflater from = LayoutInflater.from(getContext());
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(context)");
            ninePicViewPart.createView(from, ((ItemDyhArticleV8Binding) getBinding()).coolPicPartContainer);
            FrameLayout frameLayout = ((ItemDyhArticleV8Binding) getBinding()).coolPicPartContainer;
            NinePicViewPart ninePicViewPart2 = this.mNinePicViewPart;
            Intrinsics.checkNotNull(ninePicViewPart2);
            frameLayout.addView(ninePicViewPart2.getView());
            NinePicViewPart ninePicViewPart3 = this.mNinePicViewPart;
            Intrinsics.checkNotNull(ninePicViewPart3);
            View view = ninePicViewPart3.getView();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
            marginLayoutParams2.leftMargin = ResourceUtils.getDimen(getContext(), 2131165382);
            marginLayoutParams2.rightMargin = ResourceUtils.getDimen(getContext(), 2131165382);
            view.setLayoutParams(marginLayoutParams);
        }
        NinePicViewPart ninePicViewPart4 = this.mNinePicViewPart;
        Intrinsics.checkNotNull(ninePicViewPart4);
        ninePicViewPart4.setImageViewClickable(false);
        DyhArticle dyhArticle = this.mDyhArticle;
        if (dyhArticle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDyhArticle");
        }
        onPopulateDyhImage(dyhArticle);
    }

    private final void bindContentViewPart() {
        if (this.mDyhArticleContentViewPart == null) {
            DataBindingComponent component = getComponent();
            Intrinsics.checkNotNullExpressionValue(component, "component");
            DyhArticleContentViewPart dyhArticleContentViewPart = new DyhArticleContentViewPart(component, this.mDyhViewModel);
            this.mDyhArticleContentViewPart = dyhArticleContentViewPart;
            Intrinsics.checkNotNull(dyhArticleContentViewPart);
            LayoutInflater from = LayoutInflater.from(getContext());
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(context)");
            dyhArticleContentViewPart.createView(from, ((ItemDyhArticleV8Binding) getBinding()).contentContainer);
            FrameLayout frameLayout = ((ItemDyhArticleV8Binding) getBinding()).contentContainer;
            DyhArticleContentViewPart dyhArticleContentViewPart2 = this.mDyhArticleContentViewPart;
            Intrinsics.checkNotNull(dyhArticleContentViewPart2);
            frameLayout.addView(dyhArticleContentViewPart2.getView());
        }
        DyhArticleContentViewPart dyhArticleContentViewPart3 = this.mDyhArticleContentViewPart;
        Intrinsics.checkNotNull(dyhArticleContentViewPart3);
        DyhArticle dyhArticle = this.mDyhArticle;
        if (dyhArticle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDyhArticle");
        }
        dyhArticleContentViewPart3.bindToContent(dyhArticle);
    }

    private final void bindRightViewPart() {
        if (this.mRightViewPart == null) {
            this.mRightViewPart = ArticleRightCoverViewPart.newInstance(((ItemDyhArticleV8Binding) getBinding()).rightImageLayout, getComponent());
            FrameLayout frameLayout = ((ItemDyhArticleV8Binding) getBinding()).rightImageLayout;
            ArticleRightCoverViewPart articleRightCoverViewPart = this.mRightViewPart;
            Intrinsics.checkNotNull(articleRightCoverViewPart);
            frameLayout.addView(articleRightCoverViewPart.getView());
        }
        ArticleRightCoverViewPart articleRightCoverViewPart2 = this.mRightViewPart;
        Intrinsics.checkNotNull(articleRightCoverViewPart2);
        DyhArticle dyhArticle = this.mDyhArticle;
        if (dyhArticle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDyhArticle");
        }
        articleRightCoverViewPart2.bindToContent(dyhArticle);
    }

    private final void bindCoverViewPart() {
        if (this.mCoverViewPart == null) {
            this.mCoverViewPart = ArticleCoverViewPart.newInstance(((ItemDyhArticleV8Binding) getBinding()).coverView, getComponent());
            FrameLayout frameLayout = ((ItemDyhArticleV8Binding) getBinding()).coverView;
            ArticleCoverViewPart articleCoverViewPart = this.mCoverViewPart;
            Intrinsics.checkNotNull(articleCoverViewPart);
            frameLayout.addView(articleCoverViewPart.getView());
        }
        ArticleCoverViewPart articleCoverViewPart2 = this.mCoverViewPart;
        Intrinsics.checkNotNull(articleCoverViewPart2);
        DyhArticle dyhArticle = this.mDyhArticle;
        if (dyhArticle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDyhArticle");
        }
        articleCoverViewPart2.bindToContent(dyhArticle);
    }

    private final void fixStrangeLayoutBug() {
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView");
        if (!view.isLayoutRequested()) {
            this.itemView.requestLayout();
        }
    }

    private final void onPopulateDyhImage(DyhArticle dyhArticle) {
        if (dyhArticle == null || !isShowPicContainer()) {
            NinePicViewPart ninePicViewPart = this.mNinePicViewPart;
            Intrinsics.checkNotNull(ninePicViewPart);
            ninePicViewPart.bindToContent(CollectionsKt.emptyList());
        } else if (!this.mDyhViewModel.isArticleNewsTemplate()) {
            NinePicViewPart ninePicViewPart2 = this.mNinePicViewPart;
            Intrinsics.checkNotNull(ninePicViewPart2);
            ninePicViewPart2.setMaxShowCount(-1);
            NinePicViewPart ninePicViewPart3 = this.mNinePicViewPart;
            Intrinsics.checkNotNull(ninePicViewPart3);
            List<String> picArr = dyhArticle.getPicArr();
            Intrinsics.checkNotNull(picArr);
            Intrinsics.checkNotNullExpressionValue(picArr, "dyhArticle!!.picArr!!");
            ninePicViewPart3.bindToContent(picArr);
        } else if (CollectionUtils.safeSize(dyhArticle.getPicArr()) > 3) {
            NinePicViewPart ninePicViewPart4 = this.mNinePicViewPart;
            Intrinsics.checkNotNull(ninePicViewPart4);
            ninePicViewPart4.setMaxShowCount(3);
            NinePicViewPart ninePicViewPart5 = this.mNinePicViewPart;
            Intrinsics.checkNotNull(ninePicViewPart5);
            List<String> picArr2 = dyhArticle.getPicArr();
            Intrinsics.checkNotNull(picArr2);
            Intrinsics.checkNotNullExpressionValue(picArr2, "dyhArticle.picArr!!");
            ninePicViewPart5.bindToContent(picArr2);
        } else {
            int safeSize = CollectionUtils.safeSize(dyhArticle.getPicArr());
            if (1 <= safeSize && 3 >= safeSize) {
                NinePicViewPart ninePicViewPart6 = this.mNinePicViewPart;
                Intrinsics.checkNotNull(ninePicViewPart6);
                ninePicViewPart6.setMaxShowCount(-1);
                NinePicViewPart ninePicViewPart7 = this.mNinePicViewPart;
                Intrinsics.checkNotNull(ninePicViewPart7);
                List<String> picArr3 = dyhArticle.getPicArr();
                Intrinsics.checkNotNull(picArr3);
                Intrinsics.checkNotNullExpressionValue(picArr3, "dyhArticle.picArr!!");
                ninePicViewPart7.bindToContent(picArr3);
                return;
            }
            NinePicViewPart ninePicViewPart8 = this.mNinePicViewPart;
            Intrinsics.checkNotNull(ninePicViewPart8);
            ninePicViewPart8.bindToContent(CollectionsKt.emptyList());
        }
    }

    private final boolean isShowPicContainer() {
        if (!this.showCover && !this.showRight) {
            DyhArticle dyhArticle = this.mDyhArticle;
            if (dyhArticle == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDyhArticle");
            }
            if (CollectionUtils.safeSize(dyhArticle.getPicArr()) >= 1) {
                return true;
            }
        }
        return false;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        Intrinsics.checkNotNull(view);
        if (view.getId() == 2131363274) {
            DyhArticle dyhArticle = this.mDyhArticle;
            if (dyhArticle == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDyhArticle");
            }
            if (!TextUtils.isEmpty(dyhArticle.getRawUrl())) {
                DyhArticle dyhArticle2 = this.mDyhArticle;
                if (dyhArticle2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDyhArticle");
                }
                String rawUrl = dyhArticle2.getRawUrl();
                Intrinsics.checkNotNull(rawUrl);
                Intrinsics.checkNotNullExpressionValue(rawUrl, "mDyhArticle.rawUrl!!");
                if (UriUtils.isInAppUrl(rawUrl)) {
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    DyhArticle dyhArticle3 = this.mDyhArticle;
                    if (dyhArticle3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mDyhArticle");
                    }
                    ActionManagerCompat.startActivityByUrl$default(context, dyhArticle3.getRawUrl(), null, null, 12, null);
                    return;
                }
            }
            Context context2 = getContext();
            DyhArticle dyhArticle4 = this.mDyhArticle;
            if (dyhArticle4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDyhArticle");
            }
            ActionManager.startDyhArticleDetailActivity(context2, dyhArticle4.getId());
        }
    }
}
