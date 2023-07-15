package co.tiagoaguiar.tutorial.jokerappdev.presentation

import android.os.Handler
import android.os.Looper
import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import co.tiagoaguiar.tutorial.jokerappdev.view.HomeFragment

class HomePresenter(private val view: HomeFragment){

    fun findAllCategories() {
        view.showProgress()
        fakeRequest()
    }

    fun onSuccess(response: List<String>){

        val categories = response.map { Category(it, 0xFFFF0000) }

        view.showCategories(categories)
    }

//    fun onError(message:String){
//        view.showFailure(message)
//    }

    fun onComplete(){
        view.hideProgress()
    }


    private fun fakeRequest() {
        Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(
                "categoria 1",
                "categoria 2",
                "categoria 3",
                "categoria 4"
            )

            onSuccess(response)
//            onError("Falha na conexão, tente novamente mais tarde.")

            onComplete()
        }, 2000)
    }

}


        // 1- O CICLO DE VIDA DO FRAGMENT FAZ A AÇÃO (CHAMAR O PRESENTER PEDINDO AS CATEGORIAS)
        // 2- O PRESENTER PEDE A LISTA DE CATEGORIAS NO MODEL
        // 3- O MODEL DEVOLVE UMA LISTA List<String>
        // 4- O PRESENTER FORMATA ESSA LISTA (String) EM Category (MODEL)
        // 5- A VIEW PEGA A LISTA DE List<Category> E CONVERTE PARA O List<CategoryItem>