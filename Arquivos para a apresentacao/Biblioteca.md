## Importando Classes:
Java

import java.util.*;
import java.io.*;

    java.util.*: Importa todas as classes do pacote java.util, que contém diversas classes utilitárias como List, ArrayList, Scanner, etc.
    java.io.*: Importa todas as classes do pacote java.io, que contém classes para entrada e saída de dados, como File, FileReader, FileWriter, etc.

## Declarando a Classe:
Java

public class Biblioteca {

    Declara uma classe pública chamada Biblioteca. Isso significa que essa classe pode ser acessada de qualquer outra classe no seu projeto.

## Atributos:
Java

    private List<Usuario> usuarios;
    private List<Livro> livros;

    usuarios: Uma lista (List) para armazenar objetos do tipo Usuario. A lista é privada (private), o que significa que só pode ser acessada dentro da própria classe Biblioteca.
    livros: Uma lista (List) para armazenar objetos do tipo Livro. Também é privada (private).

## Construtor:
Java

    public Biblioteca() {
        this.usuarios = new ArrayList<>();
        this.livros = new ArrayList<>();
    }

    Este é o construtor da classe Biblioteca. Ele é executado automaticamente quando um novo objeto da classe Biblioteca é criado.
    Dentro do construtor:
        this.usuarios = new ArrayList<>();: Inicializa a lista usuarios como uma nova ArrayList. ArrayList é uma implementação da interface List que permite armazenar elementos de forma dinâmica.
        this.livros = new ArrayList<>();: Inicializa a lista livros como uma nova ArrayList.

Em resumo, essa parte do código define a estrutura básica da classe Biblioteca, que inclui:

    Importar as classes necessárias.
    Declarar a classe como pública.
    Criar duas listas para armazenar usuários e livros.
    Inicializar as listas no construtor.

Essa classe será responsável por gerenciar as operações relacionadas aos livros e usuários da biblioteca, como cadastrar, remover, editar, emprestar e devolver.


Este trecho de código faz parte do método cadastrarUsuario na classe Biblioteca. Ele tem como objetivo cadastrar um novo usuário na lista de usuários da biblioteca, mas antes de adicionar o usuário, ele verifica se já existe um usuário com o mesmo CPF cadastrado.

## Verificação de CPF Duplicado:
Java

for (Usuario u: usuarios) {
    if (u.getCpf().equals(usuario.getCpf())) {
        throw new Exception("Usuário com este CPF já está cadastrado.");
    }
}

    for (Usuario u: usuarios): Este é um loop "for-each" que percorre cada Usuario (u) na lista usuarios.
    if (u.getCpf().equals(usuario.getCpf())): Dentro do loop, esta linha verifica se o CPF do usuário atual (u) sendo percorrido é igual ao CPF do novo usuário (usuario) que se deseja cadastrar. O método getCpf() é usado para obter o CPF de cada usuário.
    throw new Exception("Usuário com este CPF já está cadastrado.");: Se o CPF já existir na lista, o código lança uma exceção (Exception) com a mensagem "Usuário com este CPF já está cadastrado.". Isso interrompe a execução do método e sinaliza um erro, impedindo que o usuário duplicado seja cadastrado.

## Observações:

    Essa verificação é importante para garantir a integridade dos dados, evitando que usuários com o mesmo CPF sejam cadastrados na biblioteca.
    Lançar uma exceção é uma forma comum de lidar com erros em Java. A exceção pode ser tratada em outro lugar do código, permitindo que o programa se recupere do erro ou exiba uma mensagem de erro ao usuário.
    O código que você forneceu mostra apenas a parte da verificação de CPF. O restante do método cadastrarUsuario provavelmente adicionaria o novo usuário à lista usuarios caso o CPF não seja duplicado.

Em resumo, esse trecho de código verifica se um usuário com o mesmo CPF já está cadastrado na biblioteca antes de tentar cadastrar um novo usuário. Isso ajuda a manter a consistência dos dados e evitar duplicatas.

# cadastrarUsuario dentro da classe Biblioteca 

Este código representa o método cadastrarUsuario dentro da classe Biblioteca, que é responsável por adicionar um novo usuário à lista de usuários da biblioteca. Vamos analisar o que acontece nesse método:

    Verificar CPF Existente:

Java

for (Usuario u: usuarios) {
    if (u.getCpf().equals(usuario.getCpf())) {
        throw new Exception("Usuário com este CPF já está cadastrado.");
    }
}

    Ele percorre a lista de usuários (usuarios) usando um loop for-each.
    Para cada usuário (u) na lista, ele compara o CPF do usuário atual com o CPF do novo usuário (usuario) que se deseja cadastrar.
    Se encontrar um usuário com o mesmo CPF, o método lança uma exceção (throw new Exception) com a mensagem "Usuário com este CPF já está cadastrado.". Isso impede que usuários com o mesmo CPF sejam cadastrados.

    Adicionar Usuário:

Java

usuarios.add(usuario);

    Se o loop terminar sem encontrar um usuário com o mesmo CPF, o novo usuário (usuario) é adicionado à lista usuarios.

Em resumo, o método cadastrarUsuario adiciona um novo usuário à lista de usuários da biblioteca, mas antes verifica se já existe um usuário com o mesmo CPF. Se existir, ele impede o cadastro e lança uma exceção.


## cadastrarLivro dentro da classe Biblioteca

Este código representa o método cadastrarLivro dentro da classe Biblioteca, que é responsável por adicionar um novo livro à lista de livros da biblioteca. Ele funciona de maneira muito similar ao método cadastrarUsuario, que você já viu. Vamos analisar o que acontece nesse método:

    Verificar ISBN Existente:

Java

for (Livro l: livros) {
    if (l.getIsbn().equals(livro.getIsbn())) {
        throw new Exception("Livro com este ISBN já está cadastrado.");
    }
}

    Ele percorre a lista de livros (livros) usando um loop for-each.
    Para cada livro (l) na lista, ele compara o ISBN do livro atual com o ISBN do novo livro (livro) que se deseja cadastrar.
    Se encontrar um livro com o mesmo ISBN, o método lança uma exceção (throw new Exception) com a mensagem "Livro com este ISBN já está cadastrado.". Isso impede que livros com o mesmo ISBN sejam cadastrados, já que o ISBN deve ser único para cada livro.

    Adicionar Livro:

Java

livros.add(livro);

    Se o loop terminar sem encontrar um livro com o mesmo ISBN, o novo livro (livro) é adicionado à lista livros.

Em resumo, o método cadastrarLivro adiciona um novo livro à lista de livros da biblioteca, mas antes verifica se já existe um livro com o mesmo ISBN. Se existir, ele impede o cadastro e lança uma exceção.

## buscarUsuario dentro da classe Biblioteca

Este código representa o método buscarUsuario dentro da classe Biblioteca, que é responsável por localizar um usuário específico na lista de usuários da biblioteca, usando o CPF como chave de busca. Vamos analisar o que acontece nesse método:

    Percorrer a Lista:

Java

for (Usuario usuario: usuarios) {... }

    Ele percorre a lista de usuários (usuarios) usando um loop for-each.

    Comparar CPF:

Java

if (usuario.getCpf().equals(cpf)) {... }

    Para cada usuário (usuario) na lista, ele compara o CPF do usuário atual com o CPF fornecido como argumento (cpf).
    Se o CPF do usuário atual for igual ao CPF buscado, a condição do if é verdadeira.

    Retornar Usuário:

Java

return usuario;

    Se a condição do if for verdadeira (CPF encontrado), o método retorna o objeto Usuario correspondente.

    Usuário Não Encontrado:

Java

// Se o loop terminar sem encontrar o usuário...

    Se o loop for-each terminar sem encontrar um usuário com o CPF buscado, significa que o usuário não está cadastrado na biblioteca.
    Nesse caso, como o código que você forneceu está incompleto, não podemos afirmar com certeza o que acontece. O comportamento mais comum seria lançar uma exceção, como throw new Exception("Usuário não encontrado.");, para indicar que a busca não teve sucesso.

Em resumo, o método buscarUsuario procura um usuário na lista de usuários da biblioteca com base no CPF fornecido. Se encontrar o usuário, retorna o objeto Usuario correspondente; caso contrário, provavelmente lança uma exceção indicando que o usuário não foi encontrado.


## método buscarLivro dentro da classe Biblioteca

Este código representa o método buscarLivro dentro da classe Biblioteca, que é responsável por localizar um livro específico na lista de livros da biblioteca, usando o ISBN como chave de busca. Ele é muito similar ao método buscarUsuario, que você já viu, com uma pequena diferença no final. Vamos analisar o que acontece nesse método:

    Percorrer a Lista:

Java

for (Livro livro: livros) {... }

    Ele percorre a lista de livros (livros) usando um loop for-each.

    Comparar ISBN:

Java

if (livro.getIsbn().equals(isbn)) {... }

    Para cada livro (livro) na lista, ele compara o ISBN do livro atual com o ISBN fornecido como argumento (isbn).
    Se o ISBN do livro atual for igual ao ISBN buscado, a condição do if é verdadeira.

    Retornar Livro:

Java

return livro;

    Se a condição do if for verdadeira (ISBN encontrado), o método retorna o objeto Livro correspondente.

    Livro Não Encontrado:

Java

throw new Exception("Livro não encontrado.");

    Se o loop for-each terminar sem encontrar um livro com o ISBN buscado, significa que o livro não está cadastrado na biblioteca.
    Nesse caso, diferente do buscarUsuario, o método lança uma exceção (throw new Exception) com a mensagem "Livro não encontrado." para indicar que a busca não teve sucesso.

Em resumo, o método buscarLivro procura um livro na lista de livros da biblioteca com base no ISBN fornecido. Se encontrar o livro, retorna o objeto Livro correspondente; caso contrário, lança uma exceção indicando que o livro não foi encontrado.