Feature: Déplacement copie des document

  Background:
    Given je connecte à Averroès en tant que admin
    Then je vois le dashboard d'admin
    And je clique sur le lien du dashlet administration processus


  #le fichier à déplacer est "cv_safa.pdf"
  #l'emplacement du fichier est "filigrane"
  Scenario: Déplacement d'un document statique dans un emplacement statique
    Given je créé un nouveau processus "Déplacement d'un document statique dans un emplacement statique"
    And je réalise le workflow Déplacement d'un document statique dans un emplacement statique
    And je configure l'action de la tache système Déplacement d'un document statique dans un emplacement statique
    And je clique sur l'icone générer
    And je clique sur l'icone activer
    And je consule la dashlet processus
    When je lance le processus Déplacement d'un document statique dans un emplacement statique
    And je consule la dashlet bibliothéque
    Then je vois le document est bien placer dans l'emplacemrnt indiqué statiquement

    Scenario: Déplacement d'un document dynamique dans un emplacement statique
      Given je créé un nouveau processus "Déplacement d'un document dynamique dans un emplacement statique"
      And je créé la varible de processus fichier de type Contenu GED contenu
      Then je réalise le workflow de Déplacement d'un document dynamique dans un emplacement statique
      And je créé le formulaire contenat le champs fichier dans le noeud de début
      And je configure la tache système Déplacement d'un document dynamique dans un emplacement statique
      And je clique sur l'icone générer
      And je clique sur l'icone activer
      And je consule la dashlet processus
      When je lance le processus Déplacement d'un document dynamique dans un emplacement statique
      Then je consule la dashlet bibliothéque
      And je trouve le document est bien déplacer dans l'emplacemrnt indiqué statiquemente


      Scenario: Déplacement d'un document statique dans un emplacement dynamique
        Given je créé un nouveau processus "Déplacement d'un document statique dans un emplacement dynamique"
        And je créé la varible de processus dossier de type Contenu GED
        Then je réalise le workflow de Déplacement d'un document statique dans un emplacement dynamique
        And je créé le formulaire contenat le champ dossier dans le noeud de début
        And je configure la tache système Déplacement d'un document statique dans un emplacement dynamique
        And je clique sur l'icone générer
        And je clique sur l'icone activer
        And je consule la dashlet processus
        When je lance le processus Déplacement d'un document statique dans un emplacement dynamique
        Then je consule la dashlet bibliothéque
        And je trouve le fichier déplacé dans l'enplacement dynamique indiqué dans le formulaire

        Scenario: Déplacement d'un document dynamique dans un emplacement dynamique
          Given je créé un nouveau processus "Déplacement d'un document dynamique dans un emplavement dynamique"
          And je créé la varible de processus fichier de type Contenu GED contenu
          And je créé la varible de processus dossier de type Contenu GED
          Then je réalise le workflow de Déplacement d'un document dynamique dans un emplavement dynamique
          And je créé le formulaire contenat les champs fichier,dossier dans le noeud de début
          And je configure la tache système Déplacement d'un document dynamique dans un emplavement dynamique
          And je clique sur l'icone générer
          And je clique sur l'icone activer
          And je consule la dashlet processus
          When je lance le processus Déplacement d'un document dynamique dans un emplavement dynamique
          Then je consule la dashlet bibliothéque
          And je trouve le fichier déplacé dynamiqument dans l'emplacement dynamique

          Scenario: Copie d'un document statique dans un emplacement statique
            Given je créé un nouveau processus "Copie d'un document statique dans un emplacement statique"
            And je réalise le workflow Copie d'un document statique dans un emplacement statique
            And je configure l'action de la tache système Copie d'un document statique dans un emplacement statique
            And je clique sur l'icone générer
            And je clique sur l'icone activer
            And je consule la dashlet processus
            When je lance le processus Copie d'un document statique dans un emplacement statique
            And je consule la dashlet bibliothéque
            Then je trouve le document est bien copier dans l'emplacemrnt indiqué statiquement

  Scenario: Copie d'un document dynamique dans un emplacement statique
    Given je créé un nouveau processus "Copie d'un document dynamique dans un emplacement statique"
    And je créé la varible de processus fichier de type Contenu GED contenu
    Then je réalise le workflow de Copie d'un document dynamique dans un emplacement statique
    And je créé le formulaire contenat le champs fichier dans le noeud de début
    And je configure la tache système Copie d'un document dynamique dans un emplacement statique
    And je clique sur l'icone générer
    And je clique sur l'icone activer
    And je consule la dashlet processus
    When je lance le processus Copie d'un document dynamique dans un emplacement statique
    Then je consule la dashlet bibliothéque
    And je trouve le document est bien copié dans l'emplacemrnt indiqué statiquement



  Scenario: Copie d'un document statique dans un emplacement dynamique
    Given je créé un nouveau processus "Copie d'un document statique dans un emplacement dynamique"
    And je créé la varible de processus dossier de type Contenu GED
    Then je réalise le workflow de Copie d'un document statique dans un emplacement dynamique
    And je créé le formulaire contenat le champ dossier dans le noeud de début
    And je configure la tache système Copie d'un document statique dans un emplacement dynamique
    And je clique sur l'icone générer
    And je clique sur l'icone activer
    And je consule la dashlet processus
    When je lance le processus Copie d'un document statique dans un emplacement dynamique
    Then je consule la dashlet bibliothéque
    And je trouve le fichier Copié dans l'enplacement dynamique indiqué dans le formulaire


  Scenario: Copie d'un document dynamique dans un emplavement dynamique
    Given je créé un nouveau processus "Copie d'un document dynamique dans un emplavement dynamique"
    And je créé la varible de processus "fichier" de type Contenu GED contenu
    And je créé la varible de processus "dossier" de type Contenu GED
    Then je réalise le workflow de Copie d'un document dynamique dans un emplavement dynamique
    And je créé le formulaire contenat les champs fichier,dossier dans le noeud de début
    And je configure la tache système Copie d'un document dynamique dans un emplavement dynamique
    And je clique sur l'icone générer
    And je clique sur l'icone activer
    And je consule la dashlet processus
    When je lance le processus Copie d'un document dynamique dans un emplavement dynamique
    Then je consule la dashlet bibliothéque
    And je trouve le fichier Copié dynamiqument dans l'emplacement dynamique






