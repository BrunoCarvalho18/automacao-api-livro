package br.com.automacaoapilivro.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(glue = { "br.com.automacaoapilivro.steps" }, features = {"src/test/resources/br/com/automacaolivro/feature" }, tags = "@geral")
public class ApiRunner {

}
