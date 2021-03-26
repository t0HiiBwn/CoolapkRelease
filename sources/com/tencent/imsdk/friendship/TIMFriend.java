package com.tencent.imsdk.friendship;

import com.tencent.imsdk.TIMUserProfile;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TIMFriend implements Serializable {
    public static final String TIM_FRIEND_PROFILE_TYPE_KEY_CUSTOM_PREFIX = "Tag_SNS_Custom_";
    public static final String TIM_FRIEND_PROFILE_TYPE_KEY_GROUP = "Tag_SNS_IM_Group";
    public static final String TIM_FRIEND_PROFILE_TYPE_KEY_REMARK = "Tag_SNS_IM_Remark";
    private String addSource = "";
    private long addTime;
    private String addWording = "";
    private Map<String, byte[]> customInfo = new HashMap();
    private Map<String, Long> customInfoUint = new HashMap();
    private List<String> groupNames = new ArrayList();
    private String identifier = "";
    private String remark = "";
    private TIMUserProfile timUserProfile;

    public String getIdentifier() {
        return this.identifier;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getAddWording() {
        return this.addWording;
    }

    public String getAddSource() {
        return this.addSource;
    }

    public long getAddTime() {
        return this.addTime;
    }

    public List<String> getGroupNames() {
        return this.groupNames;
    }

    private void addGroup(String str) {
        this.groupNames.add(str);
    }

    public Map<String, byte[]> getCustomInfo() {
        return this.customInfo;
    }

    private void addCustomInfo(String str, byte[] bArr) {
        this.customInfo.put(str, bArr);
    }

    public Map<String, Long> getCustomInfoUint() {
        return this.customInfoUint;
    }

    private void addCustomInfoUint(String str, long j) {
        this.customInfoUint.put(str, Long.valueOf(j));
    }

    public TIMUserProfile getTimUserProfile() {
        return this.timUserProfile;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TIMFriend{\n");
        sb.append("\t\tidentifier='");
        sb.append(getIdentifier());
        sb.append("',\n");
        sb.append("\t\tremark='");
        sb.append(getRemark());
        sb.append("',\n");
        sb.append("\t\taddWording='");
        sb.append(getAddWording());
        sb.append("',\n");
        sb.append("\t\taddSource='");
        sb.append(getAddSource());
        sb.append("',\n");
        sb.append("\t\taddTime='");
        sb.append(getAddTime());
        sb.append("',\n");
        for (String str : getGroupNames()) {
            sb.append("\t\tgroupNames='");
            sb.append(str);
            sb.append("',\n");
        }
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
