package com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.net.NetworkCallBack;
import com.qq.e.comm.net.NetworkClient;
import com.qq.e.comm.net.NetworkClientImpl;
import com.qq.e.comm.net.rr.PlainRequest;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.util.FileUtil;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b {
    private static final Pattern a = Pattern.compile(".*plugin\\.dex-(\\d+)\\.jar.*");
    private final Context b;
    private PM.a.b c;
    private Executor d;

    class a implements NetworkCallBack {
        private final String a;
        private final int b;

        public a(String str, int i) {
            this.a = str;
            this.b = i;
        }

        private static String a(Response response, File file) {
            Throwable th;
            FileOutputStream fileOutputStream;
            InputStream inputStream;
            Throwable e;
            String str;
            InputStream inputStream2 = null;
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                inputStream = response.getStreamContent();
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e2) {
                    e = e2;
                    fileOutputStream = null;
                    str = "IOException While Update Plugin";
                    try {
                        GDTLogger.e(str, e);
                        FileUtil.tryClose(inputStream);
                        FileUtil.tryClose(fileOutputStream);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream2 = inputStream;
                        FileUtil.tryClose(inputStream2);
                        FileUtil.tryClose(fileOutputStream);
                        throw th;
                    }
                } catch (NoSuchAlgorithmException e3) {
                    e = e3;
                    fileOutputStream = null;
                    str = "MD5SUMException While Update Plugin";
                    GDTLogger.e(str, e);
                    FileUtil.tryClose(inputStream);
                    FileUtil.tryClose(fileOutputStream);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                    inputStream2 = inputStream;
                    FileUtil.tryClose(inputStream2);
                    FileUtil.tryClose(fileOutputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            instance.update(bArr, 0, read);
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            FileUtil.tryClose(inputStream);
                            FileUtil.tryClose(fileOutputStream);
                            String byteArrayToHexString = Md5Util.byteArrayToHexString(instance.digest());
                            FileUtil.tryClose(inputStream);
                            FileUtil.tryClose(fileOutputStream);
                            return byteArrayToHexString;
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    str = "IOException While Update Plugin";
                    GDTLogger.e(str, e);
                    FileUtil.tryClose(inputStream);
                    FileUtil.tryClose(fileOutputStream);
                    return null;
                } catch (NoSuchAlgorithmException e5) {
                    e = e5;
                    str = "MD5SUMException While Update Plugin";
                    GDTLogger.e(str, e);
                    FileUtil.tryClose(inputStream);
                    FileUtil.tryClose(fileOutputStream);
                    return null;
                }
            } catch (IOException e6) {
                e = e6;
                inputStream = null;
                fileOutputStream = null;
                str = "IOException While Update Plugin";
                GDTLogger.e(str, e);
                FileUtil.tryClose(inputStream);
                FileUtil.tryClose(fileOutputStream);
                return null;
            } catch (NoSuchAlgorithmException e7) {
                e = e7;
                inputStream = null;
                fileOutputStream = null;
                str = "MD5SUMException While Update Plugin";
                GDTLogger.e(str, e);
                FileUtil.tryClose(inputStream);
                FileUtil.tryClose(fileOutputStream);
                return null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                FileUtil.tryClose(inputStream2);
                FileUtil.tryClose(fileOutputStream);
                throw th;
            }
        }

        private void a() {
            if (b.this.c != null) {
                b.this.c.b();
            }
        }

        private boolean a(File file) {
            try {
                StringUtil.writeTo(this.b + "#####" + this.a, file);
                return true;
            } catch (IOException e) {
                GDTLogger.e("IOException While Update Plugin", e);
                return false;
            }
        }

        @Override // com.qq.e.comm.net.NetworkCallBack
        public final void onException(Exception exc) {
            GDTLogger.w("Exception While Update Plugin", exc);
            a();
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0078 A[Catch:{ all -> 0x00a0, all -> 0x00c5 }] */
        @Override // com.qq.e.comm.net.NetworkCallBack
        public final void onResponse(Request request, Response response) {
            StringBuilder sb;
            if (response.getStatusCode() == 200) {
                try {
                    File c2 = d.c(b.this.b);
                    File f = d.f(b.this.b);
                    String a2 = a(response, c2);
                    boolean z = true;
                    if (com.qq.e.comm.util.a.a().b(this.a, a2)) {
                        if (a(f)) {
                            if (FileUtil.renameTo(c2, d.d(b.this.b)) && FileUtil.renameTo(f, d.g(b.this.b))) {
                                GDTLogger.d("PluginUpdateSucc:" + z);
                                if (b.this.c != null) {
                                    b.this.c.a();
                                }
                            }
                        }
                        z = false;
                        GDTLogger.d("PluginUpdateSucc:" + z);
                        if (b.this.c != null) {
                        }
                    } else {
                        c2.delete();
                        GDTLogger.report(String.format("Fail to update plugin while verifying,sig=%s,md5=%s", this.a, a2));
                        a();
                    }
                    sb = new StringBuilder("TIMESTAMP_AFTER_DOWNPLUGIN:");
                } catch (Throwable th) {
                    GDTLogger.d("TIMESTAMP_AFTER_DOWNPLUGIN:" + System.nanoTime() + ";sig=" + this.a);
                    throw th;
                }
                sb.append(System.nanoTime());
                sb.append(";sig=");
                sb.append(this.a);
                GDTLogger.d(sb.toString());
                return;
            }
            GDTLogger.report("DownLoad Plugin Jar Status error,response status code=" + response.getStatusCode());
            a();
        }
    }

    public b(Context context, Executor executor) {
        this.b = context.getApplicationContext();
        this.d = executor;
    }

    public final void a(PM.a.b bVar) {
        this.c = bVar;
    }

    public final void a(String str, String str2) {
        if (!StringUtil.isEmpty(str) && !StringUtil.isEmpty(str2)) {
            Matcher matcher = a.matcher(str2);
            boolean z = true;
            int parseInteger = StringUtil.parseInteger(matcher.matches() ? matcher.group(1) : "0", 0);
            if (parseInteger < 1203) {
                GDTLogger.i("online plugin version is smaller than asset plugin version" + parseInteger + ",1203.download give up");
                z = false;
            }
            if (z) {
                GDTLogger.d("TIMESTAP_BEFORE_OWN_PLUGIN:" + System.nanoTime());
                NetworkClientImpl.getInstance().submit(new PlainRequest(str2, Request.Method.GET, (byte[]) null), NetworkClient.Priority.High, new a(str, parseInteger), this.d);
            }
        }
    }
}
