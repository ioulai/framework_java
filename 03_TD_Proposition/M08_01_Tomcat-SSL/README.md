# Utiliser KeyTool
- set JRE HOME
<pre>set JRE_HOME=D:\java\jre1.8\bin</pre>

- Generer le keystore et la paire clés publique/privée
<pre>%JRE_HOME%\keytool -genkey -keystore tomcatserver.jks -alias monsite -keyalg RSA</pre>

Pour la durée de validation : 
<pre>-validity 360</pre>

