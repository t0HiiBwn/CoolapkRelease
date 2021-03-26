package com.coolapk.market.view.center;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemRecentLoginBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.viewholder.GenericBindHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/center/RecentLoginHintViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemRecentLoginBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "bindToContent", "", "data", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: RecentLoginHintViewHolder.kt */
public final class RecentLoginHintViewHolder extends GenericBindHolder<ItemRecentLoginBinding, HolderItem> {
    public static final Companion Companion = new Companion(null);
    public static final String ENTITY_TYPE_RECENT_LOGIN = "recent_login";
    public static final int LAYOUT_ID = 2131558899;
    public static final String LOGIN_HTML = "你还没有登录, <a href=\"/account/login\">去登录</a>";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecentLoginHintViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/center/RecentLoginHintViewHolder$Companion;", "", "()V", "ENTITY_TYPE_RECENT_LOGIN", "", "LAYOUT_ID", "", "LOGIN_HTML", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: RecentLoginHintViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(HolderItem holderItem) {
        Intrinsics.checkNotNullParameter(holderItem, "data");
        String string = holderItem.getString();
        if (string == null || string.length() == 0) {
            TextView textView = ((ItemRecentLoginBinding) getBinding()).titleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
            ViewExtendsKt.setBriefMessage$default(textView, Integer.MAX_VALUE, "你还没有登录, <a href=\"/account/login\">去登录</a>", null, 4, null);
        } else {
            TextView textView2 = ((ItemRecentLoginBinding) getBinding()).titleView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
            textView2.setText(holderItem.getString());
        }
        ((ItemRecentLoginBinding) getBinding()).executePendingBindings();
    }
}
