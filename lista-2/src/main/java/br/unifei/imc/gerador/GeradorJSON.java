package br.unifei.imc.gerador;

import br.unifei.imc.model.Pessoa;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeradorJSON implements GeradorArquivo{
    @Override
    public void gerarArquivo(List<Pessoa> pessoas) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(pessoas);

        try{
            FileWriter fw = new FileWriter("pessoas.json");
            fw.write(json);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
