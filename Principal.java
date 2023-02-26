import java.util.ArrayList;

import teste.salas.Sala;
import teste.turmas.Turma;
import teste.turmas.TurmaAlocada;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Sala> salas = new ArrayList<Sala>();
		salas = Sala.obterSalas();

		ArrayList<Turma> turmas = new ArrayList<Turma>();
		turmas = Turma.obterTurmas();

		ArrayList<TurmaAlocada> TurmasAlocadas = new ArrayList<TurmaAlocada>();
		TurmasAlocadas = TurmaAlocada.alocaTurmas(salas, turmas);
	}

	
}
