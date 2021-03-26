package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class ei {
    private XmlPullParser a;

    ei() {
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            this.a = newPullParser;
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException unused) {
        }
    }

    fe a(byte[] bArr, em emVar) {
        this.a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.a.next();
        int eventType = this.a.getEventType();
        String name = this.a.getName();
        if (eventType != 2) {
            return null;
        }
        if (name.equals("message")) {
            return fm.a(this.a);
        }
        if (name.equals("iq")) {
            return fm.a(this.a, emVar);
        }
        if (name.equals("presence")) {
            return fm.b(this.a);
        }
        if (this.a.getName().equals("stream")) {
            return null;
        }
        if (this.a.getName().equals("error")) {
            throw new ey(fm.c(this.a));
        } else if (this.a.getName().equals("warning")) {
            this.a.next();
            this.a.getName().equals("multi-login");
            return null;
        } else {
            this.a.getName().equals("bind");
            return null;
        }
    }
}
