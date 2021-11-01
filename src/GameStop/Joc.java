package GameStop;

public class Joc extends Program implements IJoc {              // clasa joc, mosteneste clasa abstracta Program si implementeaza interfata Joc


    private String nume;
    private String publisher;
    private int pret;
    public Joc()                // constructor default
    {
        this.nume="Undefined";
        this.publisher="Undefined";
        this.pret=-1;
    }

    public Joc (String nume, String publisher, int pret)            // constructor cu parametrii
    {
        this.nume=nume;
        this.publisher=publisher;
        this.pret=pret;
    }

    public void setNume(String _nume)           //metoda pt setarea numelui
    {
        this.nume=_nume;
    }
    public String getNume()
    {
        return nume;
    }   //metoda pentru returnarea numelui
    public void setPublisher(String _publisher)
    {
        this.publisher=_publisher;
    }       //metoda pentru setarea publisherului
    public String getPublisher()
    {
        return publisher;
    }   //metoda pentru returnarea Publisherului
    public void setPret(int _pret)
    {
        this.pret=_pret;
    }  //metoda pentru setarea pretului
    public int getPret()
    {
        return pret;
    }       //metoda pentru returnarea pretului
    public String toString()        //metoda toString
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
    public void Run(){
        System.out.println("Game is running!");
    }




}
