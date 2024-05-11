package org.d3if3109.assessmentdua.navigation

sealed class Screen(val route: String) {
    object Home: Screen("mainScreen")
    object About: Screen("aboutScreen")
    object FormBaru: Screen("detailScreen")
    object FormUbah : Screen("detailScreen/{id}") {
        fun withId(id: Long) = "detailScreen/$id"
    }
}