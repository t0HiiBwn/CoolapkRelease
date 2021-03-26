package com.coolapk.market.view.live;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.databinding.ItemLiveMessageBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.imageloader.GlideFragmentImageLoader;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.model.LiveMessage;
import com.coolapk.market.model.User;
import com.coolapk.market.util.FeedTextUtils;
import com.coolapk.market.view.live.CommandHelper;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.iview.Recyclable;
import com.hanks.htextview.rainbow.RainbowTextView;
import group.infotech.drawable.dsl.ShapesKt;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u001a\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0002'(B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010&\u001a\u00020\u001dH\u0016R\u0016\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0004\n\u0002\u0010\u001b¨\u0006)"}, d2 = {"Lcom/coolapk/market/view/live/LiveMessageViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "messageType", "", "view", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "actionHandler", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "callback", "Lcom/coolapk/market/view/live/LiveMessageViewHolder$Callback;", "commandHelper", "Lcom/coolapk/market/view/live/CommandHelper;", "(Ljava/lang/String;Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;Lcom/coolapk/market/view/live/LiveMessageViewHolder$Callback;Lcom/coolapk/market/view/live/CommandHelper;)V", "binding", "Lcom/coolapk/market/databinding/ItemLiveMessageBinding;", "kotlin.jvm.PlatformType", "getCallback", "()Lcom/coolapk/market/view/live/LiveMessageViewHolder$Callback;", "getCommandHelper", "()Lcom/coolapk/market/view/live/CommandHelper;", "liveMessage", "Lcom/coolapk/market/model/LiveMessage;", "nineImageHotPlug", "com/coolapk/market/view/live/LiveMessageViewHolder$nineImageHotPlug$1", "Lcom/coolapk/market/view/live/LiveMessageViewHolder$nineImageHotPlug$1;", "bindTo", "", "data", "", "createMessageBackground", "Landroid/graphics/drawable/GradientDrawable;", "isPresenter", "", "createSourceBackground", "onClick", "onRecycled", "Callback", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveMessageViewHolder.kt */
public final class LiveMessageViewHolder extends BindingViewHolder implements Recyclable {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558808;
    private final ItemLiveMessageBinding binding;
    private final Callback callback;
    private final CommandHelper commandHelper;
    private LiveMessage liveMessage;
    private final String messageType;
    private final LiveMessageViewHolder$nineImageHotPlug$1 nineImageHotPlug;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/view/live/LiveMessageViewHolder$Callback;", "", "isPresenter", "", "uid", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LiveMessageViewHolder.kt */
    public interface Callback {
        boolean isPresenter(String str);
    }

    public final Callback getCallback() {
        return this.callback;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LiveMessageViewHolder(String str, View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, Callback callback2, CommandHelper commandHelper2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, view, dataBindingComponent, itemActionHandler, callback2, (i & 32) != 0 ? null : commandHelper2);
    }

    public final CommandHelper getCommandHelper() {
        return this.commandHelper;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveMessageViewHolder(String str, View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, Callback callback2, CommandHelper commandHelper2) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(str, "messageType");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(itemActionHandler, "actionHandler");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.messageType = str;
        this.callback = callback2;
        this.commandHelper = commandHelper2;
        ItemLiveMessageBinding itemLiveMessageBinding = (ItemLiveMessageBinding) getBinding();
        this.binding = itemLiveMessageBinding;
        Space space = itemLiveMessageBinding.nineImageSpaceView;
        Intrinsics.checkNotNullExpressionValue(space, "binding.nineImageSpaceView");
        this.nineImageHotPlug = new LiveMessageViewHolder$nineImageHotPlug$1(this, dataBindingComponent, space, dataBindingComponent);
        LiveMessageViewHolder liveMessageViewHolder = this;
        itemLiveMessageBinding.nameView.setOnClickListener(liveMessageViewHolder);
        itemLiveMessageBinding.avatarView.setOnClickListener(liveMessageViewHolder);
        itemLiveMessageBinding.itemView.setOnClickListener(liveMessageViewHolder);
        itemLiveMessageBinding.itemView.setOnLongClickListener(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/live/LiveMessageViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LiveMessageViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        String str;
        CommandHelper.Command command;
        String str2;
        String str3;
        int i;
        String str4;
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.LiveMessage");
        this.liveMessage = (LiveMessage) obj;
        LinearLayout linearLayout = this.binding.itemView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemView");
        LiveMessage liveMessage2 = this.liveMessage;
        if (liveMessage2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveMessage");
        }
        linearLayout.setTag(liveMessage2);
        Callback callback2 = this.callback;
        LiveMessage liveMessage3 = this.liveMessage;
        if (liveMessage3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveMessage");
        }
        String uid = liveMessage3.getUid();
        Intrinsics.checkNotNullExpressionValue(uid, "liveMessage.uid");
        boolean isPresenter = callback2.isPresenter(uid);
        LinearLayout linearLayout2 = this.binding.messageLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.messageLayout");
        linearLayout2.setBackground(createMessageBackground(isPresenter));
        LinearLayout linearLayout3 = this.binding.sourceView;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.sourceView");
        linearLayout3.setBackground(createSourceBackground(isPresenter));
        this.binding.messageView.setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
        TextView textView = this.binding.messageView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.messageView");
        textView.setTextSize(15.0f);
        RainbowTextView rainbowTextView = this.binding.rainbowMessageView;
        Intrinsics.checkNotNullExpressionValue(rainbowTextView, "binding.rainbowMessageView");
        rainbowTextView.setTextSize(15.0f);
        RainbowTextView rainbowTextView2 = this.binding.rainbowMessageView;
        Intrinsics.checkNotNullExpressionValue(rainbowTextView2, "binding.rainbowMessageView");
        rainbowTextView2.setVisibility(8);
        String str5 = this.messageType;
        String str6 = "";
        switch (str5.hashCode()) {
            case 48:
                if (str5.equals("0")) {
                    TableLayout tableLayout = this.binding.headerLayout;
                    Intrinsics.checkNotNullExpressionValue(tableLayout, "binding.headerLayout");
                    tableLayout.setVisibility(8);
                    TextView textView2 = this.binding.messageView;
                    Intrinsics.checkNotNullExpressionValue(textView2, "binding.messageView");
                    ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
                    Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
                    RainbowTextView rainbowTextView3 = this.binding.rainbowMessageView;
                    Intrinsics.checkNotNullExpressionValue(rainbowTextView3, "binding.rainbowMessageView");
                    ViewGroup.LayoutParams layoutParams2 = rainbowTextView3.getLayoutParams();
                    Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = 0;
                    StringBuilder sb = new StringBuilder();
                    LiveMessage liveMessage4 = this.liveMessage;
                    if (liveMessage4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("liveMessage");
                    }
                    sb.append(liveMessage4.getUserName());
                    if (isPresenter) {
                        str = "(主持人)";
                    } else {
                        str = str6;
                    }
                    sb.append(str);
                    String sb2 = sb.toString();
                    CommandHelper commandHelper2 = this.commandHelper;
                    if (commandHelper2 != null) {
                        LiveMessage liveMessage5 = this.liveMessage;
                        if (liveMessage5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("liveMessage");
                        }
                        String userName = liveMessage5.getUserName();
                        Intrinsics.checkNotNullExpressionValue(userName, "liveMessage.userName");
                        command = commandHelper2.getCommand(commandHelper2.getCommandColorKey(userName));
                    } else {
                        command = null;
                    }
                    if (command != null) {
                        str2 = "<font color=\"" + ((CommandHelper.ColorNameCommand) command).getColorHex() + "\">" + sb2 + "</font>";
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("<a href=\"/u/");
                        LiveMessage liveMessage6 = this.liveMessage;
                        if (liveMessage6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("liveMessage");
                        }
                        sb3.append(liveMessage6.getUid());
                        sb3.append("\">");
                        sb3.append(sb2);
                        sb3.append("</a>");
                        str2 = sb3.toString();
                    }
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str2);
                    sb4.append(": ");
                    LiveMessage liveMessage7 = this.liveMessage;
                    if (liveMessage7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("liveMessage");
                    }
                    sb4.append(liveMessage7.getMessage());
                    TextViewBindingAdapters.setTextViewLinkable(this.binding.messageView, sb4.toString());
                    break;
                }
                break;
            case 49:
                if (str5.equals("1")) {
                    TableLayout tableLayout2 = this.binding.headerLayout;
                    Intrinsics.checkNotNullExpressionValue(tableLayout2, "binding.headerLayout");
                    tableLayout2.setVisibility(0);
                    TextView textView3 = this.binding.messageView;
                    Intrinsics.checkNotNullExpressionValue(textView3, "binding.messageView");
                    ViewGroup.LayoutParams layoutParams3 = textView3.getLayoutParams();
                    Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = NumberExtendsKt.getDp((Number) 8);
                    RainbowTextView rainbowTextView4 = this.binding.rainbowMessageView;
                    Intrinsics.checkNotNullExpressionValue(rainbowTextView4, "binding.rainbowMessageView");
                    ViewGroup.LayoutParams layoutParams4 = rainbowTextView4.getLayoutParams();
                    Objects.requireNonNull(layoutParams4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = NumberExtendsKt.getDp((Number) 8);
                    TextView textView4 = this.binding.nameView;
                    Intrinsics.checkNotNullExpressionValue(textView4, "binding.nameView");
                    StringBuilder sb5 = new StringBuilder();
                    LiveMessage liveMessage8 = this.liveMessage;
                    if (liveMessage8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("liveMessage");
                    }
                    sb5.append(liveMessage8.getUserName());
                    if (isPresenter) {
                        str3 = "(主持人)";
                    } else {
                        str3 = "(精选上墙)";
                    }
                    sb5.append(str3);
                    textView4.setText(sb5.toString());
                    TextView textView5 = this.binding.timeView;
                    Intrinsics.checkNotNullExpressionValue(textView5, "binding.timeView");
                    LiveMessage liveMessage9 = this.liveMessage;
                    if (liveMessage9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("liveMessage");
                    }
                    textView5.setText(liveMessage9.getDatelineFormat());
                    TextView textView6 = this.binding.messageView;
                    Intrinsics.checkNotNullExpressionValue(textView6, "binding.messageView");
                    textView6.setTextSize(16.0f);
                    RainbowTextView rainbowTextView5 = this.binding.rainbowMessageView;
                    Intrinsics.checkNotNullExpressionValue(rainbowTextView5, "binding.rainbowMessageView");
                    rainbowTextView5.setTextSize(16.0f);
                    TextView textView7 = this.binding.messageView;
                    Intrinsics.checkNotNullExpressionValue(textView7, "binding.messageView");
                    LiveMessage liveMessage10 = this.liveMessage;
                    if (liveMessage10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("liveMessage");
                    }
                    String message = liveMessage10.getMessage();
                    Intrinsics.checkNotNullExpressionValue(message, "liveMessage.message");
                    textView7.setVisibility(message.length() > 0 ? 0 : 8);
                    TextView textView8 = this.binding.messageView;
                    LiveMessage liveMessage11 = this.liveMessage;
                    if (liveMessage11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("liveMessage");
                    }
                    TextViewBindingAdapters.setTextViewLinkable(textView8, liveMessage11.getMessage());
                    break;
                }
                break;
            case 50:
                if (str5.equals("2")) {
                    TextView textView9 = this.binding.messageView;
                    LiveMessage liveMessage12 = this.liveMessage;
                    if (liveMessage12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("liveMessage");
                    }
                    if (liveMessage12.isRead()) {
                        i = AppHolder.getAppTheme().getColorAccent();
                    } else {
                        i = AppHolder.getAppTheme().getTextColorPrimary();
                    }
                    textView9.setTextColor(i);
                    TableLayout tableLayout3 = this.binding.headerLayout;
                    Intrinsics.checkNotNullExpressionValue(tableLayout3, "binding.headerLayout");
                    tableLayout3.setVisibility(8);
                    TextView textView10 = this.binding.messageView;
                    Intrinsics.checkNotNullExpressionValue(textView10, "binding.messageView");
                    ViewGroup.LayoutParams layoutParams5 = textView10.getLayoutParams();
                    Objects.requireNonNull(layoutParams5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = 0;
                    RainbowTextView rainbowTextView6 = this.binding.rainbowMessageView;
                    Intrinsics.checkNotNullExpressionValue(rainbowTextView6, "binding.rainbowMessageView");
                    ViewGroup.LayoutParams layoutParams6 = rainbowTextView6.getLayoutParams();
                    Objects.requireNonNull(layoutParams6, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin = 0;
                    StringBuilder sb6 = new StringBuilder();
                    LiveMessage liveMessage13 = this.liveMessage;
                    if (liveMessage13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("liveMessage");
                    }
                    sb6.append(liveMessage13.getUserName());
                    if (isPresenter) {
                        str4 = "(主持人)";
                    } else {
                        str4 = str6;
                    }
                    sb6.append(str4);
                    String sb7 = sb6.toString();
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append("<a href=\"/u/");
                    LiveMessage liveMessage14 = this.liveMessage;
                    if (liveMessage14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("liveMessage");
                    }
                    sb8.append(liveMessage14.getUid());
                    sb8.append("\">");
                    sb8.append(sb7);
                    sb8.append("</a>: ");
                    LiveMessage liveMessage15 = this.liveMessage;
                    if (liveMessage15 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("liveMessage");
                    }
                    sb8.append(liveMessage15.getMessage());
                    TextViewBindingAdapters.setTextViewLinkable(this.binding.messageView, sb8.toString());
                    break;
                }
                break;
        }
        LiveMessage liveMessage16 = this.liveMessage;
        if (liveMessage16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveMessage");
        }
        LiveMessage sourceRow = liveMessage16.getSourceRow();
        if (sourceRow != null) {
            LinearLayout linearLayout4 = this.binding.sourceView;
            Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.sourceView");
            linearLayout4.setVisibility(0);
            Callback callback3 = this.callback;
            String uid2 = sourceRow.getUid();
            Intrinsics.checkNotNullExpressionValue(uid2, "source.uid");
            boolean isPresenter2 = callback3.isPresenter(uid2);
            String userName2 = sourceRow.getUserName();
            if (isPresenter2) {
                userName2 = userName2 + "(主持人)";
            }
            TextViewBindingAdapters.setTextViewLinkable(this.binding.sourceTextView, "<a href=\"/u/" + sourceRow.getUid() + "\">" + userName2 + "</a>: " + sourceRow.getMessage());
            if (!TextUtils.isEmpty(sourceRow.getPic())) {
                FeedTextUtils feedTextUtils = FeedTextUtils.INSTANCE;
                ImageUrl create = ImageUrl.create(sourceRow.getPic(), sourceRow.getMiddleSizePic());
                Intrinsics.checkNotNullExpressionValue(create, "ImageUrl.create(source.pic, source.middleSizePic)");
                SpannableStringBuilder buildPhotoSpanText = feedTextUtils.buildPhotoSpanText(create);
                TextView textView11 = this.binding.sourceTextView;
                Intrinsics.checkNotNullExpressionValue(textView11, "binding.sourceTextView");
                TextView textView12 = this.binding.sourceTextView;
                Intrinsics.checkNotNullExpressionValue(textView12, "binding.sourceTextView");
                textView11.setText(new SpannableStringBuilder(textView12.getText()).append((CharSequence) buildPhotoSpanText).append((CharSequence) " "));
            }
        } else {
            LinearLayout linearLayout5 = this.binding.sourceView;
            Intrinsics.checkNotNullExpressionValue(linearLayout5, "binding.sourceView");
            linearLayout5.setVisibility(8);
        }
        DataBindingComponent component = getComponent();
        Objects.requireNonNull(component, "null cannot be cast to non-null type com.coolapk.market.binding.FragmentBindingComponent");
        Fragment fragment = (Fragment) ((FragmentBindingComponent) component).getContainer();
        GlideFragmentImageLoader fragmentImageLoader = AppHolder.getFragmentImageLoader();
        LiveMessage liveMessage17 = this.liveMessage;
        if (liveMessage17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveMessage");
        }
        User userInfo = liveMessage17.getUserInfo();
        Intrinsics.checkNotNull(userInfo);
        Intrinsics.checkNotNullExpressionValue(userInfo, "liveMessage.userInfo!!");
        fragmentImageLoader.displayImage(fragment, userInfo.getUserAvatar(), this.binding.avatarView, 2131231152);
        LiveMessageViewHolder$nineImageHotPlug$1 liveMessageViewHolder$nineImageHotPlug$1 = this.nineImageHotPlug;
        LiveMessage liveMessage18 = this.liveMessage;
        if (liveMessage18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveMessage");
        }
        String pic = liveMessage18.getPic();
        if (pic != null) {
            str6 = pic;
        }
        List singletonList = Collections.singletonList(str6);
        Intrinsics.checkNotNullExpressionValue(singletonList, "Collections.singletonLis…iveMessage.pic.notNull())");
        liveMessageViewHolder$nineImageHotPlug$1.bindTo(singletonList);
        this.binding.executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int id = view.getId();
        if (id == 2131362095) {
            LiveMessage liveMessage2 = this.liveMessage;
            if (liveMessage2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("liveMessage");
            }
            String userName = liveMessage2.getUserName();
            LiveMessage liveMessage3 = this.liveMessage;
            if (liveMessage3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("liveMessage");
            }
            User userInfo = liveMessage3.getUserInfo();
            Intrinsics.checkNotNull(userInfo);
            Intrinsics.checkNotNullExpressionValue(userInfo, "liveMessage.userInfo!!");
            ActionManager.startUserSpaceActivity(view, userName, userInfo.getUserAvatar());
        } else if (id == 2131362707) {
            LiveMessage liveMessage4 = this.liveMessage;
            if (liveMessage4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("liveMessage");
            }
            ActionManager.startPhotoViewActivity(view, liveMessage4.getPic(), null);
        } else if (id != 2131363000) {
            super.onClick(view);
        } else {
            Context context = getContext();
            LiveMessage liveMessage5 = this.liveMessage;
            if (liveMessage5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("liveMessage");
            }
            ActionManager.startUserSpaceActivity(context, liveMessage5.getUid());
        }
    }

    @Override // com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        this.nineImageHotPlug.onRecycled();
    }

    private final GradientDrawable createMessageBackground(boolean z) {
        int i;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        String str = this.messageType;
        int hashCode = str.hashCode();
        if (hashCode == 48 ? !str.equals("0") : hashCode != 50 || !str.equals("2")) {
            i = LiveUtils.INSTANCE.getMessageBackgroundColor();
        } else if (z) {
            i = LiveUtils.INSTANCE.getPresenterMessageBackgroundColor();
        } else {
            i = LiveUtils.INSTANCE.getMessageBackgroundColor();
        }
        ShapesKt.setSolidColor(gradientDrawable, i);
        float dp = (float) NumberExtendsKt.getDp((Number) 1);
        float dp2 = (float) NumberExtendsKt.getDp((Number) 8);
        gradientDrawable.setCornerRadii(new float[]{dp, dp, dp2, dp2, dp2, dp2, dp2, dp2});
        return gradientDrawable;
    }

    private final GradientDrawable createSourceBackground(boolean z) {
        int i;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        String str = this.messageType;
        int hashCode = str.hashCode();
        if (hashCode == 48 ? !str.equals("0") : hashCode != 50 || !str.equals("2")) {
            i = LiveUtils.INSTANCE.getSourceBackgroundColor();
        } else if (z) {
            i = LiveUtils.INSTANCE.getPresenterSourceBackgroundColor();
        } else {
            i = LiveUtils.INSTANCE.getSourceBackgroundColor();
        }
        ShapesKt.setSolidColor(gradientDrawable, i);
        float dp = (float) NumberExtendsKt.getDp((Number) 8);
        gradientDrawable.setCornerRadii(new float[]{dp, dp, dp, dp, dp, dp, dp, dp});
        return gradientDrawable;
    }
}
