package com.coolapk.market.view.block;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.databinding.DialogAddBlockWordBinding;
import com.coolapk.market.databinding.DialogBlockNodeBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedTarget;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.WrapDialogFragmentKt;
import com.coolapk.market.widget.CoolFlowLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import rx.Subscriber;

/* compiled from: AddBlockDialog.kt */
public final class AddBlockDialog {
    public static final AddBlockDialog INSTANCE = new AddBlockDialog();
    private static final Regex TOPIC_REGEX = new Regex("<a class=\"feed-link-tag\" href=\"/t/(.+)\\?type=\\d{1,3}\">#\\1#</a>");

    private AddBlockDialog() {
    }

    public final void showAddBlockDialog(Activity activity, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Activity activity2 = activity;
        DialogAddBlockWordBinding dialogAddBlockWordBinding = (DialogAddBlockWordBinding) DataBindingUtil.inflate(LayoutInflater.from(activity2), 2131558511, null, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity2);
        Intrinsics.checkNotNullExpressionValue(dialogAddBlockWordBinding, "binding");
        AlertDialog create = builder.setView(dialogAddBlockWordBinding.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activity2).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        DialogFragment show = WrapDialogFragmentKt.show(create, supportFragmentManager, null);
        dialogAddBlockWordBinding.cancelButton.setOnClickListener(new AddBlockDialog$showAddBlockDialog$1(show));
        dialogAddBlockWordBinding.okButton.setOnClickListener(new AddBlockDialog$showAddBlockDialog$2(dialogAddBlockWordBinding, activity, show, function0));
    }

    public final void showBlockNodeDialog(Activity activity, List<BlockItem> list) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(list, "blockItemList");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (BlockContentManager.INSTANCE.isBlockNodeAlreadyActive(list.get(i))) {
                list.set(i, BlockItem.copy$default(list.get(i), null, null, null, null, true, null, null, 111, null));
            }
        }
        Activity activity2 = activity;
        DialogBlockNodeBinding dialogBlockNodeBinding = (DialogBlockNodeBinding) DataBindingUtil.inflate(LayoutInflater.from(activity2), 2131558519, null, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity2);
        Intrinsics.checkNotNullExpressionValue(dialogBlockNodeBinding, "binding");
        AlertDialog create = builder.setView(dialogBlockNodeBinding.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activity2).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        setupCoolFlowLayout(dialogBlockNodeBinding, WrapDialogFragmentKt.show(create, supportFragmentManager, null), activity, list);
    }

    public final void showBlockNodeDialog(Activity activity, Feed feed) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(feed, "feed");
        showBlockNodeDialog(activity, createBlockList(feed));
    }

    private final void setupCoolFlowLayout(DialogBlockNodeBinding dialogBlockNodeBinding, DialogFragment dialogFragment, Activity activity, List<BlockItem> list) {
        List list2 = CollectionsKt.toList(list);
        dialogBlockNodeBinding.executePendingBindings();
        dialogBlockNodeBinding.okButton.setOnClickListener(new AddBlockDialog$setupCoolFlowLayout$1(list2, list, dialogFragment));
        dialogBlockNodeBinding.cancelButton.setOnClickListener(new AddBlockDialog$setupCoolFlowLayout$2(dialogFragment));
        dialogBlockNodeBinding.neutralButton.setOnClickListener(new AddBlockDialog$setupCoolFlowLayout$3(activity, dialogFragment));
        dialogBlockNodeBinding.warningView.setOnClickListener(new AddBlockDialog$setupCoolFlowLayout$4(activity));
        AddBlockDialog$setupCoolFlowLayout$5 addBlockDialog$setupCoolFlowLayout$5 = new AddBlockDialog$setupCoolFlowLayout$5(list2, list, dialogBlockNodeBinding);
        addBlockDialog$setupCoolFlowLayout$5.invoke();
        CoolFlowLayout coolFlowLayout = dialogBlockNodeBinding.flowLayout;
        AddBlockDialog$setupCoolFlowLayout$$inlined$apply$lambda$1 addBlockDialog$setupCoolFlowLayout$$inlined$apply$lambda$1 = new AddBlockDialog$setupCoolFlowLayout$$inlined$apply$lambda$1(coolFlowLayout, list, addBlockDialog$setupCoolFlowLayout$5, activity);
        coolFlowLayout.setVerticalDividerHeight(NumberExtendsKt.getDp((Number) 12));
        coolFlowLayout.setHorizontalDividerWidth(NumberExtendsKt.getDp((Number) 16));
        coolFlowLayout.setAdapter(new AddBlockDialog$setupCoolFlowLayout$$inlined$apply$lambda$2(addBlockDialog$setupCoolFlowLayout$$inlined$apply$lambda$1, activity, 0, list, list, addBlockDialog$setupCoolFlowLayout$5, activity));
    }

    private final List<BlockItem> createBlockList(Feed feed) {
        BlockItem blockNode;
        ArrayList arrayList = new ArrayList();
        FeedTarget targetRow = feed.getTargetRow();
        String str = "";
        if (!(targetRow == null || (blockNode = FeedBlockSpamInterceptorKt.toBlockNode(targetRow)) == null)) {
            if (Intrinsics.areEqual(blockNode.getTid(), "0")) {
                str = blockNode.getName();
            }
            arrayList.add(blockNode);
        }
        String tags = feed.getTags();
        if (tags != null) {
            Intrinsics.checkNotNullExpressionValue(tags, "tags");
            ArrayList<String> arrayList2 = new ArrayList();
            for (Object obj : StringsKt.split$default((CharSequence) StringsKt.replace$default(tags, "#", "", false, 4, (Object) null), new String[]{","}, false, 0, 6, (Object) null)) {
                if (!StringsKt.isBlank((String) obj)) {
                    arrayList2.add(obj);
                }
            }
            for (String str2 : arrayList2) {
                if (!Intrinsics.areEqual(str2, str)) {
                    arrayList.add(new BlockItem(null, str2, "「话题」" + str2, null, false, null, "node", 57, null));
                }
            }
        }
        String uid = feed.getUid();
        Intrinsics.checkNotNullExpressionValue(uid, "feed.uid");
        arrayList.add(new BlockItem(null, uid, "「用户」" + feed.getUserName(), null, false, null, "user", 57, null));
        return arrayList;
    }

    public final void updateBlockNodes(List<BlockItem> list, List<BlockItem> list2) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).getActive() != list2.get(i).getActive()) {
                arrayList.add(list2.get(i));
            }
        }
        if (!arrayList.isEmpty()) {
            BlockContentManager.INSTANCE.updateSpamConfig(arrayList).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new AddBlockDialog$updateBlockNodes$2());
        }
    }
}
