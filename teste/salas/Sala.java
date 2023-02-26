package teste.salas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sala {
	private String unidade;
	private String campus;
	private String predio;
	private String bloco;
	private int andar;
	private int nSala;
	private int capacidadeSala;
	private String equipamento;
	private int qntEquip;
	private boolean IsLab;

	Sala(String unidade, String campus, String predio, String bloco, int andar, int nSala, int capacidadeSala) {

		this.unidade = unidade;
		this.campus = campus;
		this.predio = predio;
		this.bloco = bloco;
		this.andar = andar;
		this.nSala = nSala;
		this.capacidadeSala = capacidadeSala;
		this.IsLab = false;

	}

	Sala(String unidade, String campus, String predio, String bloco, int andar, int nSala, int capacidadeSala,
			String equipamento, int equipamentoQtd) {
		this.unidade = unidade;
		this.campus = campus;
		this.predio = predio;
		this.bloco = bloco;
		this.andar = andar;
		this.nSala = nSala;
		this.capacidadeSala = capacidadeSala;
		this.equipamento = equipamento;
		this.qntEquip = equipamentoQtd;
		this.IsLab = (this.equipamento == null) && (this.qntEquip == 0);
	}

	public String getEquipamento() {
		return equipamento;
	}



	public Sala() {
		
	}

	public int getnSala() {
		return nSala;
	}

	public int getCapacidadeSala() {
		return capacidadeSala;
	}

	public String getUnidade() {
		return unidade;
	}


	public int getQntEquip() {
		return qntEquip;
	}


	public boolean isIsLab() {
		return IsLab;
	}


	

	public static <T> ArrayList<Sala> obterSalas() {

		String path = "C:\\Users\\FrancieleBatistaDeOl\\eclipse-workspace\\AlocaTurmaEmSala\\src\\dados\\salas.csv";
		File file = new File(path);

		ArrayList<Sala> salas = new ArrayList<Sala>();

		try {
			Scanner leitor = new Scanner(file, "UTF-8");

			String Linha1DoArq = leitor.nextLine();

			while (leitor.hasNextLine()) {

				String linhaDoArquivo = leitor.nextLine();
				// System.out.println(linhaDoArquivo);

				String[] infoDeSala = linhaDoArquivo.split("(,)");
				// System.out.print(infoDeSala.length);
				if (infoDeSala.length <= 7) {

					String unidade = infoDeSala[0];
					String campus = infoDeSala[1];
					String predio = infoDeSala[2];
					String bloco = infoDeSala[3];
					int andar = Integer.parseInt(infoDeSala[4]);
					int nSala = Integer.parseInt(infoDeSala[5]);
					int capacidadeSala = Integer.parseInt(infoDeSala[6]);

					Sala sala = new Sala(unidade, campus, predio, bloco, andar, nSala, capacidadeSala);
					salas.add(sala);

				} else {
					String unidade = infoDeSala[0];
					String campus = infoDeSala[1];
					String predio = infoDeSala[2];
					String bloco = infoDeSala[3];
					int andar = Integer.parseInt(infoDeSala[4]);
					int nSala = Integer.parseInt(infoDeSala[5]);
					int capacidadeSala = Integer.parseInt(infoDeSala[6]);
					String equipamento = infoDeSala[7];
					int qntEquip = Integer.parseInt(infoDeSala[8]);

					Sala sala = new Sala(unidade, campus, predio, bloco, andar, nSala, capacidadeSala, equipamento,
							qntEquip);
					salas.add(sala);

				}
				for (Sala s : salas) { System.out.println(s.getDescricaoSala() );}
			}
			leitor.close();

		} catch (FileNotFoundException e) {
			System.out.println("Erro!");
			System.out.println(e);
		}
		return salas;
	}
	
	public String getDescricaoSala() {
		return "	Numero: " + nSala + " - Andar:" + andar + " - Bloco: " + bloco 
				+ "\n	Prédio: " + predio
				+ " - Localizada em " + unidade + "-  Campus= " + campus 
				+ "\n	Capacidade da Sala: " + capacidadeSala
				+ "\n	Equipamento:" + qntEquip + "  " + equipamento;
	}
}
