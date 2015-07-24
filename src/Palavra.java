
public class Palavra {
	private String letrasPalavra;
	private int chances;
	private String letrasEscolhidas;
	private String letrasCorretas;
	
	Palavra(String l){
		setLetrasPalavra(l);
		setChances(1);
		setLetrasEscolhidas(""); 
		setLetrasCorretas(l);
	}
	
	public String getLetrasPalavra() {
		return letrasPalavra;
	}
	public void setLetrasPalavra(String letras) {
		this.letrasPalavra = letras.toUpperCase();
	}
	public int getChances() {
		return chances;
	}
	public void setChances(int chances) {
		this.chances = chances;
	}
	public String getLetrasEscolhidas() {
		return letrasEscolhidas;
	}
	public void setLetrasEscolhidas(String letrasEscolhidas) {
		this.letrasEscolhidas = letrasEscolhidas.toUpperCase();
	}

	public String getLetrasCorretas() {
		return letrasCorretas;
	}

	public void setLetrasCorretas(String letrasCorretas) {
		int i;
		this.letrasCorretas = "";
		for(i=0;i<letrasCorretas.length();i++){
			this.letrasCorretas = this.letrasCorretas + "_";
		}
	}
	
	public int verificaExisteLetra(char letraDigitada){
		int i;
		letraDigitada = Character.toUpperCase(letraDigitada);
		if (letrasEscolhidas.indexOf(letraDigitada) != -1){
			return -2;
		}
		letrasEscolhidas = letrasEscolhidas + letraDigitada;
		if (letrasPalavra.indexOf(letraDigitada) != -1){
			for(i=0;i<letrasPalavra.length();i++){
				if(letrasPalavra.charAt(i) == letraDigitada){
					if(i==0){
						letrasCorretas = letraDigitada + letrasCorretas.substring(i+1, letrasCorretas.length());
					}
					else if(i==letrasCorretas.length()){
						letrasCorretas = letrasCorretas.substring(0, i) + letraDigitada;
					}
					else{
						letrasCorretas = letrasCorretas.substring(0, i) + letraDigitada + letrasCorretas.substring(i+1, letrasCorretas.length());
					}
				}
			}
			if(letrasCorretas.indexOf("_")==-1){
				return 1;
			}
			else{
				return 0;
			}
		}
		else{
			chances = chances+1;
			return -1;
		
		} 
	}


	
}
