# conception-logicielle-BATTLESHIP-TCP

Le projet développé est un jeu de bataille navale en ligne via un serveur TCP.

Le jeu n'est actuellement pas fonctionnel. Néanmoins la communication via le protocole TCP entre le client et le serveur est fonctionnelle.

Pour mettre en oeuvre cette relation nous avons respecté le Pattern Strategy. Il consiste à utiliser des interfaces telle que "IContexte" pour disposer d'un serveur TCP multitâches. Il peut servir à faire tourner ce jeu ainsi qu'autre chose selon la demande du client et le protocole exécuté par la suite.

Nous avons essayé au maximum de développer la structure du code pour respecter la méthode SOLID. Via le diagramme SYSML nous pouvons apercevoir le pattern Strategy ainsi que les dépendances entre les classes qui sont minimisées. De plus les classes sont crées pour qu'elles n'aient à gérer qu'une seule responsabilité.

Un début d'interface graphique a été développée mais pas reliée au reste du code.
