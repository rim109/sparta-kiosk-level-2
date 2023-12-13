import kotlin.system.exitProcess

fun main() {
    val kiosk = Kiosk()
    kiosk.runKiosk()

    var menuPan = kiosk.menuKiosk()
    val mainBurger = Hamburger()
    val mainIce = Ice()
    val mainDr = Drinks()
    val mainBe = Beer()

    while (true) {
        when (menuPan) {
            1 -> menuPan = mainBurger.burgers(kiosk.burgerMenu)
            2 -> menuPan = mainIce.iceCream(kiosk.iceMenu)
            3 -> menuPan = mainDr.drink(kiosk.drinkMenu)
            4 -> menuPan = mainBe.beers(kiosk.beerMenu)
            0 -> {
                println("\u001B[31m프로그램이 종료되었습니다.\u001B[0m")
                exitProcess(0)
            }

            else -> {
                println("\u001B[31m잘못된 번호를 입력하셨어요. 다시 입력해주세요!\u001B[0m")
                menuPan = kiosk.menuKiosk()
            }
        }
        if (menuPan == 0) {
            menuPan = kiosk.menuKiosk()
        }
        println(menuPan)
    }

}

open class Kiosk {

    val burgerMenu = ArrayList<Hamburger>()
    val iceMenu = ArrayList<Ice>()
    val drinkMenu = ArrayList<Drinks>()
    val beerMenu = ArrayList<Beer>()

    fun runKiosk() {
        initKiosk()
    }

    fun menuKiosk(): Int {
        println("\u001B[35m오신 것을 환영합니다!!\u001B[35m")
        println("\u001B[32m마음에 드는 메뉴 번호를 입력해주세요\u001B[0m")
        println("Menu")
        println(
                    "1. Burgers         | 앵거스 비프 통살을 다져만든 버거\n" +
                    "2. Forzen Custard  | 매장에서 신선하게 만드는 아이스크림\n" +
                    "3. Drinks          | 매장에서 직접 만드는 음료\n" +
                    "4. Beer            | 뉴욕 브루클린 브루어리에서 양조한 맥주\n" +
                    "0. exit            | 프로그램 종료\n"
        )
        return readln().toInt()
    }

    fun initKiosk() {
        burgerMenu.add(Hamburger(1, "ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"))
        burgerMenu.add(Hamburger(2, "SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"))
        burgerMenu.add(Hamburger(3, "Shroom Burger", 9400, "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거"))
        burgerMenu.add(Hamburger(4, "Cheeseburger", 9400, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"))
        burgerMenu.add(Hamburger(5, "Cheeseburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"))
        burgerMenu.add(Hamburger(0, "뒤로가기", 0, "다시 메인 메뉴로 이동한다"))

        iceMenu.add(Ice(1, "chocolate", 4900, "초콜릿 맛 아이스크림"))
        iceMenu.add(Ice(2, "vanilla", 4900, "바닐라 맛 아이스크림"))
        iceMenu.add(Ice(3, "strawberry", 5400, "딸기 맛 아이스크림"))
        iceMenu.add(Ice(4, "rainbow", 6200, "레인보우 맛 아이스크림"))
        iceMenu.add(Ice(5, "blueberry", 4000, "블루베리 맛 아이스크림"))
        iceMenu.add(Ice(0, "뒤로가기", 0, "다시 메인 메뉴로 이동한다"))

        drinkMenu.add(Drinks(1, "orange juice", 3900, "상큼한 오렌지 주스"))
        drinkMenu.add(Drinks(2, "ice-tea", 3900, "달콤한 아이스 티"))
        drinkMenu.add(Drinks(3, "tea", 2800, "따뜻한 한잔의 티"))
        drinkMenu.add(Drinks(4, "cola", 3500, "시원함을 느낄 수 있는 콜라"))
        drinkMenu.add(Drinks(5, "coffee", 4800, "온몸이 짜릿해지는 커피 한잔"))
        drinkMenu.add(Drinks(0, "뒤로가기", 0, "다시 메인 메뉴로 이동한다"))

        beerMenu.add(Beer(1, "Pale Ale ", 4900, "풍부한 향의 에일"))
        beerMenu.add(Beer(2, "Larger", 4900, "깔끔함의 극치 라거"))
        beerMenu.add(Beer(3, "Dark Beer", 4800, "매력의 소유자 흑맥주"))
        beerMenu.add(Beer(4, "Cass", 3500, "한국의 대표적인 맥주"))
        beerMenu.add(Beer(5, "Tsingtao", 3800, "중국의 칭따오 맥주"))
        beerMenu.add(Beer(0, "뒤로가기", 0, "다시 메인 메뉴로 이동한다"))
    }
}

class Hamburger() {
    var burgerNumber = 0
    var burgerName = ""
    var burgerPrice = 0
    var burgerContent = ""

    constructor(burgerNumber: Int, burgerName: String, burgerPrice: Int, burgerContent: String) : this() {
        this.burgerNumber = burgerNumber
        this.burgerName = burgerName
        this.burgerPrice = burgerPrice
        this.burgerContent = burgerContent

    }

    fun burgers(burgerMenus: ArrayList<Hamburger>): Int {
        var status = 0
        while (true) {
            println("\u001B[32m햄버거의 메뉴를 골라 숫자를 입력해주세요\u001B[0m")
            for (b in burgerMenus) {
                println(b.burgerNumber)
                println(b.burgerName)
                println(b.burgerPrice)
                println("-------------------------------------------")
                println(b.burgerContent)
                println("-------------------------------------------")
            }

            var burgerNumber = readln().toInt()

            if (burgerNumber == 0) {
                println("뒤로 가기를 선택하셨습니다")
                break
            } else if (burgerNumber in (1..5)) {
                println("${burgerNumber} ${burgerMenus[burgerNumber - 1].burgerName} ${burgerMenus[burgerNumber - 1].burgerPrice} ${burgerMenus[burgerNumber - 1].burgerContent} 을 선택했습니다. 맞습니까?")
                println("네 , 아니오")
                var answer = readln().toString()
                if (answer == "네") {
                    println("\u001B[32m[ Orders ]\u001B[0m")
                    println("${burgerNumber} ${burgerMenus[burgerNumber - 1].burgerName} ${burgerMenus[burgerNumber - 1].burgerPrice} ${burgerMenus[burgerNumber - 1].burgerContent}가 장바구니에 추가되었습니다.")
                    exitProcess(0)
                } else println("다른 메뉴를 선택해주세요.")

            } else println("\u001B[31m잘못된 번호를 입력하셨어요. 다시 입력해주세요!\u001B[0m")

        }
        return status
    }
}


class Ice() {
    var iceNumber = 0
    var iceName = ""
    var icePrice = 0
    var iceContent = ""

    constructor(iceNumber: Int, iceName: String, icePrice: Int, iceContent: String) : this() {
        this.iceNumber = iceNumber
        this.iceName = iceName
        this.icePrice = icePrice
        this.iceContent = iceContent
    }

    fun iceCream(iceMenus: ArrayList<Ice>): Int {
        while (true) {
            println("\u001B[32m아이스크림의 메뉴를 골라 숫자를 입력해주세요\u001B[0m")
            for (i in iceMenus) {
                println(i.iceNumber)
                println(i.iceName)
                println(i.icePrice)
                println("-------------------------------------------")
                println(i.iceContent)
                println("-------------------------------------------")
            }

            var iceNumber = readln().toInt()

            if (iceNumber == 0) {
                println("뒤로 가기를 선택하셨습니다")
                break
            } else if (iceNumber in (1..5)) {
                println("${iceNumber} ${iceMenus[iceNumber - 1].iceName} ${iceMenus[iceNumber - 1].icePrice} ${iceMenus[iceNumber - 1].iceContent} 을 선택했습니다. 맞습니까?")
                println("네 , 아니오")
                var answer = readln().toString()
                if (answer == "네") {
                    println("\u001B[32m[ Orders ]\u001B[0m")
                    println("${iceNumber} ${iceMenus[iceNumber - 1].iceName} ${iceMenus[iceNumber - 1].icePrice} ${iceMenus[iceNumber - 1].iceContent}가 장바구니에 추가되었습니다.")
                    exitProcess(0)
                } else println("다른 메뉴를 선택해주세요.")

            } else println("\u001B[31m잘못된 번호를 입력하셨어요. 다시 입력해주세요!\u001B[0m")

        }
        return 0
    }
}

class Drinks() {
    var drinkNumber = 0
    var drinkName = ""
    var drinkPrice = 0
    var drinkContent = ""

    constructor(drinkNumber: Int, drinkName: String, drinkPrice: Int, drinkContent: String) : this() {
        this.drinkNumber = drinkNumber
        this.drinkName = drinkName
        this.drinkPrice = drinkPrice
        this.drinkContent = drinkContent
    }

    fun drink(drinkMenus: ArrayList<Drinks>): Int {
        while (true) {
            println("\u001B[32m음료의 메뉴를 골라 숫자를 입력해주세요\u001B[0m")
            for (d in drinkMenus) {
                println(d.drinkNumber)
                println(d.drinkName)
                println(d.drinkPrice)
                println("-------------------------------------------")
                println(d.drinkContent)
                println("-------------------------------------------")
            }
            var drinkNumber = readln().toInt()

            if (drinkNumber == 0) {
                println("뒤로 가기를 선택하셨습니다")
                break
            } else if (drinkNumber in (1..5)) {
                println("${drinkNumber} ${drinkMenus[drinkNumber - 1].drinkName} ${drinkMenus[drinkNumber - 1].drinkPrice} ${drinkMenus[drinkNumber - 1].drinkContent} 위 메뉴를 장바구니에 추가하시겠습니까?")
                println("네 , 아니오")
                var answer = readln().toString()
                if (answer == "네") {
                    println("\u001B[32m[ Orders ]\u001B[0m")
                    println("${drinkNumber} ${drinkMenus[drinkNumber - 1].drinkName} ${drinkMenus[drinkNumber - 1].drinkPrice} ${drinkMenus[drinkNumber - 1].drinkContent}가 장바구니에 추가되었습니다.")
                    exitProcess(0)
                } else println("다른 메뉴를 선택해주세요.")

            } else {
                println("\u001B[31m잘못된 번호를 입력하셨어요. 다시 입력해주세요!\u001B[0m")
            }

        }
        return 0
    }

}

class Beer() {
    var beerNumber = 0
    var beerName = ""
    var beerPrice = 0
    var beerContent = ""

    constructor(beerNumber: Int, beerName: String, beerPrice: Int, beerContent: String) : this() {
        this.beerNumber = beerNumber
        this.beerName = beerName
        this.beerPrice = beerPrice
        this.beerContent = beerContent
    }

    fun beers(beerMenus: ArrayList<Beer>): Int {
        while (true) {
            println("\u001B[32m음료의 메뉴를 골라 숫자를 입력해주세요\u001B[0m")
            for (e in beerMenus) {
                println(e.beerNumber)
                println(e.beerName)
                println(e.beerPrice)
                println("-------------------------------------------")
                println(e.beerContent)
                println("-------------------------------------------")
            }
            var beerNumer = readln().toInt()

            if (beerNumer == 0) {
                println("뒤로 가기를 선택하셨습니다")
                break
            } else if (beerNumer in (1..5)) {
                println("${beerNumber} ${beerMenus[beerNumber - 1].beerName} ${beerMenus[beerNumber - 1].beerPrice} ${beerMenus[beerNumber - 1].beerContent} 을 선택했습니다. 맞습니까?")
                println("네 , 아니오")
                var answer = readln().toString()
                if (answer == "네") {
                    println("\u001B[32m[ Orders ]\u001B[0m")
                    println("${beerNumber} ${beerMenus[beerNumber - 1].beerName} ${beerMenus[beerNumber - 1].beerPrice} ${beerMenus[beerNumber - 1].beerContent}가 장바구니에 추가되었습니다.")
                    exitProcess(0)
                } else println("다른 메뉴를 선택해주세요.")

            } else println("\u001B[31m잘못된 번호를 입력하셨어요. 다시 입력해주세요!\u001B[0m")

        }
        return 0
    }
}





