package GameStop;

public interface IJoc {                               // interfata pentru clasa Joc
    void setNume(String _nume);
    String getNume();
    void setPublisher(String _publisher);
    String getPublisher();
    void setPret(int _pret);
    int getPret();
    String toString();
}
