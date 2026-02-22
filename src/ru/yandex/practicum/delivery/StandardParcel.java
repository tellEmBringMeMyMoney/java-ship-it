package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel{
    final int price = 2;

    public StandardParcel(String description, double weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    @Override
    public double calculateDeliveryCost() {
        return weight * price;
    }
}
