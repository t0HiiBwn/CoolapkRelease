package com.ali.auth.third.core.rpc.protocol;

import java.util.Random;

public class a {
    public static String a(int i) {
        String str;
        double d;
        double d2;
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            int nextInt = random.nextInt(3);
            if (nextInt == 0) {
                d = Math.random() * 25.0d;
                d2 = 65.0d;
            } else if (nextInt == 1) {
                d = Math.random() * 25.0d;
                d2 = 97.0d;
            } else if (nextInt == 2) {
                str = String.valueOf(new Random().nextInt(10));
                stringBuffer.append(str);
            }
            str = String.valueOf((char) ((int) Math.round(d + d2)));
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }
}
