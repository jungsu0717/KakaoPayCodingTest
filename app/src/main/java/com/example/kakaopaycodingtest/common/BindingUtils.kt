package com.example.kakaopaycodingtest.common

import android.graphics.drawable.Drawable
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.example.kakaopaycodingtest.R
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

/**
 * KakaoPayCodingTest
 * Class: BindingUtils
 * Created by yjs on 07/08/2020.
 *
 * Description:
 */

object BindingUtils {

    @BindingAdapter("loadImage")
    @JvmStatic
    fun loadImage(
        imageView: AppCompatImageView,
        imageUrl: String?
    ) {

        val options = RequestOptions()

        options.placeholder(R.drawable.book_no_img)
        options.error(R.drawable.book_no_img)

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

    @BindingAdapter("arrayText")
    @JvmStatic
    fun arrayText(
        textView: AppCompatTextView,
        text: List<String>?
    ) {
        val tempText = StringBuilder()
        text.let {
            it?.forEach { string ->
                if (tempText.isNotEmpty()) {
                    tempText.append(" / ")
                }
                tempText.append(string)
            }
        }
        textView.text = tempText
    }


    @BindingAdapter("parseDate")
    @JvmStatic
    fun parseDate(
        textView: AppCompatTextView,
        date: Date?
    ) {

        try {

            val cal = Calendar.getInstance()

            if (date != null){
                cal.time = date
                val df: DateFormat = SimpleDateFormat("yyyy-MM-dd")
                textView.text = df.format(cal.time)
            }

        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }

    }

}