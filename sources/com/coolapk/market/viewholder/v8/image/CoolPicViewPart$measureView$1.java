package com.coolapk.market.viewholder.v8.image;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.feed.FeedDetailActivityV8;
import com.coolapk.market.view.search.SuperSearchActivity;
import com.coolapk.market.view.search.SuperSearchResultActivity;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: CoolPicViewPart.kt */
final class CoolPicViewPart$measureView$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ ImageBinder $binder;
    final /* synthetic */ MaxWidthFrameLayout $frameView;
    final /* synthetic */ ImageArgs $imageArg;
    final /* synthetic */ CoolPicViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoolPicViewPart$measureView$1(CoolPicViewPart coolPicViewPart, ImageArgs imageArgs, ImageBinder imageBinder, MaxWidthFrameLayout maxWidthFrameLayout) {
        super(1);
        this.this$0 = coolPicViewPart;
        this.$imageArg = imageArgs;
        this.$binder = imageBinder;
        this.$frameView = maxWidthFrameLayout;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke(view);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final void invoke(View view) {
        Feed feed;
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(view, "it");
        int indexOf = this.this$0.currentDisplayList.indexOf(this.$imageArg.getInSource());
        List list = null;
        if (UiUtils.getActivityNullable(this.this$0.getContext()) instanceof FeedDetailActivityV8) {
            Rect[] rectArr = new Rect[this.this$0.currentDisplayList.size()];
            String[] strArr = new String[this.this$0.currentDisplayList.size()];
            int i = 0;
            for (T t : this.$binder.getImagePreArgs()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                T t2 = t;
                View childAt = this.$frameView.getChildAt(i);
                rectArr[i] = childAt != null ? ViewExtendsKt.getGlobalRect(childAt) : null;
                strArr[i] = t2.getSuitableUrl(CoolPicViewPart.Companion.getThumbUrlProvider());
                i = i2;
            }
            Activity activityNullable = UiUtils.getActivityNullable(this.this$0.getContext());
            Object[] array = this.this$0.currentDisplayList.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            String[] strArr2 = (String[]) array;
            ArrayList<??> arrayList = this.this$0.currentDisplayList;
            Function1<String, String> thumbUrlProvider = CoolPicViewPart.Companion.getThumbUrlProvider();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            for (?? r9 : arrayList) {
                arrayList2.add(thumbUrlProvider.invoke(r9));
            }
            Object[] array2 = arrayList2.toArray(new String[0]);
            Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
            ActionManager.startPhotoViewActivity(activityNullable, strArr2, (String[]) array2, indexOf, "picture", strArr, rectArr);
        } else if (this.this$0.bindFeed != null && (feed = this.this$0.bindFeed) != null && feed.getType() == 8) {
            Activity activityNullable2 = UiUtils.getActivityNullable(this.this$0.getContext());
            if ((activityNullable2 instanceof SuperSearchActivity) || (activityNullable2 instanceof SuperSearchResultActivity)) {
                str = "search";
            } else {
                if (this.this$0.getParams() != null) {
                    String params = this.this$0.getParams();
                    Intrinsics.checkNotNull(params);
                    if (StringsKt.contains$default((CharSequence) params, (CharSequence) "uid", false, 2, (Object) null)) {
                        str = "user";
                    }
                }
                str = "list";
            }
            String params2 = this.this$0.getParams();
            if (params2 != null) {
                list = StringsKt.split$default((CharSequence) params2, new String[]{","}, false, 0, 6, (Object) null);
            }
            if (list != null) {
                str2 = (String) list.get(0);
                str3 = (String) list.get(1);
            } else {
                str2 = "old";
                str3 = "";
            }
            ActionManager.startCoolPicActivity(this.this$0.getContext(), this.this$0.bindFeed, str, str2, str3, indexOf);
        }
    }
}
