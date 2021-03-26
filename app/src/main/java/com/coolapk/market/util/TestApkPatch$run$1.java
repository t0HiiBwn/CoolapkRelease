package com.coolapk.market.util;

import java.io.File;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: TestApkPatch.kt */
final class TestApkPatch$run$1 implements Runnable {
    public static final TestApkPatch$run$1 INSTANCE = new TestApkPatch$run$1();

    TestApkPatch$run$1() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        LogUtils.w("开始合并", new Object[0]);
        PatchUtils.patch("/data/app/com.netease.wxzc-5rGzhljPadMjOxvuBbBATQ==/base.apk", "/storage/emulated/0/Android/data/com.coolapk.market/files/Download/com.netease.wxzc-0.100.147-100147-253343.apk", "/storage/emulated/0/Android/data/com.coolapk.market/files/Download/com.netease.wxzc-0.100.147-100147-253343.papk");
        LogUtils.w("是否生成? " + new File("/storage/emulated/0/Android/data/com.coolapk.market/files/Download/com.netease.wxzc-0.100.147-100147-253343.apk").exists(), new Object[0]);
    }
}
