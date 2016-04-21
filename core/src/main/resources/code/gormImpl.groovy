import groovy.transform.Canonical

@Canonical
class TechInfo {
  String name
  int born
}

List<TechInfo> data = [
  new TechInfo(name: "Groovy", born: 2003),
  new TechInfo("Java", 1996),
  new TechInfo("Kotlin", 2016),
]

def fieldGroup = "(Name|Born)(More|Less)?"
def p = ~/findBy$fieldGroup(?:(And)$fieldGroup)*/

def funcs = [
  (null): { a, b -> a == b },
  More: { a, b -> a > b },
]

TechInfo.metaClass.'static'.invokeMethod = { String name, args ->
  if (name ==~ p) {
    int i = 0
    def res = data.collect()
    name.findAll(fieldGroup) { _, prop, criteria ->
      res.retainAll { funcs[criteria](it[prop.toLowerCase()], args[i]) }
      i++;
    }
    res
  }
}

println(TechInfo.findByName("Java"))
println(TechInfo.findByBornMore(2000))
