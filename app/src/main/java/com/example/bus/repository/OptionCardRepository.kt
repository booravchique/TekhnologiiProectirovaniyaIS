package com.example.bus.repository

import com.example.model.OptionCard

class OptionCardRepository {

    fun getAllData(): List<OptionCard> {
        return listOf(
            OptionCard("Екатеринбург ",
                " Краснотурьинск",
                "16:15",
                "15 Ноября",
                "Мест доступно: ",
                12),
            OptionCard("Екатеринбург ",
                " Ирбит",
                "10:30",
                "15 Ноября",
                "Мест доступно: ",
                6),
            OptionCard("Екатеринбург ",
                " Серов",
                "12:40",
                "15 Ноября",
                "Мест доступно: ",
                15),
            OptionCard("Екатеринбург ",
                " Верхняя Пышма",
                "14:30",
                "15 Ноября",
                "Мест доступно: ",
                3),
            OptionCard("Екатеринбург ",
                " Кушваа",
                "17:50",
                "15 Ноября",
                "Мест доступно: ",
                20),
        )
    }
}