def googleLogo = "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png"
def file = new File("googleLogo.png")
println("File exists: ${ file.exists() }")
file.bytes = new URL(googleLogo).bytes
println("File exists: ${ file.exists() }")
println("${ file.size() / 1024 } KB.")
