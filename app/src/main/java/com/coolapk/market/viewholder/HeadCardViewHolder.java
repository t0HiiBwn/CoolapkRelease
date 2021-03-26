package com.coolapk.market.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.ImageLoaderOptions;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemHeadCardBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.widget.view.ScalingImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0017J\b\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0002R\u000e\u0010\t\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/viewholder/HeadCardViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemHeadCardBinding;", "Lcom/coolapk/market/model/Entity;", "itemView", "Landroid/view/View;", "comp", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "entity", "bindToContent", "", "data", "doCoverAnim", "onClick", "view", "populateImage", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: HeadCardViewHolder.kt */
public final class HeadCardViewHolder extends GenericBindHolder<ItemHeadCardBinding, Entity> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558772;
    private Entity entity;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HeadCardViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "comp");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/HeadCardViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: HeadCardViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.GenericBindHolder
    public void bindToContent(Entity entity2) {
        Intrinsics.checkNotNullParameter(entity2, "data");
        this.entity = entity2;
        ItemHeadCardBinding itemHeadCardBinding = (ItemHeadCardBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemHeadCardBinding, "binding");
        itemHeadCardBinding.setClick(this);
        TextView textView = itemHeadCardBinding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText(entity2.getTitle());
        String subTitle = entity2.getSubTitle();
        boolean z = true;
        String str = "";
        String stringPlus = subTitle == null || subTitle.length() == 0 ? str : Intrinsics.stringPlus(entity2.getSubTitle(), " ");
        if (!(entity2.getDateline() == null)) {
            str = DateUtils.getTimeDescription(getContext(), entity2.getDateline());
        }
        String str2 = stringPlus + str;
        TextView textView2 = itemHeadCardBinding.timeView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.timeView");
        String str3 = str2;
        textView2.setText(str3);
        TextView textView3 = itemHeadCardBinding.timeView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.timeView");
        textView3.setVisibility(str3.length() == 0 ? 8 : 0);
        String pic = entity2.getPic();
        if (pic == null || pic.length() == 0) {
            itemHeadCardBinding.topImageView.setImageDrawable(null);
            FrameLayout frameLayout = itemHeadCardBinding.topImageViewContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.topImageViewContainer");
            frameLayout.setVisibility(8);
            View view = itemHeadCardBinding.dividerView;
            Intrinsics.checkNotNullExpressionValue(view, "binding.dividerView");
            view.setVisibility(0);
            itemHeadCardBinding.titleView.setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
            itemHeadCardBinding.timeView.setTextColor(AppHolder.getAppTheme().getTextColorSecondary());
        } else {
            FrameLayout frameLayout2 = itemHeadCardBinding.topImageViewContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.topImageViewContainer");
            frameLayout2.setVisibility(0);
            View view2 = itemHeadCardBinding.dividerView;
            Intrinsics.checkNotNullExpressionValue(view2, "binding.dividerView");
            view2.setVisibility(8);
            itemHeadCardBinding.titleView.setTextColor(-1);
            itemHeadCardBinding.timeView.setTextColor((int) 3439329279L);
        }
        LinearLayout linearLayout = itemHeadCardBinding.titleContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.titleContainer");
        ViewExtendsKt.measureWithScreenWidth$default(linearLayout, 0, 1, null);
        populateImage();
        String description = entity2.getDescription();
        if (!(description == null || description.length() == 0)) {
            z = false;
        }
        if (z) {
            View view3 = itemHeadCardBinding.dividerView;
            Intrinsics.checkNotNullExpressionValue(view3, "binding.dividerView");
            view3.setVisibility(8);
            TextView textView4 = itemHeadCardBinding.descriptionView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.descriptionView");
            textView4.setVisibility(8);
        } else {
            TextView textView5 = itemHeadCardBinding.descriptionView;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.descriptionView");
            textView5.setVisibility(0);
        }
        itemHeadCardBinding.setModel(entity2);
        itemHeadCardBinding.executePendingBindings();
    }

    private final void populateImage() {
        View view = ((ItemHeadCardBinding) getBinding()).coverViewMask;
        Intrinsics.checkNotNullExpressionValue(view, "binding.coverViewMask");
        view.setVisibility(8);
        FrameLayout frameLayout = ((ItemHeadCardBinding) getBinding()).topImageViewContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.topImageViewContainer");
        HeadCardViewHolder$populateImage$onImageLoadListener$1 headCardViewHolder$populateImage$onImageLoadListener$1 = null;
        frameLayout.setForeground(null);
        ScalingImageView scalingImageView = ((ItemHeadCardBinding) getBinding()).topImageView;
        Intrinsics.checkNotNullExpressionValue(scalingImageView, "binding.topImageView");
        scalingImageView.setVisibility(4);
        Entity entity2 = this.entity;
        if (entity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
        }
        DataBindingComponent component = getComponent();
        if (!(component instanceof FragmentBindingComponent)) {
            component = null;
        }
        FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
        Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
        Fragment fragment2 = !(fragment instanceof Fragment) ? null : fragment;
        if (fragment2 != null) {
            FrameLayout frameLayout2 = ((ItemHeadCardBinding) getBinding()).topImageViewContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.topImageViewContainer");
            ViewGroup.LayoutParams layoutParams = frameLayout2.getLayoutParams();
            String pic = entity2.getPic();
            if (pic == null || pic.length() == 0) {
                LinearLayout linearLayout = ((ItemHeadCardBinding) getBinding()).titleContainer;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.titleContainer");
                layoutParams.height = linearLayout.getMeasuredHeight();
                return;
            }
            layoutParams.height = (int) (((float) DisplayUtils.getDecorViewWidth(getContext())) * 0.45f);
            if (getAdapterPosition() == 0) {
                headCardViewHolder$populateImage$onImageLoadListener$1 = new HeadCardViewHolder$populateImage$onImageLoadListener$1(this);
            } else {
                ScalingImageView scalingImageView2 = ((ItemHeadCardBinding) getBinding()).topImageView;
                Intrinsics.checkNotNullExpressionValue(scalingImageView2, "binding.topImageView");
                scalingImageView2.setVisibility(0);
            }
            AppHolder.getFragmentImageLoader().displayImage(fragment2, entity2.getPic(), (ImageView) ((ItemHeadCardBinding) getBinding()).topImageView, ImageLoaderOptions.newBuilder().placeHolderRes(2131231696).build(), (OnImageLoadListener) headCardViewHolder$populateImage$onImageLoadListener$1, (OnBitmapTransformListener) null);
        }
    }

    /* access modifiers changed from: private */
    public final void doCoverAnim() {
        ScalingImageView scalingImageView = ((ItemHeadCardBinding) getBinding()).topImageView;
        Intrinsics.checkNotNullExpressionValue(scalingImageView, "binding.topImageView");
        if (!scalingImageView.isAttachedToWindow()) {
            ScalingImageView scalingImageView2 = scalingImageView;
            scalingImageView2.addOnAttachStateChangeListener(new HeadCardViewHolder$doCoverAnim$$inlined$doOnNextAttach$1(scalingImageView2, this, scalingImageView));
            return;
        }
        DataBindingComponent component = getComponent();
        View view = null;
        if (!(component instanceof FragmentBindingComponent)) {
            component = null;
        }
        FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
        Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
        if (!(fragment instanceof Fragment)) {
            fragment = null;
        }
        if (fragment != null) {
            view = fragment.getView();
        }
        if (view != null) {
            Intrinsics.checkNotNullExpressionValue(view, "inFragment<Fragment>()?.view.elvis { return }");
            if (!Intrinsics.areEqual(view.getTag(2131362638), (Object) true)) {
                View view2 = ((ItemHeadCardBinding) getBinding()).coverViewMask;
                Intrinsics.checkNotNullExpressionValue(view2, "binding.coverViewMask");
                view2.setVisibility(0);
                view.setTag(2131362638, true);
                View view3 = ((ItemHeadCardBinding) getBinding()).coverViewMask;
                Intrinsics.checkNotNullExpressionValue(view3, "binding.coverViewMask");
                ScalingImageView scalingImageView3 = ((ItemHeadCardBinding) getBinding()).topImageView;
                Intrinsics.checkNotNullExpressionValue(scalingImageView3, "binding.topImageView");
                ViewExtendsKt.startAlphaRevealAnimation$default(view3, scalingImageView3, 0, 0, 0, new HeadCardViewHolder$doCoverAnim$2(this), 14, null);
            }
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        if (view.getId() == 2131362200) {
            Entity entity2 = this.entity;
            if (entity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entity");
            }
            String url = entity2.getUrl();
            if (!(url == null || url.length() == 0)) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                Entity entity3 = this.entity;
                if (entity3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("entity");
                }
                String url2 = entity3.getUrl();
                Entity entity4 = this.entity;
                if (entity4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("entity");
                }
                String title = entity4.getTitle();
                Entity entity5 = this.entity;
                if (entity5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("entity");
                }
                ActionManagerCompat.startActivityByUrl(context, url2, title, entity5.getSubTitle());
                StatisticHelper instance = StatisticHelper.Companion.getInstance();
                DataBindingComponent component = getComponent();
                if (!(component instanceof FragmentBindingComponent)) {
                    component = null;
                }
                FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
                Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
                if (!(fragment instanceof BaseFragment)) {
                    fragment = null;
                }
                BaseFragment baseFragment = (BaseFragment) fragment;
                String fixedRecordId = baseFragment != null ? baseFragment.getFixedRecordId() : null;
                Entity entity6 = this.entity;
                if (entity6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("entity");
                }
                StatisticHelper.recordEntityEvent$default(instance, fixedRecordId, entity6, getAdapterPosition(), null, null, 24, null);
            }
        }
    }
}
