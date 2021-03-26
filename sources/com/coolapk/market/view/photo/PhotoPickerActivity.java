package com.coolapk.market.view.photo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.databinding.ItemPhotoDirectoryBinding;
import com.coolapk.market.databinding.ItemPhotoPickerBinding;
import com.coolapk.market.databinding.PhotoPickerBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.model.Product;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.CoolFileUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.feedv8.FeedArgsFactory;
import com.coolapk.market.view.feedv8.FeedArgsFactoryKt;
import com.coolapk.market.view.photo.loader.Photo;
import com.coolapk.market.view.photo.loader.PhotoDirectory;
import com.coolapk.market.view.photo.loader.PhotoGalleryUtils;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.AdapterListChangedCallback;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.Toast;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func0;

public class PhotoPickerActivity extends BaseActivity {
    public static final String ACTION_TYPE_COOLPIC = "action_coolpic";
    public static final String ACTION_TYPE_MESSAGE = "action_message";
    public static final String ACTION_TYPE_PRODUCT = "action_product_photo";
    public static final String ACTION_TYPE_RETURN = "action_return";
    public static final int DEFAULT_MULTI_PICK_COUNT = 9;
    public static final int DEFAULT_SINGLE_PICK_COUNT = 1;
    public static final String EXTRA_ACTION_TYPE = "ACTION_TYPE";
    public static final String EXTRA_COUNT_DOWN = "EXTRA_COUNT_DOWN";
    public static final String EXTRA_COUNT_DOWN_MAX = "EXTRA_COUNT_DOWN_MAX";
    public static final String EXTRA_DATA = "EXTRA_DATA";
    public static final String EXTRA_MAX_PICK_COUNT = "MAX_PICK_COUNT";
    public static final String EXTRA_PICKED_PHOTO_PATHS = "PICKED_PHOTO_PATHS";
    public static final int REQUEST_PICK = 3925;
    private boolean inMessage;
    private PhotoPickerAdapter mAdapter;
    private PhotoPickerBinding mBinding;
    private ContextBindingComponent mComponent;
    private PhotoDirectory mCurrentDirectory;
    private DirectoryAdapter mDirectoryAdapter;
    private LayoutInflater mInflater;
    private Subscription mLoadDataSub;
    private List<PhotoDirectory> mPhotoDirectoryList;
    private ArrayList<String> mPickedPhotoPath;
    private int maxPickCount;

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void initSearchMenu() {
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarDarkMode() {
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mBinding = (PhotoPickerBinding) DataBindingUtil.setContentView(this, 2131559080);
        this.mComponent = new ContextBindingComponent(this);
        this.mInflater = LayoutInflater.from(getActivity());
        this.inMessage = getIntent().getBooleanExtra("action_message", false);
        setSupportActionBar(this.mBinding.toolbar);
        this.mBinding.toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            /* class com.coolapk.market.view.photo.PhotoPickerActivity.AnonymousClass1 */

            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId != 2131361885) {
                    if (itemId == 2131361943) {
                        PhotoPickerActivity.this.setPickResultAndFinishActivity();
                    } else if (itemId == 2131361945 && !PhotoPickerActivity.this.mPickedPhotoPath.isEmpty()) {
                        ActionManager.startPhotoViewActivity(PhotoPickerActivity.this.getActivity(), (String[]) PhotoPickerActivity.this.mPickedPhotoPath.toArray(new String[PhotoPickerActivity.this.mPickedPhotoPath.size()]), (String[]) null, 0);
                    }
                } else if (PhotoPickerActivity.this.mPickedPhotoPath.size() == 0 && PhotoPickerActivity.this.maxPickCount == 1) {
                    Toast.show(PhotoPickerActivity.this.getActivity(), 2131886924);
                } else {
                    PhotoPickerActivity.this.setPickResultAndFinishActivity();
                }
                return false;
            }
        });
        ThemeUtils.setNavigationBarColor(getActivity(), 1711276032);
        this.mBinding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.photo.PhotoPickerActivity.AnonymousClass2 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PhotoPickerActivity.this.onBackPressed();
            }
        });
        this.mBinding.contentView.addOnInsetChangeListener(new DrawSystemBarFrameLayout.OnInsetChangeListener() {
            /* class com.coolapk.market.view.photo.PhotoPickerActivity.AnonymousClass3 */

            @Override // com.coolapk.market.widget.DrawSystemBarFrameLayout.OnInsetChangeListener
            public void onInsetChange(Rect rect) {
                PhotoPickerActivity.this.mBinding.appBar.setPadding(0, rect.top, 0, 0);
                PhotoPickerActivity.this.mBinding.recyclerView.setPadding(0, rect.top + UiUtils.getActionBarSize(PhotoPickerActivity.this.getActivity()), 0, DisplayUtils.dp2px(PhotoPickerActivity.this.getActivity(), 48.0f) + rect.bottom);
            }
        });
        this.mBinding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        this.mBinding.recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            /* class com.coolapk.market.view.photo.PhotoPickerActivity.AnonymousClass4 */
            int divider;

            {
                this.divider = DisplayUtils.dp2px(PhotoPickerActivity.this.getActivity(), 1.0f);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                super.getItemOffsets(rect, view, recyclerView, state);
                int i = this.divider;
                rect.set(i, i, i, i);
            }
        });
        ViewUtil.doubleClickListener(this.mBinding.toolbar, new ViewUtil.OnDoubleClickListener() {
            /* class com.coolapk.market.view.photo.PhotoPickerActivity.AnonymousClass5 */

            @Override // com.coolapk.market.util.ViewUtil.OnDoubleClickListener
            public boolean onDoubleClick(View view) {
                UiUtils.fastScrollToTop(PhotoPickerActivity.this.mBinding.recyclerView);
                return true;
            }
        });
        this.mBinding.bottomClickView.setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.photo.PhotoPickerActivity.AnonymousClass6 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PhotoPickerActivity.this.mBinding.listView.isShown()) {
                    PhotoPickerActivity.this.hidePhotoDirectory();
                } else {
                    PhotoPickerActivity.this.showPhotoDirectory();
                }
            }
        });
        this.mBinding.externalImage.setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.photo.PhotoPickerActivity.AnonymousClass7 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PhotoPickerActivity.this.getActivity().startActivityForResult(new Intent("android.intent.action.GET_CONTENT").setType("image/*"), 3925);
            }
        });
        this.maxPickCount = getIntent().getIntExtra("MAX_PICK_COUNT", 9);
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("PICKED_PHOTO_PATHS");
        this.mPickedPhotoPath = stringArrayListExtra;
        if (CollectionUtils.isEmpty(stringArrayListExtra)) {
            this.mPickedPhotoPath = new ArrayList<>();
        }
        updateTitle();
        this.mAdapter = new PhotoPickerAdapter();
        this.mBinding.recyclerView.setAdapter(this.mAdapter);
        loadData();
    }

    /* access modifiers changed from: private */
    public void showPhotoDirectory() {
        if (!CollectionUtils.isEmpty(this.mPhotoDirectoryList)) {
            ListView listView = this.mBinding.listView;
            if (this.mDirectoryAdapter == null) {
                DirectoryAdapter directoryAdapter = new DirectoryAdapter();
                this.mDirectoryAdapter = directoryAdapter;
                listView.setAdapter((ListAdapter) directoryAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    /* class com.coolapk.market.view.photo.PhotoPickerActivity.AnonymousClass8 */

                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        PhotoPickerActivity photoPickerActivity = PhotoPickerActivity.this;
                        photoPickerActivity.switchPhotoDirectory((PhotoDirectory) photoPickerActivity.mPhotoDirectoryList.get(i));
                        PhotoPickerActivity.this.hidePhotoDirectory();
                    }
                });
                this.mBinding.directoryView.setOnClickListener(new View.OnClickListener() {
                    /* class com.coolapk.market.view.photo.PhotoPickerActivity.AnonymousClass9 */

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PhotoPickerActivity.this.hidePhotoDirectory();
                    }
                });
            }
            DisplayMetrics displayMetrics = getActivity().getResources().getDisplayMetrics();
            int i = displayMetrics.heightPixels > displayMetrics.widthPixels ? displayMetrics.widthPixels : displayMetrics.heightPixels;
            ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
            if (layoutParams.height != i) {
                layoutParams.height = i;
                listView.setLayoutParams(layoutParams);
            }
            this.mBinding.directoryView.setClickable(true);
            this.mDirectoryAdapter.notifyDataSetChanged();
            this.mBinding.listView.setTranslationY(0.0f);
            TransitionManager.beginDelayedTransition(this.mBinding.directoryView, new Slide());
            this.mBinding.directoryView.setBackgroundColor(855638016);
            this.mBinding.listView.setVisibility(0);
            this.mBinding.listView.setDivider(ResourceUtils.getDrawable(getActivity(), 2131231052));
            this.mBinding.textView.setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
            this.mBinding.imageView.setImageTintList(ColorStateList.valueOf(AppHolder.getAppTheme().getTextColorPrimary()));
            this.mBinding.externalImage.setImageTintList(ColorStateList.valueOf(AppHolder.getAppTheme().getTextColorPrimary()));
            this.mBinding.bottomView.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
            ThemeUtils.setNavigationBarColor(getActivity(), ColorUtils.darkerColor(AppHolder.getAppTheme().getContentBackgroundColor(), 0.85f));
            this.mBinding.dividerView.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void hidePhotoDirectory() {
        this.mBinding.listView.animate().translationY((float) this.mBinding.listView.getHeight()).setListener(new AnimatorListenerAdapter() {
            /* class com.coolapk.market.view.photo.PhotoPickerActivity.AnonymousClass10 */

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                PhotoPickerActivity.this.mBinding.directoryView.setClickable(false);
                PhotoPickerActivity.this.mBinding.directoryView.setBackgroundColor(0);
                PhotoPickerActivity.this.mBinding.dividerView.setVisibility(4);
                PhotoPickerActivity.this.mBinding.listView.setVisibility(8);
                PhotoPickerActivity.this.mBinding.bottomView.setBackgroundColor(1711276032);
                ThemeUtils.setNavigationBarColor(PhotoPickerActivity.this.getActivity(), 1711276032);
                PhotoPickerActivity.this.mBinding.textView.setTextColor(-1);
                PhotoPickerActivity.this.mBinding.imageView.setImageTintList(ColorStateList.valueOf(-1));
                PhotoPickerActivity.this.mBinding.externalImage.setImageTintList(ColorStateList.valueOf(-1));
            }
        }).start();
    }

    private void loadData() {
        this.mPhotoDirectoryList = new ArrayList();
        this.mLoadDataSub = Observable.defer(new Func0<Observable<List<PhotoDirectory>>>() {
            /* class com.coolapk.market.view.photo.PhotoPickerActivity.AnonymousClass13 */

            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public Observable<List<PhotoDirectory>> call() {
                return Observable.just(PhotoGalleryUtils.getPhotos(PhotoPickerActivity.this.getActivity()));
            }
        }).doOnNext(new Action1<List<PhotoDirectory>>() {
            /* class com.coolapk.market.view.photo.PhotoPickerActivity.AnonymousClass12 */

            public void call(List<PhotoDirectory> list) {
                if (list == null || list.isEmpty()) {
                    throw new RuntimeException("没有找到任何图片");
                }
            }
        }).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new EmptySubscriber<List<PhotoDirectory>>() {
            /* class com.coolapk.market.view.photo.PhotoPickerActivity.AnonymousClass11 */

            public void onNext(List<PhotoDirectory> list) {
                super.onNext((AnonymousClass11) list);
                PhotoPickerActivity.this.mPhotoDirectoryList.clear();
                PhotoPickerActivity.this.mPhotoDirectoryList.addAll(list);
                PhotoPickerActivity.this.switchPhotoDirectory(list.get(0));
            }

            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
            public void onError(Throwable th) {
                Toast.error(PhotoPickerActivity.this.getActivity(), th);
            }
        });
    }

    private void updateTitle() {
        setTitle(getString(2131886926, new Object[]{String.format(Locale.getDefault(), "(%d/%d)", Integer.valueOf(this.mPickedPhotoPath.size()), Integer.valueOf(this.maxPickCount))}));
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131623966, menu);
        setPreviewMenuVisible();
        return true;
    }

    /* access modifiers changed from: private */
    public void switchPhotoDirectory(PhotoDirectory photoDirectory) {
        PhotoDirectory photoDirectory2 = this.mCurrentDirectory;
        if (photoDirectory2 == null || !photoDirectory2.equals(photoDirectory)) {
            this.mBinding.textView.setText(photoDirectory.getName());
            this.mCurrentDirectory = photoDirectory;
            this.mAdapter.clearData();
            this.mAdapter.addData(photoDirectory.getPhotos());
            UiUtils.fastScrollToTop(this.mBinding.recyclerView);
        }
    }

    /* access modifiers changed from: private */
    public boolean onImagePick(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.mPickedPhotoPath.contains(str)) {
            this.mPickedPhotoPath.remove(str);
            setPreviewMenuVisible();
            updateTitle();
            return false;
        } else if (PhotoGalleryUtils.checkImgCorrupted(str)) {
            Toast.show(getActivity(), 2131886631);
            return false;
        } else if (str.endsWith(".gif") && new File(str).length() > 20971520) {
            Toast.show(getActivity(), "抱歉，图片大小不能大于20M");
            return false;
        } else if (this.mPickedPhotoPath.size() < this.maxPickCount) {
            int intExtra = getIntent().getIntExtra("EXTRA_COUNT_DOWN_MAX", -1);
            if (intExtra > 0 && (i = this.maxPickCount) > 1) {
                int size = (i - this.mPickedPhotoPath.size()) - 1;
                if (size == 0) {
                    Toast.show(getActivity(), String.format(Locale.getDefault(), "最多添加%d张图，无法继续添加图片", Integer.valueOf(intExtra)));
                } else if (size == 5 || size == 10) {
                    Toast.show(getActivity(), String.format(Locale.getDefault(), "还可以添加%d张图", Integer.valueOf(size)));
                }
            }
            this.mPickedPhotoPath.add(str);
            setPreviewMenuVisible();
            updateTitle();
            if (this.maxPickCount == 1) {
                if (this.inMessage) {
                    setPostMenuVisible();
                } else {
                    setPickResultAndFinishActivity();
                }
            }
            return true;
        } else {
            Toast.show(getActivity(), getString(2131886925, new Object[]{Integer.valueOf(this.maxPickCount)}));
            return false;
        }
    }

    private void setPreviewMenuVisible() {
        MenuItem findItem = this.mBinding.toolbar.getMenu().findItem(2131361945);
        if (findItem != null) {
            findItem.setVisible(!this.mPickedPhotoPath.isEmpty());
        }
    }

    private void setPostMenuVisible() {
        MenuItem findItem = this.mBinding.toolbar.getMenu().findItem(2131361943);
        if (findItem != null) {
            findItem.setVisible(!this.mPickedPhotoPath.isEmpty() && this.inMessage);
            if (this.inMessage) {
                findItem.setTitle("发送");
            } else {
                findItem.setTitle("发布");
            }
        }
        MenuItem findItem2 = this.mBinding.toolbar.getMenu().findItem(2131361885);
        if (findItem2 != null) {
            findItem2.setVisible(true ^ this.inMessage);
        }
    }

    /* access modifiers changed from: private */
    public void setPickResultAndFinishActivity() {
        String stringExtra = getIntent().getStringExtra("ACTION_TYPE");
        if ("action_coolpic".equals(stringExtra)) {
            FeedMultiPart multiPartForCoolPic = FeedArgsFactory.multiPartForCoolPic(getActivity());
            FeedUIConfig uiConfigForCoolPic = FeedArgsFactory.uiConfigForCoolPic(getActivity());
            Iterator<String> it2 = this.mPickedPhotoPath.iterator();
            while (it2.hasNext()) {
                multiPartForCoolPic.imageUriList().add(ImageUrl.create(CoolFileUtils.wrap(it2.next()), null));
            }
            ActionManager.startSubmitFeedV8Activity(getActivity(), uiConfigForCoolPic, multiPartForCoolPic);
            finish();
        } else if ("action_product_photo".equals(stringExtra)) {
            Product product = (Product) getIntent().getParcelableExtra("EXTRA_DATA");
            FeedMultiPart build = FeedArgsFactoryKt.applyProduct(FeedArgsFactory.multiPartForFeed(), product).insertProductMedia(true).build();
            FeedUIConfig build2 = FeedArgsFactoryKt.applyProduct(FeedArgsFactory.uiConfigForFeed(this), this, product).title("发产品图").build();
            Iterator<String> it3 = this.mPickedPhotoPath.iterator();
            while (it3.hasNext()) {
                build.imageUriList().add(ImageUrl.create(CoolFileUtils.wrap(it3.next()), null));
            }
            ActionManager.startSubmitFeedV8Activity(this, build2, build);
            finish();
        } else {
            Intent intent = new Intent();
            if (this.mPickedPhotoPath.size() > 0) {
                intent.setData(Uri.parse(CoolFileUtils.wrap(this.mPickedPhotoPath.get(0))));
            }
            intent.putExtra("PICKED_PHOTO_PATHS", this.mPickedPhotoPath);
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mBinding.listView.isShown()) {
            hidePhotoDirectory();
            return;
        }
        PhotoDirectory photoDirectory = this.mCurrentDirectory;
        if (photoDirectory == null || photoDirectory == this.mPhotoDirectoryList.get(0)) {
            super.onBackPressed();
        } else {
            switchPhotoDirectory(this.mPhotoDirectoryList.get(0));
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mLoadDataSub.unsubscribe();
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        PhotoDirectory photoDirectory;
        int indexOf;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 3925) {
            String path = BitmapUtil.getPath(getActivity(), intent.getData());
            if (!TextUtils.isEmpty(path) && onImagePick(path) && !isFinishing() && (photoDirectory = this.mCurrentDirectory) != null && (indexOf = photoDirectory.getPhotoPaths().indexOf(path)) >= 0) {
                this.mAdapter.notifyItemChanged(indexOf);
            }
        }
    }

    private class PhotoPickerAdapter extends RecyclerView.Adapter<PhotoViewHolder> {
        private AdapterListChangedCallback<ObservableList<Photo>> callback;
        private ObservableArrayList<Photo> dataList;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 2131558851;
        }

        private PhotoPickerAdapter() {
            this.dataList = new ObservableArrayList<>();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
            if (this.callback == null) {
                AdapterListChangedCallback<ObservableList<Photo>> adapterListChangedCallback = new AdapterListChangedCallback<>(this);
                this.callback = adapterListChangedCallback;
                this.dataList.addOnListChangedCallback(adapterListChangedCallback);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
            super.onDetachedFromRecyclerView(recyclerView);
            this.dataList.removeOnListChangedCallback(this.callback);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public PhotoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = PhotoPickerActivity.this.mInflater.inflate(2131558851, viewGroup, false);
            PhotoPickerActivity photoPickerActivity = PhotoPickerActivity.this;
            return new PhotoViewHolder(inflate, photoPickerActivity.mComponent, new ItemActionHandler() {
                /* class com.coolapk.market.view.photo.PhotoPickerActivity.PhotoPickerAdapter.AnonymousClass1 */

                @Override // com.coolapk.market.viewholder.ItemActionHandler
                public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                    int adapterPosition;
                    super.onItemClick(viewHolder, view);
                    if (view.getId() == 2131363139 && (adapterPosition = viewHolder.getAdapterPosition()) >= 0) {
                        List list = PhotoPickerAdapter.this.dataList;
                        if (list.size() > 1024) {
                            list = PhotoPickerAdapter.this.dataList.subList(adapterPosition > 512 ? adapterPosition - 512 : 0, (list.size() + -1) - adapterPosition > 512 ? adapterPosition + 512 : list.size());
                            if (adapterPosition > 512) {
                                adapterPosition = 512;
                            }
                        }
                        int size = list.size();
                        String[] strArr = new String[size];
                        for (int i = 0; i < size; i++) {
                            strArr[i] = CoolFileUtils.wrap(((Photo) list.get(i)).getPath());
                        }
                        ActionManager.startPhotoViewActivity(PhotoPickerActivity.this.getActivity(), strArr, (String[]) null, adapterPosition);
                    }
                }
            });
        }

        public void onBindViewHolder(PhotoViewHolder photoViewHolder, int i) {
            photoViewHolder.bindTo(this.dataList.get(i));
        }

        public void clearData() {
            this.dataList.clear();
        }

        public void addData(List<Photo> list) {
            this.dataList.addAll(list);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.dataList.size();
        }
    }

    private class PhotoViewHolder extends BindingViewHolder {
        public static final int LAYOUT_ID = 2131558851;
        private Photo photo;

        public PhotoViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            ItemPhotoPickerBinding itemPhotoPickerBinding = (ItemPhotoPickerBinding) getBinding();
            Photo photo2 = (Photo) obj;
            this.photo = photo2;
            itemPhotoPickerBinding.setPath(CoolFileUtils.wrap(photo2.getPath()));
            itemPhotoPickerBinding.setSelected(Boolean.valueOf(PhotoPickerActivity.this.mPickedPhotoPath.contains(this.photo.getPath())));
            itemPhotoPickerBinding.executePendingBindings();
            itemPhotoPickerBinding.cardView.setOnClickListener(this);
            itemPhotoPickerBinding.presenterView.setOnClickListener(this);
            CharSequence format = DateFormat.format("yyyy年MM月dd日 hh.mm分", this.photo.getDateTaken() * 1000);
            FrameLayout frameLayout = itemPhotoPickerBinding.cardView;
            frameLayout.setContentDescription("图片 " + (getAdapterPosition() + 1) + " 拍摄时间 " + ((Object) format));
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            boolean onImagePick;
            super.onClick(view);
            int id = view.getId();
            if (id == 2131362200 || id == 2131362222) {
                ItemPhotoPickerBinding itemPhotoPickerBinding = (ItemPhotoPickerBinding) getBinding();
                Photo photo2 = this.photo;
                if (photo2 != null && itemPhotoPickerBinding.getSelected().booleanValue() != (onImagePick = PhotoPickerActivity.this.onImagePick(photo2.getPath()))) {
                    itemPhotoPickerBinding.setSelected(Boolean.valueOf(onImagePick));
                    itemPhotoPickerBinding.executePendingBindings();
                }
            }
        }
    }

    private class DirectoryAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return (long) i;
        }

        private DirectoryAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return PhotoPickerActivity.this.mPhotoDirectoryList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return PhotoPickerActivity.this.mPhotoDirectoryList.get(i);
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0038  */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x003b  */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x0016  */
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ItemPhotoDirectoryBinding itemPhotoDirectoryBinding;
            if (view != null) {
                try {
                    itemPhotoDirectoryBinding = (ItemPhotoDirectoryBinding) DataBindingUtil.bind(view, PhotoPickerActivity.this.mComponent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (itemPhotoDirectoryBinding == null) {
                    itemPhotoDirectoryBinding = (ItemPhotoDirectoryBinding) DataBindingUtil.inflate(PhotoPickerActivity.this.mInflater, 2131558850, viewGroup, false, PhotoPickerActivity.this.mComponent);
                }
                PhotoDirectory photoDirectory = (PhotoDirectory) getItem(i);
                itemPhotoDirectoryBinding.setPath(photoDirectory.getCoverPath() != null ? "" : CoolFileUtils.wrap(photoDirectory.getCoverPath()));
                itemPhotoDirectoryBinding.setSelected(Boolean.valueOf(PhotoPickerActivity.this.mCurrentDirectory.equals(photoDirectory)));
                itemPhotoDirectoryBinding.titleView.setText(photoDirectory.getName());
                itemPhotoDirectoryBinding.textView.setText(String.valueOf(photoDirectory.getPhotos().size()));
                return itemPhotoDirectoryBinding.getRoot();
            }
            itemPhotoDirectoryBinding = null;
            if (itemPhotoDirectoryBinding == null) {
            }
            PhotoDirectory photoDirectory = (PhotoDirectory) getItem(i);
            itemPhotoDirectoryBinding.setPath(photoDirectory.getCoverPath() != null ? "" : CoolFileUtils.wrap(photoDirectory.getCoverPath()));
            itemPhotoDirectoryBinding.setSelected(Boolean.valueOf(PhotoPickerActivity.this.mCurrentDirectory.equals(photoDirectory)));
            itemPhotoDirectoryBinding.titleView.setText(photoDirectory.getName());
            itemPhotoDirectoryBinding.textView.setText(String.valueOf(photoDirectory.getPhotos().size()));
            return itemPhotoDirectoryBinding.getRoot();
        }
    }
}
