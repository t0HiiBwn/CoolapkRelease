package com.coolapk.market.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bumptech.glide.load.model.LazyHeaders;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.local.DataConfig;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.network.HttpClientFactory;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.hotplug.ViewPartPool;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: KotlinExtend.kt */
public final class KotlinExtendKt {
    private static final NumberFormat NUMBER_FORMATTER = NumberFormat.getInstance();

    public static final float constrain(float f, float f2, float f3) {
        return f > f2 ? f2 : f < f3 ? f3 : f;
    }

    public static final int constrain(int i, int i2, int i3) {
        return i > i2 ? i2 : i < i3 ? i3 : i;
    }

    public static final String notNull(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "def");
        return str != null ? str : str2;
    }

    public static final <T> T takeIfP(T t, boolean z) {
        if (z) {
            return t;
        }
        return null;
    }

    public static final /* synthetic */ <T> T valueTo(boolean z, T t, T t2) {
        return z ? t : t2;
    }

    public static final /* synthetic */ <T> T elvis(T t, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "def");
        return t != null ? t : (T) function0.invoke();
    }

    public static final String lineBreakerToSpace(String str) {
        Intrinsics.checkNotNullParameter(str, "$this$lineBreakerToSpace");
        return new Regex("[\\n\\r]").replace(str, " ");
    }

    public static /* synthetic */ String notNull$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "";
        }
        Intrinsics.checkNotNullParameter(str2, "def");
        return str != null ? str : str2;
    }

    public static final boolean whenTrue(boolean z, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "action");
        if (z) {
            function0.invoke();
        }
        return z;
    }

    public static final boolean whenFalse(boolean z, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "action");
        if (!z) {
            function0.invoke();
        }
        return z;
    }

    public static final /* synthetic */ <T> T valueTo(boolean z, Function0<? extends T> function0, Function0<? extends T> function02) {
        Intrinsics.checkNotNullParameter(function0, "whenTrue");
        Intrinsics.checkNotNullParameter(function02, "whenFalse");
        return z ? (T) function0.invoke() : (T) function02.invoke();
    }

    public static final /* synthetic */ <T> T valueTo(boolean z, Function0<? extends T> function0, T t) {
        Intrinsics.checkNotNullParameter(function0, "whenTrue");
        return z ? (T) function0.invoke() : t;
    }

    public static final /* synthetic */ <T> T valueTo(boolean z, T t, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "whenFalse");
        return z ? t : (T) function0.invoke();
    }

    public static /* synthetic */ int constrain$default(int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        if ((i4 & 2) != 0) {
            i3 = Integer.MIN_VALUE;
        }
        return constrain(i, i2, i3);
    }

    public static /* synthetic */ float constrain$default(float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = Float.MAX_VALUE;
        }
        if ((i & 2) != 0) {
            f3 = Float.MIN_VALUE;
        }
        return constrain(f, f2, f3);
    }

    public static final <T> T requireNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final Pair<Integer, Integer> getBitmapSize(Uri uri, Context context) {
        Intrinsics.checkNotNullParameter(uri, "$this$getBitmapSize");
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        try {
            Intrinsics.checkNotNullExpressionValue(applicationContext, "appContext");
            InputStream openInputStream = applicationContext.getContentResolver().openInputStream(uri);
            BitmapFactory.Options options = new BitmapFactory.Options();
            boolean z = true;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(openInputStream, null, options);
            boolean z2 = false;
            try {
                String path = uri.getPath();
                Intrinsics.checkNotNull(path);
                int attributeInt = new ExifInterface(path).getAttributeInt("Orientation", 1);
                if (attributeInt == 3 || !(attributeInt == 6 || attributeInt == 8)) {
                    z = false;
                }
                z2 = z;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return new Pair<>(Integer.valueOf(z2 ? options.outHeight : options.outWidth), Integer.valueOf(z2 ? options.outWidth : options.outHeight));
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return new Pair<>(1024, 1024);
        }
    }

    public static final float getPicRatio(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "$this$getPicRatio");
        String label = feed.getLabel();
        if (label == null || label.length() == 0) {
            return 1.0f;
        }
        try {
            String label2 = feed.getLabel();
            List split$default = label2 != null ? StringsKt.split$default((CharSequence) label2, new String[]{"x"}, false, 0, 6, (Object) null) : null;
            if (split$default != null) {
                return Float.parseFloat((String) split$default.get(0)) / Float.parseFloat((String) split$default.get(1));
            }
            return 1.0f;
        } catch (Exception unused) {
            return 1.0f;
        }
    }

    public static final Activity findActivity(Context context) {
        Intrinsics.checkNotNullParameter(context, "$this$findActivity");
        return UiUtils.getActivityNullable(context);
    }

    public static final /* synthetic */ <T extends Fragment> T inFragment(BindingViewHolder bindingViewHolder) {
        Intrinsics.checkNotNullParameter(bindingViewHolder, "$this$inFragment");
        DataBindingComponent component = bindingViewHolder.getComponent();
        Fragment fragment = null;
        if (!(component instanceof FragmentBindingComponent)) {
            component = null;
        }
        FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
        if (fragmentBindingComponent != null) {
            fragment = (Fragment) fragmentBindingComponent.getContainer();
        }
        Intrinsics.reifiedOperationMarker(2, "T");
        return (T) fragment;
    }

    public static final /* synthetic */ <T extends Activity> T inActivity(BindingViewHolder bindingViewHolder) {
        Intrinsics.checkNotNullParameter(bindingViewHolder, "$this$inActivity");
        DataBindingComponent component = bindingViewHolder.getComponent();
        Context context = null;
        if (!(component instanceof ContextBindingComponent)) {
            component = null;
        }
        ContextBindingComponent contextBindingComponent = (ContextBindingComponent) component;
        if (contextBindingComponent != null) {
            context = (Context) contextBindingComponent.getContainer();
        }
        Intrinsics.reifiedOperationMarker(2, "T");
        return (T) ((Activity) context);
    }

    public static final void drawRect(Canvas canvas, int i, int i2, int i3, int i4, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "$this$drawRect");
        Intrinsics.checkNotNullParameter(paint, "paint");
        canvas.drawRect((float) i, (float) i2, (float) i3, (float) i4, paint);
    }

    public static final String getSimpleHost(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "$this$simpleHost");
        String host = uri.getHost();
        if (host == null) {
            return null;
        }
        return new Regex("^www\\.").replace(host, "");
    }

    public static final Uri asUri(String str) {
        Intrinsics.checkNotNullParameter(str, "$this$asUri");
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(this)");
        return parse;
    }

    public static final JSONObject toJSONObject(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "$this$toJSONObject");
        JSONObject jSONObject = new JSONObject();
        Set<String> keySet = bundle.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "bundle.keySet()");
        for (T t : keySet) {
            String string = bundle.getString(t, null);
            if (string != null) {
                jSONObject.put(t, string);
            }
        }
        return jSONObject;
    }

    public static final String limitLength(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "$this$limitLength");
        if (str.length() <= i) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, i - 1);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        sb.append(substring);
        sb.append("…");
        return sb.toString();
    }

    public static /* synthetic */ String format$default(Number number, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return format(number, i);
    }

    public static final String format(Number number, int i) {
        Intrinsics.checkNotNullParameter(number, "$this$format");
        NumberFormat numberFormat = NUMBER_FORMATTER;
        Intrinsics.checkNotNullExpressionValue(numberFormat, "NUMBER_FORMATTER");
        numberFormat.setMaximumFractionDigits(i);
        Intrinsics.checkNotNullExpressionValue(numberFormat, "NUMBER_FORMATTER");
        numberFormat.setMinimumFractionDigits(i);
        String format = numberFormat.format(number);
        Intrinsics.checkNotNullExpressionValue(format, "NUMBER_FORMATTER.format(this)");
        return format;
    }

    public static final String toDisplayScore(float f) {
        return f == 10.0f ? "10" : format$default(Float.valueOf(f), 0, 1, null);
    }

    public static final List<Cookie> getCoolApkCookie(DataConfig dataConfig) {
        Intrinsics.checkNotNullParameter(dataConfig, "$this$getCoolApkCookie");
        HttpClientFactory instance = HttpClientFactory.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "HttpClientFactory.getInstance()");
        CookieJar cookieJar = instance.getCoolMarketHttpClient().cookieJar();
        HttpUrl.Companion companion = HttpUrl.Companion;
        String apiEndpoint = dataConfig.getApiEndpoint();
        Intrinsics.checkNotNullExpressionValue(apiEndpoint, "apiEndpoint");
        return cookieJar.loadForRequest(companion.get(apiEndpoint));
    }

    public static final String toCookieString(List<Cookie> list) {
        Intrinsics.checkNotNullParameter(list, "$this$toCookieString");
        StringBuilder sb = new StringBuilder();
        for (Cookie cookie : list) {
            sb.append(cookie.name() + "=" + cookie.value() + ";");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "cookieBuilder.toString()");
        return sb2;
    }

    public static final LazyHeaders.Builder createGlideCoolApkHeader() {
        LazyHeaders.Builder builder = new LazyHeaders.Builder();
        try {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            DataConfig dataConfig = instance.getDataConfig();
            Intrinsics.checkNotNullExpressionValue(dataConfig, "dataConfig");
            List<String> coolMarketHeaders = dataConfig.getCoolMarketHeaders();
            for (int i = 0; i < coolMarketHeaders.size(); i += 2) {
                builder.addHeader(coolMarketHeaders.get(i), coolMarketHeaders.get(i + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder;
    }

    public static final void appendCoolApkCookies(LazyHeaders.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "$this$appendCoolApkCookies");
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        DataConfig dataConfig = instance.getDataConfig();
        Intrinsics.checkNotNullExpressionValue(dataConfig, "DataManager.getInstance().dataConfig");
        builder.addHeader("Cookie", toCookieString(getCoolApkCookie(dataConfig)));
    }

    public static final JSONObject convertToJson(String str) {
        Intrinsics.checkNotNullParameter(str, "$this$convertToJson");
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final List<JSONObject> toJSONObjectList(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "$this$toJSONObjectList");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            Intrinsics.checkNotNullExpressionValue(optJSONObject, "optJSONObject(index)");
            arrayList.add(optJSONObject);
        }
        return arrayList;
    }

    public static final SpannableStringBuilder insertParagraphSpacing(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "$this$insertParagraphSpacing");
        String str2 = str;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 >= 0) {
            int indexOf$default = StringsKt.indexOf$default((CharSequence) str2, "\r\n", i2, false, 4, (Object) null);
            if (indexOf$default >= 0) {
                arrayList.add(Integer.valueOf(indexOf$default));
                indexOf$default += 2;
            }
            i2 = indexOf$default;
        }
        int i3 = 0;
        while (i3 < arrayList.size() - 2) {
            int i4 = i3 + 1;
            String substring = str.substring(((Number) arrayList.get(i3)).intValue() + 2, ((Number) arrayList.get(i4)).intValue());
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (StringsKt.isBlank(substring)) {
                ColorDrawable colorDrawable = new ColorDrawable(0);
                colorDrawable.setBounds(0, 0, 0, i);
                Unit unit = Unit.INSTANCE;
                spannableStringBuilder.setSpan(new ImageSpan(colorDrawable, "[LINE]"), ((Number) arrayList.get(i3)).intValue(), ((Number) arrayList.get(i4)).intValue() + 2, 33);
            }
            i3 = i4;
        }
        return spannableStringBuilder;
    }

    public static final String toDisplayString(int i) {
        if (i <= 9999) {
            return String.valueOf(i);
        }
        return format$default(Float.valueOf(((float) i) / ((float) 10000)), 0, 1, null) + "w";
    }

    public static final Iterator<JSONObject> iterator(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "$this$iterator");
        return SequencesKt.map(CollectionsKt.asSequence(RangesKt.until(0, jSONArray.length())), new KotlinExtendKt$iterator$1(jSONArray)).iterator();
    }

    public static final Integer getIntOrNull(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "$this$getIntOrNull");
        Intrinsics.checkNotNullParameter(str, "key");
        if (jSONObject.has(str)) {
            return Integer.valueOf(jSONObject.optInt(str));
        }
        return null;
    }

    public static final String getStringOrNull(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "$this$getStringOrNull");
        Intrinsics.checkNotNullParameter(str, "key");
        if (jSONObject.has(str)) {
            return jSONObject.optString(str);
        }
        return null;
    }

    public static final ViewPartPool getViewPartPool(DataBindingComponent dataBindingComponent) {
        Intrinsics.checkNotNullParameter(dataBindingComponent, "$this$getViewPartPool");
        if (!(dataBindingComponent instanceof FragmentBindingComponent)) {
            dataBindingComponent = null;
        }
        FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) dataBindingComponent;
        Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
        if (!(fragment instanceof EntityListFragment)) {
            fragment = null;
        }
        EntityListFragment entityListFragment = (EntityListFragment) fragment;
        if (entityListFragment != null) {
            return entityListFragment.getViewPartPool();
        }
        return null;
    }

    public static final EntityListFragment getEntityListFragment(DataBindingComponent dataBindingComponent) {
        Intrinsics.checkNotNullParameter(dataBindingComponent, "$this$getEntityListFragment");
        LifecycleOwner lifecycleOwner = null;
        if (!(dataBindingComponent instanceof FragmentBindingComponent)) {
            dataBindingComponent = null;
        }
        FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) dataBindingComponent;
        LifecycleOwner lifecycleOwner2 = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
        if (lifecycleOwner2 instanceof EntityListFragment) {
            lifecycleOwner = lifecycleOwner2;
        }
        return (EntityListFragment) lifecycleOwner;
    }
}
