package DesafioDio.src.main.java.br.com.desafio.dio.dominio;

public class Arara extends AnimalZoo {
    public Arara(String nome){
    super(nome, "Arara");
}


    @Override
    public void emitirSom(){
        System.out.println(nome + "aaaah aahhahhh");
    }


    @Override
        public void comer(){
            System.out.println(nome + "Comendo frutinhas");
        }

    @Override
    public void dormir(){
        System.out.println(nome + "Dorme cerca de 8 horas por dia!!");
    }



}
