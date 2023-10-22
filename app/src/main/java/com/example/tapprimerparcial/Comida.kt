package com.example.tapprimerparcial

data class Comida(
    val id:Int,
    val nombre:String,
    val dificultad:Int,
    val pais:Pais,
    val logo:String,
    val ingredientes: List<Ingredientes>,
)

enum class Pais{
    ARGENTINA, BRASIL, PARAGUAY, CHILE, COLOMBIA, MEXICO, PERU, EEUU
}

enum class Ingredientes{
    HARINA, AZUCAR, HUEVO, PECHUGA, CARNE, VEGETALES, ESPECIAS, PAN, SALCHICHA, PESCADO
}