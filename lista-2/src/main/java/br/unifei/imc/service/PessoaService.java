package br.unifei.imc.service;
import br.unifei.imc.exceptions.OpcaoErradaException;
import br.unifei.imc.gerador.GeradorCSV;
import br.unifei.imc.gerador.GeradorJSON;
import br.unifei.imc.model.Pessoa;
import java.util.ArrayList;
import java.util.List;

public class PessoaService {
    List<Pessoa> pessoas = new ArrayList<>();

    public void gerarMapaPessoa(){
        pessoas.add(new Pessoa(1,"Guts",39));
        pessoas.add(new Pessoa(2,"Casca",30));
        pessoas.add(new Pessoa(3,"Andreas",60));
    }

    public void gerarArquivo(OpcaoArquivo op){
        this.pessoas.clear();
        this.gerarMapaPessoa();

        GeradorCSV csv = new GeradorCSV();
        GeradorJSON json = new GeradorJSON();
        if (op == OpcaoArquivo.CSV){
           csv.gerarArquivo(this.pessoas);
        }else if (op == OpcaoArquivo.JSON){
            json.gerarArquivo(this.pessoas);

        }else throw new OpcaoErradaException("");
    }

}
