package com.example.myapplication.network.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.BR
import com.example.myapplication.R
import com.example.myapplication.databinding.PostListItemBinding
import com.example.myapplication.network.model.PostInfo


class PostListAdapter(var context: Context) : RecyclerView.Adapter<PostListAdapter.ViewHolder>() {
    private  var list: List<PostInfo> = emptyList<PostInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding: PostListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.post_list_item, parent, false)
        return PostListAdapter.ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("ADapter","Info:::"+list.get(position).body)
        holder.bind(list.get(position))
    }

    fun setAdapterList(list: List<PostInfo> ){
     this.list = list
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int = list.size

    class ViewHolder(val binding: com.example.myapplication.databinding.PostListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Any) {
            binding.setVariable(BR.postmodel, data) //BR - generated class; BR.user - 'user' is variable name declared in layout
            binding.executePendingBindings()
        }
    }
}


//https://yamikrish.blogspot.com/2018/12/databinding-in-recyclerview-android.html