package com.coolapk.market.view.message;

import android.app.Dialog;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.databinding.DialogMessageCardBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.Contacts;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.view.base.BaseDialogFragment;
import com.makeramen.roundedimageview.RoundedImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u000e\u0010\u0017\u001a\u00020\u0007*\u0004\u0018\u00010\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/coolapk/market/view/message/MessageCardDialogFragment;", "Lcom/coolapk/market/view/base/BaseDialogFragment;", "Landroid/view/View$OnClickListener;", "()V", "binding", "Lcom/coolapk/market/databinding/DialogMessageCardBinding;", "uid", "", "url", "userName", "bindData", "", "entity", "Lcom/coolapk/market/model/Entity;", "contact", "Lcom/coolapk/market/model/Contacts;", "onClick", "v", "Landroid/view/View;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "insertHostIfNeed", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MessageCardDialogFragment.kt */
public final class MessageCardDialogFragment extends BaseDialogFragment implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_CONTACTS = "EXTRA_CONTACTS";
    public static final String EXTRA_ENTITY = "EXTRA_ENTITY";
    public static final String EXTRA_FEED = "EXTRA_FEED";
    public static final String EXTRA_USER_PROFILE = "EXTRA_USER_PROFILE";
    private DialogMessageCardBinding binding;
    private String uid = "";
    private String url = "";
    private String userName = "";

    public static final /* synthetic */ DialogMessageCardBinding access$getBinding$p(MessageCardDialogFragment messageCardDialogFragment) {
        DialogMessageCardBinding dialogMessageCardBinding = messageCardDialogFragment.binding;
        if (dialogMessageCardBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return dialogMessageCardBinding;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/message/MessageCardDialogFragment$Companion;", "", "()V", "EXTRA_CONTACTS", "", "EXTRA_ENTITY", "EXTRA_FEED", "EXTRA_USER_PROFILE", "newInstance", "Lcom/coolapk/market/view/message/MessageCardDialogFragment;", "entity", "Lcom/coolapk/market/model/Entity;", "contact", "Lcom/coolapk/market/model/Contacts;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MessageCardDialogFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MessageCardDialogFragment newInstance(Entity entity, Contacts contacts) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(contacts, "contact");
            MessageCardDialogFragment messageCardDialogFragment = new MessageCardDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("EXTRA_ENTITY", entity);
            bundle.putParcelable("EXTRA_CONTACTS", contacts);
            Unit unit = Unit.INSTANCE;
            messageCardDialogFragment.setArguments(bundle);
            return messageCardDialogFragment;
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Contacts contacts = (Contacts) requireArguments().getParcelable("EXTRA_CONTACTS");
        Entity entity = (Entity) requireArguments().getParcelable("EXTRA_ENTITY");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131558532, null, false, new ContextBindingComponent(getActivity()));
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…ndingComponent(activity))");
        this.binding = (DialogMessageCardBinding) inflate;
        if (entity != null) {
            Intrinsics.checkNotNull(contacts);
            bindData(entity, contacts);
        }
        DialogMessageCardBinding dialogMessageCardBinding = this.binding;
        if (dialogMessageCardBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dialogMessageCardBinding.setContact(contacts);
        DialogMessageCardBinding dialogMessageCardBinding2 = this.binding;
        if (dialogMessageCardBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = dialogMessageCardBinding2.contentLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.contentLayout");
        linearLayout.setBackground(ShapeUtils.createStrokeBg(getActivity(), 8, AppHolder.getAppTheme().getContentBackgroundDividerColor(), 1.0f, 0));
        DialogMessageCardBinding dialogMessageCardBinding3 = this.binding;
        if (dialogMessageCardBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dialogMessageCardBinding3.dialogConfirm.setTextColor(AppHolder.getAppTheme().getColorAccent());
        DialogMessageCardBinding dialogMessageCardBinding4 = this.binding;
        if (dialogMessageCardBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dialogMessageCardBinding4.setClick(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        DialogMessageCardBinding dialogMessageCardBinding5 = this.binding;
        if (dialogMessageCardBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AlertDialog create = builder.setView(dialogMessageCardBinding5.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "androidx.appcompat.app.A…                .create()");
        create.setCanceledOnTouchOutside(false);
        create.setCancelable(false);
        return create;
    }

    /* JADX WARNING: Removed duplicated region for block: B:116:0x029c  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x02aa  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x02ad  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x02b5  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x02de  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x02ea  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02ed  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02f5  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0307  */
    public final void bindData(Entity entity, Contacts contacts) {
        boolean z;
        DialogMessageCardBinding dialogMessageCardBinding;
        DialogMessageCardBinding dialogMessageCardBinding2;
        boolean z2;
        DialogMessageCardBinding dialogMessageCardBinding3;
        DialogMessageCardBinding dialogMessageCardBinding4;
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(contacts, "contact");
        DialogMessageCardBinding dialogMessageCardBinding5 = this.binding;
        if (dialogMessageCardBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dialogMessageCardBinding5.setToAvatar(contacts.getUserAvatar());
        DialogMessageCardBinding dialogMessageCardBinding6 = this.binding;
        if (dialogMessageCardBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dialogMessageCardBinding6.setToTitle(contacts.getUserName());
        String uid2 = contacts.getUid();
        Intrinsics.checkNotNullExpressionValue(uid2, "contact.uid");
        this.uid = uid2;
        String userName2 = contacts.getUserName();
        Intrinsics.checkNotNullExpressionValue(userName2, "contact.userName");
        this.userName = userName2;
        boolean z3 = true;
        int i = 0;
        if (entity instanceof Album) {
            DialogMessageCardBinding dialogMessageCardBinding7 = this.binding;
            if (dialogMessageCardBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            Album album = (Album) entity;
            dialogMessageCardBinding7.setContentTitle(album.getTitle());
            DialogMessageCardBinding dialogMessageCardBinding8 = this.binding;
            if (dialogMessageCardBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            dialogMessageCardBinding8.setContent(album.getDescription());
            DialogMessageCardBinding dialogMessageCardBinding9 = this.binding;
            if (dialogMessageCardBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            String icon = album.getIcon();
            dialogMessageCardBinding9.setPic(icon == null || icon.length() == 0 ? album.getUserAvatar() : album.getIcon());
            DialogMessageCardBinding dialogMessageCardBinding10 = this.binding;
            if (dialogMessageCardBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            dialogMessageCardBinding10.setFromTitle(album.getUserName() + "的应用集");
            DialogMessageCardBinding dialogMessageCardBinding11 = this.binding;
            if (dialogMessageCardBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            dialogMessageCardBinding11.setFromAvatar(album.getUserAvatar());
            this.url = "https://www.coolapk.com" + album.getUrl();
            DialogMessageCardBinding dialogMessageCardBinding12 = this.binding;
            if (dialogMessageCardBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView = dialogMessageCardBinding12.titleMessage;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleMessage");
            textView.setTypeface(Typeface.defaultFromStyle(1));
            DialogMessageCardBinding dialogMessageCardBinding13 = this.binding;
            if (dialogMessageCardBinding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            RoundedImageView roundedImageView = dialogMessageCardBinding13.contentPicView;
            Intrinsics.checkNotNullExpressionValue(roundedImageView, "binding.contentPicView");
            roundedImageView.setBorderWidth(NumberExtendsKt.getDpf((Number) 1));
            DialogMessageCardBinding dialogMessageCardBinding14 = this.binding;
            if (dialogMessageCardBinding14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            RoundedImageView roundedImageView2 = dialogMessageCardBinding14.contentPicView;
            Intrinsics.checkNotNullExpressionValue(roundedImageView2, "binding.contentPicView");
            roundedImageView2.setBorderColor(AppHolder.getAppTheme().getContentBackgroundDividerColor());
        } else if (entity instanceof Feed) {
            DialogMessageCardBinding dialogMessageCardBinding15 = this.binding;
            if (dialogMessageCardBinding15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            Feed feed = (Feed) entity;
            dialogMessageCardBinding15.setContentTitle(feed.getMessageTitle());
            DialogMessageCardBinding dialogMessageCardBinding16 = this.binding;
            if (dialogMessageCardBinding16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            dialogMessageCardBinding16.setContent(feed.getMessage());
            DialogMessageCardBinding dialogMessageCardBinding17 = this.binding;
            if (dialogMessageCardBinding17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            String pic = feed.getPic();
            dialogMessageCardBinding17.setPic(pic == null || pic.length() == 0 ? feed.getUserAvatar() : feed.getPic());
            DialogMessageCardBinding dialogMessageCardBinding18 = this.binding;
            if (dialogMessageCardBinding18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            dialogMessageCardBinding18.setFromTitle(feed.getUserName() + (char) 30340 + feed.getFeedTypeName());
            DialogMessageCardBinding dialogMessageCardBinding19 = this.binding;
            if (dialogMessageCardBinding19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            dialogMessageCardBinding19.setFromAvatar(feed.getUserAvatar());
            String shareUrl = feed.getShareUrl();
            Intrinsics.checkNotNull(shareUrl);
            this.url = shareUrl;
            DialogMessageCardBinding dialogMessageCardBinding20 = this.binding;
            if (dialogMessageCardBinding20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView2 = dialogMessageCardBinding20.titleMessage;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleMessage");
            textView2.setTypeface(Typeface.defaultFromStyle(1));
        } else if (entity instanceof UserProfile) {
            DialogMessageCardBinding dialogMessageCardBinding21 = this.binding;
            if (dialogMessageCardBinding21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            UserProfile userProfile = (UserProfile) entity;
            dialogMessageCardBinding21.setContentTitle(userProfile.getUserName());
            DialogMessageCardBinding dialogMessageCardBinding22 = this.binding;
            if (dialogMessageCardBinding22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            dialogMessageCardBinding22.setContent(userProfile.getFeedNum() + "动态 " + userProfile.getFansNum() + "粉丝");
            DialogMessageCardBinding dialogMessageCardBinding23 = this.binding;
            if (dialogMessageCardBinding23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            dialogMessageCardBinding23.setPic(userProfile.getUserAvatar());
            DialogMessageCardBinding dialogMessageCardBinding24 = this.binding;
            if (dialogMessageCardBinding24 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            dialogMessageCardBinding24.setFromTitle("酷友名片");
            DialogMessageCardBinding dialogMessageCardBinding25 = this.binding;
            if (dialogMessageCardBinding25 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            dialogMessageCardBinding25.setFromAvatar("");
            this.url = "https://www.coolapk.com/u/" + userProfile.getUid();
            DialogMessageCardBinding dialogMessageCardBinding26 = this.binding;
            if (dialogMessageCardBinding26 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView3 = dialogMessageCardBinding26.titleMessage;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.titleMessage");
            textView3.setTypeface(Typeface.defaultFromStyle(0));
        } else if (entity instanceof DyhArticle) {
            this.url = insertHostIfNeed(((DyhArticle) entity).getRedirectUrl());
        } else {
            this.url = insertHostIfNeed(entity.getUrl());
        }
        DialogMessageCardBinding dialogMessageCardBinding27 = this.binding;
        if (dialogMessageCardBinding27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        if (TextUtils.isEmpty(dialogMessageCardBinding27.getContentTitle())) {
            DialogMessageCardBinding dialogMessageCardBinding28 = this.binding;
            if (dialogMessageCardBinding28 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            if (TextUtils.isEmpty(dialogMessageCardBinding28.getContent())) {
                DialogMessageCardBinding dialogMessageCardBinding29 = this.binding;
                if (dialogMessageCardBinding29 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                if (TextUtils.isEmpty(dialogMessageCardBinding29.getPic())) {
                    z = true;
                    dialogMessageCardBinding = this.binding;
                    if (dialogMessageCardBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    LinearLayout linearLayout = dialogMessageCardBinding.contentCard;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.contentCard");
                    linearLayout.setVisibility(!z ? 8 : 0);
                    dialogMessageCardBinding2 = this.binding;
                    if (dialogMessageCardBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    if (TextUtils.isEmpty(dialogMessageCardBinding2.getFromAvatar())) {
                        DialogMessageCardBinding dialogMessageCardBinding30 = this.binding;
                        if (dialogMessageCardBinding30 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        if (TextUtils.isEmpty(dialogMessageCardBinding30.getFromTitle())) {
                            z2 = true;
                            dialogMessageCardBinding3 = this.binding;
                            if (dialogMessageCardBinding3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                            }
                            LinearLayout linearLayout2 = dialogMessageCardBinding3.authorView;
                            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.authorView");
                            linearLayout2.setVisibility(z2 ? 8 : 0);
                            dialogMessageCardBinding4 = this.binding;
                            if (dialogMessageCardBinding4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                            }
                            LinearLayout linearLayout3 = dialogMessageCardBinding4.contentLayout;
                            Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.contentLayout");
                            if (!z2 || !z) {
                                z3 = false;
                            }
                            if (z3) {
                                i = 8;
                            }
                            linearLayout3.setVisibility(i);
                        }
                    }
                    z2 = false;
                    dialogMessageCardBinding3 = this.binding;
                    if (dialogMessageCardBinding3 == null) {
                    }
                    LinearLayout linearLayout2 = dialogMessageCardBinding3.authorView;
                    Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.authorView");
                    linearLayout2.setVisibility(z2 ? 8 : 0);
                    dialogMessageCardBinding4 = this.binding;
                    if (dialogMessageCardBinding4 == null) {
                    }
                    LinearLayout linearLayout3 = dialogMessageCardBinding4.contentLayout;
                    Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.contentLayout");
                    z3 = false;
                    if (z3) {
                    }
                    linearLayout3.setVisibility(i);
                }
            }
        }
        z = false;
        dialogMessageCardBinding = this.binding;
        if (dialogMessageCardBinding == null) {
        }
        LinearLayout linearLayout = dialogMessageCardBinding.contentCard;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.contentCard");
        linearLayout.setVisibility(!z ? 8 : 0);
        dialogMessageCardBinding2 = this.binding;
        if (dialogMessageCardBinding2 == null) {
        }
        if (TextUtils.isEmpty(dialogMessageCardBinding2.getFromAvatar())) {
        }
        z2 = false;
        dialogMessageCardBinding3 = this.binding;
        if (dialogMessageCardBinding3 == null) {
        }
        LinearLayout linearLayout2 = dialogMessageCardBinding3.authorView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.authorView");
        linearLayout2.setVisibility(z2 ? 8 : 0);
        dialogMessageCardBinding4 = this.binding;
        if (dialogMessageCardBinding4 == null) {
        }
        LinearLayout linearLayout3 = dialogMessageCardBinding4.contentLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.contentLayout");
        z3 = false;
        if (z3) {
        }
        linearLayout3.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNull(view);
        int id = view.getId();
        if (id == 2131362402) {
            dismiss();
        } else if (id == 2131362404) {
            DialogMessageCardBinding dialogMessageCardBinding = this.binding;
            if (dialogMessageCardBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ProgressBar progressBar = dialogMessageCardBinding.loadingView;
            Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
            progressBar.setVisibility(0);
            DialogMessageCardBinding dialogMessageCardBinding2 = this.binding;
            if (dialogMessageCardBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView = dialogMessageCardBinding2.dialogConfirm;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.dialogConfirm");
            textView.setVisibility(4);
            DataManager.getInstance().sendMessage(this.uid, this.url, "", "").compose(RxUtils.apiCommonToData()).subscribe(new MessageCardDialogFragment$onClick$1(this), new MessageCardDialogFragment$onClick$2(this));
        }
    }

    private final String insertHostIfNeed(String str) {
        if (str == null) {
            str = "";
        }
        boolean z = true;
        if (!(str.length() > 0)) {
            return str;
        }
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(url)");
        String host = parse.getHost();
        if (!(host == null || host.length() == 0)) {
            z = false;
        }
        if (!z) {
            return str;
        }
        return "https://www.coolapk.com" + str;
    }
}
