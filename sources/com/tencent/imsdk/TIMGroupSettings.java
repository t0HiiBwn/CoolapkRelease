package com.tencent.imsdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class TIMGroupSettings {
    Options groupInfoOptions = new Options();
    Options memberInfoOptions = new Options();

    public static class Options {
        List<String> customTags = new ArrayList();
        long flags = -1;
        boolean isDefaultFlag = true;

        public Options() {
        }

        protected Options(long j) {
            this.flags = j;
        }

        public void setFlags(long j) {
            this.flags = j;
            this.isDefaultFlag = false;
        }

        @Deprecated
        public void setCustomTags(List<String> list) {
            this.customTags = list;
        }

        @Deprecated
        public void addCustomTag(String str) {
            List<String> list;
            if (!TextUtils.isEmpty(str) && (list = this.customTags) != null) {
                list.add(str);
            }
        }
    }

    public void setGroupInfoOptions(Options options) {
        this.groupInfoOptions = options;
    }

    public void setMemberInfoOptions(Options options) {
        this.memberInfoOptions = options;
    }
}
