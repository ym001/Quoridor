/**
	@author yves Mercadier
	@version 0.2
	@classe Joueur
*/

public  class Joueur{
	/**
	nom est une chaine de caratère correspondant au nom du joueur.
	*/
	private String nom;
	/**
	nombreDeMur est un entier indiquant le nombre de mur possédé par l'arbitre.
	*/
	private int nombreDeMur;
	/**
	p est le piont du joueur.
	*/
	private Pion p;
/**
	@Constructeur
*/
	Joueur(Pion pion,String m,int nb){
		nom=m;
		nombreDeMur=nb;
		p=pion;
		}
/**
    Obtenir le pion d'un joueur.
    @return le pion du joueur.
*/
	public Pion pion(){
		return p;
		}
/**
    Obtenir le nombre de mur d'un joueur.
    @return nombreDeMur un entier représentant le nombre de mur du joueur.
*/
	public int nbMur(){
		return nombreDeMur;
		}
		
/**
    Diminue de un la quantité de mur disponnible du joueur.
*/
	public void utiliseUnMur(){
		nombreDeMur=nombreDeMur-1;
		}
/**
    Affecte un pion à un joueur.
    @param un pion pion.
    @return le pion du joueur.
*/
	public void affectePion(Pion pion){
		p=pion;
		}
/**
    Obtenir le nom d'un joueur.
    @return nom une chaine de caractère repésentant le nom du joueur.
*/
	public String nom(){return nom;}

}
