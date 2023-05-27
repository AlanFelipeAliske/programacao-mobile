
const modelUser = {
    nome: {
        type: String,
        required: true
    },
    sobrenome: {
        type: String,
        required: true
    },
    email: {
        type: String,
        required: true,
        unique: true,
        lowercase: true
    },
    idade: {
        type: Number,
        required: true
    },
    telefone: {
        type: String
    }
}

const usuario = [
    {
        "id": 1,
        "nome": "Alan Felipe",
        "sobrenome": "Aliske",
        "email": "alan@gmail.com",
        "idade": 27,
        "telefone": "(41) 99530-9999"
    }
]

    `
GET minhaapi.com.br/api/v1/alunos (onde iremos recuperar uma lista de alunos)
POST minhaapi.com.br/api/v1/alunos — data {nome: Aluno5, idade: 16}
DELETE minhaapi.com.br/api/v1/alunos/1 (aqui passamos o id 1 do aluno cadastrado e ele será excluído)
PUT minhaapi.com.br/api/v1/alunos/1 — data {nome: Nome novo; idade: 20} (já aqui, passamos o id do aluno e mais as informações a serem atualizadas)
`

const curso = [
    {
        "id": 1,
        "nome": "Pedro Alcantara",
        "disciplinas": ["Biologia", "Botânica", "Quimica", "Genética"],
        "periodo": "5"
    },
    {
        "id": 1,
        "nome": "Artur Vanderley",
        "disciplinas": ["Biologia", "Botânica ll", "Quimica", "Genética ll"],
        "periodo": "6"
    }
]
`
GET minhaapi.com.br/api/v1/cursos (onde iremos recuperar uma lista de cursos)
POST minhaapi.com.br/api/v1/cursos {nome: curso5, idade: 16}
DELETE minhaapi.com.br/api/v1/cursos/1 (aqui passamos o id 1 do curso cadastrado e ele será excluído)
PUT minhaapi.com.br/api/v1/cursos/1 — data {nome: Nome novo; periodo: 20} (já aqui, passamos o id do curso e mais as informações a serem atualizadas)
`


const filmes = [
    {
        "id": 1,
        "titulo": "Titanic",
        "diretor": ["Leonardo Di Caprio"],
        "sessoes": [
            { "data": "27-05-2023", "hora": "13:30" },
            { "data": "27-05-2023", "hora": "13:30" },
            { "data": "27-05-2023", "hora": "13:30" },
        ]
    }
]
`
GET minhaapi.com.br/api/v1/filmes (onde iremos recuperar uma lista de filmes)
POST minhaapi.com.br/api/v1/filmes {nome: se beber nao case, data: 28-06-2023}
DELETE minhaapi.com.br/api/v1/filmes/1 (aqui passamos o id 1 do filme cadastrado e ele será excluído)
PUT minhaapi.com.br/api/v1/filmes/1 — data {nome: Nome novo; data: 20} (já aqui, passamos o id do filme e mais as informações a serem atualizadas)
`
