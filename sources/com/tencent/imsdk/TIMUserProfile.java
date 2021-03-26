package com.tencent.imsdk;

import android.text.TextUtils;
import com.tencent.imsdk.log.QLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TIMUserProfile implements Serializable {
    public static final String TIM_PROFILE_TYPE_KEY_ALLOWTYPE = "Tag_Profile_IM_AllowType";
    public static final String TIM_PROFILE_TYPE_KEY_BIRTHDAY = "Tag_Profile_IM_BirthDay";
    public static final String TIM_PROFILE_TYPE_KEY_CUSTOM_PREFIX = "Tag_Profile_Custom_";
    public static final String TIM_PROFILE_TYPE_KEY_FACEURL = "Tag_Profile_IM_Image";
    public static final String TIM_PROFILE_TYPE_KEY_GENDER = "Tag_Profile_IM_Gender";
    public static final String TIM_PROFILE_TYPE_KEY_LANGUAGE = "Tag_Profile_IM_Language";
    public static final String TIM_PROFILE_TYPE_KEY_LEVEL = "Tag_Profile_IM_Level";
    public static final String TIM_PROFILE_TYPE_KEY_LOCATION = "Tag_Profile_IM_Location";
    public static final String TIM_PROFILE_TYPE_KEY_NICK = "Tag_Profile_IM_Nick";
    public static final String TIM_PROFILE_TYPE_KEY_ROLE = "Tag_Profile_IM_Role";
    public static final String TIM_PROFILE_TYPE_KEY_SELFSIGNATURE = "Tag_Profile_IM_SelfSignature";
    private String allowType = "";
    private int birthday = 0;
    private Map<String, byte[]> customInfo = new HashMap();
    private Map<String, Long> customInfoUint = new HashMap();
    private String faceUrl = "";
    private int gender = 0;
    private String identifier = "";
    private int language = 0;
    private int level = 0;
    private String location = "";
    private String nickName = "";
    private int role = 0;
    private String selfSignature = "";

    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    public String getSelfSignature() {
        return this.selfSignature;
    }

    public String getAllowType() {
        QLog.i("TIMUserProfile", "allowType " + this.allowType);
        if (this.allowType.equals("AllowType_Type_AllowAny")) {
            return "AllowType_Type_AllowAny";
        }
        if (this.allowType.equals("AllowType_Type_DenyAny")) {
            return "AllowType_Type_DenyAny";
        }
        return this.allowType.equals("AllowType_Type_NeedConfirm") ? "AllowType_Type_NeedConfirm" : "AllowType_Type_Invalid";
    }

    public Map<String, byte[]> getCustomInfo() {
        return this.customInfo;
    }

    void addCustomInfo(String str, byte[] bArr) {
        this.customInfo.put(str, bArr);
    }

    public int getGender() {
        int i = this.gender;
        if (i == 1 || i == 2) {
            return i;
        }
        return 0;
    }

    void setGender(int i) {
        this.gender = i;
    }

    public long getBirthday() {
        return (long) this.birthday;
    }

    void setBirthday(int i) {
        this.birthday = i;
    }

    public long getLanguage() {
        return (long) this.language;
    }

    void setLanguage(int i) {
        this.language = i;
    }

    public String getLocation() {
        return this.location;
    }

    void setLocation(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.location = str;
        }
    }

    public long getLevel() {
        return (long) this.level;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public long getRole() {
        return (long) this.role;
    }

    public void setRole(int i) {
        this.role = i;
    }

    public Map<String, Long> getCustomInfoUint() {
        return this.customInfoUint;
    }

    void addCustomInfoUint(String str, long j) {
        this.customInfoUint.put(str, Long.valueOf(j));
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TIMUserProfile{\n");
        sb.append("\t\tidentifier='");
        sb.append(getIdentifier());
        sb.append("',\n");
        sb.append("\t\tnickName='");
        sb.append(getNickName());
        sb.append("',\n");
        sb.append("\t\tallowType='");
        sb.append(getAllowType());
        sb.append("',\n");
        sb.append("\t\tfaceUrl='");
        sb.append(getFaceUrl());
        sb.append("',\n");
        sb.append("\t\tselfSignature='");
        sb.append(getSelfSignature());
        sb.append("',\n");
        sb.append("\t\tlevel='");
        sb.append(getLevel());
        sb.append("',\n");
        sb.append("\t\trole='");
        sb.append(getRole());
        sb.append("',\n");
        if (!getCustomInfo().isEmpty()) {
            for (Map.Entry<String, byte[]> entry : getCustomInfo().entrySet()) {
                sb.append("\t\t");
                sb.append(entry.getKey());
                sb.append("='");
                sb.append(new String(entry.getValue()));
                sb.append("',\n");
            }
        }
        if (!getCustomInfoUint().isEmpty()) {
            for (Map.Entry<String, Long> entry2 : getCustomInfoUint().entrySet()) {
                sb.append("\t\t");
                sb.append(entry2.getKey());
                sb.append("='");
                sb.append(entry2.getValue());
                sb.append("',\n");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
