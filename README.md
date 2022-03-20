# conception-logicielle-BATTLESHIP-TCP

Le projet développé est un jeu de bataille navale en ligne via un serveur TCP

Le jeu n'est actuellement pas foncitonnel. Néanmoins la communication via le protocole TCP entre le client et le serveur est foncitonnel.

Pour mettre en oeuvre cette relation nous avons respecté le Pattern Strategy. Il consiste à utiliser des interfaces tel que "IContexte" pour disposer d'un serveur TCP multitâche. Il peut servir à faire tourner ce jeu ainsi qu'autre chose selon la demande du client et le protocole exécuté par la suite.

Nous avons essayé au maximum de développer la structure du code pour respecter la méthode SOLID. Via le diagramme SYSML nous pouvons apercevoir le pattern Strategy ainsi que les dépendances entre les classes qui sont minimisées. De plus les classes sont crées pour qu'elles n'aient à gérer qu'une seule responsabilité.
