Feature: Exécuteur de script
  Scenario: Exécution du Script "Hello World"
    Given je connecte à Averroès en tant que admin
    Then je vois le dashboard d'admin
    And je clique sur le lien du dashlet administration processus
    And je créé un nouveau processus "Script Hello World"
    And je créé la varible de processus Hello de type texte
    And je réalise le workflow d'exécuteur de script
    And je créé le formulaire contenat le champ Hello dans la tache utilisateur
    And je configure l'action de la tache système exécueur script
    And je clique sur l'icone générer
    And je clique sur l'icone activer
    And je consule la dashlet processus
    When je lance le processus Script Hello World
    Then je vois "Hello World" affiché dans le formulaire
