package com.example.kakaopaycodingtest.common

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.example.kakaopaycodingtest.R
/**
 * KakaoPayCodingTest
 * Class: BindingUtils
 * Created by yjs on 07/08/2020.
 *
 * Description:
 */

class BindingUtils {

    @SuppressLint("CheckResult")
    @BindingAdapter("imageUrl")
    fun loadImage(
        imageView: ImageView,
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