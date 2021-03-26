package com.qq.e.comm.managers.setting;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.comm.util.SystemUtil;
import java.io.File;
import java.io.FileWriter;
import org.json.JSONException;
import org.json.JSONObject;

class e {
    protected JSONObject a;

    static class a<T> {
        private final String a;
        private final T b;

        private a(String str, T t) {
            this.a = str;
            this.b = t;
        }

        /* synthetic */ a(String str, Object obj, byte b2) {
            this(str, obj);
        }

        public final String a() {
            return this.a;
        }

        public final T b() {
            return this.b;
        }
    }

    e() {
        this(null);
    }

    e(String str) {
        String simpleName = getClass().getSimpleName();
        GDTLogger.d("Initialize " + simpleName + ",Json=" + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                this.a = new JSONObject(str);
            } catch (JSONException e) {
                GDTLogger.e("JsonException While build" + simpleName + " Instance from JSON", e);
            }
        }
        if (this.a == null) {
            this.a = new JSONObject();
        }
    }

    private static Pair<String, String> a(Context context, String str) {
        File dir = context.getDir(SystemUtil.buildNewPathByProcessName("e_qq_com_setting"), 0);
        if (!dir.exists()) {
            return null;
        }
        File file = new File(dir, str + ".sig");
        File file2 = new File(dir, str + ".cfg");
        if (file.exists() && file2.exists()) {
            try {
                String readAll = StringUtil.readAll(file);
                String readAll2 = StringUtil.readAll(file2);
                if (!TextUtils.isEmpty(readAll) && !TextUtils.isEmpty(readAll2) && com.qq.e.comm.util.a.a().a(readAll, readAll2)) {
                    return new Pair<>(readAll, new String(Base64.decode(readAll2, 0), "UTF-8"));
                }
                GDTLogger.e("verify " + str + " setting fail");
            } catch (Exception e) {
                GDTLogger.e("exception while loading local " + str, e);
            }
        }
        return null;
    }

    static a<a> a(Context context) {
        Pair<String, String> a2 = a(context, "devCloudSetting");
        if (a2 == null) {
            return null;
        }
        return new a<>((String) a2.first, new a((String) a2.second), (byte) 0);
    }

    static boolean a(Context context, String str, String str2) {
        return a(context, "sdkCloudSetting", str, str2);
    }

    private static final boolean a(Context context, String str, String str2, String str3) {
        String format;
        if (StringUtil.isEmpty(str2) || StringUtil.isEmpty(str3)) {
            format = String.format("Fail to update Cloud setting due to sig or setting is empty,name=%s\tsig=%s\tsetting=%s", str, str2, str3);
        } else if (com.qq.e.comm.util.a.a().a(str2, str3)) {
            return b(context, str, str2, str3);
        } else {
            format = String.format("Fail to update Cloud setting due to sig verify fail,name=%s\tsig=%s\tsetting=%s", str, str2, str3);
        }
        GDTLogger.e(format);
        return false;
    }

    static a<d> b(Context context) {
        Pair<String, String> a2 = a(context, "sdkCloudSetting");
        if (a2 == null) {
            return null;
        }
        return new a<>((String) a2.first, new d((String) a2.second), (byte) 0);
    }

    static boolean b(Context context, String str, String str2) {
        return a(context, "devCloudSetting", str, str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0070 A[SYNTHETIC, Splitter:B:27:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0075 A[Catch:{ Exception -> 0x0078 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007f A[SYNTHETIC, Splitter:B:36:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0084 A[Catch:{ Exception -> 0x0087 }] */
    private static boolean b(Context context, String str, String str2, String str3) {
        FileWriter fileWriter;
        FileWriter fileWriter2;
        Throwable th;
        File dir = context.getDir(SystemUtil.buildNewPathByProcessName("e_qq_com_setting"), 0);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(dir, str + ".cfg");
        File file2 = new File(dir, str + ".sig");
        FileWriter fileWriter3 = null;
        try {
            fileWriter2 = new FileWriter(file);
            try {
                fileWriter2.write(str3);
                fileWriter = new FileWriter(file2);
                try {
                    fileWriter.write(str2);
                    try {
                        fileWriter2.close();
                        fileWriter.close();
                        return true;
                    } catch (Exception unused) {
                        return true;
                    }
                } catch (Exception unused2) {
                    fileWriter3 = fileWriter2;
                    try {
                        file.delete();
                        file2.delete();
                        if (fileWriter3 != null) {
                            try {
                                fileWriter3.close();
                            } catch (Exception unused3) {
                                return false;
                            }
                        }
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        fileWriter2 = fileWriter3;
                        th = th2;
                        if (fileWriter2 != null) {
                        }
                        if (fileWriter != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (fileWriter2 != null) {
                        try {
                            fileWriter2.close();
                        } catch (Exception unused4) {
                            throw th;
                        }
                    }
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                    throw th;
                }
            } catch (Exception unused5) {
                fileWriter = null;
                fileWriter3 = fileWriter2;
                file.delete();
                file2.delete();
                if (fileWriter3 != null) {
                }
                if (fileWriter != null) {
                }
                return false;
            } catch (Throwable th4) {
                fileWriter = null;
                th = th4;
                if (fileWriter2 != null) {
                }
                if (fileWriter != null) {
                }
                throw th;
            }
        } catch (Exception unused6) {
            fileWriter = null;
            file.delete();
            file2.delete();
            if (fileWriter3 != null) {
            }
            if (fileWriter != null) {
            }
            return false;
        } catch (Throwable th5) {
            fileWriter = null;
            th = th5;
            fileWriter2 = null;
            if (fileWriter2 != null) {
            }
            if (fileWriter != null) {
            }
            throw th;
        }
    }

    static a<c> c(Context context) {
        Pair<String, String> a2 = a(context, "placementCloudSetting");
        if (a2 == null) {
            return null;
        }
        return new a<>((String) a2.first, new c((String) a2.second), (byte) 0);
    }

    static boolean c(Context context, String str, String str2) {
        return a(context, "placementCloudSetting", str, str2);
    }

    static void d(Context context) {
        File dir = context.getDir(SystemUtil.buildNewPathByProcessName("e_qq_com_setting"), 0);
        if (dir.exists()) {
            File file = new File(dir, "placementCloudSetting.cfg");
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(dir, "placementCloudSetting.sig");
            if (file2.exists()) {
                file2.delete();
            }
        }
    }
}
