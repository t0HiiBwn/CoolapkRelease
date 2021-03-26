package com.coolapk.market.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.percentlayout.widget.PercentFrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemImageCarouselCard2Binding;
import com.coolapk.market.databinding.ItemImageCarouselCard2ItemBinding;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.viewholder.TitleViewPart;
import com.coolapk.market.viewholder.iview.Recyclable;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0003\u0019\u001a\u001bB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0002R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/viewholder/ImageCarouselCard2ViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "binding", "Lcom/coolapk/market/databinding/ItemImageCarouselCard2Binding;", "kotlin.jvm.PlatformType", "displayedChild", "", "Ljava/lang/Integer;", "entityCard", "Lcom/coolapk/market/model/EntityCard;", "viewPart", "Lcom/coolapk/market/viewholder/TitleViewPart;", "bindTo", "", "data", "", "getDisplayedChild", "onRecycled", "setDisplayedChild", "Companion", "CustPagerTransformer", "GlideImageLoader", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ImageCarouselCard2ViewHolder.kt */
public final class ImageCarouselCard2ViewHolder extends BindingViewHolder implements Recyclable {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558796;
    private final ItemImageCarouselCard2Binding binding;
    private Integer displayedChild;
    private EntityCard entityCard;
    private final TitleViewPart viewPart;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageCarouselCard2ViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ItemImageCarouselCard2Binding itemImageCarouselCard2Binding = (ItemImageCarouselCard2Binding) getBinding();
        this.binding = itemImageCarouselCard2Binding;
        TitleViewPart.Companion companion = TitleViewPart.Companion;
        PercentFrameLayout percentFrameLayout = itemImageCarouselCard2Binding.frameView;
        Intrinsics.checkNotNullExpressionValue(percentFrameLayout, "binding.frameView");
        this.viewPart = companion.newInstance(percentFrameLayout, this);
        itemImageCarouselCard2Binding.bannerView.setImageLoader(new GlideImageLoader());
        itemImageCarouselCard2Binding.bannerView.setBannerStyle(0);
        itemImageCarouselCard2Binding.bannerView.setOffscreenPageLimit(3);
        itemImageCarouselCard2Binding.bannerView.setPageTransformer(true, new CustPagerTransformer());
        itemImageCarouselCard2Binding.bannerView.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(this) {
            /* class com.coolapk.market.viewholder.ImageCarouselCard2ViewHolder.AnonymousClass1 */
            final /* synthetic */ ImageCarouselCard2ViewHolder this$0;

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
        });
        itemImageCarouselCard2Binding.bannerView.setOnBannerListener(new OnBannerListener(this) {
            /* class com.coolapk.market.viewholder.ImageCarouselCard2ViewHolder.AnonymousClass2 */
            final /* synthetic */ ImageCarouselCard2ViewHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // com.youth.banner.listener.OnBannerListener
            public final void OnBannerClick(int i) {
                Entity entity;
                String str = null;
                if (i != 0 || !CollectionUtils.isEmpty(ImageCarouselCard2ViewHolder.access$getEntityCard$p(this.this$0).getEntities())) {
                    List<Entity> entities = ImageCarouselCard2ViewHolder.access$getEntityCard$p(this.this$0).getEntities();
                    Intrinsics.checkNotNull(entities);
                    Entity entity2 = entities.get(i);
                    Intrinsics.checkNotNullExpressionValue(entity2, "entityCard.entities!![position]");
                    entity = entity2;
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
                    if (baseFragment != null) {
                        str = baseFragment.getFixedRecordId();
                    }
                    StatisticHelper.recordEntityEvent$default(instance, str, entity, this.this$0.getAdapterPosition(), ImageCarouselCard2ViewHolder.access$getEntityCard$p(this.this$0), null, 16, null);
                } else {
                    entity = ImageCarouselCard2ViewHolder.access$getEntityCard$p(this.this$0);
                    StatisticHelper instance2 = StatisticHelper.Companion.getInstance();
                    DataBindingComponent component2 = this.this$0.getComponent();
                    if (!(component2 instanceof FragmentBindingComponent)) {
                        component2 = null;
                    }
                    FragmentBindingComponent fragmentBindingComponent2 = (FragmentBindingComponent) component2;
                    Fragment fragment2 = fragmentBindingComponent2 != null ? (Fragment) fragmentBindingComponent2.getContainer() : null;
                    if (!(fragment2 instanceof BaseFragment)) {
                        fragment2 = null;
                    }
                    BaseFragment baseFragment2 = (BaseFragment) fragment2;
                    if (baseFragment2 != null) {
                        str = baseFragment2.getFixedRecordId();
                    }
                    StatisticHelper.recordEntityEvent$default(instance2, str, entity, this.this$0.getAdapterPosition(), null, null, 24, null);
                }
                Context context = this.this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ActionManagerCompat.startActivityByUrl(context, entity.getUrl(), entity.getTitle(), entity.getSubTitle());
            }
        });
    }

    public static final /* synthetic */ EntityCard access$getEntityCard$p(ImageCarouselCard2ViewHolder imageCarouselCard2ViewHolder) {
        EntityCard entityCard2 = imageCarouselCard2ViewHolder.entityCard;
        if (entityCard2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entityCard");
        }
        return entityCard2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/ImageCarouselCard2ViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ImageCarouselCard2ViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.EntityCard");
        EntityCard entityCard2 = (EntityCard) obj;
        this.entityCard = entityCard2;
        TitleViewPart titleViewPart = this.viewPart;
        if (entityCard2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entityCard");
        }
        titleViewPart.bindToContent(entityCard2);
        if (this.displayedChild == null) {
            EntityCard entityCard3 = this.entityCard;
            if (entityCard3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entityCard");
            }
            List<Entity> entities = entityCard3.getEntities();
            Intrinsics.checkNotNull(entities);
            double floor = Math.floor((double) ((((float) entities.size()) * 1.0f) / ((float) 2)));
            EntityCard entityCard4 = this.entityCard;
            if (entityCard4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entityCard");
            }
            List<Entity> entities2 = entityCard4.getEntities();
            Intrinsics.checkNotNull(entities2);
            if (entities2.size() % 2 == 0) {
                floor -= (double) 1;
            }
            this.displayedChild = Integer.valueOf((int) floor);
        }
        ArrayList arrayList = new ArrayList();
        EntityCard entityCard5 = this.entityCard;
        if (entityCard5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entityCard");
        }
        List<Entity> entities3 = entityCard5.getEntities();
        if (entities3 != null) {
            for (T t : entities3) {
                Intrinsics.checkNotNullExpressionValue(t, "it");
                String pic = t.getPic();
                if (pic != null) {
                    arrayList.add(pic);
                }
            }
        }
        if (arrayList.isEmpty()) {
            EntityCard entityCard6 = this.entityCard;
            if (entityCard6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entityCard");
            }
            String pic2 = entityCard6.getPic();
            if (pic2 != null) {
                arrayList.add(pic2);
            }
        }
        this.binding.bannerView.setImages(arrayList);
        this.binding.bannerView.start();
        setDisplayedChild();
        this.binding.executePendingBindings();
    }

    /* access modifiers changed from: private */
    public final void getDisplayedChild() {
        try {
            Field declaredField = Banner.class.getDeclaredField("viewPager");
            Intrinsics.checkNotNullExpressionValue(declaredField, "startedField");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this.binding.bannerView);
            if (obj != null) {
                this.displayedChild = Integer.valueOf(this.binding.bannerView.toRealPosition(((BannerViewPager) obj).getCurrentItem()));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.youth.banner.view.BannerViewPager");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        this.binding.bannerView.releaseBanner();
        this.binding.bannerView.update(Collections.emptyList());
    }

    private final void setDisplayedChild() {
        try {
            Field declaredField = Banner.class.getDeclaredField("currentItem");
            Intrinsics.checkNotNullExpressionValue(declaredField, "currentItemField");
            declaredField.setAccessible(true);
            Banner banner = this.binding.bannerView;
            Integer num = this.displayedChild;
            Intrinsics.checkNotNull(num);
            declaredField.setInt(banner, num.intValue());
            Field declaredField2 = Banner.class.getDeclaredField("viewPager");
            Intrinsics.checkNotNullExpressionValue(declaredField2, "viewPagerField");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(this.binding.bannerView);
            if (obj != null) {
                Integer num2 = this.displayedChild;
                Intrinsics.checkNotNull(num2);
                ((BannerViewPager) obj).setCurrentItem(num2.intValue());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.youth.banner.view.BannerViewPager");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/coolapk/market/viewholder/ImageCarouselCard2ViewHolder$CustPagerTransformer;", "Landroidx/viewpager/widget/ViewPager$PageTransformer;", "()V", "maxTranslateOffsetX", "", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "transformPage", "", "view", "Landroid/view/View;", "position", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ImageCarouselCard2ViewHolder.kt */
    public static final class CustPagerTransformer implements ViewPager.PageTransformer {
        private final int maxTranslateOffsetX = ConvertUtils.dp2px(180.0f);
        private ViewPager viewPager;

        @Override // androidx.viewpager.widget.ViewPager.PageTransformer
        public void transformPage(View view, float f) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (this.viewPager == null) {
                ViewParent parent = view.getParent();
                Objects.requireNonNull(parent, "null cannot be cast to non-null type androidx.viewpager.widget.ViewPager");
                this.viewPager = (ViewPager) parent;
            }
            int left = view.getLeft();
            ViewPager viewPager2 = this.viewPager;
            Intrinsics.checkNotNull(viewPager2);
            int scrollX = (left - viewPager2.getScrollX()) + (view.getMeasuredWidth() / 2);
            ViewPager viewPager3 = this.viewPager;
            Intrinsics.checkNotNull(viewPager3);
            ViewPager viewPager4 = this.viewPager;
            Intrinsics.checkNotNull(viewPager4);
            float measuredWidth = (((float) (scrollX - (viewPager3.getMeasuredWidth() / 2))) * 0.05f) / ((float) viewPager4.getMeasuredWidth());
            float abs = ((float) 1) - Math.abs(measuredWidth);
            if (abs > ((float) 0)) {
                view.setScaleX(abs);
                view.setScaleY(abs);
                view.setTranslationX(((float) (-this.maxTranslateOffsetX)) * measuredWidth);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/coolapk/market/viewholder/ImageCarouselCard2ViewHolder$GlideImageLoader;", "Lcom/youth/banner/loader/ImageLoaderInterface;", "Landroid/view/View;", "(Lcom/coolapk/market/viewholder/ImageCarouselCard2ViewHolder;)V", "createImageView", "context", "Landroid/content/Context;", "displayImage", "", "path", "", "view", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ImageCarouselCard2ViewHolder.kt */
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
            Intrinsics.checkNotNullExpressionValue(binding, "DataBindingUtil.getBindi…Card2ItemBinding>(view)!!");
            ItemImageCarouselCard2ItemBinding itemImageCarouselCard2ItemBinding = (ItemImageCarouselCard2ItemBinding) binding;
            itemImageCarouselCard2ItemBinding.setUrl(obj != null ? obj.toString() : null);
            itemImageCarouselCard2ItemBinding.executePendingBindings();
        }

        @Override // com.youth.banner.loader.ImageLoaderInterface
        public View createImageView(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ItemImageCarouselCard2ItemBinding itemImageCarouselCard2ItemBinding = (ItemImageCarouselCard2ItemBinding) DataBindingUtil.inflate(LayoutInflater.from(context), 2131558797, null, false, ImageCarouselCard2ViewHolder.this.getComponent());
            Intrinsics.checkNotNullExpressionValue(itemImageCarouselCard2ItemBinding, "binding");
            View root = itemImageCarouselCard2ItemBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            return root;
        }
    }
}
