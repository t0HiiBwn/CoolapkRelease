package com.coolapk.market.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.databinding.ServiceAppBinding;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/viewholder/ServiceAppExpandedViewHolder;", "Lcom/coolapk/market/viewholder/ServiceAppViewHolder;", "itemView", "Landroid/view/View;", "bindingComponent", "Landroidx/databinding/DataBindingComponent;", "itemActionHandler", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "binding", "Lcom/coolapk/market/databinding/ServiceAppBinding;", "kotlin.jvm.PlatformType", "imageViewPart", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "getImageViewPart", "()Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "imageViewPart$delegate", "Lkotlin/Lazy;", "bindTo", "", "data", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ServiceAppExpandedViewHolder.kt */
public final class ServiceAppExpandedViewHolder extends ServiceAppViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int VIEW_TYPE_EXPANDED_CARD = 2131123389;
    private final ServiceAppBinding binding;
    private final Lazy imageViewPart$delegate;

    private final NinePicViewPart getImageViewPart() {
        return (NinePicViewPart) this.imageViewPart$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ServiceAppExpandedViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "bindingComponent");
        Intrinsics.checkNotNullParameter(itemActionHandler, "itemActionHandler");
        ServiceAppBinding serviceAppBinding = (ServiceAppBinding) getBinding();
        this.binding = serviceAppBinding;
        TextView textView = serviceAppBinding.introductionView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.introductionView");
        textView.setMaxLines(3);
        TextView textView2 = serviceAppBinding.introductionView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.introductionView");
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        serviceAppBinding.introductionView.setLineSpacing(0.0f, 1.2f);
        TextView textView3 = serviceAppBinding.introductionView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.introductionView");
        textView3.setTextSize(14.0f);
        this.imageViewPart$delegate = LazyKt.lazy(new ServiceAppExpandedViewHolder$imageViewPart$2(this, dataBindingComponent, view));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/ServiceAppExpandedViewHolder$Companion;", "", "()V", "VIEW_TYPE_EXPANDED_CARD", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ServiceAppExpandedViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.ServiceAppViewHolder, com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "data");
        super.bindTo(obj);
        ServiceApp serviceApp = (ServiceApp) obj;
        LinearLayout linearLayout = this.binding.introductionLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.introductionLayout");
        linearLayout.setVisibility(0);
        LinearLayout linearLayout2 = this.binding.introductionLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.introductionLayout");
        boolean z = true;
        linearLayout2.setVerticalFadingEdgeEnabled(true);
        TextView textView = this.binding.introductionView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.introductionView");
        TextView textView2 = textView;
        ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.leftMargin = 0;
        textView2.setLayoutParams(marginLayoutParams);
        getImageViewPart().setThumbUrlProviderForNewActivity(new ServiceAppExpandedViewHolder$bindTo$2(serviceApp));
        getImageViewPart().setThumbUrlProviderForLoad(new ServiceAppExpandedViewHolder$bindTo$3(serviceApp));
        NinePicViewPart imageViewPart = getImageViewPart();
        List<String> screenList = serviceApp.getScreenList();
        if (screenList == null) {
            screenList = Collections.emptyList();
        }
        Intrinsics.checkNotNullExpressionValue(screenList, "serviceApp.screenList.el…Collections.emptyList() }");
        imageViewPart.bindToContent(screenList);
        TextView textView3 = this.binding.introductionView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.introductionView");
        if (textView3.getVisibility() != 0) {
            String description = serviceApp.getDescription();
            if (!(description == null || description.length() == 0)) {
                z = false;
            }
            if (!z) {
                TextView textView4 = this.binding.introductionView;
                Intrinsics.checkNotNullExpressionValue(textView4, "binding.introductionView");
                textView4.setVisibility(0);
                TextViewBindingAdapters.setTextViewLinkable(this.binding.introductionView, serviceApp.getDescription());
            }
        }
    }
}
