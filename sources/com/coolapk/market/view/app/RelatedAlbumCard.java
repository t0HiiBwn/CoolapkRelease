package com.coolapk.market.view.app;

import android.content.Context;
import android.os.Parcel;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.Card;
import com.coolapk.market.model.ServiceApp;
import java.util.List;

public class RelatedAlbumCard implements Card<Album> {
    public static final String ENTITY_TYPE = "related_album";
    private Context context;
    private final ServiceApp serviceApp;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.coolapk.market.model.Entity
    public Long getDateline() {
        return null;
    }

    @Override // com.coolapk.market.model.Card, com.coolapk.market.model.Entity
    public String getDescription() {
        return null;
    }

    @Override // com.coolapk.market.model.Entity
    public Integer getEntityFixed() {
        return null;
    }

    @Override // com.coolapk.market.model.Entity
    public String getEntityId() {
        return null;
    }

    @Override // com.coolapk.market.model.Entity
    public String getEntityTemplate() {
        return null;
    }

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "related_album";
    }

    @Override // com.coolapk.market.model.Entity
    public String getExtraData() {
        return null;
    }

    @Override // com.coolapk.market.model.Entity
    public String getId() {
        return null;
    }

    @Override // com.coolapk.market.model.Entity
    public Long getLastUpdate() {
        return null;
    }

    @Override // com.coolapk.market.model.Entity
    public String getLogo() {
        return null;
    }

    @Override // com.coolapk.market.model.Entity
    public String getPic() {
        return null;
    }

    @Override // com.coolapk.market.model.Entity
    public String getSubTitle() {
        return null;
    }

    @Override // com.coolapk.market.model.Card, com.coolapk.market.model.Entity
    public String getUrl() {
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }

    public RelatedAlbumCard(Context context2, ServiceApp serviceApp2) {
        this.context = context2.getApplicationContext();
        this.serviceApp = serviceApp2;
    }

    @Override // com.coolapk.market.model.Card, com.coolapk.market.model.Entity
    public String getTitle() {
        return this.context.getString(2131887017);
    }

    @Override // com.coolapk.market.model.Card
    public List<Album> getEntities() {
        return this.serviceApp.getAlbumRows();
    }

    @Override // com.coolapk.market.model.Entity
    public String getEntityTypeName() {
        return getTitle();
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }
}
