package com.coolapk.market.local;

import android.content.ContentValues;
import android.database.Cursor;
import com.coolapk.market.local.DbConst;
import com.coolapk.market.model.DownloadInfo;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.UpgradeInfo;
import java.util.ArrayList;
import java.util.List;

public class DbHelper {
    public static final int FLAG_GET_ALL = 0;
    public static final int FLAG_GET_EXIST_APP = 1;
    public static final int FLAG_GET_UPGRADE_APP = 2;
    private Db db;

    public DbHelper(DbOpenHelper dbOpenHelper) {
        this.db = new Db(dbOpenHelper);
    }

    public void close() {
        this.db.close();
    }

    public Db getDb() {
        return this.db;
    }

    public void insertOrUpdateContentValuesList(String str, List<ContentValues> list) {
        this.db.getWriteableDatabase().beginTransaction();
        for (ContentValues contentValues : list) {
            saveContentValues(str, contentValues);
        }
        this.db.getWriteableDatabase().setTransactionSuccessful();
        this.db.getWriteableDatabase().endTransaction();
    }

    private long saveContentValues(String str, ContentValues contentValues) {
        Long l;
        if (contentValues.containsKey("_id")) {
            l = contentValues.getAsLong("_id");
            contentValues.remove("_id");
        } else {
            l = null;
        }
        if (l == null || l.longValue() <= 0) {
            return this.db.insert(str, contentValues, 3);
        }
        Db db2 = this.db;
        return (long) db2.update(str, contentValues, "_id=?", "" + l);
    }

    public long saveMobileApp(MobileApp mobileApp) {
        ContentValues contentValues = DbConst.AppTable.toContentValues(mobileApp);
        if (mobileApp.getDbId() > 0) {
            contentValues.put("modified", Long.valueOf(mobileApp.getModified()));
            Db db2 = this.db;
            db2.update("app", contentValues, "_id=?", "" + mobileApp.getDbId());
            return mobileApp.getDbId();
        }
        contentValues.put("modified", Long.valueOf(mobileApp.getModified()));
        contentValues.put("created", Long.valueOf(mobileApp.getModified()));
        return this.db.insert("app", contentValues, 3);
    }

    public int deleteMobileApp(String str) {
        return this.db.delete("app", "packageName=?", str);
    }

    public MobileApp getMobileApp(String str) {
        Cursor query = this.db.query("SELECT * FROM app WHERE packageName =?", str);
        try {
            return query.moveToNext() ? DbConst.AppTable.parseCursor(query) : null;
        } finally {
            query.close();
        }
    }

    public synchronized List<MobileApp> getMobileAppList(int i) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            List<MobileApp> mobileAppList = getMobileAppList(i, i2, 300);
            if (mobileAppList == null) {
                break;
            } else if (mobileAppList.isEmpty()) {
                break;
            } else {
                i2 += 300;
                arrayList.addAll(mobileAppList);
            }
        }
        return arrayList;
    }

    public List<MobileApp> getMobileAppList(int i, int i2, int i3) {
        String str = "SELECT * FROM app";
        if (i == 1) {
            str = str + " WHERE isExist =1";
        } else if (i == 2) {
            str = str + " WHERE upgradeApkId IS NOT NULL AND upgradeApkId !=''";
        }
        if (!(i2 == -1 || i3 == -1)) {
            str = str + " LIMIT " + i2 + " , " + i3;
        }
        Cursor query = this.db.query(str, new String[0]);
        ArrayList arrayList = new ArrayList(query.getCount());
        while (query.moveToNext()) {
            try {
                arrayList.add(DbConst.AppTable.parseCursor(query));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    public long saveDownloadInfo(DownloadInfo downloadInfo) {
        ContentValues contentValues = DbConst.DownloadTable.toContentValues(downloadInfo);
        if (downloadInfo.getDbId() > 0) {
            contentValues.put("modified", Long.valueOf(downloadInfo.getUpdateTime()));
            Db db2 = this.db;
            if (db2.update("download", contentValues, "_id=?", "" + downloadInfo.getDbId()) > 0) {
                return downloadInfo.getDbId();
            }
        }
        contentValues.remove("_id");
        contentValues.put("modified", Long.valueOf(downloadInfo.getUpdateTime()));
        contentValues.put("created", Long.valueOf(downloadInfo.getUpdateTime()));
        return this.db.insert("download", contentValues, 3);
    }

    public DownloadInfo getDownloadInfo(String str) {
        Cursor query = this.db.query("SELECT * FROM download WHERE urlMd5 =?", str);
        try {
            return query.moveToNext() ? DbConst.DownloadTable.parseCursor(query) : null;
        } finally {
            query.close();
        }
    }

    public List<DownloadInfo> getDownloadInfoList(int i) {
        Cursor query = this.db.query("SELECT * FROM download ORDER BY created DESC", new String[0]);
        ArrayList arrayList = new ArrayList(query.getCount());
        while (query.moveToNext()) {
            try {
                arrayList.add(DbConst.DownloadTable.parseCursor(query));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    public void updateMobileAppUpgradeInfoList(List<UpgradeInfo> list) {
        this.db.getWriteableDatabase().beginTransaction();
        for (UpgradeInfo upgradeInfo : list) {
            updateMobileAppUpgradeInfo(upgradeInfo);
        }
        this.db.getWriteableDatabase().setTransactionSuccessful();
        this.db.getWriteableDatabase().endTransaction();
    }

    public int updateMobileAppUpgradeInfo(UpgradeInfo upgradeInfo) {
        ContentValues contentValues = new ContentValues();
        DbConst.AppTable.inflateUpgradeContentValues(contentValues, upgradeInfo);
        return this.db.update("app", contentValues, "packageName=?", upgradeInfo.getPackageName());
    }

    public int setAllMobileAppNotExist() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("isExist", (Boolean) false);
        return this.db.update("app", contentValues, null, new String[0]);
    }

    public int deleteMobileAppNotExist() {
        return this.db.delete("app", "isExist !=1", new String[0]);
    }

    public int clearMobileAppUpgradeInfo() {
        ContentValues contentValues = new ContentValues();
        DbConst.AppTable.inflateUpgradeContentValues(contentValues, null);
        return this.db.update("app", contentValues, "upgradeApkId IS NOT NULL AND upgradeApkId !=''", new String[0]);
    }

    public int clearMobileAppUpgradeInfo(String str) {
        ContentValues contentValues = new ContentValues();
        DbConst.AppTable.inflateUpgradeContentValues(contentValues, null);
        return this.db.update("app", contentValues, "packageName =?", str);
    }

    public int fixIgnoreAllUpgradeBug() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("ignoredType", (Integer) 0);
        return this.db.update("app", contentValues, "(upgradeApkId IS NULL OR upgradeApkId =='') AND ignoredType != 0", new String[0]);
    }

    public int ignoreAllUpgrade() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("ignoredType", (Integer) 1);
        return this.db.update("app", contentValues, "upgradeApkId IS NOT NULL AND upgradeApkId !='' AND ignoredType == 0", new String[0]);
    }

    public int cancelAllIgnore() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("ignoredType", (Integer) 0);
        return this.db.update("app", contentValues, "upgradeApkId IS NOT NULL AND upgradeApkId !='' AND ignoredType != 0", new String[0]);
    }

    public int cancelIgnoreUpgrade(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("ignoredType", (Integer) 0);
        return this.db.update("app", contentValues, "packageName =? ", str);
    }

    public int ignoreUpgrade(String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("ignoredType", Integer.valueOf(i));
        return this.db.update("app", contentValues, "packageName =? ", str);
    }

    public void deleteDownloadInfoList(List<DownloadInfo> list) {
        this.db.getWriteableDatabase().beginTransaction();
        for (DownloadInfo downloadInfo : list) {
            deleteDownloadInfo(downloadInfo);
        }
        this.db.getWriteableDatabase().setTransactionSuccessful();
        this.db.getWriteableDatabase().endTransaction();
    }

    public int updateDownloadInfoApkPath(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("apkFilePath", str2);
        return this.db.update("download", contentValues, "urlMd5 =?", str);
    }

    public int deleteDownloadInfo(DownloadInfo downloadInfo) {
        return this.db.delete("download", "_id =? ", String.valueOf(downloadInfo.getDbId()));
    }

    public int deleteDownloadInfo(String str) {
        return this.db.delete("download", "urlMd5 =? ", str);
    }

    public void saveLog(String str, String str2, String str3) {
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tag", str);
        contentValues.put("message", str2);
        contentValues.put("error", str3);
        contentValues.put("created", Long.valueOf(currentTimeMillis));
        contentValues.put("modified", Long.valueOf(currentTimeMillis));
        this.db.insert("log", contentValues);
    }

    public Cursor getLogs(String str) {
        if (str.hashCode() == 1427818632) {
            str.equals("download");
        }
        return this.db.query("SELECT * FROM log WHERE tag=? ORDER BY created DESC", str);
    }

    public int cleanLogs(String str) {
        return this.db.delete("log", "tag =? ", str);
    }

    public long insertArticle(String str, String str2, String str3) {
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", str);
        contentValues.put("coverUrl", str2);
        contentValues.put("content", str3);
        contentValues.put("created", Long.valueOf(currentTimeMillis));
        contentValues.put("modified", Long.valueOf(currentTimeMillis));
        return this.db.insert("article", contentValues);
    }

    public int updateArticle(long j, String str, String str2, String str3) {
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        if (str != null) {
            contentValues.put("title", str);
        }
        if (str2 != null) {
            contentValues.put("coverUrl", str2);
        }
        if (str3 != null) {
            contentValues.put("content", str3);
        }
        contentValues.put("modified", Long.valueOf(currentTimeMillis));
        return this.db.update("article", contentValues, "_id =? ", String.valueOf(j));
    }

    public int deleteArticle(long j) {
        return this.db.delete("article", "_id =? ", String.valueOf(j));
    }

    public Cursor getArticles() {
        return this.db.query("SELECT * FROM article ORDER BY modified DESC", new String[0]);
    }
}
