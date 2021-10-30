package GameStop;

public class Joc implements IJoc {


    private String nume;
    private String publisher;
    private int pret;
    public Joc()
    {
        this.nume="Undefined";
        this.publisher="Undefined";
        this.pret=-1;
    }

    public Joc (String nume, String publisher, int pret)
    {
        this.nume=nume;
        this.publisher=publisher;
        this.pret=pret;
    }

    public void setNume(String _nume)
    {
        this.nume=_nume;
    }
    public String getNume()
    {
        return nume;
    }
    public void setPublisher(String _publisher)
    {
        this.publisher=_publisher;
    }
    public String getPublisher()
    {
        return publisher;
    }
    public void setPret(int _pret)
    {
        this.pret=_pret;
    }
    public int getPret()
    {
        return pret;
    }
    public String toString()
    {
        StringBuffer sb=new StringBuffer();
        sb.append("Joc: ");
        sb.append(nume);
        sb.append(" publisher: ");
        sb.append(publisher);
        sb.append(" pret: ");
        sb.append(pret);
        return sb.toString();

    }



}
