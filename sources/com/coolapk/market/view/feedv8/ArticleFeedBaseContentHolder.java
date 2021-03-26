package com.coolapk.market.view.feedv8;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.databinding.SubmitFeedArticleHolder2Binding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.util.CoolFileUtils;
import com.coolapk.market.util.DialogUtil;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.feed.CommentHelper;
import com.coolapk.market.view.feedv8.ArticleModel;
import com.coolapk.market.view.feedv8.article.ArticleViewModel;
import com.coolapk.market.view.feedv8.util.ArticleEditText;
import com.coolapk.market.view.feedv8.util.HandleFocusRecyclerView;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.emotion.BaseEmotion;
import com.coolapk.market.widget.multitype.MultiTypeAdapter;
import com.yalantis.ucrop.UCrop;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

/* compiled from: ArticleFeedBaseContentHolder.kt */
public abstract class ArticleFeedBaseContentHolder extends BaseFeedContentHolder {
    private static final int COUNT_DOWN_START = 5;
    public static final Companion Companion = new Companion(null);
    private static final int MAX_ARTICLE_PIC_COUNT = 50;
    private static final int REQUEST_PICK_COVER = 433;
    private final MultiTypeAdapter adapter;
    private final ArticleViewModel articleViewModel = new ArticleViewModel();
    private SubmitFeedArticleHolder2Binding binding;
    private final List<ArticleModel> dataList;
    private final LifecycleOwner lifecycleOwner;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArticleFeedBaseContentHolder(Activity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.lifecycleOwner = (LifecycleOwner) activity;
        ArrayList arrayList = new ArrayList();
        this.dataList = arrayList;
        this.adapter = new MultiTypeAdapter(arrayList);
    }

    /* compiled from: ArticleFeedBaseContentHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    protected final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    protected final ArticleViewModel getArticleViewModel() {
        return this.articleViewModel;
    }

    protected final MultiTypeAdapter getAdapter() {
        return this.adapter;
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public View getFocusEditorView() {
        SubmitFeedArticleHolder2Binding submitFeedArticleHolder2Binding = this.binding;
        if (submitFeedArticleHolder2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View findFocus = submitFeedArticleHolder2Binding.recyclerView.findFocus();
        if (findFocus != null) {
            return findFocus;
        }
        SubmitFeedArticleHolder2Binding submitFeedArticleHolder2Binding2 = this.binding;
        if (submitFeedArticleHolder2Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        HandleFocusRecyclerView handleFocusRecyclerView = submitFeedArticleHolder2Binding2.recyclerView;
        Intrinsics.checkNotNullExpressionValue(handleFocusRecyclerView, "binding.recyclerView");
        return handleFocusRecyclerView;
    }

    public final HandleFocusRecyclerView getRecyclerView$presentation_coolapkAppRelease() {
        SubmitFeedArticleHolder2Binding submitFeedArticleHolder2Binding = this.binding;
        if (submitFeedArticleHolder2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        HandleFocusRecyclerView handleFocusRecyclerView = submitFeedArticleHolder2Binding.recyclerView;
        Intrinsics.checkNotNullExpressionValue(handleFocusRecyclerView, "binding.recyclerView");
        return handleFocusRecyclerView;
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public View onCreateContentView$presentation_coolapkAppRelease(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131559158, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…cle_holder2, null, false)");
        SubmitFeedArticleHolder2Binding submitFeedArticleHolder2Binding = (SubmitFeedArticleHolder2Binding) inflate;
        this.binding = submitFeedArticleHolder2Binding;
        if (submitFeedArticleHolder2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        HandleFocusRecyclerView handleFocusRecyclerView = submitFeedArticleHolder2Binding.recyclerView;
        Intrinsics.checkNotNullExpressionValue(handleFocusRecyclerView, "binding.recyclerView");
        handleFocusRecyclerView.setAdapter(this.adapter);
        SubmitFeedArticleHolder2Binding submitFeedArticleHolder2Binding2 = this.binding;
        if (submitFeedArticleHolder2Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        HandleFocusRecyclerView handleFocusRecyclerView2 = submitFeedArticleHolder2Binding2.recyclerView;
        Intrinsics.checkNotNullExpressionValue(handleFocusRecyclerView2, "binding.recyclerView");
        handleFocusRecyclerView2.setLayoutManager(new ArticleFeedBaseContentHolder$onCreateContentView$1(this, getActivity()));
        SubmitFeedArticleHolder2Binding submitFeedArticleHolder2Binding3 = this.binding;
        if (submitFeedArticleHolder2Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        HandleFocusRecyclerView handleFocusRecyclerView3 = submitFeedArticleHolder2Binding3.recyclerView;
        Intrinsics.checkNotNullExpressionValue(handleFocusRecyclerView3, "binding.recyclerView");
        handleFocusRecyclerView3.setItemAnimator(null);
        this.articleViewModel.setInitMultiPart(getMultiPart());
        this.articleViewModel.getDataList().observe(this.lifecycleOwner, new ArticleFeedBaseContentHolder$onCreateContentView$2(this));
        this.articleViewModel.getActions().observe(this.lifecycleOwner, new ArticleFeedBaseContentHolder$onCreateContentView$3(this));
        this.articleViewModel.getMenuEnable().observe(this.lifecycleOwner, new ArticleFeedBaseContentHolder$onCreateContentView$4(this));
        SubmitFeedArticleHolder2Binding submitFeedArticleHolder2Binding4 = this.binding;
        if (submitFeedArticleHolder2Binding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = submitFeedArticleHolder2Binding4.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onRequestPickImage() {
        ArrayList arrayList = new ArrayList();
        for (T t : this.dataList) {
            if (t.getType() == ArticleModel.Type.Image) {
                arrayList.add(t);
            }
        }
        int size = arrayList.size();
        if (size >= 50) {
            Activity activity = getActivity();
            Toast.show$default(activity, "最多添加50张图片", 0, false, 12, null);
            return;
        }
        ActionManager.startPhotoPickerActivityWithCountDown(getActivity(), 50 - size, 5, 50);
        UiUtils.closeKeyboard(getFocusEditorView());
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder, com.coolapk.market.widget.emotion.EmotionPanel.EmotionPanelListener
    public void onEmotionClick(BaseEmotion baseEmotion) {
        Intrinsics.checkNotNullParameter(baseEmotion, "emotions");
        String realText = baseEmotion.getRealText();
        ArticleEditText activeEditText = this.articleViewModel.getActiveEditText();
        if (activeEditText != null) {
            Intrinsics.checkNotNullExpressionValue(realText, "emotionText");
            ViewExtendsKt.insertText(activeEditText, realText);
        }
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder, com.coolapk.market.widget.emotion.EmotionPanel.EmotionPanelListener
    public void onDeleteButtonClick() {
        ArticleEditText activeEditText = this.articleViewModel.getActiveEditText();
        if (activeEditText != null) {
            ViewExtendsKt.insertBackKey(activeEditText);
        }
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onPickImageListChange(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "pathList");
        super.onPickImageListChange(list);
        this.articleViewModel.insertImages(list);
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onPickTopicIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        super.onPickTopicIntent(intent);
        ArticleEditText activeEditText = this.articleViewModel.getActiveEditText();
        if (activeEditText != null) {
            CommentHelper.processTopicResult(intent, activeEditText);
        }
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onPickAtIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        super.onPickAtIntent(intent);
        ArticleEditText activeEditText = this.articleViewModel.getActiveEditText();
        if (activeEditText != null) {
            CommentHelper.processAtUserResult(intent, activeEditText);
        }
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onPickAppIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        super.onPickAppIntent(intent);
        ArticleEditText activeEditText = this.articleViewModel.getActiveEditText();
        if (activeEditText != null) {
            CommentHelper.processAddAppResult(intent, activeEditText);
        }
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onPreviewClicked() {
        super.onPreviewClicked();
        ActionManager.startArticlePreviewFragment(getActivity(), ArticleModelKt.toJson(this.dataList, true), this);
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onActivityResult(int i, int i2, Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 69) {
                Uri output = UCrop.getOutput(intent);
                if (output != null) {
                    Intrinsics.checkNotNullExpressionValue(output, "UCrop.getOutput(data) ?: return");
                    ArticleViewModel.updateDataList$default(this.articleViewModel, false, false, new ArticleFeedBaseContentHolder$onActivityResult$1(output), 3, null);
                }
            } else if (i == 433) {
                String path = BitmapUtil.getPath(getActivity(), intent.getData());
                if (TextUtils.isEmpty(path)) {
                    Toast.show$default(getActivity(), "无法读取图片", 0, false, 12, null);
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(path, "path");
                compressAndCrop(path);
            }
        }
    }

    private final void compressAndCrop(String str) {
        Dialog showProgressDialog = DialogUtil.INSTANCE.showProgressDialog(getActivity(), "正在处理...", false);
        BitmapUtil.compressImage(getActivity(), CoolFileUtils.wrap(str), 0).compose(RxUtils.applyIOSchedulers()).doOnUnsubscribe(new ArticleFeedBaseContentHolder$compressAndCrop$1(showProgressDialog)).subscribe((Subscriber<? super R>) new ArticleFeedBaseContentHolder$compressAndCrop$2(this, BitmapUtil.generateFileOutputPath(getActivity(), str + ".bak")));
    }

    public final void requestPickArticlePhoto() {
        ActionManager.startPhotoPickerActivity(getActivity(), 1, (List<String>) null, 433);
    }
}
