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
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.lany.picker.NumberPicker;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;

public class HourMinutePicker extends FrameLayout {
    private static final boolean DEFAULT_ENABLED_STATE = true;
    private static final int HOURS_IN_HALF_DAY = 12;
    private final Button mAmPmButton;
    private final NumberPicker mAmPmSpinner;
    private final EditText mAmPmSpinnerInput;
    private final String[] mAmPmStrings;
    private Locale mCurrentLocale;
    private final TextView mDivider;
    private final NumberPicker mHourSpinner;
    private final EditText mHourSpinnerInput;
    private boolean mIs24HourView;
    private boolean mIsAm;
    private boolean mIsEnabled;
    private final NumberPicker mMinuteSpinner;
    private final EditText mMinuteSpinnerInput;
    private OnTimeChangedListener mOnTimeChangedListener;
    private Calendar mTempCalendar;

    public interface OnTimeChangedListener {
        void onTimeChanged(HourMinutePicker hourMinutePicker, int i, int i2);
    }

    private void setContentDescriptions() {
    }

    public HourMinutePicker(Context context) {
        this(context, null);
    }

    public HourMinutePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.timePickerStyle);
    }

    public HourMinutePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIs24HourView = true;
        this.mIsEnabled = true;
        setCurrentLocale(Locale.getDefault());
        LayoutInflater.from(getContext()).inflate(R.layout.picker_hour_minute, this);
        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.hour);
        this.mHourSpinner = numberPicker;
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            /* class com.lany.picker.HourMinutePicker.AnonymousClass1 */

            @Override // com.lany.picker.NumberPicker.OnValueChangeListener
            public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                HourMinutePicker.this.updateInputState();
                if (!HourMinutePicker.this.is24HourView() && ((i == 11 && i2 == 12) || (i == 12 && i2 == 11))) {
                    HourMinutePicker hourMinutePicker = HourMinutePicker.this;
                    hourMinutePicker.mIsAm = !hourMinutePicker.mIsAm;
                    HourMinutePicker.this.updateAmPmControl();
                }
                HourMinutePicker.this.onTimeChanged();
            }
        });
        EditText editText = (EditText) numberPicker.findViewById(R.id.np__numberpicker_input);
        this.mHourSpinnerInput = editText;
        editText.setImeOptions(5);
        TextView textView = (TextView) findViewById(R.id.divider);
        this.mDivider = textView;
        if (textView != null) {
            textView.setText(R.string.time_picker_separator);
        }
        NumberPicker numberPicker2 = (NumberPicker) findViewById(R.id.minute);
        this.mMinuteSpinner = numberPicker2;
        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(59);
        numberPicker2.setOnLongPressUpdateInterval(100);
        numberPicker2.setFormatter(NumberPicker.getTwoDigitFormatter());
        numberPicker2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            /* class com.lany.picker.HourMinutePicker.AnonymousClass2 */

            @Override // com.lany.picker.NumberPicker.OnValueChangeListener
            public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                HourMinutePicker.this.updateInputState();
                int minValue = HourMinutePicker.this.mMinuteSpinner.getMinValue();
                int maxValue = HourMinutePicker.this.mMinuteSpinner.getMaxValue();
                if (i == maxValue && i2 == minValue) {
                    int value = HourMinutePicker.this.mHourSpinner.getValue() + 1;
                    if (!HourMinutePicker.this.is24HourView() && value == 12) {
                        HourMinutePicker hourMinutePicker = HourMinutePicker.this;
                        hourMinutePicker.mIsAm = !hourMinutePicker.mIsAm;
                        HourMinutePicker.this.updateAmPmControl();
                    }
                    HourMinutePicker.this.mHourSpinner.setValue(value);
                } else if (i == minValue && i2 == maxValue) {
                    int value2 = HourMinutePicker.this.mHourSpinner.getValue() - 1;
                    if (!HourMinutePicker.this.is24HourView() && value2 == 11) {
                        HourMinutePicker hourMinutePicker2 = HourMinutePicker.this;
                        hourMinutePicker2.mIsAm = !hourMinutePicker2.mIsAm;
                        HourMinutePicker.this.updateAmPmControl();
                    }
                    HourMinutePicker.this.mHourSpinner.setValue(value2);
                }
                HourMinutePicker.this.onTimeChanged();
            }
        });
        EditText editText2 = (EditText) numberPicker2.findViewById(R.id.np__numberpicker_input);
        this.mMinuteSpinnerInput = editText2;
        editText2.setImeOptions(5);
        String[] amPmStrings = new DateFormatSymbols().getAmPmStrings();
        this.mAmPmStrings = amPmStrings;
        View findViewById = findViewById(R.id.amPm);
        if (findViewById instanceof Button) {
            this.mAmPmSpinner = null;
            this.mAmPmSpinnerInput = null;
            Button button = (Button) findViewById;
            this.mAmPmButton = button;
            button.setOnClickListener(new View.OnClickListener() {
                /* class com.lany.picker.HourMinutePicker.AnonymousClass3 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    view.requestFocus();
                    HourMinutePicker hourMinutePicker = HourMinutePicker.this;
                    hourMinutePicker.mIsAm = !hourMinutePicker.mIsAm;
                    HourMinutePicker.this.updateAmPmControl();
                    HourMinutePicker.this.onTimeChanged();
                }
            });
        } else {
            this.mAmPmButton = null;
            NumberPicker numberPicker3 = (NumberPicker) findViewById;
            this.mAmPmSpinner = numberPicker3;
            numberPicker3.setMinValue(0);
            numberPicker3.setMaxValue(1);
            numberPicker3.setDisplayedValues(amPmStrings);
            numberPicker3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                /* class com.lany.picker.HourMinutePicker.AnonymousClass4 */

                @Override // com.lany.picker.NumberPicker.OnValueChangeListener
                public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                    HourMinutePicker.this.updateInputState();
                    numberPicker.requestFocus();
                    HourMinutePicker hourMinutePicker = HourMinutePicker.this;
                    hourMinutePicker.mIsAm = !hourMinutePicker.mIsAm;
                    HourMinutePicker.this.updateAmPmControl();
                    HourMinutePicker.this.onTimeChanged();
                }
            });
            EditText editText3 = (EditText) numberPicker3.findViewById(R.id.np__numberpicker_input);
            this.mAmPmSpinnerInput = editText3;
            editText3.setImeOptions(6);
        }
        updateHourControl();
        updateAmPmControl();
        setOnTimeChangedListener(new OnTimeChangedListener() {
            /* class com.lany.picker.HourMinutePicker.AnonymousClass5 */

            @Override // com.lany.picker.HourMinutePicker.OnTimeChangedListener
            public void onTimeChanged(HourMinutePicker hourMinutePicker, int i, int i2) {
            }
        });
        setCurrentHour(Integer.valueOf(this.mTempCalendar.get(11)));
        setCurrentMinute(Integer.valueOf(this.mTempCalendar.get(12)));
        if (!isEnabled()) {
            setEnabled(false);
        }
        setContentDescriptions();
        if (Build.VERSION.SDK_INT >= 16 && getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public void setSelectionDivider(Drawable drawable) {
        this.mHourSpinner.setSelectionDivider(drawable);
        this.mMinuteSpinner.setSelectionDivider(drawable);
        this.mAmPmSpinner.setSelectionDivider(drawable);
    }

    public void setSelectionDividerHeight(int i) {
        this.mHourSpinner.setSelectionDividerHeight(i);
        this.mMinuteSpinner.setSelectionDividerHeight(i);
        this.mAmPmSpinner.setSelectionDividerHeight(i);
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
            TextView textView = this.mDivider;
            if (textView != null) {
                textView.setEnabled(z);
            }
            this.mHourSpinner.setEnabled(z);
            NumberPicker numberPicker = this.mAmPmSpinner;
            if (numberPicker != null) {
                numberPicker.setEnabled(z);
            } else {
                this.mAmPmButton.setEnabled(z);
            }
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
        return new SavedState(super.onSaveInstanceState(), getCurrentHour().intValue(), getCurrentMinute().intValue());
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentHour(Integer.valueOf(savedState.getHour()));
        setCurrentMinute(Integer.valueOf(savedState.getMinute()));
    }

    public void setOnTimeChangedListener(OnTimeChangedListener onTimeChangedListener) {
        this.mOnTimeChangedListener = onTimeChangedListener;
    }

    public Integer getCurrentHour() {
        int value = this.mHourSpinner.getValue();
        if (is24HourView()) {
            return Integer.valueOf(value);
        }
        if (this.mIsAm) {
            return Integer.valueOf(value % 12);
        }
        return Integer.valueOf((value % 12) + 12);
    }

    public void setCurrentHour(Integer num) {
        if (num != null && num != getCurrentHour()) {
            if (!is24HourView()) {
                if (num.intValue() >= 12) {
                    this.mIsAm = false;
                    if (num.intValue() > 12) {
                        num = Integer.valueOf(num.intValue() - 12);
                    }
                } else {
                    this.mIsAm = true;
                    if (num.intValue() == 0) {
                        num = 12;
                    }
                }
                updateAmPmControl();
            }
            this.mHourSpinner.setValue(num.intValue());
            onTimeChanged();
        }
    }

    public void setIs24HourView(Boolean bool) {
        if (this.mIs24HourView != bool.booleanValue()) {
            this.mIs24HourView = bool.booleanValue();
            int intValue = getCurrentHour().intValue();
            updateHourControl();
            setCurrentHour(Integer.valueOf(intValue));
            updateAmPmControl();
        }
    }

    public boolean is24HourView() {
        return this.mIs24HourView;
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
        int i = this.mIs24HourView ? 129 : 65;
        this.mTempCalendar.set(11, getCurrentHour().intValue());
        this.mTempCalendar.set(12, getCurrentMinute().intValue());
        accessibilityEvent.getText().add(DateUtils.formatDateTime(getContext(), this.mTempCalendar.getTimeInMillis(), i));
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(HourMinutePicker.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(HourMinutePicker.class.getName());
    }

    private void updateHourControl() {
        if (is24HourView()) {
            this.mHourSpinner.setMinValue(0);
            this.mHourSpinner.setMaxValue(23);
            this.mHourSpinner.setFormatter(NumberPicker.getTwoDigitFormatter());
            return;
        }
        this.mHourSpinner.setMinValue(1);
        this.mHourSpinner.setMaxValue(12);
        this.mHourSpinner.setFormatter(null);
    }

    /* access modifiers changed from: private */
    public void updateAmPmControl() {
        if (is24HourView()) {
            NumberPicker numberPicker = this.mAmPmSpinner;
            if (numberPicker != null) {
                numberPicker.setVisibility(8);
            } else {
                this.mAmPmButton.setVisibility(8);
            }
        } else {
            int i = !this.mIsAm ? 1 : 0;
            NumberPicker numberPicker2 = this.mAmPmSpinner;
            if (numberPicker2 != null) {
                numberPicker2.setValue(i);
                this.mAmPmSpinner.setVisibility(0);
            } else {
                this.mAmPmButton.setText(this.mAmPmStrings[i]);
                this.mAmPmButton.setVisibility(0);
            }
        }
        sendAccessibilityEvent(4);
    }

    /* access modifiers changed from: private */
    public void onTimeChanged() {
        sendAccessibilityEvent(4);
        OnTimeChangedListener onTimeChangedListener = this.mOnTimeChangedListener;
        if (onTimeChangedListener != null) {
            onTimeChangedListener.onTimeChanged(this, getCurrentHour().intValue(), getCurrentMinute().intValue());
        }
    }

    private void trySetContentDescription(View view, int i, int i2) {
        View findViewById = view.findViewById(i);
        if (findViewById != null) {
            findViewById.setContentDescription(getContext().getString(i2));
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
        } else if (inputMethodManager.isActive(this.mAmPmSpinnerInput)) {
            this.mAmPmSpinnerInput.clearFocus();
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.lany.picker.HourMinutePicker.SavedState.AnonymousClass1 */

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        private final int mHour;
        private final int mMinute;

        private SavedState(Parcelable parcelable, int i, int i2) {
            super(parcelable);
            this.mHour = i;
            this.mMinute = i2;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mHour = parcel.readInt();
            this.mMinute = parcel.readInt();
        }

        public int getHour() {
            return this.mHour;
        }

        public int getMinute() {
            return this.mMinute;
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mHour);
            parcel.writeInt(this.mMinute);
        }
    }
}
