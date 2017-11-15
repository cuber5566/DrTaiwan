package com.cuber.drtaiwan.model

/**
 * Created by cuber on 2017/11/14.
 */
data class Post(

     var id: String,
     var title: String,
     var subtitle: String,
     var simpleDoctor: SimpleDoctor,
     var likeCount: Int,
     var clinic: Clinic,
     var createTime: String,
     var updateTime: String
)
