package com.coolapk.market.viewholder;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.databinding.ItemNodeTopContenItemBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragment;
import com.coolapk.market.view.base.MultiItemDialogFragmentKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\tH\u0002R\u000e\u0010\f\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/viewholder/NodeTopContentItemViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemNodeTopContenItemBinding;", "Lcom/coolapk/market/model/Entity;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "nodeType", "", "nodeId", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Ljava/lang/String;Ljava/lang/String;)V", "entity", "getNodeId", "()Ljava/lang/String;", "getNodeType", "bindToContent", "", "data", "onClick", "view", "removeTopContentFromNode", "url", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NodeTopContentViewHolder.kt */
final class NodeTopContentItemViewHolder extends GenericBindHolder<ItemNodeTopContenItemBinding, Entity> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558841;
    private Entity entity;
    private final String nodeId;
    private final String nodeType;

    public static final /* synthetic */ Entity access$getEntity$p(NodeTopContentItemViewHolder nodeTopContentItemViewHolder) {
        Entity entity2 = nodeTopContentItemViewHolder.entity;
        if (entity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
        }
        return entity2;
    }

    public final String getNodeId() {
        return this.nodeId;
    }

    public final String getNodeType() {
        return this.nodeType;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NodeTopContentItemViewHolder(View view, DataBindingComponent dataBindingComponent, String str, String str2) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(str, "nodeType");
        Intrinsics.checkNotNullParameter(str2, "nodeId");
        this.nodeType = str;
        this.nodeId = str2;
        ItemNodeTopContenItemBinding itemNodeTopContenItemBinding = (ItemNodeTopContenItemBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemNodeTopContenItemBinding, "binding");
        itemNodeTopContenItemBinding.setClick(this);
        itemNodeTopContenItemBinding.cardView.setOnLongClickListener(new View.OnLongClickListener(this) {
            /* class com.coolapk.market.viewholder.NodeTopContentItemViewHolder.AnonymousClass1 */
            final /* synthetic */ NodeTopContentItemViewHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                DataManager instance = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                LoginSession loginSession = instance.getLoginSession();
                Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
                if (!loginSession.isAdmin()) {
                    return true;
                }
                Context context = this.this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                Activity activityNullable = UiUtils.getActivityNullable(context);
                Intrinsics.checkNotNull(activityNullable);
                MultiItemDialogFragment initBuilder = MultiItemDialogFragment.Companion.newInstance().setInitBuilder(new Function1<List<ActionItem>, Unit>(this) {
                    /* class com.coolapk.market.viewholder.NodeTopContentItemViewHolder.AnonymousClass1.AnonymousClass1 */
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<ActionItem> list) {
                        invoke(list);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(List<ActionItem> list) {
                        Intrinsics.checkNotNullParameter(list, "it");
                        MultiItemDialogFragmentKt.addItem(list, "取消单条置顶", new Function0<Unit>(this) {
                            /* class com.coolapk.market.viewholder.NodeTopContentItemViewHolder.AnonymousClass1.AnonymousClass1.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass1 this$0;

                            {
                                this.this$0 = r1;
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final void invoke() {
                                NodeTopContentItemViewHolder nodeTopContentItemViewHolder = this.this$0.this$0.this$0;
                                String url = NodeTopContentItemViewHolder.access$getEntity$p(this.this$0.this$0.this$0).getUrl();
                                if (url == null) {
                                    url = "";
                                }
                                nodeTopContentItemViewHolder.removeTopContentFromNode(url);
                            }
                        });
                    }
                });
                FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activityNullable).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
                initBuilder.show(supportFragmentManager, (String) null);
                return true;
            }
        });
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/NodeTopContentItemViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: NodeTopContentViewHolder.kt */
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
        ItemNodeTopContenItemBinding itemNodeTopContenItemBinding = (ItemNodeTopContenItemBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemNodeTopContenItemBinding, "binding");
        itemNodeTopContenItemBinding.setModel(entity2);
        ((ItemNodeTopContenItemBinding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() != 2131362200) {
            super.onClick(view);
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Entity entity2 = this.entity;
        if (entity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
        }
        ActionManagerCompat.startActivityByUrl$default(context, entity2.getUrl(), null, null, 12, null);
    }

    /* access modifiers changed from: private */
    public final void removeTopContentFromNode(String str) {
        DataManager.getInstance().removeTopContentFromNode(this.nodeType, this.nodeId, str).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new NodeTopContentItemViewHolder$removeTopContentFromNode$1(this));
    }
}
