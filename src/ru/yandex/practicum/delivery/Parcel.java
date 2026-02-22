package ru.yandex.practicum.delivery;

public abstract class Parcel {
    protected String description;
    protected Double weight;
    protected String deliveryAddress;
    protected int sendDay;


    void packageItem() {
        System.out.println("Посылка "+ description +" упакована");
    }

    void deliver() {
        System.out.println("Посылка "+ description +" доставлена по адресу "+ deliveryAddress);
    }

    double calculateDeliveryCost() {
        return 0;
    }

    double getWeight(){
        return weight;
    }

    @Override
    public String toString() {
        String result = "Послыка " + description + ", весом " + weight;
        return result;
    }
}
