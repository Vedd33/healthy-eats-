package com.purehealthyeats.app.repository;

import com.purehealthyeats.app.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByItemTypeAndAvailableTrue(MenuItem.ItemType itemType);
    List<MenuItem> findByAvailableTrue();
}
