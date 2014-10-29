import java.util.*;
/**
	Quoridor est un jeu de plateau.
	@author yves Mercadier
	@version 0.2
	@classe Quoridor
*/

public class Quoridor{
	static Scanner scan = new Scanner(System.in);
	Quoridor(){
	System.out.println("Bonjour voulez-vous faire une partie de coridor (o)ui (n)on ?");
	String str = scan.nextLine();
	if((str.equals("oui"))||(str.equals("o"))||(str.equals(""))){Arbitre a=new Arbitre();}
	System.out.println("Salut.");

	}

    public static void main (String[] args)
    {
	Quoridor q=new Quoridor();
    }
}
