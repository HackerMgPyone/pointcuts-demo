package org.example;

import org.example.ds.CurrencyType;
import org.example.service.AnotherCurrencyService;
import org.example.service.CurrencyService;
import org.example.service.MyCurrencyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        CurrencyService currencyService = context.getBean(CurrencyService.class);
        currencyService.changeCurrency(100);
        AnotherCurrencyService anotherCurrencyService =
                context.getBean(AnotherCurrencyService.class);
        anotherCurrencyService.changeCurrencyName("USD");

        MyCurrencyService myCurrencyService =
                context.getBean(MyCurrencyService.class);

        myCurrencyService.changeCurrency(700);
        myCurrencyService.changeCurrency(300,150);

        myCurrencyService.changeCurrencyName(CurrencyType.US,1000);

        myCurrencyService.changeCurrencyCountryName(CurrencyType.US);

        try{
            myCurrencyService.changeCurrencyCountryName(CurrencyType.EURO);
        }catch (IllegalArgumentException e){
            System.out.println("Exception caught::"+ e);
        }
    }
}