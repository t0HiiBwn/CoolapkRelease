package com.coolapk.market.util;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Gift;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.view.app.FetchGiftDialog;
import com.coolapk.market.view.base.SimpleDialog;
import com.coolapk.market.widget.Toast;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class JavascriptInterfaceUtils {
    private Context context;
    private Gift mGift;
    private ServiceApp serviceApp;

    public JavascriptInterfaceUtils(Context context2, Gift gift, ServiceApp serviceApp2) {
        this.context = context2;
        this.mGift = gift;
        this.serviceApp = serviceApp2;
    }

    public JavascriptInterfaceUtils(Context context2) {
        this.context = context2;
    }

    @JavascriptInterface
    public void saveImageByNativeMethod(String str) {
        File fileFromWeb = getFileFromWeb(str);
        File createBitmapSavePath = BitmapUtil.createBitmapSavePath();
        try {
            FileUtils.copyFile(fileFromWeb, createBitmapSavePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        CoolFileUtils.notifyNewMediaFile(this.context, createBitmapSavePath);
        fileFromWeb.delete();
        Toast.show(this.context, "保存成功");
    }

    private File getFileFromWeb(String str) {
        byte[] decode = Base64.decode(str.replace("data:image/jpeg;base64,", ""), 0);
        String generateFileOutputPath = BitmapUtil.generateFileOutputPath(this.context, String.valueOf(System.currentTimeMillis()));
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
        File file = new File(generateFileOutputPath);
        BitmapUtil.saveBitmapToFile(file, decodeByteArray, true);
        return file;
    }

    @JavascriptInterface
    public void shareImage(String str) {
        ActionManager.startShareImageListActivity(this.context, getFileFromWeb(str).getAbsolutePath());
    }

    @JavascriptInterface
    public void getGift(String str) {
        Gift gift = this.mGift;
        if (gift == null) {
            Toast.show(this.context, "礼包信息不完整");
        } else if (!gift.isRequireInstalled() || PackageUtils.isInstalled(this.context, this.mGift.getApkName())) {
            FetchGiftDialog.newInstance(this.mGift, this.serviceApp).show(ContextExtendsKt.requireAppCompatActivity(this.context).getSupportFragmentManager(), (String) null);
        } else {
            SimpleDialog newInstance = SimpleDialog.newInstance();
            newInstance.setMessage(this.context.getString(2131886884));
            newInstance.setPositiveButton(2131886813, new DialogInterface.OnClickListener() {
                /* class com.coolapk.market.util.JavascriptInterfaceUtils.AnonymousClass1 */

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    ActionManager.startAppViewActivity(JavascriptInterfaceUtils.this.context, JavascriptInterfaceUtils.this.mGift.getApkName(), true);
                }
            });
            newInstance.setNegativeButton(2131886115);
            newInstance.show(ContextExtendsKt.requireAppCompatActivity(this.context).getSupportFragmentManager(), (String) null);
        }
    }
}
