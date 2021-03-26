package cn.bertsir.zbar;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import cn.bertsir.zbar.Qr.Image;
import cn.bertsir.zbar.Qr.ImageScanner;
import cn.bertsir.zbar.Qr.ScanResult;
import cn.bertsir.zbar.Qr.Symbol;
import cn.bertsir.zbar.utils.QRUtils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.datamatrix.detector.Detector;
import com.google.zxing.qrcode.QRCodeReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CameraScanAnalysis implements Camera.PreviewCallback {
    private static final String TAG = "CameraScanAnalysis";
    private boolean allowAnalysis = true;
    private Image barcode;
    private Camera camera;
    private Context context;
    private int cropHeight;
    private int cropWidth;
    private byte[] data;
    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private long lastResultTime = 0;
    private Runnable mAnalysisTask = new Runnable() {
        /* class cn.bertsir.zbar.CameraScanAnalysis.AnonymousClass2 */

        @Override // java.lang.Runnable
        public void run() {
            if (Symbol.is_auto_zoom && Symbol.scanType == 1 && QRUtils.getInstance().isScreenOriatationPortrait(CameraScanAnalysis.this.context)) {
                if (!Symbol.is_only_scan_center || !(Symbol.cropX == 0 || Symbol.cropY == 0 || CameraScanAnalysis.this.cropWidth == 0 || CameraScanAnalysis.this.cropHeight == 0)) {
                    try {
                        ResultPoint[] points = new Detector(new BinaryBitmap(new HybridBinarizer(new PlanarYUVLuminanceSource(CameraScanAnalysis.this.data, CameraScanAnalysis.this.size.width, CameraScanAnalysis.this.size.height, Symbol.cropX, Symbol.cropY, CameraScanAnalysis.this.cropWidth, CameraScanAnalysis.this.cropHeight, true))).getBlackMatrix()).detect().getPoints();
                        float x = points[0].getX();
                        float y = points[0].getY();
                        float x2 = x - points[1].getX();
                        float y2 = y - points[1].getY();
                        int sqrt = (int) Math.sqrt((double) ((Math.abs(x2) * Math.abs(x2)) + (Math.abs(y2) * Math.abs(y2))));
                        if (sqrt < CameraScanAnalysis.this.cropWidth / 4 && sqrt > 10) {
                            CameraScanAnalysis cameraScanAnalysis = CameraScanAnalysis.this;
                            cameraScanAnalysis.cameraZoom(cameraScanAnalysis.camera);
                        }
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                } else {
                    return;
                }
            }
            String str = null;
            int i = -1;
            if (CameraScanAnalysis.this.mImageScanner.scanImage(CameraScanAnalysis.this.barcode) != 0) {
                Iterator<Symbol> it2 = CameraScanAnalysis.this.mImageScanner.getResults().iterator();
                while (it2.hasNext()) {
                    Symbol next = it2.next();
                    String data = next.getData();
                    i = next.getType();
                    str = data;
                }
            }
            if (!TextUtils.isEmpty(str)) {
                ScanResult scanResult = new ScanResult();
                scanResult.setContent(str);
                scanResult.setType(i == 64 ? 1 : 2);
                Message obtainMessage = CameraScanAnalysis.this.mHandler.obtainMessage();
                obtainMessage.obj = scanResult;
                obtainMessage.sendToTarget();
                CameraScanAnalysis.this.lastResultTime = System.currentTimeMillis();
                if (Symbol.looperScan) {
                    CameraScanAnalysis.this.allowAnalysis = true;
                }
            } else if (Symbol.doubleEngine) {
                CameraScanAnalysis cameraScanAnalysis2 = CameraScanAnalysis.this;
                cameraScanAnalysis2.decode(cameraScanAnalysis2.data, CameraScanAnalysis.this.size.width, CameraScanAnalysis.this.size.height);
            } else {
                CameraScanAnalysis.this.allowAnalysis = true;
            }
        }
    };
    private ScanCallback mCallback;
    private Handler mHandler;
    private ImageScanner mImageScanner;
    private MultiFormatReader multiFormatReader = new MultiFormatReader();
    private Camera.Size size;

    CameraScanAnalysis(Context context2) {
        this.context = context2;
        this.mImageScanner = new ImageScanner();
        if (Symbol.scanType == 1) {
            this.mImageScanner.setConfig(0, 0, 0);
            this.mImageScanner.setConfig(64, 0, 1);
        } else if (Symbol.scanType == 2) {
            this.mImageScanner.setConfig(0, 0, 0);
            this.mImageScanner.setConfig(128, 0, 1);
            this.mImageScanner.setConfig(39, 0, 1);
            this.mImageScanner.setConfig(13, 0, 1);
            this.mImageScanner.setConfig(8, 0, 1);
            this.mImageScanner.setConfig(12, 0, 1);
            this.mImageScanner.setConfig(9, 0, 1);
            this.mImageScanner.setConfig(9, 0, 1);
        } else if (Symbol.scanType == 3) {
            this.mImageScanner.setConfig(0, 256, 3);
            this.mImageScanner.setConfig(0, 257, 3);
        } else if (Symbol.scanType == 4) {
            this.mImageScanner.setConfig(0, 0, 0);
            this.mImageScanner.setConfig(Symbol.scanFormat, 0, 1);
        } else {
            this.mImageScanner.setConfig(0, 256, 3);
            this.mImageScanner.setConfig(0, 257, 3);
        }
        this.mHandler = new Handler(Looper.getMainLooper()) {
            /* class cn.bertsir.zbar.CameraScanAnalysis.AnonymousClass1 */

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (CameraScanAnalysis.this.mCallback != null) {
                    CameraScanAnalysis.this.mCallback.onScanResult((ScanResult) message.obj);
                }
            }
        };
    }

    void setScanCallback(ScanCallback scanCallback) {
        this.mCallback = scanCallback;
    }

    void onStop() {
        this.allowAnalysis = false;
    }

    void onStart() {
        this.allowAnalysis = true;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera2) {
        if (this.allowAnalysis) {
            this.allowAnalysis = false;
            this.data = bArr;
            this.camera = camera2;
            this.size = camera2.getParameters().getPreviewSize();
            Image image = new Image(this.size.width, this.size.height, "Y800");
            this.barcode = image;
            image.setData(bArr);
            if (Symbol.is_only_scan_center) {
                this.cropWidth = (int) (((float) Symbol.cropWidth) * (((float) this.size.height) / ((float) Symbol.screenWidth)));
                this.cropHeight = (int) (((float) Symbol.cropHeight) * (((float) this.size.width) / ((float) Symbol.screenHeight)));
                Symbol.cropX = (this.size.width / 2) - (this.cropHeight / 2);
                Symbol.cropY = (this.size.height / 2) - (this.cropWidth / 2);
                this.barcode.setCrop(Symbol.cropX, Symbol.cropY, this.cropHeight, this.cropWidth);
            } else {
                Symbol.cropX = 0;
                Symbol.cropY = 0;
                this.cropWidth = this.size.width;
                this.cropHeight = this.size.height;
            }
            if (!Symbol.looperScan || System.currentTimeMillis() - this.lastResultTime >= ((long) Symbol.looperWaitTime)) {
                this.executorService.execute(this.mAnalysisTask);
            } else {
                this.allowAnalysis = true;
            }
        }
    }

    public void cameraZoom(Camera camera2) {
        if (camera2 != null) {
            Camera.Parameters parameters = camera2.getParameters();
            if (parameters.isZoomSupported() && parameters.getMaxZoom() != 0 && parameters.getZoom() + 10 <= parameters.getMaxZoom()) {
                parameters.setZoom(parameters.getZoom() + 10);
                camera2.setParameters(parameters);
            }
        }
    }

    /* access modifiers changed from: private */
    public void decode(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                bArr2[(((i4 * i2) + i2) - i3) - 1] = bArr[(i3 * i) + i4];
            }
        }
        PlanarYUVLuminanceSource planarYUVLuminanceSource = new PlanarYUVLuminanceSource(bArr2, i2, i, 0, 0, i2, i, true);
        Hashtable hashtable = new Hashtable();
        hashtable.put(DecodeHintType.CHARACTER_SET, "utf-8");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new QRCodeReader());
        hashtable.put(DecodeHintType.POSSIBLE_FORMATS, arrayList);
        this.multiFormatReader.setHints(hashtable);
        try {
            Result decodeWithState = this.multiFormatReader.decodeWithState(new BinaryBitmap(new HybridBinarizer(planarYUVLuminanceSource)));
            String result = decodeWithState.toString();
            BarcodeFormat barcodeFormat = decodeWithState.getBarcodeFormat();
            if (!TextUtils.isEmpty(result)) {
                ScanResult scanResult = new ScanResult();
                scanResult.setContent(result);
                scanResult.setType(barcodeFormat == BarcodeFormat.QR_CODE ? 1 : 2);
                Message obtainMessage = this.mHandler.obtainMessage();
                obtainMessage.obj = scanResult;
                obtainMessage.sendToTarget();
                this.lastResultTime = System.currentTimeMillis();
                if (Symbol.looperScan) {
                    this.allowAnalysis = true;
                }
            } else {
                this.allowAnalysis = true;
            }
        } catch (ReaderException unused) {
            this.allowAnalysis = true;
        } catch (Throwable th) {
            this.multiFormatReader.reset();
            throw th;
        }
        this.multiFormatReader.reset();
    }
}
