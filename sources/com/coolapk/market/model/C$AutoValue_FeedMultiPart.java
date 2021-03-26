package com.coolapk.market.model;

import com.coolapk.market.model.FeedMultiPart;
import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$AutoValue_FeedMultiPart  reason: invalid class name */
abstract class C$AutoValue_FeedMultiPart extends FeedMultiPart {
    private final int agree;
    private final boolean buyStatus;
    private final int categoryId;
    private final String cityCode;
    private final String commentBad;
    private final String commentBadPic;
    private final String commentGeneral;
    private final String commentGeneralPic;
    private final String commentGood;
    private final String commentGoodPic;
    private final int compressFlag;
    private final String dyhId;
    private final String extraInfo;
    private final String extraKey;
    private final String extraPic;
    private final String extraTitle;
    private final String extraUrl;
    private final String feedId;
    private final String forwardId;
    private final String id;
    private final List<ImageUrl> imageUriList;
    private final boolean insertProductMedia;
    private final boolean isAnonymous;
    private final boolean isDisallowReply;
    private final boolean isDisallowRepost;
    private final boolean isEditInDyh;
    private final boolean isHtmlArticle;
    private final boolean isReplyWithForward;
    private final double latitude;
    private final String location;
    private final String locationCity;
    private final String locationCountry;
    private final String longLocation;
    private final double longitude;
    private final String mediaInfo;
    private final String mediaPic;
    private final int mediaType;
    private final String mediaUrl;
    private final String message;
    private final String messageBrief;
    private final String messageCover;
    private final String messageTitle;
    private final String pic;
    private final String productConfig;
    private final String productId;
    private final String province;
    private final int ratingScore1;
    private final int risePriceType;
    private final int secondHandDealType;
    private final int secondHandFaceDeal;
    private final String secondHandOutLink;
    private final String secondHandPrice;
    private final String secondHandSthType;
    private final int secondHandType;
    private final String targetId;
    private final String targetType;
    private final String type;
    private final String uploadDir;
    private final int version;
    private final int visibleStatus;
    private final int voteAnonymousStatus;
    private final long voteEndTime;
    private final int voteMaxSelectNum;
    private final int voteMinSelectNum;
    private final List<String> voteOptionColors;
    private final List<String> voteOptions;
    private final String votePage;
    private final int voteScore;
    private final int voteShowAuthor;
    private final String voteTag;
    private final int voteType;

    C$AutoValue_FeedMultiPart(String str, int i, String str2, String str3, boolean z, List<ImageUrl> list, String str4, int i2, String str5, String str6, double d, double d2, String str7, int i3, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, boolean z2, boolean z3, boolean z4, boolean z5, String str18, boolean z6, String str19, String str20, String str21, int i4, String str22, String str23, String str24, int i5, String str25, int i6, boolean z7, int i7, String str26, String str27, String str28, int i8, String str29, String str30, String str31, String str32, int i9, int i10, long j, int i11, int i12, List<String> list2, String str33, String str34, List<String> list3, int i13, int i14, int i15, int i16, String str35, String str36, String str37, String str38, String str39, String str40, boolean z8, int i17) {
        Objects.requireNonNull(str, "Null id");
        this.id = str;
        this.version = i;
        Objects.requireNonNull(str2, "Null message");
        this.message = str2;
        Objects.requireNonNull(str3, "Null type");
        this.type = str3;
        this.isHtmlArticle = z;
        Objects.requireNonNull(list, "Null imageUriList");
        this.imageUriList = list;
        Objects.requireNonNull(str4, "Null pic");
        this.pic = str4;
        this.visibleStatus = i2;
        Objects.requireNonNull(str5, "Null location");
        this.location = str5;
        Objects.requireNonNull(str6, "Null longLocation");
        this.longLocation = str6;
        this.latitude = d;
        this.longitude = d2;
        Objects.requireNonNull(str7, "Null mediaUrl");
        this.mediaUrl = str7;
        this.mediaType = i3;
        Objects.requireNonNull(str8, "Null mediaPic");
        this.mediaPic = str8;
        Objects.requireNonNull(str9, "Null messageTitle");
        this.messageTitle = str9;
        Objects.requireNonNull(str10, "Null messageBrief");
        this.messageBrief = str10;
        Objects.requireNonNull(str11, "Null extraTitle");
        this.extraTitle = str11;
        Objects.requireNonNull(str12, "Null extraUrl");
        this.extraUrl = str12;
        Objects.requireNonNull(str13, "Null extraKey");
        this.extraKey = str13;
        Objects.requireNonNull(str14, "Null extraPic");
        this.extraPic = str14;
        Objects.requireNonNull(str15, "Null extraInfo");
        this.extraInfo = str15;
        Objects.requireNonNull(str16, "Null messageCover");
        this.messageCover = str16;
        Objects.requireNonNull(str17, "Null dyhId");
        this.dyhId = str17;
        this.isDisallowRepost = z2;
        this.isAnonymous = z3;
        this.isDisallowReply = z4;
        this.isEditInDyh = z5;
        Objects.requireNonNull(str18, "Null forwardId");
        this.forwardId = str18;
        this.isReplyWithForward = z6;
        Objects.requireNonNull(str19, "Null feedId");
        this.feedId = str19;
        Objects.requireNonNull(str20, "Null targetType");
        this.targetType = str20;
        Objects.requireNonNull(str21, "Null targetId");
        this.targetId = str21;
        this.voteScore = i4;
        Objects.requireNonNull(str22, "Null uploadDir");
        this.uploadDir = str22;
        Objects.requireNonNull(str23, "Null locationCity");
        this.locationCity = str23;
        Objects.requireNonNull(str24, "Null locationCountry");
        this.locationCountry = str24;
        this.compressFlag = i5;
        Objects.requireNonNull(str25, "Null mediaInfo");
        this.mediaInfo = str25;
        this.ratingScore1 = i6;
        this.insertProductMedia = z7;
        this.secondHandType = i7;
        Objects.requireNonNull(str26, "Null secondHandOutLink");
        this.secondHandOutLink = str26;
        Objects.requireNonNull(str27, "Null secondHandPrice");
        this.secondHandPrice = str27;
        Objects.requireNonNull(str28, "Null secondHandSthType");
        this.secondHandSthType = str28;
        this.agree = i8;
        Objects.requireNonNull(str29, "Null productConfig");
        this.productConfig = str29;
        Objects.requireNonNull(str30, "Null productId");
        this.productId = str30;
        Objects.requireNonNull(str31, "Null province");
        this.province = str31;
        Objects.requireNonNull(str32, "Null cityCode");
        this.cityCode = str32;
        this.voteType = i9;
        this.voteAnonymousStatus = i10;
        this.voteEndTime = j;
        this.voteMinSelectNum = i11;
        this.voteMaxSelectNum = i12;
        Objects.requireNonNull(list2, "Null voteOptions");
        this.voteOptions = list2;
        Objects.requireNonNull(str33, "Null voteTag");
        this.voteTag = str33;
        Objects.requireNonNull(str34, "Null votePage");
        this.votePage = str34;
        Objects.requireNonNull(list3, "Null voteOptionColors");
        this.voteOptionColors = list3;
        this.voteShowAuthor = i13;
        this.secondHandDealType = i14;
        this.secondHandFaceDeal = i15;
        this.risePriceType = i16;
        Objects.requireNonNull(str35, "Null commentGood");
        this.commentGood = str35;
        Objects.requireNonNull(str36, "Null commentGoodPic");
        this.commentGoodPic = str36;
        Objects.requireNonNull(str37, "Null commentBad");
        this.commentBad = str37;
        Objects.requireNonNull(str38, "Null commentBadPic");
        this.commentBadPic = str38;
        Objects.requireNonNull(str39, "Null commentGeneral");
        this.commentGeneral = str39;
        Objects.requireNonNull(str40, "Null commentGeneralPic");
        this.commentGeneralPic = str40;
        this.buyStatus = z8;
        this.categoryId = i17;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String id() {
        return this.id;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public int version() {
        return this.version;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String message() {
        return this.message;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String type() {
        return this.type;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public boolean isHtmlArticle() {
        return this.isHtmlArticle;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public List<ImageUrl> imageUriList() {
        return this.imageUriList;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String pic() {
        return this.pic;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public int visibleStatus() {
        return this.visibleStatus;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String location() {
        return this.location;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String longLocation() {
        return this.longLocation;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public double latitude() {
        return this.latitude;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public double longitude() {
        return this.longitude;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String mediaUrl() {
        return this.mediaUrl;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public int mediaType() {
        return this.mediaType;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String mediaPic() {
        return this.mediaPic;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String messageTitle() {
        return this.messageTitle;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String messageBrief() {
        return this.messageBrief;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String extraTitle() {
        return this.extraTitle;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String extraUrl() {
        return this.extraUrl;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String extraKey() {
        return this.extraKey;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String extraPic() {
        return this.extraPic;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String extraInfo() {
        return this.extraInfo;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String messageCover() {
        return this.messageCover;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String dyhId() {
        return this.dyhId;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public boolean isDisallowRepost() {
        return this.isDisallowRepost;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public boolean isDisallowReply() {
        return this.isDisallowReply;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public boolean isEditInDyh() {
        return this.isEditInDyh;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String forwardId() {
        return this.forwardId;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public boolean isReplyWithForward() {
        return this.isReplyWithForward;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String feedId() {
        return this.feedId;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String targetType() {
        return this.targetType;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String targetId() {
        return this.targetId;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public int voteScore() {
        return this.voteScore;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String uploadDir() {
        return this.uploadDir;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String locationCity() {
        return this.locationCity;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String locationCountry() {
        return this.locationCountry;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public int compressFlag() {
        return this.compressFlag;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String mediaInfo() {
        return this.mediaInfo;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public int ratingScore1() {
        return this.ratingScore1;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public boolean insertProductMedia() {
        return this.insertProductMedia;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public int secondHandType() {
        return this.secondHandType;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String secondHandOutLink() {
        return this.secondHandOutLink;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String secondHandPrice() {
        return this.secondHandPrice;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String secondHandSthType() {
        return this.secondHandSthType;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public int agree() {
        return this.agree;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String productConfig() {
        return this.productConfig;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String productId() {
        return this.productId;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String province() {
        return this.province;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String cityCode() {
        return this.cityCode;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public int voteType() {
        return this.voteType;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public int voteAnonymousStatus() {
        return this.voteAnonymousStatus;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public long voteEndTime() {
        return this.voteEndTime;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public int voteMinSelectNum() {
        return this.voteMinSelectNum;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public int voteMaxSelectNum() {
        return this.voteMaxSelectNum;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public List<String> voteOptions() {
        return this.voteOptions;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String voteTag() {
        return this.voteTag;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String votePage() {
        return this.votePage;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public List<String> voteOptionColors() {
        return this.voteOptionColors;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public int voteShowAuthor() {
        return this.voteShowAuthor;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public int secondHandDealType() {
        return this.secondHandDealType;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public int secondHandFaceDeal() {
        return this.secondHandFaceDeal;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public int risePriceType() {
        return this.risePriceType;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String commentGood() {
        return this.commentGood;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String commentGoodPic() {
        return this.commentGoodPic;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String commentBad() {
        return this.commentBad;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String commentBadPic() {
        return this.commentBadPic;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String commentGeneral() {
        return this.commentGeneral;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public String commentGeneralPic() {
        return this.commentGeneralPic;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public boolean buyStatus() {
        return this.buyStatus;
    }

    @Override // com.coolapk.market.model.FeedMultiPart
    public int categoryId() {
        return this.categoryId;
    }

    @Override // java.lang.Object
    public String toString() {
        return "FeedMultiPart{id=" + this.id + ", version=" + this.version + ", message=" + this.message + ", type=" + this.type + ", isHtmlArticle=" + this.isHtmlArticle + ", imageUriList=" + this.imageUriList + ", pic=" + this.pic + ", visibleStatus=" + this.visibleStatus + ", location=" + this.location + ", longLocation=" + this.longLocation + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", mediaUrl=" + this.mediaUrl + ", mediaType=" + this.mediaType + ", mediaPic=" + this.mediaPic + ", messageTitle=" + this.messageTitle + ", messageBrief=" + this.messageBrief + ", extraTitle=" + this.extraTitle + ", extraUrl=" + this.extraUrl + ", extraKey=" + this.extraKey + ", extraPic=" + this.extraPic + ", extraInfo=" + this.extraInfo + ", messageCover=" + this.messageCover + ", dyhId=" + this.dyhId + ", isDisallowRepost=" + this.isDisallowRepost + ", isAnonymous=" + this.isAnonymous + ", isDisallowReply=" + this.isDisallowReply + ", isEditInDyh=" + this.isEditInDyh + ", forwardId=" + this.forwardId + ", isReplyWithForward=" + this.isReplyWithForward + ", feedId=" + this.feedId + ", targetType=" + this.targetType + ", targetId=" + this.targetId + ", voteScore=" + this.voteScore + ", uploadDir=" + this.uploadDir + ", locationCity=" + this.locationCity + ", locationCountry=" + this.locationCountry + ", compressFlag=" + this.compressFlag + ", mediaInfo=" + this.mediaInfo + ", ratingScore1=" + this.ratingScore1 + ", insertProductMedia=" + this.insertProductMedia + ", secondHandType=" + this.secondHandType + ", secondHandOutLink=" + this.secondHandOutLink + ", secondHandPrice=" + this.secondHandPrice + ", secondHandSthType=" + this.secondHandSthType + ", agree=" + this.agree + ", productConfig=" + this.productConfig + ", productId=" + this.productId + ", province=" + this.province + ", cityCode=" + this.cityCode + ", voteType=" + this.voteType + ", voteAnonymousStatus=" + this.voteAnonymousStatus + ", voteEndTime=" + this.voteEndTime + ", voteMinSelectNum=" + this.voteMinSelectNum + ", voteMaxSelectNum=" + this.voteMaxSelectNum + ", voteOptions=" + this.voteOptions + ", voteTag=" + this.voteTag + ", votePage=" + this.votePage + ", voteOptionColors=" + this.voteOptionColors + ", voteShowAuthor=" + this.voteShowAuthor + ", secondHandDealType=" + this.secondHandDealType + ", secondHandFaceDeal=" + this.secondHandFaceDeal + ", risePriceType=" + this.risePriceType + ", commentGood=" + this.commentGood + ", commentGoodPic=" + this.commentGoodPic + ", commentBad=" + this.commentBad + ", commentBadPic=" + this.commentBadPic + ", commentGeneral=" + this.commentGeneral + ", commentGeneralPic=" + this.commentGeneralPic + ", buyStatus=" + this.buyStatus + ", categoryId=" + this.categoryId + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FeedMultiPart)) {
            return false;
        }
        FeedMultiPart feedMultiPart = (FeedMultiPart) obj;
        if (!this.id.equals(feedMultiPart.id()) || this.version != feedMultiPart.version() || !this.message.equals(feedMultiPart.message()) || !this.type.equals(feedMultiPart.type()) || this.isHtmlArticle != feedMultiPart.isHtmlArticle() || !this.imageUriList.equals(feedMultiPart.imageUriList()) || !this.pic.equals(feedMultiPart.pic()) || this.visibleStatus != feedMultiPart.visibleStatus() || !this.location.equals(feedMultiPart.location()) || !this.longLocation.equals(feedMultiPart.longLocation()) || Double.doubleToLongBits(this.latitude) != Double.doubleToLongBits(feedMultiPart.latitude()) || Double.doubleToLongBits(this.longitude) != Double.doubleToLongBits(feedMultiPart.longitude()) || !this.mediaUrl.equals(feedMultiPart.mediaUrl()) || this.mediaType != feedMultiPart.mediaType() || !this.mediaPic.equals(feedMultiPart.mediaPic()) || !this.messageTitle.equals(feedMultiPart.messageTitle()) || !this.messageBrief.equals(feedMultiPart.messageBrief()) || !this.extraTitle.equals(feedMultiPart.extraTitle()) || !this.extraUrl.equals(feedMultiPart.extraUrl()) || !this.extraKey.equals(feedMultiPart.extraKey()) || !this.extraPic.equals(feedMultiPart.extraPic()) || !this.extraInfo.equals(feedMultiPart.extraInfo()) || !this.messageCover.equals(feedMultiPart.messageCover()) || !this.dyhId.equals(feedMultiPart.dyhId()) || this.isDisallowRepost != feedMultiPart.isDisallowRepost() || this.isAnonymous != feedMultiPart.isAnonymous() || this.isDisallowReply != feedMultiPart.isDisallowReply() || this.isEditInDyh != feedMultiPart.isEditInDyh() || !this.forwardId.equals(feedMultiPart.forwardId()) || this.isReplyWithForward != feedMultiPart.isReplyWithForward() || !this.feedId.equals(feedMultiPart.feedId()) || !this.targetType.equals(feedMultiPart.targetType()) || !this.targetId.equals(feedMultiPart.targetId()) || this.voteScore != feedMultiPart.voteScore() || !this.uploadDir.equals(feedMultiPart.uploadDir()) || !this.locationCity.equals(feedMultiPart.locationCity()) || !this.locationCountry.equals(feedMultiPart.locationCountry()) || this.compressFlag != feedMultiPart.compressFlag() || !this.mediaInfo.equals(feedMultiPart.mediaInfo()) || this.ratingScore1 != feedMultiPart.ratingScore1() || this.insertProductMedia != feedMultiPart.insertProductMedia() || this.secondHandType != feedMultiPart.secondHandType() || !this.secondHandOutLink.equals(feedMultiPart.secondHandOutLink()) || !this.secondHandPrice.equals(feedMultiPart.secondHandPrice()) || !this.secondHandSthType.equals(feedMultiPart.secondHandSthType()) || this.agree != feedMultiPart.agree() || !this.productConfig.equals(feedMultiPart.productConfig()) || !this.productId.equals(feedMultiPart.productId()) || !this.province.equals(feedMultiPart.province()) || !this.cityCode.equals(feedMultiPart.cityCode()) || this.voteType != feedMultiPart.voteType() || this.voteAnonymousStatus != feedMultiPart.voteAnonymousStatus() || this.voteEndTime != feedMultiPart.voteEndTime() || this.voteMinSelectNum != feedMultiPart.voteMinSelectNum() || this.voteMaxSelectNum != feedMultiPart.voteMaxSelectNum() || !this.voteOptions.equals(feedMultiPart.voteOptions()) || !this.voteTag.equals(feedMultiPart.voteTag()) || !this.votePage.equals(feedMultiPart.votePage()) || !this.voteOptionColors.equals(feedMultiPart.voteOptionColors()) || this.voteShowAuthor != feedMultiPart.voteShowAuthor() || this.secondHandDealType != feedMultiPart.secondHandDealType() || this.secondHandFaceDeal != feedMultiPart.secondHandFaceDeal() || this.risePriceType != feedMultiPart.risePriceType() || !this.commentGood.equals(feedMultiPart.commentGood()) || !this.commentGoodPic.equals(feedMultiPart.commentGoodPic()) || !this.commentBad.equals(feedMultiPart.commentBad()) || !this.commentBadPic.equals(feedMultiPart.commentBadPic()) || !this.commentGeneral.equals(feedMultiPart.commentGeneral()) || !this.commentGeneralPic.equals(feedMultiPart.commentGeneralPic()) || this.buyStatus != feedMultiPart.buyStatus() || this.categoryId != feedMultiPart.categoryId()) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 1231;
        int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((int) (((long) (((int) (((long) ((((((((((((((((((((this.id.hashCode() ^ 1000003) * 1000003) ^ this.version) * 1000003) ^ this.message.hashCode()) * 1000003) ^ this.type.hashCode()) * 1000003) ^ (this.isHtmlArticle ? 1231 : 1237)) * 1000003) ^ this.imageUriList.hashCode()) * 1000003) ^ this.pic.hashCode()) * 1000003) ^ this.visibleStatus) * 1000003) ^ this.location.hashCode()) * 1000003) ^ this.longLocation.hashCode()) * 1000003)) ^ ((Double.doubleToLongBits(this.latitude) >>> 32) ^ Double.doubleToLongBits(this.latitude)))) * 1000003)) ^ ((Double.doubleToLongBits(this.longitude) >>> 32) ^ Double.doubleToLongBits(this.longitude)))) * 1000003) ^ this.mediaUrl.hashCode()) * 1000003) ^ this.mediaType) * 1000003) ^ this.mediaPic.hashCode()) * 1000003) ^ this.messageTitle.hashCode()) * 1000003) ^ this.messageBrief.hashCode()) * 1000003) ^ this.extraTitle.hashCode()) * 1000003) ^ this.extraUrl.hashCode()) * 1000003) ^ this.extraKey.hashCode()) * 1000003) ^ this.extraPic.hashCode()) * 1000003) ^ this.extraInfo.hashCode()) * 1000003) ^ this.messageCover.hashCode()) * 1000003) ^ this.dyhId.hashCode()) * 1000003) ^ (this.isDisallowRepost ? 1231 : 1237)) * 1000003) ^ (this.isAnonymous ? 1231 : 1237)) * 1000003) ^ (this.isDisallowReply ? 1231 : 1237)) * 1000003) ^ (this.isEditInDyh ? 1231 : 1237)) * 1000003) ^ this.forwardId.hashCode()) * 1000003) ^ (this.isReplyWithForward ? 1231 : 1237)) * 1000003) ^ this.feedId.hashCode()) * 1000003) ^ this.targetType.hashCode()) * 1000003) ^ this.targetId.hashCode()) * 1000003) ^ this.voteScore) * 1000003) ^ this.uploadDir.hashCode()) * 1000003) ^ this.locationCity.hashCode()) * 1000003) ^ this.locationCountry.hashCode()) * 1000003) ^ this.compressFlag) * 1000003) ^ this.mediaInfo.hashCode()) * 1000003) ^ this.ratingScore1) * 1000003;
        int i2 = this.insertProductMedia ? 1231 : 1237;
        long j = this.voteEndTime;
        int hashCode2 = ((((((((((((((((((((((((((((((((((int) (((long) ((((((((((((((((((((((((hashCode ^ i2) * 1000003) ^ this.secondHandType) * 1000003) ^ this.secondHandOutLink.hashCode()) * 1000003) ^ this.secondHandPrice.hashCode()) * 1000003) ^ this.secondHandSthType.hashCode()) * 1000003) ^ this.agree) * 1000003) ^ this.productConfig.hashCode()) * 1000003) ^ this.productId.hashCode()) * 1000003) ^ this.province.hashCode()) * 1000003) ^ this.cityCode.hashCode()) * 1000003) ^ this.voteType) * 1000003) ^ this.voteAnonymousStatus) * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003) ^ this.voteMinSelectNum) * 1000003) ^ this.voteMaxSelectNum) * 1000003) ^ this.voteOptions.hashCode()) * 1000003) ^ this.voteTag.hashCode()) * 1000003) ^ this.votePage.hashCode()) * 1000003) ^ this.voteOptionColors.hashCode()) * 1000003) ^ this.voteShowAuthor) * 1000003) ^ this.secondHandDealType) * 1000003) ^ this.secondHandFaceDeal) * 1000003) ^ this.risePriceType) * 1000003) ^ this.commentGood.hashCode()) * 1000003) ^ this.commentGoodPic.hashCode()) * 1000003) ^ this.commentBad.hashCode()) * 1000003) ^ this.commentBadPic.hashCode()) * 1000003) ^ this.commentGeneral.hashCode()) * 1000003) ^ this.commentGeneralPic.hashCode()) * 1000003;
        if (!this.buyStatus) {
            i = 1237;
        }
        return ((hashCode2 ^ i) * 1000003) ^ this.categoryId;
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_FeedMultiPart$Builder */
    static final class Builder extends FeedMultiPart.Builder {
        private Integer agree;
        private Boolean buyStatus;
        private Integer categoryId;
        private String cityCode;
        private String commentBad;
        private String commentBadPic;
        private String commentGeneral;
        private String commentGeneralPic;
        private String commentGood;
        private String commentGoodPic;
        private Integer compressFlag;
        private String dyhId;
        private String extraInfo;
        private String extraKey;
        private String extraPic;
        private String extraTitle;
        private String extraUrl;
        private String feedId;
        private String forwardId;
        private String id;
        private List<ImageUrl> imageUriList;
        private Boolean insertProductMedia;
        private Boolean isAnonymous;
        private Boolean isDisallowReply;
        private Boolean isDisallowRepost;
        private Boolean isEditInDyh;
        private Boolean isHtmlArticle;
        private Boolean isReplyWithForward;
        private Double latitude;
        private String location;
        private String locationCity;
        private String locationCountry;
        private String longLocation;
        private Double longitude;
        private String mediaInfo;
        private String mediaPic;
        private Integer mediaType;
        private String mediaUrl;
        private String message;
        private String messageBrief;
        private String messageCover;
        private String messageTitle;
        private String pic;
        private String productConfig;
        private String productId;
        private String province;
        private Integer ratingScore1;
        private Integer risePriceType;
        private Integer secondHandDealType;
        private Integer secondHandFaceDeal;
        private String secondHandOutLink;
        private String secondHandPrice;
        private String secondHandSthType;
        private Integer secondHandType;
        private String targetId;
        private String targetType;
        private String type;
        private String uploadDir;
        private Integer version;
        private Integer visibleStatus;
        private Integer voteAnonymousStatus;
        private Long voteEndTime;
        private Integer voteMaxSelectNum;
        private Integer voteMinSelectNum;
        private List<String> voteOptionColors;
        private List<String> voteOptions;
        private String votePage;
        private Integer voteScore;
        private Integer voteShowAuthor;
        private String voteTag;
        private Integer voteType;

        Builder() {
        }

        Builder(FeedMultiPart feedMultiPart) {
            this.id = feedMultiPart.id();
            this.version = Integer.valueOf(feedMultiPart.version());
            this.message = feedMultiPart.message();
            this.type = feedMultiPart.type();
            this.isHtmlArticle = Boolean.valueOf(feedMultiPart.isHtmlArticle());
            this.imageUriList = feedMultiPart.imageUriList();
            this.pic = feedMultiPart.pic();
            this.visibleStatus = Integer.valueOf(feedMultiPart.visibleStatus());
            this.location = feedMultiPart.location();
            this.longLocation = feedMultiPart.longLocation();
            this.latitude = Double.valueOf(feedMultiPart.latitude());
            this.longitude = Double.valueOf(feedMultiPart.longitude());
            this.mediaUrl = feedMultiPart.mediaUrl();
            this.mediaType = Integer.valueOf(feedMultiPart.mediaType());
            this.mediaPic = feedMultiPart.mediaPic();
            this.messageTitle = feedMultiPart.messageTitle();
            this.messageBrief = feedMultiPart.messageBrief();
            this.extraTitle = feedMultiPart.extraTitle();
            this.extraUrl = feedMultiPart.extraUrl();
            this.extraKey = feedMultiPart.extraKey();
            this.extraPic = feedMultiPart.extraPic();
            this.extraInfo = feedMultiPart.extraInfo();
            this.messageCover = feedMultiPart.messageCover();
            this.dyhId = feedMultiPart.dyhId();
            this.isDisallowRepost = Boolean.valueOf(feedMultiPart.isDisallowRepost());
            this.isAnonymous = Boolean.valueOf(feedMultiPart.isAnonymous());
            this.isDisallowReply = Boolean.valueOf(feedMultiPart.isDisallowReply());
            this.isEditInDyh = Boolean.valueOf(feedMultiPart.isEditInDyh());
            this.forwardId = feedMultiPart.forwardId();
            this.isReplyWithForward = Boolean.valueOf(feedMultiPart.isReplyWithForward());
            this.feedId = feedMultiPart.feedId();
            this.targetType = feedMultiPart.targetType();
            this.targetId = feedMultiPart.targetId();
            this.voteScore = Integer.valueOf(feedMultiPart.voteScore());
            this.uploadDir = feedMultiPart.uploadDir();
            this.locationCity = feedMultiPart.locationCity();
            this.locationCountry = feedMultiPart.locationCountry();
            this.compressFlag = Integer.valueOf(feedMultiPart.compressFlag());
            this.mediaInfo = feedMultiPart.mediaInfo();
            this.ratingScore1 = Integer.valueOf(feedMultiPart.ratingScore1());
            this.insertProductMedia = Boolean.valueOf(feedMultiPart.insertProductMedia());
            this.secondHandType = Integer.valueOf(feedMultiPart.secondHandType());
            this.secondHandOutLink = feedMultiPart.secondHandOutLink();
            this.secondHandPrice = feedMultiPart.secondHandPrice();
            this.secondHandSthType = feedMultiPart.secondHandSthType();
            this.agree = Integer.valueOf(feedMultiPart.agree());
            this.productConfig = feedMultiPart.productConfig();
            this.productId = feedMultiPart.productId();
            this.province = feedMultiPart.province();
            this.cityCode = feedMultiPart.cityCode();
            this.voteType = Integer.valueOf(feedMultiPart.voteType());
            this.voteAnonymousStatus = Integer.valueOf(feedMultiPart.voteAnonymousStatus());
            this.voteEndTime = Long.valueOf(feedMultiPart.voteEndTime());
            this.voteMinSelectNum = Integer.valueOf(feedMultiPart.voteMinSelectNum());
            this.voteMaxSelectNum = Integer.valueOf(feedMultiPart.voteMaxSelectNum());
            this.voteOptions = feedMultiPart.voteOptions();
            this.voteTag = feedMultiPart.voteTag();
            this.votePage = feedMultiPart.votePage();
            this.voteOptionColors = feedMultiPart.voteOptionColors();
            this.voteShowAuthor = Integer.valueOf(feedMultiPart.voteShowAuthor());
            this.secondHandDealType = Integer.valueOf(feedMultiPart.secondHandDealType());
            this.secondHandFaceDeal = Integer.valueOf(feedMultiPart.secondHandFaceDeal());
            this.risePriceType = Integer.valueOf(feedMultiPart.risePriceType());
            this.commentGood = feedMultiPart.commentGood();
            this.commentGoodPic = feedMultiPart.commentGoodPic();
            this.commentBad = feedMultiPart.commentBad();
            this.commentBadPic = feedMultiPart.commentBadPic();
            this.commentGeneral = feedMultiPart.commentGeneral();
            this.commentGeneralPic = feedMultiPart.commentGeneralPic();
            this.buyStatus = Boolean.valueOf(feedMultiPart.buyStatus());
            this.categoryId = Integer.valueOf(feedMultiPart.categoryId());
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder id(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder version(int i) {
            this.version = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder message(String str) {
            this.message = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder type(String str) {
            this.type = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder isHtmlArticle(boolean z) {
            this.isHtmlArticle = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder imageUriList(List<ImageUrl> list) {
            this.imageUriList = list;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder pic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder visibleStatus(int i) {
            this.visibleStatus = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder location(String str) {
            this.location = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder longLocation(String str) {
            this.longLocation = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder latitude(double d) {
            this.latitude = Double.valueOf(d);
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder longitude(double d) {
            this.longitude = Double.valueOf(d);
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder mediaUrl(String str) {
            this.mediaUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder mediaType(int i) {
            this.mediaType = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder mediaPic(String str) {
            this.mediaPic = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder messageTitle(String str) {
            this.messageTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder messageBrief(String str) {
            this.messageBrief = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder extraTitle(String str) {
            this.extraTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder extraUrl(String str) {
            this.extraUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder extraKey(String str) {
            this.extraKey = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder extraPic(String str) {
            this.extraPic = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder extraInfo(String str) {
            this.extraInfo = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder messageCover(String str) {
            this.messageCover = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder dyhId(String str) {
            this.dyhId = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder isDisallowRepost(boolean z) {
            this.isDisallowRepost = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder isAnonymous(boolean z) {
            this.isAnonymous = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder isDisallowReply(boolean z) {
            this.isDisallowReply = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder isEditInDyh(boolean z) {
            this.isEditInDyh = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder forwardId(String str) {
            this.forwardId = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder isReplyWithForward(boolean z) {
            this.isReplyWithForward = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder feedId(String str) {
            this.feedId = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder targetType(String str) {
            this.targetType = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder targetId(String str) {
            this.targetId = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder voteScore(int i) {
            this.voteScore = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder uploadDir(String str) {
            this.uploadDir = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder locationCity(String str) {
            this.locationCity = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder locationCountry(String str) {
            this.locationCountry = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder compressFlag(int i) {
            this.compressFlag = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder mediaInfo(String str) {
            this.mediaInfo = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder ratingScore1(int i) {
            this.ratingScore1 = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder insertProductMedia(boolean z) {
            this.insertProductMedia = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder secondHandType(int i) {
            this.secondHandType = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder secondHandOutLink(String str) {
            this.secondHandOutLink = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder secondHandPrice(String str) {
            this.secondHandPrice = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder secondHandSthType(String str) {
            this.secondHandSthType = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder agree(int i) {
            this.agree = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder productConfig(String str) {
            this.productConfig = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder productId(String str) {
            this.productId = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder province(String str) {
            this.province = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder cityCode(String str) {
            this.cityCode = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder voteType(int i) {
            this.voteType = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder voteAnonymousStatus(int i) {
            this.voteAnonymousStatus = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder voteEndTime(long j) {
            this.voteEndTime = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder voteMinSelectNum(int i) {
            this.voteMinSelectNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder voteMaxSelectNum(int i) {
            this.voteMaxSelectNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder voteOptions(List<String> list) {
            this.voteOptions = list;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder voteTag(String str) {
            this.voteTag = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder votePage(String str) {
            this.votePage = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder voteOptionColors(List<String> list) {
            this.voteOptionColors = list;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder voteShowAuthor(int i) {
            this.voteShowAuthor = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder secondHandDealType(int i) {
            this.secondHandDealType = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder secondHandFaceDeal(int i) {
            this.secondHandFaceDeal = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder risePriceType(int i) {
            this.risePriceType = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder commentGood(String str) {
            this.commentGood = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder commentGoodPic(String str) {
            this.commentGoodPic = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder commentBad(String str) {
            this.commentBad = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder commentBadPic(String str) {
            this.commentBadPic = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder commentGeneral(String str) {
            this.commentGeneral = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder commentGeneralPic(String str) {
            this.commentGeneralPic = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder buyStatus(boolean z) {
            this.buyStatus = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart.Builder categoryId(int i) {
            this.categoryId = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedMultiPart.Builder
        public FeedMultiPart build() {
            String str = "";
            if (this.id == null) {
                str = str + " id";
            }
            if (this.version == null) {
                str = str + " version";
            }
            if (this.message == null) {
                str = str + " message";
            }
            if (this.type == null) {
                str = str + " type";
            }
            if (this.isHtmlArticle == null) {
                str = str + " isHtmlArticle";
            }
            if (this.imageUriList == null) {
                str = str + " imageUriList";
            }
            if (this.pic == null) {
                str = str + " pic";
            }
            if (this.visibleStatus == null) {
                str = str + " visibleStatus";
            }
            if (this.location == null) {
                str = str + " location";
            }
            if (this.longLocation == null) {
                str = str + " longLocation";
            }
            if (this.latitude == null) {
                str = str + " latitude";
            }
            if (this.longitude == null) {
                str = str + " longitude";
            }
            if (this.mediaUrl == null) {
                str = str + " mediaUrl";
            }
            if (this.mediaType == null) {
                str = str + " mediaType";
            }
            if (this.mediaPic == null) {
                str = str + " mediaPic";
            }
            if (this.messageTitle == null) {
                str = str + " messageTitle";
            }
            if (this.messageBrief == null) {
                str = str + " messageBrief";
            }
            if (this.extraTitle == null) {
                str = str + " extraTitle";
            }
            if (this.extraUrl == null) {
                str = str + " extraUrl";
            }
            if (this.extraKey == null) {
                str = str + " extraKey";
            }
            if (this.extraPic == null) {
                str = str + " extraPic";
            }
            if (this.extraInfo == null) {
                str = str + " extraInfo";
            }
            if (this.messageCover == null) {
                str = str + " messageCover";
            }
            if (this.dyhId == null) {
                str = str + " dyhId";
            }
            if (this.isDisallowRepost == null) {
                str = str + " isDisallowRepost";
            }
            if (this.isAnonymous == null) {
                str = str + " isAnonymous";
            }
            if (this.isDisallowReply == null) {
                str = str + " isDisallowReply";
            }
            if (this.isEditInDyh == null) {
                str = str + " isEditInDyh";
            }
            if (this.forwardId == null) {
                str = str + " forwardId";
            }
            if (this.isReplyWithForward == null) {
                str = str + " isReplyWithForward";
            }
            if (this.feedId == null) {
                str = str + " feedId";
            }
            if (this.targetType == null) {
                str = str + " targetType";
            }
            if (this.targetId == null) {
                str = str + " targetId";
            }
            if (this.voteScore == null) {
                str = str + " voteScore";
            }
            if (this.uploadDir == null) {
                str = str + " uploadDir";
            }
            if (this.locationCity == null) {
                str = str + " locationCity";
            }
            if (this.locationCountry == null) {
                str = str + " locationCountry";
            }
            if (this.compressFlag == null) {
                str = str + " compressFlag";
            }
            if (this.mediaInfo == null) {
                str = str + " mediaInfo";
            }
            if (this.ratingScore1 == null) {
                str = str + " ratingScore1";
            }
            if (this.insertProductMedia == null) {
                str = str + " insertProductMedia";
            }
            if (this.secondHandType == null) {
                str = str + " secondHandType";
            }
            if (this.secondHandOutLink == null) {
                str = str + " secondHandOutLink";
            }
            if (this.secondHandPrice == null) {
                str = str + " secondHandPrice";
            }
            if (this.secondHandSthType == null) {
                str = str + " secondHandSthType";
            }
            if (this.agree == null) {
                str = str + " agree";
            }
            if (this.productConfig == null) {
                str = str + " productConfig";
            }
            if (this.productId == null) {
                str = str + " productId";
            }
            if (this.province == null) {
                str = str + " province";
            }
            if (this.cityCode == null) {
                str = str + " cityCode";
            }
            if (this.voteType == null) {
                str = str + " voteType";
            }
            if (this.voteAnonymousStatus == null) {
                str = str + " voteAnonymousStatus";
            }
            if (this.voteEndTime == null) {
                str = str + " voteEndTime";
            }
            if (this.voteMinSelectNum == null) {
                str = str + " voteMinSelectNum";
            }
            if (this.voteMaxSelectNum == null) {
                str = str + " voteMaxSelectNum";
            }
            if (this.voteOptions == null) {
                str = str + " voteOptions";
            }
            if (this.voteTag == null) {
                str = str + " voteTag";
            }
            if (this.votePage == null) {
                str = str + " votePage";
            }
            if (this.voteOptionColors == null) {
                str = str + " voteOptionColors";
            }
            if (this.voteShowAuthor == null) {
                str = str + " voteShowAuthor";
            }
            if (this.secondHandDealType == null) {
                str = str + " secondHandDealType";
            }
            if (this.secondHandFaceDeal == null) {
                str = str + " secondHandFaceDeal";
            }
            if (this.risePriceType == null) {
                str = str + " risePriceType";
            }
            if (this.commentGood == null) {
                str = str + " commentGood";
            }
            if (this.commentGoodPic == null) {
                str = str + " commentGoodPic";
            }
            if (this.commentBad == null) {
                str = str + " commentBad";
            }
            if (this.commentBadPic == null) {
                str = str + " commentBadPic";
            }
            if (this.commentGeneral == null) {
                str = str + " commentGeneral";
            }
            if (this.commentGeneralPic == null) {
                str = str + " commentGeneralPic";
            }
            if (this.buyStatus == null) {
                str = str + " buyStatus";
            }
            if (this.categoryId == null) {
                str = str + " categoryId";
            }
            if (str.isEmpty()) {
                return new AutoValue_FeedMultiPart(this.id, this.version.intValue(), this.message, this.type, this.isHtmlArticle.booleanValue(), this.imageUriList, this.pic, this.visibleStatus.intValue(), this.location, this.longLocation, this.latitude.doubleValue(), this.longitude.doubleValue(), this.mediaUrl, this.mediaType.intValue(), this.mediaPic, this.messageTitle, this.messageBrief, this.extraTitle, this.extraUrl, this.extraKey, this.extraPic, this.extraInfo, this.messageCover, this.dyhId, this.isDisallowRepost.booleanValue(), this.isAnonymous.booleanValue(), this.isDisallowReply.booleanValue(), this.isEditInDyh.booleanValue(), this.forwardId, this.isReplyWithForward.booleanValue(), this.feedId, this.targetType, this.targetId, this.voteScore.intValue(), this.uploadDir, this.locationCity, this.locationCountry, this.compressFlag.intValue(), this.mediaInfo, this.ratingScore1.intValue(), this.insertProductMedia.booleanValue(), this.secondHandType.intValue(), this.secondHandOutLink, this.secondHandPrice, this.secondHandSthType, this.agree.intValue(), this.productConfig, this.productId, this.province, this.cityCode, this.voteType.intValue(), this.voteAnonymousStatus.intValue(), this.voteEndTime.longValue(), this.voteMinSelectNum.intValue(), this.voteMaxSelectNum.intValue(), this.voteOptions, this.voteTag, this.votePage, this.voteOptionColors, this.voteShowAuthor.intValue(), this.secondHandDealType.intValue(), this.secondHandFaceDeal.intValue(), this.risePriceType.intValue(), this.commentGood, this.commentGoodPic, this.commentBad, this.commentBadPic, this.commentGeneral, this.commentGeneralPic, this.buyStatus.booleanValue(), this.categoryId.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
