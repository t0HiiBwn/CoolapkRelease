package com.coolapk.market.model;

import com.coolapk.market.model.AutoValue_Library;
import java.util.ArrayList;
import java.util.List;

public abstract class Library {

    public static abstract class Builder {
        public abstract Library build();

        public abstract Builder setAuthor(String str);

        public abstract Builder setDescription(String str);

        public abstract Builder setTitle(String str);

        public abstract Builder setUrl(String str);
    }

    public abstract String getAuthor();

    public abstract String getDescription();

    public abstract String getTitle();

    public abstract String getUrl();

    public static Library create(String str, String str2, String str3, String str4) {
        return builder().setUrl(str).setAuthor(str2).setTitle(str3).setDescription(str4).build();
    }

    public static Builder builder() {
        return new AutoValue_Library.Builder();
    }

    public static class LibraryProvider {
        public static List<Library> getLibraryList() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Library.builder().setUrl("https://github.com/greenrobot/EventBus").setAuthor("greenrobot").setTitle("EventBus").setDescription("Android optimized event bus that simplifies communication between Activities, Fragments, Threads, Services, etc. Less code, better quality.").build());
            arrayList.add(Library.builder().setUrl("https://github.com/magiepooh/RecyclerItemDecoration").setAuthor("magiepooh").setTitle("RecyclerItemDecoration").setDescription("RecyclerItemDecoration allows you to draw divider between items in recyclerview with multiple ViewType without considering items' positions!").build());
            arrayList.add(Library.builder().setUrl("https://github.com/sephiroth74/android-target-tooltip").setAuthor("sephiroth74").setTitle("Tooltips").setDescription("Create Toast like tooltips, but targets can be specified, plus custom properties and features").build());
            arrayList.add(Library.builder().setUrl("https://github.com/bignerdranch/recyclerview-multiselect").setAuthor("bignerdranch").setTitle("RecyclerView MultiSelect").setDescription("RecyclerView MultiSelect is a tool to help implement single or multichoice selection on RecyclerView items.").build());
            arrayList.add(Library.builder().setUrl("https://github.com/square/leakcanary").setAuthor("square").setTitle("LeakCanary").setDescription("A memory leak detection library for Android and Java.").build());
            arrayList.add(Library.builder().setUrl("https://github.com/aurelhubert/ahbottomnavigation").setAuthor("aurelhubert").setTitle("AHBottomNavigation").setDescription("A library to reproduce the behavior of the Bottom Navigation guidelines from Material Design.").build());
            arrayList.add(Library.builder().setUrl("https://github.com/dlazaro66/QRCodeReaderView").setAuthor("dlazaro66").setTitle("QRCodeReaderView").setDescription("Modification of ZXING Barcode Scanner project for easy Android QR-Code detection and AR purposes").build());
            arrayList.add(Library.builder().setUrl("https://github.com/Yalantis/uCrop").setAuthor("Yalantis").setTitle("uCrop").setDescription("Image Cropping Library for Android ").build());
            arrayList.add(Library.builder().setUrl("https://github.com/bm-x/PhotoView").setAuthor("bm-x").setTitle("PhotoView").setDescription("PhotoView 图片浏览缩放控件").build());
            arrayList.add(Library.builder().setUrl("https://github.com/davemorrissey/subsampling-scale-image-view").setAuthor("davemorrissey").setTitle("Subsampling Scale Image View").setDescription("Highly configurable, easily extendable view with pan and zoom gestures for displaying huge images without loss of detail. Perfect for photo galleries, maps, building plans etc.").build());
            arrayList.add(Library.builder().setUrl("https://github.com/gongwen/MarqueeViewLibrary").setAuthor("gongwen").setTitle("MarqueeViewLibrary").setDescription("一个帮您快速实现跑马灯效果的library").build());
            arrayList.add(Library.builder().setUrl("https://github.com/bumptech/glide").setAuthor("bumptech").setTitle("Glide").setDescription("An image loading and caching library for Android focused on smooth scrolling").build());
            arrayList.add(Library.builder().setUrl("https://github.com/google/auto/tree/master/value").setAuthor("Google").setTitle("AutoValue").setDescription("Generated immutable value classes for Java 1.6+").build());
            arrayList.add(Library.builder().setUrl("https://github.com/JakeWharton/timber").setAuthor("JakeWharton").setTitle("Timber").setDescription("A logger with a small, extensible API which provides utility on top of Android's normal Log class.").build());
            arrayList.add(Library.builder().setUrl("https://github.com/square/retrofit").setAuthor("square").setTitle("Retrofit").setDescription("Type-safe HTTP client for Android and Java by Square, Inc.").build());
            arrayList.add(Library.builder().setUrl("https://github.com/google/gson").setAuthor("Google").setTitle("Gson").setDescription("A Java serialization library that can convert Java Objects into JSON and back.").build());
            arrayList.add(Library.builder().setUrl("https://github.com/square/okhttp").setAuthor("square").setTitle("Okhttp").setDescription("n HTTP & HTTP/2 client for Android and Java applications.").build());
            arrayList.add(Library.builder().setUrl("https://github.com/vinc3m1/RoundedImageView").setAuthor("vinc3m1").setTitle("RoundedImageView").setDescription("A fast ImageView that supports rounded corners, ovals, and circles.").build());
            arrayList.add(Library.builder().setUrl("https://github.com/ReactiveX/RxAndroid").setAuthor("ReactiveX").setTitle("RxAndroid").setDescription("RxJava bindings for Android.").build());
            arrayList.add(Library.builder().setUrl("https://github.com/ReactiveX/RxJava").setAuthor("ReactiveX").setTitle("RxJava").setDescription("RxJava – Reactive Extensions for the JVM – a library for composing asynchronous and event-based programs using observable sequences for the Java VM.").build());
            arrayList.add(Library.builder().setUrl("https://github.com/r0adkll/Slidr").setAuthor("r0adkll").setTitle("Slidr").setDescription("Easily add slide to dismiss functionality to an Activity.").build());
            arrayList.add(Library.builder().setUrl("https://github.com/tbruyelle/RxPermissions").setAuthor("tbruyelle").setTitle("RxPermissions").setDescription("Android runtime permissions powered by RxJava2.").build());
            arrayList.add(Library.builder().setUrl("https://github.com/lankton/android-flowlayout").setAuthor("lankton").setTitle("android-flowlayout").setDescription("A very convenient and powerful flow layout by Lan").build());
            arrayList.add(Library.builder().setUrl("https://github.com/youth5201314/banner").setAuthor("youth5201314").setTitle("banner").setDescription("Android广告图片轮播控件，支持无限循环和多种主题，可以灵活设置轮播样式、动画、轮播和切换时间、位置、图片加载框架等！").build());
            arrayList.add(Library.builder().setUrl("https://github.com/Blankj/AndroidUtilCode").setAuthor("Blankj").setTitle("AndroidUtilCode").setDescription("Android developers should collect the following utils(updating).").build());
            arrayList.add(Library.builder().setUrl("https://github.com/H07000223/FlycoTabLayout").setAuthor("H07000223").setTitle("FlycoTabLayout").setDescription("An Android TabLayout Lib").build());
            arrayList.add(Library.builder().setUrl("https://github.com/florent37/ArcLayout").setAuthor("florent37").setTitle("ArcLayout").setDescription("With Arc Layout explore new styles and approaches on material design").build());
            arrayList.add(Library.builder().setUrl("https://github.com/trello/RxLifecycle").setAuthor("trello").setTitle("RxLifecycle").setDescription("Lifecycle handling APIs for Android apps using RxJava").build());
            arrayList.add(Library.builder().setUrl("https://github.com/loopeer/shadow").setAuthor("loopeer").setTitle("shadow").setDescription("Deprecated because of the performance not fine. Android custom shadow view, can replace your CardView").build());
            arrayList.add(Library.builder().setUrl("https://github.com/wasabeef/glide-transformations").setAuthor("wasabeef").setTitle("glide-transformations").setDescription("An Android transformation library providing a variety of image transformations for Glide.").build());
            arrayList.add(Library.builder().setUrl("https://github.com/SalomonBrys/Kotson").setAuthor("SalomonBrys").setTitle("Kotson").setDescription("Kotlin bindings for JSON manipulation via Gson").build());
            arrayList.add(Library.builder().setUrl("https://github.com/dinuscxj/EllipsizeTextView").setAuthor("dinuscxj").setTitle("EllipsizeTextView").setDescription("The EllipsizeTextView extends TextView, support omit (Ellipsize/Ellipsis) redundant characters in multiple lines situtation.").build());
            arrayList.add(Library.builder().setUrl("https://github.com/infotech-group/android-drawable-dsl").setAuthor("infotech-group").setTitle("android-drawable-dsl").setDescription("DSL for constructing the drawables in Kotlin instead of in XML").build());
            arrayList.add(Library.builder().setUrl("https://github.com/Fondesa/RecyclerViewDivider").setAuthor("Fondesa").setTitle("RecyclerViewDivider").setDescription("A library that can configure a divider for a RecyclerView.").build());
            arrayList.add(Library.builder().setUrl("https://github.com/jiajunhui/PlayerBase").setAuthor("jiajunhui").setTitle("PlayerBase").setDescription("The basic library of Android player will process complex business components. The access is simple。").build());
            arrayList.add(Library.builder().setUrl("https://github.com/bilibili/ijkplayer").setAuthor("bilibili").setTitle("ijkplayer").setDescription("Android/iOS video player based on FFmpeg n3.4, with MediaCodec, VideoToolbox support.").build());
            arrayList.add(Library.builder().setUrl("https://github.com/romandanylyk/PageIndicatorView").setAuthor("romandanylyk").setTitle("PageIndicatorView").setDescription("An page indicator for Android ViewPager").build());
            arrayList.add(Library.builder().setUrl("https://github.com/lany192/DateTimePicker").setAuthor("lany192").setTitle("DateTimePicker").setDescription("This is a custom android holo datepicker timepicker").build());
            arrayList.add(Library.builder().setUrl("https://github.com/tiann/FreeReflection").setAuthor("tiann").setTitle("FreeReflection").setDescription("A library that lets you use reflection without any restriction above Android P").build());
            arrayList.add(Library.builder().setUrl("https://github.com/KilleTom/BangScreenToolsMaster").setAuthor("KilleTom").setTitle("BangScreenToolsMaster").setDescription("Android 刘海屏适配工具库、刘海屏幕多样式适配、刘海屏适配、Android 刘海屏适配工具类").build());
            arrayList.add(Library.builder().setUrl("https://github.com/MostafaGazar/CustomShapeImageView").setAuthor("MostafaGazar").setTitle("CustomShapeImageView").setDescription("A library for supporting custom shaped ImageView(s) using SVGs and paint shapes").build());
            arrayList.add(Library.builder().setUrl("https://github.com/hanks-zyh/HTextView").setAuthor("hanks-zyh").setTitle("HTextView").setDescription("Animation effects to text, not really textview").build());
            return arrayList;
        }
    }
}
