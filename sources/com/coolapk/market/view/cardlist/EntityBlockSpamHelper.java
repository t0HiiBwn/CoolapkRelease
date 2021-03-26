package com.coolapk.market.view.cardlist;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedTarget;
import com.coolapk.market.view.block.BlockContentManager;
import com.coolapk.market.view.block.BlockItem;
import com.coolapk.market.view.block.FeedBlockSpamInterceptorKt;
import com.coolapk.market.view.block.FragmentFeedBlockInterceptor;
import com.coolapk.market.view.feed.dialog.SheetGroupModifierManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* compiled from: EntityBlockSpamHelper.kt */
public final class EntityBlockSpamHelper extends EntityDataFilter {
    public static final Companion Companion = new Companion(null);
    private static final String LAST_MODIFY_BLOCK_ITEM_TIME_MILL = "lastModifyBlockItemTimeMill";
    private FragmentFeedBlockInterceptor feedBlockInterceptor;
    private final EntityListFragment fragment;
    private long lastModifyBlockItemTimeMill;

    public EntityBlockSpamHelper(EntityListFragment entityListFragment) {
        Intrinsics.checkNotNullParameter(entityListFragment, "fragment");
        this.fragment = entityListFragment;
    }

    public final EntityListFragment getFragment() {
        return this.fragment;
    }

    /* compiled from: EntityBlockSpamHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final boolean shouldBlockSpamWord() {
        if (this.fragment.getConfigHelper().getBlockSpamWord() > 0) {
            return true;
        }
        Fragment parentFragment = this.fragment.getParentFragment();
        if (!(parentFragment instanceof EntityListFragment)) {
            parentFragment = null;
        }
        EntityListFragment entityListFragment = (EntityListFragment) parentFragment;
        if (entityListFragment == null || entityListFragment.getConfigHelper().getBlockSpamWord() <= 0) {
            return false;
        }
        return true;
    }

    @Override // com.coolapk.market.view.cardlist.EntityDataFilter
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (shouldBlockSpamWord()) {
            registerInterceptor();
        }
        if (bundle != null) {
            long j = bundle.getLong("lastModifyBlockItemTimeMill", 0);
            this.lastModifyBlockItemTimeMill = j;
            if (j < BlockContentManager.INSTANCE.getLastModifyBlockItemTimeMill()) {
                onBlockItemChangeEvent();
                return;
            }
            return;
        }
        this.lastModifyBlockItemTimeMill = BlockContentManager.INSTANCE.getLastModifyBlockItemTimeMill();
    }

    @Override // com.coolapk.market.view.cardlist.EntityDataFilter
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putLong("lastModifyBlockItemTimeMill", this.lastModifyBlockItemTimeMill);
    }

    public final void onFragmentDestroy() {
        FragmentFeedBlockInterceptor fragmentFeedBlockInterceptor = this.feedBlockInterceptor;
        if (fragmentFeedBlockInterceptor != null) {
            SheetGroupModifierManager.INSTANCE.removeModifier(fragmentFeedBlockInterceptor);
        }
    }

    public final void onBlockItemChangeEvent() {
        if (shouldBlockSpamWord()) {
            processDataList(this.fragment.getDataList());
        }
        this.lastModifyBlockItemTimeMill = BlockContentManager.INSTANCE.getLastModifyBlockItemTimeMill();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.List<? extends com.coolapk.market.model.Entity> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.coolapk.market.view.cardlist.EntityDataFilter
    public List<Entity> modifyData(List<? extends Entity> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "list");
        if (!shouldBlockSpamWord()) {
            return list;
        }
        registerInterceptor();
        boolean isMutableList = TypeIntrinsics.isMutableList(list);
        ArrayList arrayList = list;
        if (!isMutableList) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            arrayList = arrayList2;
        }
        processDataList(arrayList);
        return arrayList;
    }

    private final void processDataList(List<? extends Object> list) {
        ArrayList arrayList = new ArrayList();
        List<BlockItem> blockItems = BlockContentManager.INSTANCE.getBlockItems("node");
        if (!blockItems.isEmpty()) {
            findAndRemoveNodeSpam(list, blockItems, arrayList);
        }
        List<BlockItem> blockItems2 = BlockContentManager.INSTANCE.getBlockItems("word");
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(blockItems2, 10));
        Iterator<T> it2 = blockItems2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(it2.next().getName());
        }
        ArrayList arrayList3 = arrayList2;
        if (!arrayList3.isEmpty()) {
            findAndRemoveWordSpam(list, new Regex(CollectionsKt.joinToString$default(arrayList3, "|", null, null, 0, null, null, 62, null), RegexOption.IGNORE_CASE), arrayList);
        }
        List<BlockItem> blockItems3 = BlockContentManager.INSTANCE.getBlockItems("user");
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(blockItems3, 10));
        Iterator<T> it3 = blockItems3.iterator();
        while (it3.hasNext()) {
            arrayList4.add(it3.next().getName());
        }
        ArrayList arrayList5 = arrayList4;
        if (!arrayList5.isEmpty()) {
            findAndRemoveUidSpam(list, arrayList5, arrayList);
        }
    }

    private final void registerInterceptor() {
        if (this.feedBlockInterceptor == null) {
            FragmentFeedBlockInterceptor fragmentFeedBlockInterceptor = new FragmentFeedBlockInterceptor(this.fragment);
            SheetGroupModifierManager.INSTANCE.addModifier(fragmentFeedBlockInterceptor);
            this.feedBlockInterceptor = fragmentFeedBlockInterceptor;
        }
    }

    private final void findAndRemoveNodeSpam(List<? extends Object> list, List<BlockItem> list2, List<Feed> list3) {
        List<Entity> entities;
        CollectionsKt.removeAll((List) list, (Function1) new EntityBlockSpamHelper$findAndRemoveNodeSpam$1(this, list2, list3));
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if ((t instanceof EntityCard) && (entities = t.getEntities()) != null) {
                int size = entities.size();
                Intrinsics.checkNotNullExpressionValue(entities, "it");
                findAndRemoveNodeSpam(entities, list2, list3);
                if (size != entities.size()) {
                    Objects.requireNonNull(list, "null cannot be cast to non-null type kotlin.collections.MutableList<android.os.Parcelable>");
                    TypeIntrinsics.asMutableList(list).set(i, t);
                }
            }
            i = i2;
        }
    }

    public final boolean isFeedNeedToBlock(Feed feed, List<BlockItem> list) {
        FeedTarget targetRow = feed.getTargetRow();
        BlockItem blockNode = targetRow != null ? FeedBlockSpamInterceptorKt.toBlockNode(targetRow) : null;
        String tags = feed.getTags();
        if (tags == null) {
            tags = "";
        }
        Intrinsics.checkNotNullExpressionValue(tags, "(feed.tags ?: \"\")");
        List split$default = StringsKt.split$default((CharSequence) StringsKt.replace$default(tags, "#", "", false, 4, (Object) null), new String[]{","}, false, 0, 6, (Object) null);
        for (T t : list) {
            if (blockNode != null && Intrinsics.areEqual(t.getTid(), blockNode.getTid()) && Intrinsics.areEqual(t.getName(), blockNode.getName())) {
                return true;
            }
            if ((Intrinsics.areEqual(t.getTid(), "0") || StringsKt.startsWith$default(t.getTid(), "300", false, 2, (Object) null)) && split$default.contains(t.getName())) {
                return true;
            }
        }
        return false;
    }

    private final void findAndRemoveWordSpam(List<? extends Object> list, Regex regex, List<Feed> list2) {
        List<Entity> entities;
        CollectionsKt.removeAll((List) list, (Function1) new EntityBlockSpamHelper$findAndRemoveWordSpam$1(this, regex, list2));
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if ((t instanceof EntityCard) && (entities = t.getEntities()) != null) {
                int size = entities.size();
                Intrinsics.checkNotNullExpressionValue(entities, "it");
                findAndRemoveWordSpam(entities, regex, list2);
                if (size != entities.size()) {
                    Objects.requireNonNull(list, "null cannot be cast to non-null type kotlin.collections.MutableList<android.os.Parcelable>");
                    TypeIntrinsics.asMutableList(list).set(i, t);
                }
            }
            i = i2;
        }
    }

    public final boolean isFeedNeedToBlock(Feed feed, Regex regex) {
        EntityBlockSpamHelper$isFeedNeedToBlock$2 entityBlockSpamHelper$isFeedNeedToBlock$2 = new EntityBlockSpamHelper$isFeedNeedToBlock$2(regex);
        String messageSource = feed.getMessageSource();
        String str = "";
        if (messageSource == null) {
            messageSource = str;
        }
        if ((messageSource.length() > 0) && entityBlockSpamHelper$isFeedNeedToBlock$2.invoke(messageSource)) {
            return true;
        }
        String message = feed.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "feed.message");
        if (entityBlockSpamHelper$isFeedNeedToBlock$2.invoke(message)) {
            return true;
        }
        String messageTitle = feed.getMessageTitle();
        if (messageTitle == null) {
            messageTitle = str;
        }
        if (entityBlockSpamHelper$isFeedNeedToBlock$2.invoke(messageTitle)) {
            return true;
        }
        String commentGood = feed.getCommentGood();
        if (commentGood == null) {
            commentGood = str;
        }
        if (entityBlockSpamHelper$isFeedNeedToBlock$2.invoke(commentGood)) {
            return true;
        }
        String commentGeneral = feed.getCommentGeneral();
        if (commentGeneral == null) {
            commentGeneral = str;
        }
        if (entityBlockSpamHelper$isFeedNeedToBlock$2.invoke(commentGeneral)) {
            return true;
        }
        String commentBad = feed.getCommentBad();
        if (commentBad == null) {
            commentBad = str;
        }
        if (entityBlockSpamHelper$isFeedNeedToBlock$2.invoke(commentBad)) {
            return true;
        }
        FeedTarget targetRow = feed.getTargetRow();
        String title = targetRow != null ? targetRow.getTitle() : null;
        if (title != null) {
            str = title;
        }
        return entityBlockSpamHelper$isFeedNeedToBlock$2.invoke(str);
    }

    private final void findAndRemoveUidSpam(List<? extends Object> list, List<String> list2, List<Feed> list3) {
        List<Entity> entities;
        CollectionsKt.removeAll((List) list, (Function1) new EntityBlockSpamHelper$findAndRemoveUidSpam$1(list2, list3));
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if ((t instanceof EntityCard) && (entities = t.getEntities()) != null) {
                int size = entities.size();
                Intrinsics.checkNotNullExpressionValue(entities, "it");
                findAndRemoveUidSpam(entities, list2, list3);
                if (size != entities.size()) {
                    Objects.requireNonNull(list, "null cannot be cast to non-null type kotlin.collections.MutableList<android.os.Parcelable>");
                    TypeIntrinsics.asMutableList(list).set(i, t);
                }
            }
            i = i2;
        }
    }
}
