package com.ypz.bangscreentools;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class BangScreenTools {
    protected static final String TAG = "BangScreenTools";
    private static BangScreenTools bangScreenTools;
    private BangScreenSupport bangScreenSupport = null;
    private boolean isBangScree;
    private boolean isHaveResult;
    private int statusBarHeight = -1;
    private final int systemCode = Build.VERSION.SDK_INT;

    public static BangScreenTools getBangScreenTools() {
        if (bangScreenTools == null) {
            synchronized (BangScreenTools.class) {
                bangScreenTools = new BangScreenTools();
            }
        }
        return bangScreenTools;
    }

    private BangScreenTools() {
    }

    public boolean hasBangScreen(Window window) {
        if (this.isHaveResult) {
            return this.isBangScree;
        }
        if (this.bangScreenSupport == null) {
            checkScreenSupportInit();
        }
        BangScreenSupport bangScreenSupport2 = this.bangScreenSupport;
        if (bangScreenSupport2 == null) {
            this.isHaveResult = true;
            this.isBangScree = false;
            return false;
        }
        boolean hasNotBangScreen = bangScreenSupport2.hasNotBangScreen(window);
        this.isBangScree = hasNotBangScreen;
        return hasNotBangScreen;
    }

    private List<Rect> getDisplayCutoutSize(Window window) {
        if (this.bangScreenSupport == null) {
            checkScreenSupportInit();
        }
        BangScreenSupport bangScreenSupport2 = this.bangScreenSupport;
        if (bangScreenSupport2 == null) {
            return new ArrayList();
        }
        return bangScreenSupport2.getBangSize(window);
    }

    public void extendStatusCutout(Window window, Context context) {
        ActionBar actionBar;
        if (this.bangScreenSupport == null) {
            checkScreenSupportInit();
        }
        if (window != null && this.bangScreenSupport != null) {
            if (context instanceof AppCompatActivity) {
                androidx.appcompat.app.ActionBar supportActionBar = ((AppCompatActivity) context).getSupportActionBar();
                Log.i("BangScreenTools", "isAppCompatActivity");
                if (supportActionBar != null) {
                    supportActionBar.hide();
                }
            } else if ((context instanceof Activity) && (actionBar = ((Activity) context).getActionBar()) != null) {
                actionBar.hide();
            }
            window.setFlags(1024, 1024);
            window.getDecorView().setSystemUiVisibility(1792);
            this.bangScreenSupport.extendStatusCutout(window, context);
        }
    }

    public void windowChangeExtendStatusCutout(Window window) {
        if (this.bangScreenSupport == null) {
            checkScreenSupportInit();
        }
        if (window != null) {
            window.getDecorView().setSystemUiVisibility(5888);
        }
    }

    public void transparentStatusCutout(Window window, Context context) {
        ActionBar actionBar;
        if (this.bangScreenSupport == null) {
            checkScreenSupportInit();
        }
        if (window != null && this.bangScreenSupport != null) {
            if (context instanceof AppCompatActivity) {
                androidx.appcompat.app.ActionBar supportActionBar = ((AppCompatActivity) context).getSupportActionBar();
                Log.i("BangScreenTools", "isAppCompatActivity");
                if (supportActionBar != null) {
                    supportActionBar.hide();
                }
            } else if ((context instanceof Activity) && (actionBar = ((Activity) context).getActionBar()) != null) {
                actionBar.hide();
            }
            window.getDecorView().setSystemUiVisibility(1280);
            window.setStatusBarColor(0);
            this.bangScreenSupport.transparentStatusCutout(window, context);
        }
    }

    public void windowChangeTransparentStatusCutout(Window window) {
        if (this.bangScreenSupport == null) {
            checkScreenSupportInit();
        }
        if (window != null) {
            window.getDecorView().setSystemUiVisibility(1280);
        }
    }

    public void fullscreen(Window window, Context context) {
        ActionBar actionBar;
        if (this.bangScreenSupport == null) {
            checkScreenSupportInit();
        }
        if (window != null && this.bangScreenSupport != null) {
            if (context instanceof AppCompatActivity) {
                androidx.appcompat.app.ActionBar supportActionBar = ((AppCompatActivity) context).getSupportActionBar();
                Log.i("BangScreenTools", "isAppCompatActivity");
                if (supportActionBar != null) {
                    supportActionBar.hide();
                }
            } else if ((context instanceof Activity) && (actionBar = ((Activity) context).getActionBar()) != null) {
                actionBar.hide();
            }
            window.getDecorView().setSystemUiVisibility(1798);
            this.bangScreenSupport.fullscreen(window, context);
        }
    }

    public void windowChangeFullscreen(Window window) {
        if (window != null) {
            window.getDecorView().setSystemUiVisibility(5894);
        }
    }

    public void blockDisplayCutout(Window window) {
        if (this.bangScreenSupport == null) {
            checkScreenSupportInit();
        }
        BangScreenSupport bangScreenSupport2 = this.bangScreenSupport;
        if (bangScreenSupport2 != null) {
            bangScreenSupport2.setWindowLayoutBlockNotch(window);
        }
    }

    private void checkScreenSupportInit() {
        if (this.bangScreenSupport == null) {
            int i = this.systemCode;
            if (i < 26) {
                this.bangScreenSupport = new BangScreenSupport() {
                    /* class com.ypz.bangscreentools.BangScreenTools.AnonymousClass1 */

                    @Override // com.ypz.bangscreentools.BangScreenSupport
                    public void extendStatusCutout(Window window, Context context) {
                    }

                    @Override // com.ypz.bangscreentools.BangScreenSupport
                    public void fullscreen(Window window, Context context) {
                    }

                    @Override // com.ypz.bangscreentools.BangScreenSupport
                    public boolean hasNotBangScreen(Window window) {
                        return false;
                    }

                    @Override // com.ypz.bangscreentools.BangScreenSupport
                    public void setWindowLayoutBlockNotch(Window window) {
                    }

                    @Override // com.ypz.bangscreentools.BangScreenSupport
                    public void transparentStatusCutout(Window window, Context context) {
                    }

                    @Override // com.ypz.bangscreentools.BangScreenSupport
                    public List<Rect> getBangSize(Window window) {
                        return new ArrayList();
                    }
                };
            } else if (i < 28) {
                PhoneManufacturersJudgeTools pMJTools = PhoneManufacturersJudgeTools.getPMJTools();
                if (pMJTools.isHuaWei()) {
                    Log.i("BangScreenTools", "HuaWei");
                    this.bangScreenSupport = new HuaWeiBangScreen();
                } else if (pMJTools.isMiui()) {
                    Log.i("BangScreenTools", "Miui");
                    this.bangScreenSupport = new MiuiBangScreen();
                } else if (pMJTools.isVivo()) {
                    Log.i("BangScreenTools", "Vivo");
                    this.bangScreenSupport = new VivoBangScreen();
                } else if (pMJTools.isOppo()) {
                    Log.i("BangScreenTools", "Oppo");
                    this.bangScreenSupport = new OppoBangScreen();
                }
            } else {
                Log.i("BangScreenTools", "PB");
                this.bangScreenSupport = new PBangScreen();
            }
        }
    }

    protected final int getStatusBarHeight(Context context) {
        int i = this.statusBarHeight;
        if (i != -1) {
            return i;
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            this.statusBarHeight = context.getResources().getDimensionPixelSize(identifier);
        }
        return this.statusBarHeight;
    }
}
