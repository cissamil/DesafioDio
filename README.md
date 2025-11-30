# Projeto Zoológico 

Este é um projeto simples em Java, desenvolvido como um exercício prático para aplicar os conceitos fundamentais da Programação Orientada a Objetos (POO). A aplicação simula o funcionamento de um zoológico, com animais, visitantes e suas interações.
---
## 🐘 Conceitos

O projeto foi estruturado para demonstrar os pilares da POO:

*   **Herança:** A classe abstrata `AnimalZoo` (não fornecida, mas inferida) serve como base para as classes de animais específicos (`Macaco`, `Tigre`, `Cobra`, `Arara`), que herdam seus atributos e métodos comuns.
*   **Polimorfismo:** Cada animal implementa seus próprios comportamentos para métodos como `emitirSom()`, `comer()` e `dormir()`, permitindo que sejam tratados de forma genérica como `AnimalZoo`, mas executando ações específicas.
*   **Encapsulamento:** Os atributos das classes (`Zoologico`, `Visitante`, etc.) são mantidos como `private`, e o acesso a eles é controlado por meio de métodos públicos (`getters` e `setters`), protegendo o estado interno dos objetos.
*   **Abstração:** A classe `AnimalZoo` abstrai o conceito de um animal, definindo o que um animal do zoológico "é" e "faz", sem se preocupar com os detalhes de cada espécie.

---
## 📂 Estrutura

As principais classes do sistema são:

*   `Zoologico`: A classe central que gerencia as listas de animais presentes e os visitantes.
*   `AnimalZoo`: Classe base abstrata para todos os animais.
    *   `Macaco`, `Tigre`, `Cobra`, `Arara`: Classes concretas que representam cada animal, com seus comportamentos específicos.
*   `Visitante`: Representa uma pessoa que visita o zoológico e pode interagir com os animais.
*   `Main`: A classe executável que orquestra a simulação: cria o zoológico, adiciona os animais, recebe os visitantes e simula as interações.

