package com.example.bus.bNav

import com.example.bus.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String) {

    object Home : BottomNavItem("Билеты", R.drawable.ic_home,"home")
    object Schelude: BottomNavItem("Расписание",R.drawable.ic_list,"schedule")
    object Profile: BottomNavItem("Профиль",R.drawable.ic_person,"profile")
}
