import java.util.Scanner;

public class Jogo {
	public static final int  MAPA = 10;
	public static int[]mapa;
	public static final int  COMBUSTIVEL_INICIAL = 7000;
	public static int tentativas = 0;
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args){
		Caminhao caminhao = new Caminhao();
		inicializaMapa();
		mostraRegras();
		int op = 0; 
		int casas = 0;
		while(!isJogoAcabou(caminhao,true)){
			tentativas++;
			while (op == 0){
				op = getOpcao();
			}
			switch(op){
				case 1:
					casas = getQuantidadeCasas();
					for(int i = 1; i <= casas; i++){
						caminhao.avanca();
						if(isJogoAcabou(caminhao,false)){
							break;
						}
					}
					break;
				case 2:
					casas = getQuantidadeCasas();
					for(int i = 1; i <= casas; i++){
						if(caminhao.getPosicaoAtual() == 0){
							break;
						}
						caminhao.volta();
						if(isJogoAcabou(caminhao,false)){
							break;
						}
					}
					break;
				case 3:
					carregarCaminhao(caminhao);
					break;
				case 4:
					descarregarCaminhao(caminhao);
					break;
				case 5:
					tentativas--;
					printStatus(caminhao);
					break;
			}
			op = 0;
		}
		
		
		printStatus(caminhao);
	}
	
	public static void mostraRegras(){
		System.out.println( "O Caminhao\n" +
							"     _________\n" +
							"  ___/=======/\n" +
							" /__/_______/ \n" +
							" 0  0    000\n" +
							"O Caminhao tem que percorrer todo o Mapa.\n" +
							"O tamanho do Mapa é de 10 posições.\n" +
							"A capacidade maxima do tanque do caminhão é de 6 litros.\n" +
							"Cada litro permite andar 1 posição.\n" +
							"Na posição 0 o caminhão sempre recarrega.\n" +
							"O caminhão pode descarregar combustivel em qualquer posição do mapa para carregar posteriormente.\n" +
							"Na posição 9 o jogo acaba.\n");
	}
	
	public static void printStatus(Caminhao caminhao){
		caminhao.printStatus();
		System.out.println("Mapa: Posição | Gasolina | Caminhão");
		
		for(int i = 0; i < MAPA; i++){
			System.out.print("        ["+i+"]");
			System.out.print("      ["+mapa[i]+"]");
			if(i == caminhao.getPosicaoAtual()){
				System.out.print("     Aqui!");
			}
			System.out.println("");
		}
		System.out.println("Movimentos: "+tentativas);
	}
	
	public static int getOpcao(){
		System.out.println("COMANDOS DO JOGO: AVANCAR (+)| RETROCEDER (-)| CARREGAR (+#)| DESCARREGAR (-#)| STATUS|");
		String op = scan.next().toUpperCase();
		
		if(op.equals("AVANCAR")){
			return 1;
		}else if(op.equals("RETROCEDER")){
			return 2;
		} else if(op.equals("CARREGAR")){
			return 3;
		}else if(op.equals("DESCARREGAR")){
			return 4;
		}else if(op.equals("STATUS")){		
			return 5;
		} else {
			System.out.println("Comando invalido.");
			return 0;
		}
	}
	
	public static void inicializaMapa(){
		mapa = new int[MAPA];
		mapa[0] = COMBUSTIVEL_INICIAL;
		
		for(int i = 1; i < MAPA; i++){
			mapa[i] = 0;
		}
	}
	
	public static void carregarCaminhao(Caminhao caminhao){
		System.out.println("Quantos litros?");
		int galoes = scan.nextInt();
		for(int i = 0; i <= galoes; i++){
			if(mapa[caminhao.getPosicaoAtual()] > 0 && caminhao.getCombustivel() <= 6){
				caminhao.setCombustivel(1);
				mapa[caminhao.getPosicaoAtual()] -= 1;
			} else {
				break;
			}
			
		}
	}
	
	public static void descarregarCaminhao(Caminhao caminhao){
		System.out.println("Quantos litros?");
		int galoes = scan.nextInt();
		
		for(int i = 1; i <= galoes; i++){
			if( caminhao.getCombustivel() == 0){
				break;
			}
			caminhao.setCombustivel(-1);
			mapa[caminhao.getPosicaoAtual()] += 1;
		}
	}
	
	
	
	public static int getQuantidadeCasas(){
		System.out.println("Quantas posicões do Mapa?");
		return scan.nextInt();
	}
	
	
	public static boolean isJogoAcabou(Caminhao caminhao,boolean mostraMensagem){
		 int posicaoCaminhao = caminhao.getPosicaoAtual();
		 int combustivel = caminhao.getCombustivel();
		 
		 if(posicaoCaminhao == (MAPA-1)){ 
			if(mostraMensagem){
				resultado(true); 
			}
			return true; 
		 } else if ((combustivel < 0) || (combustivel == 0 && mapa[posicaoCaminhao] == 0)){
			 if(mostraMensagem){
				 resultado(false); 
			 }
			 return true; 
		 } else {
			 return false;
		 }
	}
	
	public static void resultado(boolean ganhou){
		if(ganhou){
			System.out.println("Parabéns!!! você Venceu!!!!.");
		} else {
			System.out.println("Infelizmente você perdeu.Tente novamente.");
		}
	}

}
