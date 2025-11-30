package DesafioDio.src.main.java.br.com.desafio.dio.dominio;

public class Cobra extends AnimalZoo {
    public Cobra(String nome){
        super(nome, "Cobra");
    }

    @Override
    public void emitirSom(){
        System.out.println(nome + "Sssssss");

    }

    @Override
    public void comer(){
        System.out.println(nome + "Come roedores");
    }

    @Override
    public void dormir(){
        System.out.println(nome + "Dorme cerca de 16 horas por dia");
    }
}
