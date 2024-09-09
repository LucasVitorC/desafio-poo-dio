package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {
    private Bootcamp bootcamp;
    private String nome;
	private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
	private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
	
	public void inscreverBootcamp(Bootcamp bootcamp) {
        this.bootcamp = bootcamp;
		this.conteudosInscritos.addAll(bootcamp.getConteudos());
		bootcamp.getDevsInscritos().add(this);

        System.out.println("Bootcamp atribuído a " + this.nome + ": " + bootcamp.getNome());
	}
	
	private void emitirCertificado() {
        if (bootcamp != null) {
            System.err.println(bootcamp.getNome());
            System.out.println(Certificado.gerarCertificado(this, bootcamp));
        }else {
            System.err.println("Erro: Bootcamp não encontrado!");
        }
    }
	
	public void progredir() {
		Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
		if(conteudo.isPresent()) {
			this.conteudosConcluidos.add(conteudo.get());
			this.conteudosInscritos.remove(conteudo.get());
		}if(conteudosInscritos.isEmpty()) {
			emitirCertificado();
		}else {
			System.err.println("Você não está matriculado em nenhum conteúdo!");
		}
	}
	
	public double calcularTotalXp() {
		return this.conteudosConcluidos
		.stream()
		.mapToDouble(Conteudo::calcularXP)
		.sum();
	}
	
	public void deixarFeedback(Conteudo conteudo, Feedback feedback) {
        if (conteudosConcluidos.contains(conteudo)) {
            conteudo.adicionarFeedback(feedback);
            System.out.println("Feedback adicionado com sucesso!");
        } else {
            System.out.println("Você ainda não concluiu este conteúdo.");
        }
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Conteudo> getConteudosInscritos() {
		return conteudosInscritos;
	}

	public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
		this.conteudosInscritos = conteudosInscritos;
	}

	public Set<Conteudo> getConteudosConcluidos() {
		return conteudosConcluidos;
	}

	public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
		this.conteudosConcluidos = conteudosConcluidos;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass())return false;
		Dev dev = (Dev) o;
		return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);	
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nome, conteudosInscritos,conteudosConcluidos);
	}
}
