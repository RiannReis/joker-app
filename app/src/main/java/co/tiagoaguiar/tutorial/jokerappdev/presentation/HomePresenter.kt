package co.tiagoaguiar.tutorial.jokerappdev.presentation

import android.os.Handler
import android.os.Looper
import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import co.tiagoaguiar.tutorial.jokerappdev.view.CategoryItem
import co.tiagoaguiar.tutorial.jokerappdev.view.HomeFragment

class HomePresenter(private val view: HomeFragment){

    fun findAllCategories() {
        view.showProgress()
        fakeRequest()
    }

    fun onSuccess(response: List<Category>){
        //OP 01:

//        val categories = mutableListOf<CategoryItem>()
//
//        for (category in response){
//            categories.add(CategoryItem(category))
//        }

        //OP 02:
//        val categories = response.map { category ->
//            CategoryItem(category)
//        }

        //OP 03:
        val categories = response.map { CategoryItem(it) }


        view.showCategories(categories)
    }

//    fun onError(message:String){
//        view.showFailure(message)
//    }

    fun onComplete(){
        view.hideProgress()
    }


    //SIMULAR UMA REQUISIÇÃO HTTP
    private fun fakeRequest() {
        Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(
                Category("categoria 1", 0xffface6e),
                Category("categoria 2", 0xffecd16d),
                Category("categoria 3", 0xffded36e),
                Category("categoria 4", 0xffcfd571)
            )

            //aqui a lista já está pronta (response)

            onSuccess(response)
//            onError("Falha na conexão, tente novamente mais tarde.")

            onComplete()
        }, 2000)
    }

}