# Utiliser KeyTool
- set JRE HOME
<pre>set JRE_HOME=D:\java\jre1.8\bin</pre>

- Generer le keystore et la paire cl�s publique/priv�e
<pre>%JRE_HOME%\keytool -genkey -keystore tomcatserver.jks -alias monsite -keyalg RSA</pre>

Pour la dur�e de validation : 
<pre>-validity 360</pre>

