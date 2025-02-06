@ECHO OFF

REM create bin directory if it doesn't exist
if not exist ..\bin mkdir ..\bin

REM delete output from previous run
del ACTUAL.TXT

REM compile the code into the bin folder
javac  -cp ..\src\main\java -Xlint:none -d ..\bin ..\src\main\java\*.java
IF ERRORLEVEL 1 (
    echo ********** BUILD FAILURE **********
    exit /b 1
)

REM run the program, feed commands from input.txt and redirect the output to the ACTUAL.TXT
java -classpath ..\bin Talko < input.txt > ACTUAL.TXT

REM compare the output to the expected output
FC ACTUAL.TXT EXPECTED.TXT

REM check if comparison was successful
IF ERRORLEVEL 1 (
    echo Test failed! There are differences between ACTUAL.TXT and EXPECTED.TXT.
) ELSE (
    echo Test passed! No differences found.
)

REM pause the script to view results
PAUSE
