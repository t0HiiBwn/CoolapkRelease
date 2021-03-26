package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.EnumDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.SerializeBeanInfo;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.Deque;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TypeUtils {
    private static final Pattern NUMBER_WITH_TRAILING_ZEROS_PATTERN = Pattern.compile("\\.0*$");
    private static volatile boolean classXmlAccessorType_error = false;
    private static volatile Class class_Clob = null;
    private static volatile boolean class_Clob_error = false;
    private static Class<? extends Annotation> class_JacksonCreator = null;
    private static boolean class_JacksonCreator_error = false;
    private static Class<? extends Annotation> class_ManyToMany = null;
    private static boolean class_ManyToMany_error = false;
    private static Class<? extends Annotation> class_OneToMany = null;
    private static boolean class_OneToMany_error = false;
    private static volatile Class class_XmlAccessType = null;
    private static volatile Class class_XmlAccessorType = null;
    public static boolean compatibleWithFieldName;
    public static boolean compatibleWithJavaBean;
    private static volatile Field field_XmlAccessType_FIELD = null;
    private static volatile Object field_XmlAccessType_FIELD_VALUE = null;
    private static volatile Map<Class, String[]> kotlinIgnores;
    private static volatile boolean kotlinIgnores_error;
    private static volatile boolean kotlin_class_klass_error;
    private static volatile boolean kotlin_error;
    private static volatile Constructor kotlin_kclass_constructor;
    private static volatile Method kotlin_kclass_getConstructors;
    private static volatile Method kotlin_kfunction_getParameters;
    private static volatile Method kotlin_kparameter_getName;
    private static volatile Class kotlin_metadata;
    private static volatile boolean kotlin_metadata_error;
    private static ConcurrentMap<String, Class<?>> mappings = new ConcurrentHashMap(256, 0.75f, 1);
    private static Method method_HibernateIsInitialized = null;
    private static boolean method_HibernateIsInitialized_error = false;
    private static volatile Method method_XmlAccessorType_value = null;
    private static Class<?> optionalClass;
    private static boolean optionalClassInited = false;
    private static Method oracleDateMethod;
    private static boolean oracleDateMethodInited = false;
    private static Method oracleTimestampMethod;
    private static boolean oracleTimestampMethodInited = false;
    private static Class<?> pathClass;
    private static boolean pathClass_error = false;
    private static boolean setAccessibleEnable = true;
    private static Class<? extends Annotation> transientClass;
    private static boolean transientClassInited = false;

    static int num(char c, char c2) {
        if (c < '0' || c > '9' || c2 < '0' || c2 > '9') {
            return -1;
        }
        return ((c - '0') * 10) + (c2 - '0');
    }

    static int num(char c, char c2, char c3, char c4) {
        if (c < '0' || c > '9' || c2 < '0' || c2 > '9' || c3 < '0' || c3 > '9' || c4 < '0' || c4 > '9') {
            return -1;
        }
        return ((c - '0') * 1000) + ((c2 - '0') * 100) + ((c3 - '0') * 10) + (c4 - '0');
    }

    static int num(char c, char c2, char c3, char c4, char c5, char c6, char c7, char c8, char c9) {
        if (c < '0' || c > '9' || c2 < '0' || c2 > '9' || c3 < '0' || c3 > '9' || c4 < '0' || c4 > '9' || c5 < '0' || c5 > '9' || c6 < '0' || c6 > '9' || c7 < '0' || c7 > '9' || c8 < '0' || c8 > '9' || c9 < '0' || c9 > '9') {
            return -1;
        }
        return ((c - '0') * 100000000) + ((c2 - '0') * 10000000) + ((c3 - '0') * 1000000) + ((c4 - '0') * 100000) + ((c5 - '0') * 10000) + ((c6 - '0') * 1000) + ((c7 - '0') * 100) + ((c8 - '0') * 10) + (c9 - '0');
    }

    static {
        compatibleWithJavaBean = false;
        compatibleWithFieldName = false;
        try {
            compatibleWithJavaBean = "true".equals(IOUtils.getStringProperty("fastjson.compatibleWithJavaBean"));
            compatibleWithFieldName = "true".equals(IOUtils.getStringProperty("fastjson.compatibleWithFieldName"));
        } catch (Throwable unused) {
        }
        addBaseClassMappings();
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0052 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0053  */
    public static boolean isXmlField(Class cls) {
        Annotation annotation;
        Object obj;
        if (class_XmlAccessorType == null && !classXmlAccessorType_error) {
            try {
                class_XmlAccessorType = Class.forName("javax.xml.bind.annotation.XmlAccessorType");
            } catch (Throwable unused) {
                classXmlAccessorType_error = true;
            }
        }
        if (class_XmlAccessorType == null || (annotation = getAnnotation(cls, class_XmlAccessorType)) == null) {
            return false;
        }
        if (method_XmlAccessorType_value == null && !classXmlAccessorType_error) {
            try {
                method_XmlAccessorType_value = class_XmlAccessorType.getMethod("value", new Class[0]);
            } catch (Throwable unused2) {
                classXmlAccessorType_error = true;
            }
        }
        if (method_XmlAccessorType_value == null) {
            return false;
        }
        if (!classXmlAccessorType_error) {
            try {
                obj = method_XmlAccessorType_value.invoke(annotation, new Object[0]);
            } catch (Throwable unused3) {
                classXmlAccessorType_error = true;
            }
            if (obj != null) {
                return false;
            }
            if (class_XmlAccessType == null && !classXmlAccessorType_error) {
                try {
                    class_XmlAccessType = Class.forName("javax.xml.bind.annotation.XmlAccessType");
                    field_XmlAccessType_FIELD = class_XmlAccessType.getField("FIELD");
                    field_XmlAccessType_FIELD_VALUE = field_XmlAccessType_FIELD.get(null);
                } catch (Throwable unused4) {
                    classXmlAccessorType_error = true;
                }
            }
            if (obj == field_XmlAccessType_FIELD_VALUE) {
                return true;
            }
            return false;
        }
        obj = null;
        if (obj != null) {
        }
    }

    public static Annotation getXmlAccessorType(Class cls) {
        if (class_XmlAccessorType == null && !classXmlAccessorType_error) {
            try {
                class_XmlAccessorType = Class.forName("javax.xml.bind.annotation.XmlAccessorType");
            } catch (Throwable unused) {
                classXmlAccessorType_error = true;
            }
        }
        if (class_XmlAccessorType == null) {
            return null;
        }
        return getAnnotation(cls, class_XmlAccessorType);
    }

    public static boolean isClob(Class cls) {
        if (class_Clob == null && !class_Clob_error) {
            try {
                class_Clob = Class.forName("java.sql.Clob");
            } catch (Throwable unused) {
                class_Clob_error = true;
            }
        }
        if (class_Clob == null) {
            return false;
        }
        return class_Clob.isAssignableFrom(cls);
    }

    public static String castToString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static Byte castToByte(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return Byte.valueOf(byteValue((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Byte.valueOf(((Number) obj).byteValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            return Byte.valueOf(Byte.parseByte(str));
        }
        throw new JSONException("can not cast to byte, value : " + obj);
    }

    public static Character castToChar(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            if (str.length() == 1) {
                return Character.valueOf(str.charAt(0));
            }
            throw new JSONException("can not cast to char, value : " + obj);
        }
        throw new JSONException("can not cast to char, value : " + obj);
    }

    public static Short castToShort(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return Short.valueOf(shortValue((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Short.valueOf(((Number) obj).shortValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            return Short.valueOf(Short.parseShort(str));
        }
        throw new JSONException("can not cast to short, value : " + obj);
    }

    public static BigDecimal castToBigDecimal(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        if (obj instanceof BigInteger) {
            return new BigDecimal((BigInteger) obj);
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0) {
            return null;
        }
        if (!(obj instanceof Map) || ((Map) obj).size() != 0) {
            return new BigDecimal(obj2);
        }
        return null;
    }

    public static BigInteger castToBigInteger(Object obj) {
        BigDecimal bigDecimal;
        int scale;
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return BigInteger.valueOf(((Number) obj).longValue());
        }
        if ((obj instanceof BigDecimal) && (scale = (bigDecimal = (BigDecimal) obj).scale()) > -1000 && scale < 1000) {
            return bigDecimal.toBigInteger();
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0 || "null".equals(obj2) || "NULL".equals(obj2)) {
            return null;
        }
        return new BigInteger(obj2);
    }

    public static Float castToFloat(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || "null".equals(obj2) || "NULL".equals(obj2)) {
                return null;
            }
            if (obj2.indexOf(44) != -1) {
                obj2 = obj2.replaceAll(",", "");
            }
            return Float.valueOf(Float.parseFloat(obj2));
        }
        throw new JSONException("can not cast to float, value : " + obj);
    }

    public static Double castToDouble(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || "null".equals(obj2) || "NULL".equals(obj2)) {
                return null;
            }
            if (obj2.indexOf(44) != -1) {
                obj2 = obj2.replaceAll(",", "");
            }
            return Double.valueOf(Double.parseDouble(obj2));
        }
        throw new JSONException("can not cast to double, value : " + obj);
    }

    public static Date castToDate(Object obj) {
        return castToDate(obj, null);
    }

    public static Date castToDate(Object obj, String str) {
        long j;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (obj instanceof BigDecimal) {
            return new Date(longValue((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            long longValue = ((Number) obj).longValue();
            if ("unixtime".equals(str)) {
                longValue *= 1000;
            }
            return new Date(longValue);
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            JSONScanner jSONScanner = new JSONScanner(str2);
            try {
                if (jSONScanner.scanISO8601DateIfMatch(false)) {
                    return jSONScanner.getCalendar().getTime();
                }
                jSONScanner.close();
                if (str2.startsWith("/Date(") && str2.endsWith(")/")) {
                    str2 = str2.substring(6, str2.length() - 2);
                }
                if (str2.indexOf(45) > 0 || str2.indexOf(43) > 0) {
                    if (str == null) {
                        if (str2.length() == JSON.DEFFAULT_DATE_FORMAT.length() || (str2.length() == 22 && JSON.DEFFAULT_DATE_FORMAT.equals("yyyyMMddHHmmssSSSZ"))) {
                            str = JSON.DEFFAULT_DATE_FORMAT;
                        } else if (str2.length() == 10) {
                            str = "yyyy-MM-dd";
                        } else {
                            str = str2.length() == 19 ? "yyyy-MM-dd HH:mm:ss" : (str2.length() == 29 && str2.charAt(26) == ':' && str2.charAt(28) == '0') ? "yyyy-MM-dd'T'HH:mm:ss.SSSXXX" : (str2.length() == 23 && str2.charAt(19) == ',') ? "yyyy-MM-dd HH:mm:ss,SSS" : "yyyy-MM-dd HH:mm:ss.SSS";
                        }
                    }
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, JSON.defaultLocale);
                    simpleDateFormat.setTimeZone(JSON.defaultTimeZone);
                    try {
                        return simpleDateFormat.parse(str2);
                    } catch (ParseException unused) {
                        throw new JSONException("can not cast to Date, value : " + str2);
                    }
                } else if (str2.length() == 0) {
                    return null;
                } else {
                    j = Long.parseLong(str2);
                }
            } finally {
                jSONScanner.close();
            }
        } else {
            j = -1;
        }
        if (j != -1) {
            return new Date(j);
        }
        Class<?> cls = obj.getClass();
        if ("oracle.sql.TIMESTAMP".equals(cls.getName())) {
            if (oracleTimestampMethod == null && !oracleTimestampMethodInited) {
                try {
                    oracleTimestampMethod = cls.getMethod("toJdbc", new Class[0]);
                } catch (NoSuchMethodException unused2) {
                } catch (Throwable th) {
                    oracleTimestampMethodInited = true;
                    throw th;
                }
                oracleTimestampMethodInited = true;
            }
            try {
                return (Date) oracleTimestampMethod.invoke(obj, new Object[0]);
            } catch (Exception e) {
                throw new JSONException("can not cast oracle.sql.TIMESTAMP to Date", e);
            }
        } else if ("oracle.sql.DATE".equals(cls.getName())) {
            if (oracleDateMethod == null && !oracleDateMethodInited) {
                try {
                    oracleDateMethod = cls.getMethod("toJdbc", new Class[0]);
                } catch (NoSuchMethodException unused3) {
                } catch (Throwable th2) {
                    oracleDateMethodInited = true;
                    throw th2;
                }
                oracleDateMethodInited = true;
            }
            try {
                return (Date) oracleDateMethod.invoke(obj, new Object[0]);
            } catch (Exception e2) {
                throw new JSONException("can not cast oracle.sql.DATE to Date", e2);
            }
        } else {
            throw new JSONException("can not cast to Date, value : " + obj);
        }
    }

    public static java.sql.Date castToSqlDate(Object obj) {
        long j;
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.sql.Date) {
            return (java.sql.Date) obj;
        }
        if (obj instanceof Date) {
            return new java.sql.Date(((Date) obj).getTime());
        }
        if (obj instanceof Calendar) {
            return new java.sql.Date(((Calendar) obj).getTimeInMillis());
        }
        if (obj instanceof BigDecimal) {
            j = longValue((BigDecimal) obj);
        } else {
            j = obj instanceof Number ? ((Number) obj).longValue() : 0;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (isNumber(str)) {
                j = Long.parseLong(str);
            } else {
                JSONScanner jSONScanner = new JSONScanner(str);
                if (jSONScanner.scanISO8601DateIfMatch(false)) {
                    j = jSONScanner.getCalendar().getTime().getTime();
                } else {
                    throw new JSONException("can not cast to Timestamp, value : " + str);
                }
            }
        }
        if (j > 0) {
            return new java.sql.Date(j);
        }
        throw new JSONException("can not cast to Date, value : " + obj);
    }

    public static long longExtractValue(Number number) {
        if (number instanceof BigDecimal) {
            return ((BigDecimal) number).longValueExact();
        }
        return number.longValue();
    }

    public static Time castToSqlTime(Object obj) {
        long j;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Time) {
            return (Time) obj;
        }
        if (obj instanceof Date) {
            return new Time(((Date) obj).getTime());
        }
        if (obj instanceof Calendar) {
            return new Time(((Calendar) obj).getTimeInMillis());
        }
        if (obj instanceof BigDecimal) {
            j = longValue((BigDecimal) obj);
        } else {
            j = obj instanceof Number ? ((Number) obj).longValue() : 0;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equalsIgnoreCase(str)) {
                return null;
            }
            if (isNumber(str)) {
                j = Long.parseLong(str);
            } else {
                JSONScanner jSONScanner = new JSONScanner(str);
                if (jSONScanner.scanISO8601DateIfMatch(false)) {
                    j = jSONScanner.getCalendar().getTime().getTime();
                } else {
                    throw new JSONException("can not cast to Timestamp, value : " + str);
                }
            }
        }
        if (j > 0) {
            return new Time(j);
        }
        throw new JSONException("can not cast to Date, value : " + obj);
    }

    public static Timestamp castToTimestamp(Object obj) {
        long j;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Calendar) {
            return new Timestamp(((Calendar) obj).getTimeInMillis());
        }
        if (obj instanceof Timestamp) {
            return (Timestamp) obj;
        }
        if (obj instanceof Date) {
            return new Timestamp(((Date) obj).getTime());
        }
        if (obj instanceof BigDecimal) {
            j = longValue((BigDecimal) obj);
        } else {
            j = obj instanceof Number ? ((Number) obj).longValue() : 0;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (str.endsWith(".000000000")) {
                str = str.substring(0, str.length() - 10);
            } else if (str.endsWith(".000000")) {
                str = str.substring(0, str.length() - 7);
            }
            if (str.length() == 29 && str.charAt(4) == '-' && str.charAt(7) == '-' && str.charAt(10) == ' ' && str.charAt(13) == ':' && str.charAt(16) == ':' && str.charAt(19) == '.') {
                return new Timestamp(num(str.charAt(0), str.charAt(1), str.charAt(2), str.charAt(3)) - 1900, num(str.charAt(5), str.charAt(6)) - 1, num(str.charAt(8), str.charAt(9)), num(str.charAt(11), str.charAt(12)), num(str.charAt(14), str.charAt(15)), num(str.charAt(17), str.charAt(18)), num(str.charAt(20), str.charAt(21), str.charAt(22), str.charAt(23), str.charAt(24), str.charAt(25), str.charAt(26), str.charAt(27), str.charAt(28)));
            } else if (isNumber(str)) {
                j = Long.parseLong(str);
            } else {
                JSONScanner jSONScanner = new JSONScanner(str);
                if (jSONScanner.scanISO8601DateIfMatch(false)) {
                    j = jSONScanner.getCalendar().getTime().getTime();
                } else {
                    throw new JSONException("can not cast to Timestamp, value : " + str);
                }
            }
        }
        if (j > 0) {
            return new Timestamp(j);
        }
        throw new JSONException("can not cast to Timestamp, value : " + obj);
    }

    public static boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '+' || charAt == '-') {
                if (i != 0) {
                    return false;
                }
            } else if (charAt < '0' || charAt > '9') {
                return false;
            }
        }
        return true;
    }

    public static Long castToLong(Object obj) {
        Calendar calendar = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return Long.valueOf(longValue((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (str.indexOf(44) != -1) {
                str = str.replaceAll(",", "");
            }
            try {
                return Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                JSONScanner jSONScanner = new JSONScanner(str);
                if (jSONScanner.scanISO8601DateIfMatch(false)) {
                    calendar = jSONScanner.getCalendar();
                }
                jSONScanner.close();
                if (calendar != null) {
                    return Long.valueOf(calendar.getTimeInMillis());
                }
            }
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                Iterator it2 = map.values().iterator();
                it2.next();
                return castToLong(it2.next());
            }
        }
        throw new JSONException("can not cast to long, value : " + obj);
    }

    public static byte byteValue(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return 0;
        }
        int scale = bigDecimal.scale();
        if (scale < -100 || scale > 100) {
            return bigDecimal.byteValueExact();
        }
        return bigDecimal.byteValue();
    }

    public static short shortValue(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return 0;
        }
        int scale = bigDecimal.scale();
        if (scale < -100 || scale > 100) {
            return bigDecimal.shortValueExact();
        }
        return bigDecimal.shortValue();
    }

    public static int intValue(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return 0;
        }
        int scale = bigDecimal.scale();
        if (scale < -100 || scale > 100) {
            return bigDecimal.intValueExact();
        }
        return bigDecimal.intValue();
    }

    public static long longValue(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return 0;
        }
        int scale = bigDecimal.scale();
        if (scale < -100 || scale > 100) {
            return bigDecimal.longValueExact();
        }
        return bigDecimal.longValue();
    }

    public static Integer castToInt(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof BigDecimal) {
            return Integer.valueOf(intValue((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (str.indexOf(44) != -1) {
                str = str.replaceAll(",", "");
            }
            Matcher matcher = NUMBER_WITH_TRAILING_ZEROS_PATTERN.matcher(str);
            if (matcher.find()) {
                str = matcher.replaceAll("");
            }
            return Integer.valueOf(Integer.parseInt(str));
        } else if (obj instanceof Boolean) {
            return Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                    Iterator it2 = map.values().iterator();
                    it2.next();
                    return castToInt(it2.next());
                }
            }
            throw new JSONException("can not cast to int, value : " + obj);
        }
    }

    public static byte[] castToBytes(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            return IOUtils.decodeBase64((String) obj);
        }
        throw new JSONException("can not cast to byte[], value : " + obj);
    }

    public static Boolean castToBoolean(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        boolean z = false;
        if (obj instanceof BigDecimal) {
            if (intValue((BigDecimal) obj) == 1) {
                z = true;
            }
            return Boolean.valueOf(z);
        } else if (obj instanceof Number) {
            if (((Number) obj).intValue() == 1) {
                z = true;
            }
            return Boolean.valueOf(z);
        } else {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                    return null;
                }
                if ("true".equalsIgnoreCase(str) || "1".equals(str)) {
                    return Boolean.TRUE;
                }
                if ("false".equalsIgnoreCase(str) || "0".equals(str)) {
                    return Boolean.FALSE;
                }
                if ("Y".equalsIgnoreCase(str) || "T".equals(str)) {
                    return Boolean.TRUE;
                }
                if ("F".equalsIgnoreCase(str) || "N".equals(str)) {
                    return Boolean.FALSE;
                }
            }
            throw new JSONException("can not cast to boolean, value : " + obj);
        }
    }

    public static <T> T castToJavaBean(Object obj, Class<T> cls) {
        return (T) cast(obj, (Class<Object>) cls, ParserConfig.getGlobalInstance());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T cast(Object obj, Class<T> cls, ParserConfig parserConfig) {
        T t;
        int i = 0;
        if (obj == 0) {
            if (cls == Integer.TYPE) {
                return (T) 0;
            }
            if (cls == Long.TYPE) {
                return (T) 0L;
            }
            if (cls == Short.TYPE) {
                return (T) 0;
            }
            if (cls == Byte.TYPE) {
                return (T) (byte) 0;
            }
            if (cls == Float.TYPE) {
                return (T) Float.valueOf(0.0f);
            }
            if (cls == Double.TYPE) {
                return (T) Double.valueOf(0.0d);
            }
            if (cls == Boolean.TYPE) {
                return (T) Boolean.FALSE;
            }
            return null;
        } else if (cls == null) {
            throw new IllegalArgumentException("clazz is null");
        } else if (cls == obj.getClass()) {
            return obj;
        } else {
            if (!(obj instanceof Map)) {
                if (cls.isArray()) {
                    if (obj instanceof Collection) {
                        Collection<Object> collection = (Collection) obj;
                        T t2 = (T) Array.newInstance(cls.getComponentType(), collection.size());
                        for (Object obj2 : collection) {
                            Array.set(t2, i, cast(obj2, (Class<Object>) cls.getComponentType(), parserConfig));
                            i++;
                        }
                        return t2;
                    } else if (cls == byte[].class) {
                        return (T) castToBytes(obj);
                    }
                }
                if (cls.isAssignableFrom(obj.getClass())) {
                    return obj;
                }
                if (cls == Boolean.TYPE || cls == Boolean.class) {
                    return (T) castToBoolean(obj);
                }
                if (cls == Byte.TYPE || cls == Byte.class) {
                    return (T) castToByte(obj);
                }
                if (cls == Character.TYPE || cls == Character.class) {
                    return (T) castToChar(obj);
                }
                if (cls == Short.TYPE || cls == Short.class) {
                    return (T) castToShort(obj);
                }
                if (cls == Integer.TYPE || cls == Integer.class) {
                    return (T) castToInt(obj);
                }
                if (cls == Long.TYPE || cls == Long.class) {
                    return (T) castToLong(obj);
                }
                if (cls == Float.TYPE || cls == Float.class) {
                    return (T) castToFloat(obj);
                }
                if (cls == Double.TYPE || cls == Double.class) {
                    return (T) castToDouble(obj);
                }
                if (cls == String.class) {
                    return (T) castToString(obj);
                }
                if (cls == BigDecimal.class) {
                    return (T) castToBigDecimal(obj);
                }
                if (cls == BigInteger.class) {
                    return (T) castToBigInteger(obj);
                }
                if (cls == Date.class) {
                    return (T) castToDate(obj);
                }
                if (cls == java.sql.Date.class) {
                    return (T) castToSqlDate(obj);
                }
                if (cls == Time.class) {
                    return (T) castToSqlTime(obj);
                }
                if (cls == Timestamp.class) {
                    return (T) castToTimestamp(obj);
                }
                if (cls.isEnum()) {
                    return (T) castToEnum(obj, cls, parserConfig);
                }
                if (Calendar.class.isAssignableFrom(cls)) {
                    Date castToDate = castToDate(obj);
                    if (cls == Calendar.class) {
                        t = (T) Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
                    } else {
                        try {
                            t = cls.newInstance();
                        } catch (Exception e) {
                            throw new JSONException("can not cast to : " + cls.getName(), e);
                        }
                    }
                    t.setTime(castToDate);
                    return t;
                }
                String name = cls.getName();
                if (name.equals("javax.xml.datatype.XMLGregorianCalendar")) {
                    Date castToDate2 = castToDate(obj);
                    Calendar instance = Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
                    instance.setTime(castToDate2);
                    return (T) CalendarCodec.instance.createXMLGregorianCalendar(instance);
                }
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                        return null;
                    }
                    if (cls == Currency.class) {
                        return (T) Currency.getInstance(str);
                    }
                    if (cls == Locale.class) {
                        return (T) toLocale(str);
                    }
                    if (name.startsWith("java.time.")) {
                        return (T) JSON.parseObject(JSON.toJSONString(str), cls);
                    }
                }
                if (parserConfig.get(cls) != null) {
                    return (T) JSON.parseObject(JSON.toJSONString(obj), cls);
                }
                throw new JSONException("can not cast to : " + cls.getName());
            } else if (cls == Map.class) {
                return obj;
            } else {
                Map map = (Map) obj;
                return (cls != Object.class || map.containsKey(JSON.DEFAULT_TYPE_KEY)) ? (T) castToJavaBean(map, cls, parserConfig) : obj;
            }
        }
    }

    public static Locale toLocale(String str) {
        String[] split = str.split("_");
        if (split.length == 1) {
            return new Locale(split[0]);
        }
        if (split.length == 2) {
            return new Locale(split[0], split[1]);
        }
        return new Locale(split[0], split[1], split[2]);
    }

    public static <T> T castToEnum(Object obj, Class<T> cls, ParserConfig parserConfig) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                if (parserConfig == null) {
                    parserConfig = ParserConfig.getGlobalInstance();
                }
                ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
                return deserializer instanceof EnumDeserializer ? (T) ((EnumDeserializer) deserializer).getEnumByHashCode(fnv1a_64(str)) : (T) Enum.valueOf(cls, str);
            }
            if (obj instanceof BigDecimal) {
                int intValue = intValue((BigDecimal) obj);
                T[] enumConstants = cls.getEnumConstants();
                if (intValue < enumConstants.length) {
                    return enumConstants[intValue];
                }
            }
            if (obj instanceof Number) {
                int intValue2 = ((Number) obj).intValue();
                T[] enumConstants2 = cls.getEnumConstants();
                if (intValue2 < enumConstants2.length) {
                    return enumConstants2[intValue2];
                }
            }
            throw new JSONException("can not cast to : " + cls.getName());
        } catch (Exception e) {
            throw new JSONException("can not cast to : " + cls.getName(), e);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T cast(Object obj, Type type, ParserConfig parserConfig) {
        if (obj == 0) {
            return null;
        }
        if (type instanceof Class) {
            return (T) cast(obj, (Class<Object>) ((Class) type), parserConfig);
        }
        if (type instanceof ParameterizedType) {
            return (T) cast(obj, (ParameterizedType) type, parserConfig);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
        }
        if (type instanceof TypeVariable) {
            return obj;
        }
        throw new JSONException("can not cast to : " + type);
    }

    public static <T> T cast(Object obj, ParameterizedType parameterizedType, ParserConfig parserConfig) {
        Object obj2;
        Object obj3;
        Type rawType = parameterizedType.getRawType();
        if (rawType == List.class || rawType == ArrayList.class) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof List) {
                List list = (List) obj;
                T t = (T) new ArrayList(list.size());
                for (int i = 0; i < list.size(); i++) {
                    Object obj4 = list.get(i);
                    if (!(type instanceof Class)) {
                        obj3 = cast(obj4, type, parserConfig);
                    } else if (obj4 == null || obj4.getClass() != JSONObject.class) {
                        obj3 = cast(obj4, (Class<Object>) ((Class) type), parserConfig);
                    } else {
                        obj3 = ((JSONObject) obj4).toJavaObject((Class) type, parserConfig, 0);
                    }
                    t.add(obj3);
                }
                return t;
            }
        }
        if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == Collection.class || rawType == List.class || rawType == ArrayList.class) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof Iterable) {
                T t2 = (rawType == Set.class || rawType == HashSet.class) ? (T) new HashSet() : rawType == TreeSet.class ? (T) new TreeSet() : (T) new ArrayList();
                for (T t3 : (Iterable) obj) {
                    if (!(type2 instanceof Class)) {
                        obj2 = cast(t3, type2, parserConfig);
                    } else if (t3 == null || t3.getClass() != JSONObject.class) {
                        obj2 = cast((Object) t3, (Class<Object>) ((Class) type2), parserConfig);
                    } else {
                        obj2 = t3.toJavaObject((Class) type2, parserConfig, 0);
                    }
                    t2.add(obj2);
                }
                return t2;
            }
        }
        if (rawType == Map.class || rawType == HashMap.class) {
            Type type3 = parameterizedType.getActualTypeArguments()[0];
            Type type4 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof Map) {
                T t4 = (T) new HashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    t4.put(cast(entry.getKey(), type3, parserConfig), cast(entry.getValue(), type4, parserConfig));
                }
                return t4;
            }
        }
        if ((obj instanceof String) && ((String) obj).length() == 0) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (actualTypeArguments.length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
            return (T) cast(obj, rawType, parserConfig);
        }
        if (rawType == Map.Entry.class && (obj instanceof Map)) {
            Map map = (Map) obj;
            if (map.size() == 1) {
                T t5 = (T) ((Map.Entry) map.entrySet().iterator().next());
                Object value = t5.getValue();
                if (actualTypeArguments.length == 2 && (value instanceof Map)) {
                    t5.setValue(cast(value, actualTypeArguments[1], parserConfig));
                }
                return t5;
            }
        }
        if (rawType instanceof Class) {
            if (parserConfig == null) {
                parserConfig = ParserConfig.global;
            }
            ObjectDeserializer deserializer = parserConfig.getDeserializer(rawType);
            if (deserializer != null) {
                return (T) deserializer.deserialze(new DefaultJSONParser(JSON.toJSONString(obj), parserConfig), parameterizedType, null);
            }
        }
        throw new JSONException("can not cast to : " + parameterizedType);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Map<java.lang.String, java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T castToJavaBean(Map<String, Object> map, Class<T> cls, ParserConfig parserConfig) {
        JSONObject jSONObject;
        int i = 0;
        if (cls == StackTraceElement.class) {
            try {
                String str = (String) map.get("className");
                String str2 = (String) map.get("methodName");
                String str3 = (String) map.get("fileName");
                Number number = (Number) map.get("lineNumber");
                if (number != null) {
                    if (number instanceof BigDecimal) {
                        i = ((BigDecimal) number).intValueExact();
                    } else {
                        i = number.intValue();
                    }
                }
                return (T) new StackTraceElement(str, str2, str3, i);
            } catch (Exception e) {
                throw new JSONException(e.getMessage(), e);
            }
        } else {
            Object obj = map.get(JSON.DEFAULT_TYPE_KEY);
            JavaBeanDeserializer javaBeanDeserializer = null;
            if (obj instanceof String) {
                String str4 = (String) obj;
                if (parserConfig == null) {
                    parserConfig = ParserConfig.global;
                }
                Class<?> checkAutoType = parserConfig.checkAutoType(str4, null);
                if (checkAutoType == null) {
                    throw new ClassNotFoundException(str4 + " not found");
                } else if (!checkAutoType.equals(cls)) {
                    return (T) castToJavaBean(map, checkAutoType, parserConfig);
                }
            }
            if (cls.isInterface()) {
                if (map instanceof JSONObject) {
                    jSONObject = (JSONObject) map;
                } else {
                    jSONObject = new JSONObject(map);
                }
                if (parserConfig == null) {
                    parserConfig = ParserConfig.getGlobalInstance();
                }
                return parserConfig.get(cls) != null ? (T) JSON.parseObject(JSON.toJSONString(jSONObject), cls) : (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, jSONObject);
            }
            if (cls == Locale.class) {
                Object obj2 = map.get("language");
                Object obj3 = map.get("country");
                if (obj2 instanceof String) {
                    String str5 = (String) obj2;
                    if (obj3 instanceof String) {
                        return (T) new Locale(str5, (String) obj3);
                    }
                    if (obj3 == null) {
                        return (T) new Locale(str5);
                    }
                }
            }
            if (cls == String.class && (map instanceof JSONObject)) {
                return (T) map.toString();
            }
            if (cls == JSON.class && (map instanceof JSONObject)) {
                return map;
            }
            if (cls == LinkedHashMap.class && (map instanceof JSONObject)) {
                T t = (T) ((JSONObject) map).getInnerMap();
                if (t instanceof LinkedHashMap) {
                    return t;
                }
                new LinkedHashMap().putAll(t);
            }
            if (cls.isInstance(map)) {
                return map;
            }
            if (cls == JSONObject.class) {
                return (T) new JSONObject(map);
            }
            if (parserConfig == null) {
                parserConfig = ParserConfig.getGlobalInstance();
            }
            ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
            if (deserializer instanceof JavaBeanDeserializer) {
                javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
            }
            if (javaBeanDeserializer != null) {
                return (T) javaBeanDeserializer.createInstance(map, parserConfig);
            }
            throw new JSONException("can not get javaBeanDeserializer. " + cls.getName());
        }
    }

    private static void addBaseClassMappings() {
        mappings.put("byte", Byte.TYPE);
        mappings.put("short", Short.TYPE);
        mappings.put("int", Integer.TYPE);
        mappings.put("long", Long.TYPE);
        mappings.put("float", Float.TYPE);
        mappings.put("double", Double.TYPE);
        mappings.put("boolean", Boolean.TYPE);
        mappings.put("char", Character.TYPE);
        mappings.put("[byte", byte[].class);
        mappings.put("[short", short[].class);
        mappings.put("[int", int[].class);
        mappings.put("[long", long[].class);
        mappings.put("[float", float[].class);
        mappings.put("[double", double[].class);
        mappings.put("[boolean", boolean[].class);
        mappings.put("[char", char[].class);
        mappings.put("[B", byte[].class);
        mappings.put("[S", short[].class);
        mappings.put("[I", int[].class);
        mappings.put("[J", long[].class);
        mappings.put("[F", float[].class);
        mappings.put("[D", double[].class);
        mappings.put("[C", char[].class);
        mappings.put("[Z", boolean[].class);
        Class<?>[] clsArr = {Object.class, Cloneable.class, loadClass("java.lang.AutoCloseable"), Exception.class, RuntimeException.class, IllegalAccessError.class, IllegalAccessException.class, IllegalArgumentException.class, IllegalMonitorStateException.class, IllegalStateException.class, IllegalThreadStateException.class, IndexOutOfBoundsException.class, InstantiationError.class, InstantiationException.class, InternalError.class, InterruptedException.class, LinkageError.class, NegativeArraySizeException.class, NoClassDefFoundError.class, NoSuchFieldError.class, NoSuchFieldException.class, NoSuchMethodError.class, NoSuchMethodException.class, NullPointerException.class, NumberFormatException.class, OutOfMemoryError.class, SecurityException.class, StackOverflowError.class, StringIndexOutOfBoundsException.class, TypeNotPresentException.class, VerifyError.class, StackTraceElement.class, HashMap.class, Hashtable.class, TreeMap.class, IdentityHashMap.class, WeakHashMap.class, LinkedHashMap.class, HashSet.class, LinkedHashSet.class, TreeSet.class, ArrayList.class, TimeUnit.class, ConcurrentHashMap.class, AtomicInteger.class, AtomicLong.class, Collections.EMPTY_MAP.getClass(), Boolean.class, Character.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, Number.class, String.class, BigDecimal.class, BigInteger.class, BitSet.class, Calendar.class, Date.class, Locale.class, UUID.class, Time.class, java.sql.Date.class, Timestamp.class, SimpleDateFormat.class, JSONObject.class, JSONPObject.class, JSONArray.class};
        for (int i = 0; i < 71; i++) {
            Class<?> cls = clsArr[i];
            if (cls != null) {
                mappings.put(cls.getName(), cls);
            }
        }
    }

    public static void clearClassMapping() {
        mappings.clear();
        addBaseClassMappings();
    }

    public static void addMapping(String str, Class<?> cls) {
        mappings.put(str, cls);
    }

    public static Class<?> loadClass(String str) {
        return loadClass(str, null);
    }

    public static boolean isPath(Class<?> cls) {
        if (pathClass == null && !pathClass_error) {
            try {
                pathClass = Class.forName("java.nio.file.Path");
            } catch (Throwable unused) {
                pathClass_error = true;
            }
        }
        Class<?> cls2 = pathClass;
        if (cls2 != null) {
            return cls2.isAssignableFrom(cls);
        }
        return false;
    }

    public static Class<?> getClassFromMapping(String str) {
        return mappings.get(str);
    }

    public static Class<?> loadClass(String str, ClassLoader classLoader) {
        return loadClass(str, classLoader, false);
    }

    public static Class<?> loadClass(String str, ClassLoader classLoader, boolean z) {
        if (str == null || str.length() == 0 || str.length() > 128) {
            return null;
        }
        Class<?> cls = mappings.get(str);
        if (cls != null) {
            return cls;
        }
        if (str.charAt(0) == '[') {
            return Array.newInstance(loadClass(str.substring(1), classLoader), 0).getClass();
        }
        if (str.startsWith("L") && str.endsWith(";")) {
            return loadClass(str.substring(1, str.length() - 1), classLoader);
        }
        if (classLoader != null) {
            try {
                Class<?> loadClass = classLoader.loadClass(str);
                if (z) {
                    mappings.put(str, loadClass);
                }
                return loadClass;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (!(contextClassLoader == null || contextClassLoader == classLoader)) {
                Class<?> loadClass2 = contextClassLoader.loadClass(str);
                if (z) {
                    try {
                        mappings.put(str, loadClass2);
                    } catch (Throwable unused) {
                        cls = loadClass2;
                    }
                }
                return loadClass2;
            }
        } catch (Throwable unused2) {
        }
        try {
            cls = Class.forName(str);
            if (z) {
                mappings.put(str, cls);
            }
        } catch (Throwable unused3) {
        }
        return cls;
    }

    public static SerializeBeanInfo buildBeanInfo(Class<?> cls, Map<String, String> map, PropertyNamingStrategy propertyNamingStrategy) {
        return buildBeanInfo(cls, map, propertyNamingStrategy, false);
    }

    public static SerializeBeanInfo buildBeanInfo(Class<?> cls, Map<String, String> map, PropertyNamingStrategy propertyNamingStrategy, boolean z) {
        int i;
        PropertyNamingStrategy propertyNamingStrategy2;
        String str;
        String str2;
        String[] strArr;
        List<FieldInfo> list;
        List<FieldInfo> list2;
        JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
        String str3 = null;
        if (jSONType != null) {
            String[] orders = jSONType.orders();
            String typeName = jSONType.typeName();
            if (typeName.length() == 0) {
                typeName = null;
            }
            PropertyNamingStrategy naming = jSONType.naming();
            if (naming == PropertyNamingStrategy.CamelCase) {
                naming = propertyNamingStrategy;
            }
            int of = SerializerFeature.of(jSONType.serialzeFeatures());
            Class<? super Object> superclass = cls.getSuperclass();
            String str4 = null;
            while (superclass != null && superclass != Object.class) {
                JSONType jSONType2 = (JSONType) getAnnotation(superclass, JSONType.class);
                if (jSONType2 == null) {
                    break;
                }
                str4 = jSONType2.typeKey();
                if (str4.length() != 0) {
                    break;
                }
                superclass = superclass.getSuperclass();
            }
            for (Class<?> cls2 : cls.getInterfaces()) {
                JSONType jSONType3 = (JSONType) getAnnotation(cls2, JSONType.class);
                if (jSONType3 != null) {
                    str4 = jSONType3.typeKey();
                    if (str4.length() != 0) {
                        break;
                    }
                }
            }
            if (str4 == null || str4.length() != 0) {
                str3 = str4;
            }
            str = str3;
            strArr = orders;
            str2 = typeName;
            propertyNamingStrategy2 = naming;
            i = of;
        } else {
            propertyNamingStrategy2 = propertyNamingStrategy;
            strArr = null;
            str2 = null;
            str = null;
            i = 0;
        }
        HashMap hashMap = new HashMap();
        ParserConfig.parserAllFieldToCache(cls, hashMap);
        if (z) {
            list = computeGettersWithFieldBase(cls, map, false, propertyNamingStrategy2);
        } else {
            list = computeGetters(cls, jSONType, map, hashMap, false, propertyNamingStrategy2);
        }
        FieldInfo[] fieldInfoArr = new FieldInfo[list.size()];
        list.toArray(fieldInfoArr);
        if (strArr == null || strArr.length == 0) {
            ArrayList arrayList = new ArrayList(list);
            Collections.sort(arrayList);
            list2 = arrayList;
        } else if (z) {
            list2 = computeGettersWithFieldBase(cls, map, true, propertyNamingStrategy2);
        } else {
            list2 = computeGetters(cls, jSONType, map, hashMap, true, propertyNamingStrategy2);
        }
        FieldInfo[] fieldInfoArr2 = new FieldInfo[list2.size()];
        list2.toArray(fieldInfoArr2);
        return new SerializeBeanInfo(cls, jSONType, str2, str, i, fieldInfoArr, Arrays.equals(fieldInfoArr2, fieldInfoArr) ? fieldInfoArr : fieldInfoArr2);
    }

    public static List<FieldInfo> computeGettersWithFieldBase(Class<?> cls, Map<String, String> map, boolean z, PropertyNamingStrategy propertyNamingStrategy) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            computeFields(cls2, map, propertyNamingStrategy, linkedHashMap, cls2.getDeclaredFields());
        }
        return getFieldInfos(cls, z, linkedHashMap);
    }

    public static List<FieldInfo> computeGetters(Class<?> cls, Map<String, String> map) {
        return computeGetters(cls, map, true);
    }

    public static List<FieldInfo> computeGetters(Class<?> cls, Map<String, String> map, boolean z) {
        HashMap hashMap = new HashMap();
        ParserConfig.parserAllFieldToCache(cls, hashMap);
        return computeGetters(cls, (JSONType) getAnnotation(cls, JSONType.class), map, hashMap, z, PropertyNamingStrategy.CamelCase);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0294, code lost:
        if (r2 == null) goto L_0x0514;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x033a, code lost:
        if (r1 == null) goto L_0x0514;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x044b, code lost:
        if (r2 == null) goto L_0x0512;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x04a8, code lost:
        if (r0 == null) goto L_0x0514;
     */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x02cd  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x03b8  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x03e9  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0416  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0459  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x04ea  */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x04f5  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x04f7  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x021e  */
    public static List<FieldInfo> computeGetters(Class<?> cls, JSONType jSONType, Map<String, String> map, Map<String, Field> map2, boolean z, PropertyNamingStrategy propertyNamingStrategy) {
        Method[] methodArr;
        int i;
        int i2;
        Annotation[][] annotationArr;
        LinkedHashMap linkedHashMap;
        JSONField jSONField;
        String[] strArr;
        short[] sArr;
        Boolean bool;
        Constructor<?>[] constructorArr;
        LinkedHashMap linkedHashMap2;
        int i3;
        int i4;
        int i5;
        Method method;
        String str;
        int i6;
        char charAt;
        Class<?> cls2;
        Field field;
        String str2;
        String str3;
        JSONField jSONField2;
        int i7;
        int i8;
        int i9;
        Field field2;
        String str4;
        String str5;
        int i10;
        int i11;
        JSONField jSONField3;
        Boolean bool2;
        boolean z2;
        char charAt2;
        JSONField jSONField4;
        JSONField jSONField5;
        Field fieldFromCache;
        Class<?> cls3 = cls;
        Map<String, String> map3 = map;
        Map<String, Field> map4 = map2;
        PropertyNamingStrategy propertyNamingStrategy2 = propertyNamingStrategy;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        boolean isKotlin = isKotlin(cls);
        Annotation[][] annotationArr2 = null;
        Method[] methods = cls.getMethods();
        int length = methods.length;
        Constructor<?>[] constructorArr2 = null;
        String[] strArr2 = null;
        short[] sArr2 = null;
        int i12 = 0;
        while (i12 < length) {
            Method method2 = methods[i12];
            String name = method2.getName();
            String str6 = null;
            if (!Modifier.isStatic(method2.getModifiers()) && !method2.getReturnType().equals(Void.TYPE) && method2.getParameterTypes().length == 0 && method2.getReturnType() != ClassLoader.class && ((!name.equals("getMetaClass") || !method2.getReturnType().getName().equals("groovy.lang.MetaClass")) && ((!name.equals("getSuppressed") || method2.getDeclaringClass() != Throwable.class) && (!isKotlin || !isKotlinIgnore(cls3, name))))) {
                JSONField jSONField6 = (JSONField) getAnnotation(method2, JSONField.class);
                if (jSONField6 == null) {
                    jSONField6 = getSuperMethodAnnotation(cls3, method2);
                }
                annotationArr = annotationArr2;
                if (jSONField6 != null || !isKotlin) {
                    jSONField4 = jSONField6;
                    bool = false;
                    constructorArr = constructorArr2;
                } else {
                    if (constructorArr2 == null) {
                        constructorArr2 = cls.getDeclaredConstructors();
                        Constructor koltinConstructor = getKoltinConstructor(constructorArr2);
                        if (koltinConstructor != null) {
                            Annotation[][] parameterAnnotations = getParameterAnnotations(koltinConstructor);
                            String[] koltinConstructorParameters = getKoltinConstructorParameters(cls);
                            if (koltinConstructorParameters != null) {
                                String[] strArr3 = new String[koltinConstructorParameters.length];
                                bool = false;
                                System.arraycopy(koltinConstructorParameters, 0, strArr3, 0, koltinConstructorParameters.length);
                                Arrays.sort(strArr3);
                                short[] sArr3 = new short[koltinConstructorParameters.length];
                                annotationArr = parameterAnnotations;
                                for (short s = 0; s < koltinConstructorParameters.length; s = (short) (s + 1)) {
                                    sArr3[Arrays.binarySearch(strArr3, koltinConstructorParameters[s])] = s;
                                }
                                strArr2 = strArr3;
                                sArr2 = sArr3;
                                constructorArr2 = constructorArr2;
                            } else {
                                annotationArr = parameterAnnotations;
                                bool = false;
                                strArr2 = koltinConstructorParameters;
                            }
                            if (strArr2 != null || sArr2 == null || !name.startsWith("get")) {
                                constructorArr = constructorArr2;
                                strArr = strArr2;
                                jSONField4 = jSONField6;
                                jSONField = jSONField4;
                                sArr = sArr2;
                                if (jSONField == null) {
                                    if (jSONField.serialize()) {
                                        i5 = jSONField.ordinal();
                                        i4 = SerializerFeature.of(jSONField.serialzeFeatures());
                                        i3 = Feature.of(jSONField.parseFeatures());
                                        if (jSONField.name().length() != 0) {
                                            String name2 = jSONField.name();
                                            if (map3 == null || (name2 = map3.get(name2)) != null) {
                                                i2 = i12;
                                                i = length;
                                                methodArr = methods;
                                                linkedHashMap2 = linkedHashMap3;
                                                linkedHashMap2.put(name2, new FieldInfo(name2, method2, null, cls, null, i5, i4, i3, jSONField, null, null));
                                                linkedHashMap = linkedHashMap2;
                                                propertyNamingStrategy2 = propertyNamingStrategy;
                                                constructorArr2 = constructorArr;
                                                sArr2 = sArr;
                                                strArr2 = strArr;
                                            }
                                        } else {
                                            i2 = i12;
                                            i = length;
                                            methodArr = methods;
                                            linkedHashMap2 = linkedHashMap3;
                                            if (jSONField.label().length() != 0) {
                                                str6 = jSONField.label();
                                            }
                                        }
                                    }
                                    i2 = i12;
                                    i = length;
                                    methodArr = methods;
                                    linkedHashMap = linkedHashMap3;
                                    constructorArr2 = constructorArr;
                                    sArr2 = sArr;
                                    strArr2 = strArr;
                                } else {
                                    i2 = i12;
                                    i = length;
                                    methodArr = methods;
                                    linkedHashMap2 = linkedHashMap3;
                                    i5 = 0;
                                    i4 = 0;
                                    i3 = 0;
                                }
                                if (!name.startsWith("get")) {
                                    if (name.length() >= 4 && !name.equals("getClass") && (!name.equals("getDeclaringClass") || !cls.isEnum())) {
                                        char charAt3 = name.charAt(3);
                                        if (Character.isUpperCase(charAt3) || charAt3 > 512) {
                                            str4 = getPropertyNameByCompatibleFieldName(map4, name, compatibleWithJavaBean ? decapitalize(name.substring(3)) : Character.toLowerCase(name.charAt(3)) + name.substring(4), 3);
                                        } else {
                                            if (charAt3 == '_') {
                                                str4 = name.substring(4);
                                                field2 = map4.get(str4);
                                                if (field2 == null) {
                                                    String substring = name.substring(3);
                                                    Field fieldFromCache2 = ParserConfig.getFieldFromCache(substring, map4);
                                                    if (fieldFromCache2 != null) {
                                                        str4 = substring;
                                                    }
                                                    field2 = fieldFromCache2;
                                                }
                                            } else if (charAt3 == 'f') {
                                                str4 = name.substring(3);
                                            } else if (name.length() < 5 || !Character.isUpperCase(name.charAt(4))) {
                                                str4 = name.substring(3);
                                                field2 = ParserConfig.getFieldFromCache(str4, map4);
                                            } else {
                                                str4 = decapitalize(name.substring(3));
                                            }
                                            if (!isJSONTypeIgnore(cls3, str4)) {
                                                if (field2 == null) {
                                                    field2 = ParserConfig.getFieldFromCache(str4, map4);
                                                }
                                                if (field2 == null && str4.length() > 1 && (charAt2 = str4.charAt(1)) >= 'A' && charAt2 <= 'Z') {
                                                    field2 = ParserConfig.getFieldFromCache(decapitalize(name.substring(3)), map4);
                                                }
                                                if (field2 != null) {
                                                    JSONField jSONField7 = (JSONField) getAnnotation(field2, JSONField.class);
                                                    if (jSONField7 == null) {
                                                        i10 = i4;
                                                        str5 = str6;
                                                        jSONField3 = jSONField7;
                                                    } else if (jSONField7.serialize()) {
                                                        int ordinal = jSONField7.ordinal();
                                                        int of = SerializerFeature.of(jSONField7.serialzeFeatures());
                                                        int of2 = Feature.of(jSONField7.parseFeatures());
                                                        if (jSONField7.name().length() != 0) {
                                                            z2 = true;
                                                            str4 = jSONField7.name();
                                                            if (map3 != null) {
                                                                str4 = map3.get(str4);
                                                            }
                                                        } else {
                                                            z2 = bool;
                                                        }
                                                        if (jSONField7.label().length() != 0) {
                                                            str6 = jSONField7.label();
                                                        }
                                                        i10 = of;
                                                        i3 = of2;
                                                        str5 = str6;
                                                        bool2 = z2;
                                                        jSONField3 = jSONField7;
                                                        i11 = ordinal;
                                                        if (map3 == null || (str4 = map3.get(str4)) != null) {
                                                            if (propertyNamingStrategy != null && !bool2.booleanValue()) {
                                                                str4 = propertyNamingStrategy.translate(str4);
                                                            }
                                                            linkedHashMap2 = linkedHashMap2;
                                                            str = name;
                                                            method = method2;
                                                            i6 = 3;
                                                            linkedHashMap2.put(str4, new FieldInfo(str4, method2, field2, cls, null, i11, i10, i3, jSONField, jSONField3, str5));
                                                            i5 = i11;
                                                            i4 = i10;
                                                            str6 = str5;
                                                        }
                                                    }
                                                } else {
                                                    i10 = i4;
                                                    jSONField3 = null;
                                                    str5 = str6;
                                                }
                                                i11 = i5;
                                                bool2 = bool;
                                                str4 = propertyNamingStrategy.translate(str4);
                                                linkedHashMap2 = linkedHashMap2;
                                                str = name;
                                                method = method2;
                                                i6 = 3;
                                                linkedHashMap2.put(str4, new FieldInfo(str4, method2, field2, cls, null, i11, i10, i3, jSONField, jSONField3, str5));
                                                i5 = i11;
                                                i4 = i10;
                                                str6 = str5;
                                            }
                                        }
                                        field2 = null;
                                        if (!isJSONTypeIgnore(cls3, str4)) {
                                        }
                                    }
                                    linkedHashMap = linkedHashMap2;
                                    propertyNamingStrategy2 = propertyNamingStrategy;
                                    constructorArr2 = constructorArr;
                                    sArr2 = sArr;
                                    strArr2 = strArr;
                                } else {
                                    str = name;
                                    method = method2;
                                    i6 = 3;
                                }
                                if (str.startsWith("is") && str.length() >= i6 && (method.getReturnType() == Boolean.TYPE || method.getReturnType() == Boolean.class)) {
                                    charAt = str.charAt(2);
                                    if (!Character.isUpperCase(charAt)) {
                                        str2 = getPropertyNameByCompatibleFieldName(map4, str, compatibleWithJavaBean ? decapitalize(str.substring(2)) : Character.toLowerCase(str.charAt(2)) + str.substring(i6), 2);
                                    } else {
                                        if (charAt == '_') {
                                            String substring2 = str.substring(i6);
                                            field = map4.get(substring2);
                                            if (field == null) {
                                                str2 = str.substring(2);
                                                field = ParserConfig.getFieldFromCache(str2, map4);
                                                if (field == null) {
                                                    str2 = substring2;
                                                }
                                            } else {
                                                cls2 = cls;
                                                str2 = substring2;
                                                if (!isJSONTypeIgnore(cls2, str2)) {
                                                    if (field == null) {
                                                        field = ParserConfig.getFieldFromCache(str2, map4);
                                                    }
                                                    Field fieldFromCache3 = field == null ? ParserConfig.getFieldFromCache(str, map4) : field;
                                                    if (fieldFromCache3 != null) {
                                                        JSONField jSONField8 = (JSONField) getAnnotation(fieldFromCache3, JSONField.class);
                                                        if (jSONField8 == null) {
                                                            map3 = map;
                                                            jSONField2 = jSONField8;
                                                            i9 = i5;
                                                            i8 = i4;
                                                        } else if (jSONField8.serialize()) {
                                                            int ordinal2 = jSONField8.ordinal();
                                                            int of3 = SerializerFeature.of(jSONField8.serialzeFeatures());
                                                            int of4 = Feature.of(jSONField8.parseFeatures());
                                                            if (jSONField8.name().length() != 0) {
                                                                str2 = jSONField8.name();
                                                                map3 = map;
                                                                if (map3 != null) {
                                                                    str2 = map3.get(str2);
                                                                }
                                                            } else {
                                                                map3 = map;
                                                            }
                                                            if (jSONField8.label().length() != 0) {
                                                                jSONField2 = jSONField8;
                                                                i8 = of3;
                                                                i7 = of4;
                                                                str3 = jSONField8.label();
                                                                i9 = ordinal2;
                                                            } else {
                                                                jSONField2 = jSONField8;
                                                                i9 = ordinal2;
                                                                i8 = of3;
                                                                i7 = of4;
                                                                str3 = str6;
                                                            }
                                                            if (map3 == null || (str2 = map3.get(str2)) != null) {
                                                                propertyNamingStrategy2 = propertyNamingStrategy;
                                                                if (propertyNamingStrategy2 != null) {
                                                                    str2 = propertyNamingStrategy2.translate(str2);
                                                                }
                                                                if (!linkedHashMap2.containsKey(str2)) {
                                                                    linkedHashMap = linkedHashMap2;
                                                                } else {
                                                                    FieldInfo fieldInfo = new FieldInfo(str2, method, fieldFromCache3, cls, null, i9, i8, i7, jSONField, jSONField2, str3);
                                                                    linkedHashMap = linkedHashMap2;
                                                                    linkedHashMap.put(str2, fieldInfo);
                                                                }
                                                                constructorArr2 = constructorArr;
                                                                sArr2 = sArr;
                                                                strArr2 = strArr;
                                                            }
                                                            linkedHashMap = linkedHashMap2;
                                                            propertyNamingStrategy2 = propertyNamingStrategy;
                                                            constructorArr2 = constructorArr;
                                                            sArr2 = sArr;
                                                            strArr2 = strArr;
                                                        }
                                                    } else {
                                                        map3 = map;
                                                        i9 = i5;
                                                        i8 = i4;
                                                        jSONField2 = null;
                                                    }
                                                    str3 = str6;
                                                    i7 = i3;
                                                    propertyNamingStrategy2 = propertyNamingStrategy;
                                                    if (propertyNamingStrategy2 != null) {
                                                    }
                                                    if (!linkedHashMap2.containsKey(str2)) {
                                                    }
                                                    constructorArr2 = constructorArr;
                                                    sArr2 = sArr;
                                                    strArr2 = strArr;
                                                }
                                            }
                                        } else if (charAt == 'f') {
                                            str2 = str.substring(2);
                                        } else {
                                            str2 = str.substring(2);
                                            field = ParserConfig.getFieldFromCache(str2, map4);
                                        }
                                        cls2 = cls;
                                        if (!isJSONTypeIgnore(cls2, str2)) {
                                        }
                                    }
                                    cls2 = cls;
                                    field = null;
                                    if (!isJSONTypeIgnore(cls2, str2)) {
                                    }
                                }
                                map3 = map;
                                linkedHashMap = linkedHashMap2;
                                propertyNamingStrategy2 = propertyNamingStrategy;
                                constructorArr2 = constructorArr;
                                sArr2 = sArr;
                                strArr2 = strArr;
                            } else {
                                String decapitalize = decapitalize(name.substring(3));
                                int binarySearch = Arrays.binarySearch(strArr2, decapitalize);
                                constructorArr = constructorArr2;
                                jSONField4 = jSONField6;
                                if (binarySearch < 0) {
                                    int i13 = 0;
                                    while (true) {
                                        if (i13 >= strArr2.length) {
                                            break;
                                        } else if (decapitalize.equalsIgnoreCase(strArr2[i13])) {
                                            binarySearch = i13;
                                            break;
                                        } else {
                                            i13++;
                                        }
                                    }
                                }
                                if (binarySearch >= 0) {
                                    Annotation[] annotationArr3 = annotationArr[sArr2[binarySearch]];
                                    if (annotationArr3 != null) {
                                        int length2 = annotationArr3.length;
                                        int i14 = 0;
                                        while (true) {
                                            if (i14 >= length2) {
                                                break;
                                            }
                                            strArr = strArr2;
                                            Annotation annotation = annotationArr3[i14];
                                            if (annotation instanceof JSONField) {
                                                jSONField5 = (JSONField) annotation;
                                                break;
                                            }
                                            i14++;
                                            strArr2 = strArr;
                                            annotationArr3 = annotationArr3;
                                        }
                                        if (jSONField5 == null || (fieldFromCache = ParserConfig.getFieldFromCache(decapitalize, map4)) == null) {
                                            sArr = sArr2;
                                            jSONField = jSONField5;
                                            if (jSONField == null) {
                                            }
                                            if (!name.startsWith("get")) {
                                            }
                                            charAt = str.charAt(2);
                                            if (!Character.isUpperCase(charAt)) {
                                            }
                                            cls2 = cls;
                                            field = null;
                                            if (!isJSONTypeIgnore(cls2, str2)) {
                                            }
                                            map3 = map;
                                            linkedHashMap = linkedHashMap2;
                                            propertyNamingStrategy2 = propertyNamingStrategy;
                                            constructorArr2 = constructorArr;
                                            sArr2 = sArr;
                                            strArr2 = strArr;
                                        } else {
                                            jSONField = (JSONField) getAnnotation(fieldFromCache, JSONField.class);
                                            sArr = sArr2;
                                            if (jSONField == null) {
                                            }
                                            if (!name.startsWith("get")) {
                                            }
                                            charAt = str.charAt(2);
                                            if (!Character.isUpperCase(charAt)) {
                                            }
                                            cls2 = cls;
                                            field = null;
                                            if (!isJSONTypeIgnore(cls2, str2)) {
                                            }
                                            map3 = map;
                                            linkedHashMap = linkedHashMap2;
                                            propertyNamingStrategy2 = propertyNamingStrategy;
                                            constructorArr2 = constructorArr;
                                            sArr2 = sArr;
                                            strArr2 = strArr;
                                        }
                                    }
                                    strArr = strArr2;
                                    jSONField5 = jSONField4;
                                    if (jSONField5 == null) {
                                    }
                                    sArr = sArr2;
                                    jSONField = jSONField5;
                                    if (jSONField == null) {
                                    }
                                    if (!name.startsWith("get")) {
                                    }
                                    charAt = str.charAt(2);
                                    if (!Character.isUpperCase(charAt)) {
                                    }
                                    cls2 = cls;
                                    field = null;
                                    if (!isJSONTypeIgnore(cls2, str2)) {
                                    }
                                    map3 = map;
                                    linkedHashMap = linkedHashMap2;
                                    propertyNamingStrategy2 = propertyNamingStrategy;
                                    constructorArr2 = constructorArr;
                                    sArr2 = sArr;
                                    strArr2 = strArr;
                                }
                            }
                        }
                    }
                    bool = false;
                    if (strArr2 != null) {
                    }
                    constructorArr = constructorArr2;
                    strArr = strArr2;
                    jSONField4 = jSONField6;
                    jSONField = jSONField4;
                    sArr = sArr2;
                    if (jSONField == null) {
                    }
                    if (!name.startsWith("get")) {
                    }
                    charAt = str.charAt(2);
                    if (!Character.isUpperCase(charAt)) {
                    }
                    cls2 = cls;
                    field = null;
                    if (!isJSONTypeIgnore(cls2, str2)) {
                    }
                    map3 = map;
                    linkedHashMap = linkedHashMap2;
                    propertyNamingStrategy2 = propertyNamingStrategy;
                    constructorArr2 = constructorArr;
                    sArr2 = sArr;
                    strArr2 = strArr;
                }
                strArr = strArr2;
                jSONField = jSONField4;
                sArr = sArr2;
                if (jSONField == null) {
                }
                if (!name.startsWith("get")) {
                }
                charAt = str.charAt(2);
                if (!Character.isUpperCase(charAt)) {
                }
                cls2 = cls;
                field = null;
                if (!isJSONTypeIgnore(cls2, str2)) {
                }
                map3 = map;
                linkedHashMap = linkedHashMap2;
                propertyNamingStrategy2 = propertyNamingStrategy;
                constructorArr2 = constructorArr;
                sArr2 = sArr;
                strArr2 = strArr;
            } else {
                annotationArr = annotationArr2;
                i2 = i12;
                i = length;
                methodArr = methods;
                linkedHashMap = linkedHashMap3;
            }
            i12 = i2 + 1;
            cls3 = cls;
            map4 = map2;
            linkedHashMap3 = linkedHashMap;
            annotationArr2 = annotationArr;
            length = i;
            methods = methodArr;
        }
        computeFields(cls, map3, propertyNamingStrategy2, linkedHashMap3, cls.getFields());
        return getFieldInfos(cls, z, linkedHashMap3);
    }

    private static List<FieldInfo> getFieldInfos(Class<?> cls, boolean z, Map<String, FieldInfo> map) {
        ArrayList arrayList = new ArrayList();
        JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
        String[] orders = jSONType != null ? jSONType.orders() : null;
        if (orders == null || orders.length <= 0) {
            for (FieldInfo fieldInfo : map.values()) {
                arrayList.add(fieldInfo);
            }
            if (z) {
                Collections.sort(arrayList);
            }
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap(arrayList.size());
            for (FieldInfo fieldInfo2 : map.values()) {
                linkedHashMap.put(fieldInfo2.name, fieldInfo2);
            }
            for (String str : orders) {
                FieldInfo fieldInfo3 = (FieldInfo) linkedHashMap.get(str);
                if (fieldInfo3 != null) {
                    arrayList.add(fieldInfo3);
                    linkedHashMap.remove(str);
                }
            }
            for (FieldInfo fieldInfo4 : linkedHashMap.values()) {
                arrayList.add(fieldInfo4);
            }
        }
        return arrayList;
    }

    private static void computeFields(Class<?> cls, Map<String, String> map, PropertyNamingStrategy propertyNamingStrategy, Map<String, FieldInfo> map2, Field[] fieldArr) {
        String str;
        int i;
        int i2;
        int i3;
        for (Field field : fieldArr) {
            if (!Modifier.isStatic(field.getModifiers())) {
                JSONField jSONField = (JSONField) getAnnotation(field, JSONField.class);
                String name = field.getName();
                String str2 = null;
                if (jSONField == null) {
                    str = null;
                    i3 = 0;
                    i2 = 0;
                    i = 0;
                } else if (jSONField.serialize()) {
                    int ordinal = jSONField.ordinal();
                    int of = SerializerFeature.of(jSONField.serialzeFeatures());
                    int of2 = Feature.of(jSONField.parseFeatures());
                    if (jSONField.name().length() != 0) {
                        name = jSONField.name();
                    }
                    if (jSONField.label().length() != 0) {
                        str2 = jSONField.label();
                    }
                    str = str2;
                    i3 = ordinal;
                    i2 = of;
                    i = of2;
                }
                if (map == null || (name = map.get(name)) != null) {
                    if (propertyNamingStrategy != null) {
                        name = propertyNamingStrategy.translate(name);
                    }
                    if (!map2.containsKey(name)) {
                        map2.put(name, new FieldInfo(name, null, field, cls, null, i3, i2, i, null, jSONField, str));
                    }
                }
            }
        }
    }

    private static String getPropertyNameByCompatibleFieldName(Map<String, Field> map, String str, String str2, int i) {
        if (!compatibleWithFieldName || map.containsKey(str2)) {
            return str2;
        }
        String substring = str.substring(i);
        return map.containsKey(substring) ? substring : str2;
    }

    public static JSONField getSuperMethodAnnotation(Class<?> cls, Method method) {
        boolean z;
        JSONField jSONField;
        boolean z2;
        JSONField jSONField2;
        Class<?>[] interfaces = cls.getInterfaces();
        if (interfaces.length > 0) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> cls2 : interfaces) {
                Method[] methods = cls2.getMethods();
                for (Method method2 : methods) {
                    Class<?>[] parameterTypes2 = method2.getParameterTypes();
                    if (parameterTypes2.length == parameterTypes.length && method2.getName().equals(method.getName())) {
                        int i = 0;
                        while (true) {
                            if (i >= parameterTypes.length) {
                                z2 = true;
                                break;
                            } else if (!parameterTypes2[i].equals(parameterTypes[i])) {
                                z2 = false;
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (z2 && (jSONField2 = (JSONField) getAnnotation(method2, JSONField.class)) != null) {
                            return jSONField2;
                        }
                    }
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && Modifier.isAbstract(superclass.getModifiers())) {
            Class<?>[] parameterTypes3 = method.getParameterTypes();
            Method[] methods2 = superclass.getMethods();
            for (Method method3 : methods2) {
                Class<?>[] parameterTypes4 = method3.getParameterTypes();
                if (parameterTypes4.length == parameterTypes3.length && method3.getName().equals(method.getName())) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= parameterTypes3.length) {
                            z = true;
                            break;
                        } else if (!parameterTypes4[i2].equals(parameterTypes3[i2])) {
                            z = false;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (z && (jSONField = (JSONField) getAnnotation(method3, JSONField.class)) != null) {
                        return jSONField;
                    }
                }
            }
        }
        return null;
    }

    private static boolean isJSONTypeIgnore(Class<?> cls, String str) {
        String[] ignores;
        JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
        if (jSONType != null) {
            String[] includes = jSONType.includes();
            if (includes.length > 0) {
                for (String str2 : includes) {
                    if (str.equals(str2)) {
                        return false;
                    }
                }
                return true;
            }
            for (String str3 : jSONType.ignores()) {
                if (str.equals(str3)) {
                    return true;
                }
            }
        }
        if (cls.getSuperclass() == Object.class || cls.getSuperclass() == null) {
            return false;
        }
        return isJSONTypeIgnore(cls.getSuperclass(), str);
    }

    public static boolean isGenericParamType(Type type) {
        Type genericSuperclass;
        if (type instanceof ParameterizedType) {
            return true;
        }
        if (!(type instanceof Class) || (genericSuperclass = ((Class) type).getGenericSuperclass()) == Object.class || !isGenericParamType(genericSuperclass)) {
            return false;
        }
        return true;
    }

    public static Type getGenericParamType(Type type) {
        return (!(type instanceof ParameterizedType) && (type instanceof Class)) ? getGenericParamType(((Class) type).getGenericSuperclass()) : type;
    }

    public static Type unwrapOptional(Type type) {
        if (!optionalClassInited) {
            try {
                optionalClass = Class.forName("java.util.Optional");
            } catch (Exception unused) {
            } catch (Throwable th) {
                optionalClassInited = true;
                throw th;
            }
            optionalClassInited = true;
        }
        if (!(type instanceof ParameterizedType)) {
            return type;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        return parameterizedType.getRawType() == optionalClass ? parameterizedType.getActualTypeArguments()[0] : type;
    }

    public static Class<?> getClass(Type type) {
        if (type.getClass() == Class.class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getClass(((ParameterizedType) type).getRawType());
        }
        if (type instanceof TypeVariable) {
            Type type2 = ((TypeVariable) type).getBounds()[0];
            if (type2 instanceof Class) {
                return (Class) type2;
            }
            return getClass(type2);
        } else if (!(type instanceof WildcardType)) {
            return Object.class;
        } else {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            if (upperBounds.length == 1) {
                return getClass(upperBounds[0]);
            }
            return Object.class;
        }
    }

    public static Field getField(Class<?> cls, String str, Field[] fieldArr) {
        char charAt;
        char charAt2;
        for (Field field : fieldArr) {
            String name = field.getName();
            if (str.equals(name)) {
                return field;
            }
            if (str.length() > 2 && (charAt = str.charAt(0)) >= 'a' && charAt <= 'z' && (charAt2 = str.charAt(1)) >= 'A' && charAt2 <= 'Z' && str.equalsIgnoreCase(name)) {
                return field;
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || superclass == Object.class) {
            return null;
        }
        return getField(superclass, str, superclass.getDeclaredFields());
    }

    public static int getSerializeFeatures(Class<?> cls) {
        JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
        if (jSONType == null) {
            return 0;
        }
        return SerializerFeature.of(jSONType.serialzeFeatures());
    }

    public static int getParserFeatures(Class<?> cls) {
        JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
        if (jSONType == null) {
            return 0;
        }
        return Feature.of(jSONType.parseFeatures());
    }

    public static String decapitalize(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    static void setAccessible(AccessibleObject accessibleObject) {
        if (setAccessibleEnable && !accessibleObject.isAccessible()) {
            try {
                accessibleObject.setAccessible(true);
            } catch (AccessControlException unused) {
                setAccessibleEnable = false;
            }
        }
    }

    public static Type getCollectionItemType(Type type) {
        if (type instanceof ParameterizedType) {
            return getCollectionItemType((ParameterizedType) type);
        }
        if (type instanceof Class) {
            return getCollectionItemType((Class<?>) ((Class) type));
        }
        return Object.class;
    }

    private static Type getCollectionItemType(Class<?> cls) {
        if (cls.getName().startsWith("java.")) {
            return Object.class;
        }
        return getCollectionItemType(getCollectionSuperType(cls));
    }

    private static Type getCollectionItemType(ParameterizedType parameterizedType) {
        Type rawType = parameterizedType.getRawType();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (rawType == Collection.class) {
            return getWildcardTypeUpperBounds(actualTypeArguments[0]);
        }
        Class cls = (Class) rawType;
        Map<TypeVariable, Type> createActualTypeMap = createActualTypeMap(cls.getTypeParameters(), actualTypeArguments);
        Type collectionSuperType = getCollectionSuperType(cls);
        if (!(collectionSuperType instanceof ParameterizedType)) {
            return getCollectionItemType((Class<?>) ((Class) collectionSuperType));
        }
        Class<?> rawClass = getRawClass(collectionSuperType);
        Type[] actualTypeArguments2 = ((ParameterizedType) collectionSuperType).getActualTypeArguments();
        if (actualTypeArguments2.length > 0) {
            return getCollectionItemType(makeParameterizedType(rawClass, actualTypeArguments2, createActualTypeMap));
        }
        return getCollectionItemType(rawClass);
    }

    private static Type getCollectionSuperType(Class<?> cls) {
        Type[] genericInterfaces = cls.getGenericInterfaces();
        Type type = null;
        for (Type type2 : genericInterfaces) {
            Class<?> rawClass = getRawClass(type2);
            if (rawClass == Collection.class) {
                return type2;
            }
            if (Collection.class.isAssignableFrom(rawClass)) {
                type = type2;
            }
        }
        return type == null ? cls.getGenericSuperclass() : type;
    }

    private static Map<TypeVariable, Type> createActualTypeMap(TypeVariable[] typeVariableArr, Type[] typeArr) {
        int length = typeVariableArr.length;
        HashMap hashMap = new HashMap(length);
        for (int i = 0; i < length; i++) {
            hashMap.put(typeVariableArr[i], typeArr[i]);
        }
        return hashMap;
    }

    private static ParameterizedType makeParameterizedType(Class<?> cls, Type[] typeArr, Map<TypeVariable, Type> map) {
        int length = typeArr.length;
        Type[] typeArr2 = new Type[length];
        for (int i = 0; i < length; i++) {
            typeArr2[i] = getActualType(typeArr[i], map);
        }
        return new ParameterizedTypeImpl(typeArr2, null, cls);
    }

    private static Type getActualType(Type type, Map<TypeVariable, Type> map) {
        if (type instanceof TypeVariable) {
            return map.get(type);
        }
        if (type instanceof ParameterizedType) {
            return makeParameterizedType(getRawClass(type), ((ParameterizedType) type).getActualTypeArguments(), map);
        }
        return type instanceof GenericArrayType ? new GenericArrayTypeImpl(getActualType(((GenericArrayType) type).getGenericComponentType(), map)) : type;
    }

    private static Type getWildcardTypeUpperBounds(Type type) {
        if (!(type instanceof WildcardType)) {
            return type;
        }
        Type[] upperBounds = ((WildcardType) type).getUpperBounds();
        return upperBounds.length > 0 ? upperBounds[0] : Object.class;
    }

    public static Class<?> getCollectionItemClass(Type type) {
        if (!(type instanceof ParameterizedType)) {
            return Object.class;
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
            if (upperBounds.length == 1) {
                type2 = upperBounds[0];
            }
        }
        if (type2 instanceof Class) {
            Class<?> cls = (Class) type2;
            if (Modifier.isPublic(cls.getModifiers())) {
                return cls;
            }
            throw new JSONException("can not create ASMParser");
        }
        throw new JSONException("can not create ASMParser");
    }

    public static Type checkPrimitiveArray(GenericArrayType genericArrayType) {
        Type genericComponentType = genericArrayType.getGenericComponentType();
        String str = "[";
        while (genericComponentType instanceof GenericArrayType) {
            genericComponentType = ((GenericArrayType) genericComponentType).getGenericComponentType();
            str = str + str;
        }
        if (!(genericComponentType instanceof Class)) {
            return genericArrayType;
        }
        Class cls = (Class) genericComponentType;
        if (!cls.isPrimitive()) {
            return genericArrayType;
        }
        try {
            if (cls == Boolean.TYPE) {
                return Class.forName(str + "Z");
            } else if (cls == Character.TYPE) {
                return Class.forName(str + "C");
            } else if (cls == Byte.TYPE) {
                return Class.forName(str + "B");
            } else if (cls == Short.TYPE) {
                return Class.forName(str + "S");
            } else if (cls == Integer.TYPE) {
                return Class.forName(str + "I");
            } else if (cls == Long.TYPE) {
                return Class.forName(str + "J");
            } else if (cls == Float.TYPE) {
                return Class.forName(str + "F");
            } else if (cls != Double.TYPE) {
                return genericArrayType;
            } else {
                return Class.forName(str + "D");
            }
        } catch (ClassNotFoundException unused) {
            return genericArrayType;
        }
    }

    public static Collection createCollection(Type type) {
        Type type2;
        Class<?> rawClass = getRawClass(type);
        if (rawClass == AbstractCollection.class || rawClass == Collection.class) {
            return new ArrayList();
        }
        if (rawClass.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (rawClass.isAssignableFrom(LinkedHashSet.class)) {
            return new LinkedHashSet();
        }
        if (rawClass.isAssignableFrom(TreeSet.class)) {
            return new TreeSet();
        }
        if (rawClass.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        if (rawClass.isAssignableFrom(EnumSet.class)) {
            if (type instanceof ParameterizedType) {
                type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            } else {
                type2 = Object.class;
            }
            return EnumSet.noneOf(type2);
        } else if (rawClass.isAssignableFrom(Queue.class) || rawClass.isAssignableFrom(Deque.class)) {
            return new LinkedList();
        } else {
            try {
                return (Collection) rawClass.newInstance();
            } catch (Exception unused) {
                throw new JSONException("create instance error, class " + rawClass.getName());
            }
        }
    }

    public static Class<?> getRawClass(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getRawClass(((ParameterizedType) type).getRawType());
        }
        if (type instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            if (upperBounds.length == 1) {
                return getRawClass(upperBounds[0]);
            }
            throw new JSONException("TODO");
        }
        throw new JSONException("TODO");
    }

    public static boolean isProxy(Class<?> cls) {
        for (Class<?> cls2 : cls.getInterfaces()) {
            String name = cls2.getName();
            if (name.equals("net.sf.cglib.proxy.Factory") || name.equals("org.springframework.cglib.proxy.Factory") || name.equals("javassist.util.proxy.ProxyObject") || name.equals("org.apache.ibatis.javassist.util.proxy.ProxyObject") || name.equals("org.hibernate.proxy.HibernateProxy")) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends java.lang.annotation.Annotation> */
    public static boolean isTransient(Method method) {
        if (method == null) {
            return false;
        }
        if (!transientClassInited) {
            try {
                transientClass = Class.forName("java.beans.Transient");
            } catch (Exception unused) {
            } catch (Throwable th) {
                transientClassInited = true;
                throw th;
            }
            transientClassInited = true;
        }
        Class<? extends Annotation> cls = transientClass;
        if (cls == null || getAnnotation(method, (Class<Annotation>) cls) == null) {
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Type inference failed for r1v4. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends java.lang.annotation.Annotation> */
    public static boolean isAnnotationPresentOneToMany(Method method) {
        if (method == null) {
            return false;
        }
        if (class_OneToMany == null && !class_OneToMany_error) {
            try {
                class_OneToMany = Class.forName("javax.persistence.OneToMany");
            } catch (Throwable unused) {
                class_OneToMany_error = true;
            }
        }
        Class<? extends Annotation> cls = class_OneToMany;
        if (cls == null || !method.isAnnotationPresent(cls)) {
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Type inference failed for r1v7. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends java.lang.annotation.Annotation> */
    public static boolean isAnnotationPresentManyToMany(Method method) {
        if (method == null) {
            return false;
        }
        if (class_ManyToMany == null && !class_ManyToMany_error) {
            try {
                class_ManyToMany = Class.forName("javax.persistence.ManyToMany");
            } catch (Throwable unused) {
                class_ManyToMany_error = true;
            }
        }
        if (class_ManyToMany == null) {
            return false;
        }
        if (method.isAnnotationPresent(class_OneToMany) || method.isAnnotationPresent(class_ManyToMany)) {
            return true;
        }
        return false;
    }

    public static boolean isHibernateInitialized(Object obj) {
        if (obj == null) {
            return false;
        }
        if (method_HibernateIsInitialized == null && !method_HibernateIsInitialized_error) {
            try {
                method_HibernateIsInitialized = Class.forName("org.hibernate.Hibernate").getMethod("isInitialized", Object.class);
            } catch (Throwable unused) {
                method_HibernateIsInitialized_error = true;
            }
        }
        Method method = method_HibernateIsInitialized;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(null, obj)).booleanValue();
            } catch (Throwable unused2) {
            }
        }
        return true;
    }

    public static double parseDouble(String str) {
        double d;
        double d2;
        int length = str.length();
        if (length > 10) {
            return Double.parseDouble(str);
        }
        long j = 0;
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '-' && i2 == 0) {
                z = true;
            } else if (charAt == '.') {
                if (i != 0) {
                    return Double.parseDouble(str);
                }
                i = (length - i2) - 1;
            } else if (charAt < '0' || charAt > '9') {
                return Double.parseDouble(str);
            } else {
                j = (j * 10) + ((long) (charAt - '0'));
            }
        }
        if (z) {
            j = -j;
        }
        switch (i) {
            case 0:
                return (double) j;
            case 1:
                d = (double) j;
                d2 = 10.0d;
                break;
            case 2:
                d = (double) j;
                d2 = 100.0d;
                break;
            case 3:
                d = (double) j;
                d2 = 1000.0d;
                break;
            case 4:
                d = (double) j;
                d2 = 10000.0d;
                break;
            case 5:
                d = (double) j;
                d2 = 100000.0d;
                break;
            case 6:
                d = (double) j;
                d2 = 1000000.0d;
                break;
            case 7:
                d = (double) j;
                d2 = 1.0E7d;
                break;
            case 8:
                d = (double) j;
                d2 = 1.0E8d;
                break;
            case 9:
                d = (double) j;
                d2 = 1.0E9d;
                break;
            default:
                return Double.parseDouble(str);
        }
        return d / d2;
    }

    public static float parseFloat(String str) {
        float f;
        float f2;
        int length = str.length();
        if (length >= 10) {
            return Float.parseFloat(str);
        }
        long j = 0;
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '-' && i2 == 0) {
                z = true;
            } else if (charAt == '.') {
                if (i != 0) {
                    return Float.parseFloat(str);
                }
                i = (length - i2) - 1;
            } else if (charAt < '0' || charAt > '9') {
                return Float.parseFloat(str);
            } else {
                j = (j * 10) + ((long) (charAt - '0'));
            }
        }
        if (z) {
            j = -j;
        }
        switch (i) {
            case 0:
                return (float) j;
            case 1:
                f = (float) j;
                f2 = 10.0f;
                break;
            case 2:
                f = (float) j;
                f2 = 100.0f;
                break;
            case 3:
                f = (float) j;
                f2 = 1000.0f;
                break;
            case 4:
                f = (float) j;
                f2 = 10000.0f;
                break;
            case 5:
                f = (float) j;
                f2 = 100000.0f;
                break;
            case 6:
                f = (float) j;
                f2 = 1000000.0f;
                break;
            case 7:
                f = (float) j;
                f2 = 1.0E7f;
                break;
            case 8:
                f = (float) j;
                f2 = 1.0E8f;
                break;
            case 9:
                f = (float) j;
                f2 = 1.0E9f;
                break;
            default:
                return Float.parseFloat(str);
        }
        return f / f2;
    }

    public static long fnv1a_64_lower(String str) {
        long j = -3750763034362895579L;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!(charAt == '_' || charAt == '-')) {
                if (charAt >= 'A' && charAt <= 'Z') {
                    charAt = (char) (charAt + ' ');
                }
                j = (j ^ ((long) charAt)) * 1099511628211L;
            }
        }
        return j;
    }

    public static long fnv1a_64(String str) {
        long j = -3750763034362895579L;
        for (int i = 0; i < str.length(); i++) {
            j = (j ^ ((long) str.charAt(i))) * 1099511628211L;
        }
        return j;
    }

    public static boolean isKotlin(Class cls) {
        if (kotlin_metadata == null && !kotlin_metadata_error) {
            try {
                kotlin_metadata = Class.forName("kotlin.Metadata");
            } catch (Throwable unused) {
                kotlin_metadata_error = true;
            }
        }
        if (kotlin_metadata == null || !cls.isAnnotationPresent(kotlin_metadata)) {
            return false;
        }
        return true;
    }

    public static Constructor getKoltinConstructor(Constructor[] constructorArr) {
        return getKoltinConstructor(constructorArr, null);
    }

    public static Constructor getKoltinConstructor(Constructor[] constructorArr, String[] strArr) {
        Constructor constructor = null;
        for (Constructor constructor2 : constructorArr) {
            Class<?>[] parameterTypes = constructor2.getParameterTypes();
            if ((strArr == null || parameterTypes.length == strArr.length) && ((parameterTypes.length <= 0 || !parameterTypes[parameterTypes.length - 1].getName().equals("kotlin.jvm.internal.DefaultConstructorMarker")) && (constructor == null || constructor.getParameterTypes().length < parameterTypes.length))) {
                constructor = constructor2;
            }
        }
        return constructor;
    }

    public static String[] getKoltinConstructorParameters(Class cls) {
        if (kotlin_kclass_constructor == null && !kotlin_class_klass_error) {
            try {
                kotlin_kclass_constructor = Class.forName("kotlin.reflect.jvm.internal.KClassImpl").getConstructor(Class.class);
            } catch (Throwable unused) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_kclass_constructor == null) {
            return null;
        }
        if (kotlin_kclass_getConstructors == null && !kotlin_class_klass_error) {
            try {
                kotlin_kclass_getConstructors = Class.forName("kotlin.reflect.jvm.internal.KClassImpl").getMethod("getConstructors", new Class[0]);
            } catch (Throwable unused2) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_kfunction_getParameters == null && !kotlin_class_klass_error) {
            try {
                kotlin_kfunction_getParameters = Class.forName("kotlin.reflect.KFunction").getMethod("getParameters", new Class[0]);
            } catch (Throwable unused3) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_kparameter_getName == null && !kotlin_class_klass_error) {
            try {
                kotlin_kparameter_getName = Class.forName("kotlin.reflect.KParameter").getMethod("getName", new Class[0]);
            } catch (Throwable unused4) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_error) {
            return null;
        }
        try {
            Iterator it2 = ((Iterable) kotlin_kclass_getConstructors.invoke(kotlin_kclass_constructor.newInstance(cls), new Object[0])).iterator();
            Object obj = null;
            while (it2.hasNext()) {
                Object next = it2.next();
                List list = (List) kotlin_kfunction_getParameters.invoke(next, new Object[0]);
                if (obj == null || list.size() != 0) {
                    obj = next;
                }
                it2.hasNext();
            }
            if (obj == null) {
                return null;
            }
            List list2 = (List) kotlin_kfunction_getParameters.invoke(obj, new Object[0]);
            String[] strArr = new String[list2.size()];
            for (int i = 0; i < list2.size(); i++) {
                strArr[i] = (String) kotlin_kparameter_getName.invoke(list2.get(i), new Object[0]);
            }
            return strArr;
        } catch (Throwable th) {
            th.printStackTrace();
            kotlin_error = true;
            return null;
        }
    }

    private static boolean isKotlinIgnore(Class cls, String str) {
        String[] strArr;
        if (kotlinIgnores == null && !kotlinIgnores_error) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(Class.forName("kotlin.ranges.CharRange"), new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("kotlin.ranges.IntRange"), new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("kotlin.ranges.LongRange"), new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("kotlin.ranges.ClosedFloatRange"), new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("kotlin.ranges.ClosedDoubleRange"), new String[]{"getEndInclusive", "isEmpty"});
                kotlinIgnores = hashMap;
            } catch (Throwable unused) {
                kotlinIgnores_error = true;
            }
        }
        if (kotlinIgnores == null || (strArr = kotlinIgnores.get(cls)) == null || Arrays.binarySearch(strArr, str) < 0) {
            return false;
        }
        return true;
    }

    public static <A extends Annotation> A getAnnotation(Class<?> cls, Class<A> cls2) {
        A a = (A) cls.getAnnotation(cls2);
        Type mixInAnnotations = JSON.getMixInAnnotations(cls);
        Class cls3 = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (cls3 != null) {
            A a2 = (A) cls3.getAnnotation(cls2);
            if (a2 == null && cls3.getAnnotations().length > 0) {
                for (Annotation annotation : cls3.getAnnotations()) {
                    a2 = (A) annotation.annotationType().getAnnotation(cls2);
                    if (a2 != null) {
                        break;
                    }
                }
            }
            if (a2 != null) {
                return a2;
            }
        }
        if (a == null && cls.getAnnotations().length > 0) {
            for (Annotation annotation2 : cls.getAnnotations()) {
                a = (A) annotation2.annotationType().getAnnotation(cls2);
                if (a != null) {
                    break;
                }
            }
        }
        return a;
    }

    public static <A extends Annotation> A getAnnotation(Field field, Class<A> cls) {
        A a;
        A a2 = (A) field.getAnnotation(cls);
        Type mixInAnnotations = JSON.getMixInAnnotations(field.getDeclaringClass());
        Field field2 = null;
        Class cls2 = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (cls2 != null) {
            String name = field.getName();
            while (cls2 != null && cls2 != Object.class) {
                try {
                    field2 = cls2.getDeclaredField(name);
                    break;
                } catch (NoSuchFieldException unused) {
                    cls2 = cls2.getSuperclass();
                }
            }
            if (!(field2 == null || (a = (A) field2.getAnnotation(cls)) == null)) {
                return a;
            }
        }
        return a2;
    }

    public static <A extends Annotation> A getAnnotation(Method method, Class<A> cls) {
        A a;
        A a2 = (A) method.getAnnotation(cls);
        Type mixInAnnotations = JSON.getMixInAnnotations(method.getDeclaringClass());
        Method method2 = null;
        Class cls2 = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (cls2 != null) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            while (cls2 != null && cls2 != Object.class) {
                try {
                    method2 = cls2.getDeclaredMethod(name, parameterTypes);
                    break;
                } catch (NoSuchMethodException unused) {
                    cls2 = cls2.getSuperclass();
                }
            }
            if (!(method2 == null || (a = (A) method2.getAnnotation(cls)) == null)) {
                return a;
            }
        }
        return a2;
    }

    public static Annotation[][] getParameterAnnotations(Method method) {
        Annotation[][] parameterAnnotations;
        Annotation[][] parameterAnnotations2 = method.getParameterAnnotations();
        Type mixInAnnotations = JSON.getMixInAnnotations(method.getDeclaringClass());
        Method method2 = null;
        Class cls = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (cls != null) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            while (cls != null && cls != Object.class) {
                try {
                    method2 = cls.getDeclaredMethod(name, parameterTypes);
                    break;
                } catch (NoSuchMethodException unused) {
                    cls = cls.getSuperclass();
                }
            }
            if (!(method2 == null || (parameterAnnotations = method2.getParameterAnnotations()) == null)) {
                return parameterAnnotations;
            }
        }
        return parameterAnnotations2;
    }

    public static Annotation[][] getParameterAnnotations(Constructor constructor) {
        Annotation[][] parameterAnnotations;
        Constructor declaredConstructor;
        Annotation[][] parameterAnnotations2 = constructor.getParameterAnnotations();
        Type mixInAnnotations = JSON.getMixInAnnotations(constructor.getDeclaringClass());
        Constructor constructor2 = null;
        Class cls = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (cls != null) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            ArrayList arrayList = new ArrayList(2);
            for (Class<?> enclosingClass = cls.getEnclosingClass(); enclosingClass != null; enclosingClass = enclosingClass.getEnclosingClass()) {
                arrayList.add(enclosingClass);
            }
            int size = arrayList.size();
            Class cls2 = cls;
            while (true) {
                if (cls2 == null || cls2 == Object.class) {
                    break;
                }
                if (size == 0) {
                    declaredConstructor = cls.getDeclaredConstructor(parameterTypes);
                    break;
                }
                try {
                    Class<?>[] clsArr = new Class[(parameterTypes.length + size)];
                    System.arraycopy(parameterTypes, 0, clsArr, size, parameterTypes.length);
                    for (int i = size; i > 0; i--) {
                        int i2 = i - 1;
                        clsArr[i2] = (Class) arrayList.get(i2);
                    }
                    declaredConstructor = cls.getDeclaredConstructor(clsArr);
                } catch (NoSuchMethodException unused) {
                    size--;
                    cls2 = cls2.getSuperclass();
                }
            }
            constructor2 = declaredConstructor;
            if (!(constructor2 == null || (parameterAnnotations = constructor2.getParameterAnnotations()) == null)) {
                return parameterAnnotations;
            }
        }
        return parameterAnnotations2;
    }

    /* JADX DEBUG: Type inference failed for r1v4. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends java.lang.annotation.Annotation> */
    public static boolean isJacksonCreator(Method method) {
        if (method == null) {
            return false;
        }
        if (class_JacksonCreator == null && !class_JacksonCreator_error) {
            try {
                class_JacksonCreator = Class.forName("com.fasterxml.jackson.annotation.JsonCreator");
            } catch (Throwable unused) {
                class_JacksonCreator_error = true;
            }
        }
        Class<? extends Annotation> cls = class_JacksonCreator;
        if (cls == null || !method.isAnnotationPresent(cls)) {
            return false;
        }
        return true;
    }

    public static LocalDateTime castToLocalDateTime(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        if (str == null) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        return LocalDateTime.parse(obj.toString(), DateTimeFormatter.ofPattern(str));
    }
}
