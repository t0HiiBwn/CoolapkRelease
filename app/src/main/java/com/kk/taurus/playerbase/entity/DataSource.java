package com.kk.taurus.playerbase.entity;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.FileDescriptor;
import java.io.Serializable;
import java.util.HashMap;

public class DataSource implements Serializable {
    private AssetFileDescriptor assetFileDescriptor;
    private String data;
    private HashMap<String, String> extra;
    private FileDescriptor fileDescriptor;
    private long id;
    private boolean isLive;
    private String sid;
    private int startPos;
    private String tag;
    private String title;
    private Uri uri;

    public DataSource() {
    }

    public DataSource(String str) {
        this.data = str;
    }

    public DataSource(String str, String str2) {
        this.tag = str;
        this.data = str2;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public String getSid() {
        return this.sid;
    }

    public void setSid(String str) {
        this.sid = str;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public Uri getUri() {
        return this.uri;
    }

    public void setUri(Uri uri2) {
        this.uri = uri2;
    }

    public HashMap<String, String> getExtra() {
        return this.extra;
    }

    public void setExtra(HashMap<String, String> hashMap) {
        this.extra = hashMap;
    }

    public FileDescriptor getFileDescriptor() {
        return this.fileDescriptor;
    }

    public void setFileDescriptor(FileDescriptor fileDescriptor2) {
        this.fileDescriptor = fileDescriptor2;
    }

    public AssetFileDescriptor getAssetFileDescriptor() {
        return this.assetFileDescriptor;
    }

    public void setAssetFileDescriptor(AssetFileDescriptor assetFileDescriptor2) {
        this.assetFileDescriptor = assetFileDescriptor2;
    }

    public int getStartPos() {
        return this.startPos;
    }

    public void setStartPos(int i) {
        this.startPos = i;
    }

    public boolean isLive() {
        return this.isLive;
    }

    public void setLive(boolean z) {
        this.isLive = z;
    }
}
