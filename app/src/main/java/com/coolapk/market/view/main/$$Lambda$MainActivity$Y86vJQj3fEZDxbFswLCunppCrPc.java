package com.coolapk.market.view.main;

import android.content.DialogInterface;
import com.coolapk.market.manager.DataManager;

/* renamed from: com.coolapk.market.view.main.-$$Lambda$MainActivity$Y86vJQj3fEZDxbFswLCunppCrPc  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$MainActivity$Y86vJQj3fEZDxbFswLCunppCrPc implements DialogInterface.OnClickListener {
    public static final /* synthetic */ $$Lambda$MainActivity$Y86vJQj3fEZDxbFswLCunppCrPc INSTANCE = new $$Lambda$MainActivity$Y86vJQj3fEZDxbFswLCunppCrPc();

    private /* synthetic */ $$Lambda$MainActivity$Y86vJQj3fEZDxbFswLCunppCrPc() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        DataManager.getInstance().getPreferencesEditor().putBoolean("CHECK_BATTERY_OPTIMIZATION", false).apply();
    }
}
