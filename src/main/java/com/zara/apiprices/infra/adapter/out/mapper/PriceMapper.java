package com.zara.apiprices.infra.adapter.out.mapper;

import com.zara.apiprices.domain.Price;
import com.zara.apiprices.infra.adapter.out.entity.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PriceMapper {
    @Mappings({
            @Mapping(source = "brand.id", target = "brandId"),
            @Mapping(source = "brand.name", target = "brandName")
    })
    public abstract Price toPrice(PriceEntity priceEntity);
    public abstract List<Price> toPriceList(List<PriceEntity> priceEntities);
}
