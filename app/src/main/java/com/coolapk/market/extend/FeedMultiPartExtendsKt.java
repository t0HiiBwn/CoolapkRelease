package com.coolapk.market.extend;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.util.EntityConvertUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006\u001a\f\u0010\t\u001a\u0004\u0018\u00010\u0006*\u00020\u0002\u001a\f\u0010\t\u001a\u0004\u0018\u00010\u0006*\u00020\u0007\u001a\u0014\u0010\n\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u000b"}, d2 = {"hasUserInputContent", "", "Lcom/coolapk/market/model/FeedMultiPart;", "loadJson", "Lcom/coolapk/market/model/FeedMultiPart$Builder;", "obj", "Lorg/json/JSONObject;", "Lcom/coolapk/market/model/FeedUIConfig;", "Lcom/coolapk/market/model/FeedUIConfig$Builder;", "toJson", "update", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: FeedMultiPartExtends.kt */
public final class FeedMultiPartExtendsKt {
    public static final boolean hasUserInputContent(FeedMultiPart feedMultiPart) {
        Intrinsics.checkNotNullParameter(feedMultiPart, "$this$hasUserInputContent");
        String message = feedMultiPart.message();
        Intrinsics.checkNotNullExpressionValue(message, "message()");
        if (!StringsKt.isBlank(message)) {
            return true;
        }
        List<ImageUrl> imageUriList = feedMultiPart.imageUriList();
        Intrinsics.checkNotNullExpressionValue(imageUriList, "imageUriList()");
        if (!imageUriList.isEmpty()) {
            return true;
        }
        String commentBad = feedMultiPart.commentBad();
        Intrinsics.checkNotNullExpressionValue(commentBad, "commentBad()");
        if (!StringsKt.isBlank(commentBad)) {
            return true;
        }
        String commentGood = feedMultiPart.commentGood();
        Intrinsics.checkNotNullExpressionValue(commentGood, "commentGood()");
        if (!StringsKt.isBlank(commentGood)) {
            return true;
        }
        String commentGeneral = feedMultiPart.commentGeneral();
        Intrinsics.checkNotNullExpressionValue(commentGeneral, "commentGeneral()");
        if (!StringsKt.isBlank(commentGeneral)) {
            return true;
        }
        String secondHandOutLink = feedMultiPart.secondHandOutLink();
        Intrinsics.checkNotNullExpressionValue(secondHandOutLink, "secondHandOutLink()");
        if (!StringsKt.isBlank(secondHandOutLink)) {
            return true;
        }
        if (!Intrinsics.areEqual(feedMultiPart.type(), "answer")) {
            String messageTitle = feedMultiPart.messageTitle();
            Intrinsics.checkNotNullExpressionValue(messageTitle, "messageTitle()");
            if (!StringsKt.isBlank(messageTitle)) {
                return true;
            }
        }
        if (!Intrinsics.areEqual(feedMultiPart.type(), "vote")) {
            return false;
        }
        List<String> voteOptions = feedMultiPart.voteOptions();
        Intrinsics.checkNotNullExpressionValue(voteOptions, "voteOptions()");
        if (!voteOptions.isEmpty()) {
            return true;
        }
        return false;
    }

    public static final JSONObject toJson(FeedMultiPart feedMultiPart) {
        Intrinsics.checkNotNullParameter(feedMultiPart, "$this$toJson");
        List<ImageUrl> imageUriList = feedMultiPart.imageUriList();
        JSONArray jSONArray = new JSONArray();
        for (ImageUrl imageUrl : imageUriList) {
            JSONObject jSONObject = new JSONObject();
            Intrinsics.checkNotNullExpressionValue(imageUrl, "x");
            jSONArray.put(jSONObject.put("sourceUrl", imageUrl.getSourceUrl()).put("compressedUrl", imageUrl.getCompressedUrl()));
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("message", feedMultiPart.message());
        jSONObject2.put("type", feedMultiPart.type());
        jSONObject2.put("isHtmlArticle", feedMultiPart.isHtmlArticle());
        jSONObject2.put("imageUriList", jSONArray);
        jSONObject2.put("visibleStatus", feedMultiPart.visibleStatus());
        jSONObject2.put("location", feedMultiPart.location());
        jSONObject2.put("longLocation", feedMultiPart.longLocation());
        jSONObject2.put("latitude", feedMultiPart.latitude());
        jSONObject2.put("longitude", feedMultiPart.longitude());
        jSONObject2.put("mediaUrl", feedMultiPart.mediaUrl());
        jSONObject2.put("mediaType", feedMultiPart.mediaType());
        jSONObject2.put("mediaPic", feedMultiPart.mediaPic());
        jSONObject2.put("messageBrief", feedMultiPart.messageBrief());
        jSONObject2.put("extraTitle", feedMultiPart.extraTitle());
        jSONObject2.put("extraUrl", feedMultiPart.extraUrl());
        jSONObject2.put("extraKey", feedMultiPart.extraKey());
        jSONObject2.put("extraPic", feedMultiPart.extraPic());
        jSONObject2.put("extraInfo", feedMultiPart.extraInfo());
        jSONObject2.put("messageTitle", feedMultiPart.messageTitle());
        jSONObject2.put("messageCover", feedMultiPart.messageCover());
        jSONObject2.put("isDisallowRepost", feedMultiPart.isDisallowRepost());
        jSONObject2.put("isAnonymous", feedMultiPart.isAnonymous());
        jSONObject2.put("isEditInDyh", feedMultiPart.isEditInDyh());
        jSONObject2.put("dyhId", feedMultiPart.dyhId());
        jSONObject2.put("forwardId", feedMultiPart.forwardId());
        jSONObject2.put("isReplyWithForward", feedMultiPart.isReplyWithForward());
        jSONObject2.put("feedId", feedMultiPart.feedId());
        jSONObject2.put("targetType", feedMultiPart.targetType());
        jSONObject2.put("targetId", feedMultiPart.targetId());
        jSONObject2.put("voteScore", feedMultiPart.voteScore());
        jSONObject2.put("pic", feedMultiPart.pic());
        jSONObject2.put("locationCity", feedMultiPart.locationCity());
        jSONObject2.put("locationCountry", feedMultiPart.locationCountry());
        jSONObject2.put("isDisallowReply", feedMultiPart.isDisallowReply());
        jSONObject2.put("uploadDir", feedMultiPart.uploadDir());
        jSONObject2.put("compressFlag", feedMultiPart.compressFlag());
        jSONObject2.put("mediaInfo", feedMultiPart.mediaInfo());
        jSONObject2.put("insertProductMedia", feedMultiPart.insertProductMedia());
        jSONObject2.put("secondHandOutLink", feedMultiPart.secondHandOutLink());
        jSONObject2.put("secondHandPrice", feedMultiPart.secondHandPrice());
        jSONObject2.put("secondHandSthType", feedMultiPart.secondHandSthType());
        jSONObject2.put("agree", feedMultiPart.agree());
        jSONObject2.put("secondHandType", feedMultiPart.secondHandType());
        jSONObject2.put("productConfig", feedMultiPart.productConfig());
        jSONObject2.put("productId", feedMultiPart.productId());
        jSONObject2.put("risePriceType", feedMultiPart.risePriceType());
        jSONObject2.put("voteType", feedMultiPart.voteType());
        jSONObject2.put("voteAnonymousStatus", feedMultiPart.voteAnonymousStatus());
        jSONObject2.put("voteEndTime", feedMultiPart.voteEndTime());
        jSONObject2.put("voteMaxSelectNum", feedMultiPart.voteMaxSelectNum());
        jSONObject2.put("voteMinSelectNum", feedMultiPart.voteMinSelectNum());
        JSONArray jSONArray2 = new JSONArray();
        for (String str : feedMultiPart.voteOptions()) {
            jSONArray2.put(str);
        }
        jSONObject2.put("voteOptions", jSONArray2);
        jSONObject2.put("voteTag", feedMultiPart.voteTag());
        jSONObject2.put("votePage", feedMultiPart.votePage());
        jSONObject2.put("voteShowAuthor", feedMultiPart.voteShowAuthor());
        JSONArray jSONArray3 = new JSONArray();
        for (String str2 : feedMultiPart.voteOptionColors()) {
            jSONArray3.put(str2);
        }
        jSONObject2.put("voteOptionColors", jSONArray3);
        jSONObject2.put("secondHandOutLink", feedMultiPart.secondHandOutLink());
        jSONObject2.put("secondHandPrice", feedMultiPart.secondHandPrice());
        jSONObject2.put("secondHandSthType", feedMultiPart.secondHandSthType());
        jSONObject2.put("agree", feedMultiPart.agree());
        jSONObject2.put("secondHandType", feedMultiPart.secondHandType());
        jSONObject2.put("productConfig", feedMultiPart.productConfig());
        jSONObject2.put("productId", feedMultiPart.productId());
        jSONObject2.put("secondHandDealType", feedMultiPart.secondHandDealType());
        jSONObject2.put("secondHandFaceDeal", feedMultiPart.secondHandFaceDeal());
        jSONObject2.put("version", feedMultiPart.version());
        jSONObject2.put("ratingScore1", feedMultiPart.ratingScore1());
        jSONObject2.put("commentBad", feedMultiPart.commentBad());
        jSONObject2.put("commentBadPic", feedMultiPart.commentBadPic());
        jSONObject2.put("commentGeneral", feedMultiPart.commentGeneral());
        jSONObject2.put("commentGeneralPic", feedMultiPart.commentGeneralPic());
        jSONObject2.put("commentGood", feedMultiPart.commentGood());
        jSONObject2.put("commentGoodPic", feedMultiPart.commentGoodPic());
        jSONObject2.put("buyStatus", feedMultiPart.buyStatus());
        jSONObject2.put("categoryId", feedMultiPart.categoryId());
        return jSONObject2;
    }

    public static final FeedMultiPart loadJson(FeedMultiPart.Builder builder, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(builder, "$this$loadJson");
        Intrinsics.checkNotNullParameter(jSONObject, "obj");
        builder.message(jSONObject.optString("message"));
        builder.type(jSONObject.optString("type"));
        builder.isHtmlArticle(jSONObject.optBoolean("isHtmlArticle"));
        JSONArray optJSONArray = jSONObject.optJSONArray("imageUriList");
        ArrayList arrayList = new ArrayList(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            arrayList.add(ImageUrl.builder().setCompressedUrl(jSONObject2.getString("compressedUrl")).setSourceUrl(jSONObject2.getString("sourceUrl")).build());
        }
        builder.imageUriList(arrayList);
        builder.visibleStatus(jSONObject.optInt("visibleStatus"));
        builder.location(jSONObject.optString("location"));
        builder.longLocation(jSONObject.optString("longLocation"));
        builder.latitude(jSONObject.optDouble("latitude"));
        builder.longitude(jSONObject.optDouble("longitude"));
        builder.mediaUrl(jSONObject.optString("mediaUrl"));
        builder.mediaType(jSONObject.optInt("mediaType"));
        builder.mediaPic(jSONObject.optString("mediaPic"));
        builder.messageBrief(jSONObject.optString("messageBrief"));
        builder.extraTitle(jSONObject.optString("extraTitle"));
        builder.extraUrl(jSONObject.optString("extraUrl"));
        builder.extraKey(jSONObject.optString("extraKey"));
        builder.extraPic(jSONObject.optString("extraPic"));
        builder.extraInfo(jSONObject.optString("extraInfo"));
        builder.messageTitle(jSONObject.optString("messageTitle"));
        builder.messageCover(jSONObject.optString("messageCover"));
        builder.isDisallowRepost(jSONObject.optBoolean("isDisallowRepost"));
        builder.isAnonymous(jSONObject.optBoolean("isAnonymous"));
        builder.isEditInDyh(jSONObject.optBoolean("isEditInDyh"));
        builder.forwardId(jSONObject.optString("forwardId"));
        builder.dyhId(jSONObject.optString("dyhId"));
        builder.isReplyWithForward(jSONObject.optBoolean("isReplyWithForward"));
        builder.feedId(jSONObject.optString("feedId"));
        builder.targetType(jSONObject.optString("targetType"));
        builder.targetId(jSONObject.optString("targetId"));
        builder.voteScore(jSONObject.optInt("voteScore"));
        builder.pic(jSONObject.optString("pic"));
        builder.locationCity(jSONObject.optString("locationCity"));
        builder.locationCountry(jSONObject.optString("locationCountry"));
        builder.isDisallowReply(jSONObject.optBoolean("isDisallowReply"));
        builder.uploadDir(jSONObject.optString("uploadDir"));
        builder.compressFlag(jSONObject.optInt("compressFlag"));
        builder.mediaInfo(jSONObject.optString("mediaInfo"));
        builder.insertProductMedia(jSONObject.optBoolean("insertProductMedia"));
        builder.productConfig(jSONObject.optString("productConfig"));
        builder.secondHandSthType(jSONObject.optString("secondHandSthType"));
        builder.secondHandOutLink(jSONObject.optString("secondHandOutLink"));
        builder.secondHandPrice(jSONObject.optString("secondHandPrice"));
        builder.secondHandType(jSONObject.optInt("secondHandType"));
        builder.productId(jSONObject.optString("productId"));
        builder.agree(jSONObject.getInt("agree"));
        builder.secondHandFaceDeal(jSONObject.optInt("secondHandFaceDeal"));
        builder.secondHandDealType(jSONObject.optInt("secondHandDealType"));
        builder.agree(jSONObject.optInt("agree"));
        builder.agree(jSONObject.optInt("risePriceType"));
        builder.voteType(jSONObject.optInt("voteType", 0));
        builder.voteAnonymousStatus(jSONObject.optInt("voteAnonymousStatus", 1));
        builder.voteEndTime(jSONObject.optLong("voteEndTime", 604800));
        builder.voteMaxSelectNum(jSONObject.optInt("voteMaxSelectNum", 1));
        builder.voteMinSelectNum(jSONObject.optInt("voteMinSelectNum", 1));
        JSONArray optJSONArray2 = jSONObject.optJSONArray("voteOptions");
        ArrayList arrayList2 = new ArrayList();
        if (optJSONArray2 != null) {
            int length = optJSONArray2.length();
            for (int i2 = 0; i2 < length; i2++) {
                arrayList2.add(optJSONArray2.getString(i2));
            }
        }
        builder.voteOptions(arrayList2);
        builder.voteTag(jSONObject.optString("voteTag", ""));
        builder.votePage(jSONObject.optString("votePage", ""));
        builder.voteShowAuthor(jSONObject.optInt("voteShowAuthor", 1));
        JSONArray optJSONArray3 = jSONObject.optJSONArray("voteOptionColors");
        ArrayList arrayList3 = new ArrayList();
        if (optJSONArray3 != null) {
            int length2 = optJSONArray3.length();
            for (int i3 = 0; i3 < length2; i3++) {
                arrayList3.add(optJSONArray3.getString(i3));
            }
        }
        builder.voteOptionColors(arrayList3);
        builder.version(jSONObject.optInt("version", 0));
        builder.ratingScore1(jSONObject.optInt("ratingScore1", 0));
        builder.commentBad(jSONObject.optString("commentBad"));
        builder.commentBadPic(jSONObject.optString("commentBadPic"));
        builder.commentGeneral(jSONObject.optString("commentGeneral"));
        builder.commentGeneralPic(jSONObject.optString("commentGeneralPic"));
        builder.commentGood(jSONObject.optString("commentGood"));
        builder.commentGoodPic(jSONObject.optString("commentGoodPic"));
        builder.buyStatus(jSONObject.optBoolean("buyStatus"));
        builder.categoryId(jSONObject.optInt("categoryId", 0));
        FeedMultiPart build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "this.build()");
        return update(build, jSONObject);
    }

    public static final JSONObject toJson(FeedUIConfig feedUIConfig) {
        Intrinsics.checkNotNullParameter(feedUIConfig, "$this$toJson");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("title", feedUIConfig.title());
        jSONObject.put("subtitle", feedUIConfig.subtitle());
        jSONObject.put("isRatingBarVisible", feedUIConfig.isRatingBarVisible());
        jSONObject.put("isRatingBarBackgroundVisible", feedUIConfig.isRatingBarBackgroundVisible());
        jSONObject.put("isLocationViewVisible", feedUIConfig.isLocationViewVisible());
        jSONObject.put("isSwitchArticleViewVisible", feedUIConfig.isSwitchArticleViewVisible());
        jSONObject.put("isPublicViewVisible", feedUIConfig.isPublicViewVisible());
        jSONObject.put("isForward", feedUIConfig.isForward());
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        jSONObject.put("forwardEntity", instance.getGson().toJson(feedUIConfig.forwardEntity()));
        jSONObject.put("isForwardAndCommentViewVisible", feedUIConfig.isForwardAndCommentViewVisible());
        jSONObject.put("isExtraViewVisible", feedUIConfig.isExtraViewVisible());
        jSONObject.put("extraViewLogoUrl", feedUIConfig.extraViewLogoUrl());
        jSONObject.put("extraViewTitle", feedUIConfig.extraViewTitle());
        jSONObject.put("isCoolPicCategoryBarVisible", feedUIConfig.isCoolPicCategoryBarVisible());
        jSONObject.put("isAnonymousAnswerBarVisible", feedUIConfig.isAnonymousAnswerBarVisible());
        jSONObject.put("isSubmitTargetBarVisible", feedUIConfig.isSubmitTargetBarVisible());
        jSONObject.put("isAnonymousQuestionViewVisible", feedUIConfig.isAnonymousQuestionViewVisible());
        jSONObject.put("isEditCoverViewVisible", feedUIConfig.isEditCoverViewVisible());
        jSONObject.put("isEditTitleViewVisible", feedUIConfig.isEditTitleViewVisible());
        jSONObject.put("isEditTextViewVisible", feedUIConfig.isEditTextViewVisible());
        jSONObject.put("editTitleHint", feedUIConfig.editTitleHint());
        jSONObject.put("editTextHint", feedUIConfig.editTextHint());
        jSONObject.put("isAddApkItemVisible", feedUIConfig.isAddApkItemVisible());
        jSONObject.put("isPickPhotoItemVisible", feedUIConfig.isPickPhotoItemVisible());
        jSONObject.put("isPickPhotoContainerVisible", feedUIConfig.isPickPhotoContainerVisible());
        jSONObject.put("isAddExtraItemVisible", feedUIConfig.isAddExtraItemVisible());
        jSONObject.put("isRichTextItemVisible", feedUIConfig.isRichTextItemVisible());
        jSONObject.put("submitText", feedUIConfig.submitText());
        jSONObject.put("submitToText", feedUIConfig.submitToText());
        jSONObject.put("isSubmitToViewVisible", feedUIConfig.isSubmitToViewVisible());
        jSONObject.put("extraViewContent", feedUIConfig.extraViewContent());
        jSONObject.put("locationName", feedUIConfig.locationName());
        jSONObject.put("tintMarkView", feedUIConfig.tintMarkView());
        jSONObject.put("visibleState", feedUIConfig.visibleState());
        jSONObject.put("extraLinkType", feedUIConfig.extraLinkType());
        jSONObject.put("isForwardAndReplyChecked", feedUIConfig.isForwardAndReplyChecked());
        jSONObject.put("isRemoveExtraViewVisible", feedUIConfig.isRemoveExtraViewVisible());
        jSONObject.put("isMenuItemEnabled", feedUIConfig.isMenuItemEnabled());
        jSONObject.put("isShowInArticleMode", feedUIConfig.isShowInArticleMode());
        jSONObject.put("topicTitle", feedUIConfig.topicTitle());
        jSONObject.put("questionTitle", feedUIConfig.questionTitle());
        jSONObject.put("isPreviewable", feedUIConfig.isPreviewable());
        jSONObject.put("dyhTitle", feedUIConfig.dyhTitle());
        jSONObject.put("relativeLogo", feedUIConfig.relativeLogo());
        jSONObject.put("relativeTitle", feedUIConfig.relativeTitle());
        jSONObject.put("canAddVideo", feedUIConfig.canAddVideo());
        jSONObject.put("canAddMusic", feedUIConfig.canAddMusic());
        jSONObject.put("addPhotoMenuEnable", feedUIConfig.addPhotoMenuEnable());
        jSONObject.put("maxPickPhotoCount", feedUIConfig.maxPickPhotoCount());
        jSONObject.put("openKeyboardWhenInit", feedUIConfig.openKeyboardWhenInit());
        jSONObject.put("isSecondHandViewVisible", feedUIConfig.isSecondHandViewVisible());
        jSONObject.put("secondHandOutLink", feedUIConfig.secondHandOutLink());
        jSONObject.put("secondHandPrice", feedUIConfig.secondHandPrice());
        jSONObject.put("secondHandType", feedUIConfig.secondHandType());
        jSONObject.put("productConfigShowText", feedUIConfig.productConfigShowText());
        jSONObject.put("productConfigCacheList", feedUIConfig.productConfigCacheList());
        jSONObject.put("commentBoardTip1", feedUIConfig.commentBoardTip1());
        jSONObject.put("commentBoardTip2", feedUIConfig.commentBoardTip2());
        jSONObject.put("isSecondHandViewVisible", feedUIConfig.isSecondHandViewVisible());
        jSONObject.put("secondHandOutLink", feedUIConfig.secondHandOutLink());
        jSONObject.put("secondHandPrice", feedUIConfig.secondHandPrice());
        jSONObject.put("secondHandType", feedUIConfig.secondHandType());
        jSONObject.put("productConfigShowText", feedUIConfig.productConfigShowText());
        jSONObject.put("productConfigCacheList", feedUIConfig.productConfigCacheList());
        jSONObject.put("commentBoardTip1", feedUIConfig.commentBoardTip1());
        jSONObject.put("commentBoardTip2", feedUIConfig.commentBoardTip2());
        jSONObject.put("secondHandDealType", feedUIConfig.secondHandDealType());
        jSONObject.put("secondHandFaceDeal", feedUIConfig.secondHandFaceDeal());
        jSONObject.put("isProductPicked", feedUIConfig.isProductPicked());
        jSONObject.put("version", feedUIConfig.version());
        jSONObject.put("isRatingTextCollapsed", feedUIConfig.isRatingTextCollapsed());
        jSONObject.put("relativeInfoPickable", feedUIConfig.relativeInfoPickable());
        DataManager instance2 = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
        jSONObject.put("feedGoods", instance2.getGson().toJson(feedUIConfig.feedGoods()));
        jSONObject.put("isFeedGoodsClosable", feedUIConfig.isFeedGoodsClosable());
        jSONObject.put("isFeedTargetPhoneOrTablet", feedUIConfig.isFeedTargetPhoneOrTablet());
        jSONObject.put("isShowAddGoodsInMenuBar", feedUIConfig.isShowAddGoodsInMenuBar());
        List<Entity> extraEntities = feedUIConfig.extraEntities();
        Intrinsics.checkNotNullExpressionValue(extraEntities, "extraEntities()");
        List<Entity> list = extraEntities;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            arrayList.add(t.getEntityType());
        }
        jSONObject.put("extraEntityTypes", CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, null, 63, null));
        DataManager instance3 = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance3, "DataManager.getInstance()");
        jSONObject.put("extraEntities", instance3.getGson().toJson(feedUIConfig.extraEntities()));
        return jSONObject;
    }

    public static final FeedUIConfig loadJson(FeedUIConfig.Builder builder, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(builder, "$this$loadJson");
        Intrinsics.checkNotNullParameter(jSONObject, "obj");
        builder.title(jSONObject.optString("title"));
        builder.subtitle(jSONObject.optString("subtitle"));
        builder.isRatingBarVisible(jSONObject.optBoolean("isRatingBarVisible"));
        builder.isRatingBarBackgroundVisible(jSONObject.optBoolean("isRatingBarBackgroundVisible"));
        builder.isLocationViewVisible(jSONObject.optBoolean("isLocationViewVisible"));
        builder.isSwitchArticleViewVisible(jSONObject.optBoolean("isSwitchArticleViewVisible"));
        builder.isPublicViewVisible(jSONObject.optBoolean("isPublicViewVisible"));
        builder.isForward(jSONObject.optBoolean("isForward"));
        builder.forwardEntity(DataManager.getInstance().parseJsonToEntity(jSONObject.optString("forwardEntity")));
        builder.isForwardAndCommentViewVisible(jSONObject.optBoolean("isForwardAndCommentViewVisible"));
        builder.isExtraViewVisible(jSONObject.optBoolean("isExtraViewVisible"));
        builder.extraViewLogoUrl(jSONObject.optString("extraViewLogoUrl"));
        builder.extraViewTitle(jSONObject.optString("extraViewTitle"));
        builder.isCoolPicCategoryBarVisible(jSONObject.optBoolean("isCoolPicCategoryBarVisible"));
        builder.isAnonymousAnswerBarVisible(jSONObject.optBoolean("isAnonymousAnswerBarVisible"));
        builder.isSubmitTargetBarVisible(jSONObject.optBoolean("isSubmitTargetBarVisible"));
        builder.isAnonymousQuestionViewVisible(jSONObject.optBoolean("isAnonymousQuestionViewVisible"));
        builder.isEditCoverViewVisible(jSONObject.optBoolean("isEditCoverViewVisible"));
        builder.isEditTitleViewVisible(jSONObject.optBoolean("isEditTitleViewVisible"));
        builder.isEditTextViewVisible(jSONObject.optBoolean("isEditTextViewVisible"));
        builder.editTitleHint(jSONObject.optString("editTitleHint"));
        builder.editTextHint(jSONObject.optString("editTextHint"));
        builder.isAddApkItemVisible(jSONObject.optBoolean("isAddApkItemVisible"));
        builder.isPickPhotoItemVisible(jSONObject.optBoolean("isPickPhotoItemVisible"));
        builder.isPickPhotoContainerVisible(jSONObject.optBoolean("isPickPhotoContainerVisible", true));
        builder.isAddExtraItemVisible(jSONObject.optBoolean("isAddExtraItemVisible"));
        builder.isRichTextItemVisible(jSONObject.optBoolean("isRichTextItemVisible"));
        builder.submitText(jSONObject.optString("submitText"));
        builder.submitToText(jSONObject.optString("submitToText"));
        builder.isSubmitToViewVisible(jSONObject.optBoolean("isSubmitToViewVisible"));
        builder.extraViewContent(jSONObject.optString("extraViewContent"));
        builder.locationName(jSONObject.optString("locationName"));
        builder.tintMarkView(jSONObject.optBoolean("tintMarkView"));
        builder.visibleState(jSONObject.optInt("visibleState"));
        builder.extraLinkType(jSONObject.optInt("extraLinkType"));
        builder.isForwardAndReplyChecked(jSONObject.optBoolean("isForwardAndReplyChecked"));
        builder.isRemoveExtraViewVisible(jSONObject.optBoolean("isRemoveExtraViewVisible"));
        builder.isMenuItemEnabled(jSONObject.optBoolean("isMenuItemEnabled"));
        builder.isShowInArticleMode(jSONObject.optBoolean("isShowInArticleMode"));
        builder.topicTitle(jSONObject.optString("topicTitle"));
        builder.questionTitle(jSONObject.optString("questionTitle"));
        builder.isPreviewable(jSONObject.optBoolean("isPreviewable", jSONObject.optBoolean("isPreviewable")));
        builder.dyhTitle(jSONObject.optString("dyhTitle"));
        builder.relativeLogo(jSONObject.optString("relativeLogo"));
        builder.relativeTitle(jSONObject.optString("relativeTitle"));
        builder.canAddVideo(jSONObject.optBoolean("canAddVideo"));
        builder.canAddMusic(jSONObject.optBoolean("canAddMusic"));
        builder.addPhotoMenuEnable(jSONObject.optBoolean("addPhotoMenuEnable"));
        builder.maxPickPhotoCount(jSONObject.optInt("maxPickPhotoCount", 9));
        builder.openKeyboardWhenInit(jSONObject.optBoolean("openKeyboardWhenInit", true));
        builder.secondHandPrice(jSONObject.optString("secondHandPrice"));
        int i = 0;
        builder.secondHandType(jSONObject.optInt("secondHandType", 0));
        builder.secondHandOutLink(jSONObject.optString("secondHandOutLink"));
        builder.productConfigShowText(jSONObject.optString("productConfigShowText"));
        builder.isSecondHandViewVisible(jSONObject.optBoolean("isSecondHandViewVisible"));
        builder.commentBoardTip1(jSONObject.optString("commentBoardTip1"));
        builder.commentBoardTip2(jSONObject.optString("commentBoardTip2"));
        builder.secondHandFaceDeal(jSONObject.optInt("secondHandFaceDeal"));
        builder.secondHandDealType(jSONObject.optInt("secondHandDealType"));
        builder.isProductPicked(jSONObject.optBoolean("isProductPicked", false));
        builder.version(jSONObject.optInt("version", 0));
        builder.isRatingTextCollapsed(jSONObject.optBoolean("isRatingTextCollapsed", false));
        builder.relativeInfoPickable(jSONObject.optBoolean("relativeInfoPickable", false));
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        builder.feedGoods((FeedGoods) instance.getGson().fromJson(jSONObject.optString("feedGoods"), (Class<Object>) FeedGoods.class));
        builder.isFeedGoodsClosable(jSONObject.optBoolean("isFeedGoodsClosable", true));
        builder.isFeedTargetPhoneOrTablet(jSONObject.optBoolean("isFeedTargetPhoneOrTablet", false));
        builder.isShowAddGoodsInMenuBar(jSONObject.optBoolean("isShowAddGoodsInMenuBar", true));
        try {
            String optString = jSONObject.optString("extraEntityTypes", "");
            Intrinsics.checkNotNullExpressionValue(optString, "obj.optString(\"extraEntityTypes\", \"\")");
            List split$default = StringsKt.split$default((CharSequence) optString, new String[]{","}, false, 0, 6, (Object) null);
            if (true ^ split$default.isEmpty()) {
                DataManager instance2 = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
                Gson gson = instance2.getGson();
                ArrayList arrayList = new ArrayList();
                JsonElement parse = new JsonParser().parse(jSONObject.optString("extraEntities"));
                Intrinsics.checkNotNullExpressionValue(parse, "JsonParser().parse(obj.optString(\"extraEntities\"))");
                JsonArray asJsonArray = parse.getAsJsonArray();
                Intrinsics.checkNotNullExpressionValue(asJsonArray, "jsonArray");
                for (Object obj : asJsonArray) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    JsonElement jsonElement = (JsonElement) obj;
                    Intrinsics.checkNotNullExpressionValue(jsonElement, "ele");
                    Entity handleType = EntityConvertUtils.handleType(gson, jsonElement.getAsJsonObject(), (String) split$default.get(i));
                    if (handleType != null) {
                        arrayList.add(handleType);
                    }
                    i = i2;
                }
                builder.extraEntities(arrayList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.build();
    }

    private static final FeedMultiPart update(FeedMultiPart feedMultiPart, JSONObject jSONObject) {
        if (feedMultiPart.version() >= 1) {
            return feedMultiPart;
        }
        FeedMultiPart.Builder builder = FeedMultiPart.builder(feedMultiPart);
        Intrinsics.areEqual(feedMultiPart.type(), "rating");
        FeedMultiPart build = builder.version(1).build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.version(1).build()");
        return update(build, jSONObject);
    }
}
