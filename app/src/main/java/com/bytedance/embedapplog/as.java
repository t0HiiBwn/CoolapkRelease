package com.bytedance.embedapplog;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class as {
    static final HashMap<String, aq> a = new HashMap<>();
    private static int b;
    private static String c = ("SELECT * FROM " + az.h + " WHERE event_name =?  AND monitor_status=?");
    private static String d = ("UPDATE " + az.h + " SET monitor_num =? WHERE event_name =? AND monitor_status =?");
    private static String e;
    private static String f = ("DELETE FROM " + az.h + " WHERE local_time_ms <= ?");
    private final z g;
    private final aa h;
    private final a i;

    private void a(ax axVar, HashMap<String, Integer> hashMap, boolean z) {
    }

    private String a(aq aqVar, String str, int i2) {
        return "SELECT * FROM " + aqVar.d() + " WHERE session_id='" + str + "' ORDER BY local_time_ms LIMIT " + i2;
    }

    private String a(aq aqVar, String str, long j) {
        return "DELETE FROM " + aqVar.d() + " WHERE session_id='" + str + "' AND local_time_ms<=" + j;
    }

    private String a(long j, int i2) {
        return "UPDATE pack SET _fail=" + i2 + " WHERE local_time_ms=" + j;
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ");
        sb.append(az.h);
        sb.append(" WHERE ");
        sb.append("date");
        sb.append("<? ORDER BY ");
        sb.append("local_time_ms");
        sb.append(" LIMIT ?");
        e = sb.toString();
        a(new ay());
        a(new at());
        a(new av(null, false, null));
        a(new aw());
        a(new ba());
        a(new ax());
        a(new au("", new JSONObject()));
        a(new az());
    }

    public as(Application application, aa aaVar, z zVar) {
        this.i = new a(application, "bd_embed_tea_agent.db", null, 29);
        this.h = aaVar;
        this.g = zVar;
    }

    private static void a(aq aqVar) {
        a.put(aqVar.d(), aqVar);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:116:0x0106 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:115:0x0166 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x0109 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0125, code lost:
        if (r5[0].length() <= 0) goto L_0x0131;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0068, code lost:
        if (r5[0].length() <= 0) goto L_0x0074;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01a1 A[SYNTHETIC, Splitter:B:101:0x01a1] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01af A[SYNTHETIC, Splitter:B:108:0x01af] */
    /* JADX WARNING: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0109 A[SYNTHETIC, Splitter:B:49:0x0109] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x017e A[SYNTHETIC, Splitter:B:81:0x017e] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public boolean a(JSONObject jSONObject, aw awVar, boolean z) {
        Throwable th;
        Exception e2;
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2;
        Throwable th2;
        aq[] aqVarArr;
        JSONArray[] jSONArrayArr;
        int a2;
        aq[] aqVarArr2;
        String str;
        ContentValues contentValues;
        SQLiteDatabase sQLiteDatabase3;
        int i2;
        ax axVar;
        String str2;
        ax axVar2;
        String str3;
        String str4;
        long currentTimeMillis;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        Throwable th3;
        HashMap<String, aq> hashMap = a;
        av avVar = (av) hashMap.get("eventv3");
        at atVar = (at) hashMap.get("event");
        au auVar = (au) hashMap.get("event_misc");
        ax axVar3 = (ax) hashMap.get("pack");
        ContentValues contentValues2 = new ContentValues();
        SQLiteDatabase sQLiteDatabase4 = null;
        try {
            SQLiteDatabase writableDatabase = this.i.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                aqVarArr = new aq[]{atVar, avVar, auVar};
                jSONArrayArr = new JSONArray[3];
                ?? r9 = 1;
                a2 = a(aqVarArr, 0, writableDatabase, awVar.c, jSONArrayArr);
                if (jSONArrayArr[0] != null) {
                    try {
                    } catch (Exception e3) {
                        e2 = e3;
                        sQLiteDatabase4 = writableDatabase;
                        try {
                            bo.a(e2);
                            if (sQLiteDatabase4 != null) {
                            }
                            return false;
                        } catch (Throwable th4) {
                            th = th4;
                            th = th;
                            if (sQLiteDatabase4 != null) {
                                try {
                                    sQLiteDatabase4.endTransaction();
                                } catch (Exception e4) {
                                    bo.a(e4);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        sQLiteDatabase4 = writableDatabase;
                        if (sQLiteDatabase4 != null) {
                        }
                        throw th;
                    }
                }
                if ((jSONArrayArr[1] == null || jSONArrayArr[1].length() <= 0) && ((jSONArrayArr[2] == null || jSONArrayArr[2].length() <= 0) && !a(awVar, z))) {
                    aqVarArr2 = aqVarArr;
                    sQLiteDatabase3 = writableDatabase;
                    str2 = null;
                    axVar = axVar3;
                    str = "pack";
                    i2 = a2;
                    contentValues = contentValues2;
                    while (i2 < 3) {
                        try {
                            try {
                                i2 = a(aqVarArr2, i2, sQLiteDatabase3, awVar.c, jSONArrayArr);
                                if (jSONArrayArr[0] != null) {
                                    try {
                                    } catch (Exception e5) {
                                        e2 = e5;
                                        sQLiteDatabase4 = sQLiteDatabase3;
                                        bo.a(e2);
                                        if (sQLiteDatabase4 != null) {
                                        }
                                        return false;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        sQLiteDatabase4 = sQLiteDatabase3;
                                        if (sQLiteDatabase4 != null) {
                                        }
                                        throw th;
                                    }
                                }
                                if (jSONArrayArr[r9] == null || jSONArrayArr[r9].length() <= 0) {
                                    axVar2 = axVar;
                                    r9 = sQLiteDatabase3;
                                    str4 = str2;
                                    str3 = str;
                                    str = str3;
                                    axVar = axVar2;
                                    sQLiteDatabase3 = r9;
                                    r9 = 1;
                                    str2 = str4;
                                }
                                currentTimeMillis = System.currentTimeMillis();
                                jSONArray = jSONArrayArr[0];
                                jSONArray2 = jSONArrayArr[r9 == true ? 1 : 0];
                                axVar2 = axVar;
                                r9 = sQLiteDatabase3;
                                str4 = str2;
                                str3 = str;
                            } catch (Exception e6) {
                                e2 = e6;
                                sQLiteDatabase = sQLiteDatabase3;
                                sQLiteDatabase4 = sQLiteDatabase;
                                bo.a(e2);
                                if (sQLiteDatabase4 != null) {
                                }
                                return false;
                            } catch (Throwable th7) {
                                th2 = th7;
                                sQLiteDatabase2 = sQLiteDatabase3;
                                th = th2;
                                sQLiteDatabase4 = sQLiteDatabase2;
                                if (sQLiteDatabase4 != null) {
                                }
                                throw th;
                            }
                            try {
                                axVar.a(currentTimeMillis, jSONObject, null, null, null, jSONArray, jSONArray2, jSONArrayArr[2]);
                                contentValues = axVar2.b(contentValues);
                                r9.insert(str3, str4, contentValues);
                                str = str3;
                                axVar = axVar2;
                                sQLiteDatabase3 = r9;
                                r9 = 1;
                                str2 = str4;
                            } catch (Exception e7) {
                                e2 = e7;
                                sQLiteDatabase = r9;
                                sQLiteDatabase4 = sQLiteDatabase;
                                bo.a(e2);
                                if (sQLiteDatabase4 != null) {
                                }
                                return false;
                            } catch (Throwable th8) {
                                th2 = th8;
                                sQLiteDatabase2 = r9;
                                th = th2;
                                sQLiteDatabase4 = sQLiteDatabase2;
                                if (sQLiteDatabase4 != null) {
                                }
                                throw th;
                            }
                        } catch (Exception e8) {
                            e2 = e8;
                            sQLiteDatabase = sQLiteDatabase3;
                            sQLiteDatabase4 = sQLiteDatabase;
                            bo.a(e2);
                            if (sQLiteDatabase4 != null) {
                            }
                            return false;
                        } catch (Throwable th9) {
                            th2 = th9;
                            sQLiteDatabase2 = sQLiteDatabase3;
                            th = th2;
                            sQLiteDatabase4 = sQLiteDatabase2;
                            if (sQLiteDatabase4 != null) {
                            }
                            throw th;
                        }
                    }
                    sQLiteDatabase3.setTransactionSuccessful();
                    if (sQLiteDatabase3 != null) {
                        return true;
                    }
                    try {
                        sQLiteDatabase3.endTransaction();
                        return true;
                    } catch (Exception e9) {
                        bo.a(e9);
                        return true;
                    }
                }
            } catch (Exception e10) {
                e2 = e10;
                sQLiteDatabase = writableDatabase;
                sQLiteDatabase4 = sQLiteDatabase;
                bo.a(e2);
                if (sQLiteDatabase4 != null) {
                    try {
                        sQLiteDatabase4.endTransaction();
                    } catch (Exception e11) {
                        bo.a(e11);
                    }
                }
                return false;
            } catch (Throwable th10) {
                th2 = th10;
                sQLiteDatabase2 = writableDatabase;
                th = th2;
                sQLiteDatabase4 = sQLiteDatabase2;
                if (sQLiteDatabase4 != null) {
                }
                throw th;
            }
            try {
                aqVarArr2 = aqVarArr;
                sQLiteDatabase3 = writableDatabase;
                str2 = null;
                axVar = axVar3;
                try {
                    axVar3.a(System.currentTimeMillis(), jSONObject, a(awVar, z) ? awVar : null, null, null, jSONArrayArr[0], jSONArrayArr[1], jSONArrayArr[2]);
                    ContentValues b2 = axVar.b(contentValues2);
                    str = "pack";
                    sQLiteDatabase3.insert(str, null, b2);
                    if (bo.b && a(awVar, z)) {
                        bo.a("send launch, " + awVar.c + ", hadUI:" + z, null);
                    }
                    awVar.k = true;
                    i2 = a2;
                    contentValues = b2;
                    while (i2 < 3) {
                    }
                    sQLiteDatabase3.setTransactionSuccessful();
                    if (sQLiteDatabase3 != null) {
                    }
                } catch (Exception e12) {
                    e2 = e12;
                    sQLiteDatabase4 = sQLiteDatabase3;
                    bo.a(e2);
                    if (sQLiteDatabase4 != null) {
                    }
                    return false;
                } catch (Throwable th11) {
                    th3 = th11;
                    th = th3;
                    sQLiteDatabase4 = sQLiteDatabase3;
                    if (sQLiteDatabase4 != null) {
                    }
                    throw th;
                }
            } catch (Exception e13) {
                e2 = e13;
                sQLiteDatabase3 = writableDatabase;
                sQLiteDatabase4 = sQLiteDatabase3;
                bo.a(e2);
                if (sQLiteDatabase4 != null) {
                }
                return false;
            } catch (Throwable th12) {
                th3 = th12;
                sQLiteDatabase3 = writableDatabase;
                th = th3;
                sQLiteDatabase4 = sQLiteDatabase3;
                if (sQLiteDatabase4 != null) {
                }
                throw th;
            }
        } catch (Exception e14) {
            e2 = e14;
            bo.a(e2);
            if (sQLiteDatabase4 != null) {
            }
            return false;
        } catch (Throwable th13) {
            th = th13;
            th = th;
            if (sQLiteDatabase4 != null) {
            }
            throw th;
        }
    }

    private boolean a(aw awVar, boolean z) {
        return !awVar.k && z;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x019a */
    /* JADX DEBUG: Multi-variable search result rejected for r48v0, resolved type: com.bytedance.embedapplog.as */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Throwable, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v19, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r8v26, types: [com.bytedance.embedapplog.ax] */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01fc, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01fd, code lost:
        r8 = r44;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0200, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0201, code lost:
        r8 = r44;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0268 A[SYNTHETIC, Splitter:B:104:0x0268] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0276  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x027b A[SYNTHETIC, Splitter:B:114:0x027b] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0166 A[SYNTHETIC, Splitter:B:40:0x0166] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01a2 A[Catch:{ Exception -> 0x023b, all -> 0x0239 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0200 A[Catch:{ Exception -> 0x023b, all -> 0x0239 }, ExcHandler: Exception (e java.lang.Exception), PHI: r44 r45 
      PHI: (r44v0 android.database.sqlite.SQLiteDatabase) = (r44v1 android.database.sqlite.SQLiteDatabase), (r44v2 android.database.sqlite.SQLiteDatabase) binds: [B:40:0x0166, B:36:0x015f] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r45v8 android.database.Cursor) = (r45v9 android.database.Cursor), (r45v10 android.database.Cursor) binds: [B:40:0x0166, B:36:0x015f] A[DONT_GENERATE, DONT_INLINE], Splitter:B:36:0x015f] */
    /* JADX WARNING: Unknown variable types count: 2 */
    public boolean a(JSONObject jSONObject) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        SQLiteDatabase sQLiteDatabase2;
        Throwable th2;
        Exception e2;
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase3;
        SQLiteDatabase sQLiteDatabase4;
        Throwable th3;
        JSONObject jSONObject2;
        JSONArray a2;
        ?? r8;
        SQLiteDatabase sQLiteDatabase5;
        ba baVar;
        ay ayVar;
        aq[] aqVarArr;
        char c2;
        aw awVar;
        ?? r4;
        String str;
        ContentValues contentValues;
        int i2;
        char c3;
        HashMap<String, aq> hashMap = a;
        aw awVar2 = (aw) hashMap.get("launch");
        ba baVar2 = (ba) hashMap.get("terminate");
        ay ayVar2 = (ay) hashMap.get("page");
        av avVar = (av) hashMap.get("eventv3");
        at atVar = (at) hashMap.get("event");
        au auVar = (au) hashMap.get("event_misc");
        String str2 = "pack";
        ax axVar = (ax) hashMap.get(str2);
        ContentValues contentValues2 = new ContentValues();
        Cursor cursor2 = null;
        try {
            SQLiteDatabase writableDatabase = this.i.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM launch ORDER BY local_time_ms DESC LIMIT 5", null);
                ContentValues contentValues3 = contentValues2;
                long j = Long.MIN_VALUE;
                long j2 = Long.MAX_VALUE;
                JSONObject jSONObject3 = jSONObject;
                while (rawQuery.moveToNext()) {
                    try {
                        awVar2.a(rawQuery);
                        if (TextUtils.equals(awVar2.c, k.c())) {
                            str2 = str2;
                        } else {
                            if (TextUtils.equals(awVar2.i, this.h.d())) {
                                try {
                                    if (awVar2.h == this.h.c()) {
                                        jSONObject2 = jSONObject3;
                                        long j3 = awVar2.a >= j2 ? awVar2.a : j2;
                                        long j4 = awVar2.a <= j ? awVar2.a : j;
                                        a2 = a(awVar2, baVar2, ayVar2, writableDatabase);
                                        aq[] aqVarArr2 = {atVar, avVar, auVar};
                                        JSONArray[] jSONArrayArr = new JSONArray[3];
                                        int a3 = a(aqVarArr2, 0, writableDatabase, awVar2.c, jSONArrayArr);
                                        if (a2.length() <= 0) {
                                            axVar.a(awVar2.a, jSONObject2, null, baVar2, a2, jSONArrayArr[0], jSONArrayArr[1], jSONArrayArr[2]);
                                            contentValues = contentValues3;
                                            sQLiteDatabase5 = writableDatabase;
                                            cursor = rawQuery;
                                            aqVarArr = aqVarArr2;
                                            ayVar = ayVar2;
                                            baVar = baVar2;
                                            awVar = awVar2;
                                            str = str2;
                                            r4 = 0;
                                            c2 = 1;
                                        } else {
                                            awVar2.j = true;
                                            long j5 = awVar2.a;
                                            JSONArray jSONArray = jSONArrayArr[0];
                                            JSONArray jSONArray2 = jSONArrayArr[1];
                                            JSONArray jSONArray3 = jSONArrayArr[2];
                                            contentValues = contentValues3;
                                            r8 = axVar;
                                            sQLiteDatabase5 = writableDatabase;
                                            cursor = rawQuery;
                                            aqVarArr = aqVarArr2;
                                            r4 = 0;
                                            str = str2;
                                            c2 = 1;
                                            ayVar = ayVar2;
                                            baVar = baVar2;
                                            awVar = awVar2;
                                            try {
                                                r8.a(j5, jSONObject2, awVar2, null, null, jSONArray, jSONArray2, jSONArray3);
                                            } catch (Exception e3) {
                                            } catch (Throwable th4) {
                                                th = th4;
                                                sQLiteDatabase3 = sQLiteDatabase5;
                                                cursor2 = cursor;
                                                sQLiteDatabase = sQLiteDatabase3;
                                                if (cursor2 != null) {
                                                }
                                                if (sQLiteDatabase != null) {
                                                }
                                                throw th;
                                            }
                                        }
                                        if (bo.b) {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("packer launch, ");
                                            sb.append(a2.length() <= 0);
                                            sb.append(", sid:");
                                            sb.append(awVar.c);
                                            bo.a(sb.toString(), r4);
                                        }
                                        ContentValues b2 = axVar.b(contentValues);
                                        r8 = sQLiteDatabase5;
                                        r8.insert(str, r4, b2);
                                        i2 = a3;
                                        ContentValues contentValues4 = b2;
                                        String str3 = r4;
                                        while (i2 < 3) {
                                            i2 = a(aqVarArr, i2, r8, awVar.c, jSONArrayArr);
                                            if (jSONArrayArr[0] == null && jSONArrayArr[c2] == null) {
                                                c3 = 2;
                                                if (jSONArrayArr[2] != null) {
                                                    axVar.a(awVar.a, jSONObject2, null, null, null, jSONArrayArr[0], jSONArrayArr[c2], jSONArrayArr[c3]);
                                                    contentValues4 = axVar.b(contentValues4);
                                                    r8.insert(str, str3, contentValues4);
                                                }
                                            } else {
                                                c3 = 2;
                                                axVar.a(awVar.a, jSONObject2, null, null, null, jSONArrayArr[0], jSONArrayArr[c2], jSONArrayArr[c3]);
                                                contentValues4 = axVar.b(contentValues4);
                                                r8.insert(str, str3, contentValues4);
                                            }
                                            awVar = awVar;
                                            str = str;
                                            str3 = str3;
                                        }
                                        str2 = str;
                                        awVar2 = awVar;
                                        jSONObject3 = jSONObject2;
                                        ayVar2 = ayVar;
                                        j2 = j3;
                                        j = j4;
                                        rawQuery = cursor;
                                        baVar2 = baVar;
                                        writableDatabase = r8;
                                        contentValues3 = contentValues4;
                                    }
                                } catch (Exception e4) {
                                    e2 = e4;
                                    sQLiteDatabase2 = writableDatabase;
                                    cursor2 = rawQuery;
                                    try {
                                        bo.a(e2);
                                        if (cursor2 != null) {
                                        }
                                        if (sQLiteDatabase2 != null) {
                                        }
                                        return false;
                                    } catch (Throwable th5) {
                                        th2 = th5;
                                        th = th2;
                                        sQLiteDatabase = sQLiteDatabase2;
                                        if (cursor2 != null) {
                                            cursor2.close();
                                        }
                                        if (sQLiteDatabase != null) {
                                            try {
                                                sQLiteDatabase.endTransaction();
                                            } catch (Exception e5) {
                                                bo.a(e5);
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    sQLiteDatabase = writableDatabase;
                                    cursor2 = rawQuery;
                                    if (cursor2 != null) {
                                    }
                                    if (sQLiteDatabase != null) {
                                    }
                                    throw th;
                                }
                            }
                            JSONObject jSONObject4 = new JSONObject();
                            bp.b(jSONObject4, jSONObject3);
                            jSONObject4.put("app_version", awVar2.i);
                            jSONObject4.put("version_code", awVar2.h);
                            jSONObject2 = jSONObject4;
                            if (awVar2.a >= j2) {
                            }
                            if (awVar2.a <= j) {
                            }
                            a2 = a(awVar2, baVar2, ayVar2, writableDatabase);
                            aq[] aqVarArr2 = {atVar, avVar, auVar};
                            JSONArray[] jSONArrayArr = new JSONArray[3];
                            int a3 = a(aqVarArr2, 0, writableDatabase, awVar2.c, jSONArrayArr);
                            if (a2.length() <= 0) {
                            }
                            if (bo.b) {
                            }
                            ContentValues b2 = axVar.b(contentValues);
                            r8 = sQLiteDatabase5;
                            try {
                                r8.insert(str, r4, b2);
                                i2 = a3;
                                ContentValues contentValues4 = b2;
                                String str3 = r4;
                                while (i2 < 3) {
                                }
                                str2 = str;
                                awVar2 = awVar;
                                jSONObject3 = jSONObject2;
                                ayVar2 = ayVar;
                                j2 = j3;
                                j = j4;
                                rawQuery = cursor;
                                baVar2 = baVar;
                                writableDatabase = r8;
                                contentValues3 = contentValues4;
                            } catch (Exception e6) {
                                e2 = e6;
                                sQLiteDatabase2 = r8;
                                cursor2 = cursor;
                                bo.a(e2);
                                if (cursor2 != null) {
                                }
                                if (sQLiteDatabase2 != null) {
                                }
                                return false;
                            } catch (Throwable th7) {
                                th3 = th7;
                                sQLiteDatabase4 = r8;
                                th = th3;
                                sQLiteDatabase3 = sQLiteDatabase4;
                                cursor2 = cursor;
                                sQLiteDatabase = sQLiteDatabase3;
                                if (cursor2 != null) {
                                }
                                if (sQLiteDatabase != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Exception e7) {
                        e2 = e7;
                        sQLiteDatabase2 = writableDatabase;
                        cursor = rawQuery;
                        cursor2 = cursor;
                        bo.a(e2);
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        if (sQLiteDatabase2 != null) {
                            try {
                                sQLiteDatabase2.endTransaction();
                            } catch (Exception e8) {
                                bo.a(e8);
                            }
                        }
                        return false;
                    } catch (Throwable th8) {
                        th3 = th8;
                        sQLiteDatabase4 = writableDatabase;
                        cursor = rawQuery;
                        th = th3;
                        sQLiteDatabase3 = sQLiteDatabase4;
                        cursor2 = cursor;
                        sQLiteDatabase = sQLiteDatabase3;
                        if (cursor2 != null) {
                        }
                        if (sQLiteDatabase != null) {
                        }
                        throw th;
                    }
                }
                if (!(j2 == Long.MAX_VALUE || j == Long.MIN_VALUE)) {
                    writableDatabase.execSQL("DELETE FROM launch WHERE local_time_ms>=? AND local_time_ms<=?", new String[]{String.valueOf(j2), String.valueOf(j)});
                }
                writableDatabase.setTransactionSuccessful();
                if (rawQuery != null) {
                    rawQuery.close();
                }
                if (writableDatabase != null) {
                    try {
                        writableDatabase.endTransaction();
                    } catch (Exception e9) {
                        bo.a(e9);
                    }
                }
                return true;
            } catch (Exception e10) {
                e2 = e10;
                sQLiteDatabase2 = writableDatabase;
                bo.a(e2);
                if (cursor2 != null) {
                }
                if (sQLiteDatabase2 != null) {
                }
                return false;
            } catch (Throwable th9) {
                th2 = th9;
                sQLiteDatabase2 = writableDatabase;
                th = th2;
                sQLiteDatabase = sQLiteDatabase2;
                if (cursor2 != null) {
                }
                if (sQLiteDatabase != null) {
                }
                throw th;
            }
        } catch (Exception e11) {
            e2 = e11;
            sQLiteDatabase2 = null;
            cursor2 = null;
            bo.a(e2);
            if (cursor2 != null) {
            }
            if (sQLiteDatabase2 != null) {
            }
            return false;
        } catch (Throwable th10) {
            th = th10;
            sQLiteDatabase = null;
            cursor2 = null;
            if (cursor2 != null) {
            }
            if (sQLiteDatabase != null) {
            }
            throw th;
        }
    }

    private int a(aq[] aqVarArr, int i2, SQLiteDatabase sQLiteDatabase, String str, JSONArray[] jSONArrayArr) {
        int i3 = 0;
        while (i3 < i2) {
            jSONArrayArr[i3] = null;
            i3++;
        }
        int i4 = 200;
        while (i4 > 0 && i3 < aqVarArr.length) {
            jSONArrayArr[i3] = a(sQLiteDatabase, aqVarArr[i3], str, i4);
            i4 -= jSONArrayArr[i3].length();
            if (i4 > 0) {
                i3++;
            }
        }
        return i3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0065 A[DONT_GENERATE] */
    private JSONArray a(SQLiteDatabase sQLiteDatabase, aq aqVar, String str, int i2) {
        long j;
        Cursor cursor;
        Throwable th;
        JSONArray jSONArray = new JSONArray();
        long j2 = 0;
        try {
            cursor = sQLiteDatabase.rawQuery(a(aqVar, str, i2), null);
            j = 0;
            while (cursor.moveToNext()) {
                try {
                    aqVar.a(cursor);
                    if (bo.b) {
                        bo.a("queryEvnetInner, " + str + ", " + aqVar, null);
                    }
                    jSONArray.put(aqVar.f());
                    if (aqVar.a > j) {
                        j = aqVar.a;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    j2 = j;
                    try {
                        bo.a(th);
                        j = j2;
                        bo.a("queryEvent, " + aqVar + ", " + jSONArray.length() + ", " + j, null);
                        return jSONArray;
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
            if (j > 0) {
                sQLiteDatabase.execSQL(a(aqVar, str, j));
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            bo.a(th);
            j = j2;
            bo.a("queryEvent, " + aqVar + ", " + jSONArray.length() + ", " + j, null);
            return jSONArray;
        }
        bo.a("queryEvent, " + aqVar + ", " + jSONArray.length() + ", " + j, null);
        return jSONArray;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0059, code lost:
        if (r8 != null) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005b, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0066, code lost:
        if (r8 != null) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006d, code lost:
        if (r3.length() <= 0) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0073, code lost:
        if (r6 <= 1000) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0076, code lost:
        r6 = 1000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0077, code lost:
        r13.h = r6;
        r13.c = r12.c;
        r13.a = r12.a;
        r13.i = (r12.a + r6) / 1000;
        r13.b = com.bytedance.embedapplog.q.a(r11.g);
        r13.e = r12.e;
        r13.f = r12.f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0099, code lost:
        if (com.bytedance.embedapplog.bo.b == false) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009b, code lost:
        com.bytedance.embedapplog.bo.a("queryPage, " + r13 + ", " + r3.length(), null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b9, code lost:
        return r3;
     */
    private JSONArray a(aw awVar, ba baVar, ay ayVar, SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        Cursor cursor;
        boolean z = false;
        String[] strArr = {awVar.c};
        JSONArray jSONArray = new JSONArray();
        long j = 0;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT * FROM page WHERE session_id=? LIMIT 500", strArr);
            while (cursor.moveToNext()) {
                try {
                    ayVar.a(cursor);
                    if (bo.b) {
                        bo.a("queryPageInner, " + strArr + ", " + ayVar, null);
                    }
                    if (ayVar.i()) {
                        jSONArray.put(ayVar.f());
                    } else {
                        j += ayVar.h;
                    }
                    z = true;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        bo.a(th);
                    } catch (Throwable th3) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th3;
                    }
                }
            }
            if (z) {
                sQLiteDatabase.execSQL("DELETE FROM page WHERE session_id=?", strArr);
            }
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
            bo.a(th);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003e, code lost:
        com.bytedance.embedapplog.bo.a("queryPack, " + r0.size() + ", " + r0, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005e, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002f, code lost:
        if (r3 != null) goto L_0x003b;
     */
    public ArrayList<ax> a() {
        Cursor cursor;
        Throwable th;
        ArrayList<ax> arrayList = new ArrayList<>();
        ax axVar = (ax) a.get("pack");
        try {
            cursor = this.i.getWritableDatabase().rawQuery("SELECT * FROM pack ORDER BY local_time_ms DESC,_full DESC LIMIT 2", null);
            while (cursor.moveToNext()) {
                try {
                    axVar = (ax) axVar.clone();
                    axVar.a(cursor);
                    arrayList.add(axVar);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        bo.a(th);
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            bo.a(th);
        }
    }

    public void a(ArrayList<ax> arrayList, ArrayList<ax> arrayList2) {
        SQLiteDatabase sQLiteDatabase = null;
        bo.a("setResult, " + arrayList + ", " + arrayList2, null);
        HashMap<String, Integer> hashMap = new HashMap<>();
        HashMap hashMap2 = new HashMap();
        HashMap<String, Integer> hashMap3 = new HashMap<>();
        HashMap<String, Integer> hashMap4 = new HashMap<>();
        HashMap<String, Integer> hashMap5 = new HashMap<>();
        if (arrayList != null && arrayList.size() > 0) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (arrayList.get(i2).i == 0) {
                    a(arrayList.get(i2), hashMap, true);
                } else {
                    a(arrayList.get(i2), hashMap4, false);
                }
            }
        }
        Iterator<ax> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            ax next = it2.next();
            if (next.i == 0) {
                HashMap<String, Integer> hashMap6 = (HashMap) hashMap2.get(Integer.valueOf(next.j));
                if (hashMap6 == null) {
                    hashMap6 = new HashMap<>();
                    hashMap2.put(Integer.valueOf(next.j), hashMap6);
                }
                a(next, hashMap6, false);
            } else if (((long) (next.i + 1)) > 5) {
                a(next, hashMap3, false);
                arrayList.add(next);
                it2.remove();
            } else {
                a(next, hashMap5, false);
            }
        }
        try {
            SQLiteDatabase writableDatabase = this.i.getWritableDatabase();
            writableDatabase.beginTransaction();
            Iterator<ax> it3 = arrayList.iterator();
            while (it3.hasNext()) {
                writableDatabase.execSQL("DELETE FROM pack WHERE local_time_ms=?", new String[]{String.valueOf(it3.next().a)});
            }
            Iterator<ax> it4 = arrayList2.iterator();
            while (it4.hasNext()) {
                ax next2 = it4.next();
                long j = next2.a;
                int i3 = next2.i + 1;
                next2.i = i3;
                writableDatabase.execSQL(a(j, i3));
            }
            writableDatabase.setTransactionSuccessful();
            if (writableDatabase != null) {
                try {
                    writableDatabase.endTransaction();
                } catch (Exception e2) {
                    bo.a(e2);
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e3) {
                    bo.a(e3);
                }
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    public void a(ArrayList<aq> arrayList) {
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        bo.a("save, " + arrayList.toString(), null);
        try {
            sQLiteDatabase = this.i.getWritableDatabase();
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<aq> it2 = arrayList.iterator();
                ContentValues contentValues = null;
                while (it2.hasNext()) {
                    aq next = it2.next();
                    String d2 = next.d();
                    contentValues = next.b(contentValues);
                    sQLiteDatabase.insert(d2, null, contentValues);
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                        return;
                    } catch (Throwable th2) {
                        bo.a(th2);
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    b += arrayList.size();
                    bo.a(th);
                    if (sQLiteDatabase == null) {
                        sQLiteDatabase.endTransaction();
                        return;
                    }
                    return;
                } catch (Throwable th4) {
                    bo.a(th4);
                }
            }
        } catch (Throwable th5) {
            th = th5;
            sQLiteDatabase = null;
            b += arrayList.size();
            bo.a(th);
            if (sQLiteDatabase == null) {
            }
        }
        throw th;
    }

    static class a extends SQLiteOpenHelper {
        a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(context, str, cursorFactory, i);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.beginTransaction();
                for (aq aqVar : as.a.values()) {
                    String c = aqVar.c();
                    if (c != null) {
                        sQLiteDatabase.execSQL(c);
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e) {
                    bo.a(e);
                }
            } catch (Throwable th) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e2) {
                    bo.a(e2);
                }
                throw th;
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            bo.d("onUpgrade, " + i + ", " + i2, null);
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<aq> it2 = as.a.values().iterator();
                while (it2.hasNext()) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + it2.next().d());
                }
                sQLiteDatabase.setTransactionSuccessful();
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e) {
                    bo.a(e);
                }
            } catch (Throwable th) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e2) {
                    bo.a(e2);
                }
                throw th;
            }
            onCreate(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            onUpgrade(sQLiteDatabase, i, i2);
        }
    }
}
