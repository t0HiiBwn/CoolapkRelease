package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.IOUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class CalendarCodec extends ContextObjectDeserializer implements ObjectSerializer, ObjectDeserializer, ContextObjectSerializer {
    public static final CalendarCodec instance = new CalendarCodec();
    private DatatypeFactory dateFactory;

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    @Override // com.alibaba.fastjson.serializer.ContextObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, BeanContext beanContext) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        String format = beanContext.getFormat();
        Calendar calendar = (Calendar) obj;
        if (format.equals("unixtime")) {
            serializeWriter.writeInt((int) (calendar.getTimeInMillis() / 1000));
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        simpleDateFormat.setTimeZone(jSONSerializer.timeZone);
        serializeWriter.writeString(simpleDateFormat.format(calendar.getTime()));
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        Calendar calendar;
        char[] cArr;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        if (obj instanceof XMLGregorianCalendar) {
            calendar = ((XMLGregorianCalendar) obj).toGregorianCalendar();
        } else {
            calendar = (Calendar) obj;
        }
        if (serializeWriter.isEnabled(SerializerFeature.UseISO8601DateFormat)) {
            char c = serializeWriter.isEnabled(SerializerFeature.UseSingleQuotes) ? '\'' : '\"';
            serializeWriter.append(c);
            int i2 = calendar.get(1);
            int i3 = calendar.get(2) + 1;
            int i4 = calendar.get(5);
            int i5 = calendar.get(11);
            int i6 = calendar.get(12);
            int i7 = calendar.get(13);
            int i8 = calendar.get(14);
            if (i8 != 0) {
                cArr = "0000-00-00T00:00:00.000".toCharArray();
                IOUtils.getChars(i8, 23, cArr);
                IOUtils.getChars(i7, 19, cArr);
                IOUtils.getChars(i6, 16, cArr);
                IOUtils.getChars(i5, 13, cArr);
                IOUtils.getChars(i4, 10, cArr);
                IOUtils.getChars(i3, 7, cArr);
                IOUtils.getChars(i2, 4, cArr);
            } else if (i7 == 0 && i6 == 0 && i5 == 0) {
                cArr = "0000-00-00".toCharArray();
                IOUtils.getChars(i4, 10, cArr);
                IOUtils.getChars(i3, 7, cArr);
                IOUtils.getChars(i2, 4, cArr);
            } else {
                cArr = "0000-00-00T00:00:00".toCharArray();
                IOUtils.getChars(i7, 19, cArr);
                IOUtils.getChars(i6, 16, cArr);
                IOUtils.getChars(i5, 13, cArr);
                IOUtils.getChars(i4, 10, cArr);
                IOUtils.getChars(i3, 7, cArr);
                IOUtils.getChars(i2, 4, cArr);
            }
            serializeWriter.write(cArr);
            float offset = ((float) calendar.getTimeZone().getOffset(calendar.getTimeInMillis())) / 3600000.0f;
            int i9 = (int) offset;
            if (((double) i9) == 0.0d) {
                serializeWriter.write(90);
            } else {
                if (i9 > 9) {
                    serializeWriter.write(43);
                    serializeWriter.writeInt(i9);
                } else if (i9 > 0) {
                    serializeWriter.write(43);
                    serializeWriter.write(48);
                    serializeWriter.writeInt(i9);
                } else if (i9 < -9) {
                    serializeWriter.write(45);
                    serializeWriter.writeInt(i9);
                } else if (i9 < 0) {
                    serializeWriter.write(45);
                    serializeWriter.write(48);
                    serializeWriter.writeInt(-i9);
                }
                serializeWriter.write(58);
                serializeWriter.append((CharSequence) String.format("%02d", Integer.valueOf((int) ((offset - ((float) i9)) * 60.0f))));
            }
            serializeWriter.append(c);
            return;
        }
        jSONSerializer.write(calendar.getTime());
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, null, 0);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, String str, int i) {
        T t = (T) DateCodec.instance.deserialze(defaultJSONParser, type, obj, str, i);
        if (t instanceof Calendar) {
            return t;
        }
        T t2 = t;
        if (t2 == null) {
            return null;
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        T t3 = (T) Calendar.getInstance(jSONLexer.getTimeZone(), jSONLexer.getLocale());
        t3.setTime(t2);
        return type == XMLGregorianCalendar.class ? (T) createXMLGregorianCalendar(t3) : t3;
    }

    public XMLGregorianCalendar createXMLGregorianCalendar(Calendar calendar) {
        if (this.dateFactory == null) {
            try {
                this.dateFactory = DatatypeFactory.newInstance();
            } catch (DatatypeConfigurationException e) {
                throw new IllegalStateException("Could not obtain an instance of DatatypeFactory.", e);
            }
        }
        return this.dateFactory.newXMLGregorianCalendar((GregorianCalendar) calendar);
    }
}
