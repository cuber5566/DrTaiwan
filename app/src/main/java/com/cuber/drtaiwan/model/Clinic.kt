package com.cuber.drtaiwan.model

/**
 * Created by cuber on 2017/11/14.
 */
data class Clinic(

        var id: String,
        var name: String,
        var division: Division,
        var lat: Double,
        var lng: Double,
        var address: String,
        var open: String
)