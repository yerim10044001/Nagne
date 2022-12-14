package com.example.teamproject

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView.OnDateChangeListener
import androidx.fragment.app.Fragment
import com.example.teamproject.databinding.ActivityMainBinding
import com.example.teamproject.databinding.FragmentCalendarBinding
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CalendarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CalendarFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var binding: FragmentCalendarBinding
    lateinit var selectedDate: String

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

        binding = FragmentCalendarBinding.inflate(inflater, container, false)

        // 오늘 날짜로 default 설정
        val currentDate: LocalDate = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")
        val formatted = currentDate.format(formatter)
        selectedDate = formatted

        binding.diaryTextView.setText(formatted)
        // calendar 날짜 선택 시 아래 text 날짜 변경
        binding.calendarView.setOnDateChangeListener(OnDateChangeListener { view, year, month, dayOfMonth ->
            binding.diaryTextView.setVisibility(View.VISIBLE)
            selectedDate = String.format("%d년 %d월 %d일", year, month + 1, dayOfMonth)
            binding.diaryTextView.setText(selectedDate)

        })


        //버튼 클릭 시 일지 쓰는 화면으로 넘어가기
        binding.editBtn.setOnClickListener{
            val intent: Intent = Intent(activity, WritingActivity::class.java)
            intent.putExtra("date",selectedDate)
            startActivity(intent)
        }

        binding.picture1.setOnClickListener {
            val mActivity = activity as MainActivity2
            mActivity.changeFragment(2)
        }
        binding.picture2.setOnClickListener {
            val mActivity = activity as MainActivity2
            mActivity.changeFragment(4)

        }

        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CalendarFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CalendarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}