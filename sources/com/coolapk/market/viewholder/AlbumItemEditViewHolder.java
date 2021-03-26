package com.coolapk.market.viewholder;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemAlbumAppEditBinding;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.model.SimpleAlbumItem;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.album.AlbumItemViewModel;
import com.coolapk.market.view.album.EditDialog;
import com.coolapk.market.view.album.albumv8.AlbumEditListFragment;
import com.coolapk.market.widget.touchhelper.ItemTouchHelperViewHolder;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 *2\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\u00020\u00042\u00020\u0005:\u0003*+,Ba\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0015j\b\u0012\u0004\u0012\u00020\u0003`\u0016¢\u0006\u0002\u0010\u0017J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u0017J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\u0018\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u001dH\u0016J\b\u0010)\u001a\u00020\u001dH\u0002R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0015j\b\u0012\u0004\u0012\u00020\u0003`\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/coolapk/market/viewholder/AlbumItemEditViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemAlbumAppEditBinding;", "Lcom/coolapk/market/model/AlbumItem;", "Lcom/coolapk/market/widget/touchhelper/ItemTouchHelperViewHolder;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "callBack", "Lcom/coolapk/market/viewholder/AlbumItemEditViewHolder$TouchCallBack;", "mAlbum", "Lcom/coolapk/market/model/Album;", "albumItems", "", "mFragmentManager", "Landroidx/fragment/app/FragmentManager;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "delList", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "(Lcom/coolapk/market/viewholder/AlbumItemEditViewHolder$TouchCallBack;Lcom/coolapk/market/model/Album;Ljava/util/List;Landroidx/fragment/app/FragmentManager;Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;Ljava/util/HashSet;)V", "mAlbumItem", "mBinding", "viewModel", "Lcom/coolapk/market/view/album/AlbumItemViewModel;", "bindToContent", "", "data", "editComment", "onCheckedChanged", "buttonView", "Landroid/widget/CompoundButton;", "isChecked", "", "onItemClear", "pos", "", "onItemSelected", "pickApp", "Companion", "ItemTouch", "TouchCallBack", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumItemEditViewHolder.kt */
public final class AlbumItemEditViewHolder extends GenericBindHolder<ItemAlbumAppEditBinding, AlbumItem> implements ItemTouchHelperViewHolder, CompoundButton.OnCheckedChangeListener {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558584;
    private final List<AlbumItem> albumItems;
    private final TouchCallBack callBack;
    private final HashSet<AlbumItem> delList;
    private final Album mAlbum;
    private AlbumItem mAlbumItem;
    private ItemAlbumAppEditBinding mBinding;
    private final FragmentManager mFragmentManager;
    private AlbumItemViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/viewholder/AlbumItemEditViewHolder$TouchCallBack;", "", "touch", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AlbumItemEditViewHolder.kt */
    public interface TouchCallBack {
        void touch(RecyclerView.ViewHolder viewHolder);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.coolapk.market.model.AlbumItem> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlbumItemEditViewHolder(TouchCallBack touchCallBack, Album album, List<? extends AlbumItem> list, FragmentManager fragmentManager, View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, HashSet<AlbumItem> hashSet) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(touchCallBack, "callBack");
        Intrinsics.checkNotNullParameter(album, "mAlbum");
        Intrinsics.checkNotNullParameter(list, "albumItems");
        Intrinsics.checkNotNullParameter(fragmentManager, "mFragmentManager");
        Intrinsics.checkNotNullParameter(hashSet, "delList");
        this.callBack = touchCallBack;
        this.mAlbum = album;
        this.albumItems = list;
        this.mFragmentManager = fragmentManager;
        this.delList = hashSet;
    }

    public void bindToContent(AlbumItem albumItem) {
        this.mAlbumItem = albumItem;
        this.mBinding = (ItemAlbumAppEditBinding) getBinding();
        AlbumItemViewModel albumItemViewModel = new AlbumItemViewModel(getContext());
        this.viewModel = albumItemViewModel;
        Intrinsics.checkNotNull(albumItemViewModel);
        albumItemViewModel.setAlbumItem(this.mAlbumItem);
        ItemAlbumAppEditBinding itemAlbumAppEditBinding = this.mBinding;
        Intrinsics.checkNotNull(itemAlbumAppEditBinding);
        itemAlbumAppEditBinding.setModel(this.viewModel);
        ItemAlbumAppEditBinding itemAlbumAppEditBinding2 = this.mBinding;
        Intrinsics.checkNotNull(itemAlbumAppEditBinding2);
        CheckBox checkBox = itemAlbumAppEditBinding2.appCheckView;
        Intrinsics.checkNotNullExpressionValue(checkBox, "mBinding!!.appCheckView");
        checkBox.setChecked(CollectionsKt.contains(this.delList, albumItem));
        ItemAlbumAppEditBinding itemAlbumAppEditBinding3 = this.mBinding;
        Intrinsics.checkNotNull(itemAlbumAppEditBinding3);
        ImageView imageView = itemAlbumAppEditBinding3.noteEdit;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding!!.noteEdit");
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        imageView.setVisibility(TextUtils.equals(this.mAlbum.getUid(), loginSession.getUid()) ? 0 : 8);
        ItemAlbumAppEditBinding itemAlbumAppEditBinding4 = this.mBinding;
        Intrinsics.checkNotNull(itemAlbumAppEditBinding4);
        itemAlbumAppEditBinding4.appCheckView.setOnCheckedChangeListener(this);
        ItemAlbumAppEditBinding itemAlbumAppEditBinding5 = this.mBinding;
        Intrinsics.checkNotNull(itemAlbumAppEditBinding5);
        ViewUtil.clickListener(itemAlbumAppEditBinding5.noteEdit, new AlbumItemEditViewHolder$bindToContent$1(this));
        ItemAlbumAppEditBinding itemAlbumAppEditBinding6 = this.mBinding;
        Intrinsics.checkNotNull(itemAlbumAppEditBinding6);
        ViewUtil.clickListener(itemAlbumAppEditBinding6.cardView, new AlbumItemEditViewHolder$bindToContent$2(this));
        ItemAlbumAppEditBinding itemAlbumAppEditBinding7 = this.mBinding;
        Intrinsics.checkNotNull(itemAlbumAppEditBinding7);
        ViewUtil.clickListener(itemAlbumAppEditBinding7.appCommentView, new AlbumItemEditViewHolder$bindToContent$3(this));
        ItemAlbumAppEditBinding itemAlbumAppEditBinding8 = this.mBinding;
        Intrinsics.checkNotNull(itemAlbumAppEditBinding8);
        itemAlbumAppEditBinding8.orderEdit.setOnTouchListener(new ItemTouch(this, this));
        ItemAlbumAppEditBinding itemAlbumAppEditBinding9 = this.mBinding;
        Intrinsics.checkNotNull(itemAlbumAppEditBinding9);
        itemAlbumAppEditBinding9.executePendingBindings();
    }

    /* access modifiers changed from: private */
    public final void pickApp() {
        if (CollectionsKt.contains(this.delList, this.mAlbumItem)) {
            ItemAlbumAppEditBinding itemAlbumAppEditBinding = this.mBinding;
            Intrinsics.checkNotNull(itemAlbumAppEditBinding);
            CheckBox checkBox = itemAlbumAppEditBinding.appCheckView;
            Intrinsics.checkNotNullExpressionValue(checkBox, "mBinding!!.appCheckView");
            checkBox.setChecked(false);
            HashSet<AlbumItem> hashSet = this.delList;
            AlbumItem albumItem = this.mAlbumItem;
            Objects.requireNonNull(hashSet, "null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
            TypeIntrinsics.asMutableCollection(hashSet).remove(albumItem);
        } else {
            HashSet<AlbumItem> hashSet2 = this.delList;
            AlbumItem albumItem2 = this.mAlbumItem;
            Intrinsics.checkNotNull(albumItem2);
            hashSet2.add(albumItem2);
            ItemAlbumAppEditBinding itemAlbumAppEditBinding2 = this.mBinding;
            Intrinsics.checkNotNull(itemAlbumAppEditBinding2);
            CheckBox checkBox2 = itemAlbumAppEditBinding2.appCheckView;
            Intrinsics.checkNotNullExpressionValue(checkBox2, "mBinding!!.appCheckView");
            checkBox2.setChecked(true);
        }
        DataBindingComponent component = getComponent();
        LifecycleOwner lifecycleOwner = null;
        if (!(component instanceof FragmentBindingComponent)) {
            component = null;
        }
        FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
        LifecycleOwner lifecycleOwner2 = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
        if (lifecycleOwner2 instanceof AlbumEditListFragment) {
            lifecycleOwner = lifecycleOwner2;
        }
        AlbumEditListFragment albumEditListFragment = (AlbumEditListFragment) lifecycleOwner;
        if (albumEditListFragment != null) {
            albumEditListFragment.delListChange();
        }
    }

    /* access modifiers changed from: private */
    public final void editComment() {
        EditDialog newInstance = EditDialog.newInstance(this.mAlbumItem);
        newInstance.setViewModel(this.viewModel);
        newInstance.show(this.mFragmentManager, (String) null);
    }

    @Override // com.coolapk.market.widget.touchhelper.ItemTouchHelperViewHolder
    public void onItemSelected() {
        this.itemView.setBackgroundColor(-3355444);
    }

    @Override // com.coolapk.market.widget.touchhelper.ItemTouchHelperViewHolder
    public void onItemClear(int i) {
        int i2 = 0;
        this.itemView.setBackgroundColor(0);
        ArrayList arrayList = new ArrayList();
        int size = this.albumItems.size();
        while (i2 < size) {
            SimpleAlbumItem simpleAlbumItem = new SimpleAlbumItem();
            simpleAlbumItem.setPackageName(this.albumItems.get(i2).getPackageName());
            i2++;
            simpleAlbumItem.setDisplayOrder(i2);
            arrayList.add(simpleAlbumItem);
        }
        DataManager.getInstance().editApkDisplayOrder(this.mAlbum.getAlbumId(), new Gson().toJson(arrayList)).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new AlbumItemEditViewHolder$onItemClear$1(this));
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "buttonView");
        if (!UiUtils.isInvalidPosition(getAdapterPosition())) {
            if (z) {
                if (!CollectionsKt.contains(this.delList, this.mAlbumItem)) {
                    HashSet<AlbumItem> hashSet = this.delList;
                    AlbumItem albumItem = this.mAlbumItem;
                    Intrinsics.checkNotNull(albumItem);
                    hashSet.add(albumItem);
                }
            } else if (CollectionsKt.contains(this.delList, this.mAlbumItem)) {
                HashSet<AlbumItem> hashSet2 = this.delList;
                AlbumItem albumItem2 = this.mAlbumItem;
                Objects.requireNonNull(hashSet2, "null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                TypeIntrinsics.asMutableCollection(hashSet2).remove(albumItem2);
            }
            DataBindingComponent component = getComponent();
            LifecycleOwner lifecycleOwner = null;
            if (!(component instanceof FragmentBindingComponent)) {
                component = null;
            }
            FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
            LifecycleOwner lifecycleOwner2 = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
            if (lifecycleOwner2 instanceof AlbumEditListFragment) {
                lifecycleOwner = lifecycleOwner2;
            }
            AlbumEditListFragment albumEditListFragment = (AlbumEditListFragment) lifecycleOwner;
            if (albumEditListFragment != null) {
                albumEditListFragment.delListChange();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/viewholder/AlbumItemEditViewHolder$ItemTouch;", "Landroid/view/View$OnTouchListener;", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Lcom/coolapk/market/viewholder/AlbumItemEditViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AlbumItemEditViewHolder.kt */
    public final class ItemTouch implements View.OnTouchListener {
        private final RecyclerView.ViewHolder holder;
        final /* synthetic */ AlbumItemEditViewHolder this$0;

        public ItemTouch(AlbumItemEditViewHolder albumItemEditViewHolder, RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(viewHolder, "holder");
            this.this$0 = albumItemEditViewHolder;
            this.holder = viewHolder;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(view, "v");
            Intrinsics.checkNotNullParameter(motionEvent, "event");
            if (motionEvent.getAction() != 0) {
                return false;
            }
            this.this$0.callBack.touch(this.holder);
            return false;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/AlbumItemEditViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AlbumItemEditViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
