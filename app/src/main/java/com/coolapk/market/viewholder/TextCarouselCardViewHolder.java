package com.coolapk.market.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ViewFlipper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemTextCarouselCardBinding;
import com.coolapk.market.databinding.ItemTextLinkCardItemBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.AppPictureSizeManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.gongwen.marqueen.MarqueeFactory;
import com.gongwen.marqueen.MarqueeView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0002\u0015\u0016B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/viewholder/TextCarouselCardViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "Lcom/coolapk/market/viewholder/IAnimationBehavior;", "view", "Landroid/view/View;", "bindingComponent", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "binding", "Lcom/coolapk/market/databinding/ItemTextCarouselCardBinding;", "kotlin.jvm.PlatformType", "displayedChild", "", "shouldAnim", "", "bindTo", "", "data", "", "startAnimation", "stopAnimation", "Companion", "ItemMF", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TextCarouselCardViewHolder.kt */
public final class TextCarouselCardViewHolder extends BindingViewHolder implements IAnimationBehavior {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558948;
    private final ItemTextCarouselCardBinding binding;
    private int displayedChild;
    private boolean shouldAnim;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextCarouselCardViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "bindingComponent");
        ItemTextCarouselCardBinding itemTextCarouselCardBinding = (ItemTextCarouselCardBinding) getBinding();
        this.binding = itemTextCarouselCardBinding;
        itemTextCarouselCardBinding.marqueeView.setInterval(3000);
        MarqueeView marqueeView = itemTextCarouselCardBinding.marqueeView;
        Intrinsics.checkNotNullExpressionValue(marqueeView, "binding.marqueeView");
        marqueeView.setAutoStart(true);
        MarqueeView marqueeView2 = itemTextCarouselCardBinding.marqueeView;
        Intrinsics.checkNotNullExpressionValue(marqueeView2, "binding.marqueeView");
        marqueeView2.setAnimateFirstView(false);
        MarqueeView marqueeView3 = itemTextCarouselCardBinding.marqueeView;
        Intrinsics.checkNotNullExpressionValue(marqueeView3, "binding.marqueeView");
        marqueeView3.getInAnimation().setAnimationListener(new Animation.AnimationListener(this) {
            /* class com.coolapk.market.viewholder.TextCarouselCardViewHolder.AnonymousClass1 */
            final /* synthetic */ TextCarouselCardViewHolder this$0;

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                TextCarouselCardViewHolder textCarouselCardViewHolder = this.this$0;
                MarqueeView marqueeView = textCarouselCardViewHolder.binding.marqueeView;
                Intrinsics.checkNotNullExpressionValue(marqueeView, "binding.marqueeView");
                textCarouselCardViewHolder.displayedChild = marqueeView.getDisplayedChild();
            }
        });
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/TextCarouselCardViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TextCarouselCardViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.IAnimationBehavior
    public void startAnimation() {
        if (this.shouldAnim) {
            try {
                Field declaredField = ViewFlipper.class.getDeclaredField("mStarted");
                Intrinsics.checkNotNullExpressionValue(declaredField, "startedField");
                declaredField.setAccessible(true);
                declaredField.setBoolean(this.binding.marqueeView, true);
                Method declaredMethod = ViewFlipper.class.getDeclaredMethod("updateRunning", Boolean.TYPE);
                Intrinsics.checkNotNullExpressionValue(declaredMethod, "updateRunningMethod");
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.binding.marqueeView, false);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.coolapk.market.viewholder.IAnimationBehavior
    public void stopAnimation() {
        if (this.shouldAnim) {
            this.binding.marqueeView.stopFlipping();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.EntityCard");
        EntityCard entityCard = (EntityCard) obj;
        List<Entity> entities = entityCard.getEntities();
        Intrinsics.checkNotNull(entities);
        boolean z = entities.size() > 1;
        this.shouldAnim = z;
        if (!z) {
            MarqueeView marqueeView = this.binding.marqueeView;
            Intrinsics.checkNotNullExpressionValue(marqueeView, "binding.marqueeView");
            marqueeView.setAutoStart(false);
            stopAnimation();
        } else {
            MarqueeView marqueeView2 = this.binding.marqueeView;
            Intrinsics.checkNotNullExpressionValue(marqueeView2, "binding.marqueeView");
            marqueeView2.setAutoStart(true);
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        DataBindingComponent component = getComponent();
        Intrinsics.checkNotNullExpressionValue(component, "component");
        ItemMF itemMF = new ItemMF(context, component);
        itemMF.setData(entityCard.getEntities());
        itemMF.setOnItemClickListener(new TextCarouselCardViewHolder$bindTo$1(this, entityCard));
        this.binding.marqueeView.setMarqueeFactory(itemMF);
        MarqueeView marqueeView3 = this.binding.marqueeView;
        Intrinsics.checkNotNullExpressionValue(marqueeView3, "binding.marqueeView");
        marqueeView3.setDisplayedChild(this.displayedChild);
        AppPictureSizeManager.PictureSize size = AppPictureSizeManager.getInstance().getSize(EntityExtendsKt.picOrLogo(entityCard));
        if (size != null) {
            ImageView imageView = this.binding.imageView;
            imageView.getLayoutParams().width = size.getWidth();
            imageView.requestLayout();
            this.binding.imageView.setColorFilter(AppHolder.getAppTheme().getColorAccent());
        }
        this.itemView.requestLayout();
        ItemTextCarouselCardBinding itemTextCarouselCardBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemTextCarouselCardBinding, "binding");
        itemTextCarouselCardBinding.setEntity(entityCard);
        this.binding.executePendingBindings();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/viewholder/TextCarouselCardViewHolder$ItemMF;", "Lcom/gongwen/marqueen/MarqueeFactory;", "Landroid/view/View;", "Lcom/coolapk/market/model/Entity;", "context", "Landroid/content/Context;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/content/Context;Landroidx/databinding/DataBindingComponent;)V", "getComponent", "()Landroidx/databinding/DataBindingComponent;", "getContext", "()Landroid/content/Context;", "inflater", "Landroid/view/LayoutInflater;", "generateMarqueeItemView", "data", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TextCarouselCardViewHolder.kt */
    private static final class ItemMF extends MarqueeFactory<View, Entity> {
        private final DataBindingComponent component;
        private final Context context;
        private final LayoutInflater inflater;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ItemMF(Context context2, DataBindingComponent dataBindingComponent) {
            super(context2);
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            this.context = context2;
            this.component = dataBindingComponent;
            LayoutInflater from = LayoutInflater.from(context2);
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(context)");
            this.inflater = from;
        }

        public final DataBindingComponent getComponent() {
            return this.component;
        }

        public final Context getContext() {
            return this.context;
        }

        public View generateMarqueeItemView(Entity entity) {
            Intrinsics.checkNotNullParameter(entity, "data");
            View inflate = this.inflater.inflate(2131558950, (ViewGroup) null, false);
            ViewDataBinding bind = DataBindingUtil.bind(inflate, this.component);
            Intrinsics.checkNotNull(bind);
            Intrinsics.checkNotNullExpressionValue(bind, "DataBindingUtil.bind<Ite…g>(viewItem, component)!!");
            ItemTextLinkCardItemBinding itemTextLinkCardItemBinding = (ItemTextLinkCardItemBinding) bind;
            itemTextLinkCardItemBinding.setEntity(entity);
            itemTextLinkCardItemBinding.executePendingBindings();
            Intrinsics.checkNotNullExpressionValue(inflate, "viewItem");
            return inflate;
        }
    }
}
