package com.coolapk.market.view.center;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemRecentHistoryBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.RecentHistory;
import com.coolapk.market.util.CircleRadiusTransform;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.MultiItemDialogFragment;
import com.coolapk.market.viewholder.GenericBindHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0010\u0011B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0003H\u0002R\u000e\u0010\t\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/center/RecentHistoryViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemRecentHistoryBinding;", "Lcom/coolapk/market/model/RecentHistory;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "data", "bindToContent", "", "onClick", "view", "getPrettyDescription", "", "Companion", "RecentHistoryDialog", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: RecentHistoryViewHolder.kt */
public final class RecentHistoryViewHolder extends GenericBindHolder<ItemRecentHistoryBinding, RecentHistory> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558891;
    private RecentHistory data;

    public static final /* synthetic */ RecentHistory access$getData$p(RecentHistoryViewHolder recentHistoryViewHolder) {
        RecentHistory recentHistory = recentHistoryViewHolder.data;
        if (recentHistory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
        }
        return recentHistory;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecentHistoryViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ((ItemRecentHistoryBinding) getBinding()).itemView.setOnClickListener(this);
        ((ItemRecentHistoryBinding) getBinding()).itemView.setOnLongClickListener(new View.OnLongClickListener(this) {
            /* class com.coolapk.market.view.center.RecentHistoryViewHolder.AnonymousClass1 */
            final /* synthetic */ RecentHistoryViewHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                Context context = this.this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                Activity activityNullable = UiUtils.getActivityNullable(context);
                if (activityNullable == null) {
                    return true;
                }
                RecentHistoryDialog newInstance = RecentHistoryDialog.Companion.newInstance(RecentHistoryViewHolder.access$getData$p(this.this$0));
                FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activityNullable).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
                newInstance.show(supportFragmentManager, (String) null);
                return true;
            }
        });
        TextView textView = ((ItemRecentHistoryBinding) getBinding()).tagView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tagView");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 2));
        gradientDrawable.setStroke(NumberExtendsKt.getDp(Double.valueOf(0.5d)), AppHolder.getAppTheme().getColorAccent());
        Unit unit = Unit.INSTANCE;
        textView.setBackground(gradientDrawable);
        ((ItemRecentHistoryBinding) getBinding()).tagView.setTextColor(AppHolder.getAppTheme().getColorAccent());
        ItemRecentHistoryBinding itemRecentHistoryBinding = (ItemRecentHistoryBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemRecentHistoryBinding, "binding");
        itemRecentHistoryBinding.setTransformer(new CircleRadiusTransform(NumberExtendsKt.getDpf((Number) 6), false));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/center/RecentHistoryViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: RecentHistoryViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e5  */
    public void bindToContent(RecentHistory recentHistory) {
        String str;
        String str2;
        int i;
        Intrinsics.checkNotNullParameter(recentHistory, "data");
        this.data = recentHistory;
        String targetType = recentHistory.getTargetType();
        if (targetType != null) {
            switch (targetType.hashCode()) {
                case -309474065:
                    if (targetType.equals("product")) {
                        str = "数码";
                        break;
                    }
                    break;
                case 96796:
                    if (targetType.equals("apk")) {
                        str = "应用";
                        break;
                    }
                    break;
                case 99955:
                    if (targetType.equals("dyh")) {
                        str = "看看号";
                        break;
                    }
                    break;
                case 3138974:
                    if (targetType.equals("feed")) {
                        str = "动态";
                        break;
                    }
                    break;
                case 3599307:
                    if (targetType.equals("user")) {
                        str = "用户";
                        break;
                    }
                    break;
                case 110546223:
                    if (targetType.equals("topic")) {
                        str = "话题";
                        break;
                    }
                    break;
            }
            TextView textView = ((ItemRecentHistoryBinding) getBinding()).tagView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tagView");
            textView.setText(str);
            TextView textView2 = ((ItemRecentHistoryBinding) getBinding()).titleView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
            textView2.setText(recentHistory.getTitle());
            ItemRecentHistoryBinding itemRecentHistoryBinding = (ItemRecentHistoryBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemRecentHistoryBinding, "binding");
            itemRecentHistoryBinding.setModel(recentHistory);
            String prettyDescription = getPrettyDescription(recentHistory);
            TextView textView3 = ((ItemRecentHistoryBinding) getBinding()).descriptionView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.descriptionView");
            str2 = prettyDescription;
            textView3.setText(str2);
            TextView textView4 = ((ItemRecentHistoryBinding) getBinding()).descriptionView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.descriptionView");
            int i2 = 0;
            if (str2.length() != 0) {
                i2 = 8;
            }
            textView4.setVisibility(i2);
            if (recentHistory.getIsTop() != 1) {
                i = ColorUtils.calculateOneColorPlusAnotherColor(ColorUtils.adjustAlpha(AppHolder.getAppTheme().getColorAccent(), 0.1f), AppHolder.getAppTheme().getContentBackgroundColor());
            } else {
                i = AppHolder.getAppTheme().getContentBackgroundColor();
            }
            ((ItemRecentHistoryBinding) getBinding()).cardView.setDefaultBackgroundColor(Integer.valueOf(i));
            ((ItemRecentHistoryBinding) getBinding()).executePendingBindings();
        }
        str = "其他";
        TextView textView = ((ItemRecentHistoryBinding) getBinding()).tagView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tagView");
        textView.setText(str);
        TextView textView2 = ((ItemRecentHistoryBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
        textView2.setText(recentHistory.getTitle());
        ItemRecentHistoryBinding itemRecentHistoryBinding = (ItemRecentHistoryBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemRecentHistoryBinding, "binding");
        itemRecentHistoryBinding.setModel(recentHistory);
        String prettyDescription = getPrettyDescription(recentHistory);
        TextView textView3 = ((ItemRecentHistoryBinding) getBinding()).descriptionView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.descriptionView");
        str2 = prettyDescription;
        textView3.setText(str2);
        TextView textView4 = ((ItemRecentHistoryBinding) getBinding()).descriptionView;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.descriptionView");
        int i2 = 0;
        if (str2.length() != 0) {
        }
        textView4.setVisibility(i2);
        if (recentHistory.getIsTop() != 1) {
        }
        ((ItemRecentHistoryBinding) getBinding()).cardView.setDefaultBackgroundColor(Integer.valueOf(i));
        ((ItemRecentHistoryBinding) getBinding()).executePendingBindings();
    }

    private final String getPrettyDescription(RecentHistory recentHistory) {
        ArrayList arrayList = new ArrayList();
        RecentHistory recentHistory2 = this.data;
        if (recentHistory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
        }
        if (recentHistory2.getFollowNum() >= 0) {
            RecentHistory recentHistory3 = this.data;
            if (recentHistory3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("data");
            }
            if (Intrinsics.areEqual(recentHistory3.getTargetType(), "dyh")) {
                StringBuilder sb = new StringBuilder();
                RecentHistory recentHistory4 = this.data;
                if (recentHistory4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("data");
                }
                sb.append(recentHistory4.getFollowNum());
                sb.append("订阅");
                arrayList.add(sb.toString());
            } else {
                StringBuilder sb2 = new StringBuilder();
                RecentHistory recentHistory5 = this.data;
                if (recentHistory5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("data");
                }
                sb2.append(recentHistory5.getFollowNum());
                sb2.append("关注");
                arrayList.add(sb2.toString());
            }
        }
        RecentHistory recentHistory6 = this.data;
        if (recentHistory6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
        }
        if (recentHistory6.getCommentNum() >= 0) {
            StringBuilder sb3 = new StringBuilder();
            RecentHistory recentHistory7 = this.data;
            if (recentHistory7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("data");
            }
            sb3.append(recentHistory7.getCommentNum());
            sb3.append("讨论");
            arrayList.add(sb3.toString());
        }
        RecentHistory recentHistory8 = this.data;
        if (recentHistory8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
        }
        if (recentHistory8.getFansNum() >= 0) {
            StringBuilder sb4 = new StringBuilder();
            RecentHistory recentHistory9 = this.data;
            if (recentHistory9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("data");
            }
            sb4.append(recentHistory9.getFansNum());
            sb4.append("粉丝");
            arrayList.add(sb4.toString());
        }
        RecentHistory recentHistory10 = this.data;
        if (recentHistory10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
        }
        if (recentHistory10.getAnswerNum() >= 0) {
            StringBuilder sb5 = new StringBuilder();
            RecentHistory recentHistory11 = this.data;
            if (recentHistory11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("data");
            }
            sb5.append(recentHistory11.getAnswerNum());
            sb5.append("回答");
            arrayList.add(sb5.toString());
        }
        return CollectionsKt.joinToString$default(arrayList, " ", null, null, 0, null, null, 62, null);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        RecentHistory recentHistory = this.data;
        if (recentHistory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
        }
        String url = recentHistory.getUrl();
        if (!(url == null || url.length() == 0)) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            RecentHistory recentHistory2 = this.data;
            if (recentHistory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("data");
            }
            String url2 = recentHistory2.getUrl();
            RecentHistory recentHistory3 = this.data;
            if (recentHistory3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("data");
            }
            String title = recentHistory3.getTitle();
            RecentHistory recentHistory4 = this.data;
            if (recentHistory4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("data");
            }
            ActionManagerCompat.startActivityByUrl(context, url2, title, recentHistory4.getSubTitle());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/center/RecentHistoryViewHolder$RecentHistoryDialog;", "Lcom/coolapk/market/view/base/MultiItemDialogFragment;", "()V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: RecentHistoryViewHolder.kt */
    public static final class RecentHistoryDialog extends MultiItemDialogFragment {
        public static final Companion Companion = new Companion(null);

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/center/RecentHistoryViewHolder$RecentHistoryDialog$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/center/RecentHistoryViewHolder$RecentHistoryDialog;", "recentHistory", "Lcom/coolapk/market/model/RecentHistory;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: RecentHistoryViewHolder.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final RecentHistoryDialog newInstance(RecentHistory recentHistory) {
                Intrinsics.checkNotNullParameter(recentHistory, "recentHistory");
                RecentHistoryDialog recentHistoryDialog = new RecentHistoryDialog();
                Bundle bundle = new Bundle();
                bundle.putParcelable("recentHistory", recentHistory);
                Unit unit = Unit.INSTANCE;
                recentHistoryDialog.setArguments(bundle);
                return recentHistoryDialog;
            }
        }

        @Override // com.coolapk.market.view.base.MultiItemDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            RecentHistory recentHistory = (RecentHistory) requireArguments().getParcelable("recentHistory");
            if (recentHistory != null) {
                Intrinsics.checkNotNullExpressionValue(recentHistory, "requireArguments().getPa…recentHistory\") ?: return");
                updateDataList(new RecentHistoryViewHolder$RecentHistoryDialog$onActivityCreated$1(this, recentHistory));
            }
        }
    }
}
