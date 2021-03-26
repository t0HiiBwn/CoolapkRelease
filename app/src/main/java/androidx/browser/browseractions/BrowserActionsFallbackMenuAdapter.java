package androidx.browser.browseractions;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.browser.R;
import androidx.core.content.res.ResourcesCompat;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

@Deprecated
class BrowserActionsFallbackMenuAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<BrowserActionItem> mMenuItems;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return (long) i;
    }

    BrowserActionsFallbackMenuAdapter(List<BrowserActionItem> list, Context context) {
        this.mMenuItems = list;
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mMenuItems.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.mMenuItems.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolderItem viewHolderItem;
        BrowserActionItem browserActionItem = this.mMenuItems.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.browser_actions_context_menu_row, (ViewGroup) null);
            ImageView imageView = (ImageView) view.findViewById(R.id.browser_actions_menu_item_icon);
            TextView textView = (TextView) view.findViewById(R.id.browser_actions_menu_item_text);
            if (imageView == null || textView == null) {
                throw new IllegalStateException("Browser Actions fallback UI does not contain necessary Views.");
            }
            viewHolderItem = new ViewHolderItem(imageView, textView);
            view.setTag(viewHolderItem);
        } else {
            viewHolderItem = (ViewHolderItem) view.getTag();
        }
        final String title = browserActionItem.getTitle();
        viewHolderItem.mText.setText(title);
        if (browserActionItem.getIconId() != 0) {
            viewHolderItem.mIcon.setImageDrawable(ResourcesCompat.getDrawable(this.mContext.getResources(), browserActionItem.getIconId(), null));
        } else if (browserActionItem.getIconUri() != null) {
            final ListenableFuture<Bitmap> loadBitmap = BrowserServiceFileProvider.loadBitmap(this.mContext.getContentResolver(), browserActionItem.getIconUri());
            loadBitmap.addListener(new Runnable() {
                /* class androidx.browser.browseractions.BrowserActionsFallbackMenuAdapter.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap;
                    if (TextUtils.equals(title, viewHolderItem.mText.getText())) {
                        try {
                            bitmap = (Bitmap) loadBitmap.get();
                        } catch (InterruptedException | ExecutionException unused) {
                            bitmap = null;
                        }
                        if (bitmap != null) {
                            viewHolderItem.mIcon.setVisibility(0);
                            viewHolderItem.mIcon.setImageBitmap(bitmap);
                            return;
                        }
                        viewHolderItem.mIcon.setVisibility(4);
                        viewHolderItem.mIcon.setImageBitmap(null);
                    }
                }
            }, new Executor() {
                /* class androidx.browser.browseractions.BrowserActionsFallbackMenuAdapter.AnonymousClass2 */

                @Override // java.util.concurrent.Executor
                public void execute(Runnable runnable) {
                    runnable.run();
                }
            });
        } else {
            viewHolderItem.mIcon.setImageBitmap(null);
            viewHolderItem.mIcon.setVisibility(4);
        }
        return view;
    }

    static class ViewHolderItem {
        final ImageView mIcon;
        final TextView mText;

        ViewHolderItem(ImageView imageView, TextView textView) {
            this.mIcon = imageView;
            this.mText = textView;
        }
    }
}
