package com.enes_08.recyclerviewmultiple.adapter

import android.app.Activity
import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.enes_08.recyclerviewmultiple.R
import com.enes_08.recyclerviewmultiple.model.Post
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.item_post_text.view.*

class PostAdapter(var Context: Activity, var PostData: ArrayList<Post>) :
    RecyclerView.Adapter<ViewHolder>() {
    var mContext: Activity
    var mPostlist: ArrayList<Post>
    var mInflater: LayoutInflater
    var mLayoutManager: LinearLayoutManager

    init {
        mContext = Context
        mPostlist = PostData

        mInflater = LayoutInflater.from(mContext);
        mLayoutManager = LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);


        for (item in mPostlist) {
            print(item.mDate)
            print(item.mUser.name)

        }


    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        var type: Post.Type = Post.Type.values()[p1]


        if (Post.Type.TEXT == type) {

            var row: View = mInflater.inflate(R.layout.item_post_text, p0, false)
            var textViewHolder: TextPostViewHolder = TextPostViewHolder(row)

            return textViewHolder

        } else if (Post.Type.IMAGE == type) {

            var row: View = mInflater.inflate(R.layout.item_post_image, p0, false)
            var imageViewHolder: ImagePostViewHolder = ImagePostViewHolder(row)

            return imageViewHolder

        } else {

            var row: View = mInflater.inflate(R.layout.item_post_multiple, p0, false)
            var multipleViewHolder: MultiplePostViewHolder = MultiplePostViewHolder(row)

            return multipleViewHolder

        }


    }

    override fun getItemCount(): Int {

        return mPostlist.size

    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        var post: Post = mPostlist.get(p1)
        var type: Post.Type = Post.Type.values()[p0.getItemViewType()]


        if (Post.Type.TEXT == type) {
            var mTextPostViewHolder: TextPostViewHolder = p0 as TextPostViewHolder

            mTextPostViewHolder.cIvProfil.setBackgroundResource(mPostlist.get(p1).mUser.ımg)
            mTextPostViewHolder.tvDate.setText(mPostlist.get(p1).mDate)
            mTextPostViewHolder.tvText.setText(mPostlist.get(p1).mDescription)
            mTextPostViewHolder.tvTitle.setText(mPostlist.get(p1).mTitle)
            mTextPostViewHolder.tvUserName.setText(mPostlist.get(p1).mUser.name)
            mTextPostViewHolder.tvLikeCount.setText(mPostlist.get(p1).mLikeCount)
            mTextPostViewHolder.tvUserDescription.setText(mPostlist.get(p1).mUser.description)


        } else if (Post.Type.IMAGE == type) {

            var mImagePostViewHolder: ImagePostViewHolder = p0 as ImagePostViewHolder

            mImagePostViewHolder.cIvProfil.setBackgroundResource(mPostlist.get(p1).mUser.ımg)
            mImagePostViewHolder.tvDate.setText(mPostlist.get(p1).mDate)
            mImagePostViewHolder.ivImage.setBackgroundResource(mPostlist.get(p1).mImage)
            mImagePostViewHolder.tvTitle.setText(mPostlist.get(p1).mTitle)
            mImagePostViewHolder.tvUserName.setText(mPostlist.get(p1).mUser.name)
            mImagePostViewHolder.tvLikeCount.setText(mPostlist.get(p1).mLikeCount)
            mImagePostViewHolder.tvUserDescription.setText(mPostlist.get(p1).mUser.description)


        } else if (Post.Type.MULTİPLE == type) {
            var mMultiplePostViewHolder: MultiplePostViewHolder = p0 as MultiplePostViewHolder

            mMultiplePostViewHolder.cIvProfil.setBackgroundResource(mPostlist.get(p1).mUser.ımg)
            mMultiplePostViewHolder.tvDate.setText(mPostlist.get(p1).mDate)
            mMultiplePostViewHolder.ivImage.setBackgroundResource(mPostlist.get(p1).mImage)
            mMultiplePostViewHolder.tvText.setText(mPostlist.get(p1).mDescription)

            mMultiplePostViewHolder.tvTitle.setText(mPostlist.get(p1).mTitle)
            mMultiplePostViewHolder.tvUserName.setText(mPostlist.get(p1).mUser.name)
            mMultiplePostViewHolder.tvLikeCount.setText(mPostlist.get(p1).mLikeCount)
            mMultiplePostViewHolder.tvUserDescription.setText(mPostlist.get(p1).mUser.description)


        }

    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {

        recyclerView.layoutManager = mLayoutManager
    }

    override fun getItemViewType(position: Int): Int {

        var post: Post = mPostlist.get(position)

        return post.mType.ordinal
    }


    class TextPostViewHolder(row: View) : ViewHolder(row) {

        var tvDate: TextView
        var cIvProfil: CircleImageView
        var tvTitle: TextView
        var tvUserName: TextView
        var tvText: TextView
        var tvLikeCount: TextView
        var tvUserDescription: TextView


        init {


            tvDate = row.findViewById(R.id.tvDate)
            cIvProfil = row.findViewById(R.id.cIvProfil)
            tvTitle = row.findViewById(R.id.tvTitle)
            tvUserName = row.findViewById(R.id.tvUserName)
            tvText = row.findViewById(R.id.tvText)
            tvLikeCount = row.findViewById(R.id.tvLikeCount)
            tvUserDescription = row.findViewById(R.id.tvUserDescription)

        }


    }

    class ImagePostViewHolder(row: View) : ViewHolder(row) {

        var tvDate: TextView
        var cIvProfil: CircleImageView
        var tvTitle: TextView
        var tvUserName: TextView
        var ivImage: ImageView
        var tvLikeCount: TextView
        var tvUserDescription: TextView


        init {


            tvDate = row.findViewById(R.id.tvDate)
            cIvProfil = row.findViewById(R.id.cIvProfil)
            tvTitle = row.findViewById(R.id.tvTitle)
            tvUserName = row.findViewById(R.id.tvUserName)
            ivImage = row.findViewById(R.id.ivImage)
            tvLikeCount = row.findViewById(R.id.tvLikeCount)
            tvUserDescription = row.findViewById(R.id.tvUserDescription)


        }


    }

    class MultiplePostViewHolder(row: View) : ViewHolder(row) {

        var tvDate: TextView
        var cIvProfil: CircleImageView
        var tvTitle: TextView
        var tvUserName: TextView
        var ivImage: ImageView
        var tvText: TextView
        var tvLikeCount: TextView

        var tvUserDescription: TextView


        init {


            tvDate = row.findViewById(R.id.tvDate)
            cIvProfil = row.findViewById(R.id.cIvProfil)
            tvTitle = row.findViewById(R.id.tvTitle)
            tvUserName = row.findViewById(R.id.tvUserName)
            ivImage = row.findViewById(R.id.ivImage)
            tvText = row.findViewById(R.id.tvText)
            tvLikeCount = row.findViewById(R.id.tvLikeCount)
            tvUserDescription = row.findViewById(R.id.tvUserDescription)


        }


    }


}