package service;


import entity.Currency;
import service.impl.NbrbCurrencyConversionService;

import java.io.IOException;

public interface CurrencyConversionService {

    static CurrencyConversionService getInstance() {
        return new NbrbCurrencyConversionService();
    }

    double getConversionRatio(Currency original, Currency target) throws IOException;
}
