package com.coolapk.market.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.ImageLoaderOptions;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.databinding.ItemPodiumCardBinding;
import com.coolapk.market.databinding.ItemPodiumCardItemBinding;
import com.coolapk.market.event.Event;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.ClickInfo;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.model.User;
import com.coolapk.market.util.BlurTransform;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.widget.ActionButton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 '2\u00020\u0001:\u0001'B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J@\u0010\u0014\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001aH\u0002J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0003H\u0016J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\u000f0\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/coolapk/market/viewholder/ItemPodiumViewHolder;", "Lcom/coolapk/market/viewholder/StateViewHolder;", "itemView", "Landroid/view/View;", "comp", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "binding", "Lcom/coolapk/market/databinding/ItemPodiumCardBinding;", "kotlin.jvm.PlatformType", "bitmapTransformation", "Lcom/coolapk/market/util/BlurTransform;", "card", "Lcom/coolapk/market/model/EntityCard;", "options", "Lcom/coolapk/market/app/ImageLoaderOptions;", "bindTo", "", "data", "", "fillData", "entities", "", "Lcom/coolapk/market/model/Entity;", "titles", "", "", "logos", "scores", "loadLogoBackground", "backgroundView", "Landroid/widget/ImageView;", "logo", "onClick", "view", "onStateEventChanged", "", "event", "Lcom/coolapk/market/event/Event;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ItemPodiumViewHolder.kt */
public final class ItemPodiumViewHolder extends StateViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558859;
    private final ItemPodiumCardBinding binding;
    private final BlurTransform bitmapTransformation = new BlurTransform();
    private EntityCard card;
    private final ImageLoaderOptions options = ImageLoaderOptions.newBuilder().bitmapOnly(true).build();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ItemPodiumViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "comp");
        ItemPodiumCardBinding itemPodiumCardBinding = (ItemPodiumCardBinding) getBinding();
        this.binding = itemPodiumCardBinding;
        ItemPodiumCardItemBinding itemPodiumCardItemBinding = itemPodiumCardBinding.secondPlaceView;
        Intrinsics.checkNotNullExpressionValue(itemPodiumCardItemBinding, "binding.secondPlaceView");
        ItemPodiumViewHolder itemPodiumViewHolder = this;
        itemPodiumCardItemBinding.getRoot().setOnClickListener(itemPodiumViewHolder);
        ItemPodiumCardItemBinding itemPodiumCardItemBinding2 = itemPodiumCardBinding.championView;
        Intrinsics.checkNotNullExpressionValue(itemPodiumCardItemBinding2, "binding.championView");
        itemPodiumCardItemBinding2.getRoot().setOnClickListener(itemPodiumViewHolder);
        ItemPodiumCardItemBinding itemPodiumCardItemBinding3 = itemPodiumCardBinding.thirdPlaceView;
        Intrinsics.checkNotNullExpressionValue(itemPodiumCardItemBinding3, "binding.thirdPlaceView");
        itemPodiumCardItemBinding3.getRoot().setOnClickListener(itemPodiumViewHolder);
        itemPodiumCardBinding.secondPlaceView.actionContainer.setOnClickListener(itemPodiumViewHolder);
        itemPodiumCardBinding.championView.actionContainer.setOnClickListener(itemPodiumViewHolder);
        itemPodiumCardBinding.thirdPlaceView.actionContainer.setOnClickListener(itemPodiumViewHolder);
        itemPodiumCardBinding.secondPlaceView.actionButton2.setOnClickListener(itemPodiumViewHolder);
        itemPodiumCardBinding.championView.actionButton2.setOnClickListener(itemPodiumViewHolder);
        itemPodiumCardBinding.thirdPlaceView.actionButton2.setOnClickListener(itemPodiumViewHolder);
        itemPodiumCardBinding.secondPlaceView.numView.setImageResource(2131231699);
        itemPodiumCardBinding.championView.numView.setImageResource(2131231698);
        itemPodiumCardBinding.thirdPlaceView.numView.setImageResource(2131231700);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/ItemPodiumViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ItemPodiumViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        boolean z;
        boolean z2;
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.EntityCard");
        EntityCard entityCard = (EntityCard) obj;
        this.card = entityCard;
        if (entityCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        List<Entity> entities = entityCard.getEntities();
        Intrinsics.checkNotNull(entities);
        Intrinsics.checkNotNullExpressionValue(entities, "card.entities!!");
        Entity entity = entities.get(1);
        Entity entity2 = entities.get(0);
        Entity entity3 = entities.get(2);
        ItemPodiumCardItemBinding itemPodiumCardItemBinding = this.binding.secondPlaceView;
        Intrinsics.checkNotNullExpressionValue(itemPodiumCardItemBinding, "binding.secondPlaceView");
        View root = itemPodiumCardItemBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.secondPlaceView.root");
        root.setTag(entity);
        ItemPodiumCardItemBinding itemPodiumCardItemBinding2 = this.binding.championView;
        Intrinsics.checkNotNullExpressionValue(itemPodiumCardItemBinding2, "binding.championView");
        View root2 = itemPodiumCardItemBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.championView.root");
        root2.setTag(entity2);
        ItemPodiumCardItemBinding itemPodiumCardItemBinding3 = this.binding.thirdPlaceView;
        Intrinsics.checkNotNullExpressionValue(itemPodiumCardItemBinding3, "binding.thirdPlaceView");
        View root3 = itemPodiumCardItemBinding3.getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "binding.thirdPlaceView.root");
        root3.setTag(entity3);
        ActionButton actionButton = this.binding.secondPlaceView.actionContainer;
        Intrinsics.checkNotNullExpressionValue(actionButton, "binding.secondPlaceView.actionContainer");
        actionButton.setTag(entity);
        ActionButton actionButton2 = this.binding.championView.actionContainer;
        Intrinsics.checkNotNullExpressionValue(actionButton2, "binding.championView.actionContainer");
        actionButton2.setTag(entity2);
        ActionButton actionButton3 = this.binding.thirdPlaceView.actionContainer;
        Intrinsics.checkNotNullExpressionValue(actionButton3, "binding.thirdPlaceView.actionContainer");
        actionButton3.setTag(entity3);
        TextView textView = this.binding.secondPlaceView.actionButton2;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.secondPlaceView.actionButton2");
        textView.setTag(entity);
        TextView textView2 = this.binding.championView.actionButton2;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.championView.actionButton2");
        textView2.setTag(entity2);
        TextView textView3 = this.binding.thirdPlaceView.actionButton2;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.thirdPlaceView.actionButton2");
        textView3.setTag(entity3);
        int size = entities.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add("");
        }
        ArrayList arrayList2 = arrayList;
        int size2 = entities.size();
        ArrayList arrayList3 = new ArrayList(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            arrayList3.add("");
        }
        ArrayList arrayList4 = arrayList3;
        int size3 = entities.size();
        ArrayList arrayList5 = new ArrayList(size3);
        for (int i3 = 0; i3 < size3; i3++) {
            arrayList5.add("");
        }
        ArrayList arrayList6 = arrayList5;
        fillData(entities, arrayList2, arrayList4, arrayList6);
        ArrayList arrayList7 = arrayList6;
        if (!(arrayList7 instanceof Collection) || !arrayList7.isEmpty()) {
            Iterator it2 = arrayList7.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (((String) it2.next()).length() > 0) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        FrameLayout frameLayout = this.binding.secondPlaceView.contentLayout;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.secondPlaceView.contentLayout");
        FrameLayout frameLayout2 = frameLayout;
        ViewGroup.LayoutParams layoutParams = frameLayout2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = NumberExtendsKt.getDp(Integer.valueOf(z ? 133 : 128));
            frameLayout2.setLayoutParams(layoutParams);
            FrameLayout frameLayout3 = this.binding.championView.contentLayout;
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.championView.contentLayout");
            FrameLayout frameLayout4 = frameLayout3;
            ViewGroup.LayoutParams layoutParams2 = frameLayout4.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = NumberExtendsKt.getDp(Integer.valueOf(z ? 147 : 144));
                frameLayout4.setLayoutParams(layoutParams2);
                FrameLayout frameLayout5 = this.binding.thirdPlaceView.contentLayout;
                Intrinsics.checkNotNullExpressionValue(frameLayout5, "binding.thirdPlaceView.contentLayout");
                FrameLayout frameLayout6 = frameLayout5;
                ViewGroup.LayoutParams layoutParams3 = frameLayout6.getLayoutParams();
                if (layoutParams3 != null) {
                    layoutParams3.height = NumberExtendsKt.getDp(Integer.valueOf(z ? 125 : 112));
                    frameLayout6.setLayoutParams(layoutParams3);
                    ItemPodiumCardBinding itemPodiumCardBinding = this.binding;
                    Intrinsics.checkNotNullExpressionValue(itemPodiumCardBinding, "binding");
                    itemPodiumCardBinding.setLogos(arrayList4);
                    ItemPodiumCardBinding itemPodiumCardBinding2 = this.binding;
                    Intrinsics.checkNotNullExpressionValue(itemPodiumCardBinding2, "binding");
                    itemPodiumCardBinding2.setTitles(arrayList2);
                    ItemPodiumCardBinding itemPodiumCardBinding3 = this.binding;
                    Intrinsics.checkNotNullExpressionValue(itemPodiumCardBinding3, "binding");
                    itemPodiumCardBinding3.setScores(arrayList6);
                    ItemPodiumCardBinding itemPodiumCardBinding4 = this.binding;
                    Intrinsics.checkNotNullExpressionValue(itemPodiumCardBinding4, "binding");
                    itemPodiumCardBinding4.setApps(CollectionsKt.filterIsInstance(entities, ServiceApp.class));
                    this.binding.executePendingBindings();
                    ImageView imageView = this.binding.secondPlaceView.backgroundImageView;
                    Intrinsics.checkNotNullExpressionValue(imageView, "binding.secondPlaceView.backgroundImageView");
                    loadLogoBackground(imageView, arrayList4.get(1));
                    ImageView imageView2 = this.binding.championView.backgroundImageView;
                    Intrinsics.checkNotNullExpressionValue(imageView2, "binding.championView.backgroundImageView");
                    loadLogoBackground(imageView2, arrayList4.get(0));
                    ImageView imageView3 = this.binding.thirdPlaceView.backgroundImageView;
                    Intrinsics.checkNotNullExpressionValue(imageView3, "binding.thirdPlaceView.backgroundImageView");
                    loadLogoBackground(imageView3, arrayList4.get(2));
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    private final void loadLogoBackground(ImageView imageView, String str) {
        AppHolder.getContextImageLoader().displayImage(getContext(), str, imageView, this.options, (OnImageLoadListener) null, (OnBitmapTransformListener) this.bitmapTransformation);
    }

    private final void fillData(List<? extends Entity> list, List<String> list2, List<String> list3, List<String> list4) {
        String str;
        String str2;
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            String str3 = "";
            if (t2 instanceof User) {
                T t3 = t2;
                str = t3.getUserAvatar();
                if (str == null) {
                    str = str3;
                }
                str2 = t3.getUserName();
                Intrinsics.checkNotNullExpressionValue(str2, "entity.userName");
            } else if (t2 instanceof ServiceApp) {
                str = EntityExtendsKt.picOrLogo(t2);
                T t4 = t2;
                String appName = t4.getAppName();
                if (appName == null) {
                    appName = str3;
                }
                String score = t4.getScore();
                if (score != null) {
                    str3 = score;
                }
                str2 = appName;
            } else {
                str = EntityExtendsKt.picOrLogo(t2);
                str2 = t2.getTitle();
                if (str2 == null) {
                    str2 = str3;
                }
            }
            list2.set(i, str2);
            list3.set(i, str);
            list4.set(i, str3);
            i = i2;
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00b9: APUT  (r5v2 java.lang.String[]), (2 ??[int, float, short, byte, char]), (r0v5 java.lang.String) */
    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() != 2131361886) {
            Object tag = view.getTag();
            if (tag instanceof ServiceApp) {
                ServiceApp serviceApp = (ServiceApp) tag;
                ActionManager.startAppViewActivity(getContext(), serviceApp.getPackageName(), serviceApp.getExtraAnalysisData(), serviceApp.getRequestContext(), serviceApp.getExtraFromApi(), EntityExtendsKt.urlClientConfig((Entity) tag));
            } else if (tag instanceof User) {
                ActionManager.startUserSpaceActivity(getContext(), ((User) tag).getUid());
            } else if (tag instanceof Entity) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                Entity entity = (Entity) tag;
                ActionManagerCompat.startActivityByUrl(context, entity.getUrl(), entity.getTitle(), entity.getSubTitle());
            }
        } else {
            Object tag2 = view.getTag();
            Objects.requireNonNull(tag2, "null cannot be cast to non-null type com.coolapk.market.model.ServiceApp");
            ServiceApp serviceApp2 = (ServiceApp) tag2;
            String str = null;
            UpgradeInfo upgradeInfo = null;
            MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(serviceApp2.getPackageName());
            if (mobileAppExistFast != null) {
                upgradeInfo = mobileAppExistFast.getUpgradeInfo();
            }
            ClickInfo.Builder targetUrl = ClickInfo.newBuilder(serviceApp2).packageName(serviceApp2.getPackageName()).targetUrl(serviceApp2.getDownloadUrl(0));
            String[] strArr = new String[4];
            strArr[0] = serviceApp2.getDownloadUrlMd5(0);
            strArr[1] = serviceApp2.getDownloadUrlMd5(2);
            strArr[2] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(0) : null;
            if (upgradeInfo != null) {
                str = upgradeInfo.getDownloadUrlMd5(1);
            }
            strArr[3] = str;
            StateUtils.handleClick(UiUtils.getActivity(getContext()), targetUrl.downloadKeys(strArr).build(), view);
        }
    }

    @Override // com.coolapk.market.viewholder.StateViewHolder, com.coolapk.market.util.RVStateEventChangedAdapter.IStateViewHolder
    public boolean onStateEventChanged(Event event) {
        boolean z;
        EntityCard entityCard = this.card;
        if (entityCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        List<Entity> entities = entityCard.getEntities();
        Intrinsics.checkNotNull(entities);
        Intrinsics.checkNotNullExpressionValue(entities, "card.entities!!");
        List<Entity> list = entities;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (T t : list) {
                if (!(t instanceof ServiceApp) || !StateViewHolder.isEventBelongTo(event, (ServiceApp) t)) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }
}
