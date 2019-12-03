package caruaru.pe.clima.request;

import caruaru.pe.clima.models.Clima;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class ClimaDeserializer implements JsonDeserializer<Clima>{

    @Override
    public Clima deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        Clima item = null;
        if(json.isJsonObject()){
            item = new Clima();

            JsonObject obj = json.getAsJsonObject();

            JsonObject main = obj.get("main").getAsJsonObject();
            JsonObject weather = obj.get("weather").getAsJsonArray().get(0).getAsJsonObject();

            item.setCidade(obj.get("name").toString());
            item.setTemperatura(main.get("temp").toString());
            item.setTemperaturaMaxima(main.get("temp_max").toString());
            item.setTemperaturaMinima(main.get("temp_min").toString());
            item.setHumidade(main.get("humidity").toString());
            item.setDescricao(weather.get("description").toString());



        }

        return item;
    }

}
