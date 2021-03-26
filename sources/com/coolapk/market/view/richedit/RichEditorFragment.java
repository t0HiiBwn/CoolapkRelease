package com.coolapk.market.view.richedit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.ImageLoaderOptions;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Article;
import com.coolapk.market.model.ImageUploadOption;
import com.coolapk.market.util.CoolFileUtils;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.richedit.RichEditor;
import com.coolapk.market.widget.Toast;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

public class RichEditorFragment extends Fragment {
    private static final int REQUEST_PICK_CONTENT_PHOTO = 2;
    private static final int REQUEST_PICK_COVER_URL = 1;
    private Article article;
    private String coverUrl;
    private ImageView coverView;
    private View optionLayout;
    private RichEditor richEditor;
    private String thumbnail;
    private EditText titleView;
    private View topLayout;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2131559117, viewGroup, false);
        this.topLayout = inflate.findViewById(2131362899);
        View findViewById = inflate.findViewById(2131362898);
        this.optionLayout = findViewById;
        findViewById.setVisibility(8);
        RichEditor richEditor2 = (RichEditor) inflate.findViewById(2131362448);
        this.richEditor = richEditor2;
        richEditor2.setEditorFontSize(16);
        this.richEditor.setEditorFontColor(AppHolder.getAppTheme().getTextColorPrimary());
        this.richEditor.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        this.richEditor.setPlaceholder("正文");
        this.richEditor.setOutdent();
        this.richEditor.defaultParagraphSeparator();
        this.richEditor.setOnTextChangeListener(new RichEditor.OnTextChangeListener() {
            /* class com.coolapk.market.view.richedit.RichEditorFragment.AnonymousClass1 */

            @Override // com.coolapk.market.view.richedit.RichEditor.OnTextChangeListener
            public void onTextChange(String str) {
                LogUtils.d(str, new Object[0]);
            }
        });
        this.richEditor.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.coolapk.market.view.richedit.RichEditorFragment.AnonymousClass2 */

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                RichEditorFragment.this.richEditor.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                LogUtils.d("WebView height: " + RichEditorFragment.this.richEditor.getHeight(), new Object[0]);
                RichEditorFragment.this.richEditor.setEditorHeight(RichEditorFragment.this.richEditor.getHeight());
            }
        });
        this.topLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.coolapk.market.view.richedit.RichEditorFragment.AnonymousClass3 */

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                RichEditorFragment.this.topLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                RichEditorFragment.this.richEditor.setPadding(12, (int) ((((float) RichEditorFragment.this.topLayout.getHeight()) / RichEditorFragment.this.getResources().getDisplayMetrics().density) + 12.0f), 12, 12);
            }
        });
        this.richEditor.setScrollViewCallbacks(new ObservableScrollViewCallbacks() {
            /* class com.coolapk.market.view.richedit.RichEditorFragment.AnonymousClass4 */

            @Override // com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks
            public void onDownMotionEvent() {
                LogUtils.d("onDownMotionEvent: ", new Object[0]);
                if (!ViewCompat.canScrollVertically(RichEditorFragment.this.richEditor, -1)) {
                    LogUtils.d("onDownMotionEvent: 不能下拉的", new Object[0]);
                }
            }

            @Override // com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks
            public void onScrollChanged(int i, boolean z, boolean z2) {
                LogUtils.d("onScrollChanged: scrollY " + i + " firstScroll " + z + " dragging " + z2, new Object[0]);
                if (i > RichEditorFragment.this.topLayout.getHeight()) {
                    i = RichEditorFragment.this.topLayout.getHeight();
                }
                RichEditorFragment.this.topLayout.setTranslationY((float) (-i));
            }

            @Override // com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks
            public void onUpOrCancelMotionEvent(ScrollState scrollState) {
                if (scrollState != null) {
                    LogUtils.d("onUpOrCancelMotionEvent: " + scrollState.ordinal(), new Object[0]);
                }
            }
        });
        this.richEditor.setOnEditFocusChangeListener(new RichEditor.OnEditFocusChangeListener() {
            /* class com.coolapk.market.view.richedit.RichEditorFragment.AnonymousClass5 */

            @Override // com.coolapk.market.view.richedit.RichEditor.OnEditFocusChangeListener
            public void onEditFocus(boolean z) {
                RichEditorFragment.this.optionLayout.setVisibility(z ? 0 : 8);
            }
        });
        ImageView imageView = (ImageView) inflate.findViewById(2131362793);
        this.coverView = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.richedit.RichEditorFragment.AnonymousClass6 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActionManager.startPhotoPickerActivity(RichEditorFragment.this, 1, (List<String>) null, 1);
            }
        });
        inflate.findViewById(2131362786).setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.richedit.RichEditorFragment.AnonymousClass7 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActionManager.startPhotoPickerActivity(RichEditorFragment.this, 9, (List<String>) null, 2);
            }
        });
        inflate.findViewById(2131362796).setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.richedit.RichEditorFragment.AnonymousClass8 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RichEditorFragment.this.richEditor.setHeading(1);
            }
        });
        inflate.findViewById(2131362797).setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.richedit.RichEditorFragment.AnonymousClass9 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RichEditorFragment.this.richEditor.setHeading(2);
            }
        });
        inflate.findViewById(2131362798).setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.richedit.RichEditorFragment.AnonymousClass10 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RichEditorFragment.this.richEditor.setHeading(3);
            }
        });
        inflate.findViewById(2131362789).setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.richedit.RichEditorFragment.AnonymousClass11 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RichEditorFragment.this.richEditor.setBold();
            }
        });
        inflate.findViewById(2131362804).setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.richedit.RichEditorFragment.AnonymousClass12 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RichEditorFragment.this.richEditor.insertLink("https://github.com/wasabeef", "link");
            }
        });
        inflate.findViewById(2131362802).setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.richedit.RichEditorFragment.AnonymousClass13 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RichEditorFragment.this.richEditor.setItalic();
            }
        });
        inflate.findViewById(2131362807).setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.richedit.RichEditorFragment.AnonymousClass14 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RichEditorFragment.this.richEditor.setStrikeThrough();
            }
        });
        inflate.findViewById(2131362809).setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.richedit.RichEditorFragment.AnonymousClass15 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RichEditorFragment.this.richEditor.setUnderline();
            }
        });
        this.titleView = (EditText) inflate.findViewById(2131362472);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Article latestArticle = DataManager.getInstance().getLatestArticle();
        this.article = latestArticle;
        if (latestArticle == null) {
            DataManager.getInstance().insertArticle("", "", "");
            this.article = DataManager.getInstance().getLatestArticle();
        }
        this.titleView.setText(this.article.title());
        this.richEditor.setHtml(this.article.content());
        this.coverUrl = this.article.coverUrl();
        updateCover();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        DataManager.getInstance().updateArticle(this.article.id(), this.titleView.getText().toString(), this.coverUrl, this.richEditor.getHtml());
    }

    public void updateCover() {
        DataManager.getInstance().updateArticle(this.article.id(), null, this.coverUrl, null);
        AppHolder.getFragmentImageLoader().displayImage((Fragment) this, this.coverUrl, this.coverView, ImageLoaderOptions.newBuilder().thumbnail(this.thumbnail).build(), (OnImageLoadListener) null, (OnBitmapTransformListener) null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && intent != null) {
            final ProgressDialog progressDialog = new ProgressDialog(getActivity());
            progressDialog.setProgressStyle(0);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setCancelable(false);
            progressDialog.setMessage("提交中...");
            if (i == 1) {
                DataManager.getInstance().uploadImage(Collections.singletonList(ImageUploadOption.create(intent.getData().toString(), "feed_image", "FEED", null))).compose(RxUtils.applyIOSchedulers()).first().doOnSubscribe(new Action0() {
                    /* class com.coolapk.market.view.richedit.RichEditorFragment.AnonymousClass18 */

                    @Override // rx.functions.Action0
                    public void call() {
                        progressDialog.show();
                    }
                }).doOnTerminate(new Action0() {
                    /* class com.coolapk.market.view.richedit.RichEditorFragment.AnonymousClass17 */

                    @Override // rx.functions.Action0
                    public void call() {
                        progressDialog.dismiss();
                    }
                }).subscribe((Subscriber<? super R>) new Subscriber<Pair<String, String>>() {
                    /* class com.coolapk.market.view.richedit.RichEditorFragment.AnonymousClass16 */

                    @Override // rx.Observer
                    public void onCompleted() {
                    }

                    @Override // rx.Observer
                    public void onError(Throwable th) {
                        Toast.error(RichEditorFragment.this.getActivity(), th);
                    }

                    public void onNext(Pair<String, String> pair) {
                        if (pair.second == null || !((String) pair.second).startsWith("http")) {
                            Toast.show(RichEditorFragment.this.getActivity(), "图片上传失败，请重试");
                            return;
                        }
                        RichEditorFragment.this.thumbnail = (String) pair.first;
                        RichEditorFragment.this.coverUrl = (String) pair.second;
                        RichEditorFragment.this.updateCover();
                    }
                });
            } else if (i == 2) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PICKED_PHOTO_PATHS");
                ArrayList arrayList = new ArrayList(stringArrayListExtra.size());
                for (String str : stringArrayListExtra) {
                    arrayList.add(CoolFileUtils.wrap(str));
                }
                DataManager.getInstance().uploadImage(ImageUploadOption.transformList(arrayList, "feed_image", "FEED", null)).compose(RxUtils.applyIOSchedulers()).doOnNext(new Action1<Pair<String, String>>() {
                    /* class com.coolapk.market.view.richedit.RichEditorFragment.AnonymousClass23 */

                    public void call(Pair<String, String> pair) {
                        if (pair.second == null || !((String) pair.second).startsWith("http")) {
                            throw Exceptions.propagate(new RuntimeException("图片上传失败，请重试"));
                        }
                        RichEditorFragment.this.insertImage((String) pair.second, "");
                    }
                }).all(new Func1<Pair<String, String>, Boolean>() {
                    /* class com.coolapk.market.view.richedit.RichEditorFragment.AnonymousClass22 */

                    public Boolean call(Pair<String, String> pair) {
                        return true;
                    }
                }).doOnSubscribe(new Action0() {
                    /* class com.coolapk.market.view.richedit.RichEditorFragment.AnonymousClass21 */

                    @Override // rx.functions.Action0
                    public void call() {
                        progressDialog.show();
                    }
                }).doOnTerminate(new Action0() {
                    /* class com.coolapk.market.view.richedit.RichEditorFragment.AnonymousClass20 */

                    @Override // rx.functions.Action0
                    public void call() {
                        progressDialog.dismiss();
                    }
                }).subscribe((Subscriber<? super Boolean>) new Subscriber<Boolean>() {
                    /* class com.coolapk.market.view.richedit.RichEditorFragment.AnonymousClass19 */

                    @Override // rx.Observer
                    public void onCompleted() {
                    }

                    @Override // rx.Observer
                    public void onError(Throwable th) {
                        Toast.error(RichEditorFragment.this.getActivity(), th);
                    }

                    public void onNext(Boolean bool) {
                        if (bool.booleanValue()) {
                            LogUtils.d("图片上传完成", new Object[0]);
                        }
                    }
                });
            }
        }
    }

    public void insertImage(String str, String str2) {
        this.richEditor.insertImage(str, str2);
        this.richEditor.insertHtml("<br />");
    }
}
