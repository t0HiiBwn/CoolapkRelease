package com.coolapk.market.viewholder;

import android.app.Activity;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import com.coolapk.market.databinding.AlbumListItemCardNonupleBinding;
import com.coolapk.market.databinding.AlbumListItemCardNonupleItemBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.Card;
import com.coolapk.market.model.Entity;
import java.util.List;

public class AlbumMainCardViewHolder extends GenericBindHolder<AlbumListItemCardNonupleBinding, Card> {
    public static final int LAYOUT_ID = 2131558448;
    private View childView;

    public AlbumMainCardViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
    }

    public void bindToContent(Card card) {
        final List entities = card.getEntities();
        AlbumListItemCardNonupleBinding albumListItemCardNonupleBinding = (AlbumListItemCardNonupleBinding) getBinding();
        albumListItemCardNonupleBinding.setCard(card);
        albumListItemCardNonupleBinding.setViewHolder(this);
        int size = entities.size();
        for (final int i = 0; i < 12; i++) {
            View findViewById = this.itemView.findViewById(2131362769 + i);
            this.childView = findViewById;
            AlbumListItemCardNonupleItemBinding albumListItemCardNonupleItemBinding = (AlbumListItemCardNonupleItemBinding) DataBindingUtil.bind(findViewById);
            if (size < 7) {
                if (i > 6 || i == 3 || (size < 4 && i > 2)) {
                    this.childView = null;
                }
                if (this.childView != null) {
                    albumListItemCardNonupleItemBinding.getRoot().setVisibility(0);
                    if (i > 2 && size > 3) {
                        albumListItemCardNonupleItemBinding.setAlbum((Album) entities.get(i - 1));
                        this.childView.setOnClickListener(new View.OnClickListener() {
                            /* class com.coolapk.market.viewholder.AlbumMainCardViewHolder.AnonymousClass1 */

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                ActionManager.startV8AlbumDetailActivity((Activity) AlbumMainCardViewHolder.this.getContext(), (Entity) entities.get(i - 1));
                            }
                        });
                    } else if (size > i) {
                        albumListItemCardNonupleItemBinding.setAlbum((Album) entities.get(i));
                        this.childView.setOnClickListener(new View.OnClickListener() {
                            /* class com.coolapk.market.viewholder.AlbumMainCardViewHolder.AnonymousClass2 */

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                ActionManager.startV8AlbumDetailActivity((Activity) AlbumMainCardViewHolder.this.getContext(), (Entity) entities.get(i));
                            }
                        });
                    }
                } else {
                    albumListItemCardNonupleItemBinding.getRoot().setVisibility(8);
                }
            } else {
                if (i > 7) {
                    this.childView = null;
                }
                View view = this.childView;
                if (view == null) {
                    albumListItemCardNonupleItemBinding.getRoot().setVisibility(8);
                } else if (size > i) {
                    view.setOnClickListener(new View.OnClickListener() {
                        /* class com.coolapk.market.viewholder.AlbumMainCardViewHolder.AnonymousClass3 */

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ActionManager.startV8AlbumDetailActivity((Activity) AlbumMainCardViewHolder.this.getContext(), (Entity) entities.get(i));
                        }
                    });
                    albumListItemCardNonupleItemBinding.getRoot().setVisibility(0);
                    albumListItemCardNonupleItemBinding.setAlbum((Album) entities.get(i));
                }
            }
        }
    }
}
