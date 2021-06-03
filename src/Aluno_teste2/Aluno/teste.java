package Aluno_teste2.Aluno;

import Aluno_modelo2.Aluno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class teste {

    private Aluno eduardo;

    @BeforeEach
    private void instanciar() {
        eduardo = new Aluno();
    }

    @Test
    public void nomeAlunoVazio() {
        assertThrows(RuntimeException.class, () -> eduardo.setNome(""));
    }

    public void nomeAlunoMaisCemCaracteres() {
        String entrada = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut quis congue erat. Nam bibendum lacus eu ex mattis ultrices. Suspendisse"
                + " bibendum convallis libero, id mattis mi vehicula quis. Morbi quis lacinia felis. Aliquam magna augue, egestas vel leo sed, laoreet convallis nibh."
                + " Cras vel orci interdum, rutrum mauris a, imperdiet erat. Sed augue odio, viverra quis quam quis, placerat convallis neque. Curabitur et sapien "
                + "in lectus scelerisque posuere rhoncus vitae sapien. In sed enim quis ipsum molestie convallis. Interdum et malesuada fames ac ante ipsum primis in faucibus."
                + "Suspendisse bibendum egestas leo.";
        assertThrows(RuntimeException.class, () -> eduardo.setNome(entrada));
    }

    @Test
    public void notaMenorZero() {
        assertThrows(RuntimeException.class, () -> eduardo.entradaDeNota(-1.0));
    }

    @Test
    public void notaMaiorTrinta() {
        assertThrows(RuntimeException.class, () -> eduardo.entradaDeNota(40.0));
    }

    @Test
    public void alunoSemNota() {
        assertEquals(0.0, eduardo.retornaNotaTotal());
    }

    @Test
    public void notaTotalIqualCem() {
        for (int i = 0; i < 4; i++)
            eduardo.entradaDeNota(25.0);
        assertThrows(RuntimeException.class, () -> eduardo.entradaDeNota(10.0));
    }

    @Test
    public void notaTotalMaiorCem() {
        for (int i = 0; i < 4; i++)
            eduardo.entradaDeNota(20.0);
        assertThrows(RuntimeException.class, () -> eduardo.entradaDeNota(25.0));
    }
}

