package com.coolapk.market.view.search;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.coolapk.market.model.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\bG\u0018\u0000 b2\u00020\u0001:\u0001bB\u0005¢\u0006\u0002\u0010\u0002R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR+\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\tR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R+\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR+\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u000b\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR+\u0010#\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0002¢\u0006\u0012\n\u0004\b&\u0010\u000b\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010\tR\u001d\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001c¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR+\u0010)\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0002¢\u0006\u0012\n\u0004\b,\u0010\u000b\u001a\u0004\b*\u0010\u0007\"\u0004\b+\u0010\tR+\u0010-\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0002¢\u0006\u0012\n\u0004\b0\u0010\u000b\u001a\u0004\b.\u0010\u0007\"\u0004\b/\u0010\tR\u001d\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001c¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001eR+\u00103\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0002¢\u0006\u0012\n\u0004\b6\u0010\u000b\u001a\u0004\b4\u0010\u0007\"\u0004\b5\u0010\tR\u001d\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001c¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u001eR\u001d\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001c¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u001eR+\u0010;\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0002¢\u0006\u0012\n\u0004\b>\u0010\u000b\u001a\u0004\b<\u0010\u0007\"\u0004\b=\u0010\tR+\u0010?\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0002¢\u0006\u0012\n\u0004\bB\u0010\u000b\u001a\u0004\b@\u0010\u0007\"\u0004\bA\u0010\tR \u0010C\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0014\"\u0004\bE\u0010\u0016R+\u0010F\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0002¢\u0006\u0012\n\u0004\bI\u0010\u000b\u001a\u0004\bG\u0010\u0007\"\u0004\bH\u0010\tR\u001d\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001c¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\u001eR\u001d\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001c¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\u001eR+\u0010N\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0002¢\u0006\u0012\n\u0004\bQ\u0010\u000b\u001a\u0004\bO\u0010\u0007\"\u0004\bP\u0010\tR\u001d\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001c¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u001eR+\u0010T\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0002¢\u0006\u0012\n\u0004\bW\u0010\u000b\u001a\u0004\bU\u0010\u0007\"\u0004\bV\u0010\tR+\u0010X\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0002¢\u0006\u0012\n\u0004\b[\u0010\u000b\u001a\u0004\bY\u0010\u0007\"\u0004\bZ\u0010\tR+\u0010\\\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0002¢\u0006\u0012\n\u0004\b_\u0010\u000b\u001a\u0004\b]\u0010\u0007\"\u0004\b^\u0010\tR\u001d\u0010`\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001c¢\u0006\b\n\u0000\u001a\u0004\ba\u0010\u001e¨\u0006c"}, d2 = {"Lcom/coolapk/market/view/search/SuperSearchViewModel;", "Landroidx/databinding/BaseObservable;", "()V", "<set-?>", "", "actionType", "getActionType", "()Ljava/lang/String;", "setActionType", "(Ljava/lang/String;)V", "actionType$delegate", "Lkotlin/properties/ReadWriteProperty;", "appCat", "getAppCat", "setAppCat", "appCat$delegate", "appCategoryList", "", "Lcom/coolapk/market/model/Entity;", "getAppCategoryList", "()Ljava/util/List;", "setAppCategoryList", "(Ljava/util/List;)V", "appSort", "getAppSort", "setAppSort", "appSort$delegate", "appSortMap", "", "getAppSortMap", "()Ljava/util/Map;", "askFeedType", "getAskFeedType", "setAskFeedType", "askFeedType$delegate", "dealType", "getDealType", "setDealType", "dealType$delegate", "dealTypeMap", "getDealTypeMap", "dealTypeText", "getDealTypeText", "setDealTypeText", "dealTypeText$delegate", "feedFeedType", "getFeedFeedType", "setFeedFeedType", "feedFeedType$delegate", "feedProductTypeMap", "getFeedProductTypeMap", "feedSort", "getFeedSort", "setFeedSort", "feedSort$delegate", "feedTopicTypeMap", "getFeedTopicTypeMap", "feedTypeMap", "getFeedTypeMap", "filterType", "getFilterType", "setFilterType", "filterType$delegate", "gameCat", "getGameCat", "setGameCat", "gameCat$delegate", "gameCategoryList", "getGameCategoryList", "setGameCategoryList", "gameSort", "getGameSort", "setGameSort", "gameSort$delegate", "otherMap", "getOtherMap", "otherMapRemoveLink", "getOtherMapRemoveLink", "secondHandChangeSort", "getSecondHandChangeSort", "setSecondHandChangeSort", "secondHandChangeSort$delegate", "secondHandChangeSortMap", "getSecondHandChangeSortMap", "secondHandFilterInBuy", "getSecondHandFilterInBuy", "setSecondHandFilterInBuy", "secondHandFilterInBuy$delegate", "secondHandOther", "getSecondHandOther", "setSecondHandOther", "secondHandOther$delegate", "secondHandSort", "getSecondHandSort", "setSecondHandSort", "secondHandSort$delegate", "secondHandSortMap", "getSecondHandSortMap", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SuperSearchViewModel.kt */
public final class SuperSearchViewModel extends BaseObservable {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(SuperSearchViewModel.class, "appCat", "getAppCat()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SuperSearchViewModel.class, "gameCat", "getGameCat()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SuperSearchViewModel.class, "appSort", "getAppSort()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SuperSearchViewModel.class, "gameSort", "getGameSort()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SuperSearchViewModel.class, "feedSort", "getFeedSort()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SuperSearchViewModel.class, "dealType", "getDealType()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SuperSearchViewModel.class, "actionType", "getActionType()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SuperSearchViewModel.class, "filterType", "getFilterType()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SuperSearchViewModel.class, "dealTypeText", "getDealTypeText()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SuperSearchViewModel.class, "secondHandSort", "getSecondHandSort()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SuperSearchViewModel.class, "secondHandChangeSort", "getSecondHandChangeSort()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SuperSearchViewModel.class, "secondHandFilterInBuy", "getSecondHandFilterInBuy()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SuperSearchViewModel.class, "secondHandOther", "getSecondHandOther()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SuperSearchViewModel.class, "feedFeedType", "getFeedFeedType()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SuperSearchViewModel.class, "askFeedType", "getAskFeedType()Ljava/lang/String;", 0))};
    public static final Companion Companion = new Companion(null);
    public static final String DEAL_TYPE_BUY = "1";
    public static final String DEAL_TYPE_BUY_TEXT = "收购";
    public static final String DEAL_TYPE_EXCHANGE = "2";
    public static final String DEAL_TYPE_EXCHANGE_TEXT = "换机";
    public static final String DEAL_TYPE_SELL = "0";
    public static final String DEAL_TYPE_SELL_TEXT = "出售";
    public static final String FEED_PAGE_TYPE_APK = "apk";
    public static final String FEED_PAGE_TYPE_NULL = "";
    public static final String FEED_PAGE_TYPE_PRODUCT = "product_phone";
    public static final String FEED_PAGE_TYPE_TAG = "tag";
    public static final String FEED_PAGE_TYPE_USER = "user";
    public static final String FEED_TYPE_ALL = "all";
    public static final String FEED_TYPE_ANSWER = "answer";
    public static final String FEED_TYPE_COMMENT = "comment";
    public static final String FEED_TYPE_ERSHOU = "ershou";
    public static final String FEED_TYPE_FEED = "feed";
    public static final String FEED_TYPE_FEED_ARTICLE = "feedArticle";
    public static final String FEED_TYPE_GOODS = "goods";
    public static final String FEED_TYPE_PICTURE = "picture";
    public static final String FEED_TYPE_QUESTION = "question";
    public static final String FEED_TYPE_RATING = "rating";
    public static final String FEED_TYPE_URL = "url";
    public static final String FEED_TYPE_VIDEO = "video";
    public static final String FEED_TYPE_VOTE = "vote";
    public static final String SEARCH_TYPE_ALBUM = "album";
    public static final String SEARCH_TYPE_ALL = "all";
    public static final String SEARCH_TYPE_APK = "apk";
    public static final String SEARCH_TYPE_ASK = "ask";
    public static final String SEARCH_TYPE_DYH_MIX = "dyhMix";
    public static final String SEARCH_TYPE_FEED = "feed";
    public static final String SEARCH_TYPE_FEED_TOPIC = "feedTopic";
    public static final String SEARCH_TYPE_GAME = "game";
    public static final String SEARCH_TYPE_GOODS = "goods";
    public static final String SEARCH_TYPE_GOODS_LIST = "goods_list";
    public static final String SEARCH_TYPE_PRODUCT = "product";
    public static final String SEARCH_TYPE_SECONDHAND = "ershou";
    public static final String SEARCH_TYPE_USER = "user";
    public static final String SECOND_TYPE_ALL = "0";
    public static final String SECOND_TYPE_ISLINK = "1";
    public static final String SECOND_TYPE_LOCATION = "2";
    public static final String SORT_ASC = "-asc";
    public static final String SORT_CHANGE_BUY_PRICEDOWN = "buy_price_down";
    public static final String SORT_CHANGE_BUY_PRICEUP = "buy_price_up";
    public static final String SORT_CHANGE_SELL_PRICEDOWN = "sell_price_down";
    public static final String SORT_CHANGE_SELL_PRICEUP = "sell_price_up";
    public static final String SORT_COMMENT = "comment";
    public static final String SORT_DATELINE = "dateline";
    public static final String SORT_DEFAULT = "default";
    public static final String SORT_DESC = "-desc";
    public static final String SORT_DOWNLOAD = "download";
    public static final String SORT_FOLLOW = "follow";
    public static final String SORT_HOT = "hot";
    public static final String SORT_LAST_UPDATE = "lastupdate";
    public static final String SORT_PUBLISH_DATE = "pubdate";
    public static final String SORT_RATING = "rating";
    public static final String SORT_REPLY = "reply";
    public static final String SORT_SH_DEFAULT = "default";
    public static final String SORT_SH_FACE_DEAL = "face_deal";
    public static final String SORT_SH_PRICE_ASC = "priceDown";
    public static final String SORT_SH_PRICE_DESC = "priceUp";
    public static final String SORT_SH_TIME = "time";
    private final ReadWriteProperty actionType$delegate;
    private final ReadWriteProperty appCat$delegate;
    private List<? extends Entity> appCategoryList = new ArrayList();
    private final ReadWriteProperty appSort$delegate;
    private final Map<String, String> appSortMap = MapsKt.mapOf(TuplesKt.to("default", "按默认排序"), TuplesKt.to("follow", "按关注数排序"), TuplesKt.to("rating", "按评分排序"), TuplesKt.to("comment", "按评论数排序"), TuplesKt.to("download", "按下载数排序"), TuplesKt.to("pubdate", "按收录时间排序"), TuplesKt.to("lastupdate", "按更新时间排序"));
    private final ReadWriteProperty askFeedType$delegate;
    private final ReadWriteProperty dealType$delegate;
    private final Map<String, String> dealTypeMap = MapsKt.mapOf(TuplesKt.to("0", "出售"), TuplesKt.to("1", "收购"), TuplesKt.to("2", "换机"));
    private final ReadWriteProperty dealTypeText$delegate;
    private final ReadWriteProperty feedFeedType$delegate;
    private final Map<String, String> feedProductTypeMap = MapsKt.mapOf(TuplesKt.to("all", "全部"), TuplesKt.to("feed", "动态"), TuplesKt.to("feedArticle", "图文"), TuplesKt.to("rating", "点评"), TuplesKt.to("goods", "好物推荐"), TuplesKt.to("picture", "酷图"), TuplesKt.to("question", "提问"), TuplesKt.to("answer", "回答"), TuplesKt.to("comment", "评论"), TuplesKt.to("video", "视频"), TuplesKt.to("ershou", "二手"), TuplesKt.to("vote", "投票"));
    private final ReadWriteProperty feedSort$delegate;
    private final Map<String, String> feedTopicTypeMap = MapsKt.mapOf(TuplesKt.to("all", "全部"), TuplesKt.to("feed", "动态"), TuplesKt.to("feedArticle", "图文"), TuplesKt.to("picture", "酷图"), TuplesKt.to("question", "提问"), TuplesKt.to("answer", "回答"), TuplesKt.to("comment", "评论"), TuplesKt.to("video", "视频"), TuplesKt.to("ershou", "二手"), TuplesKt.to("vote", "投票"));
    private final Map<String, String> feedTypeMap = MapsKt.mapOf(TuplesKt.to("all", "全部"), TuplesKt.to("feed", "动态"), TuplesKt.to("feedArticle", "图文"), TuplesKt.to("rating", "点评"), TuplesKt.to("goods", "好物推荐"), TuplesKt.to("picture", "酷图"), TuplesKt.to("question", "提问"), TuplesKt.to("answer", "回答"), TuplesKt.to("comment", "评论"), TuplesKt.to("video", "视频"), TuplesKt.to("ershou", "二手"), TuplesKt.to("vote", "投票"));
    private final ReadWriteProperty filterType$delegate;
    private final ReadWriteProperty gameCat$delegate;
    private List<? extends Entity> gameCategoryList = new ArrayList();
    private final ReadWriteProperty gameSort$delegate;
    private final Map<String, String> otherMap = MapsKt.mapOf(TuplesKt.to("0", "全部"), TuplesKt.to("2", "只看同城"));
    private final Map<String, String> otherMapRemoveLink = MapsKt.mapOf(TuplesKt.to("0", "全部"), TuplesKt.to("2", "只看同城"));
    private final ReadWriteProperty secondHandChangeSort$delegate;
    private final Map<String, String> secondHandChangeSortMap = MapsKt.mapOf(TuplesKt.to("default", "综合排序"), TuplesKt.to("time", "按发布时间"), TuplesKt.to("sell_price_up", "卖家补价从低到高"), TuplesKt.to("sell_price_down", "卖家补价从高到低"), TuplesKt.to("buy_price_up", "买家补价从低到高"), TuplesKt.to("buy_price_down", "买家补价从高到低"), TuplesKt.to("face_deal", "只看面议"));
    private final ReadWriteProperty secondHandFilterInBuy$delegate;
    private final ReadWriteProperty secondHandOther$delegate;
    private final ReadWriteProperty secondHandSort$delegate;
    private final Map<String, String> secondHandSortMap = MapsKt.mapOf(TuplesKt.to("default", "综合排序"), TuplesKt.to("time", "按发布时间"), TuplesKt.to("priceDown", "价格从低到高"), TuplesKt.to("priceUp", "价格从高到低"), TuplesKt.to("face_deal", "只看面议"));

    @Bindable
    public final String getActionType() {
        return (String) this.actionType$delegate.getValue(this, $$delegatedProperties[6]);
    }

    @Bindable
    public final String getAppCat() {
        return (String) this.appCat$delegate.getValue(this, $$delegatedProperties[0]);
    }

    @Bindable
    public final String getAppSort() {
        return (String) this.appSort$delegate.getValue(this, $$delegatedProperties[2]);
    }

    @Bindable
    public final String getAskFeedType() {
        return (String) this.askFeedType$delegate.getValue(this, $$delegatedProperties[14]);
    }

    @Bindable
    public final String getDealType() {
        return (String) this.dealType$delegate.getValue(this, $$delegatedProperties[5]);
    }

    @Bindable
    public final String getDealTypeText() {
        return (String) this.dealTypeText$delegate.getValue(this, $$delegatedProperties[8]);
    }

    @Bindable
    public final String getFeedFeedType() {
        return (String) this.feedFeedType$delegate.getValue(this, $$delegatedProperties[13]);
    }

    @Bindable
    public final String getFeedSort() {
        return (String) this.feedSort$delegate.getValue(this, $$delegatedProperties[4]);
    }

    @Bindable
    public final String getFilterType() {
        return (String) this.filterType$delegate.getValue(this, $$delegatedProperties[7]);
    }

    @Bindable
    public final String getGameCat() {
        return (String) this.gameCat$delegate.getValue(this, $$delegatedProperties[1]);
    }

    @Bindable
    public final String getGameSort() {
        return (String) this.gameSort$delegate.getValue(this, $$delegatedProperties[3]);
    }

    @Bindable
    public final String getSecondHandChangeSort() {
        return (String) this.secondHandChangeSort$delegate.getValue(this, $$delegatedProperties[10]);
    }

    @Bindable
    public final String getSecondHandFilterInBuy() {
        return (String) this.secondHandFilterInBuy$delegate.getValue(this, $$delegatedProperties[11]);
    }

    @Bindable
    public final String getSecondHandOther() {
        return (String) this.secondHandOther$delegate.getValue(this, $$delegatedProperties[12]);
    }

    @Bindable
    public final String getSecondHandSort() {
        return (String) this.secondHandSort$delegate.getValue(this, $$delegatedProperties[9]);
    }

    public final void setActionType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.actionType$delegate.setValue(this, $$delegatedProperties[6], str);
    }

    public final void setAppCat(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appCat$delegate.setValue(this, $$delegatedProperties[0], str);
    }

    public final void setAppSort(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appSort$delegate.setValue(this, $$delegatedProperties[2], str);
    }

    public final void setAskFeedType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.askFeedType$delegate.setValue(this, $$delegatedProperties[14], str);
    }

    public final void setDealType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dealType$delegate.setValue(this, $$delegatedProperties[5], str);
    }

    public final void setDealTypeText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dealTypeText$delegate.setValue(this, $$delegatedProperties[8], str);
    }

    public final void setFeedFeedType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.feedFeedType$delegate.setValue(this, $$delegatedProperties[13], str);
    }

    public final void setFeedSort(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.feedSort$delegate.setValue(this, $$delegatedProperties[4], str);
    }

    public final void setFilterType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.filterType$delegate.setValue(this, $$delegatedProperties[7], str);
    }

    public final void setGameCat(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gameCat$delegate.setValue(this, $$delegatedProperties[1], str);
    }

    public final void setGameSort(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gameSort$delegate.setValue(this, $$delegatedProperties[3], str);
    }

    public final void setSecondHandChangeSort(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.secondHandChangeSort$delegate.setValue(this, $$delegatedProperties[10], str);
    }

    public final void setSecondHandFilterInBuy(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.secondHandFilterInBuy$delegate.setValue(this, $$delegatedProperties[11], str);
    }

    public final void setSecondHandOther(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.secondHandOther$delegate.setValue(this, $$delegatedProperties[12], str);
    }

    public final void setSecondHandSort(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.secondHandSort$delegate.setValue(this, $$delegatedProperties[9], str);
    }

    public SuperSearchViewModel() {
        Delegates delegates = Delegates.INSTANCE;
        this.appCat$delegate = new SuperSearchViewModel$$special$$inlined$observable$1("", "", this);
        Delegates delegates2 = Delegates.INSTANCE;
        this.gameCat$delegate = new SuperSearchViewModel$$special$$inlined$observable$2("", "", this);
        Delegates delegates3 = Delegates.INSTANCE;
        this.appSort$delegate = new SuperSearchViewModel$$special$$inlined$observable$3("default", "default", this);
        Delegates delegates4 = Delegates.INSTANCE;
        this.gameSort$delegate = new SuperSearchViewModel$$special$$inlined$observable$4("default", "default", this);
        Delegates delegates5 = Delegates.INSTANCE;
        this.feedSort$delegate = new SuperSearchViewModel$$special$$inlined$observable$5("default", "default", this);
        Delegates delegates6 = Delegates.INSTANCE;
        this.dealType$delegate = new SuperSearchViewModel$$special$$inlined$observable$6("0", "0", this);
        Delegates delegates7 = Delegates.INSTANCE;
        this.actionType$delegate = new SuperSearchViewModel$$special$$inlined$observable$7("0", "0", this);
        Delegates delegates8 = Delegates.INSTANCE;
        this.filterType$delegate = new SuperSearchViewModel$$special$$inlined$observable$8("0", "0", this);
        Delegates delegates9 = Delegates.INSTANCE;
        this.dealTypeText$delegate = new SuperSearchViewModel$$special$$inlined$observable$9("出售", "出售", this);
        Delegates delegates10 = Delegates.INSTANCE;
        this.secondHandSort$delegate = new SuperSearchViewModel$$special$$inlined$observable$10("default", "default", this);
        Delegates delegates11 = Delegates.INSTANCE;
        this.secondHandChangeSort$delegate = new SuperSearchViewModel$$special$$inlined$observable$11("default", "default", this);
        Delegates delegates12 = Delegates.INSTANCE;
        this.secondHandFilterInBuy$delegate = new SuperSearchViewModel$$special$$inlined$observable$12("0", "0", this);
        Delegates delegates13 = Delegates.INSTANCE;
        this.secondHandOther$delegate = new SuperSearchViewModel$$special$$inlined$observable$13("0", "0", this);
        Delegates delegates14 = Delegates.INSTANCE;
        this.feedFeedType$delegate = new SuperSearchViewModel$$special$$inlined$observable$14("all", "all", this);
        Delegates delegates15 = Delegates.INSTANCE;
        this.askFeedType$delegate = new SuperSearchViewModel$$special$$inlined$observable$15("all", "all", this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b=\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/coolapk/market/view/search/SuperSearchViewModel$Companion;", "", "()V", "DEAL_TYPE_BUY", "", "DEAL_TYPE_BUY_TEXT", "DEAL_TYPE_EXCHANGE", "DEAL_TYPE_EXCHANGE_TEXT", "DEAL_TYPE_SELL", "DEAL_TYPE_SELL_TEXT", "FEED_PAGE_TYPE_APK", "FEED_PAGE_TYPE_NULL", "FEED_PAGE_TYPE_PRODUCT", "FEED_PAGE_TYPE_TAG", "FEED_PAGE_TYPE_USER", "FEED_TYPE_ALL", "FEED_TYPE_ANSWER", "FEED_TYPE_COMMENT", "FEED_TYPE_ERSHOU", "FEED_TYPE_FEED", "FEED_TYPE_FEED_ARTICLE", "FEED_TYPE_GOODS", "FEED_TYPE_PICTURE", "FEED_TYPE_QUESTION", "FEED_TYPE_RATING", "FEED_TYPE_URL", "FEED_TYPE_VIDEO", "FEED_TYPE_VOTE", "SEARCH_TYPE_ALBUM", "SEARCH_TYPE_ALL", "SEARCH_TYPE_APK", "SEARCH_TYPE_ASK", "SEARCH_TYPE_DYH_MIX", "SEARCH_TYPE_FEED", "SEARCH_TYPE_FEED_TOPIC", "SEARCH_TYPE_GAME", "SEARCH_TYPE_GOODS", "SEARCH_TYPE_GOODS_LIST", "SEARCH_TYPE_PRODUCT", "SEARCH_TYPE_SECONDHAND", "SEARCH_TYPE_USER", "SECOND_TYPE_ALL", "SECOND_TYPE_ISLINK", "SECOND_TYPE_LOCATION", "SORT_ASC", "SORT_CHANGE_BUY_PRICEDOWN", "SORT_CHANGE_BUY_PRICEUP", "SORT_CHANGE_SELL_PRICEDOWN", "SORT_CHANGE_SELL_PRICEUP", "SORT_COMMENT", "SORT_DATELINE", "SORT_DEFAULT", "SORT_DESC", "SORT_DOWNLOAD", "SORT_FOLLOW", "SORT_HOT", "SORT_LAST_UPDATE", "SORT_PUBLISH_DATE", "SORT_RATING", "SORT_REPLY", "SORT_SH_DEFAULT", "SORT_SH_FACE_DEAL", "SORT_SH_PRICE_ASC", "SORT_SH_PRICE_DESC", "SORT_SH_TIME", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SuperSearchViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.coolapk.market.model.Entity>, java.util.List<com.coolapk.market.model.Entity> */
    public final List<Entity> getAppCategoryList() {
        return this.appCategoryList;
    }

    public final void setAppCategoryList(List<? extends Entity> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.appCategoryList = list;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.coolapk.market.model.Entity>, java.util.List<com.coolapk.market.model.Entity> */
    public final List<Entity> getGameCategoryList() {
        return this.gameCategoryList;
    }

    public final void setGameCategoryList(List<? extends Entity> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.gameCategoryList = list;
    }

    public final Map<String, String> getAppSortMap() {
        return this.appSortMap;
    }

    public final Map<String, String> getFeedTypeMap() {
        return this.feedTypeMap;
    }

    public final Map<String, String> getDealTypeMap() {
        return this.dealTypeMap;
    }

    public final Map<String, String> getOtherMap() {
        return this.otherMap;
    }

    public final Map<String, String> getOtherMapRemoveLink() {
        return this.otherMapRemoveLink;
    }

    public final Map<String, String> getSecondHandSortMap() {
        return this.secondHandSortMap;
    }

    public final Map<String, String> getSecondHandChangeSortMap() {
        return this.secondHandChangeSortMap;
    }

    public final Map<String, String> getFeedProductTypeMap() {
        return this.feedProductTypeMap;
    }

    public final Map<String, String> getFeedTopicTypeMap() {
        return this.feedTopicTypeMap;
    }
}
