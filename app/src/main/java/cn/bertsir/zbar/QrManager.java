package cn.bertsir.zbar;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import cn.bertsir.zbar.Qr.ScanResult;
import cn.bertsir.zbar.QrConfig;
import cn.bertsir.zbar.utils.PermissionUtils;
import java.util.List;

public class QrManager {
    private static QrManager instance;
    private QrConfig options;
    public OnScanResultCallback resultCallback;

    public interface OnScanResultCallback {
        void onScanSuccess(ScanResult scanResult);
    }

    public static synchronized QrManager getInstance() {
        QrManager qrManager;
        synchronized (QrManager.class) {
            if (instance == null) {
                instance = new QrManager();
            }
            qrManager = instance;
        }
        return qrManager;
    }

    public OnScanResultCallback getResultCallback() {
        return this.resultCallback;
    }

    public QrManager init(QrConfig qrConfig) {
        this.options = qrConfig;
        return this;
    }

    public void startScan(final Activity activity, OnScanResultCallback onScanResultCallback) {
        if (this.options == null) {
            this.options = new QrConfig.Builder().create();
        }
        PermissionUtils.permission(activity, "android.permission-group.CAMERA", "android.permission-group.STORAGE").rationale(new PermissionUtils.OnRationaleListener() {
            /* class cn.bertsir.zbar.QrManager.AnonymousClass2 */

            @Override // cn.bertsir.zbar.utils.PermissionUtils.OnRationaleListener
            public void rationale(PermissionUtils.OnRationaleListener.ShouldRequest shouldRequest) {
                shouldRequest.again(true);
            }
        }).callback(new PermissionUtils.FullCallback() {
            /* class cn.bertsir.zbar.QrManager.AnonymousClass1 */

            @Override // cn.bertsir.zbar.utils.PermissionUtils.FullCallback
            public void onGranted(List<String> list) {
                Intent intent = new Intent(activity, QRActivity.class);
                intent.putExtra("extra_this_config", QrManager.this.options);
                activity.startActivity(intent);
            }

            @Override // cn.bertsir.zbar.utils.PermissionUtils.FullCallback
            public void onDenied(List<String> list, List<String> list2) {
                Toast.makeText(activity, "摄像头权限被拒绝！", 0).show();
            }
        }).request();
        this.resultCallback = onScanResultCallback;
    }
}
