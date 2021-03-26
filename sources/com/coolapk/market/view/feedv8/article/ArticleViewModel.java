package com.coolapk.market.view.feedv8.article;

import android.text.Editable;
import androidx.lifecycle.MutableLiveData;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.ShareFeedInfo;
import com.coolapk.market.util.CoolFileUtils;
import com.coolapk.market.view.feedv8.ArticleCard;
import com.coolapk.market.view.feedv8.ArticleImage;
import com.coolapk.market.view.feedv8.ArticleModel;
import com.coolapk.market.view.feedv8.ArticleShareUrl;
import com.coolapk.market.view.feedv8.util.ArticleEditText;
import com.coolapk.market.viewholder.BindingViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001NB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010.\u001a\u00020\u0011J\u0012\u0010/\u001a\u0004\u0018\u00010\u000e2\u0006\u00100\u001a\u00020\u0017H\u0002J\u000e\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0005J\u0018\u00104\u001a\u0002022\u0006\u00105\u001a\u00020,2\b\b\u0002\u00106\u001a\u00020#J\u0014\u00107\u001a\u0002022\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001109J\u0016\u0010:\u001a\u0002022\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000e09H\u0002J\u000e\u0010<\u001a\u0002022\u0006\u0010=\u001a\u00020>J\u0016\u0010?\u001a\u0002022\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u000e\u0010A\u001a\u0002022\u0006\u0010.\u001a\u00020\u0011J\u000e\u0010B\u001a\u0002022\u0006\u0010C\u001a\u00020DJ4\u0010E\u001a\u0002022\b\b\u0002\u0010F\u001a\u00020#2\b\b\u0002\u0010G\u001a\u00020#2\u0018\u0010H\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u0002020IJ\u001a\u0010J\u001a\u0002022\b\u0010K\u001a\u0004\u0018\u00010\t2\b\u0010L\u001a\u0004\u0018\u00010\u001eJ\"\u0010M\u001a\u0002022\u0006\u00100\u001a\u00020\u00172\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0IR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR:\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010$\"\u0004\b%\u0010&R\u001f\u0010'\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010#0#0\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0007R\u001a\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020,0+X\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/coolapk/market/view/feedv8/article/ArticleViewModel;", "", "()V", "actions", "Landroidx/lifecycle/MutableLiveData;", "Lcom/coolapk/market/view/feedv8/article/ArticleViewModel$ActionType;", "getActions", "()Landroidx/lifecycle/MutableLiveData;", "activeEditText", "Lcom/coolapk/market/view/feedv8/util/ArticleEditText;", "getActiveEditText", "()Lcom/coolapk/market/view/feedv8/util/ArticleEditText;", "dataList", "", "Lcom/coolapk/market/view/feedv8/ArticleModel;", "getDataList", "firstTextHint", "", "getFirstTextHint", "()Ljava/lang/String;", "setFirstTextHint", "(Ljava/lang/String;)V", "firstTextMinLines", "", "getFirstTextMinLines", "()I", "setFirstTextMinLines", "(I)V", "<set-?>", "Lkotlin/Pair;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "focusPair", "getFocusPair", "()Lkotlin/Pair;", "isAlertViewUserDismiss", "", "()Z", "setAlertViewUserDismiss", "(Z)V", "menuEnable", "kotlin.jvm.PlatformType", "getMenuEnable", "urlEntityMap", "", "Lcom/coolapk/market/model/Entity;", "getEntityByUrl", "url", "getModel", "at", "handleAction", "", "action", "insertExtraEntity", "entity", "addToList", "insertImages", "pathList", "", "insertNotTextPart", "articleImages", "insertShareUrl", "info", "Lcom/coolapk/market/model/ShareFeedInfo;", "internalCheckEditable", "modelList", "removeEntityByUrl", "setInitMultiPart", "multiPart", "Lcom/coolapk/market/model/FeedMultiPart;", "updateDataList", "silent", "checkOrder", "updater", "Lkotlin/Function1;", "updateFocusPair", "first", "second", "updateModel", "ActionType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ArticleViewModel.kt */
public final class ArticleViewModel {
    private final MutableLiveData<ActionType> actions = new MutableLiveData<>();
    private final MutableLiveData<List<ArticleModel>> dataList = new MutableLiveData<>(new ArrayList());
    private String firstTextHint = "正文";
    private int firstTextMinLines = 2;
    private Pair<? extends ArticleEditText, ? extends BindingViewHolder> focusPair;
    private boolean isAlertViewUserDismiss;
    private final MutableLiveData<Boolean> menuEnable = new MutableLiveData<>(true);
    private final Map<String, Entity> urlEntityMap = new LinkedHashMap();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/feedv8/article/ArticleViewModel$ActionType;", "", "(Ljava/lang/String;I)V", "CheckTextLength", "CheckSubmittable", "PickContacts", "UpdateListSilently", "UpdateFirstTextPart", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ArticleViewModel.kt */
    public enum ActionType {
        CheckTextLength,
        CheckSubmittable,
        PickContacts,
        UpdateListSilently,
        UpdateFirstTextPart
    }

    public final MutableLiveData<List<ArticleModel>> getDataList() {
        return this.dataList;
    }

    public final MutableLiveData<Boolean> getMenuEnable() {
        return this.menuEnable;
    }

    public final MutableLiveData<ActionType> getActions() {
        return this.actions;
    }

    public final boolean isAlertViewUserDismiss() {
        return this.isAlertViewUserDismiss;
    }

    public final void setAlertViewUserDismiss(boolean z) {
        this.isAlertViewUserDismiss = z;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.Pair<? extends com.coolapk.market.view.feedv8.util.ArticleEditText, ? extends com.coolapk.market.viewholder.BindingViewHolder>, kotlin.Pair<com.coolapk.market.view.feedv8.util.ArticleEditText, com.coolapk.market.viewholder.BindingViewHolder> */
    public final Pair<ArticleEditText, BindingViewHolder> getFocusPair() {
        return this.focusPair;
    }

    public final ArticleEditText getActiveEditText() {
        Pair<? extends ArticleEditText, ? extends BindingViewHolder> pair = this.focusPair;
        if (pair != null) {
            return (ArticleEditText) pair.getFirst();
        }
        return null;
    }

    public final String getFirstTextHint() {
        return this.firstTextHint;
    }

    public final void setFirstTextHint(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.firstTextHint = str;
    }

    public final int getFirstTextMinLines() {
        return this.firstTextMinLines;
    }

    public final void setFirstTextMinLines(int i) {
        this.firstTextMinLines = i;
    }

    public final Entity getEntityByUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        return this.urlEntityMap.get(str);
    }

    public final void removeEntityByUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        List<ArticleModel> value = this.dataList.getValue();
        if (value != null) {
            Intrinsics.checkNotNullExpressionValue(value, "it");
            Sequence filter = SequencesKt.filter(CollectionsKt.asSequence(value), ArticleViewModel$$special$$inlined$filterIsInstance$1.INSTANCE);
            Objects.requireNonNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
            if (SequencesKt.count(SequencesKt.filter(filter, new ArticleViewModel$removeEntityByUrl$$inlined$let$lambda$1(this, str))) == 0) {
                this.urlEntityMap.remove(str);
            }
        }
    }

    private final ArticleModel getModel(int i) {
        List<ArticleModel> value = this.dataList.getValue();
        Intrinsics.checkNotNull(value);
        Intrinsics.checkNotNullExpressionValue(value, "dataList.value!!");
        return (ArticleModel) CollectionsKt.getOrNull(value, i);
    }

    public final void setInitMultiPart(FeedMultiPart feedMultiPart) {
        Intrinsics.checkNotNullParameter(feedMultiPart, "multiPart");
        if (Intrinsics.areEqual(feedMultiPart.type(), "answer")) {
            this.firstTextHint = "说说你的回答";
            this.firstTextMinLines = 6;
        }
    }

    public final void updateModel(int i, Function1<? super ArticleModel, ? extends ArticleModel> function1) {
        Intrinsics.checkNotNullParameter(function1, "updater");
        ArticleModel model = getModel(i);
        if (model != null) {
            updateDataList(true, false, new ArticleViewModel$updateModel$1(i, function1, model));
        }
    }

    public static /* synthetic */ void updateDataList$default(ArticleViewModel articleViewModel, boolean z, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        articleViewModel.updateDataList(z, z2, function1);
    }

    public final void updateDataList(boolean z, boolean z2, Function1<? super List<ArticleModel>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "updater");
        List<ArticleModel> value = this.dataList.getValue();
        Intrinsics.checkNotNull(value);
        Intrinsics.checkNotNullExpressionValue(value, "dataList.value!!");
        function1.invoke(value);
        if (z2) {
            List<ArticleModel> value2 = this.dataList.getValue();
            Intrinsics.checkNotNull(value2);
            Intrinsics.checkNotNullExpressionValue(value2, "dataList.value!!");
            internalCheckEditable(value2);
        }
        if (!z) {
            MutableLiveData<List<ArticleModel>> mutableLiveData = this.dataList;
            mutableLiveData.setValue(mutableLiveData.getValue());
            return;
        }
        handleAction(ActionType.UpdateListSilently);
    }

    public final void updateFocusPair(ArticleEditText articleEditText, BindingViewHolder bindingViewHolder) {
        if (articleEditText == null || bindingViewHolder == null) {
            this.focusPair = null;
        } else {
            this.focusPair = TuplesKt.to(articleEditText, bindingViewHolder);
        }
    }

    public final void handleAction(ActionType actionType) {
        Intrinsics.checkNotNullParameter(actionType, "action");
        this.actions.setValue(actionType);
    }

    public final void insertImages(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "pathList");
        List<String> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList.add(CoolFileUtils.wrap(it2.next()));
        }
        ArrayList<String> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (String str : arrayList2) {
            Intrinsics.checkNotNullExpressionValue(str, "it");
            arrayList3.add(new ArticleImage(str, ""));
        }
        insertNotTextPart(arrayList3);
    }

    public final void insertShareUrl(ShareFeedInfo shareFeedInfo) {
        Intrinsics.checkNotNullParameter(shareFeedInfo, "info");
        String title = shareFeedInfo.getTitle();
        String str = "";
        if (title == null) {
            title = str;
        }
        String subTitle = shareFeedInfo.getSubTitle();
        if (subTitle == null) {
            subTitle = str;
        }
        String url = shareFeedInfo.getUrl();
        if (url == null) {
            url = str;
        }
        String logo = shareFeedInfo.getLogo();
        if (logo != null) {
            str = logo;
        }
        insertNotTextPart(CollectionsKt.listOf(new ArticleShareUrl(title, subTitle, url, str)));
    }

    public static /* synthetic */ void insertExtraEntity$default(ArticleViewModel articleViewModel, Entity entity, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        articleViewModel.insertExtraEntity(entity, z);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0026: APUT  
      (r5v2 com.coolapk.market.view.feedv8.ArticleCard[])
      (0 ??[int, short, byte, char])
      (wrap: com.coolapk.market.view.feedv8.ArticleCard : 0x0023: CONSTRUCTOR  (r1v2 com.coolapk.market.view.feedv8.ArticleCard) = (r2v1 java.lang.String) call: com.coolapk.market.view.feedv8.ArticleCard.<init>(java.lang.String):void type: CONSTRUCTOR)
     */
    public final void insertExtraEntity(Entity entity, boolean z) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        Map<String, Entity> map = this.urlEntityMap;
        String url = entity.getUrl();
        String str = "";
        if (url == null) {
            url = str;
        }
        map.put(url, entity);
        if (z) {
            ArticleCard[] articleCardArr = new ArticleCard[1];
            String url2 = entity.getUrl();
            if (url2 != null) {
                str = url2;
            }
            articleCardArr[0] = new ArticleCard(str);
            insertNotTextPart(CollectionsKt.mutableListOf(articleCardArr));
        }
    }

    private final void insertNotTextPart(List<? extends ArticleModel> list) {
        Pair<? extends ArticleEditText, ? extends BindingViewHolder> pair = this.focusPair;
        if (pair == null || ((BindingViewHolder) pair.getSecond()).getAdapterPosition() < 0) {
            updateDataList$default(this, false, false, new ArticleViewModel$insertNotTextPart$1(list), 3, null);
        } else {
            int adapterPosition = ((BindingViewHolder) pair.getSecond()).getAdapterPosition();
            ArticleEditText articleEditText = (ArticleEditText) pair.getFirst();
            Editable text = articleEditText.getText();
            Intrinsics.checkNotNull(text);
            Intrinsics.checkNotNullExpressionValue(text, "editText.text!!");
            updateDataList$default(this, false, false, new ArticleViewModel$insertNotTextPart$2(articleEditText, adapterPosition, list, text), 3, null);
        }
        handleAction(ActionType.CheckSubmittable);
        handleAction(ActionType.UpdateFirstTextPart);
    }

    private final void internalCheckEditable(List<ArticleModel> list) {
        new ArticleViewModel$internalCheckEditable$1(list).invoke(0);
    }
}
