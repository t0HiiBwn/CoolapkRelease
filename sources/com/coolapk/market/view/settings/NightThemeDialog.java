package com.coolapk.market.view.settings;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.databinding.DataBindingUtil;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.DialogTimePickerBinding;
import com.coolapk.market.util.NightModeHelper;
import com.coolapk.market.view.base.BaseDialogFragment;
import com.coolapk.market.widget.Toast;
import com.lany.picker.HourMinutePicker;

public class NightThemeDialog extends BaseDialogFragment implements DialogInterface.OnClickListener {
    private static final int MIN_INTERVAL = 60;
    private DialogTimePickerBinding binding;

    public static NightThemeDialog newInstance() {
        Bundle bundle = new Bundle();
        NightThemeDialog nightThemeDialog = new NightThemeDialog();
        nightThemeDialog.setArguments(bundle);
        return nightThemeDialog;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        this.binding = (DialogTimePickerBinding) DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131558540, null, false);
        int colorAccent = AppHolder.getAppTheme().getColorAccent();
        this.binding.startTimePicker.setSelectionDivider(new ColorDrawable(colorAccent));
        this.binding.endTimePicker.setSelectionDivider(new ColorDrawable(colorAccent));
        int startTime = NightModeHelper.getInstance().getStartTime();
        this.binding.startTimePicker.setCurrentHour(Integer.valueOf(startTime / 60));
        this.binding.startTimePicker.setCurrentMinute(Integer.valueOf(startTime % 60));
        int endTime = NightModeHelper.getInstance().getEndTime();
        this.binding.endTimePicker.setCurrentHour(Integer.valueOf(endTime / 60));
        this.binding.endTimePicker.setCurrentMinute(Integer.valueOf(endTime % 60));
        return new AlertDialog.Builder(getActivity()).setView(this.binding.getRoot()).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(17039370, this).create();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (Math.abs(getTime(this.binding.startTimePicker) - getTime(this.binding.endTimePicker)) < 60) {
            Toast.show(getActivity(), 2131886548);
        } else {
            saveDataAndExit();
        }
    }

    private int getTime(HourMinutePicker hourMinutePicker) {
        return (hourMinutePicker.getCurrentHour().intValue() * 60) + hourMinutePicker.getCurrentMinute().intValue();
    }

    private void saveDataAndExit() {
        NightModeHelper.getInstance().modifyNightModeTime(getTime(this.binding.startTimePicker), getTime(this.binding.endTimePicker));
        Toast.show(getActivity(), 2131886549);
        this.binding.getRoot().postDelayed(new Runnable() {
            /* class com.coolapk.market.view.settings.NightThemeDialog.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                if (NightThemeDialog.this.getActivity() != null) {
                    NightThemeDialog.this.getActivity().finish();
                }
            }
        }, 100);
    }
}
