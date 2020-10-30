@echo off

set DIRNAME=%~dp0

set CP="%DIRNAME%MiscelaneosPOS.jar"

set CP=%CP%;"%DIRNAME%locales/"
set CP=%CP%;"%DIRNAME%lib/substance.jar"

start /B javaw -cp %CP% -Djava.util.logging.config.file="%DIRNAME%logging.properties" com.openbravo.pos.config.JFrmConfig
