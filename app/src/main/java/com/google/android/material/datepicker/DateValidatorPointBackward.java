package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.Arrays;

public class DateValidatorPointBackward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointBackward> CREATOR = new Parcelable.Creator<DateValidatorPointBackward>() {
        /* class com.google.android.material.datepicker.DateValidatorPointBackward.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public DateValidatorPointBackward createFromParcel(Parcel parcel) {
            return new DateValidatorPointBackward(parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public DateValidatorPointBackward[] newArray(int i) {
            return new DateValidatorPointBackward[i];
        }
    };
    private final long point;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private DateValidatorPointBackward(long j) {
        this.point = j;
    }

    public static DateValidatorPointBackward before(long j) {
        return new DateValidatorPointBackward(j);
    }

    public static DateValidatorPointBackward now() {
        return before(UtcDates.getTodayCalendar().getTimeInMillis());
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean isValid(long j) {
        return j <= this.point;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.point);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof DateValidatorPointBackward) && this.point == ((DateValidatorPointBackward) obj).point) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.point)});
    }
}
