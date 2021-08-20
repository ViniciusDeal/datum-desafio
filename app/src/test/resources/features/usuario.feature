#language: pt

  Funcionalidade: Gerenciamento de usuario


  Cenario: Criar usuario
    Quando faco um post para /users com os dados:
      | name | usuarioteste |
      | job  | leader       |
    Entao faco um get para /users?page=2 com todos os usuarios


    Cenario: Criar usuario
      Quando crio um usuario
      Entao os usuario sao retornados
