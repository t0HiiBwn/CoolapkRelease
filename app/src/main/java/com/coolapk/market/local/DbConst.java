package com.coolapk.market.local;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;
import android.text.TextUtils;
import com.coolapk.market.model.Article;
import com.coolapk.market.model.DownloadInfo;
import com.coolapk.market.model.IgnoreInfo;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.UpgradeInfo;
import java.util.HashMap;
import java.util.Map;

public final class DbConst {
    private static Map<String, Integer> columnIndexMapping = new HashMap();

    public interface Columns extends BaseColumns {
        public static final String COL_CREATED = "created";
        public static final String COL_MODIFIED = "modified";
        public static final String SORT_ORDER_DEFAULT = "created ASC";
    }

    public static class LogTable implements Columns {
        public static final String COL_ERROR = "error";
        public static final String COL_MESSAGE = "message";
        public static final String COL_TAG = "tag";
        public static final String SORT_ORDER_DEFAULT = "created DESC";
        public static final String TABLE_NAME = "log";
        public static final String TAG_API = "api";
        public static final String TAG_DOWNLOAD = "download";
        public static final String TAG_INSTALL = "install";
        public static final String TAG_NETWORK_STATE = "network_state";
    }

    public static class QrCodeHistoryTable implements Columns {
        public static final String COL_APK_NAME = "apkName";
        public static final String COL_EXTRA = "extraInfo";
        public static final String COL_LOGO = "logo";
        public static final String COL_RESULT = "result";
        public static final String COL_SHORT_TITLE = "shortTitle";
        public static final String COL_TYPE = "type";
        public static final String TABLE_NAME = "qrCodeHistory";
        public static final int TYPE_APK = 1;
        public static final int TYPE_OTHER = 0;
    }

    public static class SearchHistoryTable implements Columns {
        public static final String COL_KEYWORD = "keyword";
        public static final String COL_TYPE = "type";
        public static final String SORT_ORDER_DEFAULT = "modified DESC";
        public static final String TABLE_NAME = "searchHistory";
    }

    public static int getColumnIndex(Cursor cursor, String str, String str2) {
        Map<String, Integer> map = columnIndexMapping;
        Integer num = map.get(str + str2);
        if (num == null) {
            num = Integer.valueOf(cursor.getColumnIndexOrThrow(str2));
            Map<String, Integer> map2 = columnIndexMapping;
            map2.put(str + str2, num);
        }
        return num.intValue();
    }

    public static final class AppTable implements Columns {
        public static final String COL_APK_LENGTH = "apkLength";
        public static final String COL_APK_MD5 = "apkMd5";
        public static final String COL_APK_PATH = "apkPath";
        public static final String COL_APP_NAME = "appName";
        public static final String COL_FIRST_INSTALL_TIME = "firstInstallTime";
        public static final String COL_IGNORE_TYPE = "ignoredType";
        public static final String COL_IGNORE_VERSION_CODE = "ignoreVersionCode";
        public static final String COL_IS_EXIST = "isExist";
        public static final String COL_IS_SYSTEM_APP = "isSystem";
        public static final String COL_LAST_UPDATE_TIME = "lastUpdateTime";
        public static final String COL_PACKAGE_NAME = "packageName";
        public static final String COL_UPGRADE_APK_ID = "upgradeApkId";
        public static final String COL_UPGRADE_APK_SIZE = "upgradeApkSize";
        public static final String COL_UPGRADE_CHANGE_LOG = "upgradeChangeLog";
        public static final String COL_UPGRADE_DISPLAY_VERSION_NAME = "upgradeDisplayVersionName";
        public static final String COL_UPGRADE_EXTRA_ANALYSIS_DATA = "extraAnalysisData";
        public static final String COL_UPGRADE_EXTRA_FLAG = "extraFlag";
        public static final String COL_UPGRADE_LAST_UPDATE = "upgradeLastUpdate";
        public static final String COL_UPGRADE_LOGO = "upgradeLogo";
        public static final String COL_UPGRADE_PATCH_KEY = "upgradePatchKey";
        public static final String COL_UPGRADE_PATCH_LENGTH = "upgradePatchLength";
        public static final String COL_UPGRADE_PATCH_MD5 = "upgradePatchMd5";
        public static final String COL_UPGRADE_PATCH_SIZE = "upgradePatchSize";
        public static final String COL_UPGRADE_VERSION_CODE = "upgradeVersionCode";
        public static final String COL_UPGRADE_VERSION_NAME = "upgradeVersionName";
        public static final String COL_VERSION_CODE = "versionCode";
        public static final String COL_VERSION_NAME = "versionName";
        public static final String TABLE_NAME = "app";

        public static ContentValues toContentValues(MobileApp mobileApp) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("packageName", mobileApp.getPackageName());
            contentValues.put("appName", mobileApp.getAppName());
            contentValues.put("versionName", mobileApp.getVersionName());
            contentValues.put("versionCode", Integer.valueOf(mobileApp.getVersionCode()));
            contentValues.put("apkLength", Long.valueOf(mobileApp.getApkLength()));
            contentValues.put("isSystem", Boolean.valueOf(mobileApp.isSystemApp()));
            contentValues.put("isExist", Boolean.valueOf(mobileApp.isExist()));
            contentValues.put("apkPath", mobileApp.getApkPath());
            contentValues.put("firstInstallTime", Long.valueOf(mobileApp.getFirstInstallTime()));
            contentValues.put("lastUpdateTime", Long.valueOf(mobileApp.getLastUpdateTime()));
            contentValues.put("apkMd5", mobileApp.getApkMd5());
            return contentValues;
        }

        public static void inflateIgnoreContentValues(ContentValues contentValues, IgnoreInfo ignoreInfo) {
            if (ignoreInfo == null) {
                contentValues.put("ignoredType", (Integer) 0);
                contentValues.put("ignoreVersionCode", (Integer) 0);
                return;
            }
            contentValues.put("ignoredType", Integer.valueOf(ignoreInfo.getType()));
            contentValues.put("ignoreVersionCode", Integer.valueOf(ignoreInfo.getVersionCode()));
        }

        public static void inflateUpgradeContentValues(ContentValues contentValues, UpgradeInfo upgradeInfo) {
            if (upgradeInfo == null) {
                contentValues.put("upgradeApkId", "");
                contentValues.put("upgradeDisplayVersionName", "");
                contentValues.put("upgradeVersionName", "");
                contentValues.put("upgradeVersionCode", (Integer) 0);
                contentValues.put("upgradeApkSize", "");
                contentValues.put("upgradeLastUpdate", (Integer) 0);
                contentValues.put("upgradeChangeLog", "");
                contentValues.put("upgradeLogo", "");
                contentValues.put("upgradePatchKey", "");
                contentValues.put("upgradePatchSize", "");
                contentValues.put("upgradePatchLength", (Integer) 0);
                contentValues.put("upgradePatchMd5", "");
                contentValues.put("extraAnalysisData", "");
                contentValues.put("extraFlag", "");
                return;
            }
            contentValues.put("upgradeApkId", upgradeInfo.getApkId());
            contentValues.put("upgradeDisplayVersionName", upgradeInfo.getDisplayVersionName());
            contentValues.put("upgradeVersionName", upgradeInfo.getVersionName());
            contentValues.put("upgradeVersionCode", Integer.valueOf(upgradeInfo.getVersionCode()));
            contentValues.put("upgradeApkSize", upgradeInfo.getApkSize());
            contentValues.put("upgradeLastUpdate", Long.valueOf(upgradeInfo.getLastUpdate()));
            contentValues.put("upgradeChangeLog", upgradeInfo.getChangeLog());
            contentValues.put("upgradeLogo", upgradeInfo.getLogo());
            contentValues.put("upgradePatchKey", upgradeInfo.getPatchKey());
            contentValues.put("upgradePatchSize", upgradeInfo.getPatchSize());
            contentValues.put("upgradePatchLength", upgradeInfo.getPatchLength());
            contentValues.put("upgradePatchMd5", upgradeInfo.getPatchMd5());
            contentValues.put("extraAnalysisData", upgradeInfo.getExtraAnalysisData());
            contentValues.put("extraFlag", upgradeInfo.getExtraFlag());
        }

        public static MobileApp parseCursor(Cursor cursor) {
            String string = cursor.getString(DbConst.getColumnIndex(cursor, "app", "packageName"));
            IgnoreInfo build = IgnoreInfo.newBuilder().packageName(string).type(cursor.getInt(DbConst.getColumnIndex(cursor, "app", "ignoredType"))).versionCode(cursor.getInt(DbConst.getColumnIndex(cursor, "app", "ignoreVersionCode"))).build();
            UpgradeInfo build2 = !TextUtils.isEmpty(cursor.getString(DbConst.getColumnIndex(cursor, "app", "upgradeApkId"))) ? UpgradeInfo.newBuilder().packageName(string).apkId(cursor.getString(DbConst.getColumnIndex(cursor, "app", "upgradeApkId"))).displayVersionName(cursor.getString(DbConst.getColumnIndex(cursor, "app", "upgradeDisplayVersionName"))).versionName(cursor.getString(DbConst.getColumnIndex(cursor, "app", "upgradeVersionName"))).versionCode(cursor.getInt(DbConst.getColumnIndex(cursor, "app", "upgradeVersionCode"))).apkSize(cursor.getString(DbConst.getColumnIndex(cursor, "app", "upgradeApkSize"))).lastUpdate(cursor.getLong(DbConst.getColumnIndex(cursor, "app", "upgradeLastUpdate"))).changeLog(cursor.getString(DbConst.getColumnIndex(cursor, "app", "upgradeChangeLog"))).logo(cursor.getString(DbConst.getColumnIndex(cursor, "app", "upgradeLogo"))).patchKey(cursor.getString(DbConst.getColumnIndex(cursor, "app", "upgradePatchKey"))).patchSize(cursor.getString(DbConst.getColumnIndex(cursor, "app", "upgradePatchSize"))).patchLength(Long.valueOf(cursor.getLong(DbConst.getColumnIndex(cursor, "app", "upgradePatchLength")))).patchMd5(cursor.getString(DbConst.getColumnIndex(cursor, "app", "upgradePatchMd5"))).extraAnalysisData(cursor.getString(DbConst.getColumnIndex(cursor, "app", "extraAnalysisData"))).extraFlag(cursor.getString(DbConst.getColumnIndex(cursor, "app", "extraFlag"))).build() : null;
            boolean z = false;
            MobileApp.Builder systemApp = MobileApp.newBuilder().dbId(cursor.getLong(DbConst.getColumnIndex(cursor, "app", "_id"))).packageName(string).appName(cursor.getString(DbConst.getColumnIndex(cursor, "app", "appName"))).versionName(cursor.getString(DbConst.getColumnIndex(cursor, "app", "versionName"))).versionCode(cursor.getInt(DbConst.getColumnIndex(cursor, "app", "versionCode"))).apkLength(cursor.getLong(DbConst.getColumnIndex(cursor, "app", "apkLength"))).systemApp(cursor.getInt(DbConst.getColumnIndex(cursor, "app", "isSystem")) == 1);
            if (cursor.getInt(DbConst.getColumnIndex(cursor, "app", "isExist")) == 1) {
                z = true;
            }
            return systemApp.exist(z).apkPath(cursor.getString(DbConst.getColumnIndex(cursor, "app", "apkPath"))).firstInstallTime(cursor.getLong(DbConst.getColumnIndex(cursor, "app", "firstInstallTime"))).lastUpdateTime(cursor.getLong(DbConst.getColumnIndex(cursor, "app", "lastUpdateTime"))).apkMd5(cursor.getString(DbConst.getColumnIndex(cursor, "app", "apkMd5"))).upgradeInfo(build2).ignoreInfo(build).created(cursor.getLong(DbConst.getColumnIndex(cursor, "app", "created"))).modified(cursor.getLong(DbConst.getColumnIndex(cursor, "app", "modified"))).build();
        }
    }

    public static class DownloadTable implements Columns {
        public static final String COL_APK_FILE_PATH = "apkFilePath";
        public static final String COL_CURRENT_LENGTH = "currentLength";
        public static final String COL_EXTRA = "extra";
        public static final String COL_FILE_NAME = "fileName";
        public static final String COL_FILE_PATH = "filePath";
        public static final String COL_MIME_TYPE = "mimeType";
        public static final String COL_START_TIME = "startTime";
        public static final String COL_TOTAL_LENGTH = "totalLength";
        public static final String COL_URL = "url";
        public static final String COL_URL_MD5 = "urlMd5";
        public static final String SORT_ORDER_DEFAULT = "created DESC";
        public static final String TABLE_NAME = "download";

        public static ContentValues toContentValues(DownloadInfo downloadInfo) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("url", downloadInfo.getUrl());
            contentValues.put("urlMd5", downloadInfo.getUrlMd5());
            contentValues.put("filePath", downloadInfo.getFilePath());
            contentValues.put("apkFilePath", downloadInfo.getApkFilePath());
            contentValues.put("fileName", downloadInfo.getFileName());
            contentValues.put("currentLength", Long.valueOf(downloadInfo.getCurrentLength()));
            contentValues.put("totalLength", Long.valueOf(downloadInfo.getTotalLength()));
            contentValues.put("extra", downloadInfo.getExtraString());
            contentValues.put("mimeType", downloadInfo.getMimeType());
            contentValues.put("startTime", Long.valueOf(downloadInfo.getStartTime()));
            return contentValues;
        }

        public static DownloadInfo parseCursor(Cursor cursor) {
            return DownloadInfo.newBuilder().dbId(cursor.getLong(DbConst.getColumnIndex(cursor, "download", "_id"))).url(cursor.getString(DbConst.getColumnIndex(cursor, "download", "url"))).filePath(cursor.getString(DbConst.getColumnIndex(cursor, "download", "filePath"))).apkFilePath(cursor.getString(DbConst.getColumnIndex(cursor, "download", "apkFilePath"))).fileName(cursor.getString(DbConst.getColumnIndex(cursor, "download", "fileName"))).currentLength(cursor.getLong(DbConst.getColumnIndex(cursor, "download", "currentLength"))).totalLength(cursor.getLong(DbConst.getColumnIndex(cursor, "download", "totalLength"))).extraString(cursor.getString(DbConst.getColumnIndex(cursor, "download", "extra"))).mimeType(cursor.getString(DbConst.getColumnIndex(cursor, "download", "mimeType"))).createTime(cursor.getLong(DbConst.getColumnIndex(cursor, "download", "created"))).startTime(cursor.getLong(DbConst.getColumnIndex(cursor, "download", "startTime"))).updateTime(cursor.getLong(DbConst.getColumnIndex(cursor, "download", "modified"))).build();
        }
    }

    public static class ArticleTable implements Columns {
        public static final String COL_CONTENT = "content";
        public static final String COL_COVER_URL = "coverUrl";
        public static final String COL_TITLE = "title";
        public static final String SORT_ORDER_DEFAULT = "modified DESC";
        public static final String TABLE_NAME = "article";

        public static Article parseCursor(Cursor cursor) {
            return Article.create(cursor.getLong(DbConst.getColumnIndex(cursor, "article", "_id")), cursor.getString(DbConst.getColumnIndex(cursor, "article", "title")), cursor.getString(DbConst.getColumnIndex(cursor, "article", "coverUrl")), cursor.getString(DbConst.getColumnIndex(cursor, "article", "content")), cursor.getLong(DbConst.getColumnIndex(cursor, "article", "modified")), cursor.getLong(DbConst.getColumnIndex(cursor, "article", "created")));
        }
    }
}
