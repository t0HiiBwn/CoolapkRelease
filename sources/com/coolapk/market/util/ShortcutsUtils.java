package com.coolapk.market.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.view.main.MainActivity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0003J\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0014j\b\u0012\u0004\u0012\u00020\t`\u00152\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/coolapk/market/util/ShortcutsUtils;", "", "()V", "isFirst", "", "()Z", "setFirst", "(Z)V", "createShortcut", "Landroid/content/pm/ShortcutInfo;", "context", "Landroid/content/Context;", "id", "", "label", "", "icon", "intent", "Landroid/content/Intent;", "createShortcuts", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "init", "", "update", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ShortcutsUtils.kt */
public final class ShortcutsUtils {
    public static final ShortcutsUtils INSTANCE = new ShortcutsUtils();
    private static boolean isFirst = true;

    private ShortcutsUtils() {
    }

    public final boolean isFirst() {
        return isFirst;
    }

    public final void setFirst(boolean z) {
        isFirst = z;
    }

    @JvmStatic
    public static final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 25 && isFirst) {
            isFirst = true;
            try {
                Object systemService = context.getSystemService("shortcut");
                if (systemService != null) {
                    ((ShortcutManager) systemService).setDynamicShortcuts(INSTANCE.createShortcuts(context));
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.content.pm.ShortcutManager");
            } catch (Exception unused) {
            }
        }
    }

    @JvmStatic
    public static final void update(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 25) {
            try {
                Object systemService = context.getSystemService("shortcut");
                if (systemService != null) {
                    ((ShortcutManager) systemService).updateShortcuts(INSTANCE.createShortcuts(context));
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.content.pm.ShortcutManager");
            } catch (Exception unused) {
            }
        }
    }

    public final ArrayList<ShortcutInfo> createShortcuts(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList<ShortcutInfo> arrayList = new ArrayList<>();
        Intent data = new Intent(context, MainActivity.class).setAction("android.intent.action.VIEW").setData(Uri.parse("coolmarket://com.coolapk.market/search"));
        Intrinsics.checkNotNullExpressionValue(data, "Intent(context, MainActi….coolapk.market/search\"))");
        arrayList.add(createShortcut(context, "SEARCH", 2131886390, 2131231529, data));
        Intent data2 = new Intent(context, MainActivity.class).setAction("android.intent.action.VIEW").setData(Uri.parse("coolmarket://com.coolapk.market/new_feed"));
        Intrinsics.checkNotNullExpressionValue(data2, "Intent(context, MainActi…oolapk.market/new_feed\"))");
        arrayList.add(createShortcut(context, "NEW_FEED", 2131886370, 2131231527, data2));
        Intent data3 = new Intent(context, MainActivity.class).setAction("android.intent.action.VIEW").setData(Uri.parse("coolmarket://com.coolapk.market/page?url=V8_CHANNEL_COOLPIC&title=酷图"));
        Intrinsics.checkNotNullExpressionValue(data3, "Intent(context, MainActi…ANNEL_COOLPIC&title=酷图\"))");
        arrayList.add(createShortcut(context, "COOL_PIC", 2131886687, 2131231387, data3));
        if (!AppHolder.getAppMetadata().isCommunityMode()) {
            Intent data4 = new Intent(context, MainActivity.class).setAction("android.intent.action.VIEW").setData(Uri.parse("coolmarket://com.coolapk.market/app_manager"));
            Intrinsics.checkNotNullExpressionValue(data4, "Intent(context, MainActi…apk.market/app_manager\"))");
            arrayList.add(createShortcut(context, "APP_MANAGER", 2131887227, 2131231526, data4));
        }
        Intent data5 = new Intent(context, MainActivity.class).setAction("android.intent.action.VIEW").setData(Uri.parse("coolmarket://com.coolapk.market/qr_scan"));
        Intrinsics.checkNotNullExpressionValue(data5, "Intent(context, MainActi…coolapk.market/qr_scan\"))");
        arrayList.add(createShortcut(context, "COOL_SCAN", 2131887293, 2131231524, data5));
        return arrayList;
    }

    private final ShortcutInfo createShortcut(Context context, String str, int i, int i2, Intent intent) {
        int dp2px = ConvertUtils.dp2px(48.0f);
        Bitmap createBitmap = Bitmap.createBitmap(dp2px, dp2px, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(AppHolder.getAppTheme().getColorAccent());
        paint.setAntiAlias(true);
        float f = ((float) dp2px) / 2.0f;
        canvas.drawCircle(((float) canvas.getWidth()) / 2.0f, ((float) canvas.getHeight()) / 2.0f, f, paint);
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), i2);
        Intrinsics.checkNotNullExpressionValue(decodeResource, "searchBitmap");
        int width = (int) (f - (((float) decodeResource.getWidth()) / 2.0f));
        canvas.drawBitmap(decodeResource, new Rect(0, 0, decodeResource.getWidth(), decodeResource.getHeight()), new Rect(width, width, decodeResource.getWidth() + width, decodeResource.getHeight() + width), (Paint) null);
        ShortcutInfo build = new ShortcutInfo.Builder(context, str).setShortLabel(context.getString(i)).setLongLabel(context.getString(i)).setIcon(Icon.createWithBitmap(createBitmap)).setIntent(intent).build();
        Intrinsics.checkNotNullExpressionValue(build, "ShortcutInfo.Builder(con…\n                .build()");
        return build;
    }
}
