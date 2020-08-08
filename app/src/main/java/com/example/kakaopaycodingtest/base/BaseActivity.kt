package com.example.kakaopaycodingtest.base

import android.R
import android.annotation.TargetApi
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialog
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.kakaopaycodingtest.common.BusProvider
import com.example.kakaopaycodingtest.common.CommonFunc
import com.squareup.otto.Bus
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * KakaoPayCodingTest
 * Class: BaseActivity
 * Created by yjs on 07/08/2020.
 *
 * Description:
 */

@Suppress("DEPRECATION")
abstract class BaseActivity<V : ViewModel, D : ViewDataBinding>: AppCompatActivity(), BaseFragment.Callback, BaseView {

    private var mProgressDialog: AppCompatDialog? = null

    private var bus: Bus = BusProvider.getInstance()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected lateinit var viewModel: V

    protected lateinit var binding: D


    @get:LayoutRes
    protected abstract val layoutRes: Int

    protected abstract fun getViewModel(): Class<V>

    override fun onFragmentAttached() {}
    /**
     * fragment 삭제
     *
     * @param tag
     */
    override fun onFragmentDetached(tag: String?) {
        val fragmentManager = supportFragmentManager
        val fragment = fragmentManager.findFragmentByTag(tag)
        if (fragment != null) {
            fragmentManager
                .beginTransaction()
                .disallowAddToBackStack()
//                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .remove(fragment)
                .commitNow()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutRes)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel())

        bus.register(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        bus.unregister(this)
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermission(permission: String?): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission!!) == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Keyboard Setting
     */
    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    /**
     * NetWork 체크
     *
     * @return
     */
    val isNetworkConnected: Boolean
        get() = CommonFunc.isNetworkEnable(applicationContext)

    /**
     * 토큰이 종료되면 로그인창으로 보내버린다.
     */
    fun openActivityOnTokenExpire() {
//        startActivity(LoginActivity.newIntent(this))
        finish()
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun requestPermissionsSafely(permissions: Array<String?>?, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions!!, requestCode)
        }
    }


    fun showLoading() {
        mProgressDialog = CommonFunc.showLoadingDialog(this)
    }

    fun hideLoading() {
        mProgressDialog?.cancel()
    }


    /**
     * 뒤로가기 버튼
     *
     * @param item
     * @return
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
    }


    override fun ProgressOff() {
        hideLoading()
    }
}
