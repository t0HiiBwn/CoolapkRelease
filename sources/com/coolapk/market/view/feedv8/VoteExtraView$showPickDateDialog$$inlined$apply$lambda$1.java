package com.coolapk.market.view.feedv8;

import android.content.DialogInterface;
import com.coolapk.market.model.FeedMultiPart;
import com.lany.picker.DatePicker;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick", "com/coolapk/market/view/feedv8/VoteExtraView$showPickDateDialog$1$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: VoteExtraView.kt */
final class VoteExtraView$showPickDateDialog$$inlined$apply$lambda$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ DatePicker $datePickerView$inlined;
    final /* synthetic */ VoteExtraView this$0;

    VoteExtraView$showPickDateDialog$$inlined$apply$lambda$1(VoteExtraView voteExtraView, DatePicker datePicker) {
        this.this$0 = voteExtraView;
        this.$datePickerView$inlined = datePicker;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        LocalDateTime of = LocalDateTime.of(LocalDate.of(this.$datePickerView$inlined.getYear(), this.$datePickerView$inlined.getMonth() + 1, this.$datePickerView$inlined.getDayOfMonth()), LocalTime.MAX);
        VoteExtraView voteExtraView = this.this$0;
        FeedMultiPart build = VoteExtraView.access$getMultiPart$p(voteExtraView).newBuilder().voteEndTime(of.atZone(ZoneId.systemDefault()).toEpochSecond()).build();
        Intrinsics.checkNotNullExpressionValue(build, "multiPart.newBuilder()\n …                 .build()");
        VoteExtraView.access$setMultiPart$p(voteExtraView, build);
        this.this$0.requestUpdateDataList();
    }
}
