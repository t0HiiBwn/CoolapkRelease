package com.tencent.imsdk;

import java.util.ArrayList;

public class TIMImageElem extends TIMElem {
    public static final int TIM_IMAGE_FORMAT_BMP = 4;
    public static final int TIM_IMAGE_FORMAT_GIF = 2;
    public static final int TIM_IMAGE_FORMAT_JPG = 1;
    public static final int TIM_IMAGE_FORMAT_PNG = 3;
    public static final int TIM_IMAGE_FORMAT_UNKNOWN = 255;
    private int imageFormat = 255;
    private ArrayList<TIMImage> imageList = new ArrayList<>();
    private int level = 1;
    private String path = "";
    private int taskId = 0;

    public TIMImageElem() {
        this.type = TIMElemType.Image;
    }

    public ArrayList<TIMImage> getImageList() {
        return this.imageList;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public int getTaskId() {
        return this.taskId;
    }

    void setTaskId(int i) {
        this.taskId = i;
    }

    public int getImageFormat() {
        return this.imageFormat;
    }

    void setImageFormat(int i) {
        this.imageFormat = i;
    }

    void addImage(TIMImage tIMImage) {
        this.imageList.add(tIMImage);
    }
}
