package com.coolapk.market.view.sencondhand;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.model.DeviceParams;
import com.coolapk.market.model.ProductParams;
import com.coolapk.market.view.sencondhand.EditSecondHandDialogFragment;
import com.coolapk.market.view.sencondhand.SecondHandParamsViewHolder;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"<anonymous>", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "checked", "", "type", "", "invoke", "com/coolapk/market/view/sencondhand/SecondHandParamsViewHolder$bindTo$3$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: SecondHandParamsViewHolder.kt */
final class SecondHandParamsViewHolder$bindTo$$inlined$apply$lambda$2 extends Lambda implements Function3<RecyclerView.ViewHolder, Boolean, Integer, Unit> {
    final /* synthetic */ DeviceParams $deviceParams$inlined;
    final /* synthetic */ SingleCheckHelper $this_apply;
    final /* synthetic */ SecondHandParamsViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SecondHandParamsViewHolder$bindTo$$inlined$apply$lambda$2(SingleCheckHelper singleCheckHelper, SecondHandParamsViewHolder secondHandParamsViewHolder, DeviceParams deviceParams) {
        super(3);
        this.$this_apply = singleCheckHelper;
        this.this$0 = secondHandParamsViewHolder;
        this.$deviceParams$inlined = deviceParams;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(RecyclerView.ViewHolder viewHolder, Boolean bool, Integer num) {
        invoke(viewHolder, bool.booleanValue(), num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(final RecyclerView.ViewHolder viewHolder, final boolean z, final int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        final SingleCheckHelper singleCheckHelper = this.$this_apply;
        final SecondHandParamsViewHolder.DataViewHolder dataViewHolder = (SecondHandParamsViewHolder.DataViewHolder) viewHolder;
        if (dataViewHolder.getInOther() && z && i == 1) {
            EditSecondHandDialogFragment.Companion companion = EditSecondHandDialogFragment.Companion;
            String title = this.$deviceParams$inlined.getTitle();
            Intrinsics.checkNotNull(title);
            Intrinsics.checkNotNullExpressionValue(title, "deviceParams.title!!");
            final EditSecondHandDialogFragment newInstance = companion.newInstance(title, 0, "");
            newInstance.setListener(new Action1<String>() {
                /* class com.coolapk.market.view.sencondhand.SecondHandParamsViewHolder$bindTo$$inlined$apply$lambda$2.AnonymousClass1 */

                public final void call(String str) {
                    SecondHandParamsViewHolder.DataViewHolder dataViewHolder = dataViewHolder;
                    boolean z = z;
                    List<ProductParams> list = this.this$0.options;
                    LinkedHashMap<String, List<ProductParams>> map = this.this$0.getMap();
                    int i = i;
                    Intrinsics.checkNotNullExpressionValue(str, "it");
                    dataViewHolder.stateChange(z, list, map, i, str);
                    newInstance.dismiss();
                }
            });
            newInstance.setCancelListener(new Action1<Boolean>() {
                /* class com.coolapk.market.view.sencondhand.SecondHandParamsViewHolder$bindTo$$inlined$apply$lambda$2.AnonymousClass2 */

                public final void call(Boolean bool) {
                    SecondHandParamsViewHolder.DataViewHolder dataViewHolder = dataViewHolder;
                    Intrinsics.checkNotNullExpressionValue(bool, "it");
                    dataViewHolder.stateChange(bool.booleanValue(), this.this$0.options, this.this$0.getMap(), i, "其他");
                    singleCheckHelper.setCheckedPostion(-1);
                }
            });
            Context context = this.this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(context).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context.requireAppCompat…().supportFragmentManager");
            newInstance.show(supportFragmentManager, (String) null);
        }
        SecondHandParamsViewHolder.DataViewHolder.stateChange$default(dataViewHolder, z || (i == 0 ? this.this$0.paramText.contains(dataViewHolder.paramText()) : false), this.this$0.options, this.this$0.getMap(), i, null, 16, null);
    }
}
