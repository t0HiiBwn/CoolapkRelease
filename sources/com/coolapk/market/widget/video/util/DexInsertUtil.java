package com.coolapk.market.widget.video.util;

import android.content.Context;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/widget/video/util/DexInsertUtil;", "", "()V", "installHotFix", "", "context", "Landroid/content/Context;", "pluginApkPath", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DexInsertUtil.kt */
public final class DexInsertUtil {
    public static final DexInsertUtil INSTANCE = new DexInsertUtil();

    private DexInsertUtil() {
    }

    public final void installHotFix(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "pluginApkPath");
        try {
            Field declaredField = Class.forName("dalvik.system.BaseDexClassLoader").getDeclaredField("pathList");
            Intrinsics.checkNotNullExpressionValue(declaredField, "pathListField");
            declaredField.setAccessible(true);
            Field declaredField2 = Class.forName("dalvik.system.DexPathList").getDeclaredField("dexElements");
            Intrinsics.checkNotNullExpressionValue(declaredField2, "dexElementsField");
            declaredField2.setAccessible(true);
            ClassLoader classLoader = context.getClassLoader();
            if (classLoader != null) {
                Object obj = declaredField.get((PathClassLoader) classLoader);
                Object obj2 = declaredField2.get(obj);
                if (obj2 != null) {
                    Object[] objArr = (Object[]) obj2;
                    File cacheDir = context.getCacheDir();
                    Intrinsics.checkNotNullExpressionValue(cacheDir, "context.cacheDir");
                    Object obj3 = declaredField2.get(declaredField.get(new DexClassLoader(str, cacheDir.getAbsolutePath(), null, context.getClassLoader())));
                    if (obj3 != null) {
                        Object[] objArr2 = (Object[]) obj3;
                        Object newInstance = Array.newInstance(objArr2.getClass().getComponentType(), objArr.length + objArr2.length);
                        if (newInstance != null) {
                            Object[] objArr3 = (Object[]) newInstance;
                            System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
                            System.arraycopy(objArr2, 0, objArr3, objArr.length, objArr2.length);
                            declaredField2.set(obj, objArr3);
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
            }
            throw new NullPointerException("null cannot be cast to non-null type dalvik.system.PathClassLoader");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
