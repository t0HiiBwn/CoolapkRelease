package com.coolapk.market.widget;

import android.text.method.ReplacementTransformationMethod;

public class WordBreakTransformationMethod extends ReplacementTransformationMethod {
    private static char[] dash;
    private static WordBreakTransformationMethod instance;
    private static char[] original;
    private static char[] replacement;
    private static char[] space;

    private WordBreakTransformationMethod() {
    }

    public static WordBreakTransformationMethod getInstance() {
        if (instance == null) {
            instance = new WordBreakTransformationMethod();
        }
        return instance;
    }

    static {
        char[] cArr = {'-', 8209};
        dash = cArr;
        char[] cArr2 = {' ', 160};
        space = cArr2;
        original = new char[]{cArr[0], cArr2[0]};
        replacement = new char[]{cArr[1], cArr2[1]};
    }

    @Override // android.text.method.ReplacementTransformationMethod
    protected char[] getOriginal() {
        return original;
    }

    @Override // android.text.method.ReplacementTransformationMethod
    protected char[] getReplacement() {
        return replacement;
    }
}
