package com.coolapk.market.receiver;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationManagerCompat;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.model.Extra;
import com.coolapk.market.processor.FileProcessorFactory;
import com.coolapk.market.service.DownloadNotificationHelper;
import com.coolapk.market.util.CoolFileUtils;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.widget.Toast;
import java.io.File;

public class NotificationActionReceiver extends BroadcastReceiver {
    public static final String ACTION_CHECK_UPDATE_ON_START_APP_UPGRADE_CLICK = "com.coolapk.market.action.ACTION_CHECK_UPDATE_ON_START_APP_UPGRADE_CLICK";
    public static final String ACTION_CHECK_UPDATE_ON_UPGRADE_ALL_APP_CLICK = "com.coolapk.market.action.ACTION_CHECK_UPDATE_ON_UPGRADE_ALL_APP_CLICK";
    public static final String ACTION_DOWNLOAD_ON_CONTINUE_CLICK = "com.coolapk.market.action.ACTION_DOWNLOAD_ON_CONTINUE_CLICK";
    public static final String ACTION_DOWNLOAD_ON_DELETE_CLICK = "com.coolapk.market.action.ACTION_DOWNLOAD_ON_DELETE_CLICK";
    public static final String ACTION_DOWNLOAD_ON_PAUSE_CLICK = "com.coolapk.market.action.ACTION_DOWNLOAD_ON_pause_CLICK";
    public static final String ACTION_DOWNLOAD_SUCCESS_ON_INSTALL_ALL_CLICK = "com.coolapk.market.action.ACTION_DOWNLOAD_SUCCESS_ON_INSTALL_ALL_CLICK";
    public static final String ACTION_DOWNLOAD_SUCCESS_ON_OPEN_CLICK = "com.coolapk.market.action.ACTION_DOWNLOAD_SUCCESS_ON_OPEN_CLICK";
    public static final String ACTION_DOWNLOAD_SUCCESS_ON_START_DOWNLOAD_MANAGER_CLICK = "com.coolapk.market.action.ACTION_DOWNLOAD_SUCCESS_ON_START_DOWNLOAD_MANAGER_CLICK";
    public static final String ACTION_INSTALL_SUCCESS_ON_CANCEL_CLICK = "com.coolapk.market.action.ACTION_INSTALL_SUCCESS_ON_CANCEL_CLICK";
    public static final String ACTION_INSTALL_SUCCESS_ON_DISMISS = "com.coolapk.market.action.ACTION_INSTALL_SUCCESS_ON_DISMISS";
    public static final String ACTION_INSTALL_SUCCESS_ON_START_APP_CLICK = "com.coolapk.market.action.ACTION_INSTALL_SUCCESS_ON_START_APP_CLICK";
    public static final String ACTION_INSTALL_SUCCESS_ON_START_DOWNLOAD_MANAGER_CLICK = "com.coolapk.market.action.ACTION_INSTALL_SUCCESS_ON_START_DOWNLOAD_MANAGER_CLICK";
    public static final String KEY_PACKAGE_NAME = "packageName";
    public static final String KEY_URL = "URL";
    public static final String PACKAGE_TAG = "com.coolapk.market.action";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction() != null) {
            LogUtils.v("Receive action: %s", intent.getAction());
            String action = intent.getAction();
            char c = 65535;
            switch (action.hashCode()) {
                case -797567324:
                    if (action.equals("com.coolapk.market.action.ACTION_DOWNLOAD_SUCCESS_ON_START_DOWNLOAD_MANAGER_CLICK")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -675518488:
                    if (action.equals("com.coolapk.market.action.ACTION_INSTALL_SUCCESS_ON_START_APP_CLICK")) {
                        c = 2;
                        break;
                    }
                    break;
                case -358806683:
                    if (action.equals("com.coolapk.market.action.ACTION_INSTALL_SUCCESS_ON_DISMISS")) {
                        c = 0;
                        break;
                    }
                    break;
                case -316328837:
                    if (action.equals("com.coolapk.market.action.ACTION_DOWNLOAD_SUCCESS_ON_OPEN_CLICK")) {
                        c = 4;
                        break;
                    }
                    break;
                case -27466309:
                    if (action.equals("com.coolapk.market.action.ACTION_DOWNLOAD_ON_pause_CLICK")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 699725:
                    if (action.equals("com.coolapk.market.action.ACTION_CHECK_UPDATE_ON_UPGRADE_ALL_APP_CLICK")) {
                        c = 5;
                        break;
                    }
                    break;
                case 225595678:
                    if (action.equals("com.coolapk.market.action.ACTION_DOWNLOAD_SUCCESS_ON_INSTALL_ALL_CLICK")) {
                        c = 11;
                        break;
                    }
                    break;
                case 681561550:
                    if (action.equals("com.coolapk.market.action.ACTION_CHECK_UPDATE_ON_START_APP_UPGRADE_CLICK")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1075787380:
                    if (action.equals("com.coolapk.market.action.ACTION_DOWNLOAD_ON_CONTINUE_CLICK")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 1424507201:
                    if (action.equals("com.coolapk.market.action.ACTION_INSTALL_SUCCESS_ON_START_DOWNLOAD_MANAGER_CLICK")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1469651320:
                    if (action.equals("com.coolapk.market.action.ACTION_DOWNLOAD_ON_DELETE_CLICK")) {
                        c = 7;
                        break;
                    }
                    break;
                case 1756768072:
                    if (action.equals("com.coolapk.market.action.ACTION_INSTALL_SUCCESS_ON_CANCEL_CLICK")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    DataManager.getInstance().clearCompleteInstallState();
                    return;
                case 1:
                    ActionManager.startDownloadManagerActivity(context);
                    closeSystemDialog(context);
                    return;
                case 2:
                    String stringExtra = intent.getStringExtra("packageName");
                    if (context.getPackageManager().getLaunchIntentForPackage(stringExtra) != null) {
                        ActionManager.openApp(context, stringExtra);
                        return;
                    }
                    return;
                case 3:
                    DataManager.getInstance().clearCompleteInstallState();
                    NotificationManagerCompat.from(context).cancel(2);
                    return;
                case 4:
                    DownloadState downloadStateWithUrl = DataManager.getInstance().getDownloadStateWithUrl(intent.getStringExtra("URL"));
                    if (downloadStateWithUrl != null && downloadStateWithUrl.isSuccess()) {
                        String filePath = downloadStateWithUrl.getFilePath();
                        if (!TextUtils.isEmpty(filePath)) {
                            if (FileProcessorFactory.canHandleWith(CoolFileUtils.getFileExtension(filePath))) {
                                Extra extra = downloadStateWithUrl.getExtra();
                                if (extra != null) {
                                    ActionManager.installImmediately(context, filePath, downloadStateWithUrl.getUrl(), extra, true);
                                }
                            } else {
                                try {
                                    Uri fromFile = Uri.fromFile(new File(filePath));
                                    String mimeType = downloadStateWithUrl.getMimeType();
                                    if (TextUtils.isEmpty(mimeType)) {
                                        mimeType = "*/*";
                                    }
                                    ActionManager.startView(context, fromFile, mimeType);
                                } catch (ActivityNotFoundException unused) {
                                    Toast.show(context, 2131887189);
                                }
                            }
                            DownloadNotificationHelper.getInstance().cancelResult(context, downloadStateWithUrl.getKey());
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    ActionManager.startAutoUpgradeTask(context);
                    NotificationManagerCompat.from(context).cancel(3);
                    return;
                case 6:
                    ActionManager.startUpgradeManagerActivity(context);
                    closeSystemDialog(context);
                    return;
                case 7:
                    ActionManager.stopDownload(context, intent.getStringExtra("URL"), 2);
                    return;
                case '\b':
                    String stringExtra2 = intent.getStringExtra("URL");
                    DownloadState downloadStateWithUrl2 = DataManager.getInstance().getDownloadStateWithUrl(stringExtra2);
                    if (downloadStateWithUrl2 != null) {
                        ActionManager.startDownload(context, stringExtra2, downloadStateWithUrl2.getExtra(), 0);
                        return;
                    }
                    return;
                case '\t':
                    ActionManager.stopDownload(context, intent.getStringExtra("URL"));
                    return;
                default:
                    return;
            }
        }
    }

    private void closeSystemDialog(Context context) {
        context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
    }

    public void register(Context context) {
        context.registerReceiver(this, new IntentFilter("com.coolapk.market.action.ACTION_INSTALL_SUCCESS_ON_CANCEL_CLICK"));
        context.registerReceiver(this, new IntentFilter("com.coolapk.market.action.ACTION_INSTALL_SUCCESS_ON_START_APP_CLICK"));
        context.registerReceiver(this, new IntentFilter("com.coolapk.market.action.ACTION_DOWNLOAD_SUCCESS_ON_OPEN_CLICK"));
        context.registerReceiver(this, new IntentFilter("com.coolapk.market.action.ACTION_CHECK_UPDATE_ON_START_APP_UPGRADE_CLICK"));
        context.registerReceiver(this, new IntentFilter("com.coolapk.market.action.ACTION_CHECK_UPDATE_ON_UPGRADE_ALL_APP_CLICK"));
        context.registerReceiver(this, new IntentFilter("com.coolapk.market.action.ACTION_DOWNLOAD_ON_CONTINUE_CLICK"));
        context.registerReceiver(this, new IntentFilter("com.coolapk.market.action.ACTION_DOWNLOAD_ON_pause_CLICK"));
        context.registerReceiver(this, new IntentFilter("com.coolapk.market.action.ACTION_DOWNLOAD_ON_DELETE_CLICK"));
        context.registerReceiver(this, new IntentFilter("com.coolapk.market.action.ACTION_INSTALL_SUCCESS_ON_DISMISS"));
        context.registerReceiver(this, new IntentFilter("com.coolapk.market.action.ACTION_INSTALL_SUCCESS_ON_START_DOWNLOAD_MANAGER_CLICK"));
        context.registerReceiver(this, new IntentFilter("com.coolapk.market.action.ACTION_DOWNLOAD_SUCCESS_ON_START_DOWNLOAD_MANAGER_CLICK"));
        context.registerReceiver(this, new IntentFilter("com.coolapk.market.action.ACTION_DOWNLOAD_SUCCESS_ON_INSTALL_ALL_CLICK"));
    }

    public void unregister(Context context) {
        context.unregisterReceiver(this);
    }
}
