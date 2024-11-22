# QBank
Desenvolvimento do Qbank, um banco digital utilizando a metodologia de Desenvolvimento Orientado por Testes (TDD) e  ferramentas de integração contínua. 

# Objetivo 
Desenvolver um sistema que permite que os clientes do banco realizem diversas operações bancárias por meio do Aplicativo. Inclui gerenciamento de contas, transações para fazer transferências e pagamentos de serviços externos, como universidades e telefonia. A conta do cliente permitirá o acesso a todas essas operações.


# 1. Inicializão do Projeto

Aqui criamos a classe Usuario, para que o cliente consiga inserir os seus dados tanto para fazer login e cadastro mas para utilizar algumas das ações contidas no sistema.

![Captura de tela 2024-10-31 185455](https://github.com/user-attachments/assets/068b713d-9e88-455b-ae81-62b0f1e94a04)

Neste passo, criamos uma classe Bando de Dados, para que consigamos armazenar todos os dados do Usuário.

![Captura de tela 2024-10-31 185521](https://github.com/user-attachments/assets/22afb1b6-b842-4e2f-bb56-41e1896522a1)

Aqui foi feito o sistema que é disponibilizado para que o usuário tenha acesso para fazer o login.

![Captura de tela 2024-10-31 185550](https://github.com/user-attachments/assets/c8256abe-0d60-4bf3-a8a5-9d6219673152)

Neste, é o sistema feito para caso o usuário esqueça a senha, ele tera a oportunidade de recupera-la.

![Captura de tela 2024-10-31 185835](https://github.com/user-attachments/assets/725fb21c-0dbd-4bb3-a18a-731f223a0b4f)

Sistema para que o usuario consiga depositar dinheiro em sua conta.

![Captura de tela 2024-11-05 211556](https://github.com/user-attachments/assets/d9021c5f-908a-46b4-b3f3-38d499149588)

Neste caso, é um sistema que com ele o usuario consegue sacar qualquer quantia em dinheiro.

![Captura de tela 2024-11-05 211616](https://github.com/user-attachments/assets/d3c5c10f-94bb-4d22-8662-272c7261cdbd)

Aqui, desenvolvemos um sistema que da acesso ao usuario poder fazer qualquer tipo de transferencia.

![Captura de tela 2024-11-05 211634](https://github.com/user-attachments/assets/b7553198-e1a5-441e-a4a7-9accfc2ee2f7)


# 2. Funcionalidades

Cadastro de novos usuários.

Login seguro com verificação de credenciais.

Criação e gestão de contas bancárias.

Operações bancárias como depósitos, saques e transferências.

# 3. Roadmap
 
 [x] Cadastro e autenticação de usuários.
 
 [X] Operações bancárias (depósito, saque, transferência).
 
 [X] Sistema de notificações para movimentações financeiras.
 
 [ ] Testes automatizados.

# 3. Como Executar o Projeto (Passo a Passo) Após o projeto estar finalizado0.

# 4. Tecnologias Utilizadas

Java para lógica de back-end.

Spring Boot para criar o servidor da aplicação.

MySQL para armazenamento de dados.

JWT (JSON Web Token) para autenticação e segurança.

Controle de fluxo (if/else) para verificar se os valores de depósito, saque e transferência são válidos.

# 5. Uso

Cadastro: O usuário deve inserir dados como nome, CPF e senha.

Login: Ao entrar, o usuário insere seu CPF e senha.

Transaçoes: Pix para terceiro, pix para instituição, saque e deposito.

# 6. Resultados Esperados
Um sistema que permite que os clientes do banco realizem diversas operações bancárias por meio do Aplicativo. Inclui gerenciamento de contas, transações para fazer transferências e pagamentos de serviços externos, como universidades e telefonia. A conta do cliente permitirá o acesso a todas essas operações.

