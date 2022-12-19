package com.example.teamproject

import android.graphics.Bitmap
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.teamproject.databinding.ItemMainBinding

class MyAdapter (val datas: MutableList<Bitmap>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    class MyViewHolder(val binding: ItemMainBinding): RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int = datas.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MyViewHolder(ItemMainBinding.inflate(LayoutInflater.from(parent.context),parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val binding = (holder as MyViewHolder).binding
        // 뷰에 데이터 출력
        //binding.itemData.src = datas[position]
        binding.itemData.setImageBitmap(datas[position])
    }
}