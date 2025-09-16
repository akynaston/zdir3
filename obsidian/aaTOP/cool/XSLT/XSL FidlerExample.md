2/2/2024 3:05:39 PM

This is the fiddler link:
https://xsltfiddle.liberty-development.net/

But some times it is over quota and doesn't work - so this is another one:


XSLT fidler optional version; when the original one is down. This has ane example I did for Brenden just now:

https://xsltfiddle-beta.liberty-development.net/?xslt=%3C%3Fxml+version%3D%221.0%22+encoding%3D%22utf-8%22%3F%3E%0D%0A%3Cxsl%3Astylesheet+xmlns%3Axsl%3D%22http%3A%2F%2Fwww.w3.org%2F1999%2FXSL%2FTransform%22%0D%0A++version%3D%223.0%22%0D%0A++xmlns%3Axs%3D%22http%3A%2F%2Fwww.w3.org%2F2001%2FXMLSchema%22%0D%0A++exclude-result-prefixes%3D%22%23all%22%0D%0A++expand-text%3D%22yes%22%3E%0D%0A%0D%0A%0D%0A%3Cxsl%3Atemplate+match%3D%22%40*%7Cnode%28%29%22%3E%0D%0A++%3Cxsl%3Acopy%3E%0D%0A++++%3Cxsl%3Aapply-templates+select%3D%22%40*%7Cnode%28%29%22%2F%3E%0D%0A++%3C%2Fxsl%3Acopy%3E%0D%0A%3C%2Fxsl%3Atemplate%3E%0D%0A%0D%0A%3Cxsl%3Atemplate+match%3D%22modify%2Fmodify-attr%2Fadd-value%22%3E%0D%0A+%3Cxsl%3Acopy%3E%0D%0A+++%3Cxsl%3Acopy-of+select%3D%22value%5Bstarts-with%28.%2C+%270%27%29%5D%22%2F%3E%0D%0A+%3C%2Fxsl%3Acopy%3E%0D%0A%3C%2Fxsl%3Atemplate%3E%0D%0A%0D%0A%0D%0A%0D%0A%3C%2Fxsl%3Astylesheet%3E%0D%0A&input=%3Cmodify%3E%0D%0A%0D%0A%3Cmodify-attr+attr-name%3D%22wd-EmergencyContactData%22%3E%0D%0A++%3Cadd-value%3E%0D%0A++++%3Cvalue%3E0+%7C%7C%7C+Jane+Doe+%7C%7C%7C+123+Herb+St+%7C%7C%7C++%7C%7C%7C+Dallas+%7C%7C%7C+TX+%7C%7C%7C+75235+%7C%7C%7C+US+%7C%7C%7C+%2B1+123-456-7890+%7C%7C%7C+%3C%2Fvalue%3E%0D%0A++++%3Cvalue%3E1+%7C%7C%7C+Jim+Doe+%7C%7C%7C+123+Herb+St+%7C%7C%7C++%7C%7C%7C+Dallas+%7C%7C%7C+TX+%7C%7C%7C+75235+%7C%7C%7C+US+%7C%7C%7C+%2B1+123-098-7654+%7C%7C%7C+%2B1+123-567-4890%3C%2Fvalue%3E%0D%0A++%3C%2Fadd-value%3E%0D%0A%3C%2Fmodify-attr%3E%0D%0A%0D%0A%0D%0A%3C%2Fmodify%3E&input-type=XML
