package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.R;

class MonthAdapter extends BaseAdapter {
    static final int MAXIMUM_WEEKS = UtcDates.getUtcCalendar().getMaximum(4);
    final CalendarConstraints calendarConstraints;
    CalendarStyle calendarStyle;
    final DateSelector<?> dateSelector;
    final Month month;

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    MonthAdapter(Month month2, DateSelector<?> dateSelector2, CalendarConstraints calendarConstraints2) {
        this.month = month2;
        this.dateSelector = dateSelector2;
        this.calendarConstraints = calendarConstraints2;
    }

    @Override // android.widget.Adapter
    public Long getItem(int i) {
        if (i < this.month.daysFromStartOfWeekToFirstOfMonth() || i > lastPositionInMonth()) {
            return null;
        }
        return Long.valueOf(this.month.getDay(positionToDay(i)));
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return (long) (i / this.month.daysInWeek);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.month.daysInMonth + firstPositionInMonth();
    }

    @Override // android.widget.Adapter
    public TextView getView(int i, View view, ViewGroup viewGroup) {
        initializeStyles(viewGroup.getContext());
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day, viewGroup, false);
        }
        int firstPositionInMonth = i - firstPositionInMonth();
        if (firstPositionInMonth < 0 || firstPositionInMonth >= this.month.daysInMonth) {
            textView.setVisibility(8);
            textView.setEnabled(false);
        } else {
            int i2 = firstPositionInMonth + 1;
            textView.setTag(this.month);
            textView.setText(String.valueOf(i2));
            long day = this.month.getDay(i2);
            if (this.month.year == Month.current().year) {
                textView.setContentDescription(DateStrings.getMonthDayOfWeekDay(day));
            } else {
                textView.setContentDescription(DateStrings.getYearMonthDayOfWeekDay(day));
            }
            textView.setVisibility(0);
            textView.setEnabled(true);
        }
        Long item = getItem(i);
        if (item == null) {
            return textView;
        }
        if (this.calendarConstraints.getDateValidator().isValid(item.longValue())) {
            textView.setEnabled(true);
            for (Long l2 : this.dateSelector.getSelectedDays()) {
                if (UtcDates.canonicalYearMonthDay(item.longValue()) == UtcDates.canonicalYearMonthDay(l2.longValue())) {
                    this.calendarStyle.selectedDay.styleItem(textView);
                    return textView;
                }
            }
            if (UtcDates.getTodayCalendar().getTimeInMillis() == item.longValue()) {
                this.calendarStyle.todayDay.styleItem(textView);
                return textView;
            }
            this.calendarStyle.day.styleItem(textView);
            return textView;
        }
        textView.setEnabled(false);
        this.calendarStyle.invalidDay.styleItem(textView);
        return textView;
    }

    private void initializeStyles(Context context) {
        if (this.calendarStyle == null) {
            this.calendarStyle = new CalendarStyle(context);
        }
    }

    int firstPositionInMonth() {
        return this.month.daysFromStartOfWeekToFirstOfMonth();
    }

    int lastPositionInMonth() {
        return (this.month.daysFromStartOfWeekToFirstOfMonth() + this.month.daysInMonth) - 1;
    }

    int positionToDay(int i) {
        return (i - this.month.daysFromStartOfWeekToFirstOfMonth()) + 1;
    }

    int dayToPosition(int i) {
        return firstPositionInMonth() + (i - 1);
    }

    boolean withinMonth(int i) {
        return i >= firstPositionInMonth() && i <= lastPositionInMonth();
    }

    boolean isFirstInRow(int i) {
        return i % this.month.daysInWeek == 0;
    }

    boolean isLastInRow(int i) {
        return (i + 1) % this.month.daysInWeek == 0;
    }
}
