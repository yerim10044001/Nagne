package com.example.teamproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Gallery
import android.widget.Spinner
import com.example.teamproject.databinding.ActivityWritingBinding

class WritingActivity : AppCompatActivity() {
    val Gallery = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityWritingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // category 선택 스피너 구현
        // https://developer.android.com/guide/topics/ui/controls/spinner?hl=ko
        val spinner: Spinner = binding.spinner
        ArrayAdapter.createFromResource(
            this,
            R.array.category,
            android.R.layout.simple_spinner_item
        ).also{
            adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        // 사진추가 버튼 클릭 시 갤러리에서 사진 추가해주기
        // https://taekwang.tistory.com/2
        binding.addImage.setOnClickListener{ loadImage() }

    }

    // 갤러리로부터 이미지 가져오는 함수
    private fun loadImage(){
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(Intent.createChooser(intent, "load picture"), Gallery)
    }
}