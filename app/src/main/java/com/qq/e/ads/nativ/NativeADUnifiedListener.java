package com.qq.e.ads.nativ;

import com.qq.e.ads.AbstractAD;
import java.util.List;

public interface NativeADUnifiedListener extends AbstractAD.BasicADListener {
    void onADLoaded(List<NativeUnifiedADData> list);
}
