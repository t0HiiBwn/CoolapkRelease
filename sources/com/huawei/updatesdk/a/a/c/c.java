package com.huawei.updatesdk.a.a.c;

import java.util.HashMap;
import java.util.Map;

public class c {
    private static final Map<String, String> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("android.hardware.audio.output", "1");
        hashMap.put("android.hardware.bluetooth", "2");
        hashMap.put("android.hardware.bluetooth_le", "3");
        hashMap.put("android.hardware.camera", "4");
        hashMap.put("android.hardware.camera.any", "5");
        hashMap.put("android.hardware.camera.autofocus", "6");
        hashMap.put("android.hardware.camera.capability.manual_post_processing", "7");
        hashMap.put("android.hardware.camera.flash", "8");
        hashMap.put("android.hardware.camera.front", "9");
        hashMap.put("android.hardware.consumerir", "A");
        hashMap.put("android.hardware.faketouch", "B");
        hashMap.put("android.hardware.fingerprint", "C");
        hashMap.put("android.hardware.location", "D");
        hashMap.put("android.hardware.location.gps", "E");
        hashMap.put("android.hardware.location.network", "F");
        hashMap.put("android.hardware.microphone", "G");
        hashMap.put("android.hardware.nfc", "H");
        hashMap.put("android.hardware.nfc.any", "I");
        hashMap.put("android.hardware.nfc.hce", "J");
        hashMap.put("android.hardware.nfc.hcef", "K");
        hashMap.put("android.hardware.opengles.aep", "L");
        hashMap.put("android.hardware.ram.normal", "M");
        hashMap.put("android.hardware.screen.landscape", "N");
        hashMap.put("android.hardware.screen.portrait", "O");
        hashMap.put("android.hardware.sensor.accelerometer", "P");
        hashMap.put("android.hardware.sensor.barometer", "Q");
        hashMap.put("android.hardware.sensor.compass", "R");
        hashMap.put("android.hardware.sensor.gyroscope", "S");
        hashMap.put("android.hardware.sensor.light", "T");
        hashMap.put("android.hardware.sensor.proximity", "U");
        hashMap.put("android.hardware.sensor.stepcounter", "V");
        hashMap.put("android.hardware.sensor.stepdetector", "W");
        hashMap.put("android.hardware.telephony", "X");
        hashMap.put("android.hardware.telephony.gsm", "Y");
        hashMap.put("android.hardware.telephony.ims", "Z");
        hashMap.put("android.hardware.touchscreen", "a");
        hashMap.put("android.hardware.touchscreen.multitouch", "b");
        hashMap.put("android.hardware.touchscreen.multitouch.distinct", "c");
        hashMap.put("android.hardware.touchscreen.multitouch.jazzhand", "d");
        hashMap.put("android.hardware.usb.accessory", "e");
        hashMap.put("android.hardware.usb.host", "f");
        hashMap.put("android.hardware.vulkan.compute", "g");
        hashMap.put("android.hardware.vulkan.level", "h");
        hashMap.put("android.hardware.vulkan.version", "i");
        hashMap.put("android.hardware.wifi", "j");
        hashMap.put("android.hardware.wifi.direct", "k");
        hashMap.put("android.hardware.wifi.passpoint", "l");
        hashMap.put("android.software.activities_on_secondary_displays", "m");
        hashMap.put("android.software.app_widgets", "n");
        hashMap.put("android.software.autofill", "o");
        hashMap.put("android.software.backup", "p");
        hashMap.put("android.software.cant_save_state", "q");
        hashMap.put("android.software.companion_device_setup", "r");
        hashMap.put("android.software.connectionservice", "s");
        hashMap.put("android.software.cts", "t");
        hashMap.put("android.software.device_admin", "u");
        hashMap.put("android.software.file_based_encryption", "v");
        hashMap.put("android.software.freeform_window_management", "w");
        hashMap.put("android.software.home_screen", "x");
        hashMap.put("android.software.input_methods", "y");
        hashMap.put("android.software.ipsec_tunnels", "z");
        hashMap.put("android.software.live_wallpaper", "00");
        hashMap.put("android.software.managed_users", "01");
        hashMap.put("android.software.midi", "02");
        hashMap.put("android.software.picture_in_picture", "03");
        hashMap.put("android.software.print", "04");
        hashMap.put("android.software.secure_lock_screen", "05");
        hashMap.put("android.software.securely_removes_users", "06");
        hashMap.put("android.software.verified_boot", "07");
        hashMap.put("android.software.voice_recognizers", "08");
        hashMap.put("android.software.webview", "09");
        hashMap.put("android.sofware.nfc.beam", "0A");
        hashMap.put("com.huawei.software.features.china", "0B");
        hashMap.put("com.huawei.software.features.full", "0C");
        hashMap.put("com.huawei.system.feature", "0D");
        hashMap.put("com.nxp.mifare", "0E");
        hashMap.put("huawei.android.hardware.stylus", "0F");
        hashMap.put("android.hardware.audio.low_latency", "0G");
        hashMap.put("android.hardware.camera.capability.raw", "0H");
        hashMap.put("android.hardware.camera.external", "0I");
        hashMap.put("android.hardware.telephony.cdma", "0J");
        hashMap.put("android.software.file_based_encryption", "0K");
        hashMap.put("android.software.sip", "0L");
        hashMap.put("android.software.sip.voip", "0M");
        hashMap.put("android.software.vr.mode", "0N");
        hashMap.put("cn.google.services", "0O");
        hashMap.put("com.google.android.feature.services_updater", "0P");
        hashMap.put("com.google.android.feature.ZERO_TOUCH", "0Q");
        hashMap.put("com.huawei.software.features.oversea", "0R");
    }

    public static String a(String str) {
        Map<String, String> map = a;
        return map.containsKey(str) ? map.get(str) : str;
    }
}
