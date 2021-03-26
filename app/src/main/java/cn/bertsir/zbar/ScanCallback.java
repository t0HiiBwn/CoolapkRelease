package cn.bertsir.zbar;

import cn.bertsir.zbar.Qr.ScanResult;

public interface ScanCallback {
    void onScanResult(ScanResult scanResult);
}
