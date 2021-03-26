package com.xiaomi.push;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class fl {
    private static fl a;
    private Map<String, Object> b = new ConcurrentHashMap();
    private Map<String, Object> c = new ConcurrentHashMap();

    private fl() {
        b();
    }

    public static synchronized fl a() {
        fl flVar;
        synchronized (fl.class) {
            if (a == null) {
                a = new fl();
            }
            flVar = a;
        }
        return flVar;
    }

    private String b(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(str);
        sb.append("/>");
        if (str != null) {
            sb.append("<");
            sb.append(str2);
            sb.append("/>");
        }
        return sb.toString();
    }

    private ClassLoader[] c() {
        ClassLoader[] classLoaderArr = {fl.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 2; i++) {
            ClassLoader classLoader = classLoaderArr[i];
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }

    public Object a(String str, String str2) {
        return this.b.get(b(str, str2));
    }

    public void a(String str, String str2, Object obj) {
        if ((obj instanceof fk) || (obj instanceof Class)) {
            this.b.put(b(str, str2), obj);
            return;
        }
        throw new IllegalArgumentException("Provider must be a PacketExtensionProvider or a Class instance.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f6 A[SYNTHETIC, Splitter:B:42:0x00f6] */
    protected void b() {
        Map<String, Object> map;
        Object obj;
        Map<String, Object> map2;
        Object obj2;
        try {
            for (ClassLoader classLoader : c()) {
                Enumeration<URL> resources = classLoader.getResources("META-INF/smack.providers");
                while (resources.hasMoreElements()) {
                    InputStream inputStream = null;
                    try {
                        InputStream openStream = resources.nextElement().openStream();
                        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                        newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                        newPullParser.setInput(openStream, "UTF-8");
                        int eventType = newPullParser.getEventType();
                        do {
                            if (eventType == 2) {
                                if (newPullParser.getName().equals("iqProvider")) {
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText = newPullParser.nextText();
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText2 = newPullParser.nextText();
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText3 = newPullParser.nextText();
                                    String b2 = b(nextText, nextText2);
                                    if (!this.c.containsKey(b2)) {
                                        try {
                                            Class<?> cls = Class.forName(nextText3);
                                            if (fj.class.isAssignableFrom(cls)) {
                                                map2 = this.c;
                                                obj2 = cls.newInstance();
                                            } else if (fc.class.isAssignableFrom(cls)) {
                                                map2 = this.c;
                                                obj2 = cls;
                                            }
                                            map2.put(b2, obj2 == 1 ? 1 : 0);
                                        } catch (ClassNotFoundException e) {
                                            e = e;
                                            e.printStackTrace();
                                            eventType = newPullParser.next();
                                            if (eventType == 1) {
                                            }
                                        }
                                    }
                                } else if (newPullParser.getName().equals("extensionProvider")) {
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText4 = newPullParser.nextText();
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText5 = newPullParser.nextText();
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText6 = newPullParser.nextText();
                                    String b3 = b(nextText4, nextText5);
                                    if (!this.b.containsKey(b3)) {
                                        try {
                                            Class<?> cls2 = Class.forName(nextText6);
                                            if (fk.class.isAssignableFrom(cls2)) {
                                                map = this.b;
                                                obj = cls2.newInstance();
                                            } else if (ff.class.isAssignableFrom(cls2)) {
                                                map = this.b;
                                                obj = cls2;
                                            }
                                            map.put(b3, obj == 1 ? 1 : 0);
                                        } catch (ClassNotFoundException e2) {
                                            e = e2;
                                            e.printStackTrace();
                                            eventType = newPullParser.next();
                                            if (eventType == 1) {
                                            }
                                        }
                                    }
                                }
                            }
                            eventType = newPullParser.next();
                        } while (eventType == 1);
                    } finally {
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
