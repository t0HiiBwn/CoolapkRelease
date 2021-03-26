package com.bytedance.sdk.openadsdk.preload.geckox.model;

import com.bytedance.sdk.openadsdk.preload.a.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckRequestBodyModel {
    @c(a = "common")
    private Common common;
    @c(a = "custom")
    private Map<String, Map<String, Object>> custom;
    @c(a = "deployment")
    private Map<String, List<ChannelInfo>> deployment;
    @c(a = "deployments")
    private Map<String, Object> deployments;
    @c(a = "local")
    private Map<String, Map<String, LocalChannel>> local;

    public static class Channels {
        @c(a = "channels")
        public List<Channel> channels = new ArrayList();
    }

    public static class Group {
        @c(a = "group_name")
        public String groupName;
        @c(a = "target_channels")
        public List<TargetChannel> targetChannels;
    }

    public static class LocalChannel {
        @c(a = "l_v")
        public Long localVersion;
    }

    public static class ProcessorParams {
        @c(a = "domain")
        public String domain;
    }

    public void setDeployments(Map<String, Object> map) {
        this.deployments = map;
    }

    public void setLocal(Map<String, Map<String, LocalChannel>> map) {
        this.local = map;
    }

    public void setCustom(Map<String, Map<String, Object>> map) {
        this.custom = map;
    }

    public void setCommon(Common common2) {
        this.common = common2;
    }

    public void putChannelInfo(String str, List<ChannelInfo> list) {
        if (this.deployment == null) {
            this.deployment = new HashMap();
        }
        this.deployment.put(str, list);
    }

    public static class ChannelInfo {
        @c(a = "channel")
        private String channel;
        @c(a = "local_version")
        private long localVersion;

        public ChannelInfo(String str, long j) {
            this.channel = str;
            this.localVersion = j;
        }
    }

    public enum GroupType {
        NORMAL("normal"),
        HIGHPRIORITY("high_priority");
        
        private String value;

        private GroupType(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    public static class TargetChannel {
        @c(a = "c")
        public String channelName;
        @c(a = "t_v")
        public Long targetVersion;

        public TargetChannel() {
        }

        public TargetChannel(String str) {
            this.channelName = str;
        }

        public TargetChannel(String str, Long l) {
            this.channelName = str;
            this.targetVersion = l;
        }
    }

    public static class Channel {
        @c(a = "c")
        String channelName;
        @c(a = "l_v")
        public String localVersion;

        public Channel(String str) {
            this.channelName = str;
        }
    }
}
