package com.coolapk.market.model;

import java.util.List;

public interface Card<T> extends Entity {
    @Override // com.coolapk.market.model.Entity
    String getDescription();

    List<T> getEntities();

    @Override // com.coolapk.market.model.Entity
    String getTitle();

    @Override // com.coolapk.market.model.Entity
    String getUrl();
}
