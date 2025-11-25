import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Curso curso1 = new Curso("Curso Java",
                "Curso básico de Java",
                92);
        Curso curso2 = new Curso("Curso Ruby",
                "O básico sobre Ruby e a famosa framework Ruby on Rails",
                80);

        Mentoria mentoria1 = new Mentoria("Mentoria Java",
                "Mentoria para tirar dúvidas sobre o curso de Java",
                LocalDate.now());

        Bootcamp bootcamp = new Bootcamp("Bootcamp Java",
                "Intensivão de aprendizagem Java e frameworks!!");

        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria1);

        Dev devJoao = new Dev("João");
        Dev devMaria = new Dev("Maria");

        devJoao.inscreverBootcamp(bootcamp);
        devMaria.inscreverBootcamp(bootcamp);

        devJoao.progredir();

        System.out.println("--- DEVS ---");
        System.out.println("João: ");
        System.out.println("XP atual: " + devJoao.calcularTotalXP());
        System.out.println("Conteúdos inscritos: " + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos: " + devJoao.getConteudosConcluidos());
        System.out.println("Maria: ");
        System.out.println("XP atual: " + devMaria.calcularTotalXP());
        System.out.println("Conteúdos inscritos: " + devMaria.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos: " + devMaria.getConteudosConcluidos());
    }
}
