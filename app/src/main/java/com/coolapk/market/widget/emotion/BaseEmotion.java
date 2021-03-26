package com.coolapk.market.widget.emotion;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseEmotion {
    public static final String COOLAPK_EMOTION = "COOLAPK";
    public static final String COOLB_EMOTION = "COOLB";
    private static final int DEFAULT_SIZE = 20;
    public static final String DOG_EMOTION = "DOG";
    public static final String DRAWABLE_EMOTION = "DRAWABLE";
    public static final String EMOJI_EMOTION = "EMOJI";
    public static final String EMPTY_EMOTION = "EMPTY";
    public static final String QQ_EMOTION = "QQ";
    public static final String TIEBA_EMOTION = "TIEBA";
    private String md5;
    private final Integer resId;
    private final String text;

    public abstract String getEntityType();

    public abstract String getRealText();

    public int getTransitionY() {
        return 0;
    }

    public BaseEmotion(Integer num, String str) {
        this.resId = num;
        this.text = str;
    }

    public boolean hasDrawable() {
        return this.resId != null;
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String getText() {
        return this.text;
    }

    public Drawable getDrawable(Context context, int i) {
        if (!hasDrawable()) {
            return null;
        }
        int dp2px = DisplayUtils.dp2px(context, (float) i);
        Drawable drawable = ResourceUtils.getDrawable(context, this.resId.intValue());
        drawable.setBounds(0, 0, dp2px, dp2px);
        return drawable;
    }

    public Drawable getDrawable(Context context) {
        return getDrawable(context, 20);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("resId", this.resId);
        jSONObject.put("text", this.text);
        jSONObject.put("entityType", getEntityType());
        return jSONObject;
    }

    public String buildUrl(Context context) {
        return "file:///android_res/drawable/" + context.getResources().getResourceEntryName(this.resId.intValue());
    }

    public String getMd5() {
        if (this.md5 == null) {
            this.md5 = StringUtils.toMd5(getRealText());
        }
        return this.md5;
    }

    public String getHtmlGroup() {
        return EmotionUtils.emotionTypeToHtmlGroup(getEntityType());
    }

    public String toString() {
        return "BaseEmotion{description='" + this.text + "', resId=" + this.resId + '}';
    }
}
