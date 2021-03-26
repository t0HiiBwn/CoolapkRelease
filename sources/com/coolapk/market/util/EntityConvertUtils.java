package com.coolapk.market.util;

import com.coolapk.market.model.Ads;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.model.AppCategory;
import com.coolapk.market.model.AppForum;
import com.coolapk.market.model.BackupInfo;
import com.coolapk.market.model.Collection;
import com.coolapk.market.model.ConfigPage;
import com.coolapk.market.model.Contacts;
import com.coolapk.market.model.DeviceParams;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.DyhLogoCard;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.Favorite;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.model.FeedQuestion;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.model.ForwardFeed;
import com.coolapk.market.model.FunThings;
import com.coolapk.market.model.Gift;
import com.coolapk.market.model.Goods;
import com.coolapk.market.model.ItemPlaceHolder;
import com.coolapk.market.model.Link;
import com.coolapk.market.model.LinkCard;
import com.coolapk.market.model.Live;
import com.coolapk.market.model.LiveMessage;
import com.coolapk.market.model.LiveUser;
import com.coolapk.market.model.MainSecondHandType;
import com.coolapk.market.model.Message;
import com.coolapk.market.model.MessageCard;
import com.coolapk.market.model.NewHeadLine;
import com.coolapk.market.model.NodeRating;
import com.coolapk.market.model.Notification;
import com.coolapk.market.model.Product;
import com.coolapk.market.model.ProductBrand;
import com.coolapk.market.model.ProductMedia;
import com.coolapk.market.model.ProductSeries;
import com.coolapk.market.model.RecentHistory;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.ShareFeedInfo;
import com.coolapk.market.model.SimpleEntity;
import com.coolapk.market.model.TabGroupCard;
import com.coolapk.market.model.TitleCard;
import com.coolapk.market.model.TopGroupCard;
import com.coolapk.market.model.Topic;
import com.coolapk.market.model.User;
import com.coolapk.market.model.UserHistory;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.model.Video;
import com.coolapk.market.network.Result;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EntityConvertUtils {
    public static Result<JSONArray> convertJSONArray(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return wrapAsResult(jSONObject, jSONObject.optJSONArray("data"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static Result<JSONObject> convertJSONObject(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return wrapAsResult(jSONObject, jSONObject.optJSONObject("data"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static Result<Entity> convertEntity(Gson gson, String str) {
        Entity entity;
        JsonObject asJsonObject = JsonParser.parseString(str).getAsJsonObject();
        JsonElement jsonElement = asJsonObject.get("data");
        if (jsonElement != null) {
            JsonObject asJsonObject2 = jsonElement.getAsJsonObject();
            entity = handleType(gson, asJsonObject2, asJsonObject2.get("entityType").getAsString());
        } else {
            entity = null;
        }
        return wrapAsResult(asJsonObject, entity);
    }

    public static Result<List<Entity>> convertEntityList(Gson gson, String str) {
        JsonObject asJsonObject = JsonParser.parseString(str).getAsJsonObject();
        JsonElement jsonElement = asJsonObject.get("data");
        Object handleType = jsonElement != null ? handleType(gson, jsonElement.getAsJsonArray()) : null;
        if (handleType == null) {
            handleType = new ArrayList();
        }
        return wrapAsResult(asJsonObject, handleType);
    }

    public static Result<UserProfile> convertUserProfile(Gson gson, String str) {
        JsonObject asJsonObject = JsonParser.parseString(str).getAsJsonObject();
        JsonElement jsonElement = asJsonObject.get("data");
        UserProfile userProfile = null;
        List<Entity> list = null;
        if (jsonElement != null) {
            JsonObject asJsonObject2 = jsonElement.getAsJsonObject();
            if (asJsonObject2.has("homeTabCardRows")) {
                list = handleType(gson, asJsonObject2.get("homeTabCardRows").getAsJsonArray());
                asJsonObject2.remove("homeTabCardRows");
            }
            UserProfile userProfile2 = (UserProfile) gson.fromJson((JsonElement) asJsonObject2, (Class<Object>) UserProfile.class);
            userProfile = list != null ? UserProfile.builder(userProfile2).setHomeTabCardRows(list).build() : userProfile2;
        }
        return wrapAsResult(asJsonObject, userProfile);
    }

    public static Entity handleType(Gson gson, JsonObject jsonObject, String str) {
        Entity entity;
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -2136267384:
                    if (str.equals("titleCard")) {
                        c = '&';
                        break;
                    }
                    break;
                case -1974884838:
                    if (str.equals("tabGroupCard")) {
                        c = '#';
                        break;
                    }
                    break;
                case -1765643847:
                    if (str.equals("recentHistory")) {
                        c = 'A';
                        break;
                    }
                    break;
                case -1754586358:
                    if (str.equals("apkListCard")) {
                        c = '\r';
                        break;
                    }
                    break;
                case -1741312354:
                    if (str.equals("collection")) {
                        c = ':';
                        break;
                    }
                    break;
                case -1583570103:
                    if (str.equals("imageListCard")) {
                        c = 21;
                        break;
                    }
                    break;
                case -1414998512:
                    if (str.equals("pearGoods")) {
                        c = '/';
                        break;
                    }
                    break;
                case -1309962167:
                    if (str.equals("messageExtra")) {
                        c = '2';
                        break;
                    }
                    break;
                case -1216055496:
                    if (str.equals("imageScrollCard")) {
                        c = 20;
                        break;
                    }
                    break;
                case -1115058732:
                    if (str.equals("headline")) {
                        c = 31;
                        break;
                    }
                    break;
                case -1079225818:
                    if (str.equals("docListCard")) {
                        c = 29;
                        break;
                    }
                    break;
                case -1031509124:
                    if (str.equals("deviceParams")) {
                        c = 'B';
                        break;
                    }
                    break;
                case -1004153379:
                    if (str.equals("textCard")) {
                        c = 27;
                        break;
                    }
                    break;
                case -878677237:
                    if (str.equals("imageCard")) {
                        c = 26;
                        break;
                    }
                    break;
                case -873622601:
                    if (str.equals("messageCard")) {
                        c = '!';
                        break;
                    }
                    break;
                case -743768816:
                    if (str.equals("shareUrl")) {
                        c = 'G';
                        break;
                    }
                    break;
                case -732377866:
                    if (str.equals("article")) {
                        c = '+';
                        break;
                    }
                    break;
                case -710374190:
                    if (str.equals("searchWord")) {
                        c = '1';
                        break;
                    }
                    break;
                case -652998748:
                    if (str.equals("feedQuestion")) {
                        c = '-';
                        break;
                    }
                    break;
                case -567451565:
                    if (str.equals("contacts")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -464911232:
                    if (str.equals("itemPlaceHolder")) {
                        c = ';';
                        break;
                    }
                    break;
                case -334215421:
                    if (str.equals("dyhArticle")) {
                        c = 24;
                        break;
                    }
                    break;
                case -309474065:
                    if (str.equals("product")) {
                        c = '<';
                        break;
                    }
                    break;
                case -235559235:
                    if (str.equals("pear_goods")) {
                        c = '0';
                        break;
                    }
                    break;
                case -232766085:
                    if (str.equals("liveMessage")) {
                        c = '6';
                        break;
                    }
                    break;
                case -174423732:
                    if (str.equals("liveSystemMessage")) {
                        c = '5';
                        break;
                    }
                    break;
                case -121207376:
                    if (str.equals("discovery")) {
                        c = 7;
                        break;
                    }
                    break;
                case 96432:
                    if (str.equals("ads")) {
                        c = '$';
                        break;
                    }
                    break;
                case 96796:
                    if (str.equals("apk")) {
                        c = 0;
                        break;
                    }
                    break;
                case 99955:
                    if (str.equals("dyh")) {
                        c = ',';
                        break;
                    }
                    break;
                case 3015911:
                    if (str.equals("back")) {
                        c = '9';
                        break;
                    }
                    break;
                case 3046160:
                    if (str.equals("card")) {
                        c = 14;
                        break;
                    }
                    break;
                case 3138974:
                    if (str.equals("feed")) {
                        c = 6;
                        break;
                    }
                    break;
                case 3172656:
                    if (str.equals("gift")) {
                        c = 30;
                        break;
                    }
                    break;
                case 3321850:
                    if (str.equals("link")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3433103:
                    if (str.equals("page")) {
                        c = '@';
                        break;
                    }
                    break;
                case 3599307:
                    if (str.equals("user")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 50511102:
                    if (str.equals("category")) {
                        c = 3;
                        break;
                    }
                    break;
                case 92896879:
                    if (str.equals("album")) {
                        c = 4;
                        break;
                    }
                    break;
                case 98539350:
                    if (str.equals("goods")) {
                        c = 'F';
                        break;
                    }
                    break;
                case 110546223:
                    if (str.equals("topic")) {
                        c = ')';
                        break;
                    }
                    break;
                case 112202875:
                    if (str.equals("video")) {
                        c = '4';
                        break;
                    }
                    break;
                case 181378138:
                    if (str.equals("topGroupCard")) {
                        c = '\"';
                        break;
                    }
                    break;
                case 222748253:
                    if (str.equals("textCarouselCard")) {
                        c = 17;
                        break;
                    }
                    break;
                case 248946207:
                    if (str.equals("albumCard")) {
                        c = 5;
                        break;
                    }
                    break;
                case 261655391:
                    if (str.equals("iconLargeScrollCard")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 295732393:
                    if (str.equals("iconLinkGridCard")) {
                        c = 18;
                        break;
                    }
                    break;
                case 317548406:
                    if (str.equals("gridCard")) {
                        c = 22;
                        break;
                    }
                    break;
                case 352612224:
                    if (str.equals("unLoginCard")) {
                        c = 25;
                        break;
                    }
                    break;
                case 362109016:
                    if (str.equals("imageTextCard")) {
                        c = 28;
                        break;
                    }
                    break;
                case 580594953:
                    if (str.equals("feed_reply")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 595233003:
                    if (str.equals("notification")) {
                        c = 11;
                        break;
                    }
                    break;
                case 648355698:
                    if (str.equals("liveUserDisallow")) {
                        c = '8';
                        break;
                    }
                    break;
                case 925449847:
                    if (str.equals("textLinkCard")) {
                        c = '3';
                        break;
                    }
                    break;
                case 926934164:
                    if (str.equals("history")) {
                        c = '\'';
                        break;
                    }
                    break;
                case 954925063:
                    if (str.equals("message")) {
                        c = ' ';
                        break;
                    }
                    break;
                case 987712472:
                    if (str.equals("productBrand")) {
                        c = '=';
                        break;
                    }
                    break;
                case 997486645:
                    if (str.equals("productMedia")) {
                        c = '?';
                        break;
                    }
                    break;
                case 998694819:
                    if (str.equals("liveTopic")) {
                        c = '7';
                        break;
                    }
                    break;
                case 1029507142:
                    if (str.equals("productSeries")) {
                        c = '>';
                        break;
                    }
                    break;
                case 1050790300:
                    if (str.equals("favorite")) {
                        c = '%';
                        break;
                    }
                    break;
                case 1144606592:
                    if (str.equals("appForum")) {
                        c = '(';
                        break;
                    }
                    break;
                case 1166033471:
                    if (str.equals("nodeRating")) {
                        c = 'D';
                        break;
                    }
                    break;
                case 1193677354:
                    if (str.equals("linkCard")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1345134798:
                    if (str.equals("listCard")) {
                        c = 19;
                        break;
                    }
                    break;
                case 1354449533:
                    if (str.equals("imageCarouselCard_1")) {
                        c = 15;
                        break;
                    }
                    break;
                case 1354449534:
                    if (str.equals("imageCarouselCard_2")) {
                        c = 16;
                        break;
                    }
                    break;
                case 1385626596:
                    if (str.equals("articleListCard")) {
                        c = 23;
                        break;
                    }
                    break;
                case 1394352404:
                    if (str.equals("goodsList")) {
                        c = 'E';
                        break;
                    }
                    break;
                case 1652818435:
                    if (str.equals("forwardFeed")) {
                        c = '.';
                        break;
                    }
                    break;
                case 1999423259:
                    if (str.equals("mainErshouType")) {
                        c = 'C';
                        break;
                    }
                    break;
                case 2118602430:
                    if (str.equals("dyhLogo")) {
                        c = '*';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) ServiceApp.class);
                    break;
                case 1:
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) Link.class);
                    break;
                case 2:
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) LinkCard.class);
                    break;
                case 3:
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) AppCategory.class);
                    break;
                case 4:
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) Album.class);
                    break;
                case 5:
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) AlbumItem.class);
                    break;
                case 6:
                    entity = handleFeedType(gson, jsonObject);
                    break;
                case 7:
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) Feed.class);
                    break;
                case '\b':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) Contacts.class);
                    break;
                case '\t':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) User.class);
                    break;
                case '\n':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) FeedReply.class);
                    break;
                case 11:
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) Notification.class);
                    break;
                case '\f':
                case '\r':
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                    try {
                        EntityCard.Builder extraData = EntityCard.builder().setTitle(GsonUtils.optString(jsonObject, "title")).setUrl(GsonUtils.optString(jsonObject, "url")).setEntityTypeName(GsonUtils.optString(jsonObject, "title")).setEntityType(str).setSubTitle(GsonUtils.optString(jsonObject, "subTitle")).setDescription(GsonUtils.optString(jsonObject, "description")).setEntityId(GsonUtils.optString(jsonObject, "entityId")).setEntityFixed(GsonUtils.optInt(jsonObject, "entityFixed")).setPic(GsonUtils.optString(jsonObject, "pic")).setEntityTemplate(GsonUtils.optString(jsonObject, "entityTemplate")).setId(GsonUtils.optString(jsonObject, "id")).setDateline(GsonUtils.optLong(jsonObject, "dateline")).setLastUpdate(GsonUtils.optLong(jsonObject, "lastupdate")).setExtraData(GsonUtils.optString(jsonObject, "extraData"));
                        JsonElement jsonElement = jsonObject.get("entities");
                        List<Entity> handleType = jsonElement.isJsonArray() ? handleType(gson, jsonElement.getAsJsonArray()) : null;
                        if (handleType == null) {
                            handleType = new ArrayList<>();
                        }
                        extraData.setEntities(handleType);
                        entity = extraData.build();
                        break;
                    } catch (Exception e) {
                        LogUtils.json(jsonObject.toString());
                        e.printStackTrace();
                        return null;
                    }
                case 30:
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) Gift.class);
                    break;
                case 31:
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) NewHeadLine.class);
                    break;
                case ' ':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) Message.class);
                    break;
                case '!':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) MessageCard.class);
                    break;
                case '\"':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) TopGroupCard.class);
                    break;
                case '#':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) TabGroupCard.class);
                    break;
                case '$':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) Ads.class);
                    break;
                case '%':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) Favorite.class);
                    break;
                case '&':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) TitleCard.class);
                    break;
                case '\'':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) UserHistory.class);
                    break;
                case '(':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) AppForum.class);
                    break;
                case ')':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) Topic.class);
                    break;
                case '*':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) DyhLogoCard.class);
                    break;
                case '+':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) DyhArticle.class);
                    break;
                case ',':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) DyhModel.class);
                    break;
                case '-':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) FeedQuestion.class);
                    break;
                case '.':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) ForwardFeed.class);
                    break;
                case '/':
                case '0':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) Goods.class);
                    break;
                case '1':
                case '2':
                case '3':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) SimpleEntity.class);
                    break;
                case '4':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) Video.class);
                    break;
                case '5':
                case '6':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) LiveMessage.class);
                    break;
                case '7':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) Live.class);
                    break;
                case '8':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) LiveUser.class);
                    break;
                case '9':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) BackupInfo.class);
                    break;
                case ':':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) Collection.class);
                    break;
                case ';':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) ItemPlaceHolder.class);
                    break;
                case '<':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) Product.class);
                    break;
                case '=':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) ProductBrand.class);
                    break;
                case '>':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) ProductSeries.class);
                    break;
                case '?':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) ProductMedia.class);
                    break;
                case '@':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) ConfigPage.class);
                    break;
                case 'A':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) RecentHistory.class);
                    break;
                case 'B':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) DeviceParams.class);
                    break;
                case 'C':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) MainSecondHandType.class);
                    break;
                case 'D':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) NodeRating.class);
                    break;
                case 'E':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) FunThings.class);
                    break;
                case 'F':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) FeedGoods.class);
                    break;
                case 'G':
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) ShareFeedInfo.class);
                    break;
                default:
                    LogUtils.d("Unknown entityType %s", str);
                    entity = (Entity) gson.fromJson((JsonElement) jsonObject, (Class<Object>) SimpleEntity.class);
                    break;
            }
            return entity;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x008a A[ADDED_TO_REGION] */
    private static Feed handleFeedType(Gson gson, JsonObject jsonObject) {
        Entity entity;
        Entity entity2;
        Entity entity3;
        Exception e;
        List<Entity> emptyList = Collections.emptyList();
        Entity entity4 = null;
        try {
            if (jsonObject.has("extra_entities")) {
                emptyList = handleType(gson, jsonObject.getAsJsonArray("extra_entities"));
                jsonObject.remove("extra_entities");
            }
            if (jsonObject.has("noticeSponsorCard")) {
                JsonObject asJsonObject = jsonObject.getAsJsonObject("noticeSponsorCard");
                entity = handleType(gson, asJsonObject, asJsonObject.get("entityType").getAsString());
                try {
                    jsonObject.remove("noticeSponsorCard");
                } catch (Exception e2) {
                    e = e2;
                    entity3 = null;
                    entity2 = null;
                    entity4 = entity;
                    e.printStackTrace();
                    entity = entity4;
                    entity4 = entity3;
                    Feed feed = (Feed) gson.fromJson((JsonElement) jsonObject, (Class<Object>) Feed.class);
                    if (entity == null) {
                    }
                }
            } else {
                entity = null;
            }
            if (jsonObject.has("detailSponsorCard")) {
                JsonObject asJsonObject2 = jsonObject.getAsJsonObject("detailSponsorCard");
                entity2 = handleType(gson, asJsonObject2, asJsonObject2.get("entityType").getAsString());
                try {
                    jsonObject.remove("detailSponsorCard");
                } catch (Exception e3) {
                    e = e3;
                    entity3 = null;
                    entity4 = entity;
                    e.printStackTrace();
                    entity = entity4;
                    entity4 = entity3;
                    Feed feed = (Feed) gson.fromJson((JsonElement) jsonObject, (Class<Object>) Feed.class);
                    if (entity == null) {
                    }
                }
            } else {
                entity2 = null;
            }
            if (jsonObject.has("hotSponsorCard")) {
                JsonObject asJsonObject3 = jsonObject.getAsJsonObject("hotSponsorCard");
                entity4 = handleType(gson, asJsonObject3, asJsonObject3.get("entityType").getAsString());
                jsonObject.remove("hotSponsorCard");
            }
        } catch (Exception e4) {
            e = e4;
            entity3 = null;
            entity2 = null;
            e.printStackTrace();
            entity = entity4;
            entity4 = entity3;
            Feed feed = (Feed) gson.fromJson((JsonElement) jsonObject, (Class<Object>) Feed.class);
            if (entity == null) {
            }
        }
        Feed feed = (Feed) gson.fromJson((JsonElement) jsonObject, (Class<Object>) Feed.class);
        return (entity == null || entity2 != null || entity4 != null || !emptyList.isEmpty()) ? Feed.newBuilder(feed).noticeSponsorCard(entity).detailSponsorCard(entity2).hotSponsorCard(entity4).extraEntities(emptyList).build() : feed;
    }

    public static List<Entity> handleType(Gson gson, JsonArray jsonArray) {
        ArrayList arrayList = new ArrayList();
        Iterator<JsonElement> it2 = jsonArray.iterator();
        while (it2.hasNext()) {
            JsonObject asJsonObject = it2.next().getAsJsonObject();
            Entity handleType = handleType(gson, asJsonObject, asJsonObject.get("entityType").getAsString());
            if (handleType != null) {
                arrayList.add(handleType);
            }
        }
        return arrayList;
    }

    public static <T> Result<T> wrapAsResult(JsonObject jsonObject, T t) {
        int asInt = jsonObject.has("status") ? jsonObject.get("status").getAsInt() : 1;
        String str = null;
        String asString = jsonObject.has("message") ? jsonObject.get("message").getAsString() : null;
        String asString2 = jsonObject.has("forwardUrl") ? jsonObject.get("forwardUrl").getAsString() : null;
        String asString3 = jsonObject.has("messageStatus") ? jsonObject.get("messageStatus").getAsString() : null;
        if (jsonObject.has("messageExtra")) {
            str = jsonObject.get("messageExtra").getAsString();
        }
        return new Result<>(Integer.valueOf(asInt), asString, asString2, asString3, str, t);
    }

    public static <T> Result<T> wrapAsResult(JSONObject jSONObject, T t) {
        int optInt = jSONObject.has("status") ? jSONObject.optInt("status") : 1;
        String str = null;
        String optString = jSONObject.has("message") ? jSONObject.optString("message") : null;
        String optString2 = jSONObject.has("forwardUrl") ? jSONObject.optString("forwardUrl") : null;
        String optString3 = jSONObject.has("messageStatus") ? jSONObject.optString("messageStatus") : null;
        if (jSONObject.has("messageExtra")) {
            str = jSONObject.optString("messageExtra");
        }
        return new Result<>(Integer.valueOf(optInt), optString, optString2, optString3, str, t);
    }
}
