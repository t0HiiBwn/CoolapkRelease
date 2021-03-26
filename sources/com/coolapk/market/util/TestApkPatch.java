package com.coolapk.market.util;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/util/TestApkPatch;", "", "()V", "run", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TestApkPatch.kt */
public final class TestApkPatch {
    public static final TestApkPatch INSTANCE = new TestApkPatch();

    private TestApkPatch() {
    }

    @JvmStatic
    public static final void run() {
        new Thread(TestApkPatch$run$1.INSTANCE).start();
    }
}
