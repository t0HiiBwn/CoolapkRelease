package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MapDeserializer implements ObjectDeserializer {
    public static MapDeserializer instance = new MapDeserializer();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Map<Object, Object> map;
        if (type == JSONObject.class && defaultJSONParser.getFieldTypeResolver() == null) {
            return (T) defaultJSONParser.parseObject();
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        boolean z = (type instanceof Class) && "java.util.Collections$UnmodifiableMap".equals(((Class) type).getName());
        if ((jSONLexer.getFeatures() & Feature.OrderedField.mask) != 0) {
            map = createMap(type, jSONLexer.getFeatures());
        } else {
            map = createMap(type);
        }
        ParseContext context = defaultJSONParser.getContext();
        try {
            defaultJSONParser.setContext(context, map, obj);
            T t = (T) deserialze(defaultJSONParser, type, obj, map);
            if (z) {
                t = (T) Collections.unmodifiableMap(t);
            }
            return t;
        } finally {
            defaultJSONParser.setContext(context);
        }
    }

    protected Object deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, Map map) {
        Type type2;
        if (!(type instanceof ParameterizedType)) {
            return defaultJSONParser.parseObject(map, obj);
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type type3 = parameterizedType.getActualTypeArguments()[0];
        if (map.getClass().getName().equals("org.springframework.util.LinkedMultiValueMap")) {
            type2 = List.class;
        } else {
            type2 = parameterizedType.getActualTypeArguments()[1];
        }
        if (String.class == type3) {
            return parseMap(defaultJSONParser, map, type2, obj);
        }
        return parseMap(defaultJSONParser, map, type3, type2, obj);
    }

    public static Map parseMap(DefaultJSONParser defaultJSONParser, Map<String, Object> map, Type type, Object obj) {
        String str;
        Object obj2;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        int i2 = 0;
        if (i != 12) {
            String str2 = "syntax error, expect {, actual " + jSONLexer.tokenName();
            if (obj instanceof String) {
                str2 = (str2 + ", fieldName ") + obj;
            }
            String str3 = (str2 + ", ") + jSONLexer.info();
            if (i != 4) {
                JSONArray jSONArray = new JSONArray();
                defaultJSONParser.parseArray(jSONArray, obj);
                if (jSONArray.size() == 1) {
                    Object obj3 = jSONArray.get(0);
                    if (obj3 instanceof JSONObject) {
                        return (JSONObject) obj3;
                    }
                }
            }
            throw new JSONException(str3);
        }
        ParseContext context = defaultJSONParser.getContext();
        while (true) {
            try {
                jSONLexer.skipWhitespace();
                char current = jSONLexer.getCurrent();
                if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                    while (current == ',') {
                        jSONLexer.next();
                        jSONLexer.skipWhitespace();
                        current = jSONLexer.getCurrent();
                    }
                }
                if (current == '\"') {
                    str = jSONLexer.scanSymbol(defaultJSONParser.getSymbolTable(), '\"');
                    jSONLexer.skipWhitespace();
                    if (jSONLexer.getCurrent() != ':') {
                        throw new JSONException("expect ':' at " + jSONLexer.pos());
                    }
                } else if (current == '}') {
                    jSONLexer.next();
                    jSONLexer.resetStringPosition();
                    jSONLexer.nextToken(16);
                    defaultJSONParser.setContext(context);
                    return map;
                } else if (current == '\'') {
                    if (jSONLexer.isEnabled(Feature.AllowSingleQuotes)) {
                        str = jSONLexer.scanSymbol(defaultJSONParser.getSymbolTable(), '\'');
                        jSONLexer.skipWhitespace();
                        if (jSONLexer.getCurrent() != ':') {
                            throw new JSONException("expect ':' at " + jSONLexer.pos());
                        }
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if (jSONLexer.isEnabled(Feature.AllowUnQuotedFieldNames)) {
                    str = jSONLexer.scanSymbolUnQuoted(defaultJSONParser.getSymbolTable());
                    jSONLexer.skipWhitespace();
                    char current2 = jSONLexer.getCurrent();
                    if (current2 != ':') {
                        throw new JSONException("expect ':' at " + jSONLexer.pos() + ", actual " + current2);
                    }
                } else {
                    throw new JSONException("syntax error");
                }
                jSONLexer.next();
                jSONLexer.skipWhitespace();
                jSONLexer.getCurrent();
                jSONLexer.resetStringPosition();
                obj2 = null;
                i2++;
            } finally {
                defaultJSONParser.setContext(context);
            }
            if (str != JSON.DEFAULT_TYPE_KEY || jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                jSONLexer.nextToken();
                if (i2 != 0) {
                    defaultJSONParser.setContext(context);
                }
                if (jSONLexer.token() == 8) {
                    jSONLexer.nextToken();
                } else {
                    obj2 = defaultJSONParser.parseObject(type, str);
                }
                map.put(str, obj2);
                defaultJSONParser.checkMapResolve(map, str);
                defaultJSONParser.setContext(context, obj2, str);
                defaultJSONParser.setContext(context);
                int i3 = jSONLexer.token();
                if (i3 == 20 || i3 == 15) {
                    break;
                } else if (i3 == 13) {
                    jSONLexer.nextToken();
                    defaultJSONParser.setContext(context);
                    return map;
                }
            } else {
                String scanSymbol = jSONLexer.scanSymbol(defaultJSONParser.getSymbolTable(), '\"');
                ParserConfig config = defaultJSONParser.getConfig();
                Class<?> checkAutoType = config.checkAutoType(scanSymbol, null, jSONLexer.getFeatures());
                if (Map.class.isAssignableFrom(checkAutoType)) {
                    jSONLexer.nextToken(16);
                    if (jSONLexer.token() == 13) {
                        jSONLexer.nextToken(16);
                        return map;
                    }
                } else {
                    ObjectDeserializer deserializer = config.getDeserializer(checkAutoType);
                    jSONLexer.nextToken(16);
                    defaultJSONParser.setResolveStatus(2);
                    if (context != null && !(obj instanceof Integer)) {
                        defaultJSONParser.popContext();
                    }
                    Map map2 = (Map) deserializer.deserialze(defaultJSONParser, checkAutoType, obj);
                    defaultJSONParser.setContext(context);
                    return map2;
                }
            }
        }
        defaultJSONParser.setContext(context);
        return map;
    }

    public static Object parseMap(DefaultJSONParser defaultJSONParser, Map<Object, Object> map, Type type, Type type2, Object obj) {
        Object obj2;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 12 || jSONLexer.token() == 16) {
            ObjectDeserializer deserializer = defaultJSONParser.getConfig().getDeserializer(type);
            ObjectDeserializer deserializer2 = defaultJSONParser.getConfig().getDeserializer(type2);
            jSONLexer.nextToken(deserializer.getFastMatchToken());
            ParseContext context = defaultJSONParser.getContext();
            while (jSONLexer.token() != 13) {
                try {
                    Object obj3 = null;
                    if (jSONLexer.token() != 4 || !jSONLexer.isRef() || jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                        if (map.size() == 0 && jSONLexer.token() == 4 && JSON.DEFAULT_TYPE_KEY.equals(jSONLexer.stringVal()) && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                            jSONLexer.nextTokenWithColon(4);
                            jSONLexer.nextToken(16);
                            if (jSONLexer.token() == 13) {
                                jSONLexer.nextToken();
                                return map;
                            }
                            jSONLexer.nextToken(deserializer.getFastMatchToken());
                        }
                        if (jSONLexer.token() != 4 || !(deserializer instanceof JavaBeanDeserializer)) {
                            obj2 = deserializer.deserialze(defaultJSONParser, type, null);
                        } else {
                            String stringVal = jSONLexer.stringVal();
                            jSONLexer.nextToken();
                            DefaultJSONParser defaultJSONParser2 = new DefaultJSONParser(stringVal, defaultJSONParser.getConfig(), defaultJSONParser.getLexer().getFeatures());
                            defaultJSONParser2.setDateFormat(defaultJSONParser.getDateFomartPattern());
                            obj2 = deserializer.deserialze(defaultJSONParser2, type, null);
                        }
                        if (jSONLexer.token() == 17) {
                            jSONLexer.nextToken(deserializer2.getFastMatchToken());
                            Object deserialze = deserializer2.deserialze(defaultJSONParser, type2, obj2);
                            defaultJSONParser.checkMapResolve(map, obj2);
                            map.put(obj2, deserialze);
                            if (jSONLexer.token() == 16) {
                                jSONLexer.nextToken(deserializer.getFastMatchToken());
                            }
                        } else {
                            throw new JSONException("syntax error, expect :, actual " + jSONLexer.token());
                        }
                    } else {
                        jSONLexer.nextTokenWithColon(4);
                        if (jSONLexer.token() == 4) {
                            String stringVal2 = jSONLexer.stringVal();
                            if ("..".equals(stringVal2)) {
                                obj3 = context.parent.object;
                            } else if ("$".equals(stringVal2)) {
                                ParseContext parseContext = context;
                                while (parseContext.parent != null) {
                                    parseContext = parseContext.parent;
                                }
                                obj3 = parseContext.object;
                            } else {
                                defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(context, stringVal2));
                                defaultJSONParser.setResolveStatus(1);
                            }
                            jSONLexer.nextToken(13);
                            if (jSONLexer.token() == 13) {
                                jSONLexer.nextToken(16);
                                defaultJSONParser.setContext(context);
                                return obj3;
                            }
                            throw new JSONException("illegal ref");
                        }
                        throw new JSONException("illegal ref, " + JSONToken.name(jSONLexer.token()));
                    }
                } finally {
                    defaultJSONParser.setContext(context);
                }
            }
            jSONLexer.nextToken(16);
            defaultJSONParser.setContext(context);
            return map;
        }
        throw new JSONException("syntax error, expect {, actual " + jSONLexer.tokenName());
    }

    public Map<Object, Object> createMap(Type type) {
        return createMap(type, JSON.DEFAULT_GENERATE_FEATURE);
    }

    public Map<Object, Object> createMap(Type type, int i) {
        if (type == Properties.class) {
            return new Properties();
        }
        if (type == Hashtable.class) {
            return new Hashtable();
        }
        if (type == IdentityHashMap.class) {
            return new IdentityHashMap();
        }
        if (type == SortedMap.class || type == TreeMap.class) {
            return new TreeMap();
        }
        if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
            return new ConcurrentHashMap();
        }
        if (type == Map.class) {
            return (Feature.OrderedField.mask & i) != 0 ? new LinkedHashMap() : new HashMap();
        }
        if (type == HashMap.class) {
            return new HashMap();
        }
        if (type == LinkedHashMap.class) {
            return new LinkedHashMap();
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            if (EnumMap.class.equals(rawType)) {
                return new EnumMap((Class) parameterizedType.getActualTypeArguments()[0]);
            }
            return createMap(rawType, i);
        }
        Class cls = (Class) type;
        if (cls.isInterface()) {
            throw new JSONException("unsupport type " + type);
        } else if ("java.util.Collections$UnmodifiableMap".equals(cls.getName())) {
            return new HashMap();
        } else {
            try {
                return (Map) cls.newInstance();
            } catch (Exception e) {
                throw new JSONException("unsupport type " + type, e);
            }
        }
    }
}
