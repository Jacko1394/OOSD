#!/usr/bin/env bash

pwd
echo "Building..."
javac -d out/production/OOSD --module-path javafx-sdk-11.0.2/lib --add-modules=javafx.controls,javafx.fxml --add-modules javafx.base,javafx.graphics $(find . -name "*.java")
echo "Running..."
java --module-path javafx-sdk-11.0.2/lib --add-modules=javafx.controls,javafx.fxml --add-modules javafx.base,javafx.graphics -classpath out/production/OOSD:/javafx-sdk-11.0.2/lib/src.zip:/javafx-sdk-11.0.2/lib/javafx-swt.jar:/javafx-sdk-11.0.2/lib/javafx.web.jar:/javafx-sdk-11.0.2/lib/javafx.base.jar:javafx-sdk-11.0.2/lib/javafx.fxml.jar:javafx-sdk-11.0.2/lib/javafx.media.jar:javafx-sdk-11.0.2/lib/javafx.swing.jar:javafx-sdk-11.0.2/lib/javafx.controls.jar:javafx-sdk-11.0.2/lib/javafx.graphics.jar game.Application
