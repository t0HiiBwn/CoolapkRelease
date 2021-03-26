package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Time;

public class TimeDeserializer implements ObjectDeserializer {
    public static final TimeDeserializer instance = new TimeDeserializer();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        long j;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 16) {
            jSONLexer.nextToken(4);
            if (jSONLexer.token() == 4) {
                jSONLexer.nextTokenWithColon(2);
                if (jSONLexer.token() == 2) {
                    long longValue = jSONLexer.longValue();
                    jSONLexer.nextToken(13);
                    if (jSONLexer.token() == 13) {
                        jSONLexer.nextToken(16);
                        return (T) new Time(longValue);
                    }
                    throw new JSONException("syntax error");
                }
                throw new JSONException("syntax error");
            }
            throw new JSONException("syntax error");
        }
        T t = (T) defaultJSONParser.parse();
        if (t == null) {
            return null;
        }
        if (t instanceof Time) {
            return t;
        }
        if (t instanceof BigDecimal) {
            return (T) new Time(TypeUtils.longValue(t));
        }
        if (t instanceof Number) {
            return (T) new Time(t.longValue());
        }
        if (t instanceof String) {
            T t2 = t;
            if (t2.length() == 0) {
                return null;
            }
            JSONScanner jSONScanner = new JSONScanner(t2);
            if (jSONScanner.scanISO8601DateIfMatch()) {
                j = jSONScanner.getCalendar().getTimeInMillis();
            } else {
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= t2.length()) {
                        z = true;
                        break;
                    }
                    char charAt = t2.charAt(i);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    i++;
                }
                if (!z) {
                    jSONScanner.close();
                    return (T) Time.valueOf(t2);
                }
                j = Long.parseLong(t2);
            }
            jSONScanner.close();
            return (T) new Time(j);
        }
        throw new JSONException("parse error");
    }
}
