package org.apache.commons.io;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

public class Charsets {
    @Deprecated
    public static final Charset ISO_8859_1 = StandardCharsets.ISO_8859_1;
    @Deprecated
    public static final Charset US_ASCII = StandardCharsets.US_ASCII;
    @Deprecated
    public static final Charset UTF_16 = StandardCharsets.UTF_16;
    @Deprecated
    public static final Charset UTF_16BE = StandardCharsets.UTF_16BE;
    @Deprecated
    public static final Charset UTF_16LE = StandardCharsets.UTF_16LE;
    @Deprecated
    public static final Charset UTF_8 = StandardCharsets.UTF_8;

    public static SortedMap<String, Charset> requiredCharsets() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        treeMap.put(StandardCharsets.ISO_8859_1.name(), StandardCharsets.ISO_8859_1);
        treeMap.put(StandardCharsets.US_ASCII.name(), StandardCharsets.US_ASCII);
        treeMap.put(StandardCharsets.UTF_16.name(), StandardCharsets.UTF_16);
        treeMap.put(StandardCharsets.UTF_16BE.name(), StandardCharsets.UTF_16BE);
        treeMap.put(StandardCharsets.UTF_16LE.name(), StandardCharsets.UTF_16LE);
        treeMap.put(StandardCharsets.UTF_8.name(), StandardCharsets.UTF_8);
        return Collections.unmodifiableSortedMap(treeMap);
    }

    public static Charset toCharset(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }

    public static Charset toCharset(String str) {
        return str == null ? Charset.defaultCharset() : Charset.forName(str);
    }
}
