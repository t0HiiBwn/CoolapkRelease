package com.umeng.analytics.process;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.umeng.analytics.pro.p;
import com.umeng.analytics.process.DBFileTraversalUtil;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class UMProcessDBHelper {
    private static UMProcessDBHelper mInstance;
    private InsertEventCallback ekvCallBack = new InsertEventCallback();
    private Context mContext;
    private FileLockUtil mFileLock = new FileLockUtil();

    private int getDataSource() {
        return 0;
    }

    private class InsertEventCallback implements FileLockCallback {
        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            return false;
        }

        private InsertEventCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (str.startsWith("ua_")) {
                str = str.replaceFirst("ua_", "");
            }
            UMProcessDBHelper.this.insertEvents(str.replace(".db", ""), (JSONArray) obj);
            return true;
        }
    }

    private UMProcessDBHelper() {
    }

    private UMProcessDBHelper(Context context) {
        com.umeng.common.a.a().a(context);
    }

    public static UMProcessDBHelper getInstance(Context context) {
        if (mInstance == null) {
            synchronized (UMProcessDBHelper.class) {
                if (mInstance == null) {
                    mInstance = new UMProcessDBHelper(context);
                }
            }
        }
        UMProcessDBHelper uMProcessDBHelper = mInstance;
        uMProcessDBHelper.mContext = context;
        return uMProcessDBHelper;
    }

    public void createDBByProcess(String str) {
        try {
            c.a(this.mContext).a(str);
            c.a(this.mContext).b(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertEventsInSubProcess(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            File file = new File(b.b(this.mContext, str));
            if (file.exists()) {
                this.mFileLock.doFileOperateion(file, this.ekvCallBack, jSONArray);
            } else {
                insertEvents(str, jSONArray);
            }
        }
    }

    public void insertEvents(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            insertEvents_(str, datasAdapter(str, jSONArray));
        }
    }

    /* access modifiers changed from: private */
    public void processToMain(String str) {
        if (dbIsExists(str)) {
            List<a> readEventByProcess = readEventByProcess(str);
            if (!readEventByProcess.isEmpty() && insertEvents_("_main_", readEventByProcess)) {
                deleteEventDatas(str, null, readEventByProcess);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0185 A[SYNTHETIC, Splitter:B:73:0x0185] */
    public JSONObject readMainEvents(long j, List<Integer> list) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        Cursor cursor;
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject();
        SQLiteDatabase sQLiteDatabase2 = null;
        r4 = null;
        Cursor cursor2 = null;
        try {
            sQLiteDatabase = c.a(this.mContext).a("_main_");
            try {
                sQLiteDatabase.beginTransaction();
                Cursor rawQuery = sQLiteDatabase.rawQuery("select *  from __et_p", null);
                if (rawQuery != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    String str = "";
                    while (rawQuery.moveToNext()) {
                        int i = rawQuery.getInt(rawQuery.getColumnIndex("id"));
                        int i2 = rawQuery.getInt(rawQuery.getColumnIndex("__t"));
                        String string = rawQuery.getString(rawQuery.getColumnIndex("__i"));
                        String string2 = rawQuery.getString(rawQuery.getColumnIndex("__s"));
                        String string3 = rawQuery.getString(rawQuery.getColumnIndex("__pn"));
                        String string4 = rawQuery.getString(rawQuery.getColumnIndex("__av"));
                        if (!TextUtils.isEmpty(string)) {
                            if (TextUtils.isEmpty(str)) {
                                str = string4;
                            }
                            if (!TextUtils.isEmpty(string2) && i2 == 2049) {
                                JSONObject jSONObject3 = new JSONObject(com.umeng.common.a.a().b(string2));
                                String optString = jSONObject3.optString("pn");
                                if (TextUtils.isEmpty(optString) || "unknown".equals(optString)) {
                                    jSONObject3.put("pn", this.mContext.getPackageName() + ":" + string3);
                                }
                                if (jSONObject2.has(string)) {
                                    jSONArray = jSONObject2.optJSONArray(string);
                                } else {
                                    jSONArray = new JSONArray();
                                }
                                if (p.a(jSONObject3) + p.a(jSONArray) > j || !str.equalsIgnoreCase(string4)) {
                                    break;
                                }
                                list.add(Integer.valueOf(i));
                                jSONArray.put(jSONObject3);
                                jSONObject2.put(string, jSONArray);
                            }
                        }
                    }
                    if (jSONObject2.length() > 0) {
                        JSONArray jSONArray2 = new JSONArray();
                        Iterator<String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            JSONObject jSONObject4 = new JSONObject();
                            String next = keys.next();
                            jSONObject4.put(next, new JSONArray(jSONObject2.optString(next)));
                            if (jSONObject4.length() > 0) {
                                jSONArray2.put(jSONObject4);
                            }
                        }
                        if (jSONArray2.length() > 0) {
                            jSONObject.put("ekv", jSONArray2);
                        }
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (rawQuery != null) {
                    rawQuery.close();
                }
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
            } catch (Exception unused2) {
                cursor = null;
                sQLiteDatabase2 = sQLiteDatabase;
                try {
                    UMRTLog.e("MobclickRT", "--->>> 构建子进程事件数据异常，清除数据库数据。");
                    sQLiteDatabase2.execSQL("delete from __et_p");
                    sQLiteDatabase2.setTransactionSuccessful();
                    if (cursor != null) {
                    }
                    if (sQLiteDatabase2 != null) {
                    }
                    c.a(this.mContext).b("_main_");
                    return jSONObject;
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteDatabase = sQLiteDatabase2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    if (sQLiteDatabase != null) {
                    }
                    c.a(this.mContext).b("_main_");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (cursor2 != null) {
                }
                if (sQLiteDatabase != null) {
                }
                c.a(this.mContext).b("_main_");
                throw th;
            }
        } catch (Exception unused3) {
            cursor = null;
            UMRTLog.e("MobclickRT", "--->>> 构建子进程事件数据异常，清除数据库数据。");
            sQLiteDatabase2.execSQL("delete from __et_p");
            sQLiteDatabase2.setTransactionSuccessful();
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabase2 != null) {
                sQLiteDatabase2.endTransaction();
            }
            c.a(this.mContext).b("_main_");
            return jSONObject;
        } catch (Throwable th4) {
            th = th4;
            sQLiteDatabase = null;
            if (cursor2 != null) {
                cursor2.close();
            }
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused4) {
                }
            }
            c.a(this.mContext).b("_main_");
            throw th;
        }
        c.a(this.mContext).b("_main_");
        return jSONObject;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0049, code lost:
        if (0 == 0) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004b, code lost:
        r1.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004e, code lost:
        com.umeng.analytics.process.c.a(r7.mContext).b("_main_");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0057, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0035, code lost:
        if (r1 != null) goto L_0x004b;
     */
    public void deleteMainProcessEventDatasByIds(List<Integer> list) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = c.a(this.mContext).a("_main_");
            sQLiteDatabase.beginTransaction();
            Iterator<Integer> it2 = list.iterator();
            while (it2.hasNext()) {
                sQLiteDatabase.delete("__et_p", "id=?", new String[]{String.valueOf(it2.next())});
            }
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception unused) {
        } catch (Throwable th) {
            if (0 != 0) {
                sQLiteDatabase.endTransaction();
            }
            c.a(this.mContext).b("_main_");
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0066  */
    public void deleteEventDatas(String str, String str2, List<a> list) {
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        if (!TextUtils.isEmpty(str)) {
            SQLiteDatabase sQLiteDatabase2 = null;
            try {
                sQLiteDatabase = c.a(this.mContext).a(str);
                try {
                    sQLiteDatabase.beginTransaction();
                    int size = list.size();
                    if (list == null || size <= 0) {
                        sQLiteDatabase.delete("__et_p", null, null);
                    } else {
                        for (int i = 0; i < size; i++) {
                            sQLiteDatabase.execSQL("delete from __et_p where rowid=" + list.get(i).a);
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                } catch (Exception unused) {
                    sQLiteDatabase2 = sQLiteDatabase;
                    if (sQLiteDatabase2 != null) {
                    }
                    c.a(this.mContext).b(str);
                } catch (Throwable th2) {
                    th = th2;
                    if (sQLiteDatabase != null) {
                    }
                    c.a(this.mContext).b(str);
                    throw th;
                }
            } catch (Exception unused2) {
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.endTransaction();
                }
                c.a(this.mContext).b(str);
            } catch (Throwable th3) {
                sQLiteDatabase = null;
                th = th3;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
                c.a(this.mContext).b(str);
                throw th;
            }
            c.a(this.mContext).b(str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0081, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0082, code lost:
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0084, code lost:
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r0.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r0.endTransaction();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0081 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:8:0x001c] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0089 A[SYNTHETIC, Splitter:B:29:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0099 A[SYNTHETIC, Splitter:B:37:0x0099] */
    private boolean insertEvents_(String str, List<a> list) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return true;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase a2 = c.a(this.mContext).a(str);
            try {
                a2.beginTransaction();
                for (a aVar : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("__i", aVar.b);
                    contentValues.put("__e", aVar.c);
                    contentValues.put("__t", Integer.valueOf(aVar.e));
                    contentValues.put("__pn", aVar.f);
                    contentValues.put("__av", aVar.g);
                    contentValues.put("__vc", aVar.h);
                    contentValues.put("__s", aVar.d);
                    a2.insert("__et_p", null, contentValues);
                }
                a2.setTransactionSuccessful();
                if (a2 != null) {
                    try {
                        a2.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                c.a(this.mContext).b(str);
                return true;
            } catch (Exception unused2) {
            } catch (Throwable th) {
            }
        } catch (Exception unused3) {
            if (sQLiteDatabase != null) {
            }
            c.a(this.mContext).b(str);
            return false;
        } catch (Throwable th2) {
            Throwable th3 = th2;
            if (sQLiteDatabase != null) {
            }
            c.a(this.mContext).b(str);
            throw th3;
        }
    }

    private List<a> datasAdapter(String str, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                a aVar = new a();
                aVar.c = jSONObject.optString("id");
                aVar.g = UMUtils.getAppVersionName(this.mContext);
                aVar.h = UMUtils.getAppVersionCode(this.mContext);
                aVar.b = jSONObject.optString("__i");
                aVar.e = jSONObject.optInt("__t");
                aVar.f = str;
                if (jSONObject.has("ds")) {
                    jSONObject.remove("ds");
                }
                jSONObject.put("ds", getDataSource());
                jSONObject.remove("__i");
                jSONObject.remove("__t");
                aVar.d = com.umeng.common.a.a().a(jSONObject.toString());
                jSONObject.remove("ds");
                arrayList.add(aVar);
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005d, code lost:
        r3 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0060, code lost:
        r5 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005c A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0085 A[SYNTHETIC, Splitter:B:40:0x0085] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008a A[Catch:{ Exception -> 0x008d }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x009b A[SYNTHETIC, Splitter:B:48:0x009b] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a0 A[Catch:{ Exception -> 0x00a3 }] */
    public JSONObject readVersionInfoFromColumId(Integer num) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        JSONObject jSONObject;
        Exception e;
        String str = "select *  from __et_p where rowid=" + num;
        Cursor cursor = null;
        r3 = null;
        JSONObject jSONObject2 = null;
        cursor = null;
        cursor = null;
        try {
            sQLiteDatabase = c.a(this.mContext).a("_main_");
            try {
                sQLiteDatabase.beginTransaction();
                Cursor rawQuery = sQLiteDatabase.rawQuery(str, null);
                if (rawQuery != null) {
                    try {
                        if (rawQuery.moveToNext()) {
                            jSONObject = new JSONObject();
                            String string = rawQuery.getString(rawQuery.getColumnIndex("__av"));
                            String string2 = rawQuery.getString(rawQuery.getColumnIndex("__vc"));
                            if (!TextUtils.isEmpty(string)) {
                                jSONObject.put("__av", string);
                            }
                            if (!TextUtils.isEmpty(string2)) {
                                jSONObject.put("__vc", string2);
                            }
                            jSONObject2 = jSONObject;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        cursor = rawQuery;
                        try {
                            e.printStackTrace();
                            if (cursor != null) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            c.a(this.mContext).b("_main_");
                            return jSONObject;
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            c.a(this.mContext).b("_main_");
                            throw th;
                        }
                    } catch (Throwable th3) {
                    }
                }
                if (rawQuery != null) {
                    try {
                        rawQuery.close();
                    } catch (Exception unused) {
                    }
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
                c.a(this.mContext).b("_main_");
                return jSONObject2;
            } catch (Exception e3) {
                e = e3;
                jSONObject = null;
                e.printStackTrace();
                if (cursor != null) {
                }
                if (sQLiteDatabase != null) {
                }
                c.a(this.mContext).b("_main_");
                return jSONObject;
            }
        } catch (Exception e4) {
            e = e4;
            sQLiteDatabase = null;
            jSONObject = null;
            e.printStackTrace();
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception unused2) {
                    c.a(this.mContext).b("_main_");
                    return jSONObject;
                }
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            c.a(this.mContext).b("_main_");
            return jSONObject;
        } catch (Throwable th4) {
            th = th4;
            sQLiteDatabase = null;
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception unused3) {
                    c.a(this.mContext).b("_main_");
                    throw th;
                }
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            c.a(this.mContext).b("_main_");
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x008c, code lost:
        if (r3 != null) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a5, code lost:
        if (r3 != null) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a7, code lost:
        r3.endTransaction();
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b8 A[SYNTHETIC, Splitter:B:34:0x00b8] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bd A[Catch:{ Exception -> 0x00c0 }] */
    private List<a> readEventByProcess(String str) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        Exception e;
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = null;
        try {
            sQLiteDatabase = c.a(this.mContext).a(str);
            try {
                sQLiteDatabase.beginTransaction();
                cursor = sQLiteDatabase.rawQuery("select *  from __et_p", null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            a aVar = new a();
                            aVar.a = cursor.getInt(0);
                            aVar.b = cursor.getString(cursor.getColumnIndex("__i"));
                            aVar.c = cursor.getString(cursor.getColumnIndex("__e"));
                            aVar.d = cursor.getString(cursor.getColumnIndex("__s"));
                            aVar.e = cursor.getInt(cursor.getColumnIndex("__t"));
                            aVar.f = cursor.getString(cursor.getColumnIndex("__pn"));
                            aVar.g = cursor.getString(cursor.getColumnIndex("__av"));
                            aVar.h = cursor.getString(cursor.getColumnIndex("__vc"));
                            arrayList.add(aVar);
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                e.printStackTrace();
                                if (cursor != null) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                cursor2 = cursor;
                                if (cursor2 != null) {
                                    try {
                                        cursor2.close();
                                    } catch (Exception unused) {
                                        c.a(this.mContext).b(str);
                                        throw th;
                                    }
                                }
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.endTransaction();
                                }
                                c.a(this.mContext).b(str);
                                throw th;
                            }
                        }
                    }
                }
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused2) {
                    }
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
                e.printStackTrace();
                if (cursor != null) {
                }
            } catch (Throwable th3) {
                th = th3;
                if (cursor2 != null) {
                }
                if (sQLiteDatabase != null) {
                }
                c.a(this.mContext).b(str);
                throw th;
            }
        } catch (Exception e4) {
            sQLiteDatabase = null;
            e = e4;
            cursor = null;
            e.printStackTrace();
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th4) {
            th = th4;
            sQLiteDatabase = null;
            if (cursor2 != null) {
            }
            if (sQLiteDatabase != null) {
            }
            c.a(this.mContext).b(str);
            throw th;
        }
        c.a(this.mContext).b(str);
        return arrayList;
    }

    private boolean dbIsExists(String str) {
        try {
            return new File(b.b(this.mContext, str)).exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    private class a implements Serializable {
        int a;
        String b;
        String c;
        String d;
        int e;
        String f;
        String g;
        String h;

        private a() {
        }
    }

    private class ProcessToMainCallback implements FileLockCallback {
        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            return false;
        }

        private ProcessToMainCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (str.startsWith("ua_")) {
                str = str.replaceFirst("ua_", "");
            }
            UMProcessDBHelper.this.processToMain(str.replace(".db", ""));
            return true;
        }
    }

    public void processDBToMain() {
        try {
            DBFileTraversalUtil.traverseDBFiles(b.a(this.mContext), new ProcessToMainCallback(), new DBFileTraversalUtil.a() {
                /* class com.umeng.analytics.process.UMProcessDBHelper.AnonymousClass1 */

                @Override // com.umeng.analytics.process.DBFileTraversalUtil.a
                public void a() {
                    if (AnalyticsConstants.SUB_PROCESS_EVENT) {
                        UMWorkDispatch.sendEvent(UMProcessDBHelper.this.mContext, 36946, UMProcessDBDatasSender.getInstance(UMProcessDBHelper.this.mContext), null);
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    private boolean processIsService(Context context) {
        try {
            if (context.getPackageManager().getServiceInfo(new ComponentName(context, this.mContext.getClass()), 0) != null) {
                return true;
            }
            return false;
        } catch (Exception unused) {
        }
    }
}
