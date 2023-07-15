package co.tiagoaguiar.tutorial.jokerappdev.data

import android.os.Handler
import android.os.Looper

class CategoryRemoteDataSource {

    fun findAllCategories(callback: ListCategoryCallback){
        Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(
                "categoria 1",
                "categoria 2",
                "categoria 3",
                "categoria 4"
            )

            callback.onSuccess(response)
//            onError("Falha na conexão, tente novamente mais tarde.")
//
            callback.onComplete()
        }, 2000)
    }
}