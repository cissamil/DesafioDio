package DesafioDio;

import DesafioDio.src.main.java.br.com.desafio.dio.dominio.Arara;
import DesafioDio.src.main.java.br.com.desafio.dio.dominio.Cobra;
import DesafioDio.src.main.java.br.com.desafio.dio.dominio.Macaco;
import DesafioDio.src.main.java.br.com.desafio.dio.dominio.Tigre;
import DesafioDio.src.main.java.br.com.desafio.dio.dominio.Visitante;
import DesafioDio.src.main.java.br.com.desafio.dio.dominio.Zoologico;

public class Main {
    public static void main(String args[]){
    Zoologico zoologico = new Zoologico("Zoológico Yellow!");
    System.out.println("--------------------");

    System.out.println("Adicionandoooooo");
    Macaco macaco = new Macaco("George");
    Tigre tigre = new Tigre("Yuna");
    Cobra cobra = new Cobra("Kemily");
    Arara arara = new Arara("Maicon");


    zoologico.adicionarAnimal(macaco);
    zoologico.adicionarAnimal(tigre);
    zoologico.adicionarAnimal(cobra);
    zoologico.adicionarAnimal(arara);
    System.out.println("Lista de animais: " + zoologico.getAnimais());
    System.out.println("--------------------");


    System.out.println("Recebendo visitantes...");
    Visitante visitante1 = new Visitante("Clarissa");
    Visitante visitante2 = new Visitante("Camila");
    zoologico.adicionarVisitante(visitante1);
    zoologico.adicionarVisitante(visitante2);
    System.out.println("Visitantes presentes: " + zoologico.getVisitantes());
    System.out.println("--------------------");


    System.out.println("--- Interações dos Visitantes ---");
    System.out.println(visitante1.getNome() + "  está visitando o Macaco...");
    visitante1.visitarAnimal(macaco);
    macaco.emitirSom();
    macaco.comer();
    macaco.dormir();
    System.out.println("--------------------");

    System.out.println(visitante1.getNome() + "  agora está visitando o Tigre...");
    visitante1.visitarAnimal(tigre);
    tigre.emitirSom();
    tigre.comer();
    tigre.dormir();
    System.out.println("--------------------");

    // Ao final, mostramos um resumo dos animais que o visitante viu
    System.out.println("Animais visitados por " + visitante1.getNome() + ": " + visitante1.getAnimaisVisitados());
    System.out.println("====================");



    }

}
