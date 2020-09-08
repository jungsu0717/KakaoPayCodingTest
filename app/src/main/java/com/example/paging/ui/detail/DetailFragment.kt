package com.example.paging.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.paging.R
import com.example.paging.base.BaseFragment
import com.example.paging.databinding.FragmentDetailBinding
import com.example.paging.model.data.DocumentsData
import java.lang.Exception

class DetailFragment : BaseFragment<DetailViewModel, FragmentDetailBinding>(), DetailView {

    companion object {
        fun newInstance() = DetailFragment()
    }

    private lateinit var detailViewModel: DetailViewModel

    override val layoutRes: Int
        get() = R.layout.fragment_detail

    override fun getViewModel(): Class<DetailViewModel> {
        return DetailViewModel::class.java
    }

    override fun onError() {
        Toast.makeText(activity, "오류가 발생했습니다.", Toast.LENGTH_SHORT).show()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.setNavigator(this)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel


        arguments?.getSerializable("data")?.let {
            viewModel.liveData.value = it as DocumentsData
        }
    }

    // 상세페이지 URL 이동
    override fun goDetail(url: String?) {

        try {
            context?.let {
                ContextCompat.startActivity(
                    it,
                    Intent(Intent.ACTION_VIEW, Uri.parse(url)
                    ), null) }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}