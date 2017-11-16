package com.cuber.drtaiwan.ui.post

/**
 * Created by cuber on 2017/11/16.
 */
interface PostPresenterImp {

    fun addFavorite(postId: String)

    fun addBookmark(postId: String)

    fun isFavorite(postId: String):Boolean

    fun isBookmark(postId: String):Boolean
}