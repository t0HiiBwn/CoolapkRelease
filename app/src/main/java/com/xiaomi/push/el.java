package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.clientreport.processor.b;
import java.util.List;

public class el extends b {
    public el(Context context) {
        super(context);
    }

    @Override // com.xiaomi.clientreport.processor.b
    public void a(List<String> list) {
        em.a(this.a, list);
    }
}
