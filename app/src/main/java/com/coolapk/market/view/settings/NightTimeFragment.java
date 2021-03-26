package com.coolapk.market.view.settings;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.NightTimePickerBinding;
import com.coolapk.market.util.NightModeHelper;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.base.ToolbarActivity;
import com.coolapk.market.widget.Toast;
import com.lany.picker.HourMinutePicker;

public class NightTimeFragment extends BaseFragment implements View.OnClickListener {
    private static final int MIN_INTERVAL = 60;
    private NightTimePickerBinding binding;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        NightTimePickerBinding nightTimePickerBinding = (NightTimePickerBinding) DataBindingUtil.inflate(layoutInflater, 2131559055, viewGroup, false);
        this.binding = nightTimePickerBinding;
        return nightTimePickerBinding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        int colorAccent = AppHolder.getAppTheme().getColorAccent();
        this.binding.startTimePicker.setSelectionDivider(new ColorDrawable(colorAccent));
        this.binding.endTimePicker.setSelectionDivider(new ColorDrawable(colorAccent));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        int startTime = NightModeHelper.getInstance().getStartTime();
        this.binding.startTimePicker.setCurrentHour(Integer.valueOf(startTime / 60));
        this.binding.startTimePicker.setCurrentMinute(Integer.valueOf(startTime % 60));
        int endTime = NightModeHelper.getInstance().getEndTime();
        this.binding.endTimePicker.setCurrentHour(Integer.valueOf(endTime / 60));
        this.binding.endTimePicker.setCurrentMinute(Integer.valueOf(endTime % 60));
        ViewUtil.clickListener(((ToolbarActivity) getActivity()).getFab(), this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ViewUtil.clickListener(((ToolbarActivity) getActivity()).getFab(), null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (Math.abs(getTime(this.binding.startTimePicker) - getTime(this.binding.endTimePicker)) < 60) {
            Toast.show(getActivity(), 2131886488);
        } else {
            saveDataAndExit();
        }
    }

    private int getTime(HourMinutePicker hourMinutePicker) {
        return (hourMinutePicker.getCurrentHour().intValue() * 60) + hourMinutePicker.getCurrentMinute().intValue();
    }

    private void saveDataAndExit() {
        NightModeHelper.getInstance().modifyNightModeTime(getTime(this.binding.startTimePicker), getTime(this.binding.endTimePicker));
        Toast.show(getActivity(), 2131886489);
        this.binding.getRoot().postDelayed(new Runnable() {
            /* class com.coolapk.market.view.settings.NightTimeFragment.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                if (NightTimeFragment.this.getActivity() != null) {
                    NightTimeFragment.this.getActivity().finish();
                }
            }
        }, 100);
    }
}
