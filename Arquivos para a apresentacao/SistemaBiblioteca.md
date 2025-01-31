# Trabalhode-POO-Curso-de-Ferias-


Análise da Classe SistemaBiblioteca e sua Relação com Outras Classes

A classe SistemaBiblioteca é a classe principal do seu programa, responsável por gerenciar a interação do usuário com a biblioteca. Vamos analisar seu código e suas relações com as outras classes:

Atributos:

    private static Biblioteca biblioteca = new Biblioteca();: Este atributo é uma instância da classe Biblioteca, que é a classe responsável por armazenar e gerenciar os livros e usuários da biblioteca. A palavra-chave static indica que este atributo pertence à classe SistemaBiblioteca em si, e não a uma instância específica da classe.

Métodos:

    private static void menu(): Este método exibe o menu de opções para o usuário.
    public static void main(String args): Este é o método principal do programa, que é executado quando o programa é iniciado. Ele carrega os dados da biblioteca, exibe o menu e processa as opções do usuário.
    Os métodos dentro do switch (opcao): Estes métodos são responsáveis por executar as ações correspondentes às opções do menu, como cadastrar livros e usuários, emprestar e devolver livros, listar livros e usuários, etc.

Relação com outras classes:

    Biblioteca: A classe SistemaBiblioteca utiliza a classe Biblioteca para armazenar e gerenciar os livros e usuários.
    Livro: A classe SistemaBiblioteca utiliza a classe Livro para criar e manipular objetos de livros.
    Usuario, UsuarioAluno, UsuarioServidor: A classe SistemaBiblioteca utiliza estas classes para criar e manipular objetos de usuários.
    Emprestimo: A classe SistemaBiblioteca utiliza a classe Emprestimo para registrar os empréstimos de livros.

Observações:

    O código utiliza um loop do-while para exibir o menu repetidamente até que o usuário escolha a opção de sair.
    O código utiliza um bloco try-catch para lidar com possíveis exceções, como erros de entrada/saída.
    O código utiliza a classe Scanner para ler a entrada do usuário.

Melhorias:

    O código poderia ser melhorado utilizando um framework de logging para registrar as ações do usuário e os erros do sistema.
    O código poderia ser melhorado utilizando um banco de dados para armazenar os dados da biblioteca, em vez de arquivos de texto.
    O código poderia ser melhorado utilizando uma interface gráfica para interagir com o usuário, em vez de uma interface de linha de comando.

# switch do método main

  ## case1

  Este trecho de código representa o caso 1 (case 1) dentro do bloco switch do método main que você apresentou anteriormente. Ele é responsável por lidar com a opção de cadastrar um novo livro no sistema da biblioteca. Vamos analisar o que acontece nesse caso:

1. Entrada de Dados:
Java

System.out.println("1. Cadastrar Livro");
System.out.print("Digite o ISBN: ");
String isbn = scanner.nextLine();
System.out.print("Digite o título: ");
String titulo = scanner.nextLine();
System.out.print("Digite o autor: ");
String autor = scanner.nextLine();
System.out.println("Digite a editora: ");
String editora = scanner.nextLine();
System.out.print("Digite o número de páginas: ");
int numeroPaginas = scanner.nextInt();
System.out.print("Digite a quantidade de exemplares: ");
int quantidade = scanner.nextInt();

    O programa exibe a mensagem "1. Cadastrar Livro" para indicar ao usuário qual opção está sendo executada.
    Em seguida, o programa solicita ao usuário que digite os dados do livro, um por vez: ISBN, título, autor, editora, número de páginas e quantidade de exemplares.
    Cada dado é lido usando o objeto scanner e armazenado em uma variável.

2. Cadastrar Livro:
Java

try {
    Livro livro = new Livro(isbn, titulo, autor, editora, numeroPaginas, quantidade);
    biblioteca.cadastrarLivro(livro);
    System.out.println("Livro cadastrado com sucesso!");
} catch (Exception e) {
    System.out.println(e.getMessage());
}

    Um novo objeto Livro é criado usando os dados fornecidos pelo usuário.
    O programa tenta cadastrar o livro na biblioteca usando o método biblioteca.cadastrarLivro(livro).
    Isso é feito dentro de um bloco try-catch para lidar com possíveis exceções que podem ocorrer durante o cadastro (por exemplo, se já existir um livro com o mesmo ISBN).
    Se o cadastro for bem-sucedido, o programa imprime a mensagem "Livro cadastrado com sucesso!".
    Se ocorrer alguma exceção, o programa imprime a mensagem de erro associada à exceção.

3. Encerrar o Caso:
Java

break;

    A palavra-chave break é usada para sair do bloco switch após o caso 1 ser processado.

Em resumo, este código dentro do case 1 permite que o usuário cadastre um novo livro no sistema da biblioteca, solicitando os dados necessários, criando um objeto Livro e tentando adicioná-lo à biblioteca. O try-catch garante que o programa lide com possíveis erros durante o processo de cadastro.


  ##  case 2

  Este código representa o case 2 dentro do bloco switch do método main, que é responsável por cadastrar um novo usuário no sistema da biblioteca. Diferente do cadastro de livros, aqui o programa precisa lidar com dois tipos de usuários: alunos e servidores. Vamos analisar o código passo a passo:

1. Escolha do Tipo de Usuário:
Java

System.out.println("Cadastrar Aluno(A) ou Servidor(S)?");
char tipo = scanner.next().charAt(0);
scanner.nextLine(); // Limpa o buffer do teclado

    O programa pergunta ao usuário qual tipo de usuário ele deseja cadastrar: Aluno (A) ou Servidor (S).
    A resposta do usuário é lida como uma string com scanner.next() e o primeiro caractere dessa string é extraído com charAt(0) e armazenado na variável tipo.
    scanner.nextLine() é usado para limpar o buffer do teclado, como explicado anteriormente.

2. Entrada de Dados Comuns:
Java

System.out.println("2. Cadastrar Usuário");
System.out.print("Digite o CPF: ");
String cpf = scanner.nextLine();
System.out.print("Digite o nome: ");
String nome = scanner.nextLine();
System.out.print("Digite o endereço: ");
String endereco = scanner.nextLine();
System.out.print("Digite o telefone: ");
String telefone = scanner.nextLine();
System.out.print("Digite o e-mail: ");
String email = scanner.nextLine();
System.out.print("Digite a matrícula: ");
String matricula = scanner.nextLine();

    O programa exibe a mensagem "2. Cadastrar Usuário".
    Em seguida, solicita os dados comuns a ambos os tipos de usuários: CPF, nome, endereço, telefone, e-mail e matrícula.
    Cada dado é lido e armazenado em uma variável.

3. Cadastro do Usuário:
Java

try {
    if (tipo == 'A') {
        System.out.print("Digite o curso: ");
        String curso = scanner.nextLine();
        UsuarioAluno aluno = new UsuarioAluno(cpf, nome, endereco, telefone, email, matricula, curso);
        biblioteca.cadastrarUsuario(aluno);
    } else if (tipo == 'S') {
        System.out.print("Digite o cargo: ");
        String cargo = scanner.nextLine();
        UsuarioServidor servidor = new UsuarioServidor(cpf, nome, endereco, telefone, email, matricula, cargo);
        biblioteca.cadastrarUsuario(servidor);
    } else {
        System.out.println("Tipo inválido");
    }
    System.out.println("Usuário cadastrado com sucesso!");
} catch (Exception e) {
    System.out.println(e.getMessage());
}

    Um bloco try-catch é usado para lidar com possíveis exceções durante o cadastro.
    Dentro do bloco try:
        Se tipo for igual a 'A', o programa solicita o curso do aluno, cria um objeto UsuarioAluno com os dados fornecidos e o cadastra na biblioteca.
        Se tipo for igual a 'S', o programa solicita o cargo do servidor, cria um objeto UsuarioServidor e o cadastra na biblioteca.
        Se tipo não for 'A' nem 'S', o programa imprime "Tipo inválido".
    Se o cadastro for bem-sucedido, o programa imprime "Usuário cadastrado com sucesso!".
    Se ocorrer alguma exceção, o programa imprime a mensagem de erro.

4. Encerrar o Caso:
Java

break;

    break é usado para sair do bloco switch.

Em resumo, o case 2 permite o cadastro de alunos e servidores, solicitando os dados específicos de cada tipo e usando polimorfismo para cadastrar o usuário na biblioteca. O try-catch garante o tratamento de erros durante o processo.

  ## case 3 e 4

  Este trecho de código apresenta os casos 3 e 4 do bloco switch no método main. Eles são responsáveis por emprestar e devolver livros no sistema da biblioteca, respectivamente. Vamos analisar cada caso:

Caso 3: Emprestar Livro
Java

case 3:
    System.out.println("3. Emprestar Livro");
    System.out.print("Digite o CPF do usuário: ");
    String cpfEmprestimo = scanner.nextLine();
    System.out.print("Digite o ISBN do livro: ");
    String isbnEmprestimo = scanner.nextLine();
    try {
        biblioteca.realizarEmprestimo(cpfEmprestimo, isbnEmprestimo);
        System.out.println("Livro emprestado com sucesso!");
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    break;

    Exibe a mensagem "3. Emprestar Livro".
    Solicita o CPF do usuário e o ISBN do livro a ser emprestado.
    Tenta realizar o empréstimo usando o método biblioteca.realizarEmprestimo().
    Se o empréstimo for bem-sucedido, imprime "Livro emprestado com sucesso!".
    Se houver algum erro (como usuário ou livro não encontrado, ou livro indisponível), imprime a mensagem de erro.
    Usa break para sair do switch.

Caso 4: Devolver Livro
Java

case 4:
    System.out.println("Devolver Livro");
    System.out.print("Digite o CPF do usuário: ");
    String cpfDevolucao = scanner.nextLine();
    System.out.print("Digite o ISBN do livro: ");
    String isbnDevolucao = scanner.nextLine();
    try {
        biblioteca.devolverLivro(cpfDevolucao, isbnDevolucao);
        System.out.println("Livro devolvido com sucesso!");
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    break;

    Exibe a mensagem "Devolver Livro".
    Solicita o CPF do usuário e o ISBN do livro a ser devolvido.
    Tenta realizar a devolução usando o método biblioteca.devolverLivro().
    Se a devolução for bem-sucedida, imprime "Livro devolvido com sucesso!".
    Se houver algum erro (como usuário ou livro não encontrado, ou livro não emprestado), imprime a mensagem de erro.
    Usa break para sair do switch.

Observações:

    Ambos os casos usam try-catch para lidar com exceções durante o empréstimo e a devolução.
    As mensagens exibidas no console guiam o usuário durante o processo.
    A lógica principal de empréstimo e devolução está encapsulada nos métodos realizarEmprestimo() e devolverLivro() da classe Biblioteca, o que torna o código mais organizado e modular.

Em resumo, esses casos permitem que o usuário realize operações de empréstimo e devolução de livros de forma interativa, com tratamento de erros e mensagens informativas.

  ## case 5, 6 e 7 
 
   Este trecho de código apresenta os casos 5, 6 e 7 do bloco switch no método main.  Eles são responsáveis por exibir listas de livros, usuários e livros emprestados, respectivamente. Vamos analisar cada caso:

Caso 5: Listar Livros
Java

case 5:
    System.out.println("Listar Livros");
    biblioteca.listarLivros();
    break;

    Exibe a mensagem "Listar Livros".
    Chama o método biblioteca.listarLivros() para exibir a lista de livros cadastrados na biblioteca.
    Usa break para sair do switch.

Caso 6: Listar Usuários
Java

case 6:
    System.out.println("Listar Usuários");
    biblioteca.listarUsuarios();
    break;

    Exibe a mensagem "Listar Usuários".
    Chama o método biblioteca.listarUsuarios() para exibir a lista de usuários cadastrados na biblioteca.
    Usa break para sair do switch.

Caso 7: Listar Livros Emprestados
Java

case 7:
    System.out.println("Listar Livros Emprestados");
    biblioteca.listarLivrosEmprestados();
    break;

    Exibe a mensagem "Listar Livros Emprestados".
    Chama o método biblioteca.listarLivrosEmprestados() para exibir a lista de livros que estão emprestados no momento.
    Usa break para sair do switch.

Observações:

    Cada caso chama um método específico da classe Biblioteca para realizar a listagem desejada, o que demonstra uma boa organização do código.
    As mensagens exibidas no console informam ao usuário qual listagem está sendo exibida.
    A lógica de listagem está encapsulada nos métodos da classe Biblioteca, o que facilita a manutenção e reutilização do código.

Em resumo, esses casos permitem que o usuário visualize informações importantes sobre o acervo da biblioteca e os empréstimos realizados, de forma simples e organizada.


  ## case 8 

  Este código representa o case 8 dentro do bloco switch do método main, que é responsável por remover um livro do sistema da biblioteca. Vamos analisar o que acontece nesse caso:

    Solicitar ISBN:

Java

System.out.println("8. Remover Livro");
System.out.print("Digite o ISBN do livro: ");
String isbnRemover = scanner.nextLine();

    Exibe a mensagem "8. Remover Livro" para o usuário.
    Solicita ao usuário que digite o ISBN do livro que deseja remover.
    Lê o ISBN digitado pelo usuário e armazena na variável isbnRemover.

    Remover Livro:

Java

try {
    biblioteca.removerLivro(isbnRemover);
    System.out.println("Livro removido com sucesso!");
} catch (Exception e) {
    System.out.println(e.getMessage());
}

    Tenta remover o livro da biblioteca usando o método biblioteca.removerLivro(), passando o isbnRemover como argumento.
    Se a remoção for bem-sucedida, exibe a mensagem "Livro removido com sucesso!".
    Se ocorrer algum erro durante a remoção (por exemplo, se o livro não for encontrado), o bloco catch captura a exceção e exibe a mensagem de erro correspondente.

    Sair do switch:

Java

break;

    Utiliza a palavra-chave break para sair do bloco switch após a execução do case 8.

Em resumo, o case 8 permite que o usuário remova um livro do sistema da biblioteca. Ele solicita o ISBN do livro, tenta removê-lo e exibe mensagens informativas sobre o sucesso ou falha da operação.

 ## case 9  

 Este código representa o case 9 dentro do bloco switch do método main, que é responsável por remover um usuário do sistema da biblioteca. Vamos analisar o que acontece nesse caso:

    Solicitar CPF:

Java

System.out.println("9. Remover Usuário");
System.out.print("Digite o CPF do usuário: ");
String cpfRemover = scanner.nextLine();

    Exibe a mensagem "9. Remover Usuário" para o usuário.
    Solicita ao usuário que digite o CPF do usuário que deseja remover.
    Lê o CPF digitado pelo usuário e armazena na variável cpfRemover.

    Remover Usuário:

Java

try {
    biblioteca.removerUsuario(cpfRemover);
    System.out.println("Usuário removido com sucesso!");
} catch (Exception e) {
    System.out.println(e.getMessage());
}

    Tenta remover o usuário da biblioteca usando o método biblioteca.removerUsuario(), passando o cpfRemover como argumento.
    Se a remoção for bem-sucedida, exibe a mensagem "Usuário removido com sucesso!".
    Se ocorrer algum erro durante a remoção (por exemplo, se o usuário não for encontrado), o bloco catch captura a exceção e exibe a mensagem de erro correspondente.

    Sair do switch:

Java

break;

    Utiliza a palavra-chave break para sair do bloco switch após a execução do case 9.

Em resumo, o case 9 permite que o usuário remova um usuário do sistema da biblioteca. Ele solicita o CPF do usuário, tenta removê-lo e exibe mensagens informativas sobre o sucesso ou falha da operação.
 

 ## case 10 

Este código representa o case 10 dentro do bloco switch do método main, que é responsável por editar os dados de um livro existente no sistema da biblioteca. Vamos analisar o que acontece nesse caso:

    Solicitar ISBN e Novos Dados:

Java

System.out.println("10. Editar Livro");
System.out.print("Digite o ISBN do livro: ");
String isbnEditar = scanner.nextLine();
System.out.print("Digite o novo título: ");
String novoTitulo = scanner.nextLine();
System.out.print("Digite o novo autor: ");
String novoAutor = scanner.nextLine();
System.out.print("Digite a nova editora: ");
String novaEditora = scanner.nextLine();
System.out.print("Digite o novo número de páginas: ");
int novoNumeroPaginas = scanner.nextInt();
System.out.print("Digite a nova quantidade de exemplares: ");
int novaQuantidade = scanner.nextInt();

    Exibe a mensagem "10. Editar Livro" para o usuário.
    Solicita ao usuário que digite o ISBN do livro que deseja editar.
    Lê o ISBN digitado pelo usuário e armazena na variável isbnEditar.
    Em seguida, solicita os novos dados do livro: título, autor, editora, número de páginas e quantidade de exemplares.
    Lê cada novo dado digitado pelo usuário e armazena nas respectivas variáveis.

    Editar Livro:

Java

try {
    biblioteca.editarLivro(isbnEditar, novoTitulo, novoAutor, novaEditora, novoNumeroPaginas, novaQuantidade);
    System.out.println("Livro editado com sucesso!");
} catch (Exception e) {
    System.out.println(e.getMessage());
}

    Tenta editar o livro na biblioteca usando o método biblioteca.editarLivro(), passando o isbnEditar e os novos dados como argumentos.
    Se a edição for bem-sucedida, exibe a mensagem "Livro editado com sucesso!".
    Se ocorrer algum erro durante a edição (por exemplo, se o livro não for encontrado), o bloco catch captura a exceção e exibe a mensagem de erro correspondente.

    Sair do switch:

Java

break;

    Utiliza a palavra-chave break para sair do bloco switch após a execução do case 10.

Em resumo, o case 10 permite que o usuário edite os dados de um livro existente no sistema da biblioteca. Ele solicita o ISBN do livro e os novos dados, tenta editar o livro e exibe mensagens informativas sobre o sucesso ou falha da operação.


   ## case 11 

   Este código representa o case 11 dentro do bloco switch do método main, que é responsável por editar os dados de um usuário existente no sistema da biblioteca. Vamos analisar o que acontece nesse caso:

    Solicitar CPF e Novos Dados:

Java

System.out.println("11. Editar Usuário");
System.out.print("Digite o CPF do usuário: ");
String cpfEditar = scanner.nextLine();
System.out.print("Digite o novo nome: ");
String novoNome = scanner.nextLine();
System.out.print("Digite o novo endereço: ");
String novoEndereco = scanner.nextLine();
System.out.print("Digite o novo telefone: ");
String novoTelefone = scanner.nextLine();
System.out.print("Digite o novo e-mail: ");
String novoEmail = scanner.nextLine();
System.out.print("Digite a nova matrícula: ");
String novaMatricula = scanner.nextLine();

    Exibe a mensagem "11. Editar Usuário" para o usuário.
    Solicita ao usuário que digite o CPF do usuário que deseja editar.
    Lê o CPF digitado pelo usuário e armazena na variável cpfEditar.
    Em seguida, solicita os novos dados do usuário: nome, endereço, telefone, e-mail e matrícula.
    Lê cada novo dado digitado pelo usuário e armazena nas respectivas variáveis.

    Editar Usuário:

Java

try {
    biblioteca.editarUsuario(cpfEditar, novoNome, novoEndereco, novoTelefone, novoEmail, novaMatricula);
    System.out.println("Usuário editado com sucesso!");
} catch (Exception e) {
    System.out.println(e.getMessage());
}

    Tenta editar o usuário na biblioteca usando o método biblioteca.editarUsuario(), passando o cpfEditar e os novos dados como argumentos.
    Se a edição for bem-sucedida, exibe a mensagem "Usuário editado com sucesso!".
    Se ocorrer algum erro durante a edição (por exemplo, se o usuário não for encontrado), o bloco catch captura a exceção e exibe a mensagem de erro correspondente.

    Sair do switch:

Java

break;

    Utiliza a palavra-chave break para sair do bloco switch após a execução do case 11.

Em resumo, o case 11 permite que o usuário edite os dados de um usuário existente no sistema da biblioteca. Ele solicita o CPF do usuário e os novos dados, tenta editar o usuário e exibe mensagens informativas sobre o sucesso ou falha da operação.

  ## case 12 

  Este código representa o case 12 dentro do bloco switch do método main, que é responsável por salvar os dados da biblioteca. Vamos analisar o que acontece nesse caso:

    Exibir Mensagem:

Java

System.out.println("Salvar Dados");

    Exibe a mensagem "Salvar Dados" para o usuário, indicando que o processo de salvamento foi iniciado.

    Salvar Dados:

Java

try {
    biblioteca.salvarDados();
    System.out.println("Dados salvos com sucesso!");
} catch (IOException e) {
    System.out.println("Erro ao salvar dados: " + e.getMessage());
}

    Tenta salvar os dados da biblioteca usando o método biblioteca.salvarDados().
    Se o salvamento for bem-sucedido, exibe a mensagem "Dados salvos com sucesso!".
    Se ocorrer algum erro durante o salvamento (por exemplo, erro de permissão de arquivo), o bloco catch captura a exceção IOException e exibe a mensagem "Erro ao salvar dados: " junto com a mensagem de erro específica da exceção.

    Sair do switch:

Java

break;

    Utiliza a palavra-chave break para sair do bloco switch após a execução do case 12.

Em resumo, o case 12 permite salvar os dados da biblioteca, como informações sobre livros, usuários e empréstimos, para que possam ser carregados posteriormente. Ele chama o método salvarDados() da classe Biblioteca para realizar o salvamento e exibe mensagens informativas sobre o sucesso ou falha da operação.


  ## case 13, default e do-while 

  ste código representa o case 13 e o default dentro do bloco switch do método main, além do fechamento do loop do-while. Eles são responsáveis por sair do programa e tratar opções inválidas, respectivamente. Vamos analisar cada parte:

Case 13: Sair
Java

case 13:
    System.out.println("Sair");
    try {
        biblioteca.salvarDados();
    } catch (IOException e) {
        System.out.println("Erro ao salvar dados: " + e.getMessage());
    }
    scanner.close();
    break;

    Exibe a mensagem "Sair" para o usuário.
    Tenta salvar os dados da biblioteca usando o método biblioteca.salvarDados(), como no case 12.
    Se houver algum erro durante o salvamento, exibe a mensagem de erro.
    Fecha o objeto scanner usando scanner.close() para liberar os recursos associados a ele.
    Utiliza break para sair do bloco switch.

Default: Opção Inválida
Java

default:
    System.out.println("Opção inválida");

    Caso o usuário digite uma opção que não esteja entre 1 e 13, o default é executado.
    Exibe a mensagem "Opção inválida" para o usuário.

Fechamento do Loop
Java

} while (opcao!= 13);

    Fecha o loop do-while que mantém o programa em execução.
    A condição opcao!= 13 indica que o loop continuará sendo executado enquanto o usuário não digitar a opção 13 (Sair).

Finalização da Classe
Java

}
}

    Fecha a chave do método main.
    Fecha a chave da classe SistemaBiblioteca.

Em resumo, o case 13 permite que o usuário saia do programa de forma segura, salvando os dados da biblioteca antes de encerrar. O default garante que o programa trate opções inválidas digitadas pelo usuário. O fechamento do loop do-while e da classe finaliza a execução do programa.