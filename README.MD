
# 🚀 Sistema Simplificado de Gestão de Catálogo e Pedidos em Java 

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Design Patterns](https://img.shields.io/badge/Design%20Patterns-Aprendizado%20Avançado-blueviolet?style=for-the-badge)
![POO](https://img.shields.io/badge/POO-Conceitos%20Sólidos-success?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge)

## 🌟 Sobre o Projeto

Este é um projeto desenvolvido com foco em consolidar e aplicar os principais conceitos de **Programação Orientada a Objetos (POO)** e **Design Patterns** em Java. Ele simula um sistema básico de gestão de catálogo de produtos e o processamento de pedidos em um ambiente de e-commerce simplificado, operando com dados em memória.

## ✨ Funcionalidades

-   **Gestão de Produtos:** Adição de novos produtos ao catálogo.
-   **Gestão de Pedidos:** Criação de novos pedidos e atualização de seus status.
-   **Consulta de Dados:** Listagem de todos os produtos e pedidos registrados.

## 🛠️ Tecnologias e Conceitos Aplicados

-   **Java:** Linguagem de programação principal.
-   **Programação Orientada a Objetos (POO):** Encapsulamento, Herança, Polimorfismo e Abstração.
-   **Generics:** Utilizados para criar DAOs reutilizáveis e com segurança de tipo.
-   **Collections (Map, List):** Armazenamento e manipulação de dados em memória.
-   **Enums:** Para gerenciamento de status de pedidos.

## 🧱 Design Patterns Implementados

Este projeto é um excelente exemplo da aplicação prática de diversos Design Patterns, garantindo um código limpo, flexível e de fácil manutenção:

-   ### **DAO (Data Access Object) Pattern**
    * **`IPersistente`**: Interface que define um contrato para todas as entidades persistíveis, garantindo que possuam um código (ID).
    * **`IGenericDAO`**: Interface genérica para operações CRUD (Create, Read, Update, Delete), aceitando qualquer tipo de entidade `T` que seja `IPersistente`.
    * **`GenericDAO`**: Classe abstrata que implementa a lógica CRUD genérica, utilizando um `Map` aninhado (`Map<Class, Map<Long, T>>`) para armazenamento em memória e um `innerMapCache` para otimização do acesso.
    * **`ProdutoDAO` e `PedidoDAO`**: Implementações concretas que estendem `GenericDAO`, reutilizando toda a lógica de persistência e se mantendo concisas.

-   ### **Builder Pattern**
    * Aplicado para a construção fluente e segura de objetos `Produto` e `Pedido`. Permite a criação de objetos com muitos atributos de forma mais legível, gerenciando campos obrigatórios e opcionais.

-   ### **Facade Pattern**
    * **`ProcessadorPedidosFacade`**: Oferece uma interface simplificada para operações complexas do sistema de pedidos (como "adicionar produto ao catálogo", "realizar novo pedido" e "atualizar status do pedido"), orquestrando chamadas aos DAOs subjacentes.

-   ### **Template Method Pattern (Implícito em `GenericDAO.alterar`)**
    * Embora a implementação final de `alterar()` tenha sido simplificada para o `Map`, a discussão e a possibilidade de se ter um método abstrato para "atualizarDados" em `GenericDAO` (que seria implementado por `ProdutoDAO`, `PedidoDAO`) demonstra como o Template Method pode ser usado para fixar o fluxo geral de uma operação e delegar os detalhes específicos da entidade às subclasses.

## 📁 Estrutura do Projeto

```

src
└── br.com.carlosbrito
├── dao
│   ├── GenericDAO.java
│   ├── PedidoDAO.java
│   └── ProdutoDAO.java
├── facade
│   └── ProcessadorPedidosFacade.java
├── interfaces
│   ├── IGenericDAO.java
│   ├── IPedidoDAO.java
│   ├── IPersistente.java
│   └── IProdutoDAO.java
├── main
│   └── Main.java
├── model
│   ├── ItemPedido.java
│   ├── Pedido.java
│   └── Produto.java
└── util
└── StatusPedido.java

```

## 🚀 Como Executar

1.  Clone este repositório.
2.  Abra o projeto em sua IDE Java favorita (IntelliJ IDEA, Eclipse, VS Code).
3.  Navegue até a classe `br.com.carlosbrito.main.Main.java`.
4.  Execute o método `main()`. As operações e resultados serão exibidos no console.

## 👤 Autor

**CBritoDev (Carlos Brito)**

## 📄 Licença

Este projeto está licenciado sob a Licença MIT.

---
