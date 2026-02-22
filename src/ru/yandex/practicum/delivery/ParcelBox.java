package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {
    private ArrayList<T> box = new ArrayList<>();
    double maxWeight;

    public ParcelBox(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public String addParcel(T parcel){
        if (parcel.getWeight() + getBoxWeight() <= maxWeight){
            box.add(parcel);
            return "Посылка "+ parcel.description +" добавлена в коробку";
        } else {
            return "Коробка перегружена, посылку не добавить.";
        }
    }

    public ArrayList<T> getAllParcels(){
        return box;
    }

    private double getBoxWeight(){
        double weight = 0;
        for (T parcel : box){
            weight += parcel.getWeight();
        }
        return weight;
    }
}
