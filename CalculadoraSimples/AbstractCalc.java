//Nome: Lucas de Queiroz Silva e Silva
//DRE: 115197960



import java.math.BigInteger;

public abstract class AbstractCalc implements Calc
{
    ObservadorBigInteger obs;
    boolean troca=false;
    int p0 = 0;
    int p1 = 0;
    int p2 = 0;
    int p3 = 0;
    BigInteger display = BigInteger.valueOf(0);
    BigInteger memoria = BigInteger.valueOf(0);
    
    
    public void digito(int i) {
        if(troca) {
            this.p0 = i;
            this.display = BigInteger.valueOf(i);
            this.troca = false;
        }
        
        
        
        else {
            this.p0 = 10*this.p0 + i;
            this.display = BigInteger.valueOf(p0);
        }
        obs.mudou(display);
    }
    
    

    public void memRecall()
    {
        this.p0 = this.memoria.intValue();
        this.display = this.memoria;
        this.obs.mudou(this.display);
    }
        
        

    public void memPlus()
    {
        this.memoria = memoria.add(display);
        this.p0 = 0;
    }

    
    
    public void memSub()
    {
        this.memoria = memoria.subtract(this.display);
        this.p0 = 0;
    }
    
    

    public void memClear()
    {
        this.memoria = BigInteger.valueOf(0);
    }
    
    

    public void reset()
    {
        this.p0 = 0;
        this.p1 = 0;
        this.p2 = 0;
        this.p3 = 0;
        this.troca = false;
        this.display = BigInteger.valueOf(0);
        this.obs.mudou(this.display);
    }
    
    

    public void setObservador(ObservadorBigInteger obs)
    {
        this.obs = obs;
    }
}
