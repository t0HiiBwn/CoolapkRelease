package com.coolapk.market.view.block;

import android.os.Parcelable;
import com.coolapk.market.model.HolderItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Landroid/os/Parcelable;", "kotlin.jvm.PlatformType", "it", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: BlockCategoryFragment.kt */
final class BlockCategoryFragment$onCreateRequest$1<T, R> implements Func1<String, List<? extends Parcelable>> {
    public static final BlockCategoryFragment$onCreateRequest$1 INSTANCE = new BlockCategoryFragment$onCreateRequest$1();

    BlockCategoryFragment$onCreateRequest$1() {
    }

    public final List<Parcelable> call(String str) {
        ArrayList arrayList = new ArrayList();
        HolderItem build = HolderItem.newBuilder().entityType("holder_title").build();
        Intrinsics.checkNotNullExpressionValue(build, "HolderItem.newBuilder().…OLDER_TYPE_TITLE).build()");
        arrayList.add(build);
        return arrayList;
    }
}
