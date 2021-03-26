package com.coolapk.market.view.feedv8;

import android.content.Context;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.StringExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedGoodsAction;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedTarget;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.model.ProductParams;
import com.coolapk.market.model.SecondHandInfo;
import com.coolapk.market.model.Topic;
import com.coolapk.market.model.Vote;
import com.coolapk.market.model.VoteOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"convertToFeedMultiPart", "Lcom/coolapk/market/model/FeedMultiPart;", "Lcom/coolapk/market/model/Feed;", "convertToFeedUIConfig", "Lcom/coolapk/market/model/FeedUIConfig;", "context", "Landroid/content/Context;", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: FeedConvertUtils.kt */
public final class FeedConvertUtilsKt {
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01b0, code lost:
        if (r3.equals(r5) != false) goto L_0x01bd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x028b  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0298  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x029d  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x02a8  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x02ad  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02ba  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0311  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0316  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0321  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x036b  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0377  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0383  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x038f  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x039b  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x03a6  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x03b2  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x03bd  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x021b  */
    public static final FeedMultiPart convertToFeedMultiPart(Feed feed) {
        String str;
        String str2;
        String str3;
        ArrayList arrayList;
        String longLocation;
        String feedType;
        long j;
        Vote vote;
        ArrayList arrayList2;
        Vote vote2;
        ArrayList arrayList3;
        String commentGood;
        String commentGoodPic;
        String commentBad;
        String commentBadPic;
        String commentGeneral;
        String commentGeneralPic;
        FeedGoodsAction goodsAction;
        List<VoteOption> voteOptions;
        List<VoteOption> voteOptions2;
        Integer intOrNull;
        boolean z;
        String str4;
        Topic linkTagEntity;
        Intrinsics.checkNotNullParameter(feed, "$this$convertToFeedMultiPart");
        boolean z2 = true;
        String str5 = "";
        if (feed.getIsHtmlArticle() == 1) {
            str = feed.getMessageRawInput();
            if (str == null) {
                str = str5;
            }
        } else {
            str = feed.getMessage();
        }
        if (Intrinsics.areEqual(feed.getFeedType(), "vote")) {
            Vote vote3 = feed.getVote();
            if (vote3 == null || (linkTagEntity = vote3.getLinkTagEntity()) == null || (str4 = linkTagEntity.getTitle()) == null) {
                str4 = str5;
            }
            str2 = str4;
            str3 = str5;
        } else {
            if (Intrinsics.areEqual(feed.getFeedType(), "voteComment")) {
            }
            str3 = str5;
            str2 = str5;
        }
        int i = 0;
        FeedMultiPart.Builder isHtmlArticle = FeedMultiPart.builder().id(feed.getId()).type(feed.getFeedType()).message(str).isHtmlArticle(feed.getIsHtmlArticle() == 1);
        List<String> picArray = feed.getPicArray();
        if (picArray != null) {
            if (!picArray.isEmpty()) {
                Object first = CollectionsKt.first((List<? extends Object>) picArray);
                Intrinsics.checkNotNullExpressionValue(first, "it.first()");
                if (((CharSequence) first).length() > 0) {
                    z = true;
                    if (!z) {
                        picArray = null;
                    }
                    if (picArray != null) {
                        ArrayList arrayList4 = new ArrayList();
                        for (T t : picArray) {
                            arrayList4.add(ImageUrl.create(t, t));
                        }
                        arrayList = arrayList4;
                        FeedMultiPart.Builder location = isHtmlArticle.imageUriList(arrayList).pic(feed.getPic()).visibleStatus(feed.getStatus()).location(feed.getLocation());
                        longLocation = feed.getLongLocation();
                        if (longLocation == null) {
                            longLocation = str5;
                        }
                        FeedMultiPart.Builder mediaUrl = location.longLocation(longLocation).mediaUrl(feed.getMediaUrl());
                        String mediaType = feed.getMediaType();
                        FeedMultiPart.Builder targetId = mediaUrl.mediaType((mediaType != null || (intOrNull = StringsKt.toIntOrNull(mediaType)) == null) ? 0 : intOrNull.intValue()).messageTitle(feed.getMessageTitle()).extraTitle(feed.getExtraTitle()).extraUrl(feed.getExtraUrl()).extraKey(feed.getExtraKey()).extraPic(feed.getExtraPic()).extraInfo(feed.getExtraInfo()).messageCover(feed.getMessageCover()).dyhId(feed.getDyhId()).isAnonymous(feed.getIsAnonymous() != 1).forwardId(feed.getForwardId()).feedId(str3).targetType(EntityExtendsKt.getTargetTypeString(feed)).targetId(EntityExtendsKt.getBoundID(feed));
                        feedType = feed.getFeedType();
                        String str6 = "discovery";
                        if (feedType != null) {
                            int hashCode = feedType.hashCode();
                            if (hashCode != -577741570) {
                                if (hashCode == -121207376) {
                                }
                            } else if (feedType.equals("picture")) {
                                str6 = "picture";
                                FeedMultiPart.Builder mediaInfo = targetId.uploadDir(str6).mediaInfo(feed.getMediaInfo());
                                SecondHandInfo secondHandInfo = feed.getSecondHandInfo();
                                if (secondHandInfo == null || (r3 = secondHandInfo.getUrl()) == null) {
                                    String str7 = str5;
                                }
                                FeedMultiPart.Builder secondHandOutLink = mediaInfo.secondHandOutLink(str7);
                                SecondHandInfo secondHandInfo2 = feed.getSecondHandInfo();
                                if (secondHandInfo2 == null || (r3 = secondHandInfo2.getPrice()) == null) {
                                    String str8 = str5;
                                }
                                FeedMultiPart.Builder secondHandPrice = secondHandOutLink.secondHandPrice(str8);
                                SecondHandInfo secondHandInfo3 = feed.getSecondHandInfo();
                                if (secondHandInfo3 == null || (r3 = secondHandInfo3.getErshouTypeID()) == null) {
                                    String str9 = "100";
                                }
                                FeedMultiPart.Builder secondHandSthType = secondHandPrice.secondHandSthType(str9);
                                SecondHandInfo secondHandInfo4 = feed.getSecondHandInfo();
                                FeedMultiPart.Builder secondHandDealType = secondHandSthType.secondHandDealType(secondHandInfo4 != null ? secondHandInfo4.getSecondHandDealType() : 0);
                                SecondHandInfo secondHandInfo5 = feed.getSecondHandInfo();
                                FeedMultiPart.Builder secondHandFaceDeal = secondHandDealType.secondHandFaceDeal(secondHandInfo5 != null ? secondHandInfo5.getSecondHandFaceDeal() : 0);
                                SecondHandInfo secondHandInfo6 = feed.getSecondHandInfo();
                                if (secondHandInfo6 == null || (r3 = secondHandInfo6.getProductConfigSource()) == null) {
                                    String str10 = str5;
                                }
                                FeedMultiPart.Builder productConfig = secondHandFaceDeal.productConfig(str10);
                                SecondHandInfo secondHandInfo7 = feed.getSecondHandInfo();
                                if (secondHandInfo7 == null || (r3 = secondHandInfo7.getProductId()) == null) {
                                    String str11 = str5;
                                }
                                FeedMultiPart.Builder productId = productConfig.productId(str11);
                                Vote vote4 = feed.getVote();
                                FeedMultiPart.Builder voteType = productId.voteType(vote4 != null ? vote4.getType() : 0);
                                Vote vote5 = feed.getVote();
                                FeedMultiPart.Builder voteAnonymousStatus = voteType.voteAnonymousStatus(vote5 != null ? vote5.getAnonymousStatus() : 0);
                                if (feed.getVote() != null) {
                                    Vote vote6 = feed.getVote();
                                    Intrinsics.checkNotNull(vote6);
                                    Intrinsics.checkNotNullExpressionValue(vote6, "this.vote!!");
                                    long endTime = vote6.getEndTime();
                                    Vote vote7 = feed.getVote();
                                    Intrinsics.checkNotNull(vote7);
                                    Intrinsics.checkNotNullExpressionValue(vote7, "this.vote!!");
                                    j = endTime - ((long) vote7.getStartTime());
                                } else {
                                    j = 86400;
                                }
                                FeedMultiPart.Builder voteEndTime = voteAnonymousStatus.voteEndTime(j);
                                Vote vote8 = feed.getVote();
                                FeedMultiPart.Builder voteMinSelectNum = voteEndTime.voteMinSelectNum(vote8 != null ? vote8.getMinSelectNum() : 1);
                                Vote vote9 = feed.getVote();
                                FeedMultiPart.Builder voteMaxSelectNum = voteMinSelectNum.voteMaxSelectNum(vote9 != null ? vote9.getMaxSelectNum() : 1);
                                vote = feed.getVote();
                                if (vote != null || (voteOptions2 = vote.getVoteOptions()) == null) {
                                    arrayList2 = new ArrayList();
                                } else {
                                    ArrayList arrayList5 = new ArrayList();
                                    for (T t2 : voteOptions2) {
                                        Intrinsics.checkNotNullExpressionValue(t2, "it");
                                        arrayList5.add(t2.getTitle());
                                    }
                                    arrayList2 = arrayList5;
                                }
                                FeedMultiPart.Builder voteTag = voteMaxSelectNum.voteOptions(arrayList2).voteTag(str2);
                                Vote vote10 = feed.getVote();
                                if (vote10 == null || (r3 = vote10.getLinkPage()) == null) {
                                    String str12 = str5;
                                }
                                FeedMultiPart.Builder votePage = voteTag.votePage(str12);
                                Vote vote11 = feed.getVote();
                                FeedMultiPart.Builder voteShowAuthor = votePage.voteShowAuthor(vote11 != null ? vote11.getShowAuthor() : 1);
                                vote2 = feed.getVote();
                                if (vote2 != null || (voteOptions = vote2.getVoteOptions()) == null) {
                                    arrayList3 = new ArrayList();
                                } else {
                                    ArrayList arrayList6 = new ArrayList();
                                    for (T t3 : voteOptions) {
                                        Intrinsics.checkNotNullExpressionValue(t3, "it");
                                        arrayList6.add(t3.getColor());
                                    }
                                    arrayList3 = arrayList6;
                                }
                                FeedMultiPart.Builder ratingScore1 = voteShowAuthor.voteOptionColors(arrayList3).ratingScore1(feed.getStar());
                                commentGood = feed.getCommentGood();
                                if (commentGood == null) {
                                    commentGood = str5;
                                }
                                FeedMultiPart.Builder commentGood2 = ratingScore1.commentGood(commentGood);
                                commentGoodPic = feed.getCommentGoodPic();
                                if (commentGoodPic == null) {
                                    commentGoodPic = str5;
                                }
                                FeedMultiPart.Builder commentGoodPic2 = commentGood2.commentGoodPic(commentGoodPic);
                                commentBad = feed.getCommentBad();
                                if (commentBad == null) {
                                    commentBad = str5;
                                }
                                FeedMultiPart.Builder commentBad2 = commentGoodPic2.commentBad(commentBad);
                                commentBadPic = feed.getCommentBadPic();
                                if (commentBadPic == null) {
                                    commentBadPic = str5;
                                }
                                FeedMultiPart.Builder commentBadPic2 = commentBad2.commentBadPic(commentBadPic);
                                commentGeneral = feed.getCommentGeneral();
                                if (commentGeneral == null) {
                                    commentGeneral = str5;
                                }
                                FeedMultiPart.Builder commentGeneral2 = commentBadPic2.commentGeneral(commentGeneral);
                                commentGeneralPic = feed.getCommentGeneralPic();
                                if (commentGeneralPic != null) {
                                    str5 = commentGeneralPic;
                                }
                                FeedMultiPart.Builder commentGeneralPic2 = commentGeneral2.commentGeneralPic(str5);
                                if (feed.getBuyStatus() != 1) {
                                    z2 = false;
                                }
                                FeedMultiPart.Builder buyStatus = commentGeneralPic2.buyStatus(z2);
                                goodsAction = feed.getGoodsAction();
                                if (goodsAction != null) {
                                    i = goodsAction.getCategoryId();
                                }
                                FeedMultiPart build = buyStatus.categoryId(i).build();
                                Intrinsics.checkNotNullExpressionValue(build, "FeedMultiPart.builder()\n…: 0)\n            .build()");
                                return build;
                            }
                        }
                        str6 = "feed";
                        FeedMultiPart.Builder mediaInfo = targetId.uploadDir(str6).mediaInfo(feed.getMediaInfo());
                        SecondHandInfo secondHandInfo = feed.getSecondHandInfo();
                        String str7 = str5;
                        FeedMultiPart.Builder secondHandOutLink = mediaInfo.secondHandOutLink(str7);
                        SecondHandInfo secondHandInfo2 = feed.getSecondHandInfo();
                        String str8 = str5;
                        FeedMultiPart.Builder secondHandPrice = secondHandOutLink.secondHandPrice(str8);
                        SecondHandInfo secondHandInfo3 = feed.getSecondHandInfo();
                        String str9 = "100";
                        FeedMultiPart.Builder secondHandSthType = secondHandPrice.secondHandSthType(str9);
                        SecondHandInfo secondHandInfo4 = feed.getSecondHandInfo();
                        FeedMultiPart.Builder secondHandDealType = secondHandSthType.secondHandDealType(secondHandInfo4 != null ? secondHandInfo4.getSecondHandDealType() : 0);
                        SecondHandInfo secondHandInfo5 = feed.getSecondHandInfo();
                        FeedMultiPart.Builder secondHandFaceDeal = secondHandDealType.secondHandFaceDeal(secondHandInfo5 != null ? secondHandInfo5.getSecondHandFaceDeal() : 0);
                        SecondHandInfo secondHandInfo6 = feed.getSecondHandInfo();
                        String str10 = str5;
                        FeedMultiPart.Builder productConfig = secondHandFaceDeal.productConfig(str10);
                        SecondHandInfo secondHandInfo7 = feed.getSecondHandInfo();
                        String str11 = str5;
                        FeedMultiPart.Builder productId = productConfig.productId(str11);
                        Vote vote4 = feed.getVote();
                        FeedMultiPart.Builder voteType = productId.voteType(vote4 != null ? vote4.getType() : 0);
                        Vote vote5 = feed.getVote();
                        FeedMultiPart.Builder voteAnonymousStatus = voteType.voteAnonymousStatus(vote5 != null ? vote5.getAnonymousStatus() : 0);
                        if (feed.getVote() != null) {
                        }
                        FeedMultiPart.Builder voteEndTime = voteAnonymousStatus.voteEndTime(j);
                        Vote vote8 = feed.getVote();
                        FeedMultiPart.Builder voteMinSelectNum = voteEndTime.voteMinSelectNum(vote8 != null ? vote8.getMinSelectNum() : 1);
                        Vote vote9 = feed.getVote();
                        FeedMultiPart.Builder voteMaxSelectNum = voteMinSelectNum.voteMaxSelectNum(vote9 != null ? vote9.getMaxSelectNum() : 1);
                        vote = feed.getVote();
                        if (vote != null) {
                        }
                        arrayList2 = new ArrayList();
                        FeedMultiPart.Builder voteTag = voteMaxSelectNum.voteOptions(arrayList2).voteTag(str2);
                        Vote vote10 = feed.getVote();
                        String str12 = str5;
                        FeedMultiPart.Builder votePage = voteTag.votePage(str12);
                        Vote vote11 = feed.getVote();
                        FeedMultiPart.Builder voteShowAuthor = votePage.voteShowAuthor(vote11 != null ? vote11.getShowAuthor() : 1);
                        vote2 = feed.getVote();
                        if (vote2 != null) {
                        }
                        arrayList3 = new ArrayList();
                        FeedMultiPart.Builder ratingScore1 = voteShowAuthor.voteOptionColors(arrayList3).ratingScore1(feed.getStar());
                        commentGood = feed.getCommentGood();
                        if (commentGood == null) {
                        }
                        FeedMultiPart.Builder commentGood2 = ratingScore1.commentGood(commentGood);
                        commentGoodPic = feed.getCommentGoodPic();
                        if (commentGoodPic == null) {
                        }
                        FeedMultiPart.Builder commentGoodPic2 = commentGood2.commentGoodPic(commentGoodPic);
                        commentBad = feed.getCommentBad();
                        if (commentBad == null) {
                        }
                        FeedMultiPart.Builder commentBad2 = commentGoodPic2.commentBad(commentBad);
                        commentBadPic = feed.getCommentBadPic();
                        if (commentBadPic == null) {
                        }
                        FeedMultiPart.Builder commentBadPic2 = commentBad2.commentBadPic(commentBadPic);
                        commentGeneral = feed.getCommentGeneral();
                        if (commentGeneral == null) {
                        }
                        FeedMultiPart.Builder commentGeneral2 = commentBadPic2.commentGeneral(commentGeneral);
                        commentGeneralPic = feed.getCommentGeneralPic();
                        if (commentGeneralPic != null) {
                        }
                        FeedMultiPart.Builder commentGeneralPic2 = commentGeneral2.commentGeneralPic(str5);
                        if (feed.getBuyStatus() != 1) {
                        }
                        FeedMultiPart.Builder buyStatus = commentGeneralPic2.buyStatus(z2);
                        goodsAction = feed.getGoodsAction();
                        if (goodsAction != null) {
                        }
                        FeedMultiPart build = buyStatus.categoryId(i).build();
                        Intrinsics.checkNotNullExpressionValue(build, "FeedMultiPart.builder()\n…: 0)\n            .build()");
                        return build;
                    }
                }
            }
            z = false;
            if (!z) {
            }
            if (picArray != null) {
            }
        }
        arrayList = new ArrayList();
        FeedMultiPart.Builder location = isHtmlArticle.imageUriList(arrayList).pic(feed.getPic()).visibleStatus(feed.getStatus()).location(feed.getLocation());
        longLocation = feed.getLongLocation();
        if (longLocation == null) {
        }
        FeedMultiPart.Builder mediaUrl = location.longLocation(longLocation).mediaUrl(feed.getMediaUrl());
        String mediaType = feed.getMediaType();
        FeedMultiPart.Builder targetId = mediaUrl.mediaType((mediaType != null || (intOrNull = StringsKt.toIntOrNull(mediaType)) == null) ? 0 : intOrNull.intValue()).messageTitle(feed.getMessageTitle()).extraTitle(feed.getExtraTitle()).extraUrl(feed.getExtraUrl()).extraKey(feed.getExtraKey()).extraPic(feed.getExtraPic()).extraInfo(feed.getExtraInfo()).messageCover(feed.getMessageCover()).dyhId(feed.getDyhId()).isAnonymous(feed.getIsAnonymous() != 1).forwardId(feed.getForwardId()).feedId(str3).targetType(EntityExtendsKt.getTargetTypeString(feed)).targetId(EntityExtendsKt.getBoundID(feed));
        feedType = feed.getFeedType();
        String str6 = "discovery";
        if (feedType != null) {
        }
        str6 = "feed";
        FeedMultiPart.Builder mediaInfo = targetId.uploadDir(str6).mediaInfo(feed.getMediaInfo());
        SecondHandInfo secondHandInfo = feed.getSecondHandInfo();
        String str7 = str5;
        FeedMultiPart.Builder secondHandOutLink = mediaInfo.secondHandOutLink(str7);
        SecondHandInfo secondHandInfo2 = feed.getSecondHandInfo();
        String str8 = str5;
        FeedMultiPart.Builder secondHandPrice = secondHandOutLink.secondHandPrice(str8);
        SecondHandInfo secondHandInfo3 = feed.getSecondHandInfo();
        String str9 = "100";
        FeedMultiPart.Builder secondHandSthType = secondHandPrice.secondHandSthType(str9);
        SecondHandInfo secondHandInfo4 = feed.getSecondHandInfo();
        FeedMultiPart.Builder secondHandDealType = secondHandSthType.secondHandDealType(secondHandInfo4 != null ? secondHandInfo4.getSecondHandDealType() : 0);
        SecondHandInfo secondHandInfo5 = feed.getSecondHandInfo();
        FeedMultiPart.Builder secondHandFaceDeal = secondHandDealType.secondHandFaceDeal(secondHandInfo5 != null ? secondHandInfo5.getSecondHandFaceDeal() : 0);
        SecondHandInfo secondHandInfo6 = feed.getSecondHandInfo();
        String str10 = str5;
        FeedMultiPart.Builder productConfig = secondHandFaceDeal.productConfig(str10);
        SecondHandInfo secondHandInfo7 = feed.getSecondHandInfo();
        String str11 = str5;
        FeedMultiPart.Builder productId = productConfig.productId(str11);
        Vote vote4 = feed.getVote();
        FeedMultiPart.Builder voteType = productId.voteType(vote4 != null ? vote4.getType() : 0);
        Vote vote5 = feed.getVote();
        FeedMultiPart.Builder voteAnonymousStatus = voteType.voteAnonymousStatus(vote5 != null ? vote5.getAnonymousStatus() : 0);
        if (feed.getVote() != null) {
        }
        FeedMultiPart.Builder voteEndTime = voteAnonymousStatus.voteEndTime(j);
        Vote vote8 = feed.getVote();
        FeedMultiPart.Builder voteMinSelectNum = voteEndTime.voteMinSelectNum(vote8 != null ? vote8.getMinSelectNum() : 1);
        Vote vote9 = feed.getVote();
        FeedMultiPart.Builder voteMaxSelectNum = voteMinSelectNum.voteMaxSelectNum(vote9 != null ? vote9.getMaxSelectNum() : 1);
        vote = feed.getVote();
        if (vote != null) {
        }
        arrayList2 = new ArrayList();
        FeedMultiPart.Builder voteTag = voteMaxSelectNum.voteOptions(arrayList2).voteTag(str2);
        Vote vote10 = feed.getVote();
        String str12 = str5;
        FeedMultiPart.Builder votePage = voteTag.votePage(str12);
        Vote vote11 = feed.getVote();
        FeedMultiPart.Builder voteShowAuthor = votePage.voteShowAuthor(vote11 != null ? vote11.getShowAuthor() : 1);
        vote2 = feed.getVote();
        if (vote2 != null) {
        }
        arrayList3 = new ArrayList();
        FeedMultiPart.Builder ratingScore1 = voteShowAuthor.voteOptionColors(arrayList3).ratingScore1(feed.getStar());
        commentGood = feed.getCommentGood();
        if (commentGood == null) {
        }
        FeedMultiPart.Builder commentGood2 = ratingScore1.commentGood(commentGood);
        commentGoodPic = feed.getCommentGoodPic();
        if (commentGoodPic == null) {
        }
        FeedMultiPart.Builder commentGoodPic2 = commentGood2.commentGoodPic(commentGoodPic);
        commentBad = feed.getCommentBad();
        if (commentBad == null) {
        }
        FeedMultiPart.Builder commentBad2 = commentGoodPic2.commentBad(commentBad);
        commentBadPic = feed.getCommentBadPic();
        if (commentBadPic == null) {
        }
        FeedMultiPart.Builder commentBadPic2 = commentBad2.commentBadPic(commentBadPic);
        commentGeneral = feed.getCommentGeneral();
        if (commentGeneral == null) {
        }
        FeedMultiPart.Builder commentGeneral2 = commentBadPic2.commentGeneral(commentGeneral);
        commentGeneralPic = feed.getCommentGeneralPic();
        if (commentGeneralPic != null) {
        }
        FeedMultiPart.Builder commentGeneralPic2 = commentGeneral2.commentGeneralPic(str5);
        if (feed.getBuyStatus() != 1) {
        }
        FeedMultiPart.Builder buyStatus = commentGeneralPic2.buyStatus(z2);
        goodsAction = feed.getGoodsAction();
        if (goodsAction != null) {
        }
        FeedMultiPart build = buyStatus.categoryId(i).build();
        Intrinsics.checkNotNullExpressionValue(build, "FeedMultiPart.builder()\n…: 0)\n            .build()");
        return build;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009c, code lost:
        if (r1 != null) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0180, code lost:
        if (r1.equals("goodsList") != false) goto L_0x039d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x019a, code lost:
        if (r1.equals("goods") != false) goto L_0x039d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (r1.equals("album") != false) goto L_0x039d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0143  */
    public static final FeedUIConfig convertToFeedUIConfig(Feed feed, Context context) {
        String str;
        String str2;
        String str3;
        String str4;
        boolean z;
        List<Entity> extraEntities;
        String feedType;
        String str5;
        String str6;
        String str7;
        String str8;
        String logo;
        String productConfigSource;
        String configJson;
        Topic linkTagEntity;
        Topic linkTagEntity2;
        List split$default;
        String str9;
        Intrinsics.checkNotNullParameter(feed, "$this$convertToFeedUIConfig");
        Intrinsics.checkNotNullParameter(context, "context");
        FeedTarget targetRow = feed.getTargetRow();
        FeedUIConfig.Builder builder = FeedUIConfig.builder();
        String str10 = "";
        if (targetRow == null || (str = targetRow.getTitle()) == null) {
            str = str10;
        }
        FeedUIConfig.Builder dyhTitle = builder.dyhTitle(str);
        if (targetRow == null || (str2 = targetRow.getTitle()) == null) {
            str2 = str10;
        }
        FeedUIConfig.Builder relativeTitle = dyhTitle.relativeTitle(str2);
        if (targetRow == null || (str3 = targetRow.getLogo()) == null) {
            str3 = str10;
        }
        FeedUIConfig.Builder locationName = relativeTitle.relativeLogo(str3).visibleState(feed.getStatus()).locationName(feed.getLocation());
        String tags = feed.getTags();
        List<ProductParams> list = null;
        String str11 = null;
        r3 = null;
        String str12 = null;
        list = null;
        int i = 0;
        if (tags != null) {
            Intrinsics.checkNotNullExpressionValue(tags, "it");
            if (!(tags.length() > 0)) {
                tags = null;
            }
            if (!(tags == null || (split$default = StringsKt.split$default((CharSequence) tags, new String[]{","}, false, 0, 6, (Object) null)) == null || (str9 = (String) CollectionsKt.firstOrNull((List<? extends Object>) split$default)) == null)) {
                Objects.requireNonNull(str9, "null cannot be cast to non-null type java.lang.String");
                str4 = str9.substring(1, str9.length() - 1);
                Intrinsics.checkNotNullExpressionValue(str4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
        }
        str4 = str10;
        FeedUIConfig.Builder extraViewContent = locationName.topicTitle(str4).extraViewTitle(feed.getExtraTitle()).extraViewLogoUrl(feed.getExtraPic()).isFeedTargetPhoneOrTablet(feed.getShowOwner() == 1).extraViewContent(feed.getExtraInfo());
        String extraTitle = feed.getExtraTitle();
        FeedUIConfig.Builder isExtraViewVisible = extraViewContent.isExtraViewVisible(!(extraTitle == null || extraTitle.length() == 0));
        String mediaInfo = feed.getMediaInfo();
        if (mediaInfo == null || mediaInfo.length() == 0) {
            String extraTitle2 = feed.getExtraTitle();
            if (extraTitle2 == null || extraTitle2.length() == 0) {
                z = false;
                FeedUIConfig.Builder isRemoveExtraViewVisible = isExtraViewVisible.isRemoveExtraViewVisible(z);
                extraEntities = feed.getExtraEntities();
                Intrinsics.checkNotNullExpressionValue(extraEntities, "this.extraEntities");
                if (!extraEntities.isEmpty()) {
                    isRemoveExtraViewVisible.extraEntities(feed.getExtraEntities()).extraViewContent(str10).extraViewTitle(str10).extraViewLogoUrl(str10).isRemoveExtraViewVisible(false);
                }
                feedType = feed.getFeedType();
                if (feedType != null) {
                    switch (feedType.hashCode()) {
                        case -1412808770:
                            if (feedType.equals("answer")) {
                                Intrinsics.checkNotNullExpressionValue(isRemoveExtraViewVisible, "builder");
                                FeedArgsFactoryKt.applyAnswerFeed(isRemoveExtraViewVisible, context, feed);
                                break;
                            }
                            break;
                        case -1294612184:
                            if (feedType.equals("ershou")) {
                                Intrinsics.checkNotNullExpressionValue(isRemoveExtraViewVisible, "builder");
                                FeedUIConfig.Builder applySecondHand = FeedArgsFactoryKt.applySecondHand(isRemoveExtraViewVisible, context);
                                SecondHandInfo secondHandInfo = feed.getSecondHandInfo();
                                FeedUIConfig.Builder secondHandDealType = applySecondHand.secondHandDealType(secondHandInfo != null ? secondHandInfo.getSecondHandDealType() : 0);
                                SecondHandInfo secondHandInfo2 = feed.getSecondHandInfo();
                                FeedUIConfig.Builder secondHandFaceDeal = secondHandDealType.secondHandFaceDeal(secondHandInfo2 != null ? secondHandInfo2.getSecondHandFaceDeal() : 0);
                                SecondHandInfo secondHandInfo3 = feed.getSecondHandInfo();
                                if (secondHandInfo3 == null || (str5 = secondHandInfo3.getPrice()) == null) {
                                    str5 = str10;
                                }
                                FeedUIConfig.Builder secondHandPrice = secondHandFaceDeal.secondHandPrice(str5);
                                SecondHandInfo secondHandInfo4 = feed.getSecondHandInfo();
                                if (secondHandInfo4 == null || (str6 = secondHandInfo4.getUrl()) == null) {
                                    str6 = str10;
                                }
                                FeedUIConfig.Builder secondHandOutLink = secondHandPrice.secondHandOutLink(str6);
                                SecondHandInfo secondHandInfo5 = feed.getSecondHandInfo();
                                if (secondHandInfo5 != null) {
                                    i = secondHandInfo5.getStoreType();
                                }
                                FeedUIConfig.Builder secondHandType = secondHandOutLink.secondHandType(i);
                                SecondHandInfo secondHandInfo6 = feed.getSecondHandInfo();
                                if (secondHandInfo6 == null || (configJson = secondHandInfo6.getConfigJson()) == null || (str7 = StringExtendsKt.parseSecondHandShowParams(configJson)) == null) {
                                    str7 = str10;
                                }
                                FeedUIConfig.Builder productConfigShowText = secondHandType.productConfigShowText(str7);
                                SecondHandInfo secondHandInfo7 = feed.getSecondHandInfo();
                                if (!(secondHandInfo7 == null || (productConfigSource = secondHandInfo7.getProductConfigSource()) == null)) {
                                    list = StringExtendsKt.parseSecondHandParams(productConfigSource);
                                }
                                FeedUIConfig.Builder productConfigCacheList = productConfigShowText.productConfigCacheList(list);
                                SecondHandInfo secondHandInfo8 = feed.getSecondHandInfo();
                                if (secondHandInfo8 == null || (str8 = secondHandInfo8.getTitle()) == null) {
                                    str8 = str10;
                                }
                                FeedUIConfig.Builder relativeTitle2 = productConfigCacheList.relativeTitle(str8);
                                SecondHandInfo secondHandInfo9 = feed.getSecondHandInfo();
                                if (!(secondHandInfo9 == null || (logo = secondHandInfo9.getLogo()) == null)) {
                                    str10 = logo;
                                }
                                relativeTitle2.relativeLogo(str10);
                                break;
                            }
                            break;
                        case -1165870106:
                            if (feedType.equals("question")) {
                                Intrinsics.checkNotNullExpressionValue(isRemoveExtraViewVisible, "builder");
                                FeedArgsFactoryKt.applyQuestion(isRemoveExtraViewVisible).title("提问").submitText(context.getString(2131886430)).editTitleHint("请填下你的问题并以问号结尾").editTextHint("描述你的问题...").isLocationViewVisible(false).isEditTitleViewVisible(true).isAddExtraItemVisible(false);
                                break;
                            }
                            break;
                        case -938102371:
                            if (feedType.equals("rating")) {
                                if (feed.getIsHtmlArticle() != 1) {
                                    Intrinsics.checkNotNullExpressionValue(isRemoveExtraViewVisible, "builder");
                                    FeedArgsFactoryKt.applyToRating(FeedArgsFactoryKt.applyFeed(isRemoveExtraViewVisible, context), EntityExtendsKt.getTargetTypeString(feed));
                                    break;
                                } else {
                                    Intrinsics.checkNotNullExpressionValue(isRemoveExtraViewVisible, "builder");
                                    FeedArgsFactoryKt.applyHtml(FeedArgsFactoryKt.applyFeed(isRemoveExtraViewVisible, context));
                                    break;
                                }
                            }
                            break;
                        case -577741570:
                            if (feedType.equals("picture")) {
                                Intrinsics.checkNotNullExpressionValue(isRemoveExtraViewVisible, "builder");
                                FeedArgsFactoryKt.applyCoolPic(isRemoveExtraViewVisible, context);
                                break;
                            }
                            break;
                        case -121207376:
                            if (feedType.equals("discovery")) {
                                Intrinsics.checkNotNullExpressionValue(isRemoveExtraViewVisible, "builder");
                                String extraTitle3 = feed.getExtraTitle();
                                if (extraTitle3 == null) {
                                    extraTitle3 = str10;
                                }
                                Intrinsics.checkNotNullExpressionValue(extraTitle3, "this.extraTitle ?: \"\"");
                                String extraPic = feed.getExtraPic();
                                if (extraPic != null) {
                                    str10 = extraPic;
                                }
                                Intrinsics.checkNotNullExpressionValue(str10, "this.extraPic ?: \"\"");
                                FeedArgsFactoryKt.applyDiscovery(isRemoveExtraViewVisible, context, extraTitle3, str10);
                                break;
                            }
                            break;
                        case -23096968:
                            if (feedType.equals("feedArticle")) {
                                Intrinsics.checkNotNullExpressionValue(isRemoveExtraViewVisible, "builder");
                                FeedArgsFactoryKt.applyHtml(FeedArgsFactoryKt.applyFeed(isRemoveExtraViewVisible, context));
                                break;
                            }
                            break;
                        case 116079:
                            if (feedType.equals("url")) {
                                Intrinsics.checkNotNullExpressionValue(isRemoveExtraViewVisible, "builder");
                                String extraTitle4 = feed.getExtraTitle();
                                if (extraTitle4 == null) {
                                    extraTitle4 = str10;
                                }
                                Intrinsics.checkNotNullExpressionValue(extraTitle4, "this.extraTitle ?: \"\"");
                                String extraInfo = feed.getExtraInfo();
                                if (extraInfo == null) {
                                    extraInfo = str10;
                                }
                                Intrinsics.checkNotNullExpressionValue(extraInfo, "this.extraInfo ?: \"\"");
                                String extraPic2 = feed.getExtraPic();
                                if (extraPic2 != null) {
                                    str10 = extraPic2;
                                }
                                Intrinsics.checkNotNullExpressionValue(str10, "this.extraPic ?: \"\"");
                                FeedArgsFactoryKt.applyShareInfo(isRemoveExtraViewVisible, context, extraTitle4, extraInfo, str10);
                                break;
                            }
                            break;
                        case 3138974:
                            if (feedType.equals("feed")) {
                                Intrinsics.checkNotNullExpressionValue(isRemoveExtraViewVisible, "builder");
                                FeedArgsFactoryKt.applyFeed(isRemoveExtraViewVisible, context);
                                break;
                            }
                            break;
                        case 3625706:
                            if (feedType.equals("vote")) {
                                Intrinsics.checkNotNullExpressionValue(isRemoveExtraViewVisible, "builder");
                                FeedUIConfig.Builder applyVote = FeedArgsFactoryKt.applyVote(isRemoveExtraViewVisible, context);
                                Vote vote = feed.getVote();
                                FeedUIConfig.Builder relativeTitle3 = applyVote.relativeTitle((vote == null || (linkTagEntity2 = vote.getLinkTagEntity()) == null) ? null : linkTagEntity2.getTitle());
                                Vote vote2 = feed.getVote();
                                if (!(vote2 == null || (linkTagEntity = vote2.getLinkTagEntity()) == null)) {
                                    str12 = linkTagEntity.getLogo();
                                }
                                relativeTitle3.relativeLogo(str12).canUpdateVoteMode(false).canUpdateVoteTime(false);
                                break;
                            }
                            break;
                        case 92896879:
                            break;
                        case 98539350:
                            break;
                        case 950398559:
                            if (feedType.equals("comment")) {
                                Intrinsics.checkNotNullExpressionValue(isRemoveExtraViewVisible, "builder");
                                FeedArgsFactoryKt.applyFeed(isRemoveExtraViewVisible, context);
                                break;
                            }
                            break;
                        case 1394352404:
                            break;
                        case 1408890901:
                            if (feedType.equals("voteComment")) {
                                Intrinsics.checkNotNullExpressionValue(isRemoveExtraViewVisible, "builder");
                                Vote vote3 = feed.getVote();
                                if (vote3 != null) {
                                    str11 = vote3.getMessageTitle();
                                }
                                FeedArgsFactoryKt.applyVoteComment(isRemoveExtraViewVisible, context, str11).extraViewTitle(str10).extraViewLogoUrl(str10).extraViewContent(str10).isExtraViewVisible(false);
                                break;
                            }
                            break;
                    }
                    FeedUIConfig build = isRemoveExtraViewVisible.build();
                    Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
                    return build;
                }
                Intrinsics.checkNotNullExpressionValue(isRemoveExtraViewVisible, "builder");
                FeedArgsFactoryKt.applyFeed(isRemoveExtraViewVisible, context);
                FeedUIConfig build = isRemoveExtraViewVisible.build();
                Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
                return build;
            }
        }
        z = true;
        FeedUIConfig.Builder isRemoveExtraViewVisible = isExtraViewVisible.isRemoveExtraViewVisible(z);
        extraEntities = feed.getExtraEntities();
        Intrinsics.checkNotNullExpressionValue(extraEntities, "this.extraEntities");
        if (!extraEntities.isEmpty()) {
        }
        feedType = feed.getFeedType();
        if (feedType != null) {
        }
        Intrinsics.checkNotNullExpressionValue(isRemoveExtraViewVisible, "builder");
        FeedArgsFactoryKt.applyFeed(isRemoveExtraViewVisible, context);
        FeedUIConfig build = isRemoveExtraViewVisible.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }
}
