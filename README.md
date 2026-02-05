# 📝 TaskFlow API

Uma API de gerenciamento de tarefas (**To-Do List**) desenvolvida para demonstrar boas práticas de arquitetura REST, validação de dados e separação de responsabilidades.

---

## 🚀 Tecnologias

- **Java 17**
- **Spring Boot 4.0.2**
- **Spring Data JPA**
- **Jakarta Validation (Bean Validation)**
- **H2 Database** (Banco de dados em memória para testes)

---

## 🏗️ Diferenciais da Arquitetura

O projeto foi construído com foco em **extensibilidade** e **segurança de dados**:

- **Separação por DTOs**  
  Uso de DTOs distintos para criação (`TaskRequestDTO`) e atualização (`TaskUpdateRequestDTO`), permitindo regras de validação diferentes para cada operação.

- **Atualização Parcial (PATCH)**  
  Implementação de lógica que permite alterar campos específicos sem a necessidade de enviar o objeto completo.

- **Camada de Mapper**  
  Conversão manual entre **Entidades** e **DTOs**, mantendo o `Service` focado apenas na regra de negócio.

- **Validações Robustas**  
  Uso de anotações como `@FutureOrPresent`, `@NotBlank` e `@Size` para garantir a integridade das informações.

---

## 🛠️ Como rodar o projeto

Clone o repositório:

```bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git
```

Entre na pasta do projeto e execute via Maven:

```bash
./mvnw spring-boot:run
```

A API estará disponível em: http://localhost:8080

## 🛣️ Endpoints Principais

| Método | Endpoint          | Descrição                                     |
|--------|------------------|-----------------------------------------------|
| POST   | `/api/tasks`     | Cria uma nova tarefa                          |
| GET    | `/api/tasks`     | Lista todas as tarefas                        |
| GET    | `/api/tasks/{id}`| Busca uma tarefa por ID                       |
| PATCH  | `/api/tasks/{id}`| Atualização parcial (título, descrição, etc.) |
| DELETE | `/api/tasks/{id}`| Remove uma tarefa                             |


## 📌 Exemplo de JSON para Criação (POST)
```json
{
  "title": "Estudar Spring Boot",
  "description": "Finalizar o módulo de DTOs e Mappers",
  "dueDate": "2026-12-31T10:00:00"
}
```

## 🧪 Próximos Passos
[ ] Implementar Global Exception Handler

[ ] Adicionar Testes Unitários (JUnit 5 / Mockito)

[ ] Documentação com Swagger (OpenAPI)
