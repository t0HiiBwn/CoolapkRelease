package com.ali.auth.third.core.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SNSSignInAccount implements Parcelable {
    public static final Parcelable.Creator<SNSSignInAccount> CREATOR = new Parcelable.Creator<SNSSignInAccount>() {
        /* class com.ali.auth.third.core.model.SNSSignInAccount.AnonymousClass1 */

        /* renamed from: a */
        public SNSSignInAccount createFromParcel(Parcel parcel) {
            return new SNSSignInAccount(parcel);
        }

        /* renamed from: a */
        public SNSSignInAccount[] newArray(int i) {
            return new SNSSignInAccount[i];
        }
    };
    public String app_id;
    public String company;
    public String countryAbbr;
    public String countryFullName;
    public String email;
    public String firstName;
    public String lastName;
    public boolean neetBindExpressOpenId;
    public int site;
    public String snsType;
    public String token;
    public String trustOpenId;
    public String userId;

    public SNSSignInAccount() {
    }

    protected SNSSignInAccount(Parcel parcel) {
        this.snsType = parcel.readString();
        this.userId = parcel.readString();
        this.token = parcel.readString();
        this.email = parcel.readString();
        this.firstName = parcel.readString();
        this.lastName = parcel.readString();
        this.company = parcel.readString();
        this.countryFullName = parcel.readString();
        this.countryAbbr = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        return "SNSSignInAccount{snsType='" + this.snsType + "', userId='" + this.userId + "', token='" + this.token + "', email='" + this.email + "', firstName='" + this.firstName + "', lastName='" + this.lastName + "', company='" + this.company + "', countryFullName='" + this.countryFullName + "', countryAbbr='" + this.countryAbbr + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.snsType);
        parcel.writeString(this.userId);
        parcel.writeString(this.token);
        parcel.writeString(this.email);
        parcel.writeString(this.firstName);
        parcel.writeString(this.lastName);
        parcel.writeString(this.company);
        parcel.writeString(this.countryFullName);
        parcel.writeString(this.countryAbbr);
    }
}
