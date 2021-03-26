package com.coolapk.market.binding;

import com.coolapk.market.model.RelatedData;
import com.coolapk.market.widget.InteractivePeopleView;
import java.util.List;

public class InteractivePeopleViewBindingAdapters {
    public static void setTitle(InteractivePeopleView interactivePeopleView, String str) {
        interactivePeopleView.setTitle(str);
    }

    public static void setAvatarList(InteractivePeopleView interactivePeopleView, List<RelatedData> list, Integer num) {
        if (num != null) {
            interactivePeopleView.setSumNum(num.intValue());
        }
        interactivePeopleView.setAvatarList(list);
    }
}
