package androidx.core.widget;

import android.os.Build;

public interface AutoSizeableTextView {
    public static final boolean PLATFORM_SUPPORTS_AUTOSIZE = (Build.VERSION.SDK_INT >= 27);

    @Override // androidx.core.widget.AutoSizeableTextView
    int getAutoSizeMaxTextSize();

    @Override // androidx.core.widget.AutoSizeableTextView
    int getAutoSizeMinTextSize();

    @Override // androidx.core.widget.AutoSizeableTextView
    int getAutoSizeStepGranularity();

    @Override // androidx.core.widget.AutoSizeableTextView
    int[] getAutoSizeTextAvailableSizes();

    @Override // androidx.core.widget.AutoSizeableTextView
    int getAutoSizeTextType();

    @Override // androidx.core.widget.AutoSizeableTextView
    void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) throws IllegalArgumentException;

    @Override // androidx.core.widget.AutoSizeableTextView
    void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) throws IllegalArgumentException;

    @Override // androidx.core.widget.AutoSizeableTextView
    void setAutoSizeTextTypeWithDefaults(int i);
}
