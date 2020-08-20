package com.bottomfeeder.serviceapi;

import java.util.List;

import com.bottomfeeder.model.ProductLine;

public interface IClassicModelsSerivce {
    List<ProductLine> FindAllProductLines();

    List<ProductLine> FindByCode(int code);

    void Bingo();
}
