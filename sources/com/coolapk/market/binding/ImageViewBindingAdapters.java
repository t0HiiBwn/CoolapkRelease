package com.coolapk.market.binding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.ImageLoaderAdapter;
import com.coolapk.market.app.ImageLoaderOptions;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.widget.UserAvatarView;
import java.io.File;

public class ImageViewBindingAdapters {
    public static void setVipSignView(UserAvatarView userAvatarView, String str, Boolean bool) {
        userAvatarView.bind(str, bool == null ? true : bool.booleanValue());
    }

    public static void setAppIconWithContext(DataBindingComponent dataBindingComponent, ImageView imageView, String str, String str2, Drawable drawable, int i, Boolean bool, Boolean bool2) {
        Fragment fragment;
        if (bool2 != null) {
            imageView.setTag(2131362704, bool2);
        }
        ImageLoaderOptions.Builder newBuilder = ImageLoaderOptions.newBuilder();
        if (drawable != null) {
            newBuilder.placeHolder(drawable);
        }
        if (i != 0) {
            newBuilder.placeHolderRes(i);
        }
        if (bool != null) {
            newBuilder.useAnimate(bool.booleanValue());
        }
        if (dataBindingComponent instanceof ContextBindingComponent) {
            Context context = (Context) ((ContextBindingComponent) dataBindingComponent).getContainer();
            if (str != null) {
                setAppIconWithPkgName(GlideApp.with(context), context, imageView, str, newBuilder.build());
            } else if (str2 != null) {
                setAppIconWithFilePath(GlideApp.with(context), context, imageView, str2, newBuilder.build());
            }
        } else if ((dataBindingComponent instanceof FragmentBindingComponent) && (fragment = (Fragment) ((FragmentBindingComponent) dataBindingComponent).getContainer()) != null) {
            if (str != null) {
                setAppIconWithPkgName(GlideApp.with(fragment), fragment.getActivity(), imageView, str, newBuilder.build());
            } else if (str2 != null) {
                setAppIconWithFilePath(GlideApp.with(fragment), fragment.getActivity(), imageView, str2, newBuilder.build());
            }
        }
    }

    public static void setImageUriWithContext(DataBindingComponent dataBindingComponent, ImageView imageView, String str, Drawable drawable, int i, int i2, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, String str2, OnImageLoadListener onImageLoadListener, OnBitmapTransformListener onBitmapTransformListener, Boolean bool6, Boolean bool7, Boolean bool8, View.OnClickListener onClickListener, Boolean bool9) {
        if (bool6 != null) {
            imageView.setTag(2131362707, bool6);
        }
        if (bool7 != null) {
            imageView.setTag(2131362700, bool7);
        }
        if (bool8 != null) {
            imageView.setTag(2131362704, bool8);
        }
        if (onClickListener != null) {
            ViewUtil.clickListener(imageView, onClickListener);
        }
        if (TextUtils.isEmpty(str)) {
            if (i > 0) {
                imageView.setImageResource(i);
            } else if (drawable != null) {
                imageView.setImageDrawable(drawable);
            }
        } else if (str.startsWith("packageName")) {
            setAppIconWithContext(dataBindingComponent, imageView, Uri.parse(str).getSchemeSpecificPart(), null, drawable, i, false, true);
        } else {
            Boolean bool10 = str.startsWith("file") ? false : bool2;
            ImageLoaderOptions.Builder newBuilder = ImageLoaderOptions.newBuilder();
            if (drawable != null) {
                newBuilder.placeHolder(drawable);
            }
            if (i != 0) {
                newBuilder.placeHolderRes(i);
            }
            if (bool9 != null) {
                newBuilder.coolapkHeaderReqired(bool9.booleanValue());
            }
            if (i2 != 0) {
                newBuilder.errorRes(i2);
            }
            if (bool != null) {
                newBuilder.useMemoryCache(bool.booleanValue());
            }
            if (bool10 != null) {
                newBuilder.useDiskCache(bool10.booleanValue());
            }
            if (bool3 != null) {
                newBuilder.dontTransfer(bool3.booleanValue());
            }
            if (str2 != null) {
                newBuilder.thumbnail(str2);
            }
            if (bool5 != null) {
                newBuilder.loadSource(bool5.booleanValue());
            }
            if (bool4 != null) {
                newBuilder.useAnimate(bool4.booleanValue());
            }
            if (dataBindingComponent instanceof ContextBindingComponent) {
                setImageUri(AppHolder.getContextImageLoader(), (Context) ((ContextBindingComponent) dataBindingComponent).getContainer(), imageView, str, newBuilder.build(), onImageLoadListener, onBitmapTransformListener);
            } else if (dataBindingComponent instanceof FragmentBindingComponent) {
                setImageUri(AppHolder.getFragmentImageLoader(), (Fragment) ((FragmentBindingComponent) dataBindingComponent).getContainer(), imageView, str, newBuilder.build(), onImageLoadListener, onBitmapTransformListener);
            } else {
                throw new RuntimeException("check DataBindingComponent");
            }
        }
    }

    private static void setAppIconWithPkgName(RequestManager requestManager, Context context, ImageView imageView, String str, ImageLoaderOptions imageLoaderOptions) {
        ((RequestBuilder) requestManager.load(Uri.parse("package://" + str)).placeholder(imageLoaderOptions.getPlaceHolderRes())).into(imageView);
    }

    private static void setAppIconWithFilePath(RequestManager requestManager, Context context, ImageView imageView, String str, ImageLoaderOptions imageLoaderOptions) {
        ((RequestBuilder) ((RequestBuilder) requestManager.load(Uri.fromFile(new File(str))).placeholder(imageLoaderOptions.getPlaceHolder())).placeholder(imageLoaderOptions.getPlaceHolderRes())).into(imageView);
    }

    private static <T> void setImageUri(ImageLoaderAdapter<T> imageLoaderAdapter, T t, ImageView imageView, String str, ImageLoaderOptions imageLoaderOptions, OnImageLoadListener onImageLoadListener, OnBitmapTransformListener onBitmapTransformListener) {
        imageLoaderAdapter.displayImage(t, str, imageView, imageLoaderOptions, onImageLoadListener, onBitmapTransformListener);
    }

    public static void setImageIcon(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(ShapeUtils.createCircleShapeIcon(drawable));
    }
}
