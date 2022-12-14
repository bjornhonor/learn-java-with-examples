package br.unifei.imc.gerador;

import br.unifei.imc.model.Pessoa;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeradorCSV implements GeradorArquivo{
    @Override
    public void gerarArquivo(List<Pessoa> pessoas) {

//        FileWriter arquivo;
        try {
            FileWriter arquivo = new FileWriter("pessoas.csv");

            CSVWriter writer = new CSVWriter(arquivo);

            String[] cabecalho = {"Id","Nome","Idade"};
            writer.writeNext(cabecalho);

            pessoas.forEach( p -> {
                String[] dado = {p.getId().toString(),p.getNome(),p.getIdade().toString()};
                writer.writeNext(dado);
            });
//          precisou dessas duas linhas abaixo. Sem elas não funcionou no meu pc
            writer.flush();
            writer.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
