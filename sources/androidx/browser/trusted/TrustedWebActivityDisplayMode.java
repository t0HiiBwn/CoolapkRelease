package androidx.browser.trusted;

import android.os.Bundle;

public interface TrustedWebActivityDisplayMode {
    public static final String KEY_ID = "androidx.browser.trusted.displaymode.KEY_ID";

    Bundle toBundle();

    /* renamed from: androidx.browser.trusted.TrustedWebActivityDisplayMode$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static TrustedWebActivityDisplayMode fromBundle(Bundle bundle) {
            if (bundle.getInt("androidx.browser.trusted.displaymode.KEY_ID") != 1) {
                return new DefaultMode();
            }
            return ImmersiveMode.fromBundle(bundle);
        }
    }

    public static class DefaultMode implements TrustedWebActivityDisplayMode {
        private static final int ID = 0;

        @Override // androidx.browser.trusted.TrustedWebActivityDisplayMode
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt("androidx.browser.trusted.displaymode.KEY_ID", 0);
            return bundle;
        }
    }

    public static class ImmersiveMode implements TrustedWebActivityDisplayMode {
        private static final int ID = 1;
        public static final String KEY_CUTOUT_MODE = "androidx.browser.trusted.displaymode.KEY_CUTOUT_MODE";
        public static final String KEY_STICKY = "androidx.browser.trusted.displaymode.KEY_STICKY";
        private final boolean mIsSticky;
        private final int mLayoutInDisplayCutoutMode;

        public ImmersiveMode(boolean z, int i) {
            this.mIsSticky = z;
            this.mLayoutInDisplayCutoutMode = i;
        }

        static TrustedWebActivityDisplayMode fromBundle(Bundle bundle) {
            return new ImmersiveMode(bundle.getBoolean("androidx.browser.trusted.displaymode.KEY_STICKY"), bundle.getInt("androidx.browser.trusted.displaymode.KEY_CUTOUT_MODE"));
        }

        @Override // androidx.browser.trusted.TrustedWebActivityDisplayMode
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt("androidx.browser.trusted.displaymode.KEY_ID", 1);
            bundle.putBoolean("androidx.browser.trusted.displaymode.KEY_STICKY", this.mIsSticky);
            bundle.putInt("androidx.browser.trusted.displaymode.KEY_CUTOUT_MODE", this.mLayoutInDisplayCutoutMode);
            return bundle;
        }

        public boolean isSticky() {
            return this.mIsSticky;
        }

        public int layoutInDisplayCutoutMode() {
            return this.mLayoutInDisplayCutoutMode;
        }
    }
}
