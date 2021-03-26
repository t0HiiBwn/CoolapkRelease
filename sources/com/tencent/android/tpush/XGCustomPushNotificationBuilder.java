package com.tencent.android.tpush;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Pair;
import android.widget.RemoteViews;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class XGCustomPushNotificationBuilder extends XGPushNotificationBuilder {
    private Integer B = null;
    private Integer C = null;
    private Integer D = null;
    private Integer E = null;
    private Integer F = null;
    private Integer G = null;
    private Integer H = null;
    private Bitmap I = null;

    @Override // com.tencent.android.tpush.XGPushNotificationBuilder
    public String getType() {
        return "custom";
    }

    @Override // com.tencent.android.tpush.XGPushNotificationBuilder
    protected void a(JSONObject jSONObject) {
        CommonHelper.jsonPut(jSONObject, "layoutId", this.B);
        CommonHelper.jsonPut(jSONObject, "layoutIconId", this.C);
        CommonHelper.jsonPut(jSONObject, "layoutTitleId", this.D);
        CommonHelper.jsonPut(jSONObject, "layoutTextId", this.E);
        CommonHelper.jsonPut(jSONObject, "layoutIconDrawableId", this.F);
        CommonHelper.jsonPut(jSONObject, "statusBarIconDrawableId", this.G);
        CommonHelper.jsonPut(jSONObject, "layoutTimeId", this.H);
    }

    @Override // com.tencent.android.tpush.XGPushNotificationBuilder
    protected void b(JSONObject jSONObject) {
        this.B = (Integer) CommonHelper.jsonGet(jSONObject, "layoutId", null);
        this.C = (Integer) CommonHelper.jsonGet(jSONObject, "layoutIconId", null);
        this.D = (Integer) CommonHelper.jsonGet(jSONObject, "layoutTitleId", null);
        this.E = (Integer) CommonHelper.jsonGet(jSONObject, "layoutTextId", null);
        this.F = (Integer) CommonHelper.jsonGet(jSONObject, "layoutIconDrawableId", null);
        this.G = (Integer) CommonHelper.jsonGet(jSONObject, "statusBarIconDrawableId", null);
        this.H = (Integer) CommonHelper.jsonGet(jSONObject, "layoutTimeId", null);
    }

    @Override // com.tencent.android.tpush.XGPushNotificationBuilder
    public Pair<Notification, Object> buildNotification(Context context) {
        if (this.B == null) {
            return a(context);
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), this.B.intValue());
        Integer num = this.D;
        if (num != null) {
            remoteViews.setTextViewText(num.intValue(), getTitle(context));
        }
        Integer num2 = this.E;
        if (num2 != null) {
            remoteViews.setTextViewText(num2.intValue(), this.q);
        }
        Integer num3 = this.C;
        if (num3 != null) {
            remoteViews.setImageViewResource(num3.intValue(), this.F.intValue());
            if (this.I != null) {
                remoteViews.setImageViewBitmap(this.C.intValue(), this.I);
            }
        }
        Integer num4 = this.G;
        if (num4 != null) {
            remoteViews.setTextViewText(num4.intValue(), getTitle(context));
        }
        if (this.H != null) {
            remoteViews.setTextViewText(this.H.intValue(), String.valueOf(new SimpleDateFormat("HH:mm").format(new Date(System.currentTimeMillis()))));
        }
        this.e = remoteViews;
        return a(context);
    }

    public int getLayoutId() {
        return this.B.intValue();
    }

    public XGCustomPushNotificationBuilder setLayoutId(int i) {
        this.B = Integer.valueOf(i);
        return this;
    }

    public Integer getLayoutIconId() {
        return this.C;
    }

    public XGCustomPushNotificationBuilder setLayoutIconId(int i) {
        this.C = Integer.valueOf(i);
        return this;
    }

    public int getLayoutTitleId() {
        return this.D.intValue();
    }

    public XGCustomPushNotificationBuilder setLayoutTitleId(int i) {
        this.D = Integer.valueOf(i);
        return this;
    }

    public int getLayoutTextId() {
        return this.E.intValue();
    }

    public int getLayoutTimeId() {
        return this.H.intValue();
    }

    public XGCustomPushNotificationBuilder setLayoutTextId(int i) {
        this.E = Integer.valueOf(i);
        return this;
    }

    public XGCustomPushNotificationBuilder setLayoutTimeId(int i) {
        this.H = Integer.valueOf(i);
        return this;
    }

    public int getLayoutIconDrawableId() {
        return this.F.intValue();
    }

    public XGCustomPushNotificationBuilder setLayoutIconDrawableId(int i) {
        this.F = Integer.valueOf(i);
        return this;
    }

    public XGCustomPushNotificationBuilder setLayoutIconDrawableBmp(Bitmap bitmap) {
        this.I = bitmap;
        return this;
    }
}
