package com.lany.picker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lany.picker.NumberPicker;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DatePicker extends FrameLayout {
    private static final String DATE_FORMAT = "MM/dd/yyyy";
    private static final boolean DEFAULT_DAY_VIEW_SHOWN = true;
    private static final boolean DEFAULT_ENABLED_STATE = true;
    private static final int DEFAULT_END_YEAR = 2100;
    private static final boolean DEFAULT_SPINNERS_SHOWN = true;
    private static final int DEFAULT_START_YEAR = 1900;
    private final String TAG;
    private Calendar mCurrentDate;
    private Locale mCurrentLocale;
    private final DateFormat mDateFormat;
    private NumberPicker mDaySpinner;
    private final EditText mDaySpinnerInput;
    private boolean mIsEnabled;
    private Calendar mMaxDate;
    private Calendar mMinDate;
    private NumberPicker mMonthSpinner;
    private final EditText mMonthSpinnerInput;
    private int mNumberOfMonths;
    private OnDateChangedListener mOnDateChangedListener;
    private String[] mShortMonths;
    private final LinearLayout mSpinners;
    private Calendar mTempDate;
    private NumberPicker mYearSpinner;
    private final EditText mYearSpinnerInput;

    public interface OnDateChangedListener {
        void onDateChanged(DatePicker datePicker, int i, int i2, int i3);
    }

    private void setContentDescriptions() {
    }

    public DatePicker(Context context) {
        this(context, null);
    }

    public DatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.datePickerStyle);
    }

    public DatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = getClass().getSimpleName();
        this.mDateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
        this.mIsEnabled = true;
        setCurrentLocale(Locale.getDefault());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DatePicker, i, 0);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.DatePicker_dp_spinnersShown, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.DatePicker_dp_dayViewShown, true);
        int i2 = obtainStyledAttributes.getInt(R.styleable.DatePicker_dp_startYear, 1900);
        int i3 = obtainStyledAttributes.getInt(R.styleable.DatePicker_dp_endYear, 2100);
        String string = obtainStyledAttributes.getString(R.styleable.DatePicker_dp_minDate);
        String string2 = obtainStyledAttributes.getString(R.styleable.DatePicker_dp_maxDate);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.DatePicker_dp_internalLayout, R.layout.picker_date);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(resourceId, this);
        AnonymousClass1 r12 = new NumberPicker.OnValueChangeListener() {
            /* class com.lany.picker.DatePicker.AnonymousClass1 */

            @Override // com.lany.picker.NumberPicker.OnValueChangeListener
            public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                DatePicker.this.updateInputState();
                DatePicker.this.mTempDate.setTimeInMillis(DatePicker.this.mCurrentDate.getTimeInMillis());
                if (numberPicker == DatePicker.this.mDaySpinner) {
                    int actualMaximum = DatePicker.this.mTempDate.getActualMaximum(5);
                    if (i == actualMaximum && i2 == 1) {
                        DatePicker.this.mTempDate.add(5, 1);
                    } else if (i == 1 && i2 == actualMaximum) {
                        DatePicker.this.mTempDate.add(5, -1);
                    } else {
                        DatePicker.this.mTempDate.add(5, i2 - i);
                    }
                } else if (numberPicker == DatePicker.this.mMonthSpinner) {
                    if (i == 11 && i2 == 0) {
                        DatePicker.this.mTempDate.add(2, 1);
                    } else if (i == 0 && i2 == 11) {
                        DatePicker.this.mTempDate.add(2, -1);
                    } else {
                        DatePicker.this.mTempDate.add(2, i2 - i);
                    }
                } else if (numberPicker == DatePicker.this.mYearSpinner) {
                    DatePicker.this.mTempDate.set(1, i2);
                } else {
                    throw new IllegalArgumentException();
                }
                DatePicker datePicker = DatePicker.this;
                datePicker.setDate(datePicker.mTempDate.get(1), DatePicker.this.mTempDate.get(2), DatePicker.this.mTempDate.get(5));
                DatePicker.this.updateSpinners();
                DatePicker.this.notifyDateChanged();
            }
        };
        this.mSpinners = (LinearLayout) findViewById(R.id.pickers);
        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.day);
        this.mDaySpinner = numberPicker;
        numberPicker.setFormatter(NumberPicker.getTwoDigitFormatter());
        this.mDaySpinner.setOnLongPressUpdateInterval(100);
        this.mDaySpinner.setOnValueChangedListener(r12);
        this.mDaySpinnerInput = (EditText) this.mDaySpinner.findViewById(R.id.np__numberpicker_input);
        if (z || z2) {
            setSpinnersShown(z);
            setDayViewShown(z2);
        } else {
            setSpinnersShown(true);
        }
        NumberPicker numberPicker2 = (NumberPicker) findViewById(R.id.month);
        this.mMonthSpinner = numberPicker2;
        numberPicker2.setMinValue(0);
        this.mMonthSpinner.setMaxValue(this.mNumberOfMonths - 1);
        this.mMonthSpinner.setDisplayedValues(this.mShortMonths);
        this.mMonthSpinner.setOnLongPressUpdateInterval(200);
        this.mMonthSpinner.setOnValueChangedListener(r12);
        this.mMonthSpinnerInput = (EditText) this.mMonthSpinner.findViewById(R.id.np__numberpicker_input);
        NumberPicker numberPicker3 = (NumberPicker) findViewById(R.id.year);
        this.mYearSpinner = numberPicker3;
        numberPicker3.setOnLongPressUpdateInterval(100);
        this.mYearSpinner.setOnValueChangedListener(r12);
        this.mYearSpinnerInput = (EditText) this.mYearSpinner.findViewById(R.id.np__numberpicker_input);
        if (!z) {
            setSpinnersShown(true);
        } else {
            setSpinnersShown(z);
        }
        this.mTempDate.clear();
        if (TextUtils.isEmpty(string)) {
            this.mTempDate.set(i2, 0, 1);
        } else if (!parseDate(string, this.mTempDate)) {
            this.mTempDate.set(i2, 0, 1);
        }
        setMinDate(this.mTempDate.getTimeInMillis());
        this.mTempDate.clear();
        if (TextUtils.isEmpty(string2)) {
            this.mTempDate.set(i3, 11, 31);
        } else if (!parseDate(string2, this.mTempDate)) {
            this.mTempDate.set(i3, 11, 31);
        }
        setMaxDate(this.mTempDate.getTimeInMillis());
        this.mCurrentDate.setTimeInMillis(System.currentTimeMillis());
        init(this.mCurrentDate.get(1), this.mCurrentDate.get(2), this.mCurrentDate.get(5));
        reorderSpinners();
        setContentDescriptions();
        if (Build.VERSION.SDK_INT >= 16 && getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public void setSelectionDivider(Drawable drawable) {
        this.mDaySpinner.setSelectionDivider(drawable);
        this.mMonthSpinner.setSelectionDivider(drawable);
        this.mYearSpinner.setSelectionDivider(drawable);
    }

    public void setSelectionDividerHeight(int i) {
        this.mDaySpinner.setSelectionDividerHeight(i);
        this.mMonthSpinner.setSelectionDividerHeight(i);
        this.mYearSpinner.setSelectionDividerHeight(i);
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
            this.mDaySpinner.setEnabled(z);
            this.mMonthSpinner.setEnabled(z);
            this.mYearSpinner.setEnabled(z);
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
        accessibilityEvent.setClassName(DatePicker.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(DatePicker.class.getName());
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setCurrentLocale(configuration.locale);
    }

    public void setDayViewShown(boolean z) {
        this.mDaySpinner.setVisibility(z ? 0 : 8);
    }

    public boolean getSpinnersShown() {
        return this.mSpinners.isShown();
    }

    public void setSpinnersShown(boolean z) {
        this.mSpinners.setVisibility(z ? 0 : 8);
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
        this.mSpinners.removeAllViews();
        char[] dateFormatOrder = android.text.format.DateFormat.getDateFormatOrder(getContext());
        int length = dateFormatOrder.length;
        for (int i = 0; i < length; i++) {
            char c = dateFormatOrder[i];
            if (c == 'M') {
                this.mSpinners.addView(this.mMonthSpinner);
                setImeOptions(this.mMonthSpinner, length, i);
            } else if (c == 'd') {
                this.mSpinners.addView(this.mDaySpinner);
                setImeOptions(this.mDaySpinner, length, i);
            } else if (c == 'y') {
                this.mSpinners.addView(this.mYearSpinner);
                setImeOptions(this.mYearSpinner, length, i);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public void updateDate(int i, int i2, int i3) {
        if (isNewDate(i, i2, i3)) {
            setDate(i, i2, i3);
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
        return new SavedState(super.onSaveInstanceState(), getYear(), getMonth(), getDayOfMonth());
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setDate(savedState.mYear, savedState.mMonth, savedState.mDay);
        updateSpinners();
    }

    public void init(int i, int i2, int i3) {
        setDate(i, i2, i3);
        updateSpinners();
    }

    private boolean parseDate(String str, Calendar calendar) {
        try {
            calendar.setTime(this.mDateFormat.parse(str));
            return true;
        } catch (ParseException unused) {
            String str2 = this.TAG;
            Log.w(str2, "Date: " + str + " not in format: MM/dd/yyyy");
            return false;
        }
    }

    private boolean isNewDate(int i, int i2, int i3) {
        if (this.mCurrentDate.get(1) == i && this.mCurrentDate.get(2) == i3 && this.mCurrentDate.get(5) == i2) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void setDate(int i, int i2, int i3) {
        this.mCurrentDate.set(i, i2, i3);
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
        this.mYearSpinner.setValue(this.mCurrentDate.get(1));
        this.mMonthSpinner.setValue(this.mCurrentDate.get(2));
        this.mDaySpinner.setValue(this.mCurrentDate.get(5));
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

    /* access modifiers changed from: private */
    public void notifyDateChanged() {
        sendAccessibilityEvent(4);
        OnDateChangedListener onDateChangedListener = this.mOnDateChangedListener;
        if (onDateChangedListener != null) {
            onDateChangedListener.onDateChanged(this, getYear(), getMonth(), getDayOfMonth());
        }
    }

    private void setImeOptions(NumberPicker numberPicker, int i, int i2) {
        ((TextView) numberPicker.findViewById(R.id.np__numberpicker_input)).setImeOptions(i2 < i + -1 ? 5 : 6);
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
        if (inputMethodManager.isActive(this.mYearSpinnerInput)) {
            this.mYearSpinnerInput.clearFocus();
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        } else if (inputMethodManager.isActive(this.mMonthSpinnerInput)) {
            this.mMonthSpinnerInput.clearFocus();
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        } else if (inputMethodManager.isActive(this.mDaySpinnerInput)) {
            this.mDaySpinnerInput.clearFocus();
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    public void setOnDateChangedListener(OnDateChangedListener onDateChangedListener) {
        this.mOnDateChangedListener = onDateChangedListener;
    }

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.lany.picker.DatePicker.SavedState.AnonymousClass1 */

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
        private final int mMonth;
        private final int mYear;

        private SavedState(Parcelable parcelable, int i, int i2, int i3) {
            super(parcelable);
            this.mYear = i;
            this.mMonth = i2;
            this.mDay = i3;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mYear = parcel.readInt();
            this.mMonth = parcel.readInt();
            this.mDay = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mYear);
            parcel.writeInt(this.mMonth);
            parcel.writeInt(this.mDay);
        }
    }
}
