$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("AlimentationVariable.feature");
formatter.feature({
  "line": 1,
  "name": "Alimentation Variable",
  "description": "",
  "id": "alimentation-variable",
  "keyword": "Feature"
});
formatter.before({
  "duration": 18379376884,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "Je connecte à Averroès et je créé un nouveau processus de l\u0027action Alimentation Variable",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "je connecte à Averroès en tant que admin",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "je vois le dashboard d\u0027admin",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "je clique sur le lien du dashlet administration processus",
  "keyword": "And "
});
formatter.match({
  "location": "FiligranerPDFSteps.jeConnecteAAverroesEnTantQueAdmin()"
});
formatter.result({
  "duration": 462164432,
  "status": "passed"
});
formatter.match({
  "location": "FiligranerPDFSteps.jeVoisLeDashboardDAdmin()"
});
formatter.result({
  "duration": 81121996,
  "status": "passed"
});
formatter.match({
  "location": "FiligranerPDFSteps.jeCliqueSurLeLienDuDashletAdministrationProcessus()"
});
formatter.result({
  "duration": 6097476290,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Alimentation variable d\u0027un initiateur",
  "description": "",
  "id": "alimentation-variable;alimentation-variable-d\u0027un-initiateur",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "je consule la dashlet processus",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "je lance le processus \"alimentation variable d\u0027un initiateur\"",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "je vois le formulaire avec le nom et le prènom de l\u0027initiateur",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "je créé un nouveau processus \"alimentation variable d\u0027un initiateur\"",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "je réalise le workflow d\u0027Alimentaion variable",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "je créé la varible de processus nom de type texte",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "je créé la variable de processus prenom de type texte",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "je créé le formulaire dans la tache utilisateur",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "je configure l\u0027action de la tache système \"Alimentation variable\"",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "je clique sur l\u0027icone générer",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "je clique sur l\u0027icone activer",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "je consule la dashlet processus",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "je lance le processus \"alimentation variable d\u0027un initiateur\"",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "je vois le formulaire avec le nom et le prènom de l\u0027initiateur",
  "keyword": "Then "
});
formatter.match({
  "location": "FiligranerPDFSteps.jeConsuleLaDashletProcessus()"
});
formatter.result({
  "duration": 11233020590,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "alimentation variable d\u0027un initiateur",
      "offset": 23
    }
  ],
  "location": "AlimentationVariableTest.jeLanceLeProcessus(String)"
});
