package com.example.teamproject

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Gallery
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teamproject.databinding.ActivityWritingBinding
import com.example.teamproject.databinding.FragmentCalendarBinding
import com.example.teamproject.databinding.ItemMainBinding

class WritingActivity : AppCompatActivity() {
    val Gallery = 0
    lateinit var binding: ActivityWritingBinding
    lateinit var bitmap: Bitmap
    val datas = mutableListOf<Bitmap>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWritingBinding.inflate(layoutInflater)
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

        // 날짜 정보 받아오기
        val selectedDate = intent.getStringExtra("date")
        binding.currdate.setText(selectedDate)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MyAdapter(datas)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.recyclerView.layoutManager = layoutManager

        // 사진추가 버튼 클릭 시 갤러리에서 사진 추가해주기
        // https://taekwang.tistory.com/2
        binding.addImage.setOnClickListener{
            loadImage()
        }

        // 저장버튼 클릭 시 fragment로 데이터 전달
        binding.btnSave.setOnClickListener{
            // 화면에서 데이터 받아오기

            // 데이터 fragment로 전달
            finish()

        }

    }

    // 갤러리로부터 가져온 이미지 layout에 띄우기
    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == Gallery){
            if(resultCode == RESULT_OK){
                var dataUri = data?.data
                try{
                    bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, dataUri)
                    datas.add(bitmap)
                    (binding.recyclerView.adapter as MyAdapter).notifyDataSetChanged()
                }catch(e: Exception){
                    Toast.makeText(this,"$e",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }



    // 갤러리로부터 이미지 가져오는 함수
    private fun loadImage(){
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(Intent.createChooser(intent, "load picture"), Gallery)
    }
}