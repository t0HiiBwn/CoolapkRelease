package com.alibaba.sdk.android.oss.model;

import java.util.ArrayList;
import java.util.List;

public class ListPartsResult extends OSSResult {
    private String bucketName;
    private boolean isTruncated = false;
    private String key;
    private int maxParts = 0;
    private int nextPartNumberMarker = 0;
    private int partNumberMarker = 0;
    private List<PartSummary> parts = new ArrayList();
    private String storageClass;
    private String uploadId;

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public void setStorageClass(String str) {
        this.storageClass = str;
    }

    public int getPartNumberMarker() {
        return this.partNumberMarker;
    }

    public void setPartNumberMarker(int i) {
        this.partNumberMarker = i;
    }

    public int getNextPartNumberMarker() {
        return this.nextPartNumberMarker;
    }

    public void setNextPartNumberMarker(int i) {
        this.nextPartNumberMarker = i;
    }

    public int getMaxParts() {
        return this.maxParts;
    }

    public void setMaxParts(int i) {
        this.maxParts = i;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public void setTruncated(boolean z) {
        this.isTruncated = z;
    }

    public List<PartSummary> getParts() {
        return this.parts;
    }

    public void setParts(List<PartSummary> list) {
        this.parts.clear();
        if (list != null && !list.isEmpty()) {
            this.parts.addAll(list);
        }
    }
}
