package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class ImageHeaderParserUtils {
    private static final int MARK_READ_LIMIT = 5242880;

    private interface OrientationReader {
        int getOrientation(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    private interface TypeReader {
        ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    private ImageHeaderParserUtils() {
    }

    public static ImageHeaderParser.ImageType getType(List<ImageHeaderParser> list, final InputStream inputStream, ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(5242880);
        return getTypeInternal(list, new TypeReader() {
            /* class com.bumptech.glide.load.ImageHeaderParserUtils.AnonymousClass1 */

            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
            public ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException {
                try {
                    return imageHeaderParser.getType(inputStream);
                } finally {
                    inputStream.reset();
                }
            }
        });
    }

    public static ImageHeaderParser.ImageType getType(List<ImageHeaderParser> list, final ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        return getTypeInternal(list, new TypeReader() {
            /* class com.bumptech.glide.load.ImageHeaderParserUtils.AnonymousClass2 */

            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
            public ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException {
                return imageHeaderParser.getType(byteBuffer);
            }
        });
    }

    public static ImageHeaderParser.ImageType getType(List<ImageHeaderParser> list, final ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, final ArrayPool arrayPool) throws IOException {
        return getTypeInternal(list, new TypeReader() {
            /* class com.bumptech.glide.load.ImageHeaderParserUtils.AnonymousClass3 */

            /* JADX WARNING: Removed duplicated region for block: B:14:0x002a A[SYNTHETIC, Splitter:B:14:0x002a] */
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
            public ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException {
                Throwable th;
                RecyclableBufferedInputStream recyclableBufferedInputStream = null;
                try {
                    RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(ParcelFileDescriptorRewinder.this.rewindAndGet().getFileDescriptor()), arrayPool);
                    try {
                        ImageHeaderParser.ImageType type = imageHeaderParser.getType(recyclableBufferedInputStream2);
                        try {
                            recyclableBufferedInputStream2.close();
                        } catch (IOException unused) {
                        }
                        ParcelFileDescriptorRewinder.this.rewindAndGet();
                        return type;
                    } catch (Throwable th2) {
                        th = th2;
                        recyclableBufferedInputStream = recyclableBufferedInputStream2;
                        if (recyclableBufferedInputStream != null) {
                            try {
                                recyclableBufferedInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        ParcelFileDescriptorRewinder.this.rewindAndGet();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (recyclableBufferedInputStream != null) {
                    }
                    ParcelFileDescriptorRewinder.this.rewindAndGet();
                    throw th;
                }
            }
        });
    }

    private static ImageHeaderParser.ImageType getTypeInternal(List<ImageHeaderParser> list, TypeReader typeReader) throws IOException {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ImageHeaderParser.ImageType type = typeReader.getType(list.get(i));
            if (type != ImageHeaderParser.ImageType.UNKNOWN) {
                return type;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public static int getOrientation(List<ImageHeaderParser> list, final InputStream inputStream, final ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(5242880);
        return getOrientationInternal(list, new OrientationReader() {
            /* class com.bumptech.glide.load.ImageHeaderParserUtils.AnonymousClass4 */

            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader
            public int getOrientation(ImageHeaderParser imageHeaderParser) throws IOException {
                try {
                    return imageHeaderParser.getOrientation(inputStream, arrayPool);
                } finally {
                    inputStream.reset();
                }
            }
        });
    }

    public static int getOrientation(List<ImageHeaderParser> list, final ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, final ArrayPool arrayPool) throws IOException {
        return getOrientationInternal(list, new OrientationReader() {
            /* class com.bumptech.glide.load.ImageHeaderParserUtils.AnonymousClass5 */

            /* JADX WARNING: Removed duplicated region for block: B:14:0x002c A[SYNTHETIC, Splitter:B:14:0x002c] */
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader
            public int getOrientation(ImageHeaderParser imageHeaderParser) throws IOException {
                Throwable th;
                RecyclableBufferedInputStream recyclableBufferedInputStream = null;
                try {
                    RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(ParcelFileDescriptorRewinder.this.rewindAndGet().getFileDescriptor()), arrayPool);
                    try {
                        int orientation = imageHeaderParser.getOrientation(recyclableBufferedInputStream2, arrayPool);
                        try {
                            recyclableBufferedInputStream2.close();
                        } catch (IOException unused) {
                        }
                        ParcelFileDescriptorRewinder.this.rewindAndGet();
                        return orientation;
                    } catch (Throwable th2) {
                        th = th2;
                        recyclableBufferedInputStream = recyclableBufferedInputStream2;
                        if (recyclableBufferedInputStream != null) {
                            try {
                                recyclableBufferedInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        ParcelFileDescriptorRewinder.this.rewindAndGet();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (recyclableBufferedInputStream != null) {
                    }
                    ParcelFileDescriptorRewinder.this.rewindAndGet();
                    throw th;
                }
            }
        });
    }

    private static int getOrientationInternal(List<ImageHeaderParser> list, OrientationReader orientationReader) throws IOException {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int orientation = orientationReader.getOrientation(list.get(i));
            if (orientation != -1) {
                return orientation;
            }
        }
        return -1;
    }
}
