package com.coolapk.market.view.settings.settingsynch;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import com.coolapk.market.AppHolder;
import com.coolapk.market.event.PostButtonEvent;
import com.coolapk.market.util.BitmapUtil;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import org.greenrobot.eventbus.EventBus;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lokhttp3/ResponseBody;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: SettingSynchronized.kt */
final class SettingSynchronized$reloadSettingConfig$1<T> implements Action1<ResponseBody> {
    public static final SettingSynchronized$reloadSettingConfig$1 INSTANCE = new SettingSynchronized$reloadSettingConfig$1();

    SettingSynchronized$reloadSettingConfig$1() {
    }

    public final void call(ResponseBody responseBody) {
        JsonObject asJsonObject;
        JsonElement parseString = JsonParser.parseString(responseBody.string());
        Intrinsics.checkNotNullExpressionValue(parseString, "JsonParser.parseString(it.string())");
        JsonObject asJsonObject2 = parseString.getAsJsonObject();
        if (asJsonObject2.has("data")) {
            JsonElement jsonElement = asJsonObject2.get("data");
            Intrinsics.checkNotNullExpressionValue(jsonElement, "jsonObject.get(\"data\")");
            if (jsonElement.isJsonObject()) {
                JsonElement jsonElement2 = asJsonObject2.get("data");
                String str = null;
                JsonElement jsonElement3 = (jsonElement2 == null || (asJsonObject = jsonElement2.getAsJsonObject()) == null) ? null : asJsonObject.get("publish_button_picture");
                if (jsonElement3 != null) {
                    str = jsonElement3.getAsString();
                }
                if (!TextUtils.isEmpty(str)) {
                    byte[] decode = Base64.decode(str, 0);
                    Intrinsics.checkNotNullExpressionValue(decode, "Base64.decode(json, Base64.DEFAULT)");
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                    if (decodeByteArray != null) {
                        BitmapUtil.saveBitmapToFile(new File(BitmapUtil.generateFileOutputPath(AppHolder.getApplication(), "post_button_custom")), decodeByteArray, true);
                        EventBus.getDefault().post(new PostButtonEvent());
                    }
                }
            }
        }
    }
}
