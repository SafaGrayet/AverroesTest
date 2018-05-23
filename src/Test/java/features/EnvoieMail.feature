Feature: Envoie Mail
  Background: Je connecte à Averroès et je créé un nouveau processus de l'action Alimentation Variable
    Given je connecte à Averroès en tant que admin
    Then je vois le dashboard d'admin
    And je clique sur le lien du dashlet administration processus

    #l'utilisateur statique est "safa"
    Scenario: Envoie mail à un utilisateur statique
      Given je créé un nouveau processus "Evoie Mail à un utilisateur statique"
      Then je réalise le workflow de Envoie Mail
      And je configure la tache système envoie mail
      And je clique sur l'icone générer
      And je clique sur l'icone activer
      And je consule la dashlet processus
      When je lance le processus Evoie Mail à un utilisateur statique
      Then je reçue le mail dans la boite de réception de l'utilisateur indiqué statiquement
      #l'initiateur est l'administrateur
      Scenario: Envoie mail à un initiateur
        Given je créé un nouveau processus "Evoie Mail à un initiateur"
        Then je réalise le workflow de Envoie Mail
        And je configure la tache système envoie mail à un initiateur
        And je clique sur l'icone générer
        And je clique sur l'icone activer
        And je consule la dashlet processus
        When je lance le processus Evoie Mail à un initiateur
        Then je reçue le mail dans la boite de réception de l'initiateur

         #l'utilisateur dynamique est "safa"

     Scenario: Evoie mail à un utilisateur dynamique
       Given je créé un nouveau processus "Evoie Mail à un utilisateur dynamique"
       And je créé une variable de processus "user" de type personne
       Then je réalise le workflow de Envoie Mail
       And je créé le formulaire dans le noeud de début
       And je configure la tache système Evoie Mail à un utilisateur dynamique
       And je clique sur l'icone générer
       And je clique sur l'icone activer
       And je consule la dashlet processus
       When je lance le processus Evoie Mail à un utilisateur dynamique
       Then je reçue le mail dans la boite de réception de l'utilisateur indiqué dynamiquement
      #Le destinataire est le chef hiérarchique du groupe 1
       Scenario: Envoie mail à un chef hiérarchique
    Given je créé un nouveau processus "Evoie Mail à un chef hiérarchique statique"
    Then je réalise le workflow de Envoie Mail
    And je configure la tache système Evoie Mail à un chef hiérarchique statique
    And je clique sur l'icone générer
    And je clique sur l'icone activer
    And je consule la dashlet processus
    When je lance le processus Evoie Mail à un chef hiérarchique statique
    Then je reçue le mail dans la boite de réception du chef hiérarchique statique

         #Le destinataire est le chef hiérarchique de l'initiateur (administrateur)
  Scenario: Envoie mail au chef hiérarchique de l'intiateur
    Given je créé un nouveau processus "Evoie Mail au chef hiérarchique de l'initiateur "
    Then je réalise le workflow de Envoie Mail
    And je configure la tache système Evoie Mail au chef hiérarchique de l'initiateur
    And je clique sur l'icone générer
    And je clique sur l'icone activer
    And je consule la dashlet processus
    When je lance le processus Evoie Mail au chef hiérarchique de l'initiateur
    Then je reçue le mail dans la boite de réception du chef hiérarchique de l'initiateur

    #Le destinataire est le chef hiérarchique de l'utilisateur dynamique ("safa")
  Scenario: Envoie mail au chef hiérarchique d'un utilisateur dynamique
    Given je créé un nouveau processus "Envoie mail au chef hiérarchique d'un utilisateur dynamique"
    And je créé une variable de processus "user" de type personne
    Then je réalise le workflow de Envoie Mail
    And je créé le formulaire dans le noeud de début
    And je configure la tache système Envoie mail au chef hiérarchique d'un utilisateur dynamique
    And je clique sur l'icone générer
    And je clique sur l'icone activer
    And je consule la dashlet processus
    When je lance le processus Envoie mail au chef hiérarchique d'un utilisateur dynamique
    Then je reçue le mail dans la boite de réception du chef hiérarchique de l'utilisateur indiqué dynamiquement








