$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/sample.feature");
formatter.feature({
  "name": "check WordPress Login Functinality with Different User",
  "description": "Description: The purpose of this feature is to test the Background keyword",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Title of your scenario",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user logged in using username as \"\u003cUsername\u003e\" and password as \"\u003cpassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "home page should be displayed",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Username",
        "password"
      ]
    },
    {
      "cells": [
        "sumitsingh21",
        "demo@5318"
      ]
    }
  ]
});
formatter.background({
  "name": "To close the browser",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "navigate to wordpress page",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDefinition.navigate()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Title of your scenario",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user logged in using username as \"sumitsingh21\" and password as \"demo@5318\"",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDefinition.login(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "home page should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefinition.verifySuccessful()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});