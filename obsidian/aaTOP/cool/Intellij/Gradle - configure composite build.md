9/12/2024 2:41:35 PM

How to configure a composot build: tie two gradle projects together:
 - aka: when working on a connector at the same time you build the tests.

1 - get both repos cloned, and side by side
2 - first confirm boht can be built, and have clean idm-comm.
2 - add this to proejct A:
  //    implementation(':swa-scim-connector')
3 - Add location line under settings.gradle
  rootProject.name = 'IDtoSAPBrim'
  findProject(":swa-scim-connector")?.projectDir = new File("../swa-scim-connector")
4 - in right hand window in intellj, clikc plus and add swa-scim-connector's build to the gradle window.
(may not be needed) 5 - right clikc on main project, and 'confugre composit build config', then select swa-sicm conenctor.
It shoudl be set up!


9/12/2024 2:41:43 PM
Note: this portion may not be needed:
	'findProject(":swa-scim-connector")?.projectDir = new File("../swa-scim-connector")' 