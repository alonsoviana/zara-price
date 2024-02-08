package com.zara.apiprices.infra.adapter.in.mapper;

import com.zara.apiprices.domain.Price;
import com.zara.apiprices.infra.adapter.in.dto.PriceRs;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PriceRsMapper {
    public abstract List<PriceRs> toPriceRsList(List<Price> prices);
}
