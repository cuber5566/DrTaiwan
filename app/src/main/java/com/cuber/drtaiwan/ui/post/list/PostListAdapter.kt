package com.cuber.drtaiwan.ui.post.list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.cuber.drtaiwan.R
import com.cuber.drtaiwan.extension.setColor
import com.cuber.drtaiwan.model.SimplePost
import com.cuber.drtaiwan.ui.post.PostPresenterImp
import kotlinx.android.synthetic.main.item_simple_post.view.*

internal class PostListAdapter(private val context: Context, private val presenter: PostPresenterImp) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var simplePostList: List<SimplePost>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
        val layoutInflater = LayoutInflater.from(context)
        return SimplePostViewHolder(layoutInflater.inflate(R.layout.item_simple_post, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is SimplePostViewHolder) {

            simplePostList!![position].run {

                holder.doctorName.text = simpleDoctor.name
                holder.doctorTitle.text = simpleDoctor.title
                holder.clinicName.text = simpleDoctor.clinicName
                holder.title.text = title
                holder.subtitle.text = subtitle
                holder.favoriteCount.text = favoriteCount.toString()
                holder.responseCount.text = responseCount.toString()

                if (presenter.isBookmark(id)) {
                    holder.addBookmark.drawable.setColor(context, R.color.colorPrimary)
                } else {
                    holder.addBookmark.drawable.setColor(context, R.color.black_text_disabled)
                }

                if (presenter.isFavorite(id)) {
                    holder.addFavorite.drawable.setColor(context, R.color.favorite)
                } else {
                    holder.addFavorite.drawable.setColor(context, R.color.black_text_disabled)
                }

                Glide.with(context).load(simpleDoctor.avatar).into(holder.doctorAvatar)
            }
        }
    }

    override fun getItemCount(): Int {
        return simplePostList?.size ?: 0
    }

    private inner class SimplePostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val doctorAvatar = itemView.doctorAvatar!!
        val doctorTitle = itemView.doctorTitle!!
        val doctorName = itemView.doctorName!!
        val clinicName = itemView.clinicName!!
        val title = itemView.title!!
        val subtitle = itemView.subTitle!!
        val favoriteCount = itemView.favoriteCount!!
        val responseCount = itemView.responseCount!!
        val addBookmark = itemView.addBookmark!!
        val addFavorite = itemView.addFavorite!!
    }
}
