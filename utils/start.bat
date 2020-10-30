@echo off

set DIRNAME=%~dp0

set CP="%DIRNAME%MiscelaneosPOS.jar"

set CP=%CP%;"%DIRNAME%lib/jasperreports-3.1.4.jar"
set CP=%CP%;"%DIRNAME%lib/jcommon-1.0.15.jar"
set CP=%CP%;"%DIRNAME%lib/jfreechart-1.0.12.jar"
set CP=%CP%;"%DIRNAME%lib/jdt-compiler-3.1.1.jar"
set CP=%CP%;"%DIRNAME%lib/commons-beanutils-1.7.jar"
set CP=%CP%;"%DIRNAME%lib/commons-digester-1.7.jar"
set CP=%CP%;"%DIRNAME%lib/iText-2.1.0.jar"
set CP=%CP%;"%DIRNAME%lib/poi-3.2-FINAL-20081019.jar"
set CP=%CP%;"%DIRNAME%lib/barcode4j-light.jar"
set CP=%CP%;"%DIRNAME%lib/commons-codec-1.3.jar"
set CP=%CP%;"%DIRNAME%lib/velocity-1.5.jar"
set CP=%CP%;"%DIRNAME%lib/oro-2.0.8.jar"
set CP=%CP%;"%DIRNAME%lib/commons-collections-3.1.jar"
set CP=%CP%;"%DIRNAME%lib/commons-lang-2.1.jar"
set CP=%CP%;"%DIRNAME%lib/bsh-core-2.0b4.jar"
set CP=%CP%;"%DIRNAME%lib/RXTXcomm.jar"
set CP=%CP%;"%DIRNAME%lib/jpos1121.jar"
set CP=%CP%;"%DIRNAME%lib/swingx-0.9.5.jar"
set CP=%CP%;"%DIRNAME%lib/substance.jar"
set CP=%CP%;"%DIRNAME%lib/substance-swingx.jar"

rem Apache Axis SOAP libraries.
set CP=%CP%;"%DIRNAME%lib/axis.jar"
set CP=%CP%;"%DIRNAME%lib/jaxrpc.jar"
set CP=%CP%;"%DIRNAME%lib/saaj.jar"
set CP=%CP%;"%DIRNAME%lib/wsdl4j-1.5.1.jar"
set CP=%CP%;"%DIRNAME%lib/commons-discovery-0.2.jar"
set CP=%CP%;"%DIRNAME%lib/commons-logging-1.0.4.jar"

set CP=%CP%;"%DIRNAME%locales/"
set CP=%CP%;"%DIRNAME%reports/"

start /B javaw -cp %CP% -Djava.util.logging.config.file="%DIRNAME%logging.properties" -Djava.library.path="%DIRNAME%lib/Windows/i368-mingw32" -Ddirname.path="%DIRNAME%./" com.openbravo.pos.forms.StartPOS %1
