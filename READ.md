Description du jeu
QUORIDOR
® & © 1997 Gigamic from a concept of Mirko Marchesi

Présentation

un plateau de jeu de 9×9 cases, séparées les unes des autres par des interstices permettant la pose de barrières les séparant les unes des autres
2 zones de stockage
20 barrières et 4 pions

But du jeu
Atteindre le premier la ligne opposée à sa ligne de départ. 

Début de partie

En début de partie, les barrières sont remisées dans leur zone de stockage (10 par joueur).
Chaque joueur pose son pion au centre de sa ligne de départ.
Un tirage au sort détermine qui commence.

Déroulement d’une partie

A tour de rôle, chaque joueur choisit de déplacer son pion ou de poser une de ses barrières.
Lorsqu’il n’a plus de barrières, un joueur est obligé de déplacer son pion. 

Déplacement des pions

Les pions se déplacent d’une case, horizontalement ou verticalement, en avant ou en arrière; les
barrières doivent être contournées. 

Pose des barrières

Une barrière doit être posée exactement entre 2 blocs de 2 cases (fig 4).
La pose des barrières a pour but de se créer son propre chemin ou de ralentir l’adversaire, mais il est
interdit de lui fermer totalement l’accès à sa ligne de but : il faut toujours lui laisser une solution. 

Face à face

Quand les 2 pions se retrouvent en vis-à-vis sur 2 cases voisines non séparées par une barrière, le
joueur dont c’est le tour peut sauter son adversaire et se placer derrière lui (fig 6).
Si une barrière est située derrière le pion sauté, le joueur peut choisir de bifurquer à droite ou à
gauche du pion sauté. 

Fin de partie
Le premier joueur qui atteint une des 9 cases de la ligne opposée à sa ligne de départ gagne la partie. 

Étapes de la réalisation

Niveau1

Dans l'état initial, l'application propose de démarrer une partie ou de quitter l'application.
L'application invite tour à tour chaque joueur à jouer.
L'application permet de visualiser l'état du plateau.

Pendant une partie, le joueur courant peut :

déplacer son pion sur n'importe quelle case autre que celle où se trouve l'adversaire
positionner un mur au lieu d'avancer son pion (n'importe où du moment que deux murs ne se
chevauchent pas)
arrêter la partie et revenir à l'état initial

Niveau2

https://www.amazon.fr/ABcédaire-Amoureux-lIntelligence-Artificielle-Mercadier/dp/B0C872FTS3

Un pion ne peut être déplacé que sur une case adjacente.
Il est impossible d'aller sur une case s'il faut traverser un mur.
Le programme doit détecter si la partie est gagnée.

Niveau3
L'application intègre la règle du saut du pion adverse en cas de proximité des deux pions.


Niveau4
Il est impossible de poser un mur qui bloquerait tout accès à sa ligne d'arrivée à l'un des deux joueurs.
