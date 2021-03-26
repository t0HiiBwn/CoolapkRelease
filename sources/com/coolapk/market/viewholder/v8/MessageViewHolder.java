package com.coolapk.market.viewholder.v8;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemMessageBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Message;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.notification.NotificationActivity;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001cBC\u0012\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0003`\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u001a\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\nH\u0016R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0003`\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/coolapk/market/viewholder/v8/MessageViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemMessageBinding;", "Lcom/coolapk/market/model/Message;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "delList", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Ljava/util/LinkedHashMap;Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "editState", "", "mMessage", "bindToContent", "", "message", "onCheckedChanged", "buttonView", "Landroid/widget/CompoundButton;", "isChecked", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MessageViewHolder.kt */
public final class MessageViewHolder extends GenericBindHolder<ItemMessageBinding, Message> implements CompoundButton.OnCheckedChangeListener {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558824;
    private final LinkedHashMap<String, Message> delList;
    private boolean editState;
    private Message mMessage;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageViewHolder(LinkedHashMap<String, Message> linkedHashMap, View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(linkedHashMap, "delList");
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.delList = linkedHashMap;
    }

    public static final /* synthetic */ Message access$getMMessage$p(MessageViewHolder messageViewHolder) {
        Message message = messageViewHolder.mMessage;
        if (message == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMessage");
        }
        return message;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (!UiUtils.isInvalidPosition(getAdapterPosition())) {
            LinkedHashMap<String, Message> linkedHashMap = this.delList;
            ItemMessageBinding itemMessageBinding = (ItemMessageBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemMessageBinding, "binding");
            Message model = itemMessageBinding.getModel();
            Intrinsics.checkNotNull(model);
            Intrinsics.checkNotNullExpressionValue(model, "binding.model!!");
            String entityId = model.getEntityId();
            Objects.requireNonNull(linkedHashMap, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            boolean containsKey = linkedHashMap.containsKey(entityId);
            Activity activity = UiUtils.getActivity(getContext());
            ItemMessageBinding itemMessageBinding2 = (ItemMessageBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemMessageBinding2, "binding");
            Message model2 = itemMessageBinding2.getModel();
            if (z && !containsKey) {
                Intrinsics.checkNotNull(model2);
                String entityId2 = model2.getEntityId();
                Intrinsics.checkNotNull(entityId2);
                Intrinsics.checkNotNullExpressionValue(entityId2, "message!!.entityId!!");
                this.delList.put(entityId2, model2);
            } else if (!z && containsKey) {
                LinkedHashMap<String, Message> linkedHashMap2 = this.delList;
                Intrinsics.checkNotNull(model2);
                String entityId3 = model2.getEntityId();
                Objects.requireNonNull(linkedHashMap2, "null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                TypeIntrinsics.asMutableMap(linkedHashMap2).remove(entityId3);
                if (activity instanceof NotificationActivity) {
                    ((NotificationActivity) activity).setSelectAllState(false);
                }
            }
            if (activity instanceof NotificationActivity) {
                ((NotificationActivity) activity).updateDelView();
            }
        }
    }

    public void bindToContent(Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.mMessage = message;
        ItemMessageBinding itemMessageBinding = (ItemMessageBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemMessageBinding, "binding");
        itemMessageBinding.setModel(message);
        ItemMessageBinding itemMessageBinding2 = (ItemMessageBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemMessageBinding2, "binding");
        itemMessageBinding2.setClick(this);
        ItemMessageBinding itemMessageBinding3 = (ItemMessageBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemMessageBinding3, "binding");
        int i = 0;
        Drawable drawable = null;
        itemMessageBinding3.setTransformer(new CircleTransform(false, 0, 3, null));
        Activity activity = UiUtils.getActivity(getContext());
        if (activity instanceof NotificationActivity) {
            boolean z = true;
            if (((NotificationActivity) activity).getMessageState() != 1) {
                z = false;
            }
            this.editState = z;
        }
        CoolEllipsizeTextView coolEllipsizeTextView = ((ItemMessageBinding) getBinding()).infoView;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView, "binding.infoView");
        coolEllipsizeTextView.setText(StringUtils.getAllLinkAndText(message.getMessage()));
        CheckBox checkBox = ((ItemMessageBinding) getBinding()).checkBox;
        Intrinsics.checkNotNullExpressionValue(checkBox, "binding.checkBox");
        if (!this.editState) {
            i = 8;
        }
        checkBox.setVisibility(i);
        ((ItemMessageBinding) getBinding()).checkBox.setOnCheckedChangeListener(this);
        CheckBox checkBox2 = ((ItemMessageBinding) getBinding()).checkBox;
        Intrinsics.checkNotNullExpressionValue(checkBox2, "binding.checkBox");
        LinkedHashMap<String, Message> linkedHashMap = this.delList;
        String entityId = message.getEntityId();
        Objects.requireNonNull(linkedHashMap, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        checkBox2.setChecked(linkedHashMap.containsKey(entityId));
        Message message2 = this.mMessage;
        if (message2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMessage");
        }
        if (message2.isToped()) {
            ColorDrawable colorDrawable = new ColorDrawable(AppHolder.getAppTheme().getColorAccent());
            colorDrawable.setAlpha(26);
            Drawable createSelectableItemBackgroundWith = ShapeUtils.createSelectableItemBackgroundWith(getContext(), colorDrawable);
            ItemMessageBinding itemMessageBinding4 = (ItemMessageBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemMessageBinding4, "binding");
            View root = itemMessageBinding4.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            Intrinsics.checkNotNullExpressionValue(createSelectableItemBackgroundWith, "colorAccentSelectableBackground");
            Drawable.ConstantState constantState = createSelectableItemBackgroundWith.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            root.setBackground(drawable);
        } else {
            ColorDrawable colorDrawable2 = new ColorDrawable(AppHolder.getAppTheme().getContentBackgroundColor());
            ItemMessageBinding itemMessageBinding5 = (ItemMessageBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemMessageBinding5, "binding");
            View root2 = itemMessageBinding5.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
            root2.setBackground(colorDrawable2);
        }
        ((ItemMessageBinding) getBinding()).executePendingBindings();
        ItemMessageBinding itemMessageBinding6 = (ItemMessageBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemMessageBinding6, "binding");
        itemMessageBinding6.getRoot().setOnLongClickListener(new MessageViewHolder$bindToContent$1(this, message));
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        if (!UiUtils.isInvalidPosition(getAdapterPosition())) {
            if (this.editState) {
                CheckBox checkBox = ((ItemMessageBinding) getBinding()).checkBox;
                Intrinsics.checkNotNullExpressionValue(checkBox, "binding.checkBox");
                CheckBox checkBox2 = ((ItemMessageBinding) getBinding()).checkBox;
                Intrinsics.checkNotNullExpressionValue(checkBox2, "binding.checkBox");
                checkBox.setChecked(!checkBox2.isChecked());
                return;
            }
            if (view == this.itemView) {
                Context context = getContext();
                Message message = this.mMessage;
                if (message == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMessage");
                }
                String messageUid = message.getMessageUid();
                Message message2 = this.mMessage;
                if (message2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMessage");
                }
                ActionManager.startChattingActivity(context, messageUid, message2.getMessageUserName());
                Observable.timer(1000, TimeUnit.MILLISECONDS).compose(RxUtils.applyIOSchedulers()).subscribe(new MessageViewHolder$onClick$1(this));
            }
            if (view.getId() == 2131363877) {
                Message message3 = this.mMessage;
                if (message3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMessage");
                }
                String messageUid2 = message3.getMessageUid();
                Message message4 = this.mMessage;
                if (message4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMessage");
                }
                ActionManager.startUserSpaceActivity(view, messageUid2, message4.getMessageUserAvatar());
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/v8/MessageViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MessageViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
