package cn.bertsir.zbar;

import android.graphics.Color;
import java.io.Serializable;

public class QrConfig implements Serializable {
    public static final int BARCODE_CODABAR = 38;
    public static final int BARCODE_CODE128 = 128;
    public static final int BARCODE_CODE39 = 39;
    public static final int BARCODE_CODE93 = 93;
    public static final int BARCODE_DATABAR = 34;
    public static final int BARCODE_DATABAR_EXP = 35;
    public static final int BARCODE_EAN13 = 13;
    public static final int BARCODE_EAN8 = 8;
    public static final int BARCODE_I25 = 25;
    public static final int BARCODE_ISBN10 = 10;
    public static final int BARCODE_ISBN13 = 14;
    public static final int BARCODE_PDF417 = 57;
    public static final int BARCODE_UPCA = 12;
    public static final int BARCODE_UPCE = 9;
    public static final String EXTRA_THIS_CONFIG = "extra_this_config";
    public static final int LINE_FAST = 1000;
    public static final int LINE_MEDIUM = 2000;
    public static final int LINE_SLOW = 3000;
    public static final int REQUEST_CAMERA = 99;
    public static final int SCANVIEW_TYPE_BARCODE = 2;
    public static final int SCANVIEW_TYPE_QRCODE = 1;
    public static final int SCREEN_LANDSCAPE = 2;
    public static final int SCREEN_PORTRAIT = 1;
    public static final int SCREEN_SENSOR = 3;
    public static final int TYPE_ALL = 3;
    public static final int TYPE_BARCODE = 2;
    public static final int TYPE_CUSTOM = 4;
    public static final int TYPE_QRCODE = 1;
    public static int ding_path = R.raw.qrcode;
    public int CORNER_COLOR = Color.parseColor("#ff5f00");
    public int LINE_COLOR = Color.parseColor("#ff5f00");
    public int SCREEN_ORIENTATION = 1;
    public int TITLE_BACKGROUND_COLOR = Color.parseColor("#ff5f00");
    public int TITLE_TEXT_COLOR = Color.parseColor("#ffffff");
    public int album_img_res = R.drawable.scanner_album;
    public boolean auto_light = false;
    public boolean auto_zoom = false;
    public int back_img_res = R.drawable.scanner_back_img;
    public int corner_width = 10;
    public int custombarcodeformat = -1;
    public String des_text = "(识别二维码)";
    public boolean double_engine = false;
    public int falsh_img_res = R.drawable.scanner_light;
    public boolean finger_zoom = false;
    public int line_speed = 1000;
    public int line_style = 2;
    public boolean loop_scan = false;
    public int loop_wait_time = 0;
    public boolean need_crop = true;
    public boolean only_center = false;
    public String open_album_text = "选择要识别的图片";
    public boolean play_sound = true;
    public int scan_type = 1;
    public int scan_view_type = 1;
    public boolean show_album = true;
    public boolean show_des = true;
    public boolean show_light = true;
    public boolean show_title = true;
    public boolean show_vibrator = false;
    public boolean show_zoom = false;
    public String title_text = "扫描二维码";

    public int getScan_type() {
        return this.scan_type;
    }

    public boolean isPlay_sound() {
        return this.play_sound;
    }

    public int getCORNER_COLOR() {
        return this.CORNER_COLOR;
    }

    public int getLINE_COLOR() {
        return this.LINE_COLOR;
    }

    public int getTITLE_BACKGROUND_COLOR() {
        return this.TITLE_BACKGROUND_COLOR;
    }

    public int getTITLE_TEXT_COLOR() {
        return this.TITLE_TEXT_COLOR;
    }

    public boolean isShow_title() {
        return this.show_title;
    }

    public boolean isShow_light() {
        return this.show_light;
    }

    public boolean isShow_album() {
        return this.show_album;
    }

    public boolean isShow_des() {
        return this.show_des;
    }

    public boolean isNeed_crop() {
        return this.need_crop;
    }

    public String getTitle_text() {
        return this.title_text;
    }

    public String getDes_text() {
        return this.des_text;
    }

    public String getOpen_album_text() {
        return this.open_album_text;
    }

    public int getLine_speed() {
        return this.line_speed;
    }

    public int getLine_style() {
        return this.line_style;
    }

    public int getCorner_width() {
        return this.corner_width;
    }

    public int getCustombarcodeformat() {
        return this.custombarcodeformat;
    }

    public int getScan_view_type() {
        return this.scan_view_type;
    }

    public boolean isOnly_center() {
        return this.only_center;
    }

    public static int getDing_path() {
        return ding_path;
    }

    public boolean isShow_zoom() {
        return this.show_zoom;
    }

    public boolean isAuto_zoom() {
        return this.auto_zoom;
    }

    public boolean isFinger_zoom() {
        return this.finger_zoom;
    }

    public int getSCREEN_ORIENTATION() {
        return this.SCREEN_ORIENTATION;
    }

    public boolean isDouble_engine() {
        return this.double_engine;
    }

    public boolean isLoop_scan() {
        return this.loop_scan;
    }

    public int getLoop_wait_time() {
        return this.loop_wait_time;
    }

    public boolean isAuto_light() {
        return this.auto_light;
    }

    public boolean isShow_vibrator() {
        return this.show_vibrator;
    }

    public int getBackImgRes() {
        return this.back_img_res;
    }

    public int getLightImageRes() {
        return this.falsh_img_res;
    }

    public int getAblumImageRes() {
        return this.album_img_res;
    }

    public static class Builder {
        private QrConfig watcher = new QrConfig();

        public Builder setLineSpeed(int i) {
            this.watcher.line_speed = i;
            return this;
        }

        public Builder setLineColor(int i) {
            this.watcher.LINE_COLOR = i;
            return this;
        }

        public Builder setCornerColor(int i) {
            this.watcher.CORNER_COLOR = i;
            return this;
        }

        public Builder setCornerWidth(int i) {
            this.watcher.corner_width = i;
            return this;
        }

        public Builder setDesText(String str) {
            this.watcher.des_text = str;
            return this;
        }

        public Builder setTitleText(String str) {
            this.watcher.title_text = str;
            return this;
        }

        public Builder setShowTitle(boolean z) {
            this.watcher.show_title = z;
            return this;
        }

        public Builder setShowLight(boolean z) {
            this.watcher.show_light = z;
            return this;
        }

        public Builder setShowAlbum(boolean z) {
            this.watcher.show_album = z;
            return this;
        }

        public Builder setShowDes(boolean z) {
            this.watcher.show_des = z;
            return this;
        }

        public Builder setNeedCrop(boolean z) {
            this.watcher.need_crop = z;
            return this;
        }

        public Builder setTitleBackgroudColor(int i) {
            this.watcher.TITLE_BACKGROUND_COLOR = i;
            return this;
        }

        public Builder setTitleTextColor(int i) {
            this.watcher.TITLE_TEXT_COLOR = i;
            return this;
        }

        public Builder setScanType(int i) {
            this.watcher.scan_type = i;
            return this;
        }

        public Builder setPlaySound(boolean z) {
            this.watcher.play_sound = z;
            return this;
        }

        public Builder setCustombarcodeformat(int i) {
            this.watcher.custombarcodeformat = i;
            return this;
        }

        public Builder setScanViewType(int i) {
            this.watcher.scan_view_type = i;
            return this;
        }

        public Builder setIsOnlyCenter(boolean z) {
            this.watcher.only_center = z;
            return this;
        }

        public Builder setDingPath(int i) {
            QrConfig.ding_path = i;
            return this;
        }

        public Builder setShowZoom(boolean z) {
            this.watcher.show_zoom = z;
            return this;
        }

        public Builder setAutoZoom(boolean z) {
            this.watcher.auto_zoom = z;
            return this;
        }

        public Builder setFingerZoom(boolean z) {
            this.watcher.finger_zoom = z;
            return this;
        }

        public Builder setScreenOrientation(int i) {
            this.watcher.SCREEN_ORIENTATION = i;
            return this;
        }

        public Builder setDoubleEngine(boolean z) {
            this.watcher.double_engine = z;
            return this;
        }

        public Builder setOpenAlbumText(String str) {
            this.watcher.open_album_text = str;
            return this;
        }

        public Builder setLooperScan(boolean z) {
            this.watcher.loop_scan = z;
            return this;
        }

        public Builder setLooperWaitTime(int i) {
            this.watcher.loop_wait_time = i;
            return this;
        }

        public Builder setScanLineStyle(int i) {
            this.watcher.line_style = i;
            return this;
        }

        public Builder setAutoLight(boolean z) {
            this.watcher.auto_light = z;
            return this;
        }

        public Builder setShowVibrator(boolean z) {
            this.watcher.show_vibrator = z;
            return this;
        }

        public Builder setBackImageRes(int i) {
            this.watcher.back_img_res = i;
            return this;
        }

        public Builder setLightImageRes(int i) {
            this.watcher.falsh_img_res = i;
            return this;
        }

        public Builder setAblumImageRes(int i) {
            this.watcher.album_img_res = i;
            return this;
        }

        public QrConfig create() {
            return this.watcher;
        }
    }
}
