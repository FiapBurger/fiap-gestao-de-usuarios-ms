# Fiap Gestão de Usuários Microservice

## Visão Geral

A Fiap Gestão de Usuários é um microserviço desenvolvido para gerenciar usuários (médicos e pacientes) no sistema de telemedicina da Health&Med. Este serviço fornece funcionalidades como busca, edição, deleção e salvamento de registros de usuários, garantindo segurança e eficiência na gestão de dados sensíveis.

## Índice

- [Visão Geral](#visão-geral)
- [Pré-requisitos](#pré-requisitos)
- [Instalação](#instalação)
- [Configuração](#configuração)
- [Uso](#uso)
  - [Endpoints](#endpoints)
- [Desenvolvimento](#desenvolvimento)
  - [Casos de Uso](#casos-de-uso)
  - [Execução de Testes](#execução-de-testes)
- [Contribuição](#contribuição)
- [Licença](#licença)

## Pré-requisitos

- Java 17
- Gradle
- PostgreSQL

## Instalação

1. Clone o repositório:
    ```sh
    git clone https://github.com/FiapBurger/fiap-gestao-de-usuarios-ms.git
    cd fiap-gestao-de-usuarios-ms
    ```

2. Compile e construa o projeto usando Gradle:
    ```sh
    ./gradlew build
    ```

## Configuração

1. Configure o banco de dados PostgreSQL com as seguintes credenciais:
    - **Host:** `localhost`
    - **Porta:** `5432`
    - **Nome do Banco:** `fiap_gestao_usuarios`
    - **Usuário:** `postgres`
    - **Senha:** `password`

2. Atualize as configurações do banco de dados no arquivo `application.properties`:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/fiap_gestao_usuarios
    spring.datasource.username=postgres
    spring.datasource.password=password
    spring.jpa.hibernate.ddl-auto=update
    ```

## Uso

### Endpoints

- **Buscar Médico**
  - **GET** `/medicos/{crm}`
  - Exemplo de resposta:
    ```json
    {
      "crm": "123456",
      "nome": "Dr. João Silva",
      "especialidade": "Cardiologia"
    }
    ```

- **Buscar Paciente**
  - **GET** `/pacientes/{id}`
  - Exemplo de resposta:
    ```json
    {
      "id": "78910",
      "nome": "Maria Santos",
      "idade": 30
    }
    ```

- **Salvar Médico**
  - **POST** `/medicos`
  - Exemplo de corpo da requisição:
    ```json
    {
      "crm": "123456",
      "nome": "Dr. João Silva",
      "especialidade": "Cardiologia"
    }
    ```

- **Salvar Paciente**
  - **POST** `/pacientes`
  - Exemplo de corpo da requisição:
    ```json
    {
      "id": "78910",
      "nome": "Maria Santos",
      "idade": 30
    }
    ```

- **Editar Médico**
  - **PUT** `/medicos`
  - Exemplo de corpo da requisição:
    ```json
    {
      "crm": "123456",
      "nome": "Dr. João Silva",
      "especialidade": "Neurologia"
    }
    ```

- **Editar Paciente**
  - **PUT** `/pacientes`
  - Exemplo de corpo da requisição:
    ```json
    {
      "id": "78910",
      "nome": "Maria Santos",
      "idade": 31
    }
    ```

- **Deletar Médico**
  - **DELETE** `/medicos/{crm}`

- **Deletar Paciente**
  - **DELETE** `/pacientes/{id}`

## Desenvolvimento

### Casos de Uso

- **BuscarMedicoUseCase**
  ```java
  public class BuscarMedicoUseCase implements BuscarMedicoInputPort {
      // Implementação...
  }


# micro-service-customer
![image](https://github.com/JPSSouza/micro-service-customer/assets/20976819/dd1321b4-563e-41a2-9830-443a12aa50a3)

![image](https://github.com/JPSSouza/micro-service-customer/assets/20976819/1746b355-103d-4ff8-b8b3-83e24f4d2f4c)




