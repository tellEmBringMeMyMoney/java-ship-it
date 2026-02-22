package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable{
    final int price = 4;

    public FragileParcel(String description, double weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    @Override
    void packageItem() {
        System.out.println("Посылка "+ description +" обёрнута в защитную плёнку");
        super.packageItem();
    }

    @Override
    public double calculateDeliveryCost() {
        return weight * price;
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println(String.format("Хрупкая посылка %s изменила местоположение на %s", description, newLocation));
    }
}
