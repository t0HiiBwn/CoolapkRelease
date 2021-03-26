package com.soundcloud.android.crop;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.opengl.GLES10;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.soundcloud.android.crop.ImageViewTouchBase;
import com.soundcloud.android.crop.MonitoredActivity;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.CountDownLatch;

public class CropImageActivity extends MonitoredActivity {
    private static final int SIZE_DEFAULT = 2048;
    private static final int SIZE_LIMIT = 4096;
    private int aspectX;
    private int aspectY;
    private HighlightView cropView;
    private int exifRotation;
    private final Handler handler = new Handler();
    private CropImageView imageView;
    private boolean isSaving;
    private int maxX;
    private int maxY;
    private RotateBitmap rotateBitmap;
    private int sampleSize;
    private Uri saveUri;
    private Uri sourceUri;

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        return false;
    }

    @Override // com.soundcloud.android.crop.MonitoredActivity
    public /* bridge */ /* synthetic */ void addLifeCycleListener(MonitoredActivity.LifeCycleListener lifeCycleListener) {
        super.addLifeCycleListener(lifeCycleListener);
    }

    @Override // com.soundcloud.android.crop.MonitoredActivity
    public /* bridge */ /* synthetic */ void removeLifeCycleListener(MonitoredActivity.LifeCycleListener lifeCycleListener) {
        super.removeLifeCycleListener(lifeCycleListener);
    }

    @Override // com.soundcloud.android.crop.MonitoredActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupWindowFlags();
        setupViews();
        loadInput();
        if (this.rotateBitmap == null) {
            finish();
        } else {
            startCrop();
        }
    }

    private void setupWindowFlags() {
        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().clearFlags(67108864);
        }
    }

    private void setupViews() {
        setContentView(R.layout.crop__activity_crop);
        CropImageView cropImageView = (CropImageView) findViewById(R.id.crop_image);
        this.imageView = cropImageView;
        cropImageView.context = this;
        this.imageView.setRecycler(new ImageViewTouchBase.Recycler() {
            /* class com.soundcloud.android.crop.CropImageActivity.AnonymousClass1 */

            @Override // com.soundcloud.android.crop.ImageViewTouchBase.Recycler
            public void recycle(Bitmap bitmap) {
                bitmap.recycle();
                System.gc();
            }
        });
        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            /* class com.soundcloud.android.crop.CropImageActivity.AnonymousClass2 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CropImageActivity.this.setResult(0);
                CropImageActivity.this.finish();
            }
        });
        findViewById(R.id.btn_done).setOnClickListener(new View.OnClickListener() {
            /* class com.soundcloud.android.crop.CropImageActivity.AnonymousClass3 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CropImageActivity.this.onSaveClicked();
            }
        });
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:6:0x004d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.Context, com.soundcloud.android.crop.CropImageActivity] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARNING: Unknown variable types count: 2 */
    private void loadInput() {
        ?? r1;
        Throwable th;
        ?? r12;
        Object obj;
        IOException e;
        OutOfMemoryError e2;
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            this.aspectX = extras.getInt("aspect_x");
            this.aspectY = extras.getInt("aspect_y");
            this.maxX = extras.getInt("max_x");
            this.maxY = extras.getInt("max_y");
            this.saveUri = (Uri) extras.getParcelable("output");
        }
        Uri data = intent.getData();
        this.sourceUri = data;
        if (data != null) {
            ContentResolver contentResolver = getContentResolver();
            Uri uri = this.sourceUri;
            this.exifRotation = CropUtil.getExifRotation(CropUtil.getFromMediaUri(this, contentResolver, uri));
            try {
                this.sampleSize = calculateBitmapSampleSize(this.sourceUri);
                InputStream openInputStream = getContentResolver().openInputStream(this.sourceUri);
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.sampleSize;
                    this.rotateBitmap = new RotateBitmap(BitmapFactory.decodeStream(openInputStream, null, options), this.exifRotation);
                    r12 = openInputStream;
                } catch (IOException e3) {
                    e = e3;
                    obj = openInputStream;
                } catch (OutOfMemoryError e4) {
                    e2 = e4;
                    uri = openInputStream;
                    Log.e("OOM reading image: " + e2.getMessage(), e2);
                    setResultException(e2);
                    r12 = uri;
                    CropUtil.closeSilently(r12);
                }
            } catch (IOException e5) {
                obj = null;
                e = e5;
                Log.e("Error reading image: " + e.getMessage(), e);
                setResultException(e);
                r12 = obj;
                CropUtil.closeSilently(r12);
            } catch (OutOfMemoryError e6) {
                uri = null;
                e2 = e6;
                Log.e("OOM reading image: " + e2.getMessage(), e2);
                setResultException(e2);
                r12 = uri;
                CropUtil.closeSilently(r12);
            } catch (Throwable th2) {
                th = th2;
                r1 = uri;
                CropUtil.closeSilently(r1);
                throw th;
            }
            CropUtil.closeSilently(r12);
        }
    }

    private int calculateBitmapSampleSize(Uri uri) throws IOException {
        Throwable th;
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i = 1;
        options.inJustDecodeBounds = true;
        InputStream inputStream = null;
        try {
            InputStream openInputStream = getContentResolver().openInputStream(uri);
            try {
                BitmapFactory.decodeStream(openInputStream, null, options);
                CropUtil.closeSilently(openInputStream);
                int maxImageSize = getMaxImageSize();
                while (true) {
                    if (options.outHeight / i <= maxImageSize && options.outWidth / i <= maxImageSize) {
                        return i;
                    }
                    i <<= 1;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = openInputStream;
                CropUtil.closeSilently(inputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            CropUtil.closeSilently(inputStream);
            throw th;
        }
    }

    private int getMaxImageSize() {
        int maxTextureSize = getMaxTextureSize();
        if (maxTextureSize == 0) {
            return 2048;
        }
        return Math.min(maxTextureSize, 4096);
    }

    private int getMaxTextureSize() {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        return iArr[0];
    }

    private void startCrop() {
        if (!isFinishing()) {
            this.imageView.setImageRotateBitmapResetBase(this.rotateBitmap, true);
            CropUtil.startBackgroundJob(this, null, getResources().getString(R.string.crop__wait), new Runnable() {
                /* class com.soundcloud.android.crop.CropImageActivity.AnonymousClass4 */

                @Override // java.lang.Runnable
                public void run() {
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    CropImageActivity.this.handler.post(new Runnable() {
                        /* class com.soundcloud.android.crop.CropImageActivity.AnonymousClass4.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            if (CropImageActivity.this.imageView.getScale() == 1.0f) {
                                CropImageActivity.this.imageView.center();
                            }
                            countDownLatch.countDown();
                        }
                    });
                    try {
                        countDownLatch.await();
                        new Cropper().crop();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }, this.handler);
        }
    }

    private class Cropper {
        private Cropper() {
        }

        /* access modifiers changed from: private */
        public void makeDefault() {
            int i;
            if (CropImageActivity.this.rotateBitmap != null) {
                HighlightView highlightView = new HighlightView(CropImageActivity.this.imageView);
                int width = CropImageActivity.this.rotateBitmap.getWidth();
                int height = CropImageActivity.this.rotateBitmap.getHeight();
                boolean z = false;
                Rect rect = new Rect(0, 0, width, height);
                int min = (Math.min(width, height) * 4) / 5;
                if (CropImageActivity.this.aspectX == 0 || CropImageActivity.this.aspectY == 0) {
                    i = min;
                } else if (CropImageActivity.this.aspectX > CropImageActivity.this.aspectY) {
                    i = (CropImageActivity.this.aspectY * min) / CropImageActivity.this.aspectX;
                } else {
                    i = min;
                    min = (CropImageActivity.this.aspectX * min) / CropImageActivity.this.aspectY;
                }
                int i2 = (width - min) / 2;
                int i3 = (height - i) / 2;
                RectF rectF = new RectF((float) i2, (float) i3, (float) (i2 + min), (float) (i3 + i));
                Matrix unrotatedMatrix = CropImageActivity.this.imageView.getUnrotatedMatrix();
                if (!(CropImageActivity.this.aspectX == 0 || CropImageActivity.this.aspectY == 0)) {
                    z = true;
                }
                highlightView.setup(unrotatedMatrix, rect, rectF, z);
                CropImageActivity.this.imageView.add(highlightView);
            }
        }

        public void crop() {
            CropImageActivity.this.handler.post(new Runnable() {
                /* class com.soundcloud.android.crop.CropImageActivity.Cropper.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    Cropper.this.makeDefault();
                    CropImageActivity.this.imageView.invalidate();
                    if (CropImageActivity.this.imageView.highlightViews.size() == 1) {
                        CropImageActivity.this.cropView = CropImageActivity.this.imageView.highlightViews.get(0);
                        CropImageActivity.this.cropView.setFocus(true);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void onSaveClicked() {
        int i;
        HighlightView highlightView = this.cropView;
        if (highlightView != null && !this.isSaving) {
            this.isSaving = true;
            Rect scaledCropRect = highlightView.getScaledCropRect((float) this.sampleSize);
            int width = scaledCropRect.width();
            int height = scaledCropRect.height();
            int i2 = this.maxX;
            if (i2 > 0 && (i = this.maxY) > 0 && (width > i2 || height > i)) {
                float f = ((float) width) / ((float) height);
                if (((float) i2) / ((float) i) > f) {
                    width = (int) ((((float) i) * f) + 0.5f);
                    height = i;
                } else {
                    height = (int) ((((float) i2) / f) + 0.5f);
                    width = i2;
                }
            }
            try {
                Bitmap decodeRegionCrop = decodeRegionCrop(scaledCropRect, width, height);
                if (decodeRegionCrop != null) {
                    this.imageView.setImageRotateBitmapResetBase(new RotateBitmap(decodeRegionCrop, this.exifRotation), true);
                    this.imageView.center();
                    this.imageView.highlightViews.clear();
                }
                saveImage(decodeRegionCrop);
            } catch (IllegalArgumentException e) {
                setResultException(e);
                finish();
            }
        }
    }

    private void saveImage(final Bitmap bitmap) {
        if (bitmap != null) {
            CropUtil.startBackgroundJob(this, null, getResources().getString(R.string.crop__saving), new Runnable() {
                /* class com.soundcloud.android.crop.CropImageActivity.AnonymousClass5 */

                @Override // java.lang.Runnable
                public void run() {
                    CropImageActivity.this.saveOutput(bitmap);
                }
            }, this.handler);
        } else {
            finish();
        }
    }

    private Bitmap decodeRegionCrop(Rect rect, int i, int i2) {
        Throwable th;
        Bitmap bitmap;
        IOException iOException;
        OutOfMemoryError outOfMemoryError;
        Rect rect2;
        clearImageView();
        InputStream inputStream = null;
        try {
            InputStream openInputStream = getContentResolver().openInputStream(this.sourceUri);
            try {
                BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(openInputStream, false);
                int width = newInstance.getWidth();
                int height = newInstance.getHeight();
                if (this.exifRotation != 0) {
                    Matrix matrix = new Matrix();
                    matrix.setRotate((float) (-this.exifRotation));
                    RectF rectF = new RectF();
                    matrix.mapRect(rectF, new RectF(rect));
                    float f = 0.0f;
                    float f2 = rectF.left < 0.0f ? (float) width : 0.0f;
                    if (rectF.top < 0.0f) {
                        f = (float) height;
                    }
                    rectF.offset(f2, f);
                    rect2 = new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                } else {
                    rect2 = rect;
                }
                try {
                    Bitmap decodeRegion = newInstance.decodeRegion(rect2, new BitmapFactory.Options());
                    if (rect2.width() > i || rect2.height() > i2) {
                        Matrix matrix2 = new Matrix();
                        matrix2.postScale(((float) i) / ((float) rect2.width()), ((float) i2) / ((float) rect2.height()));
                        decodeRegion = Bitmap.createBitmap(decodeRegion, 0, 0, decodeRegion.getWidth(), decodeRegion.getHeight(), matrix2, true);
                    }
                    CropUtil.closeSilently(openInputStream);
                    return decodeRegion;
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Rectangle " + rect2 + " is outside of the image (" + width + "," + height + "," + this.exifRotation + ")", e);
                }
            } catch (IOException e2) {
                iOException = e2;
                bitmap = null;
                inputStream = openInputStream;
                Log.e("Error cropping image: " + iOException.getMessage(), iOException);
                setResultException(iOException);
                CropUtil.closeSilently(inputStream);
                return bitmap;
            } catch (OutOfMemoryError e3) {
                outOfMemoryError = e3;
                bitmap = null;
                inputStream = openInputStream;
                Log.e("OOM cropping image: " + outOfMemoryError.getMessage(), outOfMemoryError);
                setResultException(outOfMemoryError);
                CropUtil.closeSilently(inputStream);
                return bitmap;
            } catch (Throwable th2) {
                th = th2;
                inputStream = openInputStream;
                CropUtil.closeSilently(inputStream);
                throw th;
            }
        } catch (IOException e4) {
            iOException = e4;
            bitmap = null;
            Log.e("Error cropping image: " + iOException.getMessage(), iOException);
            setResultException(iOException);
            CropUtil.closeSilently(inputStream);
            return bitmap;
        } catch (OutOfMemoryError e5) {
            outOfMemoryError = e5;
            bitmap = null;
            Log.e("OOM cropping image: " + outOfMemoryError.getMessage(), outOfMemoryError);
            setResultException(outOfMemoryError);
            CropUtil.closeSilently(inputStream);
            return bitmap;
        } catch (Throwable th3) {
            th = th3;
            CropUtil.closeSilently(inputStream);
            throw th;
        }
    }

    private void clearImageView() {
        this.imageView.clear();
        RotateBitmap rotateBitmap2 = this.rotateBitmap;
        if (rotateBitmap2 != null) {
            rotateBitmap2.recycle();
        }
        System.gc();
    }

    /* access modifiers changed from: private */
    public void saveOutput(final Bitmap bitmap) {
        if (this.saveUri != null) {
            OutputStream outputStream = null;
            try {
                outputStream = getContentResolver().openOutputStream(this.saveUri);
                if (outputStream != null) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream);
                }
            } catch (IOException e) {
                setResultException(e);
                Log.e("Cannot open file: " + this.saveUri, e);
            } catch (Throwable th) {
                CropUtil.closeSilently(null);
                throw th;
            }
            CropUtil.closeSilently(outputStream);
            CropUtil.copyExifRotation(CropUtil.getFromMediaUri(this, getContentResolver(), this.sourceUri), CropUtil.getFromMediaUri(this, getContentResolver(), this.saveUri));
            setResultUri(this.saveUri);
        }
        this.handler.post(new Runnable() {
            /* class com.soundcloud.android.crop.CropImageActivity.AnonymousClass6 */

            @Override // java.lang.Runnable
            public void run() {
                CropImageActivity.this.imageView.clear();
                bitmap.recycle();
            }
        });
        finish();
    }

    @Override // com.soundcloud.android.crop.MonitoredActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        RotateBitmap rotateBitmap2 = this.rotateBitmap;
        if (rotateBitmap2 != null) {
            rotateBitmap2.recycle();
        }
    }

    public boolean isSaving() {
        return this.isSaving;
    }

    private void setResultUri(Uri uri) {
        setResult(-1, new Intent().putExtra("output", uri));
    }

    private void setResultException(Throwable th) {
        setResult(404, new Intent().putExtra("error", th));
    }
}
