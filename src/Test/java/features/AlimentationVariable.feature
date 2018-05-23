Feature: Alimentation Variable

  Background: Je connecte à Averroès et je créé un nouveau processus de l'action Alimentation Variable
    Given je connecte à Averroès en tant que admin
    Then je vois le dashboard d'admin
    And je clique sur le lien du dashlet administration processus

    Scenario: Alimentation variable d'un initiateur
      And je consule la dashlet processus
      When je lance le processus "alimentation variable d'un initiateur"
      Then je vois le formulaire avec le nom et le prènom de l'initiateur
      Given je créé un nouveau processus "alimentation variable d'un initiateur"
      And je réalise le workflow d'Alimentaion variable

      And je créé la varible de processus nom de type texte
      And je créé la variable de processus prenom de type texte
      And je créé le formulaire dans la tache utilisateur
      And je configure l'action de la tache système "Alimentation variable"
      And je clique sur l'icone générer
      And je clique sur l'icone activer
      And je consule la dashlet processus
      When je lance le processus "alimentation variable d'un initiateur"
      Then je vois le formulaire avec le nom et le prènom de l'initiateur

      Scenario: Alimentation variable d'un utilisateur dynamique

        Given je créé un nouveau processus "alimentation variable d'un utilisateur dynamique"
        And je créé une variable de processus "user" de type personne
        And je créé la varible de processus nom de type texte
        And je créé la variable de processus prenom de type texte
        And je réalise le workflow d'Alimentaion variable
        And je créé le formulaire dans le noeud de début
        And je créé le formulaire dans la tache utilisateur
        And je configure l'action de la tache système Alimentation variable
        And je clique sur l'icone générer
        And je clique sur l'icone activer
        And je consule la dashlet processus
        When je lance le processus Alimentation variable d'un utilisateur dynamique
        Then je vois le formulaire avec le nom et le prènom de l'utilisateur dynamique


  Scenario: Alimentation variable d'un groupe dynamique

    Given je créé un nouveau processus "alimentation variable d'un groupe dynamique"
    And je créé une variable de processus "groupe" de type "Groupe"
    And je créé la varible de processus "role" de type texte
    And je réalise le workflow d'Alimentaion variable
    And je créé le formulaire constitué par la variable groupe dans le noeud de début
    And je créé le formulaire de la variable role dans la tache utilisateur
    And je configure l'action de la tache système Alimentation variable d'un groupe dynamique
    And je clique sur l'icone générer
    And je clique sur l'icone activer
    And je consule la dashlet processus
    When je lance le processus Alimentation variable d'un groupe dynamique
    Then je vois le formulaire avec le role du groupe dynamique
















