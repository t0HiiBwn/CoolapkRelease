package com.sina.weibo.sdk.api;

import android.os.Bundle;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.Serializable;

public final class WeiboMultiMessage implements Serializable {
    public static int NineImageType = 2;
    public static int OneImageType = 1;
    private static final String TAG = "WeiboMultiMessage";
    public ImageObject imageObject;
    public BaseMediaObject mediaObject;
    public int msgType;
    public MultiImageObject multiImageObject;
    public TextObject textObject;
    public VideoSourceObject videoSourceObject;

    public WeiboMultiMessage() {
    }

    public WeiboMultiMessage(Bundle bundle) {
        toBundle(bundle);
    }

    public Bundle toBundle(Bundle bundle) {
        TextObject textObject2 = this.textObject;
        if (textObject2 != null) {
            bundle.putParcelable("_weibo_message_text", textObject2);
            bundle.putString("_weibo_message_text_extra", this.textObject.toExtraMediaString());
        } else {
            bundle.putParcelable("_weibo_message_text", null);
            bundle.putString("_weibo_message_text_extra", null);
        }
        ImageObject imageObject2 = this.imageObject;
        if (imageObject2 != null) {
            bundle.putParcelable("_weibo_message_image", imageObject2);
            bundle.putString("_weibo_message_image_extra", this.imageObject.toExtraMediaString());
        } else {
            bundle.putParcelable("_weibo_message_image", null);
            bundle.putString("_weibo_message_image_extra", null);
        }
        BaseMediaObject baseMediaObject = this.mediaObject;
        if (baseMediaObject != null) {
            bundle.putParcelable("_weibo_message_media", baseMediaObject);
            bundle.putString("_weibo_message_media_extra", this.mediaObject.toExtraMediaString());
        } else {
            bundle.putParcelable("_weibo_message_media", null);
            bundle.putString("_weibo_message_media_extra", null);
        }
        MultiImageObject multiImageObject2 = this.multiImageObject;
        if (multiImageObject2 != null) {
            bundle.putParcelable("_weibo_message_multi_image", multiImageObject2);
        } else {
            bundle.putParcelable("_weibo_message_multi_image", null);
        }
        VideoSourceObject videoSourceObject2 = this.videoSourceObject;
        if (videoSourceObject2 != null) {
            bundle.putParcelable("_weibo_message_video_source", videoSourceObject2);
        } else {
            bundle.putParcelable("_weibo_message_video_source", null);
        }
        return bundle;
    }

    public WeiboMultiMessage toObject(Bundle bundle) {
        TextObject textObject2 = (TextObject) bundle.getParcelable("_weibo_message_text");
        this.textObject = textObject2;
        if (textObject2 != null) {
            textObject2.toExtraMediaObject(bundle.getString("_weibo_message_text_extra"));
        }
        ImageObject imageObject2 = (ImageObject) bundle.getParcelable("_weibo_message_image");
        this.imageObject = imageObject2;
        if (imageObject2 != null) {
            imageObject2.toExtraMediaObject(bundle.getString("_weibo_message_image_extra"));
        }
        BaseMediaObject baseMediaObject = (BaseMediaObject) bundle.getParcelable("_weibo_message_media");
        this.mediaObject = baseMediaObject;
        if (baseMediaObject != null) {
            baseMediaObject.toExtraMediaObject(bundle.getString("_weibo_message_media_extra"));
        }
        this.multiImageObject = (MultiImageObject) bundle.getParcelable("_weibo_message_multi_image");
        this.videoSourceObject = (VideoSourceObject) bundle.getParcelable("_weibo_message_video_source");
        return this;
    }

    public boolean checkArgs() {
        TextObject textObject2 = this.textObject;
        if (textObject2 == null || textObject2.checkArgs()) {
            ImageObject imageObject2 = this.imageObject;
            if (imageObject2 == null || imageObject2.checkArgs()) {
                BaseMediaObject baseMediaObject = this.mediaObject;
                if (baseMediaObject != null && !baseMediaObject.checkArgs()) {
                    LogUtil.e("WeiboMultiMessage", "checkArgs fail, mediaObject is invalid");
                    return false;
                } else if (this.textObject != null || this.imageObject != null || this.mediaObject != null) {
                    return true;
                } else {
                    LogUtil.e("WeiboMultiMessage", "checkArgs fail, textObject and imageObject and mediaObject is null");
                    return false;
                }
            } else {
                LogUtil.e("WeiboMultiMessage", "checkArgs fail, imageObject is invalid");
                return false;
            }
        } else {
            LogUtil.e("WeiboMultiMessage", "checkArgs fail, textObject is invalid");
            return false;
        }
    }

    public void setMsgType(int i) {
        this.msgType = i;
    }

    public int getMsgType() {
        return this.msgType;
    }
}
