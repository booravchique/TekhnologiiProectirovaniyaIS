package com.example.bus.bNav

import com.example.bus.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String) {

    object Home : BottomNavItem("Home", R.drawable.ic_home,"home")
    object Schelude: BottomNavItem("My Network",R.drawable.ic_list,"schedule")
    object Profile: BottomNavItem("Post",R.drawable.ic_person,"add_post")
}
