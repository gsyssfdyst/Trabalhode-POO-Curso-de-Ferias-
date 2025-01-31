# Projeto Biblioteca

Objetivo:

Desenvolver um sistema de gestão de biblioteca completo e intuitivo, utilizando conceitos de Programação Orientada a Objetos, para otimizar a organização e o controle de livros, usuários e empréstimos em uma biblioteca universitária. O sistema deve ser capaz de lidar com diferentes tipos de usuários, como alunos e servidores, e fornecer funcionalidades para cadastro, consulta, alteração, remoção e persistência de dados, além de garantir a integridade dos dados e o cumprimento das regras de negócio da biblioteca.

Funcionalidades Principais:

Gerenciamento de Usuários:

    Cadastro de Usuários:
        Permitir o cadastro de diferentes tipos de usuários (alunos e servidores) com seus respectivos atributos, como CPF, nome, endereço, telefone, email, matrícula, curso (para alunos) e cargo (para servidores).
        Validar os dados de entrada para garantir a consistência e evitar duplicidade de CPF.
        Implementar tratamento de exceções para lidar com erros durante o cadastro, como CPF já existente.
    Edição de Usuários:
        Permitir a edição de informações de usuários existentes, incluindo a atualização de seus atributos.
        Manter a validação de dados e o tratamento de exceções durante a edição.
    Remoção de Usuários:
        Permitir a remoção de usuários do sistema, com a devida confirmação para evitar exclusões acidentais.
        Implementar tratamento de exceções para lidar com casos em que o usuário não existe.
    Listar Usuários:
        Listar todos os usuários cadastrados, ordenados crescentemente por nome.
        Permitir a listagem de usuários por tipo (aluno ou servidor).

Gerenciamento de Livros:

    Cadastro de Livros:
        Permitir o cadastro de livros com seus atributos, como ISBN, título, autor(es), editora, número de páginas e quantidade.
        Validar os dados de entrada para garantir a consistência e evitar duplicidade de ISBN.
        Implementar tratamento de exceções para lidar com erros durante o cadastro, como ISBN já existente.
    Edição de Livros:
        Permitir a edição de informações de livros existentes, incluindo a atualização de seus atributos.
        Manter a validação de dados e o tratamento de exceções durante a edição.
    Remoção de Livros:
        Permitir a remoção de livros do sistema, com a devida confirmação para evitar exclusões acidentais.
        Implementar tratamento de exceções para lidar com casos em que o livro não existe.
    Listar Livros:
        Listar todos os livros cadastrados, ordenados crescentemente por título.

Gerenciamento de Empréstimos:

    Realizar Empréstimo:
        Permitir o empréstimo de livros para usuários, verificando as regras de negócio, como a disponibilidade de exemplares, o limite de empréstimos por usuário e a existência de empréstimos anteriores do mesmo livro para o mesmo usuário.
        Atualizar a quantidade de exemplares disponíveis do livro após o empréstimo.
        Registrar o empréstimo com o ISBN do livro, o CPF do usuário e a data do empréstimo.
        Implementar tratamento de exceções para lidar com erros durante o empréstimo, como livro indisponível, usuário não encontrado ou limite de empréstimos atingido.
    Devolver Livro:
        Permitir a devolução de livros emprestados, atualizando a quantidade de exemplares disponíveis e removendo o registro do empréstimo.
        Implementar tratamento de exceções para lidar com erros durante a devolução, como livro não emprestado ou usuário não encontrado.

Persistência de Dados:

    Salvar Dados:
        Salvar os dados de usuários e livros em arquivos separados, garantindo a persistência dos dados entre as execuções do programa.
        Utilizar formatos de arquivo adequados, como arquivos de texto (CSV, JSON) ou arquivos binários, para armazenar os dados de forma eficiente.
    Carregar Dados:
        Carregar os dados de usuários e livros a partir dos arquivos salvos ao iniciar o programa, restaurando o estado do sistema.

Regras de Negócio:

    Limite de Empréstimos:
        Alunos podem pegar até 3 livros por vez.
        Servidores podem pegar até 5 livros por vez.
    Disponibilidade de Livros:
        Um livro só pode ser emprestado se houver exemplares disponíveis no estoque.
    Ordenação:
        A listagem dos usuários deve ser ordenada crescentemente por nome.
        A listagem dos livros deve ser ordenada crescentemente por título.
    Busca:
        As operações de busca, remoção e edição devem ser realizadas utilizando o CPF para usuários e o ISBN para livros.
    Validação de Dados:
        Garantir que não haja dois usuários com o mesmo CPF e que não haja dois livros com o mesmo ISBN no sistema.
        Validar os dados de entrada para evitar inconsistências e erros no sistema.
    Tratamento de Exceções:
        Implementar tratamento de exceções para lidar com erros e situações inesperadas durante a execução do programa, como dados inválidos, operações ilegais e problemas de acesso a arquivos.

Interface do Usuário:

    Utilizar uma interface de linha de comando (CLI) para interagir com o usuário, fornecendo um menu com as opções disponíveis e exibindo mensagens claras e informativas.
    Opcionalmente, desenvolver uma interface gráfica (GUI) para tornar o sistema mais amigável e intuitivo.

Considerações Adicionais:

    Utilizar boas práticas de programação, como modularização, encapsulamento e comentários, para tornar o código mais legível, manutenível e reutilizável.
    Documentar o código e as funcionalidades do sistema para facilitar o entendimento e a utilização por outros desenvolvedores e usuários.
    Realizar testes abrangentes para garantir a qualidade e a confiabilidade do sistema.

Entrega:

    O projeto deve ser entregue com o código-fonte completo, documentação e instruções de uso.
    É recomendado o uso de um sistema de controle de versão, como Git, para gerenciar o código-fonte e facilitar o trabalho em equipe.

Observações:

    Esta versão aprimorada do "Projeto Biblioteca" visa fornecer uma descrição mais completa e detalhada, incluindo aspectos importantes como validação de dados, tratamento de exceções, persistência de dados e interface do usuário.
    A implementação específica do projeto pode variar de acordo com as necessidades da biblioteca e as escolhas dos desenvolvedores.


