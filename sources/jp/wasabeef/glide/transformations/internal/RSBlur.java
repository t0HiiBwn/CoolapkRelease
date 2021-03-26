package jp.wasabeef.glide.transformations.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

public class RSBlur {
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007b  */
    public static Bitmap blur(Context context, Bitmap bitmap, int i) throws RSRuntimeException {
        Throwable th;
        ScriptIntrinsicBlur scriptIntrinsicBlur;
        Allocation allocation;
        Allocation allocation2;
        RenderScript renderScript = null;
        ScriptIntrinsicBlur scriptIntrinsicBlur2 = null;
        try {
            RenderScript create = RenderScript.create(context);
            try {
                create.setMessageHandler(new RenderScript.RSMessageHandler());
                allocation2 = Allocation.createFromBitmap(create, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
            } catch (Throwable th2) {
                th = th2;
                allocation2 = null;
                allocation = null;
                renderScript = create;
                scriptIntrinsicBlur = allocation;
                if (renderScript != null) {
                }
                if (allocation2 != null) {
                }
                if (allocation != null) {
                }
                if (scriptIntrinsicBlur != null) {
                }
                throw th;
            }
            try {
                allocation = Allocation.createTyped(create, allocation2.getType());
            } catch (Throwable th3) {
                th = th3;
                allocation = null;
                renderScript = create;
                scriptIntrinsicBlur = allocation;
                if (renderScript != null) {
                }
                if (allocation2 != null) {
                }
                if (allocation != null) {
                }
                if (scriptIntrinsicBlur != null) {
                }
                throw th;
            }
            try {
                scriptIntrinsicBlur2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                scriptIntrinsicBlur2.setInput(allocation2);
                scriptIntrinsicBlur2.setRadius((float) i);
                scriptIntrinsicBlur2.forEach(allocation);
                allocation.copyTo(bitmap);
                if (create != null) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        RenderScript.releaseAllContexts();
                    } else {
                        create.destroy();
                    }
                }
                if (allocation2 != null) {
                    allocation2.destroy();
                }
                if (allocation != null) {
                    allocation.destroy();
                }
                if (scriptIntrinsicBlur2 != null) {
                    scriptIntrinsicBlur2.destroy();
                }
                return bitmap;
            } catch (Throwable th4) {
                th = th4;
                renderScript = create;
                scriptIntrinsicBlur = scriptIntrinsicBlur2;
                if (renderScript != null) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        RenderScript.releaseAllContexts();
                    } else {
                        renderScript.destroy();
                    }
                }
                if (allocation2 != null) {
                    allocation2.destroy();
                }
                if (allocation != null) {
                    allocation.destroy();
                }
                if (scriptIntrinsicBlur != null) {
                    scriptIntrinsicBlur.destroy();
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            scriptIntrinsicBlur = null;
            allocation2 = null;
            allocation = null;
            if (renderScript != null) {
            }
            if (allocation2 != null) {
            }
            if (allocation != null) {
            }
            if (scriptIntrinsicBlur != null) {
            }
            throw th;
        }
    }
}
