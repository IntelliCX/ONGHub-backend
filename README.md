<div align="center" >
  <img alt="ONGHub-logo" src="https://cdn.discordapp.com/attachments/1111132306485297203/1115778259804770355/ONGHub-removebg-preview.png"/>
</div>

## Descrição
* <i> Visando potencializar a visibilidade e influência de organizações não governamentais, nós da IntelliCX elaboramos e desenvolvemos o ONGHub, uma espécie de "rede social" para ONG's com foco em auxílio alimentar. No ONGHub as Organizações poderão publicar e divulgar os seus eventos beneficentes para que cheguem até os usuários da plataforma e os mesmos possam se solidarizar e colaborar, seja financeiramente ou fisicamente, com a Organização e suas ações. </i>

## Utilização da API

* <b> Requerimentos: </b> <i> Possuir Docker e Docker-Compose instalados na máquina. Caso não possua, segue links de auxílio para instalação: </i>
  * <b> Windows:</b> <i> https://learn.microsoft.com/pt-br/virtualization/windowscontainers/manage-docker/configure-docker-daemon </i>
  * <b> Linux:</b> <i> https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-20-04-pt </i>

* <b> Para utilizar a API: </b>
  * Estando dentro da raíz do projeto, entre no terminal e insira o seguinte comando:
    * <b> Windows:</b>
      ```
      docker-compose up OU docker compose up
      ```
    
    * <b> Linux:</b>
      ```
      sudo docker-compose up OU sudo docker compose up
      ```

<div align="center" >
  <h2> Endpoint's </h2>
</div>

- `POST /contributors/create`
  - <b> Descrição: </b> <i> Cria o perfil de um contribuidor. </i>
  - <b> Parâmetros: <i> Sem parâmetros. </i> </b>
  - <b> Exemplo de requisição:  </b>
    ```json
    {
     "ongsIds": [
     "3fa85f64-5717-4562-b3fc-2c963f66afa6"
     ],
     "name": "Contributor name",
     "email": "Contributor email",
     "cellphone": "Contributor cellphone"
    }
    ```
  - <b> Exemplo de resposta:  </b>
    ```json
    [
     {
       "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
       "role": "string",
       "name": "string",
       "email": "string",
       "cellphone": "string",
       "createdAt": "2023-06-07T23:11:45.649Z",
       "updatedAt": "2023-06-07T23:11:45.649Z",
       "deletedAt": "2023-06-07T23:11:45.649Z",
       "ongs": [
          {
             "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
             "role": "string",
             "name": "string",
             "email": "string",
             "cellphone": "string",
             "createdAt": "2023-06-07T23:11:45.649Z",
             "updatedAt": "2023-06-07T23:11:45.649Z",
             "deletedAt": "2023-06-07T23:11:45.649Z",
             "contributors": [
                "string"
             ],
       "pixKey": "string",
       "websiteUrl": "string"
          }
       ]
      }
    ]
    ```

- `GET /contributors`
  - <b> Descrição: </b> <i> Lista todos os contribuidores. </i>
  - <b> Parâmetros: <i> Sem parâmetros. </i> </b>
  - <b> Exemplo de resposta:  </b>
    ```json
    [
       {
         "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
         "role": "string",
         "name": "string",
         "email": "string",
         "cellphone": "string",
         "createdAt": "2023-06-07T23:11:45.651Z",
         "updatedAt": "2023-06-07T23:11:45.651Z",
         "deletedAt": "2023-06-07T23:11:45.651Z",
         "contributors": [
            {
               "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
               "role": "string",
               "name": "string",
               "email": "string",
               "cellphone": "string",
               "createdAt": "2023-06-07T23:11:45.651Z",
               "updatedAt": "2023-06-07T23:11:45.651Z",
               "deletedAt": "2023-06-07T23:11:45.651Z",
               "ongs": [
                  "string"
                ]
            }
        ],
       "pixKey": "string",
       "websiteUrl": "string"
       }
    ]
    ```

- `PUT /ongs/update/{id}`
  - <b> Descrição: </b> <i> Atualiza os dados de uma ong específica. </i>
  - <b> Parâmetros: <i> ID, string($uuid) </i> </b>
  - <b> Exemplo de requisição:  </b>
    ```json
    {
     "name": "ONG name",
     "email": "ONG email",
     "cellphone": "ONG cellphone",
     "pixKey": "ONG pix key",
     "websiteUrl": "ONG website url"
    }
    ```
  - <b> Exemplo de resposta:  </b>
    ```json
     {
       "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
       "role": "string",
       "name": "string",
       "email": "string",
       "cellphone": "string",
       "createdAt": "2023-06-07T23:11:45.653Z",
       "updatedAt": "2023-06-07T23:11:45.653Z",
       "deletedAt": "2023-06-07T23:11:45.653Z",
       "contributors": [
        {
         "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
         "role": "string",
         "name": "string",
         "email": "string",
         "cellphone": "string",
         "createdAt": "2023-06-07T23:11:45.653Z",
         "updatedAt": "2023-06-07T23:11:45.653Z",
         "deletedAt": "2023-06-07T23:11:45.653Z",
         "ongs": [
            "string"
          ]
        }
     ],
     "pixKey": "string",
     "websiteUrl": "string"
    }
    
    ```
    
- `POST /ongs/create`
  - <b> Descrição: </b> <i> Criar um novo registro de ong. </i>
  - <b> Exemplo de requisição:  </b>
    ```json
    {
     "name": "ONG name",
     "email": "ONG email",
     "cellphone": "ONG cellphone",
     "pixKey": "ONG pix key",
     "websiteUrl": "ONG website url"
    }
    ```
  - <b> Exemplo de resposta:  </b>
    ```json
     {
       "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
       "role": "string",
       "name": "string",
       "email": "string",
       "cellphone": "string",
       "createdAt": "2023-06-07T23:11:45.655Z",
       "updatedAt": "2023-06-07T23:11:45.655Z",
       "deletedAt": "2023-06-07T23:11:45.655Z",
       "contributors": [
         {
           "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
           "role": "string",
           "name": "string",
           "email": "string",
           "cellphone": "string",
           "createdAt": "2023-06-07T23:11:45.655Z",
           "updatedAt": "2023-06-07T23:11:45.655Z",
           "deletedAt": "2023-06-07T23:11:45.655Z",
           "ongs": [
              "string"
            ]
         }
       ],
       "pixKey": "string",
       "websiteUrl": "string"
      }
    ```
        
- `GET /ongs/{ongId}`
  - <b> Descrição: </b> <i> Busca uma ong específica. </i>
  - <b> Parâmetros: <i> ongID: string($uuid) </i> </b>
  - <b> Exemplo de resposta:  </b>
    ```json
    [
       {
         "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
         "role": "string",
         "name": "string",
         "email": "string",
         "cellphone": "string",
         "createdAt": "2023-06-07T23:11:45.660Z",
         "updatedAt": "2023-06-07T23:11:45.660Z",
         "deletedAt": "2023-06-07T23:11:45.660Z",
         "contributors": [
            {
             "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
             "role": "string",
             "name": "string",
             "email": "string",
             "cellphone": "string",
             "createdAt": "2023-06-07T23:11:45.660Z",
             "updatedAt": "2023-06-07T23:11:45.660Z",
             "deletedAt": "2023-06-07T23:11:45.660Z",
             "ongs": [
                "string"
             ]
            }
        ],
       "pixKey": "string",
       "websiteUrl": "string"
      }
    ]
    ```
       
- `DELETE /ongs/delete/{id}`
  - <b> Descrição: </b> <i> Delete uma ong específica. </i>
  - <b> Parâmetros: <i> ID: string($uuid) </i> </b>
  - <b> Exemplo de resposta:  </b>
    ```json
    {
       "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
       "role": "string",
       "name": "string",
       "email": "string",
       "cellphone": "string",
       "createdAt": "2023-06-07T23:11:45.662Z",
       "updatedAt": "2023-06-07T23:11:45.662Z",
       "deletedAt": "2023-06-07T23:11:45.662Z",
       "contributors": [
          {
             "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
             "role": "string",
             "name": "string",
             "email": "string",
             "cellphone": "string",
            "createdAt": "2023-06-07T23:11:45.662Z",
             "updatedAt": "2023-06-07T23:11:45.662Z",
             "deletedAt": "2023-06-07T23:11:45.662Z",
             "ongs": [
                 "string"
             ]
          }
      ],
     "pixKey": "string",
     "websiteUrl": "string"
    }
    ```
   
- `POST /posts/share`
  - <b> Descrição: </b> <i> Compartilhar posts de outros usuários. </i>
  - <b> Exemplo de requisição:  </b>
    ```json
    {
       "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
       "user": {
         "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
         "role": "string",
         "name": "string",
         "email": "string",
         "cellphone": "string",
         "createdAt": "2023-06-07T23:11:45.664Z",
         "updatedAt": "2023-06-07T23:11:45.664Z",
         "deletedAt": "2023-06-07T23:11:45.664Z"
       },
       "caption": "string",
       "picture": "string",
       "createdAt": "2023-06-07T23:11:45.664Z",
       "updatedAt": "2023-06-07T23:11:45.664Z",
       "deletedAt": "2023-06-07T23:11:45.664Z"
    }
    ```
        
- `POST /posts/askToGpt`
  - <b> Descrição: </b> <i> Pedir para o GPT criar o conteúdo de um post </i>
  - <b> Parâmetros: <i> question: string </i> </b>
  - <b> Exemplo de requisição:  </b>
    ```json
      {
       "data": "Resposta: Ontem fomos a uma comunidade carente e levamos o
      nosso maior caminhao de alimentos para doar. Dezenas de pessoas..."
      }
    ```

- `GET /posts`
  - <b> Descrição: </b> <i> Lista todos os posts. </i>
  - <b> Exemplo de resposta:  </b>
    ```json
    [
       {
         "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
         "user": {
           "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
           "role": "string",
           "name": "string",
           "email": "string",
           "cellphone": "string",
           "createdAt": "2023-06-07T23:11:45.667Z",
           "updatedAt": "2023-06-07T23:11:45.667Z",
           "deletedAt": "2023-06-07T23:11:45.667Z"
         },
         "caption": "string",
         "picture": "string",
         "createdAt": "2023-06-07T23:11:45.667Z",
         "updatedAt": "2023-06-07T23:11:45.667Z",
         "deletedAt": "2023-06-07T23:11:45.667Z"
       }
    ]
    ```

- `GET /posts/{userId}`
  - <b> Descrição: </b> <i> Lista os posts de um usuário específico. </i>
  - <b> Exemplo de resposta:  </b>
    ```json
    [
       {
       "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
       "user": {
         "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
         "role": "string",
         "name": "string",
         "email": "string",
         "cellphone": "string",
         "createdAt": "2023-06-07T23:11:45.668Z",
         "updatedAt": "2023-06-07T23:11:45.669Z",
         "deletedAt": "2023-06-07T23:11:45.669Z"
       },
       "caption": "string",
       "picture": "string",
       "createdAt": "2023-06-07T23:11:45.669Z",
       "updatedAt": "2023-06-07T23:11:45.669Z",
       "deletedAt": "2023-06-07T23:11:45.669Z"
       }
    ]
    ```
