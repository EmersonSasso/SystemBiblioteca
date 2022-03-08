/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Usuário
 */
public class CallAPI {

    public JSONObject callapi(String tipo, String dado) {
        JSONObject jsonObject = null;
        //Cria o parse de tratamento
        JSONParser parser = new JSONParser();
        //Variaveis que irao armazenar os dados do arquivo JSON
        try {                                               //9788520938393.json
//            URL url = new URL("https://openlibrary.org/isbn/9780140328721.json");
            URL url = new URL("https://openlibrary.org/" + tipo + "/" + dado + ".json");
            BufferedReader leitorArquivo = new BufferedReader(new InputStreamReader(url.openStream()));
            jsonObject = (JSONObject) parser.parse(leitorArquivo.readLine());
        } catch (IOException | ParseException ex) {
            Logger.getLogger(CallAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonObject;
    }
}
