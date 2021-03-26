package com.coolapk.market.viewholder;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemTitleViewBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.AppPictureSizeManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.cardlist.divider.ViewMarginData;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 02\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0014J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\rH\u0002J\b\u0010\u0018\u001a\u00020\rH\u0002J\b\u0010\u0019\u001a\u00020\rH\u0002J\b\u0010\u001a\u001a\u00020\rH\u0002J\u0012\u0010\u001b\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 J\f\u0010!\u001a\u00020\u001d*\u00020\u0003H\u0002J\u0018\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0#*\u00020\u0003H\u0002J\f\u0010$\u001a\u00020\u001d*\u00020\u0003H\u0002J\u0014\u0010%\u001a\u00020 *\u00020\u00032\u0006\u0010&\u001a\u00020 H\u0002J\u0014\u0010'\u001a\u00020 *\u00020\u00032\u0006\u0010&\u001a\u00020 H\u0002J\f\u0010(\u001a\u00020 *\u00020\u0003H\u0002J\f\u0010)\u001a\u00020\u001d*\u00020\u0003H\u0002J\f\u0010*\u001a\u00020\u001d*\u00020\u0003H\u0002J\f\u0010+\u001a\u00020,*\u00020\u0003H\u0002J\f\u0010-\u001a\u00020,*\u00020\u0003H\u0002J\f\u0010.\u001a\u00020,*\u00020\u0003H\u0002J\f\u0010/\u001a\u00020,*\u00020\u0003H\u0002R\u001a\u0010\u0005\u001a\u00020\u0003X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/coolapk/market/viewholder/TitleViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemTitleViewBinding;", "Lcom/coolapk/market/model/Entity;", "()V", "card", "getCard", "()Lcom/coolapk/market/model/Entity;", "setCard", "(Lcom/coolapk/market/model/Entity;)V", "viewHolder", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "onBindToContent", "", "data", "onClick", "v", "Landroid/view/View;", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "populateBottomTextAndPic", "populateDivider", "populateTitlePic", "populateTitleText", "setMoreViewText", "titleText", "", "updateWithCardStyle", "cardStyle", "", "getBottomPic", "getCardContainerPadding", "Lkotlin/Pair;", "getCardTitleDividerColor", "getCardTitleMarginBottom", "default", "getCardTitleMarginLeft", "getCardTitleSize", "getCardTitleStyle", "getTitlePic", "hasCardMoreDivider", "", "hasCardTitleDivider", "isCardTitleSmall", "isTitleLeft", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TitleViewPart.kt */
public final class TitleViewPart extends BindingViewPart<ItemTitleViewBinding, Entity> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558965;
    public Entity card;
    private BindingViewHolder viewHolder;

    @JvmStatic
    public static final TitleViewPart newInstance(View view, BindingViewHolder bindingViewHolder) {
        return Companion.newInstance(view, bindingViewHolder);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/viewholder/TitleViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "newInstance", "Lcom/coolapk/market/viewholder/TitleViewPart;", "viewToWrap", "Landroid/view/View;", "viewHolder", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TitleViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final TitleViewPart newInstance(View view, BindingViewHolder bindingViewHolder) {
            Intrinsics.checkNotNullParameter(view, "viewToWrap");
            TitleViewPart titleViewPart = new TitleViewPart();
            ViewParent parent = view.getParent();
            Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            LayoutInflater from = LayoutInflater.from(view.getContext());
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(viewToWrap.context)");
            titleViewPart.createView(from, (ViewGroup) parent);
            titleViewPart.viewHolder = bindingViewHolder;
            ViewUtil.replaceView(view, titleViewPart.getView());
            ViewUtil.replaceView(((ItemTitleViewBinding) titleViewPart.getBinding()).spaceView, view);
            ItemTitleViewBinding itemTitleViewBinding = (ItemTitleViewBinding) titleViewPart.getBinding();
            FrameLayout frameLayout = itemTitleViewBinding.moreView;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "moreView");
            TitleViewPart titleViewPart2 = titleViewPart;
            ViewUtil.clickListener(frameLayout, titleViewPart2);
            FrameLayout frameLayout2 = itemTitleViewBinding.bottomView;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "bottomView");
            ViewUtil.clickListener(frameLayout2, titleViewPart2);
            FrameLayout frameLayout3 = itemTitleViewBinding.bottomView;
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "bottomView");
            frameLayout3.setId(2131362982);
            return titleViewPart;
        }
    }

    public final Entity getCard() {
        Entity entity = this.card;
        if (entity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        return entity;
    }

    public final void setCard(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "<set-?>");
        this.card = entity;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemTitleViewBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558965, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…OUT_ID, viewGroup, false)");
        return (ItemTitleViewBinding) inflate;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0115  */
    public void onBindToContent(Entity entity) {
        Entity entity2;
        Intrinsics.checkNotNullParameter(entity, "data");
        super.onBindToContent((TitleViewPart) entity);
        this.card = entity;
        populateDivider();
        Entity entity3 = this.card;
        if (entity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        String titlePic = getTitlePic(entity3);
        boolean z = true;
        if (titlePic.length() == 0) {
            Entity entity4 = this.card;
            if (entity4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("card");
            }
            String title = entity4.getTitle();
            if (title == null || title.length() == 0) {
                Entity entity5 = this.card;
                if (entity5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("card");
                }
                String description = entity5.getDescription();
                if (description == null || description.length() == 0) {
                    FrameLayout frameLayout = ((ItemTitleViewBinding) getBinding()).moreView;
                    Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.moreView");
                    frameLayout.setVisibility(8);
                    FrameLayout frameLayout2 = ((ItemTitleViewBinding) getBinding()).bottomView;
                    Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.bottomView");
                    frameLayout2.setVisibility(8);
                    return;
                }
            }
        }
        Entity entity6 = this.card;
        if (entity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        String title2 = entity6.getTitle();
        if (title2 == null || title2.length() == 0) {
            if (titlePic.length() == 0) {
                FrameLayout frameLayout3 = ((ItemTitleViewBinding) getBinding()).moreView;
                Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.moreView");
                frameLayout3.setVisibility(8);
                entity2 = this.card;
                if (entity2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("card");
                }
                String url = entity2.getUrl();
                if (!(url == null || url.length() == 0)) {
                    z = false;
                }
                if (z) {
                    Entity entity7 = this.card;
                    if (entity7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("card");
                    }
                    String stringExtraData = EntityExtendsKt.getStringExtraData(entity7, "cardMoreAlign", "right");
                    FrameLayout.LayoutParams layoutParams = null;
                    switch (stringExtraData.hashCode()) {
                        case -1682792238:
                            if (stringExtraData.equals("bottomLeft")) {
                                ImageView imageView = ((ItemTitleViewBinding) getBinding()).enterView;
                                Intrinsics.checkNotNullExpressionValue(imageView, "binding.enterView");
                                imageView.setVisibility(8);
                                FrameLayout frameLayout4 = ((ItemTitleViewBinding) getBinding()).bottomView;
                                Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.bottomView");
                                frameLayout4.setVisibility(0);
                                populateBottomTextAndPic();
                                LinearLayout linearLayout = ((ItemTitleViewBinding) getBinding()).bottomTitleContainer;
                                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.bottomTitleContainer");
                                ViewGroup.LayoutParams layoutParams2 = linearLayout.getLayoutParams();
                                if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                                    layoutParams = layoutParams2;
                                }
                                FrameLayout.LayoutParams layoutParams3 = layoutParams;
                                if (layoutParams3 != null) {
                                    layoutParams3.gravity = 3;
                                    break;
                                }
                            }
                            ImageView imageView2 = ((ItemTitleViewBinding) getBinding()).enterView;
                            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.enterView");
                            imageView2.setVisibility(0);
                            FrameLayout frameLayout5 = ((ItemTitleViewBinding) getBinding()).bottomView;
                            Intrinsics.checkNotNullExpressionValue(frameLayout5, "binding.bottomView");
                            frameLayout5.setVisibility(8);
                            break;
                        case -1383228885:
                            if (stringExtraData.equals("bottom")) {
                                ImageView imageView3 = ((ItemTitleViewBinding) getBinding()).enterView;
                                Intrinsics.checkNotNullExpressionValue(imageView3, "binding.enterView");
                                imageView3.setVisibility(8);
                                FrameLayout frameLayout6 = ((ItemTitleViewBinding) getBinding()).bottomView;
                                Intrinsics.checkNotNullExpressionValue(frameLayout6, "binding.bottomView");
                                frameLayout6.setVisibility(0);
                                populateBottomTextAndPic();
                                LinearLayout linearLayout2 = ((ItemTitleViewBinding) getBinding()).bottomTitleContainer;
                                Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.bottomTitleContainer");
                                ViewGroup.LayoutParams layoutParams4 = linearLayout2.getLayoutParams();
                                if (layoutParams4 instanceof FrameLayout.LayoutParams) {
                                    layoutParams = layoutParams4;
                                }
                                FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) layoutParams;
                                if (layoutParams5 != null) {
                                    layoutParams5.gravity = 17;
                                    break;
                                }
                            }
                            ImageView imageView2 = ((ItemTitleViewBinding) getBinding()).enterView;
                            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.enterView");
                            imageView2.setVisibility(0);
                            FrameLayout frameLayout5 = ((ItemTitleViewBinding) getBinding()).bottomView;
                            Intrinsics.checkNotNullExpressionValue(frameLayout5, "binding.bottomView");
                            frameLayout5.setVisibility(8);
                            break;
                        case -621290831:
                            if (stringExtraData.equals("bottomRight")) {
                                ImageView imageView4 = ((ItemTitleViewBinding) getBinding()).enterView;
                                Intrinsics.checkNotNullExpressionValue(imageView4, "binding.enterView");
                                imageView4.setVisibility(8);
                                FrameLayout frameLayout7 = ((ItemTitleViewBinding) getBinding()).bottomView;
                                Intrinsics.checkNotNullExpressionValue(frameLayout7, "binding.bottomView");
                                frameLayout7.setVisibility(0);
                                populateBottomTextAndPic();
                                LinearLayout linearLayout3 = ((ItemTitleViewBinding) getBinding()).bottomTitleContainer;
                                Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.bottomTitleContainer");
                                ViewGroup.LayoutParams layoutParams6 = linearLayout3.getLayoutParams();
                                if (layoutParams6 instanceof FrameLayout.LayoutParams) {
                                    layoutParams = layoutParams6;
                                }
                                FrameLayout.LayoutParams layoutParams7 = (FrameLayout.LayoutParams) layoutParams;
                                if (layoutParams7 != null) {
                                    layoutParams7.gravity = 5;
                                    break;
                                }
                            }
                            ImageView imageView2 = ((ItemTitleViewBinding) getBinding()).enterView;
                            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.enterView");
                            imageView2.setVisibility(0);
                            FrameLayout frameLayout5 = ((ItemTitleViewBinding) getBinding()).bottomView;
                            Intrinsics.checkNotNullExpressionValue(frameLayout5, "binding.bottomView");
                            frameLayout5.setVisibility(8);
                            break;
                        case 3178655:
                            if (stringExtraData.equals("gone")) {
                                ImageView imageView5 = ((ItemTitleViewBinding) getBinding()).enterView;
                                Intrinsics.checkNotNullExpressionValue(imageView5, "binding.enterView");
                                imageView5.setVisibility(8);
                                FrameLayout frameLayout8 = ((ItemTitleViewBinding) getBinding()).bottomView;
                                Intrinsics.checkNotNullExpressionValue(frameLayout8, "binding.bottomView");
                                frameLayout8.setVisibility(8);
                                break;
                            }
                            ImageView imageView2 = ((ItemTitleViewBinding) getBinding()).enterView;
                            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.enterView");
                            imageView2.setVisibility(0);
                            FrameLayout frameLayout5 = ((ItemTitleViewBinding) getBinding()).bottomView;
                            Intrinsics.checkNotNullExpressionValue(frameLayout5, "binding.bottomView");
                            frameLayout5.setVisibility(8);
                            break;
                        default:
                            ImageView imageView2 = ((ItemTitleViewBinding) getBinding()).enterView;
                            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.enterView");
                            imageView2.setVisibility(0);
                            FrameLayout frameLayout5 = ((ItemTitleViewBinding) getBinding()).bottomView;
                            Intrinsics.checkNotNullExpressionValue(frameLayout5, "binding.bottomView");
                            frameLayout5.setVisibility(8);
                            break;
                    }
                } else {
                    ImageView imageView6 = ((ItemTitleViewBinding) getBinding()).enterView;
                    Intrinsics.checkNotNullExpressionValue(imageView6, "binding.enterView");
                    imageView6.setVisibility(8);
                    FrameLayout frameLayout9 = ((ItemTitleViewBinding) getBinding()).bottomView;
                    Intrinsics.checkNotNullExpressionValue(frameLayout9, "binding.bottomView");
                    frameLayout9.setVisibility(8);
                }
                setMoreViewText(entity.getSubTitle());
            }
        }
        FrameLayout frameLayout10 = ((ItemTitleViewBinding) getBinding()).moreView;
        Intrinsics.checkNotNullExpressionValue(frameLayout10, "binding.moreView");
        frameLayout10.setVisibility(0);
        TextView textView = ((ItemTitleViewBinding) getBinding()).moreTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.moreTextView");
        textView.setVisibility(8);
        populateTitleText();
        populateTitlePic();
        entity2 = this.card;
        if (entity2 == null) {
        }
        String url = entity2.getUrl();
        z = false;
        if (z) {
        }
        setMoreViewText(entity.getSubTitle());
    }

    private final void setMoreViewText(String str) {
        TextView textView = ((ItemTitleViewBinding) getBinding()).moreTextView;
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01af, code lost:
        if (r0.equals("BOLD_ITALIC") != false) goto L_0x01bd;
     */
    private final void populateTitleText() {
        TextView textView = ((ItemTitleViewBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        Entity entity = this.card;
        if (entity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        textView.setText(entity.getTitle());
        Entity entity2 = this.card;
        if (entity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        int i = 3;
        FrameLayout.LayoutParams layoutParams = null;
        if (isTitleLeft(entity2)) {
            LinearLayout linearLayout = ((ItemTitleViewBinding) getBinding()).titleContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.titleContainer");
            ViewGroup.LayoutParams layoutParams2 = linearLayout.getLayoutParams();
            if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                layoutParams = layoutParams2;
            }
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams;
            if (layoutParams3 != null) {
                layoutParams3.gravity = 3;
                layoutParams3.height = -2;
                layoutParams3.rightMargin = NumberExtendsKt.getDp((Number) 36);
            }
            FrameLayout frameLayout = ((ItemTitleViewBinding) getBinding()).moreView;
            frameLayout.setPadding(frameLayout.getPaddingLeft(), DisplayUtils.dp2px(frameLayout.getContext(), 10.0f), DisplayUtils.dp2px(frameLayout.getContext(), 12.0f), DisplayUtils.dp2px(frameLayout.getContext(), 2.0f));
            Entity entity3 = this.card;
            if (entity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("card");
            }
            if (isCardTitleSmall(entity3)) {
                TextView textView2 = ((ItemTitleViewBinding) getBinding()).titleView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
                textView2.setTextSize(14.0f);
                LinearLayout linearLayout2 = ((ItemTitleViewBinding) getBinding()).titleContainer;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.titleContainer");
                linearLayout2.getLayoutParams().height = NumberExtendsKt.getDp((Number) 18);
            } else {
                TextView textView3 = ((ItemTitleViewBinding) getBinding()).titleView;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.titleView");
                textView3.setTextSize(16.0f);
            }
        } else {
            LinearLayout linearLayout3 = ((ItemTitleViewBinding) getBinding()).titleContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.titleContainer");
            ViewGroup.LayoutParams layoutParams4 = linearLayout3.getLayoutParams();
            if (layoutParams4 instanceof FrameLayout.LayoutParams) {
                layoutParams = layoutParams4;
            }
            FrameLayout.LayoutParams layoutParams5 = layoutParams;
            if (layoutParams5 != null) {
                layoutParams5.gravity = 17;
                layoutParams5.height = -2;
                layoutParams5.rightMargin = 0;
            }
            FrameLayout frameLayout2 = ((ItemTitleViewBinding) getBinding()).moreView;
            frameLayout2.setPadding(frameLayout2.getPaddingLeft(), DisplayUtils.dp2px(frameLayout2.getContext(), 16.0f), DisplayUtils.dp2px(frameLayout2.getContext(), 16.0f), DisplayUtils.dp2px(frameLayout2.getContext(), 8.0f));
            TextView textView4 = ((ItemTitleViewBinding) getBinding()).titleView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.titleView");
            textView4.setTextSize(18.0f);
        }
        Entity entity4 = this.card;
        if (entity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        int cardTitleSize = getCardTitleSize(entity4);
        if (cardTitleSize > 0) {
            TextView textView5 = ((ItemTitleViewBinding) getBinding()).titleView;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.titleView");
            textView5.setTextSize((float) cardTitleSize);
        }
        Entity entity5 = this.card;
        if (entity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        String cardTitleStyle = getCardTitleStyle(entity5);
        Objects.requireNonNull(cardTitleStyle, "null cannot be cast to non-null type java.lang.String");
        String upperCase = cardTitleStyle.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
        if (upperCase.length() > 0) {
            TextView textView6 = ((ItemTitleViewBinding) getBinding()).titleView;
            TextView textView7 = ((ItemTitleViewBinding) getBinding()).titleView;
            Intrinsics.checkNotNullExpressionValue(textView7, "binding.titleView");
            Typeface typeface = textView7.getTypeface();
            int hashCode = upperCase.hashCode();
            if (hashCode != -2125451728) {
                if (hashCode != -2071918294) {
                    if (hashCode == 2044549 && upperCase.equals("BOLD")) {
                        i = 1;
                        textView6.setTypeface(typeface, i);
                    }
                }
            } else if (upperCase.equals("ITALIC")) {
                i = 2;
                textView6.setTypeface(typeface, i);
            }
            i = 0;
            textView6.setTypeface(typeface, i);
        }
    }

    private final void populateTitlePic() {
        Entity entity = this.card;
        if (entity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        String titlePic = getTitlePic(entity);
        if (titlePic.length() == 0) {
            ImageView imageView = ((ItemTitleViewBinding) getBinding()).imageView;
            imageView.setVisibility(8);
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.imageView.apply …= View.GONE\n            }");
            return;
        }
        AppPictureSizeManager.PictureSize size = AppPictureSizeManager.getInstance().getSize(titlePic);
        if (size != null) {
            ImageView imageView2 = ((ItemTitleViewBinding) getBinding()).imageView;
            imageView2.getLayoutParams().width = (int) ((((float) size.getWidth()) / ((float) size.getHeight())) * ((float) imageView2.getLayoutParams().height));
            imageView2.requestLayout();
        } else {
            ImageView imageView3 = ((ItemTitleViewBinding) getBinding()).imageView;
            imageView3.getLayoutParams().width = -2;
            imageView3.requestLayout();
        }
        ImageView imageView4 = ((ItemTitleViewBinding) getBinding()).imageView;
        imageView4.setColorFilter(AppHolder.getAppTheme().getColorAccent());
        imageView4.setVisibility(0);
        AppHolder.getContextImageLoader().displayImage(getContext(), titlePic, ((ItemTitleViewBinding) getBinding()).imageView);
    }

    private final void populateDivider() {
        Integer stringToColor;
        View view = ((ItemTitleViewBinding) getBinding()).topDivider;
        Intrinsics.checkNotNullExpressionValue(view, "binding.topDivider");
        view.setVisibility(8);
        View view2 = ((ItemTitleViewBinding) getBinding()).bottomDivider;
        Intrinsics.checkNotNullExpressionValue(view2, "binding.bottomDivider");
        view2.setVisibility(8);
        Entity entity = this.card;
        if (entity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        Pair<Integer, Integer> cardContainerPadding = getCardContainerPadding(entity);
        int intValue = cardContainerPadding.component1().intValue();
        int intValue2 = cardContainerPadding.component2().intValue();
        View view3 = ((ItemTitleViewBinding) getBinding()).topDivider;
        Intrinsics.checkNotNullExpressionValue(view3, "binding.topDivider");
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams2 != null) {
            marginLayoutParams2.bottomMargin = ConvertUtils.dp2px((float) intValue);
        }
        View view4 = ((ItemTitleViewBinding) getBinding()).bottomDivider;
        Intrinsics.checkNotNullExpressionValue(view4, "binding.bottomDivider");
        ViewGroup.LayoutParams layoutParams2 = view4.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = layoutParams2;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams3 = marginLayoutParams;
        if (marginLayoutParams3 != null) {
            marginLayoutParams3.topMargin = ConvertUtils.dp2px((float) intValue2);
        }
        Entity entity2 = this.card;
        if (entity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        boolean z = false;
        if (hasCardTitleDivider(entity2)) {
            View view5 = ((ItemTitleViewBinding) getBinding()).topDivider;
            Intrinsics.checkNotNullExpressionValue(view5, "binding.topDivider");
            view5.setVisibility(0);
        }
        Entity entity3 = this.card;
        if (entity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        if (hasCardMoreDivider(entity3)) {
            View view6 = ((ItemTitleViewBinding) getBinding()).bottomDivider;
            Intrinsics.checkNotNullExpressionValue(view6, "binding.bottomDivider");
            view6.setVisibility(0);
        }
        Entity entity4 = this.card;
        if (entity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        String cardTitleDividerColor = getCardTitleDividerColor(entity4);
        if (cardTitleDividerColor.length() > 0) {
            z = true;
        }
        if (z && (stringToColor = ColorUtils.stringToColor(cardTitleDividerColor)) != null) {
            View view7 = ((ItemTitleViewBinding) getBinding()).topDivider;
            Intrinsics.checkNotNullExpressionValue(stringToColor, "it");
            view7.setBackgroundColor(stringToColor.intValue());
            ((ItemTitleViewBinding) getBinding()).bottomDivider.setBackgroundColor(stringToColor.intValue());
        }
    }

    private final void populateBottomTextAndPic() {
        String str;
        Entity entity = this.card;
        if (entity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        String description = entity.getDescription();
        boolean z = true;
        int i = 0;
        if (description == null || description.length() == 0) {
            str = getContext().getString(2131887210);
        } else {
            Entity entity2 = this.card;
            if (entity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("card");
            }
            str = entity2.getDescription();
        }
        TextView textView = ((ItemTitleViewBinding) getBinding()).bottomTitleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.bottomTitleView");
        textView.setText(str);
        ImageView imageView = ((ItemTitleViewBinding) getBinding()).bottomImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.bottomImageView");
        imageView.setVisibility(8);
        Entity entity3 = this.card;
        if (entity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        String bottomPic = getBottomPic(entity3);
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        if (StringsKt.startsWith$default(bottomPic, "http", false, 2, (Object) null)) {
            AppPictureSizeManager.PictureSize size = AppPictureSizeManager.getInstance().getSize(bottomPic);
            if (size != null) {
                ImageView imageView2 = ((ItemTitleViewBinding) getBinding()).bottomImageView;
                imageView2.getLayoutParams().width = size.getWidth();
                imageView2.requestLayout();
            }
            ImageView imageView3 = ((ItemTitleViewBinding) getBinding()).bottomImageView;
            imageView3.setColorFilter(AppHolder.getAppTheme().getColorAccent());
            imageView3.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = imageView3.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = layoutParams;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
            if (marginLayoutParams2 != null) {
                Entity entity4 = this.card;
                if (entity4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("card");
                }
                String title = entity4.getTitle();
                if (!(title == null || title.length() == 0)) {
                    z = false;
                }
                int dp2px = ConvertUtils.dp2px(12.0f);
                if (!z) {
                    i = dp2px;
                }
                marginLayoutParams2.rightMargin = i;
            }
            AppHolder.getContextImageLoader().displayImage(getContext(), bottomPic, ((ItemTitleViewBinding) getBinding()).bottomImageView);
            return;
        }
        int identifier = getContext().getResources().getIdentifier(bottomPic, "drawable", getContext().getPackageName());
        if (identifier == 0) {
            identifier = getContext().getResources().getIdentifier(bottomPic, "mipmap", getContext().getPackageName());
        }
        if (identifier != 0) {
            ImageView imageView4 = ((ItemTitleViewBinding) getBinding()).bottomImageView;
            imageView4.setImageResource(identifier);
            imageView4.setColorFilter(AppHolder.getAppTheme().getColorAccent());
            imageView4.setVisibility(0);
        }
    }

    private final int getCardTitleMarginBottom(Entity entity, int i) {
        return EntityExtendsKt.getIntExtraData(entity, "cardTitleMarginBottom", i);
    }

    private final int getCardTitleMarginLeft(Entity entity, int i) {
        return EntityExtendsKt.getIntExtraData(entity, "cardTitleMarginLeft", i);
    }

    private final String getCardTitleDividerColor(Entity entity) {
        return EntityExtendsKt.getStringExtraData(entity, "cardTitleDividerColor", "");
    }

    private final int getCardTitleSize(Entity entity) {
        return EntityExtendsKt.getIntExtraData(entity, "cardTitleSize", 0);
    }

    private final String getCardTitleStyle(Entity entity) {
        return EntityExtendsKt.getStringExtraData(entity, "cardTitleStyle", "BOLD");
    }

    private final boolean isTitleLeft(Entity entity) {
        return EntityExtendsKt.getIntExtraData(entity, "cardTitleAlign", 0) != 1;
    }

    private final boolean isCardTitleSmall(Entity entity) {
        return EntityExtendsKt.getIntExtraData(entity, "cardTitleSmall", 0) == 1;
    }

    private final String getTitlePic(Entity entity) {
        return EntityExtendsKt.getStringExtraData(entity, "cardTitlePic", "");
    }

    private final String getBottomPic(Entity entity) {
        return EntityExtendsKt.getStringExtraData(entity, "cardMorePic", "");
    }

    private final boolean hasCardTitleDivider(Entity entity) {
        return EntityExtendsKt.getIntExtraData(entity, "cardTitleDivider", 0) == 1;
    }

    private final boolean hasCardMoreDivider(Entity entity) {
        return EntityExtendsKt.getIntExtraData(entity, "cardMoreDivider", 0) == 1;
    }

    private final Pair<Integer, Integer> getCardContainerPadding(Entity entity) {
        List split$default = StringsKt.split$default((CharSequence) EntityExtendsKt.getStringExtraData(entity, "cardContainerPadding", ""), new String[]{":"}, false, 0, 6, (Object) null);
        if (!(split$default.size() == 2)) {
            split$default = null;
        }
        if (split$default == null) {
            return new Pair<>(0, 0);
        }
        try {
            return new Pair<>(Integer.valueOf(Integer.parseInt((String) split$default.get(0))), Integer.valueOf(Integer.parseInt((String) split$default.get(1))));
        } catch (Exception unused) {
            return new Pair<>(0, 0);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0090  */
    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        Entity entity;
        BindingViewHolder bindingViewHolder;
        Intrinsics.checkNotNullParameter(view, "v");
        super.onClick(view);
        if (view.getId() == 2131362982) {
            Context context = getView().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            Entity entity2 = this.card;
            if (entity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("card");
            }
            String url = entity2.getUrl();
            Entity entity3 = this.card;
            if (entity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("card");
            }
            String title = entity3.getTitle();
            Entity entity4 = this.card;
            if (entity4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("card");
            }
            ActionManagerCompat.startActivityByUrl(context, url, title, entity4.getSubTitle());
            StatisticHelper instance = StatisticHelper.Companion.getInstance();
            BindingViewHolder bindingViewHolder2 = this.viewHolder;
            int i = null;
            if (bindingViewHolder2 != null) {
                DataBindingComponent component = bindingViewHolder2.getComponent();
                if (!(component instanceof FragmentBindingComponent)) {
                    component = null;
                }
                FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
                Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
                if (!(fragment instanceof BaseFragment)) {
                    fragment = null;
                }
                BaseFragment baseFragment = (BaseFragment) fragment;
                if (baseFragment != null) {
                    str = baseFragment.getFixedRecordId();
                    entity = this.card;
                    if (entity == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("card");
                    }
                    bindingViewHolder = this.viewHolder;
                    if (bindingViewHolder != null) {
                        i = Integer.valueOf(bindingViewHolder.getAdapterPosition());
                    }
                    if (i == null) {
                        i = -1;
                    }
                    StatisticHelper.recordEntityEvent$default(instance, str, entity, i.intValue(), null, null, 24, null);
                }
            }
            str = null;
            entity = this.card;
            if (entity == null) {
            }
            bindingViewHolder = this.viewHolder;
            if (bindingViewHolder != null) {
            }
            if (i == null) {
            }
            StatisticHelper.recordEntityEvent$default(instance, str, entity, i.intValue(), null, null, 24, null);
        }
    }

    public final void updateWithCardStyle(int i) {
        FrameLayout frameLayout = ((ItemTitleViewBinding) getBinding()).moreView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.moreView");
        if (!(frameLayout.getVisibility() == 0) || i != 1) {
            FrameLayout frameLayout2 = ((ItemTitleViewBinding) getBinding()).moreView;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.moreView");
            FrameLayout frameLayout3 = frameLayout2;
            ViewGroup.LayoutParams layoutParams = frameLayout3.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
            Entity entity = this.card;
            if (entity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("card");
            }
            marginLayoutParams2.bottomMargin = NumberExtendsKt.getDp(Integer.valueOf(getCardTitleMarginBottom(entity, 0)));
            Entity entity2 = this.card;
            if (entity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("card");
            }
            marginLayoutParams2.leftMargin = NumberExtendsKt.getDp(Integer.valueOf(getCardTitleMarginLeft(entity2, 0)));
            frameLayout3.setLayoutParams(marginLayoutParams);
            return;
        }
        FrameLayout frameLayout4 = ((ItemTitleViewBinding) getBinding()).moreView;
        Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.moreView");
        FrameLayout frameLayout5 = frameLayout4;
        ViewGroup.LayoutParams layoutParams2 = frameLayout5.getLayoutParams();
        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams2;
        ViewGroup.MarginLayoutParams marginLayoutParams4 = marginLayoutParams3;
        Entity entity3 = this.card;
        if (entity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        marginLayoutParams4.bottomMargin = NumberExtendsKt.getDp(Integer.valueOf(getCardTitleMarginBottom(entity3, 8)));
        Entity entity4 = this.card;
        if (entity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        marginLayoutParams4.leftMargin = NumberExtendsKt.getDp(Integer.valueOf(getCardTitleMarginLeft(entity4, ViewMarginData.Companion.getDEFAULT_SIZE_RAW())));
        frameLayout5.setLayoutParams(marginLayoutParams3);
    }
}
