package GameStop;

public class Magazin extends Joc{       //clasa Magazin, mosteneste clasa joc
    private boolean stock;
    private static boolean IN_STOCK=true;       //constante de tip boolean
    private static boolean OUT_STOCK=false;
    private int ID;
    private Joc joc;
    public Magazin(Joc joc, Boolean stock, int ID)      // constructor cu parametrii
    {
        this.ID=ID;
        this.stock=stock;
        this.joc=joc;
    }

    public Magazin()            // constructor default
    {
        this.ID=-1;
        this.stock=false;
        this.joc=new Joc();
    }
    @Override
    public String toString()            //suprascrierea metodei toString a clasei Joc
    {
        String sr=joc.toString();
        sr+=" ID: ";sr+=ID;sr+=" in stock: ";
        if(stock==IN_STOCK)
        sr+=" da";
        else
            sr+=" nu";
        return sr;
    }

    @Override                           //suprascrierea metodei Run a clasei joc
    public void Run() {
        super.Run();            // folosirea metodei super pentru a afisa "Game is running"
        System.out.println("Store is staying");         //)))))
    }
}
