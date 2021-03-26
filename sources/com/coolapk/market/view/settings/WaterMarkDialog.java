package com.coolapk.market.view.settings;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.coolapk.market.databinding.LayoutWaterMarkBinding;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.view.base.BaseDialogFragment;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0003\u0010\u0005R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/settings/WaterMarkDialog;", "Lcom/coolapk/market/view/base/BaseDialogFragment;", "()V", "isPosition", "", "()Z", "isPosition$delegate", "Lkotlin/Lazy;", "key", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: WaterMarkDialog.kt */
public final class WaterMarkDialog extends BaseDialogFragment {
    public static final Companion Companion = new Companion(null);
    private final Lazy isPosition$delegate = LazyKt.lazy(new WaterMarkDialog$isPosition$2(this));
    private String key = "";

    /* access modifiers changed from: private */
    public final boolean isPosition() {
        return ((Boolean) this.isPosition$delegate.getValue()).booleanValue();
    }

    @JvmStatic
    public static final WaterMarkDialog newInstance(String str) {
        return Companion.newInstance(str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/settings/WaterMarkDialog$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/settings/WaterMarkDialog;", "type", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: WaterMarkDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final WaterMarkDialog newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "type");
            Bundle bundle = new Bundle();
            bundle.putString("type", str);
            WaterMarkDialog waterMarkDialog = new WaterMarkDialog();
            waterMarkDialog.setArguments(bundle);
            return waterMarkDialog;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0135, code lost:
        if (r0.equals("7") != false) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x013e, code lost:
        if (r0.equals("5") != false) goto L_0x0158;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0147, code lost:
        if (r0.equals("1") != false) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0156, code lost:
        if (r0.equals("0") != false) goto L_0x0158;
     */
    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        LayoutWaterMarkBinding layoutWaterMarkBinding = (LayoutWaterMarkBinding) DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131559015, null, false);
        this.key = isPosition() ? "picture_watermark_position" : "watermark_icon_type";
        String str = isPosition() ? "水印位置" : "水印类型";
        TextView textView = layoutWaterMarkBinding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText(str);
        layoutWaterMarkBinding.radioFi.setOnClickListener(new WaterMarkDialog$onCreateDialog$1(this, layoutWaterMarkBinding));
        RadioButton radioButton = layoutWaterMarkBinding.radioTh;
        Intrinsics.checkNotNullExpressionValue(radioButton, "binding.radioTh");
        radioButton.setText("底部居中");
        RadioButton radioButton2 = layoutWaterMarkBinding.radioFo;
        Intrinsics.checkNotNullExpressionValue(radioButton2, "binding.radioFo");
        radioButton2.setText("底部居右");
        RadioButton radioButton3 = layoutWaterMarkBinding.radioFi;
        Intrinsics.checkNotNullExpressionValue(radioButton3, "binding.radioFi");
        radioButton3.setText(isPosition() ? "图片正中" : "文字");
        RadioButton radioButton4 = layoutWaterMarkBinding.radioSe;
        Intrinsics.checkNotNullExpressionValue(radioButton4, "binding.radioSe");
        radioButton4.setText(isPosition() ? "底部居左" : "图标");
        layoutWaterMarkBinding.radioSe.setOnClickListener(new WaterMarkDialog$onCreateDialog$2(this, layoutWaterMarkBinding));
        if (isPosition()) {
            layoutWaterMarkBinding.radioTh.setOnClickListener(new WaterMarkDialog$onCreateDialog$3(this, layoutWaterMarkBinding));
            layoutWaterMarkBinding.radioFo.setOnClickListener(new WaterMarkDialog$onCreateDialog$4(this, layoutWaterMarkBinding));
        } else {
            RadioButton radioButton5 = layoutWaterMarkBinding.radioTh;
            Intrinsics.checkNotNullExpressionValue(radioButton5, "binding.radioTh");
            radioButton5.setVisibility(8);
            RadioButton radioButton6 = layoutWaterMarkBinding.radioFo;
            Intrinsics.checkNotNullExpressionValue(radioButton6, "binding.radioFo");
            radioButton6.setVisibility(8);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        layoutWaterMarkBinding.radioGroup.setOnCheckedChangeListener(new WaterMarkDialog$onCreateDialog$5(this, objectRef));
        String preferencesString = DataManager.getInstance().getPreferencesString(this.key, isPosition() ? "9" : "0");
        if (preferencesString != null) {
            int hashCode = preferencesString.hashCode();
            if (hashCode != 48) {
                if (hashCode != 49) {
                    if (hashCode != 53) {
                        switch (hashCode) {
                            case 56:
                                if (preferencesString.equals("8")) {
                                    layoutWaterMarkBinding.radioGroup.check(2131363192);
                                    break;
                                }
                                break;
                            case 57:
                                if (preferencesString.equals("9")) {
                                    layoutWaterMarkBinding.radioGroup.check(2131363183);
                                    break;
                                }
                                break;
                        }
                    }
                }
                layoutWaterMarkBinding.radioGroup.check(2131363189);
            }
            layoutWaterMarkBinding.radioGroup.check(2131363181);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        Intrinsics.checkNotNullExpressionValue(layoutWaterMarkBinding, "binding");
        AlertDialog create = builder.setView(layoutWaterMarkBinding.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
        return create;
    }
}
