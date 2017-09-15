//Nome: Lucas de Queiroz Silva e Silva
//DRE: 115197960



import java.math.BigInteger;

public class CalcRPN extends AbstractCalc
{
    
        public void igual()
    {
        p3 = p2;
        p2 = p1;
        p1 = p0;
        p0 = 0;
        display = BigInteger.valueOf(p0);
        obs.mudou(display);
    }
    
    
    
    public void soma()
    {
        troca = true;
        p0 += p1;
        p1 = p2;
        p2 = p3;
        p3 = 0;
        display = BigInteger.valueOf(p0);
        obs.mudou(display);
    }
    
    
    
    public void sub()
    {
        troca = true;
        p0 -= p1;
        p1 = p2;
        p2 = p3;
        p3 = 0;
        display = BigInteger.valueOf(p0);
        obs.mudou(display);
    }
    
    
    
    public void mult()
    {
        troca = true;
        p0 = p1 * p0;
        p1 = p2;
        p2 = p3;
        p3 = 0;
        display = BigInteger.valueOf(p0);
        obs.mudou(display);
    }
    
    
    
    public void div()
    {
        troca = true;
        if(p1==0){
            //erro
            p0 = 0;
            System.out.println("Erro. Divisão por zero");
        }
        
        else{
            p0 = p0 / p1;
            p1 = p2;
            p2 = p3;
            p3 = 0;
            display = BigInteger.valueOf(p0);
            obs.mudou(display);
        }
    }
}
