package com.coolapk.market.util;

import android.util.Log;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class AuthUtils {
    public static String getAS(String str) {
        String str2 = "";
        try {
            Calendar instance = Calendar.getInstance();
            int parseInt = Integer.parseInt(dateToStamp(instance.get(1) + "-" + (instance.get(2) + 1) + "-" + instance.get(5) + " " + instance.get(11) + ":" + instance.get(12) + ":" + instance.get(13)).substring(0, 10));
            String str3 = "0x" + Integer.toHexString(parseInt);
            str2 = DigestUtils.md5Hex(Base64.encodeBase64(("token://com.coolapk.market/c67ef5943784d09750dcfbb31020f0ab?" + DigestUtils.md5Hex(String.valueOf(parseInt)) + "$" + str + "&com.coolapk.market").getBytes(StandardCharsets.UTF_8))) + str + str3;
            Log.i("getAS", str2);
            return str2;
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static String dateToStamp(String str) throws ParseException {
        return String.valueOf(((Date) Objects.requireNonNull(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str))).getTime());
    }
}
