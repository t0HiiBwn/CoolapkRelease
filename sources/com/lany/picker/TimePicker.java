package com.lany.picker;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.lany.picker.NumberPicker;
import java.util.Calendar;
import java.util.Locale;

public class TimePicker extends FrameLayout {
    private static final boolean DEFAULT_ENABLED_STATE = true;
    private Locale mCurrentLocale;
    private final TextView mFirstDivider;
    private final NumberPicker mHourSpinner;
    private final EditText mHourSpinnerInput;
    private boolean mIsEnabled;
    private final NumberPicker mMinuteSpinner;
    private final EditText mMinuteSpinnerInput;
    private OnTimeChangedListener mOnTimeChangedListener;
    private final TextView mSecondDivider;
    private final NumberPicker mSecondSpinner;
    private final EditText mSecondSpinnerInput;
    private Calendar mTempCalendar;

    public interface OnTimeChangedListener {
        void onTimeChanged(TimePicker timePicker, int i, int i2, int i3);
    }

    public TimePicker(Context context) {
        this(context, null);
    }

    public TimePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.timePickerStyle);
    }

    public TimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsEnabled = true;
        setCurrentLocale(Locale.getDefault());
        LayoutInflater.from(getContext()).inflate(R.layout.picker_time, this);
        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.picker_time_hour);
        this.mHourSpinner = numberPicker;
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            /* class com.lany.picker.TimePicker.AnonymousClass1 */

            @Override // com.lany.picker.NumberPicker.OnValueChangeListener
            public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                TimePicker.this.updateInputState();
                TimePicker.this.onTimeChanged();
            }
        });
        EditText editText = (EditText) numberPicker.findViewById(R.id.np__numberpicker_input);
        this.mHourSpinnerInput = editText;
        editText.setImeOptions(5);
        TextView textView = (TextView) findViewById(R.id.picker_time_first_divider);
        this.mFirstDivider = textView;
        if (textView != null) {
            textView.setText(R.string.time_picker_separator);
        }
        TextView textView2 = (TextView) findViewById(R.id.picker_time_second_divider);
        this.mSecondDivider = textView2;
        if (textView2 != null) {
            textView2.setText(R.string.time_picker_separator);
        }
        NumberPicker numberPicker2 = (NumberPicker) findViewById(R.id.picker_time_minute);
        this.mMinuteSpinner = numberPicker2;
        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(59);
        numberPicker2.setOnLongPressUpdateInterval(100);
        numberPicker2.setFormatter(NumberPicker.getTwoDigitFormatter());
        numberPicker2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            /* class com.lany.picker.TimePicker.AnonymousClass2 */

            @Override // com.lany.picker.NumberPicker.OnValueChangeListener
            public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                TimePicker.this.updateInputState();
                int minValue = TimePicker.this.mMinuteSpinner.getMinValue();
                int maxValue = TimePicker.this.mMinuteSpinner.getMaxValue();
                if (i == maxValue && i2 == minValue) {
                    TimePicker.this.mHourSpinner.setValue(TimePicker.this.mHourSpinner.getValue() + 1);
                } else if (i == minValue && i2 == maxValue) {
                    TimePicker.this.mHourSpinner.setValue(TimePicker.this.mHourSpinner.getValue() - 1);
                }
                TimePicker.this.onTimeChanged();
            }
        });
        EditText editText2 = (EditText) numberPicker2.findViewById(R.id.np__numberpicker_input);
        this.mMinuteSpinnerInput = editText2;
        editText2.setImeOptions(5);
        NumberPicker numberPicker3 = (NumberPicker) findViewById(R.id.picker_time_second);
        this.mSecondSpinner = numberPicker3;
        numberPicker3.setMinValue(0);
        numberPicker3.setMaxValue(59);
        numberPicker2.setOnLongPressUpdateInterval(100);
        numberPicker2.setFormatter(NumberPicker.getTwoDigitFormatter());
        numberPicker3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            /* class com.lany.picker.TimePicker.AnonymousClass3 */

            @Override // com.lany.picker.NumberPicker.OnValueChangeListener
            public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                TimePicker.this.updateInputState();
                numberPicker.requestFocus();
                TimePicker.this.sendAccessibilityEvent(4);
                TimePicker.this.onTimeChanged();
            }
        });
        EditText editText3 = (EditText) numberPicker3.findViewById(R.id.np__numberpicker_input);
        this.mSecondSpinnerInput = editText3;
        editText3.setImeOptions(6);
        updateHourControl();
        sendAccessibilityEvent(4);
        setCurrentHour(Integer.valueOf(this.mTempCalendar.get(11)));
        setCurrentMinute(Integer.valueOf(this.mTempCalendar.get(12)));
        if (!isEnabled()) {
            setEnabled(false);
        }
        if (Build.VERSION.SDK_INT >= 16 && getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public void setSelectionDivider(Drawable drawable) {
        this.mHourSpinner.setSelectionDivider(drawable);
        this.mMinuteSpinner.setSelectionDivider(drawable);
        this.mSecondSpinner.setSelectionDivider(drawable);
    }

    public void setSelectionDividerHeight(int i) {
        this.mHourSpinner.setSelectionDividerHeight(i);
        this.mMinuteSpinner.setSelectionDividerHeight(i);
        this.mSecondSpinner.setSelectionDividerHeight(i);
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (this.mIsEnabled != z) {
            super.setEnabled(z);
            this.mMinuteSpinner.setEnabled(z);
            this.mFirstDivider.setEnabled(z);
            this.mHourSpinner.setEnabled(z);
            this.mSecondDivider.setEnabled(z);
            this.mSecondSpinner.setEnabled(z);
            this.mIsEnabled = z;
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setCurrentLocale(configuration.locale);
    }

    private void setCurrentLocale(Locale locale) {
        if (!locale.equals(this.mCurrentLocale)) {
            this.mCurrentLocale = locale;
            this.mTempCalendar = Calendar.getInstance(locale);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getCurrentHour().intValue(), getCurrentMinute().intValue(), getCurrentSecond().intValue());
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentHour(Integer.valueOf(savedState.getHour()));
        setCurrentMinute(Integer.valueOf(savedState.getMinute()));
        setCurrentSecond(Integer.valueOf(savedState.getSecond()));
    }

    public void setOnTimeChangedListener(OnTimeChangedListener onTimeChangedListener) {
        this.mOnTimeChangedListener = onTimeChangedListener;
    }

    public Integer getCurrentHour() {
        return Integer.valueOf(this.mHourSpinner.getValue());
    }

    public void setCurrentHour(Integer num) {
        if (num != null && num != getCurrentHour()) {
            this.mHourSpinner.setValue(num.intValue());
            onTimeChanged();
        }
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(this.mMinuteSpinner.getValue());
    }

    public void setCurrentMinute(Integer num) {
        if (num != getCurrentMinute()) {
            this.mMinuteSpinner.setValue(num.intValue());
            onTimeChanged();
        }
    }

    public Integer getCurrentSecond() {
        return Integer.valueOf(this.mSecondSpinner.getValue());
    }

    public void setCurrentSecond(Integer num) {
        if (num != getCurrentSecond()) {
            this.mSecondSpinner.setValue(num.intValue());
            onTimeChanged();
        }
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.mHourSpinner.getBaseline();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        this.mTempCalendar.set(11, getCurrentHour().intValue());
        this.mTempCalendar.set(12, getCurrentMinute().intValue());
        this.mTempCalendar.set(13, getCurrentSecond().intValue());
        accessibilityEvent.getText().add(DateUtils.formatDateTime(getContext(), this.mTempCalendar.getTimeInMillis(), 129));
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(TimePicker.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TimePicker.class.getName());
    }

    private void updateHourControl() {
        this.mHourSpinner.setMinValue(0);
        this.mHourSpinner.setMaxValue(23);
        this.mHourSpinner.setFormatter(NumberPicker.getTwoDigitFormatter());
    }

    /* access modifiers changed from: private */
    public void onTimeChanged() {
        sendAccessibilityEvent(4);
        OnTimeChangedListener onTimeChangedListener = this.mOnTimeChangedListener;
        if (onTimeChangedListener != null) {
            onTimeChangedListener.onTimeChanged(this, getCurrentHour().intValue(), getCurrentMinute().intValue(), getCurrentSecond().intValue());
        }
    }

    /* access modifiers changed from: private */
    public void updateInputState() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager == null) {
            return;
        }
        if (inputMethodManager.isActive(this.mHourSpinnerInput)) {
            this.mHourSpinnerInput.clearFocus();
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        } else if (inputMethodManager.isActive(this.mMinuteSpinnerInput)) {
            this.mMinuteSpinnerInput.clearFocus();
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        } else if (inputMethodManager.isActive(this.mSecondSpinnerInput)) {
            this.mSecondSpinnerInput.clearFocus();
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    private static class SavedState extends View.BaseSavedState {
        private final int mHour;
        private final int mMinute;
        private final int mSecond;

        private SavedState(Parcelable parcelable, int i, int i2, int i3) {
            super(parcelable);
            this.mHour = i;
            this.mMinute = i2;
            this.mSecond = i3;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mHour = parcel.readInt();
            this.mMinute = parcel.readInt();
            this.mSecond = parcel.readInt();
        }

        public int getHour() {
            return this.mHour;
        }

        public int getMinute() {
            return this.mMinute;
        }

        public int getSecond() {
            return this.mSecond;
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mHour);
            parcel.writeInt(this.mMinute);
            parcel.writeInt(this.mSecond);
        }
    }
}
