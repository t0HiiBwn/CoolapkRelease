package com.coolapk.market.view.settings;

import android.widget.RadioGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "group", "Landroid/widget/RadioGroup;", "kotlin.jvm.PlatformType", "checkedId", "", "onCheckedChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: DiscoveryTabConfigDialog.kt */
final class DiscoveryTabConfigDialog$onCreateDialog$6 implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ Ref.ObjectRef $value;
    final /* synthetic */ DiscoveryTabConfigDialog this$0;

    DiscoveryTabConfigDialog$onCreateDialog$6(DiscoveryTabConfigDialog discoveryTabConfigDialog, Ref.ObjectRef objectRef) {
        this.this$0 = discoveryTabConfigDialog;
        this.$value = objectRef;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == 2131363189) {
            this.$value.element = "V11_FIND_GOOD_GOODS_HOME";
            this.this$0.putString(this.$value.element);
        } else if (i != 2131363192) {
            switch (i) {
                case 2131363181:
                    this.$value.element = "V11_FIND_COOLPIC";
                    this.this$0.putString(this.$value.element);
                    return;
                case 2131363182:
                    this.$value.element = "V11_FIND_DYH";
                    this.this$0.putString(this.$value.element);
                    return;
                case 2131363183:
                    this.$value.element = "V11_FIND_GOODS";
                    this.this$0.putString(this.$value.element);
                    return;
                default:
                    return;
            }
        } else {
            this.$value.element = "V11_DISCOVERY_SECOND_HAND";
            this.this$0.putString(this.$value.element);
        }
    }
}
