package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.service.ag;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class bz {
    private static String b = "/MiPushLog";
    private final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String c;
    private String d;
    private boolean e;
    private int f;
    private int g = 2097152;
    private ArrayList<File> h = new ArrayList<>();

    bz() {
    }

    private void a(BufferedReader bufferedReader, BufferedWriter bufferedWriter, Pattern pattern) {
        char[] cArr = new char[4096];
        int read = bufferedReader.read(cArr);
        boolean z = false;
        while (read != -1 && !z) {
            String str = new String(cArr, 0, read);
            Matcher matcher = pattern.matcher(str);
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= read || !matcher.find(i)) {
                    break;
                }
                int start = matcher.start();
                String substring = str.substring(start, this.c.length() + start);
                if (this.e) {
                    if (substring.compareTo(this.d) > 0) {
                        read = start;
                        z = true;
                        break;
                    }
                } else if (substring.compareTo(this.c) >= 0) {
                    this.e = true;
                    i2 = start;
                }
                int indexOf = str.indexOf(10, start);
                if (indexOf == -1) {
                    indexOf = this.c.length();
                }
                i = start + indexOf;
            }
            if (this.e) {
                int i3 = read - i2;
                this.f += i3;
                bufferedWriter.write(cArr, i2, i3);
                if (z || this.f > this.g) {
                    return;
                }
            }
            read = bufferedReader.read(cArr);
        }
    }

    private void b(File file) {
        Throwable th;
        BufferedReader bufferedReader;
        String str;
        FileNotFoundException e2;
        IOException e3;
        Pattern compile = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        BufferedReader bufferedReader2 = null;
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            try {
                bufferedWriter.write("model :" + Build.MODEL + "; os :" + Build.VERSION.INCREMENTAL + "; uid :" + ag.e() + "; lng :" + Locale.getDefault().toString() + "; sdk :39; andver :" + Build.VERSION.SDK_INT + "\n");
                this.f = 0;
                Iterator<File> it2 = this.h.iterator();
                while (it2.hasNext()) {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(it2.next())));
                    try {
                        a(bufferedReader, bufferedWriter, compile);
                        bufferedReader.close();
                        bufferedReader2 = bufferedReader;
                    } catch (FileNotFoundException e4) {
                        e2 = e4;
                        bufferedReader2 = bufferedWriter;
                        str = "LOG: filter error = " + e2.getMessage();
                        c.c(str);
                        jg.a(bufferedReader2);
                        jg.a(bufferedReader);
                    } catch (IOException e5) {
                        e3 = e5;
                        bufferedReader2 = bufferedWriter;
                        str = "LOG: filter error = " + e3.getMessage();
                        c.c(str);
                        jg.a(bufferedReader2);
                        jg.a(bufferedReader);
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedWriter;
                        jg.a(bufferedReader2);
                        jg.a(bufferedReader);
                        throw th;
                    }
                }
                bufferedWriter.write(bq.a().e());
                jg.a(bufferedWriter);
                jg.a(bufferedReader2);
            } catch (FileNotFoundException e6) {
                e2 = e6;
                bufferedReader = null;
                bufferedReader2 = bufferedWriter;
                str = "LOG: filter error = " + e2.getMessage();
                c.c(str);
                jg.a(bufferedReader2);
                jg.a(bufferedReader);
            } catch (IOException e7) {
                e3 = e7;
                bufferedReader = null;
                bufferedReader2 = bufferedWriter;
                str = "LOG: filter error = " + e3.getMessage();
                c.c(str);
                jg.a(bufferedReader2);
                jg.a(bufferedReader);
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                bufferedReader2 = bufferedWriter;
                jg.a(bufferedReader2);
                jg.a(bufferedReader);
                throw th;
            }
        } catch (FileNotFoundException e8) {
            e2 = e8;
            bufferedReader = null;
            str = "LOG: filter error = " + e2.getMessage();
            c.c(str);
            jg.a(bufferedReader2);
            jg.a(bufferedReader);
        } catch (IOException e9) {
            e3 = e9;
            bufferedReader = null;
            str = "LOG: filter error = " + e3.getMessage();
            c.c(str);
            jg.a(bufferedReader2);
            jg.a(bufferedReader);
        } catch (Throwable th4) {
            th = th4;
            jg.a(bufferedReader2);
            jg.a(bufferedReader);
            throw th;
        }
    }

    bz a(File file) {
        if (file.exists()) {
            this.h.add(file);
        }
        return this;
    }

    bz a(Date date, Date date2) {
        String str;
        if (date.after(date2)) {
            this.c = this.a.format(date2);
            str = this.a.format(date);
        } else {
            this.c = this.a.format(date);
            str = this.a.format(date2);
        }
        this.d = str;
        return this;
    }

    File a(Context context, Date date, Date date2, File file) {
        File file2;
        if ("com.xiaomi.xmsf".equalsIgnoreCase(context.getPackageName())) {
            file2 = context.getFilesDir();
            a(new File(file2, "xmsf.log.1"));
            a(new File(file2, "xmsf.log"));
        } else {
            File file3 = new File(context.getExternalFilesDir(null) + b);
            a(new File(file3, "log0.txt"));
            a(new File(file3, "log1.txt"));
            file2 = file3;
        }
        if (!file2.isDirectory()) {
            return null;
        }
        File file4 = new File(file, date.getTime() + "-" + date2.getTime() + ".zip");
        if (file4.exists()) {
            return null;
        }
        a(date, date2);
        long currentTimeMillis = System.currentTimeMillis();
        File file5 = new File(file, "log.txt");
        b(file5);
        c.c("LOG: filter cost = " + (System.currentTimeMillis() - currentTimeMillis));
        if (file5.exists()) {
            long currentTimeMillis2 = System.currentTimeMillis();
            jg.a(file4, file5);
            c.c("LOG: zip cost = " + (System.currentTimeMillis() - currentTimeMillis2));
            file5.delete();
            if (file4.exists()) {
                return file4;
            }
        }
        return null;
    }

    void a(int i) {
        if (i != 0) {
            this.g = i;
        }
    }
}
