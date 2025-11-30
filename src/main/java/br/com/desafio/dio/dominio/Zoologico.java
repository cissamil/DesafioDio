package DesafioDio.src.main.java.br.com.desafio.dio.dominio;
import java.util.ArrayList;
import java.util.List;

public class Zoologico {
  private String nome;
  private List <AnimalZoo> animais = new ArrayList<>();
  private List <Visitante> visitantes = new ArrayList<>();
  
  public Zoologico(String nome){
    this.nome = nome;
  }
   public String getNome() {
        return nome;
   }

  public void adicionarAnimal(AnimalZoo animal){
    animais.add(animal);
  }

  public void adicionarVisitante( Visitante visitante){
    visitantes.add(visitante);
  }

  public List<AnimalZoo> getAnimais(){
    return animais;
}

  public List <Visitante> getVisitantes(){
    return visitantes;

  }

   @Override
    public String toString() {
        return "Zoológico: " + nome + 
               " | Animais: " + animais.size() +
               " | Visitantes: " + visitantes.size();
    }


}
