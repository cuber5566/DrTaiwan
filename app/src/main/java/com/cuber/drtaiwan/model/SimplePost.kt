package com.cuber.drtaiwan.model

data class SimplePost(

        var id: String,
        var title: String,
        var subtitle: String,
        var simpleDoctor: SimpleDoctor,
        var favoriteCount: Int,
        var responseCount: Int,
        var createTime: String,
        var updateTime: String
)