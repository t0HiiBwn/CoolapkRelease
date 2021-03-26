package com.tencent.imsdk;

import android.net.Uri;
import android.text.TextUtils;

public class TIMMessageOfflinePushSettings {
    private AndroidSettings androidSettings = new AndroidSettings();
    private String descr;
    private byte[] ext;
    private IOSSettings iosSettings = new IOSSettings();
    private boolean isEnabled = true;
    private boolean isValid = false;
    private String title;

    public TIMMessageOfflinePushSettings setTitle(String str) {
        this.title = str;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescr() {
        return this.descr;
    }

    public TIMMessageOfflinePushSettings setDescr(String str) {
        this.descr = str;
        this.isValid = true;
        return this;
    }

    public byte[] getExt() {
        return this.ext;
    }

    public TIMMessageOfflinePushSettings setExt(byte[] bArr) {
        this.ext = bArr;
        this.isValid = true;
        return this;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public TIMMessageOfflinePushSettings setEnabled(boolean z) {
        this.isEnabled = z;
        this.isValid = true;
        return this;
    }

    public AndroidSettings getAndroidSettings() {
        return this.androidSettings;
    }

    public TIMMessageOfflinePushSettings setAndroidSettings(AndroidSettings androidSettings2) {
        this.androidSettings = androidSettings2;
        this.isValid = true;
        return this;
    }

    public IOSSettings getIosSettings() {
        return this.iosSettings;
    }

    public TIMMessageOfflinePushSettings setIosSettings(IOSSettings iOSSettings) {
        this.iosSettings = iOSSettings;
        this.isValid = true;
        return this;
    }

    boolean isValid() {
        return this.isValid;
    }

    public enum NotifyMode {
        Normal(0),
        Custom(1);
        
        private int value = 0;

        private NotifyMode(int i) {
            this.value = i;
        }

        static NotifyMode convertFrom(long j) {
            NotifyMode[] values = values();
            for (NotifyMode notifyMode : values) {
                if (((long) notifyMode.getValue()) == j) {
                    return notifyMode;
                }
            }
            return Normal;
        }

        int getValue() {
            return this.value;
        }
    }

    public static class AndroidSettings {
        private String OPPOChannelID = "";
        private String desc = "";
        private NotifyMode notifyMode = NotifyMode.Normal;
        private Uri sound;
        private String title = "";

        public String getTitle() {
            return this.title;
        }

        public AndroidSettings setTitle(String str) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            this.title = str;
            return this;
        }

        public AndroidSettings setDesc(String str) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            this.desc = str;
            return this;
        }

        public Uri getSound() {
            return this.sound;
        }

        public AndroidSettings setSound(Uri uri) {
            this.sound = uri;
            return this;
        }

        String getSoundValue() {
            Uri uri = this.sound;
            return uri != null ? uri.toString() : "";
        }

        void setSoundValue(String str) {
            if (str != null) {
                this.sound = Uri.parse(str);
            }
        }

        public NotifyMode getNotifyMode() {
            return this.notifyMode;
        }

        public AndroidSettings setNotifyMode(NotifyMode notifyMode2) {
            if (notifyMode2 == null) {
                return this;
            }
            this.notifyMode = notifyMode2;
            return this;
        }

        int getNotifyModeValue() {
            return this.notifyMode.getValue();
        }

        void setNotifyModeValue(int i) {
            this.notifyMode = NotifyMode.convertFrom((long) i);
        }

        public String getOPPOChannelID() {
            return this.OPPOChannelID;
        }

        public void setOPPOChannelID(String str) {
            this.OPPOChannelID = str;
        }
    }

    public static class IOSSettings {
        public static String NO_SOUND_NO_VIBRATION = "push.no_sound";
        private String desc = "";
        private boolean isBadgeEnabled = true;
        private String sound = "";
        private String title = "";

        public String getTitle() {
            return this.title;
        }

        public IOSSettings setTitle(String str) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            this.title = str;
            return this;
        }

        public IOSSettings setDesc(String str) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            this.desc = str;
            return this;
        }

        public String getSound() {
            return this.sound;
        }

        public IOSSettings setSound(String str) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            this.sound = str;
            return this;
        }

        public boolean isBadgeEnabled() {
            return this.isBadgeEnabled;
        }

        public IOSSettings setBadgeEnabled(boolean z) {
            this.isBadgeEnabled = z;
            return this;
        }
    }
}
