package DesafioDio.src.main.java.br.com.desafio.dio.dominio;

public class Tigre extends AnimalZoo {
    public Tigre(String nome){
        super(nome, "Tigre");
    }

    @Override
    public void emitirSom(){
        System.out.println(nome + "Grrrr");
    }
    
    @Override
    public void comer(){
        System.out.println(nome + "Come carne");

    }

    @Override
    public void dormir(){
        System.out.println(nome +"Dorme cerca de 12 horas por dia!!!");
    }
}
