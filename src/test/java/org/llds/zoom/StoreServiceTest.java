package org.llds.zoom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreServiceTest {

    @Test
    void getStoreByLocationId() {
        StoreService storeService = new StoreService();
        storeService.add(Store.builder()
                        .name("ABC")
                        .locationId(123)
                .build());
        storeService.add(Store.builder()
                .name("XYZ")
                .locationId(123)
                .build());
        storeService.add(Store.builder()
                .name("HIJ")
                .locationId(124)
                .build());
        assertTrue(storeService.getStoreByLocationId(123)
                .stream()
                .anyMatch(x->x.getName().equalsIgnoreCase("ABC")));
        assertFalse(storeService.getStoreByLocationId(123)
                .stream()
                .anyMatch(x->x.getName().equalsIgnoreCase("HIJ ")));

    }
}