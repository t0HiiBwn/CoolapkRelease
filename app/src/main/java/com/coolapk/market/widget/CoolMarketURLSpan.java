package com.coolapk.market.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import com.coolapk.market.manager.ActionManagerCompat;
import rx.functions.Action2;

public class CoolMarketURLSpan extends URLSpan {
    public static final Parcelable.Creator<CoolMarketURLSpan> CREATOR = new Parcelable.Creator<CoolMarketURLSpan>() {
        /* class com.coolapk.market.widget.CoolMarketURLSpan.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public CoolMarketURLSpan createFromParcel(Parcel parcel) {
            return new CoolMarketURLSpan(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public CoolMarketURLSpan[] newArray(int i) {
            return new CoolMarketURLSpan[i];
        }
    };
    private Action2<String, View> mExtraListener;
    private final int mLinkColor;
    private final boolean mUnderlineTextEnabled;

    @Override // android.text.style.URLSpan, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CoolMarketURLSpan(URLSpan uRLSpan) {
        this(uRLSpan.getURL(), 0, false);
    }

    public CoolMarketURLSpan(CoolMarketURLSpan coolMarketURLSpan) {
        this(coolMarketURLSpan.getURL(), coolMarketURLSpan.mLinkColor, coolMarketURLSpan.mUnderlineTextEnabled);
        this.mExtraListener = coolMarketURLSpan.mExtraListener;
    }

    public CoolMarketURLSpan(String str) {
        this(str, 0, false);
    }

    public CoolMarketURLSpan(String str, int i) {
        this(str, i, false);
    }

    public CoolMarketURLSpan(String str, boolean z) {
        this(str, 0, z);
    }

    public int getLinkColor() {
        return this.mLinkColor;
    }

    public CoolMarketURLSpan(String str, int i, boolean z) {
        super(str);
        this.mLinkColor = i;
        this.mUnderlineTextEnabled = z;
    }

    public void setExtraListener(Action2<String, View> action2) {
        this.mExtraListener = action2;
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View view) {
        Context context = view.getContext();
        Action2<String, View> action2 = this.mExtraListener;
        if (action2 != null) {
            action2.call(getURL(), view);
        } else {
            ActionManagerCompat.startActivityByUrl(context, getURL(), null, null);
        }
    }

    @Override // android.text.style.CharacterStyle, android.text.style.ClickableSpan
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        int i = this.mLinkColor;
        if (i != 0) {
            textPaint.setColor(i);
        }
        textPaint.setUnderlineText(this.mUnderlineTextEnabled);
    }

    @Override // android.text.style.URLSpan, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mLinkColor);
        parcel.writeByte(this.mUnderlineTextEnabled ? (byte) 1 : 0);
    }

    protected CoolMarketURLSpan(Parcel parcel) {
        super(parcel);
        this.mLinkColor = parcel.readInt();
        this.mUnderlineTextEnabled = parcel.readByte() != 0;
    }
}
