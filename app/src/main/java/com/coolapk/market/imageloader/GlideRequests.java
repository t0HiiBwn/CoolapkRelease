package com.coolapk.market.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import java.io.File;
import java.net.URL;

public class GlideRequests extends RequestManager {
    public GlideRequests(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
        super(glide, lifecycle, requestManagerTreeNode, context);
    }

    @Override // com.bumptech.glide.RequestManager
    public <ResourceType> GlideRequest<ResourceType> as(Class<ResourceType> cls) {
        return new GlideRequest<>(this.glide, this, cls, this.context);
    }

    @Override // com.bumptech.glide.RequestManager
    public synchronized GlideRequests applyDefaultRequestOptions(RequestOptions requestOptions) {
        return (GlideRequests) super.applyDefaultRequestOptions(requestOptions);
    }

    @Override // com.bumptech.glide.RequestManager
    public synchronized GlideRequests setDefaultRequestOptions(RequestOptions requestOptions) {
        return (GlideRequests) super.setDefaultRequestOptions(requestOptions);
    }

    @Override // com.bumptech.glide.RequestManager
    public GlideRequests addDefaultRequestListener(RequestListener<Object> requestListener) {
        return (GlideRequests) super.addDefaultRequestListener(requestListener);
    }

    @Override // com.bumptech.glide.RequestManager
    public GlideRequest<Bitmap> asBitmap() {
        return (GlideRequest) super.asBitmap();
    }

    @Override // com.bumptech.glide.RequestManager
    public GlideRequest<GifDrawable> asGif() {
        return (GlideRequest) super.asGif();
    }

    @Override // com.bumptech.glide.RequestManager
    public GlideRequest<Drawable> asDrawable() {
        return (GlideRequest) super.asDrawable();
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideRequest<android.graphics.drawable.Drawable>' to match base method */
    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(Bitmap bitmap) {
        return (GlideRequest) super.load(bitmap);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideRequest<android.graphics.drawable.Drawable>' to match base method */
    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(Drawable drawable) {
        return (GlideRequest) super.load(drawable);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideRequest<android.graphics.drawable.Drawable>' to match base method */
    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(String str) {
        return (GlideRequest) super.load(str);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideRequest<android.graphics.drawable.Drawable>' to match base method */
    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(Uri uri) {
        return (GlideRequest) super.load(uri);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideRequest<android.graphics.drawable.Drawable>' to match base method */
    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(File file) {
        return (GlideRequest) super.load(file);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideRequest<android.graphics.drawable.Drawable>' to match base method */
    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(Integer num) {
        return (GlideRequest) super.load(num);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideRequest<android.graphics.drawable.Drawable>' to match base method */
    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @Deprecated
    public RequestBuilder<Drawable> load(URL url) {
        return (GlideRequest) super.load(url);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideRequest<android.graphics.drawable.Drawable>' to match base method */
    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(byte[] bArr) {
        return (GlideRequest) super.load(bArr);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideRequest<android.graphics.drawable.Drawable>' to match base method */
    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(Object obj) {
        return (GlideRequest) super.load(obj);
    }

    @Override // com.bumptech.glide.RequestManager
    public GlideRequest<File> downloadOnly() {
        return (GlideRequest) super.downloadOnly();
    }

    @Override // com.bumptech.glide.RequestManager
    public GlideRequest<File> download(Object obj) {
        return (GlideRequest) super.download(obj);
    }

    @Override // com.bumptech.glide.RequestManager
    public GlideRequest<File> asFile() {
        return (GlideRequest) super.asFile();
    }

    @Override // com.bumptech.glide.RequestManager
    protected void setRequestOptions(RequestOptions requestOptions) {
        if (requestOptions instanceof GlideOptions) {
            super.setRequestOptions(requestOptions);
        } else {
            super.setRequestOptions(new GlideOptions().apply((BaseRequestOptions<?>) requestOptions));
        }
    }
}
