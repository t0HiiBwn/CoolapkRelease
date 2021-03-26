package com.coolapk.market.view.feedv8;

import android.content.Context;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.model.Product;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.Topic;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\"\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t\u001a\u0012\u0010\u000b\u001a\u00020\f*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\u001a\u0012\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e\u001a\u0012\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\n\u0010\u0010\u001a\u00020\u0001*\u00020\u0001\u001a\u0012\u0010\u0011\u001a\u00020\f*\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u0012\u0010\u0011\u001a\u00020\f*\u00020\f2\u0006\u0010\u0014\u001a\u00020\t\u001a\u001a\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013\u001a\n\u0010\u0015\u001a\u00020\u0001*\u00020\u0001\u001a\u0012\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0017\u001a\u00020\f*\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019\u001a\u0012\u0010\u0017\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0019\u001a*\u0010\u001a\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t\u001a\n\u0010\u001d\u001a\u00020\f*\u00020\f\u001a\u0012\u0010\u001d\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001e\u001a\u00020\t\u001a\u0012\u0010\u001f\u001a\u00020\f*\u00020\f2\u0006\u0010 \u001a\u00020!\u001a\u001a\u0010\u001f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!\u001a\u0012\u0010\"\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001c\u0010#\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\t¨\u0006%"}, d2 = {"applyAnswerFeed", "Lcom/coolapk/market/model/FeedUIConfig$Builder;", "context", "Landroid/content/Context;", "feed", "Lcom/coolapk/market/model/Feed;", "applyCoolPic", "applyDiscovery", "appName", "", "logoUrl", "applyDyh", "Lcom/coolapk/market/model/FeedMultiPart$Builder;", "dyh", "Lcom/coolapk/market/model/DyhModel;", "applyFeed", "applyHtml", "applyProduct", "product", "Lcom/coolapk/market/model/Product;", "id", "applyQuestion", "applySecondHand", "applyServiceApp", "serviceApp", "Lcom/coolapk/market/model/ServiceApp;", "applyShareInfo", "title", "content", "applyToRating", "type", "applyTopic", "topic", "Lcom/coolapk/market/model/Topic;", "applyVote", "applyVoteComment", "messageTitle", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: FeedArgsFactory.kt */
public final class FeedArgsFactoryKt {
    public static final FeedUIConfig.Builder applyDyh(FeedUIConfig.Builder builder, DyhModel dyhModel) {
        Intrinsics.checkNotNullParameter(builder, "$this$applyDyh");
        Intrinsics.checkNotNullParameter(dyhModel, "dyh");
        String title = dyhModel.getTitle();
        String str = "";
        if (title == null) {
            title = str;
        }
        FeedUIConfig.Builder dyhTitle = builder.dyhTitle(title);
        String title2 = dyhModel.getTitle();
        if (title2 == null) {
            title2 = str;
        }
        FeedUIConfig.Builder relativeTitle = dyhTitle.relativeTitle(title2);
        String logo = dyhModel.getLogo();
        if (logo != null) {
            str = logo;
        }
        FeedUIConfig.Builder isPickPhotoContainerVisible = relativeTitle.relativeLogo(str).isPickPhotoContainerVisible(false);
        Intrinsics.checkNotNullExpressionValue(isPickPhotoContainerVisible, "this.dyhTitle(dyh.title.…toContainerVisible(false)");
        return isPickPhotoContainerVisible;
    }

    public static final FeedMultiPart.Builder applyDyh(FeedMultiPart.Builder builder, DyhModel dyhModel) {
        Intrinsics.checkNotNullParameter(builder, "$this$applyDyh");
        Intrinsics.checkNotNullParameter(dyhModel, "dyh");
        FeedMultiPart.Builder dyhId = builder.dyhId(dyhModel.getId());
        Intrinsics.checkNotNullExpressionValue(dyhId, "this.dyhId(dyh.id)");
        return dyhId;
    }

    public static final FeedUIConfig.Builder applyFeed(FeedUIConfig.Builder builder, Context context) {
        Intrinsics.checkNotNullParameter(builder, "$this$applyFeed");
        Intrinsics.checkNotNullParameter(context, "context");
        FeedUIConfig.Builder canAddVideo = builder.title(context.getString(2131886347)).submitText(context.getString(2131886430)).editTextHint(context.getString(2131886947)).canAddVideo(true);
        Intrinsics.checkNotNullExpressionValue(canAddVideo, "this.title(context.getSt…       .canAddVideo(true)");
        return canAddVideo;
    }

    public static final FeedUIConfig.Builder applyHtml(FeedUIConfig.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "$this$applyHtml");
        FeedUIConfig.Builder canAddVideo = builder.title("发布图文").isShowInArticleMode(true).isPreviewable(true).canAddMusic(false).canAddVideo(false);
        Intrinsics.checkNotNullExpressionValue(canAddVideo, "this.title(\"发布图文\")\n     …      .canAddVideo(false)");
        return canAddVideo;
    }

    public static final FeedUIConfig.Builder applyCoolPic(FeedUIConfig.Builder builder, Context context) {
        Intrinsics.checkNotNullParameter(builder, "$this$applyCoolPic");
        Intrinsics.checkNotNullParameter(context, "context");
        FeedUIConfig.Builder editTextHint = builder.title("发布酷图").submitText(context.getString(2131886430)).isSubmitToViewVisible(true).submitToText("选择分类").isAddExtraItemVisible(false).editTextHint("以上传壁纸为主，发布广告、色情、手机截图和无关低质量图片将会被删除并对账号做禁言处理。");
        Intrinsics.checkNotNullExpressionValue(editTextHint, "this.title(\"发布酷图\")\n     …和无关低质量图片将会被删除并对账号做禁言处理。\")");
        return editTextHint;
    }

    public static final FeedUIConfig.Builder applyAnswerFeed(FeedUIConfig.Builder builder, Context context, Feed feed) {
        Intrinsics.checkNotNullParameter(builder, "$this$applyAnswerFeed");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feed, "feed");
        FeedUIConfig.Builder canAddVideo = builder.title("写回答").submitText(context.getString(2131886430)).editTextHint("写回答...").questionTitle(feed.getMessageTitle()).isSubmitToViewVisible(true).isLocationViewVisible(false).submitToText("").isShowInArticleMode(true).isPreviewable(true).isSubmitToViewVisible(false).canAddMusic(false).canAddVideo(false);
        Intrinsics.checkNotNullExpressionValue(canAddVideo, "this.title(\"写回答\")\n      …      .canAddVideo(false)");
        return canAddVideo;
    }

    public static final FeedMultiPart.Builder applyTopic(FeedMultiPart.Builder builder, Topic topic) {
        Intrinsics.checkNotNullParameter(builder, "$this$applyTopic");
        Intrinsics.checkNotNullParameter(topic, "topic");
        FeedMultiPart.Builder targetType = builder.targetType(topic.getTagType() == 1 ? "phone" : "tag");
        FeedMultiPart.Builder targetId = targetType.message('#' + topic.getTitle() + "# ").targetId(topic.getId());
        Intrinsics.checkNotNullExpressionValue(targetId, "this.targetType(type)\n  …      .targetId(topic.id)");
        return targetId;
    }

    public static final FeedUIConfig.Builder applyTopic(FeedUIConfig.Builder builder, Context context, Topic topic) {
        Intrinsics.checkNotNullParameter(builder, "$this$applyTopic");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(topic, "topic");
        FeedUIConfig.Builder builder2 = builder.title("参与话题").submitText(context.getString(2131886430)).editTextHint(topic.getTagType() == 1 ? "点评一下" : "说两句").topicTitle(topic.getTitle());
        String logo = topic.getLogo();
        if (logo == null) {
            logo = "";
        }
        FeedUIConfig.Builder relativeLogo = builder2.relativeLogo(logo);
        FeedUIConfig.Builder isPickPhotoContainerVisible = relativeLogo.relativeTitle('#' + topic.getTitle() + '#').isPickPhotoContainerVisible(false);
        Intrinsics.checkNotNullExpressionValue(isPickPhotoContainerVisible, "title(\"参与话题\")\n          …toContainerVisible(false)");
        return isPickPhotoContainerVisible;
    }

    public static final FeedUIConfig.Builder applySecondHand(FeedUIConfig.Builder builder, Context context) {
        Intrinsics.checkNotNullParameter(builder, "$this$applySecondHand");
        Intrinsics.checkNotNullParameter(context, "context");
        FeedUIConfig.Builder isAnonymousAnswerBarVisible = builder.title("发布二手信息").submitText(context.getString(2131886430)).isEditTitleViewVisible(true).isSecondHandViewVisible(true).editTitleHint("宝贝品牌型号").relativeTitle("选择商品").submitToText("商品价格").relativeLogo("null").editTextHint("写写宝贝的转手原因，入手渠道等具体信息吧").commentBoardTip1("添加真实详细的商品照片").commentBoardTip2("首图会作为动态封面").isAddExtraItemVisible(false).isShareAppItemVisible(false).openKeyboardWhenInit(false).isAnonymousAnswerBarVisible(false);
        Intrinsics.checkNotNullExpressionValue(isAnonymousAnswerBarVisible, "this.title(\"发布二手信息\")\n   …usAnswerBarVisible(false)");
        return isAnonymousAnswerBarVisible;
    }

    public static final FeedUIConfig.Builder applyVote(FeedUIConfig.Builder builder, Context context) {
        Intrinsics.checkNotNullParameter(builder, "$this$applyVote");
        Intrinsics.checkNotNullParameter(context, "context");
        FeedUIConfig.Builder isAnonymousAnswerBarVisible = builder.title("发起投票").submitText(context.getString(2131886430)).editTextHint("投票说明").openKeyboardWhenInit(false).isAddExtraItemVisible(false).editTitleHint("投票标题").isPickPhotoItemVisible(false).isEditTitleViewVisible(true).isPickPhotoContainerVisible(false).isLocationViewVisible(false).isAnonymousAnswerBarVisible(false);
        Intrinsics.checkNotNullExpressionValue(isAnonymousAnswerBarVisible, "this.title(\"发起投票\")\n     …usAnswerBarVisible(false)");
        return isAnonymousAnswerBarVisible;
    }

    public static final FeedUIConfig.Builder applyVoteComment(FeedUIConfig.Builder builder, Context context, String str) {
        Intrinsics.checkNotNullParameter(builder, "$this$applyVoteComment");
        Intrinsics.checkNotNullParameter(context, "context");
        FeedUIConfig.Builder isAnonymousAnswerBarVisible = builder.title("发观点").submitText(context.getString(2131886430)).editTextHint("说说你投票的理由吧").relativeTitle(str).isLocationViewVisible(false).isAnonymousAnswerBarVisible(false);
        Intrinsics.checkNotNullExpressionValue(isAnonymousAnswerBarVisible, "this.title(\"发观点\")\n      …usAnswerBarVisible(false)");
        return isAnonymousAnswerBarVisible;
    }

    public static final FeedMultiPart.Builder applyProduct(FeedMultiPart.Builder builder, String str) {
        Intrinsics.checkNotNullParameter(builder, "$this$applyProduct");
        Intrinsics.checkNotNullParameter(str, "id");
        FeedMultiPart.Builder targetType = builder.targetId(str).targetType("product_phone");
        Intrinsics.checkNotNullExpressionValue(targetType, "this.targetId(id)\n      …TargetType.PRODUCT_PHONE)");
        return targetType;
    }

    public static final FeedMultiPart.Builder applyProduct(FeedMultiPart.Builder builder, Product product) {
        Intrinsics.checkNotNullParameter(builder, "$this$applyProduct");
        Intrinsics.checkNotNullParameter(product, "product");
        FeedMultiPart.Builder targetType = builder.targetId(product.getId()).targetType("product_phone");
        Intrinsics.checkNotNullExpressionValue(targetType, "this.targetId(product.id…TargetType.PRODUCT_PHONE)");
        return targetType;
    }

    public static final FeedMultiPart.Builder applyToRating(FeedMultiPart.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "$this$applyToRating");
        FeedMultiPart.Builder type = builder.type("rating");
        Intrinsics.checkNotNullExpressionValue(type, "this.type(FeedMultiPart.Type.RATING)");
        return type;
    }

    public static final FeedUIConfig.Builder applyToRating(FeedUIConfig.Builder builder, String str) {
        Intrinsics.checkNotNullParameter(builder, "$this$applyToRating");
        Intrinsics.checkNotNullParameter(str, "type");
        FeedUIConfig.Builder isAnonymousAnswerBarVisible = builder.title("发点评").isAnonymousAnswerBarVisible(false);
        if (Intrinsics.areEqual(str, "apk")) {
            isAnonymousAnswerBarVisible.editTextHint("说一说你对这个应用的评价吧（可选）");
        } else if (Intrinsics.areEqual(str, "product_phone")) {
            isAnonymousAnswerBarVisible.editTextHint("说一说你对这个产品的评价吧（可选）");
        }
        Intrinsics.checkNotNullExpressionValue(isAnonymousAnswerBarVisible, "this.title(\"发点评\")\n      …          }\n            }");
        return isAnonymousAnswerBarVisible;
    }

    public static final FeedUIConfig.Builder applyDiscovery(FeedUIConfig.Builder builder, Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(builder, "$this$applyDiscovery");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "appName");
        Intrinsics.checkNotNullParameter(str2, "logoUrl");
        FeedUIConfig.Builder submitText = builder.extraViewTitle(str).extraViewLogoUrl(str2).isExtraViewVisible(true).title(context.getString(2131886347)).submitText(context.getString(2131886430));
        Intrinsics.checkNotNullExpressionValue(submitText, "this.extraViewTitle(appN…(R.string.menu_add_feed))");
        return submitText;
    }

    public static final FeedUIConfig.Builder applyProduct(FeedUIConfig.Builder builder, Context context, Product product) {
        Intrinsics.checkNotNullParameter(builder, "$this$applyProduct");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(product, "product");
        String logo = product.getLogo();
        if (logo == null) {
            logo = "";
        }
        FeedUIConfig.Builder openKeyboardWhenInit = builder.relativeLogo(logo).relativeTitle(product.getTitle()).isFeedTargetPhoneOrTablet(EntityExtendsKt.isPhoneOrTablet(product)).openKeyboardWhenInit(false);
        Intrinsics.checkNotNullExpressionValue(openKeyboardWhenInit, "relativeLogo(product.log…enKeyboardWhenInit(false)");
        return openKeyboardWhenInit;
    }

    public static final FeedUIConfig.Builder applyShareInfo(FeedUIConfig.Builder builder, Context context, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(builder, "$this$applyShareInfo");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "content");
        Intrinsics.checkNotNullParameter(str3, "logoUrl");
        FeedUIConfig.Builder canAddVideo = builder.extraViewTitle(str).extraViewContent(str2).extraViewLogoUrl(str3).isExtraViewVisible(true).title(context.getString(2131886347)).editTextHint("分享你此刻的想法...").submitText(context.getString(2131886430)).canAddVideo(true);
        Intrinsics.checkNotNullExpressionValue(canAddVideo, "this.extraViewTitle(titl…       .canAddVideo(true)");
        return canAddVideo;
    }

    public static final FeedUIConfig.Builder applyServiceApp(FeedUIConfig.Builder builder, ServiceApp serviceApp) {
        Intrinsics.checkNotNullParameter(builder, "$this$applyServiceApp");
        Intrinsics.checkNotNullParameter(serviceApp, "serviceApp");
        FeedUIConfig.Builder editTextHint = builder.title("发评论").editTextHint("评论一下吧...");
        String logo = serviceApp.getLogo();
        if (logo == null) {
            logo = "";
        }
        FeedUIConfig.Builder isPickPhotoContainerVisible = editTextHint.relativeLogo(logo).relativeTitle(serviceApp.getAppName()).isPickPhotoContainerVisible(false);
        Intrinsics.checkNotNullExpressionValue(isPickPhotoContainerVisible, "title(\"发评论\")\n           …toContainerVisible(false)");
        return isPickPhotoContainerVisible;
    }

    public static final FeedUIConfig.Builder applyQuestion(FeedUIConfig.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "$this$applyQuestion");
        FeedUIConfig.Builder canAddVideo = builder.isPickPhotoContainerVisible(false).canAddVideo(true);
        Intrinsics.checkNotNullExpressionValue(canAddVideo, "this.isPickPhotoContaine…       .canAddVideo(true)");
        return canAddVideo;
    }

    public static final FeedMultiPart.Builder applyServiceApp(FeedMultiPart.Builder builder, ServiceApp serviceApp) {
        Intrinsics.checkNotNullParameter(builder, "$this$applyServiceApp");
        Intrinsics.checkNotNullParameter(serviceApp, "serviceApp");
        FeedMultiPart.Builder targetType = builder.type("comment").targetType("apk");
        String targetId = serviceApp.getTargetId();
        if (targetId == null) {
            targetId = "";
        }
        FeedMultiPart.Builder targetId2 = targetType.targetId(targetId);
        Intrinsics.checkNotNullExpressionValue(targetId2, "type(FeedMultiPart.Type.…ceApp.targetId.orEmpty())");
        return targetId2;
    }
}
