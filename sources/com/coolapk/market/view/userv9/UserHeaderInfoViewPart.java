package com.coolapk.market.view.userv9;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.databinding.ItemUserInfoHeaderViewBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.util.ColorUtil2;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.view.product.ProductGlobalData;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import com.coolapk.market.widget.CoolFlowLayout;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.emotion.ImageSpanAlignCenter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\"B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J,\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0003H\u0014J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\nH\u0016J\u001a\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0015H\u0014J\u000e\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0003J\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0003J\u000e\u0010 \u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0003J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0003H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/coolapk/market/view/userv9/UserHeaderInfoViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemUserInfoHeaderViewBinding;", "Lcom/coolapk/market/model/UserProfile;", "presenter", "Lcom/coolapk/market/view/userv9/UserSpaceV9Presenter;", "viewModel", "Lcom/coolapk/market/view/userv9/UserSpaceV9ViewModel;", "(Lcom/coolapk/market/view/userv9/UserSpaceV9Presenter;Lcom/coolapk/market/view/userv9/UserSpaceV9ViewModel;)V", "createGenderAgeView", "Landroid/view/View;", "data", "createTagView", "backgroundColor", "", "textColor", "content", "", "listener", "Landroid/view/View$OnClickListener;", "onBindToContent", "", "onClick", "v", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "setFlowLayoutView", "setFollowState", "setSignatureView", "setVerifiedView", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserHeaderInfoViewPart.kt */
public final class UserHeaderInfoViewPart extends BindingViewPart<ItemUserInfoHeaderViewBinding, UserProfile> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558981;
    private final UserSpaceV9Presenter presenter;
    private final UserSpaceV9ViewModel viewModel;

    public UserHeaderInfoViewPart(UserSpaceV9Presenter userSpaceV9Presenter, UserSpaceV9ViewModel userSpaceV9ViewModel) {
        Intrinsics.checkNotNullParameter(userSpaceV9Presenter, "presenter");
        Intrinsics.checkNotNullParameter(userSpaceV9ViewModel, "viewModel");
        this.presenter = userSpaceV9Presenter;
        this.viewModel = userSpaceV9ViewModel;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/userv9/UserHeaderInfoViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserHeaderInfoViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemUserInfoHeaderViewBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558981, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…OUT_ID, viewGroup, false)");
        return (ItemUserInfoHeaderViewBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        UserHeaderInfoViewPart userHeaderInfoViewPart = this;
        ((ItemUserInfoHeaderViewBinding) getBinding()).fansViewContainer.setOnClickListener(userHeaderInfoViewPart);
        ((ItemUserInfoHeaderViewBinding) getBinding()).followViewContainer.setOnClickListener(userHeaderInfoViewPart);
        ((ItemUserInfoHeaderViewBinding) getBinding()).editSignatureView.setOnClickListener(userHeaderInfoViewPart);
        Typeface numberTypeface = ProductGlobalData.getNumberTypeface(getContext());
        TextView textView = ((ItemUserInfoHeaderViewBinding) getBinding()).fansNumView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.fansNumView");
        textView.setTypeface(numberTypeface);
        TextView textView2 = ((ItemUserInfoHeaderViewBinding) getBinding()).followNumView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.followNumView");
        textView2.setTypeface(numberTypeface);
        TextView textView3 = ((ItemUserInfoHeaderViewBinding) getBinding()).likeNumView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.likeNumView");
        textView3.setTypeface(numberTypeface);
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(UserProfile userProfile) {
        Intrinsics.checkNotNullParameter(userProfile, "data");
        super.onBindToContent((UserHeaderInfoViewPart) userProfile);
        LinearLayout linearLayout = ((ItemUserInfoHeaderViewBinding) getBinding()).vViewContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.vViewContainer");
        linearLayout.setVisibility(8);
        if (userProfile.getBeLikeNum() > 0) {
            TextView textView = ((ItemUserInfoHeaderViewBinding) getBinding()).likeNumView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.likeNumView");
            textView.setText(String.valueOf(userProfile.getBeLikeNum()));
            LinearLayout linearLayout2 = ((ItemUserInfoHeaderViewBinding) getBinding()).likeViewContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.likeViewContainer");
            linearLayout2.setVisibility(0);
        } else {
            LinearLayout linearLayout3 = ((ItemUserInfoHeaderViewBinding) getBinding()).likeViewContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.likeViewContainer");
            linearLayout3.setVisibility(8);
        }
        setSignatureView(userProfile);
        setFollowState(userProfile);
        setFlowLayoutView(userProfile);
        setVerifiedView(userProfile);
        ((ItemUserInfoHeaderViewBinding) getBinding()).executePendingBindings();
    }

    private final void setVerifiedView(UserProfile userProfile) {
        int verifyTextToIconRes = UserAvatarView.Companion.verifyTextToIconRes(userProfile.getVerifyStatusIcon());
        if (verifyTextToIconRes != 0) {
            LinearLayout linearLayout = ((ItemUserInfoHeaderViewBinding) getBinding()).vViewContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.vViewContainer");
            linearLayout.setVisibility(0);
            Drawable drawable = ResourceUtils.getDrawable(getContext(), verifyTextToIconRes);
            drawable.setBounds(0, 0, NumberExtendsKt.getDp((Number) 16), NumberExtendsKt.getDp((Number) 16));
            ((ItemUserInfoHeaderViewBinding) getBinding()).vIconView.setImageBitmap(BitmapUtil.drawableToBitmap(drawable));
            TextView textView = ((ItemUserInfoHeaderViewBinding) getBinding()).vTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.vTextView");
            textView.setText(userProfile.getVerifyTitle());
            return;
        }
        LinearLayout linearLayout2 = ((ItemUserInfoHeaderViewBinding) getBinding()).vViewContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.vViewContainer");
        linearLayout2.setVisibility(8);
    }

    public final void setSignatureView(UserProfile userProfile) {
        Intrinsics.checkNotNullParameter(userProfile, "data");
        String signature = userProfile.getSignature();
        boolean z = true;
        int i = 0;
        boolean z2 = signature == null || signature.length() == 0;
        String signature2 = userProfile.getSignature();
        String signature3 = !(signature2 == null || signature2.length() == 0) ? userProfile.getSignature() : getContext().getString(2131886754);
        TextView textView = ((ItemUserInfoHeaderViewBinding) getBinding()).signatureView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.signatureView");
        textView.setText(signature3);
        TextView textView2 = ((ItemUserInfoHeaderViewBinding) getBinding()).signatureView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.signatureView");
        textView2.setVisibility(z2 ? 8 : 0);
        LinearLayout linearLayout = ((ItemUserInfoHeaderViewBinding) getBinding()).editSignatureView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.editSignatureView");
        LinearLayout linearLayout2 = linearLayout;
        if (!this.viewModel.isLoginUser() || !z2) {
            z = false;
        }
        if (!z) {
            i = 8;
        }
        linearLayout2.setVisibility(i);
    }

    public final void setFlowLayoutView(UserProfile userProfile) {
        Intrinsics.checkNotNullParameter(userProfile, "data");
        UserHeaderInfoViewPart$setFlowLayoutView$userDataListener$1 userHeaderInfoViewPart$setFlowLayoutView$userDataListener$1 = new UserHeaderInfoViewPart$setFlowLayoutView$userDataListener$1(this, userProfile);
        ArrayList arrayList = new ArrayList();
        String verifyLabel = userProfile.getVerifyLabel();
        String str = "";
        if (verifyLabel == null) {
            verifyLabel = str;
        }
        String str2 = verifyLabel;
        if (str2.length() > 0) {
            arrayList.add(createTagView$default(this, ColorUtil2.INSTANCE.setAlphaComponent(UserAvatarView.Companion.verifyTextToIconColor(userProfile.getVerifyStatusIcon()), 128), -1, str2, null, 8, null));
        }
        View createGenderAgeView = createGenderAgeView(userProfile);
        if (createGenderAgeView != null) {
            createGenderAgeView.setOnClickListener(userHeaderInfoViewPart$setFlowLayoutView$userDataListener$1);
            arrayList.add(createGenderAgeView);
        }
        String addressString = userProfile.getAddressString();
        Intrinsics.checkNotNullExpressionValue(addressString, "data.addressString");
        if (addressString.length() > 0) {
            String addressString2 = userProfile.getAddressString();
            Intrinsics.checkNotNullExpressionValue(addressString2, "data.addressString");
            arrayList.add(createTagView(1308622847, -1, addressString2, userHeaderInfoViewPart$setFlowLayoutView$userDataListener$1));
        }
        String zodiacSign = userProfile.getZodiacSign();
        if (!(zodiacSign == null || zodiacSign.length() == 0)) {
            String zodiacSign2 = userProfile.getZodiacSign();
            if (zodiacSign2 != null) {
                str = zodiacSign2;
            }
            arrayList.add(createTagView(1308622847, -1, str, userHeaderInfoViewPart$setFlowLayoutView$userDataListener$1));
        }
        if (userProfile.getLoginTime() > 0) {
            String string = getContext().getString(2131887162, DateUtils.getTimeDescription(getContext(), Long.valueOf(userProfile.getLoginTime())));
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…context, data.loginTime))");
            arrayList.add(createTagView$default(this, 1308622847, -1, string, null, 8, null));
        }
        if (arrayList.isEmpty()) {
            CoolFlowLayout coolFlowLayout = ((ItemUserInfoHeaderViewBinding) getBinding()).flowLayout;
            Intrinsics.checkNotNullExpressionValue(coolFlowLayout, "binding.flowLayout");
            coolFlowLayout.setVisibility(8);
            return;
        }
        CoolFlowLayout coolFlowLayout2 = ((ItemUserInfoHeaderViewBinding) getBinding()).flowLayout;
        Intrinsics.checkNotNullExpressionValue(coolFlowLayout2, "binding.flowLayout");
        coolFlowLayout2.setVisibility(0);
        ((ItemUserInfoHeaderViewBinding) getBinding()).flowLayout.setHorizontalDividerWidth(NumberExtendsKt.getDp((Number) 8));
        ((ItemUserInfoHeaderViewBinding) getBinding()).flowLayout.setVerticalDividerHeight(NumberExtendsKt.getDp((Number) 8));
        ((ItemUserInfoHeaderViewBinding) getBinding()).flowLayout.setLayoutMode("FLEX");
        ((ItemUserInfoHeaderViewBinding) getBinding()).flowLayout.setAdapter(new UserHeaderInfoViewPart$setFlowLayoutView$1(this, arrayList, getContext(), 0, arrayList));
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008f  */
    private final View createGenderAgeView(UserProfile userProfile) {
        int i;
        int i2;
        SpannableStringBuilder spannableStringBuilder;
        String generationString;
        SpannableStringBuilder spannableStringBuilder2;
        long j;
        boolean z = true;
        if (userProfile.getGender() == 0) {
            j = 2163371482L;
        } else if (userProfile.getGender() == 1) {
            j = 2149684979L;
        } else {
            i = 1308622847;
            if (userProfile.getGender() != 0) {
                i2 = 2131231338;
            } else {
                i2 = userProfile.getGender() == 1 ? 2131231340 : 0;
            }
            if (i2 != 0) {
                spannableStringBuilder = null;
            } else {
                spannableStringBuilder = new SpannableStringBuilder("[GENDER]");
                spannableStringBuilder.setSpan(new ImageSpanAlignCenter(getContext().getDrawable(i2), spannableStringBuilder.toString()), 0, spannableStringBuilder.length(), 33);
            }
            generationString = EntityExtendsKt.getGenerationString(userProfile);
            if ((generationString.length() <= 0) && spannableStringBuilder == null) {
                return null;
            }
            if (spannableStringBuilder == null) {
                if (generationString.length() <= 0) {
                    z = false;
                }
                if (z) {
                    spannableStringBuilder = spannableStringBuilder.append((CharSequence) " ").append((CharSequence) generationString);
                }
                spannableStringBuilder2 = spannableStringBuilder;
            } else {
                spannableStringBuilder2 = generationString;
            }
            Intrinsics.checkNotNullExpressionValue(spannableStringBuilder2, "genderAgeString");
            return createTagView$default(this, i, -1, spannableStringBuilder2, null, 8, null);
        }
        i = (int) j;
        if (userProfile.getGender() != 0) {
        }
        if (i2 != 0) {
        }
        generationString = EntityExtendsKt.getGenerationString(userProfile);
        if (generationString.length() <= 0) {
        }
        if (spannableStringBuilder == null) {
        }
        Intrinsics.checkNotNullExpressionValue(spannableStringBuilder2, "genderAgeString");
        return createTagView$default(this, i, -1, spannableStringBuilder2, null, 8, null);
    }

    static /* synthetic */ View createTagView$default(UserHeaderInfoViewPart userHeaderInfoViewPart, int i, int i2, CharSequence charSequence, View.OnClickListener onClickListener, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            onClickListener = null;
        }
        return userHeaderInfoViewPart.createTagView(i, i2, charSequence, onClickListener);
    }

    private final View createTagView(int i, int i2, CharSequence charSequence, View.OnClickListener onClickListener) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(12.0f);
        textView.setText(charSequence);
        TextView textView2 = textView;
        ViewExtendsKt.clipView$default(textView2, 2, 0.0f, 2, null);
        textView.setGravity(17);
        textView.setTextColor(i2);
        textView.setBackgroundColor(i);
        if (onClickListener != null) {
            textView.setOnClickListener(onClickListener);
        }
        textView.setPadding(NumberExtendsKt.getDp((Number) 8), NumberExtendsKt.getDp((Number) 2), NumberExtendsKt.getDp((Number) 8), NumberExtendsKt.getDp((Number) 2));
        return textView2;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        super.onClick(view);
        UserProfile userProfile = this.viewModel.getUserProfile();
        if (userProfile != null) {
            int id = view.getId();
            if (id == 2131362446) {
                ActionManager.startUserProfileActivity(getContext(), "编辑资料");
            } else if (id == 2131362521) {
                String string = getContext().getString(2131887149, userProfile.getUserName());
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…fans_list, data.userName)");
                ActionManager.startFansListActivity(getContext(), userProfile.getUid(), string);
            } else if (id == 2131362591) {
                String string2 = getContext().getString(2131887153, userProfile.getUserName());
                Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…llow_list, data.userName)");
                ActionManager.startFriendListActivity(getContext(), userProfile.getUid(), string2);
            }
        }
    }

    public final void setFollowState(UserProfile userProfile) {
        Intrinsics.checkNotNullParameter(userProfile, "data");
        boolean z = userProfile.getIsFollow() > 0;
        boolean follow = this.viewModel.getFollow();
        int i = z != follow ? follow ? 1 : -1 : 0;
        TextView textView = ((ItemUserInfoHeaderViewBinding) getBinding()).followNumView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.followNumView");
        textView.setText(String.valueOf(KotlinExtendKt.constrain$default(userProfile.getFollowNum(), 0, 0, 1, (Object) null)));
        TextView textView2 = ((ItemUserInfoHeaderViewBinding) getBinding()).fansNumView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.fansNumView");
        textView2.setText(String.valueOf(KotlinExtendKt.constrain$default(userProfile.getFansNum() + i, 0, 0, 1, (Object) null)));
    }
}
