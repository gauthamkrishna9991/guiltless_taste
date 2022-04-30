package com.gouthamkrishnakv.guiltless_taste;

import java.util.UUID;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

public interface GiftRepository extends PanacheRepositoryBase<Gift, UUID> {
}
