package com.coolapk.market.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemTopicViewBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewHolderExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Topic;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.view.base.BaseFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/viewholder/TopicViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemTopicViewBinding;", "Lcom/coolapk/market/model/Topic;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "bindToContent", "", "data", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TopicViewHolder.kt */
public class TopicViewHolder extends GenericBindHolder<ItemTopicViewBinding, Topic> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558962;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopicViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ItemTopicViewBinding itemTopicViewBinding = (ItemTopicViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemTopicViewBinding, "binding");
        itemTopicViewBinding.setClick(this);
        Drawable mutate = ResourceUtils.getDrawable(getContext(), 2131231300).mutate();
        mutate.setTint(ResourceUtils.getColorInt(getContext(), 2131100011));
        mutate.setBounds(0, 0, NumberExtendsKt.getDp((Number) 12), NumberExtendsKt.getDp((Number) 12));
        Intrinsics.checkNotNullExpressionValue(mutate, "ResourceUtils.getDrawabl… 12.dp)\n                }");
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{mutate});
        layerDrawable.setLayerInset(0, 0, 0, NumberExtendsKt.getDp((Number) 1), 0);
        layerDrawable.setBounds(0, 0, NumberExtendsKt.getDp((Number) 13), NumberExtendsKt.getDp((Number) 12));
        ((ItemTopicViewBinding) getBinding()).descriptionView.setCompoundDrawables(layerDrawable, null, null, null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/TopicViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TopicViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Type inference failed for: r0v21, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public void bindToContent(Topic topic) {
        Intrinsics.checkNotNullParameter(topic, "data");
        ItemTopicViewBinding itemTopicViewBinding = (ItemTopicViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemTopicViewBinding, "binding");
        itemTopicViewBinding.setModel(topic);
        TextView textView = ((ItemTopicViewBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText(topic.getTitle());
        TextView textView2 = ((ItemTopicViewBinding) getBinding()).descriptionView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.descriptionView");
        textView2.setText(KotlinExtendKt.toDisplayString(topic.getHotNum()) + "热度 " + KotlinExtendKt.toDisplayString(topic.getCommentNum()) + "讨论");
        ((ItemTopicViewBinding) getBinding()).executePendingBindings();
        String logo = topic.getLogo();
        if (logo == null || logo.length() == 0) {
            GlideApp.with(getContext()).load((Integer) 2131231617).into(((ItemTopicViewBinding) getBinding()).logoView);
        }
        ((ItemTopicViewBinding) getBinding()).rootView.setOnLongClickListener(new TopicViewHolder$bindToContent$1(this, topic));
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        String title = topic.getTitle();
        if (title == null) {
            title = "";
        }
        instance.recordTopicViewDisplay(title);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ItemTopicViewBinding itemTopicViewBinding = (ItemTopicViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemTopicViewBinding, "binding");
        Entity model = itemTopicViewBinding.getModel();
        if (model != null) {
            Intrinsics.checkNotNullExpressionValue(model, "binding.model ?: return");
            super.onClick(view);
            if (view.getId() == 2131363260) {
                StatisticHelper instance = StatisticHelper.Companion.getInstance();
                String title = model.getTitle();
                if (title == null) {
                    title = "";
                }
                instance.recordTopicViewClick(title);
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ActionManagerCompat.startActivityByUrl(context, model.getUrl(), model.getTitle(), model.getSubTitle());
                Entity findParentEntity = ViewHolderExtendsKt.findParentEntity(this);
                if (findParentEntity != null && EntityExtendsKt.hasCardStatName(findParentEntity)) {
                    StatisticHelper instance2 = StatisticHelper.Companion.getInstance();
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
                    StatisticHelper.recordEntityEvent$default(instance2, baseFragment != null ? baseFragment.getFixedRecordId() : null, model, getAdapterPosition(), findParentEntity, null, 16, null);
                }
            }
        }
    }
}
