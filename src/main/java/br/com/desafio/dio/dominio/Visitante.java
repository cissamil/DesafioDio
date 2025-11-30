package DesafioDio.src.main.java.br.com.desafio.dio.dominio;
import java.util.ArrayList;
import java.util.List;

public class Visitante {

    private String nome;
    private List<AnimalZoo> animaisVisitados = new ArrayList<>();

    public Visitante(String nome){
        this.nome = nome;
    }

     public String getNome() {
        return nome;
   }

     public void visitarAnimal(AnimalZoo animal) {
        animaisVisitados.add(animal);
    }

    public List<AnimalZoo> getAnimaisVisitados() {
        return animaisVisitados;
    }

    @Override
    public String toString() {
        return "Visitante: " + nome + 
               " | Animais visitados: " + animaisVisitados.size();
    }


}
