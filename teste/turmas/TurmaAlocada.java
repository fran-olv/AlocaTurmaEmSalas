package teste.turmas;

import java.util.ArrayList;

import teste.salas.Sala;

public class TurmaAlocada {
	Turma turma;
	Sala sala;

	public TurmaAlocada() {
	}

	public TurmaAlocada(Turma turma, Sala sala) {
		this.turma = turma;
		this.sala = sala;
	}
	
	
	public static ArrayList<TurmaAlocada> alocaTurmas(ArrayList<Sala> salas, ArrayList<Turma> turmas) {
		 
		ArrayList<TurmaAlocada> turmasAlocadas = new ArrayList<TurmaAlocada>();

		for (int j = 0; j < turmas.size(); j++) {

			for (int i = 0; i < salas.size(); i++) {
				salas.get(i).getDescricaoSala();
				if (turmas.get(j).getEquipamento() == salas.get(i).getEquipamento()
						&& (turmas.get(j).getnVagas() <= salas.get(i).getCapacidadeSala())
						&& (turmas.get(j).getQntEquip() == salas.get(i).getQntEquip())) {
									
					Turma turmaAloc = turmas.get(j);
					Sala salaPreenc = salas.get(i);
					
					TurmaAlocada turmaAlocObg = new TurmaAlocada(turmaAloc, salaPreenc);
					turmasAlocadas.add(turmaAlocObg);
				
					salas.remove(salas.get(i));
					
					break;
				}				
			}
		}
		System.out.println("Quantidade de turmas alocadas: " + turmasAlocadas.size());
		System.out.println("Num total de: " + turmas.size());
		System.out.println("  ");
		System.out.println("Turmas Alocadas: ");
		for (int w = 0; w < turmasAlocadas.size(); w++) {turmasAlocadas.get(w).DescreveAlocamentos();}
		

		
		return turmasAlocadas;
	}
	
	
	

	public void DescreveAlocamentos() {
		System.out.println();
		System.out.println(turma.getDescricaoTurma());
		System.out.println("--- Alocada na Sala: --- ");
		System.out.println(sala.getDescricaoSala());
		System.out.println();
	}

}
