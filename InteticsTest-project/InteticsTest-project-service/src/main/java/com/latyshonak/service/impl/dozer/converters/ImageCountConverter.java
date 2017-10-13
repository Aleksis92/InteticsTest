package com.latyshonak.service.impl.dozer.converters;

import org.dozer.DozerConverter;

import java.util.ArrayList;
import java.util.List;

public class ImageCountConverter  extends DozerConverter<List, List> {

    public ImageCountConverter() {
        super(List.class, List.class);
    }

    @Override
    public List convertTo(List source, List destination) {
        List imageList = source;
        return imageList;
    }

    @Override
    public List convertFrom(List source, List destination) {
        return new ArrayList<>();
    }
}
