package me.zhanghai.android.appiconloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.UserHandle;
import java.util.concurrent.ConcurrentLinkedQueue;
import me.zhanghai.android.appiconloader.iconloaderlib.BaseIconFactory;
import me.zhanghai.android.appiconloader.iconloaderlib.BitmapInfo;

public class AppIconLoader {
    private final Context mContext;
    private final ConcurrentLinkedQueue<IconFactory> mIconFactoryPool = new ConcurrentLinkedQueue<>();
    private final int mIconSize;
    private final boolean mShrinkNonAdaptiveIcons;

    static {
        MiuiAdaptiveIconDrawableFix.apply();
    }

    public AppIconLoader(int i, boolean z, Context context) {
        this.mIconSize = i;
        this.mShrinkNonAdaptiveIcons = z;
        this.mContext = context;
    }

    public static String getIconKey(ApplicationInfo applicationInfo, long j, Context context) {
        UserHandle userHandleForUid = UserHandleCompat.getUserHandleForUid(applicationInfo.uid);
        return applicationInfo.packageName + ":" + j + ":" + UserSerialNumberCache.getSerialNumber(userHandleForUid, context);
    }

    public static String getIconKey(PackageInfo packageInfo, Context context) {
        return getIconKey(packageInfo.applicationInfo, PackageInfoCompat.getLongVersionCode(packageInfo), context);
    }

    public Bitmap loadIcon(ApplicationInfo applicationInfo, boolean z) {
        Drawable loadUnbadgedIcon = PackageItemInfoCompat.loadUnbadgedIcon(applicationInfo, this.mContext.getPackageManager());
        UserHandle userHandleForUid = UserHandleCompat.getUserHandleForUid(applicationInfo.uid);
        IconFactory poll = this.mIconFactoryPool.poll();
        if (poll == null) {
            poll = new IconFactory(this.mIconSize, this.mContext);
        }
        try {
            return poll.createBadgedIconBitmap(loadUnbadgedIcon, userHandleForUid, this.mShrinkNonAdaptiveIcons, z).icon;
        } finally {
            this.mIconFactoryPool.offer(poll);
        }
    }

    public Bitmap loadIcon(ApplicationInfo applicationInfo) {
        return loadIcon(applicationInfo, false);
    }

    private static class IconFactory extends BaseIconFactory {
        private final float[] mTempScale = new float[1];

        public IconFactory(int i, Context context) {
            super(context, context.getResources().getConfiguration().densityDpi, i, true);
        }

        public BitmapInfo createBadgedIconBitmap(Drawable drawable, UserHandle userHandle, boolean z, boolean z2) {
            return super.createBadgedIconBitmap(drawable, userHandle, z, z2, this.mTempScale);
        }
    }
}
