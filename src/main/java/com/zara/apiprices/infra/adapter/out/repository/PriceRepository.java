package com.zara.apiprices.infra.adapter.out.repository;

import com.zara.apiprices.infra.adapter.out.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository extends JpaRepository<PriceEntity, Integer> {
    List<PriceEntity> findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfter(
        Long brandId, Long productId, LocalDateTime applicationDateBefore, LocalDateTime applicationDateAfter);
}
