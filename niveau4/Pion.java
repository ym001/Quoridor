/**
	Gère les attributs d'un pion.
	@author yves Mercadier
	@version 0.2
	@classe Pion
*/

public  class Pion{
	private int x;
	private int y;
	private int numero;
	Pion(int a,int b,int n){
		x=a;
		y=b;
		numero=n;
	}
	//Constructeur par défaut
	Pion(){}
	
	public int abscisse(){
		return x;
	}
	
	public int ordonnee(){
		return y;
	}
	
	public void affecteAbscisse(int a){
		x=a;
	}
	
	public void affecteOrdonnee(int o){
		y=o;
	}
	
	public void affecteNumero(int n){
		numero=n;
	}
	
	public int numero(){
		return numero;
	}
}
