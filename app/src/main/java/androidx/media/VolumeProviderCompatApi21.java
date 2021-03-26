package androidx.media;

import android.media.VolumeProvider;

class VolumeProviderCompatApi21 {

    public interface Delegate {
        void onAdjustVolume(int i);

        void onSetVolumeTo(int i);
    }

    public static Object createVolumeProvider(int i, int i2, int i3, final Delegate delegate) {
        return new VolumeProvider(i, i2, i3) {
            /* class androidx.media.VolumeProviderCompatApi21.AnonymousClass1 */

            @Override // android.media.VolumeProvider
            public void onSetVolumeTo(int i) {
                delegate.onSetVolumeTo(i);
            }

            @Override // android.media.VolumeProvider
            public void onAdjustVolume(int i) {
                delegate.onAdjustVolume(i);
            }
        };
    }

    public static void setCurrentVolume(Object obj, int i) {
        ((VolumeProvider) obj).setCurrentVolume(i);
    }

    private VolumeProviderCompatApi21() {
    }
}
