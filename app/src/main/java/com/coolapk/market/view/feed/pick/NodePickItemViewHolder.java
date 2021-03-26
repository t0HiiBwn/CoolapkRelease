package com.coolapk.market.view.feed.pick;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemNodePickItemBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Product;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.viewholder.GenericBindHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0003H\u0016R\u000e\u0010\t\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/feed/pick/NodePickItemViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemNodePickItemBinding;", "Lcom/coolapk/market/model/Entity;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "data", "bindToContent", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NodePickRecentListFragment.kt */
public final class NodePickItemViewHolder extends GenericBindHolder<ItemNodePickItemBinding, Entity> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558838;
    private Entity data;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NodePickItemViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        TextView textView = ((ItemNodePickItemBinding) getBinding()).tagView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tagView");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 2));
        gradientDrawable.setStroke(NumberExtendsKt.getDp(Double.valueOf(0.5d)), AppHolder.getAppTheme().getColorAccent());
        Unit unit = Unit.INSTANCE;
        textView.setBackground(gradientDrawable);
        ((ItemNodePickItemBinding) getBinding()).tagView.setTextColor(AppHolder.getAppTheme().getColorAccent());
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/pick/NodePickItemViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: NodePickRecentListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00fe  */
    @Override // com.coolapk.market.viewholder.GenericBindHolder
    public void bindToContent(Entity entity) {
        String str;
        String entityType;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(entity, "data");
        this.data = entity;
        String entityType2 = entity.getEntityType();
        if (entityType2 != null) {
            int hashCode = entityType2.hashCode();
            if (hashCode != -309474065) {
                if (hashCode == 96796 && entityType2.equals("apk")) {
                    str = "应用";
                    TextView textView = ((ItemNodePickItemBinding) getBinding()).tagView;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.tagView");
                    textView.setText(str);
                    TextView textView2 = ((ItemNodePickItemBinding) getBinding()).titleView;
                    Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
                    textView2.setText(entity.getTitle());
                    ItemNodePickItemBinding itemNodePickItemBinding = (ItemNodePickItemBinding) getBinding();
                    Intrinsics.checkNotNullExpressionValue(itemNodePickItemBinding, "binding");
                    itemNodePickItemBinding.setModel(entity);
                    entityType = entity.getEntityType();
                    if (entityType != null) {
                        int hashCode2 = entityType.hashCode();
                        if (hashCode2 != -309474065) {
                            if (hashCode2 == 96796 && entityType.equals("apk")) {
                                ServiceApp serviceApp = (ServiceApp) entity;
                                str2 = serviceApp.getFollowCount() + "关注  " + serviceApp.getCommentCount() + "讨论";
                                TextView textView3 = ((ItemNodePickItemBinding) getBinding()).descriptionView;
                                Intrinsics.checkNotNullExpressionValue(textView3, "binding.descriptionView");
                                str3 = str2;
                                textView3.setText(str3);
                                TextView textView4 = ((ItemNodePickItemBinding) getBinding()).descriptionView;
                                Intrinsics.checkNotNullExpressionValue(textView4, "binding.descriptionView");
                                int i = 0;
                                if (str3.length() == 0) {
                                    i = 8;
                                }
                                textView4.setVisibility(i);
                                ((ItemNodePickItemBinding) getBinding()).cardView.setDefaultBackgroundColor(Integer.valueOf(AppHolder.getAppTheme().getContentBackgroundColor()));
                                ((ItemNodePickItemBinding) getBinding()).executePendingBindings();
                            }
                        } else if (entityType.equals("product")) {
                            Product product = (Product) entity;
                            str2 = KotlinExtendKt.toDisplayString(product.getFollowNum()) + "关注  " + KotlinExtendKt.toDisplayString(product.getFeedCommentNum()) + "讨论";
                            TextView textView3 = ((ItemNodePickItemBinding) getBinding()).descriptionView;
                            Intrinsics.checkNotNullExpressionValue(textView3, "binding.descriptionView");
                            str3 = str2;
                            textView3.setText(str3);
                            TextView textView4 = ((ItemNodePickItemBinding) getBinding()).descriptionView;
                            Intrinsics.checkNotNullExpressionValue(textView4, "binding.descriptionView");
                            int i = 0;
                            if (str3.length() == 0) {
                            }
                            textView4.setVisibility(i);
                            ((ItemNodePickItemBinding) getBinding()).cardView.setDefaultBackgroundColor(Integer.valueOf(AppHolder.getAppTheme().getContentBackgroundColor()));
                            ((ItemNodePickItemBinding) getBinding()).executePendingBindings();
                        }
                    }
                    str2 = "";
                    TextView textView3 = ((ItemNodePickItemBinding) getBinding()).descriptionView;
                    Intrinsics.checkNotNullExpressionValue(textView3, "binding.descriptionView");
                    str3 = str2;
                    textView3.setText(str3);
                    TextView textView4 = ((ItemNodePickItemBinding) getBinding()).descriptionView;
                    Intrinsics.checkNotNullExpressionValue(textView4, "binding.descriptionView");
                    int i = 0;
                    if (str3.length() == 0) {
                    }
                    textView4.setVisibility(i);
                    ((ItemNodePickItemBinding) getBinding()).cardView.setDefaultBackgroundColor(Integer.valueOf(AppHolder.getAppTheme().getContentBackgroundColor()));
                    ((ItemNodePickItemBinding) getBinding()).executePendingBindings();
                }
            } else if (entityType2.equals("product")) {
                str = "数码";
                TextView textView = ((ItemNodePickItemBinding) getBinding()).tagView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.tagView");
                textView.setText(str);
                TextView textView2 = ((ItemNodePickItemBinding) getBinding()).titleView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
                textView2.setText(entity.getTitle());
                ItemNodePickItemBinding itemNodePickItemBinding = (ItemNodePickItemBinding) getBinding();
                Intrinsics.checkNotNullExpressionValue(itemNodePickItemBinding, "binding");
                itemNodePickItemBinding.setModel(entity);
                entityType = entity.getEntityType();
                if (entityType != null) {
                }
                str2 = "";
                TextView textView3 = ((ItemNodePickItemBinding) getBinding()).descriptionView;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.descriptionView");
                str3 = str2;
                textView3.setText(str3);
                TextView textView4 = ((ItemNodePickItemBinding) getBinding()).descriptionView;
                Intrinsics.checkNotNullExpressionValue(textView4, "binding.descriptionView");
                int i = 0;
                if (str3.length() == 0) {
                }
                textView4.setVisibility(i);
                ((ItemNodePickItemBinding) getBinding()).cardView.setDefaultBackgroundColor(Integer.valueOf(AppHolder.getAppTheme().getContentBackgroundColor()));
                ((ItemNodePickItemBinding) getBinding()).executePendingBindings();
            }
        }
        str = "其他";
        TextView textView = ((ItemNodePickItemBinding) getBinding()).tagView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tagView");
        textView.setText(str);
        TextView textView2 = ((ItemNodePickItemBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
        textView2.setText(entity.getTitle());
        ItemNodePickItemBinding itemNodePickItemBinding = (ItemNodePickItemBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemNodePickItemBinding, "binding");
        itemNodePickItemBinding.setModel(entity);
        entityType = entity.getEntityType();
        if (entityType != null) {
        }
        str2 = "";
        TextView textView3 = ((ItemNodePickItemBinding) getBinding()).descriptionView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.descriptionView");
        str3 = str2;
        textView3.setText(str3);
        TextView textView4 = ((ItemNodePickItemBinding) getBinding()).descriptionView;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.descriptionView");
        int i = 0;
        if (str3.length() == 0) {
        }
        textView4.setVisibility(i);
        ((ItemNodePickItemBinding) getBinding()).cardView.setDefaultBackgroundColor(Integer.valueOf(AppHolder.getAppTheme().getContentBackgroundColor()));
        ((ItemNodePickItemBinding) getBinding()).executePendingBindings();
    }
}
