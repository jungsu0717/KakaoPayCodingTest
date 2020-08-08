package com.example.kakaopaycodingtest.common

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.net.ConnectivityManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatDialog
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.example.kakaopaycodingtest.R

/**
 * KakaoPayCodingTest
 * Class: CommonFunc
 * Created by yjs on 07/08/2020.
 *
 * Description:
 */


/**
 * 로딩바 생성
 * @param context
 * @return
 */

@Suppress("DEPRECATION")
class CommonFunc {

    companion object {

        fun showLoadingDialog(context: Context?): AppCompatDialog? {
            val progressDialog = AppCompatDialog(context)
            try {
                progressDialog.setCancelable(false)
                progressDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                progressDialog.setContentView(R.layout.progress_dialog)
                progressDialog.show()
                val iv =
                    progressDialog.findViewById<AppCompatImageView>(R.id.iv_progress)
                val drawable = iv!!.background as AnimationDrawable
                iv.post { drawable.start() }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return progressDialog
        }

        fun isNetworkEnable(context: Context): Boolean {
            val cm =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            try {
                val ni = cm.activeNetworkInfo
                return ni.isAvailable && ni.isConnected
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return false
        }

        @SuppressLint("CheckResult")
        fun loadImageUrl(
            imageView: AppCompatImageView,
            imageUrl: String?
        ) {
            val options = RequestOptions()

            options.placeholder(R.drawable.ic_launcher_background)
            options.error(R.drawable.ic_launcher_background)

            if (imageUrl != null) {
                try {
                    Glide.with(imageView.context)
                        .load(imageUrl)
                        .apply(options)
                        .listener(object : RequestListener<Drawable?> {
                            override fun onLoadFailed(
                                e: GlideException?,
                                model: Any,
                                target: Target<Drawable?>,
                                isFirstResource: Boolean
                            ): Boolean {


                                var error: String? = "Error : "
                                if (e != null) {
                                    error += e.message
                                }
                                error += " Image Url : $imageUrl"

                                println(error)
                                return false
                            }

                            override fun onResourceReady(
                                resource: Drawable?,
                                model: Any,
                                target: Target<Drawable?>,
                                dataSource: DataSource,
                                isFirstResource: Boolean
                            ): Boolean {
                                return false
                            }
                        })
                        .into(imageView)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

    }
}