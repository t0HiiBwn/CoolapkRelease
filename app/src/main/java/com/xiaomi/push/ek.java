package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.clientreport.processor.a;
import java.util.List;

public class ek extends a {
    public ek(Context context) {
        super(context);
    }

    @Override // com.xiaomi.clientreport.processor.a
    public void a(List<String> list) {
        em.a(this.a, list);
    }
}
