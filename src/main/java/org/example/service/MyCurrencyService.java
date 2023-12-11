package org.example.service;

import org.example.ds.CurrencyType;
import org.springframework.stereotype.Service;

@Service
public class MyCurrencyService {
    public void changeCurrency(int amount,int to) {

    }
    public void changeCurrency(int amount) {

    }
    public int changeCurrencyName(CurrencyType currencyType,int amount){
        return amount;
    }
    public String changeCurrencyCountryName(CurrencyType type){
        if (type.name().equals("US")){
            return "USA";
        }else
            throw new IllegalArgumentException();
    }
}
