package com.coolapk.market.view.node.rating;

import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.SparseArray;
import android.util.StateSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.core.util.SparseArrayKt;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemNodeRatingSelectorBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.viewholder.GenericBindHolder;
import group.infotech.drawable.dsl.ShapesKt;
import group.infotech.drawable.dsl.ViewStates;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001aB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/coolapk/market/view/node/rating/NodeRatingSelectorViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemNodeRatingSelectorBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "presenter", "Lcom/coolapk/market/view/node/rating/NodeRatingPresenter;", "(Landroid/view/View;Lcom/coolapk/market/view/node/rating/NodeRatingPresenter;)V", "ignoreCheckCallback", "", "getPresenter", "()Lcom/coolapk/market/view/node/rating/NodeRatingPresenter;", "starViewArray", "Landroid/util/SparseArray;", "Landroid/widget/TextView;", "bindToContent", "", "data", "initTextViewState", "view", "onClick", "updateArgs", "args", "Lcom/coolapk/market/view/node/rating/NodeRatingArgs;", "updateUIWithArgs", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NodeRatingSelectorViewHolder.kt */
public final class NodeRatingSelectorViewHolder extends GenericBindHolder<ItemNodeRatingSelectorBinding, HolderItem> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558840;
    private boolean ignoreCheckCallback;
    private final NodeRatingPresenter presenter;
    private final SparseArray<TextView> starViewArray;

    public final NodeRatingPresenter getPresenter() {
        return this.presenter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NodeRatingSelectorViewHolder(View view, NodeRatingPresenter nodeRatingPresenter) {
        super(view, null, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(nodeRatingPresenter, "presenter");
        this.presenter = nodeRatingPresenter;
        SparseArray<TextView> sparseArray = new SparseArray<>();
        this.starViewArray = sparseArray;
        sparseArray.put(1, ((ItemNodeRatingSelectorBinding) getBinding()).star1View);
        sparseArray.put(2, ((ItemNodeRatingSelectorBinding) getBinding()).star2View);
        sparseArray.put(3, ((ItemNodeRatingSelectorBinding) getBinding()).star3View);
        sparseArray.put(4, ((ItemNodeRatingSelectorBinding) getBinding()).star4View);
        sparseArray.put(5, ((ItemNodeRatingSelectorBinding) getBinding()).star5View);
        Iterator valueIterator = SparseArrayKt.valueIterator(sparseArray);
        while (valueIterator.hasNext()) {
            initTextViewState((TextView) valueIterator.next());
        }
        TextView textView = ((ItemNodeRatingSelectorBinding) getBinding()).starAllView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.starAllView");
        initTextViewState(textView);
        ItemNodeRatingSelectorBinding itemNodeRatingSelectorBinding = (ItemNodeRatingSelectorBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemNodeRatingSelectorBinding, "binding");
        itemNodeRatingSelectorBinding.setClick(this);
        ((ItemNodeRatingSelectorBinding) getBinding()).versionCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
            /* class com.coolapk.market.view.node.rating.NodeRatingSelectorViewHolder.AnonymousClass2 */
            final /* synthetic */ NodeRatingSelectorViewHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                NodeRatingSelectorViewHolder nodeRatingSelectorViewHolder = this.this$0;
                nodeRatingSelectorViewHolder.updateArgs(NodeRatingArgs.copy$default(nodeRatingSelectorViewHolder.getPresenter().getArgs(), null, null, null, null, z, null, null, null, 0, 0, 1007, null));
            }
        });
        ((ItemNodeRatingSelectorBinding) getBinding()).noCommentCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
            /* class com.coolapk.market.view.node.rating.NodeRatingSelectorViewHolder.AnonymousClass3 */
            final /* synthetic */ NodeRatingSelectorViewHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (!this.this$0.ignoreCheckCallback) {
                    NodeRatingSelectorViewHolder nodeRatingSelectorViewHolder = this.this$0;
                    nodeRatingSelectorViewHolder.updateArgs(NodeRatingArgs.copy$default(nodeRatingSelectorViewHolder.getPresenter().getArgs(), null, null, null, null, false, null, z ? "0" : NodeRatingPresenter.Companion.getRATING_TYPE_ALL(), null, 0, 0, 959, null));
                }
            }
        });
        ((ItemNodeRatingSelectorBinding) getBinding()).hasCommentCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
            /* class com.coolapk.market.view.node.rating.NodeRatingSelectorViewHolder.AnonymousClass4 */
            final /* synthetic */ NodeRatingSelectorViewHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (!this.this$0.ignoreCheckCallback) {
                    NodeRatingSelectorViewHolder nodeRatingSelectorViewHolder = this.this$0;
                    nodeRatingSelectorViewHolder.updateArgs(NodeRatingArgs.copy$default(nodeRatingSelectorViewHolder.getPresenter().getArgs(), null, null, null, null, false, null, z ? "1" : NodeRatingPresenter.Companion.getRATING_TYPE_ALL(), null, 0, 0, 959, null));
                }
            }
        });
        ((ItemNodeRatingSelectorBinding) getBinding()).buyStatusCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
            /* class com.coolapk.market.view.node.rating.NodeRatingSelectorViewHolder.AnonymousClass5 */
            final /* synthetic */ NodeRatingSelectorViewHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (this.this$0.getPresenter().getArgs().getBuyStatusCheck() >= 0) {
                    NodeRatingSelectorViewHolder nodeRatingSelectorViewHolder = this.this$0;
                    nodeRatingSelectorViewHolder.updateArgs(NodeRatingArgs.copy$default(nodeRatingSelectorViewHolder.getPresenter().getArgs(), null, null, null, null, false, null, null, null, z ? 1 : 0, 0, 767, null));
                }
            }
        });
        ((ItemNodeRatingSelectorBinding) getBinding()).ownerCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
            /* class com.coolapk.market.view.node.rating.NodeRatingSelectorViewHolder.AnonymousClass6 */
            final /* synthetic */ NodeRatingSelectorViewHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (this.this$0.getPresenter().getArgs().getOwnStatusCheck() >= 0) {
                    NodeRatingSelectorViewHolder nodeRatingSelectorViewHolder = this.this$0;
                    nodeRatingSelectorViewHolder.updateArgs(NodeRatingArgs.copy$default(nodeRatingSelectorViewHolder.getPresenter().getArgs(), null, null, null, null, false, null, null, null, 0, z ? 1 : 0, 511, null));
                }
            }
        });
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/node/rating/NodeRatingSelectorViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: NodeRatingSelectorViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(HolderItem holderItem) {
        Intrinsics.checkNotNullParameter(holderItem, "data");
        updateUIWithArgs(this.presenter.getArgs());
    }

    /* access modifiers changed from: private */
    public final void updateArgs(NodeRatingArgs nodeRatingArgs) {
        if (!Intrinsics.areEqual(nodeRatingArgs, this.presenter.getArgs())) {
            this.presenter.setArgs(nodeRatingArgs);
            updateUIWithArgs(nodeRatingArgs);
        }
    }

    private final void updateUIWithArgs(NodeRatingArgs nodeRatingArgs) {
        boolean z = true;
        this.ignoreCheckCallback = true;
        SparseArray<TextView> sparseArray = this.starViewArray;
        int size = sparseArray.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            boolean areEqual = Intrinsics.areEqual(String.valueOf(sparseArray.keyAt(i)), nodeRatingArgs.getStar());
            sparseArray.valueAt(i).setSelected(areEqual);
            if (areEqual) {
                z2 = true;
            }
        }
        TextView textView = ((ItemNodeRatingSelectorBinding) getBinding()).starAllView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.starAllView");
        textView.setSelected(!z2);
        CheckBox checkBox = ((ItemNodeRatingSelectorBinding) getBinding()).noCommentCheckBox;
        Intrinsics.checkNotNullExpressionValue(checkBox, "binding.noCommentCheckBox");
        checkBox.setChecked(Intrinsics.areEqual(nodeRatingArgs.getRatingType(), "0"));
        CheckBox checkBox2 = ((ItemNodeRatingSelectorBinding) getBinding()).hasCommentCheckBox;
        Intrinsics.checkNotNullExpressionValue(checkBox2, "binding.hasCommentCheckBox");
        checkBox2.setChecked(Intrinsics.areEqual(nodeRatingArgs.getRatingType(), "1"));
        CheckBox checkBox3 = ((ItemNodeRatingSelectorBinding) getBinding()).versionCheckBox;
        Intrinsics.checkNotNullExpressionValue(checkBox3, "binding.versionCheckBox");
        checkBox3.setChecked(nodeRatingArgs.getUseTargetVersion());
        CheckBox checkBox4 = ((ItemNodeRatingSelectorBinding) getBinding()).versionCheckBox;
        Intrinsics.checkNotNullExpressionValue(checkBox4, "binding.versionCheckBox");
        int i2 = 8;
        checkBox4.setVisibility(nodeRatingArgs.getTargetVersion() != null ? 0 : 8);
        CheckBox checkBox5 = ((ItemNodeRatingSelectorBinding) getBinding()).buyStatusCheck;
        Intrinsics.checkNotNullExpressionValue(checkBox5, "binding.buyStatusCheck");
        checkBox5.setVisibility(nodeRatingArgs.getBuyStatusCheck() >= 0 ? 0 : 8);
        CheckBox checkBox6 = ((ItemNodeRatingSelectorBinding) getBinding()).buyStatusCheck;
        Intrinsics.checkNotNullExpressionValue(checkBox6, "binding.buyStatusCheck");
        checkBox6.setChecked(nodeRatingArgs.getBuyStatusCheck() >= 1);
        CheckBox checkBox7 = ((ItemNodeRatingSelectorBinding) getBinding()).ownerCheck;
        Intrinsics.checkNotNullExpressionValue(checkBox7, "binding.ownerCheck");
        CheckBox checkBox8 = checkBox7;
        if (nodeRatingArgs.getOwnStatusCheck() >= 0) {
            i2 = 0;
        }
        checkBox8.setVisibility(i2);
        CheckBox checkBox9 = ((ItemNodeRatingSelectorBinding) getBinding()).ownerCheck;
        Intrinsics.checkNotNullExpressionValue(checkBox9, "binding.ownerCheck");
        if (nodeRatingArgs.getOwnStatusCheck() < 1) {
            z = false;
        }
        checkBox9.setChecked(z);
        this.ignoreCheckCallback = false;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        NodeRatingArgs args = this.presenter.getArgs();
        switch (view.getId()) {
            case 2131363408:
                updateArgs(NodeRatingArgs.copy$default(args, null, null, null, null, false, null, null, "1", 0, 0, 895, null));
                return;
            case 2131363409:
                updateArgs(NodeRatingArgs.copy$default(args, null, null, null, null, false, null, null, "2", 0, 0, 895, null));
                return;
            case 2131363410:
                updateArgs(NodeRatingArgs.copy$default(args, null, null, null, null, false, null, null, "3", 0, 0, 895, null));
                return;
            case 2131363411:
                updateArgs(NodeRatingArgs.copy$default(args, null, null, null, null, false, null, null, "4", 0, 0, 895, null));
                return;
            case 2131363412:
                updateArgs(NodeRatingArgs.copy$default(args, null, null, null, null, false, null, null, "5", 0, 0, 895, null));
                return;
            case 2131363413:
                updateArgs(NodeRatingArgs.copy$default(args, null, null, null, null, false, null, null, NodeRatingPresenter.Companion.getSTAR_ALL(), 0, 0, 895, null));
                return;
            default:
                return;
        }
    }

    private final void initTextViewState(TextView textView) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        int[] selected = ViewStates.INSTANCE.selected();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 4));
        ShapesKt.setSolidColor(gradientDrawable, AppHolder.getAppTheme().getColorAccent());
        stateListDrawable.addState(selected, gradientDrawable);
        int[] iArr = StateSet.WILD_CARD;
        Intrinsics.checkExpressionValueIsNotNull(iArr, "StateSet.WILD_CARD");
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setGradientType(0);
        gradientDrawable2.setCornerRadius((float) NumberExtendsKt.getDp((Number) 4));
        ShapesKt.setSolidColor(gradientDrawable2, 443905397);
        stateListDrawable.addState(iArr, gradientDrawable2);
        Unit unit = Unit.INSTANCE;
        textView.setBackground(stateListDrawable);
        textView.setTextColor(new ColorStateList(new int[][]{new int[]{16842913}, new int[0]}, new int[]{-1, (int) 4285887861L}));
    }
}
