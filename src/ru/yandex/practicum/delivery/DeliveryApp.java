package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> allFragile = new ArrayList<>();
    private static ParcelBox<StandardParcel> standartBox = new ParcelBox<>(50);
    private static ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(20);
    private static ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(30);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportStatusAll();
                    break;
                case 5:
                    showBoxContent();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Изменить статус хрупких посылок");
        System.out.println("5 — Показать содержимое коробки ");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("Выберите тип посылки:\n1 - Стандартная\n2 - Скоропортящаяся\n3 - Хрупкая");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 2){
            System.out.println("Введите описание, вес, адрес доставки, дату отправления, срок жизни");
            String description = scanner.nextLine();
            double weight = Double.parseDouble(scanner.nextLine());
            String deliveryAddress = scanner.nextLine();
            int sendDay = Integer.parseInt(scanner.nextLine());
            int timeToLive = Integer.parseInt(scanner.nextLine());

            Parcel parcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
            allParcels.add(parcel);
            System.out.println("Скоропортящаяся посылка добавлена в общий список посылок");
            perishableBox.addParcel((PerishableParcel) parcel);

        } else if (choice == 1) {
            System.out.println("Введите описание, вес, адрес доставки, дату отправления.");
            String description = scanner.nextLine();
            double weight = Double.parseDouble(scanner.nextLine());
            String deliveryAddress = scanner.nextLine();
            int sendDay = Integer.parseInt(scanner.nextLine());

            Parcel parcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
            allParcels.add(parcel);
            System.out.println("Стандартная посылка добавлена в общий список посылок");
            standartBox.addParcel((StandardParcel) parcel);


        } else if (choice == 3){
            System.out.println("Введите описание, вес, адрес доставки, дату отправления.");
            String description = scanner.nextLine();
            double weight = Double.parseDouble(scanner.nextLine());
            String deliveryAddress = scanner.nextLine();
            int sendDay = Integer.parseInt(scanner.nextLine());

            Parcel parcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
            allParcels.add(parcel);
            allFragile.add((Trackable) parcel);
            System.out.println("Хрупкая посылка добавлена в общий список посылок");
            fragileBox.addParcel((FragileParcel) parcel);

        } else {
            System.out.println("Некорректный тип посылки");
        }
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels){
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        double priceAll = 0;
        for (Parcel parcel : allParcels){
            priceAll += parcel.calculateDeliveryCost();
        }
        System.out.println("Total cost: " + priceAll);
    }

    private static void reportStatusAll() {
        System.out.println("Введите новый адрес доставки для всех хрупких посылок");
        String newDestination = scanner.nextLine();
        for (Trackable parcel : allFragile) {
            parcel.reportStatus(newDestination);
        }
    }

    private static void showBoxContent() {
        System.out.println("Выберите тип коробки: Стандартная (1), Хрупкая(2), Скоропортящаяся(3)");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            System.out.println(standartBox.getAllParcels());
        } else if (choice == 2) {
            System.out.println(fragileBox.getAllParcels());
        } else if (choice == 3) {
            System.out.println(perishableBox.getAllParcels());
        } else {
            System.out.println("Incorrect input");
        }
    }

}
