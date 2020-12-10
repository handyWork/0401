package com.testPackage.DesignMode.converter;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 转换器
 *
 * @param <T>
 * @param <C>
 */
public abstract class Converter<T, C> {
    private final Function<T, C> fromDto;
    private final Function<C, T> fromEntity;

    public Converter(final Function<T, C> fromDto, final Function<C, T> fromEntity) {
        this.fromDto = fromDto;
        this.fromEntity = fromEntity;
    }

    public final C converterFromDto(final T customerDto) {
        return (fromDto.apply(customerDto));
    }

    public final T convertFromEntity(final C customer) {
        return (fromEntity.apply(customer));
    }

    public final List<C> creatFromDtos(final Collection<T> dtoCustomers) {

        return dtoCustomers.stream().map(this::converterFromDto).collect(Collectors.toList());
    }

    public final List<T> creatFromEntity(final Collection<C> customers) {

        return customers.stream().map(this::convertFromEntity).collect(Collectors.toList());

    }
}
