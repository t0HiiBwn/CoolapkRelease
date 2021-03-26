package com.coolapk.market.view.feedv8;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.databinding.SubmitFeedGoodsBinding;
import com.coolapk.market.databinding.SubmitVoteExtraChildBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.model.FeedGoodsCategory;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.util.DialogUtil;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.TintHelper;
import com.coolapk.market.view.feed.CommentHelper;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.emotion.BaseEmotion;
import com.coolapk.market.widget.view.BadBadRatingBar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001LB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\r\u0010 \u001a\u00020!H\u0010¢\u0006\u0002\b\"J\r\u0010#\u001a\u00020$H\u0010¢\u0006\u0002\b%J\b\u0010&\u001a\u00020'H\u0002J\r\u0010(\u001a\u00020'H\u0010¢\u0006\u0002\b)J\u0010\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020\u001dH\u0016J\u0015\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020.H\u0010¢\u0006\u0002\b/J\b\u00100\u001a\u00020'H\u0016J\u0010\u00101\u001a\u00020'2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020'2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020'2\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010:\u001a\u00020'2\u0006\u00108\u001a\u000209H\u0016J\u0016\u0010;\u001a\u00020'2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=H\u0016J\u0010\u0010?\u001a\u00020'2\u0006\u00108\u001a\u000209H\u0016J\b\u0010@\u001a\u00020'H\u0016J\b\u0010A\u001a\u00020'H\u0016J\u0013\u0010B\u001a\b\u0012\u0004\u0012\u00020$0CH\u0010¢\u0006\u0002\bDJ\b\u0010E\u001a\u00020'H\u0002J\u0012\u0010F\u001a\u00020'2\b\u0010G\u001a\u0004\u0018\u00010HH\u0002J\u0010\u0010I\u001a\u00020'2\u0006\u0010J\u001a\u00020KH\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006M"}, d2 = {"Lcom/coolapk/market/view/feedv8/GoodsContentHolder;", "Lcom/coolapk/market/view/feedv8/BaseFeedContentHolder;", "Landroid/view/View$OnClickListener;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "adapter", "Lcom/coolapk/market/view/feedv8/PickPhotoAdapterV8;", "getAdapter$presentation_coolapkAppRelease", "()Lcom/coolapk/market/view/feedv8/PickPhotoAdapterV8;", "setAdapter$presentation_coolapkAppRelease", "(Lcom/coolapk/market/view/feedv8/PickPhotoAdapterV8;)V", "binding", "Lcom/coolapk/market/databinding/SubmitFeedGoodsBinding;", "getBinding$presentation_coolapkAppRelease", "()Lcom/coolapk/market/databinding/SubmitFeedGoodsBinding;", "setBinding$presentation_coolapkAppRelease", "(Lcom/coolapk/market/databinding/SubmitFeedGoodsBinding;)V", "categoryView", "Lcom/coolapk/market/databinding/SubmitVoteExtraChildBinding;", "getCategoryView", "()Lcom/coolapk/market/databinding/SubmitVoteExtraChildBinding;", "categoryView$delegate", "Lkotlin/Lazy;", "focusEditText", "Landroid/widget/EditText;", "getFocusEditText", "()Landroid/widget/EditText;", "focusEditorView", "Landroid/view/View;", "getFocusEditorView", "()Landroid/view/View;", "checkSubmittable", "", "checkSubmittable$presentation_coolapkAppRelease", "generateDraftCopy", "Lcom/coolapk/market/model/FeedMultiPart;", "generateDraftCopy$presentation_coolapkAppRelease", "initCheckBoxViews", "", "notifyUIChange", "notifyUIChange$presentation_coolapkAppRelease", "onClick", "v", "onCreateContentView", "inflater", "Landroid/view/LayoutInflater;", "onCreateContentView$presentation_coolapkAppRelease", "onDeleteButtonClick", "onEmotionClick", "emotions", "Lcom/coolapk/market/widget/emotion/BaseEmotion;", "onExtraEntityLoaded", "entity", "Lcom/coolapk/market/model/Entity;", "onPickAppIntent", "data", "Landroid/content/Intent;", "onPickAtIntent", "onPickImageListChange", "pathList", "", "", "onPickTopicIntent", "onRequestPickImage", "onSubmitButtonClick", "prepareMultiFeed", "Lrx/Observable;", "prepareMultiFeed$presentation_coolapkAppRelease", "showCategoryDialog", "updateGoodsUI", "feedGoods", "Lcom/coolapk/market/model/FeedGoods;", "updateRatingScore", "score", "", "SimpleViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsContentHolder.kt */
public final class GoodsContentHolder extends BaseFeedContentHolder implements View.OnClickListener {
    public PickPhotoAdapterV8 adapter;
    public SubmitFeedGoodsBinding binding;
    private final Lazy categoryView$delegate = LazyKt.lazy(new GoodsContentHolder$categoryView$2(this));

    private final SubmitVoteExtraChildBinding getCategoryView() {
        return (SubmitVoteExtraChildBinding) this.categoryView$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GoodsContentHolder(Activity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public final SubmitFeedGoodsBinding getBinding$presentation_coolapkAppRelease() {
        SubmitFeedGoodsBinding submitFeedGoodsBinding = this.binding;
        if (submitFeedGoodsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return submitFeedGoodsBinding;
    }

    public final void setBinding$presentation_coolapkAppRelease(SubmitFeedGoodsBinding submitFeedGoodsBinding) {
        Intrinsics.checkNotNullParameter(submitFeedGoodsBinding, "<set-?>");
        this.binding = submitFeedGoodsBinding;
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public View getFocusEditorView() {
        return getFocusEditText();
    }

    private final EditText getFocusEditText() {
        SubmitFeedGoodsBinding submitFeedGoodsBinding = this.binding;
        if (submitFeedGoodsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = submitFeedGoodsBinding.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        return editText;
    }

    public final PickPhotoAdapterV8 getAdapter$presentation_coolapkAppRelease() {
        PickPhotoAdapterV8 pickPhotoAdapterV8 = this.adapter;
        if (pickPhotoAdapterV8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return pickPhotoAdapterV8;
    }

    public final void setAdapter$presentation_coolapkAppRelease(PickPhotoAdapterV8 pickPhotoAdapterV8) {
        Intrinsics.checkNotNullParameter(pickPhotoAdapterV8, "<set-?>");
        this.adapter = pickPhotoAdapterV8;
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public View onCreateContentView$presentation_coolapkAppRelease(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        int i = 0;
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131559159, null, false, new ContextBindingComponent(getActivity()));
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…ndingComponent(activity))");
        SubmitFeedGoodsBinding submitFeedGoodsBinding = (SubmitFeedGoodsBinding) inflate;
        this.binding = submitFeedGoodsBinding;
        if (submitFeedGoodsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitFeedGoodsBinding.setUiConfig(getUiConfig());
        SubmitFeedGoodsBinding submitFeedGoodsBinding2 = this.binding;
        if (submitFeedGoodsBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = submitFeedGoodsBinding2.editText;
        editText.addTextChangedListener(new CommentHelper.EmotionTextModifier());
        editText.addTextChangedListener(new GoodsContentHolder$onCreateContentView$$inlined$apply$lambda$1(this));
        editText.setText(getMultiPart().message());
        editText.addTextChangedListener(new GoodsContentHolder$onCreateContentView$$inlined$apply$lambda$2(this));
        editText.setOnKeyListener(new CommentHelper.FastDeleteAtUserKeyListener());
        editText.addTextChangedListener(new CommentHelper.OnTextInputListener("@", new GoodsContentHolder$onCreateContentView$$inlined$apply$lambda$3(this)));
        editText.setOnFocusChangeListener(new GoodsContentHolder$onCreateContentView$$inlined$apply$lambda$4(this));
        PickPhotoAdapterV8 pickPhotoAdapterV8 = new PickPhotoAdapterV8(getActivity());
        this.adapter = pickPhotoAdapterV8;
        if (pickPhotoAdapterV8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        pickPhotoAdapterV8.setOnPhotoCountChangeListener(new GoodsContentHolder$onCreateContentView$$inlined$apply$lambda$5(this));
        pickPhotoAdapterV8.setPickPhotoClickListener(new GoodsContentHolder$onCreateContentView$$inlined$apply$lambda$6(this));
        pickPhotoAdapterV8.setInitList(getMultiPart().imageUriList());
        pickPhotoAdapterV8.setEditTable(true);
        pickPhotoAdapterV8.setMaxPickCount(getUiConfig().maxPickPhotoCount());
        SubmitFeedGoodsBinding submitFeedGoodsBinding3 = this.binding;
        if (submitFeedGoodsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView = submitFeedGoodsBinding3.recyclerView;
        PickPhotoAdapterV8 pickPhotoAdapterV82 = this.adapter;
        if (pickPhotoAdapterV82 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(pickPhotoAdapterV82);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setOverScrollMode(2);
        SubmitFeedGoodsBinding submitFeedGoodsBinding4 = this.binding;
        if (submitFeedGoodsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        BadBadRatingBar badBadRatingBar = submitFeedGoodsBinding4.ratingBar;
        badBadRatingBar.setHeartShapeProgressBar(NumberExtendsKt.getDp((Number) 36));
        badBadRatingBar.setProgressBackgroundTintList(ColorStateList.valueOf((int) 4292335575L));
        badBadRatingBar.setRating((float) getMultiPart().ratingScore1());
        updateRatingScore(getMultiPart().ratingScore1());
        badBadRatingBar.setOnRatingBarChangeListener(new GoodsContentHolder$onCreateContentView$$inlined$apply$lambda$7(this));
        updateGoodsUI(getUiConfig().feedGoods());
        SubmitFeedGoodsBinding submitFeedGoodsBinding5 = this.binding;
        if (submitFeedGoodsBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView = submitFeedGoodsBinding5.closeView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.closeView");
        ViewExtendsKt.expandTouchRect(imageView, NumberExtendsKt.getDp((Number) 12));
        SubmitFeedGoodsBinding submitFeedGoodsBinding6 = this.binding;
        if (submitFeedGoodsBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView2 = submitFeedGoodsBinding6.closeView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.closeView");
        ImageView imageView3 = imageView2;
        if (!getUiConfig().isFeedGoodsClosable()) {
            i = 8;
        }
        imageView3.setVisibility(i);
        initCheckBoxViews();
        SubmitFeedGoodsBinding submitFeedGoodsBinding7 = this.binding;
        if (submitFeedGoodsBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitFeedGoodsBinding7.setClick(this);
        SubmitFeedGoodsBinding submitFeedGoodsBinding8 = this.binding;
        if (submitFeedGoodsBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitFeedGoodsBinding8.executePendingBindings();
        SubmitFeedGoodsBinding submitFeedGoodsBinding9 = this.binding;
        if (submitFeedGoodsBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitFeedGoodsBinding9.getRoot().postDelayed(new GoodsContentHolder$onCreateContentView$5(this), 300);
        SubmitFeedGoodsBinding submitFeedGoodsBinding10 = this.binding;
        if (submitFeedGoodsBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = submitFeedGoodsBinding10.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    private final void initCheckBoxViews() {
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        GoodsContentHolder$initCheckBoxViews$1 goodsContentHolder$initCheckBoxViews$1 = new GoodsContentHolder$initCheckBoxViews$1(this, booleanRef);
        SubmitFeedGoodsBinding submitFeedGoodsBinding = this.binding;
        if (submitFeedGoodsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitFeedGoodsBinding.buyCheckBox.setOnCheckedChangeListener(new GoodsContentHolder$initCheckBoxViews$2(booleanRef, goodsContentHolder$initCheckBoxViews$1));
        SubmitFeedGoodsBinding submitFeedGoodsBinding2 = this.binding;
        if (submitFeedGoodsBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitFeedGoodsBinding2.wishCheckBox.setOnCheckedChangeListener(new GoodsContentHolder$initCheckBoxViews$3(booleanRef, goodsContentHolder$initCheckBoxViews$1));
        SubmitFeedGoodsBinding submitFeedGoodsBinding3 = this.binding;
        if (submitFeedGoodsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TintHelper.setTint(submitFeedGoodsBinding3.buyCheckBox, AppHolder.getAppTheme().getColorAccent(), AppHolder.getAppTheme().isDarkTheme());
        SubmitFeedGoodsBinding submitFeedGoodsBinding4 = this.binding;
        if (submitFeedGoodsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TintHelper.setTint(submitFeedGoodsBinding4.wishCheckBox, AppHolder.getAppTheme().getColorAccent(), AppHolder.getAppTheme().isDarkTheme());
        goodsContentHolder$initCheckBoxViews$1.invoke(getMultiPart().buyStatus());
    }

    /* access modifiers changed from: private */
    public final void updateGoodsUI(FeedGoods feedGoods) {
        String str;
        SubmitFeedGoodsBinding submitFeedGoodsBinding = this.binding;
        if (submitFeedGoodsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FeedGoods feedGoods2 = submitFeedGoodsBinding.getFeedGoods();
        SubmitFeedGoodsBinding submitFeedGoodsBinding2 = this.binding;
        if (submitFeedGoodsBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitFeedGoodsBinding2.setFeedGoods(feedGoods);
        String str2 = null;
        if (!Intrinsics.areEqual(getUiConfig().feedGoods(), feedGoods)) {
            FeedUIConfig build = getUiConfig().newBuilder().feedGoods(feedGoods).build();
            Intrinsics.checkNotNullExpressionValue(build, "uiConfig.newBuilder().feedGoods(feedGoods).build()");
            updateUiConfig$presentation_coolapkAppRelease(build);
            FeedMultiPart.Builder newBuilder = getMultiPart().newBuilder();
            if (feedGoods != null) {
                str = feedGoods.getId();
            } else {
                str = "";
            }
            FeedMultiPart.Builder extraKey = newBuilder.extraKey(str);
            if (feedGoods == null || feedGoods.getCategoryId() <= 0) {
                extraKey.categoryId(0);
            } else {
                extraKey.categoryId((int) feedGoods.getCategoryId());
            }
            Unit unit = Unit.INSTANCE;
            FeedMultiPart build2 = extraKey.build();
            Intrinsics.checkNotNullExpressionValue(build2, "multiPart.newBuilder()\n …                 .build()");
            updateMultiPart$presentation_coolapkAppRelease(build2);
            feedGoods2 = null;
        }
        SubmitFeedGoodsBinding submitFeedGoodsBinding3 = this.binding;
        if (submitFeedGoodsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        if (!Intrinsics.areEqual(feedGoods2, submitFeedGoodsBinding3.getFeedGoods())) {
            SubmitFeedGoodsBinding submitFeedGoodsBinding4 = this.binding;
            if (submitFeedGoodsBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            if (submitFeedGoodsBinding4.getFeedGoods() != null) {
                SubmitFeedGoodsBinding submitFeedGoodsBinding5 = this.binding;
                if (submitFeedGoodsBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                submitFeedGoodsBinding5.executePendingBindings();
                SubmitFeedGoodsBinding submitFeedGoodsBinding6 = this.binding;
                if (submitFeedGoodsBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                TextView textView = submitFeedGoodsBinding6.titleView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
                ViewExtendsKt.applyText(textView, new GoodsContentHolder$updateGoodsUI$2(feedGoods));
            }
        }
        TransitionManager.beginDelayedTransition(getCategoryView().itemView);
        if (feedGoods == null || feedGoods.getCategoryId() != 0) {
            SubmitFeedGoodsBinding submitFeedGoodsBinding7 = this.binding;
            if (submitFeedGoodsBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            View view = submitFeedGoodsBinding7.dividerView;
            Intrinsics.checkNotNullExpressionValue(view, "binding.dividerView");
            view.setVisibility(8);
            View root = getCategoryView().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "categoryView.root");
            root.setVisibility(8);
        } else {
            SubmitFeedGoodsBinding submitFeedGoodsBinding8 = this.binding;
            if (submitFeedGoodsBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            View view2 = submitFeedGoodsBinding8.dividerView;
            Intrinsics.checkNotNullExpressionValue(view2, "binding.dividerView");
            view2.setVisibility(0);
            View root2 = getCategoryView().getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "categoryView.root");
            root2.setVisibility(0);
            TextView textView2 = getCategoryView().titleView;
            Intrinsics.checkNotNullExpressionValue(textView2, "categoryView.titleView");
            textView2.setText("选择分类");
            getCategoryView().imageView.setImageResource(2131231170);
            List<FeedGoodsCategory> categoryRows = feedGoods.getCategoryRows();
            Intrinsics.checkNotNullExpressionValue(categoryRows, "feedGoods.categoryRows");
            List<FeedGoodsCategory> list = categoryRows;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
            for (T t : list) {
                T t2 = t;
                Intrinsics.checkNotNullExpressionValue(t2, "it");
                linkedHashMap.put(Integer.valueOf((int) t2.getId()), t);
            }
            if (linkedHashMap.containsKey(Integer.valueOf(getMultiPart().categoryId()))) {
                TextView textView3 = getCategoryView().descriptionView;
                Intrinsics.checkNotNullExpressionValue(textView3, "categoryView.descriptionView");
                FeedGoodsCategory feedGoodsCategory = (FeedGoodsCategory) linkedHashMap.get(Integer.valueOf(getMultiPart().categoryId()));
                if (feedGoodsCategory != null) {
                    str2 = feedGoodsCategory.getTitle();
                }
                textView3.setText(str2);
            } else {
                TextView textView4 = getCategoryView().descriptionView;
                Intrinsics.checkNotNullExpressionValue(textView4, "categoryView.descriptionView");
                textView4.setText("");
            }
            getCategoryView().itemView.setOnClickListener(new GoodsContentHolder$updateGoodsUI$3(this));
        }
        requestCheckSubmittable$presentation_coolapkAppRelease();
    }

    /* access modifiers changed from: private */
    public final void updateRatingScore(int i) {
        int constrain = KotlinExtendKt.constrain(i, 5, 0);
        SubmitFeedGoodsBinding submitFeedGoodsBinding = this.binding;
        if (submitFeedGoodsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        BadBadRatingBar badBadRatingBar = submitFeedGoodsBinding.ratingBar;
        Intrinsics.checkNotNullExpressionValue(badBadRatingBar, "binding.ratingBar");
        badBadRatingBar.setProgressTintList(ColorStateList.valueOf(RatingContentHelper.INSTANCE.getSCORE_TINT_COLORS()[constrain].intValue()));
        if (getMultiPart().ratingScore1() != constrain) {
            FeedMultiPart build = getMultiPart().newBuilder().ratingScore1(constrain).build();
            Intrinsics.checkNotNullExpressionValue(build, "multiPart.newBuilder().r…Score1(realScore).build()");
            updateMultiPart$presentation_coolapkAppRelease(build);
            requestCheckSubmittable$presentation_coolapkAppRelease();
        }
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onPickImageListChange(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "pathList");
        super.onPickImageListChange(list);
        PickPhotoAdapterV8 pickPhotoAdapterV8 = this.adapter;
        if (pickPhotoAdapterV8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        pickPhotoAdapterV8.onPickedImageChange(list);
        requestCheckSubmittable$presentation_coolapkAppRelease();
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onRequestPickImage() {
        super.onRequestPickImage();
        PickPhotoAdapterV8 pickPhotoAdapterV8 = this.adapter;
        if (pickPhotoAdapterV8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        pickPhotoAdapterV8.pickImage();
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void notifyUIChange$presentation_coolapkAppRelease() {
        super.notifyUIChange$presentation_coolapkAppRelease();
        SubmitFeedGoodsBinding submitFeedGoodsBinding = this.binding;
        if (submitFeedGoodsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitFeedGoodsBinding.setUiConfig(getUiConfig());
        SubmitFeedGoodsBinding submitFeedGoodsBinding2 = this.binding;
        if (submitFeedGoodsBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitFeedGoodsBinding2.executePendingBindings();
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder, com.coolapk.market.widget.emotion.EmotionPanel.EmotionPanelListener
    public void onDeleteButtonClick() {
        super.onDeleteButtonClick();
        ViewExtendsKt.insertBackKey(getFocusEditText());
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder, com.coolapk.market.widget.emotion.EmotionPanel.EmotionPanelListener
    public void onEmotionClick(BaseEmotion baseEmotion) {
        Intrinsics.checkNotNullParameter(baseEmotion, "emotions");
        super.onEmotionClick(baseEmotion);
        String realText = baseEmotion.getRealText();
        EditText focusEditText = getFocusEditText();
        Intrinsics.checkNotNullExpressionValue(realText, "emotionText");
        ViewExtendsKt.insertText(focusEditText, realText);
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onPickTopicIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        super.onPickTopicIntent(intent);
        CommentHelper.processTopicResult(intent, getFocusEditText());
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onPickAtIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        super.onPickAtIntent(intent);
        CommentHelper.processAtUserResult(intent, getFocusEditText());
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onPickAppIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        super.onPickAppIntent(intent);
        CommentHelper.processAddAppResult(intent, getFocusEditText());
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onSubmitButtonClick() {
        String extraKey = getMultiPart().extraKey();
        if (extraKey == null || extraKey.length() == 0) {
            Toast.show$default(getActivity(), "请先添加好物", 0, false, 12, null);
        } else if (getMultiPart().categoryId() == 0) {
            Toast.show$default(getActivity(), "该好物首次被分享，需选择分类", 0, true, 4, null);
            showCategoryDialog();
        } else {
            SubmitFeedGoodsBinding submitFeedGoodsBinding = this.binding;
            if (submitFeedGoodsBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText = submitFeedGoodsBinding.editText;
            Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
            if (editText.getText().length() < 50) {
                Toast.show$default(getActivity(), "请多分享一些推荐理由吧（至少50字）", 0, false, 12, null);
                return;
            }
            PickPhotoAdapterV8 pickPhotoAdapterV8 = this.adapter;
            if (pickPhotoAdapterV8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            }
            if (pickPhotoAdapterV8.getImageUrls().isEmpty()) {
                Toast.show$default(getActivity(), "请添加真实好物图片吧", 0, false, 12, null);
            } else {
                startSubmitFeed$presentation_coolapkAppRelease();
            }
        }
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public FeedMultiPart generateDraftCopy$presentation_coolapkAppRelease() {
        SubmitFeedGoodsBinding submitFeedGoodsBinding = this.binding;
        if (submitFeedGoodsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = submitFeedGoodsBinding.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        String obj = editText.getText().toString();
        FeedMultiPart.Builder builder = FeedMultiPart.builder(getMultiPart());
        String str = obj;
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare(str.charAt(!z ? i : length), 32) <= 0;
            if (!z) {
                if (!z2) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!z2) {
                break;
            } else {
                length--;
            }
        }
        builder.message(str.subSequence(i, length + 1).toString());
        Map map = (Map) Observable.from(getMultiPart().imageUriList()).toMap(GoodsContentHolder$generateDraftCopy$oldImageMap$1.INSTANCE).toBlocking().first();
        PickPhotoAdapterV8 pickPhotoAdapterV8 = this.adapter;
        if (pickPhotoAdapterV8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        builder.imageUriList((List) Observable.from(pickPhotoAdapterV8.getImageUrls()).map(new GoodsContentHolder$generateDraftCopy$fixedList$1(map)).toList().toBlocking().first());
        FeedMultiPart build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public Observable<FeedMultiPart> prepareMultiFeed$presentation_coolapkAppRelease() {
        FeedMultiPart.Builder builder = FeedMultiPart.builder(getMultiPart());
        SubmitFeedGoodsBinding submitFeedGoodsBinding = this.binding;
        if (submitFeedGoodsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = submitFeedGoodsBinding.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        String obj = editText.getText().toString();
        int length = obj.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare(obj.charAt(!z ? i : length), 32) <= 0;
            if (!z) {
                if (!z2) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!z2) {
                break;
            } else {
                length--;
            }
        }
        builder.message(obj.subSequence(i, length + 1).toString());
        FeedMultiPart build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        updateMultiPart$presentation_coolapkAppRelease(build);
        FeedMultiPart multiPart = getMultiPart();
        Map map = (Map) Observable.from(multiPart.imageUriList()).toMap(GoodsContentHolder$prepareMultiFeed$oldImageMap$1.INSTANCE).toBlocking().first();
        PickPhotoAdapterV8 pickPhotoAdapterV8 = this.adapter;
        if (pickPhotoAdapterV8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        List list = (List) Observable.from(pickPhotoAdapterV8.getImageUrls()).map(new GoodsContentHolder$prepareMultiFeed$fixedList$1(map)).toList().toBlocking().first();
        multiPart.imageUriList().clear();
        List<ImageUrl> imageUriList = multiPart.imageUriList();
        Intrinsics.checkNotNullExpressionValue(list, "fixedList");
        imageUriList.addAll(list);
        return super.prepareMultiFeed$presentation_coolapkAppRelease();
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public boolean checkSubmittable$presentation_coolapkAppRelease() {
        SubmitFeedGoodsBinding submitFeedGoodsBinding = this.binding;
        if (submitFeedGoodsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        BadBadRatingBar badBadRatingBar = submitFeedGoodsBinding.ratingBar;
        Intrinsics.checkNotNullExpressionValue(badBadRatingBar, "binding.ratingBar");
        if (badBadRatingBar.getRating() <= ((float) 0)) {
            return false;
        }
        SubmitFeedGoodsBinding submitFeedGoodsBinding2 = this.binding;
        if (submitFeedGoodsBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        if (submitFeedGoodsBinding2.getFeedGoods() == null) {
            return false;
        }
        return true;
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onExtraEntityLoaded(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        if (entity instanceof FeedGoods) {
            updateGoodsUI((FeedGoods) entity);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        int id = view.getId();
        if (id == 2131361999) {
            ActionManager.startGoodsSearchActivity(getActivity(), 349);
        } else if (id == 2131362257) {
            updateGoodsUI(null);
        }
    }

    /* access modifiers changed from: private */
    public final void showCategoryDialog() {
        List<FeedGoodsCategory> categoryRows;
        FeedGoods feedGoods = getUiConfig().feedGoods();
        if (feedGoods != null && (categoryRows = feedGoods.getCategoryRows()) != null) {
            Activity activity = getActivity();
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = getMultiPart().categoryId();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = (T) null;
            RecyclerView recyclerView = new RecyclerView(getActivity());
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
            recyclerView.setPadding(NumberExtendsKt.getDp((Number) 12), NumberExtendsKt.getDp((Number) 28), NumberExtendsKt.getDp((Number) 12), NumberExtendsKt.getDp((Number) 28));
            recyclerView.setClipToPadding(false);
            recyclerView.setClipChildren(false);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(AppHolder.getAppTheme().getContentBackgroundColor());
            gradientDrawable.setCornerRadii(new float[]{NumberExtendsKt.getDpf((Number) 8), NumberExtendsKt.getDpf((Number) 8), NumberExtendsKt.getDpf((Number) 8), NumberExtendsKt.getDpf((Number) 8), 0.0f, 0.0f, 0.0f, 0.0f});
            Unit unit = Unit.INSTANCE;
            recyclerView.setBackground(gradientDrawable);
            recyclerView.setAdapter(new GoodsContentHolder$showCategoryDialog$2(this, activity, categoryRows, objectRef, intRef, feedGoods, DialogUtil.showBottomSheetDialog$default(DialogUtil.INSTANCE, getActivity(), recyclerView, true, false, 8, null)));
            recyclerView.post(new GoodsContentHolder$showCategoryDialog$3(recyclerView));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feedv8/GoodsContentHolder$SimpleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoodsContentHolder.kt */
    public static final class SimpleViewHolder extends RecyclerView.ViewHolder {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SimpleViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }
}
