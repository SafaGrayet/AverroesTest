Feature: Génération d'un PDF

  Background:
    Given je connecte à Averroès en tant que admin
    Then je vois le dashboard d'admin
    And je clique sur le lien du dashlet administration processus

  Scenario: Génération d'un PDF statique dans un emplacement statique
    Given je créé un nouveau processus "Génération d'un PDF statique dans un emplacement statique"
    And je créé la varible de processus nom de type texte
    And je créé la variable de processus prenom de type texte
    Then je réalise le workflow de génération PDF statique
    And je créé le formulaire contenat les champs nom, prénom  dans le noeud de début
    And je configure la tache système génération PDF statique
    And je clique sur l'icone générer
    And je clique sur l'icone activer
    And je consule la dashlet processus
    When je lance le processus Génération d'un PDF statique dans un emplacement statique
    Then je consule la dashlet bibliothéque
    And je trouve le fichier généré dans l'enplacement statique indiqué dans la configuration de la tache système

    #l'emplacement du fichier généré est le dossier PDF généré
    Scenario: Génération d'un PDF statique dans un emplacement dynamique
      Given je créé un nouveau processus "Génération d'un PDF statique dans un emplacement dynamique"
      And je créé la varible de processus nom de type texte
      And je créé la variable de processus prenom de type texte
      And je créé la varible de processus "dossier" de type Contenu GED
      Then je réalise le workflow de génération PDF statique
      And je créé le formulaire contenat les champs nom, prénom, dossier dans le noeud de début
      And je configure la tache système génération PDF statique avc emplacement dynamique
      And je clique sur l'icone générer
      And je clique sur l'icone activer
      And je consule la dashlet processus
      When je lance le processus Génération d'un PDF statique dans un emplacement dynamique
      Then je consule la dashlet bibliothéque
      And je trouve le fichier généré dans l'enplacement dynamique indiqué dans le formulaire

      #le fichier à générer dynamiquement est "test.pdf"
      Scenario: Génération d'un PDF dynamique dans un emplacement statique
        Given je créé un nouveau processus "Génération d'un PDF dynamique dans un emplacement statique"
        And je créé la varible de processus nom de type texte
        And je créé la variable de processus prenom de type texte
        And je créé la varible de processus "fichier" de type Contenu GED contenu
        Then je réalise le workflow de génération PDF dynamique dans un emplacement statique
        And je créé le formulaire contenat les champs nom, prénom, fichier dans le noeud de début
        And je configure la tache système génération PDF dynamique avc emplacement statique
        And je clique sur l'icone générer
        And je clique sur l'icone activer
        And je consule la dashlet processus
        When je lance le processus Génération d'un PDF dynamique dans un emplacement statique
        Then je consule la dashlet bibliothéque
        And je trouve le fichier généré dynamiqument dans l'emplacement statique indiqué dans la configuration de la tache système

        Scenario: Génération d'un PDF dynamique avec emplacement dynamique
          Given je créé un nouveau processus "Génération d'un PDF dynamique dans un emplacement dynamique"
          And je créé la varible de processus nom de type texte
          And je créé la variable de processus prenom de type texte
          And je créé la varible de processus "fichier" de type Contenu GED contenu
          And je créé la varible de processus "dossier" de type Contenu GED
          Then je réalise le workflow de génération PDF dynamique dans un emplacement dynamique
          And je créé le formulaire contenat les champs nom, prénom, fichier,dossier dans le noeud de début
          And je configure la tache système génération PDF dynamique avec emplacement dynamique
          And je clique sur l'icone générer
          And je clique sur l'icone activer
          And je consule la dashlet processus
          When je lance le processus Génération d'un PDF dynamique dans un emplacement dynamique
          Then je consule la dashlet bibliothéque
          And je trouve le fichier généré dynamiqument dans l'emplacement dynamique





