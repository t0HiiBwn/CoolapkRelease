package cn.bertsir.zbar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import cn.bertsir.zbar.Qr.ScanResult;
import cn.bertsir.zbar.Qr.Symbol;
import cn.bertsir.zbar.utils.GetPathFromUri;
import cn.bertsir.zbar.utils.QRUtils;
import cn.bertsir.zbar.view.ScanView;
import cn.bertsir.zbar.view.VerticalSeekBar;
import com.soundcloud.android.crop.Crop;
import java.io.File;

public class QRActivity extends Activity implements View.OnClickListener, SensorEventListener {
    static final int REQUEST_IMAGE_GET = 1;
    static final int REQUEST_PHOTO_CUT = 2;
    public static final int RESULT_CANCELED = 401;
    private static final String TAG = "QRActivity";
    public final float AUTOLIGHTMIN = 10.0f;
    private CameraPreview cp;
    private String cropTempPath = (Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "cropQr.jpg");
    private FrameLayout fl_title;
    private ImageView iv_album;
    private ImageView iv_flash;
    private ImageView mo_scanner_back;
    private float oldDist = 1.0f;
    private QrConfig options;
    private AlertDialog progressDialog;
    private ScanCallback resultCallback = new ScanCallback() {
        /* class cn.bertsir.zbar.QRActivity.AnonymousClass2 */

        @Override // cn.bertsir.zbar.ScanCallback
        public void onScanResult(ScanResult scanResult) {
            if (QRActivity.this.options.isPlay_sound()) {
                QRActivity.this.soundPool.play(1, 1.0f, 1.0f, 0, 0, 1.0f);
            }
            if (QRActivity.this.options.isShow_vibrator()) {
                QRUtils.getInstance().getVibrator(QRActivity.this.getApplicationContext());
            }
            if (QRActivity.this.cp != null) {
                QRActivity.this.cp.setFlash(false);
            }
            QrManager.getInstance().getResultCallback().onScanSuccess(scanResult);
            if (!Symbol.looperScan) {
                QRActivity.this.finish();
            }
        }
    };
    private Sensor sensor;
    private SensorManager sensorManager;
    private SoundPool soundPool;
    private ScanView sv;
    private TextView textDialog;
    private TextView tv_des;
    private TextView tv_title;
    private Uri uricropFile;
    private VerticalSeekBar vsb_zoom;

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor2, int i) {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().addFlags(67108864);
        }
        Log.i("zBarLibary", "version: 1.4.2");
        this.options = (QrConfig) getIntent().getExtras().get("extra_this_config");
        initParm();
        setContentView(R.layout.activity_qr);
        initView();
    }

    private void initParm() {
        int screen_orientation = this.options.getSCREEN_ORIENTATION();
        if (screen_orientation == 1) {
            setRequestedOrientation(1);
        } else if (screen_orientation == 2) {
            setRequestedOrientation(0);
        } else if (screen_orientation != 3) {
            setRequestedOrientation(1);
        } else {
            setRequestedOrientation(4);
        }
        Symbol.scanType = this.options.getScan_type();
        Symbol.scanFormat = this.options.getCustombarcodeformat();
        Symbol.is_only_scan_center = this.options.isOnly_center();
        Symbol.is_auto_zoom = this.options.isAuto_zoom();
        Symbol.doubleEngine = this.options.isDouble_engine();
        Symbol.looperScan = this.options.isLoop_scan();
        Symbol.looperWaitTime = this.options.getLoop_wait_time();
        Symbol.screenWidth = QRUtils.getInstance().getScreenWidth(this);
        Symbol.screenHeight = QRUtils.getInstance().getScreenHeight(this);
        if (this.options.isAuto_light()) {
            getSensorManager();
        }
    }

    private void initView() {
        this.cp = (CameraPreview) findViewById(R.id.cp);
        SoundPool soundPool2 = new SoundPool(10, 1, 5);
        this.soundPool = soundPool2;
        soundPool2.load(this, QrConfig.getDing_path(), 1);
        ScanView scanView = (ScanView) findViewById(R.id.sv);
        this.sv = scanView;
        scanView.setType(this.options.getScan_view_type());
        ImageView imageView = (ImageView) findViewById(R.id.mo_scanner_back);
        this.mo_scanner_back = imageView;
        imageView.setOnClickListener(this);
        this.mo_scanner_back.setImageResource(this.options.getBackImgRes());
        ImageView imageView2 = (ImageView) findViewById(R.id.iv_flash);
        this.iv_flash = imageView2;
        imageView2.setOnClickListener(this);
        this.iv_flash.setImageResource(this.options.getLightImageRes());
        ImageView imageView3 = (ImageView) findViewById(R.id.iv_album);
        this.iv_album = imageView3;
        imageView3.setOnClickListener(this);
        this.iv_album.setImageResource(this.options.getAblumImageRes());
        this.tv_title = (TextView) findViewById(R.id.tv_title);
        this.fl_title = (FrameLayout) findViewById(R.id.fl_title);
        this.tv_des = (TextView) findViewById(R.id.tv_des);
        this.vsb_zoom = (VerticalSeekBar) findViewById(R.id.vsb_zoom);
        int i = 0;
        this.iv_album.setVisibility(this.options.isShow_light() ? 0 : 8);
        this.fl_title.setVisibility(this.options.isShow_title() ? 0 : 8);
        this.iv_flash.setVisibility(this.options.isShow_light() ? 0 : 8);
        this.iv_album.setVisibility(this.options.isShow_album() ? 0 : 8);
        this.tv_des.setVisibility(this.options.isShow_des() ? 0 : 8);
        VerticalSeekBar verticalSeekBar = this.vsb_zoom;
        if (!this.options.isShow_zoom()) {
            i = 8;
        }
        verticalSeekBar.setVisibility(i);
        this.tv_des.setText(this.options.getDes_text());
        this.tv_title.setText(this.options.getTitle_text());
        this.fl_title.setBackgroundColor(this.options.getTITLE_BACKGROUND_COLOR());
        this.tv_title.setTextColor(this.options.getTITLE_TEXT_COLOR());
        this.sv.setCornerColor(this.options.getCORNER_COLOR());
        this.sv.setLineSpeed(this.options.getLine_speed());
        this.sv.setLineColor(this.options.getLINE_COLOR());
        this.sv.setScanLineStyle(this.options.getLine_style());
        if (Build.VERSION.SDK_INT >= 16) {
            setSeekBarColor(this.vsb_zoom, this.options.getCORNER_COLOR());
        }
        this.vsb_zoom.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /* class cn.bertsir.zbar.QRActivity.AnonymousClass1 */

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                QRActivity.this.cp.setZoom(((float) i) / 100.0f);
            }
        });
    }

    public void getSensorManager() {
        SensorManager sensorManager2 = (SensorManager) getSystemService("sensor");
        this.sensorManager = sensorManager2;
        if (sensorManager2 != null) {
            this.sensor = sensorManager2.getDefaultSensor(5);
        }
    }

    public void setSeekBarColor(SeekBar seekBar, int i) {
        seekBar.getThumb().setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
        seekBar.getProgressDrawable().setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.iv_album) {
            fromAlbum();
        } else if (view.getId() == R.id.iv_flash) {
            CameraPreview cameraPreview = this.cp;
            if (cameraPreview != null) {
                cameraPreview.setFlash();
            }
        } else if (view.getId() == R.id.mo_scanner_back) {
            setResult(401);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        CameraPreview cameraPreview = this.cp;
        if (cameraPreview != null) {
            cameraPreview.setScanCallback(this.resultCallback);
            this.cp.start();
        }
        SensorManager sensorManager2 = this.sensorManager;
        if (sensorManager2 != null) {
            sensorManager2.registerListener(this, this.sensor, 3);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        CameraPreview cameraPreview = this.cp;
        if (cameraPreview != null) {
            cameraPreview.stop();
        }
        SensorManager sensorManager2 = this.sensorManager;
        if (sensorManager2 != null) {
            sensorManager2.unregisterListener(this, this.sensor);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        CameraPreview cameraPreview = this.cp;
        if (cameraPreview != null) {
            cameraPreview.setFlash(false);
            this.cp.stop();
        }
        this.soundPool.release();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i != 1) {
                if (i == 6709) {
                    recognitionLocation(this.uricropFile);
                }
            } else if (this.options.isNeed_crop()) {
                cropPhoto(intent.getData());
            } else {
                recognitionLocation(intent.getData());
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    private void fromAlbum() {
        if (QRUtils.getInstance().isMIUI()) {
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
            startActivityForResult(Intent.createChooser(intent, this.options.getOpen_album_text()), 1);
            return;
        }
        Intent intent2 = new Intent();
        if (Build.VERSION.SDK_INT < 19) {
            intent2.setAction("android.intent.action.GET_CONTENT");
            intent2.setType("image/*");
        } else {
            intent2.setAction("android.intent.action.OPEN_DOCUMENT");
            intent2.addCategory("android.intent.category.OPENABLE");
            intent2.setType("image/*");
        }
        startActivityForResult(Intent.createChooser(intent2, this.options.getOpen_album_text()), 1);
    }

    private void recognitionLocation(Uri uri) {
        final String path = GetPathFromUri.getPath(this, uri);
        TextView showProgressDialog = showProgressDialog();
        this.textDialog = showProgressDialog;
        showProgressDialog.setText("请稍后...");
        new Thread(new Runnable() {
            /* class cn.bertsir.zbar.QRActivity.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (TextUtils.isEmpty(path)) {
                        Toast.makeText(QRActivity.this.getApplicationContext(), "获取图片失败！", 0).show();
                        return;
                    }
                    final String decodeQRcode = QRUtils.getInstance().decodeQRcode(path);
                    QRActivity.this.runOnUiThread(new Runnable() {
                        /* class cn.bertsir.zbar.QRActivity.AnonymousClass3.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            ScanResult scanResult = new ScanResult();
                            if (!TextUtils.isEmpty(decodeQRcode)) {
                                QRActivity.this.closeProgressDialog();
                                scanResult.setContent(decodeQRcode);
                                scanResult.setType(1);
                                QrManager.getInstance().getResultCallback().onScanSuccess(scanResult);
                                QRUtils.getInstance().deleteTempFile(QRActivity.this.cropTempPath);
                                QRActivity.this.finish();
                                return;
                            }
                            String decodeQRcodeByZxing = QRUtils.getInstance().decodeQRcodeByZxing(path);
                            if (!TextUtils.isEmpty(decodeQRcodeByZxing)) {
                                QRActivity.this.closeProgressDialog();
                                scanResult.setContent(decodeQRcodeByZxing);
                                scanResult.setType(1);
                                QrManager.getInstance().getResultCallback().onScanSuccess(scanResult);
                                QRUtils.getInstance().deleteTempFile(QRActivity.this.cropTempPath);
                                QRActivity.this.finish();
                                return;
                            }
                            try {
                                String decodeBarcode = QRUtils.getInstance().decodeBarcode(path);
                                if (!TextUtils.isEmpty(decodeBarcode)) {
                                    QRActivity.this.closeProgressDialog();
                                    scanResult.setContent(decodeBarcode);
                                    scanResult.setType(2);
                                    QrManager.getInstance().getResultCallback().onScanSuccess(scanResult);
                                    QRUtils.getInstance().deleteTempFile(QRActivity.this.cropTempPath);
                                    QRActivity.this.finish();
                                    return;
                                }
                                Toast.makeText(QRActivity.this.getApplicationContext(), "识别失败！", 0).show();
                                QRActivity.this.closeProgressDialog();
                            } catch (Exception e) {
                                Toast.makeText(QRActivity.this.getApplicationContext(), "识别异常！", 0).show();
                                QRActivity.this.closeProgressDialog();
                                e.printStackTrace();
                            }
                        }
                    });
                } catch (Exception unused) {
                    Toast.makeText(QRActivity.this.getApplicationContext(), "识别异常！", 0).show();
                    QRActivity.this.closeProgressDialog();
                }
            }
        }).start();
    }

    public void cropPhoto(Uri uri) {
        Uri parse = Uri.parse("file:///" + this.cropTempPath);
        this.uricropFile = parse;
        Crop.of(uri, parse).asSquare().start(this);
    }

    public TextView showProgressDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);
        builder.setCancelable(false);
        View inflate = View.inflate(this, R.layout.dialog_loading, null);
        builder.setView(inflate);
        ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.pb_loading);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_hint);
        if (Build.VERSION.SDK_INT >= 23) {
            progressBar.setIndeterminateTintList(getColorStateList(R.color.dialog_pro_color));
        }
        AlertDialog create = builder.create();
        this.progressDialog = create;
        create.show();
        return textView;
    }

    public void closeProgressDialog() {
        try {
            AlertDialog alertDialog = this.progressDialog;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.options.isFinger_zoom()) {
            int action = motionEvent.getAction() & 255;
            if (action != 2) {
                if (action == 5) {
                    this.oldDist = QRUtils.getInstance().getFingerSpacing(motionEvent);
                }
            } else if (motionEvent.getPointerCount() == 2) {
                float fingerSpacing = QRUtils.getInstance().getFingerSpacing(motionEvent);
                float f = this.oldDist;
                if (fingerSpacing > f) {
                    this.cp.handleZoom(true);
                } else if (fingerSpacing < f) {
                    this.cp.handleZoom(false);
                }
                this.oldDist = fingerSpacing;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.values[0] < 10.0f && this.cp.isPreviewStart()) {
            this.cp.setFlash(true);
            this.sensorManager.unregisterListener(this, this.sensor);
            this.sensor = null;
            this.sensorManager = null;
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }
}
