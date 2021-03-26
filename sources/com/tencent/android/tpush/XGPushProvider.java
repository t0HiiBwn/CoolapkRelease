package com.tencent.android.tpush;

import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.tencent.android.tpush.b.f;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import java.net.URISyntaxException;
import java.util.Arrays;

/* compiled from: ProGuard */
public class XGPushProvider extends ContentProvider {
    public static String AUTH_PRIX = ".XGVIP_PUSH_AUTH";
    public static final String TAG = "XGPushProvider";
    private Context a = null;
    private String b = null;
    private UriMatcher c = new UriMatcher(-1);

    private void a() {
        Context applicationContext = getContext().getApplicationContext();
        this.a = applicationContext;
        j.a(applicationContext);
        this.b = this.a.getPackageName();
        String str = this.b + AUTH_PRIX;
        this.c.addURI(str, TypeStr.config.getStr(), TypeStr.config.getType());
        this.c.addURI(str, TypeStr.config_all.getStr(), TypeStr.config_all.getType());
        this.c.addURI(str, TypeStr.msg.getStr(), TypeStr.msg.getType());
        this.c.addURI(str, TypeStr.msg_all.getStr(), TypeStr.msg_all.getType());
        this.c.addURI(str, TypeStr.hearbeat.getStr(), TypeStr.hearbeat.getType());
        this.c.addURI(str, TypeStr.hearbeat_all.getStr(), TypeStr.hearbeat_all.getType());
        this.c.addURI(str, TypeStr.feedback.getStr(), TypeStr.feedback.getType());
        this.c.addURI(str, TypeStr.feedback_all.getStr(), TypeStr.feedback_all.getType());
        this.c.addURI(str, TypeStr.token.getStr(), TypeStr.token.getType());
        this.c.addURI(str, TypeStr.register.getStr(), TypeStr.register.getType());
        this.c.addURI(str, TypeStr.insert_mid_new.getStr(), TypeStr.insert_mid_new.getType());
        this.c.addURI(str, TypeStr.insert_mid_old.getStr(), TypeStr.insert_mid_old.getType());
        this.c.addURI(str, TypeStr.pullupxg.getStr(), TypeStr.pullupxg.getType());
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        TLogger.i("XGPushProvider", "XGPushProvider onCreate");
        a();
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        TLogger.i("XGPushProvider", "query uri:" + uri + ",projection:" + Arrays.toString(strArr) + ",selection:" + str + ",selectionArgs:" + Arrays.toString(strArr2) + ",sortOrder:" + str2);
        return null;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        int match = this.c.match(uri);
        TLogger.i("XGPushProvider", "getType uri:" + uri + ",match:" + match);
        TypeStr typeStr = TypeStr.getTypeStr(match);
        if (typeStr == null) {
            return null;
        }
        switch (AnonymousClass1.a[typeStr.ordinal()]) {
            case 1:
                return "CONFIG";
            case 2:
                return "CONFIG_ALL";
            case 3:
                f.a(this.a).a(false);
                return null;
            case 4:
                TLogger.i("XGPushProvider", "Start XGService by provider");
                b.a(this.a);
                return null;
            case 5:
                return "HEARTBEAT_ALL";
            case 6:
                return GuidInfoManager.getToken(this.a);
            case 7:
                RegisterEntity currentAppRegisterEntity = CacheManager.getCurrentAppRegisterEntity(this.a);
                TLogger.i("XGPushProvider", "get RegisterEntity:" + currentAppRegisterEntity);
                return Rijndael.encrypt(RegisterEntity.encode(currentAppRegisterEntity));
            default:
                return null;
        }
    }

    /* renamed from: com.tencent.android.tpush.XGPushProvider$1  reason: invalid class name */
    /* compiled from: ProGuard */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[TypeStr.values().length];
            a = iArr;
            try {
                iArr[TypeStr.config.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[TypeStr.config_all.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[TypeStr.hearbeat.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[TypeStr.pullupxg.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[TypeStr.hearbeat_all.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[TypeStr.token.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[TypeStr.register.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[TypeStr.msg.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[TypeStr.msg_all.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[TypeStr.feedback.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[TypeStr.feedback_all.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        int match = this.c.match(uri);
        TypeStr typeStr = TypeStr.getTypeStr(match);
        if (typeStr == null) {
            return null;
        }
        TLogger.i("XGPushProvider", "insert uri:" + uri + ",match:" + match + ",values:" + contentValues);
        if (AnonymousClass1.a[typeStr.ordinal()] != 8) {
            return null;
        }
        try {
            String asString = contentValues.getAsString("key");
            if (asString == null) {
                TLogger.e("XGPushProvider", "key is null");
                return null;
            }
            Intent parseUri = Intent.parseUri(asString, 0);
            parseUri.addCategory("android.intent.category.BROWSABLE");
            parseUri.setComponent(null);
            if (Build.VERSION.SDK_INT >= 15) {
                try {
                    parseUri.getClass().getMethod("setSelector", Intent.class).invoke(parseUri, null);
                } catch (Throwable th) {
                    TLogger.w("XGPushProvider", "invoke intent.setComponent error.", th);
                }
            }
            f.a(this.a).b(parseUri);
            return null;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        TLogger.w("XGPushProvider", "delete uri:" + uri + ",selection:" + str + ",selectionArgs:" + Arrays.toString(strArr));
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int match = this.c.match(uri);
        TypeStr typeStr = TypeStr.getTypeStr(match);
        if (typeStr == null) {
            return 0;
        }
        TLogger.i("XGPushProvider", "update uri:" + uri + ",values:" + contentValues + ",selection:" + str + ",selectionArgs:" + Arrays.toString(strArr) + ",match:" + match);
        if (AnonymousClass1.a[typeStr.ordinal()] != 10) {
            return 0;
        }
        String decrypt = Rijndael.decrypt(contentValues.getAsString("feedback"));
        TLogger.i("XGPushProvider", "feeback: " + decrypt);
        return 0;
    }

    public static void fetchProviderAuthorities(Context context) {
        try {
            String packageName = context.getPackageName();
            ProviderInfo providerInfo = context.getPackageManager().getProviderInfo(new ComponentName(packageName, XGPushProvider.class.getName()), 0);
            AUTH_PRIX = providerInfo.authority.replace(packageName, "");
            TLogger.i("XGPushProvider", "name:" + providerInfo.name + ", authority:" + providerInfo.authority + ", AUTH_PRIX:" + AUTH_PRIX);
        } catch (Throwable th) {
            TLogger.w("XGPushProvider", "unexpected for fetchProviderAuthorities", th);
        }
    }
}
