package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel{
    int timeToLive;
    final int price = 3;

    public PerishableParcel(String description, double weight, String deliveryAddress, int sendDay, int timeToLive) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay){
        return (currentDay > sendDay + timeToLive);
    }

    @Override
    public double calculateDeliveryCost() {
        return weight * price;
    }

}
