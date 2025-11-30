package DesafioDio.src.main.java.br.com.desafio.dio;

import java.time.LocalDate;

import DesafioDio.src.main.java.br.com.desafio.dio.dominio.Bootcamp;
import DesafioDio.src.main.java.br.com.desafio.dio.dominio.Conteudo;
import DesafioDio.src.main.java.br.com.desafio.dio.dominio.Curso;
import DesafioDio.src.main.java.br.com.desafio.dio.dominio.Dev;
import DesafioDio.src.main.java.br.com.desafio.dio.dominio.Mentoria;

public class Main {
    public static void main(String args[]) {
        Curso curso1 = new Curso();
        curso1.setTitulo("Java");
        curso1.setDescricao("sobre linguagem orientada a objetos");
        curso1.setCargaHoraria(60);

        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("Mentoria de java");
        mentoria1.setDescricao("ajudar os alunos com a aprendizagem");
        mentoria1.setData(LocalDate.now());

        System.out.println(curso1);
        System.out.println(mentoria1);

        //polimorfismo
        Conteudo conteudo = new Curso();

        //interligando as classes
        
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Aprenda java");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(mentoria1);

        Dev devClarissa = new Dev();
        devClarissa.setNome("Clarissa");
        devClarissa.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos inscritos: " + devClarissa.getConteudoInscritos());
        devClarissa.progredir();
        System.out.println("Conteudos concluido: " + devClarissa.getConteudoConcluidos());
        System.out.println("XP:" + devClarissa.calcularTotalXp());

        System.out.println("--------------------");

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos inscritos: " + devCamila.getConteudoInscritos());
        devCamila.progredir();
        System.out.println("Conteudos concluido: " + devCamila.getConteudoConcluidos());
        System.out.println("XP:" + devCamila.calcularTotalXp());
    }
}
