package com.github.salomonbrys.kotson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 0}, d1 = {"\u0000¦\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020K*\u00020\u00032\u0006\u0010L\u001a\u00020\u001c\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010O\u001a\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070K*\u00020\u00032\u0006\u0010L\u001a\u00020\u001c\u001a.\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001*\u00020\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010O\u001a\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0K*\u00020\u00032\u0006\u0010L\u001a\u00020\u001c\u001a.\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001*\u00020\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010O\u001a\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0K*\u00020\u00032\u0006\u0010L\u001a\u00020\u001c\u001a.\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010O\u001a\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100K*\u00020\u00032\u0006\u0010L\u001a\u00020\u001c\u001a.\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001*\u00020\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010O\u001a\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130K*\u00020\u00032\u0006\u0010L\u001a\u00020\u001c\u001a.\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001*\u00020\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010O\u001a\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160K*\u00020\u00032\u0006\u0010L\u001a\u00020\u001c\u001a.\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0001*\u00020\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010O\u001a\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190K*\u00020\u00032\u0006\u0010L\u001a\u00020\u001c\u001a.\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0001*\u00020\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010O\u001a\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0K*\u00020\u00032\u0006\u0010L\u001a\u00020\u001c\u001a.\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0001*\u00020\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010O\u001a\u0018\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0K*\u00020\u00032\u0006\u0010L\u001a\u00020\u001c\u001a.\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0001*\u00020\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010O\u001a0\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\"*\u00020\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010O\u001a0\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\"*\u00020\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010O\u001a0\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\"*\u00020\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010O\u001a0\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\"*\u00020\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010O\u001a0\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\"*\u00020\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010O\u001a0\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\"*\u00020\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010O\u001a0\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\"*\u00020\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010O\u001a0\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\"*\u00020\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010O\u001a0\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\"*\u00020\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010O\u001a0\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\"*\u00020\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010O\u001a0\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001080\"*\u00020\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010O\u001a0\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010;0\"*\u00020\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010O\u001a0\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010>0\"*\u00020\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010O\u001a0\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A0\"*\u00020\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010O\u001a\u0018\u0010C\u001a\b\u0012\u0004\u0012\u0002080K*\u00020\u00032\u0006\u0010L\u001a\u00020\u001c\u001a.\u0010C\u001a\b\u0012\u0004\u0012\u0002080\u0001*\u00020\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010O\u001a\u0018\u0010E\u001a\b\u0012\u0004\u0012\u00020;0K*\u00020\u00032\u0006\u0010L\u001a\u00020\u001c\u001a.\u0010E\u001a\b\u0012\u0004\u0012\u00020;0\u0001*\u00020\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010O\u001a\u0018\u0010G\u001a\b\u0012\u0004\u0012\u00020>0K*\u00020\u00032\u0006\u0010L\u001a\u00020\u001c\u001a.\u0010G\u001a\b\u0012\u0004\u0012\u00020>0\u0001*\u00020\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010O\u001a\u0018\u0010I\u001a\b\u0012\u0004\u0012\u00020A0K*\u00020\u00032\u0006\u0010L\u001a\u00020\u001c\u001a.\u0010I\u001a\b\u0012\u0004\u0012\u00020A0\u0001*\u00020\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010O\u001a#\u0010P\u001a\u00020\u0003*\u00020;2\b\u0010Q\u001a\u0004\u0018\u00010R2\n\u0010S\u001a\u0006\u0012\u0002\b\u00030TH\u0002\u001a+\u0010U\u001a\u00020V*\u00020;2\b\u0010Q\u001a\u0004\u0018\u00010R2\n\u0010S\u001a\u0006\u0012\u0002\b\u00030T2\u0006\u0010W\u001a\u00020\u0003H\u0002\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005\"\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005\"\u001b\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0005\"\u001b\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005\"\u001b\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0005\"\u001b\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005\"\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0005\"\u001b\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0005\"\u001b\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b \u0010\u0005\"\u001d\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\"*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b#\u0010$\"\u001d\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\"*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b&\u0010$\"\u001d\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\"*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b(\u0010$\"\u001d\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\"*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b*\u0010$\"\u001d\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\"*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b,\u0010$\"\u001d\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\"*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b.\u0010$\"\u001d\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\"*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b0\u0010$\"\u001d\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\"*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b2\u0010$\"\u001d\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\"*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b4\u0010$\"\u001d\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\"*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b6\u0010$\"\u001d\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001080\"*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b9\u0010$\"\u001d\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010;0\"*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b<\u0010$\"\u001d\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010>0\"*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b?\u0010$\"\u001d\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A0\"*\u00020\u00038F¢\u0006\u0006\u001a\u0004\bB\u0010$\"\u001b\u0010C\u001a\b\u0012\u0004\u0012\u0002080\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\bD\u0010\u0005\"\u001b\u0010E\u001a\b\u0012\u0004\u0012\u00020;0\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\bF\u0010\u0005\"\u001b\u0010G\u001a\b\u0012\u0004\u0012\u00020>0\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\bH\u0010\u0005\"\u001b\u0010I\u001a\b\u0012\u0004\u0012\u00020A0\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\bJ\u0010\u0005¨\u0006X"}, d2 = {"byArray", "Lcom/github/salomonbrys/kotson/JsonObjectDelegate;", "Lcom/google/gson/JsonArray;", "Lcom/google/gson/JsonElement;", "getByArray", "(Lcom/google/gson/JsonElement;)Lcom/github/salomonbrys/kotson/JsonObjectDelegate;", "byBigDecimal", "Ljava/math/BigDecimal;", "getByBigDecimal", "byBigInteger", "Ljava/math/BigInteger;", "getByBigInteger", "byBool", "", "getByBool", "byByte", "", "getByByte", "byChar", "", "getByChar", "byDouble", "", "getByDouble", "byFloat", "", "getByFloat", "byInt", "", "getByInt", "byLong", "", "getByLong", "byNullableArray", "Lcom/github/salomonbrys/kotson/NullableJsonObjectDelegate;", "getByNullableArray", "(Lcom/google/gson/JsonElement;)Lcom/github/salomonbrys/kotson/NullableJsonObjectDelegate;", "byNullableBigDecimal", "getByNullableBigDecimal", "byNullableBigInteger", "getByNullableBigInteger", "byNullableBool", "getByNullableBool", "byNullableByte", "getByNullableByte", "byNullableChar", "getByNullableChar", "byNullableDouble", "getByNullableDouble", "byNullableFloat", "getByNullableFloat", "byNullableInt", "getByNullableInt", "byNullableLong", "getByNullableLong", "byNullableNumber", "", "getByNullableNumber", "byNullableObject", "Lcom/google/gson/JsonObject;", "getByNullableObject", "byNullableShort", "", "getByNullableShort", "byNullableString", "", "getByNullableString", "byNumber", "getByNumber", "byObject", "getByObject", "byShort", "getByShort", "byString", "getByString", "Lcom/github/salomonbrys/kotson/JsonArrayDelegate;", "index", "key", "default", "Lkotlin/Function0;", "getValue", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "setValue", "", "value", "kotson_main"}, k = 2, mv = {1, 1, 1})
/* compiled from: Properties.kt */
public final class PropertiesKt {
    public static final JsonElement getValue(JsonObject jsonObject, Object obj, KProperty<?> kProperty) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(kProperty, "property");
        JsonElement jsonElement = ElementKt.getObj(jsonObject).get(kProperty.getName());
        Intrinsics.checkExpressionValueIsNotNull(jsonElement, "obj[property.name]");
        return jsonElement;
    }

    public static final void setValue(JsonObject jsonObject, Object obj, KProperty<?> kProperty, JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "$receiver");
        Intrinsics.checkParameterIsNotNull(kProperty, "property");
        Intrinsics.checkParameterIsNotNull(jsonElement, "value");
        MutableKt.set(ElementKt.getObj(jsonObject), kProperty.getName(), jsonElement);
    }

    public static final JsonObjectDelegate<String> getByString(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byString$1.INSTANCE, PropertiesKt$byString$2.INSTANCE, null, null, 24, null);
    }

    public static final JsonObjectDelegate<Boolean> getByBool(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byBool$1.INSTANCE, PropertiesKt$byBool$2.INSTANCE, null, null, 24, null);
    }

    public static final JsonObjectDelegate<Byte> getByByte(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byByte$1.INSTANCE, PropertiesKt$byByte$2.INSTANCE, null, null, 24, null);
    }

    public static final JsonObjectDelegate<Character> getByChar(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byChar$1.INSTANCE, PropertiesKt$byChar$2.INSTANCE, null, null, 24, null);
    }

    public static final JsonObjectDelegate<Short> getByShort(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byShort$1.INSTANCE, PropertiesKt$byShort$2.INSTANCE, null, null, 24, null);
    }

    public static final JsonObjectDelegate<Integer> getByInt(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byInt$1.INSTANCE, PropertiesKt$byInt$2.INSTANCE, null, null, 24, null);
    }

    public static final JsonObjectDelegate<Long> getByLong(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byLong$1.INSTANCE, PropertiesKt$byLong$2.INSTANCE, null, null, 24, null);
    }

    public static final JsonObjectDelegate<Float> getByFloat(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byFloat$1.INSTANCE, PropertiesKt$byFloat$2.INSTANCE, null, null, 24, null);
    }

    public static final JsonObjectDelegate<Double> getByDouble(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byDouble$1.INSTANCE, PropertiesKt$byDouble$2.INSTANCE, null, null, 24, null);
    }

    public static final JsonObjectDelegate<Number> getByNumber(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNumber$1.INSTANCE, PropertiesKt$byNumber$2.INSTANCE, null, null, 24, null);
    }

    public static final JsonObjectDelegate<BigInteger> getByBigInteger(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byBigInteger$1.INSTANCE, PropertiesKt$byBigInteger$2.INSTANCE, null, null, 24, null);
    }

    public static final JsonObjectDelegate<BigDecimal> getByBigDecimal(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byBigDecimal$1.INSTANCE, PropertiesKt$byBigDecimal$2.INSTANCE, null, null, 24, null);
    }

    public static final JsonObjectDelegate<JsonArray> getByArray(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byArray$1.INSTANCE, PropertiesKt$byArray$2.INSTANCE, null, null, 24, null);
    }

    public static final JsonObjectDelegate<JsonObject> getByObject(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byObject$1.INSTANCE, PropertiesKt$byObject$2.INSTANCE, null, null, 24, null);
    }

    public static final JsonObjectDelegate<String> byString(JsonElement jsonElement, String str, Function0<String> function0) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byString$3.INSTANCE, PropertiesKt$byString$4.INSTANCE, str, function0);
    }

    public static /* bridge */ /* synthetic */ JsonObjectDelegate byString$default(JsonElement jsonElement, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            return byString(jsonElement, str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: byString");
    }

    public static final JsonObjectDelegate<Boolean> byBool(JsonElement jsonElement, String str, Function0<Boolean> function0) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byBool$3.INSTANCE, PropertiesKt$byBool$4.INSTANCE, str, function0);
    }

    public static /* bridge */ /* synthetic */ JsonObjectDelegate byBool$default(JsonElement jsonElement, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            return byBool(jsonElement, str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: byBool");
    }

    public static final JsonObjectDelegate<Byte> byByte(JsonElement jsonElement, String str, Function0<Byte> function0) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byByte$3.INSTANCE, PropertiesKt$byByte$4.INSTANCE, str, function0);
    }

    public static /* bridge */ /* synthetic */ JsonObjectDelegate byByte$default(JsonElement jsonElement, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            return byByte(jsonElement, str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: byByte");
    }

    public static final JsonObjectDelegate<Character> byChar(JsonElement jsonElement, String str, Function0<Character> function0) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byChar$3.INSTANCE, PropertiesKt$byChar$4.INSTANCE, str, function0);
    }

    public static /* bridge */ /* synthetic */ JsonObjectDelegate byChar$default(JsonElement jsonElement, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            return byChar(jsonElement, str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: byChar");
    }

    public static final JsonObjectDelegate<Short> byShort(JsonElement jsonElement, String str, Function0<Short> function0) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byShort$3.INSTANCE, PropertiesKt$byShort$4.INSTANCE, str, function0);
    }

    public static /* bridge */ /* synthetic */ JsonObjectDelegate byShort$default(JsonElement jsonElement, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            return byShort(jsonElement, str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: byShort");
    }

    public static final JsonObjectDelegate<Integer> byInt(JsonElement jsonElement, String str, Function0<Integer> function0) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byInt$3.INSTANCE, PropertiesKt$byInt$4.INSTANCE, str, function0);
    }

    public static /* bridge */ /* synthetic */ JsonObjectDelegate byInt$default(JsonElement jsonElement, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            return byInt(jsonElement, str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: byInt");
    }

    public static final JsonObjectDelegate<Long> byLong(JsonElement jsonElement, String str, Function0<Long> function0) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byLong$3.INSTANCE, PropertiesKt$byLong$4.INSTANCE, str, function0);
    }

    public static /* bridge */ /* synthetic */ JsonObjectDelegate byLong$default(JsonElement jsonElement, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            return byLong(jsonElement, str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: byLong");
    }

    public static final JsonObjectDelegate<Float> byFloat(JsonElement jsonElement, String str, Function0<Float> function0) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byFloat$3.INSTANCE, PropertiesKt$byFloat$4.INSTANCE, str, function0);
    }

    public static /* bridge */ /* synthetic */ JsonObjectDelegate byFloat$default(JsonElement jsonElement, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            return byFloat(jsonElement, str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: byFloat");
    }

    public static final JsonObjectDelegate<Double> byDouble(JsonElement jsonElement, String str, Function0<Double> function0) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byDouble$3.INSTANCE, PropertiesKt$byDouble$4.INSTANCE, str, function0);
    }

    public static /* bridge */ /* synthetic */ JsonObjectDelegate byDouble$default(JsonElement jsonElement, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            return byDouble(jsonElement, str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: byDouble");
    }

    public static final JsonObjectDelegate<Number> byNumber(JsonElement jsonElement, String str, Function0<? extends Number> function0) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNumber$3.INSTANCE, PropertiesKt$byNumber$4.INSTANCE, str, function0);
    }

    public static /* bridge */ /* synthetic */ JsonObjectDelegate byNumber$default(JsonElement jsonElement, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            return byNumber(jsonElement, str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: byNumber");
    }

    public static final JsonObjectDelegate<BigInteger> byBigInteger(JsonElement jsonElement, String str, Function0<? extends BigInteger> function0) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byBigInteger$3.INSTANCE, PropertiesKt$byBigInteger$4.INSTANCE, str, function0);
    }

    public static /* bridge */ /* synthetic */ JsonObjectDelegate byBigInteger$default(JsonElement jsonElement, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            return byBigInteger(jsonElement, str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: byBigInteger");
    }

    public static final JsonObjectDelegate<BigDecimal> byBigDecimal(JsonElement jsonElement, String str, Function0<? extends BigDecimal> function0) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byBigDecimal$3.INSTANCE, PropertiesKt$byBigDecimal$4.INSTANCE, str, function0);
    }

    public static /* bridge */ /* synthetic */ JsonObjectDelegate byBigDecimal$default(JsonElement jsonElement, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            return byBigDecimal(jsonElement, str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: byBigDecimal");
    }

    public static final JsonObjectDelegate<JsonArray> byArray(JsonElement jsonElement, String str, Function0<JsonArray> function0) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byArray$3.INSTANCE, PropertiesKt$byArray$4.INSTANCE, str, function0);
    }

    public static /* bridge */ /* synthetic */ JsonObjectDelegate byArray$default(JsonElement jsonElement, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            return byArray(jsonElement, str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: byArray");
    }

    public static final JsonObjectDelegate<JsonObject> byObject(JsonElement jsonElement, String str, Function0<JsonObject> function0) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byObject$3.INSTANCE, PropertiesKt$byObject$4.INSTANCE, str, function0);
    }

    public static /* bridge */ /* synthetic */ JsonObjectDelegate byObject$default(JsonElement jsonElement, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            return byObject(jsonElement, str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: byObject");
    }

    public static final NullableJsonObjectDelegate<String> getByNullableString(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new NullableJsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNullableString$1.INSTANCE, PropertiesKt$byNullableString$2.INSTANCE, null, null, 24, null);
    }

    public static final NullableJsonObjectDelegate<Boolean> getByNullableBool(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new NullableJsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNullableBool$1.INSTANCE, PropertiesKt$byNullableBool$2.INSTANCE, null, null, 24, null);
    }

    public static final NullableJsonObjectDelegate<Byte> getByNullableByte(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new NullableJsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNullableByte$1.INSTANCE, PropertiesKt$byNullableByte$2.INSTANCE, null, null, 24, null);
    }

    public static final NullableJsonObjectDelegate<Character> getByNullableChar(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new NullableJsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNullableChar$1.INSTANCE, PropertiesKt$byNullableChar$2.INSTANCE, null, null, 24, null);
    }

    public static final NullableJsonObjectDelegate<Short> getByNullableShort(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new NullableJsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNullableShort$1.INSTANCE, PropertiesKt$byNullableShort$2.INSTANCE, null, null, 24, null);
    }

    public static final NullableJsonObjectDelegate<Integer> getByNullableInt(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new NullableJsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNullableInt$1.INSTANCE, PropertiesKt$byNullableInt$2.INSTANCE, null, null, 24, null);
    }

    public static final NullableJsonObjectDelegate<Long> getByNullableLong(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new NullableJsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNullableLong$1.INSTANCE, PropertiesKt$byNullableLong$2.INSTANCE, null, null, 24, null);
    }

    public static final NullableJsonObjectDelegate<Float> getByNullableFloat(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new NullableJsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNullableFloat$1.INSTANCE, PropertiesKt$byNullableFloat$2.INSTANCE, null, null, 24, null);
    }

    public static final NullableJsonObjectDelegate<Double> getByNullableDouble(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new NullableJsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNullableDouble$1.INSTANCE, PropertiesKt$byNullableDouble$2.INSTANCE, null, null, 24, null);
    }

    public static final NullableJsonObjectDelegate<Number> getByNullableNumber(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new NullableJsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNullableNumber$1.INSTANCE, PropertiesKt$byNullableNumber$2.INSTANCE, null, null, 24, null);
    }

    public static final NullableJsonObjectDelegate<BigInteger> getByNullableBigInteger(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new NullableJsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNullableBigInteger$1.INSTANCE, PropertiesKt$byNullableBigInteger$2.INSTANCE, null, null, 24, null);
    }

    public static final NullableJsonObjectDelegate<BigDecimal> getByNullableBigDecimal(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new NullableJsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNullableBigDecimal$1.INSTANCE, PropertiesKt$byNullableBigDecimal$2.INSTANCE, null, null, 24, null);
    }

    public static final NullableJsonObjectDelegate<JsonArray> getByNullableArray(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new NullableJsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNullableArray$1.INSTANCE, PropertiesKt$byNullableArray$2.INSTANCE, null, null, 24, null);
    }

    public static final NullableJsonObjectDelegate<JsonObject> getByNullableObject(JsonElement jsonElement) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new NullableJsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNullableObject$1.INSTANCE, PropertiesKt$byNullableObject$2.INSTANCE, null, null, 24, null);
    }

    public static final NullableJsonObjectDelegate<String> byNullableString(JsonElement jsonElement, String str, Function0<String> function0) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new NullableJsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNullableString$3.INSTANCE, PropertiesKt$byNullableString$4.INSTANCE, str, function0);
    }

    public static /* bridge */ /* synthetic */ NullableJsonObjectDelegate byNullableString$default(JsonElement jsonElement, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            return byNullableString(jsonElement, str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: byNullableString");
    }

    public static final NullableJsonObjectDelegate<Boolean> byNullableBool(JsonElement jsonElement, String str, Function0<Boolean> function0) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new NullableJsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNullableBool$3.INSTANCE, PropertiesKt$byNullableBool$4.INSTANCE, str, function0);
    }

    public static /* bridge */ /* synthetic */ NullableJsonObjectDelegate byNullableBool$default(JsonElement jsonElement, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            return byNullableBool(jsonElement, str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: byNullableBool");
    }

    public static final NullableJsonObjectDelegate<Byte> byNullableByte(JsonElement jsonElement, String str, Function0<Byte> function0) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new NullableJsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNullableByte$3.INSTANCE, PropertiesKt$byNullableByte$4.INSTANCE, str, function0);
    }

    public static /* bridge */ /* synthetic */ NullableJsonObjectDelegate byNullableByte$default(JsonElement jsonElement, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            return byNullableByte(jsonElement, str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: byNullableByte");
    }

    public static final NullableJsonObjectDelegate<Character> byNullableChar(JsonElement jsonElement, String str, Function0<Character> function0) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new NullableJsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNullableChar$3.INSTANCE, PropertiesKt$byNullableChar$4.INSTANCE, str, function0);
    }

    public static /* bridge */ /* synthetic */ NullableJsonObjectDelegate byNullableChar$default(JsonElement jsonElement, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            return byNullableChar(jsonElement, str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: byNullableChar");
    }

    public static final NullableJsonObjectDelegate<Short> byNullableShort(JsonElement jsonElement, String str, Function0<Short> function0) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new NullableJsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNullableShort$3.INSTANCE, PropertiesKt$byNullableShort$4.INSTANCE, str, function0);
    }

    public static /* bridge */ /* synthetic */ NullableJsonObjectDelegate byNullableShort$default(JsonElement jsonElement, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            return byNullableShort(jsonElement, str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: byNullableShort");
    }

    public static final NullableJsonObjectDelegate<Integer> byNullableInt(JsonElement jsonElement, String str, Function0<Integer> function0) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new NullableJsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNullableInt$3.INSTANCE, PropertiesKt$byNullableInt$4.INSTANCE, str, function0);
    }

    public static /* bridge */ /* synthetic */ NullableJsonObjectDelegate byNullableInt$default(JsonElement jsonElement, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            return byNullableInt(jsonElement, str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: byNullableInt");
    }

    public static final NullableJsonObjectDelegate<Long> byNullableLong(JsonElement jsonElement, String str, Function0<Long> function0) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new NullableJsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNullableLong$3.INSTANCE, PropertiesKt$byNullableLong$4.INSTANCE, str, function0);
    }

    public static /* bridge */ /* synthetic */ NullableJsonObjectDelegate byNullableLong$default(JsonElement jsonElement, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            return byNullableLong(jsonElement, str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: byNullableLong");
    }

    public static final NullableJsonObjectDelegate<Float> byNullableFloat(JsonElement jsonElement, String str, Function0<Float> function0) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new NullableJsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNullableFloat$3.INSTANCE, PropertiesKt$byNullableFloat$4.INSTANCE, str, function0);
    }

    public static /* bridge */ /* synthetic */ NullableJsonObjectDelegate byNullableFloat$default(JsonElement jsonElement, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            return byNullableFloat(jsonElement, str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: byNullableFloat");
    }

    public static final NullableJsonObjectDelegate<Double> byNullableDouble(JsonElement jsonElement, String str, Function0<Double> function0) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new NullableJsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNullableDouble$3.INSTANCE, PropertiesKt$byNullableDouble$4.INSTANCE, str, function0);
    }

    public static /* bridge */ /* synthetic */ NullableJsonObjectDelegate byNullableDouble$default(JsonElement jsonElement, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            return byNullableDouble(jsonElement, str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: byNullableDouble");
    }

    public static final NullableJsonObjectDelegate<Number> byNullableNumber(JsonElement jsonElement, String str, Function0<? extends Number> function0) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new NullableJsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNullableNumber$3.INSTANCE, PropertiesKt$byNullableNumber$4.INSTANCE, str, function0);
    }

    public static /* bridge */ /* synthetic */ NullableJsonObjectDelegate byNullableNumber$default(JsonElement jsonElement, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            return byNullableNumber(jsonElement, str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: byNullableNumber");
    }

    public static final NullableJsonObjectDelegate<BigInteger> byNullableBigInteger(JsonElement jsonElement, String str, Function0<? extends BigInteger> function0) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new NullableJsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNullableBigInteger$3.INSTANCE, PropertiesKt$byNullableBigInteger$4.INSTANCE, str, function0);
    }

    public static /* bridge */ /* synthetic */ NullableJsonObjectDelegate byNullableBigInteger$default(JsonElement jsonElement, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            return byNullableBigInteger(jsonElement, str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: byNullableBigInteger");
    }

    public static final NullableJsonObjectDelegate<BigDecimal> byNullableBigDecimal(JsonElement jsonElement, String str, Function0<? extends BigDecimal> function0) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new NullableJsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNullableBigDecimal$3.INSTANCE, PropertiesKt$byNullableBigDecimal$4.INSTANCE, str, function0);
    }

    public static /* bridge */ /* synthetic */ NullableJsonObjectDelegate byNullableBigDecimal$default(JsonElement jsonElement, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            return byNullableBigDecimal(jsonElement, str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: byNullableBigDecimal");
    }

    public static final NullableJsonObjectDelegate<JsonArray> byNullableArray(JsonElement jsonElement, String str, Function0<JsonArray> function0) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new NullableJsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNullableArray$3.INSTANCE, PropertiesKt$byNullableArray$4.INSTANCE, str, function0);
    }

    public static /* bridge */ /* synthetic */ NullableJsonObjectDelegate byNullableArray$default(JsonElement jsonElement, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            return byNullableArray(jsonElement, str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: byNullableArray");
    }

    public static final NullableJsonObjectDelegate<JsonObject> byNullableObject(JsonElement jsonElement, String str, Function0<JsonObject> function0) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new NullableJsonObjectDelegate<>(ElementKt.getObj(jsonElement), PropertiesKt$byNullableObject$3.INSTANCE, PropertiesKt$byNullableObject$4.INSTANCE, str, function0);
    }

    public static /* bridge */ /* synthetic */ NullableJsonObjectDelegate byNullableObject$default(JsonElement jsonElement, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            return byNullableObject(jsonElement, str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: byNullableObject");
    }

    public static final JsonArrayDelegate<String> byString(JsonElement jsonElement, int i) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonArrayDelegate<>(ElementKt.getArray(jsonElement), i, PropertiesKt$byString$5.INSTANCE, PropertiesKt$byString$6.INSTANCE);
    }

    public static final JsonArrayDelegate<Boolean> byBool(JsonElement jsonElement, int i) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonArrayDelegate<>(ElementKt.getArray(jsonElement), i, PropertiesKt$byBool$5.INSTANCE, PropertiesKt$byBool$6.INSTANCE);
    }

    public static final JsonArrayDelegate<Byte> byByte(JsonElement jsonElement, int i) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonArrayDelegate<>(ElementKt.getArray(jsonElement), i, PropertiesKt$byByte$5.INSTANCE, PropertiesKt$byByte$6.INSTANCE);
    }

    public static final JsonArrayDelegate<Character> byChar(JsonElement jsonElement, int i) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonArrayDelegate<>(ElementKt.getArray(jsonElement), i, PropertiesKt$byChar$5.INSTANCE, PropertiesKt$byChar$6.INSTANCE);
    }

    public static final JsonArrayDelegate<Short> byShort(JsonElement jsonElement, int i) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonArrayDelegate<>(ElementKt.getArray(jsonElement), i, PropertiesKt$byShort$5.INSTANCE, PropertiesKt$byShort$6.INSTANCE);
    }

    public static final JsonArrayDelegate<Integer> byInt(JsonElement jsonElement, int i) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonArrayDelegate<>(ElementKt.getArray(jsonElement), i, PropertiesKt$byInt$5.INSTANCE, PropertiesKt$byInt$6.INSTANCE);
    }

    public static final JsonArrayDelegate<Long> byLong(JsonElement jsonElement, int i) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonArrayDelegate<>(ElementKt.getArray(jsonElement), i, PropertiesKt$byLong$5.INSTANCE, PropertiesKt$byLong$6.INSTANCE);
    }

    public static final JsonArrayDelegate<Float> byFloat(JsonElement jsonElement, int i) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonArrayDelegate<>(ElementKt.getArray(jsonElement), i, PropertiesKt$byFloat$5.INSTANCE, PropertiesKt$byFloat$6.INSTANCE);
    }

    public static final JsonArrayDelegate<Double> byDouble(JsonElement jsonElement, int i) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonArrayDelegate<>(ElementKt.getArray(jsonElement), i, PropertiesKt$byDouble$5.INSTANCE, PropertiesKt$byDouble$6.INSTANCE);
    }

    public static final JsonArrayDelegate<Number> byNumber(JsonElement jsonElement, int i) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonArrayDelegate<>(ElementKt.getArray(jsonElement), i, PropertiesKt$byNumber$5.INSTANCE, PropertiesKt$byNumber$6.INSTANCE);
    }

    public static final JsonArrayDelegate<BigInteger> byBigInteger(JsonElement jsonElement, int i) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonArrayDelegate<>(ElementKt.getArray(jsonElement), i, PropertiesKt$byBigInteger$5.INSTANCE, PropertiesKt$byBigInteger$6.INSTANCE);
    }

    public static final JsonArrayDelegate<BigDecimal> byBigDecimal(JsonElement jsonElement, int i) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonArrayDelegate<>(ElementKt.getArray(jsonElement), i, PropertiesKt$byBigDecimal$5.INSTANCE, PropertiesKt$byBigDecimal$6.INSTANCE);
    }

    public static final JsonArrayDelegate<JsonArray> byArray(JsonElement jsonElement, int i) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonArrayDelegate<>(ElementKt.getArray(jsonElement), i, PropertiesKt$byArray$5.INSTANCE, PropertiesKt$byArray$6.INSTANCE);
    }

    public static final JsonArrayDelegate<JsonObject> byObject(JsonElement jsonElement, int i) {
        Intrinsics.checkParameterIsNotNull(jsonElement, "$receiver");
        return new JsonArrayDelegate<>(ElementKt.getArray(jsonElement), i, PropertiesKt$byObject$5.INSTANCE, PropertiesKt$byObject$6.INSTANCE);
    }
}
