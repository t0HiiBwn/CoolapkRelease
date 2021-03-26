package com.coolapk.market.view.live;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.LiveIntroduceBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Live;
import com.coolapk.market.model.User;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.view.base.BaseFragment;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0003\u001b\u001c\u001dB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/coolapk/market/view/live/LiveIntroduceFragment;", "Lcom/coolapk/market/view/base/BaseFragment;", "()V", "binding", "Lcom/coolapk/market/databinding/LiveIntroduceBinding;", "live", "Lcom/coolapk/market/model/Live;", "getLive", "()Lcom/coolapk/market/model/Live;", "live$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/coolapk/market/view/live/LiveViewModel;", "getViewModel", "()Lcom/coolapk/market/view/live/LiveViewModel;", "viewModel$delegate", "initTitle", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "Companion", "PresenterLayout", "PresenterView", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveIntroduceFragment.kt */
public final class LiveIntroduceFragment extends BaseFragment {
    public static final Companion Companion = new Companion(null);
    private LiveIntroduceBinding binding;
    private final Lazy live$delegate = LazyKt.lazy(new LiveIntroduceFragment$live$2(this));
    private final Lazy viewModel$delegate = LazyKt.lazy(new LiveIntroduceFragment$viewModel$2(this));

    private final Live getLive() {
        return (Live) this.live$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final LiveViewModel getViewModel() {
        return (LiveViewModel) this.viewModel$delegate.getValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/live/LiveIntroduceFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/live/LiveIntroduceFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LiveIntroduceFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveIntroduceFragment newInstance() {
            return new LiveIntroduceFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131559018, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…roduce, container, false)");
        LiveIntroduceBinding liveIntroduceBinding = (LiveIntroduceBinding) inflate;
        this.binding = liveIntroduceBinding;
        if (liveIntroduceBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return liveIntroduceBinding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        LiveIntroduceBinding liveIntroduceBinding = this.binding;
        if (liveIntroduceBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        liveIntroduceBinding.setViewModel(getViewModel());
        initTitle();
        LiveIntroduceBinding liveIntroduceBinding2 = this.binding;
        if (liveIntroduceBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = liveIntroduceBinding2.presenterFrame;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        PresenterLayout presenterLayout = new PresenterLayout(requireActivity);
        List<User> presenterUserInfo = getLive().getPresenterUserInfo();
        Intrinsics.checkNotNullExpressionValue(presenterUserInfo, "live.presenterUserInfo");
        presenterLayout.setData(presenterUserInfo);
        Unit unit = Unit.INSTANCE;
        frameLayout.addView(presenterLayout);
    }

    private final void initTitle() {
        SpannableString spannableString = new SpannableString(getLive().getTitle());
        SpannableString spannableString2 = new SpannableString(getViewModel().getLiveStatusSimpleString());
        spannableString2.setSpan(new StyleSpan(0), 0, spannableString2.length(), 33);
        spannableString2.setSpan(new RoundedBackgroundSpan(getViewModel().getLiveStatusSimpleColor(), -1, (float) NumberExtendsKt.getSp((Number) 10), (float) NumberExtendsKt.getDp((Number) 4), (float) NumberExtendsKt.getDp((Number) 4), (float) NumberExtendsKt.getDp((Number) 2), (float) NumberExtendsKt.getDp((Number) 6)), 0, spannableString2.length(), 33);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) spannableString);
        spannableStringBuilder.append((CharSequence) spannableString2);
        LiveIntroduceBinding liveIntroduceBinding = this.binding;
        if (liveIntroduceBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = liveIntroduceBinding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText(spannableStringBuilder);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/live/LiveIntroduceFragment$PresenterLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "setData", "", "users", "", "Lcom/coolapk/market/model/User;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LiveIntroduceFragment.kt */
    public static final class PresenterLayout extends LinearLayout {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PresenterLayout(Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            setOrientation(1);
        }

        public final void setData(List<? extends User> list) {
            Intrinsics.checkNotNullParameter(list, "users");
            if (getChildCount() > 0) {
                removeAllViews();
            }
            int i = 0;
            for (T t : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                T t2 = t;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                PresenterView presenterView = new PresenterView(context);
                presenterView.setOnClickListener(new LiveIntroduceFragment$PresenterLayout$setData$$inlined$forEachIndexed$lambda$1(t2, this));
                String userAvatar = t2.getUserAvatar();
                Intrinsics.checkNotNullExpressionValue(userAvatar, "user.userAvatar");
                String userName = t2.getUserName();
                Intrinsics.checkNotNullExpressionValue(userName, "user.userName");
                presenterView.setData(userAvatar, userName);
                PresenterView presenterView2 = presenterView;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (i != 0) {
                    layoutParams.topMargin = NumberExtendsKt.getDp((Number) 8);
                }
                Unit unit = Unit.INSTANCE;
                addView(presenterView2, layoutParams);
                i = i2;
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/live/LiveIntroduceFragment$PresenterView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "avatarView", "Lcom/makeramen/roundedimageview/RoundedImageView;", "nameView", "Landroid/widget/TextView;", "setData", "", "avatarUrl", "", "name", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LiveIntroduceFragment.kt */
    public static final class PresenterView extends LinearLayout {
        private final RoundedImageView avatarView;
        private final TextView nameView;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PresenterView(Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            RoundedImageView roundedImageView = new RoundedImageView(context);
            this.avatarView = roundedImageView;
            TextView textView = new TextView(context);
            this.nameView = textView;
            textView.setTextColor(AppHolder.getAppTheme().getTextColorSecondary());
            roundedImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            roundedImageView.setOval(true);
            setBackgroundResource(ResourceUtils.resolveResId(context, 16843534));
            setOrientation(0);
            setGravity(16);
            addView(roundedImageView, new LinearLayout.LayoutParams(NumberExtendsKt.getDp((Number) 16), NumberExtendsKt.getDp((Number) 16)));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.leftMargin = NumberExtendsKt.getDp((Number) 6);
            Unit unit = Unit.INSTANCE;
            addView(textView, layoutParams);
        }

        public final void setData(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "avatarUrl");
            Intrinsics.checkNotNullParameter(str2, "name");
            AppHolder.getContextImageLoader().displayImage(getContext(), str, this.avatarView, 2131231162);
            this.nameView.setText(str2);
        }
    }
}
