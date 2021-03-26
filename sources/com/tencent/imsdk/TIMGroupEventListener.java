package com.tencent.imsdk;

import com.tencent.imsdk.common.IMBaseListener;

public interface TIMGroupEventListener extends IMBaseListener {
    void onGroupTipsEvent(TIMGroupTipsElem tIMGroupTipsElem);
}
