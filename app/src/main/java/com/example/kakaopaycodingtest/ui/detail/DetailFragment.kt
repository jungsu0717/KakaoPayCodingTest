package com.example.kakaopaycodingtest.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kakaopaycodingtest.R
import com.example.kakaopaycodingtest.ui.search.SearchFragment
import com.example.kakaopaycodingtest.ui.search.SearchViewModel

class DetailFragment : Fragment() {


    companion object {
        fun newInstance() = DetailFragment()
    }
    private lateinit var detailViewModel: DetailViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        detailViewModel =
                ViewModelProviders.of(this).get(DetailViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_detail, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        detailViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }


}