package com.coolapk.market.view.feedv8;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.ShareFeedInfo;
import com.coolapk.market.model.Topic;
import com.coolapk.market.model.Vote;
import com.coolapk.market.util.FeedTextUtils;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.StringUtils;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0014\u0010\u0014\u001a\u00020\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\b\u0010\u0017\u001a\u00020\u000fH\u0007J\"\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\u001b\u001a\u00020\u000fH\u0007J\b\u0010\u001c\u001a\u00020\u000fH\u0007J&\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0007J&\u0010#\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0007J\"\u0010$\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010\u0019H\u0007J\b\u0010&\u001a\u00020\u000fH\u0007J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020)H\u0007J\u0018\u0010*\u001a\u00020+2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010,\u001a\u00020+2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010-\u001a\u00020+2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010.\u001a\u00020/2\u0006\u0010\u000b\u001a\u000200H\u0007J\u0018\u00101\u001a\u00020+2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0018\u00102\u001a\u00020+2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001c\u00103\u001a\u00020+2\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u0010\u00104\u001a\u00020+2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u00105\u001a\u00020/H\u0007J\u0018\u00105\u001a\u00020+2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00106\u001a\u00020+H\u0007J\u0018\u00107\u001a\u00020+2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00108\u001a\u000209H\u0007J\u0010\u0010:\u001a\u00020/2\u0006\u0010\u0005\u001a\u000200H\u0007J\u0018\u0010;\u001a\u00020+2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0018\u0010<\u001a\u00020+2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010=\u001a\u00020+2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010>\u001a\u00020/2\u0006\u0010\u0005\u001a\u000200H\u0007J\u0018\u0010?\u001a\u00020/2\u0006\u0010\u0005\u001a\u0002002\u0006\u0010(\u001a\u00020)H\u0007¨\u0006@"}, d2 = {"Lcom/coolapk/market/view/feedv8/FeedArgsFactory;", "", "()V", "multiPartForAnswerFeed", "Lcom/coolapk/market/model/FeedMultiPart;", "activity", "Landroid/app/Activity;", "feed", "Lcom/coolapk/market/model/Feed;", "multiPartForCoolPic", "multiPartForDiscovery", "context", "query", "Lcom/coolapk/market/model/MobileApp;", "multiPartForFeed", "Lcom/coolapk/market/model/FeedMultiPart$Builder;", "multiPartForForwardDyhArticle", "dyhArticle", "Lcom/coolapk/market/model/DyhArticle;", "multiPartForForwardFeed", "multiPartForGoods", "feedGoods", "Lcom/coolapk/market/model/FeedGoods;", "multiPartForQuestion", "title", "", "oldMultiPart", "multiPartForRating", "multiPartForSecondHand", "multiPartForShareDyhInfo", "info", "Lcom/coolapk/market/model/ShareFeedInfo;", "list", "", "Lcom/coolapk/market/model/ImageUrl;", "multiPartForShareInfo", "multiPartForShareVideo", "videoTitle", "multiPartForVote", "multiPartForVoteComment", "vote", "Lcom/coolapk/market/model/Vote;", "uiConfigForAnswerFeed", "Lcom/coolapk/market/model/FeedUIConfig;", "uiConfigForCoolPic", "uiConfigForDiscovery", "uiConfigForFeed", "Lcom/coolapk/market/model/FeedUIConfig$Builder;", "Landroid/content/Context;", "uiConfigForForwardDyhArticle", "uiConfigForForwardFeed", "uiConfigForForwardGoods", "uiConfigForHtmlFeed", "uiConfigForQuestion", "oldConfig", "uiConfigForQuestionTopic", "topic", "Lcom/coolapk/market/model/Topic;", "uiConfigForSecondHand", "uiConfigForShareDyhInfo", "uiConfigForShareInfo", "uiConfigForShareVideo", "uiConfigForVote", "uiConfigForVoteComment", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedArgsFactory.kt */
public final class FeedArgsFactory {
    public static final FeedArgsFactory INSTANCE = new FeedArgsFactory();

    private FeedArgsFactory() {
    }

    @JvmStatic
    public static final FeedMultiPart.Builder multiPartForFeed() {
        FeedMultiPart.Builder type = FeedMultiPart.builder().type("feed");
        Intrinsics.checkNotNullExpressionValue(type, "FeedMultiPart.builder().…(FeedMultiPart.Type.FEED)");
        return type;
    }

    @JvmStatic
    public static final FeedUIConfig.Builder uiConfigForFeed(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        FeedUIConfig.Builder builder = FeedUIConfig.builder();
        Intrinsics.checkNotNullExpressionValue(builder, "FeedUIConfig.builder()");
        return FeedArgsFactoryKt.applyFeed(builder, context);
    }

    @JvmStatic
    public static final FeedMultiPart.Builder multiPartForSecondHand() {
        FeedMultiPart.Builder type = FeedMultiPart.builder().type("ershou");
        Intrinsics.checkNotNullExpressionValue(type, "FeedMultiPart.builder().…ultiPart.Type.SECONDHAND)");
        return type;
    }

    @JvmStatic
    public static final FeedUIConfig.Builder uiConfigForSecondHand(Context context) {
        Intrinsics.checkNotNullParameter(context, "activity");
        FeedUIConfig.Builder builder = FeedUIConfig.builder();
        Intrinsics.checkNotNullExpressionValue(builder, "FeedUIConfig.builder()");
        return FeedArgsFactoryKt.applySecondHand(builder, context);
    }

    @JvmStatic
    public static final FeedUIConfig.Builder uiConfigForQuestion() {
        FeedUIConfig.Builder builder = FeedUIConfig.builder();
        Intrinsics.checkNotNullExpressionValue(builder, "FeedUIConfig.builder()");
        return FeedArgsFactoryKt.applyQuestion(builder);
    }

    @JvmStatic
    public static final FeedMultiPart.Builder multiPartForQuestion() {
        FeedMultiPart.Builder type = FeedMultiPart.builder().type("question");
        Intrinsics.checkNotNullExpressionValue(type, "FeedMultiPart.builder()\n…dMultiPart.Type.QUESTION)");
        return type;
    }

    @JvmStatic
    public static final FeedMultiPart.Builder multiPartForRating() {
        FeedMultiPart.Builder type = FeedMultiPart.builder().type("rating");
        Intrinsics.checkNotNullExpressionValue(type, "FeedMultiPart.builder()\n…eedMultiPart.Type.RATING)");
        return type;
    }

    @JvmStatic
    public static final FeedMultiPart multiPartForForwardFeed(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        FeedMultiPart.Builder multiPartForFeed = multiPartForFeed();
        if (!TextUtils.isEmpty(feed.getForwardSourceType())) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String allLinkAndText = StringUtils.getAllLinkAndText(feed.getMessage());
            Intrinsics.checkNotNullExpressionValue(allLinkAndText, "StringUtils.getAllLinkAndText(feed.message)");
            String format = String.format("//@%s: %s", Arrays.copyOf(new Object[]{feed.getUserName(), FeedTextUtils.insertReconvertedPhotoLink(LinkTextUtils.reconvert(allLinkAndText), feed)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            multiPartForFeed.message(format);
        }
        FeedMultiPart build = multiPartForFeed.forwardId(feed.getId()).build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.forwardId(feed.id).build()");
        return build;
    }

    @JvmStatic
    public static final FeedUIConfig uiConfigForForwardFeed(Activity activity, Feed feed) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(feed, "feed");
        String forwardSourceType = feed.getForwardSourceType();
        DyhArticle dyhArticle = null;
        if (TextUtils.isEmpty(forwardSourceType)) {
            dyhArticle = feed;
        } else if (Intrinsics.areEqual("feed", forwardSourceType)) {
            dyhArticle = feed.getForwardSourceFeed();
        } else if (Intrinsics.areEqual("article", forwardSourceType)) {
            dyhArticle = feed.getForwardSourceArticle();
        }
        FeedUIConfig build = FeedUIConfig.builder().title(activity.getString(2131886347)).submitText(activity.getString(2131886430)).editTextHint(activity.getString(2131887321)).isForward(true).isPickPhotoContainerVisible(false).isPickPhotoItemVisible(true).maxPickPhotoCount(1).isAddExtraItemVisible(false).isLocationViewVisible(false).isForwardAndReplyChecked(false).isForwardAndCommentViewVisible(true).forwardEntity(dyhArticle).build();
        Intrinsics.checkNotNullExpressionValue(build, "FeedUIConfig.builder()\n …\n                .build()");
        return build;
    }

    @JvmStatic
    public static final FeedMultiPart multiPartForForwardDyhArticle(Activity activity, DyhArticle dyhArticle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(dyhArticle, "dyhArticle");
        FeedMultiPart build = FeedMultiPart.builder().type("feed").forwardId(StringUtils.getForwardId(dyhArticle)).build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.forwardId(String…rdId(dyhArticle)).build()");
        return build;
    }

    @JvmStatic
    public static final FeedUIConfig uiConfigForForwardDyhArticle(Activity activity, DyhArticle dyhArticle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(dyhArticle, "dyhArticle");
        FeedUIConfig build = FeedUIConfig.builder().title(activity.getString(2131887320)).submitText(activity.getString(2131886430)).editTextHint("分享你此刻的想法...").isForward(true).isPickPhotoContainerVisible(false).isPickPhotoItemVisible(true).maxPickPhotoCount(1).isAddExtraItemVisible(false).isLocationViewVisible(false).isForwardAndReplyChecked(false).isForwardAndCommentViewVisible(true).forwardEntity(dyhArticle).build();
        Intrinsics.checkNotNullExpressionValue(build, "FeedUIConfig.builder()\n …\n                .build()");
        return build;
    }

    @JvmStatic
    public static final FeedUIConfig uiConfigForHtmlFeed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        FeedUIConfig build = FeedArgsFactoryKt.applyHtml(uiConfigForFeed(activity)).build();
        Intrinsics.checkNotNullExpressionValue(build, "uiConfigForFeed(activity…\n                .build()");
        return build;
    }

    @JvmStatic
    public static final FeedMultiPart multiPartForDiscovery(Activity activity, MobileApp mobileApp) {
        Intrinsics.checkNotNullParameter(activity, "context");
        Intrinsics.checkNotNullParameter(mobileApp, "query");
        FeedMultiPart.Builder extraTitle = FeedMultiPart.builder().type("discovery").extraPic(Uri.fromParts("package", mobileApp.getPackageName(), null).toString()).extraTitle(mobileApp.getAppName());
        FeedMultiPart build = extraTitle.extraUrl("market://details?id=" + mobileApp.getPackageName()).message("").uploadDir("discovery").extraKey(mobileApp.getPackageName()).build();
        Intrinsics.checkNotNullExpressionValue(build, "FeedMultiPart.builder()\n…\n                .build()");
        return build;
    }

    @JvmStatic
    public static final FeedUIConfig uiConfigForDiscovery(Activity activity, MobileApp mobileApp) {
        Intrinsics.checkNotNullParameter(activity, "context");
        Intrinsics.checkNotNullParameter(mobileApp, "query");
        FeedUIConfig.Builder builder = FeedUIConfig.builder();
        Intrinsics.checkNotNullExpressionValue(builder, "FeedUIConfig.builder()");
        String appName = mobileApp.getAppName();
        Intrinsics.checkNotNullExpressionValue(appName, "query.appName");
        String uri = Uri.fromParts("packageName", mobileApp.getPackageName(), null).toString();
        Intrinsics.checkNotNullExpressionValue(uri, "Uri.fromParts(\"packageNa…ageName, null).toString()");
        FeedUIConfig build = FeedArgsFactoryKt.applyDiscovery(builder, activity, appName, uri).build();
        Intrinsics.checkNotNullExpressionValue(build, "FeedUIConfig.builder()\n …\n                .build()");
        return build;
    }

    @JvmStatic
    public static final FeedUIConfig uiConfigForAnswerFeed(Activity activity, Feed feed) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(feed, "feed");
        FeedUIConfig.Builder builder = FeedUIConfig.builder();
        Intrinsics.checkNotNullExpressionValue(builder, "FeedUIConfig.builder()");
        FeedUIConfig build = FeedArgsFactoryKt.applyAnswerFeed(builder, activity, feed).build();
        Intrinsics.checkNotNullExpressionValue(build, "FeedUIConfig.builder()\n …\n                .build()");
        return build;
    }

    @JvmStatic
    public static final FeedMultiPart multiPartForAnswerFeed(Activity activity, Feed feed) {
        String str;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(feed, "feed");
        if (Intrinsics.areEqual(feed.getFeedType(), "answer")) {
            str = feed.getFid();
        } else if (Intrinsics.areEqual(feed.getFeedType(), "question")) {
            str = feed.getId();
        } else {
            throw new IllegalStateException("无法找到问题ID");
        }
        FeedMultiPart build = FeedMultiPart.builder().type("answer").feedId(str).messageTitle(feed.getMessageTitle()).build();
        Intrinsics.checkNotNullExpressionValue(build, "FeedMultiPart.builder()\n…\n                .build()");
        return build;
    }

    @JvmStatic
    public static final FeedMultiPart multiPartForShareVideo(Activity activity, ShareFeedInfo shareFeedInfo, String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareFeedInfo, "info");
        FeedMultiPart.Builder type = multiPartForFeed().type("url");
        FeedMultiPart.Builder mediaType = type.message(' ' + str + ' ').extraPic(shareFeedInfo.getLogo()).extraTitle(shareFeedInfo.getTitle()).extraUrl(shareFeedInfo.getUrl()).extraInfo(shareFeedInfo.getDescription()).mediaType(shareFeedInfo.getMediaType());
        String mediaUrl = shareFeedInfo.getMediaUrl();
        String str2 = "";
        if (mediaUrl == null) {
            mediaUrl = str2;
        }
        FeedMultiPart.Builder mediaUrl2 = mediaType.mediaUrl(mediaUrl);
        String mediaPic = shareFeedInfo.getMediaPic();
        if (mediaPic == null) {
            mediaPic = str2;
        }
        FeedMultiPart.Builder mediaPic2 = mediaUrl2.mediaPic(mediaPic);
        String mediaInfo = shareFeedInfo.getMediaInfo();
        if (mediaInfo == null) {
            mediaInfo = str2;
        }
        FeedMultiPart.Builder mediaInfo2 = mediaPic2.mediaInfo(mediaInfo);
        String packageName = shareFeedInfo.getPackageName();
        if (packageName != null) {
            str2 = packageName;
        }
        FeedMultiPart build = mediaInfo2.extraKey(str2).build();
        Intrinsics.checkNotNullExpressionValue(build, "multiPartForFeed()\n     …\n                .build()");
        return build;
    }

    @JvmStatic
    public static final FeedUIConfig uiConfigForShareVideo(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        FeedUIConfig build = uiConfigForFeed(activity).isExtraViewVisible(false).isPickPhotoContainerVisible(false).addPhotoMenuEnable(false).isRemoveExtraViewVisible(true).build();
        Intrinsics.checkNotNullExpressionValue(build, "uiConfigForFeed(activity…\n                .build()");
        return build;
    }

    @JvmStatic
    public static final FeedMultiPart multiPartForShareInfo(Activity activity, ShareFeedInfo shareFeedInfo, List<? extends ImageUrl> list) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareFeedInfo, "info");
        Intrinsics.checkNotNullParameter(list, "list");
        String str = "discovery";
        FeedMultiPart.Builder mediaType = FeedMultiPart.builder().imageUriList(list).type(shareFeedInfo.isDiscovery() ? str : "url").extraPic(shareFeedInfo.getLogo()).extraTitle(shareFeedInfo.getTitle()).extraUrl(shareFeedInfo.getUrl()).extraInfo(shareFeedInfo.getDescription()).mediaType(shareFeedInfo.getMediaType());
        String mediaUrl = shareFeedInfo.getMediaUrl();
        if (mediaUrl == null) {
            mediaUrl = "";
        }
        FeedMultiPart.Builder mediaUrl2 = mediaType.mediaUrl(mediaUrl);
        String mediaPic = shareFeedInfo.getMediaPic();
        if (mediaPic == null) {
            mediaPic = "";
        }
        FeedMultiPart.Builder extraKey = mediaUrl2.mediaPic(mediaPic).message("").extraKey(shareFeedInfo.getPackageName());
        if (!shareFeedInfo.isDiscovery()) {
            str = "feed";
        }
        FeedMultiPart build = extraKey.uploadDir(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "FeedMultiPart.builder()\n…\n                .build()");
        return build;
    }

    @JvmStatic
    public static final FeedUIConfig uiConfigForShareInfo(Activity activity, ShareFeedInfo shareFeedInfo) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareFeedInfo, "info");
        FeedUIConfig.Builder builder = FeedUIConfig.builder();
        Intrinsics.checkNotNullExpressionValue(builder, "FeedUIConfig.builder()");
        Activity activity2 = activity;
        String title = shareFeedInfo.getTitle();
        String str = "";
        if (title == null) {
            title = str;
        }
        Intrinsics.checkNotNullExpressionValue(title, "info.title ?: \"\"");
        String url = shareFeedInfo.getUrl();
        if (url == null) {
            url = str;
        }
        String simpleHost = KotlinExtendKt.getSimpleHost(KotlinExtendKt.asUri(url));
        if (simpleHost == null) {
            simpleHost = str;
        }
        String logo = shareFeedInfo.getLogo();
        if (logo != null) {
            str = logo;
        }
        Intrinsics.checkNotNullExpressionValue(str, "info.logo ?: \"\"");
        FeedUIConfig build = FeedArgsFactoryKt.applyShareInfo(builder, activity2, title, simpleHost, str).build();
        Intrinsics.checkNotNullExpressionValue(build, "FeedUIConfig.builder()\n …\n                .build()");
        return build;
    }

    @JvmStatic
    public static final FeedMultiPart multiPartForShareDyhInfo(Activity activity, ShareFeedInfo shareFeedInfo, List<? extends ImageUrl> list) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareFeedInfo, "info");
        Intrinsics.checkNotNullParameter(list, "list");
        FeedMultiPart.Builder mediaType = FeedMultiPart.builder().imageUriList(list).type("dyh").mediaType(shareFeedInfo.getMediaType());
        String mediaUrl = shareFeedInfo.getMediaUrl();
        String str = "";
        if (mediaUrl == null) {
            mediaUrl = str;
        }
        FeedMultiPart.Builder mediaUrl2 = mediaType.mediaUrl(mediaUrl);
        String mediaPic = shareFeedInfo.getMediaPic();
        if (mediaPic != null) {
            str = mediaPic;
        }
        FeedMultiPart build = mediaUrl2.mediaPic(str).message(shareFeedInfo.getDescription()).messageTitle(shareFeedInfo.getTitle()).extraKey(shareFeedInfo.getPackageName()).uploadDir("feed").build();
        Intrinsics.checkNotNullExpressionValue(build, "FeedMultiPart.builder()\n…\n                .build()");
        return build;
    }

    @JvmStatic
    public static final FeedUIConfig uiConfigForShareDyhInfo(Activity activity, ShareFeedInfo shareFeedInfo) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareFeedInfo, "info");
        FeedUIConfig build = FeedUIConfig.builder().extraViewTitle(shareFeedInfo.getTitle()).extraViewLogoUrl(shareFeedInfo.getLogo()).title("收录到看看号").editTextHint("分享你此刻的想法...").submitToText("选择看看号").isLocationViewVisible(false).isSubmitToViewVisible(true).isEditTitleViewVisible(true).isEditTextViewVisible(true).submitText("投稿").build();
        Intrinsics.checkNotNullExpressionValue(build, "FeedUIConfig.builder()\n …\n                .build()");
        return build;
    }

    @JvmStatic
    public static final FeedUIConfig uiConfigForQuestionTopic(Activity activity, Topic topic) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(topic, "topic");
        FeedUIConfig.Builder relativeLogo = FeedUIConfig.builder().topicTitle(topic.getTitle()).relativeLogo(topic.getLogo());
        FeedUIConfig build = relativeLogo.relativeTitle('#' + topic.getTitle() + '#').build();
        Intrinsics.checkNotNullExpressionValue(build, "FeedUIConfig.builder()\n …\n                .build()");
        return build;
    }

    @JvmStatic
    public static final FeedUIConfig uiConfigForCoolPic(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        FeedUIConfig.Builder builder = FeedUIConfig.builder();
        Intrinsics.checkNotNullExpressionValue(builder, "FeedUIConfig.builder()");
        FeedUIConfig build = FeedArgsFactoryKt.applyCoolPic(builder, activity).build();
        Intrinsics.checkNotNullExpressionValue(build, "FeedUIConfig.builder()\n …\n                .build()");
        return build;
    }

    @JvmStatic
    public static final FeedMultiPart multiPartForCoolPic(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        FeedMultiPart build = FeedMultiPart.builder().type("picture").uploadDir("picture").build();
        Intrinsics.checkNotNullExpressionValue(build, "FeedMultiPart.builder()\n…\n                .build()");
        return build;
    }

    @JvmStatic
    public static final FeedMultiPart multiPartForQuestion(Activity activity, String str, FeedMultiPart feedMultiPart) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "title");
        FeedMultiPart build = FeedMultiPart.builder(feedMultiPart).type("question").messageTitle(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "FeedMultiPart.builder(ol…\n                .build()");
        return build;
    }

    @JvmStatic
    public static final FeedUIConfig uiConfigForQuestion(Activity activity, FeedUIConfig feedUIConfig) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(feedUIConfig, "oldConfig");
        FeedUIConfig.Builder builder = FeedUIConfig.builder(feedUIConfig);
        if (TextUtils.isEmpty(feedUIConfig.title())) {
            builder.title("提问");
        }
        if (TextUtils.isEmpty(feedUIConfig.submitText())) {
            builder.submitText(activity.getString(2131886430));
        }
        if (TextUtils.isEmpty(feedUIConfig.editTitleHint())) {
            builder.editTitleHint("请填下你的问题并以问号结尾");
        }
        if (TextUtils.isEmpty(feedUIConfig.editTextHint())) {
            builder.editTextHint("描述你的问题...");
        }
        FeedUIConfig build = builder.isLocationViewVisible(false).isEditTitleViewVisible(true).isAddExtraItemVisible(false).build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.isLocationViewVi…\n                .build()");
        return build;
    }

    @JvmStatic
    public static final FeedMultiPart.Builder multiPartForVoteComment(Vote vote) {
        Intrinsics.checkNotNullParameter(vote, "vote");
        FeedMultiPart.Builder feedId = FeedMultiPart.builder().type("voteComment").feedId(vote.getId());
        Intrinsics.checkNotNullExpressionValue(feedId, "FeedMultiPart.builder().…         .feedId(vote.id)");
        return feedId;
    }

    @JvmStatic
    public static final FeedUIConfig.Builder uiConfigForVoteComment(Context context, Vote vote) {
        Intrinsics.checkNotNullParameter(context, "activity");
        Intrinsics.checkNotNullParameter(vote, "vote");
        FeedUIConfig.Builder builder = FeedUIConfig.builder();
        Intrinsics.checkNotNullExpressionValue(builder, "FeedUIConfig.builder()");
        return FeedArgsFactoryKt.applyVoteComment(builder, context, vote.getMessageTitle());
    }

    @JvmStatic
    public static final FeedMultiPart.Builder multiPartForVote() {
        FeedMultiPart.Builder type = FeedMultiPart.builder().type("vote");
        Intrinsics.checkNotNullExpressionValue(type, "FeedMultiPart.builder().…(FeedMultiPart.Type.VOTE)");
        return type;
    }

    @JvmStatic
    public static final FeedUIConfig.Builder uiConfigForVote(Context context) {
        Intrinsics.checkNotNullParameter(context, "activity");
        FeedUIConfig.Builder builder = FeedUIConfig.builder();
        Intrinsics.checkNotNullExpressionValue(builder, "FeedUIConfig.builder()");
        return FeedArgsFactoryKt.applyVote(builder, context);
    }

    public static /* synthetic */ FeedMultiPart multiPartForGoods$default(FeedGoods feedGoods, int i, Object obj) {
        if ((i & 1) != 0) {
            feedGoods = null;
        }
        return multiPartForGoods(feedGoods);
    }

    @JvmStatic
    public static final FeedMultiPart multiPartForGoods(FeedGoods feedGoods) {
        FeedMultiPart.Builder multiPartForFeed = multiPartForFeed();
        multiPartForFeed.type("goods");
        if (feedGoods != null) {
            FeedMultiPart.Builder extraKey = multiPartForFeed.extraKey(feedGoods.getId());
            if (feedGoods.getCategoryId() > 0) {
                extraKey.categoryId((int) feedGoods.getCategoryId());
            } else {
                extraKey.categoryId(0);
            }
        }
        FeedMultiPart build = multiPartForFeed.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public static /* synthetic */ FeedUIConfig uiConfigForForwardGoods$default(Activity activity, FeedGoods feedGoods, int i, Object obj) {
        if ((i & 2) != 0) {
            feedGoods = null;
        }
        return uiConfigForForwardGoods(activity, feedGoods);
    }

    @JvmStatic
    public static final FeedUIConfig uiConfigForForwardGoods(Activity activity, FeedGoods feedGoods) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        FeedUIConfig build = FeedUIConfig.builder().title("分享好物").submitText(activity.getString(2131886430)).commentBoardTip1("添加真实详细的好物照片").commentBoardTip2("首图会作为动态封面").editTextHint("分享你推荐的理由（至少50字）").isShareAppItemVisible(false).isAddExtraItemVisible(false).feedGoods(feedGoods).build();
        Intrinsics.checkNotNullExpressionValue(build, "FeedUIConfig.builder()\n …\n                .build()");
        return build;
    }
}
