package DesafioDio.src.main.java.br.com.desafio.dio.dominio;

public abstract class AnimalZoo {
    protected String nome;
    protected String especie;

    public AnimalZoo(String nome, String especie){
        this.nome = nome;
        this.especie = especie;

    }
    //getter
    public String getNome(){
        return nome;
    }
    public String getEspecie(){
        return especie;
    }

    //metodos
    public abstract void emitirSom();
    public abstract void comer();
    public abstract void dormir();

}
