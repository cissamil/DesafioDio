package DesafioDio.src.main.java.br.com.desafio.dio.dominio;
//abstract nao pode ser instanciada e encapsulamento 
public abstract class Conteudo {
    //protected so as filhas de Conteudo tem acesso total, Static compartilha para todo mundo, final const;
    protected static final double XP_PADRAO = 10d;
    
    private String titulo;
    private String descricao;

    public abstract double calcularXp();

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
