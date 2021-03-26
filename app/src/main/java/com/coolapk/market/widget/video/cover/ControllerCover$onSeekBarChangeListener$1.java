package com.coolapk.market.widget.video.cover;

import android.widget.SeekBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/coolapk/market/widget/video/cover/ControllerCover$onSeekBarChangeListener$1", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ControllerCover.kt */
public final class ControllerCover$onSeekBarChangeListener$1 implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ ControllerCover this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    ControllerCover$onSeekBarChangeListener$1(ControllerCover controllerCover) {
        this.this$0 = controllerCover;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        if (z) {
            boolean z2 = this.this$0.isTouchingSeekBar;
            this.this$0.isTouchingSeekBar = false;
            this.this$0.updateUI(i, seekBar.getMax());
            this.this$0.isTouchingSeekBar = z2;
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        this.this$0.removeDelayHiddenMessage();
        this.this$0.isTouchingSeekBar = true;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        this.this$0.sendSeekEvent(seekBar.getProgress());
        this.this$0.sendDelayHiddenMessage();
        this.this$0.isTouchingSeekBar = false;
    }
}
