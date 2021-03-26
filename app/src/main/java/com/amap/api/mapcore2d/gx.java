package com.amap.api.mapcore2d;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;

/* compiled from: SpUtil */
public final class gx {
    public static int a(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, 200);
        } catch (Throwable th) {
            gu.a(th, "SpUtil", "getPrefsInt");
            return 200;
        }
    }

    public static String a(Context context) {
        return context == null ? "00:00:00:00:00:00" : b(context, "pref", "smac", "00:00:00:00:00:00");
    }

    public static void a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            a(context, "pref", "smac", str);
        }
    }

    private static void a(Context context, String str, String str2, String str3) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString(str2, str3);
            a(edit);
        } catch (Throwable th) {
            gu.a(th, "SpUtil", "setPrefsStr");
        }
    }

    private static void a(SharedPreferences.Editor editor) {
        if (editor != null) {
            if (Build.VERSION.SDK_INT >= 9) {
                editor.apply();
            } else {
                b(editor);
            }
        }
    }

    private static String b(Context context, String str, String str2, String str3) {
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th) {
            gu.a(th, "SpUtil", "getPrefsInt");
            return str3;
        }
    }

    private static void b(final SharedPreferences.Editor editor) {
        try {
            new AsyncTask<Void, Void, Void>() {
                /* class com.amap.api.mapcore2d.gx.AnonymousClass1 */

                private Void a() {
                    try {
                        SharedPreferences.Editor editor = editor;
                        if (editor == null) {
                            return null;
                        }
                        editor.commit();
                        return null;
                    } catch (Throwable th) {
                        gu.a(th, "SpUtil", "commit");
                        return null;
                    }
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
                @Override // android.os.AsyncTask
                protected final /* synthetic */ Void doInBackground(Void[] voidArr) {
                    return a();
                }
            }.execute(null, null, null);
        } catch (Throwable th) {
            gu.a(th, "SpUtil", "commit1");
        }
    }

    public static boolean b(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, true);
        } catch (Throwable th) {
            gu.a(th, "SpUtil", "getPrefsBoolean");
            return true;
        }
    }
}
