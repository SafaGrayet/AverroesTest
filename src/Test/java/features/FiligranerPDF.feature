Feature: Filigraner PDF

  Background: Je connecte à Averroès et je créé un nouveau processus de l'action Alimentation Variable
    Given je connecte à Averroès en tant que admin
    Then je vois le dashboard d'admin
    And je clique sur le lien du dashlet administration processus

  Scenario: Filigraner PDF et le placer dans dashlet Mes documents
    And je créé un nouveau processus
    And je réalise le workflow de filigranner PDF
    And je configure l'action de la tache système
    And je clique sur l'icone générer
    And je clique sur l'icone activer
    And je consule la dashlet processus
    And je lance le processus
    And je consulte la dashlet Bibliothéque
    Then je trouve le document filigrané