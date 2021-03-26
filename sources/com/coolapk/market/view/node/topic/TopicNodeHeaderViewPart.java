package com.coolapk.market.view.node.topic;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.coolapk.market.databinding.TopicNodeHeaderBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideRequest;
import com.coolapk.market.imageloader.PaletteBitmap;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.NewHeadLine;
import com.coolapk.market.model.RelatedData;
import com.coolapk.market.model.Topic;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.ShapeExtends;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.node.BitmapSizeTransformation;
import com.coolapk.market.view.node.NodeHelper;
import com.coolapk.market.view.node.NodePaletteBackgroundTarget;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import com.coolapk.market.widget.LinearAdapterLayout;
import com.coolapk.market.widget.view.IndicatorView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import com.coolapk.market.widget.viewpart.TripleAvatarViewPart;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0003H\u0002J(\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00032\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00180\u001fJ\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0003H\u0014J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$H\u0016J\u001a\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\b\u0010*\u001a\u00020\u0018H\u0014J\u0006\u0010+\u001a\u00020\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006,"}, d2 = {"Lcom/coolapk/market/view/node/topic/TopicNodeHeaderViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/TopicNodeHeaderBinding;", "Lcom/coolapk/market/model/Topic;", "activity", "Landroid/app/Activity;", "viewModel", "Lcom/coolapk/market/view/node/topic/TopicVXViewModel;", "presenter", "Lcom/coolapk/market/view/node/topic/TopicVXPresenter;", "(Landroid/app/Activity;Lcom/coolapk/market/view/node/topic/TopicVXViewModel;Lcom/coolapk/market/view/node/topic/TopicVXPresenter;)V", "getActivity", "()Landroid/app/Activity;", "getPresenter", "()Lcom/coolapk/market/view/node/topic/TopicVXPresenter;", "tripleViewPart", "Lcom/coolapk/market/widget/viewpart/TripleAvatarViewPart;", "getTripleViewPart", "()Lcom/coolapk/market/widget/viewpart/TripleAvatarViewPart;", "tripleViewPart$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/coolapk/market/view/node/topic/TopicVXViewModel;", "applyWindowsInset", "", "rect", "Landroid/graphics/Rect;", "loadDescription", "data", "loadLogoAndBG", "callback", "Lkotlin/Function2;", "", "onBindToContent", "onClick", "v", "Landroid/view/View;", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "updateFollowState", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TopicNodeHeaderViewPart.kt */
public final class TopicNodeHeaderViewPart extends BindingViewPart<TopicNodeHeaderBinding, Topic> {
    private final Activity activity;
    private final TopicVXPresenter presenter;
    private final Lazy tripleViewPart$delegate = LazyKt.lazy(new TopicNodeHeaderViewPart$tripleViewPart$2(this));
    private final TopicVXViewModel viewModel;

    private final TripleAvatarViewPart getTripleViewPart() {
        return (TripleAvatarViewPart) this.tripleViewPart$delegate.getValue();
    }

    public TopicNodeHeaderViewPart(Activity activity2, TopicVXViewModel topicVXViewModel, TopicVXPresenter topicVXPresenter) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(topicVXViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(topicVXPresenter, "presenter");
        this.activity = activity2;
        this.viewModel = topicVXViewModel;
        this.presenter = topicVXPresenter;
        topicVXViewModel.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback(this) {
            /* class com.coolapk.market.view.node.topic.TopicNodeHeaderViewPart.AnonymousClass1 */
            final /* synthetic */ TopicNodeHeaderViewPart this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                if (i == 122) {
                    this.this$0.updateFollowState();
                }
            }
        });
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final TopicVXPresenter getPresenter() {
        return this.presenter;
    }

    public final TopicVXViewModel getViewModel() {
        return this.viewModel;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public TopicNodeHeaderBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131559210, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…header, viewGroup, false)");
        return (TopicNodeHeaderBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        ((TopicNodeHeaderBinding) getBinding()).setClick(this);
        TextView textView = ((TopicNodeHeaderBinding) getBinding()).actionView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.actionView");
        textView.setBackground(ShapeExtends.INSTANCE.createNodeCapsuleActionBackground(this.activity, (float) NumberExtendsKt.getDp((Number) 14)));
        ((TopicNodeHeaderBinding) getBinding()).actionView.setTextColor(ShapeExtends.INSTANCE.createNodeActionTextColors(this.activity));
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0069: APUT  (r0v10 java.lang.String[]), (0 ??[int, short, byte, char]), (r1v2 java.lang.String) */
    /* access modifiers changed from: protected */
    public void onBindToContent(Topic topic) {
        List mutableListOf;
        Intrinsics.checkNotNullParameter(topic, "data");
        super.onBindToContent((TopicNodeHeaderViewPart) topic);
        Topic model = ((TopicNodeHeaderBinding) getBinding()).getModel();
        if (model == null || (!Intrinsics.areEqual(model.getId(), topic.getId()))) {
            loadDescription(topic);
            NodeHelper nodeHelper = NodeHelper.INSTANCE;
            LinearAdapterLayout linearAdapterLayout = ((TopicNodeHeaderBinding) getBinding()).linearView;
            Intrinsics.checkNotNullExpressionValue(linearAdapterLayout, "binding.linearView");
            List<NewHeadLine> recommendRows = topic.getRecommendRows();
            Intrinsics.checkNotNullExpressionValue(recommendRows, "data.recommendRows");
            nodeHelper.setupRecommendRows(linearAdapterLayout, recommendRows);
            String cover = topic.getCover();
            if (cover == null || StringsKt.isBlank(cover)) {
                mutableListOf = CollectionsKt.emptyList();
            } else {
                String[] strArr = new String[1];
                String cover2 = topic.getCover();
                if (cover2 == null) {
                    cover2 = "";
                }
                strArr[0] = cover2;
                mutableListOf = CollectionsKt.mutableListOf(strArr);
            }
            NodeHelper nodeHelper2 = NodeHelper.INSTANCE;
            ViewPager viewPager = ((TopicNodeHeaderBinding) getBinding()).imageViewPager;
            Intrinsics.checkNotNullExpressionValue(viewPager, "binding.imageViewPager");
            IndicatorView indicatorView = ((TopicNodeHeaderBinding) getBinding()).indicatorView;
            Intrinsics.checkNotNullExpressionValue(indicatorView, "binding.indicatorView");
            NodeHelper.setupIndicatorAndViewPager$default(nodeHelper2, viewPager, indicatorView, mutableListOf, null, 8, null);
            updateFollowState();
            TextView textView = ((TopicNodeHeaderBinding) getBinding()).hotNumView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.hotNumView");
            textView.setText(KotlinExtendKt.toDisplayString(topic.getHotNum()) + "热度  " + KotlinExtendKt.toDisplayString(topic.getCommentNum()) + "讨论");
            TripleAvatarViewPart tripleViewPart = getTripleViewPart();
            List<RelatedData> recentFollowList = topic.getRecentFollowList();
            Intrinsics.checkNotNullExpressionValue(recentFollowList, "data.recentFollowList");
            List<RelatedData> list = recentFollowList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (T t : list) {
                Intrinsics.checkNotNullExpressionValue(t, "it");
                String userAvatar = t.getUserAvatar();
                if (userAvatar == null) {
                    userAvatar = "";
                }
                arrayList.add(userAvatar);
            }
            tripleViewPart.bindToContent(arrayList);
        }
        ((TopicNodeHeaderBinding) getBinding()).setModel(topic);
        ((TopicNodeHeaderBinding) getBinding()).executePendingBindings();
    }

    public final void applyWindowsInset(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Topic model = ((TopicNodeHeaderBinding) getBinding()).getModel();
        if (model != null) {
            Intrinsics.checkNotNullExpressionValue(model, "binding.model ?: return");
            MaxWidthFrameLayout maxWidthFrameLayout = ((TopicNodeHeaderBinding) getBinding()).coverViewContainer;
            String cover = model.getCover();
            if (!(cover == null || cover.length() == 0)) {
                MaxWidthFrameLayout maxWidthFrameLayout2 = maxWidthFrameLayout;
                ViewGroup.LayoutParams layoutParams = maxWidthFrameLayout2.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = NumberExtendsKt.getDp((Number) 203);
                    maxWidthFrameLayout2.setLayoutParams(layoutParams);
                    maxWidthFrameLayout2.setVisibility(0);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            MaxWidthFrameLayout maxWidthFrameLayout3 = maxWidthFrameLayout;
            ViewGroup.LayoutParams layoutParams2 = maxWidthFrameLayout3.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = UiUtils.getActionBarSize(maxWidthFrameLayout.getContext()) + rect.top;
                maxWidthFrameLayout3.setLayoutParams(layoutParams2);
                maxWidthFrameLayout3.setVisibility(4);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
    }

    public final void updateFollowState() {
        boolean followState = this.viewModel.getFollowState();
        TextView textView = ((TopicNodeHeaderBinding) getBinding()).actionView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.actionView");
        textView.setSelected(followState);
        if (followState) {
            ((TopicNodeHeaderBinding) getBinding()).actionView.setText(2131887204);
        } else {
            ((TopicNodeHeaderBinding) getBinding()).actionView.setText(2131887205);
        }
        TextView textView2 = ((TopicNodeHeaderBinding) getBinding()).followNumView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.followNumView");
        textView2.setText(KotlinExtendKt.toDisplayString(this.viewModel.getFollowCount()) + "关注");
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        super.onClick(view);
        int id = view.getId();
        if (id == 2131361982) {
            this.presenter.followTag(this.viewModel.getFollowState(), !this.viewModel.getFollowState());
        } else if (id == 2131362973) {
            Context context = getContext();
            String title = this.viewModel.getModel().getTitle();
            if (title == null) {
                title = "";
            }
            ActionManager.startTopicFollowerListActivity(context, title);
        }
    }

    /* JADX WARN: Type inference failed for: r1v18, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 2 */
    public final void loadLogoAndBG(Topic topic, Function2<? super Integer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(topic, "data");
        Intrinsics.checkNotNullParameter(function2, "callback");
        String logo = topic.getLogo();
        String str = logo;
        boolean z = false;
        if (str == null || str.length() == 0) {
            GlideApp.with(this.activity).load((Integer) 2131231628).into(((TopicNodeHeaderBinding) getBinding()).logoView);
        } else {
            GlideApp.with(this.activity).load(logo).placeholder(2131231628).diskCacheStrategy(DiskCacheStrategy.DATA).into(((TopicNodeHeaderBinding) getBinding()).logoView);
        }
        String cover = topic.getCover();
        String str2 = cover;
        if (!(!(str2 == null || str2.length() == 0))) {
            cover = null;
        }
        String str3 = cover;
        if (str3 == null || str3.length() == 0) {
            z = true;
        }
        TopicNodeHeaderViewPart$loadLogoAndBG$wrapCallback$1 topicNodeHeaderViewPart$loadLogoAndBG$wrapCallback$1 = new TopicNodeHeaderViewPart$loadLogoAndBG$wrapCallback$1(this, !z, function2);
        Integer stringToColor = ColorUtils.stringToColor(topic.getBgColor());
        if (stringToColor != null) {
            Pair<Integer, Integer> nodeColors = NodePaletteBackgroundTarget.Companion.getNodeColors(stringToColor.intValue());
            int intValue = nodeColors.component1().intValue();
            int intValue2 = nodeColors.component2().intValue();
            View view = ((TopicNodeHeaderBinding) getBinding()).backgroundTopView;
            Intrinsics.checkNotNullExpressionValue(view, "binding.backgroundTopView");
            view.setBackground(NodePaletteBackgroundTarget.Companion.createShapeDrawable(intValue, intValue2));
            topicNodeHeaderViewPart$loadLogoAndBG$wrapCallback$1.invoke((TopicNodeHeaderViewPart$loadLogoAndBG$wrapCallback$1) Integer.valueOf(intValue), Integer.valueOf(intValue2));
            return;
        }
        GlideRequest priority = GlideApp.with(this.activity).as(PaletteBitmap.class).load(logo).transform((Transformation<Bitmap>) new BitmapSizeTransformation(24, 24)).priority(Priority.IMMEDIATE);
        View view2 = ((TopicNodeHeaderBinding) getBinding()).backgroundTopView;
        Intrinsics.checkNotNullExpressionValue(view2, "binding.backgroundTopView");
        Intrinsics.checkNotNullExpressionValue(priority.into((GlideRequest) new NodePaletteBackgroundTarget(view2, ((TopicNodeHeaderBinding) getBinding()).backgroundBottomView, false, topicNodeHeaderViewPart$loadLogoAndBG$wrapCallback$1, 4, null)), "GlideApp.with(activity)\n…callback = wrapCallback))");
    }

    private final void loadDescription(Topic topic) {
        TextView textView = ((TopicNodeHeaderBinding) getBinding()).descriptionView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.descriptionView");
        String intro = topic.getIntro();
        if (intro == null) {
            intro = "";
        }
        textView.setText(intro);
        TextView textView2 = ((TopicNodeHeaderBinding) getBinding()).descriptionView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.descriptionView");
        TextView textView3 = textView2;
        String intro2 = topic.getIntro();
        int i = 0;
        if (intro2 == null || intro2.length() == 0) {
            i = 8;
        }
        textView3.setVisibility(i);
    }
}
