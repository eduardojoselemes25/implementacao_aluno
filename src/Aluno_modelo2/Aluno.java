package Aluno_modelo2;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

    private String nome;
    private List<Double> notas = new ArrayList<>();

    public Aluno() {
        super();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() == 0 || nome.length() > 100)
            throw new RuntimeException("Nome Invalido!");
        this.nome = nome;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void entradaDeNota(Double nota) {
        if (nota < 0.0 || nota > 30.0)
            throw new RuntimeException("Nota invalida!!");
        if (retornaNotaTotal() == 100)
            throw new RuntimeException("O valor Maximo de nota permitido jï¿½ foi atingido (100) Pontos!");
        if ((retornaNotaTotal() + nota) > 100.0)
            throw new RuntimeException("O valor total da nota nï¿½o pode ultrapassar os 100 Pontos!");
        notas.add(nota);
    }

    public Double retornaNotaTotal() {
        return notas.stream().reduce(0.0, Double::sum);
    }
}

