package com.kepler.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class a {
    private static Class<AssetManager> a = AssetManager.class;
    private static Method b;

    static {
        try {
            b = AssetManager.class.getDeclaredMethod("addAssetPath", String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static Resources a(Context context, String str) {
        ApplicationInfo applicationInfo;
        Resources resources = null;
        if (!a(str)) {
            return null;
        }
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 0);
        if (packageArchiveInfo == null) {
            applicationInfo = null;
        } else {
            applicationInfo = packageArchiveInfo.applicationInfo;
        }
        if (applicationInfo != null) {
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            try {
                resources = context.getPackageManager().getResourcesForApplication(applicationInfo);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return resources != null ? resources : c(context, str);
    }

    private static Resources c(Context context, String str) {
        if (a == null || b == null || !a(str)) {
            return null;
        }
        try {
            AssetManager newInstance = a.newInstance();
            b.invoke(newInstance, str);
            return new Resources(newInstance, context.getResources().getDisplayMetrics(), context.getResources().getConfiguration());
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static PackageInfo b(Context context, String str) {
        return a(context, str, 0);
    }

    public static PackageInfo a(Context context, String str, int i) {
        PackageInfo packageArchiveInfo;
        if (!a(str) || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, i)) == null) {
            return null;
        }
        if ((i & 64) != 0 && packageArchiveInfo.signatures == null) {
            packageArchiveInfo.signatures = C0081a.a(str);
        }
        return packageArchiveInfo;
    }

    private static boolean a(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        return true;
    }

    /* renamed from: com.kepler.sdk.a$a  reason: collision with other inner class name */
    public static class C0081a {
        public static final String[] a = {"AndroidManifest.xml"};
        public static final String[] b = {"AndroidManifest.xml", "classes.dex"};
        private static final Object c = new Object();
        private static WeakReference<byte[]> d;

        public static Signature[] a(String str) {
            return a(str, false);
        }

        public static Signature[] a(String str, boolean z) {
            return a(str, z ? b : null);
        }

        public static Signature[] a(String str, String... strArr) {
            WeakReference<byte[]> weakReference;
            byte[] bArr;
            JarEntry nextElement;
            boolean z;
            if (!b(str)) {
                return null;
            }
            synchronized (c) {
                weakReference = d;
                if (weakReference != null) {
                    d = null;
                    bArr = weakReference.get();
                } else {
                    bArr = null;
                }
                if (bArr == null) {
                    bArr = new byte[8192];
                    weakReference = new WeakReference<>(bArr);
                }
            }
            try {
                JarFile jarFile = new JarFile(str);
                Enumeration<JarEntry> a2 = a(jarFile, strArr);
                Certificate[] certificateArr = null;
                loop0:
                while (true) {
                    if (a2.hasMoreElements()) {
                        nextElement = a2.nextElement();
                        if (nextElement != null) {
                            if (!nextElement.isDirectory()) {
                                if (!nextElement.getName().startsWith("META-INF/")) {
                                    Certificate[] a3 = a(jarFile, nextElement, bArr);
                                    if (a3 == null) {
                                        Log.e("Certificates", "File " + str + " has no certificates at entry " + nextElement.getName() + "; ignoring!");
                                        jarFile.close();
                                        return null;
                                    } else if (certificateArr == null) {
                                        certificateArr = a3;
                                    } else {
                                        for (int i = 0; i < certificateArr.length; i++) {
                                            int i2 = 0;
                                            while (true) {
                                                if (i2 >= a3.length) {
                                                    z = false;
                                                    break;
                                                }
                                                if (certificateArr[i] != null && certificateArr[i].equals(a3[i2])) {
                                                    z = true;
                                                    break;
                                                }
                                                i2++;
                                            }
                                            if (!z) {
                                                break loop0;
                                            } else if (certificateArr.length != a3.length) {
                                                break loop0;
                                            }
                                        }
                                        continue;
                                    }
                                }
                            }
                        }
                    } else {
                        jarFile.close();
                        synchronized (c) {
                            d = weakReference;
                        }
                        if (certificateArr == null || certificateArr.length <= 0) {
                            Log.e("Certificates", "File " + str + " has no certificates; ignoring!");
                            return null;
                        }
                        int length = certificateArr.length;
                        Signature[] signatureArr = new Signature[certificateArr.length];
                        for (int i3 = 0; i3 < length; i3++) {
                            signatureArr[i3] = new Signature(certificateArr[i3].getEncoded());
                        }
                        return signatureArr;
                    }
                }
                Log.e("Certificates", "File " + str + " has mismatched certificates at entry " + nextElement.getName() + "; ignoring!");
                jarFile.close();
                return null;
            } catch (CertificateEncodingException e) {
                Log.w("Certificates", "Exception reading " + str, e);
                return null;
            } catch (IOException e2) {
                Log.w("Certificates", "Exception reading " + str, e2);
                return null;
            } catch (RuntimeException e3) {
                Log.w("Certificates", "Exception reading " + str, e3);
                return null;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0073 A[SYNTHETIC, Splitter:B:23:0x0073] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00a2 A[SYNTHETIC, Splitter:B:31:0x00a2] */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00cc A[SYNTHETIC, Splitter:B:40:0x00cc] */
        private static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
            Throwable th;
            Exception e;
            StringBuilder sb;
            IOException e2;
            BufferedInputStream bufferedInputStream;
            RuntimeException e3;
            BufferedInputStream bufferedInputStream2 = null;
            Certificate[] certificateArr = null;
            try {
                bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
                while (bufferedInputStream.read(bArr, 0, bArr.length) != -1) {
                    try {
                    } catch (IOException e4) {
                        e2 = e4;
                        Log.w("Certificates", "Exception reading " + jarEntry.getName() + " in " + jarFile.getName(), e2);
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e5) {
                                e = e5;
                                sb = new StringBuilder();
                            }
                        }
                        return null;
                    } catch (RuntimeException e6) {
                        e3 = e6;
                        try {
                            Log.w("Certificates", "Exception reading " + jarEntry.getName() + " in " + jarFile.getName(), e3);
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (Exception e7) {
                                    e = e7;
                                    sb = new StringBuilder();
                                }
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedInputStream2 = bufferedInputStream;
                            if (bufferedInputStream2 != null) {
                            }
                            throw th;
                        }
                    }
                }
                if (jarEntry != null) {
                    certificateArr = jarEntry.getCertificates();
                }
                try {
                    bufferedInputStream.close();
                } catch (Exception e8) {
                    Log.w("Certificates", "Close IS Exception" + jarEntry.getName() + " in " + jarFile.getName(), e8);
                }
                return certificateArr;
                sb.append("Close IS Exception");
                sb.append(jarEntry.getName());
                sb.append(" in ");
                sb.append(jarFile.getName());
                Log.w("Certificates", sb.toString(), e);
                return null;
            } catch (IOException e9) {
                e2 = e9;
                bufferedInputStream = null;
                Log.w("Certificates", "Exception reading " + jarEntry.getName() + " in " + jarFile.getName(), e2);
                if (bufferedInputStream != null) {
                }
                return null;
            } catch (RuntimeException e10) {
                e3 = e10;
                bufferedInputStream = null;
                Log.w("Certificates", "Exception reading " + jarEntry.getName() + " in " + jarFile.getName(), e3);
                if (bufferedInputStream != null) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e11) {
                        Log.w("Certificates", "Close IS Exception" + jarEntry.getName() + " in " + jarFile.getName(), e11);
                    }
                }
                throw th;
            }
        }

        private static boolean b(String str) {
            if (str == null || str.length() == 0) {
                return false;
            }
            File file = new File(str);
            if (!file.exists() || !file.isFile()) {
                return false;
            }
            return true;
        }

        private static Enumeration<JarEntry> a(JarFile jarFile, String... strArr) {
            if (strArr == null || strArr.length == 0) {
                return jarFile.entries();
            }
            return new C0082a(jarFile, strArr);
        }

        /* renamed from: com.kepler.sdk.a$a$a  reason: collision with other inner class name */
        static class C0082a implements Enumeration<JarEntry> {
            private final JarFile a;
            private final String[] b;
            private int c = 0;

            public C0082a(JarFile jarFile, String... strArr) {
                this.a = jarFile;
                this.b = strArr;
            }

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return this.c < this.b.length;
            }

            /* renamed from: a */
            public JarEntry nextElement() {
                JarFile jarFile = this.a;
                String[] strArr = this.b;
                int i = this.c;
                this.c = i + 1;
                return jarFile.getJarEntry(strArr[i]);
            }
        }
    }
}
