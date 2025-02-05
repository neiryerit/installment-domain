package com.melita.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.melita.product.entity.Bundle;

public interface IBundleRepo extends JpaRepository<Bundle, Long> {

    final String BUNDLES_BY_PRODUCT = """
            SELECT b FROM Bundle b WHERE b.product.id=?1
            """;

    @Query(BUNDLES_BY_PRODUCT)
    List<Bundle> findBundlesByProduct(long productId);
}
