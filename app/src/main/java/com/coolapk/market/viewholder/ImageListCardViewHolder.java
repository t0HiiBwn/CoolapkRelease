package com.coolapk.market.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemImageCarouselCard1ItemBinding;
import com.coolapk.market.databinding.ItemImageListCardBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.AppPictureSizeManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.viewholder.TitleViewPart;
import com.coolapk.market.viewholder.iview.Recyclable;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoaderInterface;
import com.youth.banner.view.BannerViewPager;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0016\u0018\u0000 !2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002!\"B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u000eH\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0014H\u0002J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\b\u0010 \u001a\u00020\u0014H\u0016R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/coolapk/market/viewholder/ImageListCardViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "Lcom/coolapk/market/viewholder/IAnimationBehavior;", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "Lcom/coolapk/market/design/CoolapkCardView$CardStyleCallback;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "binding", "Lcom/coolapk/market/databinding/ItemImageListCardBinding;", "kotlin.jvm.PlatformType", "displayedChild", "", "entityCard", "Lcom/coolapk/market/model/EntityCard;", "viewPart", "Lcom/coolapk/market/viewholder/TitleViewPart;", "bindTo", "", "data", "", "getDisplayedChild", "onCardStyleDetermined", "cardStyle", "onRecycled", "setAspectRatio", "ratio", "", "setDisplayedChild", "startAnimation", "stopAnimation", "Companion", "GlideImageLoader", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ImageListCardViewHolder.kt */
public class ImageListCardViewHolder extends BindingViewHolder implements IAnimationBehavior, Recyclable, CoolapkCardView.CardStyleCallback {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558791;
    private final ItemImageListCardBinding binding;
    private int displayedChild = 1;
    private EntityCard entityCard;
    private final TitleViewPart viewPart;

    public static final /* synthetic */ EntityCard access$getEntityCard$p(ImageListCardViewHolder imageListCardViewHolder) {
        EntityCard entityCard2 = imageListCardViewHolder.entityCard;
        if (entityCard2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entityCard");
        }
        return entityCard2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageListCardViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ItemImageListCardBinding itemImageListCardBinding = (ItemImageListCardBinding) getBinding();
        this.binding = itemImageListCardBinding;
        TitleViewPart.Companion companion = TitleViewPart.Companion;
        MaxWidthFrameLayout maxWidthFrameLayout = itemImageListCardBinding.frameView;
        Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout, "binding.frameView");
        this.viewPart = companion.newInstance(maxWidthFrameLayout, this);
        itemImageListCardBinding.bannerView.setImageLoader(new GlideImageLoader());
        itemImageListCardBinding.bannerView.setBannerStyle(1);
        itemImageListCardBinding.bannerView.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(this) {
            /* class com.coolapk.market.viewholder.ImageListCardViewHolder.AnonymousClass1 */
            final /* synthetic */ ImageListCardViewHolder this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0) {
                    this.this$0.getDisplayedChild();
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                Entity entity;
                super.onPageSelected(i);
                if (i != 0 || !CollectionUtils.isEmpty(ImageListCardViewHolder.access$getEntityCard$p(this.this$0).getEntities())) {
                    List<Entity> entities = ImageListCardViewHolder.access$getEntityCard$p(this.this$0).getEntities();
                    Intrinsics.checkNotNull(entities);
                    Entity entity2 = entities.get(i);
                    Intrinsics.checkNotNullExpressionValue(entity2, "entityCard.entities!![position]");
                    entity = entity2;
                } else {
                    entity = ImageListCardViewHolder.access$getEntityCard$p(this.this$0);
                }
                StatisticHelper instance = StatisticHelper.Companion.getInstance();
                String title = entity.getTitle();
                if (title == null) {
                    title = "";
                }
                instance.recordBannerDisplayEvent(title);
            }
        });
        try {
            Class<?> cls = itemImageListCardBinding.bannerView.getClass();
            Field declaredField = cls.getDeclaredField("mIndicatorWidth");
            declaredField.setAccessible(true);
            declaredField.setInt(itemImageListCardBinding.bannerView, NumberExtendsKt.getDp((Number) 5));
            Field declaredField2 = cls.getDeclaredField("mIndicatorHeight");
            declaredField2.setAccessible(true);
            declaredField2.setInt(itemImageListCardBinding.bannerView, NumberExtendsKt.getDp((Number) 5));
            Field declaredField3 = cls.getDeclaredField("mIndicatorMargin");
            declaredField3.setAccessible(true);
            declaredField3.setInt(itemImageListCardBinding.bannerView, NumberExtendsKt.getDp((Number) 2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.binding.bannerView.setOnBannerListener(new OnBannerListener(this) {
            /* class com.coolapk.market.viewholder.ImageListCardViewHolder.AnonymousClass3 */
            final /* synthetic */ ImageListCardViewHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // com.youth.banner.listener.OnBannerListener
            public final void OnBannerClick(int i) {
                Entity entity;
                if (i != 0 || !CollectionUtils.isEmpty(ImageListCardViewHolder.access$getEntityCard$p(this.this$0).getEntities())) {
                    List<Entity> entities = ImageListCardViewHolder.access$getEntityCard$p(this.this$0).getEntities();
                    Intrinsics.checkNotNull(entities);
                    Entity entity2 = entities.get(i);
                    Intrinsics.checkNotNullExpressionValue(entity2, "entityCard.entities!![position]");
                    entity = entity2;
                } else {
                    entity = ImageListCardViewHolder.access$getEntityCard$p(this.this$0);
                }
                Context context = this.this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ActionManagerCompat.startActivityByUrl(context, entity.getUrl(), entity.getTitle(), entity.getSubTitle());
                StatisticHelper instance = StatisticHelper.Companion.getInstance();
                DataBindingComponent component = this.this$0.getComponent();
                if (!(component instanceof FragmentBindingComponent)) {
                    component = null;
                }
                FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
                Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
                if (!(fragment instanceof BaseFragment)) {
                    fragment = null;
                }
                BaseFragment baseFragment = (BaseFragment) fragment;
                StatisticHelper.recordEntityEvent$default(instance, baseFragment != null ? baseFragment.getFixedRecordId() : null, entity, this.this$0.getAdapterPosition(), ImageListCardViewHolder.access$getEntityCard$p(this.this$0), null, 16, null);
            }
        });
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/ImageListCardViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ImageListCardViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final void getDisplayedChild() {
        try {
            Field declaredField = Banner.class.getDeclaredField("viewPager");
            Intrinsics.checkNotNullExpressionValue(declaredField, "startedField");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this.binding.bannerView);
            if (obj != null) {
                this.displayedChild = this.binding.bannerView.toRealPosition(((BannerViewPager) obj).getCurrentItem());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.youth.banner.view.BannerViewPager");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void setDisplayedChild() {
        try {
            Field declaredField = Banner.class.getDeclaredField("currentItem");
            Intrinsics.checkNotNullExpressionValue(declaredField, "currentItemField");
            declaredField.setAccessible(true);
            declaredField.setInt(this.binding.bannerView, this.displayedChild);
            Field declaredField2 = Banner.class.getDeclaredField("viewPager");
            Intrinsics.checkNotNullExpressionValue(declaredField2, "viewPagerField");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(this.binding.bannerView);
            if (obj != null) {
                ((BannerViewPager) obj).setCurrentItem(this.displayedChild);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.youth.banner.view.BannerViewPager");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.coolapk.market.viewholder.IAnimationBehavior
    public void startAnimation() {
        this.binding.bannerView.startAutoPlay();
    }

    @Override // com.coolapk.market.viewholder.IAnimationBehavior
    public void stopAnimation() {
        this.binding.bannerView.stopAutoPlay();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.EntityCard");
        this.entityCard = (EntityCard) obj;
        ArrayList arrayList = new ArrayList();
        EntityCard entityCard2 = this.entityCard;
        if (entityCard2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entityCard");
        }
        List<Entity> entities = entityCard2.getEntities();
        if (entities != null) {
            for (T t : entities) {
                Intrinsics.checkNotNullExpressionValue(t, "it");
                String pic = t.getPic();
                if (pic != null) {
                    arrayList.add(pic);
                }
            }
        }
        if (arrayList.isEmpty()) {
            EntityCard entityCard3 = this.entityCard;
            if (entityCard3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entityCard");
            }
            String pic2 = entityCard3.getPic();
            if (pic2 != null) {
                arrayList.add(pic2);
            }
        }
        TitleViewPart titleViewPart = this.viewPart;
        EntityCard entityCard4 = this.entityCard;
        if (entityCard4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entityCard");
        }
        titleViewPart.bindToContent(entityCard4);
        EntityCard entityCard5 = this.entityCard;
        if (entityCard5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entityCard");
        }
        String entityTemplate = entityCard5.getEntityTemplate();
        if (entityTemplate != null) {
            Float f = null;
            switch (entityTemplate.hashCode()) {
                case -1759482485:
                    if (entityTemplate.equals("imageCarouselCard")) {
                        this.binding.bannerView.setIndicatorGravity(6);
                        MaxWidthFrameLayout maxWidthFrameLayout = this.binding.frameView;
                        Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout, "binding.frameView");
                        ViewExtendsKt.clipView$default(maxWidthFrameLayout, 0, 0.0f, 1, null);
                        setAspectRatio(3.0f);
                        this.binding.itemView.setPadding(0, 0, 0, 0);
                        break;
                    }
                    break;
                case -878677237:
                    if (entityTemplate.equals("imageCard")) {
                        this.binding.bannerView.setIndicatorGravity(7);
                        setAspectRatio(3.0f);
                        MaxWidthFrameLayout maxWidthFrameLayout2 = this.binding.frameView;
                        Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout2, "binding.frameView");
                        ViewExtendsKt.clipView$default(maxWidthFrameLayout2, 0, 0.0f, 1, null);
                        this.binding.itemView.setPadding(0, 0, 0, 0);
                        break;
                    }
                    break;
                case 1354449533:
                    if (entityTemplate.equals("imageCarouselCard_1")) {
                        this.binding.bannerView.setIndicatorGravity(7);
                        MaxWidthFrameLayout maxWidthFrameLayout3 = this.binding.frameView;
                        Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout3, "binding.frameView");
                        ViewExtendsKt.clipView$default(maxWidthFrameLayout3, 0, (float) NumberExtendsKt.getDp((Number) 8), 1, null);
                        setAspectRatio(3.0f);
                        this.binding.itemView.setPadding(0, 0, 0, 0);
                        break;
                    }
                    break;
                case 1820987487:
                    if (entityTemplate.equals("imageScaleCard")) {
                        EntityCard entityCard6 = this.entityCard;
                        if (entityCard6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("entityCard");
                        }
                        JSONObject jsonExtraData = EntityExtendsKt.getJsonExtraData(entityCard6);
                        int dp = jsonExtraData != null ? NumberExtendsKt.getDp(Integer.valueOf(jsonExtraData.optInt("cardContainerPaddingLeft"))) : 0;
                        int dp2 = jsonExtraData != null ? NumberExtendsKt.getDp(Integer.valueOf(jsonExtraData.optInt("cardContainerPaddingTop"))) : 0;
                        int dp3 = jsonExtraData != null ? NumberExtendsKt.getDp(Integer.valueOf(jsonExtraData.optInt("cardContainerPaddingRight"))) : 0;
                        int dp4 = jsonExtraData != null ? NumberExtendsKt.getDp(Integer.valueOf(jsonExtraData.optInt("cardContainerPaddingBottom"))) : 0;
                        int dp5 = jsonExtraData != null ? NumberExtendsKt.getDp(Integer.valueOf(jsonExtraData.optInt("cardContainerRadius"))) : 0;
                        this.binding.itemView.setPadding(dp, dp2, dp3, dp4);
                        this.binding.bannerView.setIndicatorGravity(7);
                        MaxWidthFrameLayout maxWidthFrameLayout4 = this.binding.frameView;
                        Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout4, "binding.frameView");
                        ViewExtendsKt.clipView$default(maxWidthFrameLayout4, 0, (float) dp5, 1, null);
                        AppPictureSizeManager.PictureSize size = AppPictureSizeManager.getInstance().getSize((String) CollectionsKt.getOrNull(arrayList, 0));
                        if (size != null) {
                            f = Float.valueOf(((float) size.getWidth()) / ((float) size.getHeight()));
                        }
                        if (f == null) {
                            f = Float.valueOf(1.0f);
                        }
                        setAspectRatio(f.floatValue());
                        break;
                    }
                    break;
            }
        }
        EntityCard entityCard7 = this.entityCard;
        if (entityCard7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entityCard");
        }
        List<Entity> entities2 = entityCard7.getEntities();
        Intrinsics.checkNotNull(entities2);
        if (entities2.size() <= 1) {
            this.binding.bannerView.setBannerStyle(0);
        } else {
            this.binding.bannerView.setBannerStyle(1);
        }
        this.binding.bannerView.setImages(arrayList);
        this.binding.bannerView.start();
        setDisplayedChild();
    }

    private final void setAspectRatio(float f) {
        this.binding.frameView.setAspectRatio(f);
        this.binding.frameView.requestLayout();
    }

    @Override // com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        this.binding.bannerView.releaseBanner();
        this.binding.bannerView.update(Collections.emptyList());
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/coolapk/market/viewholder/ImageListCardViewHolder$GlideImageLoader;", "Lcom/youth/banner/loader/ImageLoaderInterface;", "Landroid/view/View;", "(Lcom/coolapk/market/viewholder/ImageListCardViewHolder;)V", "createImageView", "context", "Landroid/content/Context;", "displayImage", "", "path", "", "view", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ImageListCardViewHolder.kt */
    private final class GlideImageLoader implements ImageLoaderInterface<View> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public GlideImageLoader() {
        }

        @Override // com.youth.banner.loader.ImageLoaderInterface
        public void displayImage(Context context, Object obj, View view) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(view, "view");
            ViewDataBinding binding = DataBindingUtil.getBinding(view);
            Intrinsics.checkNotNull(binding);
            Intrinsics.checkNotNullExpressionValue(binding, "DataBindingUtil.getBindi…Card1ItemBinding>(view)!!");
            ItemImageCarouselCard1ItemBinding itemImageCarouselCard1ItemBinding = (ItemImageCarouselCard1ItemBinding) binding;
            itemImageCarouselCard1ItemBinding.setUrl(obj != null ? obj.toString() : null);
            itemImageCarouselCard1ItemBinding.executePendingBindings();
            ImageView imageView = itemImageCarouselCard1ItemBinding.imageView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.imageView");
            ViewExtendsKt.darkForegroundIfNeed(imageView);
        }

        @Override // com.youth.banner.loader.ImageLoaderInterface
        public View createImageView(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ItemImageCarouselCard1ItemBinding itemImageCarouselCard1ItemBinding = (ItemImageCarouselCard1ItemBinding) DataBindingUtil.inflate(LayoutInflater.from(context), 2131558788, null, false, ImageListCardViewHolder.this.getComponent());
            Intrinsics.checkNotNullExpressionValue(itemImageCarouselCard1ItemBinding, "binding");
            View root = itemImageCarouselCard1ItemBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            return root;
        }
    }

    @Override // com.coolapk.market.design.CoolapkCardView.CardStyleCallback
    public void onCardStyleDetermined(int i) {
        MaxWidthFrameLayout maxWidthFrameLayout = this.binding.frameView;
        Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout, "binding.frameView");
        int clipRectRadius = (int) ViewExtendsKt.getClipRectRadius(maxWidthFrameLayout);
        if (clipRectRadius != 0) {
            if (i == 4) {
                this.binding.frameView.setPadding(0, 0, 0, clipRectRadius);
                MaxWidthFrameLayout maxWidthFrameLayout2 = this.binding.frameView;
                Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout2, "binding.frameView");
                MaxWidthFrameLayout maxWidthFrameLayout3 = maxWidthFrameLayout2;
                ViewGroup.LayoutParams layoutParams = maxWidthFrameLayout3.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
                marginLayoutParams2.bottomMargin = -clipRectRadius;
                marginLayoutParams2.topMargin = 0;
                maxWidthFrameLayout3.setLayoutParams(marginLayoutParams);
            } else if (i != 5) {
                this.binding.frameView.setPadding(0, 0, 0, 0);
                MaxWidthFrameLayout maxWidthFrameLayout4 = this.binding.frameView;
                Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout4, "binding.frameView");
                MaxWidthFrameLayout maxWidthFrameLayout5 = maxWidthFrameLayout4;
                ViewGroup.LayoutParams layoutParams2 = maxWidthFrameLayout5.getLayoutParams();
                Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams2;
                ViewGroup.MarginLayoutParams marginLayoutParams4 = marginLayoutParams3;
                marginLayoutParams4.topMargin = 0;
                marginLayoutParams4.bottomMargin = 0;
                maxWidthFrameLayout5.setLayoutParams(marginLayoutParams3);
            } else {
                this.binding.frameView.setPadding(0, clipRectRadius, 0, 0);
                MaxWidthFrameLayout maxWidthFrameLayout6 = this.binding.frameView;
                Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout6, "binding.frameView");
                MaxWidthFrameLayout maxWidthFrameLayout7 = maxWidthFrameLayout6;
                ViewGroup.LayoutParams layoutParams3 = maxWidthFrameLayout7.getLayoutParams();
                Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams3;
                ViewGroup.MarginLayoutParams marginLayoutParams6 = marginLayoutParams5;
                marginLayoutParams6.topMargin = -clipRectRadius;
                marginLayoutParams6.bottomMargin = 0;
                maxWidthFrameLayout7.setLayoutParams(marginLayoutParams5);
            }
        }
    }
}
