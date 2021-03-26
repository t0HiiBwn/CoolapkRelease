package com.coolapk.market.view.collectionList;

import android.text.TextUtils;
import com.coolapk.market.model.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010$\u001a\u0004\u0018\u00010\u0004J\b\u0010%\u001a\u0004\u0018\u00010\nJ\r\u0010&\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010'J\b\u0010(\u001a\u0004\u0018\u00010\nJ\u0006\u0010)\u001a\u00020\u0010J\b\u0010*\u001a\u0004\u0018\u00010\nJ\r\u0010+\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010'J\r\u0010,\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010'J\b\u0010-\u001a\u0004\u0018\u00010\nJ\b\u0010.\u001a\u0004\u0018\u00010\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001a\u0010\u001e\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001c\u0010!\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000e¨\u0006/"}, d2 = {"Lcom/coolapk/market/view/collectionList/CollectionListViewModel;", "", "()V", "collection", "Lcom/coolapk/market/model/Collection;", "getCollection", "()Lcom/coolapk/market/model/Collection;", "setCollection", "(Lcom/coolapk/market/model/Collection;)V", "collectionCoverUrl", "", "getCollectionCoverUrl", "()Ljava/lang/String;", "setCollectionCoverUrl", "(Ljava/lang/String;)V", "collectionCreateAndBack", "", "getCollectionCreateAndBack", "()Z", "setCollectionCreateAndBack", "(Z)V", "collectionDescription", "getCollectionDescription", "setCollectionDescription", "collectionId", "getCollectionId", "setCollectionId", "collectionIsEdit", "getCollectionIsEdit", "setCollectionIsEdit", "collectionIsOpen", "getCollectionIsOpen", "setCollectionIsOpen", "collectionTitle", "getCollectionTitle", "setCollectionTitle", "getCollectionModel", "getCoverUrl", "getCreateAndBack", "()Ljava/lang/Boolean;", "getDescription", "getHasPic", "getId", "getIsEdit", "getIsOpen", "getTitle", "getUploadPic", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CollectionListViewModel.kt */
public final class CollectionListViewModel {
    private Collection collection;
    private String collectionCoverUrl;
    private boolean collectionCreateAndBack;
    private String collectionDescription;
    private String collectionId;
    private boolean collectionIsEdit;
    private boolean collectionIsOpen;
    private String collectionTitle;

    public final String getCollectionTitle() {
        return this.collectionTitle;
    }

    public final void setCollectionTitle(String str) {
        this.collectionTitle = str;
    }

    public final String getCollectionId() {
        return this.collectionId;
    }

    public final void setCollectionId(String str) {
        this.collectionId = str;
    }

    public final String getCollectionDescription() {
        return this.collectionDescription;
    }

    public final void setCollectionDescription(String str) {
        this.collectionDescription = str;
    }

    public final String getCollectionCoverUrl() {
        return this.collectionCoverUrl;
    }

    public final void setCollectionCoverUrl(String str) {
        this.collectionCoverUrl = str;
    }

    public final boolean getCollectionIsOpen() {
        return this.collectionIsOpen;
    }

    public final void setCollectionIsOpen(boolean z) {
        this.collectionIsOpen = z;
    }

    public final boolean getCollectionCreateAndBack() {
        return this.collectionCreateAndBack;
    }

    public final void setCollectionCreateAndBack(boolean z) {
        this.collectionCreateAndBack = z;
    }

    public final boolean getCollectionIsEdit() {
        return this.collectionIsEdit;
    }

    public final void setCollectionIsEdit(boolean z) {
        this.collectionIsEdit = z;
    }

    public final Collection getCollection() {
        return this.collection;
    }

    public final void setCollection(Collection collection2) {
        this.collection = collection2;
    }

    public final Collection getCollectionModel() {
        return Collection.newBuilder().coverPic(getCoverUrl()).title(this.collectionTitle).description(this.collectionDescription).isOpen(this.collectionIsOpen ? 1 : 0).id(this.collectionId).followNum(0).apkNum(0).likeNum(0).replyNum(0).copyNum(0).feedNum(0).itemNum(0).shareNum(0).isBeCollected(0).build();
    }

    public final String getTitle() {
        return this.collectionTitle;
    }

    public final String getId() {
        return this.collectionId;
    }

    public final String getDescription() {
        return this.collectionDescription;
    }

    public final String getCoverUrl() {
        return this.collectionCoverUrl;
    }

    public final String getUploadPic() {
        if (TextUtils.isEmpty(getCoverUrl())) {
            return "";
        }
        String coverUrl = getCoverUrl();
        Intrinsics.checkNotNull(coverUrl);
        return !StringsKt.startsWith$default(coverUrl, "http", false, 2, null) ? "" : getCoverUrl();
    }

    public final Boolean getIsOpen() {
        return Boolean.valueOf(this.collectionIsOpen);
    }

    public final Boolean getCreateAndBack() {
        return Boolean.valueOf(this.collectionCreateAndBack);
    }

    public final Boolean getIsEdit() {
        return Boolean.valueOf(this.collectionIsOpen);
    }

    public final boolean getHasPic() {
        return !TextUtils.isEmpty(this.collectionCoverUrl);
    }
}
