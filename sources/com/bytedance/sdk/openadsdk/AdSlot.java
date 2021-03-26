package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.i.g.b;
import com.bytedance.sdk.openadsdk.utils.u;
import org.json.JSONObject;

public class AdSlot {
    public static final int TYPE_BANNER = 1;
    public static final int TYPE_CACHED_SPLASH = 4;
    public static final int TYPE_DRAW_FEED = 9;
    public static final int TYPE_FEED = 5;
    public static final int TYPE_FULL_SCREEN_VIDEO = 8;
    public static final int TYPE_INTERACTION_AD = 2;
    public static final int TYPE_REWARD_VIDEO = 7;
    public static final int TYPE_SPLASH = 3;
    public static final int TYPE_STREAM = 6;
    private String a;
    private int b;
    private int c;
    private float d;
    private float e;
    private int f;
    private boolean g;
    private boolean h;
    private String i;
    private int j;
    private String k;
    private String l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private int[] q;
    private String r;
    private int s;
    private String t;
    private String u;
    private String v;
    private String w;

    public static int getPosition(int i2) {
        if (i2 == 1) {
            return 2;
        }
        if (i2 != 2) {
            return (i2 == 3 || i2 == 4 || i2 == 7 || i2 == 8) ? 5 : 3;
        }
        return 4;
    }

    private AdSlot() {
        this.m = 2;
        this.p = true;
    }

    public String getAdId() {
        return this.v;
    }

    public String getCreativeId() {
        return this.w;
    }

    public String getCodeId() {
        return this.a;
    }

    public boolean isAutoPlay() {
        return this.p;
    }

    public int getImgAcceptedWidth() {
        return this.b;
    }

    public int getImgAcceptedHeight() {
        return this.c;
    }

    public float getExpressViewAcceptedWidth() {
        return this.d;
    }

    public float getExpressViewAcceptedHeight() {
        return this.e;
    }

    public boolean isSupportDeepLink() {
        return this.g;
    }

    public boolean isSupportRenderConrol() {
        return this.h;
    }

    public int getAdCount() {
        return this.f;
    }

    public void setAdCount(int i2) {
        this.f = i2;
    }

    public String getRewardName() {
        return this.i;
    }

    public int getRewardAmount() {
        return this.j;
    }

    public String getMediaExtra() {
        return this.k;
    }

    public String getUserID() {
        return this.l;
    }

    public int getOrientation() {
        return this.m;
    }

    public int getNativeAdType() {
        return this.o;
    }

    public void setNativeAdType(int i2) {
        this.o = i2;
    }

    public int[] getExternalABVid() {
        return this.q;
    }

    public void setExternalABVid(int... iArr) {
        this.q = iArr;
    }

    public int getAdloadSeq() {
        return this.s;
    }

    public String getPrimeRit() {
        String str = this.t;
        return str == null ? "" : str;
    }

    public int getAdType() {
        return this.n;
    }

    public String getBidAdm() {
        return this.u;
    }

    public String getExtraSmartLookParam() {
        return this.r;
    }

    public String toString() {
        return "AdSlot{mCodeId='" + this.a + "', mImgAcceptedWidth=" + this.b + ", mImgAcceptedHeight=" + this.c + ", mExpressViewAcceptedWidth=" + this.d + ", mExpressViewAcceptedHeight=" + this.e + ", mAdCount=" + this.f + ", mSupportDeepLink=" + this.g + ", mSupportRenderControl=" + this.h + ", mRewardName='" + this.i + "', mRewardAmount=" + this.j + ", mMediaExtra='" + this.k + "', mUserID='" + this.l + "', mOrientation=" + this.m + ", mNativeAdType=" + this.o + ", mIsAutoPlay=" + this.p + ", mPrimeRit" + this.t + ", mAdloadSeq" + this.s + ", mAdId" + this.v + ", mCreativeId" + this.w + '}';
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.a);
            jSONObject.put("mIsAutoPlay", this.p);
            jSONObject.put("mImgAcceptedWidth", this.b);
            jSONObject.put("mImgAcceptedHeight", this.c);
            jSONObject.put("mExpressViewAcceptedWidth", (double) this.d);
            jSONObject.put("mExpressViewAcceptedHeight", (double) this.e);
            jSONObject.put("mAdCount", this.f);
            jSONObject.put("mSupportDeepLink", this.g);
            jSONObject.put("mSupportRenderControl", this.h);
            jSONObject.put("mRewardName", this.i);
            jSONObject.put("mRewardAmount", this.j);
            jSONObject.put("mMediaExtra", this.k);
            jSONObject.put("mUserID", this.l);
            jSONObject.put("mOrientation", this.m);
            jSONObject.put("mNativeAdType", this.o);
            jSONObject.put("mAdloadSeq", this.s);
            jSONObject.put("mPrimeRit", this.t);
            jSONObject.put("mExtraSmartLookParam", this.r);
            jSONObject.put("mAdId", this.v);
            jSONObject.put("mCreativeId", this.w);
            jSONObject.put("mBidAdm", this.u);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static class Builder {
        private String a;
        private int b = 640;
        private int c = 320;
        private boolean d = true;
        private boolean e = false;
        private int f = 1;
        private String g = "";
        private int h = 0;
        private String i;
        private String j = "defaultUser";
        private int k = 2;
        private int l;
        private String m;
        private int n;
        private float o;
        private float p;
        private boolean q = true;
        private int[] r;
        private int s;
        private String t;
        private String u;
        private String v;
        private String w;

        public Builder setRewardAmount(int i2) {
            return this;
        }

        public Builder setRewardName(String str) {
            return this;
        }

        public Builder setSupportDeepLink(boolean z) {
            return this;
        }

        public Builder setExtraParam(String str) {
            this.m = str;
            return this;
        }

        public Builder setAdType(int i2) {
            this.n = i2;
            return this;
        }

        public Builder setAdId(String str) {
            this.v = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.w = str;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.q = z;
            return this;
        }

        public Builder setCodeId(String str) {
            this.a = str;
            return this;
        }

        public Builder setImageAcceptedSize(int i2, int i3) {
            this.b = i2;
            this.c = i3;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f2, float f3) {
            this.o = f2;
            this.p = f3;
            return this;
        }

        public Builder supportRenderControl() {
            this.e = true;
            return this;
        }

        public Builder setAdCount(int i2) {
            if (i2 <= 0) {
                i2 = 1;
                u.c("TT_AD_SDK", "setAdCount: adCount must greater than 0 ");
            }
            if (i2 > 20) {
                u.c("TT_AD_SDK", "setAdCount: adCount must less than or equal to 20 ");
                i2 = 20;
            }
            this.f = i2;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.i = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.j = str;
            return this;
        }

        public Builder setOrientation(int i2) {
            this.k = i2;
            return this;
        }

        public Builder setNativeAdType(int i2) {
            this.l = i2;
            return this;
        }

        public Builder setAdloadSeq(int i2) {
            this.s = i2;
            return this;
        }

        public Builder setPrimeRit(String str) {
            this.t = str;
            return this;
        }

        public Builder setExternalABVid(int... iArr) {
            this.r = iArr;
            return this;
        }

        public Builder withBid(String str) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            u.c("bidding", "AdSlot -> bidAdm=" + b.a(str));
            this.u = str;
            return this;
        }

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.a = this.a;
            adSlot.f = this.f;
            adSlot.g = this.d;
            adSlot.h = this.e;
            adSlot.b = this.b;
            adSlot.c = this.c;
            float f2 = this.o;
            if (f2 <= 0.0f) {
                adSlot.d = (float) this.b;
                adSlot.e = (float) this.c;
            } else {
                adSlot.d = f2;
                adSlot.e = this.p;
            }
            adSlot.i = this.g;
            adSlot.j = this.h;
            adSlot.k = this.i;
            adSlot.l = this.j;
            adSlot.m = this.k;
            adSlot.o = this.l;
            adSlot.p = this.q;
            adSlot.q = this.r;
            adSlot.s = this.s;
            adSlot.t = this.t;
            adSlot.r = this.m;
            adSlot.v = this.v;
            adSlot.w = this.w;
            adSlot.n = this.n;
            adSlot.u = this.u;
            return adSlot;
        }
    }
}
