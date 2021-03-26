package com.coolapk.market.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.databinding.ItemSimpleEntityHolderBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.view.feed.CurrencyItemDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016R\u0019\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/viewholder/SimpleEntityViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "view", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "binding", "Lcom/coolapk/market/databinding/ItemSimpleEntityHolderBinding;", "kotlin.jvm.PlatformType", "getBinding", "()Lcom/coolapk/market/databinding/ItemSimpleEntityHolderBinding;", "data", "", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "bindTo", "", "onClick", "onLongClick", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SimpleEntityViewHolder.kt */
public final class SimpleEntityViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558936;
    private final ItemSimpleEntityHolderBinding binding = ((ItemSimpleEntityHolderBinding) getBinding());
    private Object data;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleEntityViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/SimpleEntityViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SimpleEntityViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final Object getData() {
        return this.data;
    }

    public final void setData(Object obj) {
        this.data = obj;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public final ItemSimpleEntityHolderBinding getBinding() {
        return this.binding;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        this.data = obj;
        ItemSimpleEntityHolderBinding itemSimpleEntityHolderBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemSimpleEntityHolderBinding, "binding");
        itemSimpleEntityHolderBinding.setClick(this);
        this.binding.rootView.setOnLongClickListener(this);
        int i = 8;
        if (obj instanceof Entity) {
            Entity entity = (Entity) obj;
            String picOrLogo = EntityExtendsKt.picOrLogo(entity);
            String title = entity.getTitle();
            if (title == null) {
                title = "无法支持该类型，请升级";
            }
            Intrinsics.checkNotNullExpressionValue(title, "data.title ?: \"无法支持该类型，请升级\"");
            ImageView imageView = this.binding.logoView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.logoView");
            boolean z = true;
            imageView.setVisibility(picOrLogo.length() == 0 ? 8 : 0);
            TextView textView = this.binding.titleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
            textView.setText(title);
            ItemSimpleEntityHolderBinding itemSimpleEntityHolderBinding2 = this.binding;
            Intrinsics.checkNotNullExpressionValue(itemSimpleEntityHolderBinding2, "binding");
            itemSimpleEntityHolderBinding2.setModel(entity);
            this.binding.titleView.setSingleLine(true);
            TextView textView2 = this.binding.descriptionView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.descriptionView");
            String subTitle = entity.getSubTitle();
            if (subTitle == null) {
                subTitle = entity.getDescription();
            }
            textView2.setText(subTitle);
            TextView textView3 = this.binding.descriptionView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.descriptionView");
            String subTitle2 = entity.getSubTitle();
            if (!(subTitle2 == null || subTitle2.length() == 0)) {
                z = false;
            }
            if (!z) {
                i = 0;
            }
            textView3.setVisibility(i);
        } else {
            ImageView imageView2 = this.binding.logoView;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.logoView");
            imageView2.setVisibility(8);
            TextView textView4 = this.binding.descriptionView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.descriptionView");
            textView4.setVisibility(8);
            this.binding.titleView.setSingleLine(false);
            ItemSimpleEntityHolderBinding itemSimpleEntityHolderBinding3 = this.binding;
            Intrinsics.checkNotNullExpressionValue(itemSimpleEntityHolderBinding3, "binding");
            itemSimpleEntityHolderBinding3.setModel(null);
            TextView textView5 = this.binding.titleView;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.titleView");
            textView5.setMaxLines(3);
            TextView textView6 = this.binding.titleView;
            Intrinsics.checkNotNullExpressionValue(textView6, "binding.titleView");
            textView6.setText("无法解析数据，请处理\n" + String.valueOf(obj));
        }
        this.binding.executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        if (view.getId() == 2131363274) {
            Object obj = this.data;
            if (obj instanceof Entity) {
                Entity entity = (Entity) obj;
                String url = entity.getUrl();
                if (!(url == null || url.length() == 0)) {
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    ActionManagerCompat.startActivityByUrl(context, entity.getUrl(), entity.getTitle(), entity.getSubTitle());
                }
            }
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        Object obj = this.data;
        if (obj instanceof Entity) {
            Entity entity = (Entity) obj;
            String entityType = entity.getEntityType();
            if (!(entityType == null || entityType.length() == 0) && EntityUtils.isUserReportSpamType(entity.getEntityType())) {
                CurrencyItemDialog newInstance = CurrencyItemDialog.Companion.newInstance(entity);
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(context).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context.requireAppCompat…().supportFragmentManager");
                newInstance.show(supportFragmentManager, (String) null);
                return true;
            }
        }
        return false;
    }
}
