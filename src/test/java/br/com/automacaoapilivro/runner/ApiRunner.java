package br.com.automacaoapilivro.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(glue = { "br.com.automacaoapilivro.steps" }, features = {"src/test/resources/br/com/automacaolivro/feature" }, tags = "@geral")
public class ApiRunner {

}
