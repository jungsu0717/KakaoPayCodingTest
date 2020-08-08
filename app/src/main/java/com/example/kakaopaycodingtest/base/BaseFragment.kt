package com.example.kakaopaycodingtest.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatDialog
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.kakaopaycodingtest.common.CommonFunc
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * KakaoPayCodingTest
 * Class: BaseFragment
 * Created by yjs on 07/08/2020.
 *
 * Description:
 */
@Suppress("DEPRECATION")
abstract class BaseFragment<V : ViewModel, D : ViewDataBinding> : DaggerFragment(),
    BaseView {

    private var mProgressDialog: AppCompatDialog? = null

    private var mActivity: BaseActivity<V, D>? = null

    private lateinit var mRootView: View

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected lateinit var viewModel: V

    protected lateinit var binding: D

    @get:LayoutRes
    protected abstract val layoutRes: Int

    protected abstract fun getViewModel(): Class<V>

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        if (context is BaseActivity) {
//            mActivity = context
//            context.onFragmentAttached()
//        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(false)
        showLoading()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(layoutInflater, layoutRes, container, false)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel())
        mRootView = binding.root

        return mRootView
    }

    override fun onDetach() {
        mActivity = null
        super.onDetach()
    }

    /**
     * Progressbar Setting
     */
    private fun showLoading() {
        if (mProgressDialog != null && !mProgressDialog!!.isShowing) {
            hideLoading()
            mProgressDialog = CommonFunc.showLoadingDialog(mActivity)!!
        }
    }

    private fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.cancel()
        }
    }


    interface Callback {
        fun onFragmentAttached()
        fun onFragmentDetached(tag: String?)
    }

    override fun ProgressOff() {
        hideLoading()
    }
}
