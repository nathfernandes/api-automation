# 🐶 Dog API - API Test Automation

![CI](https://github.com/nathfernandes/api-automation/actions/workflows/api-tests.yml/badge.svg)
[![Allure Report](https://img.shields.io/badge/View-Allure_Report-ff6f00)](https://nathfernandes.github.io/api-automation/)

![Java](https://img.shields.io/badge/Java-17-blue.svg)
![RestAssured](https://img.shields.io/badge/RestAssured-API%20Testing-green.svg)
![Allure Report](https://img.shields.io/badge/Allure-Reports-orange.svg)

Projeto de automação de testes de API com RestAssured + JUnit 5 + JSON Schema + Allure + GitHub Actions.

---

## 🚀 Tecnologias utilizadas

- Java 17
- RestAssured
- JUnit 5
- AssertJ
- JSON Schema Validator
- Maven
- Allure Reports
- GitHub Actions (CI)
- GitHub Pages (publicação de report)

---

## 📦 Pré-requisitos

Antes de rodar o projeto, você precisa ter instalado:

- Java 17+
- Maven 3.8+
- Allure CLI (opcional para execução local do report)
- Git

---

## 📡 API utilizada

Dog API pública:

https://dog.ceo/api


---

## 🧪 Rodar testes localmente

```bash
mvn clean test
```

---

## 📊 Gerar relatório Allure

Após executar os testes:

```bash
mvn allure:serve
```

Isso irá gerar e abrir automaticamente o relatório no navegador.

---

## 🤖 CI - GitHub Actions

Os testes são executados automaticamente via GitHub Actions sempre que há:

- push na branch `main`
- pull requests
- execução manual via `workflow_dispatch`

### 🔗 Workflow

https://github.com/nathfernandes/api-automation/actions/

---

## 🌐 Allure Report (GitHub Pages)

O relatório é publicado automaticamente após cada execução do CI.

🔗 Acesso ao report

https://nathfernandes.github.io/api-automation/

---

## 📁 Estrutura do projeto

```
src
├── test
│    ├── java
│    │    └── com.dog.api
│    │         ├── base
│    │         ├── clients
│    │         ├── config
│    │         ├── tests
│    │         ├── utils
│    └── resources
│         └── schemas
```

---

🧪 Pipeline CI/CD

Fluxo automático:
1. Push na branch main
2. GitHub Actions executa testes de API
3. Validação de contrato via JSON Schema
4. Allure report é gerado
5. Report é publicado no GitHub Pages

---

## 📌 Estratégia de testes

Este projeto cobre:

### ✔ Validação funcional
- Status codes HTTP
- Consistência das respostas da API

### ✔ Contract testing
- Validação de schema JSON das respostas

---

## ⚙️ Decisões de arquitetura

- JSON Schema utilizado para validação de contrato
- RestAssured para testes de API
- Arquitetura leve e focada em legibilidade
- Separação clara entre client, config e tests
- Allure para visibilidade dos testes em CI

---

## 👤 Autor

Projeto desenvolvido por **Nathalia Fernandes**



