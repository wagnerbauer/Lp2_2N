public class Caminhao {
	public static final int MAXIMO_COMBUSTIVEL = 6;
	private int combustivel;
	private int posicaoAtual;
	
	public Caminhao(){
		this.combustivel = MAXIMO_COMBUSTIVEL;
		this.posicaoAtual = 0;
	}
	
	public void avanca(){
		this.setCombustivel(-1);
		this.setPosicaoAtual(1);
	}
	
	public void volta(){
		this.setCombustivel(-1);
		this.setPosicaoAtual(-1);
	}
	
	public int getCombustivel() {
		return this.combustivel;
	}
	public void setCombustivel(int combustivel) {
		this.combustivel += combustivel;
	}
	
	public int getPosicaoAtual() {
		return this.posicaoAtual;
	}
	
	private void setPosicaoAtual(int posicaoAtual) {
		this.posicaoAtual += posicaoAtual;
		if(this.posicaoAtual == 0){
			Jogo.mapa[0] -=  Caminhao.MAXIMO_COMBUSTIVEL - this.combustivel;
			this.combustivel = Caminhao.MAXIMO_COMBUSTIVEL; 
		}
	}
	
	public void printStatus(){
		System.out.println("Combustível atual do caminhão: "+this.getCombustivel());
		System.out.println("Posição atual do caminhão: "+this.getPosicaoAtual());
	}
}
