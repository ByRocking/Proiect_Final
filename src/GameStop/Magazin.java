package GameStop;

public class Magazin extends Joc{
    private boolean stock;
    private static boolean IN_STOCK=true;
    private static boolean OUT_STOCK=false;
    private int ID;
    private Joc joc;
    public Magazin(Joc joc, Boolean stock, int ID)
    {
        this.ID=ID;
        this.stock=stock;
        this.joc=joc;
    }

    public Magazin()
    {
        this.ID=-1;
        this.stock=false;
        this.joc=new Joc();
    }
    @Override
    public String toString()
    {
        String sr=joc.toString();
        sr+=" ID: ";sr+=ID;sr+=" in stock: ";
        if(stock==IN_STOCK)
        sr+=" da";
        else
            sr+=" nu";
        return sr;
    }

    @Override
    public void Run() {
        super.Run();
        System.out.println("Store is staying");         //)))))
    }
}
