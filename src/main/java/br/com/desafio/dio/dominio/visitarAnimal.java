package DesafioDio.src.main.java.br.com.desafio.dio.dominio;

import java.util.ArrayList;
import java.util.List;

class visitarAnimal {

    private final List<AnimalZoo> animaisVisitados = new ArrayList<>();

    public void visitarAnimal(AnimalZoo animal) {
        animaisVisitados.add(animal);

        System.out.println("\n--- Visitando " + animal.getNome() + " ---");
        animal.emitirSom();
        animal.comer();
        animal.dormir();
    }
}


