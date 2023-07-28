package teste.turmas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Turma {

	private String codigoTurmaDep;
	private String codigoTurma;
	private String disciplina;
	private String departamentoVinc;
	private String curso;
	private String professor;
	private String tipo;
	private int nVagas;
	private String equipamento;
	private int qntEquip;

	public Turma(String codigoTurmaDep, String codigoTurma, String disciplina, String departamentoVinc, String curso, String professor, String tipo, int nVagas) {
		this.codigoTurmaDep = codigoTurmaDep;
		this.codigoTurma = codigoTurma;
		this.disciplina = disciplina;
		this.departamentoVinc = departamentoVinc;
		this.curso = curso;
		this.professor = professor;
		this.tipo = tipo;
		this.nVagas = nVagas;
	}

	public Turma(String codigoTurmaDep, String codigoTurma, String disciplina, String departamentoVinc, String curso, String professor, String tipo, int nVagas, String equipamento, int qntEquip) {
		super();
		this.codigoTurmaDep = codigoTurmaDep;
		this.codigoTurma = codigoTurma;
		this.disciplina = disciplina;
		this.departamentoVinc = departamentoVinc;
		this.curso = curso;
		this.professor = professor;
		this.tipo = tipo;
		this.nVagas = nVagas;
		this.equipamento = equipamento;
		this.qntEquip = qntEquip;

	}

	public Turma() {
	}

	public String getCodigoTurmaDep() {
		return codigoTurmaDep;
	}

	public String getCodigoTurma() {
		return codigoTurma;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public String getDepartamentoVinc() {
		return departamentoVinc;
	}

	public String getCurso() {
		return curso;
	}

	public String getProfessor() {
		return professor;
	}

	public String getTipo() {
		return tipo;
	}

	public int getnVagas() {
		return nVagas;
	}

	public String getEquipamento() {
		return equipamento;
	}

	public int getQntEquip() {
		return qntEquip;
	}

	public static ArrayList<Turma> obterTurmas() {

		String path = ".\dados\turmas.csv";
		File file = new File(path);

		ArrayList<Turma> turmas = new ArrayList();

		try {
			Scanner leitor = new Scanner(file, "UTF-8");
			String perimeiraLinhaDoArquivo = leitor.nextLine();
			while (leitor.hasNextLine()) {
				String linhaDoArquivo = leitor.nextLine();
				String[] infoDeTurma = linhaDoArquivo.split("(,)|(,,)");

				if (infoDeTurma.length >= 8) {
					String codigoTurmaDep = infoDeTurma[0];
					String codigoTurma = infoDeTurma[1];
					String disciplina = infoDeTurma[2];
					String departamentoVinc = infoDeTurma[3];
					String curso = infoDeTurma[4];
					String professor = infoDeTurma[5];
					String tipo = infoDeTurma[6];
					int nVagas = Integer.parseInt(infoDeTurma[7]);

					Turma turma = new Turma(codigoTurmaDep, codigoTurma, disciplina, departamentoVinc, curso, professor,
							tipo, nVagas);
					turmas.add(turma);
				} else {
					String codigoTurmaDep = infoDeTurma[0];
					String codigoTurma = infoDeTurma[1];
					String disciplina = infoDeTurma[2];
					String departamentoVinc = infoDeTurma[3];
					String curso = infoDeTurma[4];
					String professor = infoDeTurma[5];
					String tipo = infoDeTurma[6];
					int nVagas = Integer.parseInt(infoDeTurma[7]);
					String equipamento = infoDeTurma[8];
					int qntEquip = Integer.parseInt(infoDeTurma[9]);
					Turma turma = new Turma(codigoTurmaDep, codigoTurma, disciplina, departamentoVinc, curso, professor,
							tipo, nVagas, equipamento, qntEquip);
					turmas.add(turma);
				}
			}

			System.out.println();
			System.out.println("Lista de Todas as Turmas"); for (Turma t : turmas) {System.out.println(t.getDescricaoTurma() ); }
			leitor.close();
		} catch (FileNotFoundException e) {
			System.out.println("Erro!");
			System.out.println(e);
		}
		return turmas;
	}


	
	public String getDescricaoTurma() {
		if (tipo.equals("teórica")) {
		return "Turma: " + codigoTurmaDep + " (" + departamentoVinc + ") - " + codigoTurma + " Turma (" + tipo + ") "
				+ "\n	Disciplina: " + disciplina 
				+ "\n	Professor: " + professor 
				+ "\n	Para: Curso de " + curso
				+ "\n	Oferece " + nVagas + " vagas "; 
		}else{	return "Turma: " + codigoTurmaDep + " (" + departamentoVinc + ") - " + codigoTurma + " Turma (" + tipo + ") "
				+ "\n	Disciplina: " + disciplina 
				+ "\n	Professor: " + professor 
				+ "\n	Para: Curso de " + curso
				+ "\n	Oferece " + nVagas + " vagas " 
				+ "\n	Necessita de : " + qntEquip + " " + equipamento;
		}
	}
}
