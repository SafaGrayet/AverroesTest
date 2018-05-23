Feature: Copie de métadonées

  Background:
    Given je connecte à Averroès en tant que admin
    Then je vois le dashboard d'admin
    And je clique sur le lien du dashlet administration processus

  Scenario: Copie de métadonnées: document vers workflow (contenu GED de type dossier)

    Given je créé un nouveau processus "copie méradonnées  document vers workflow"
    And je créé la varible de processus "nom" de type texte
    And je créé la varible de processus "description" de type texte
    And je créé la varible de processus "titre" de type texte
    And je créé la varible de processus "dossier" de type Contenu GED
    And je réalise le workflow Copie de métadonnées: document vers workflow
    And je créé le formulaire contenant le champs dossier  dans le noeud de début
    And je créé le formulaire contenat les champs nom, description et titre dans la tache utilisateur
    And je configure l'action de la tache système Copie de métadonnées: document vers workflow
    And je clique sur l'icone générer
    And je clique sur l'icone activer
    And je consule la dashlet processus
    When je lance le processus copie méradonnées: document vers workflow
    Then je vois le formulaire avec le nom, le titre et la description du dossier selectinné dynamiquement

  Scenario: Copie de métadonnées: document vers workflow (contenu GED de type document)
    And je consule la dashlet processus
    When je lance le processus copie méradonnées: document vers workflow d'un contenu
    Given je créé un nouveau processus "copie méradonnées  document vers workflow d'un fichier"
    And je créé la varible de processus "nom" de type texte
    And je créé la varible de processus "description" de type texte
    And je créé la varible de processus "titre" de type texte
    And je créé la varible de processus "fichier" de type Contenu GED contenu
    And je réalise le workflow Copie de métadonnées: document vers workflow
    And je créé le formulaire contenant le champs fichier  dans le noeud de début
    And je créé le formulaire contenat les champs nom, description et titre dans la tache utilisateur
    And je configure l'action de la tache système Copie de métadonnées: document vers workflow d'un contenu
    And je clique sur l'icone générer
    And je clique sur l'icone activer
    And je consule la dashlet processus
    When je lance le processus copie méradonnées: document vers workflow d'un contenu
    Then je vois le formulaire avec le nom, le titre et la description du dossier selectinné dynamiquement

  Scenario: Copie de métadonnées: document vers workflow (document attaché)
    Given je créé un nouveau processus "copie méradonnées  document vers workflow d'un fichier attaché"
    And je créé la varible de processus "nom" de type texte
    And je créé la varible de processus "description" de type texte
    And je créé la varible de processus "titre" de type texte
    And je réalise le workflow Copie de métadonnées document vers workflow d'un fichier attaché
    And je créé le formulaire contenat les champs nom, description et titre dans la tache utilisateur
    And je configure l'action de la tache système Copie de métadonnées document vers workflow d'un document attaché
    And je clique sur l'icone générer
    And je clique sur l'icone activer
    And je consule la dashlet processus
    When je lance le processus copie méradonnées  document vers workflow d'un fichier attaché
    Then je vois le formulaire avec le nom, le titre et la description du fichier attaché








