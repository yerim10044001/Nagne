package com.example.teamproject

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.teamproject.databinding.FragmentCalendarBinding
import com.example.teamproject.databinding.FragmentDiaryviewBinding
import java.time.LocalDate
import java.time.format.DateTimeFormatter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DiaryviewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DiaryviewFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentDiaryviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDiaryviewBinding.inflate(inflater, container, false)
        binding.backBtn.setOnClickListener{

        }

        // 오늘 날짜로 default 설정
        val currentDate: LocalDate = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")
        val formatted = currentDate.format(formatter)
        val selectedDate = formatted

        binding.editBtn.setOnClickListener{
            val intent: Intent = Intent(activity, EditActivity::class.java)
            intent.putExtra("date",selectedDate)
            intent.putExtra("text",binding.dirText.text)
            startActivity(intent)
        }
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DiaryviewFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DiaryviewFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}