package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.fx;
import com.xiaomi.push.gb;
import com.xiaomi.push.gd;
import com.xiaomi.push.service.as;
import com.xiaomi.push.service.bb;
import com.xiaomi.push.service.e;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class gh {
    private static XmlPullParser a;

    public static fw a(String str, String str2, XmlPullParser xmlPullParser) {
        Object a2 = gg.a().m365a("all", "xm:chat");
        if (a2 == null || !(a2 instanceof e)) {
            return null;
        }
        return ((e) a2).b(xmlPullParser);
    }

    public static fx a(XmlPullParser xmlPullParser, fi fiVar) {
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "to");
        String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        fx.a a2 = fx.a.a(xmlPullParser.getAttributeValue("", "type"));
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            hashMap.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
        }
        fx fxVar = null;
        gd gdVar = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("error")) {
                    gdVar = m369a(xmlPullParser);
                } else {
                    fxVar = new fx();
                    fxVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                z = true;
            }
        }
        if (fxVar == null) {
            if (fx.a.a == a2 || fx.a.b == a2) {
                gi giVar = new gi();
                giVar.k(attributeValue);
                giVar.m(attributeValue3);
                giVar.n(attributeValue2);
                giVar.a(fx.a.d);
                giVar.l(attributeValue4);
                giVar.a(new gd(gd.a.e));
                fiVar.a(giVar);
                b.d("iq usage error. send packet in packet parser.");
                return null;
            }
            fxVar = new gj();
        }
        fxVar.k(attributeValue);
        fxVar.m(attributeValue2);
        fxVar.l(attributeValue4);
        fxVar.n(attributeValue3);
        fxVar.a(a2);
        fxVar.a(gdVar);
        fxVar.a(hashMap);
        return fxVar;
    }

    public static fz a(XmlPullParser xmlPullParser) {
        String str;
        boolean z = false;
        String str2 = null;
        if ("1".equals(xmlPullParser.getAttributeValue("", "s"))) {
            String attributeValue = xmlPullParser.getAttributeValue("", "chid");
            String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
            String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
            String attributeValue4 = xmlPullParser.getAttributeValue("", "to");
            String attributeValue5 = xmlPullParser.getAttributeValue("", "type");
            as.b a2 = as.a().a(attributeValue, attributeValue4);
            if (a2 == null) {
                a2 = as.a().a(attributeValue, attributeValue3);
            }
            if (a2 != null) {
                fz fzVar = null;
                while (!z) {
                    int next = xmlPullParser.next();
                    if (next == 2) {
                        if (!"s".equals(xmlPullParser.getName())) {
                            throw new ft("error while receiving a encrypted message with wrong format");
                        } else if (xmlPullParser.next() == 4) {
                            String text = xmlPullParser.getText();
                            if ("5".equals(attributeValue) || "6".equals(attributeValue)) {
                                fy fyVar = new fy();
                                fyVar.l(attributeValue);
                                fyVar.b(true);
                                fyVar.n(attributeValue3);
                                fyVar.m(attributeValue4);
                                fyVar.k(attributeValue2);
                                fyVar.f(attributeValue5);
                                String[] strArr = null;
                                fw fwVar = new fw("s", null, strArr, strArr);
                                fwVar.m348a(text);
                                fyVar.a(fwVar);
                                return fyVar;
                            }
                            a(bb.a(bb.a(a2.h, attributeValue2), text));
                            a.next();
                            fzVar = a(a);
                        } else {
                            throw new ft("error while receiving a encrypted message with wrong format");
                        }
                    } else if (next == 3 && xmlPullParser.getName().equals("message")) {
                        z = true;
                    }
                }
                if (fzVar != null) {
                    return fzVar;
                }
                throw new ft("error while receiving a encrypted message with wrong format");
            }
            throw new ft("the channel id is wrong while receiving a encrypted message");
        }
        fy fyVar2 = new fy();
        String attributeValue6 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue6 == null) {
            attributeValue6 = "ID_NOT_AVAILABLE";
        }
        fyVar2.k(attributeValue6);
        fyVar2.m(xmlPullParser.getAttributeValue("", "to"));
        fyVar2.n(xmlPullParser.getAttributeValue("", "from"));
        fyVar2.l(xmlPullParser.getAttributeValue("", "chid"));
        fyVar2.a(xmlPullParser.getAttributeValue("", "appid"));
        try {
            str = xmlPullParser.getAttributeValue("", "transient");
        } catch (Exception unused) {
            str = null;
        }
        try {
            String attributeValue7 = xmlPullParser.getAttributeValue("", "seq");
            if (!TextUtils.isEmpty(attributeValue7)) {
                fyVar2.b(attributeValue7);
            }
        } catch (Exception unused2) {
        }
        try {
            String attributeValue8 = xmlPullParser.getAttributeValue("", "mseq");
            if (!TextUtils.isEmpty(attributeValue8)) {
                fyVar2.c(attributeValue8);
            }
        } catch (Exception unused3) {
        }
        try {
            String attributeValue9 = xmlPullParser.getAttributeValue("", "fseq");
            if (!TextUtils.isEmpty(attributeValue9)) {
                fyVar2.d(attributeValue9);
            }
        } catch (Exception unused4) {
        }
        try {
            String attributeValue10 = xmlPullParser.getAttributeValue("", "status");
            if (!TextUtils.isEmpty(attributeValue10)) {
                fyVar2.e(attributeValue10);
            }
        } catch (Exception unused5) {
        }
        fyVar2.a(!TextUtils.isEmpty(str) && str.equalsIgnoreCase("true"));
        fyVar2.f(xmlPullParser.getAttributeValue("", "type"));
        String b = b(xmlPullParser);
        if (b == null || "".equals(b.trim())) {
            fz.q();
        } else {
            fyVar2.j(b);
        }
        while (!z) {
            int next2 = xmlPullParser.next();
            if (next2 == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (TextUtils.isEmpty(namespace)) {
                    namespace = "xm";
                }
                if (name.equals("subject")) {
                    b(xmlPullParser);
                    fyVar2.g(m370a(xmlPullParser));
                } else if (name.equals("body")) {
                    String attributeValue11 = xmlPullParser.getAttributeValue("", "encode");
                    String a3 = m370a(xmlPullParser);
                    if (!TextUtils.isEmpty(attributeValue11)) {
                        fyVar2.a(a3, attributeValue11);
                    } else {
                        fyVar2.h(a3);
                    }
                } else if (name.equals("thread")) {
                    if (str2 == null) {
                        str2 = xmlPullParser.nextText();
                    }
                } else if (name.equals("error")) {
                    fyVar2.a(m369a(xmlPullParser));
                } else {
                    fyVar2.a(a(name, namespace, xmlPullParser));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals("message")) {
                z = true;
            }
        }
        fyVar2.i(str2);
        return fyVar2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static gb m367a(XmlPullParser xmlPullParser) {
        gb.b bVar = gb.b.available;
        String attributeValue = xmlPullParser.getAttributeValue("", "type");
        if (attributeValue != null && !attributeValue.equals("")) {
            try {
                bVar = gb.b.valueOf(attributeValue);
            } catch (IllegalArgumentException unused) {
                PrintStream printStream = System.err;
                printStream.println("Found invalid presence type " + attributeValue);
            }
        }
        gb gbVar = new gb(bVar);
        gbVar.m(xmlPullParser.getAttributeValue("", "to"));
        gbVar.n(xmlPullParser.getAttributeValue("", "from"));
        gbVar.l(xmlPullParser.getAttributeValue("", "chid"));
        String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue2 == null) {
            attributeValue2 = "ID_NOT_AVAILABLE";
        }
        gbVar.k(attributeValue2);
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("status")) {
                    gbVar.a(xmlPullParser.nextText());
                } else if (name.equals("priority")) {
                    try {
                        gbVar.a(Integer.parseInt(xmlPullParser.nextText()));
                    } catch (NumberFormatException unused2) {
                    } catch (IllegalArgumentException unused3) {
                        gbVar.a(0);
                    }
                } else if (name.equals("show")) {
                    String nextText = xmlPullParser.nextText();
                    try {
                        gbVar.a(gb.a.valueOf(nextText));
                    } catch (IllegalArgumentException unused4) {
                        PrintStream printStream2 = System.err;
                        printStream2.println("Found invalid presence mode " + nextText);
                    }
                } else if (name.equals("error")) {
                    gbVar.a(m369a(xmlPullParser));
                } else {
                    gbVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                z = true;
            }
        }
        return gbVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static gc m368a(XmlPullParser xmlPullParser) {
        gc gcVar = null;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                gcVar = new gc(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals("error")) {
                z = true;
            }
        }
        return gcVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static gd m369a(XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        String str = "-1";
        String str2 = null;
        String str3 = null;
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            if (xmlPullParser.getAttributeName(i).equals("code")) {
                str = xmlPullParser.getAttributeValue("", "code");
            }
            if (xmlPullParser.getAttributeName(i).equals("type")) {
                str3 = xmlPullParser.getAttributeValue("", "type");
            }
            if (xmlPullParser.getAttributeName(i).equals("reason")) {
                str2 = xmlPullParser.getAttributeValue("", "reason");
            }
        }
        String str4 = null;
        String str5 = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("text")) {
                    str5 = xmlPullParser.nextText();
                } else {
                    String name = xmlPullParser.getName();
                    String namespace = xmlPullParser.getNamespace();
                    if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(namespace)) {
                        str4 = name;
                    } else {
                        arrayList.add(a(name, namespace, xmlPullParser));
                    }
                }
            } else if (next == 3) {
                if (xmlPullParser.getName().equals("error")) {
                    z = true;
                }
            } else if (next == 4) {
                str5 = xmlPullParser.getText();
            }
        }
        return new gd(Integer.parseInt(str), str3 == null ? "cancel" : str3, str2, str4, str5, arrayList);
    }

    /* renamed from: a  reason: collision with other method in class */
    private static String m370a(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        String str = "";
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str;
            }
            str = str + xmlPullParser.getText();
        }
    }

    private static void a(byte[] bArr) {
        if (a == null) {
            try {
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                a = newPullParser;
                newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
        }
        a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
    }

    private static String b(XmlPullParser xmlPullParser) {
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if ("xml:lang".equals(attributeName) || ("lang".equals(attributeName) && "xml".equals(xmlPullParser.getAttributePrefix(i)))) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }
}
