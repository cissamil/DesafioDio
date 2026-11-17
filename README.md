# Projeto Zoológico — Desafio DIO

Projeto simples em Java, desenvolvido como exercício prático dos conceitos fundamentais da **Programação Orientada a Objetos (POO)**. A aplicação simula um zoológico com animais, visitantes e as interações entre eles. Toda a execução acontece no `Main` e o resultado é exibido no console.

---

## 📂 Estrutura

```
DesafioDio/
├── Main.java
└── src/main/java/br/com/desafio/dio/dominio/
    ├── AnimalZoo.java      → classe abstrata (molde de todo animal)
    ├── Macaco.java         → animal concreto
    ├── Tigre.java          → animal concreto
    ├── Cobra.java          → animal concreto
    ├── Arara.java          → animal concreto
    ├── Zoologico.java      → gerencia animais e visitantes
    ├── Visitante.java      → pessoa que visita animais
    └── visitarAnimal.java  → classe auxiliar (atualmente não utilizada)
```

| Classe | Papel |
|---|---|
| `AnimalZoo` | Classe **abstrata**: define nome, espécie e os métodos `emitirSom()`, `comer()` e `dormir()` sem implementação |
| `Macaco`, `Tigre`, `Cobra`, `Arara` | Herdam de `AnimalZoo` e implementam os 3 métodos do seu jeito |
| `Zoologico` | Guarda duas listas: `animais` e `visitantes` |
| `Visitante` | Tem um nome e uma lista de `animaisVisitados` |
| `Main` | Orquestra a simulação |

---

## ▶️ Fluxo de execução (`Main`)

1. Cria o zoológico `"Zoológico Yellow!"`.
2. Cria 4 animais (George, Yuna, Kemily e Maicon) e adiciona com `adicionarAnimal()`.
3. Cria 2 visitantes (Clarissa e Camila) e registra com `adicionarVisitante()`.
4. Clarissa visita o macaco e o tigre. A cada visita:
   - `visitarAnimal(animal)` adiciona o animal à lista do visitante;
   - o `Main` chama `emitirSom()`, `comer()` e `dormir()` do animal.
5. Exibe os animais visitados pela Clarissa.

---

# 🧠 Os conceitos de POO no projeto

## 0. A base: Classe × Objeto

**Conceito:** a classe é o *molde*; o objeto é a *coisa real* criada a partir desse molde.

```java
public class Macaco extends AnimalZoo { ... }    // ← CLASSE (molde)

Macaco macaco = new Macaco("George");             // ← OBJETO (instância)
```

O `new` reserva espaço na memória e cria um macaco real chamado George. `new Macaco("Chico")` criaria um **segundo objeto** a partir do mesmo molde.

> **Analogia:** a classe é o *modelo* do CT-e (Conhecimento de Transporte Eletrônico), com os mesmos campos para todos. Cada CT-e emitido, com seu número próprio, é um objeto.

---

## 1. Abstração — "o que importa, sem os detalhes"

**Conceito:** descrever só o essencial de algo e deixar os detalhes para depois.

```java
public abstract class AnimalZoo {
    protected String nome;
    protected String especie;

    public abstract void emitirSom();   // sem corpo!
    public abstract void comer();
    public abstract void dormir();
}
```

**Por que funciona assim:**

1. `abstract class` → **não dá para criar um "AnimalZoo" genérico**. `new AnimalZoo(...)` gera erro de compilação, e faz sentido: ninguém visita um "animal genérico".
2. Métodos `abstract` não têm `{ }`. A classe só diz: **"todo animal TEM que saber fazer isso"**, sem dizer como.

> **Analogia:** a empresa define que todo veículo da frota precisa ter placa, capacidade e um jeito de carregar, mas não diz *como* cada um carrega. Isso depende do veículo.

---

## 2. Herança — "é um tipo de"

**Conceito:** a classe filha recebe automaticamente atributos e métodos da classe pai.

```java
public class Tigre extends AnimalZoo {
    public Tigre(String nome){
        super(nome, "Tigre");   // chama o construtor do pai
    }
}
```

**Passo a passo de `new Tigre("Yuna")`:**

1. O Java entra no construtor de `Tigre`.
2. `super(nome, "Tigre")` repassa os dados para o construtor de `AnimalZoo`.
3. `AnimalZoo` preenche `this.nome = "Yuna"` e `this.especie = "Tigre"`.
4. O tigre agora tem `getNome()` e `getEspecie()` **sem ter escrito esses métodos**, porque os herdou.

```
            AnimalZoo  (abstrata)
          nome, especie, getNome()
     ┌────────┬───────┴───────┬────────┐
  Macaco    Tigre          Cobra     Arara
```

**Teste do "é um":**

- "Tigre **é um** AnimalZoo?" → sim, então a herança faz sentido.
- "Visitante **é um** AnimalZoo?" → não, por isso `Visitante` **não** herda de ninguém.

---

## 3. Polimorfismo — "mesma chamada, comportamentos diferentes"

**Conceito:** chamar o **mesmo método** em objetos diferentes e cada um responder do seu jeito.

```java
// Macaco
@Override
public void emitirSom(){ System.out.println(nome + "Uh uh Ah Ah"); }

// Tigre
@Override
public void emitirSom(){ System.out.println(nome + "Grrrr"); }
```

`@Override` indica: "estou **sobrescrevendo** o método que veio do pai".

**Onde o polimorfismo aparece:**

```java
private List<AnimalZoo> animais = new ArrayList<>();   // lista do tipo PAI

zoologico.adicionarAnimal(macaco);   // aceita Macaco
zoologico.adicionarAnimal(tigre);    // aceita Tigre
```

`adicionarAnimal(AnimalZoo animal)` aceita **qualquer** animal. Não é preciso um `adicionarMacaco()`, outro `adicionarTigre()` e assim por diante.

**Demonstração ideal:**

```java
for (AnimalZoo a : zoologico.getAnimais()) {
    a.emitirSom();   // UMA linha, 4 sons diferentes
}
```

Saída:

```
GeorgeUh uh Ah Ah
YunaGrrrr
KemilySssssss
Maicon aaaah aahhahhh
```

**Por que funciona:** a variável `a` é do tipo `AnimalZoo`, mas o objeto real é um `Tigre`, um `Macaco` etc. O Java decide **em tempo de execução** qual versão chamar, olhando o objeto real. Isso se chama *ligação dinâmica*.

> **Analogia:** o sistema de roteirização chama `calcularFrete()` para a lista de entregas. A entrega fracionada calcula por peso, a lotação por viagem e a refrigerada soma uma taxa. O sistema não precisa saber o tipo de cada uma.

> ⚠️ O `Main` atual chama `macaco.emitirSom()` e `tigre.emitirSom()` direto pelo tipo concreto. Funciona, mas não exibe o polimorfismo. O `for` acima é o que mostra o conceito de verdade.

---

## 4. Encapsulamento — "proteger o que está dentro"

**Conceito:** os atributos ficam escondidos (`private`), e quem está de fora só mexe neles pelos métodos que a classe permite.

```java
public class Zoologico {
    private String nome;                                // ninguém de fora acessa direto
    private List<AnimalZoo> animais = new ArrayList<>();

    public void adicionarAnimal(AnimalZoo animal){      // porta de entrada controlada
        animais.add(animal);
    }
    public String getNome() { return nome; }            // só leitura, sem setNome
}
```

**O que isso garante:**

- `zoologico.nome = "X"` → **erro**, o campo é `private`.
- Como não existe `setNome()`, o nome **não muda** depois de criado.

**Níveis de acesso no projeto:**

| Modificador | Quem enxerga | Onde está |
|---|---|---|
| `private` | só a própria classe | `Zoologico`, `Visitante` |
| `protected` | a classe e as filhas | `nome` e `especie` em `AnimalZoo` |
| `public` | todo mundo | métodos `get...`, `adicionar...` |

O `protected` é a ponte entre herança e encapsulamento: por causa dele, o `Tigre` consegue usar `nome` diretamente dentro de `emitirSom()`.

> ⚠️ **Ponto fraco:** `getAnimais()` devolve a lista original, então alguém de fora pode fazer `zoologico.getAnimais().clear()` e apagar tudo. Para proteger:
>
> ```java
> public List<AnimalZoo> getAnimais(){
>     return Collections.unmodifiableList(animais);   // só leitura
> }
> ```

> **Analogia:** o saldo do frete a pagar fica `private` no sistema. Ninguém altera o valor direto: tem que passar por `registrarPagamento()`, que valida e registra no log.

---

## 5. Bônus: Associação — como os objetos se relacionam

```
Zoologico ──tem vários──▶ AnimalZoo
Zoologico ──tem vários──▶ Visitante
Visitante ──visitou────▶ AnimalZoo
```

```java
// Visitante.java
private List<AnimalZoo> animaisVisitados = new ArrayList<>();
```

O visitante **não é** um animal (não há herança), mas **conhece** animais. Essa relação de "tem / conhece" é a associação.

---

## 📋 Resumo lado a lado

| Pilar | Pergunta que responde | Onde está no projeto |
|---|---|---|
| **Abstração** | O que todo animal precisa ter? | `abstract class AnimalZoo` + métodos `abstract` |
| **Herança** | Quem é um tipo de quem? | `Tigre extends AnimalZoo` + `super(...)` |
| **Polimorfismo** | Como tratar todos igual e cada um agir diferente? | `@Override` + `List<AnimalZoo>` |
| **Encapsulamento** | Quem pode mexer em quê? | `private`, `protected` e os getters |

Os quatro funcionam **juntos**: a abstração cria o molde, a herança o passa adiante, o polimorfismo deixa cada filho agir do seu jeito e o encapsulamento protege tudo.

