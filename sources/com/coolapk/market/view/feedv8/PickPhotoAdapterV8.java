package com.coolapk.market.view.feedv8;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.databinding.ItemNewFeedImageBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.CoolFileUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.AdapterListChangedCallback;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action2;

public class PickPhotoAdapterV8 extends RecyclerView.Adapter<BindingViewHolder> {
    private static final ImageUrl ADD_BUTTON_IMAGE_URL = ImageUrl.create("", "");
    private int bindType = 0;
    private int compressFlag = 0;
    private Activity mActivity;
    private AdapterListChangedCallback<ObservableList<ImageUrl>> mCallback;
    private ContextBindingComponent mComponent;
    private boolean mEditTable;
    private ObservableArrayList<ImageUrl> mImageUrls;
    private Action0 mPhotoCountChangedListener;
    private Action2<Integer, List<String>> mPickPhotoClickListener;
    private RecyclerView mRecyclerView;
    private int maxPickCount = 9;

    public PickPhotoAdapterV8(Activity activity) {
        this.mActivity = activity;
        this.mImageUrls = new ObservableArrayList<>();
        AdapterListChangedCallback<ObservableList<ImageUrl>> adapterListChangedCallback = new AdapterListChangedCallback<>(this);
        this.mCallback = adapterListChangedCallback;
        this.mImageUrls.addOnListChangedCallback(adapterListChangedCallback);
        this.mComponent = new ContextBindingComponent(activity);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
        new ItemTouchHelper(new PickPhotoTouchHelper()).attachToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558834, viewGroup, false);
        if (i == 2131558834) {
            return new AddViewHolder(inflate, this.mComponent, null);
        }
        return new ImageViewHolder(inflate, this.mComponent, null);
    }

    public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
        bindingViewHolder.bindTo(((ImageUrl) this.mImageUrls.get(i)).getSourceUrl());
    }

    public void bindIndicator(BindingViewHolder bindingViewHolder) {
        if (bindingViewHolder instanceof ImageViewHolder) {
            ((ImageViewHolder) bindingViewHolder).bindIndicator();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.mImageUrls.get(i) == ADD_BUTTON_IMAGE_URL ? 2131558834 : 2131558835;
    }

    public void setPickPhotoClickListener(Action2<Integer, List<String>> action2) {
        this.mPickPhotoClickListener = action2;
    }

    public void setCompressFlag(int i) {
        this.compressFlag = i;
    }

    public void setBindType(int i) {
        this.bindType = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mImageUrls.size();
    }

    public void setEditTable(boolean z) {
        this.mEditTable = z;
        if (z) {
            ObservableArrayList<ImageUrl> observableArrayList = this.mImageUrls;
            ImageUrl imageUrl = ADD_BUTTON_IMAGE_URL;
            if (!observableArrayList.contains(imageUrl)) {
                this.mImageUrls.add(imageUrl);
                return;
            }
        }
        ObservableArrayList<ImageUrl> observableArrayList2 = this.mImageUrls;
        ImageUrl imageUrl2 = ADD_BUTTON_IMAGE_URL;
        if (observableArrayList2.contains(imageUrl2)) {
            this.mImageUrls.remove(imageUrl2);
        }
    }

    public void setInitList(List<ImageUrl> list) {
        if (this.mImageUrls.contains(ADD_BUTTON_IMAGE_URL)) {
            ObservableArrayList<ImageUrl> observableArrayList = this.mImageUrls;
            observableArrayList.addAll(observableArrayList.size() - 1, list);
        } else {
            this.mImageUrls.addAll(list);
        }
        this.mPhotoCountChangedListener.call();
    }

    public void setOnPhotoCountChangeListener(Action0 action0) {
        this.mPhotoCountChangedListener = action0;
    }

    public void setMaxPickCount(int i) {
        this.maxPickCount = i;
    }

    public void pickImage() {
        if (this.mEditTable && this.mPickPhotoClickListener != null) {
            ArrayList arrayList = new ArrayList();
            for (ImageUrl imageUrl : getImageUrls()) {
                arrayList.add(Uri.parse(imageUrl.getSourceUrl()).getPath());
            }
            this.mPickPhotoClickListener.call(Integer.valueOf(this.maxPickCount), arrayList);
        }
    }

    public List<ImageUrl> getImageUrls() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mImageUrls);
        arrayList.remove(ADD_BUTTON_IMAGE_URL);
        return arrayList;
    }

    public boolean isEmpty() {
        return this.mImageUrls.isEmpty() || (this.mImageUrls.size() == 1 && this.mImageUrls.get(0) == ADD_BUTTON_IMAGE_URL);
    }

    public void onPickedImageChange(final List<String> list) {
        if (CollectionUtils.isEmpty(list)) {
            list = new ArrayList<>();
        }
        final ProgressDialog progressDialog = new ProgressDialog(this.mActivity);
        progressDialog.setProgressStyle(0);
        progressDialog.setMessage(this.mActivity.getString(2131886928));
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        final ArrayList arrayList = new ArrayList(this.mImageUrls);
        final ArrayList arrayList2 = new ArrayList();
        List<ImageUrl> imageUrls = getImageUrls();
        this.mImageUrls.removeOnListChangedCallback(this.mCallback);
        Observable.create(new Observable.OnSubscribe(list, (List) Observable.from(getImageUrls()).map($$Lambda$PickPhotoAdapterV8$6iYLc_dp7PBMmMoWLDAhFm1fY1E.INSTANCE).toList().toBlocking().first(), imageUrls) {
            /* class com.coolapk.market.view.feedv8.$$Lambda$PickPhotoAdapterV8$H6iUw7hbqGZ1y3YzNGn2zBAPgg0 */
            public final /* synthetic */ List f$1;
            public final /* synthetic */ List f$2;
            public final /* synthetic */ List f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            @Override // rx.functions.Action1
            public final void call(Object obj) {
                PickPhotoAdapterV8.this.lambda$onPickedImageChange$1$PickPhotoAdapterV8(this.f$1, this.f$2, this.f$3, (Subscriber) obj);
            }
        }).compose(RxUtils.applyIOSchedulers()).doOnTerminate(new Action0() {
            /* class com.coolapk.market.view.feedv8.PickPhotoAdapterV8.AnonymousClass2 */

            @Override // rx.functions.Action0
            public void call() {
                progressDialog.dismiss();
                if (!arrayList2.contains(PickPhotoAdapterV8.ADD_BUTTON_IMAGE_URL) && arrayList2.size() < PickPhotoAdapterV8.this.maxPickCount) {
                    arrayList2.add(PickPhotoAdapterV8.ADD_BUTTON_IMAGE_URL);
                }
                PickPhotoAdapterV8.this.mImageUrls.clear();
                PickPhotoAdapterV8.this.mImageUrls.addAll(arrayList2);
                DiffUtil.calculateDiff(new DiffCallBack(arrayList, arrayList2), true).dispatchUpdatesTo(PickPhotoAdapterV8.this);
                PickPhotoAdapterV8.this.mImageUrls.addOnListChangedCallback(PickPhotoAdapterV8.this.mCallback);
                PickPhotoAdapterV8.this.mPhotoCountChangedListener.call();
            }
        }).subscribe((Subscriber) new EmptySubscriber<ImageUrl>() {
            /* class com.coolapk.market.view.feedv8.PickPhotoAdapterV8.AnonymousClass1 */
            int index = 0;

            public void onNext(ImageUrl imageUrl) {
                super.onNext((AnonymousClass1) imageUrl);
                if (imageUrl != null) {
                    arrayList2.add(imageUrl);
                }
                this.index++;
                progressDialog.setMessage(PickPhotoAdapterV8.this.mActivity.getString(2131886928) + String.format(Locale.getDefault(), "(%d/%d)", Integer.valueOf(this.index), Integer.valueOf(list.size())));
            }
        });
    }

    public /* synthetic */ void lambda$onPickedImageChange$1$PickPhotoAdapterV8(List list, List list2, List list3, Subscriber subscriber) {
        int i = 0;
        while (i < list.size()) {
            String str = (String) list.get(i);
            ImageUrl imageUrl = null;
            if (list2.contains(str)) {
                imageUrl = (ImageUrl) list3.get(list2.indexOf(str));
            } else if (str.startsWith("/")) {
                try {
                    imageUrl = BitmapUtil.compressImage(this.mActivity, CoolFileUtils.wrap(str), this.compressFlag).toBlocking().first();
                } catch (Throwable th) {
                    list.remove(i);
                    i--;
                    Toast.error(this.mActivity, th);
                }
            } else {
                imageUrl = ImageUrl.create(str, str);
            }
            if (imageUrl != null) {
                subscriber.onNext(imageUrl);
            }
            i++;
        }
        subscriber.onCompleted();
    }

    private class AddViewHolder extends BindingViewHolder {
        static final int TYPE = 2131558834;

        AddViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            ItemNewFeedImageBinding itemNewFeedImageBinding = (ItemNewFeedImageBinding) getBinding();
            itemNewFeedImageBinding.imageView.setImageResource(2131231115);
            itemNewFeedImageBinding.imageView.setScaleType(ImageView.ScaleType.CENTER);
            itemNewFeedImageBinding.imageView.setColorFilter(ResourceUtils.getColorInt(getContext(), 2131099891));
            ViewUtil.clickListener(itemNewFeedImageBinding.getRoot(), this);
            itemNewFeedImageBinding.closeView.setVisibility(8);
            itemNewFeedImageBinding.executePendingBindings();
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            super.onClick(view);
            PickPhotoAdapterV8.this.pickImage();
        }
    }

    private class ImageViewHolder extends BindingViewHolder {
        static final int TYPE = 2131558835;

        ImageViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            ItemNewFeedImageBinding itemNewFeedImageBinding = (ItemNewFeedImageBinding) getBinding();
            ViewUtil.clickListener(getBinding().getRoot(), this);
            AppHolder.getContextImageLoader().displayImage(PickPhotoAdapterV8.this.mActivity, (String) obj, itemNewFeedImageBinding.imageView);
            itemNewFeedImageBinding.closeView.setOnClickListener(this);
            int i = 0;
            boolean z = true;
            if (!(PickPhotoAdapterV8.this.bindType == 1 && getAdapterPosition() == 0)) {
                z = false;
            }
            itemNewFeedImageBinding.indicatorView.setText("封面");
            TextView textView = itemNewFeedImageBinding.indicatorView;
            if (!z) {
                i = 8;
            }
            textView.setVisibility(i);
            itemNewFeedImageBinding.executePendingBindings();
        }

        public void bindIndicator() {
            ((ItemNewFeedImageBinding) getBinding()).indicatorView.setText("封面");
            ((ItemNewFeedImageBinding) getBinding()).indicatorView.setVisibility(0);
        }

        public void deBindIndicator() {
            ((ItemNewFeedImageBinding) getBinding()).indicatorView.setText("");
            ((ItemNewFeedImageBinding) getBinding()).indicatorView.setVisibility(8);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            super.onClick(view);
            int id = view.getId();
            if (id == 2131362200) {
                ArrayList arrayList = new ArrayList();
                Iterator it2 = PickPhotoAdapterV8.this.mImageUrls.iterator();
                while (it2.hasNext()) {
                    ImageUrl imageUrl = (ImageUrl) it2.next();
                    if (imageUrl != PickPhotoAdapterV8.ADD_BUTTON_IMAGE_URL) {
                        arrayList.add(imageUrl);
                    }
                }
                String[] strArr = new String[arrayList.size()];
                Rect[] rectArr = new Rect[arrayList.size()];
                for (int i = 0; i < arrayList.size(); i++) {
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = PickPhotoAdapterV8.this.mRecyclerView.findViewHolderForAdapterPosition(i);
                    if (findViewHolderForAdapterPosition instanceof ImageViewHolder) {
                        rectArr[i] = ViewExtendsKt.getGlobalRect(findViewHolderForAdapterPosition.itemView);
                    }
                }
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    strArr[i2] = ((ImageUrl) arrayList.get(i2)).getSourceUrl();
                }
                ActionManager.startPhotoViewActivity(PickPhotoAdapterV8.this.mActivity, strArr, null, getAdapterPosition(), null, null, rectArr);
            } else if (id == 2131362257 && PickPhotoAdapterV8.this.mEditTable && getAdapterPosition() >= 0) {
                PickPhotoAdapterV8.this.mImageUrls.remove(getAdapterPosition());
                if (!PickPhotoAdapterV8.this.mImageUrls.contains(PickPhotoAdapterV8.ADD_BUTTON_IMAGE_URL) && PickPhotoAdapterV8.this.mImageUrls.size() < 9) {
                    PickPhotoAdapterV8.this.mImageUrls.add(PickPhotoAdapterV8.ADD_BUTTON_IMAGE_URL);
                }
                PickPhotoAdapterV8.this.mPhotoCountChangedListener.call();
            }
        }
    }

    private static class DiffCallBack extends DiffUtil.Callback {
        private List<ImageUrl> mNewDatas;
        private List<ImageUrl> mOldDatas;

        public DiffCallBack(List<ImageUrl> list, List<ImageUrl> list2) {
            this.mOldDatas = list;
            this.mNewDatas = list2;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            List<ImageUrl> list = this.mOldDatas;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            List<ImageUrl> list = this.mNewDatas;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int i, int i2) {
            return this.mOldDatas.get(i).equals(this.mNewDatas.get(i2));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int i, int i2) {
            return TextUtils.equals(this.mOldDatas.get(i).getSourceUrl(), this.mNewDatas.get(i2).getSourceUrl());
        }
    }

    private class PickPhotoTouchHelper extends ItemTouchHelper.Callback {
        private List<ImageUrl> mTempList;

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        }

        private PickPhotoTouchHelper() {
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return makeMovementFlags(15, 0);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            if (!canItemMove(viewHolder.getAdapterPosition()) || !canItemMove(viewHolder2.getAdapterPosition())) {
                return false;
            }
            doMoveAction(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
            if (PickPhotoAdapterV8.this.bindType == 1) {
                if (viewHolder.getAdapterPosition() == 0) {
                    if (viewHolder instanceof ImageViewHolder) {
                        ((ImageViewHolder) viewHolder).bindIndicator();
                    }
                    if (viewHolder2 instanceof ImageViewHolder) {
                        ((ImageViewHolder) viewHolder2).deBindIndicator();
                    }
                } else if (viewHolder2.getAdapterPosition() == 0) {
                    if (viewHolder2 instanceof ImageViewHolder) {
                        ((ImageViewHolder) viewHolder2).bindIndicator();
                    }
                    if (viewHolder instanceof ImageViewHolder) {
                        ((ImageViewHolder) viewHolder).deBindIndicator();
                    }
                } else {
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(0);
                    if (findViewHolderForAdapterPosition instanceof ImageViewHolder) {
                        ((ImageViewHolder) findViewHolderForAdapterPosition).bindIndicator();
                    }
                    if ((viewHolder instanceof ImageViewHolder) && (viewHolder2 instanceof ImageViewHolder)) {
                        ((ImageViewHolder) viewHolder).deBindIndicator();
                        ((ImageViewHolder) viewHolder2).deBindIndicator();
                    }
                }
            }
            return true;
        }

        private void doMoveAction(int i, int i2) {
            PickPhotoAdapterV8.this.mImageUrls.removeOnListChangedCallback(PickPhotoAdapterV8.this.mCallback);
            if (this.mTempList == null) {
                this.mTempList = new ArrayList();
            }
            List<ImageUrl> list = this.mTempList;
            list.addAll(PickPhotoAdapterV8.this.mImageUrls);
            PickPhotoAdapterV8.this.mImageUrls.add(i2, (ImageUrl) PickPhotoAdapterV8.this.mImageUrls.remove(i));
            DiffUtil.calculateDiff(new DiffCallBack(list, PickPhotoAdapterV8.this.mImageUrls), true).dispatchUpdatesTo(PickPhotoAdapterV8.this);
            PickPhotoAdapterV8.this.mImageUrls.addOnListChangedCallback(PickPhotoAdapterV8.this.mCallback);
            this.mTempList.clear();
        }

        private boolean canItemMove(int i) {
            return PickPhotoAdapterV8.this.mEditTable && i >= 0 && PickPhotoAdapterV8.this.mImageUrls.get(i) != PickPhotoAdapterV8.ADD_BUTTON_IMAGE_URL;
        }
    }
}
