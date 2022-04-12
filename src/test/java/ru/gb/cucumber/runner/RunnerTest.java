package ru.gb.cucumber.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"./src/test/java/ru/gb/cucumber/features"},
        glue = {"/src/test/java/ru/gb/cucumber/steps"})

public class RunnerTest extends AbstractTestNGCucumberTests {
}

