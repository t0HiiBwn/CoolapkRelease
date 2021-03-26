package com.gongwen.marqueen;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public abstract class MarqueeFactory<T extends View, E> {
    protected List<E> datas;
    private boolean isOnItemClickRegistered;
    protected Context mContext;
    private MarqueeView mMarqueeView;
    protected List<T> mViews;
    protected OnItemClickListener onItemClickListener;

    public interface OnItemClickListener<V extends View, E> {
        void onItemClickListener(ViewHolder<V, E> viewHolder);
    }

    public abstract T generateMarqueeItemView(E e);

    public MarqueeFactory(Context context) {
        this.mContext = context;
    }

    public void setData(List<E> list) {
        if (!(list == null || list.size() == 0)) {
            this.datas = list;
            this.mViews = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                this.mViews.add(generateMarqueeItemView(list.get(i)));
            }
            registerOnItemClick();
            MarqueeView marqueeView = this.mMarqueeView;
            if (marqueeView != null) {
                marqueeView.setMarqueeFactory(this);
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener<T, E> onItemClickListener2) {
        this.onItemClickListener = onItemClickListener2;
        registerOnItemClick();
    }

    public List<T> getMarqueeViews() {
        return this.mViews;
    }

    private void registerOnItemClick() {
        if (!(this.isOnItemClickRegistered || this.onItemClickListener == null || this.datas == null)) {
            for (int i = 0; i < this.datas.size(); i++) {
                T t = this.mViews.get(i);
                t.setTag(new ViewHolder(t, this.datas.get(i), i));
                t.setOnClickListener(new View.OnClickListener() {
                    /* class com.gongwen.marqueen.MarqueeFactory.AnonymousClass1 */

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MarqueeFactory.this.onItemClickListener.onItemClickListener((ViewHolder) view.getTag());
                    }
                });
            }
            this.isOnItemClickRegistered = true;
        }
    }

    public static class ViewHolder<V extends View, P> {
        public P data;
        public V mView;
        public int position;

        public ViewHolder(V v, P p, int i) {
            this.mView = v;
            this.data = p;
            this.position = i;
        }
    }

    public void setAttachedToMarqueeView(MarqueeView marqueeView) {
        this.mMarqueeView = marqueeView;
    }
}
