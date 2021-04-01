package br.com.automacaoapilivro.steps;

import com.google.gson.Gson;
import br.com.automacaoapilivro.core.PDFGenerator;
import br.com.automacaoapilivro.pojos.Livro;
import br.com.automacaoapilivro.servicos.Resposta;
import br.com.automacaoapilivro.servicos.ServicosImpl;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;

public class CriarLivroSteps {

	Livro livro = new Livro();
	Gson gson = new Gson();
	ServicosImpl verbos = new ServicosImpl();
	Resposta validarAssercao = new Resposta();
	PDFGenerator pdfgenerator = new PDFGenerator();
	Resposta resposta;
	Scenario scen;

	@Before(value = "@criarlivro")
	public void before(Scenario cenario) throws Exception {
		pdfgenerator.iniciaPDF(cenario);

	}

	@Dado("^que eu realize uma requisicao na API para criar o livro  \"([^\"]*)\"  \"([^\"]*)\"  \"([^\"]*)\"  \"([^\"]*)\"$")
	public void que_eu_realize_uma_requisicao_na_API_para_criar_o_livro(String userId, String id, String title,
			String body) throws Throwable {
		livro.setUserId(userId);
		livro.setId(id);
		livro.setTitle(title);
		livro.setBody(body);
		String json = gson.toJson(livro);
		resposta = verbos.postEndPoint("http://jsonplaceholder.typicode.com/posts", json);
		pdfgenerator.conteudoPDF("que eu realize uma requisicao na api para criar o livro", resposta.logarEvidencia());
	}

	@Entao("^a API me retorna o status code (\\d+)$")
	public void a_API_me_retorna_o_status_code(Integer statusCode) throws Throwable {
		resposta.getResposta().statusCode(statusCode);
		String texto = Integer.toString(resposta.getResponse().getStatusCode());
		pdfgenerator.conteudoPDF("a API me retorna a API me retorna:", "o status da resposta é: " + texto);
	}

	@After(value = "@criarlivro")
	public void finalizaPDF(Scenario cenario) throws Exception {
		scen = cenario;
		pdfgenerator.fechaPDF(scen);
	}

}
