package com.lany.picker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.lany.picker.NumberPicker;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateTimePicker extends FrameLayout {
    private static final String DATE_FORMAT = "MM/dd/yyyy";
    private static final int DEFAULT_END_YEAR = 2100;
    private static final int DEFAULT_START_YEAR = 1900;
    private final String TAG = getClass().getSimpleName();
    private Calendar mCurrentDate;
    private Locale mCurrentLocale;
    private NumberPicker mDaySpinner;
    private EditText mDaySpinnerInput;
    private NumberPicker mHourSpinner;
    private EditText mHourSpinnerInput;
    private boolean mIsEnabled = true;
    private Calendar mMaxDate;
    private Calendar mMinDate;
    private NumberPicker mMinuteSpinner;
    private EditText mMinuteSpinnerInput;
    private NumberPicker mMonthSpinner;
    private EditText mMonthSpinnerInput;
    private int mNumberOfMonths;
    private OnChangedListener mOnChangedListener;
    private NumberPicker mSecondSpinner;
    private EditText mSecondSpinnerInput;
    private String[] mShortMonths;
    private Calendar mTempDate;
    private NumberPicker mYearSpinner;
    private EditText mYearSpinnerInput;

    public interface OnChangedListener {
        void onChanged(DateTimePicker dateTimePicker, int i, int i2, int i3, int i4, int i5, int i6);
    }

    public DateTimePicker(Context context) {
        super(context);
        init(null);
    }

    public DateTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public DateTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    public void init(AttributeSet attributeSet) {
        String str;
        LayoutInflater.from(getContext()).inflate(R.layout.picker_date_time, this);
        setCurrentLocale(Locale.getDefault());
        String str2 = "";
        int i = 2100;
        int i2 = 1900;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.YMDHPicker);
            i2 = obtainStyledAttributes.getInt(R.styleable.YMDHPicker_startYear, 1900);
            i = obtainStyledAttributes.getInt(R.styleable.YMDHPicker_endYear, 2100);
            str2 = obtainStyledAttributes.getString(R.styleable.YMDHPicker_minDate);
            str = obtainStyledAttributes.getString(R.styleable.YMDHPicker_maxDate);
            obtainStyledAttributes.recycle();
        } else {
            str = str2;
        }
        AnonymousClass1 r0 = new NumberPicker.OnValueChangeListener() {
            /* class com.lany.picker.DateTimePicker.AnonymousClass1 */

            @Override // com.lany.picker.NumberPicker.OnValueChangeListener
            public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                DateTimePicker.this.updateInputState();
                DateTimePicker.this.mTempDate.setTimeInMillis(DateTimePicker.this.mCurrentDate.getTimeInMillis());
                if (numberPicker == DateTimePicker.this.mDaySpinner) {
                    int actualMaximum = DateTimePicker.this.mTempDate.getActualMaximum(5);
                    if (i == actualMaximum && i2 == 1) {
                        DateTimePicker.this.mTempDate.add(5, 1);
                    } else if (i == 1 && i2 == actualMaximum) {
                        DateTimePicker.this.mTempDate.add(5, -1);
                    } else {
                        DateTimePicker.this.mTempDate.add(5, i2 - i);
                    }
                } else if (numberPicker == DateTimePicker.this.mMonthSpinner) {
                    if (i == 11 && i2 == 0) {
                        DateTimePicker.this.mTempDate.add(2, 1);
                    } else if (i == 0 && i2 == 11) {
                        DateTimePicker.this.mTempDate.add(2, -1);
                    } else {
                        DateTimePicker.this.mTempDate.add(2, i2 - i);
                    }
                } else if (numberPicker == DateTimePicker.this.mYearSpinner) {
                    DateTimePicker.this.mTempDate.set(1, i2);
                } else if (numberPicker == DateTimePicker.this.mHourSpinner) {
                    DateTimePicker.this.mTempDate.set(11, i2);
                } else if (numberPicker == DateTimePicker.this.mMinuteSpinner) {
                    DateTimePicker.this.mTempDate.set(12, i2);
                } else if (numberPicker == DateTimePicker.this.mSecondSpinner) {
                    DateTimePicker.this.mTempDate.set(13, i2);
                } else {
                    throw new IllegalArgumentException();
                }
                DateTimePicker dateTimePicker = DateTimePicker.this;
                dateTimePicker.setDate(dateTimePicker.mTempDate.get(1), DateTimePicker.this.mTempDate.get(2), DateTimePicker.this.mTempDate.get(5), DateTimePicker.this.mTempDate.get(11), DateTimePicker.this.mTempDate.get(12), DateTimePicker.this.mTempDate.get(13));
                DateTimePicker.this.updateSpinners();
                DateTimePicker.this.notifyDateChanged();
            }
        };
        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.minute);
        this.mMinuteSpinner = numberPicker;
        numberPicker.setMinValue(0);
        this.mMinuteSpinner.setMaxValue(59);
        this.mMinuteSpinner.setOnLongPressUpdateInterval(100);
        this.mMinuteSpinner.setFormatter(NumberPicker.getTwoDigitFormatter());
        this.mMinuteSpinner.setOnValueChangedListener(r0);
        EditText editText = (EditText) this.mMinuteSpinner.findViewById(R.id.np__numberpicker_input);
        this.mMinuteSpinnerInput = editText;
        editText.setImeOptions(5);
        NumberPicker numberPicker2 = (NumberPicker) findViewById(R.id.second);
        this.mSecondSpinner = numberPicker2;
        numberPicker2.setMinValue(0);
        this.mSecondSpinner.setMaxValue(59);
        this.mMinuteSpinner.setOnLongPressUpdateInterval(100);
        this.mMinuteSpinner.setFormatter(NumberPicker.getTwoDigitFormatter());
        this.mSecondSpinner.setOnValueChangedListener(r0);
        EditText editText2 = (EditText) this.mSecondSpinner.findViewById(R.id.np__numberpicker_input);
        this.mSecondSpinnerInput = editText2;
        editText2.setImeOptions(6);
        NumberPicker numberPicker3 = (NumberPicker) findViewById(R.id.hour);
        this.mHourSpinner = numberPicker3;
        numberPicker3.setOnLongPressUpdateInterval(100);
        this.mHourSpinner.setOnValueChangedListener(r0);
        this.mHourSpinnerInput = (EditText) this.mHourSpinner.findViewById(R.id.np__numberpicker_input);
        NumberPicker numberPicker4 = (NumberPicker) findViewById(R.id.day);
        this.mDaySpinner = numberPicker4;
        numberPicker4.setFormatter(NumberPicker.getTwoDigitFormatter());
        this.mDaySpinner.setOnLongPressUpdateInterval(100);
        this.mDaySpinner.setOnValueChangedListener(r0);
        this.mDaySpinnerInput = (EditText) this.mDaySpinner.findViewById(R.id.np__numberpicker_input);
        NumberPicker numberPicker5 = (NumberPicker) findViewById(R.id.month);
        this.mMonthSpinner = numberPicker5;
        numberPicker5.setMinValue(0);
        this.mMonthSpinner.setMaxValue(this.mNumberOfMonths - 1);
        this.mMonthSpinner.setDisplayedValues(this.mShortMonths);
        this.mMonthSpinner.setOnLongPressUpdateInterval(200);
        this.mMonthSpinner.setOnValueChangedListener(r0);
        this.mMonthSpinnerInput = (EditText) this.mMonthSpinner.findViewById(R.id.np__numberpicker_input);
        NumberPicker numberPicker6 = (NumberPicker) findViewById(R.id.year);
        this.mYearSpinner = numberPicker6;
        numberPicker6.setOnLongPressUpdateInterval(100);
        this.mYearSpinner.setOnValueChangedListener(r0);
        this.mYearSpinnerInput = (EditText) this.mYearSpinner.findViewById(R.id.np__numberpicker_input);
        this.mTempDate.clear();
        if (TextUtils.isEmpty(str2)) {
            this.mTempDate.set(i2, 0, 1);
        } else if (!parseDate(str2, this.mTempDate)) {
            this.mTempDate.set(i2, 0, 1);
        }
        setMinDate(this.mTempDate.getTimeInMillis());
        this.mTempDate.clear();
        if (TextUtils.isEmpty(str)) {
            this.mTempDate.set(i, 11, 31);
        } else if (!parseDate(str, this.mTempDate)) {
            this.mTempDate.set(i, 11, 31);
        }
        setMaxDate(this.mTempDate.getTimeInMillis());
        this.mCurrentDate.setTimeInMillis(System.currentTimeMillis());
        init(this.mCurrentDate.get(1), this.mCurrentDate.get(2), this.mCurrentDate.get(5), this.mCurrentDate.get(11), this.mCurrentDate.get(12), this.mCurrentDate.get(13));
        reorderSpinners();
        if (Build.VERSION.SDK_INT >= 16 && getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public void setOnChangedListener(OnChangedListener onChangedListener) {
        this.mOnChangedListener = onChangedListener;
    }

    public void setSelectionDivider(Drawable drawable) {
        this.mDaySpinner.setSelectionDivider(drawable);
        this.mMonthSpinner.setSelectionDivider(drawable);
        this.mYearSpinner.setSelectionDivider(drawable);
        this.mHourSpinner.setSelectionDivider(drawable);
        this.mMinuteSpinner.setSelectionDivider(drawable);
        this.mSecondSpinner.setSelectionDivider(drawable);
    }

    public void setSelectionDividerHeight(int i) {
        this.mDaySpinner.setSelectionDividerHeight(i);
        this.mMonthSpinner.setSelectionDividerHeight(i);
        this.mYearSpinner.setSelectionDividerHeight(i);
        this.mHourSpinner.setSelectionDividerHeight(i);
        this.mMinuteSpinner.setSelectionDividerHeight(i);
        this.mSecondSpinner.setSelectionDividerHeight(i);
    }

    public void setMinDate(long j) {
        this.mTempDate.setTimeInMillis(j);
        if (this.mTempDate.get(1) != this.mMinDate.get(1) || this.mTempDate.get(6) == this.mMinDate.get(6)) {
            this.mMinDate.setTimeInMillis(j);
            if (this.mCurrentDate.before(this.mMinDate)) {
                this.mCurrentDate.setTimeInMillis(this.mMinDate.getTimeInMillis());
            }
            updateSpinners();
        }
    }

    public void setMaxDate(long j) {
        this.mTempDate.setTimeInMillis(j);
        if (this.mTempDate.get(1) != this.mMaxDate.get(1) || this.mTempDate.get(6) == this.mMaxDate.get(6)) {
            this.mMaxDate.setTimeInMillis(j);
            if (this.mCurrentDate.after(this.mMaxDate)) {
                this.mCurrentDate.setTimeInMillis(this.mMaxDate.getTimeInMillis());
            }
            updateSpinners();
        }
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (this.mIsEnabled != z) {
            super.setEnabled(z);
            this.mHourSpinner.setEnabled(z);
            this.mDaySpinner.setEnabled(z);
            this.mMonthSpinner.setEnabled(z);
            this.mYearSpinner.setEnabled(z);
            this.mMinuteSpinner.setEnabled(z);
            this.mSecondSpinner.setEnabled(z);
            this.mIsEnabled = z;
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.getText().add(DateUtils.formatDateTime(getContext(), this.mCurrentDate.getTimeInMillis(), 20));
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(DateTimePicker.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(DateTimePicker.class.getName());
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setCurrentLocale(configuration.locale);
    }

    private void setCurrentLocale(Locale locale) {
        if (!locale.equals(this.mCurrentLocale)) {
            this.mCurrentLocale = locale;
            this.mTempDate = getCalendarForLocale(this.mTempDate, locale);
            this.mMinDate = getCalendarForLocale(this.mMinDate, locale);
            this.mMaxDate = getCalendarForLocale(this.mMaxDate, locale);
            this.mCurrentDate = getCalendarForLocale(this.mCurrentDate, locale);
            int actualMaximum = this.mTempDate.getActualMaximum(2) + 1;
            this.mNumberOfMonths = actualMaximum;
            this.mShortMonths = new String[actualMaximum];
            for (int i = 0; i < this.mNumberOfMonths; i++) {
                this.mShortMonths[i] = DateUtils.getMonthString(i + 0, 20);
            }
        }
    }

    private Calendar getCalendarForLocale(Calendar calendar, Locale locale) {
        if (calendar == null) {
            return Calendar.getInstance(locale);
        }
        long timeInMillis = calendar.getTimeInMillis();
        Calendar instance = Calendar.getInstance(locale);
        instance.setTimeInMillis(timeInMillis);
        return instance;
    }

    private void reorderSpinners() {
        char[] dateFormatOrder = DateFormat.getDateFormatOrder(getContext());
        int length = dateFormatOrder.length;
        for (int i = 0; i < length; i++) {
            char c = dateFormatOrder[i];
            if (c == 'M') {
                setImeOptions(this.mMonthSpinner, length, i);
            } else if (c == 'd') {
                setImeOptions(this.mDaySpinner, length, i);
            } else if (c == 'h') {
                setImeOptions(this.mHourSpinner, length, i);
            } else if (c == 'm') {
                setImeOptions(this.mMinuteSpinner, length, i);
            } else if (c == 's') {
                setImeOptions(this.mSecondSpinner, length, i);
            } else if (c == 'y') {
                setImeOptions(this.mYearSpinner, length, i);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public void updateDate(int i, int i2, int i3, int i4, int i5, int i6) {
        if (isNewDate(i, i2, i3, i4, i5, i6)) {
            setDate(i, i2, i3, i4, i5, i6);
            updateSpinners();
            notifyDateChanged();
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getYear(), getMonth(), getDayOfMonth(), getHourOfDay(), getMinute(), getSecond());
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setDate(savedState.mYear, savedState.mMonth, savedState.mDay, savedState.mHour, savedState.mMinute, savedState.mSecond);
        updateSpinners();
    }

    public void init(int i, int i2, int i3, int i4, int i5, int i6) {
        setDate(i, i2, i3, i4, i5, i6);
        updateSpinners();
    }

    private boolean parseDate(String str, Calendar calendar) {
        try {
            calendar.setTime(new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault()).parse(str));
            return true;
        } catch (ParseException unused) {
            String str2 = this.TAG;
            Log.w(str2, "Date: " + str + " not in format: MM/dd/yyyy");
            return false;
        }
    }

    private boolean isNewDate(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.mCurrentDate.get(1) == i && this.mCurrentDate.get(2) == i3 && this.mCurrentDate.get(5) == i2 && this.mCurrentDate.get(11) == i4 && this.mCurrentDate.get(12) == i5 && this.mCurrentDate.get(13) == i6) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void setDate(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mCurrentDate.set(i, i2, i3, i4, i5, i6);
        if (this.mCurrentDate.before(this.mMinDate)) {
            this.mCurrentDate.setTimeInMillis(this.mMinDate.getTimeInMillis());
        } else if (this.mCurrentDate.after(this.mMaxDate)) {
            this.mCurrentDate.setTimeInMillis(this.mMaxDate.getTimeInMillis());
        }
    }

    /* access modifiers changed from: private */
    public void updateSpinners() {
        if (this.mCurrentDate.equals(this.mMinDate)) {
            this.mDaySpinner.setMinValue(this.mCurrentDate.get(5));
            this.mDaySpinner.setMaxValue(this.mCurrentDate.getActualMaximum(5));
            this.mDaySpinner.setWrapSelectorWheel(false);
            this.mMonthSpinner.setDisplayedValues(null);
            this.mMonthSpinner.setMinValue(this.mCurrentDate.get(2));
            this.mMonthSpinner.setMaxValue(this.mCurrentDate.getActualMaximum(2));
            this.mMonthSpinner.setWrapSelectorWheel(false);
        } else if (this.mCurrentDate.equals(this.mMaxDate)) {
            this.mDaySpinner.setMinValue(this.mCurrentDate.getActualMinimum(5));
            this.mDaySpinner.setMaxValue(this.mCurrentDate.get(5));
            this.mDaySpinner.setWrapSelectorWheel(false);
            this.mMonthSpinner.setDisplayedValues(null);
            this.mMonthSpinner.setMinValue(this.mCurrentDate.getActualMinimum(2));
            this.mMonthSpinner.setMaxValue(this.mCurrentDate.get(2));
            this.mMonthSpinner.setWrapSelectorWheel(false);
        } else {
            this.mDaySpinner.setMinValue(1);
            this.mDaySpinner.setMaxValue(this.mCurrentDate.getActualMaximum(5));
            this.mDaySpinner.setWrapSelectorWheel(true);
            this.mMonthSpinner.setDisplayedValues(null);
            this.mMonthSpinner.setMinValue(0);
            this.mMonthSpinner.setMaxValue(11);
            this.mMonthSpinner.setWrapSelectorWheel(true);
        }
        this.mMonthSpinner.setDisplayedValues((String[]) ArraysUtils.copyOfRange(this.mShortMonths, this.mMonthSpinner.getMinValue(), this.mMonthSpinner.getMaxValue() + 1));
        this.mYearSpinner.setMinValue(this.mMinDate.get(1));
        this.mYearSpinner.setMaxValue(this.mMaxDate.get(1));
        this.mYearSpinner.setWrapSelectorWheel(false);
        this.mHourSpinner.setMinValue(0);
        this.mHourSpinner.setMaxValue(23);
        this.mHourSpinner.setWrapSelectorWheel(true);
        this.mMinuteSpinner.setMinValue(0);
        this.mMinuteSpinner.setMaxValue(59);
        this.mMinuteSpinner.setWrapSelectorWheel(true);
        this.mSecondSpinner.setMinValue(0);
        this.mSecondSpinner.setMaxValue(59);
        this.mSecondSpinner.setWrapSelectorWheel(true);
        this.mYearSpinner.setValue(this.mCurrentDate.get(1));
        this.mMonthSpinner.setValue(this.mCurrentDate.get(2));
        this.mDaySpinner.setValue(this.mCurrentDate.get(5));
        this.mHourSpinner.setValue(this.mCurrentDate.get(11));
        this.mMinuteSpinner.setValue(this.mCurrentDate.get(12));
        this.mSecondSpinner.setValue(this.mCurrentDate.get(13));
    }

    public int getYear() {
        return this.mCurrentDate.get(1);
    }

    public int getMonth() {
        return this.mCurrentDate.get(2);
    }

    public int getDayOfMonth() {
        return this.mCurrentDate.get(5);
    }

    public int getHourOfDay() {
        return this.mCurrentDate.get(11);
    }

    public int getMinute() {
        return this.mCurrentDate.get(12);
    }

    public int getSecond() {
        return this.mCurrentDate.get(13);
    }

    /* access modifiers changed from: private */
    public void notifyDateChanged() {
        sendAccessibilityEvent(4);
        OnChangedListener onChangedListener = this.mOnChangedListener;
        if (onChangedListener != null) {
            onChangedListener.onChanged(this, getYear(), getMonth(), getDayOfMonth(), getHourOfDay(), getMinute(), getSecond());
        }
    }

    private void setImeOptions(NumberPicker numberPicker, int i, int i2) {
        ((TextView) numberPicker.findViewById(R.id.np__numberpicker_input)).setImeOptions(i2 < i + -1 ? 5 : 6);
    }

    /* access modifiers changed from: private */
    public void updateInputState() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager == null) {
            return;
        }
        if (inputMethodManager.isActive(this.mYearSpinnerInput)) {
            this.mYearSpinnerInput.clearFocus();
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        } else if (inputMethodManager.isActive(this.mMonthSpinnerInput)) {
            this.mMonthSpinnerInput.clearFocus();
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        } else if (inputMethodManager.isActive(this.mDaySpinnerInput)) {
            this.mDaySpinnerInput.clearFocus();
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        } else if (inputMethodManager.isActive(this.mHourSpinnerInput)) {
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
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.lany.picker.DateTimePicker.SavedState.AnonymousClass1 */

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        private final int mDay;
        private final int mHour;
        private final int mMinute;
        private final int mMonth;
        private final int mSecond;
        private final int mYear;

        private SavedState(Parcelable parcelable, int i, int i2, int i3, int i4, int i5, int i6) {
            super(parcelable);
            this.mYear = i;
            this.mMonth = i2;
            this.mDay = i3;
            this.mHour = i4;
            this.mMinute = i5;
            this.mSecond = i6;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mYear = parcel.readInt();
            this.mMonth = parcel.readInt();
            this.mDay = parcel.readInt();
            this.mHour = parcel.readInt();
            this.mMinute = parcel.readInt();
            this.mSecond = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mYear);
            parcel.writeInt(this.mMonth);
            parcel.writeInt(this.mDay);
            parcel.writeInt(this.mHour);
            parcel.writeInt(this.mMinute);
            parcel.writeInt(this.mSecond);
        }
    }
}
