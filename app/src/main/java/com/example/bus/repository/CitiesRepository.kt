package com.example.bus.repository

import com.example.model.Cities

class CitiesRepository {

    fun getAllCitiesData(): List<Cities> {
        return listOf(
            Cities(
                "Екатеринбург - Алапаевск",
                "Ежедневно",
                "10:15 11:15 12:15 13:15 14:15 15:15 16:15 17:15",

                ),
            Cities(
                "Екатеринбург - Пермь",
                "Ежедневно",
                "10:15 11:15 12:15 15:15 16:15 17:15",

                ),
            Cities(
                "Екатеринбург - Ирбит",
                "ПН СР ЧТ",
                "10:15 ",

                ),
            Cities(
                "Екатеринбург - Кушва",
                "СБ ВС",
                "15:15 16:15 17:15",

                ),
            Cities(
                "Екатеринбург - Серов",
                "Ежедневно",
                "13:35 14:16",

                ),
            Cities(
                "Екатеринбург - Ивдель",
                "Ежедневно",
                "7:40",

                ),
            Cities(
                "Екатеринбург - Челябинск",
                "Ежедневно",
                "12:15 15:30 16:15 17:15",
                ),
        )
    }
}
