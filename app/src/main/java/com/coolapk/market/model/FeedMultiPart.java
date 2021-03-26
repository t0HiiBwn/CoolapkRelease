package com.coolapk.market.model;

import android.os.Parcelable;
import com.coolapk.market.model.C$AutoValue_FeedMultiPart;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public abstract class FeedMultiPart implements Parcelable {
    public static final int CURRENT_VERSION = 1;
    public static final int VISIBLE_STATE_ME = -1;
    public static final int VISIBLE_STATE_PUBLIC = 1;

    public static abstract class Builder {
        public abstract Builder agree(int i);

        public abstract FeedMultiPart build();

        public abstract Builder buyStatus(boolean z);

        public abstract Builder categoryId(int i);

        public abstract Builder cityCode(String str);

        public abstract Builder commentBad(String str);

        public abstract Builder commentBadPic(String str);

        public abstract Builder commentGeneral(String str);

        public abstract Builder commentGeneralPic(String str);

        public abstract Builder commentGood(String str);

        public abstract Builder commentGoodPic(String str);

        public abstract Builder compressFlag(int i);

        public abstract Builder dyhId(String str);

        public abstract Builder extraInfo(String str);

        public abstract Builder extraKey(String str);

        public abstract Builder extraPic(String str);

        public abstract Builder extraTitle(String str);

        public abstract Builder extraUrl(String str);

        public abstract Builder feedId(String str);

        public abstract Builder forwardId(String str);

        public abstract Builder id(String str);

        public abstract Builder imageUriList(List<ImageUrl> list);

        public abstract Builder insertProductMedia(boolean z);

        public abstract Builder isAnonymous(boolean z);

        public abstract Builder isDisallowReply(boolean z);

        public abstract Builder isDisallowRepost(boolean z);

        public abstract Builder isEditInDyh(boolean z);

        public abstract Builder isHtmlArticle(boolean z);

        public abstract Builder isReplyWithForward(boolean z);

        public abstract Builder latitude(double d);

        public abstract Builder location(String str);

        public abstract Builder locationCity(String str);

        public abstract Builder locationCountry(String str);

        public abstract Builder longLocation(String str);

        public abstract Builder longitude(double d);

        public abstract Builder mediaInfo(String str);

        public abstract Builder mediaPic(String str);

        public abstract Builder mediaType(int i);

        public abstract Builder mediaUrl(String str);

        public abstract Builder message(String str);

        public abstract Builder messageBrief(String str);

        public abstract Builder messageCover(String str);

        public abstract Builder messageTitle(String str);

        public abstract Builder pic(String str);

        public abstract Builder productConfig(String str);

        public abstract Builder productId(String str);

        public abstract Builder province(String str);

        public abstract Builder ratingScore1(int i);

        public abstract Builder risePriceType(int i);

        public abstract Builder secondHandDealType(int i);

        public abstract Builder secondHandFaceDeal(int i);

        public abstract Builder secondHandOutLink(String str);

        public abstract Builder secondHandPrice(String str);

        public abstract Builder secondHandSthType(String str);

        public abstract Builder secondHandType(int i);

        public abstract Builder targetId(String str);

        public abstract Builder targetType(String str);

        public abstract Builder type(String str);

        public abstract Builder uploadDir(String str);

        public abstract Builder version(int i);

        public abstract Builder visibleStatus(int i);

        public abstract Builder voteAnonymousStatus(int i);

        public abstract Builder voteEndTime(long j);

        public abstract Builder voteMaxSelectNum(int i);

        public abstract Builder voteMinSelectNum(int i);

        public abstract Builder voteOptionColors(List<String> list);

        public abstract Builder voteOptions(List<String> list);

        public abstract Builder votePage(String str);

        public abstract Builder voteScore(int i);

        public abstract Builder voteShowAuthor(int i);

        public abstract Builder voteTag(String str);

        public abstract Builder voteType(int i);
    }

    public interface TargetType {
        public static final String APK = "apk";
        public static final String PHONE = "phone";
        public static final String PRODUCT_PHONE = "product_phone";
        public static final String TAG = "tag";
    }

    public interface Type {
        public static final String ANSWER = "answer";
        public static final String COMMENT = "comment";
        public static final String DISCOVERY = "discovery";
        public static final String DYH = "dyh";
        public static final String FEED = "feed";
        public static final String GOODS = "goods";
        public static final String PICTURE = "picture";
        public static final String QUESTION = "question";
        public static final String RATING = "rating";
        public static final String SECONDHAND = "ershou";
        public static final String SHARE = "url";
        public static final String VOTE = "vote";
        public static final String VOTE_COMMENT = "voteComment";
    }

    public abstract int agree();

    public abstract boolean buyStatus();

    public abstract int categoryId();

    public abstract String cityCode();

    public abstract String commentBad();

    public abstract String commentBadPic();

    public abstract String commentGeneral();

    public abstract String commentGeneralPic();

    public abstract String commentGood();

    public abstract String commentGoodPic();

    public abstract int compressFlag();

    public abstract String dyhId();

    public abstract String extraInfo();

    public abstract String extraKey();

    public abstract String extraPic();

    public abstract String extraTitle();

    public abstract String extraUrl();

    public abstract String feedId();

    public abstract String forwardId();

    public abstract String id();

    public abstract List<ImageUrl> imageUriList();

    public abstract boolean insertProductMedia();

    public abstract boolean isAnonymous();

    public abstract boolean isDisallowReply();

    public abstract boolean isDisallowRepost();

    public abstract boolean isEditInDyh();

    public abstract boolean isHtmlArticle();

    public abstract boolean isReplyWithForward();

    public abstract double latitude();

    public abstract String location();

    public abstract String locationCity();

    public abstract String locationCountry();

    public abstract String longLocation();

    public abstract double longitude();

    public abstract String mediaInfo();

    public abstract String mediaPic();

    public abstract int mediaType();

    public abstract String mediaUrl();

    public abstract String message();

    public abstract String messageBrief();

    public abstract String messageCover();

    public abstract String messageTitle();

    public abstract String pic();

    public abstract String productConfig();

    public abstract String productId();

    public abstract String province();

    public abstract int ratingScore1();

    public abstract int risePriceType();

    public abstract int secondHandDealType();

    public abstract int secondHandFaceDeal();

    public abstract String secondHandOutLink();

    public abstract String secondHandPrice();

    public abstract String secondHandSthType();

    public abstract int secondHandType();

    public abstract String targetId();

    public abstract String targetType();

    public abstract String type();

    public abstract String uploadDir();

    public abstract int version();

    public abstract int visibleStatus();

    public abstract int voteAnonymousStatus();

    public abstract long voteEndTime();

    public abstract int voteMaxSelectNum();

    public abstract int voteMinSelectNum();

    public abstract List<String> voteOptionColors();

    public abstract List<String> voteOptions();

    public abstract String votePage();

    public abstract int voteScore();

    public abstract int voteShowAuthor();

    public abstract String voteTag();

    public abstract int voteType();

    public Builder newBuilder() {
        return builder(this);
    }

    public static Builder builder(FeedMultiPart feedMultiPart) {
        if (feedMultiPart == null) {
            return builder();
        }
        return new C$AutoValue_FeedMultiPart.Builder(feedMultiPart);
    }

    public static Builder builder() {
        return new C$AutoValue_FeedMultiPart.Builder().id("").message("").type("").isHtmlArticle(false).imageUriList(new ArrayList()).visibleStatus(1).location("").longLocation("").latitude(0.0d).longitude(0.0d).mediaUrl("").mediaType(0).mediaPic("").messageBrief("").extraTitle("").extraUrl("").extraKey("").extraPic("").extraInfo("").messageTitle("").messageCover("").isDisallowRepost(false).isAnonymous(false).isEditInDyh(false).dyhId("").forwardId("").isReplyWithForward(false).feedId("").targetType("").targetId("").voteScore(0).pic("").locationCity("").locationCountry("").isDisallowReply(false).uploadDir("feed").compressFlag(0).mediaInfo("").secondHandType(0).secondHandOutLink("").secondHandPrice("").secondHandSthType("").productId("").agree(0).secondHandFaceDeal(0).productConfig("").province("").cityCode("").secondHandDealType(0).risePriceType(0).insertProductMedia(false).voteType(0).voteEndTime(604800).voteMinSelectNum(1).voteMaxSelectNum(1).voteAnonymousStatus(0).voteOptions(new ArrayList()).voteTag("").votePage("").voteOptionColors(new ArrayList()).voteShowAuthor(1).version(1).ratingScore1(0).commentBad("").commentBadPic("").commentGeneral("").commentGeneralPic("").commentGood("").commentGoodPic("").buyStatus(false).categoryId(0);
    }

    public RequestBody buildRequestBody() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        FormBody.Builder builder = new FormBody.Builder();
        String str8 = "1";
        FormBody.Builder add = builder.add("id", id()).add("message", message()).add("type", type()).add("is_html_article", isHtmlArticle() ? str8 : "0").add("pic", pic()).add("status", Integer.toString(visibleStatus())).add("location", location()).add("long_location", longLocation()).add("latitude", Double.toString(latitude())).add("longitude", Double.toString(longitude())).add("media_url", mediaUrl()).add("media_type", Integer.toString(mediaType())).add("media_pic", mediaPic()).add("message_title", messageTitle()).add("message_brief", messageBrief()).add("extra_title", extraTitle()).add("extra_url", extraUrl()).add("extra_key", extraKey()).add("extra_pic", extraPic()).add("extra_info", extraInfo()).add("message_cover", messageCover());
        if (isDisallowRepost()) {
            str = str8;
        } else {
            str = "0";
        }
        FormBody.Builder add2 = add.add("disallow_repost", str);
        if (isAnonymous()) {
            str2 = str8;
        } else {
            str2 = "0";
        }
        FormBody.Builder add3 = add2.add("is_anonymous", str2);
        if (isEditInDyh()) {
            str3 = str8;
        } else {
            str3 = "0";
        }
        FormBody.Builder add4 = add3.add("is_editInDyh", str3).add("forwardid", forwardId()).add("fid", feedId()).add("dyhId", dyhId()).add("targetType", targetType()).add("productId", productId()).add("province", province()).add("city_code", cityCode()).add("province", province()).add("city_code", cityCode()).add("targetId", targetId()).add("location_city", locationCity()).add("location_country", locationCountry());
        if (isDisallowReply()) {
            str4 = str8;
        } else {
            str4 = "0";
        }
        FormBody.Builder add5 = add4.add("disallow_reply", str4).add("vote_score", Integer.toString(voteScore()));
        if (isReplyWithForward()) {
            str5 = str8;
        } else {
            str5 = "0";
        }
        FormBody.Builder add6 = add5.add("replyWithForward", str5).add("media_info", mediaInfo());
        if (insertProductMedia()) {
            str6 = str8;
        } else {
            str6 = "0";
        }
        add6.add("insert_product_media", str6);
        if (type().equals("ershou")) {
            builder.add("ershou_link", secondHandOutLink()).add("ershou_price", secondHandPrice()).add("ershouTypeId", secondHandSthType()).add("store_type", Integer.toString(secondHandType())).add("ershou_deal_type", Integer.toString(secondHandDealType())).add("face_deal", Integer.toString(secondHandFaceDeal())).add("agree", Integer.toString(agree())).add("exchange_type", Integer.toString(risePriceType())).add("ershou_config", productConfig());
        }
        if (type().equals("rating")) {
            builder.add("rating_score_1", String.valueOf(ratingScore1())).add("comment_good", commentGood()).add("comment_general", commentGeneral()).add("comment_bad", commentBad()).add("comment_good_pic", commentGoodPic()).add("comment_bad_pic", commentBadPic()).add("comment_general_pic", commentGeneralPic());
            if ("product_phone".equals(targetType())) {
                if (buyStatus()) {
                    str7 = str8;
                } else {
                    str7 = "0";
                }
                builder.add("buy_status", str7);
            }
        }
        if (type().equals("vote")) {
            long voteEndTime = voteEndTime();
            if (voteEndTime > 2592000) {
                voteEndTime -= System.currentTimeMillis() / 1000;
            }
            builder.add("vote_type", String.valueOf(voteType())).add("vote_anonymous_status", String.valueOf(voteAnonymousStatus())).add("vote_end_time", String.valueOf(voteEndTime)).add("vote_min_select_num", String.valueOf(voteMinSelectNum())).add("vote_tag", voteTag()).add("vote_page", votePage()).add("vote_show_author", String.valueOf(voteShowAuthor()));
            int size = voteOptions().size();
            int voteMaxSelectNum = voteMaxSelectNum();
            int i = 2;
            if (voteType() == 0) {
                if (voteOptionColors().size() == 2) {
                    builder.add("vote_option_color[0]", voteOptionColors().get(0));
                    builder.add("vote_option_color[1]", voteOptionColors().get(1));
                }
                size = 1;
            } else {
                i = size;
                if (voteMaxSelectNum <= size) {
                    size = voteMaxSelectNum;
                }
            }
            builder.add("vote_max_select_num", String.valueOf(size));
            for (int i2 = 0; i2 < i; i2++) {
                builder.add(String.format(Locale.getDefault(), "vote_option[%d]", Integer.valueOf(i2)), voteOptions().get(i2));
            }
        }
        if (type().equals("goods")) {
            if (!buyStatus()) {
                str8 = "0";
            }
            builder.add("buy_status", str8);
            builder.add("rating_score_1", String.valueOf(ratingScore1()));
            builder.add("category_id", String.valueOf(categoryId()));
        }
        return builder.build();
    }
}
