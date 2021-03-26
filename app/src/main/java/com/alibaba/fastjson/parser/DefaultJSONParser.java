package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.JSONPathException;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.MapDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.PropertyProcessable;
import com.alibaba.fastjson.parser.deserializer.ResolveFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class DefaultJSONParser implements Closeable {
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    private static final Set<Class<?>> primitiveClasses = new HashSet();
    private String[] autoTypeAccept;
    private boolean autoTypeEnable;
    protected ParserConfig config;
    protected ParseContext context;
    private ParseContext[] contextArray;
    private int contextArrayIndex;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    private List<ExtraProcessor> extraProcessors;
    private List<ExtraTypeProvider> extraTypeProviders;
    protected FieldTypeResolver fieldTypeResolver;
    public final Object input;
    protected transient BeanContext lastBeanContext;
    public final JSONLexer lexer;
    private int objectKeyLevel;
    public int resolveStatus;
    private List<ResolveTask> resolveTaskList;
    public final SymbolTable symbolTable;

    static {
        Class<?>[] clsArr = {Boolean.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Boolean.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, BigInteger.class, BigDecimal.class, String.class};
        for (int i = 0; i < 17; i++) {
            primitiveClasses.add(clsArr[i]);
        }
    }

    public String getDateFomartPattern() {
        return this.dateFormatPattern;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormatPattern, this.lexer.getLocale());
            this.dateFormat = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.lexer.getTimeZone());
        }
        return this.dateFormat;
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        this.dateFormat = null;
    }

    public void setDateFomrat(DateFormat dateFormat2) {
        this.dateFormat = dateFormat2;
    }

    public DefaultJSONParser(String str) {
        this(str, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig) {
        this(str, new JSONScanner(str, JSON.DEFAULT_PARSER_FEATURE), parserConfig);
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig, int i) {
        this(str, new JSONScanner(str, i), parserConfig);
    }

    public DefaultJSONParser(char[] cArr, int i, ParserConfig parserConfig, int i2) {
        this(cArr, new JSONScanner(cArr, i, i2), parserConfig);
    }

    public DefaultJSONParser(JSONLexer jSONLexer) {
        this(jSONLexer, ParserConfig.getGlobalInstance());
    }

    public DefaultJSONParser(JSONLexer jSONLexer, ParserConfig parserConfig) {
        this((Object) null, jSONLexer, parserConfig);
    }

    public DefaultJSONParser(Object obj, JSONLexer jSONLexer, ParserConfig parserConfig) {
        this.dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.fieldTypeResolver = null;
        this.objectKeyLevel = 0;
        this.autoTypeAccept = null;
        this.lexer = jSONLexer;
        this.input = obj;
        this.config = parserConfig;
        this.symbolTable = parserConfig.symbolTable;
        char current = jSONLexer.getCurrent();
        if (current == '{') {
            jSONLexer.next();
            ((JSONLexerBase) jSONLexer).token = 12;
        } else if (current == '[') {
            jSONLexer.next();
            ((JSONLexerBase) jSONLexer).token = 14;
        } else {
            jSONLexer.nextToken();
        }
    }

    public SymbolTable getSymbolTable() {
        return this.symbolTable;
    }

    public String getInput() {
        Object obj = this.input;
        if (obj instanceof char[]) {
            return new String((char[]) this.input);
        }
        return obj.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:129:0x026f, code lost:
        r10 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0215  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x03f5  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x03fe  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x043b  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0466  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x048f  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x04c2  */
    /* JADX WARNING: Removed duplicated region for block: B:328:0x05c2  */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x05ce  */
    /* JADX WARNING: Removed duplicated region for block: B:336:0x05da  */
    /* JADX WARNING: Removed duplicated region for block: B:341:0x05ef  */
    /* JADX WARNING: Removed duplicated region for block: B:370:0x04cb A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x0186 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:383:0x05e5 A[SYNTHETIC] */
    public final Object parseObject(Map map, Object obj) {
        boolean z;
        Map<String, Object> innerMap;
        boolean z2;
        Object obj2;
        boolean z3;
        char current;
        Object obj3;
        Object obj4;
        char current2;
        Number number;
        Map map2;
        Object obj5;
        boolean z4;
        Object obj6;
        Object obj7;
        Class<?> cls;
        Object obj8;
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
            return null;
        } else if (jSONLexer.token() == 13) {
            jSONLexer.nextToken();
            return map;
        } else if (jSONLexer.token() == 4 && jSONLexer.stringVal().length() == 0) {
            jSONLexer.nextToken();
            return map;
        } else if (jSONLexer.token() == 12 || jSONLexer.token() == 16) {
            ParseContext parseContext = this.context;
            try {
                z = map instanceof JSONObject;
                innerMap = z ? ((JSONObject) map).getInnerMap() : map;
                z2 = false;
            } finally {
                setContext(parseContext);
            }
            while (true) {
                jSONLexer.skipWhitespace();
                char current3 = jSONLexer.getCurrent();
                if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                    while (current3 == ',') {
                        jSONLexer.next();
                        jSONLexer.skipWhitespace();
                        current3 = jSONLexer.getCurrent();
                    }
                }
                boolean z5 = true;
                if (current3 == '\"') {
                    Object scanSymbol = jSONLexer.scanSymbol(this.symbolTable, '\"');
                    jSONLexer.skipWhitespace();
                    obj2 = scanSymbol;
                    if (jSONLexer.getCurrent() != ':') {
                        throw new JSONException("expect ':' at " + jSONLexer.pos() + ", name " + scanSymbol);
                    }
                } else if (current3 == '}') {
                    jSONLexer.next();
                    jSONLexer.resetStringPosition();
                    jSONLexer.nextToken();
                    if (!z2) {
                        ParseContext parseContext2 = this.context;
                        if (parseContext2 != null && obj == parseContext2.fieldName && map == this.context.object) {
                            parseContext = this.context;
                        } else {
                            ParseContext context2 = setContext(map, obj);
                            if (parseContext == null) {
                                parseContext = context2;
                            }
                        }
                    }
                    setContext(parseContext);
                    return map;
                } else if (current3 == '\'') {
                    if (jSONLexer.isEnabled(Feature.AllowSingleQuotes)) {
                        Object scanSymbol2 = jSONLexer.scanSymbol(this.symbolTable, '\'');
                        jSONLexer.skipWhitespace();
                        obj2 = scanSymbol2;
                        if (jSONLexer.getCurrent() != ':') {
                            throw new JSONException("expect ':' at " + jSONLexer.pos());
                        }
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if (current3 == 26) {
                    throw new JSONException("syntax error");
                } else if (current3 == ',') {
                    throw new JSONException("syntax error");
                } else if ((current3 >= '0' && current3 <= '9') || current3 == '-') {
                    jSONLexer.resetStringPosition();
                    jSONLexer.scanNumber();
                    try {
                        if (jSONLexer.token() == 2) {
                            obj8 = jSONLexer.integerValue();
                        } else {
                            obj8 = jSONLexer.decimalValue(true);
                        }
                        if (!jSONLexer.isEnabled(Feature.NonStringKeyAsString)) {
                            if (z) {
                            }
                            obj2 = obj8;
                            if (jSONLexer.getCurrent() != ':') {
                                throw new JSONException("parse number key error" + jSONLexer.info());
                            }
                        }
                        obj8 = obj8.toString();
                        obj2 = obj8;
                        if (jSONLexer.getCurrent() != ':') {
                        }
                    } catch (NumberFormatException unused) {
                        throw new JSONException("parse number key error" + jSONLexer.info());
                    }
                } else if (current3 == '{' || current3 == '[') {
                    int i = this.objectKeyLevel;
                    this.objectKeyLevel = i + 1;
                    if (i <= 512) {
                        jSONLexer.nextToken();
                        obj2 = parse();
                        z3 = true;
                        if (!z3) {
                            jSONLexer.next();
                            jSONLexer.skipWhitespace();
                        }
                        current = jSONLexer.getCurrent();
                        jSONLexer.resetStringPosition();
                        if (obj2 != JSON.DEFAULT_TYPE_KEY && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                            String scanSymbol3 = jSONLexer.scanSymbol(this.symbolTable, '\"');
                            if (!jSONLexer.isEnabled(Feature.IgnoreAutoType)) {
                                if (map == null || !map.getClass().getName().equals(scanSymbol3)) {
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 >= scanSymbol3.length()) {
                                            break;
                                        }
                                        char charAt = scanSymbol3.charAt(i2);
                                        if (charAt < '0' || charAt > '9') {
                                            break;
                                        }
                                        i2++;
                                    }
                                    if (!z5) {
                                        obj7 = null;
                                        cls = this.config.checkAutoType(scanSymbol3, null, jSONLexer.getFeatures());
                                    } else {
                                        obj7 = null;
                                        cls = null;
                                    }
                                } else {
                                    cls = map.getClass();
                                    obj7 = null;
                                }
                                if (cls == null) {
                                    innerMap.put(JSON.DEFAULT_TYPE_KEY, scanSymbol3);
                                } else {
                                    jSONLexer.nextToken(16);
                                    if (jSONLexer.token() == 13) {
                                        jSONLexer.nextToken(16);
                                        try {
                                            Object cast = this.config.getDeserializer(cls) instanceof JavaBeanDeserializer ? TypeUtils.cast((Object) map, (Class<Object>) cls, this.config) : obj7;
                                            if (cast == null) {
                                                if (cls == Cloneable.class) {
                                                    cast = new HashMap();
                                                } else if ("java.util.Collections$EmptyMap".equals(scanSymbol3)) {
                                                    cast = Collections.emptyMap();
                                                } else if ("java.util.Collections$UnmodifiableMap".equals(scanSymbol3)) {
                                                    cast = Collections.unmodifiableMap(new HashMap());
                                                } else {
                                                    cast = cls.newInstance();
                                                }
                                            }
                                            return cast;
                                        } catch (Exception e) {
                                            throw new JSONException("create instance error", e);
                                        }
                                    } else {
                                        setResolveStatus(2);
                                        ParseContext parseContext3 = this.context;
                                        if (parseContext3 != null && obj != null && !(obj instanceof Integer) && !(parseContext3.fieldName instanceof Integer)) {
                                            popContext();
                                        }
                                        if (map.size() > 0) {
                                            Object cast2 = TypeUtils.cast((Object) map, (Class<Object>) cls, this.config);
                                            setResolveStatus(0);
                                            parseObject(cast2);
                                            setContext(parseContext);
                                            return cast2;
                                        }
                                        ObjectDeserializer deserializer = this.config.getDeserializer(cls);
                                        Class<?> cls2 = deserializer.getClass();
                                        if (JavaBeanDeserializer.class.isAssignableFrom(cls2) && cls2 != JavaBeanDeserializer.class && cls2 != ThrowableDeserializer.class) {
                                            setResolveStatus(0);
                                        } else if (deserializer instanceof MapDeserializer) {
                                            setResolveStatus(0);
                                        }
                                        Object deserialze = deserializer.deserialze(this, cls, obj);
                                        setContext(parseContext);
                                        return deserialze;
                                    }
                                }
                            }
                        } else if (obj2 == "$ref" || parseContext == null || (!(map == null || map.size() == 0) || jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect))) {
                            if (!z2) {
                                ParseContext parseContext4 = this.context;
                                if (parseContext4 != null && obj == parseContext4.fieldName && map == this.context.object) {
                                    parseContext = this.context;
                                } else {
                                    ParseContext context3 = setContext(map, obj);
                                    if (parseContext == null) {
                                        parseContext = context3;
                                    }
                                    z2 = true;
                                }
                            }
                            obj3 = obj2;
                            obj3 = obj2;
                            if (map.getClass() == JSONObject.class && obj2 == null) {
                                obj3 = "null";
                            }
                            if (current != '\"') {
                                jSONLexer.scanString();
                                String stringVal = jSONLexer.stringVal();
                                Number number2 = stringVal;
                                if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                                    JSONScanner jSONScanner = new JSONScanner(stringVal);
                                    Date date = stringVal;
                                    if (jSONScanner.scanISO8601DateIfMatch()) {
                                        date = jSONScanner.getCalendar().getTime();
                                    }
                                    jSONScanner.close();
                                    number2 = date;
                                }
                                innerMap.put(obj3, number2);
                                obj4 = number2;
                            } else if ((current >= '0' && current <= '9') || current == '-') {
                                jSONLexer.scanNumber();
                                if (jSONLexer.token() == 2) {
                                    number = jSONLexer.integerValue();
                                } else {
                                    number = jSONLexer.decimalValue(jSONLexer.isEnabled(Feature.UseBigDecimal));
                                }
                                innerMap.put(obj3, number);
                                obj4 = number;
                            } else if (current == '[') {
                                jSONLexer.nextToken();
                                JSONArray jSONArray = new JSONArray();
                                if (obj != null) {
                                    obj.getClass();
                                }
                                if (obj == null) {
                                    setContext(parseContext);
                                }
                                parseArray(jSONArray, obj3);
                                Object[] objArr = jSONArray;
                                if (jSONLexer.isEnabled(Feature.UseObjectArray)) {
                                    objArr = jSONArray.toArray();
                                }
                                innerMap.put(obj3, objArr == 1 ? 1 : 0);
                                if (jSONLexer.token() == 13) {
                                    jSONLexer.nextToken();
                                    setContext(parseContext);
                                    return map;
                                } else if (jSONLexer.token() != 16) {
                                    throw new JSONException("syntax error");
                                }
                            } else if (current == '{') {
                                jSONLexer.nextToken();
                                boolean z6 = obj != null && obj.getClass() == Integer.class;
                                if (jSONLexer.isEnabled(Feature.CustomMapDeserializer)) {
                                    MapDeserializer mapDeserializer = (MapDeserializer) this.config.getDeserializer(Map.class);
                                    if ((jSONLexer.getFeatures() & Feature.OrderedField.mask) != 0) {
                                        map2 = mapDeserializer.createMap(Map.class, jSONLexer.getFeatures());
                                    } else {
                                        map2 = mapDeserializer.createMap(Map.class);
                                    }
                                } else {
                                    map2 = new JSONObject(jSONLexer.isEnabled(Feature.OrderedField));
                                }
                                ParseContext context4 = !z6 ? setContext(parseContext, map2, obj3) : null;
                                if (this.fieldTypeResolver != null) {
                                    Type resolve = this.fieldTypeResolver.resolve(map, obj3 != null ? obj3.toString() : null);
                                    if (resolve != null) {
                                        obj5 = this.config.getDeserializer(resolve).deserialze(this, resolve, obj3);
                                        z4 = true;
                                        if (!z4) {
                                            obj5 = parseObject(map2, obj3);
                                        }
                                        if (!(context4 == null || map2 == obj5)) {
                                            context4.object = map;
                                        }
                                        if (obj3 != null) {
                                            checkMapResolve(map, obj3.toString());
                                        }
                                        innerMap.put(obj3, obj5);
                                        if (z6) {
                                            setContext(obj5, obj3);
                                        }
                                        if (jSONLexer.token() != 13) {
                                            jSONLexer.nextToken();
                                            setContext(parseContext);
                                            setContext(parseContext);
                                            return map;
                                        } else if (jSONLexer.token() != 16) {
                                            throw new JSONException("syntax error, " + jSONLexer.tokenName());
                                        } else if (z6) {
                                            popContext();
                                        } else {
                                            setContext(parseContext);
                                        }
                                    }
                                }
                                z4 = false;
                                obj5 = null;
                                if (!z4) {
                                }
                                context4.object = map;
                                if (obj3 != null) {
                                }
                                innerMap.put(obj3, obj5);
                                if (z6) {
                                }
                                if (jSONLexer.token() != 13) {
                                }
                            } else {
                                jSONLexer.nextToken();
                                innerMap.put(obj3, parse());
                                if (jSONLexer.token() == 13) {
                                    jSONLexer.nextToken();
                                    setContext(parseContext);
                                    return map;
                                } else if (jSONLexer.token() != 16) {
                                    throw new JSONException("syntax error, position at " + jSONLexer.pos() + ", name " + obj3);
                                }
                            }
                            jSONLexer.skipWhitespace();
                            current2 = jSONLexer.getCurrent();
                            if (current2 != ',') {
                                jSONLexer.next();
                            } else if (current2 == '}') {
                                jSONLexer.next();
                                jSONLexer.resetStringPosition();
                                jSONLexer.nextToken();
                                setContext(obj4, obj3);
                                setContext(parseContext);
                                return map;
                            } else {
                                throw new JSONException("syntax error, position at " + jSONLexer.pos() + ", name " + obj3);
                            }
                        } else {
                            jSONLexer.nextToken(4);
                            if (jSONLexer.token() == 4) {
                                String stringVal2 = jSONLexer.stringVal();
                                jSONLexer.nextToken(13);
                                if (jSONLexer.token() == 16) {
                                    innerMap.put(obj2, stringVal2);
                                } else {
                                    if ("@".equals(stringVal2)) {
                                        ParseContext parseContext5 = this.context;
                                        if (parseContext5 != null) {
                                            Object obj9 = parseContext5.object;
                                            if ((obj9 instanceof Object[]) || (obj9 instanceof Collection)) {
                                                obj6 = obj9;
                                                if (jSONLexer.token() == 13) {
                                                    jSONLexer.nextToken(16);
                                                    setContext(parseContext);
                                                    return obj6;
                                                }
                                                throw new JSONException("syntax error, " + jSONLexer.info());
                                            } else if (parseContext5.parent != null) {
                                                obj6 = parseContext5.parent.object;
                                                if (jSONLexer.token() == 13) {
                                                }
                                            }
                                        }
                                    } else if ("..".equals(stringVal2)) {
                                        if (parseContext.object != null) {
                                            obj6 = parseContext.object;
                                            if (jSONLexer.token() == 13) {
                                            }
                                        } else {
                                            addResolveTask(new ResolveTask(parseContext, stringVal2));
                                            setResolveStatus(1);
                                        }
                                    } else if ("$".equals(stringVal2)) {
                                        ParseContext parseContext6 = parseContext;
                                        while (parseContext6.parent != null) {
                                            parseContext6 = parseContext6.parent;
                                        }
                                        if (parseContext6.object != null) {
                                            obj6 = parseContext6.object;
                                            if (jSONLexer.token() == 13) {
                                            }
                                        } else {
                                            addResolveTask(new ResolveTask(parseContext6, stringVal2));
                                            setResolveStatus(1);
                                        }
                                    } else {
                                        addResolveTask(new ResolveTask(parseContext, stringVal2));
                                        setResolveStatus(1);
                                    }
                                    obj6 = null;
                                    if (jSONLexer.token() == 13) {
                                    }
                                }
                            } else {
                                throw new JSONException("illegal ref, " + JSONToken.name(jSONLexer.token()));
                            }
                        }
                    } else {
                        throw new JSONException("object key level > 512");
                    }
                } else if (jSONLexer.isEnabled(Feature.AllowUnQuotedFieldNames)) {
                    Object scanSymbolUnQuoted = jSONLexer.scanSymbolUnQuoted(this.symbolTable);
                    jSONLexer.skipWhitespace();
                    char current4 = jSONLexer.getCurrent();
                    obj2 = scanSymbolUnQuoted;
                    if (current4 != ':') {
                        throw new JSONException("expect ':' at " + jSONLexer.pos() + ", actual " + current4);
                    }
                } else {
                    throw new JSONException("syntax error");
                }
                z3 = false;
                if (!z3) {
                }
                current = jSONLexer.getCurrent();
                jSONLexer.resetStringPosition();
                if (obj2 != JSON.DEFAULT_TYPE_KEY) {
                }
                if (obj2 == "$ref") {
                }
                if (!z2) {
                }
                obj3 = obj2;
                obj3 = obj2;
                obj3 = "null";
                if (current != '\"') {
                }
                jSONLexer.skipWhitespace();
                current2 = jSONLexer.getCurrent();
                if (current2 != ',') {
                }
            }
        } else {
            throw new JSONException("syntax error, expect {, actual " + jSONLexer.tokenName() + ", " + jSONLexer.info());
        }
    }

    public ParserConfig getConfig() {
        return this.config;
    }

    public void setConfig(ParserConfig parserConfig) {
        this.config = parserConfig;
    }

    public <T> T parseObject(Class<T> cls) {
        return (T) parseObject(cls, (Object) null);
    }

    public <T> T parseObject(Type type) {
        return (T) parseObject(type, (Object) null);
    }

    public <T> T parseObject(Type type, Object obj) {
        int i = this.lexer.token();
        if (i == 8) {
            this.lexer.nextToken();
            return null;
        }
        if (i == 4) {
            if (type == byte[].class) {
                T t = (T) this.lexer.bytesValue();
                this.lexer.nextToken();
                return t;
            } else if (type == char[].class) {
                String stringVal = this.lexer.stringVal();
                this.lexer.nextToken();
                return (T) stringVal.toCharArray();
            }
        }
        ObjectDeserializer deserializer = this.config.getDeserializer(type);
        try {
            if (deserializer.getClass() != JavaBeanDeserializer.class) {
                return (T) deserializer.deserialze(this, type, obj);
            }
            if (this.lexer.token() != 12) {
                if (this.lexer.token() != 14) {
                    throw new JSONException("syntax error,except start with { or [,but actually start with " + this.lexer.tokenName());
                }
            }
            return (T) ((JavaBeanDeserializer) deserializer).deserialze(this, type, obj, 0);
        } catch (JSONException e) {
            throw e;
        } catch (Throwable th) {
            throw new JSONException(th.getMessage(), th);
        }
    }

    public <T> List<T> parseArray(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        parseArray((Class<?>) cls, (Collection) arrayList);
        return arrayList;
    }

    public void parseArray(Class<?> cls, Collection collection) {
        parseArray((Type) cls, collection);
    }

    public void parseArray(Type type, Collection collection) {
        parseArray(type, collection, null);
    }

    /* JADX INFO: finally extract failed */
    public void parseArray(Type type, Collection collection, Object obj) {
        ObjectDeserializer objectDeserializer;
        int i = this.lexer.token();
        if (i == 21 || i == 22) {
            this.lexer.nextToken();
            i = this.lexer.token();
        }
        if (i == 14) {
            if (Integer.TYPE == type) {
                objectDeserializer = IntegerCodec.instance;
                this.lexer.nextToken(2);
            } else if (String.class == type) {
                objectDeserializer = StringCodec.instance;
                this.lexer.nextToken(4);
            } else {
                objectDeserializer = this.config.getDeserializer(type);
                this.lexer.nextToken(objectDeserializer.getFastMatchToken());
            }
            ParseContext parseContext = this.context;
            setContext(collection, obj);
            int i2 = 0;
            while (true) {
                try {
                    if (this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                        while (this.lexer.token() == 16) {
                            this.lexer.nextToken();
                        }
                    }
                    if (this.lexer.token() == 15) {
                        setContext(parseContext);
                        this.lexer.nextToken(16);
                        return;
                    }
                    Object obj2 = null;
                    if (Integer.TYPE == type) {
                        collection.add(IntegerCodec.instance.deserialze(this, null, null));
                    } else if (String.class == type) {
                        if (this.lexer.token() == 4) {
                            obj2 = this.lexer.stringVal();
                            this.lexer.nextToken(16);
                        } else {
                            Object parse = parse();
                            if (parse != null) {
                                obj2 = parse.toString();
                            }
                        }
                        collection.add(obj2);
                    } else {
                        if (this.lexer.token() == 8) {
                            this.lexer.nextToken();
                        } else {
                            obj2 = objectDeserializer.deserialze(this, type, Integer.valueOf(i2));
                        }
                        collection.add(obj2);
                        checkListResolve(collection);
                    }
                    if (this.lexer.token() == 16) {
                        this.lexer.nextToken(objectDeserializer.getFastMatchToken());
                    }
                    i2++;
                } catch (Throwable th) {
                    setContext(parseContext);
                    throw th;
                }
            }
        } else {
            throw new JSONException("expect '[', but " + JSONToken.name(i) + ", " + this.lexer.info());
        }
    }

    public Object[] parseArray(Type[] typeArr) {
        Object obj;
        Class<?> cls;
        boolean z;
        Class cls2;
        int i = 8;
        if (this.lexer.token() == 8) {
            this.lexer.nextToken(16);
            return null;
        }
        int i2 = 14;
        if (this.lexer.token() == 14) {
            Object[] objArr = new Object[typeArr.length];
            if (typeArr.length == 0) {
                this.lexer.nextToken(15);
                if (this.lexer.token() == 15) {
                    this.lexer.nextToken(16);
                    return new Object[0];
                }
                throw new JSONException("syntax error");
            }
            this.lexer.nextToken(2);
            int i3 = 0;
            while (i3 < typeArr.length) {
                if (this.lexer.token() == i) {
                    this.lexer.nextToken(16);
                    obj = null;
                } else {
                    Type type = typeArr[i3];
                    if (type == Integer.TYPE || type == Integer.class) {
                        if (this.lexer.token() == 2) {
                            obj = Integer.valueOf(this.lexer.intValue());
                            this.lexer.nextToken(16);
                        } else {
                            obj = TypeUtils.cast(parse(), type, this.config);
                        }
                    } else if (type != String.class) {
                        if (i3 != typeArr.length - 1 || !(type instanceof Class) || (((cls2 = (Class) type) == byte[].class || cls2 == char[].class) && this.lexer.token() == 4)) {
                            cls = null;
                            z = false;
                        } else {
                            z = cls2.isArray();
                            cls = cls2.getComponentType();
                        }
                        if (!z || this.lexer.token() == i2) {
                            obj = this.config.getDeserializer(type).deserialze(this, type, Integer.valueOf(i3));
                        } else {
                            ArrayList arrayList = new ArrayList();
                            ObjectDeserializer deserializer = this.config.getDeserializer(cls);
                            int fastMatchToken = deserializer.getFastMatchToken();
                            if (this.lexer.token() != 15) {
                                while (true) {
                                    arrayList.add(deserializer.deserialze(this, type, null));
                                    if (this.lexer.token() != 16) {
                                        break;
                                    }
                                    this.lexer.nextToken(fastMatchToken);
                                }
                                if (this.lexer.token() != 15) {
                                    throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                                }
                            }
                            obj = TypeUtils.cast(arrayList, type, this.config);
                        }
                    } else if (this.lexer.token() == 4) {
                        obj = this.lexer.stringVal();
                        this.lexer.nextToken(16);
                    } else {
                        obj = TypeUtils.cast(parse(), type, this.config);
                    }
                }
                objArr[i3] = obj;
                if (this.lexer.token() == 15) {
                    break;
                } else if (this.lexer.token() == 16) {
                    if (i3 == typeArr.length - 1) {
                        this.lexer.nextToken(15);
                    } else {
                        this.lexer.nextToken(2);
                    }
                    i3++;
                    i = 8;
                    i2 = 14;
                } else {
                    throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                }
            }
            if (this.lexer.token() == 15) {
                this.lexer.nextToken(16);
                return objArr;
            }
            throw new JSONException("syntax error");
        }
        throw new JSONException("syntax error : " + this.lexer.tokenName());
    }

    public void parseObject(Object obj) {
        Object obj2;
        Class<?> cls = obj.getClass();
        ObjectDeserializer deserializer = this.config.getDeserializer(cls);
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        if (this.lexer.token() == 12 || this.lexer.token() == 16) {
            while (true) {
                String scanSymbol = this.lexer.scanSymbol(this.symbolTable);
                if (scanSymbol == null) {
                    if (this.lexer.token() == 13) {
                        this.lexer.nextToken(16);
                        return;
                    } else if (this.lexer.token() == 16 && this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                    }
                }
                FieldDeserializer fieldDeserializer = javaBeanDeserializer != null ? javaBeanDeserializer.getFieldDeserializer(scanSymbol) : null;
                if (fieldDeserializer != null) {
                    Class<?> cls2 = fieldDeserializer.fieldInfo.fieldClass;
                    Type type = fieldDeserializer.fieldInfo.fieldType;
                    if (cls2 == Integer.TYPE) {
                        this.lexer.nextTokenWithColon(2);
                        obj2 = IntegerCodec.instance.deserialze(this, type, null);
                    } else if (cls2 == String.class) {
                        this.lexer.nextTokenWithColon(4);
                        obj2 = StringCodec.deserialze(this);
                    } else if (cls2 == Long.TYPE) {
                        this.lexer.nextTokenWithColon(2);
                        obj2 = LongCodec.instance.deserialze(this, type, null);
                    } else {
                        ObjectDeserializer deserializer2 = this.config.getDeserializer(cls2, type);
                        this.lexer.nextTokenWithColon(deserializer2.getFastMatchToken());
                        obj2 = deserializer2.deserialze(this, type, null);
                    }
                    fieldDeserializer.setValue(obj, obj2);
                    if (this.lexer.token() != 16 && this.lexer.token() == 13) {
                        this.lexer.nextToken(16);
                        return;
                    }
                } else if (this.lexer.isEnabled(Feature.IgnoreNotMatch)) {
                    this.lexer.nextTokenWithColon();
                    parse();
                    if (this.lexer.token() == 13) {
                        this.lexer.nextToken();
                        return;
                    }
                } else {
                    throw new JSONException("setter not found, class " + cls.getName() + ", property " + scanSymbol);
                }
            }
        } else {
            throw new JSONException("syntax error, expect {, actual " + this.lexer.tokenName());
        }
    }

    public Object parseArrayWithType(Type type) {
        if (this.lexer.token() == 8) {
            this.lexer.nextToken();
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length == 1) {
            Type type2 = actualTypeArguments[0];
            if (type2 instanceof Class) {
                ArrayList arrayList = new ArrayList();
                parseArray((Class) type2, (Collection) arrayList);
                return arrayList;
            } else if (type2 instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type2;
                Type type3 = wildcardType.getUpperBounds()[0];
                if (!Object.class.equals(type3)) {
                    ArrayList arrayList2 = new ArrayList();
                    parseArray((Class) type3, (Collection) arrayList2);
                    return arrayList2;
                } else if (wildcardType.getLowerBounds().length == 0) {
                    return parse();
                } else {
                    throw new JSONException("not support type : " + type);
                }
            } else {
                if (type2 instanceof TypeVariable) {
                    TypeVariable typeVariable = (TypeVariable) type2;
                    Type[] bounds = typeVariable.getBounds();
                    if (bounds.length == 1) {
                        Type type4 = bounds[0];
                        if (type4 instanceof Class) {
                            ArrayList arrayList3 = new ArrayList();
                            parseArray((Class) type4, (Collection) arrayList3);
                            return arrayList3;
                        }
                    } else {
                        throw new JSONException("not support : " + typeVariable);
                    }
                }
                if (type2 instanceof ParameterizedType) {
                    ArrayList arrayList4 = new ArrayList();
                    parseArray((ParameterizedType) type2, arrayList4);
                    return arrayList4;
                }
                throw new JSONException("TODO : " + type);
            }
        } else {
            throw new JSONException("not support type " + type);
        }
    }

    public void acceptType(String str) {
        JSONLexer jSONLexer = this.lexer;
        jSONLexer.nextTokenWithColon();
        if (jSONLexer.token() != 4) {
            throw new JSONException("type not match error");
        } else if (str.equals(jSONLexer.stringVal())) {
            jSONLexer.nextToken();
            if (jSONLexer.token() == 16) {
                jSONLexer.nextToken();
            }
        } else {
            throw new JSONException("type not match error");
        }
    }

    public int getResolveStatus() {
        return this.resolveStatus;
    }

    public void setResolveStatus(int i) {
        this.resolveStatus = i;
    }

    public Object getObject(String str) {
        for (int i = 0; i < this.contextArrayIndex; i++) {
            if (str.equals(this.contextArray[i].toString())) {
                return this.contextArray[i].object;
            }
        }
        return null;
    }

    public void checkListResolve(Collection collection) {
        if (this.resolveStatus != 1) {
            return;
        }
        if (collection instanceof List) {
            ResolveTask lastResolveTask = getLastResolveTask();
            lastResolveTask.fieldDeserializer = new ResolveFieldDeserializer(this, (List) collection, collection.size() - 1);
            lastResolveTask.ownerContext = this.context;
            setResolveStatus(0);
            return;
        }
        ResolveTask lastResolveTask2 = getLastResolveTask();
        lastResolveTask2.fieldDeserializer = new ResolveFieldDeserializer(collection);
        lastResolveTask2.ownerContext = this.context;
        setResolveStatus(0);
    }

    public void checkMapResolve(Map map, Object obj) {
        if (this.resolveStatus == 1) {
            ResolveFieldDeserializer resolveFieldDeserializer = new ResolveFieldDeserializer(map, obj);
            ResolveTask lastResolveTask = getLastResolveTask();
            lastResolveTask.fieldDeserializer = resolveFieldDeserializer;
            lastResolveTask.ownerContext = this.context;
            setResolveStatus(0);
        }
    }

    public Object parseObject(Map map) {
        return parseObject(map, (Object) null);
    }

    public JSONObject parseObject() {
        Object parseObject = parseObject((Map) new JSONObject(this.lexer.isEnabled(Feature.OrderedField)));
        if (parseObject instanceof JSONObject) {
            return (JSONObject) parseObject;
        }
        if (parseObject == null) {
            return null;
        }
        return new JSONObject((Map) parseObject);
    }

    public final void parseArray(Collection collection) {
        parseArray(collection, (Object) null);
    }

    public final void parseArray(Collection collection, Object obj) {
        Number number;
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == 21 || jSONLexer.token() == 22) {
            jSONLexer.nextToken();
        }
        if (jSONLexer.token() == 14) {
            jSONLexer.nextToken(4);
            ParseContext parseContext = this.context;
            if (parseContext == null || parseContext.level <= 512) {
                ParseContext parseContext2 = this.context;
                setContext(collection, obj);
                int i = 0;
                while (true) {
                    try {
                        if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                            while (jSONLexer.token() == 16) {
                                jSONLexer.nextToken();
                            }
                        }
                        int i2 = jSONLexer.token();
                        JSONArray jSONArray = null;
                        jSONArray = null;
                        if (i2 == 2) {
                            Number integerValue = jSONLexer.integerValue();
                            jSONLexer.nextToken(16);
                            jSONArray = integerValue;
                        } else if (i2 == 3) {
                            if (jSONLexer.isEnabled(Feature.UseBigDecimal)) {
                                number = jSONLexer.decimalValue(true);
                            } else {
                                number = jSONLexer.decimalValue(false);
                            }
                            jSONArray = number;
                            jSONLexer.nextToken(16);
                        } else if (i2 == 4) {
                            String stringVal = jSONLexer.stringVal();
                            jSONLexer.nextToken(16);
                            jSONArray = stringVal;
                            if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                                JSONScanner jSONScanner = new JSONScanner(stringVal);
                                Date date = stringVal;
                                if (jSONScanner.scanISO8601DateIfMatch()) {
                                    date = jSONScanner.getCalendar().getTime();
                                }
                                jSONScanner.close();
                                jSONArray = date;
                            }
                        } else if (i2 == 6) {
                            Boolean bool = Boolean.TRUE;
                            jSONLexer.nextToken(16);
                            jSONArray = bool;
                        } else if (i2 == 7) {
                            Boolean bool2 = Boolean.FALSE;
                            jSONLexer.nextToken(16);
                            jSONArray = bool2;
                        } else if (i2 == 8) {
                            jSONLexer.nextToken(4);
                        } else if (i2 == 12) {
                            jSONArray = parseObject(new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), Integer.valueOf(i));
                        } else if (i2 == 20) {
                            throw new JSONException("unclosed jsonArray");
                        } else if (i2 == 23) {
                            jSONLexer.nextToken(4);
                        } else if (i2 == 14) {
                            JSONArray jSONArray2 = new JSONArray();
                            parseArray(jSONArray2, Integer.valueOf(i));
                            jSONArray = jSONArray2;
                            if (jSONLexer.isEnabled(Feature.UseObjectArray)) {
                                jSONArray = jSONArray2.toArray();
                            }
                        } else if (i2 != 15) {
                            jSONArray = parse();
                        } else {
                            jSONLexer.nextToken(16);
                            return;
                        }
                        collection.add(jSONArray == 1 ? 1 : 0);
                        checkListResolve(collection);
                        if (jSONLexer.token() == 16) {
                            jSONLexer.nextToken(4);
                        }
                        i++;
                    } finally {
                        setContext(parseContext2);
                    }
                }
            } else {
                throw new JSONException("array level > 512");
            }
        } else {
            throw new JSONException("syntax error, expect [, actual " + JSONToken.name(jSONLexer.token()) + ", pos " + jSONLexer.pos() + ", fieldName " + obj);
        }
    }

    public ParseContext getContext() {
        return this.context;
    }

    public List<ResolveTask> getResolveTaskList() {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        return this.resolveTaskList;
    }

    public void addResolveTask(ResolveTask resolveTask) {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        this.resolveTaskList.add(resolveTask);
    }

    public ResolveTask getLastResolveTask() {
        List<ResolveTask> list = this.resolveTaskList;
        return list.get(list.size() - 1);
    }

    public List<ExtraProcessor> getExtraProcessors() {
        if (this.extraProcessors == null) {
            this.extraProcessors = new ArrayList(2);
        }
        return this.extraProcessors;
    }

    public List<ExtraTypeProvider> getExtraTypeProviders() {
        if (this.extraTypeProviders == null) {
            this.extraTypeProviders = new ArrayList(2);
        }
        return this.extraTypeProviders;
    }

    public FieldTypeResolver getFieldTypeResolver() {
        return this.fieldTypeResolver;
    }

    public void setFieldTypeResolver(FieldTypeResolver fieldTypeResolver2) {
        this.fieldTypeResolver = fieldTypeResolver2;
    }

    public void setContext(ParseContext parseContext) {
        if (!this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            this.context = parseContext;
        }
    }

    public void popContext() {
        if (!this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            this.context = this.context.parent;
            int i = this.contextArrayIndex;
            if (i > 0) {
                int i2 = i - 1;
                this.contextArrayIndex = i2;
                this.contextArray[i2] = null;
            }
        }
    }

    public ParseContext setContext(Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        return setContext(this.context, obj, obj2);
    }

    public ParseContext setContext(ParseContext parseContext, Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        ParseContext parseContext2 = new ParseContext(parseContext, obj, obj2);
        this.context = parseContext2;
        addContext(parseContext2);
        return this.context;
    }

    private void addContext(ParseContext parseContext) {
        int i = this.contextArrayIndex;
        this.contextArrayIndex = i + 1;
        ParseContext[] parseContextArr = this.contextArray;
        if (parseContextArr == null) {
            this.contextArray = new ParseContext[8];
        } else if (i >= parseContextArr.length) {
            ParseContext[] parseContextArr2 = new ParseContext[((parseContextArr.length * 3) / 2)];
            System.arraycopy(parseContextArr, 0, parseContextArr2, 0, parseContextArr.length);
            this.contextArray = parseContextArr2;
        }
        this.contextArray[i] = parseContext;
    }

    public Object parse() {
        return parse(null);
    }

    public Object parseKey() {
        if (this.lexer.token() != 18) {
            return parse(null);
        }
        String stringVal = this.lexer.stringVal();
        this.lexer.nextToken(16);
        return stringVal;
    }

    public Object parse(Object obj) {
        JSONLexer jSONLexer = this.lexer;
        int i = jSONLexer.token();
        if (i == 2) {
            Number integerValue = jSONLexer.integerValue();
            jSONLexer.nextToken();
            return integerValue;
        } else if (i == 3) {
            Number decimalValue = jSONLexer.decimalValue(jSONLexer.isEnabled(Feature.UseBigDecimal));
            jSONLexer.nextToken();
            return decimalValue;
        } else if (i == 4) {
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                JSONScanner jSONScanner = new JSONScanner(stringVal);
                try {
                    if (jSONScanner.scanISO8601DateIfMatch()) {
                        return jSONScanner.getCalendar().getTime();
                    }
                    jSONScanner.close();
                } finally {
                    jSONScanner.close();
                }
            }
            return stringVal;
        } else if (i == 12) {
            return parseObject(new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), obj);
        } else {
            if (i == 14) {
                JSONArray jSONArray = new JSONArray();
                parseArray(jSONArray, obj);
                return jSONLexer.isEnabled(Feature.UseObjectArray) ? jSONArray.toArray() : jSONArray;
            } else if (i != 18) {
                if (i != 26) {
                    switch (i) {
                        case 6:
                            jSONLexer.nextToken();
                            return Boolean.TRUE;
                        case 7:
                            jSONLexer.nextToken();
                            return Boolean.FALSE;
                        case 8:
                            jSONLexer.nextToken();
                            return null;
                        case 9:
                            jSONLexer.nextToken(18);
                            if (jSONLexer.token() == 18) {
                                jSONLexer.nextToken(10);
                                accept(10);
                                long longValue = jSONLexer.integerValue().longValue();
                                accept(2);
                                accept(11);
                                return new Date(longValue);
                            }
                            throw new JSONException("syntax error");
                        default:
                            switch (i) {
                                case 20:
                                    if (jSONLexer.isBlankInput()) {
                                        return null;
                                    }
                                    throw new JSONException("unterminated json string, " + jSONLexer.info());
                                case 21:
                                    jSONLexer.nextToken();
                                    Collection hashSet = new HashSet();
                                    parseArray(hashSet, obj);
                                    return hashSet;
                                case 22:
                                    jSONLexer.nextToken();
                                    Collection treeSet = new TreeSet();
                                    parseArray(treeSet, obj);
                                    return treeSet;
                                case 23:
                                    jSONLexer.nextToken();
                                    return null;
                                default:
                                    throw new JSONException("syntax error, " + jSONLexer.info());
                            }
                    }
                } else {
                    byte[] bytesValue = jSONLexer.bytesValue();
                    jSONLexer.nextToken();
                    return bytesValue;
                }
            } else if ("NaN".equals(jSONLexer.stringVal())) {
                jSONLexer.nextToken();
                return null;
            } else {
                throw new JSONException("syntax error, " + jSONLexer.info());
            }
        }
    }

    public void config(Feature feature, boolean z) {
        this.lexer.config(feature, z);
    }

    public boolean isEnabled(Feature feature) {
        return this.lexer.isEnabled(feature);
    }

    public JSONLexer getLexer() {
        return this.lexer;
    }

    public final void accept(int i) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i) {
            jSONLexer.nextToken();
            return;
        }
        throw new JSONException("syntax error, expect " + JSONToken.name(i) + ", actual " + JSONToken.name(jSONLexer.token()));
    }

    public final void accept(int i, int i2) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i) {
            jSONLexer.nextToken(i2);
        } else {
            throwException(i);
        }
    }

    public void throwException(int i) {
        throw new JSONException("syntax error, expect " + JSONToken.name(i) + ", actual " + JSONToken.name(this.lexer.token()));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        JSONLexer jSONLexer = this.lexer;
        try {
            if (jSONLexer.isEnabled(Feature.AutoCloseSource)) {
                if (jSONLexer.token() != 20) {
                    throw new JSONException("not close json text, token : " + JSONToken.name(jSONLexer.token()));
                }
            }
        } finally {
            jSONLexer.close();
        }
    }

    public Object resolveReference(String str) {
        if (this.contextArray == null) {
            return null;
        }
        int i = 0;
        while (true) {
            ParseContext[] parseContextArr = this.contextArray;
            if (i >= parseContextArr.length || i >= this.contextArrayIndex) {
                break;
            }
            ParseContext parseContext = parseContextArr[i];
            if (parseContext.toString().equals(str)) {
                return parseContext.object;
            }
            i++;
        }
        return null;
    }

    public void handleResovleTask(Object obj) {
        Object obj2;
        List<ResolveTask> list = this.resolveTaskList;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ResolveTask resolveTask = this.resolveTaskList.get(i);
                String str = resolveTask.referenceValue;
                Object obj3 = null;
                if (resolveTask.ownerContext != null) {
                    obj3 = resolveTask.ownerContext.object;
                }
                if (str.startsWith("$")) {
                    obj2 = getObject(str);
                    if (obj2 == null) {
                        try {
                            JSONPath compile = JSONPath.compile(str);
                            if (compile.isRef()) {
                                obj2 = compile.eval(obj);
                            }
                        } catch (JSONPathException unused) {
                        }
                    }
                } else {
                    obj2 = resolveTask.context.object;
                }
                FieldDeserializer fieldDeserializer = resolveTask.fieldDeserializer;
                if (fieldDeserializer != null) {
                    if (obj2 != null && obj2.getClass() == JSONObject.class && fieldDeserializer.fieldInfo != null && !Map.class.isAssignableFrom(fieldDeserializer.fieldInfo.fieldClass)) {
                        Object obj4 = this.contextArray[0].object;
                        JSONPath compile2 = JSONPath.compile(str);
                        if (compile2.isRef()) {
                            obj2 = compile2.eval(obj4);
                        }
                    }
                    fieldDeserializer.setValue(obj3, obj2);
                }
            }
        }
    }

    public static class ResolveTask {
        public final ParseContext context;
        public FieldDeserializer fieldDeserializer;
        public ParseContext ownerContext;
        public final String referenceValue;

        public ResolveTask(ParseContext parseContext, String str) {
            this.context = parseContext;
            this.referenceValue = str;
        }
    }

    public void parseExtra(Object obj, String str) {
        Object obj2;
        this.lexer.nextTokenWithColon();
        List<ExtraTypeProvider> list = this.extraTypeProviders;
        Type type = null;
        if (list != null) {
            for (ExtraTypeProvider extraTypeProvider : list) {
                type = extraTypeProvider.getExtraType(obj, str);
            }
        }
        if (type == null) {
            obj2 = parse();
        } else {
            obj2 = parseObject(type);
        }
        if (obj instanceof ExtraProcessable) {
            ((ExtraProcessable) obj).processExtra(str, obj2);
            return;
        }
        List<ExtraProcessor> list2 = this.extraProcessors;
        if (list2 != null) {
            for (ExtraProcessor extraProcessor : list2) {
                extraProcessor.processExtra(obj, str, obj2);
            }
        }
        if (this.resolveStatus == 1) {
            this.resolveStatus = 0;
        }
    }

    public Object parse(PropertyProcessable propertyProcessable, Object obj) {
        String str;
        Object obj2;
        int i = 0;
        if (this.lexer.token() != 12) {
            String str2 = "syntax error, expect {, actual " + this.lexer.tokenName();
            if (obj instanceof String) {
                str2 = (str2 + ", fieldName ") + obj;
            }
            String str3 = (str2 + ", ") + this.lexer.info();
            JSONArray jSONArray = new JSONArray();
            parseArray(jSONArray, obj);
            if (jSONArray.size() == 1) {
                Object obj3 = jSONArray.get(0);
                if (obj3 instanceof JSONObject) {
                    return (JSONObject) obj3;
                }
            }
            throw new JSONException(str3);
        }
        ParseContext parseContext = this.context;
        while (true) {
            try {
                this.lexer.skipWhitespace();
                char current = this.lexer.getCurrent();
                if (this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                    while (current == ',') {
                        this.lexer.next();
                        this.lexer.skipWhitespace();
                        current = this.lexer.getCurrent();
                    }
                }
                if (current == '\"') {
                    str = this.lexer.scanSymbol(this.symbolTable, '\"');
                    this.lexer.skipWhitespace();
                    if (this.lexer.getCurrent() != ':') {
                        throw new JSONException("expect ':' at " + this.lexer.pos());
                    }
                } else if (current == '}') {
                    this.lexer.next();
                    this.lexer.resetStringPosition();
                    this.lexer.nextToken(16);
                    setContext(parseContext);
                    return propertyProcessable;
                } else if (current == '\'') {
                    if (this.lexer.isEnabled(Feature.AllowSingleQuotes)) {
                        str = this.lexer.scanSymbol(this.symbolTable, '\'');
                        this.lexer.skipWhitespace();
                        if (this.lexer.getCurrent() != ':') {
                            throw new JSONException("expect ':' at " + this.lexer.pos());
                        }
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if (this.lexer.isEnabled(Feature.AllowUnQuotedFieldNames)) {
                    str = this.lexer.scanSymbolUnQuoted(this.symbolTable);
                    this.lexer.skipWhitespace();
                    char current2 = this.lexer.getCurrent();
                    if (current2 != ':') {
                        throw new JSONException("expect ':' at " + this.lexer.pos() + ", actual " + current2);
                    }
                } else {
                    throw new JSONException("syntax error");
                }
                this.lexer.next();
                this.lexer.skipWhitespace();
                this.lexer.getCurrent();
                this.lexer.resetStringPosition();
                obj2 = null;
                i++;
            } finally {
                setContext(parseContext);
            }
            if (str != JSON.DEFAULT_TYPE_KEY || this.lexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                this.lexer.nextToken();
                if (i != 0) {
                    setContext(parseContext);
                }
                Type type = propertyProcessable.getType(str);
                if (this.lexer.token() == 8) {
                    this.lexer.nextToken();
                } else {
                    obj2 = parseObject(type, str);
                }
                propertyProcessable.apply(str, obj2);
                setContext(parseContext, obj2, str);
                setContext(parseContext);
                int i2 = this.lexer.token();
                if (i2 == 20 || i2 == 15) {
                    break;
                } else if (i2 == 13) {
                    this.lexer.nextToken();
                    setContext(parseContext);
                    return propertyProcessable;
                }
            } else {
                Class<?> checkAutoType = this.config.checkAutoType(this.lexer.scanSymbol(this.symbolTable, '\"'), null, this.lexer.getFeatures());
                if (Map.class.isAssignableFrom(checkAutoType)) {
                    this.lexer.nextToken(16);
                    if (this.lexer.token() == 13) {
                        this.lexer.nextToken(16);
                        return propertyProcessable;
                    }
                } else {
                    ObjectDeserializer deserializer = this.config.getDeserializer(checkAutoType);
                    this.lexer.nextToken(16);
                    setResolveStatus(2);
                    if (parseContext != null && !(obj instanceof Integer)) {
                        popContext();
                    }
                    Map map = (Map) deserializer.deserialze(this, checkAutoType, obj);
                    setContext(parseContext);
                    return map;
                }
            }
        }
        setContext(parseContext);
        return propertyProcessable;
    }
}
