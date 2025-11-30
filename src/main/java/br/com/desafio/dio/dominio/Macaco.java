package DesafioDio.src.main.java.br.com.desafio.dio.dominio;

public class Macaco extends AnimalZoo{
    public Macaco(String nome){
        super(nome, "Macaco");
    }

    @Override
    public void emitirSom(){
        System.out.println(nome + "Uh uh Ah Ah");
    }


    @Override
        public void comer(){
            System.out.println(nome + "Comendo bananas");
        }

    @Override
    public void dormir(){
        System.out.println(nome + "Dorme cerca de 10 horas por dia!!");
    }

}
