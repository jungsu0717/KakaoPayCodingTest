package com.example.kakaopaycodingtest.common

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatDialog
import androidx.appcompat.widget.AppCompatImageView
import com.example.kakaopaycodingtest.R
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

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

        fun makeMoneyType(price : Int): String? {
            val format = "#,##0"
            val df = DecimalFormat(format)
            val dfs = DecimalFormatSymbols()
            dfs.groupingSeparator = ',' // 구분자를 ,로
            df.groupingSize = 3 // 3자리 단위마다 구분자처리 한다.
            df.decimalFormatSymbols = dfs
            return df.format(price.toLong())
        }


    }
}