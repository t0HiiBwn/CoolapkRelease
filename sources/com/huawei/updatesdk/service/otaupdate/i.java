package com.huawei.updatesdk.service.otaupdate;

import android.content.Context;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class i {
    public static int a(long j, long j2) {
        if (j2 <= 0) {
            return 0;
        }
        int round = (int) Math.round((((double) j) / ((double) j2)) * 100.0d);
        if (round > 100) {
            return 100;
        }
        return round;
    }

    public static String a(int i) {
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        percentInstance.setMinimumFractionDigits(0);
        return percentInstance.format(((double) i) / 100.0d);
    }

    public static String a(Context context, long j) {
        if (j == 0) {
            return context.getString(g.b(context, "upsdk_storage_utils"), "0");
        }
        DecimalFormat decimalFormat = null;
        if (j > 104857) {
            decimalFormat = new DecimalFormat("###.#");
        } else if (j > 10485) {
            decimalFormat = new DecimalFormat("###.##");
        }
        return decimalFormat != null ? context.getString(g.b(context, "upsdk_storage_utils"), decimalFormat.format(((double) j) / 1048576.0d)) : context.getString(g.b(context, "upsdk_storage_utils"), "0.01");
    }

    public static boolean a(List list) {
        return list == null || list.size() <= 0;
    }
}
