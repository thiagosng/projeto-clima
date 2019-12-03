package caruaru.pe.clima.transactions;

public interface Transaction {

    void execute() throws Exception;

    void updateView();
}
