Sí. Yo lo configuraría para que puedas trabajar **en Windows y en WSL2**, pero usando **WSL2 como entorno principal** para Java + seguridad.

## 1. Comprueba primero si ya tienes WSL2

Abre **PowerShell como administrador**:

```powershell
wsl -l -v
```

Si aparece algo como:

```text
NAME      STATE      VERSION
Ubuntu    Running    2
```

ya lo tienes.

Si no:

```powershell
wsl --install
```

Reinicia Windows cuando termine. Microsoft indica que las instalaciones actuales usan WSL2 por defecto. ([Microsoft Learn][1])

[Guía oficial de instalación de WSL](https://learn.microsoft.com/es-es/windows/wsl/install?utm_source=chatgpt.com)

## 2. Actualiza Ubuntu

Abre Ubuntu/WSL:

```bash
sudo apt update
sudo apt upgrade -y
```

Comprueba:

```bash
cat /etc/os-release
```

## 3. Instala Java 21

Tienes dos posibilidades. Para empezar puedes utilizar directamente OpenJDK:

```bash
sudo apt install openjdk-21-jdk -y
```

Comprueba:

```bash
java -version
javac -version
```

Deberías ver Java **21**.

Si en tu asignatura te piden específicamente **AdoptOpenJDK**, actualmente el proyecto se denomina Eclipse Adoptium y su distribución es **Temurin**. Adoptium proporciona paquetes Linux oficiales. ([Adoptium][2])

[Eclipse Temurin 21](https://adoptium.net/temurin/releases?version=21&utm_source=chatgpt.com)

En ese caso te explico después cómo sustituir OpenJDK por Temurin 21.

## 4. Configura JAVA_HOME

Primero:

```bash
readlink -f $(which java)
```

Probablemente tendrás algo parecido a:

```text
/usr/lib/jvm/java-21-openjdk-amd64/bin/java
```

Entonces:

```bash
nano ~/.bashrc
```

Al final añade:

```bash
export JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH
```

Guarda y ejecuta:

```bash
source ~/.bashrc
```

Comprueba:

```bash
echo $JAVA_HOME
java -version
```

## 5. Instala Maven

```bash
sudo apt install maven -y
```

Comprueba:

```bash
mvn -version
```

Es importante que ahí aparezca:

```text
Java version: 21...
```
Salida en wls probable

```text 
Apache Maven 3.8.7
Maven home: /usr/share/maven
Java version: 21.0.12.1, vendor: Ubuntu, runtime: /usr/lib/jvm/java-21-openjdk-amd64
Default locale: en, platform encoding: UTF-8
OS name: "linux", version: "6.18.33.2-microsoft-standard-wsl2", arch: "amd64", family: "unix"

```
Puedes comprobar dónde está cada programa:

```bash
which java
which javac
which mvn
```

Debería ser algo similar a:

```text
/usr/bin/java
/usr/bin/javac
/usr/bin/mvn
```

## 6. Configura VS Code

En Windows instala [Visual Studio Code](https://code.visualstudio.com/?utm_source=chatgpt.com).

Dentro de VS Code instala:

```text
WSL

Extension Pack for Java
```

El **Extension Pack for Java** proporciona las herramientas fundamentales para desarrollar, ejecutar, depurar y probar Java desde VS Code. ([Visual Studio Code][3])

[Documentación oficial Java + VS Code](https://code.visualstudio.com/docs/languages/java?utm_source=chatgpt.com)

En tu captura, para **Java 21 + Maven + VS Code + WSL**, no instalaría extensiones una por una. Instala directamente **`Extension Pack for Java` de Microsoft**.

Ese pack te instalará automáticamente las importantes que aparecen en tu captura:

* **Language Support for Java by Red Hat** → autocompletado, errores, navegación, refactoring, etc.
* **Debugger for Java — Microsoft** → ejecutar y depurar.
* **Test Runner for Java — Microsoft** → JUnit/TestNG.
* **Maven for Java — Microsoft** → trabajar con `pom.xml`, goals y dependencias.
* **Project Manager for Java — Microsoft** → gestión de proyectos Java.
* **IntelliCode** → asistencia adicional para el código.

Por tanto, **no hace falta que pulses Install individualmente** en Debugger, Maven, Test Runner, etc.; instala el pack y él se encarga.

De lo que veo en tu captura, **no instalaría por ahora** `Java — Oracle`, `Gradle for Java` (vamos a usar Maven), `Spring Initializr` (solo lo necesitarás si luego trabajamos con Spring Boot) ni las otras extensiones Java de terceros.

Tu configuración debería quedar:

```text
VS Code (Windows)
│
├── WSL                       ← Microsoft
│
└── Extension Pack for Java   ← Microsoft
     ├── Language Support for Java
     ├── Debugger for Java
     ├── Test Runner for Java
     ├── Maven for Java
     └── Project Manager for Java
             │
             ▼
        Ubuntu WSL2
        ├── Java 21
        └── Maven
```

**Importante:** como quieres trabajar en WSL, después de instalarlo abre VS Code conectado a **WSL: Ubuntu**. Si las extensiones aparecen como disponibles para **“Install in WSL: Ubuntu”**, instálalas ahí también.

Cuando hagas eso, podemos pasar directamente a configurar el entorno de **búsqueda de vulnerabilidades**, donde añadiríamos herramientas como **FindSecBugs, OWASP Dependency-Check y Semgrep**.


## 7. Crea los proyectos dentro de WSL

Yo crearía:

```bash
mkdir -p ~/git
cd ~/git
```

Tus proyectos:

```text
/home/tu_usuario/git/
├── java-security-lab/
├── universidad/
├── practicas/
└── proyectos/
```

Evitaría tener el proyecto Java principal en:

```text
/mnt/c/Users/...
```

Microsoft también recomienda almacenar los proyectos que vas a trabajar con herramientas Linux en el filesystem de WSL por rendimiento. ([Microsoft Learn][4])

## 8. Abre VS Code desde WSL

Por ejemplo:

```bash
cd ~/git
mkdir java-security-lab
cd java-security-lab

code .
```

Ahora tienes:

```text
Windows
   │
   └── VS Code
         │
         └── WSL2
               │
               └── Ubuntu
                    ├── Java 21
                    ├── Maven
                    ├── Git
                    └── herramientas seguridad
```

Esto es importante: **la interfaz de VS Code sigue estando en Windows**, pero el código, terminal, Java, Maven y las herramientas se ejecutan en Linux.

## 9. Comprueba que VS Code está utilizando WSL

Abre el terminal integrado:

`Ctrl + ñ`

y ejecuta:

```bash
uname -a
which java
java -version
which mvn
mvn -version
```

Si ves rutas `/usr/...`, estás trabajando correctamente dentro de WSL.

## 10. Crea un proyecto Maven de prueba

Desde WSL:

```bash
cd ~/git

mvn archetype:generate \
-DgroupId=com.securitylab \
-DartifactId=java-security-lab \
-DarchetypeArtifactId=maven-archetype-quickstart \
-DinteractiveMode=false
```

Después:

```bash
cd java-security-lab
code .
```

Compila:

```bash
mvn clean package
```

Y ejecuta los tests:

```bash
mvn test
```

Si obtienes:

```text
BUILD SUCCESS
```

ya tienes funcionando:

```text
VS Code
   ↓
WSL2
   ↓
Ubuntu
   ↓
JDK 21
   ↓
Maven
   ↓
Proyecto Java
```

## 11. Después montamos la parte interesante: seguridad

Sobre esta instalación podemos añadir progresivamente:

```text
VS Code + WSL2
        │
        ├── Java 21
        ├── Maven
        ├── Git
        │
        ├── SpotBugs
        │      └── FindSecBugs
        │
        ├── OWASP Dependency-Check
        │      └── CVE en dependencias
        │
        ├── Semgrep
        │      └── SAST
        │
        ├── CodeQL
        │      └── data-flow / taint analysis
        │
        └── Docker
               └── laboratorios aislados
```

Ahí es donde tu elección de **WSL2 frente a Windows puro** empieza a tener bastante sentido para ciberseguridad.

Haz primero hasta el **paso 5** y pásame el resultado de:

```bash
java -version
javac -version
mvn -version
echo $JAVA_HOME
```

Con eso comprobamos que no tienes mezcladas instalaciones de Java y pasamos a configurar **VS Code + primer proyecto vulnerable + FindSecBugs**.

[1]: https://learn.microsoft.com/es-es/windows/wsl/install?utm_source=chatgpt.com "Instalación de WSL | Microsoft Learn"
[2]: https://adoptium.net/installation/linux?utm_source=chatgpt.com "Linux (RPM/DEB/APK) installer packages | Adoptium"
[3]: https://code.visualstudio.com/docs/languages/java?utm_source=chatgpt.com "Java in Visual Studio Code"
[4]: https://learn.microsoft.com/eu-es/windows/wsl/setup/environment?utm_source=chatgpt.com "Configurar un entorno de desarrollo de WSL | Microsoft Learn"
