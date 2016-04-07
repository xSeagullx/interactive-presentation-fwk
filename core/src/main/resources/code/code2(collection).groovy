List<Integer> list = [1,2,3,4,5,6,7,8,9];
def odds = list.grep({ it % 2 == 0 })
odds.each { println(it + ", ") }
