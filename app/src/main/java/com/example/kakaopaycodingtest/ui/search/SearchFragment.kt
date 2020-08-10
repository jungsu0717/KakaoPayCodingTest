package com.example.kakaopaycodingtest.ui.search

import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.SearchView.OnQueryTextListener
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kakaopaycodingtest.R
import com.example.kakaopaycodingtest.base.BaseFragment
import com.example.kakaopaycodingtest.common.SeparatorDecoration
import com.example.kakaopaycodingtest.databinding.FragmentSearchBinding
import com.example.kakaopaycodingtest.model.data.DocumentsData
import com.example.kakaopaycodingtest.model.data.RequestData
import com.example.kakaopaycodingtest.model.type.SpinnerType
import com.example.kakaopaycodingtest.repository.NetworkState
import kotlinx.android.synthetic.main.fragment_search.*
import javax.inject.Inject

class SearchFragment : BaseFragment<SearchViewModel, FragmentSearchBinding>(), SearchView,
    SearchAdapter.ItemClickListener {

    companion object {
        fun newInstance() = SearchFragment()
    }

    @Inject
    lateinit var mAdapter: SearchAdapter

    private var sortValue = SpinnerType.ACCURACY

    override val layoutRes: Int
        get() = R.layout.fragment_search

    override fun getViewModel(): Class<SearchViewModel> {
        return SearchViewModel::class.java
    }

    override fun onError() {
        Toast.makeText(activity, "오류가 발생했습니다.", Toast.LENGTH_SHORT).show()
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.lifecycleOwner = this
        viewModel.setNavigator(this)
        mAdapter.listener = this

        // Recycler View Setting
        rv_search.apply {
            setHasFixedSize(true)
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context)
        }

        // Search View Setting
        search_view.setOnQueryTextListener(object : OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                query.trim().let {
                    viewModel.requestData.value = RequestData(
                        query,
                        sortValue.getType(),
                        1,
                        null
                    )
                    mAdapter.submitList(null)
                }

                return false
            }

        })

        // Spinner Setting
        spinner_sort.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val reqData = viewModel.requestData.value

                val sort = spinner_sort.getItemAtPosition(position) as String?
                if (reqData != null) {
                    viewModel.requestData.value =
                        RequestData(
                            reqData.keyWord,
                            sort,
                            1,
                            null
                        )

                } else {

                    when (sort) {
                        SpinnerType.ACCURACY.getType() -> sortValue = SpinnerType.ACCURACY
                        SpinnerType.RECENCY.getType() -> sortValue = SpinnerType.RECENCY
                    }


                }

            }
        }

        // Swipe Refresh Layout Setting
        swipe_refresh.setOnRefreshListener {
            viewModel.refresh()
        }

        // Data Observe
        observeData()
    }

    private fun observeData() {

        viewModel.searchData.observe(viewLifecycleOwner, Observer {
            mAdapter.submitList(it)
        })

        viewModel.networkState.observe(viewLifecycleOwner, Observer {
            swipe_refresh.isRefreshing = it == NetworkState.LOADING
            if (it != NetworkState.LOADING) {
                empty_view.visibility = if (viewModel.listIsEmpty()) View.VISIBLE else View.GONE
            }
        })
    }


    override fun onClick(data: DocumentsData) {
        findNavController().navigate(
            R.id.action_go_detail,
            bundleOf("data" to data)
        )
    }


}