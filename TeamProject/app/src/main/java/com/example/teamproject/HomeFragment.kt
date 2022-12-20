package com.example.teamproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.teamproject.databinding.FragmentCalendarBinding
import com.example.teamproject.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        val mActivity = activity as MainActivity2
        val travelDiaryBtn: Button = rootView.findViewById(R.id.travelDiary)
        val travleRecommendBtn: Button = rootView.findViewById(R.id.travelRecommend)
        travelDiaryBtn.setOnClickListener {
            mActivity.changeFragment(1)
        }
        travleRecommendBtn.setOnClickListener {
            mActivity.changeFragment(3)
        }
        val jejuBtn: Button = rootView.findViewById(R.id.jeju_btn)
        val chumBtn: Button = rootView.findViewById(R.id.chum_btn)
        val haeBtn: Button = rootView.findViewById(R.id.hae_btn)
        jejuBtn.setOnClickListener{
            val intent: Intent = Intent(activity, jejuActivity::class.java)
            startActivity(intent)
        }

        chumBtn.setOnClickListener{
            val intent: Intent = Intent(activity, ChumActivity::class.java)
            startActivity(intent)
        }

        haeBtn.setOnClickListener{
            val intent: Intent = Intent(activity, HaeActivity::class.java)
            startActivity(intent)
        }

        // Inflate the layout for this fragment
        return rootView
    }


}