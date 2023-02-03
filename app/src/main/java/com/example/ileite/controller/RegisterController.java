package com.example.ileite.controller;

import android.content.Context;

import com.example.ileite.model.Cow;
import com.example.ileite.repository.CowRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Vector;

public class RegisterController {

    private Context context;

    public RegisterController(Context context) {
        this.context = context;
    }

    private CowRepository instanceRepository() {
        CowRepository cowRepository = new CowRepository(context);
        return cowRepository;
    }

    public Vector<Cow> searchCows() throws Exception {
        return instanceRepository().searchEvents();
    }

    public boolean cowInsert(Cow newCow) {
        if (newCow != null) {
            return instanceRepository().insertEvent(newCow);
        }

        return false;
    }

    public boolean cowInsert(
            String cowName,
            Integer isHeifer,
            Integer age,
            Double amountMilk,
            Double weight,
            LocalDate registerDate
    ) {
        if (cowName != null &&
                age != null &&
                amountMilk != null &&
                weight != null
        ) {

            Cow newCow = new Cow(cowName, isHeifer, age, amountMilk, weight, registerDate);

            return cowInsert(newCow);
        } else {
            return false;
        }
    }

    public Double milkAvarege() {
        List<Cow> cows = instanceRepository().searchEvents();
        double total = 0;

        for (int index = 0; index < cows.size(); index++) {
            total += cows.get(index).getAmountMilk();
        }

        return Math.ceil(total / cows.size());
    }

    public Double totalMilk() {
        List<Cow> cows = instanceRepository().searchEvents();
        double total = 0;

        for (int index = 0; index < cows.size(); index++) {
            total += cows.get(index).getAmountMilk();
        }

        return total;
    }
}
