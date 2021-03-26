package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.fc;
import com.xiaomi.push.fg;
import com.xiaomi.push.fi;
import com.xiaomi.push.service.bc;
import com.xiaomi.push.service.q;
import com.xiaomi.push.service.z;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class fm {
    private static XmlPullParser a;

    public static fb a(String str, String str2, XmlPullParser xmlPullParser) {
        Object a2 = fl.a().a("all", "xm:chat");
        if (a2 == null || !(a2 instanceof bc)) {
            return null;
        }
        return ((bc) a2).b(xmlPullParser);
    }

    public static fc a(XmlPullParser xmlPullParser, em emVar) {
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "to");
        String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        fc.a a2 = fc.a.a(xmlPullParser.getAttributeValue("", "type"));
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            hashMap.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
        }
        fc fcVar = null;
        fi fiVar = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("error")) {
                    fiVar = d(xmlPullParser);
                } else {
                    fcVar = new fc();
                    fcVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                z = true;
            }
        }
        if (fcVar == null) {
            if (fc.a.a == a2 || fc.a.b == a2) {
                fn fnVar = new fn();
                fnVar.k(attributeValue);
                fnVar.m(attributeValue3);
                fnVar.n(attributeValue2);
                fnVar.a(fc.a.d);
                fnVar.l(attributeValue4);
                fnVar.a(new fi(fi.a.e));
                emVar.a(fnVar);
                c.d("iq usage error. send packet in packet parser.");
                return null;
            }
            fcVar = new fo();
        }
        fcVar.k(attributeValue);
        fcVar.m(attributeValue2);
        fcVar.l(attributeValue4);
        fcVar.n(attributeValue3);
        fcVar.a(a2);
        fcVar.a(fiVar);
        fcVar.a(hashMap);
        return fcVar;
    }

    public static fe a(XmlPullParser xmlPullParser) {
        String str;
        boolean z = false;
        String str2 = null;
        if ("1".equals(xmlPullParser.getAttributeValue("", "s"))) {
            String attributeValue = xmlPullParser.getAttributeValue("", "chid");
            String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
            String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
            String attributeValue4 = xmlPullParser.getAttributeValue("", "to");
            String attributeValue5 = xmlPullParser.getAttributeValue("", "type");
            q.b b = q.a().b(attributeValue, attributeValue4);
            if (b == null) {
                b = q.a().b(attributeValue, attributeValue3);
            }
            if (b != null) {
                fe feVar = null;
                while (!z) {
                    int next = xmlPullParser.next();
                    if (next == 2) {
                        if (!"s".equals(xmlPullParser.getName())) {
                            throw new ey("error while receiving a encrypted message with wrong format");
                        } else if (xmlPullParser.next() == 4) {
                            String text = xmlPullParser.getText();
                            if ("5".equals(attributeValue) || "6".equals(attributeValue)) {
                                fd fdVar = new fd();
                                fdVar.l(attributeValue);
                                fdVar.b(true);
                                fdVar.n(attributeValue3);
                                fdVar.m(attributeValue4);
                                fdVar.k(attributeValue2);
                                fdVar.f(attributeValue5);
                                String[] strArr = null;
                                fb fbVar = new fb("s", null, strArr, strArr);
                                fbVar.b(text);
                                fdVar.a(fbVar);
                                return fdVar;
                            }
                            a(z.a(z.a(b.i, attributeValue2), text));
                            a.next();
                            feVar = a(a);
                        } else {
                            throw new ey("error while receiving a encrypted message with wrong format");
                        }
                    } else if (next == 3 && xmlPullParser.getName().equals("message")) {
                        z = true;
                    }
                }
                if (feVar != null) {
                    return feVar;
                }
                throw new ey("error while receiving a encrypted message with wrong format");
            }
            throw new ey("the channel id is wrong while receiving a encrypted message");
        }
        fd fdVar2 = new fd();
        String attributeValue6 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue6 == null) {
            attributeValue6 = "ID_NOT_AVAILABLE";
        }
        fdVar2.k(attributeValue6);
        fdVar2.m(xmlPullParser.getAttributeValue("", "to"));
        fdVar2.n(xmlPullParser.getAttributeValue("", "from"));
        fdVar2.l(xmlPullParser.getAttributeValue("", "chid"));
        fdVar2.a(xmlPullParser.getAttributeValue("", "appid"));
        try {
            str = xmlPullParser.getAttributeValue("", "transient");
        } catch (Exception unused) {
            str = null;
        }
        try {
            String attributeValue7 = xmlPullParser.getAttributeValue("", "seq");
            if (!TextUtils.isEmpty(attributeValue7)) {
                fdVar2.b(attributeValue7);
            }
        } catch (Exception unused2) {
        }
        try {
            String attributeValue8 = xmlPullParser.getAttributeValue("", "mseq");
            if (!TextUtils.isEmpty(attributeValue8)) {
                fdVar2.c(attributeValue8);
            }
        } catch (Exception unused3) {
        }
        try {
            String attributeValue9 = xmlPullParser.getAttributeValue("", "fseq");
            if (!TextUtils.isEmpty(attributeValue9)) {
                fdVar2.d(attributeValue9);
            }
        } catch (Exception unused4) {
        }
        try {
            String attributeValue10 = xmlPullParser.getAttributeValue("", "status");
            if (!TextUtils.isEmpty(attributeValue10)) {
                fdVar2.e(attributeValue10);
            }
        } catch (Exception unused5) {
        }
        fdVar2.a(!TextUtils.isEmpty(str) && str.equalsIgnoreCase("true"));
        fdVar2.f(xmlPullParser.getAttributeValue("", "type"));
        String f = f(xmlPullParser);
        if (f == null || "".equals(f.trim())) {
            fe.u();
        } else {
            fdVar2.j(f);
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
                    f(xmlPullParser);
                    fdVar2.g(e(xmlPullParser));
                } else if (name.equals("body")) {
                    String attributeValue11 = xmlPullParser.getAttributeValue("", "encode");
                    String e = e(xmlPullParser);
                    if (!TextUtils.isEmpty(attributeValue11)) {
                        fdVar2.a(e, attributeValue11);
                    } else {
                        fdVar2.h(e);
                    }
                } else if (name.equals("thread")) {
                    if (str2 == null) {
                        str2 = xmlPullParser.nextText();
                    }
                } else if (name.equals("error")) {
                    fdVar2.a(d(xmlPullParser));
                } else {
                    fdVar2.a(a(name, namespace, xmlPullParser));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals("message")) {
                z = true;
            }
        }
        fdVar2.i(str2);
        return fdVar2;
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

    public static fg b(XmlPullParser xmlPullParser) {
        fg.b bVar = fg.b.available;
        String attributeValue = xmlPullParser.getAttributeValue("", "type");
        if (attributeValue != null && !attributeValue.equals("")) {
            try {
                bVar = fg.b.valueOf(attributeValue);
            } catch (IllegalArgumentException unused) {
                PrintStream printStream = System.err;
                printStream.println("Found invalid presence type " + attributeValue);
            }
        }
        fg fgVar = new fg(bVar);
        fgVar.m(xmlPullParser.getAttributeValue("", "to"));
        fgVar.n(xmlPullParser.getAttributeValue("", "from"));
        fgVar.l(xmlPullParser.getAttributeValue("", "chid"));
        String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue2 == null) {
            attributeValue2 = "ID_NOT_AVAILABLE";
        }
        fgVar.k(attributeValue2);
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("status")) {
                    fgVar.a(xmlPullParser.nextText());
                } else if (name.equals("priority")) {
                    try {
                        fgVar.a(Integer.parseInt(xmlPullParser.nextText()));
                    } catch (NumberFormatException unused2) {
                    } catch (IllegalArgumentException unused3) {
                        fgVar.a(0);
                    }
                } else if (name.equals("show")) {
                    String nextText = xmlPullParser.nextText();
                    try {
                        fgVar.a(fg.a.valueOf(nextText));
                    } catch (IllegalArgumentException unused4) {
                        PrintStream printStream2 = System.err;
                        printStream2.println("Found invalid presence mode " + nextText);
                    }
                } else if (name.equals("error")) {
                    fgVar.a(d(xmlPullParser));
                } else {
                    fgVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                z = true;
            }
        }
        return fgVar;
    }

    public static fh c(XmlPullParser xmlPullParser) {
        fh fhVar = null;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                fhVar = new fh(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals("error")) {
                z = true;
            }
        }
        return fhVar;
    }

    public static fi d(XmlPullParser xmlPullParser) {
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
        return new fi(Integer.parseInt(str), str3 == null ? "cancel" : str3, str2, str4, str5, arrayList);
    }

    private static String e(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        String str = "";
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str;
            }
            str = str + xmlPullParser.getText();
        }
    }

    private static String f(XmlPullParser xmlPullParser) {
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if ("xml:lang".equals(attributeName) || ("lang".equals(attributeName) && "xml".equals(xmlPullParser.getAttributePrefix(i)))) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }
}
