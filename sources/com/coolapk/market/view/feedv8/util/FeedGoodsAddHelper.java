package com.coolapk.market.view.feedv8.util;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.ExpireCache;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.WrapDialogFragmentKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fJ\u0006\u0010\r\u001a\u00020\u000eJ*\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/feedv8/util/FeedGoodsAddHelper;", "", "()V", "KEY_TIP_GOODS_TAG_LIST", "", "TAG_PATTERN", "Lkotlin/text/Regex;", "getTAG_PATTERN", "()Lkotlin/text/Regex;", "didInputTextContainGoodsTag", "", "inputText", "", "requireLoadGoodsTagList", "", "showSuggestAddGoodsDialog", "context", "Landroidx/appcompat/app/AppCompatActivity;", "addGoodsAction", "Lkotlin/Function0;", "postAction", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedGoodsAddHelper.kt */
public final class FeedGoodsAddHelper {
    public static final FeedGoodsAddHelper INSTANCE = new FeedGoodsAddHelper();
    public static final String KEY_TIP_GOODS_TAG_LIST = "tipGoodsTagList";
    private static final Regex TAG_PATTERN = new Regex("#([^# @\n]{1,15})#");

    private FeedGoodsAddHelper() {
    }

    public final Regex getTAG_PATTERN() {
        return TAG_PATTERN;
    }

    public final void requireLoadGoodsTagList() {
        if (((List) ExpireCache.INSTANCE.getOrNull("tipGoodsTagList", 3600000)) == null) {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            instance.getTipGoodsTagList().compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new FeedGoodsAddHelper$requireLoadGoodsTagList$1());
        }
    }

    public final boolean didInputTextContainGoodsTag(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "inputText");
        List list2 = (List) ExpireCache.INSTANCE.getOrNull("tipGoodsTagList", 3600000);
        if (list2 == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            CollectionsKt.addAll(arrayList, SequencesKt.map(Regex.findAll$default(TAG_PATTERN, it2.next(), 0, 2, null), FeedGoodsAddHelper$didInputTextContainGoodsTag$topicList$1$1.INSTANCE));
        }
        Set<String> set = CollectionsKt.toSet(arrayList);
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        for (String str : set) {
            if (list2.contains(str)) {
                return true;
            }
        }
        return false;
    }

    public final void showSuggestAddGoodsDialog(AppCompatActivity appCompatActivity, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "context");
        Intrinsics.checkNotNullParameter(function0, "addGoodsAction");
        Intrinsics.checkNotNullParameter(function02, "postAction");
        AlertDialog create = new AlertDialog.Builder(appCompatActivity).setMessage("添加您安利的好物，并获得更高曝光").setPositiveButton("添加好物", new FeedGoodsAddHelper$showSuggestAddGoodsDialog$1(function0)).setNegativeButton("直接发布", new FeedGoodsAddHelper$showSuggestAddGoodsDialog$2(function02)).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(cont…                .create()");
        FragmentManager supportFragmentManager = appCompatActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context.supportFragmentManager");
        WrapDialogFragmentKt.show(create, supportFragmentManager, null);
    }
}
