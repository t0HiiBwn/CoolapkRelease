package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.asm.ClassWriter;
import com.alibaba.fastjson.asm.FieldWriter;
import com.alibaba.fastjson.asm.Label;
import com.alibaba.fastjson.asm.MethodVisitor;
import com.alibaba.fastjson.asm.MethodWriter;
import com.alibaba.fastjson.asm.Opcodes;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.SymbolTable;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class ASMDeserializerFactory implements Opcodes {
    static final String DefaultJSONParser = ASMUtils.type(DefaultJSONParser.class);
    static final String JSONLexerBase = ASMUtils.type(JSONLexerBase.class);
    public final ASMClassLoader classLoader;
    protected final AtomicLong seed = new AtomicLong();

    public ASMDeserializerFactory(ClassLoader classLoader2) {
        this.classLoader = classLoader2 instanceof ASMClassLoader ? (ASMClassLoader) classLoader2 : new ASMClassLoader(classLoader2);
    }

    public ObjectDeserializer createJavaBeanDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo) throws Exception {
        String str;
        Class<?> cls = javaBeanInfo.clazz;
        if (!cls.isPrimitive()) {
            String str2 = "FastjsonASMDeserializer_" + this.seed.incrementAndGet() + "_" + cls.getSimpleName();
            Package r1 = ASMDeserializerFactory.class.getPackage();
            if (r1 != null) {
                String name = r1.getName();
                String str3 = name.replace('.', '/') + "/" + str2;
                str = name + "." + str2;
                str2 = str3;
            } else {
                str = str2;
            }
            ClassWriter classWriter = new ClassWriter();
            classWriter.visit(49, 33, str2, ASMUtils.type(JavaBeanDeserializer.class), null);
            _init(classWriter, new Context(str2, parserConfig, javaBeanInfo, 3));
            _createInstance(classWriter, new Context(str2, parserConfig, javaBeanInfo, 3));
            _deserialze(classWriter, new Context(str2, parserConfig, javaBeanInfo, 5));
            _deserialzeArrayMapping(classWriter, new Context(str2, parserConfig, javaBeanInfo, 4));
            byte[] byteArray = classWriter.toByteArray();
            return (ObjectDeserializer) this.classLoader.defineClassPublic(str, byteArray, 0, byteArray.length).getConstructor(ParserConfig.class, JavaBeanInfo.class).newInstance(parserConfig, javaBeanInfo);
        }
        throw new IllegalArgumentException("not support type :" + cls.getName());
    }

    private void _setFlag(MethodVisitor methodVisitor, Context context, int i) {
        String str = "_asm_flag_" + (i / 32);
        methodVisitor.visitVarInsn(21, context.var(str));
        methodVisitor.visitLdcInsn(Integer.valueOf(1 << i));
        methodVisitor.visitInsn(128);
        methodVisitor.visitVarInsn(54, context.var(str));
    }

    private void _isFlag(MethodVisitor methodVisitor, Context context, int i, Label label) {
        methodVisitor.visitVarInsn(21, context.var("_asm_flag_" + (i / 32)));
        methodVisitor.visitLdcInsn(Integer.valueOf(1 << i));
        methodVisitor.visitInsn(126);
        methodVisitor.visitJumpInsn(153, label);
    }

    private void _deserialzeArrayMapping(ClassWriter classWriter, Context context) {
        FieldInfo[] fieldInfoArr;
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        sb.append("(L");
        String str = DefaultJSONParser;
        sb.append(str);
        sb.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
        MethodWriter methodWriter = new MethodWriter(classWriter, 1, "deserialzeArrayMapping", sb.toString(), null, null);
        defineVarLexer(context, methodWriter);
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitMethodInsn(182, str, "getSymbolTable", "()" + ASMUtils.desc(SymbolTable.class));
        String str2 = JSONLexerBase;
        methodWriter.visitMethodInsn(182, str2, "scanTypeName", "(" + ASMUtils.desc(SymbolTable.class) + ")Ljava/lang/String;");
        methodWriter.visitVarInsn(58, context.var("typeName"));
        Label label = new Label();
        methodWriter.visitVarInsn(25, context.var("typeName"));
        methodWriter.visitJumpInsn(198, label);
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitMethodInsn(182, str, "getConfig", "()" + ASMUtils.desc(ParserConfig.class));
        methodWriter.visitVarInsn(25, 0);
        methodWriter.visitFieldInsn(180, ASMUtils.type(JavaBeanDeserializer.class), "beanInfo", ASMUtils.desc(JavaBeanInfo.class));
        methodWriter.visitVarInsn(25, context.var("typeName"));
        String type = ASMUtils.type(JavaBeanDeserializer.class);
        methodWriter.visitMethodInsn(184, type, "getSeeAlso", "(" + ASMUtils.desc(ParserConfig.class) + ASMUtils.desc(JavaBeanInfo.class) + "Ljava/lang/String;)" + ASMUtils.desc(JavaBeanDeserializer.class));
        methodWriter.visitVarInsn(58, context.var("userTypeDeser"));
        methodWriter.visitVarInsn(25, context.var("userTypeDeser"));
        methodWriter.visitTypeInsn(193, ASMUtils.type(JavaBeanDeserializer.class));
        methodWriter.visitJumpInsn(153, label);
        methodWriter.visitVarInsn(25, context.var("userTypeDeser"));
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitVarInsn(25, 2);
        methodWriter.visitVarInsn(25, 3);
        methodWriter.visitVarInsn(25, 4);
        String type2 = ASMUtils.type(JavaBeanDeserializer.class);
        methodWriter.visitMethodInsn(182, type2, "deserialzeArrayMapping", "(L" + str + ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
        methodWriter.visitInsn(176);
        methodWriter.visitLabel(label);
        _createInstance(context, methodWriter);
        FieldInfo[] fieldInfoArr2 = context.beanInfo.sortedFields;
        int length = fieldInfoArr2.length;
        int i3 = 0;
        while (i3 < length) {
            boolean z = i3 == length + -1;
            int i4 = z ? 93 : 44;
            FieldInfo fieldInfo = fieldInfoArr2[i3];
            Class<?> cls = fieldInfo.fieldClass;
            Type type3 = fieldInfo.fieldType;
            if (cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE) {
                i2 = i3;
                fieldInfoArr = fieldInfoArr2;
                i = length;
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(16, i4);
                methodWriter.visitMethodInsn(182, JSONLexerBase, "scanInt", "(C)I");
                methodWriter.visitVarInsn(54, context.var(fieldInfo.name + "_asm"));
            } else {
                if (cls == Byte.class) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i4);
                    String str3 = JSONLexerBase;
                    methodWriter.visitMethodInsn(182, str3, "scanInt", "(C)I");
                    methodWriter.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                    methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                    Label label2 = new Label();
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitFieldInsn(180, str3, "matchStat", "I");
                    methodWriter.visitLdcInsn(5);
                    methodWriter.visitJumpInsn(160, label2);
                    methodWriter.visitInsn(1);
                    methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                    methodWriter.visitLabel(label2);
                } else if (cls == Short.class) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i4);
                    String str4 = JSONLexerBase;
                    methodWriter.visitMethodInsn(182, str4, "scanInt", "(C)I");
                    methodWriter.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                    methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                    Label label3 = new Label();
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitFieldInsn(180, str4, "matchStat", "I");
                    methodWriter.visitLdcInsn(5);
                    methodWriter.visitJumpInsn(160, label3);
                    methodWriter.visitInsn(1);
                    methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                    methodWriter.visitLabel(label3);
                } else if (cls == Integer.class) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i4);
                    String str5 = JSONLexerBase;
                    methodWriter.visitMethodInsn(182, str5, "scanInt", "(C)I");
                    methodWriter.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                    methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                    Label label4 = new Label();
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitFieldInsn(180, str5, "matchStat", "I");
                    methodWriter.visitLdcInsn(5);
                    methodWriter.visitJumpInsn(160, label4);
                    methodWriter.visitInsn(1);
                    methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                    methodWriter.visitLabel(label4);
                } else if (cls == Long.TYPE) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i4);
                    methodWriter.visitMethodInsn(182, JSONLexerBase, "scanLong", "(C)J");
                    methodWriter.visitVarInsn(55, context.var(fieldInfo.name + "_asm", 2));
                } else if (cls == Long.class) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i4);
                    String str6 = JSONLexerBase;
                    methodWriter.visitMethodInsn(182, str6, "scanLong", "(C)J");
                    methodWriter.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                    methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                    Label label5 = new Label();
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitFieldInsn(180, str6, "matchStat", "I");
                    methodWriter.visitLdcInsn(5);
                    methodWriter.visitJumpInsn(160, label5);
                    methodWriter.visitInsn(1);
                    methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                    methodWriter.visitLabel(label5);
                } else if (cls == Boolean.TYPE) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i4);
                    methodWriter.visitMethodInsn(182, JSONLexerBase, "scanBoolean", "(C)Z");
                    methodWriter.visitVarInsn(54, context.var(fieldInfo.name + "_asm"));
                } else if (cls == Float.TYPE) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i4);
                    methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFloat", "(C)F");
                    methodWriter.visitVarInsn(56, context.var(fieldInfo.name + "_asm"));
                } else if (cls == Float.class) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i4);
                    String str7 = JSONLexerBase;
                    methodWriter.visitMethodInsn(182, str7, "scanFloat", "(C)F");
                    methodWriter.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                    methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                    Label label6 = new Label();
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitFieldInsn(180, str7, "matchStat", "I");
                    methodWriter.visitLdcInsn(5);
                    methodWriter.visitJumpInsn(160, label6);
                    methodWriter.visitInsn(1);
                    methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                    methodWriter.visitLabel(label6);
                } else if (cls == Double.TYPE) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i4);
                    methodWriter.visitMethodInsn(182, JSONLexerBase, "scanDouble", "(C)D");
                    methodWriter.visitVarInsn(57, context.var(fieldInfo.name + "_asm", 2));
                } else if (cls == Double.class) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i4);
                    String str8 = JSONLexerBase;
                    methodWriter.visitMethodInsn(182, str8, "scanDouble", "(C)D");
                    methodWriter.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                    methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                    Label label7 = new Label();
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitFieldInsn(180, str8, "matchStat", "I");
                    methodWriter.visitLdcInsn(5);
                    methodWriter.visitJumpInsn(160, label7);
                    methodWriter.visitInsn(1);
                    methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                    methodWriter.visitLabel(label7);
                } else if (cls == Character.TYPE) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i4);
                    methodWriter.visitMethodInsn(182, JSONLexerBase, "scanString", "(C)Ljava/lang/String;");
                    methodWriter.visitInsn(3);
                    methodWriter.visitMethodInsn(182, "java/lang/String", "charAt", "(I)C");
                    methodWriter.visitVarInsn(54, context.var(fieldInfo.name + "_asm"));
                } else if (cls == String.class) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i4);
                    methodWriter.visitMethodInsn(182, JSONLexerBase, "scanString", "(C)Ljava/lang/String;");
                    methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                } else if (cls == BigDecimal.class) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i4);
                    methodWriter.visitMethodInsn(182, JSONLexerBase, "scanDecimal", "(C)Ljava/math/BigDecimal;");
                    methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                } else if (cls == Date.class) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i4);
                    methodWriter.visitMethodInsn(182, JSONLexerBase, "scanDate", "(C)Ljava/util/Date;");
                    methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                } else if (cls == UUID.class) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i4);
                    methodWriter.visitMethodInsn(182, JSONLexerBase, "scanUUID", "(C)Ljava/util/UUID;");
                    methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                } else if (cls.isEnum()) {
                    Label label8 = new Label();
                    Label label9 = new Label();
                    Label label10 = new Label();
                    Label label11 = new Label();
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    String str9 = JSONLexerBase;
                    methodWriter.visitMethodInsn(182, str9, "getCurrent", "()C");
                    methodWriter.visitInsn(89);
                    methodWriter.visitVarInsn(54, context.var("ch"));
                    methodWriter.visitLdcInsn(110);
                    methodWriter.visitJumpInsn(159, label11);
                    methodWriter.visitVarInsn(21, context.var("ch"));
                    methodWriter.visitLdcInsn(34);
                    methodWriter.visitJumpInsn(160, label8);
                    methodWriter.visitLabel(label11);
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(cls)));
                    methodWriter.visitVarInsn(25, 1);
                    String str10 = DefaultJSONParser;
                    methodWriter.visitMethodInsn(182, str10, "getSymbolTable", "()" + ASMUtils.desc(SymbolTable.class));
                    methodWriter.visitVarInsn(16, i4);
                    methodWriter.visitMethodInsn(182, str9, "scanEnum", "(Ljava/lang/Class;" + ASMUtils.desc(SymbolTable.class) + "C)Ljava/lang/Enum;");
                    methodWriter.visitJumpInsn(167, label10);
                    methodWriter.visitLabel(label8);
                    methodWriter.visitVarInsn(21, context.var("ch"));
                    methodWriter.visitLdcInsn(48);
                    methodWriter.visitJumpInsn(161, label9);
                    methodWriter.visitVarInsn(21, context.var("ch"));
                    methodWriter.visitLdcInsn(57);
                    methodWriter.visitJumpInsn(163, label9);
                    _getFieldDeser(context, methodWriter, fieldInfo);
                    methodWriter.visitTypeInsn(192, ASMUtils.type(EnumDeserializer.class));
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i4);
                    methodWriter.visitMethodInsn(182, str9, "scanInt", "(C)I");
                    methodWriter.visitMethodInsn(182, ASMUtils.type(EnumDeserializer.class), "valueOf", "(I)Ljava/lang/Enum;");
                    methodWriter.visitJumpInsn(167, label10);
                    methodWriter.visitLabel(label9);
                    methodWriter.visitVarInsn(25, 0);
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i4);
                    String type4 = ASMUtils.type(JavaBeanDeserializer.class);
                    methodWriter.visitMethodInsn(182, type4, "scanEnum", "(L" + str9 + ";C)Ljava/lang/Enum;");
                    methodWriter.visitLabel(label10);
                    methodWriter.visitTypeInsn(192, ASMUtils.type(cls));
                    methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                    i = length;
                    fieldInfoArr = fieldInfoArr2;
                    i2 = i3;
                } else if (Collection.class.isAssignableFrom(cls)) {
                    Class<?> collectionItemClass = TypeUtils.getCollectionItemClass(type3);
                    if (collectionItemClass == String.class) {
                        if (cls == List.class || cls == Collections.class || cls == ArrayList.class) {
                            methodWriter.visitTypeInsn(187, ASMUtils.type(ArrayList.class));
                            methodWriter.visitInsn(89);
                            methodWriter.visitMethodInsn(183, ASMUtils.type(ArrayList.class), "<init>", "()V");
                        } else {
                            methodWriter.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(cls)));
                            methodWriter.visitMethodInsn(184, ASMUtils.type(TypeUtils.class), "createCollection", "(Ljava/lang/Class;)Ljava/util/Collection;");
                        }
                        methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                        methodWriter.visitVarInsn(25, context.var("lexer"));
                        methodWriter.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
                        methodWriter.visitVarInsn(16, i4);
                        String str11 = JSONLexerBase;
                        methodWriter.visitMethodInsn(182, str11, "scanStringArray", "(Ljava/util/Collection;C)V");
                        Label label12 = new Label();
                        methodWriter.visitVarInsn(25, context.var("lexer"));
                        methodWriter.visitFieldInsn(180, str11, "matchStat", "I");
                        methodWriter.visitLdcInsn(5);
                        methodWriter.visitJumpInsn(160, label12);
                        methodWriter.visitInsn(1);
                        methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                        methodWriter.visitLabel(label12);
                        i3 = i3;
                    } else {
                        Label label13 = new Label();
                        methodWriter.visitVarInsn(25, context.var("lexer"));
                        String str12 = JSONLexerBase;
                        methodWriter.visitMethodInsn(182, str12, "token", "()I");
                        methodWriter.visitVarInsn(54, context.var("token"));
                        methodWriter.visitVarInsn(21, context.var("token"));
                        int i5 = i3 == 0 ? 14 : 16;
                        methodWriter.visitLdcInsn(Integer.valueOf(i5));
                        methodWriter.visitJumpInsn(159, label13);
                        methodWriter.visitVarInsn(25, 1);
                        methodWriter.visitLdcInsn(Integer.valueOf(i5));
                        String str13 = DefaultJSONParser;
                        methodWriter.visitMethodInsn(182, str13, "throwException", "(I)V");
                        methodWriter.visitLabel(label13);
                        Label label14 = new Label();
                        Label label15 = new Label();
                        methodWriter.visitVarInsn(25, context.var("lexer"));
                        methodWriter.visitMethodInsn(182, str12, "getCurrent", "()C");
                        methodWriter.visitVarInsn(16, 91);
                        methodWriter.visitJumpInsn(160, label14);
                        methodWriter.visitVarInsn(25, context.var("lexer"));
                        methodWriter.visitMethodInsn(182, str12, "next", "()C");
                        methodWriter.visitInsn(87);
                        methodWriter.visitVarInsn(25, context.var("lexer"));
                        methodWriter.visitLdcInsn(14);
                        methodWriter.visitMethodInsn(182, str12, "setToken", "(I)V");
                        methodWriter.visitJumpInsn(167, label15);
                        methodWriter.visitLabel(label14);
                        methodWriter.visitVarInsn(25, context.var("lexer"));
                        methodWriter.visitLdcInsn(14);
                        methodWriter.visitMethodInsn(182, str12, "nextToken", "(I)V");
                        methodWriter.visitLabel(label15);
                        i3 = i3;
                        _newCollection(methodWriter, cls, i3, false);
                        methodWriter.visitInsn(89);
                        methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                        _getCollectionFieldItemDeser(context, methodWriter, fieldInfo, collectionItemClass);
                        methodWriter.visitVarInsn(25, 1);
                        methodWriter.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(collectionItemClass)));
                        methodWriter.visitVarInsn(25, 3);
                        String type5 = ASMUtils.type(JavaBeanDeserializer.class);
                        methodWriter.visitMethodInsn(184, type5, "parseArray", "(Ljava/util/Collection;" + ASMUtils.desc(ObjectDeserializer.class) + "L" + str13 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)V");
                    }
                } else if (cls.isArray()) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitLdcInsn(14);
                    methodWriter.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
                    methodWriter.visitVarInsn(25, 1);
                    methodWriter.visitVarInsn(25, 0);
                    methodWriter.visitLdcInsn(Integer.valueOf(i3));
                    methodWriter.visitMethodInsn(182, ASMUtils.type(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
                    methodWriter.visitMethodInsn(182, DefaultJSONParser, "parseObject", "(Ljava/lang/reflect/Type;)Ljava/lang/Object;");
                    methodWriter.visitTypeInsn(192, ASMUtils.type(cls));
                    methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                    i2 = i3;
                    i = length;
                    fieldInfoArr = fieldInfoArr2;
                } else {
                    Label label16 = new Label();
                    Label label17 = new Label();
                    if (cls == Date.class) {
                        methodWriter.visitVarInsn(25, context.var("lexer"));
                        String str14 = JSONLexerBase;
                        methodWriter.visitMethodInsn(182, str14, "getCurrent", "()C");
                        methodWriter.visitLdcInsn(49);
                        methodWriter.visitJumpInsn(160, label16);
                        methodWriter.visitTypeInsn(187, ASMUtils.type(Date.class));
                        methodWriter.visitInsn(89);
                        methodWriter.visitVarInsn(25, context.var("lexer"));
                        methodWriter.visitVarInsn(16, i4);
                        methodWriter.visitMethodInsn(182, str14, "scanLong", "(C)J");
                        methodWriter.visitMethodInsn(183, ASMUtils.type(Date.class), "<init>", "(J)V");
                        methodWriter.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
                        methodWriter.visitJumpInsn(167, label17);
                    }
                    methodWriter.visitLabel(label16);
                    _quickNextToken(context, methodWriter, 14);
                    i2 = i3;
                    i = length;
                    fieldInfoArr = fieldInfoArr2;
                    _deserObject(context, methodWriter, fieldInfo, cls, i2);
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitMethodInsn(182, JSONLexerBase, "token", "()I");
                    methodWriter.visitLdcInsn(15);
                    methodWriter.visitJumpInsn(159, label17);
                    methodWriter.visitVarInsn(25, 0);
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    if (!z) {
                        methodWriter.visitLdcInsn(16);
                    } else {
                        methodWriter.visitLdcInsn(15);
                    }
                    String type6 = ASMUtils.type(JavaBeanDeserializer.class);
                    methodWriter.visitMethodInsn(183, type6, "check", "(" + ASMUtils.desc(JSONLexer.class) + "I)V");
                    methodWriter.visitLabel(label17);
                }
                i2 = i3;
                i = length;
                fieldInfoArr = fieldInfoArr2;
            }
            i3 = i2 + 1;
            length = i;
            fieldInfoArr2 = fieldInfoArr;
        }
        _batchSet(context, methodWriter, false);
        Label label18 = new Label();
        Label label19 = new Label();
        Label label20 = new Label();
        Label label21 = new Label();
        methodWriter.visitVarInsn(25, context.var("lexer"));
        String str15 = JSONLexerBase;
        methodWriter.visitMethodInsn(182, str15, "getCurrent", "()C");
        methodWriter.visitInsn(89);
        methodWriter.visitVarInsn(54, context.var("ch"));
        methodWriter.visitVarInsn(16, 44);
        methodWriter.visitJumpInsn(160, label19);
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitMethodInsn(182, str15, "next", "()C");
        methodWriter.visitInsn(87);
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitLdcInsn(16);
        methodWriter.visitMethodInsn(182, str15, "setToken", "(I)V");
        methodWriter.visitJumpInsn(167, label21);
        methodWriter.visitLabel(label19);
        methodWriter.visitVarInsn(21, context.var("ch"));
        methodWriter.visitVarInsn(16, 93);
        methodWriter.visitJumpInsn(160, label20);
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitMethodInsn(182, str15, "next", "()C");
        methodWriter.visitInsn(87);
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitLdcInsn(15);
        methodWriter.visitMethodInsn(182, str15, "setToken", "(I)V");
        methodWriter.visitJumpInsn(167, label21);
        methodWriter.visitLabel(label20);
        methodWriter.visitVarInsn(21, context.var("ch"));
        methodWriter.visitVarInsn(16, 26);
        methodWriter.visitJumpInsn(160, label18);
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitMethodInsn(182, str15, "next", "()C");
        methodWriter.visitInsn(87);
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitLdcInsn(20);
        methodWriter.visitMethodInsn(182, str15, "setToken", "(I)V");
        methodWriter.visitJumpInsn(167, label21);
        methodWriter.visitLabel(label18);
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitLdcInsn(16);
        methodWriter.visitMethodInsn(182, str15, "nextToken", "(I)V");
        methodWriter.visitLabel(label21);
        methodWriter.visitVarInsn(25, context.var("instance"));
        methodWriter.visitInsn(176);
        methodWriter.visitMaxs(5, context.variantIndex);
        methodWriter.visitEnd();
    }

    /* JADX WARNING: Removed duplicated region for block: B:129:0x0e36  */
    private void _deserialze(ClassWriter classWriter, Context context) {
        int i;
        String str;
        String str2;
        Label label;
        MethodWriter methodWriter;
        Label label2;
        int i2;
        int i3;
        Label label3;
        int i4;
        ASMDeserializerFactory aSMDeserializerFactory;
        Label label4;
        Label label5;
        Label label6;
        Label label7;
        ASMDeserializerFactory aSMDeserializerFactory2 = this;
        if (context.fieldInfoList.length != 0) {
            FieldInfo[] fieldInfoArr = context.fieldInfoList;
            for (FieldInfo fieldInfo : fieldInfoArr) {
                Class<?> cls = fieldInfo.fieldClass;
                Type type = fieldInfo.fieldType;
                if (cls == Character.TYPE) {
                    return;
                }
                if (Collection.class.isAssignableFrom(cls) && (!(type instanceof ParameterizedType) || !(((ParameterizedType) type).getActualTypeArguments()[0] instanceof Class))) {
                    return;
                }
            }
            JavaBeanInfo javaBeanInfo = context.beanInfo;
            context.fieldInfoList = javaBeanInfo.sortedFields;
            StringBuilder sb = new StringBuilder();
            sb.append("(L");
            String str3 = DefaultJSONParser;
            sb.append(str3);
            sb.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;");
            MethodWriter methodWriter2 = new MethodWriter(classWriter, 1, "deserialze", sb.toString(), null, null);
            Label label8 = new Label();
            Label label9 = new Label();
            Label label10 = new Label();
            Label label11 = new Label();
            aSMDeserializerFactory2.defineVarLexer(context, methodWriter2);
            Label label12 = new Label();
            methodWriter2.visitVarInsn(25, context.var("lexer"));
            String str4 = JSONLexerBase;
            methodWriter2.visitMethodInsn(182, str4, "token", "()I");
            methodWriter2.visitLdcInsn(14);
            methodWriter2.visitJumpInsn(160, label12);
            if ((javaBeanInfo.parserFeatures & Feature.SupportArrayToBean.mask) == 0) {
                methodWriter2.visitVarInsn(25, context.var("lexer"));
                methodWriter2.visitVarInsn(21, 4);
                methodWriter2.visitLdcInsn(Integer.valueOf(Feature.SupportArrayToBean.mask));
                methodWriter2.visitMethodInsn(182, str4, "isEnabled", "(II)Z");
                methodWriter2.visitJumpInsn(153, label12);
            }
            methodWriter2.visitVarInsn(25, 0);
            methodWriter2.visitVarInsn(25, 1);
            methodWriter2.visitVarInsn(25, 2);
            methodWriter2.visitVarInsn(25, 3);
            methodWriter2.visitInsn(1);
            methodWriter2.visitMethodInsn(183, context.className, "deserialzeArrayMapping", "(L" + str3 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
            methodWriter2.visitInsn(176);
            methodWriter2.visitLabel(label12);
            methodWriter2.visitVarInsn(25, context.var("lexer"));
            methodWriter2.visitLdcInsn(Integer.valueOf(Feature.SortFeidFastMatch.mask));
            methodWriter2.visitMethodInsn(182, str4, "isEnabled", "(I)Z");
            Label label13 = new Label();
            methodWriter2.visitJumpInsn(154, label13);
            methodWriter2.visitJumpInsn(200, label9);
            methodWriter2.visitLabel(label13);
            methodWriter2.visitVarInsn(25, context.var("lexer"));
            methodWriter2.visitLdcInsn(context.clazz.getName());
            methodWriter2.visitMethodInsn(182, str4, "scanType", "(Ljava/lang/String;)I");
            methodWriter2.visitLdcInsn(-1);
            Label label14 = new Label();
            methodWriter2.visitJumpInsn(160, label14);
            methodWriter2.visitJumpInsn(200, label9);
            methodWriter2.visitLabel(label14);
            methodWriter2.visitVarInsn(25, 1);
            methodWriter2.visitMethodInsn(182, str3, "getContext", "()" + ASMUtils.desc(ParseContext.class));
            methodWriter2.visitVarInsn(58, context.var("mark_context"));
            methodWriter2.visitInsn(3);
            methodWriter2.visitVarInsn(54, context.var("matchedCount"));
            aSMDeserializerFactory2._createInstance(context, methodWriter2);
            methodWriter2.visitVarInsn(25, 1);
            methodWriter2.visitMethodInsn(182, str3, "getContext", "()" + ASMUtils.desc(ParseContext.class));
            methodWriter2.visitVarInsn(58, context.var("context"));
            methodWriter2.visitVarInsn(25, 1);
            methodWriter2.visitVarInsn(25, context.var("context"));
            methodWriter2.visitVarInsn(25, context.var("instance"));
            methodWriter2.visitVarInsn(25, 3);
            methodWriter2.visitMethodInsn(182, str3, "setContext", "(" + ASMUtils.desc(ParseContext.class) + "Ljava/lang/Object;Ljava/lang/Object;)" + ASMUtils.desc(ParseContext.class));
            methodWriter2.visitVarInsn(58, context.var("childContext"));
            methodWriter2.visitVarInsn(25, context.var("lexer"));
            String str5 = "matchStat";
            String str6 = "I";
            methodWriter2.visitFieldInsn(180, str4, str5, str6);
            methodWriter2.visitLdcInsn(4);
            methodWriter2.visitJumpInsn(159, label10);
            int i5 = 3;
            methodWriter2.visitInsn(3);
            methodWriter2.visitIntInsn(54, context.var(str5));
            int length = context.fieldInfoList.length;
            int i6 = 0;
            while (i6 < length) {
                methodWriter2.visitInsn(i5);
                methodWriter2.visitVarInsn(54, context.var("_asm_flag_" + (i6 / 32)));
                i6 += 32;
                i5 = 3;
            }
            methodWriter2.visitVarInsn(25, context.var("lexer"));
            methodWriter2.visitLdcInsn(Integer.valueOf(Feature.InitStringFieldAsEmpty.mask));
            methodWriter2.visitMethodInsn(182, JSONLexerBase, "isEnabled", "(I)Z");
            methodWriter2.visitIntInsn(54, context.var("initStringFieldAsEmpty"));
            int i7 = 0;
            while (i7 < length) {
                FieldInfo fieldInfo2 = context.fieldInfoList[i7];
                Class<?> cls2 = fieldInfo2.fieldClass;
                if (cls2 == Boolean.TYPE || cls2 == Byte.TYPE || cls2 == Short.TYPE || cls2 == Integer.TYPE) {
                    label4 = label8;
                    label7 = label9;
                    label6 = label10;
                    label5 = label11;
                    methodWriter2.visitInsn(3);
                    methodWriter2.visitVarInsn(54, context.var(fieldInfo2.name + "_asm"));
                } else {
                    if (cls2 == Long.TYPE) {
                        methodWriter2.visitInsn(9);
                        methodWriter2.visitVarInsn(55, context.var(fieldInfo2.name + "_asm", 2));
                    } else if (cls2 == Float.TYPE) {
                        methodWriter2.visitInsn(11);
                        methodWriter2.visitVarInsn(56, context.var(fieldInfo2.name + "_asm"));
                    } else if (cls2 == Double.TYPE) {
                        methodWriter2.visitInsn(14);
                        methodWriter2.visitVarInsn(57, context.var(fieldInfo2.name + "_asm", 2));
                    } else {
                        if (cls2 == String.class) {
                            Label label15 = new Label();
                            label7 = label9;
                            Label label16 = new Label();
                            label6 = label10;
                            label5 = label11;
                            methodWriter2.visitVarInsn(21, context.var("initStringFieldAsEmpty"));
                            methodWriter2.visitJumpInsn(153, label16);
                            aSMDeserializerFactory2._setFlag(methodWriter2, context, i7);
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            label4 = label8;
                            methodWriter2.visitMethodInsn(182, JSONLexerBase, "stringDefaultValue", "()Ljava/lang/String;");
                            methodWriter2.visitJumpInsn(167, label15);
                            methodWriter2.visitLabel(label16);
                            methodWriter2.visitInsn(1);
                            methodWriter2.visitLabel(label15);
                        } else {
                            label4 = label8;
                            label7 = label9;
                            label6 = label10;
                            label5 = label11;
                            methodWriter2.visitInsn(1);
                        }
                        methodWriter2.visitTypeInsn(192, ASMUtils.type(cls2));
                        methodWriter2.visitVarInsn(58, context.var(fieldInfo2.name + "_asm"));
                    }
                    label4 = label8;
                    label7 = label9;
                    label6 = label10;
                    label5 = label11;
                }
                i7++;
                aSMDeserializerFactory2 = this;
                label9 = label7;
                label10 = label6;
                label11 = label5;
                label8 = label4;
            }
            Label label17 = label8;
            Label label18 = label11;
            int i8 = 0;
            while (i8 < length) {
                FieldInfo fieldInfo3 = context.fieldInfoList[i8];
                Class<?> cls3 = fieldInfo3.fieldClass;
                Type type2 = fieldInfo3.fieldType;
                Label label19 = new Label();
                if (cls3 == Boolean.TYPE) {
                    methodWriter2.visitVarInsn(25, context.var("lexer"));
                    methodWriter2.visitVarInsn(25, 0);
                    methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                    methodWriter2.visitMethodInsn(182, JSONLexerBase, "scanFieldBoolean", "([C)Z");
                    methodWriter2.visitVarInsn(54, context.var(fieldInfo3.name + "_asm"));
                    i4 = length;
                } else {
                    i4 = length;
                    if (cls3 == Byte.TYPE) {
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitVarInsn(25, 0);
                        methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                        methodWriter2.visitMethodInsn(182, JSONLexerBase, "scanFieldInt", "([C)I");
                        methodWriter2.visitVarInsn(54, context.var(fieldInfo3.name + "_asm"));
                    } else {
                        label3 = label19;
                        i3 = i8;
                        if (cls3 == Byte.class) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                            String str7 = JSONLexerBase;
                            methodWriter2.visitMethodInsn(182, str7, "scanFieldInt", "([C)I");
                            methodWriter2.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                            methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            Label label20 = new Label();
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitFieldInsn(180, str7, str5, str6);
                            methodWriter2.visitLdcInsn(5);
                            methodWriter2.visitJumpInsn(160, label20);
                            methodWriter2.visitInsn(1);
                            methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            methodWriter2.visitLabel(label20);
                        } else if (cls3 == Short.TYPE) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                            methodWriter2.visitMethodInsn(182, JSONLexerBase, "scanFieldInt", "([C)I");
                            methodWriter2.visitVarInsn(54, context.var(fieldInfo3.name + "_asm"));
                        } else if (cls3 == Short.class) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                            String str8 = JSONLexerBase;
                            methodWriter2.visitMethodInsn(182, str8, "scanFieldInt", "([C)I");
                            methodWriter2.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                            methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            Label label21 = new Label();
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitFieldInsn(180, str8, str5, str6);
                            methodWriter2.visitLdcInsn(5);
                            methodWriter2.visitJumpInsn(160, label21);
                            methodWriter2.visitInsn(1);
                            methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            methodWriter2.visitLabel(label21);
                        } else if (cls3 == Integer.TYPE) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                            methodWriter2.visitMethodInsn(182, JSONLexerBase, "scanFieldInt", "([C)I");
                            methodWriter2.visitVarInsn(54, context.var(fieldInfo3.name + "_asm"));
                        } else if (cls3 == Integer.class) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                            String str9 = JSONLexerBase;
                            methodWriter2.visitMethodInsn(182, str9, "scanFieldInt", "([C)I");
                            methodWriter2.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                            methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            Label label22 = new Label();
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitFieldInsn(180, str9, str5, str6);
                            methodWriter2.visitLdcInsn(5);
                            methodWriter2.visitJumpInsn(160, label22);
                            methodWriter2.visitInsn(1);
                            methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            methodWriter2.visitLabel(label22);
                        } else if (cls3 == Long.TYPE) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                            methodWriter2.visitMethodInsn(182, JSONLexerBase, "scanFieldLong", "([C)J");
                            methodWriter2.visitVarInsn(55, context.var(fieldInfo3.name + "_asm", 2));
                        } else if (cls3 == Long.class) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                            String str10 = JSONLexerBase;
                            methodWriter2.visitMethodInsn(182, str10, "scanFieldLong", "([C)J");
                            methodWriter2.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                            methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            Label label23 = new Label();
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitFieldInsn(180, str10, str5, str6);
                            methodWriter2.visitLdcInsn(5);
                            methodWriter2.visitJumpInsn(160, label23);
                            methodWriter2.visitInsn(1);
                            methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            methodWriter2.visitLabel(label23);
                        } else if (cls3 == Float.TYPE) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                            methodWriter2.visitMethodInsn(182, JSONLexerBase, "scanFieldFloat", "([C)F");
                            methodWriter2.visitVarInsn(56, context.var(fieldInfo3.name + "_asm"));
                        } else if (cls3 == Float.class) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                            String str11 = JSONLexerBase;
                            methodWriter2.visitMethodInsn(182, str11, "scanFieldFloat", "([C)F");
                            methodWriter2.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                            methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            Label label24 = new Label();
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitFieldInsn(180, str11, str5, str6);
                            methodWriter2.visitLdcInsn(5);
                            methodWriter2.visitJumpInsn(160, label24);
                            methodWriter2.visitInsn(1);
                            methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            methodWriter2.visitLabel(label24);
                        } else if (cls3 == Double.TYPE) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                            methodWriter2.visitMethodInsn(182, JSONLexerBase, "scanFieldDouble", "([C)D");
                            methodWriter2.visitVarInsn(57, context.var(fieldInfo3.name + "_asm", 2));
                        } else {
                            if (cls3 == Double.class) {
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitVarInsn(25, 0);
                                methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                                String str12 = JSONLexerBase;
                                methodWriter2.visitMethodInsn(182, str12, "scanFieldDouble", "([C)D");
                                methodWriter2.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                                methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                                Label label25 = new Label();
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitFieldInsn(180, str12, str5, str6);
                                methodWriter2.visitLdcInsn(5);
                                methodWriter2.visitJumpInsn(160, label25);
                                methodWriter2.visitInsn(1);
                                methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                                methodWriter2.visitLabel(label25);
                            } else if (cls3 == String.class) {
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitVarInsn(25, 0);
                                methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                                methodWriter2.visitMethodInsn(182, JSONLexerBase, "scanFieldString", "([C)Ljava/lang/String;");
                                methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            } else if (cls3 == Date.class) {
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitVarInsn(25, 0);
                                methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                                methodWriter2.visitMethodInsn(182, JSONLexerBase, "scanFieldDate", "([C)Ljava/util/Date;");
                                methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            } else if (cls3 == UUID.class) {
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitVarInsn(25, 0);
                                methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                                methodWriter2.visitMethodInsn(182, JSONLexerBase, "scanFieldUUID", "([C)Ljava/util/UUID;");
                                methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            } else if (cls3 == BigDecimal.class) {
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitVarInsn(25, 0);
                                methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                                methodWriter2.visitMethodInsn(182, JSONLexerBase, "scanFieldDecimal", "([C)Ljava/math/BigDecimal;");
                                methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            } else if (cls3 == BigInteger.class) {
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitVarInsn(25, 0);
                                methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                                methodWriter2.visitMethodInsn(182, JSONLexerBase, "scanFieldBigInteger", "([C)Ljava/math/BigInteger;");
                                methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            } else if (cls3 == int[].class) {
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitVarInsn(25, 0);
                                methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                                methodWriter2.visitMethodInsn(182, JSONLexerBase, "scanFieldIntArray", "([C)[I");
                                methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            } else if (cls3 == float[].class) {
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitVarInsn(25, 0);
                                methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                                methodWriter2.visitMethodInsn(182, JSONLexerBase, "scanFieldFloatArray", "([C)[F");
                                methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            } else if (cls3 == float[][].class) {
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitVarInsn(25, 0);
                                methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                                methodWriter2.visitMethodInsn(182, JSONLexerBase, "scanFieldFloatArray2", "([C)[[F");
                                methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                            } else if (cls3.isEnum()) {
                                methodWriter2.visitVarInsn(25, 0);
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitVarInsn(25, 0);
                                methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                                aSMDeserializerFactory = this;
                                aSMDeserializerFactory._getFieldDeser(context, methodWriter2, fieldInfo3);
                                methodWriter2.visitMethodInsn(182, ASMUtils.type(JavaBeanDeserializer.class), "scanEnum", "(L" + JSONLexerBase + ";[C" + ASMUtils.desc(ObjectDeserializer.class) + ")Ljava/lang/Enum;");
                                methodWriter2.visitTypeInsn(192, ASMUtils.type(cls3));
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(fieldInfo3.name);
                                sb2.append("_asm");
                                methodWriter2.visitVarInsn(58, context.var(sb2.toString()));
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                String str13 = JSONLexerBase;
                                methodWriter2.visitFieldInsn(180, str13, str5, str6);
                                Label label26 = new Label();
                                methodWriter2.visitJumpInsn(158, label26);
                                aSMDeserializerFactory._setFlag(methodWriter2, context, i3);
                                methodWriter2.visitLabel(label26);
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitFieldInsn(180, str13, str5, str6);
                                methodWriter2.visitInsn(89);
                                methodWriter2.visitVarInsn(54, context.var(str5));
                                methodWriter2.visitLdcInsn(-1);
                                methodWriter2.visitJumpInsn(159, label17);
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitFieldInsn(180, str13, str5, str6);
                                methodWriter2.visitJumpInsn(158, label3);
                                methodWriter2.visitVarInsn(21, context.var("matchedCount"));
                                methodWriter2.visitInsn(4);
                                methodWriter2.visitInsn(96);
                                methodWriter2.visitVarInsn(54, context.var("matchedCount"));
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitFieldInsn(180, str13, str5, str6);
                                methodWriter2.visitLdcInsn(4);
                                label = label18;
                                methodWriter2.visitJumpInsn(159, label);
                                methodWriter2.visitLabel(label3);
                                if (i3 == i4 - 1) {
                                    methodWriter2.visitVarInsn(25, context.var("lexer"));
                                    methodWriter2.visitFieldInsn(180, str13, str5, str6);
                                    methodWriter2.visitLdcInsn(4);
                                    methodWriter2.visitJumpInsn(160, label17);
                                }
                                str2 = str6;
                                str = str5;
                                label2 = label17;
                                methodWriter = methodWriter2;
                                i = i4;
                                i2 = i3;
                                int i9 = i2 + 1;
                                label17 = label2;
                                methodWriter2 = methodWriter;
                                str6 = str2;
                                str5 = str;
                                length = i;
                                i8 = i9;
                                label18 = label;
                            } else {
                                aSMDeserializerFactory = this;
                                if (Collection.class.isAssignableFrom(cls3)) {
                                    methodWriter2.visitVarInsn(25, context.var("lexer"));
                                    methodWriter2.visitVarInsn(25, 0);
                                    methodWriter2.visitFieldInsn(180, context.className, fieldInfo3.name + "_asm_prefix__", "[C");
                                    Class<?> collectionItemClass = TypeUtils.getCollectionItemClass(type2);
                                    if (collectionItemClass == String.class) {
                                        methodWriter2.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(cls3)));
                                        methodWriter2.visitMethodInsn(182, JSONLexerBase, "scanFieldStringArray", "([CLjava/lang/Class;)" + ASMUtils.desc(Collection.class));
                                        methodWriter2.visitVarInsn(58, context.var(fieldInfo3.name + "_asm"));
                                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                                        String str13 = JSONLexerBase;
                                        methodWriter2.visitFieldInsn(180, str13, str5, str6);
                                        Label label26 = new Label();
                                        methodWriter2.visitJumpInsn(158, label26);
                                        aSMDeserializerFactory._setFlag(methodWriter2, context, i3);
                                        methodWriter2.visitLabel(label26);
                                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                                        methodWriter2.visitFieldInsn(180, str13, str5, str6);
                                        methodWriter2.visitInsn(89);
                                        methodWriter2.visitVarInsn(54, context.var(str5));
                                        methodWriter2.visitLdcInsn(-1);
                                        methodWriter2.visitJumpInsn(159, label17);
                                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                                        methodWriter2.visitFieldInsn(180, str13, str5, str6);
                                        methodWriter2.visitJumpInsn(158, label3);
                                        methodWriter2.visitVarInsn(21, context.var("matchedCount"));
                                        methodWriter2.visitInsn(4);
                                        methodWriter2.visitInsn(96);
                                        methodWriter2.visitVarInsn(54, context.var("matchedCount"));
                                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                                        methodWriter2.visitFieldInsn(180, str13, str5, str6);
                                        methodWriter2.visitLdcInsn(4);
                                        label = label18;
                                        methodWriter2.visitJumpInsn(159, label);
                                        methodWriter2.visitLabel(label3);
                                        if (i3 == i4 - 1) {
                                        }
                                        str2 = str6;
                                        str = str5;
                                        label2 = label17;
                                        methodWriter = methodWriter2;
                                        i = i4;
                                        i2 = i3;
                                    } else {
                                        label = label18;
                                        str2 = str6;
                                        str = str5;
                                        i = i4;
                                        label2 = label17;
                                        methodWriter = methodWriter2;
                                        i2 = i3;
                                        _deserialze_list_obj(context, methodWriter2, label17, fieldInfo3, cls3, collectionItemClass, i2);
                                        if (i2 == i - 1) {
                                            aSMDeserializerFactory._deserialize_endCheck(context, methodWriter, label2);
                                        }
                                    }
                                } else {
                                    str2 = str6;
                                    str = str5;
                                    methodWriter = methodWriter2;
                                    label = label18;
                                    label2 = label17;
                                    i = i4;
                                    i2 = i3;
                                    _deserialze_obj(context, methodWriter, label2, fieldInfo3, cls3, i2);
                                    if (i2 == i - 1) {
                                        aSMDeserializerFactory._deserialize_endCheck(context, methodWriter, label2);
                                    }
                                }
                                int i9 = i2 + 1;
                                label17 = label2;
                                methodWriter2 = methodWriter;
                                str6 = str2;
                                str5 = str;
                                length = i;
                                i8 = i9;
                                label18 = label;
                            }
                            aSMDeserializerFactory = this;
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            String str13 = JSONLexerBase;
                            methodWriter2.visitFieldInsn(180, str13, str5, str6);
                            Label label26 = new Label();
                            methodWriter2.visitJumpInsn(158, label26);
                            aSMDeserializerFactory._setFlag(methodWriter2, context, i3);
                            methodWriter2.visitLabel(label26);
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitFieldInsn(180, str13, str5, str6);
                            methodWriter2.visitInsn(89);
                            methodWriter2.visitVarInsn(54, context.var(str5));
                            methodWriter2.visitLdcInsn(-1);
                            methodWriter2.visitJumpInsn(159, label17);
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitFieldInsn(180, str13, str5, str6);
                            methodWriter2.visitJumpInsn(158, label3);
                            methodWriter2.visitVarInsn(21, context.var("matchedCount"));
                            methodWriter2.visitInsn(4);
                            methodWriter2.visitInsn(96);
                            methodWriter2.visitVarInsn(54, context.var("matchedCount"));
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitFieldInsn(180, str13, str5, str6);
                            methodWriter2.visitLdcInsn(4);
                            label = label18;
                            methodWriter2.visitJumpInsn(159, label);
                            methodWriter2.visitLabel(label3);
                            if (i3 == i4 - 1) {
                            }
                            str2 = str6;
                            str = str5;
                            label2 = label17;
                            methodWriter = methodWriter2;
                            i = i4;
                            i2 = i3;
                            int i9 = i2 + 1;
                            label17 = label2;
                            methodWriter2 = methodWriter;
                            str6 = str2;
                            str5 = str;
                            length = i;
                            i8 = i9;
                            label18 = label;
                        }
                        aSMDeserializerFactory = this;
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        String str13 = JSONLexerBase;
                        methodWriter2.visitFieldInsn(180, str13, str5, str6);
                        Label label26 = new Label();
                        methodWriter2.visitJumpInsn(158, label26);
                        aSMDeserializerFactory._setFlag(methodWriter2, context, i3);
                        methodWriter2.visitLabel(label26);
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitFieldInsn(180, str13, str5, str6);
                        methodWriter2.visitInsn(89);
                        methodWriter2.visitVarInsn(54, context.var(str5));
                        methodWriter2.visitLdcInsn(-1);
                        methodWriter2.visitJumpInsn(159, label17);
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitFieldInsn(180, str13, str5, str6);
                        methodWriter2.visitJumpInsn(158, label3);
                        methodWriter2.visitVarInsn(21, context.var("matchedCount"));
                        methodWriter2.visitInsn(4);
                        methodWriter2.visitInsn(96);
                        methodWriter2.visitVarInsn(54, context.var("matchedCount"));
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitFieldInsn(180, str13, str5, str6);
                        methodWriter2.visitLdcInsn(4);
                        label = label18;
                        methodWriter2.visitJumpInsn(159, label);
                        methodWriter2.visitLabel(label3);
                        if (i3 == i4 - 1) {
                        }
                        str2 = str6;
                        str = str5;
                        label2 = label17;
                        methodWriter = methodWriter2;
                        i = i4;
                        i2 = i3;
                        int i9 = i2 + 1;
                        label17 = label2;
                        methodWriter2 = methodWriter;
                        str6 = str2;
                        str5 = str;
                        length = i;
                        i8 = i9;
                        label18 = label;
                    }
                }
                i3 = i8;
                label3 = label19;
                aSMDeserializerFactory = this;
                methodWriter2.visitVarInsn(25, context.var("lexer"));
                String str13 = JSONLexerBase;
                methodWriter2.visitFieldInsn(180, str13, str5, str6);
                Label label26 = new Label();
                methodWriter2.visitJumpInsn(158, label26);
                aSMDeserializerFactory._setFlag(methodWriter2, context, i3);
                methodWriter2.visitLabel(label26);
                methodWriter2.visitVarInsn(25, context.var("lexer"));
                methodWriter2.visitFieldInsn(180, str13, str5, str6);
                methodWriter2.visitInsn(89);
                methodWriter2.visitVarInsn(54, context.var(str5));
                methodWriter2.visitLdcInsn(-1);
                methodWriter2.visitJumpInsn(159, label17);
                methodWriter2.visitVarInsn(25, context.var("lexer"));
                methodWriter2.visitFieldInsn(180, str13, str5, str6);
                methodWriter2.visitJumpInsn(158, label3);
                methodWriter2.visitVarInsn(21, context.var("matchedCount"));
                methodWriter2.visitInsn(4);
                methodWriter2.visitInsn(96);
                methodWriter2.visitVarInsn(54, context.var("matchedCount"));
                methodWriter2.visitVarInsn(25, context.var("lexer"));
                methodWriter2.visitFieldInsn(180, str13, str5, str6);
                methodWriter2.visitLdcInsn(4);
                label = label18;
                methodWriter2.visitJumpInsn(159, label);
                methodWriter2.visitLabel(label3);
                if (i3 == i4 - 1) {
                }
                str2 = str6;
                str = str5;
                label2 = label17;
                methodWriter = methodWriter2;
                i = i4;
                i2 = i3;
                int i9 = i2 + 1;
                label17 = label2;
                methodWriter2 = methodWriter;
                str6 = str2;
                str5 = str;
                length = i;
                i8 = i9;
                label18 = label;
            }
            methodWriter2.visitLabel(label18);
            if (!context.clazz.isInterface() && !Modifier.isAbstract(context.clazz.getModifiers())) {
                _batchSet(context, methodWriter2);
            }
            methodWriter2.visitLabel(label10);
            _setContext(context, methodWriter2);
            methodWriter2.visitVarInsn(25, context.var("instance"));
            Method method = context.beanInfo.buildMethod;
            if (method != null) {
                methodWriter2.visitMethodInsn(182, ASMUtils.type(context.getInstClass()), method.getName(), "()" + ASMUtils.desc(method.getReturnType()));
            }
            methodWriter2.visitInsn(176);
            methodWriter2.visitLabel(label17);
            _batchSet(context, methodWriter2);
            methodWriter2.visitVarInsn(25, 0);
            methodWriter2.visitVarInsn(25, 1);
            methodWriter2.visitVarInsn(25, 2);
            methodWriter2.visitVarInsn(25, 3);
            methodWriter2.visitVarInsn(25, context.var("instance"));
            methodWriter2.visitVarInsn(21, 4);
            int i10 = length / 32;
            if (!(length == 0 || length % 32 == 0)) {
                i10++;
            }
            if (i10 == 1) {
                methodWriter2.visitInsn(4);
            } else {
                methodWriter2.visitIntInsn(16, i10);
            }
            methodWriter2.visitIntInsn(188, 10);
            for (int i11 = 0; i11 < i10; i11++) {
                methodWriter2.visitInsn(89);
                if (i11 == 0) {
                    methodWriter2.visitInsn(3);
                } else if (i11 == 1) {
                    methodWriter2.visitInsn(4);
                } else {
                    methodWriter2.visitIntInsn(16, i11);
                }
                methodWriter2.visitVarInsn(21, context.var("_asm_flag_" + i11));
                methodWriter2.visitInsn(79);
            }
            String type3 = ASMUtils.type(JavaBeanDeserializer.class);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("(L");
            String str14 = DefaultJSONParser;
            sb3.append(str14);
            sb3.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;I[I)Ljava/lang/Object;");
            methodWriter2.visitMethodInsn(182, type3, "parseRest", sb3.toString());
            methodWriter2.visitTypeInsn(192, ASMUtils.type(context.clazz));
            methodWriter2.visitInsn(176);
            methodWriter2.visitLabel(label9);
            methodWriter2.visitVarInsn(25, 0);
            methodWriter2.visitVarInsn(25, 1);
            methodWriter2.visitVarInsn(25, 2);
            methodWriter2.visitVarInsn(25, 3);
            methodWriter2.visitVarInsn(21, 4);
            methodWriter2.visitMethodInsn(183, ASMUtils.type(JavaBeanDeserializer.class), "deserialze", "(L" + str14 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;");
            methodWriter2.visitInsn(176);
            methodWriter2.visitMaxs(10, context.variantIndex);
            methodWriter2.visitEnd();
        }
    }

    private void defineVarLexer(Context context, MethodVisitor methodVisitor) {
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitFieldInsn(180, DefaultJSONParser, "lexer", ASMUtils.desc(JSONLexer.class));
        methodVisitor.visitTypeInsn(192, JSONLexerBase);
        methodVisitor.visitVarInsn(58, context.var("lexer"));
    }

    private void _createInstance(Context context, MethodVisitor methodVisitor) {
        Constructor<?> constructor = context.beanInfo.defaultConstructor;
        if (Modifier.isPublic(constructor.getModifiers())) {
            methodVisitor.visitTypeInsn(187, ASMUtils.type(context.getInstClass()));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, ASMUtils.type(constructor.getDeclaringClass()), "<init>", "()V");
            methodVisitor.visitVarInsn(58, context.var("instance"));
            return;
        }
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(180, ASMUtils.type(JavaBeanDeserializer.class), "clazz", "Ljava/lang/Class;");
        String type = ASMUtils.type(JavaBeanDeserializer.class);
        methodVisitor.visitMethodInsn(183, type, "createInstance", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;)Ljava/lang/Object;");
        methodVisitor.visitTypeInsn(192, ASMUtils.type(context.getInstClass()));
        methodVisitor.visitVarInsn(58, context.var("instance"));
    }

    private void _batchSet(Context context, MethodVisitor methodVisitor) {
        _batchSet(context, methodVisitor, true);
    }

    private void _batchSet(Context context, MethodVisitor methodVisitor, boolean z) {
        int length = context.fieldInfoList.length;
        for (int i = 0; i < length; i++) {
            Label label = new Label();
            if (z) {
                _isFlag(methodVisitor, context, i, label);
            }
            _loadAndSet(context, methodVisitor, context.fieldInfoList[i]);
            if (z) {
                methodVisitor.visitLabel(label);
            }
        }
    }

    private void _loadAndSet(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Class<?> cls = fieldInfo.fieldClass;
        Type type = fieldInfo.fieldType;
        if (cls == Boolean.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(21, context.var(fieldInfo.name + "_asm"));
            _set(context, methodVisitor, fieldInfo);
        } else if (cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE || cls == Character.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(21, context.var(fieldInfo.name + "_asm"));
            _set(context, methodVisitor, fieldInfo);
        } else if (cls == Long.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(22, context.var(fieldInfo.name + "_asm", 2));
            if (fieldInfo.method != null) {
                methodVisitor.visitMethodInsn(182, ASMUtils.type(context.getInstClass()), fieldInfo.method.getName(), ASMUtils.desc(fieldInfo.method));
                if (!fieldInfo.method.getReturnType().equals(Void.TYPE)) {
                    methodVisitor.visitInsn(87);
                    return;
                }
                return;
            }
            methodVisitor.visitFieldInsn(181, ASMUtils.type(fieldInfo.declaringClass), fieldInfo.field.getName(), ASMUtils.desc(fieldInfo.fieldClass));
        } else if (cls == Float.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(23, context.var(fieldInfo.name + "_asm"));
            _set(context, methodVisitor, fieldInfo);
        } else if (cls == Double.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(24, context.var(fieldInfo.name + "_asm", 2));
            _set(context, methodVisitor, fieldInfo);
        } else if (cls == String.class) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
            _set(context, methodVisitor, fieldInfo);
        } else if (cls.isEnum()) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
            _set(context, methodVisitor, fieldInfo);
        } else if (Collection.class.isAssignableFrom(cls)) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            if (TypeUtils.getCollectionItemClass(type) == String.class) {
                methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
                methodVisitor.visitTypeInsn(192, ASMUtils.type(cls));
            } else {
                methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
            }
            _set(context, methodVisitor, fieldInfo);
        } else {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
            _set(context, methodVisitor, fieldInfo);
        }
    }

    private void _set(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Method method = fieldInfo.method;
        if (method != null) {
            methodVisitor.visitMethodInsn(method.getDeclaringClass().isInterface() ? 185 : 182, ASMUtils.type(fieldInfo.declaringClass), method.getName(), ASMUtils.desc(method));
            if (!fieldInfo.method.getReturnType().equals(Void.TYPE)) {
                methodVisitor.visitInsn(87);
                return;
            }
            return;
        }
        methodVisitor.visitFieldInsn(181, ASMUtils.type(fieldInfo.declaringClass), fieldInfo.field.getName(), ASMUtils.desc(fieldInfo.fieldClass));
    }

    private void _setContext(Context context, MethodVisitor methodVisitor) {
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, context.var("context"));
        String str = DefaultJSONParser;
        methodVisitor.visitMethodInsn(182, str, "setContext", "(" + ASMUtils.desc(ParseContext.class) + ")V");
        Label label = new Label();
        methodVisitor.visitVarInsn(25, context.var("childContext"));
        methodVisitor.visitJumpInsn(198, label);
        methodVisitor.visitVarInsn(25, context.var("childContext"));
        methodVisitor.visitVarInsn(25, context.var("instance"));
        methodVisitor.visitFieldInsn(181, ASMUtils.type(ParseContext.class), "object", "Ljava/lang/Object;");
        methodVisitor.visitLabel(label);
    }

    private void _deserialize_endCheck(Context context, MethodVisitor methodVisitor, Label label) {
        methodVisitor.visitIntInsn(21, context.var("matchedCount"));
        methodVisitor.visitJumpInsn(158, label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
        methodVisitor.visitLdcInsn(13);
        methodVisitor.visitJumpInsn(160, label);
        _quickNextTokenComma(context, methodVisitor);
    }

    private void _deserialze_list_obj(Context context, MethodVisitor methodVisitor, Label label, FieldInfo fieldInfo, Class<?> cls, Class<?> cls2, int i) {
        String str;
        Label label2;
        String str2;
        String str3;
        String str4;
        int i2;
        String str5;
        Label label3 = new Label();
        String str6 = JSONLexerBase;
        methodVisitor.visitMethodInsn(182, str6, "matchField", "([C)Z");
        methodVisitor.visitJumpInsn(153, label3);
        _setFlag(methodVisitor, context, i);
        Label label4 = new Label();
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, str6, "token", "()I");
        methodVisitor.visitLdcInsn(8);
        methodVisitor.visitJumpInsn(160, label4);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(16);
        methodVisitor.visitMethodInsn(182, str6, "nextToken", "(I)V");
        methodVisitor.visitJumpInsn(167, label3);
        methodVisitor.visitLabel(label4);
        Label label5 = new Label();
        Label label6 = new Label();
        Label label7 = new Label();
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, str6, "token", "()I");
        methodVisitor.visitLdcInsn(21);
        methodVisitor.visitJumpInsn(160, label6);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(14);
        methodVisitor.visitMethodInsn(182, str6, "nextToken", "(I)V");
        _newCollection(methodVisitor, cls, i, true);
        methodVisitor.visitJumpInsn(167, label5);
        methodVisitor.visitLabel(label6);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, str6, "token", "()I");
        methodVisitor.visitLdcInsn(14);
        methodVisitor.visitJumpInsn(159, label7);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, str6, "token", "()I");
        methodVisitor.visitLdcInsn(12);
        methodVisitor.visitJumpInsn(160, label);
        _newCollection(methodVisitor, cls, i, false);
        methodVisitor.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
        _getCollectionFieldItemDeser(context, methodVisitor, fieldInfo, cls2);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(cls2)));
        methodVisitor.visitInsn(3);
        methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        String type = ASMUtils.type(ObjectDeserializer.class);
        StringBuilder sb = new StringBuilder();
        sb.append("(L");
        String str7 = DefaultJSONParser;
        sb.append(str7);
        sb.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        methodVisitor.visitMethodInsn(185, type, "deserialze", sb.toString());
        methodVisitor.visitVarInsn(58, context.var("list_item_value"));
        methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
        methodVisitor.visitVarInsn(25, context.var("list_item_value"));
        if (cls.isInterface()) {
            str = "list_item_value";
            methodVisitor.visitMethodInsn(185, ASMUtils.type(cls), "add", "(Ljava/lang/Object;)Z");
        } else {
            str = "list_item_value";
            methodVisitor.visitMethodInsn(182, ASMUtils.type(cls), "add", "(Ljava/lang/Object;)Z");
        }
        methodVisitor.visitInsn(87);
        methodVisitor.visitJumpInsn(167, label3);
        methodVisitor.visitLabel(label7);
        _newCollection(methodVisitor, cls, i, false);
        methodVisitor.visitLabel(label5);
        methodVisitor.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
        boolean isPrimitive2 = ParserConfig.isPrimitive2(fieldInfo.fieldClass);
        _getCollectionFieldItemDeser(context, methodVisitor, fieldInfo, cls2);
        if (isPrimitive2) {
            methodVisitor.visitMethodInsn(185, ASMUtils.type(ObjectDeserializer.class), "getFastMatchToken", "()I");
            methodVisitor.visitVarInsn(54, context.var("fastMatchToken"));
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitVarInsn(21, context.var("fastMatchToken"));
            str4 = str6;
            str3 = "nextToken";
            str2 = "(I)V";
            methodVisitor.visitMethodInsn(182, str4, str3, str2);
            label2 = label3;
        } else {
            str4 = str6;
            str3 = "nextToken";
            str2 = "(I)V";
            methodVisitor.visitInsn(87);
            methodVisitor.visitLdcInsn(12);
            label2 = label3;
            methodVisitor.visitVarInsn(54, context.var("fastMatchToken"));
            _quickNextToken(context, methodVisitor, 12);
        }
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitMethodInsn(182, str7, "getContext", "()" + ASMUtils.desc(ParseContext.class));
        methodVisitor.visitVarInsn(58, context.var("listContext"));
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
        methodVisitor.visitLdcInsn(fieldInfo.name);
        methodVisitor.visitMethodInsn(182, str7, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)" + ASMUtils.desc(ParseContext.class));
        methodVisitor.visitInsn(87);
        Label label8 = new Label();
        Label label9 = new Label();
        methodVisitor.visitInsn(3);
        methodVisitor.visitVarInsn(54, context.var("i"));
        methodVisitor.visitLabel(label8);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, str4, "token", "()I");
        methodVisitor.visitLdcInsn(15);
        methodVisitor.visitJumpInsn(159, label9);
        methodVisitor.visitVarInsn(25, 0);
        String str8 = context.className;
        methodVisitor.visitFieldInsn(180, str8, fieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class));
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(cls2)));
        methodVisitor.visitVarInsn(21, context.var("i"));
        methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        String type2 = ASMUtils.type(ObjectDeserializer.class);
        methodVisitor.visitMethodInsn(185, type2, "deserialze", "(L" + str7 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        methodVisitor.visitVarInsn(58, context.var(str));
        methodVisitor.visitIincInsn(context.var("i"), 1);
        methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
        methodVisitor.visitVarInsn(25, context.var(str));
        if (cls.isInterface()) {
            methodVisitor.visitMethodInsn(185, ASMUtils.type(cls), "add", "(Ljava/lang/Object;)Z");
        } else {
            methodVisitor.visitMethodInsn(182, ASMUtils.type(cls), "add", "(Ljava/lang/Object;)Z");
        }
        methodVisitor.visitInsn(87);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, context.var(fieldInfo.name + "_asm"));
        methodVisitor.visitMethodInsn(182, str7, "checkListResolve", "(Ljava/util/Collection;)V");
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, str4, "token", "()I");
        methodVisitor.visitLdcInsn(16);
        methodVisitor.visitJumpInsn(160, label8);
        if (isPrimitive2) {
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitVarInsn(21, context.var("fastMatchToken"));
            methodVisitor.visitMethodInsn(182, str4, str3, str2);
            i2 = 167;
            str5 = str7;
        } else {
            str5 = str7;
            _quickNextToken(context, methodVisitor, 12);
            i2 = 167;
        }
        methodVisitor.visitJumpInsn(i2, label8);
        methodVisitor.visitLabel(label9);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, context.var("listContext"));
        methodVisitor.visitMethodInsn(182, str5, "setContext", "(" + ASMUtils.desc(ParseContext.class) + ")V");
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, str4, "token", "()I");
        methodVisitor.visitLdcInsn(15);
        methodVisitor.visitJumpInsn(160, label);
        _quickNextTokenComma(context, methodVisitor);
        methodVisitor.visitLabel(label2);
    }

    private void _quickNextToken(Context context, MethodVisitor methodVisitor, int i) {
        Label label = new Label();
        Label label2 = new Label();
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        String str = JSONLexerBase;
        methodVisitor.visitMethodInsn(182, str, "getCurrent", "()C");
        if (i == 12) {
            methodVisitor.visitVarInsn(16, 123);
        } else if (i == 14) {
            methodVisitor.visitVarInsn(16, 91);
        } else {
            throw new IllegalStateException();
        }
        methodVisitor.visitJumpInsn(160, label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, str, "next", "()C");
        methodVisitor.visitInsn(87);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(Integer.valueOf(i));
        methodVisitor.visitMethodInsn(182, str, "setToken", "(I)V");
        methodVisitor.visitJumpInsn(167, label2);
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(Integer.valueOf(i));
        methodVisitor.visitMethodInsn(182, str, "nextToken", "(I)V");
        methodVisitor.visitLabel(label2);
    }

    private void _quickNextTokenComma(Context context, MethodVisitor methodVisitor) {
        Label label = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        Label label5 = new Label();
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        String str = JSONLexerBase;
        methodVisitor.visitMethodInsn(182, str, "getCurrent", "()C");
        methodVisitor.visitInsn(89);
        methodVisitor.visitVarInsn(54, context.var("ch"));
        methodVisitor.visitVarInsn(16, 44);
        methodVisitor.visitJumpInsn(160, label2);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, str, "next", "()C");
        methodVisitor.visitInsn(87);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(16);
        methodVisitor.visitMethodInsn(182, str, "setToken", "(I)V");
        methodVisitor.visitJumpInsn(167, label5);
        methodVisitor.visitLabel(label2);
        methodVisitor.visitVarInsn(21, context.var("ch"));
        methodVisitor.visitVarInsn(16, 125);
        methodVisitor.visitJumpInsn(160, label3);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, str, "next", "()C");
        methodVisitor.visitInsn(87);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(13);
        methodVisitor.visitMethodInsn(182, str, "setToken", "(I)V");
        methodVisitor.visitJumpInsn(167, label5);
        methodVisitor.visitLabel(label3);
        methodVisitor.visitVarInsn(21, context.var("ch"));
        methodVisitor.visitVarInsn(16, 93);
        methodVisitor.visitJumpInsn(160, label4);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, str, "next", "()C");
        methodVisitor.visitInsn(87);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(15);
        methodVisitor.visitMethodInsn(182, str, "setToken", "(I)V");
        methodVisitor.visitJumpInsn(167, label5);
        methodVisitor.visitLabel(label4);
        methodVisitor.visitVarInsn(21, context.var("ch"));
        methodVisitor.visitVarInsn(16, 26);
        methodVisitor.visitJumpInsn(160, label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(20);
        methodVisitor.visitMethodInsn(182, str, "setToken", "(I)V");
        methodVisitor.visitJumpInsn(167, label5);
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, str, "nextToken", "()V");
        methodVisitor.visitLabel(label5);
    }

    private void _getCollectionFieldItemDeser(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo, Class<?> cls) {
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 0);
        String str = context.className;
        methodVisitor.visitFieldInsn(180, str, fieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class));
        methodVisitor.visitJumpInsn(199, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        String str2 = DefaultJSONParser;
        methodVisitor.visitMethodInsn(182, str2, "getConfig", "()" + ASMUtils.desc(ParserConfig.class));
        methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(cls)));
        String type = ASMUtils.type(ParserConfig.class);
        methodVisitor.visitMethodInsn(182, type, "getDeserializer", "(Ljava/lang/reflect/Type;)" + ASMUtils.desc(ObjectDeserializer.class));
        String str3 = context.className;
        methodVisitor.visitFieldInsn(181, str3, fieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class));
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        String str4 = context.className;
        methodVisitor.visitFieldInsn(180, str4, fieldInfo.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class));
    }

    private void _newCollection(MethodVisitor methodVisitor, Class<?> cls, int i, boolean z) {
        if (cls.isAssignableFrom(ArrayList.class) && !z) {
            methodVisitor.visitTypeInsn(187, "java/util/ArrayList");
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, "java/util/ArrayList", "<init>", "()V");
        } else if (cls.isAssignableFrom(LinkedList.class) && !z) {
            methodVisitor.visitTypeInsn(187, ASMUtils.type(LinkedList.class));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, ASMUtils.type(LinkedList.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(HashSet.class)) {
            methodVisitor.visitTypeInsn(187, ASMUtils.type(HashSet.class));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, ASMUtils.type(HashSet.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(TreeSet.class)) {
            methodVisitor.visitTypeInsn(187, ASMUtils.type(TreeSet.class));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, ASMUtils.type(TreeSet.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(LinkedHashSet.class)) {
            methodVisitor.visitTypeInsn(187, ASMUtils.type(LinkedHashSet.class));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, ASMUtils.type(LinkedHashSet.class), "<init>", "()V");
        } else if (z) {
            methodVisitor.visitTypeInsn(187, ASMUtils.type(HashSet.class));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, ASMUtils.type(HashSet.class), "<init>", "()V");
        } else {
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitLdcInsn(Integer.valueOf(i));
            methodVisitor.visitMethodInsn(182, ASMUtils.type(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            methodVisitor.visitMethodInsn(184, ASMUtils.type(TypeUtils.class), "createCollection", "(Ljava/lang/reflect/Type;)Ljava/util/Collection;");
        }
        methodVisitor.visitTypeInsn(192, ASMUtils.type(cls));
    }

    private void _deserialze_obj(Context context, MethodVisitor methodVisitor, Label label, FieldInfo fieldInfo, Class<?> cls, int i) {
        Label label2 = new Label();
        Label label3 = new Label();
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitVarInsn(25, 0);
        String str = context.className;
        methodVisitor.visitFieldInsn(180, str, fieldInfo.name + "_asm_prefix__", "[C");
        methodVisitor.visitMethodInsn(182, JSONLexerBase, "matchField", "([C)Z");
        methodVisitor.visitJumpInsn(154, label2);
        methodVisitor.visitInsn(1);
        methodVisitor.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
        methodVisitor.visitJumpInsn(167, label3);
        methodVisitor.visitLabel(label2);
        _setFlag(methodVisitor, context, i);
        methodVisitor.visitVarInsn(21, context.var("matchedCount"));
        methodVisitor.visitInsn(4);
        methodVisitor.visitInsn(96);
        methodVisitor.visitVarInsn(54, context.var("matchedCount"));
        _deserObject(context, methodVisitor, fieldInfo, cls, i);
        methodVisitor.visitVarInsn(25, 1);
        String str2 = DefaultJSONParser;
        methodVisitor.visitMethodInsn(182, str2, "getResolveStatus", "()I");
        methodVisitor.visitLdcInsn(1);
        methodVisitor.visitJumpInsn(160, label3);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitMethodInsn(182, str2, "getLastResolveTask", "()" + ASMUtils.desc(DefaultJSONParser.ResolveTask.class));
        methodVisitor.visitVarInsn(58, context.var("resolveTask"));
        methodVisitor.visitVarInsn(25, context.var("resolveTask"));
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitMethodInsn(182, str2, "getContext", "()" + ASMUtils.desc(ParseContext.class));
        methodVisitor.visitFieldInsn(181, ASMUtils.type(DefaultJSONParser.ResolveTask.class), "ownerContext", ASMUtils.desc(ParseContext.class));
        methodVisitor.visitVarInsn(25, context.var("resolveTask"));
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitLdcInsn(fieldInfo.name);
        String type = ASMUtils.type(JavaBeanDeserializer.class);
        methodVisitor.visitMethodInsn(182, type, "getFieldDeserializer", "(Ljava/lang/String;)" + ASMUtils.desc(FieldDeserializer.class));
        methodVisitor.visitFieldInsn(181, ASMUtils.type(DefaultJSONParser.ResolveTask.class), "fieldDeserializer", ASMUtils.desc(FieldDeserializer.class));
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(0);
        methodVisitor.visitMethodInsn(182, str2, "setResolveStatus", "(I)V");
        methodVisitor.visitLabel(label3);
    }

    private void _deserObject(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo, Class<?> cls, int i) {
        _getFieldDeser(context, methodVisitor, fieldInfo);
        Label label = new Label();
        Label label2 = new Label();
        if ((fieldInfo.parserFeatures & Feature.SupportArrayToBean.mask) != 0) {
            methodVisitor.visitInsn(89);
            methodVisitor.visitTypeInsn(193, ASMUtils.type(JavaBeanDeserializer.class));
            methodVisitor.visitJumpInsn(153, label);
            methodVisitor.visitTypeInsn(192, ASMUtils.type(JavaBeanDeserializer.class));
            methodVisitor.visitVarInsn(25, 1);
            if (fieldInfo.fieldType instanceof Class) {
                methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
            } else {
                methodVisitor.visitVarInsn(25, 0);
                methodVisitor.visitLdcInsn(Integer.valueOf(i));
                methodVisitor.visitMethodInsn(182, ASMUtils.type(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            }
            methodVisitor.visitLdcInsn(fieldInfo.name);
            methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.parserFeatures));
            String type = ASMUtils.type(JavaBeanDeserializer.class);
            methodVisitor.visitMethodInsn(182, type, "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;");
            methodVisitor.visitTypeInsn(192, ASMUtils.type(cls));
            methodVisitor.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
            methodVisitor.visitJumpInsn(167, label2);
            methodVisitor.visitLabel(label);
        }
        methodVisitor.visitVarInsn(25, 1);
        if (fieldInfo.fieldType instanceof Class) {
            methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
        } else {
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitLdcInsn(Integer.valueOf(i));
            methodVisitor.visitMethodInsn(182, ASMUtils.type(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
        }
        methodVisitor.visitLdcInsn(fieldInfo.name);
        String type2 = ASMUtils.type(ObjectDeserializer.class);
        methodVisitor.visitMethodInsn(185, type2, "deserialze", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        methodVisitor.visitTypeInsn(192, ASMUtils.type(cls));
        methodVisitor.visitVarInsn(58, context.var(fieldInfo.name + "_asm"));
        methodVisitor.visitLabel(label2);
    }

    private void _getFieldDeser(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 0);
        String str = context.className;
        methodVisitor.visitFieldInsn(180, str, fieldInfo.name + "_asm_deser__", ASMUtils.desc(ObjectDeserializer.class));
        methodVisitor.visitJumpInsn(199, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        String str2 = DefaultJSONParser;
        methodVisitor.visitMethodInsn(182, str2, "getConfig", "()" + ASMUtils.desc(ParserConfig.class));
        methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
        String type = ASMUtils.type(ParserConfig.class);
        methodVisitor.visitMethodInsn(182, type, "getDeserializer", "(Ljava/lang/reflect/Type;)" + ASMUtils.desc(ObjectDeserializer.class));
        String str3 = context.className;
        methodVisitor.visitFieldInsn(181, str3, fieldInfo.name + "_asm_deser__", ASMUtils.desc(ObjectDeserializer.class));
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        String str4 = context.className;
        methodVisitor.visitFieldInsn(180, str4, fieldInfo.name + "_asm_deser__", ASMUtils.desc(ObjectDeserializer.class));
    }

    static class Context {
        static final int fieldName = 3;
        static final int parser = 1;
        static final int type = 2;
        private final JavaBeanInfo beanInfo;
        private final String className;
        private final Class<?> clazz;
        private FieldInfo[] fieldInfoList;
        private int variantIndex = -1;
        private final Map<String, Integer> variants = new HashMap();

        public Context(String str, ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, int i) {
            this.className = str;
            this.clazz = javaBeanInfo.clazz;
            this.variantIndex = i;
            this.beanInfo = javaBeanInfo;
            this.fieldInfoList = javaBeanInfo.fields;
        }

        public Class<?> getInstClass() {
            Class<?> cls = this.beanInfo.builderClass;
            return cls == null ? this.clazz : cls;
        }

        public int var(String str, int i) {
            if (this.variants.get(str) == null) {
                this.variants.put(str, Integer.valueOf(this.variantIndex));
                this.variantIndex += i;
            }
            return this.variants.get(str).intValue();
        }

        public int var(String str) {
            if (this.variants.get(str) == null) {
                Map<String, Integer> map = this.variants;
                int i = this.variantIndex;
                this.variantIndex = i + 1;
                map.put(str, Integer.valueOf(i));
            }
            return this.variants.get(str).intValue();
        }
    }

    private void _init(ClassWriter classWriter, Context context) {
        int length = context.fieldInfoList.length;
        for (int i = 0; i < length; i++) {
            FieldInfo fieldInfo = context.fieldInfoList[i];
            new FieldWriter(classWriter, 1, fieldInfo.name + "_asm_prefix__", "[C").visitEnd();
        }
        int length2 = context.fieldInfoList.length;
        for (int i2 = 0; i2 < length2; i2++) {
            FieldInfo fieldInfo2 = context.fieldInfoList[i2];
            Class<?> cls = fieldInfo2.fieldClass;
            if (!cls.isPrimitive()) {
                if (Collection.class.isAssignableFrom(cls)) {
                    new FieldWriter(classWriter, 1, fieldInfo2.name + "_asm_list_item_deser__", ASMUtils.desc(ObjectDeserializer.class)).visitEnd();
                } else {
                    new FieldWriter(classWriter, 1, fieldInfo2.name + "_asm_deser__", ASMUtils.desc(ObjectDeserializer.class)).visitEnd();
                }
            }
        }
        MethodWriter methodWriter = new MethodWriter(classWriter, 1, "<init>", "(" + ASMUtils.desc(ParserConfig.class) + ASMUtils.desc(JavaBeanInfo.class) + ")V", null, null);
        methodWriter.visitVarInsn(25, 0);
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitVarInsn(25, 2);
        String type = ASMUtils.type(JavaBeanDeserializer.class);
        methodWriter.visitMethodInsn(183, type, "<init>", "(" + ASMUtils.desc(ParserConfig.class) + ASMUtils.desc(JavaBeanInfo.class) + ")V");
        int length3 = context.fieldInfoList.length;
        for (int i3 = 0; i3 < length3; i3++) {
            FieldInfo fieldInfo3 = context.fieldInfoList[i3];
            methodWriter.visitVarInsn(25, 0);
            methodWriter.visitLdcInsn("\"" + fieldInfo3.name + "\":");
            methodWriter.visitMethodInsn(182, "java/lang/String", "toCharArray", "()[C");
            String str = context.className;
            methodWriter.visitFieldInsn(181, str, fieldInfo3.name + "_asm_prefix__", "[C");
        }
        methodWriter.visitInsn(177);
        methodWriter.visitMaxs(4, 4);
        methodWriter.visitEnd();
    }

    private void _createInstance(ClassWriter classWriter, Context context) {
        if (Modifier.isPublic(context.beanInfo.defaultConstructor.getModifiers())) {
            MethodWriter methodWriter = new MethodWriter(classWriter, 1, "createInstance", "(L" + DefaultJSONParser + ";Ljava/lang/reflect/Type;)Ljava/lang/Object;", null, null);
            methodWriter.visitTypeInsn(187, ASMUtils.type(context.getInstClass()));
            methodWriter.visitInsn(89);
            methodWriter.visitMethodInsn(183, ASMUtils.type(context.getInstClass()), "<init>", "()V");
            methodWriter.visitInsn(176);
            methodWriter.visitMaxs(3, 3);
            methodWriter.visitEnd();
        }
    }
}
