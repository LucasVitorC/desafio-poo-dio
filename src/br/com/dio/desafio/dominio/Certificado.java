package br.com.dio.desafio.dominio;
import java.time.LocalDate;

public class Certificado {
    public static String gerarCertificado(Dev dev, Bootcamp bootcamp) {
        StringBuilder sb = new StringBuilder();
        sb.append("----- CERTIFICADO DE CONCLUSÃO -----\n");
        sb.append("Desenvolvedor: ").append(dev.getNome()).append("\n");
        sb.append("Bootcamp: ").append(bootcamp.getNome()).append("\n");
        sb.append("Total de Conteúdos Concluídos: ").append(dev.getConteudosConcluidos().size()).append("\n");
        sb.append("XP Total: ").append(dev.calcularTotalXp()).append("\n");
        sb.append("Data de Conclusão: ").append(LocalDate.now()).append("\n");
        sb.append("-------------------------------------\n");

        return sb.toString();
    }
}
