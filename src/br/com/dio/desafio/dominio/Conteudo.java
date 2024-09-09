package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public abstract class Conteudo {

    protected static final double XP_PADRAO = 10d;
	
	private String titulo;
	private String descricao;
	private LocalDate dataInicial;
	private List<Feedback> feedbacks = new ArrayList<>();
	
	public abstract double calcularXP();
	
	public String getTitulo() {
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
	
	public boolean estaExpirado() {
		return LocalDate.now().isAfter(dataInicial.plusDays(45));
	}
	
	public void adicionarFeedback(Feedback feedback) {
        feedbacks.add(feedback);
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }
	
    @Override
    public String toString() {
        return "\n |Conteudo|" +
                "\n titulo = " + titulo + 
                "\n descricao = " + descricao;
    }
}
