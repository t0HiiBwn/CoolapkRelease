package cn.bertsir.zbar.Qr;

public class ScanResult {
    public static final int CODE_BAR = 2;
    public static final int CODE_QR = 1;
    public String content;
    public int type;

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
