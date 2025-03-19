#!/bin/sh

# Utilize of the shell 'sh' compliant with the POSIX standard;
# conversion of the characters '[[' and ']]' to be compliant
# with the standard

#Configuring the environment:
#CWD = path of the script, the directory where the Bash script is located
#CWD = /app/Serv
CWD="$(cd "$(dirname "$0")" && pwd)"

CLASS_UT_CLASSPATH=$1
CLASS_UT_NAME=$2
CLASS_UT_PACKAGE_NAME=$3
TESTS_CLASSPATH=$4
EVOSUITE_WORKING_DIR=$5

echo "Configuring the environment...\n\n"
echo "CWD: $CWD"
echo "Percorso Classe UT: $CLASS_UT_CLASSPATH"
echo "Nome Classe UT: $CLASS_UT_NAME"
echo "Percorso Test: $TESTS_CLASSPATH"
echo "EvoSuite working directory: $EVOSUITE_WORKING_DIR"

cp -r $CWD/evosuite-1.0.6.jar $EVOSUITE_WORKING_DIR/
cp -r $CWD/evosuite-standalone-runtime-1.0.6.jar $EVOSUITE_WORKING_DIR/
cp -r $CWD/pom.xml $EVOSUITE_WORKING_DIR/

cd $EVOSUITE_WORKING_DIR

export EVOSUITE="java -jar $(pwd)/evosuite-1.0.6.jar"

mvn clean install

echo "Let's execute the tests...\n\n"

mvn dependency:copy-dependencies

export CLASSPATH=target/classes:evosuite-standalone-runtime-1.0.6.jar:target/test-classes:target/dependency/junit-4.13.1.jar:target/dependency/hamcrest-core-1.3.jar

sleep 2

#TEST_CLASSES=$(find $EVOSUITE_WORKING_DIR/target/test-classes -name "*.class" | sed 's|.*/||' | sed 's|.class$||' | paste -sd ',')
#echo $TEST_CLASSES
#PREFIX=${TEST_PACKAGE_NAME:-Test}

$EVOSUITE -measureCoverage -class $CLASS_UT_PACKAGE_NAME$CLASS_UT_NAME -projectCP $EVOSUITE_WORKING_DIR/target/classes:$EVOSUITE_WORKING_DIR/target/test-classes -Dcriterion=LINE > /dev/null 2>&1
$EVOSUITE -measureCoverage -class $CLASS_UT_PACKAGE_NAME$CLASS_UT_NAME -projectCP $EVOSUITE_WORKING_DIR/target/classes:$EVOSUITE_WORKING_DIR/target/test-classes -Dcriterion=LINE > /dev/null 2>&1
$EVOSUITE -measureCoverage -class $CLASS_UT_PACKAGE_NAME$CLASS_UT_NAME -projectCP $EVOSUITE_WORKING_DIR/target/classes:$EVOSUITE_WORKING_DIR/target/test-classes -Dcriterion=BRANCH > /dev/null 2>&1
$EVOSUITE -measureCoverage -class $CLASS_UT_PACKAGE_NAME$CLASS_UT_NAME -projectCP $EVOSUITE_WORKING_DIR/target/classes:$EVOSUITE_WORKING_DIR/target/test-classes -Dcriterion=EXCEPTION > /dev/null 2>&1
$EVOSUITE -measureCoverage -class $CLASS_UT_PACKAGE_NAME$CLASS_UT_NAME -projectCP $EVOSUITE_WORKING_DIR/target/classes:$EVOSUITE_WORKING_DIR/target/test-classes -Dcriterion=WEAKMUTATION > /dev/null 2>&1
$EVOSUITE -measureCoverage -class $CLASS_UT_PACKAGE_NAME$CLASS_UT_NAME -projectCP $EVOSUITE_WORKING_DIR/target/classes:$EVOSUITE_WORKING_DIR/target/test-classes -Dcriterion=OUTPUT > /dev/null 2>&1
$EVOSUITE -measureCoverage -class $CLASS_UT_PACKAGE_NAME$CLASS_UT_NAME -projectCP $EVOSUITE_WORKING_DIR/target/classes:$EVOSUITE_WORKING_DIR/target/test-classes -Dcriterion=METHOD > /dev/null 2>&1
$EVOSUITE -measureCoverage -class $CLASS_UT_PACKAGE_NAME$CLASS_UT_NAME -projectCP $EVOSUITE_WORKING_DIR/target/classes:$EVOSUITE_WORKING_DIR/target/test-classes -Dcriterion=METHODNOEXCEPTION > /dev/null 2>&1
$EVOSUITE -measureCoverage -class $CLASS_UT_PACKAGE_NAME$CLASS_UT_NAME -projectCP $EVOSUITE_WORKING_DIR/target/classes:$EVOSUITE_WORKING_DIR/target/test-classes -Dcriterion=CBRANCH > /dev/null 2>&1

sleep 2

echo "Saving staistics to $TESTS_CLASSPATH/GameData.csv\n\n"
cp -f evosuite-report/statistics.csv $TESTS_CLASSPATH/statistics.csv

