enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }
data class Usuario(val nomeUsu: String)
data class ConteudoEducacional(val nomeConteudo: String, val duracao: Int)
data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {
    val inscritos = mutableListOf<Usuario>()
    fun matricular(usuario: Usuario): String {
        inscritos.add(usuario)
        return usuario.nomeUsu
    }
}
fun main() {
    /*=========================  USUÁRIOS  ================================*/
    val usuario1 = Usuario("Willian")
    val usuario2 = Usuario("Bianca")
    val usuario3 = Usuario("Zezinho")

    /*=========================  CONTEÚDOS  ================================*/
    val conteudo1 = ConteudoEducacional("Logica de Programação", 90)
    val conteudo11 = ConteudoEducacional("POO", 120)

    val conteudo2 = ConteudoEducacional("Conteudo 2", 190)
    val conteudo22 = ConteudoEducacional("Outro Conteudo 2", 250)

    /*=========================  FORMAÇÃO  ================================*/
    val form = Formacao("Kotlin Básico", listOf(conteudo1, conteudo11), Nivel.BASICO)
    val form3 = Formacao("Kotlin Avançado", listOf(conteudo2, conteudo22), Nivel.AVANCADO)

    /*=========================  MATRICULAR  ================================*/
    val alu = form.matricular(usuario1)
    val alu2 = form.matricular(usuario2)
    val alu3 = form3.matricular(usuario3)

    /*=========================  DISPLAY  ================================*/
    for (conteudo in form.conteudos) {
        println("O Aluno ${alu} se matriculou para a formação de ${form.nome}, que contem os seguintes cursos - Nome: ${conteudo.nomeConteudo}, Duração: ${conteudo.duracao} minutos e com o seguinte nivel ${form.nivel}")
        println("O Aluno ${alu2} se matriculou para a formação de ${form.nome}, que contem os seguintes cursos - Nome: ${conteudo.nomeConteudo}, Duração: ${conteudo.duracao} minutos e com o seguinte nivel ${form.nivel}")
    }

    for (conteudo in form3.conteudos) {
        println("O Aluno ${alu3} se matriculou para a formação de ${form3.nome}, que contem os seguintes cursos - Nome: ${conteudo.nomeConteudo}, Duração: ${conteudo.duracao} minutos e com o seguinte nivel ${form3.nivel}")
    }

    /*=========================  CONTAGEM DE INSCRITOS  ================================*/
    println("Inscritos na formação ${form.nome}: ${form.inscritos.size}")
    println("Inscritos na formação ${form3.nome}: ${form3.inscritos.size}")
}
