package com.coolapk.market.view.userv9;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.UserDataBinding;
import com.coolapk.market.event.UserProfileEvent;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0016J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068B@BX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006$"}, d2 = {"Lcom/coolapk/market/view/userv9/UserDataFragment;", "Lcom/coolapk/market/view/base/BaseFragment;", "()V", "binding", "Lcom/coolapk/market/databinding/UserDataBinding;", "value", "Lcom/coolapk/market/model/UserProfile;", "userProfile", "getUserProfile", "()Lcom/coolapk/market/model/UserProfile;", "setUserProfile", "(Lcom/coolapk/market/model/UserProfile;)V", "createChildInfoView", "Landroid/view/View;", "content", "", "listener", "Landroid/view/View$OnClickListener;", "getUserMrs", "data", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onUserProfileEvent", "event", "Lcom/coolapk/market/event/UserProfileEvent;", "setUIView", "showRegisterToast", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserDataFragment.kt */
public final class UserDataFragment extends BaseFragment {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_EXTRA_PROFILE = "PROFILE";
    private UserDataBinding binding;

    private final UserProfile getUserProfile() {
        Parcelable parcelable = requireArguments().getParcelable("PROFILE");
        Intrinsics.checkNotNull(parcelable);
        return (UserProfile) parcelable;
    }

    private final void setUserProfile(UserProfile userProfile) {
        requireArguments().putParcelable("PROFILE", userProfile);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/userv9/UserDataFragment$Companion;", "", "()V", "KEY_EXTRA_PROFILE", "", "newInstance", "Lcom/coolapk/market/view/userv9/UserQRCodeFragment;", "userProfile", "Lcom/coolapk/market/model/UserProfile;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserDataFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UserQRCodeFragment newInstance(UserProfile userProfile) {
            Intrinsics.checkNotNullParameter(userProfile, "userProfile");
            UserQRCodeFragment userQRCodeFragment = new UserQRCodeFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("PROFILE", userProfile);
            Unit unit = Unit.INSTANCE;
            userQRCodeFragment.setArguments(bundle);
            return userQRCodeFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131559291, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…r_data, container, false)");
        UserDataBinding userDataBinding = (UserDataBinding) inflate;
        this.binding = userDataBinding;
        if (userDataBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return userDataBinding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        EventBus.getDefault().register(this);
        setUIView(getUserProfile());
    }

    private final void setUIView(UserProfile userProfile) {
        String uid = userProfile.getUid();
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        boolean areEqual = Intrinsics.areEqual(uid, loginSession.getUid());
        String signature = userProfile.getSignature();
        boolean z = false;
        String signature2 = !(signature == null || signature.length() == 0) ? userProfile.getSignature() : requireActivity().getString(2131886754);
        UserDataBinding userDataBinding = this.binding;
        if (userDataBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = userDataBinding.signatureView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.signatureView");
        textView.setText(signature2);
        String userMrs = getUserMrs(userProfile);
        Long days = DateUtils.getDays(Long.valueOf(userProfile.getRegDate() * ((long) 1000)));
        UserDataBinding userDataBinding2 = this.binding;
        if (userDataBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView2 = userDataBinding2.regDateView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.regDateView");
        textView2.setText(userMrs + "来到酷安已经" + ((int) days.longValue()) + "天了");
        UserDataBinding userDataBinding3 = this.binding;
        if (userDataBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userDataBinding3.regDateView.setOnClickListener(new UserDataFragment$setUIView$1(this, userProfile));
        UserDataFragment$setUIView$editActionListener$1 userDataFragment$setUIView$editActionListener$1 = new UserDataFragment$setUIView$editActionListener$1(this);
        ArrayList<View> arrayList = new ArrayList();
        arrayList.add(createChildInfoView$default(this, "等级：LV " + userProfile.getLevel(), null, 2, null));
        if (userProfile.getGender() >= 0) {
            String str = userProfile.getGender() == 0 ? "女" : "男";
            arrayList.add(createChildInfoView$default(this, "性别：" + str, null, 2, null));
        } else if (areEqual) {
            arrayList.add(createChildInfoView("性别：未填写", userDataFragment$setUIView$editActionListener$1));
        }
        String addressString = userProfile.getAddressString();
        Intrinsics.checkNotNullExpressionValue(addressString, "data.addressString");
        if (addressString.length() > 0) {
            arrayList.add(createChildInfoView$default(this, "城市：" + userProfile.getAddressString(), null, 2, null));
        } else if (areEqual) {
            arrayList.add(createChildInfoView("城市：未填写", userDataFragment$setUIView$editActionListener$1));
        }
        if (EntityExtendsKt.getGenerationString(userProfile).length() > 0) {
            arrayList.add(createChildInfoView$default(this, "年龄：" + EntityExtendsKt.getGenerationString(userProfile), null, 2, null));
        } else if (areEqual) {
            arrayList.add(createChildInfoView("年龄：未填写", userDataFragment$setUIView$editActionListener$1));
        }
        String zodiacSign = userProfile.getZodiacSign();
        if (zodiacSign == null) {
            zodiacSign = "";
        }
        if (zodiacSign.length() > 0) {
            z = true;
        }
        if (z) {
            arrayList.add(createChildInfoView$default(this, "星座：" + userProfile.getZodiacSign(), null, 2, null));
        } else if (areEqual) {
            arrayList.add(createChildInfoView("星座：未填写", userDataFragment$setUIView$editActionListener$1));
        }
        UserDataBinding userDataBinding4 = this.binding;
        if (userDataBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userDataBinding4.infoDataContent.removeAllViews();
        for (View view : arrayList) {
            UserDataBinding userDataBinding5 = this.binding;
            if (userDataBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            userDataBinding5.infoDataContent.addView(view);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public final void onUserProfileEvent(UserProfileEvent userProfileEvent) {
        Intrinsics.checkNotNullParameter(userProfileEvent, "event");
        UserProfile userProfile = getUserProfile();
        if (userProfileEvent.canMatchUpWith(userProfile)) {
            UserProfile patch = userProfileEvent.patch(userProfile);
            String type = userProfileEvent.getType();
            switch (type.hashCode()) {
                case -410342769:
                    if (!type.equals("address_event")) {
                        return;
                    }
                    break;
                case -348261476:
                    if (!type.equals("gender_event")) {
                        return;
                    }
                    break;
                case -288816045:
                    if (!type.equals("signature_event")) {
                        return;
                    }
                    break;
                case 1872264986:
                    if (!type.equals("birth_event")) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            setUIView(patch);
        }
    }

    static /* synthetic */ View createChildInfoView$default(UserDataFragment userDataFragment, String str, View.OnClickListener onClickListener, int i, Object obj) {
        if ((i & 2) != 0) {
            onClickListener = null;
        }
        return userDataFragment.createChildInfoView(str, onClickListener);
    }

    private final View createChildInfoView(String str, View.OnClickListener onClickListener) {
        TextView textView = new TextView(getActivity());
        textView.setTextColor(AppHolder.getAppTheme().getTextColorSecondary());
        textView.setTextSize(14.0f);
        textView.setText(str);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = NumberExtendsKt.getDp((Number) 8);
        Unit unit = Unit.INSTANCE;
        textView.setLayoutParams(layoutParams);
        if (onClickListener != null) {
            textView.setOnClickListener(onClickListener);
        }
        return textView;
    }

    private final String getUserMrs(UserProfile userProfile) {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        if (Intrinsics.areEqual(loginSession.getUid(), userProfile.getUid())) {
            return "你";
        }
        if (userProfile.getGender() >= 1) {
            return "他";
        }
        return userProfile.getGender() == 0 ? "她" : "TA";
    }

    /* access modifiers changed from: private */
    public final void showRegisterToast(UserProfile userProfile) {
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "cal");
        instance.setTimeInMillis(userProfile.getRegDate() * ((long) 1000));
        String userMrs = getUserMrs(userProfile);
        FragmentActivity activity = getActivity();
        Toast.show$default(activity, instance.get(1) + (char) 24180 + (instance.get(2) + 1) + (char) 26376 + instance.get(5) + (char) 26085 + userMrs + "来到了酷安💖", 0, false, 12, null);
    }
}
