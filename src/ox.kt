val table = arrayOf(
    arrayOf(' ','1','2','3'),
    arrayOf('1','-','-','-'),
    arrayOf('2','-','-','-'),
    arrayOf('3','-','-','-')
)
var player = 'X'
fun  printTable(){
    for(row:Array<Char> in table) {
        for(col:Char in row){
            print("$col ")
        }
        println()
    }
}

fun changePlayer(){
    if (player == 'X'){
        player = 'O'
    }else if (player == 'O'){
        player = 'X'
    }
}
fun printTurn(){
    println("$player Turn")
}
fun input():List<Int>{
    while (true){
        try {
            print("Plasse input Row and Column")
            val str = readLine()
            val rcList = str?.split(' ')
            if (rcList?.size !=2){
                println("Error: Must input 2 number at Row and Column (Ex. 1 2)")
                continue
            }
            val row = rcList?.get(0).toInt()
            val col = rcList?.get(1).toInt()
            return listOf(row,col)

        }catch (T:Throwable){
            println("Error: Must input number at Row and Column (Ex. 1 2)")
        }
    }
}
fun play(row:Int,col:Int){
    try {
        if (table[row][col] != '-') {
            println("Error: Index is not Empyty")
        }else{
            table[row][col] = player
        }
    }catch (T:Throwable){
        println("Error: Index Out Of Bounds")
    }
}
fun checkRow():Boolean {
    for(rowInd in 1..3){
        var count = 0
        for (colInd in 1..3){
            if (table[rowInd][colInd] == player){
                count++
            }
        }
        if (count==3){
            return true
        }
    }
    return false
}
fun checkCol():Boolean{
    for (colInd in 1..3){
        var count = 0
        for (rowInd in 1..3){
            if(table[rowInd][colInd] == player){
                count++
            }
        }
        if (count==3){
            return true
        }
    }
    return false
}
fun checkwin():Boolean{
    if (checkCol()){
        return true
    }
    if (checkRow()){
        return true
    }
    if (checkA()){
        return true
    }
    if (checkB()){
        return true
    }
    return false
}
fun checkA():Boolean{
    var count = 0
    for(index in 1..3){
        if (table[index][index]== player){
            count++
        }
    }
    if (count==3) return true
    return false
}
fun checkB():Boolean{
    var count = 0

    for(index in 1..3){
        for(indexs in 3 downTo 1) {
            if (table[index][indexs] == player) {
                count++
            }
        }
    }
    if (count==3) return true
    return false
}
fun main(){
    while (true){
        println("Welcome to OX Game")
        printTable()
        printTurn()
        val (row,col) = input()
        play(row,col)
        if (checkwin()){
            printTable()
            println("$player Win")
            break
        }
        changePlayer()
    }
}
