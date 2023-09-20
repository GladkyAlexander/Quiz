package ru.great_larder.sportquiz.services;

public class GetNamesVictik {
    public String getVictik(int x){
        String res = "Виктиков";
        if (x == 1) return "Виктик";
        if (x == 2 || x == 3 || x == 4) return "Виктика";
        return res;
    }
}
