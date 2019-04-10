#!/usr/bin/env bash

pwd
echo "Building..."
javac -d out/production/OOSD --module-path javafx-sdk-12/lib --add-modules=javafx.controls,javafx.fxml --add-modules javafx.base,javafx.graphics $(find . -name "*.java")
echo "Running..."
java --module-path javafx-sdk-12/lib --add-modules=javafx.controls,javafx.fxml --add-modules javafx.base,javafx.graphics game.Application
