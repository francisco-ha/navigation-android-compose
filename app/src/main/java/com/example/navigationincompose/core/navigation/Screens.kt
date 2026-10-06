package com.example.navigationincompose.core.navigation

import kotlinx.serialization.Serializable


//Aqui se definen todas las vistas las cuales son objetos
@Serializable
object Login
@Serializable
object Home
@Serializable
data class Detail(val name: String)