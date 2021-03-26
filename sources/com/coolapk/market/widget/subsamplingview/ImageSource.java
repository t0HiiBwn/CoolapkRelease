package com.coolapk.market.widget.subsamplingview;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Objects;

public final class ImageSource {
    static final String ASSET_SCHEME = "file:///android_asset/";
    static final String FILE_SCHEME = "file:///";
    private final Bitmap bitmap;
    private boolean cached;
    private final Integer resource;
    private int sHeight;
    private Rect sRegion;
    private int sWidth;
    private boolean tile;
    private final Uri uri;

    private ImageSource(Bitmap bitmap2, boolean z) {
        this.bitmap = bitmap2;
        this.uri = null;
        this.resource = null;
        this.tile = false;
        this.sWidth = bitmap2.getWidth();
        this.sHeight = bitmap2.getHeight();
        this.cached = z;
    }

    private ImageSource(Uri uri2) {
        String uri3 = uri2.toString();
        if (uri3.startsWith("file:///") && !new File(uri3.substring(7)).exists()) {
            try {
                uri2 = Uri.parse(URLDecoder.decode(uri3, "UTF-8"));
            } catch (UnsupportedEncodingException unused) {
            }
        }
        this.bitmap = null;
        this.uri = uri2;
        this.resource = null;
        this.tile = true;
    }

    private ImageSource(int i) {
        this.bitmap = null;
        this.uri = null;
        this.resource = Integer.valueOf(i);
        this.tile = true;
    }

    public static ImageSource resource(int i) {
        return new ImageSource(i);
    }

    public static ImageSource asset(String str) {
        Objects.requireNonNull(str, "Asset name must not be null");
        return uri("file:///android_asset/" + str);
    }

    public static ImageSource uri(String str) {
        Objects.requireNonNull(str, "Uri must not be null");
        if (!str.contains("://")) {
            if (str.startsWith("/")) {
                str = str.substring(1);
            }
            str = "file:///" + str;
        }
        return new ImageSource(Uri.parse(str));
    }

    public static ImageSource uri(Uri uri2) {
        Objects.requireNonNull(uri2, "Uri must not be null");
        return new ImageSource(uri2);
    }

    public static ImageSource bitmap(Bitmap bitmap2) {
        Objects.requireNonNull(bitmap2, "Bitmap must not be null");
        return new ImageSource(bitmap2, false);
    }

    public static ImageSource cachedBitmap(Bitmap bitmap2) {
        Objects.requireNonNull(bitmap2, "Bitmap must not be null");
        return new ImageSource(bitmap2, true);
    }

    public ImageSource tilingEnabled() {
        return tiling(true);
    }

    public ImageSource tilingDisabled() {
        return tiling(false);
    }

    public ImageSource tiling(boolean z) {
        this.tile = z;
        return this;
    }

    public ImageSource region(Rect rect) {
        this.sRegion = rect;
        setInvariants();
        return this;
    }

    public ImageSource dimensions(int i, int i2) {
        if (this.bitmap == null) {
            this.sWidth = i;
            this.sHeight = i2;
        }
        setInvariants();
        return this;
    }

    private void setInvariants() {
        Rect rect = this.sRegion;
        if (rect != null) {
            this.tile = true;
            this.sWidth = rect.width();
            this.sHeight = this.sRegion.height();
        }
    }

    protected final Uri getUri() {
        return this.uri;
    }

    protected final Bitmap getBitmap() {
        return this.bitmap;
    }

    protected final Integer getResource() {
        return this.resource;
    }

    protected final boolean getTile() {
        return this.tile;
    }

    protected final int getSWidth() {
        return this.sWidth;
    }

    protected final int getSHeight() {
        return this.sHeight;
    }

    protected final Rect getSRegion() {
        return this.sRegion;
    }

    protected final boolean isCached() {
        return this.cached;
    }
}
