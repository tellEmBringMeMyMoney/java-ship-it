package ru.yandex.practicum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DeliveryCostTest {

    @Test
    public void everyParcelPrice() {
        StandardParcel standardParcel = new StandardParcel("standard", 20, "moscow", 20);
        FragileParcel fragileParcel = new FragileParcel("fragile", 10, "spb", 20);
        PerishableParcel perishableParcel = new PerishableParcel("perishable", 15, "ekb", 20, 8);

        double standardPrice = standardParcel.calculateDeliveryCost();
        double fragilePrice = fragileParcel.calculateDeliveryCost();
        double perishablePrice = perishableParcel.calculateDeliveryCost();

        assertEquals(40, standardPrice);
        assertEquals(40, fragilePrice);
        assertEquals(45, perishablePrice);
    }

    @Test
    public void isExpiredTest() {
        PerishableParcel perishableParcel = new PerishableParcel("perishable", 15, "ekb", 20, 8);
        boolean isExpiredCheckFalse = perishableParcel.isExpired(25);
        boolean isExpiredCheckTrue = perishableParcel.isExpired(30);

        assertFalse(isExpiredCheckFalse);
        assertTrue(isExpiredCheckTrue);
    }

    @Test
    public void addNewParcelTest() {
        ParcelBox<FragileParcel> perishableBox = new ParcelBox<>(30);
        FragileParcel fragileParcel1 = new FragileParcel("fragile1", 20, "spb", 20);
        FragileParcel fragileParcel2 = new FragileParcel("fragile2", 10, "spb", 20);
        FragileParcel fragileParcel3 = new FragileParcel("fragile3", 10, "spb", 20);

        String result1 = perishableBox.addParcel(fragileParcel1);
        String result2 = perishableBox.addParcel(fragileParcel2);
        String result3 = perishableBox.addParcel(fragileParcel3);

        assertEquals("Посылка fragile1 добавлена в коробку", result1);
        assertEquals("Посылка fragile2 добавлена в коробку", result2);
        assertEquals("Коробка перегружена, посылку не добавить.", result3);


    }

}

