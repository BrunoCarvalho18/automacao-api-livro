package br.com.automacaoapilivro.steps;

import com.google.gson.Gson;

import br.com.automacaoapilivro.pojos.Livro;
import br.com.automacaoapilivro.servicos.Resposta;
import br.com.automacaoapilivro.servicos.ServicosImpl;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;

public class CriarLivroSteps {
	
	Livro livro = new Livro();
	Gson gson = new Gson();
	ServicosImpl verbos = new ServicosImpl();
	Resposta validarAssercao = new Resposta();
	
	@Dado("que eu realize uma requisicao na API para criar o livro  {string}  {string}  {string}  {string}")
	public void que_eu_realize_uma_requisicao_na_api_para_criar_o_livro(String userId, String id, String title, String body) {
		livro.setUserId(userId);
		livro.setId(id);
		livro.setTitle(title);
		livro.setBody(body);
		String json = gson.toJson(livro);
		verbos.postEndPoint("http://jsonplaceholder.typicode.com/posts", json);
	}

	@Entao("a API me retorna o status code {int}")
	public void a_api_me_retorna_o_status_code(Integer statusCode) {
	    validarAssercao.getResposta().statusCode(statusCode).log().all();
	}

}
