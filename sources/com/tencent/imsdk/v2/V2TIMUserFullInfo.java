package com.tencent.imsdk.v2;

import com.tencent.imsdk.TIMUserProfile;
import java.util.HashMap;
import java.util.Map;

public class V2TIMUserFullInfo extends V2TIMUserInfo {
    private static final String PROFILE_TYPE_KEY_ALLOWTYPE = "Tag_Profile_IM_AllowType";
    private static final String PROFILE_TYPE_KEY_CUSTOM_PREFIX = "Tag_Profile_Custom_";
    private static final String PROFILE_TYPE_KEY_FACEURL = "Tag_Profile_IM_Image";
    private static final String PROFILE_TYPE_KEY_GENDER = "Tag_Profile_IM_Gender";
    private static final String PROFILE_TYPE_KEY_LEVEL = "Tag_Profile_IM_Level";
    private static final String PROFILE_TYPE_KEY_NICK = "Tag_Profile_IM_Nick";
    private static final String PROFILE_TYPE_KEY_ROLE = "Tag_Profile_IM_Role";
    private static final String PROFILE_TYPE_KEY_SELF_SIGNATURE = "Tag_Profile_IM_SelfSignature";
    public static final int V2TIM_FRIEND_ALLOW_ANY = 0;
    public static final int V2TIM_FRIEND_DENY_ANY = 2;
    public static final int V2TIM_FRIEND_NEED_CONFIRM = 1;
    public static final int V2TIM_GENDER_FEMALE = 2;
    public static final int V2TIM_GENDER_MALE = 1;
    public static final int V2TIM_GENDER_UNKNOWN = 0;
    private HashMap<String, Object> modifyProfileHashMap;
    private TIMUserProfile timUserProfile;

    protected void setTIMUserProfile(TIMUserProfile tIMUserProfile) {
        this.timUserProfile = tIMUserProfile;
    }

    HashMap<String, Object> getModifyProfileMap() {
        return this.modifyProfileHashMap;
    }

    @Override // com.tencent.imsdk.v2.V2TIMUserInfo
    public String getUserID() {
        TIMUserProfile tIMUserProfile = this.timUserProfile;
        if (tIMUserProfile != null) {
            return tIMUserProfile.getIdentifier();
        }
        return null;
    }

    @Override // com.tencent.imsdk.v2.V2TIMUserInfo
    public String getNickName() {
        TIMUserProfile tIMUserProfile = this.timUserProfile;
        if (tIMUserProfile != null) {
            return tIMUserProfile.getNickName();
        }
        return null;
    }

    @Override // com.tencent.imsdk.v2.V2TIMUserInfo
    public String getFaceUrl() {
        TIMUserProfile tIMUserProfile = this.timUserProfile;
        if (tIMUserProfile != null) {
            return tIMUserProfile.getFaceUrl();
        }
        return null;
    }

    public void setNickname(String str) {
        if (this.modifyProfileHashMap == null) {
            this.modifyProfileHashMap = new HashMap<>();
        }
        this.modifyProfileHashMap.put("Tag_Profile_IM_Nick", str);
    }

    public void setFaceUrl(String str) {
        if (this.modifyProfileHashMap == null) {
            this.modifyProfileHashMap = new HashMap<>();
        }
        this.modifyProfileHashMap.put("Tag_Profile_IM_Image", str);
    }

    public String getSelfSignature() {
        TIMUserProfile tIMUserProfile = this.timUserProfile;
        if (tIMUserProfile != null) {
            return tIMUserProfile.getSelfSignature();
        }
        return null;
    }

    public void setSelfSignature(String str) {
        if (this.modifyProfileHashMap == null) {
            this.modifyProfileHashMap = new HashMap<>();
        }
        this.modifyProfileHashMap.put("Tag_Profile_IM_SelfSignature", str);
    }

    public int getGender() {
        TIMUserProfile tIMUserProfile = this.timUserProfile;
        if (tIMUserProfile != null) {
            return tIMUserProfile.getGender();
        }
        return 0;
    }

    public void setGender(int i) {
        if (this.modifyProfileHashMap == null) {
            this.modifyProfileHashMap = new HashMap<>();
        }
        this.modifyProfileHashMap.put("Tag_Profile_IM_Gender", Integer.valueOf(i));
    }

    public int getRole() {
        TIMUserProfile tIMUserProfile = this.timUserProfile;
        if (tIMUserProfile != null) {
            return (int) tIMUserProfile.getRole();
        }
        return 0;
    }

    public void setRole(int i) {
        if (this.modifyProfileHashMap == null) {
            this.modifyProfileHashMap = new HashMap<>();
        }
        this.modifyProfileHashMap.put("Tag_Profile_IM_Role", Integer.valueOf(i));
    }

    public int getLevel() {
        TIMUserProfile tIMUserProfile = this.timUserProfile;
        if (tIMUserProfile != null) {
            return (int) tIMUserProfile.getLevel();
        }
        return 0;
    }

    public void setLevel(int i) {
        if (this.modifyProfileHashMap == null) {
            this.modifyProfileHashMap = new HashMap<>();
        }
        this.modifyProfileHashMap.put("Tag_Profile_IM_Level", Integer.valueOf(i));
    }

    public int getAllowType() {
        TIMUserProfile tIMUserProfile = this.timUserProfile;
        if (tIMUserProfile != null) {
            String allowType = tIMUserProfile.getAllowType();
            if (allowType.equals("AllowType_Type_AllowAny")) {
                return 0;
            }
            if (allowType.equals("AllowType_Type_DenyAny")) {
                return 2;
            }
            if (allowType.equals("AllowType_Type_NeedConfirm")) {
                return 1;
            }
        }
        return 0;
    }

    public void setAllowType(int i) {
        if (this.modifyProfileHashMap == null) {
            this.modifyProfileHashMap = new HashMap<>();
        }
        String str = "AllowType_Type_AllowAny";
        if (i != 0) {
            if (i == 1) {
                str = "AllowType_Type_NeedConfirm";
            } else if (i == 2) {
                str = "AllowType_Type_DenyAny";
            }
        }
        this.modifyProfileHashMap.put("Tag_Profile_IM_AllowType", str);
    }

    public void setCustomInfo(HashMap<String, byte[]> hashMap) {
        if (!(hashMap == null || hashMap.size() == 0)) {
            if (this.modifyProfileHashMap == null) {
                this.modifyProfileHashMap = new HashMap<>();
            }
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                if (entry.getKey().contains("Tag_Profile_Custom_")) {
                    this.modifyProfileHashMap.put(entry.getKey(), new String(entry.getValue()));
                } else {
                    HashMap<String, Object> hashMap2 = this.modifyProfileHashMap;
                    hashMap2.put("Tag_Profile_Custom_" + entry.getKey(), new String(entry.getValue()));
                }
            }
        }
    }

    public HashMap<String, byte[]> getCustomInfo() {
        TIMUserProfile tIMUserProfile = this.timUserProfile;
        if (tIMUserProfile != null) {
            return (HashMap) tIMUserProfile.getCustomInfo();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("V2TIMUserFullInfo--->");
        HashMap<String, byte[]> customInfo = getCustomInfo();
        StringBuilder sb2 = new StringBuilder();
        if (customInfo != null) {
            sb2.append("\n");
            for (Map.Entry<String, byte[]> entry : customInfo.entrySet()) {
                sb2.append(" |key:" + entry.getKey() + ", value:" + new String(entry.getValue()));
                sb2.append("\n");
            }
        }
        sb.append("userID:");
        sb.append(getUserID());
        sb.append(", nickName:");
        sb.append(getNickName());
        sb.append(", gender:");
        sb.append(getGender());
        sb.append(", faceUrl:");
        sb.append(getFaceUrl());
        sb.append(", selfSignature:");
        sb.append(getSelfSignature());
        sb.append(", allowType:");
        sb.append(getAllowType());
        sb.append(", customInfo:");
        sb.append(sb2.toString());
        return sb.toString();
    }
}
