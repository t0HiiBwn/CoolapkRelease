package com.coolapk.market.extend;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.util.LruCache;
import android.util.SparseIntArray;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.ConfigPage;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.model.Product;
import com.coolapk.market.model.SecondHandInfo;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.SimpleEntity;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.model.Vote;
import com.coolapk.market.util.CacheUrlUtils;
import com.coolapk.market.util.EntityConvertUtils;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.MultiItemDialogFragment;
import com.coolapk.market.view.feed.dialog.SheetDialogWrapper;
import com.coolapk.market.view.feed.dialog.SheetFactoryOptions;
import com.coolapk.market.view.feedv8.ArticleModel;
import com.coolapk.market.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¨\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!\u001a*\u0010#\u001a\u0004\u0018\u00010!2\u0018\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0&0%2\u0006\u0010'\u001a\u00020!\u001a-\u0010(\u001a\u0004\u0018\u0001H)\"\b\b\u0000\u0010)*\u00020\u001f2\u0006\u0010*\u001a\u00020!2\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H)0,¢\u0006\u0002\u0010-\u001a \u0010.\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0&0%2\u0006\u0010/\u001a\u00020!\u001a\u0014\u00100\u001a\u000201*\u00020\u001b2\b\u00102\u001a\u0004\u0018\u00010!\u001a\n\u00103\u001a\u00020!*\u00020\u001f\u001a\n\u00104\u001a\u00020!*\u00020\r\u001a\n\u00105\u001a\u00020!*\u00020\r\u001a\n\u00106\u001a\u00020!*\u00020\r\u001a\n\u00107\u001a\u00020\u0004*\u00020\r\u001a\n\u00108\u001a\u00020!*\u00020\r\u001a\n\u00109\u001a\u00020!*\u00020\r\u001a\n\u0010:\u001a\u00020!*\u00020\r\u001a\n\u0010;\u001a\u00020!*\u00020\r\u001a\n\u0010<\u001a\u00020!*\u00020\r\u001a\n\u0010=\u001a\u00020!*\u00020\r\u001a\u0014\u0010>\u001a\u00020\u0004*\u00020\u001f2\u0006\u0010?\u001a\u00020\tH\u0002\u001a\n\u0010@\u001a\u00020\u0004*\u00020\u001f\u001a\n\u0010A\u001a\u00020\u0004*\u00020\u001f\u001a\n\u0010B\u001a\u00020!*\u00020\u0013\u001a\n\u0010C\u001a\u00020!*\u00020\r\u001a\u0012\u0010D\u001a\u00020!*\u00020\r2\u0006\u0010E\u001a\u00020\u0004\u001a\u0012\u0010F\u001a\u00020!*\u00020\r2\u0006\u0010E\u001a\u00020\u0004\u001a\n\u0010G\u001a\u00020!*\u00020\r\u001a\u0010\u0010H\u001a\b\u0012\u0004\u0012\u00020!0%*\u00020\r\u001a\n\u0010I\u001a\u00020!*\u00020J\u001a\u0010\u0010K\u001a\b\u0012\u0004\u0012\u00020!0%*\u00020\r\u001a\u001a\u0010L\u001a\u00020\u0004*\u00020\u001f2\u0006\u0010'\u001a\u00020!2\u0006\u0010M\u001a\u00020\u0004\u001a\f\u0010N\u001a\u0004\u0018\u00010\u0001*\u00020\u001f\u001a\f\u0010O\u001a\u0004\u0018\u00010\u001f*\u00020\u001b\u001a\n\u0010P\u001a\u00020!*\u00020\u001b\u001a\n\u0010Q\u001a\u00020!*\u00020R\u001a\u0015\u0010S\u001a\b\u0012\u0004\u0012\u00020U0T*\u00020\r¢\u0006\u0002\u0010V\u001a\f\u0010W\u001a\u0004\u0018\u00010!*\u00020\u001f\u001a\n\u0010X\u001a\u00020Y*\u00020\u0013\u001a\n\u0010Z\u001a\u00020!*\u00020\r\u001a\u0012\u0010[\u001a\u00020Y*\u00020\u00132\u0006\u0010\\\u001a\u00020\u0004\u001a\u0012\u0010]\u001a\u00020Y*\u00020\r2\u0006\u0010\\\u001a\u00020\u0004\u001a\u001a\u0010^\u001a\u00020!*\u00020\u001f2\u0006\u0010'\u001a\u00020!2\u0006\u0010M\u001a\u00020!\u001a\u0014\u0010_\u001a\u0004\u0018\u00010!*\u00020\u001f2\u0006\u0010'\u001a\u00020!\u001a\"\u0010`\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0%0&0%*\u00020\u001b\u001a\n\u0010a\u001a\u00020!*\u00020\r\u001a\n\u0010b\u001a\u00020!*\u00020\r\u001a\n\u0010c\u001a\u00020\u0004*\u00020\u001f\u001a\u0010\u0010d\u001a\b\u0012\u0004\u0012\u00020!0%*\u00020\n\u001a\n\u0010e\u001a\u00020\t*\u00020\u001f\u001a\n\u0010f\u001a\u00020\t*\u00020\u001f\u001a\n\u0010g\u001a\u00020\t*\u00020\r\u001a\n\u0010h\u001a\u00020\t*\u00020\u001f\u001a\n\u0010i\u001a\u00020\t*\u00020\u001f\u001a\f\u0010j\u001a\u0004\u0018\u00010!*\u00020\u001f\u001a\n\u0010k\u001a\u00020!*\u00020\u001f\u001a\u0012\u0010l\u001a\u000201*\u00020m2\u0006\u0010n\u001a\u00020o\u001a\u0012\u0010l\u001a\u000201*\u00020\r2\u0006\u0010p\u001a\u00020q\u001a\u0012\u0010l\u001a\u000201*\u00020r2\u0006\u0010n\u001a\u00020o\u001a\n\u0010s\u001a\u00020!*\u00020\u001f\u001a\n\u0010t\u001a\u00020\r*\u00020\r\u001a\n\u0010u\u001a\u00020!*\u00020\u001f\u001a\f\u0010v\u001a\u0004\u0018\u00010!*\u00020w\u001a\f\u0010v\u001a\u0004\u0018\u00010!*\u00020\u001f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0015\u0010\b\u001a\u00020\t*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\b\u0010\u000b\"\u0015\u0010\f\u001a\u00020\t*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000e\"\u0015\u0010\u000f\u001a\u00020\t*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000b\"\u0015\u0010\u0010\u001a\u00020\t*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e\"\u0015\u0010\u0011\u001a\u00020\t*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000e\"\u0015\u0010\u0012\u001a\u00020\t*\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014\"\u0015\u0010\u0015\u001a\u00020\t*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000e\"\u0015\u0010\u0016\u001a\u00020\t*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000b\"\u0015\u0010\u0017\u001a\u00020\t*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000b\"\u0015\u0010\u0018\u001a\u00020\t*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000b\"\u0015\u0010\u0019\u001a\u00020\t*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000b\"\u0018\u0010\u001a\u001a\u00020\t*\u00020\u001b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006x"}, d2 = {"EMPTY_JSON", "Lorg/json/JSONObject;", "JSON_EXTRA_MAP", "Landroid/util/LruCache;", "", "dividerBottomResultCache", "Landroid/util/SparseIntArray;", "dividerTopResultCache", "isAllowAnonymous", "", "Lcom/coolapk/market/model/Vote;", "(Lcom/coolapk/market/model/Vote;)Z", "isArticleNews", "Lcom/coolapk/market/model/Feed;", "(Lcom/coolapk/market/model/Feed;)Z", "isFinished", "isInCensorStatus", "isLoadFromHistoryApi", "isPhoneOrTablet", "Lcom/coolapk/market/model/Product;", "(Lcom/coolapk/market/model/Product;)Z", "isProductPhoneOrTablet", "isUserAnonymous", "isUserCommented", "isUserHaveModifiedVote", "isUserVoted", "saveSubTabSelectedState", "Lcom/coolapk/market/model/ConfigPage;", "getSaveSubTabSelectedState", "(Lcom/coolapk/market/model/ConfigPage;)Z", "buildSponsorCard", "Lcom/coolapk/market/model/Entity;", "sponsorType", "", "id", "findValueFromUrlClientConfig", "action", "", "Lkotlin/Pair;", "key", "fromJson", "T", "json", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Lcom/coolapk/market/model/Entity;", "parseUrlClientConfigToList", "clientConfig", "checkAndSaveLastSelectedSubPage", "", "url", "entityUniqueId", "getApkExtraAnalysisData", "getApkExtraId", "getApkExtraPackageName", "getApkExtraVersionCode", "getApkExtraVersionName", "getApkSize", "getBoundApkID", "getBoundID", "getBoundProductID", "getBoundTopicID", "getCardDivider", "isTop", "getCardDividerBottom", "getCardDividerTop", "getDisplayPerferRatingScore", "getDisplayRatingScore", "getDownloadUrl", "downloadUrlType", "getDownloadUrlMd5", "getEncodedShareUrl", "getFeedUserVoteIds", "getGenerationString", "Lcom/coolapk/market/model/UserProfile;", "getHtmlPicArray", "getIntExtraData", "default", "getJsonExtraData", "getLastSelectedSubPage", "getLastSelectedSubPageTitle", "getLocationText", "Lcom/coolapk/market/model/SecondHandInfo;", "getMessageUrlSpan", "", "Landroid/text/style/URLSpan;", "(Lcom/coolapk/market/model/Feed;)[Landroid/text/style/URLSpan;", "getPageContext", "getPreferRatingScore", "", "getProductStatusText", "getRatingAverageScoreByIndex", "index", "getRatingScoreByIndex", "getStringExtraData", "getStringExtraDataOrNull", "getSubMenu", "getTargetTypeInt", "getTargetTypeString", "getTextSizeInt", "getUserVoteIds", "hasCardStatName", "isDatelineVisible", "isDeletedQuestion", "isShowCancelReportSpam", "isSingleLineTitle", "optSubTitle", "picOrLogo", "showItemDialog", "Lcom/coolapk/market/model/Album;", "activity", "Landroid/app/Activity;", "context", "Landroid/content/Context;", "Lcom/coolapk/market/model/FeedReply;", "toJson", "toShortFeed", "uniqueType", "urlClientConfig", "Landroid/net/Uri;", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: EntityExtends.kt */
public final class EntityExtendsKt {
    private static final JSONObject EMPTY_JSON = new JSONObject();
    private static final LruCache<Integer, JSONObject> JSON_EXTRA_MAP = new LruCache<>(40);
    private static final SparseIntArray dividerBottomResultCache = new SparseIntArray();
    private static final SparseIntArray dividerTopResultCache = new SparseIntArray();

    public static final String entityUniqueId(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "$this$entityUniqueId");
        if (entity.getEntityId() != null) {
            return entity.getEntityType() + entity.getEntityId();
        }
        return entity.getEntityType() + entity.getId();
    }

    public static final String uniqueType(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "$this$uniqueType");
        String entityTemplate = entity.getEntityTemplate();
        if (entityTemplate == null || entityTemplate.length() == 0) {
            String entityType = entity.getEntityType();
            Intrinsics.checkNotNullExpressionValue(entityType, "entityType");
            return entityType;
        }
        String entityTemplate2 = entity.getEntityTemplate();
        return entityTemplate2 != null ? entityTemplate2 : "";
    }

    public static final String urlClientConfig(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "$this$urlClientConfig");
        String url = entity.getUrl();
        if (url != null) {
            Uri parse = Uri.parse(url);
            Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
            if (parse != null) {
                return urlClientConfig(parse);
            }
        }
        return null;
    }

    public static final String urlClientConfig(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "$this$urlClientConfig");
        return uri.getQueryParameter("clientConfig");
    }

    public static final List<Pair<String, String>> parseUrlClientConfigToList(String str) {
        Intrinsics.checkNotNullParameter(str, "clientConfig");
        String decode = URLDecoder.decode(str);
        Intrinsics.checkNotNullExpressionValue(decode, "URLDecoder.decode(clientConfig)");
        List<String> split$default = StringsKt.split$default((CharSequence) decode, new String[]{"|"}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
        for (String str2 : split$default) {
            List split$default2 = StringsKt.split$default((CharSequence) str2, new String[]{"="}, false, 0, 6, (Object) null);
            arrayList.add(new Pair(split$default2.get(0), split$default2.get(1)));
        }
        return arrayList;
    }

    public static final String findValueFromUrlClientConfig(List<Pair<String, String>> list, String str) {
        T t;
        Intrinsics.checkNotNullParameter(list, "action");
        Intrinsics.checkNotNullParameter(str, "key");
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t = null;
                break;
            }
            t = it2.next();
            if (Intrinsics.areEqual((String) t.getFirst(), str)) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            return (String) t2.getSecond();
        }
        return null;
    }

    public static final String picOrLogo(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "$this$picOrLogo");
        String pic = entity.getPic();
        if (pic == null) {
            pic = entity.getLogo();
        }
        return pic != null ? pic : "";
    }

    public static final int getCardDividerTop(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "$this$getCardDividerTop");
        return getCardDivider(entity, true);
    }

    public static final int getCardDividerBottom(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "$this$getCardDividerBottom");
        return getCardDivider(entity, false);
    }

    private static final int getCardDivider(Entity entity, boolean z) {
        String extraData = entity.getExtraData();
        int i = Integer.MIN_VALUE;
        if (extraData == null) {
            return Integer.MIN_VALUE;
        }
        SparseIntArray sparseIntArray = z ? dividerTopResultCache : dividerBottomResultCache;
        int hashCode = extraData.hashCode();
        if (sparseIntArray.indexOfKey(hashCode) >= 0) {
            return sparseIntArray.get(hashCode);
        }
        JSONObject jsonExtraData = getJsonExtraData(entity);
        if (jsonExtraData != null) {
            String str = z ? "cardDividerTopVX" : "cardDividerBottomVX";
            if (jsonExtraData.has(str)) {
                i = NumberExtendsKt.getDp(Integer.valueOf(jsonExtraData.getInt(str)));
            } else {
                String str2 = z ? "cardDividerTop" : "cardDividerBottom";
                if (jsonExtraData.has(str2)) {
                    i = NumberExtendsKt.getDp(Integer.valueOf(jsonExtraData.getInt(str2)));
                }
            }
        }
        sparseIntArray.put(hashCode, i);
        return i;
    }

    public static final List<String> getHtmlPicArray(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "$this$getHtmlPicArray");
        boolean z = true;
        if (feed.getIsHtmlArticle() == 1) {
            ArticleModel.Companion companion = ArticleModel.Companion;
            String messageRawOutput = feed.getMessageRawOutput();
            if (messageRawOutput == null) {
                messageRawOutput = "";
            }
            List<String> list = SequencesKt.toList(SequencesKt.filterNotNull(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(companion.fromJson(messageRawOutput)), EntityExtendsKt$getHtmlPicArray$result$1.INSTANCE), EntityExtendsKt$getHtmlPicArray$result$2.INSTANCE)));
            if (!list.isEmpty()) {
                return list;
            }
        }
        if (Intrinsics.areEqual(feed.getFeedType(), "rating") && feed.getIsHtmlArticle() != 1) {
            return SequencesKt.toList(SequencesKt.filter(SequencesKt.flatMapIterable(ArraysKt.asSequence(new String[]{feed.getCommentGoodPic(), feed.getCommentBadPic(), feed.getCommentGeneralPic()}), EntityExtendsKt$getHtmlPicArray$1.INSTANCE), EntityExtendsKt$getHtmlPicArray$2.INSTANCE));
        }
        List<String> picArray = feed.getPicArray();
        if (picArray.size() == 1) {
            String str = picArray.get(0);
            Intrinsics.checkNotNullExpressionValue(str, "array[0]");
            if (str.length() != 0) {
                z = false;
            }
            if (z) {
                return CollectionsKt.emptyList();
            }
        }
        Intrinsics.checkNotNullExpressionValue(picArray, "array");
        return picArray;
    }

    public static final URLSpan[] getMessageUrlSpan(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "$this$getMessageUrlSpan");
        Context currentActivity = AppHolder.getCurrentActivity();
        if (currentActivity == null) {
            currentActivity = AppHolder.getApplication();
            Intrinsics.checkNotNullExpressionValue(currentActivity, "AppHolder.getApplication()");
        }
        TextView textView = new TextView(currentActivity);
        textView.setText(LinkTextUtils.convert(feed.getMessage(), 0, null));
        textView.setAutoLinkMask(1);
        URLSpan[] urls = textView.getUrls();
        Intrinsics.checkNotNullExpressionValue(urls, "TextView(activity).apply…nkify.WEB_URLS\n    }.urls");
        return urls;
    }

    public static final void showItemDialog(Feed feed, Context context) {
        Activity activityNullable;
        Intrinsics.checkNotNullParameter(feed, "$this$showItemDialog");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isLoadFromHistoryApi(feed) && feed.getIsHistory() != 1) {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            LoginSession loginSession = instance.getLoginSession();
            Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
            if (loginSession.isAdmin()) {
                Toast.show$default(context, "当前版本不允许删除", 0, false, 12, null);
            }
        } else if (feed.getIsHistory() == 1) {
            DataManager instance2 = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
            LoginSession loginSession2 = instance2.getLoginSession();
            Intrinsics.checkNotNullExpressionValue(loginSession2, "session");
            if (loginSession2.isAdmin() && (activityNullable = UiUtils.getActivityNullable(context)) != null) {
                MultiItemDialogFragment initBuilder = MultiItemDialogFragment.Companion.newInstance().setInitBuilder(new EntityExtendsKt$showItemDialog$1(feed, activityNullable));
                FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activityNullable).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
                initBuilder.show(supportFragmentManager, (String) null);
            }
        } else {
            SheetDialogWrapper create$default = SheetDialogWrapper.Companion.create$default(SheetDialogWrapper.Companion, feed, null, new SheetFactoryOptions(!isInCensorStatus(feed)), 2, null);
            Activity activityNullable2 = UiUtils.getActivityNullable(context);
            Intrinsics.checkNotNull(activityNullable2);
            create$default.showDialog(activityNullable2);
        }
    }

    public static final void showItemDialog(Album album, Activity activity) {
        Intrinsics.checkNotNullParameter(album, "$this$showItemDialog");
        Intrinsics.checkNotNullParameter(activity, "activity");
        SheetDialogWrapper.Companion.create$default(SheetDialogWrapper.Companion, album, null, null, 6, null).showDialog(activity);
    }

    public static final void showItemDialog(FeedReply feedReply, Activity activity) {
        Intrinsics.checkNotNullParameter(feedReply, "$this$showItemDialog");
        Intrinsics.checkNotNullParameter(activity, "activity");
        SheetDialogWrapper.Companion.create$default(SheetDialogWrapper.Companion, feedReply, null, null, 6, null).showDialog(activity);
    }

    public static final JSONObject getJsonExtraData(Entity entity) {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(entity, "$this$getJsonExtraData");
        String extraData = entity.getExtraData();
        if (extraData == null) {
            return null;
        }
        if (extraData.length() == 0) {
            return null;
        }
        JSONObject jSONObject2 = JSON_EXTRA_MAP.get(Integer.valueOf(extraData.hashCode()));
        if (jSONObject2 != null) {
            return jSONObject2;
        }
        try {
            jSONObject = new JSONObject(extraData);
        } catch (Exception e) {
            e.printStackTrace();
            jSONObject = EMPTY_JSON;
        }
        JSON_EXTRA_MAP.put(Integer.valueOf(extraData.hashCode()), jSONObject);
        return jSONObject;
    }

    public static final int getIntExtraData(Entity entity, String str, int i) {
        Intrinsics.checkNotNullParameter(entity, "$this$getIntExtraData");
        Intrinsics.checkNotNullParameter(str, "key");
        JSONObject jsonExtraData = getJsonExtraData(entity);
        return jsonExtraData != null ? jsonExtraData.optInt(str, i) : i;
    }

    public static final String getStringExtraData(Entity entity, String str, String str2) {
        String optString;
        Intrinsics.checkNotNullParameter(entity, "$this$getStringExtraData");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "default");
        JSONObject jsonExtraData = getJsonExtraData(entity);
        return (jsonExtraData == null || (optString = jsonExtraData.optString(str, str2)) == null) ? str2 : optString;
    }

    public static final String getStringExtraDataOrNull(Entity entity, String str) {
        Intrinsics.checkNotNullParameter(entity, "$this$getStringExtraDataOrNull");
        Intrinsics.checkNotNullParameter(str, "key");
        JSONObject jsonExtraData = getJsonExtraData(entity);
        if (jsonExtraData != null) {
            return jsonExtraData.optString(str, null);
        }
        return null;
    }

    public static final boolean isDatelineVisible(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "$this$isDatelineVisible");
        if (!Intrinsics.areEqual(getStringExtraData(entity, "datelineVisibility", "visible"), "gone")) {
            Long dateline = entity.getDateline();
            if (entity instanceof DyhArticle) {
                dateline = ((DyhArticle) entity).getCreatDate();
            }
            if (dateline != null && dateline.longValue() > 0) {
                return true;
            }
        }
        return false;
    }

    public static final String getPageContext(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "$this$getPageContext");
        return getStringExtraDataOrNull(entity, "pageContext");
    }

    public static final boolean isShowCancelReportSpam(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "$this$isShowCancelReportSpam");
        return getIntExtraData(entity, "showCancelReportSpam", 0) == 1;
    }

    public static final boolean isSingleLineTitle(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "$this$isSingleLineTitle");
        return getIntExtraData(entity, "itemTitleSingleLine", 0) == 1;
    }

    public static final int getTextSizeInt(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "$this$getTextSizeInt");
        return getIntExtraData(entity, "itemTitleTextSize", 14);
    }

    public static final <T extends Entity> T fromJson(String str, Class<T> cls) {
        Intrinsics.checkNotNullParameter(str, "json");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        try {
            JsonElement parse = new JsonParser().parse(str);
            Intrinsics.checkNotNullExpressionValue(parse, "JsonParser().parse(json)");
            JsonObject asJsonObject = parse.getAsJsonObject();
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            Gson gson = instance.getGson();
            JsonElement jsonElement = asJsonObject.get("entityType");
            Intrinsics.checkNotNullExpressionValue(jsonElement, "jsonObject.get(\"entityType\")");
            return (T) EntityConvertUtils.handleType(gson, asJsonObject, jsonElement.getAsString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final String toJson(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "$this$toJson");
        try {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            String json = instance.getGson().toJson(entity);
            Intrinsics.checkNotNullExpressionValue(json, "DataManager.getInstance().gson.toJson(this)");
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static final String getApkExtraPackageName(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "$this$getApkExtraPackageName");
        String extraKey = feed.getExtraKey();
        return extraKey != null ? extraKey : "";
    }

    public static final int getApkExtraVersionCode(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "$this$getApkExtraVersionCode");
        return getIntExtraData(feed, "versionCode", 0);
    }

    public static final String getApkExtraId(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "$this$getApkExtraId");
        return getStringExtraData(feed, "apkId", "0");
    }

    public static final String getApkSize(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "$this$getApkSize");
        return getStringExtraData(feed, "apkSize", "");
    }

    public static final String getApkExtraVersionName(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "$this$getApkExtraVersionName");
        return getStringExtraData(feed, "versionName", "");
    }

    public static final String getApkExtraAnalysisData(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "$this$getApkExtraAnalysisData");
        return getStringExtraData(feed, "extraAnalysisData", "");
    }

    public static final String getDownloadUrlMd5(Feed feed, int i) {
        Intrinsics.checkNotNullParameter(feed, "$this$getDownloadUrlMd5");
        String md5 = StringUtils.toMd5(getDownloadUrl(feed, i));
        Intrinsics.checkNotNullExpressionValue(md5, "StringUtils.toMd5(getDownloadUrl(downloadUrlType))");
        return md5;
    }

    public static final String getDownloadUrl(Feed feed, int i) {
        Intrinsics.checkNotNullParameter(feed, "$this$getDownloadUrl");
        if (i != 2) {
            String apkDownloadUrl = CacheUrlUtils.getApkDownloadUrl(getApkExtraPackageName(feed), getApkExtraId(feed), getApkExtraVersionCode(feed), false);
            Intrinsics.checkNotNullExpressionValue(apkDownloadUrl, "CacheUrlUtils.getApkDown…xtraVersionCode(), false)");
            return apkDownloadUrl;
        }
        String apkDownloadUrl2 = CacheUrlUtils.getApkDownloadUrl(getApkExtraPackageName(feed), getApkExtraId(feed), getApkExtraVersionCode(feed), true);
        Intrinsics.checkNotNullExpressionValue(apkDownloadUrl2, "CacheUrlUtils.getApkDown…ExtraVersionCode(), true)");
        return apkDownloadUrl2;
    }

    public static final boolean isDeletedQuestion(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "$this$isDeletedQuestion");
        return getIntExtraData(feed, "questionStatus", -1) == 0;
    }

    public static final float getRatingScoreByIndex(Feed feed, int i) {
        Intrinsics.checkNotNullParameter(feed, "$this$getRatingScoreByIndex");
        switch (i) {
            case 0:
                return feed.getRatingScore1();
            case 1:
                return feed.getRatingScore2();
            case 2:
                return feed.getRatingScore3();
            case 3:
                return feed.getRatingScore4();
            case 4:
                return feed.getRatingScore5();
            case 5:
                return feed.getRatingScore6();
            case 6:
                return feed.getRatingScore7();
            case 7:
                return feed.getRatingScore8();
            case 8:
                return feed.getRatingScore9();
            case 9:
                return feed.getRatingScore10();
            default:
                return 0.0f;
        }
    }

    public static final String getDisplayRatingScore(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "$this$getDisplayRatingScore");
        return KotlinExtendKt.toDisplayScore(feed.getRatingScore());
    }

    public static final float getPreferRatingScore(Product product) {
        Intrinsics.checkNotNullParameter(product, "$this$getPreferRatingScore");
        return isPhoneOrTablet(product) ? product.getOwnerStarAverageScore() : product.getRatingAverageScore();
    }

    public static final String getDisplayPerferRatingScore(Product product) {
        Intrinsics.checkNotNullParameter(product, "$this$getDisplayPerferRatingScore");
        return KotlinExtendKt.toDisplayScore(getPreferRatingScore(product));
    }

    public static final float getRatingAverageScoreByIndex(Product product, int i) {
        Intrinsics.checkNotNullParameter(product, "$this$getRatingAverageScoreByIndex");
        switch (i) {
            case 0:
                return product.getRatingAverageScore1();
            case 1:
                return product.getRatingAverageScore2();
            case 2:
                return product.getRatingAverageScore3();
            case 3:
                return product.getRatingAverageScore4();
            case 4:
                return product.getRatingAverageScore5();
            case 5:
                return product.getRatingAverageScore6();
            case 6:
                return product.getRatingAverageScore7();
            case 7:
                return product.getRatingAverageScore8();
            case 8:
                return product.getRatingAverageScore9();
            case 9:
                return product.getRatingAverageScore10();
            default:
                return 0.0f;
        }
    }

    public static final String getTargetTypeString(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "$this$getTargetTypeString");
        String targetTypeInt = getTargetTypeInt(feed);
        int hashCode = targetTypeInt.hashCode();
        if (hashCode != 49) {
            if (hashCode != 51) {
                if (hashCode != 53) {
                    if (hashCode == 55 && targetTypeInt.equals("7")) {
                        return "product_phone";
                    }
                } else if (targetTypeInt.equals("5")) {
                }
            } else if (targetTypeInt.equals("3")) {
            }
            return "tag";
        } else if (targetTypeInt.equals("1")) {
            return "apk";
        }
        return "";
    }

    public static final String getTargetTypeInt(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "$this$getTargetTypeInt");
        String tid = feed.getTid();
        if (tid != null) {
            Intrinsics.checkNotNullExpressionValue(tid, "tid ?: return \"\"");
            if (tid.length() >= 10) {
                if (new Regex("\\d+").matches(tid)) {
                    Objects.requireNonNull(tid, "null cannot be cast to non-null type java.lang.String");
                    String substring = tid.substring(0, tid.length() - 9);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    return substring;
                }
            }
        }
        return "";
    }

    public static final String getBoundID(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "$this$getBoundID");
        String tid = feed.getTid();
        if (tid != null) {
            Intrinsics.checkNotNullExpressionValue(tid, "tid ?: return \"\"");
            if (tid.length() >= 10) {
                if (new Regex("\\d+").matches(tid)) {
                    int length = tid.length();
                    Objects.requireNonNull(tid, "null cannot be cast to non-null type java.lang.String");
                    String substring = tid.substring(tid.length() - 9, length);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    return String.valueOf(Long.parseLong(substring));
                }
            }
        }
        return "";
    }

    public static final String getBoundProductID(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "$this$getBoundProductID");
        String tid = feed.getTid();
        if (tid != null) {
            Intrinsics.checkNotNullExpressionValue(tid, "tid ?: return \"\"");
            if (tid.length() >= 10) {
                if (new Regex("\\d+").matches(tid)) {
                    Objects.requireNonNull(tid, "null cannot be cast to non-null type java.lang.String");
                    String substring = tid.substring(0, tid.length() - 9);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    int length = tid.length();
                    Objects.requireNonNull(tid, "null cannot be cast to non-null type java.lang.String");
                    String substring2 = tid.substring(tid.length() - 9, length);
                    Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (Intrinsics.areEqual(substring, "7")) {
                        return String.valueOf(Long.parseLong(substring2));
                    }
                }
            }
        }
        return "";
    }

    public static final String getBoundTopicID(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "$this$getBoundTopicID");
        String tid = feed.getTid();
        if (tid != null) {
            Intrinsics.checkNotNullExpressionValue(tid, "tid ?: return \"\"");
            if (tid.length() >= 10) {
                if (new Regex("\\d+").matches(tid)) {
                    Objects.requireNonNull(tid, "null cannot be cast to non-null type java.lang.String");
                    String substring = tid.substring(0, tid.length() - 9);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    int length = tid.length();
                    Objects.requireNonNull(tid, "null cannot be cast to non-null type java.lang.String");
                    String substring2 = tid.substring(tid.length() - 9, length);
                    Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (Intrinsics.areEqual(substring, "3") || Intrinsics.areEqual(substring, "5")) {
                        return String.valueOf(Long.parseLong(substring2));
                    }
                }
            }
        }
        return "";
    }

    public static final String getBoundApkID(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "$this$getBoundApkID");
        String tid = feed.getTid();
        if (tid != null) {
            Intrinsics.checkNotNullExpressionValue(tid, "tid ?: return \"\"");
            if (tid.length() >= 10) {
                if (new Regex("\\d+").matches(tid)) {
                    Objects.requireNonNull(tid, "null cannot be cast to non-null type java.lang.String");
                    String substring = tid.substring(0, tid.length() - 9);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    int length = tid.length();
                    Objects.requireNonNull(tid, "null cannot be cast to non-null type java.lang.String");
                    String substring2 = tid.substring(tid.length() - 9, length);
                    Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (Intrinsics.areEqual(substring, "1")) {
                        return String.valueOf(Long.parseLong(substring2));
                    }
                }
            }
        }
        return "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    public static final Feed toShortFeed(Feed feed) {
        boolean z;
        Intrinsics.checkNotNullParameter(feed, "$this$toShortFeed");
        String messageRawOutput = feed.getMessageRawOutput();
        if (messageRawOutput == null) {
            messageRawOutput = "";
        }
        if (messageRawOutput.length() < 12000) {
            String message = feed.getMessage();
            if (message == null) {
                message = "";
            }
            if (message.length() < 12000) {
                z = false;
                if (z) {
                    return feed;
                }
                Feed.Builder newBuilder = Feed.newBuilder(feed);
                String message2 = feed.getMessage();
                if (message2 == null) {
                    message2 = "";
                }
                int min = Math.min(message2.length(), 1000);
                Objects.requireNonNull(message2, "null cannot be cast to non-null type java.lang.String");
                String substring = message2.substring(0, min);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                Feed build = newBuilder.message(substring).messageRawOutput("").build();
                Intrinsics.checkNotNullExpressionValue(build, "Feed.newBuilder(this)\n  …\n                .build()");
                return build;
            }
        }
        z = true;
        if (z) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        if ((r0 == null || r0.length() == 0) == false) goto L_0x003a;
     */
    public static final List<String> getFeedUserVoteIds(Feed feed) {
        List<String> split$default;
        Intrinsics.checkNotNullParameter(feed, "$this$getFeedUserVoteIds");
        String extraKey = feed.getExtraKey();
        if (!(extraKey == null || (split$default = StringsKt.split$default((CharSequence) extraKey, new String[]{","}, false, 0, 6, (Object) null)) == null)) {
            boolean z = false;
            if (split$default.size() <= 1) {
                CharSequence charSequence = (CharSequence) CollectionsKt.getOrNull(split$default, 0);
            }
            z = true;
            if (!z) {
                split$default = null;
            }
            if (split$default != null) {
                return split$default;
            }
        }
        return CollectionsKt.emptyList();
    }

    public static final boolean isInCensorStatus(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "$this$isInCensorStatus");
        return ArraysKt.contains(new Integer[]{-20, -21, -22}, Integer.valueOf(feed.getStatus()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        if ((r0 == null || r0.length() == 0) == false) goto L_0x003a;
     */
    public static final List<String> getUserVoteIds(Vote vote) {
        List<String> split$default;
        Intrinsics.checkNotNullParameter(vote, "$this$getUserVoteIds");
        String userSelectedOptions = vote.getUserSelectedOptions();
        if (!(userSelectedOptions == null || (split$default = StringsKt.split$default((CharSequence) userSelectedOptions, new String[]{","}, false, 0, 6, (Object) null)) == null)) {
            boolean z = false;
            if (split$default.size() <= 1) {
                CharSequence charSequence = (CharSequence) CollectionsKt.getOrNull(split$default, 0);
            }
            z = true;
            if (!z) {
                split$default = null;
            }
            if (split$default != null) {
                return split$default;
            }
        }
        return CollectionsKt.emptyList();
    }

    public static final boolean isFinished(Vote vote) {
        Intrinsics.checkNotNullParameter(vote, "$this$isFinished");
        return System.currentTimeMillis() / ((long) 1000) > vote.getEndTime();
    }

    public static final boolean isUserVoted(Vote vote) {
        Intrinsics.checkNotNullParameter(vote, "$this$isUserVoted");
        String userSelectedOptions = vote.getUserSelectedOptions();
        return !(userSelectedOptions == null || userSelectedOptions.length() == 0);
    }

    public static final boolean isUserAnonymous(Vote vote) {
        Intrinsics.checkNotNullParameter(vote, "$this$isUserAnonymous");
        return vote.getUserAnonymousStatus() == 1;
    }

    public static final boolean isUserCommented(Vote vote) {
        Intrinsics.checkNotNullParameter(vote, "$this$isUserCommented");
        return vote.getUserVoteCommentStatus() == 1;
    }

    public static final boolean isUserHaveModifiedVote(Vote vote) {
        Intrinsics.checkNotNullParameter(vote, "$this$isUserHaveModifiedVote");
        return vote.getUserChangeVoteStatus() == 1;
    }

    public static final boolean isAllowAnonymous(Vote vote) {
        Intrinsics.checkNotNullParameter(vote, "$this$isAllowAnonymous");
        return vote.getAnonymousStatus() == 1;
    }

    public static final List<Pair<String, List<Entity>>> getSubMenu(ConfigPage configPage) {
        String str;
        Intrinsics.checkNotNullParameter(configPage, "$this$getSubMenu");
        ArrayList arrayList = new ArrayList();
        List<SimpleEntity> rawEntities = configPage.getRawEntities();
        if (rawEntities.isEmpty()) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(rawEntities, "rawEntities");
        Iterator<T> it2 = rawEntities.iterator();
        loop0:
        while (true) {
            str = "";
            while (true) {
                if (!it2.hasNext()) {
                    break loop0;
                }
                T next = it2.next();
                Intrinsics.checkNotNullExpressionValue(next, "it");
                String url = next.getUrl();
                if (url == null || url.length() == 0) {
                    ArrayList arrayList3 = arrayList2;
                    if (true ^ arrayList3.isEmpty()) {
                        ArrayList arrayList4 = new ArrayList();
                        arrayList4.addAll(arrayList3);
                        Unit unit = Unit.INSTANCE;
                        arrayList.add(TuplesKt.to(str, arrayList4));
                        arrayList2.clear();
                    }
                    str = next.getTitle();
                    if (str != null) {
                    }
                } else {
                    arrayList2.add(next);
                }
            }
        }
        ArrayList arrayList5 = arrayList2;
        if (!arrayList5.isEmpty()) {
            ArrayList arrayList6 = new ArrayList();
            arrayList6.addAll(arrayList5);
            Unit unit2 = Unit.INSTANCE;
            arrayList.add(TuplesKt.to(str, arrayList6));
        }
        return arrayList;
    }

    private static final boolean getSaveSubTabSelectedState(ConfigPage configPage) {
        return getIntExtraData(configPage, "saveSubTabSelectedState", 0) == 1;
    }

    public static final Entity getLastSelectedSubPage(ConfigPage configPage) {
        T t;
        Intrinsics.checkNotNullParameter(configPage, "$this$getLastSelectedSubPage");
        if (getSaveSubTabSelectedState(configPage)) {
            String preferencesString = DataManager.getInstance().getPreferencesString(configPage.getPageName(), "");
            String str = preferencesString;
            if (!(str == null || StringsKt.isBlank(str))) {
                List<SimpleEntity> rawEntities = configPage.getRawEntities();
                Intrinsics.checkNotNullExpressionValue(rawEntities, "configPage.rawEntities");
                Iterator<T> it2 = rawEntities.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        t = null;
                        break;
                    }
                    t = it2.next();
                    T t2 = t;
                    Intrinsics.checkNotNullExpressionValue(t2, "it");
                    if (Intrinsics.areEqual(t2.getUrl(), preferencesString)) {
                        break;
                    }
                }
                T t3 = t;
                if (t3 != null) {
                    return t3;
                }
            }
        }
        return null;
    }

    public static final void checkAndSaveLastSelectedSubPage(ConfigPage configPage, String str) {
        Intrinsics.checkNotNullParameter(configPage, "$this$checkAndSaveLastSelectedSubPage");
        if (getSaveSubTabSelectedState(configPage)) {
            String str2 = str;
            if (!(str2 == null || str2.length() == 0)) {
                DataManager instance = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                instance.getPreferencesEditor().putString(configPage.getPageName(), str).apply();
            }
        }
    }

    public static final String getLastSelectedSubPageTitle(ConfigPage configPage) {
        Intrinsics.checkNotNullParameter(configPage, "$this$getLastSelectedSubPageTitle");
        Entity lastSelectedSubPage = getLastSelectedSubPage(configPage);
        if (lastSelectedSubPage == null) {
            String title = configPage.getTitle();
            return title != null ? title : "";
        } else if (Intrinsics.areEqual(lastSelectedSubPage.getUrl(), configPage.getUrl())) {
            String title2 = configPage.getTitle();
            if (title2 != null) {
                return title2;
            }
            return "";
        } else {
            String title3 = lastSelectedSubPage.getTitle();
            return title3 != null ? title3 : "";
        }
    }

    public static final String getEncodedShareUrl(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "$this$getEncodedShareUrl");
        String shareUrl = feed.getShareUrl();
        if (shareUrl == null || shareUrl.length() == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("https://www.coolapk.com");
            String url = feed.getUrl();
            if (url == null) {
                url = "";
            }
            sb.append(url);
            return sb.toString();
        }
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Uri.Builder buildUpon = Uri.parse(feed.getShareUrl()).buildUpon();
        Intrinsics.checkNotNullExpressionValue(loginSession, "loginSession");
        if (loginSession.isLogin()) {
            buildUpon.appendQueryParameter("shareUid", loginSession.getUid());
        }
        Application application = AppHolder.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "context");
        String packageName = application.getPackageName();
        String str = application.getPackageManager().getPackageInfo(packageName, 0).versionName;
        buildUpon.appendQueryParameter("shareFrom", packageName + '_' + str);
        String uri = buildUpon.build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "Uri.parse(shareUrl)\n    …              .toString()");
        return uri;
    }

    public static final Entity buildSponsorCard(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "sponsorType");
        Intrinsics.checkNotNullParameter(str2, "id");
        SimpleEntity.Builder entityType = SimpleEntity.builder().setEntityId(str2).setEntityTemplate("sponsorCard").setEntityType("card");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sponsorType", str);
        Unit unit = Unit.INSTANCE;
        SimpleEntity build = entityType.setExtraData(jSONObject.toString()).build();
        Intrinsics.checkNotNullExpressionValue(build, "SimpleEntity.builder()\n …g())\n            .build()");
        return build;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [('0' char), (r0v4 int), (21518 char)] */
    public static final String getGenerationString(UserProfile userProfile) {
        Intrinsics.checkNotNullParameter(userProfile, "$this$getGenerationString");
        if (userProfile.getBirthyear() <= 0) {
            return "";
        }
        int birthyear = (userProfile.getBirthyear() - (userProfile.getBirthyear() % 5)) % 100;
        if (birthyear < 10) {
            StringBuilder sb = new StringBuilder();
            sb.append('0');
            sb.append(birthyear);
            sb.append((char) 21518);
            return sb.toString();
        }
        return String.valueOf(birthyear) + "后";
    }

    public static final String getLocationText(SecondHandInfo secondHandInfo) {
        Intrinsics.checkNotNullParameter(secondHandInfo, "$this$getLocationText");
        String province = secondHandInfo.getProvince();
        Intrinsics.checkNotNull(province);
        Intrinsics.checkNotNullExpressionValue(province, "province!!");
        if (new Regex("(北京|上海|天津|重庆|香港|澳门)").containsMatchIn(province)) {
            return String.valueOf(secondHandInfo.getCity());
        }
        return secondHandInfo.getProvince() + ' ' + secondHandInfo.getCity();
    }

    public static final boolean isLoadFromHistoryApi(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "$this$isLoadFromHistoryApi");
        String extraFromApi = feed.getExtraFromApi();
        if (extraFromApi == null || extraFromApi.length() == 0) {
            return false;
        }
        Uri parse = Uri.parse(feed.getExtraFromApi());
        Intrinsics.checkNotNullExpressionValue(parse, "extraFromApi");
        return ArraysKt.contains(new String[]{"changeHistoryList", "changeHistoryDetail"}, parse.getLastPathSegment());
    }

    public static final boolean isArticleNews(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "$this$isArticleNews");
        return EntityUtils.isFeedArticleNewsType(feed.getEntityTemplate());
    }

    public static final boolean isPhoneOrTablet(Product product) {
        Intrinsics.checkNotNullParameter(product, "$this$isPhoneOrTablet");
        return product.getCategoryId() == 1000 || product.getCategoryId() == 1001;
    }

    public static final boolean isProductPhoneOrTablet(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "$this$isProductPhoneOrTablet");
        return Intrinsics.areEqual(feed.getFeedType(), "rating") && feed.getShowOwner() == 1;
    }

    public static final String getProductStatusText(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "$this$getProductStatusText");
        if (!Intrinsics.areEqual(feed.getFeedType(), "rating")) {
            return "";
        }
        if (isProductPhoneOrTablet(feed)) {
            if (feed.getIsOwner() == 1) {
                return "机主";
            }
            return "";
        } else if (feed.getBuyStatus() == 1) {
            return "已买";
        } else {
            return "";
        }
    }

    public static final String optSubTitle(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "$this$optSubTitle");
        if (entity instanceof ServiceApp) {
            ServiceApp serviceApp = (ServiceApp) entity;
            if (!TextUtils.isEmpty(serviceApp.getApkSubTitle())) {
                return serviceApp.getApkSubTitle();
            }
        }
        if (!TextUtils.isEmpty(entity.getSubTitle())) {
            return entity.getSubTitle();
        }
        JSONObject jsonExtraData = getJsonExtraData(entity);
        if (jsonExtraData != null) {
            return KotlinExtendKt.getStringOrNull(jsonExtraData, "subTitle");
        }
        return null;
    }

    public static final boolean hasCardStatName(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "$this$hasCardStatName");
        return getStringExtraDataOrNull(entity, "cardStatName") != null;
    }
}
