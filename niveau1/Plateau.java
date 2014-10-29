/**
	Le plateau est le lieu du combat entre les joueurs
	@author yves Mercadier
	@version 0.1
	@classe Plateau
*/

public  class Plateau{
	/**
	taille est un entier représentant la taille du plateau.
	*/
	private int taille;
	/**
	matrice est untableau à deux dimentions repésentant l'état du plateau.
	*/
	private int[][] matrice;

/**
	@Constructeur par défaut
*/
	Plateau(Joueur ja,Joueur jb,int t){
		taille=2*t+1;
		initialisation(taille);
		affecterPion(ja.pion());
		affecterPion(jb.pion());
		}
/**
    Initialise l'état du plateau.
    @param taille un entier représentant la taille du plateau.
*/
	void initialisation(int taille){
		int i, j;
		matrice=new int[taille+1][taille+1];
		for(i=0; i<taille; i++) {
			for(j=0; j<taille; j++) {
				if(i%2==1){matrice[i][j]=0;}
				else{matrice[i][j]=0;}
			
			}
		}
	}
/**
    retourne le type d'occupation d'une case.
    @param x un entier représentant l'abscisse de la case.
    @param y un entier représentant l'ordonnée de la case.
    @return Un entier représentant le type d'occupation de la case.
*/
	public int occupationCase(int x, int y){
	return matrice[x][y];
	}
/**
    retourne vrai si une case est occupé par un élément de mur.
    @param x un entier représentant l'abscisse de la case.
    @param y un entier représentant l'ordonnée de la case.
    @return Un booléen vrai si la case est occupé par un élément de mur.
*/
	public boolean testCaseMur(int x, int y){
		boolean test;
		if(matrice[x][y]==3){test=true;}
		else{test=false;}
	return test;
	}
/**
    retourne vrai si une case est occupé par un pion.
    @param x un entier représentant l'abscisse de la case.
    @param y un entier représentant l'ordonnée de la case.
    @return Un booléen vrai si la case est occupé par un élément de mur.
*/
	public boolean testCasePion(int x, int y){
		boolean test;
		if((matrice[x][y]==1)||(matrice[x][y]==2)){test=true;}
		else{test=false;}
	return test;
	}
/**
    expulse un pion occupant une case.
    @param p un pion.
*/
	public void libererCase(Pion p){
		matrice[p.abscisse()][p.ordonnee()]=0;
		}
		
/**
    Affecte un pion à une case.
    @param p un pion.
*/
	public void affecterPion(Pion p){
		if(p.numero()==1){
			matrice[p.abscisse()][p.ordonnee()]=1;
		}
		if(p.numero()==2){
			matrice[p.abscisse()][p.ordonnee()]=2;
			}
	}
/**
    Affecte un élément de mur à une case.
    @param p une chaine de caractère représentant la verticalité du mur.
    @param x un entier représentant l'abscisse du premier élément de mur.
    @param y un entier représentant l'ordonnée du premier élément de mur.

*/
	public void affecterMur(String p,int x,int y){
		if(p.equals("h")){
			int i;
			for(i=0;i<3;i++){
				matrice[x+1+i][y]=3;
			}
		}
		if(p.equals("v")){int i;
			for(i=0;i<3;i++){
				matrice[x][y+1+i]=3;
			}
			}
	}
	
/**
    Permet l'affichage de l'état du plateau
    @param j1 et j2 les deux joueurs de la partie.
    @return Une chaine de caractère.
*/
public String pourAffichage(Joueur j1,Joueur j2){
		String affichage="\n";
		int colonne, ligne;
		int nb1mur=j1.nbMur();
		int nb2mur=j2.nbMur();
		for(colonne=0; colonne<taille; colonne++) {
			affichage=affichage+"     ";
			for(ligne=0; ligne<taille; ligne++) {
				if((ligne==0)&&(colonne%2==1)){
					affichage=affichage+colonne;
					if(colonne<10){affichage=affichage+" ";}
				}
				if((ligne==0)&&(colonne%2==0)){
					affichage=affichage+"  ";
				}				
				if((occupationCase(ligne,colonne)==0)&&(colonne%2==0)&&(ligne%2==0))
					{if((ligne==0)||(ligne==taille-1)){affichage=affichage+".";}
					else{affichage=affichage+"+";}
					}
				if((occupationCase(ligne,colonne)==0)&&(colonne%2==0)&&(ligne%2==1)){
					affichage=affichage+"--";
					}
				if((occupationCase(ligne,colonne)==0)&&(colonne%2==1)&&(ligne%2==0)){affichage=affichage+"|";}
				if((occupationCase(ligne,colonne)==0)&&(colonne%2==1)&&(ligne%2==1)){affichage=affichage+"  ";}
				if(occupationCase(ligne,colonne)==1){affichage=affichage+"1 ";}
				if(occupationCase(ligne,colonne)==2){affichage=affichage+"2 ";}
				if(occupationCase(ligne,colonne)==3){affichage=affichage+"#";}
				if((occupationCase(ligne,colonne)==3)&&(ligne%2==1)){affichage=affichage+"#";}
				if((colonne == 0)&&(ligne==taille-1)){affichage=affichage+"     "+j1.nom()+" dispose de "+j1.nbMur()+" murs.";}
				if((colonne == 1)&&(ligne==taille-1)){affichage=affichage+"     "+j2.nom()+" dispose de "+j2.nbMur()+" murs.";}
			}
		affichage=affichage+"\n";
		}
		affichage=affichage+"        1  3  5  7  9  11 13 15 17\n";
		return affichage;	
	}

}
