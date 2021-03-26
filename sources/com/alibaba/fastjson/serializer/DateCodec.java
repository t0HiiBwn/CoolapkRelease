package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.deserializer.AbstractDateDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateCodec extends AbstractDateDeserializer implements ObjectSerializer, ObjectDeserializer {
    public static final DateCodec instance = new DateCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        Date date;
        char[] cArr;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls == java.sql.Date.class) {
            long time = ((java.sql.Date) obj).getTime();
            if ((time + ((long) jSONSerializer.timeZone.getOffset(time))) % 86400000 == 0 && !SerializerFeature.isEnabled(serializeWriter.features, i, SerializerFeature.WriteClassName)) {
                serializeWriter.writeString(obj.toString());
                return;
            }
        }
        if (cls == Time.class) {
            long time2 = ((Time) obj).getTime();
            if ("unixtime".equals(jSONSerializer.getDateFormatPattern())) {
                serializeWriter.writeLong(time2 / 1000);
                return;
            } else if ("millis".equals(jSONSerializer.getDateFormatPattern())) {
                serializeWriter.writeLong(time2);
                return;
            } else if (time2 < 86400000) {
                serializeWriter.writeString(obj.toString());
                return;
            }
        }
        int nanos = cls == Timestamp.class ? ((Timestamp) obj).getNanos() : 0;
        if (obj instanceof Date) {
            date = (Date) obj;
        } else {
            date = TypeUtils.castToDate(obj);
        }
        if ("unixtime".equals(jSONSerializer.getDateFormatPattern())) {
            serializeWriter.writeLong(date.getTime() / 1000);
        } else if ("millis".equals(jSONSerializer.getDateFormatPattern())) {
            serializeWriter.writeLong(date.getTime());
        } else if (serializeWriter.isEnabled(SerializerFeature.WriteDateUseDateFormat)) {
            DateFormat dateFormat = jSONSerializer.getDateFormat();
            if (dateFormat == null) {
                dateFormat = new SimpleDateFormat(JSON.DEFFAULT_DATE_FORMAT, jSONSerializer.locale);
                dateFormat.setTimeZone(jSONSerializer.timeZone);
            }
            serializeWriter.writeString(dateFormat.format(date));
        } else if (!serializeWriter.isEnabled(SerializerFeature.WriteClassName) || cls == type) {
            long time3 = date.getTime();
            if (serializeWriter.isEnabled(SerializerFeature.UseISO8601DateFormat)) {
                int i2 = serializeWriter.isEnabled(SerializerFeature.UseSingleQuotes) ? 39 : 34;
                serializeWriter.write(i2);
                Calendar instance2 = Calendar.getInstance(jSONSerializer.timeZone, jSONSerializer.locale);
                instance2.setTimeInMillis(time3);
                int i3 = instance2.get(1);
                int i4 = instance2.get(2) + 1;
                int i5 = instance2.get(5);
                int i6 = instance2.get(11);
                int i7 = instance2.get(12);
                int i8 = instance2.get(13);
                int i9 = instance2.get(14);
                if (nanos > 0) {
                    cArr = "0000-00-00 00:00:00.000000000".toCharArray();
                    IOUtils.getChars(nanos, 29 - (9 - IOUtils.stringSize(nanos)), cArr);
                    IOUtils.getChars(i8, 19, cArr);
                    IOUtils.getChars(i7, 16, cArr);
                    IOUtils.getChars(i6, 13, cArr);
                    IOUtils.getChars(i5, 10, cArr);
                    IOUtils.getChars(i4, 7, cArr);
                    IOUtils.getChars(i3, 4, cArr);
                } else if (i9 != 0) {
                    char[] charArray = "0000-00-00T00:00:00.000".toCharArray();
                    IOUtils.getChars(i9, 23, charArray);
                    IOUtils.getChars(i8, 19, charArray);
                    IOUtils.getChars(i7, 16, charArray);
                    IOUtils.getChars(i6, 13, charArray);
                    IOUtils.getChars(i5, 10, charArray);
                    IOUtils.getChars(i4, 7, charArray);
                    IOUtils.getChars(i3, 4, charArray);
                    cArr = charArray;
                } else if (i8 == 0 && i7 == 0 && i6 == 0) {
                    char[] charArray2 = "0000-00-00".toCharArray();
                    IOUtils.getChars(i5, 10, charArray2);
                    IOUtils.getChars(i4, 7, charArray2);
                    IOUtils.getChars(i3, 4, charArray2);
                    cArr = charArray2;
                } else {
                    cArr = "0000-00-00T00:00:00".toCharArray();
                    IOUtils.getChars(i8, 19, cArr);
                    IOUtils.getChars(i7, 16, cArr);
                    IOUtils.getChars(i6, 13, cArr);
                    IOUtils.getChars(i5, 10, cArr);
                    IOUtils.getChars(i4, 7, cArr);
                    IOUtils.getChars(i3, 4, cArr);
                }
                serializeWriter.write(cArr);
                if (nanos > 0) {
                    serializeWriter.write(i2);
                    return;
                }
                float offset = ((float) instance2.getTimeZone().getOffset(instance2.getTimeInMillis())) / 3600000.0f;
                int i10 = (int) offset;
                if (((double) i10) == 0.0d) {
                    serializeWriter.write(90);
                } else {
                    if (i10 > 9) {
                        serializeWriter.write(43);
                        serializeWriter.writeInt(i10);
                    } else if (i10 > 0) {
                        serializeWriter.write(43);
                        serializeWriter.write(48);
                        serializeWriter.writeInt(i10);
                    } else if (i10 < -9) {
                        serializeWriter.write(45);
                        serializeWriter.writeInt(-i10);
                    } else if (i10 < 0) {
                        serializeWriter.write(45);
                        serializeWriter.write(48);
                        serializeWriter.writeInt(-i10);
                    }
                    serializeWriter.write(58);
                    serializeWriter.append((CharSequence) String.format("%02d", Integer.valueOf((int) (Math.abs(offset - ((float) i10)) * 60.0f))));
                }
                serializeWriter.write(i2);
                return;
            }
            serializeWriter.writeLong(time3);
        } else if (cls == Date.class) {
            serializeWriter.write("new Date(");
            serializeWriter.writeLong(((Date) obj).getTime());
            serializeWriter.write(41);
        } else {
            serializeWriter.write(123);
            serializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY);
            jSONSerializer.write(cls.getName());
            serializeWriter.writeFieldValue(',', "val", ((Date) obj).getTime());
            serializeWriter.write(125);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.fastjson.parser.deserializer.AbstractDateDeserializer
    public <T> T cast(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        if (obj2 == 0) {
            return null;
        }
        if (obj2 instanceof Date) {
            return obj2;
        }
        if (obj2 instanceof BigDecimal) {
            return (T) new Date(TypeUtils.longValue((BigDecimal) obj2));
        }
        if (obj2 instanceof Number) {
            return (T) new Date(((Number) obj2).longValue());
        }
        if (obj2 instanceof String) {
            String str = (String) obj2;
            if (str.length() == 0) {
                return null;
            }
            JSONScanner jSONScanner = new JSONScanner(str);
            try {
                if (jSONScanner.scanISO8601DateIfMatch(false)) {
                    T t = (T) jSONScanner.getCalendar();
                    if (type == Calendar.class) {
                        return t;
                    }
                    T t2 = (T) t.getTime();
                    jSONScanner.close();
                    return t2;
                }
                jSONScanner.close();
                if (str.length() == defaultJSONParser.getDateFomartPattern().length() || (str.length() == 22 && defaultJSONParser.getDateFomartPattern().equals("yyyyMMddHHmmssSSSZ"))) {
                    try {
                        return (T) defaultJSONParser.getDateFormat().parse(str);
                    } catch (ParseException unused) {
                    }
                }
                if (str.startsWith("/Date(") && str.endsWith(")/")) {
                    str = str.substring(6, str.length() - 2);
                }
                if ("0000-00-00".equals(str) || "0000-00-00T00:00:00".equalsIgnoreCase(str) || "0001-01-01T00:00:00+08:00".equalsIgnoreCase(str)) {
                    return null;
                }
                int lastIndexOf = str.lastIndexOf(124);
                if (lastIndexOf > 20) {
                    TimeZone timeZone = TimeZone.getTimeZone(str.substring(lastIndexOf + 1));
                    if (!"GMT".equals(timeZone.getID())) {
                        JSONScanner jSONScanner2 = new JSONScanner(str.substring(0, lastIndexOf));
                        try {
                            if (jSONScanner2.scanISO8601DateIfMatch(false)) {
                                T t3 = (T) jSONScanner2.getCalendar();
                                t3.setTimeZone(timeZone);
                                if (type == Calendar.class) {
                                    return t3;
                                }
                                T t4 = (T) t3.getTime();
                                jSONScanner2.close();
                                return t4;
                            }
                            jSONScanner2.close();
                        } finally {
                            jSONScanner2.close();
                        }
                    }
                }
                return (T) new Date(Long.parseLong(str));
            } finally {
                jSONScanner.close();
            }
        } else {
            throw new JSONException("parse error");
        }
    }
}
