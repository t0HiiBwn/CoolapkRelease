package com.tencent.imsdk.v2;

import com.tencent.imsdk.TIMCustomElem;
import com.tencent.imsdk.TIMElem;
import com.tencent.imsdk.TIMFaceElem;
import com.tencent.imsdk.TIMFileElem;
import com.tencent.imsdk.TIMGroupTipsElem;
import com.tencent.imsdk.TIMImageElem;
import com.tencent.imsdk.TIMLocationElem;
import com.tencent.imsdk.TIMMessage;
import com.tencent.imsdk.TIMSoundElem;
import com.tencent.imsdk.TIMTextElem;
import com.tencent.imsdk.TIMVideoElem;
import com.tencent.imsdk.log.QLog;

public class V2TIMElem {
    private final String TAG = "V2TIMElem";
    private int elemIndex;
    private TIMMessage timMessage;

    public class V2ProgressInfo {
        private long currentSize;
        private long totalSize;

        public V2ProgressInfo(long j, long j2) {
            this.currentSize = j;
            this.totalSize = j2;
        }

        public long getCurrentSize() {
            return this.currentSize;
        }

        public long getTotalSize() {
            return this.totalSize;
        }
    }

    TIMMessage getTIMMessage() {
        return this.timMessage;
    }

    void setTIMMessage(TIMMessage tIMMessage) {
        this.timMessage = tIMMessage;
    }

    TIMElem getTIMElem() {
        return this.timMessage.getElement(this.elemIndex);
    }

    void setElemIndex(int i) {
        this.elemIndex = i;
    }

    public V2TIMElem getNextElem() {
        int i;
        TIMMessage tIMMessage = this.timMessage;
        if (tIMMessage == null || (i = this.elemIndex + 1) >= tIMMessage.getElementCount()) {
            return null;
        }
        V2TIMElem v2TIMElem = new V2TIMElem();
        TIMElem element = this.timMessage.getElement(i);
        if (element instanceof TIMTextElem) {
            v2TIMElem = new V2TIMTextElem();
        } else if (element instanceof TIMImageElem) {
            v2TIMElem = new V2TIMImageElem();
        } else if (element instanceof TIMVideoElem) {
            v2TIMElem = new V2TIMVideoElem();
        } else if (element instanceof TIMSoundElem) {
            v2TIMElem = new V2TIMSoundElem();
        } else if (element instanceof TIMFaceElem) {
            v2TIMElem = new V2TIMFaceElem();
        } else if (element instanceof TIMFileElem) {
            v2TIMElem = new V2TIMFileElem();
        } else if (element instanceof TIMCustomElem) {
            v2TIMElem = new V2TIMCustomElem();
        } else if (element instanceof TIMLocationElem) {
            v2TIMElem = new V2TIMLocationElem();
        } else if (element instanceof TIMGroupTipsElem) {
            v2TIMElem = new V2TIMGroupTipsElem();
        }
        v2TIMElem.setTIMMessage(this.timMessage);
        v2TIMElem.setElemIndex(i);
        return v2TIMElem;
    }

    public void appendElem(V2TIMElem v2TIMElem) {
        if (this.timMessage == null) {
            QLog.e("V2TIMElem", "appendElem error, must be first elem from message");
            return;
        }
        if (v2TIMElem instanceof V2TIMTextElem) {
            TIMTextElem tIMTextElem = new TIMTextElem();
            tIMTextElem.setText(((V2TIMTextElem) v2TIMElem).getText());
            this.timMessage.addElement(tIMTextElem);
        } else if (v2TIMElem instanceof V2TIMCustomElem) {
            TIMCustomElem tIMCustomElem = new TIMCustomElem();
            V2TIMCustomElem v2TIMCustomElem = (V2TIMCustomElem) v2TIMElem;
            tIMCustomElem.setData(v2TIMCustomElem.getData());
            tIMCustomElem.setDesc(v2TIMCustomElem.getDescription());
            tIMCustomElem.setExt(v2TIMCustomElem.getExtension());
            this.timMessage.addElement(tIMCustomElem);
        } else {
            QLog.e("V2TIMElem", "appendElem error, not support this elem type");
            return;
        }
        v2TIMElem.setTIMMessage(this.timMessage);
        v2TIMElem.setElemIndex(this.timMessage.getElementCount() - 1);
    }
}
