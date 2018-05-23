Feature: Insertion des informaions dans la base de données "averroesDB"

  #Prérequis:
      #création de la base de donnée "averroesDB" dans "Gestion des variables d'environnement" dans la dashlet "administration
      # processus"
      # ajouter la table test contenant les deux colones "nm" et "prènom"

  Scenario: Insérer nom et prènom dans la table "test" de la base de données "averroesDB"
    Given je connecte à Averroès en tant que admin
    Then je vois le dashboard d'admin
    And je clique sur le lien du dashlet administration processus
    And je créé un nouveau processus "Insertion dans la base de données"
    And je créé la varible de processus nom de type texte
    And je créé la variable de processus prenom de type texte
    And je réalise le workflow d'insertion dans la base de doonée
    And je créé le formulaire contenat les champs nom et prénom dans le noeud de début
    And je configure l'action de la tache système insertion dans la base de donnée
    And je clique sur l'icone générer
    And je clique sur l'icone activer
    And je consule la dashlet processus
    When je lance le processus Insertion dans la base de donnée
    Then je vois que les données saisies dans le formulaire sont bien insérer dans la base de donnée


