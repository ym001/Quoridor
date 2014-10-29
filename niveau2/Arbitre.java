/**
	L'arbitre est le grand chef d'orchestre du jeu. Il décide et nous le suivons.
	@author yves Mercadier
	@version 0.2
	@classe Arbitre
*/

import java.util.*;
public  class Arbitre{
	static Scanner scan = new Scanner(System.in);
	/**
	message est une chaine de caratère correspondant au discours de l'arbitre.
	*/
	private String message;
	/**
	jeu est un booléen vrai si le jeu est en activité faux si non.
	*/
	private boolean jeu=true;
	/**
	// est un booléen vrai si un joueur x doit jouer faux si c'est à l'autre joueur de jouer.
	*/
	private boolean tour;
	
	/**
	 * j1 et j2 sont les deux joueur de la partie.
	 */
	Joueur j1;
	Joueur j2;
	
/**
	@Constructeur par défaut
*/
	Arbitre(){
		message="";
		message="Quel est votre nom ?";
		afficherMessage();
		String str1 = scan.nextLine();
		message="Avec qui jouez-vous ?";
		afficherMessage();
		String str2 = scan.nextLine();
		Pion p1=new Pion();
		Pion p2=new Pion();
		Joueur j1=new Joueur(p1,str1,10);;
		Joueur j2=new Joueur(p2,str2,10);;
		tour=demarrerPartie(j1,j2);
		Plateau plateau=new Plateau(j1,j2,9);
		while(jeu){
			if(tour){
				jeu=action(j1,j2,plateau);
			}
			else{
				jeu=action(j2,j1,plateau);
			}
			afficherMessage();
			}
		}
/**
    Obtenir l'action décidé par l'arbiter.
    @param ja Le premier joueur.
    @param jb Le deuxième joueur.
    @param plateau le plateau. 
    @return Un booléen jeu vrai si le jeu est en activité faux si non.
*/
	boolean action(Joueur ja,Joueur jb,Plateau plateau){
		String str = scan.nextLine();
		String[] action = str.split(" ");
			
			if(action[0].equals("i")){
					message="Début d'une nouvelle partie.";
					tour=demarrerPartie(ja,jb);
					}
				
			if(action[0].equals("v")){
					dessinerPlateau(plateau,ja,jb);
					}
					
			if(action[0].equals("r")){
					regleDuJeu();
					}
					
			if(coupValide(str,ja,plateau)){
						if(tour){tour=false;}
						else{tour=true;}
						if(jeu){message=message+"C'est à "+jb.nom()+" de jouer.";}
						if(action[0].equals("m")){
							plateau.affecterMur(action[1],Integer.parseInt(action[2]),Integer.parseInt(action[3]));
							ja.utiliseUnMur();
							}
						if(action[0].equals("p")){
							plateau.libererCase(ja.pion());
							ja.pion().affecteAbscisse(Integer.parseInt(action[1]));ja.pion().affecteOrdonnee(Integer.parseInt(action[2]));
							plateau.affecterPion(ja.pion());
							}
					}
					
			else{if((action[0].equals("v"))||(action[0].equals("r"))){message=message+"C'est à "+ja.nom()+" de jouer.";}
				else{message=message+"Coup illégal.\nC'est à "+ja.nom()+" de jouer.";}
			}
			
			if(action[0].equals("a")){
					quitterLeJeu();
					}
		return jeu;
		}
		
/**
    Vérifier la validité d'un coup demandé par un joueur.
    @param str une chaine de caractère repésentant la volonté du joueur.
    @param ja le joueur.
    @param jb l'autre joueur.
    @param p le plateau. 
    @return Un booléen valider vrai si l'action demandé est un coup valide et faux sinon.
*/
	boolean coupValide(String str,Joueur ja,Plateau p){
		boolean valider=true;
		String[] action = str.split(" ");
		if(action[0].equals("m")){
			if(action.length==4){
				try{
					int x=Integer.parseInt(action[2]);
					int y=Integer.parseInt(action[3]);
						if((x<0)||(x>18)||(y<0)||(y>18)){valider=false;message="\nLe mur doit être à l'intérieur du plateau.\n";}
						else if((x%2==1)||(y%2==1)){valider=false;message="\nLes coordonnées du mur doivent être paires.\n";}
						else{if(action[1].equals("v")){
								if(p.testCaseMur(x,y+2)){valider=false;message="\nLe mur ne doit pas chevaucher un autre mur.\n";}
								else{valider=true;}
							}
							if(action[1].equals("h")){
								if(p.testCaseMur(x+2,y)){valider=false;message="\nLe mur ne doit pas chevaucher un autre mur.\n";}
								else{valider=true;}
							}
						}
				}catch(NumberFormatException e){
				message="\nLes coordonnées du mur ne sont pas valides.\n";valider=false;}
				}
			else{valider=false;message="\nDemande de coup sur un mur mal formulée.\n";}
			if(ja.nbMur()==0){valider=false;message="\nVous n'avez plus de mur.\n";}
		}

		if(action[0].equals("p")){
			if(action.length==3){
				try{
					int x=Integer.parseInt(action[1]);
					int y=Integer.parseInt(action[2]);
					int deplacementX=x-ja.pion().abscisse();
					int deplacementY=y-ja.pion().ordonnee();
					if((x<1)||(y<1)||(x>17)||(y>17)){valider=false;message="\nLe pion doit rester à l'intérieur du plateau.\n";}
					else if((x%2==0)||(y%2==0)){valider=false;message="\nLes coordonnées du pion doivent être impaires.\n";}
					else if((Math.abs(deplacementX)>2)||(Math.abs(deplacementY)>2)){valider=false;message="\nUn pion ne peut se déplacer que d'une case sans sauter.\n";}
					else if(p.testCaseMur(ja.pion().abscisse()+deplacementX/2,ja.pion().ordonnee()+deplacementY/2)){valider=false;message="\nUn pion ne peut pas se déplacer à travers un mur.\n";}
					else if(p.testCasePion(x,y)){valider=false;message="\nLa case est occupée par un pion.\n";}
					
					else{valider=true;
						if(((y==1)&&(p.occupationCase(ja.pion().abscisse(),ja.pion().ordonnee())==2))||((y==17)&&(p.occupationCase(ja.pion().abscisse(),ja.pion().ordonnee())==1))){
							message="\nC'est gagné "+ja.nom()+".\n";
							jeu=false;
							}
						}
					}
				catch(NumberFormatException e){message="\nLes coordonnées du pion ne sont pas valides.\n";valider=false;}
				}
			else{valider=false;message="\nDemande de coup sur un pion mal formulée.\n";}
		}

		if(action[0].equals("v")){valider=false;}
		if(action[0].equals("r")){valider=false;}
		return valider;
		}

/**
	Initialiser une partie
	@param j1 un joueur.
	@param j2 un deuxième joueur. 
	@return Un booléen tour vrai si c'est à j1 de commencer la partie et faux sinon.

*/

	boolean demarrerPartie(Joueur j1,Joueur j2){
		int tirage=tirage();
		boolean cestAQui;
		Pion p1=new Pion(9,1,1);
		Pion p2=new Pion(9,17,2);
		if(tirage==0){
			message=message+j1.nom()+" joue avec le pion 1.\n";
			message=message+j2.nom()+" joue avec le pion 2.\n";
			j1.affectePion(p1);
			j2.affectePion(p2);
			}
		if(tirage==1){
			j1.affectePion(p2);
			j2.affectePion(p1);
			message=message+j1.nom()+" joue avec le pion 2.\n";
			message=message+j2.nom()+" joue avec le pion 1.\n";
			}
		if(tirage==0){cestAQui=true;}else{cestAQui=false;}
		if(cestAQui){message=message+"C'est à "+j1.nom()+" de jouer.";}
		else{message=message+"C'est à "+j2.nom()+" de jouer.";}
		afficherMessage();
		return cestAQui;
		}

/** 
    @return Une valeur booléenne aléatoire.
*/

	int tirage(){
		Random r = new Random();
		int valeur =  r.nextInt(2);
		return valeur;
		}

/**
    Met la variable jeu à la valeur False et vide les méssages de l'arbitre.
*/

	void quitterLeJeu(){jeu=false;message="";}

/**
    Indique les règles du jeu.
*/
	void regleDuJeu(){
		message="\nPrésentation\n\nLe plateau du jeu est de 9×9 cases, séparées les unes des autres par des interstices permettant la pose de barrières les séparant les unes des autres 2 zones de stockage 20 barrières et 4 pions\n";
		message=message+"\nBut du jeu\n\nAtteindre le premier la ligne opposée à sa ligne de départ.\n";
		message=message+"\nDébut de partie\n\nEn début de partie, les barrières sont remisées dans leur zone de stockage (10 par joueur).Chaque joueur pose son pion au centre de sa ligne de départ.\n";
		message=message+"\nDéroulement d’une partie\n\nA tour de rôle, chaque joueur choisit de déplacer son pion ou de poser une de ses barrières. Lorsqu’il n’a plus de barrières, un joueur est obligé de déplacer son pion.\n";
		message=message+"\nDéplacement des pions\n\nLes pions se déplacent d’une case, horizontalement ou verticalement, en avant ou en arrière ; les barrières doivent être contournées.\n";
		message=message+"\nAction\n\nPour déplacer un pion écrire la lettre p suivi d'un espace puis l'abscisse suivi d'un espace puis l'ordonnée de la case d'arrivé.\n";
		message=message+"\nPour placer un mur écrire la lettre m suivi d'un espace puis la position du mur v pour vertical ou h pour horizontal suivi d'un espace puis l'abscisse suivi d'un espace puis l'ordonnée de u point de départ du mur.\n";
		message=message+"\nPour visualiser le plateau utiliser la lettre v.\n";
		message=message+"\nPour sortir du jeu utiliser la lettre a.\n";
		message=message+"\nPour réinitialiser une partie du jeu utiliser la lettre i.\n";
		message=message+"\nPour lire les règles du jeu utiliser la lettre r, mais vous le savez déjà.\n\n";
	}
	
/**
	Affiche le plateau du jeu
	@param p le plateau du jeu. 
 */
 
	void dessinerPlateau(Plateau p,Joueur j1,Joueur j2){
			System.out.println(p.pourAffichage(j1,j2));
	}
	
/**
	Affiche un méssage de l'arbitre
 */
	void afficherMessage(){
			System.out.println(message);
			message="";
	}
}
