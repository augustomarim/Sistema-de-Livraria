# 📚 Sistema de Livraria

Sistema de Livraria desenvolvido em **Java**, com funcionamento via **console**, voltado para o gerenciamento de livros, autores, clientes e empréstimos.

O projeto foi desenvolvido com foco em aplicar conceitos de **Programação Orientada a Objetos (POO)**, organização em pacotes e boas práticas de desenvolvimento.

---

## 🚀 Funcionalidades

- Cadastro, edição e inativação de clientes
- Cadastro, edição e inativação de autores
- Cadastro e edição de livros
- Controle de disponibilidade dos livros
- Retirada e devolução de livros
- Registro de empréstimos
- Listagem de:
  - Clientes
  - Autores
  - Livros
  - Empréstimos
- Filtros de busca de livros (nome, autor, gênero e data)

---

## 🛠️ Tecnologias utilizadas

- Java
- IntelliJ IDEA
- API `java.time` (LocalDate)
- Estruturas de dados (`List`, `ArrayList`)

---

## 📂 Estrutura do projeto
src/
  sistemalivraria/
    app        - Classe principal (Main),
    model      - Entidades do sistema (Livro, Autor, Cliente, Emprestimo, enums),
    service    - Regras de negócio e operações do sistema

## ▶️ Como executar o projeto

1. Clone ou baixe este repositório
2. Abra o projeto em uma IDE Java de sua preferência
3. Execute a classe `Main` localizada no pacote `sistemalivraria.app`
4. Utilize o menu interativo exibido no console

---

## 📌 Observações

- O sistema utiliza **exclusão lógica**, mantendo o histórico de dados
- Os IDs são gerados automaticamente
- O projeto não utiliza banco de dados (dados em memória)

---

## 👨‍💻 Autor - Augusto Luiz Marim

Projeto desenvolvido para fins acadêmicos.

