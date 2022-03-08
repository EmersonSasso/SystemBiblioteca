/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 *
 * @author Hemerson mendes
 */
import org.json.simple.JSONObject;

public class Json {

    public String ReadJson(JSONObject jsonObject, String campo) {
        return jsonObject.get(campo).toString();
    }

}
