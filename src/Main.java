import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;
import br.com.dio.desafio.dominio.Feedback;
import br.com.dio.desafio.dominio.Conteudo;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());

        /*System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);*/

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        devCamila.progredir();
        devCamila.progredir();
        devCamila.progredir();//Emite o Certificado
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Camila:" + devCamila.getConteudosConcluidos());
        System.out.println("XP:" + devCamila.calcularTotalXp());
        
        //Feedback
        devCamila.deixarFeedback(curso1, new Feedback(5, "Excelente curso de Java!"));
        devCamila.deixarFeedback(curso2, new Feedback(4, "Curso de JavaScript bem completo!"));
        devCamila.deixarFeedback(mentoria, new Feedback(5, "Mentoria de alto nível, tirou todas as minhas dúvidas."));
        exibirFeedbacks(curso1);
        exibirFeedbacks(curso2);
        exibirFeedbacks(mentoria);

        System.out.println("-------");

        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();//Emitir Certificado
        System.out.println("-");
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos João:" + devJoao.getConteudosConcluidos());
        System.out.println("XP:" + devJoao.calcularTotalXp());

        //Feedback negativo (não é opinião do aluno que comenta)
        devJoao.deixarFeedback(curso1, new Feedback(1, "Prefiro Python, não gosto de java"));
        devJoao.deixarFeedback(curso2, new Feedback(2, "Prefiro PHP como Backend."));
        devJoao.deixarFeedback(mentoria, new Feedback(5, "Mentoria de alto nível, superou minhas expectativas."));//seria um crime mesmo falsamente criticar a mentoria !!
        exibirFeedbacks(curso1);
        exibirFeedbacks(curso2);
        exibirFeedbacks(mentoria);
    }

    private static void exibirFeedbacks(Conteudo conteudo) {
        if (!conteudo.getFeedbacks().isEmpty()) {
                System.out.println("Feedbacks para o conteúdo " + conteudo.getTitulo() + ":");
                conteudo.getFeedbacks().forEach(feedback -> System.out.println(feedback.toString()));
            } else {
                System.out.println("Nenhum feedback disponível para este conteúdo.");
            }
    }

}
