package com.sangeetha.grocy.util

import com.sangeetha.grocy.util.Route.HOME
import com.sangeetha.grocy.util.Route.SPLASH_SCREEN

sealed class Screens(val route: String) {
    object Splash: Screens(SPLASH_SCREEN)
    object Home: Screens(HOME)
}
