package com.coolapk.market.widget.condom;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

class PseudoContextWrapper extends Context {
    Context mBase;

    public PseudoContextWrapper(Context context) {
        this.mBase = context;
    }

    protected void attachBaseContext(Context context) {
        if (this.mBase == null) {
            this.mBase = context;
            return;
        }
        throw new IllegalStateException("Base context already set");
    }

    Context getBaseContext() {
        return this.mBase;
    }

    @Override // android.content.Context
    public AssetManager getAssets() {
        return this.mBase.getAssets();
    }

    @Override // android.content.Context
    public Resources getResources() {
        return this.mBase.getResources();
    }

    @Override // android.content.Context
    public PackageManager getPackageManager() {
        return this.mBase.getPackageManager();
    }

    @Override // android.content.Context
    public ContentResolver getContentResolver() {
        return this.mBase.getContentResolver();
    }

    @Override // android.content.Context
    public Looper getMainLooper() {
        return this.mBase.getMainLooper();
    }

    @Override // android.content.Context
    public Context getApplicationContext() {
        return this.mBase.getApplicationContext();
    }

    @Override // android.content.Context
    public void setTheme(int i) {
        this.mBase.setTheme(i);
    }

    @Override // android.content.Context
    public Resources.Theme getTheme() {
        return this.mBase.getTheme();
    }

    @Override // android.content.Context
    public ClassLoader getClassLoader() {
        return this.mBase.getClassLoader();
    }

    @Override // android.content.Context
    public String getPackageName() {
        return this.mBase.getPackageName();
    }

    @Override // android.content.Context
    public ApplicationInfo getApplicationInfo() {
        return this.mBase.getApplicationInfo();
    }

    @Override // android.content.Context
    public String getPackageResourcePath() {
        return this.mBase.getPackageResourcePath();
    }

    @Override // android.content.Context
    public String getPackageCodePath() {
        return this.mBase.getPackageCodePath();
    }

    @Override // android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        return this.mBase.getSharedPreferences(str, i);
    }

    @Override // android.content.Context
    public boolean moveSharedPreferencesFrom(Context context, String str) {
        return this.mBase.moveSharedPreferencesFrom(context, str);
    }

    @Override // android.content.Context
    public boolean deleteSharedPreferences(String str) {
        return this.mBase.deleteSharedPreferences(str);
    }

    @Override // android.content.Context
    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        return this.mBase.openFileInput(str);
    }

    @Override // android.content.Context
    public FileOutputStream openFileOutput(String str, int i) throws FileNotFoundException {
        return this.mBase.openFileOutput(str, i);
    }

    @Override // android.content.Context
    public boolean deleteFile(String str) {
        return this.mBase.deleteFile(str);
    }

    @Override // android.content.Context
    public File getFileStreamPath(String str) {
        return this.mBase.getFileStreamPath(str);
    }

    @Override // android.content.Context
    public String[] fileList() {
        return this.mBase.fileList();
    }

    @Override // android.content.Context
    public File getDataDir() {
        return this.mBase.getDataDir();
    }

    @Override // android.content.Context
    public File getFilesDir() {
        return this.mBase.getFilesDir();
    }

    @Override // android.content.Context
    public File getNoBackupFilesDir() {
        return this.mBase.getNoBackupFilesDir();
    }

    @Override // android.content.Context
    public File getExternalFilesDir(String str) {
        return this.mBase.getExternalFilesDir(str);
    }

    @Override // android.content.Context
    public File[] getExternalFilesDirs(String str) {
        return this.mBase.getExternalFilesDirs(str);
    }

    @Override // android.content.Context
    public File getObbDir() {
        return this.mBase.getObbDir();
    }

    @Override // android.content.Context
    public File[] getObbDirs() {
        return this.mBase.getObbDirs();
    }

    @Override // android.content.Context
    public File getCacheDir() {
        return this.mBase.getCacheDir();
    }

    @Override // android.content.Context
    public File getCodeCacheDir() {
        return this.mBase.getCodeCacheDir();
    }

    @Override // android.content.Context
    public File getExternalCacheDir() {
        return this.mBase.getExternalCacheDir();
    }

    @Override // android.content.Context
    public File[] getExternalCacheDirs() {
        return this.mBase.getExternalCacheDirs();
    }

    @Override // android.content.Context
    public File[] getExternalMediaDirs() {
        return this.mBase.getExternalMediaDirs();
    }

    @Override // android.content.Context
    public File getDir(String str, int i) {
        return this.mBase.getDir(str, i);
    }

    @Override // android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        return this.mBase.openOrCreateDatabase(str, i, cursorFactory);
    }

    @Override // android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return this.mBase.openOrCreateDatabase(str, i, cursorFactory, databaseErrorHandler);
    }

    @Override // android.content.Context
    public boolean moveDatabaseFrom(Context context, String str) {
        return this.mBase.moveDatabaseFrom(context, str);
    }

    @Override // android.content.Context
    public boolean deleteDatabase(String str) {
        return this.mBase.deleteDatabase(str);
    }

    @Override // android.content.Context
    public File getDatabasePath(String str) {
        return this.mBase.getDatabasePath(str);
    }

    @Override // android.content.Context
    public String[] databaseList() {
        return this.mBase.databaseList();
    }

    @Override // android.content.Context
    @Deprecated
    public Drawable getWallpaper() {
        return this.mBase.getWallpaper();
    }

    @Override // android.content.Context
    @Deprecated
    public Drawable peekWallpaper() {
        return this.mBase.peekWallpaper();
    }

    @Override // android.content.Context
    @Deprecated
    public int getWallpaperDesiredMinimumWidth() {
        return this.mBase.getWallpaperDesiredMinimumWidth();
    }

    @Override // android.content.Context
    @Deprecated
    public int getWallpaperDesiredMinimumHeight() {
        return this.mBase.getWallpaperDesiredMinimumHeight();
    }

    @Override // android.content.Context
    @Deprecated
    public void setWallpaper(Bitmap bitmap) throws IOException {
        this.mBase.setWallpaper(bitmap);
    }

    @Override // android.content.Context
    @Deprecated
    public void setWallpaper(InputStream inputStream) throws IOException {
        this.mBase.setWallpaper(inputStream);
    }

    @Override // android.content.Context
    @Deprecated
    public void clearWallpaper() throws IOException {
        this.mBase.clearWallpaper();
    }

    @Override // android.content.Context
    public void startActivity(Intent intent) {
        this.mBase.startActivity(intent);
    }

    @Override // android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        this.mBase.startActivity(intent, bundle);
    }

    @Override // android.content.Context
    public void startActivities(Intent[] intentArr) {
        this.mBase.startActivities(intentArr);
    }

    @Override // android.content.Context
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        this.mBase.startActivities(intentArr, bundle);
    }

    @Override // android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3) throws IntentSender.SendIntentException {
        this.mBase.startIntentSender(intentSender, intent, i, i2, i3);
    }

    @Override // android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3, Bundle bundle) throws IntentSender.SendIntentException {
        this.mBase.startIntentSender(intentSender, intent, i, i2, i3, bundle);
    }

    @Override // android.content.Context
    public void sendBroadcast(Intent intent) {
        this.mBase.sendBroadcast(intent);
    }

    @Override // android.content.Context
    public void sendBroadcast(Intent intent, String str) {
        this.mBase.sendBroadcast(intent, str);
    }

    @Override // android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str) {
        this.mBase.sendOrderedBroadcast(intent, str);
    }

    @Override // android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str2, Bundle bundle) {
        this.mBase.sendOrderedBroadcast(intent, str, broadcastReceiver, handler, i, str2, bundle);
    }

    @Override // android.content.Context
    public void sendBroadcastAsUser(Intent intent, UserHandle userHandle) {
        this.mBase.sendBroadcastAsUser(intent, userHandle);
    }

    @Override // android.content.Context
    public void sendBroadcastAsUser(Intent intent, UserHandle userHandle, String str) {
        this.mBase.sendBroadcastAsUser(intent, userHandle, str);
    }

    @Override // android.content.Context
    public void sendOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str2, Bundle bundle) {
        this.mBase.sendOrderedBroadcastAsUser(intent, userHandle, str, broadcastReceiver, handler, i, str2, bundle);
    }

    @Override // android.content.Context
    public void sendStickyBroadcast(Intent intent) {
        this.mBase.sendStickyBroadcast(intent);
    }

    @Override // android.content.Context
    public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str, Bundle bundle) {
        this.mBase.sendStickyOrderedBroadcast(intent, broadcastReceiver, handler, i, str, bundle);
    }

    @Override // android.content.Context
    public void removeStickyBroadcast(Intent intent) {
        this.mBase.removeStickyBroadcast(intent);
    }

    @Override // android.content.Context
    public void sendStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {
        this.mBase.sendStickyBroadcastAsUser(intent, userHandle);
    }

    @Override // android.content.Context
    public void sendStickyOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str, Bundle bundle) {
        this.mBase.sendStickyOrderedBroadcastAsUser(intent, userHandle, broadcastReceiver, handler, i, str, bundle);
    }

    @Override // android.content.Context
    @Deprecated
    public void removeStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {
        this.mBase.removeStickyBroadcastAsUser(intent, userHandle);
    }

    @Override // android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return this.mBase.registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override // android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
        return this.mBase.registerReceiver(broadcastReceiver, intentFilter, i);
    }

    @Override // android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        return this.mBase.registerReceiver(broadcastReceiver, intentFilter, str, handler);
    }

    @Override // android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
        return this.mBase.registerReceiver(broadcastReceiver, intentFilter, str, handler, i);
    }

    @Override // android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        this.mBase.unregisterReceiver(broadcastReceiver);
    }

    @Override // android.content.Context
    public ComponentName startService(Intent intent) {
        return this.mBase.startService(intent);
    }

    @Override // android.content.Context
    public ComponentName startForegroundService(Intent intent) {
        return this.mBase.startForegroundService(intent);
    }

    @Override // android.content.Context
    public boolean stopService(Intent intent) {
        return this.mBase.stopService(intent);
    }

    @Override // android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        return this.mBase.bindService(intent, serviceConnection, i);
    }

    @Override // android.content.Context
    public void unbindService(ServiceConnection serviceConnection) {
        this.mBase.unbindService(serviceConnection);
    }

    @Override // android.content.Context
    public boolean startInstrumentation(ComponentName componentName, String str, Bundle bundle) {
        return this.mBase.startInstrumentation(componentName, str, bundle);
    }

    @Override // android.content.Context
    public Object getSystemService(String str) {
        return this.mBase.getSystemService(str);
    }

    @Override // android.content.Context
    public String getSystemServiceName(Class<?> cls) {
        return this.mBase.getSystemServiceName(cls);
    }

    @Override // android.content.Context
    public int checkPermission(String str, int i, int i2) {
        return this.mBase.checkPermission(str, i, i2);
    }

    @Override // android.content.Context
    public int checkCallingPermission(String str) {
        return this.mBase.checkCallingPermission(str);
    }

    @Override // android.content.Context
    public int checkCallingOrSelfPermission(String str) {
        return this.mBase.checkCallingOrSelfPermission(str);
    }

    @Override // android.content.Context
    public int checkSelfPermission(String str) {
        return this.mBase.checkSelfPermission(str);
    }

    @Override // android.content.Context
    public void enforcePermission(String str, int i, int i2, String str2) {
        this.mBase.enforcePermission(str, i, i2, str2);
    }

    @Override // android.content.Context
    public void enforceCallingPermission(String str, String str2) {
        this.mBase.enforceCallingPermission(str, str2);
    }

    @Override // android.content.Context
    public void enforceCallingOrSelfPermission(String str, String str2) {
        this.mBase.enforceCallingOrSelfPermission(str, str2);
    }

    @Override // android.content.Context
    public void grantUriPermission(String str, Uri uri, int i) {
        this.mBase.grantUriPermission(str, uri, i);
    }

    @Override // android.content.Context
    public void revokeUriPermission(Uri uri, int i) {
        this.mBase.revokeUriPermission(uri, i);
    }

    @Override // android.content.Context
    public void revokeUriPermission(String str, Uri uri, int i) {
        this.mBase.revokeUriPermission(str, uri, i);
    }

    @Override // android.content.Context
    public int checkUriPermission(Uri uri, int i, int i2, int i3) {
        return this.mBase.checkUriPermission(uri, i, i2, i3);
    }

    @Override // android.content.Context
    public int checkCallingUriPermission(Uri uri, int i) {
        return this.mBase.checkCallingUriPermission(uri, i);
    }

    @Override // android.content.Context
    public int checkCallingOrSelfUriPermission(Uri uri, int i) {
        return this.mBase.checkCallingOrSelfUriPermission(uri, i);
    }

    @Override // android.content.Context
    public int checkUriPermission(Uri uri, String str, String str2, int i, int i2, int i3) {
        return this.mBase.checkUriPermission(uri, str, str2, i, i2, i3);
    }

    @Override // android.content.Context
    public void enforceUriPermission(Uri uri, int i, int i2, int i3, String str) {
        this.mBase.enforceUriPermission(uri, i, i2, i3, str);
    }

    @Override // android.content.Context
    public void enforceCallingUriPermission(Uri uri, int i, String str) {
        this.mBase.enforceCallingUriPermission(uri, i, str);
    }

    @Override // android.content.Context
    public void enforceCallingOrSelfUriPermission(Uri uri, int i, String str) {
        this.mBase.enforceCallingOrSelfUriPermission(uri, i, str);
    }

    @Override // android.content.Context
    public void enforceUriPermission(Uri uri, String str, String str2, int i, int i2, int i3, String str3) {
        this.mBase.enforceUriPermission(uri, str, str2, i, i2, i3, str3);
    }

    @Override // android.content.Context
    public Context createPackageContext(String str, int i) throws PackageManager.NameNotFoundException {
        return this.mBase.createPackageContext(str, i);
    }

    @Override // android.content.Context
    public Context createContextForSplit(String str) throws PackageManager.NameNotFoundException {
        return this.mBase.createContextForSplit(str);
    }

    @Override // android.content.Context
    public Context createConfigurationContext(Configuration configuration) {
        return this.mBase.createConfigurationContext(configuration);
    }

    @Override // android.content.Context
    public Context createDisplayContext(Display display) {
        return this.mBase.createDisplayContext(display);
    }

    @Override // android.content.Context
    public boolean isRestricted() {
        return this.mBase.isRestricted();
    }

    @Override // android.content.Context
    public Context createDeviceProtectedStorageContext() {
        return this.mBase.createDeviceProtectedStorageContext();
    }

    @Override // android.content.Context
    public boolean isDeviceProtectedStorage() {
        return this.mBase.isDeviceProtectedStorage();
    }
}
