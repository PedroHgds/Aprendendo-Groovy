import java.nio.file.Files
import java.nio.file.Files

class TodoList {
    def tasks = []

    void addTask(String task) {
        tasks << task
    }

    void removeTask(int index) {
        tasks.remove(index -1)
    }

    void listTasks(){
        if (tasks.isEmpty()){
            println "A lista de tarefa está vazia."
        } else{
            println "Lista de tarefas:"
            tasks.eachWithIndex { task, index ->
                println "${index + 1} - ${task}"
            }
        }
    }

    void saveToFile(String filename) {
        Files.write(Paths.get(filename), tasks)
    }

    void loadFromFile (String filename){
        tasks = Files.readAllLines(Paths.get(filename))
    }

    def todoList = New TodoList()

    def input
    while( input != "q"){
        println "O que você deseja fazer ?"
        println "1. Adicionar uma tarefa"
        println "2. Remover uma tarefa"
        println "3. Listar as tarefas"
        println "4. Salvar a lista em um arquivo"
        println "5. Carregar a lista de um arquivo"
        println "q. Sair"
        input = System.Console().readLine()

        switch (input){
            case "1":
            println "Digite a tarefa a ser adicionada: "
            def task = System.console().readLine()
            todoList.addTask(task)
            break

            case "2":
            println "Digite o índice da tarefa a ser removida: "
            def index = Integer.parseInt(System.Console().readLine())
            todoList.removeTask(index)
            break

            case "3":
            todoList.listTasks()
            break

            case "4":
            println "Digite o nome do arquivo: "
            def filename = System.console().readLine()
            todoList.saveToFile(filename)
            break

            case "5":
            println "Digite o nome do arquivo: "
            def filename = System.console().readLine()
            todoList.loadFromFile(filename)
            break
        }
    }
}

//Este código define uma classe TodoList que representa nossa lista de tarefas. 
//A classe tem métodos para adicionar, remover e listar tarefas, bem como para salvar e carregar a lista de um arquivo.
//O código principal do aplicativo cria uma instância da classe TodoList  e executa um loop que lê a entrada do usuário e executa a ação apropriada com base na entrada.