package com.nbgsoftware.adapter

import android.content.Context
import android.view.LayoutInflater
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewAdapter<T>(context: Context, private val mCollection: List<T>?) :
    RecyclerView.Adapter<BaseViewAdapter.BindingViewHolder<T>>() {

    private var onItemClickListener: OnItemClickListener? = null

    private val mLayoutInflater by lazy {
        LayoutInflater.from(context)
    }

    override fun onBindViewHolder(holder: BindingViewHolder<T>, position: Int) {
        val item: T = mCollection?.get(position)!!
        holder.bindData(item)
    }


    override fun getItemCount(): Int {
        if (mCollection == null) {
            return 0
        }
        return mCollection.size
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    @LayoutRes
    protected abstract fun layoutId(): Int

    class BindingViewHolder<T>(
        val binding: ViewBinding,
        onItemClickListener: OnItemClickListener? = null
    ) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onItemClickListener?.onItemClick(adapterPosition)
            }
        }

        fun bindData(item: T) {

        }
    }
}
