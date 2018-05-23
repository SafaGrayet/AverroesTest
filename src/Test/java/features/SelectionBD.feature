Feature: Séléction des informations à partir de la base de données "averroesDB"

  #le nom de la table est "test"

Scenario: Sélectionner nom et prènom à partir de la table "test" dans la base de donnée "averroesDB"
  Given je connecte à Averroès en tant que admin
  Then je vois le dashboard d'admin
  And je clique sur le lien du dashlet administration processus
  And je créé un nouveau processus "Sélection de la base de données"
  And je créé la varible de processus nom de type texte
  And je créé la variable de processus prenom de type texte
  And je réalise le workflow de sélection dans la base de doonée
  And je créé le formulaire contenat les champs nom et prénom dans la tache utilisateur
  And je configure l'action de la tache système selection dans la base de données
  And je clique sur l'icone générer
  And je clique sur l'icone activer
  And je consule la dashlet processus
  When je lance le processus Sélection dans la base de données
  Then je vois que les données de la base de données sont figurer dans le formulaire


