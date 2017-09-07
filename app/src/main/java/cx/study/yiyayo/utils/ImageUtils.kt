package cx.study.yiyayo.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Base64
import java.io.ByteArrayOutputStream

/**
 *
 * Created by cheng.xiao on 2017/9/7.
 */
open class ImageUtils{

    companion object {
        // 根据路径获得图片并压缩，返回bitmap用于显示
        fun getSmallBitmap(uri: Uri, context: Context): Bitmap {
            val options = BitmapFactory.Options()
            options.inJustDecodeBounds = true
            val inputStream = context.contentResolver.openInputStream(uri)
            // Calculate inSampleSize
            options.inSampleSize = calculateInSampleSize(options, 480, 480)

            // Decode bitmap with inSampleSize set
            options.inJustDecodeBounds = false

            return BitmapFactory.decodeStream(inputStream,null, options)
        }

        //计算图片的缩放值
        private fun calculateInSampleSize(options: BitmapFactory.Options , reqWidth: Int, reqHeight: Int): Int {
            val height = options.outHeight;
            val width = options.outWidth;
            var inSampleSize = 1
            if (height > reqHeight || width > reqWidth) {
                val heightRatio = Math.round(height.toFloat() / reqHeight.toFloat())
                val widthRatio = Math.round(width.toFloat() / reqWidth.toFloat())
                inSampleSize = if(heightRatio < widthRatio)  heightRatio else widthRatio
            }
            return inSampleSize;
        }

        fun getImageString(bitmap: Bitmap): String? {
            return bitmapToString(bitmap)
        }

        fun bitmapToString(bitmap: Bitmap): String? {
            //将Bitmap转换成字符串
            val string: String?
            val bStream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bStream)
            val bytes = bStream.toByteArray()
            string = Base64.encodeToString(bytes, Base64.NO_WRAP)
            return string
        }
    }

}