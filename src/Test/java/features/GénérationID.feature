Feature: Génération id
  Scenario: Incrémentation du compteur avec un pas de test
    Given je connecte à Averroès en tant que admin
    Then je vois le dashboard d'admin
    And je clique sur le lien du dashlet administration processus
    And je créé un nouveau processus "Générer Identifiant"
    And je réalise le workflow de "Générer Identifiant"
    And je créé la varible de processus "test" de type texte
    And je configure l'action de la tache système Génération ID
    And je clique sur l'icone générer
    And je clique sur l'icone activer
    And je consule la dashlet processus
    And je lance le processus Générer Identifiant
    And je consulte la dashlet administration processus
    When je cliquer sur "gestion des compteurs"
    Then Le compteur nommé "test"qu'on a déjà créé s'incrémente avec la pas d'incrémentation


