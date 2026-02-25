package com.douglasrondini.movinvel.ui.fragment.motorista.corridas.model
sealed class CorridaItem {
    data class Header(
        val title: String
    ): CorridaItem()
    data class Corridas(
        var imgPerfil: Int,
        var name: String,
        var type: String,
        var value: String,
        var time: String,
        var status: String,
        var cashBack: String,
        var from: String,
        var to: String
    ): CorridaItem()

}

