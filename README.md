# Desafio LPOO - DIO

Projeto Java de desafio de Programação Orientada a Objetos da [DIO (Digital Innovation One)](https://www.dio.me/).

## Estrutura do Projeto

```
src/
├── Main.java                           # Classe principal com método main
└── br/com/dio/desafio/dominio/         # Pacote com as classes do domínio
    ├── Conteudo.java                   # Classe abstrata base
    ├── Curso.java                      # Classe que representa um curso
    ├── Mentoria.java                   # Classe que representa uma mentoria
    ├── Bootcamp.java                   # Classe que representa um bootcamp
    └── Dev.java                        # Classe que representa um desenvolvedor
```

## Como Compilar e Executar

### Compilar
```bash
javac -d out src/br/com/dio/desafio/dominio/*.java src/Main.java
```

### Executar
```bash
java -cp out Main
```

## Sobre o Package

**Importante:** Em Java, a declaração do `package` deve corresponder exatamente à estrutura de diretórios onde o arquivo está localizado.

Por exemplo:
- Se o arquivo `Curso.java` declara `package br.com.dio.desafio.dominio;`
- Então o arquivo deve estar no caminho: `src/br/com/dio/desafio/dominio/Curso.java`

Se houver divergência entre a declaração do package e o caminho do arquivo, ocorrerá erro de compilação.