package project.ft.app.controller;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.ft.app.produto.DadosAtualizacaoProduto;
import project.ft.app.produto.DadosCadastroProduto;
import project.ft.app.produto.Produto;
import project.ft.app.produto.ProdutosRepository;

@RestController
//Mapeando HTTP requests
@RequestMapping("/produtos")

public class ProdutosController {
    
    @Autowired
    //Instancia repository para acesso ao datasource
    private ProdutosRepository repository; 

    //Mapeando método POST 
    @PostMapping
    @Transactional
    public void cadastrarProduto(@RequestBody DadosCadastroProduto dados ){
        //Salvando/Criando novo produto com os dados de cadastro recebidos
        repository.save(new Produto(dados));
    }

    //Mapeando metódo GET 
    @GetMapping
    public List<Produto> listarProduto(){
        //Retornando lista de produtos localizados no datasource
        return repository.findAll(); 
    }

    //Mapeando método PUT
    @PutMapping
    @Transactional
    public void atualizarProdutos(@RequestBody DadosAtualizacaoProduto dados){
        //Variavel do tipo produto que tem acesso ao método getReferenceById passando o id dos dados recebidos
        var produto = repository.getReferenceById(dados.id());
        //Método atualizar produtos passando novos dados e os inserindo no datasource 
        produto.atualizarProdutos(dados); 
    }

    //Mapendo método DELETE por id na url 
    @DeleteMapping("/{id}")
    @Transactional
    public void deletarProdutos(@PathVariable Long id){
        //Deletando produto do datasource pelo id recebido 
        repository.deleteById(id);  
    }
}
