package com.coolapk.market.view.wallpaper.coolpic;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager.widget.PagerAdapter;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemCoolpicDetailBinding;
import com.coolapk.market.event.FeedLikeEvent;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.ExtraExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.AppPictureSizeManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.LikeResult;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.PhotoUtils;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.FragmentStatePagerAdapter;
import com.coolapk.market.view.feed.reply.FeedDetailPresenter;
import com.coolapk.market.view.feed.reply.FeedDetailView;
import com.coolapk.market.view.photo.PhotoViewUrl;
import com.coolapk.market.view.photo.SaveImageDialog;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.v8.image.ImageArgs;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.view.ImageIndicatorView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import rx.Subscriber;

/* compiled from: CoolPicDetailViewHolder.kt */
public final class CoolPicDetailViewHolder extends GenericBindHolder<ItemCoolpicDetailBinding, Feed> implements FeedDetailView {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558669;
    private long activityInitTime;
    private FeedDetailPresenter feedPresenter;
    private int index;
    private boolean isCompress;
    private List<PhotoViewUrl> photoViewUrls;
    private int picIndex;

    public static final /* synthetic */ FeedDetailPresenter access$getFeedPresenter$p(CoolPicDetailViewHolder coolPicDetailViewHolder) {
        FeedDetailPresenter feedDetailPresenter = coolPicDetailViewHolder.feedPresenter;
        if (feedDetailPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
        }
        return feedDetailPresenter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoolPicDetailViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ItemCoolpicDetailBinding itemCoolpicDetailBinding = (ItemCoolpicDetailBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemCoolpicDetailBinding, "binding");
        itemCoolpicDetailBinding.setClick(this);
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailView
    public void onFollowAuthorResult(boolean z, Throwable th) {
        if (th != null) {
            Toast.error(getContext(), th);
            return;
        }
        FeedDetailPresenter feedDetailPresenter = this.feedPresenter;
        if (feedDetailPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
        }
        Feed feed = feedDetailPresenter.getFeed();
        Feed build = Feed.newBuilder(feed).userAction(UserAction.newBuilder(feed.getUserAction()).followAuthor(z ? 1 : 0).build()).build();
        FeedDetailPresenter feedDetailPresenter2 = this.feedPresenter;
        if (feedDetailPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
        }
        Intrinsics.checkNotNullExpressionValue(build, "newFeed");
        feedDetailPresenter2.updateFeed(build);
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailView
    public void onFavoriteResult(boolean z, Integer num, Throwable th) {
        int i;
        if (th != null) {
            Toast.error(getContext(), th);
            return;
        }
        FeedDetailPresenter feedDetailPresenter = this.feedPresenter;
        if (feedDetailPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
        }
        Feed feed = feedDetailPresenter.getFeed();
        if (num != null) {
            i = num.intValue();
        } else if (z) {
            i = feed.getFavoriteNum() + 1;
        } else {
            i = feed.getFavoriteNum() - 1;
        }
        Feed build = Feed.newBuilder(feed).userAction(UserAction.newBuilder(feed.getUserAction()).favorite(z ? 1 : 0).build()).favoriteNum(i).build();
        FeedDetailPresenter feedDetailPresenter2 = this.feedPresenter;
        if (feedDetailPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
        }
        Intrinsics.checkNotNullExpressionValue(build, "newFeed");
        feedDetailPresenter2.updateFeed(build);
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailView
    public void onLikeResult(boolean z, LikeResult likeResult, Throwable th) {
        int i;
        if (th != null) {
            Toast.error(getContext(), th);
            return;
        }
        EventBus eventBus = EventBus.getDefault();
        ItemCoolpicDetailBinding itemCoolpicDetailBinding = (ItemCoolpicDetailBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemCoolpicDetailBinding, "binding");
        Feed model = itemCoolpicDetailBinding.getModel();
        Intrinsics.checkNotNull(model);
        Intrinsics.checkNotNullExpressionValue(model, "binding.model!!");
        eventBus.post(new FeedLikeEvent(model.getId(), z, likeResult));
        FeedDetailPresenter feedDetailPresenter = this.feedPresenter;
        if (feedDetailPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
        }
        Feed feed = feedDetailPresenter.getFeed();
        if ((likeResult != null ? Integer.valueOf(likeResult.getCount()) : null) != null) {
            i = likeResult.getCount();
        } else if (z) {
            i = feed.getLikeNum() + 1;
        } else {
            i = feed.getLikeNum() - 1;
        }
        Feed build = Feed.newBuilder(feed).userAction(UserAction.newBuilder(feed.getUserAction()).like(z ? 1 : 0).build()).likeNum(i).build();
        FeedDetailPresenter feedDetailPresenter2 = this.feedPresenter;
        if (feedDetailPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
        }
        Intrinsics.checkNotNullExpressionValue(build, "newFeed");
        feedDetailPresenter2.updateFeed(build);
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailView
    public void onFeedUpdate(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        setLikeView(feed);
        setFavView(feed);
        setShareView(feed);
        setActionView(feed);
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x0276  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0288  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x02bc  */
    public void bindToContent(Feed feed) {
        int i;
        DataBindingComponent component;
        LifecycleOwner lifecycleOwner;
        CoolPicListFragment coolPicListFragment;
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(feed, "entity");
        ItemCoolpicDetailBinding itemCoolpicDetailBinding = (ItemCoolpicDetailBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemCoolpicDetailBinding, "binding");
        itemCoolpicDetailBinding.setModel(feed);
        this.feedPresenter = new FeedDetailPresenter(feed, this);
        CoolPicViewPager coolPicViewPager = ((ItemCoolpicDetailBinding) getBinding()).viewPager;
        Intrinsics.checkNotNullExpressionValue(coolPicViewPager, "binding.viewPager");
        CoolPicViewPager coolPicViewPager2 = ((ItemCoolpicDetailBinding) getBinding()).viewPager;
        Intrinsics.checkNotNullExpressionValue(coolPicViewPager2, "binding.viewPager");
        boolean z = true;
        coolPicViewPager2.setId(getAdapterPosition() + 1);
        PhotoViewUrl.Companion companion = PhotoViewUrl.Companion;
        List<String> picArray = feed.getPicArray();
        Intrinsics.checkNotNullExpressionValue(picArray, "entity.picArray");
        int i2 = 0;
        Object[] array = picArray.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        String[] strArr = (String[]) array;
        List<String> picArray2 = feed.getPicArray();
        Intrinsics.checkNotNullExpressionValue(picArray2, "entity.picArray");
        List<String> list = picArray2;
        ImageArgs.Companion companion2 = ImageArgs.Companion;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(companion2.middleSizeProvider(it2.next()));
        }
        Object[] array2 = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
        String[] strArr2 = (String[]) array2;
        List<String> picArray3 = feed.getPicArray();
        Intrinsics.checkNotNullExpressionValue(picArray3, "entity.picArray");
        List<String> list2 = picArray3;
        ImageArgs.Companion companion3 = ImageArgs.Companion;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it3 = list2.iterator();
        while (it3.hasNext()) {
            arrayList2.add(companion3.middleSizeProvider(it3.next()));
        }
        Object[] array3 = arrayList2.toArray(new String[0]);
        Objects.requireNonNull(array3, "null cannot be cast to non-null type kotlin.Array<T>");
        this.photoViewUrls = companion.from(strArr, strArr2, (String[]) array3, null, 0);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(context).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context.requireAppCompat…().supportFragmentManager");
        List<PhotoViewUrl> list3 = this.photoViewUrls;
        Intrinsics.checkNotNull(list3);
        coolPicViewPager.setAdapter(new ImageViewPagerAdapter(this, supportFragmentManager, list3));
        DataBindingComponent component2 = getComponent();
        LifecycleOwner lifecycleOwner2 = null;
        if (!(component2 instanceof FragmentBindingComponent)) {
            component2 = null;
        }
        FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component2;
        Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
        if (!(fragment instanceof CoolPicListFragment)) {
            fragment = null;
        }
        CoolPicListFragment coolPicListFragment2 = (CoolPicListFragment) fragment;
        if (coolPicListFragment2 instanceof CoolPicListFragment) {
            int index2 = coolPicListFragment2.getIndex();
            this.index = index2;
            if (index2 > 0 && TextUtils.equals(feed.getId(), coolPicListFragment2.getCurrentId())) {
                coolPicViewPager.setCurrentItem(this.index);
            }
        }
        this.picIndex = coolPicViewPager.getCurrentItem();
        setLikeView(feed);
        setFavView(feed);
        setShareView(feed);
        setActionView(feed);
        setReplyView(feed);
        ((ItemCoolpicDetailBinding) getBinding()).topContainer.setPadding(0, UiUtils.getStatusBarHeight(getContext()), 0, 0);
        ArrayList arrayList3 = new ArrayList();
        List<String> picArray4 = feed.getPicArray();
        Intrinsics.checkNotNullExpressionValue(picArray4, "entity.picArray");
        Iterator<T> it4 = picArray4.iterator();
        while (it4.hasNext()) {
            AppPictureSizeManager.PictureSize size = AppPictureSizeManager.getInstance().getSize(it4.next());
            StringBuilder sb = new StringBuilder();
            sb.append(size != null ? Integer.valueOf(size.getWidth()) : null);
            sb.append('X');
            sb.append(size != null ? Integer.valueOf(size.getHeight()) : null);
            arrayList3.add(sb.toString());
        }
        TextView textView = ((ItemCoolpicDetailBinding) getBinding()).sizeView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.sizeView");
        Object obj = arrayList3.get(0);
        if (obj == null) {
            obj = "";
        }
        textView.setText((CharSequence) obj);
        ImageIndicatorView imageIndicatorView = ((ItemCoolpicDetailBinding) getBinding()).indicatorView;
        if (feed.getPicArray().size() <= 1) {
            z = false;
        }
        imageIndicatorView.setVisibility(z ? 0 : 8);
        imageIndicatorView.setTotalIndicatorCount(feed.getPicArray().size());
        List<String> picArray5 = feed.getPicArray();
        Intrinsics.checkNotNullExpressionValue(picArray5, "entity.picArray");
        List<String> list4 = picArray5;
        ImageArgs.Companion companion4 = ImageArgs.Companion;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
        Iterator<T> it5 = list4.iterator();
        while (it5.hasNext()) {
            arrayList4.add(companion4.extraSmallSizeProvider(it5.next()));
        }
        imageIndicatorView.setList(arrayList4, getAdapterPosition());
        if (this.index > 0) {
            if (TextUtils.equals(feed.getId(), coolPicListFragment2 != null ? coolPicListFragment2.getCurrentId() : null)) {
                i = this.index;
                imageIndicatorView.setSelectedIndex(i);
                imageIndicatorView.setClick(new CoolPicDetailViewHolder$bindToContent$$inlined$apply$lambda$1(this, feed, coolPicListFragment2, coolPicViewPager));
                component = getComponent();
                if (!(component instanceof FragmentBindingComponent)) {
                    component = null;
                }
                FragmentBindingComponent fragmentBindingComponent2 = (FragmentBindingComponent) component;
                lifecycleOwner = fragmentBindingComponent2 == null ? (Fragment) fragmentBindingComponent2.getContainer() : null;
                if (lifecycleOwner instanceof CoolPicListFragment) {
                    lifecycleOwner2 = lifecycleOwner;
                }
                coolPicListFragment = (CoolPicListFragment) lifecycleOwner2;
                if (coolPicListFragment instanceof CoolPicListFragment) {
                    coolPicListFragment.setShown(feed.getViewVisible());
                }
                ItemCoolpicDetailBinding itemCoolpicDetailBinding2 = (ItemCoolpicDetailBinding) getBinding();
                Intrinsics.checkNotNullExpressionValue(itemCoolpicDetailBinding2, "binding");
                itemCoolpicDetailBinding2.getRoot().post(new CoolPicDetailViewHolder$bindToContent$6(this));
                Intrinsics.checkNotNull(coolPicListFragment);
                activity = coolPicListFragment.getActivity();
                if (activity instanceof CoolPicDetailActivity) {
                    String str = feed.getPicArray().get(this.picIndex);
                    Intrinsics.checkNotNullExpressionValue(str, "entity.picArray[picIndex]");
                    this.isCompress = ((CoolPicDetailActivity) activity).isCompressUrl(str);
                    TextView textView2 = ((ItemCoolpicDetailBinding) getBinding()).wallpaperSourceView;
                    Intrinsics.checkNotNullExpressionValue(textView2, "binding.wallpaperSourceView");
                    if (!this.isCompress) {
                        i2 = 8;
                    }
                    textView2.setVisibility(i2);
                }
                ((ItemCoolpicDetailBinding) getBinding()).executePendingBindings();
                coolPicViewPager.addOnPageChangeListener(new CoolPicDetailViewHolder$bindToContent$7(this, coolPicListFragment2, arrayList3, coolPicViewPager));
                this.activityInitTime = System.currentTimeMillis();
                coolPicViewPager.setClick(new CoolPicDetailViewHolder$bindToContent$8(this, coolPicViewPager, coolPicListFragment));
            }
        }
        i = 0;
        imageIndicatorView.setSelectedIndex(i);
        imageIndicatorView.setClick(new CoolPicDetailViewHolder$bindToContent$$inlined$apply$lambda$1(this, feed, coolPicListFragment2, coolPicViewPager));
        component = getComponent();
        if (!(component instanceof FragmentBindingComponent)) {
        }
        FragmentBindingComponent fragmentBindingComponent2 = (FragmentBindingComponent) component;
        if (fragmentBindingComponent2 == null) {
        }
        if (lifecycleOwner instanceof CoolPicListFragment) {
        }
        coolPicListFragment = (CoolPicListFragment) lifecycleOwner2;
        if (coolPicListFragment instanceof CoolPicListFragment) {
        }
        ItemCoolpicDetailBinding itemCoolpicDetailBinding2 = (ItemCoolpicDetailBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemCoolpicDetailBinding2, "binding");
        itemCoolpicDetailBinding2.getRoot().post(new CoolPicDetailViewHolder$bindToContent$6(this));
        Intrinsics.checkNotNull(coolPicListFragment);
        activity = coolPicListFragment.getActivity();
        if (activity instanceof CoolPicDetailActivity) {
        }
        ((ItemCoolpicDetailBinding) getBinding()).executePendingBindings();
        coolPicViewPager.addOnPageChangeListener(new CoolPicDetailViewHolder$bindToContent$7(this, coolPicListFragment2, arrayList3, coolPicViewPager));
        this.activityInitTime = System.currentTimeMillis();
        coolPicViewPager.setClick(new CoolPicDetailViewHolder$bindToContent$8(this, coolPicViewPager, coolPicListFragment));
    }

    static /* synthetic */ void alphaView$default(CoolPicDetailViewHolder coolPicDetailViewHolder, View view, boolean z, int i, long j, int i2, Object obj) {
        int i3 = (i2 & 4) != 0 ? 0 : i;
        if ((i2 & 8) != 0) {
            j = 200;
        }
        coolPicDetailViewHolder.alphaView(view, z, i3, j);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x000d: APUT  (r0v1 float[]), (0 ??[int, short, byte, char]), (r3v0 float) */
    private final void alphaView(View view, boolean z, int i, long j) {
        float[] fArr = new float[2];
        float f = 0.0f;
        fArr[0] = z ? 1.0f : 0.0f;
        if (!z) {
            f = 1.0f;
        }
        fArr[1] = f;
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "alpha", fArr).setDuration(j);
        Intrinsics.checkNotNullExpressionValue(duration, "ObjectAnimator.ofFloat(v…       .setDuration(time)");
        ExtraExtendsKt.addListeners(duration, new CoolPicDetailViewHolder$alphaView$2(view, i), new CoolPicDetailViewHolder$alphaView$1(view, z));
        duration.start();
    }

    public final void viewOut() {
        LinearLayout linearLayout = ((ItemCoolpicDetailBinding) getBinding()).bottomContainer;
        Property property = View.TRANSLATION_Y;
        LinearLayout linearLayout2 = ((ItemCoolpicDetailBinding) getBinding()).actionContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.actionContainer");
        LinearLayout linearLayout3 = ((ItemCoolpicDetailBinding) getBinding()).textContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.textContainer");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, property, ((float) linearLayout2.getHeight()) + ((float) linearLayout3.getHeight()));
        Intrinsics.checkNotNullExpressionValue(ofFloat, "actionValueAnimator");
        ofFloat.setDuration(200L);
        ofFloat.addListener(new CoolPicDetailViewHolder$viewOut$1(this));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, (float) NumberExtendsKt.getDp((Number) 34));
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "viewAni");
        ofFloat2.setDuration(200L);
        ofFloat2.addUpdateListener(new CoolPicDetailViewHolder$viewOut$2(this));
        ofFloat2.start();
        ofFloat.start();
        LinearLayout linearLayout4 = ((ItemCoolpicDetailBinding) getBinding()).topContainer;
        Property property2 = View.TRANSLATION_Y;
        LinearLayout linearLayout5 = ((ItemCoolpicDetailBinding) getBinding()).topContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout5, "binding.topContainer");
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(linearLayout4, property2, -((float) linearLayout5.getHeight()));
        Intrinsics.checkNotNullExpressionValue(ofFloat3, "topValueAnimator");
        ofFloat3.setDuration(200L);
        ofFloat.addListener(new CoolPicDetailViewHolder$viewOut$3(this));
        ofFloat3.start();
    }

    public final void viewIn() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(((ItemCoolpicDetailBinding) getBinding()).bottomContainer, View.TRANSLATION_Y, 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "valueAnimator");
        ofFloat.setDuration(200L);
        ofFloat.addListener(new CoolPicDetailViewHolder$viewIn$1(this));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat((float) NumberExtendsKt.getDp((Number) 34), 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "viewAni");
        ofFloat2.setDuration(200L);
        ofFloat2.addUpdateListener(new CoolPicDetailViewHolder$viewIn$2(this));
        ofFloat2.addListener(new CoolPicDetailViewHolder$viewIn$3(this));
        ofFloat2.start();
        ofFloat.start();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(((ItemCoolpicDetailBinding) getBinding()).topContainer, View.TRANSLATION_Y, 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat3, "topValueAnimator");
        ofFloat3.setDuration(200L);
        ofFloat3.addListener(new CoolPicDetailViewHolder$viewIn$4(this));
        ofFloat3.start();
    }

    public final void applyWindowsInset(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        LinearLayout linearLayout = ((ItemCoolpicDetailBinding) getBinding()).bottomContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.bottomContainer");
        LinearLayout linearLayout2 = linearLayout;
        ViewGroup.LayoutParams layoutParams = linearLayout2.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = rect.bottom;
        linearLayout2.setLayoutParams(marginLayoutParams);
        View view = ((ItemCoolpicDetailBinding) getBinding()).bottomShadeCover;
        Intrinsics.checkNotNullExpressionValue(view, "binding.bottomShadeCover");
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = NumberExtendsKt.getDp((Number) 219) + rect.bottom;
            view.setLayoutParams(layoutParams2);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void setViewHeight(View view, int i) {
        view.getLayoutParams().height = i;
        view.requestLayout();
    }

    private final void setLikeView(Feed feed) {
        UserAction userAction = feed.getUserAction();
        ((ItemCoolpicDetailBinding) getBinding()).likeImageView.setImageResource((userAction == null || userAction.getLike() != 1) ? 2131689494 : 2131689495);
        TextView textView = ((ItemCoolpicDetailBinding) getBinding()).likeText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.likeText");
        textView.setText(feed.getLikeNum() > 0 ? String.valueOf(feed.getLikeNum()) : getContext().getString(2131886852));
        int i = -1;
        ((ItemCoolpicDetailBinding) getBinding()).likeImageView.setColorFilter((userAction == null || userAction.getLike() != 1) ? -1 : AppHolder.getAppTheme().getColorAccent());
        TextView textView2 = ((ItemCoolpicDetailBinding) getBinding()).likeText;
        if (userAction != null && userAction.getLike() == 1) {
            i = AppHolder.getAppTheme().getColorAccent();
        }
        textView2.setTextColor(i);
    }

    private final void setReplyView(Feed feed) {
        TextView textView = ((ItemCoolpicDetailBinding) getBinding()).commentText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.commentText");
        textView.setText(feed.getReplyNum() > 0 ? String.valueOf(feed.getReplyNum()) : getContext().getString(2131886853));
    }

    private final void setFavView(Feed feed) {
        UserAction userAction = feed.getUserAction();
        ((ItemCoolpicDetailBinding) getBinding()).favoriteImageView.setImageResource((userAction == null || userAction.getCollect() != 1) ? 2131689477 : 2131689478);
        TextView textView = ((ItemCoolpicDetailBinding) getBinding()).favoriteTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.favoriteTextView");
        textView.setText(feed.getFavoriteNum() > 0 ? String.valueOf(feed.getFavoriteNum()) : getContext().getString(2131886848));
        int i = -1;
        ((ItemCoolpicDetailBinding) getBinding()).favoriteTextView.setTextColor((userAction == null || userAction.getCollect() != 1) ? -1 : AppHolder.getAppTheme().getColorAccent());
        ImageView imageView = ((ItemCoolpicDetailBinding) getBinding()).favoriteImageView;
        if (userAction != null && userAction.getCollect() == 1) {
            i = AppHolder.getAppTheme().getColorAccent();
        }
        imageView.setColorFilter(i);
    }

    private final void setShareView(Feed feed) {
        TextView textView = ((ItemCoolpicDetailBinding) getBinding()).shareText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.shareText");
        textView.setText(feed.getShareNum() > 0 ? String.valueOf(feed.getShareNum()) : getContext().getString(2131886855));
    }

    private final void setActionView(Feed feed) {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        String uid = loginSession.getUid();
        FeedDetailPresenter feedDetailPresenter = this.feedPresenter;
        if (feedDetailPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
        }
        boolean equals = TextUtils.equals(uid, feedDetailPresenter.getFeed().getUid());
        UserAction userAction = feed.getUserAction();
        int i = 0;
        boolean z = true;
        if (userAction == null || userAction.getFollowAuthor() != 1) {
            z = false;
        }
        ((ItemCoolpicDetailBinding) getBinding()).actionView.setTextColor(AppHolder.getAppTheme().getContentBackgroundColor());
        TextView textView = ((ItemCoolpicDetailBinding) getBinding()).actionView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.actionView");
        if (equals) {
            i = 4;
        }
        textView.setVisibility(i);
        TextView textView2 = ((ItemCoolpicDetailBinding) getBinding()).actionView;
        Drawable createBgOnlyStroke = ShapeUtils.createBgOnlyStroke(textView2.getContext(), 14, AppHolder.getAppTheme().getContentBackgroundColor());
        Drawable createActionCornerBg = ShapeUtils.createActionCornerBg(textView2.getContext(), AppHolder.getAppTheme().getColorAccent());
        if (!z) {
            createBgOnlyStroke = createActionCornerBg;
        }
        textView2.setBackground(createBgOnlyStroke);
        textView2.setText(z ? "已关注" : "关注");
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNull(view);
        boolean z = false;
        int i = 0;
        r1 = false;
        boolean z2 = false;
        z = false;
        ImageViewFragment imageViewFragment = null;
        switch (view.getId()) {
            case 2131361982:
                FeedDetailPresenter feedDetailPresenter = this.feedPresenter;
                if (feedDetailPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
                }
                FeedDetailPresenter feedDetailPresenter2 = this.feedPresenter;
                if (feedDetailPresenter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
                }
                UserAction userAction = feedDetailPresenter2.getFeed().getUserAction();
                if (userAction != null && userAction.getFollowAuthor() == 1) {
                    z = true;
                }
                feedDetailPresenter.followAuthor(z);
                return;
            case 2131362098:
            case 2131363911:
                Context context = getContext();
                FeedDetailPresenter feedDetailPresenter3 = this.feedPresenter;
                if (feedDetailPresenter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
                }
                ActionManager.startUserSpaceActivity(context, feedDetailPresenter3.getFeed().getUid());
                return;
            case 2131362296:
                Activity currentActivity = AppHolder.getCurrentActivity();
                if (currentActivity != null) {
                    Boolean checkLogin = ActionManager.checkLogin(currentActivity);
                    Intrinsics.checkNotNullExpressionValue(checkLogin, "ActionManager.checkLogin(it)");
                    if (checkLogin.booleanValue()) {
                        Context context2 = getContext();
                        FeedDetailPresenter feedDetailPresenter4 = this.feedPresenter;
                        if (feedDetailPresenter4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
                        }
                        ActionManager.startPictureReplyListActivity(context2, feedDetailPresenter4.getFeed(), null, 66666);
                        return;
                    }
                    return;
                }
                return;
            case 2131362527:
                Activity currentActivity2 = AppHolder.getCurrentActivity();
                if (currentActivity2 != null) {
                    Boolean checkLogin2 = ActionManager.checkLogin(currentActivity2);
                    Intrinsics.checkNotNullExpressionValue(checkLogin2, "ActionManager.checkLogin(it)");
                    if (checkLogin2.booleanValue()) {
                        Context context3 = getContext();
                        ItemCoolpicDetailBinding itemCoolpicDetailBinding = (ItemCoolpicDetailBinding) getBinding();
                        Intrinsics.checkNotNullExpressionValue(itemCoolpicDetailBinding, "binding");
                        Feed model = itemCoolpicDetailBinding.getModel();
                        Intrinsics.checkNotNull(model);
                        Intrinsics.checkNotNullExpressionValue(model, "binding.model!!");
                        String id = model.getId();
                        FeedDetailPresenter feedDetailPresenter5 = this.feedPresenter;
                        if (feedDetailPresenter5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
                        }
                        ActionManager.startCollectionSelectActivity(context3, id, feedDetailPresenter5.getFeed().getEntityType());
                        return;
                    }
                    return;
                }
                return;
            case 2131362862:
                Activity currentActivity3 = AppHolder.getCurrentActivity();
                if (currentActivity3 != null) {
                    Boolean checkLogin3 = ActionManager.checkLogin(currentActivity3);
                    Intrinsics.checkNotNullExpressionValue(checkLogin3, "ActionManager.checkLogin(it)");
                    if (checkLogin3.booleanValue()) {
                        FeedDetailPresenter feedDetailPresenter6 = this.feedPresenter;
                        if (feedDetailPresenter6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
                        }
                        FeedDetailPresenter feedDetailPresenter7 = this.feedPresenter;
                        if (feedDetailPresenter7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
                        }
                        UserAction userAction2 = feedDetailPresenter7.getFeed().getUserAction();
                        if (userAction2 != null && userAction2.getLike() == 1) {
                            z2 = true;
                        }
                        feedDetailPresenter6.likeFeed(z2);
                        return;
                    }
                    return;
                }
                return;
            case 2131362982:
                int i2 = this.picIndex;
                List<PhotoViewUrl> list = this.photoViewUrls;
                Intrinsics.checkNotNull(list);
                if (i2 < list.size()) {
                    SaveImageDialog.Companion companion = SaveImageDialog.Companion;
                    List<PhotoViewUrl> list2 = this.photoViewUrls;
                    Intrinsics.checkNotNull(list2);
                    int i3 = this.picIndex;
                    FeedDetailPresenter feedDetailPresenter8 = this.feedPresenter;
                    if (feedDetailPresenter8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
                    }
                    SaveImageDialog newInstance = companion.newInstance(list2, i3, feedDetailPresenter8.getFeed());
                    DataBindingComponent component = getComponent();
                    if (!(component instanceof FragmentBindingComponent)) {
                        component = null;
                    }
                    FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
                    Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
                    if (!(fragment instanceof CoolPicListFragment)) {
                        fragment = null;
                    }
                    CoolPicListFragment coolPicListFragment = (CoolPicListFragment) fragment;
                    FragmentManager childFragmentManager = coolPicListFragment != null ? coolPicListFragment.getChildFragmentManager() : null;
                    Intrinsics.checkNotNull(childFragmentManager);
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager, "inFragment<CoolPicListFr…)?.childFragmentManager!!");
                    newInstance.show(childFragmentManager, (String) null);
                    return;
                }
                return;
            case 2131363022:
                Context context4 = getContext();
                Intrinsics.checkNotNullExpressionValue(context4, "context");
                Activity activityNullable = UiUtils.getActivityNullable(context4);
                if (activityNullable != null) {
                    activityNullable.finish();
                    return;
                }
                return;
            case 2131363374:
                Activity currentActivity4 = AppHolder.getCurrentActivity();
                if (currentActivity4 != null) {
                    Boolean checkLogin4 = ActionManager.checkLogin(currentActivity4);
                    Intrinsics.checkNotNullExpressionValue(checkLogin4, "ActionManager.checkLogin(it)");
                    if (checkLogin4.booleanValue()) {
                        Context context5 = getContext();
                        FeedDetailPresenter feedDetailPresenter9 = this.feedPresenter;
                        if (feedDetailPresenter9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
                        }
                        ActionManager.startForwardEntityActivity(context5, feedDetailPresenter9.getFeed());
                        return;
                    }
                    return;
                }
                return;
            case 2131363544:
                Context context6 = getContext();
                FeedDetailPresenter feedDetailPresenter10 = this.feedPresenter;
                if (feedDetailPresenter10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
                }
                ActionManager.startFeedDetailActivity(context6, feedDetailPresenter10.getFeed().getId(), (String) null);
                return;
            case 2131363979:
                int i4 = this.picIndex;
                List<PhotoViewUrl> list3 = this.photoViewUrls;
                Intrinsics.checkNotNull(list3);
                if (i4 < list3.size()) {
                    List<PhotoViewUrl> list4 = this.photoViewUrls;
                    Intrinsics.checkNotNull(list4);
                    PhotoUtils.saveImageObservable(list4.get(this.picIndex).getSource(), true).subscribe((Subscriber<? super File>) new CoolPicDetailViewHolder$onClick$5());
                    return;
                }
                return;
            case 2131363980:
                CoolPicViewPager coolPicViewPager = ((ItemCoolpicDetailBinding) getBinding()).viewPager;
                Intrinsics.checkNotNullExpressionValue(coolPicViewPager, "binding.viewPager");
                PagerAdapter adapter = coolPicViewPager.getAdapter();
                Object instantiateItem = adapter != null ? adapter.instantiateItem((ViewGroup) ((ItemCoolpicDetailBinding) getBinding()).viewPager, this.picIndex) : null;
                if (instantiateItem instanceof ImageViewFragment) {
                    imageViewFragment = instantiateItem;
                }
                ImageViewFragment imageViewFragment2 = imageViewFragment;
                if (imageViewFragment2 != null) {
                    imageViewFragment2.reloadPic();
                }
                Context context7 = getContext();
                Intrinsics.checkNotNullExpressionValue(context7, "context");
                Activity activityNullable2 = UiUtils.getActivityNullable(context7);
                if (activityNullable2 instanceof CoolPicDetailActivity) {
                    CoolPicDetailActivity coolPicDetailActivity = (CoolPicDetailActivity) activityNullable2;
                    FeedDetailPresenter feedDetailPresenter11 = this.feedPresenter;
                    if (feedDetailPresenter11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
                    }
                    String str = feedDetailPresenter11.getFeed().getPicArray().get(this.picIndex);
                    Intrinsics.checkNotNullExpressionValue(str, "feedPresenter.feed.picArray[picIndex]");
                    this.isCompress = coolPicDetailActivity.isCompressUrl(str);
                    TextView textView = ((ItemCoolpicDetailBinding) getBinding()).wallpaperSourceView;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.wallpaperSourceView");
                    if (!this.isCompress) {
                        i = 8;
                    }
                    textView.setVisibility(i);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* compiled from: CoolPicDetailViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: CoolPicDetailViewHolder.kt */
    private final class ImageViewPagerAdapter extends FragmentStatePagerAdapter {
        private final List<PhotoViewUrl> data;
        final /* synthetic */ CoolPicDetailViewHolder this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ImageViewPagerAdapter(CoolPicDetailViewHolder coolPicDetailViewHolder, FragmentManager fragmentManager, List<PhotoViewUrl> list) {
            super(fragmentManager);
            Intrinsics.checkNotNullParameter(fragmentManager, "fm");
            Intrinsics.checkNotNullParameter(list, "data");
            this.this$0 = coolPicDetailViewHolder;
            this.data = list;
        }

        @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return ImageViewFragment.Companion.newInstance(this.data, CoolPicDetailViewHolder.access$getFeedPresenter$p(this.this$0).getFeed(), i);
        }

        @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
        public String getItemTag(int i) {
            return "fragment_" + i;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.data.size();
        }
    }

    public final ObjectAnimator scaleAni(View view, String str, float f, float f2, long j, long j2) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(str, "propertyName");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, str, f, f2);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ObjectAnimator.ofFloat(v…, propertyName, from, to)");
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setStartDelay(j2);
        ofFloat.setDuration(j);
        return ofFloat;
    }

    public final ObjectAnimator translationX(View view, float f, float f2, long j, long j2) {
        Intrinsics.checkNotNullParameter(view, "view");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", f, f2);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ObjectAnimator.ofFloat(v…\"translationX\", from, to)");
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setStartDelay(j2);
        ofFloat.setDuration(j);
        return ofFloat;
    }

    public final ObjectAnimator translationY(View view, float f, float f2, long j, long j2) {
        Intrinsics.checkNotNullParameter(view, "view");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", f, f2);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ObjectAnimator.ofFloat(v…\"translationY\", from, to)");
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setStartDelay(j2);
        ofFloat.setDuration(j);
        return ofFloat;
    }

    public final ObjectAnimator alphaAni(View view, float f, float f2, long j, long j2) {
        Intrinsics.checkNotNullParameter(view, "view");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", f, f2);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ani");
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setStartDelay(j2);
        ofFloat.setDuration(j);
        return ofFloat;
    }

    public final ObjectAnimator rotation(View view, long j, long j2, float... fArr) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(fArr, "values");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotation", Arrays.copyOf(fArr, fArr.length));
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ani");
        ofFloat.setDuration(j);
        ofFloat.setStartDelay(j2);
        ofFloat.setInterpolator(CoolPicDetailViewHolder$rotation$1.INSTANCE);
        return ofFloat;
    }
}
