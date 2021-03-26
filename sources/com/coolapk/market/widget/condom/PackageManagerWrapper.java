package com.coolapk.market.widget.condom;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ChangedPackages;
import android.content.pm.FeatureInfo;
import android.content.pm.InstrumentationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.SharedLibraryInfo;
import android.content.pm.VersionedPackage;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.UserHandle;
import java.util.List;

class PackageManagerWrapper extends PackageManager {
    PackageManager mBase;

    @Override // android.content.pm.PackageManager
    public PackageInfo getPackageInfo(String str, int i) throws PackageManager.NameNotFoundException {
        return this.mBase.getPackageInfo(str, i);
    }

    @Override // android.content.pm.PackageManager
    public PackageInfo getPackageInfo(VersionedPackage versionedPackage, int i) throws PackageManager.NameNotFoundException {
        return this.mBase.getPackageInfo(versionedPackage, i);
    }

    @Override // android.content.pm.PackageManager
    public String[] currentToCanonicalPackageNames(String[] strArr) {
        return this.mBase.currentToCanonicalPackageNames(strArr);
    }

    @Override // android.content.pm.PackageManager
    public String[] canonicalToCurrentPackageNames(String[] strArr) {
        return this.mBase.canonicalToCurrentPackageNames(strArr);
    }

    @Override // android.content.pm.PackageManager
    public Intent getLaunchIntentForPackage(String str) {
        return this.mBase.getLaunchIntentForPackage(str);
    }

    @Override // android.content.pm.PackageManager
    public Intent getLeanbackLaunchIntentForPackage(String str) {
        return this.mBase.getLeanbackLaunchIntentForPackage(str);
    }

    @Override // android.content.pm.PackageManager
    public int[] getPackageGids(String str) throws PackageManager.NameNotFoundException {
        return this.mBase.getPackageGids(str);
    }

    @Override // android.content.pm.PackageManager
    public int[] getPackageGids(String str, int i) throws PackageManager.NameNotFoundException {
        return this.mBase.getPackageGids(str, i);
    }

    @Override // android.content.pm.PackageManager
    public int getPackageUid(String str, int i) throws PackageManager.NameNotFoundException {
        return this.mBase.getPackageUid(str, i);
    }

    @Override // android.content.pm.PackageManager
    public PermissionInfo getPermissionInfo(String str, int i) throws PackageManager.NameNotFoundException {
        return this.mBase.getPermissionInfo(str, i);
    }

    @Override // android.content.pm.PackageManager
    public List<PermissionInfo> queryPermissionsByGroup(String str, int i) throws PackageManager.NameNotFoundException {
        return this.mBase.queryPermissionsByGroup(str, i);
    }

    @Override // android.content.pm.PackageManager
    public PermissionGroupInfo getPermissionGroupInfo(String str, int i) throws PackageManager.NameNotFoundException {
        return this.mBase.getPermissionGroupInfo(str, i);
    }

    @Override // android.content.pm.PackageManager
    public List<PermissionGroupInfo> getAllPermissionGroups(int i) {
        return this.mBase.getAllPermissionGroups(i);
    }

    @Override // android.content.pm.PackageManager
    public ApplicationInfo getApplicationInfo(String str, int i) throws PackageManager.NameNotFoundException {
        return this.mBase.getApplicationInfo(str, i);
    }

    @Override // android.content.pm.PackageManager
    public ActivityInfo getActivityInfo(ComponentName componentName, int i) throws PackageManager.NameNotFoundException {
        return this.mBase.getActivityInfo(componentName, i);
    }

    @Override // android.content.pm.PackageManager
    public ActivityInfo getReceiverInfo(ComponentName componentName, int i) throws PackageManager.NameNotFoundException {
        return this.mBase.getReceiverInfo(componentName, i);
    }

    @Override // android.content.pm.PackageManager
    public ServiceInfo getServiceInfo(ComponentName componentName, int i) throws PackageManager.NameNotFoundException {
        return this.mBase.getServiceInfo(componentName, i);
    }

    @Override // android.content.pm.PackageManager
    public ProviderInfo getProviderInfo(ComponentName componentName, int i) throws PackageManager.NameNotFoundException {
        return this.mBase.getProviderInfo(componentName, i);
    }

    @Override // android.content.pm.PackageManager
    public List<PackageInfo> getInstalledPackages(int i) {
        return this.mBase.getInstalledPackages(i);
    }

    @Override // android.content.pm.PackageManager
    public List<PackageInfo> getPackagesHoldingPermissions(String[] strArr, int i) {
        return this.mBase.getPackagesHoldingPermissions(strArr, i);
    }

    @Override // android.content.pm.PackageManager
    public int checkPermission(String str, String str2) {
        return this.mBase.checkPermission(str, str2);
    }

    @Override // android.content.pm.PackageManager
    public boolean isPermissionRevokedByPolicy(String str, String str2) {
        return this.mBase.isPermissionRevokedByPolicy(str, str2);
    }

    @Override // android.content.pm.PackageManager
    public boolean addPermission(PermissionInfo permissionInfo) {
        return this.mBase.addPermission(permissionInfo);
    }

    @Override // android.content.pm.PackageManager
    public boolean addPermissionAsync(PermissionInfo permissionInfo) {
        return this.mBase.addPermissionAsync(permissionInfo);
    }

    @Override // android.content.pm.PackageManager
    public void removePermission(String str) {
        this.mBase.removePermission(str);
    }

    @Override // android.content.pm.PackageManager
    public int checkSignatures(String str, String str2) {
        return this.mBase.checkSignatures(str, str2);
    }

    @Override // android.content.pm.PackageManager
    public int checkSignatures(int i, int i2) {
        return this.mBase.checkSignatures(i, i2);
    }

    @Override // android.content.pm.PackageManager
    public String[] getPackagesForUid(int i) {
        return this.mBase.getPackagesForUid(i);
    }

    @Override // android.content.pm.PackageManager
    public String getNameForUid(int i) {
        return this.mBase.getNameForUid(i);
    }

    @Override // android.content.pm.PackageManager
    public List<ApplicationInfo> getInstalledApplications(int i) {
        return this.mBase.getInstalledApplications(i);
    }

    @Override // android.content.pm.PackageManager
    public boolean isInstantApp() {
        return this.mBase.isInstantApp();
    }

    @Override // android.content.pm.PackageManager
    public boolean isInstantApp(String str) {
        return this.mBase.isInstantApp(str);
    }

    @Override // android.content.pm.PackageManager
    public int getInstantAppCookieMaxBytes() {
        return this.mBase.getInstantAppCookieMaxBytes();
    }

    @Override // android.content.pm.PackageManager
    public byte[] getInstantAppCookie() {
        return this.mBase.getInstantAppCookie();
    }

    @Override // android.content.pm.PackageManager
    public void clearInstantAppCookie() {
        this.mBase.clearInstantAppCookie();
    }

    @Override // android.content.pm.PackageManager
    public void updateInstantAppCookie(byte[] bArr) {
        this.mBase.updateInstantAppCookie(bArr);
    }

    @Override // android.content.pm.PackageManager
    public String[] getSystemSharedLibraryNames() {
        return this.mBase.getSystemSharedLibraryNames();
    }

    @Override // android.content.pm.PackageManager
    public List<SharedLibraryInfo> getSharedLibraries(int i) {
        return this.mBase.getSharedLibraries(i);
    }

    @Override // android.content.pm.PackageManager
    public ChangedPackages getChangedPackages(int i) {
        return this.mBase.getChangedPackages(i);
    }

    @Override // android.content.pm.PackageManager
    public FeatureInfo[] getSystemAvailableFeatures() {
        return this.mBase.getSystemAvailableFeatures();
    }

    @Override // android.content.pm.PackageManager
    public boolean hasSystemFeature(String str) {
        return this.mBase.hasSystemFeature(str);
    }

    @Override // android.content.pm.PackageManager
    public boolean hasSystemFeature(String str, int i) {
        return this.mBase.hasSystemFeature(str, i);
    }

    @Override // android.content.pm.PackageManager
    public ResolveInfo resolveActivity(Intent intent, int i) {
        return this.mBase.resolveActivity(intent, i);
    }

    @Override // android.content.pm.PackageManager
    public List<ResolveInfo> queryIntentActivities(Intent intent, int i) {
        return this.mBase.queryIntentActivities(intent, i);
    }

    @Override // android.content.pm.PackageManager
    public List<ResolveInfo> queryIntentActivityOptions(ComponentName componentName, Intent[] intentArr, Intent intent, int i) {
        return this.mBase.queryIntentActivityOptions(componentName, intentArr, intent, i);
    }

    @Override // android.content.pm.PackageManager
    public List<ResolveInfo> queryBroadcastReceivers(Intent intent, int i) {
        return this.mBase.queryBroadcastReceivers(intent, i);
    }

    @Override // android.content.pm.PackageManager
    public ResolveInfo resolveService(Intent intent, int i) {
        return this.mBase.resolveService(intent, i);
    }

    @Override // android.content.pm.PackageManager
    public List<ResolveInfo> queryIntentServices(Intent intent, int i) {
        return this.mBase.queryIntentServices(intent, i);
    }

    @Override // android.content.pm.PackageManager
    public List<ResolveInfo> queryIntentContentProviders(Intent intent, int i) {
        return this.mBase.queryIntentContentProviders(intent, i);
    }

    @Override // android.content.pm.PackageManager
    public ProviderInfo resolveContentProvider(String str, int i) {
        return this.mBase.resolveContentProvider(str, i);
    }

    @Override // android.content.pm.PackageManager
    public List<ProviderInfo> queryContentProviders(String str, int i, int i2) {
        return this.mBase.queryContentProviders(str, i, i2);
    }

    @Override // android.content.pm.PackageManager
    public InstrumentationInfo getInstrumentationInfo(ComponentName componentName, int i) throws PackageManager.NameNotFoundException {
        return this.mBase.getInstrumentationInfo(componentName, i);
    }

    @Override // android.content.pm.PackageManager
    public List<InstrumentationInfo> queryInstrumentation(String str, int i) {
        return this.mBase.queryInstrumentation(str, i);
    }

    @Override // android.content.pm.PackageManager
    public Drawable getDrawable(String str, int i, ApplicationInfo applicationInfo) {
        return this.mBase.getDrawable(str, i, applicationInfo);
    }

    @Override // android.content.pm.PackageManager
    public Drawable getActivityIcon(ComponentName componentName) throws PackageManager.NameNotFoundException {
        return this.mBase.getActivityIcon(componentName);
    }

    @Override // android.content.pm.PackageManager
    public Drawable getActivityIcon(Intent intent) throws PackageManager.NameNotFoundException {
        return this.mBase.getActivityIcon(intent);
    }

    @Override // android.content.pm.PackageManager
    public Drawable getActivityBanner(ComponentName componentName) throws PackageManager.NameNotFoundException {
        return this.mBase.getActivityBanner(componentName);
    }

    @Override // android.content.pm.PackageManager
    public Drawable getActivityBanner(Intent intent) throws PackageManager.NameNotFoundException {
        return this.mBase.getActivityBanner(intent);
    }

    @Override // android.content.pm.PackageManager
    public Drawable getDefaultActivityIcon() {
        return this.mBase.getDefaultActivityIcon();
    }

    @Override // android.content.pm.PackageManager
    public Drawable getApplicationIcon(ApplicationInfo applicationInfo) {
        return this.mBase.getApplicationIcon(applicationInfo);
    }

    @Override // android.content.pm.PackageManager
    public Drawable getApplicationIcon(String str) throws PackageManager.NameNotFoundException {
        return this.mBase.getApplicationIcon(str);
    }

    @Override // android.content.pm.PackageManager
    public Drawable getApplicationBanner(ApplicationInfo applicationInfo) {
        return this.mBase.getApplicationBanner(applicationInfo);
    }

    @Override // android.content.pm.PackageManager
    public Drawable getApplicationBanner(String str) throws PackageManager.NameNotFoundException {
        return this.mBase.getApplicationBanner(str);
    }

    @Override // android.content.pm.PackageManager
    public Drawable getActivityLogo(ComponentName componentName) throws PackageManager.NameNotFoundException {
        return this.mBase.getActivityLogo(componentName);
    }

    @Override // android.content.pm.PackageManager
    public Drawable getActivityLogo(Intent intent) throws PackageManager.NameNotFoundException {
        return this.mBase.getActivityLogo(intent);
    }

    @Override // android.content.pm.PackageManager
    public Drawable getApplicationLogo(ApplicationInfo applicationInfo) {
        return this.mBase.getApplicationLogo(applicationInfo);
    }

    @Override // android.content.pm.PackageManager
    public Drawable getApplicationLogo(String str) throws PackageManager.NameNotFoundException {
        return this.mBase.getApplicationLogo(str);
    }

    @Override // android.content.pm.PackageManager
    public Drawable getUserBadgedIcon(Drawable drawable, UserHandle userHandle) {
        return this.mBase.getUserBadgedIcon(drawable, userHandle);
    }

    @Override // android.content.pm.PackageManager
    public Drawable getUserBadgedDrawableForDensity(Drawable drawable, UserHandle userHandle, Rect rect, int i) {
        return this.mBase.getUserBadgedDrawableForDensity(drawable, userHandle, rect, i);
    }

    @Override // android.content.pm.PackageManager
    public CharSequence getUserBadgedLabel(CharSequence charSequence, UserHandle userHandle) {
        return this.mBase.getUserBadgedLabel(charSequence, userHandle);
    }

    @Override // android.content.pm.PackageManager
    public CharSequence getText(String str, int i, ApplicationInfo applicationInfo) {
        return this.mBase.getText(str, i, applicationInfo);
    }

    @Override // android.content.pm.PackageManager
    public XmlResourceParser getXml(String str, int i, ApplicationInfo applicationInfo) {
        return this.mBase.getXml(str, i, applicationInfo);
    }

    @Override // android.content.pm.PackageManager
    public CharSequence getApplicationLabel(ApplicationInfo applicationInfo) {
        return this.mBase.getApplicationLabel(applicationInfo);
    }

    @Override // android.content.pm.PackageManager
    public Resources getResourcesForActivity(ComponentName componentName) throws PackageManager.NameNotFoundException {
        return this.mBase.getResourcesForActivity(componentName);
    }

    @Override // android.content.pm.PackageManager
    public Resources getResourcesForApplication(ApplicationInfo applicationInfo) throws PackageManager.NameNotFoundException {
        return this.mBase.getResourcesForApplication(applicationInfo);
    }

    @Override // android.content.pm.PackageManager
    public Resources getResourcesForApplication(String str) throws PackageManager.NameNotFoundException {
        return this.mBase.getResourcesForApplication(str);
    }

    @Override // android.content.pm.PackageManager
    public PackageInfo getPackageArchiveInfo(String str, int i) {
        return this.mBase.getPackageArchiveInfo(str, i);
    }

    @Override // android.content.pm.PackageManager
    public void verifyPendingInstall(int i, int i2) {
        this.mBase.verifyPendingInstall(i, i2);
    }

    @Override // android.content.pm.PackageManager
    public void extendVerificationTimeout(int i, int i2, long j) {
        this.mBase.extendVerificationTimeout(i, i2, j);
    }

    @Override // android.content.pm.PackageManager
    public void setInstallerPackageName(String str, String str2) {
        this.mBase.setInstallerPackageName(str, str2);
    }

    @Override // android.content.pm.PackageManager
    public String getInstallerPackageName(String str) {
        return this.mBase.getInstallerPackageName(str);
    }

    @Override // android.content.pm.PackageManager
    public void addPackageToPreferred(String str) {
        this.mBase.addPackageToPreferred(str);
    }

    @Override // android.content.pm.PackageManager
    public void removePackageFromPreferred(String str) {
        this.mBase.removePackageFromPreferred(str);
    }

    @Override // android.content.pm.PackageManager
    public List<PackageInfo> getPreferredPackages(int i) {
        return this.mBase.getPreferredPackages(i);
    }

    @Override // android.content.pm.PackageManager
    public void addPreferredActivity(IntentFilter intentFilter, int i, ComponentName[] componentNameArr, ComponentName componentName) {
        this.mBase.addPreferredActivity(intentFilter, i, componentNameArr, componentName);
    }

    @Override // android.content.pm.PackageManager
    public void clearPackagePreferredActivities(String str) {
        this.mBase.clearPackagePreferredActivities(str);
    }

    @Override // android.content.pm.PackageManager
    public int getPreferredActivities(List<IntentFilter> list, List<ComponentName> list2, String str) {
        return this.mBase.getPreferredActivities(list, list2, str);
    }

    @Override // android.content.pm.PackageManager
    public void setComponentEnabledSetting(ComponentName componentName, int i, int i2) {
        this.mBase.setComponentEnabledSetting(componentName, i, i2);
    }

    @Override // android.content.pm.PackageManager
    public int getComponentEnabledSetting(ComponentName componentName) {
        return this.mBase.getComponentEnabledSetting(componentName);
    }

    @Override // android.content.pm.PackageManager
    public void setApplicationEnabledSetting(String str, int i, int i2) {
        this.mBase.setApplicationEnabledSetting(str, i, i2);
    }

    @Override // android.content.pm.PackageManager
    public int getApplicationEnabledSetting(String str) {
        return this.mBase.getApplicationEnabledSetting(str);
    }

    @Override // android.content.pm.PackageManager
    public boolean isSafeMode() {
        return this.mBase.isSafeMode();
    }

    @Override // android.content.pm.PackageManager
    public void setApplicationCategoryHint(String str, int i) {
        this.mBase.setApplicationCategoryHint(str, i);
    }

    @Override // android.content.pm.PackageManager
    public PackageInstaller getPackageInstaller() {
        return this.mBase.getPackageInstaller();
    }

    @Override // android.content.pm.PackageManager
    public boolean canRequestPackageInstalls() {
        return this.mBase.canRequestPackageInstalls();
    }

    PackageManagerWrapper(PackageManager packageManager) {
        this.mBase = packageManager;
    }
}
