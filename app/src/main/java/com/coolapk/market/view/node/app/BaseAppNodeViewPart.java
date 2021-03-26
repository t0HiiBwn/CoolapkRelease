package com.coolapk.market.view.node.app;

import android.graphics.Rect;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J*\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00042\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\rH&¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/node/app/BaseAppNodeViewPart;", "B", "Landroidx/databinding/ViewDataBinding;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/model/ServiceApp;", "()V", "applyWindowsInset", "", "rect", "Landroid/graphics/Rect;", "loadLogoAndBG", "data", "callback", "Lkotlin/Function2;", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseAppNodeViewPart.kt */
public abstract class BaseAppNodeViewPart<B extends ViewDataBinding> extends BindingViewPart<B, ServiceApp> {
    public abstract void applyWindowsInset(Rect rect);

    public abstract void loadLogoAndBG(ServiceApp serviceApp, Function2<? super Integer, ? super Integer, Unit> function2);
}
