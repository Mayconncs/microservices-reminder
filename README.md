# Microserviço lembrete

Este serviço de lembrete foi desenvolvido usando Java, Java Spring, Flyway Migrations, PostgreSQL, Spring Security e JWT.

## Uso

1. Inicie a aplicação com o Maven
2. O serviço estará acessível em http://localhost:8080

## Autenticação
Este serviço usa Spring Security para autenticação. Tipos disponíveis:
```
USER -> Conta padrão.
ADMIN -> Conta administrativa.
```

## Endpoints
O serviço contém os seguintes endpoints:

**POST REGISTER USER**

```markdown
POST /auth/register - Registra a conta do usuário
```

```json
{
  "login":"Carlos",
  "password":"12345",
  "role":"ADMIN"
}
```

**POST LOGIN**
```
POST /auth/login - login do usuário
```
```json
{
  "login":"Carlos",
  "password":"12345"
}
```

**POST REGISTER REMINDER**
```markdown
POST /reminder - cria o lembrete
```
```json
{
  "id": "1e8b9ee0-667a-4265-9640-9839551d80b2",
  "title": "Compre a passagem",
  "email": "Carlos.ms@gmail.com",
  "details": "Comparar preços e horários para encontrar a melhor opção. Obs: compre duas passagens",
  "date": "02/07/2024"
}
```

**GET ALL REMINDERS**
```markdown
GET /reminder - Obtém todos os lembretes criados
```
```json
[
  {
    "id": "1e8b9ee0-667a-4265-9640-9839551d80b2",
    "title": "Compre a passagem",
    "email": "Carlos.ms@gmail.com",
    "details": "Comparar preços e horários para encontrar a melhor opção. Obs: compre duas passagens",
    "date": "02/07/2024"
  },
  {
    "id": "9e3c509f-ac4e-4f22-9837-d9642c2b6f4b",
    "title": "Passe ao mercado na volta",
    "email": "Carlos.ms@gmail.com",
    "details": "Faça as compras para o feriado",
    "date": "15/01/2024"
  }
]
```

**GET UPCOMING REMINDER**
```markdown
GET /reminder/upcoming - Obtém lembretes pendentes
```
```json
[
  {
    "id": "1e8b9ee0-667a-4265-9640-9839551d80b2",
    "title": "Compre a passagem",
    "email": "Carlos.ms@gmail.com",
    "details": "Comparar preços e horários para encontrar a melhor opção. Obs: compre duas passagens",
    "date": "02/07/2024"
  }
]
```

**PUT REMINDER**
```markdown
PUT /reminder/{id} - atualiza o lembrete
```
```json
{
  "id": "9e3c509f-ac4e-4f22-9837-d9642c2b6f4b",
  "title": "Passe ao mercado na volta",
  "email": "Carlos.ms@gmail.com",
  "details": "Faça as compras para o feriado antes que o mercado feche",
  "date": "15/01/2024"
}
```

**DELETE REMINDER**
```markdown
PUT /reminder/{id} - deleta o lembrete por id
```

## Banco de dados
O projeto utiliza o banco de dados PostgreSQL e as migrações são configuradas com Flyway.

# Microserviço Email

Este projeto é um serviço desenvolvido em Java, Java Spring, AWS Email Service.

## Uso

1. Inicie a aplicação com o Maven
2. O serviço estará acessível em http://localhost:8081
3. Coloque suas credenciais AWS em application.properties
4. Execute ambos os microsserviços

## Endpoints
O serviço contém o seguinte endpoint:

**POST EMAIL**
```markdown
POST /service/email/send - envia email
```
```json
{
  "to":"Carlos.ms@gmail.com",
  "subject":"Compre a passagem",
  "body":"Comparar preços e horários para encontrar a melhor opção. Obs: compre duas passagens"
}
```




