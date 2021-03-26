package com.coolapk.market.view.ad;

import android.os.Handler;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\r\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\b\u0010\u000f\u001a\u00020\fH\u0002J\u0006\u0010\u0010\u001a\u00020\fJ\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/ad/SmoothScrollWithADBindHelper;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroidx/recyclerview/widget/RecyclerView;)V", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "scrollState", "", "taskList", "", "Lkotlin/Function0;", "", "addTask", "task", "checkNeedToEnqueueTask", "enqueueTask", "onScrollStateChanged", "newState", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityAdHelper.kt */
public final class SmoothScrollWithADBindHelper extends RecyclerView.OnScrollListener {
    private final RecyclerView recyclerView;
    private int scrollState;
    private final List<Function0<Unit>> taskList = new ArrayList();

    public SmoothScrollWithADBindHelper(RecyclerView recyclerView2) {
        Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
        this.recyclerView = recyclerView2;
        recyclerView2.addOnScrollListener(this);
        this.scrollState = recyclerView2.getScrollState();
    }

    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView2, int i) {
        Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
        super.onScrollStateChanged(recyclerView2, i);
        this.scrollState = i;
        checkNeedToEnqueueTask();
    }

    public final void addTask(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "task");
        this.taskList.add(function0);
        checkNeedToEnqueueTask();
    }

    private final void checkNeedToEnqueueTask() {
        if (this.scrollState == 0) {
            enqueueTask();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.coolapk.market.view.ad.EntityAdHelperKt$sam$i$java_lang_Runnable$0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final void enqueueTask() {
        if (!this.taskList.isEmpty()) {
            for (T t : this.taskList) {
                Handler mainThreadHandler = AppHolder.getMainThreadHandler();
                if (t != null) {
                    t = new EntityAdHelperKt$sam$i$java_lang_Runnable$0(t);
                }
                mainThreadHandler.post(t);
            }
            this.taskList.clear();
        }
    }
}
