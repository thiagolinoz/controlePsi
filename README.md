Este primeira etapa do projeto realiza o cadastro de pacientes e suas infos por um administrador da plataforma.

Com os seguintes enpoint:  
HTTP GET    /pacientes      - lista todos usuários cadastrados  
HTTP GET    /pacientes/{id} - mostra todos infos de um usuário especifico  
HTTP POST   /pacientes           - cria um novo usuário  
HTTP PUT    /pacientes/{id}      - atualiza um usuário em especifico  
HTTP DELETE /pacientes/{id}    - deleta um usuário em especifico  

A plataforma foi construida utilizando a linguagem Java. O framework Spring. E para persistência de dados o PostgreSQL.
