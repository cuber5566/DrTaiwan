package com.cuber.drtaiwan.ui.post.list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cuber.drtaiwan.R
import com.cuber.drtaiwan.extension.setColor
import com.cuber.drtaiwan.model.SimplePost
import com.cuber.drtaiwan.ui.post.PostPresenter
import kotlinx.android.synthetic.main.item_simple_post.view.*

internal class PostListAdapter(private val context: Context, private val presenter: PostPresenter) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val postList: List<SimplePost>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
        val layoutInflater = LayoutInflater.from(context)
        return SimplePostViewHolder(layoutInflater.inflate(R.layout.item_simple_post, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val simplePost = postList!![position]

        if (holder is SimplePostViewHolder) {
            holder.doctorName.text = simplePost.simpleDoctor.name
            holder.doctorTitle.text = simplePost.simpleDoctor.title
            holder.clinicName.text = simplePost.simpleDoctor.clinic.name
            holder.title.text = simplePost.title
            holder.subtitle.text = simplePost.subtitle
            holder.favoriteCount.text = simplePost.favoriteCount.toString()
            holder.responseCount.text = simplePost.responseCount.toString()

            if (presenter.isBookmark(simplePost.id)) {
                holder.addBookmark.drawable.setColor(context, R.color.colorPrimary)
            } else {
                holder.addBookmark.drawable.setColor(context, R.color.black_text_disabled)
            }

            if (presenter.isFavorite(simplePost.id)) {
                holder.addFavorite.drawable.setColor(context, R.color.colorAccent)
            } else {
                holder.addFavorite.drawable.setColor(context, R.color.black_text_disabled)
            }
        }
    }

    override fun getItemCount(): Int {
        return postList?.size ?: 0
    }

    private inner class SimplePostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

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
