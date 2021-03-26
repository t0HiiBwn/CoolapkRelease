package com.coolapk.market.view.ad.toutiao;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ListAdapter;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001cB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0018H\u0014R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/coolapk/market/view/ad/toutiao/DislikeDialog;", "Lcom/bytedance/sdk/openadsdk/TTDislikeDialogAbstract;", "context", "Landroid/content/Context;", "list", "", "Lcom/bytedance/sdk/openadsdk/FilterWord;", "(Landroid/content/Context;Ljava/util/List;)V", "filterWordList", "onDislikeItemClick", "Lcom/coolapk/market/view/ad/toutiao/DislikeDialog$OnDislikeItemClick;", "getOnDislikeItemClick", "()Lcom/coolapk/market/view/ad/toutiao/DislikeDialog$OnDislikeItemClick;", "setOnDislikeItemClick", "(Lcom/coolapk/market/view/ad/toutiao/DislikeDialog$OnDislikeItemClick;)V", "getLayoutId", "", "getLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "getPersonalizationPromptIds", "", "getTTDislikeListViewIds", "initData", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "OnDislikeItemClick", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DislikeDialog.kt */
public final class DislikeDialog extends TTDislikeDialogAbstract {
    private final List<FilterWord> filterWordList;
    private OnDislikeItemClick onDislikeItemClick;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/view/ad/toutiao/DislikeDialog$OnDislikeItemClick;", "", "onItemClick", "", "filterWord", "Lcom/bytedance/sdk/openadsdk/FilterWord;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DislikeDialog.kt */
    public interface OnDislikeItemClick {
        void onItemClick(FilterWord filterWord);
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public int getLayoutId() {
        return 2131558541;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public int[] getPersonalizationPromptIds() {
        return new int[]{2131363096};
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public int[] getTTDislikeListViewIds() {
        return new int[]{2131362411};
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DislikeDialog(Context context, List<? extends FilterWord> list) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "list");
        this.filterWordList = initData(list);
    }

    public final OnDislikeItemClick getOnDislikeItemClick() {
        return this.onDislikeItemClick;
    }

    public final void setOnDislikeItemClick(OnDislikeItemClick onDislikeItemClick2) {
        this.onDislikeItemClick = onDislikeItemClick2;
    }

    private final List<FilterWord> initData(List<? extends FilterWord> list) {
        ArrayList arrayList = new ArrayList();
        for (FilterWord filterWord : list) {
            if (filterWord.hasSecondOptions()) {
                List<FilterWord> options = filterWord.getOptions();
                Intrinsics.checkNotNullExpressionValue(options, "filterWord.options");
                arrayList.addAll(initData(options));
            } else {
                arrayList.add(filterWord);
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View findViewById = findViewById(2131362411);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.bytedance.sdk.openadsdk.dislike.TTDislikeListView");
        TTDislikeListView tTDislikeListView = (TTDislikeListView) findViewById;
        tTDislikeListView.setAdapter((ListAdapter) new DislikeAdapter(this.filterWordList));
        tTDislikeListView.setOnItemClickListener(new DislikeDialog$onCreate$1(this));
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public ViewGroup.LayoutParams getLayoutParams() {
        return new ViewGroup.LayoutParams(-1, -1);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        Window window = getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        if (decorView != null) {
            decorView.post(new DislikeDialog$onStart$1(decorView));
        }
    }
}
