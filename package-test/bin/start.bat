@echo off
echo ========Begin to execute tools ========
java -jar ..\lib\${project.artifactId}-${project.version}.jar
echo ========Finish to execute tools ========
pause
