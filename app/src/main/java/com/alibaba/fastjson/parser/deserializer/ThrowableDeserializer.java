package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class ThrowableDeserializer extends JavaBeanDeserializer {
    @Override // com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    public ThrowableDeserializer(ParserConfig parserConfig, Class<?> cls) {
        super(parserConfig, cls, cls);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        if (java.lang.Throwable.class.isAssignableFrom(r14) != false) goto L_0x0037;
     */
    @Override // com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Class<?> cls;
        T t;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        JavaBeanDeserializer javaBeanDeserializer = null;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
            return null;
        }
        if (defaultJSONParser.getResolveStatus() == 2) {
            defaultJSONParser.setResolveStatus(0);
        } else if (jSONLexer.token() != 12) {
            throw new JSONException("syntax error");
        }
        if (type != null && (type instanceof Class)) {
            cls = (Class) type;
        }
        cls = null;
        HashMap hashMap = null;
        Throwable th = null;
        String str = null;
        StackTraceElement[] stackTraceElementArr = null;
        while (true) {
            String scanSymbol = jSONLexer.scanSymbol(defaultJSONParser.getSymbolTable());
            if (scanSymbol == null) {
                if (jSONLexer.token() == 13) {
                    jSONLexer.nextToken(16);
                    break;
                } else if (jSONLexer.token() == 16 && jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                }
            }
            jSONLexer.nextTokenWithColon(4);
            if (JSON.DEFAULT_TYPE_KEY.equals(scanSymbol)) {
                if (jSONLexer.token() == 4) {
                    cls = defaultJSONParser.getConfig().checkAutoType(jSONLexer.stringVal(), Throwable.class, jSONLexer.getFeatures());
                    jSONLexer.nextToken(16);
                } else {
                    throw new JSONException("syntax error");
                }
            } else if ("message".equals(scanSymbol)) {
                if (jSONLexer.token() == 8) {
                    str = null;
                } else if (jSONLexer.token() == 4) {
                    str = jSONLexer.stringVal();
                } else {
                    throw new JSONException("syntax error");
                }
                jSONLexer.nextToken();
            } else if ("cause".equals(scanSymbol)) {
                th = (Throwable) deserialze(defaultJSONParser, null, "cause");
            } else if ("stackTrace".equals(scanSymbol)) {
                stackTraceElementArr = (StackTraceElement[]) defaultJSONParser.parseObject((Class<Object>) StackTraceElement[].class);
            } else {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(scanSymbol, defaultJSONParser.parse());
            }
            if (jSONLexer.token() == 13) {
                jSONLexer.nextToken(16);
                break;
            }
        }
        if (cls == null) {
            t = (T) new Exception(str, th);
        } else if (Throwable.class.isAssignableFrom(cls)) {
            try {
                t = (T) createException(str, th, cls);
                if (t == null) {
                    t = (T) new Exception(str, th);
                }
            } catch (Exception e) {
                throw new JSONException("create instance error", e);
            }
        } else {
            throw new JSONException("type not match, not Throwable. " + cls.getName());
        }
        if (stackTraceElementArr != null) {
            t.setStackTrace(stackTraceElementArr);
        }
        if (hashMap != null) {
            if (cls != null) {
                if (cls == this.clazz) {
                    javaBeanDeserializer = this;
                } else {
                    ObjectDeserializer deserializer = defaultJSONParser.getConfig().getDeserializer(cls);
                    if (deserializer instanceof JavaBeanDeserializer) {
                        javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
                    }
                }
            }
            if (javaBeanDeserializer != null) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    Object value = entry.getValue();
                    FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer((String) entry.getKey());
                    if (fieldDeserializer != null) {
                        fieldDeserializer.setValue(t, value);
                    }
                }
            }
        }
        return t;
    }

    private Throwable createException(String str, Throwable th, Class<?> cls) throws Exception {
        Constructor<?>[] constructors = cls.getConstructors();
        Constructor<?> constructor = null;
        Constructor<?> constructor2 = null;
        Constructor<?> constructor3 = null;
        for (Constructor<?> constructor4 : constructors) {
            Class<?>[] parameterTypes = constructor4.getParameterTypes();
            if (parameterTypes.length == 0) {
                constructor3 = constructor4;
            } else if (parameterTypes.length == 1 && parameterTypes[0] == String.class) {
                constructor2 = constructor4;
            } else if (parameterTypes.length == 2 && parameterTypes[0] == String.class && parameterTypes[1] == Throwable.class) {
                constructor = constructor4;
            }
        }
        if (constructor != null) {
            return (Throwable) constructor.newInstance(str, th);
        }
        if (constructor2 != null) {
            return (Throwable) constructor2.newInstance(str);
        }
        if (constructor3 != null) {
            return (Throwable) constructor3.newInstance(new Object[0]);
        }
        return null;
    }
}
