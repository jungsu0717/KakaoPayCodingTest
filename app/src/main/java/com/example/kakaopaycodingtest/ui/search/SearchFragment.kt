package com.example.kakaopaycodingtest.ui.search

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.paging.DataSource
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kakaopaycodingtest.R
import com.example.kakaopaycodingtest.base.BaseFragment
import com.example.kakaopaycodingtest.databinding.ActivityMainBinding
import com.example.kakaopaycodingtest.databinding.FragmentSearchBinding
import com.example.kakaopaycodingtest.model.data.DocumentsData
import com.example.kakaopaycodingtest.model.data.RequestData
import com.example.kakaopaycodingtest.ui.main.MainView
import com.example.kakaopaycodingtest.ui.main.MainViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_search.*
import java.util.*
import javax.inject.Inject

class SearchFragment : BaseFragment<SearchViewModel, FragmentSearchBinding>(), MainView,
    SearchAdapter.ItemClickListener {

    @Inject
    lateinit var adapter: SearchAdapter

    @Inject
    lateinit var layoutManager: LinearLayoutManager

    override val layoutRes: Int
        get() = R.layout.fragment_search

    override fun getViewModel(): Class<SearchViewModel> {
        return SearchViewModel::class.java
    }

    override fun onError() {
        Toast.makeText(activity, "오류가 발생했습니다.", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        adapter.listener = this

        rv_search.apply {
            setHasFixedSize(true)
            layoutManager = layoutManager
            adapter = adapter
//            addItemDecoration(
//                SeparatorDecoration.Builder(context)
//                    .setMargin(16F, 0F)
//                    .build()
//            )
        }
        search_view.setOnQueryTextListener(object : OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                query.trim().let {
                    viewModel.requestData.value = RequestData(query, null, 1, null)
                    adapter.submitList(null)
                }

                return false
            }

        })


    }

    override fun onClick(id: Int) {
        findNavController().navigate(
            R.id.action_go_detail,
            bundleOf("id" to id)
        )
    }


}