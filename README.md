# Fiap Gestão de Usuários Microservice

## Visão Geral

A Fiap Gestão de Usuários é um microserviço desenvolvido para gerenciar usuários (médicos e pacientes) no sistema de telemedicina da Health&Med. Este serviço fornece funcionalidades como busca, edição, deleção e salvamento de registros de usuários, garantindo segurança e eficiência na gestão de dados sensíveis.

## Índice

- [Visão Geral](#visão-geral)
- [Arquitetura do Sistema](#arquitetura-do-sistema)
  - [Componentes Principais](#componentes-principais)
  - [Fluxo de Dados](#fluxo-de-dados)
- [Funcionalidades Principais](#funcionalidades-principais)
- [Instalação](#instalação)
- [Configuração](#configuração)
- [Uso](#uso)
  - [Endpoints](#endpoints)
    

## Pré-requisitos

- Java 17
- Gradle
- PostgreSQL

### Componentes Principais

1. **Microserviço de Gestão de Usuários**
   - **Responsabilidades**: Gerenciar informações de médicos e pacientes, incluindo criação, leitura, atualização e deleção de registros.
   - **Tecnologias**: Spring Boot, PostgreSQL, Kubernetes.

2. **Banco de Dados**
   - **Descrição**: Armazena informações detalhadas sobre médicos e pacientes.
   - **Tecnologia**: PostgreSQL.

3. **Kubernetes**
   - **Descrição**: Orquestração de contêineres para garantir alta disponibilidade e escalabilidade do microserviço.
   - **Componentes**:
     - **Deployment**: Configuração de como o microserviço é implantado.
     - **Service**: Exposição do microserviço para comunicação externa e interna.

### Fluxo de Dados

1. **Cadastro de Usuários**
   - **Descrição**: Permite o cadastro de novos médicos e pacientes no sistema.
   - **Fluxo**:
     1. O usuário envia uma solicitação de cadastro.
     2. O microserviço valida e salva os dados no banco de dados.
     3. Uma confirmação é enviada de volta ao usuário.

2. **Busca de Usuários**
   - **Descrição**: Permite a busca de informações de médicos e pacientes.
   - **Fluxo**:
     1. O usuário envia uma solicitação de busca com parâmetros (ex: CRM, CPF).
     2. O microserviço consulta o banco de dados e retorna os dados correspondentes.

3. **Atualização de Usuários**
   - **Descrição**: Permite a atualização de dados de médicos e pacientes.
   - **Fluxo**:
     1. O usuário envia uma solicitação com os dados atualizados.
     2. O microserviço valida e atualiza as informações no banco de dados.
     3. Uma confirmação é enviada de volta ao usuário.

4. **Deleção de Usuários**
   - **Descrição**: Permite a remoção de registros de médicos e pacientes.
   - **Fluxo**:
     1. O usuário envia uma solicitação de deleção.
     2. O microserviço valida e remove os dados do banco de dados.
     3. Uma confirmação é enviada de volta ao usuário.

## Funcionalidades Principais

- **Cadastro de Médicos e Pacientes**
  - Permite adicionar novos médicos e pacientes ao sistema.
- **Busca de Médicos e Pacientes**
  - Permite buscar informações detalhadas sobre médicos e pacientes.
- **Atualização de Dados**
  - Permite a atualização das informações de médicos e pacientes.
- **Deleção de Registros**
  - Permite a remoção de registros de médicos e pacientes do sistema.
    
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




## Diagrama
![image](https://github.com/JPSSouza/micro-service-customer/assets/20976819/dd1321b4-563e-41a2-9830-443a12aa50a3)

![image](https://github.com/JPSSouza/micro-service-customer/assets/20976819/1746b355-103d-4ff8-b8b3-83e24f4d2f4c)




