class Car {
    var id: Int = 0
    var name: String = ""
    var power: Int = 0
}


fun main() {
   /* val car = Car()
    car.id = 2
    car.name = "BMW"
    car.power = 250*/
    val car = Car().apply {
        id = 2; name="Bmw"; power=250
    }
    println(car.name)


    //  let, возвращает результат последней строки лямбды
    listOf(1,2,3,null,4,5,null).forEach {
        it?.let {
            if(it>2)
            println(it)
        } ?: println("null detected!")
    }

    //  also, которая очень похожа на let
    //  одно отличие (от let) — она возвращает объект-получатель
     //  это отличие позволяет создавать цепочки вызовов

    listOf(0,1,2,null,4,null,6,7).forEach{
        it?.also {
            println(it)
        }?.also {
            saveToFile(it.toString())
        } ?: println("null detected")
    }

    //Эта функция, как и apply, ограничивает область видимости,
    // позволяя в лямбде делать вызовы функций объекта-получателя
    // напрямую.
    // Но run, в отличии от apply, возвращает результат работы лямбды.
    //Интересная возможность этой функции — потоковый вызов ссылок на функции.

    // Java style
    // Читаем вызовы справа налево - неудобно!
    printMessage(serverResponseShowMessage(checkServerResponse(200)))

    // Kotlin style with run
    // Тут читаем в потоковом вызове в аккуратном порядке их вызова сверху вниз!
    200.run(::checkServerResponse)
        .run(::serverResponseShowMessage)
        .run(::printMessage)



    // With - по её объявлению понятно, что объект-получатель передаётся ей в первом аргументе
    // чем она отличается её от первых четырёх функций
    val startWithSpace = with(" London is the capital of GB"){
        if (startsWith(" ")){
            "строка начинается с пробела"
        } else {
            "корректное начало строки"
        }
    }
    // наверное иногда возможно использовать run вместо with

}
fun saveToFile(str: String) {

}
fun checkServerResponse(code:Int):Boolean = code == 200
fun serverResponseShowMessage(codeIsValid:Boolean) = if (codeIsValid){
    "с сервером всё в порядке"
} else {
    "с сервером есть проблемы, выходные в опасности"
}
fun printMessage(message:String) = println(message)