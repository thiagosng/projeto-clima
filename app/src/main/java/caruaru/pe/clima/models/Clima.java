package caruaru.pe.clima.models;

public class Clima {

    private String cidade;
    private String temperatura;
    private String temperaturaMaxima;
    private String temperaturaMinima;
    private String humidade;
    private String descricao;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(String temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public String getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(String temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public String getHumidade() {
        return humidade;
    }

    public void setHumidade(String humidade) {
        this.humidade = humidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}


