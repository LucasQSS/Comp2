/*
 * Autor:Lucas de Queiroz Silva e Silva
 */



public class Sapo
{

/*	
	xi, yi = coord. inicial	
	xf, yf = coord. final	
*/


    private double xi;
    private double yi;
    private double xf;
    private double yf;
    private double velX = 87.5;
    private double velY = 100;
    private Cor cor;
    public static int raio = 45;

    public Sapo(double x, double y, Cor cor)
    {
        this.xi = x;
        this.xf = x;
        this.yi = y;
        this.yf = y;
        this.cor = cor;
    }

    public void draw(Tela canvas)
    {
        canvas.circulo(this.xi, this.yi, raio, this.cor);
    }

    public void goUp()
    {
        this.yf -= this.velY;
        if(this.yf <= - raio){
            this.yf += this.velY;
        }
    }

    public void goDown()
    {
        this.yf += this.velY;
        if (this.yf >= Jogo.getAltura() - raio) {
            this.yf -= this.velY;
        }
    }

    public void goLeft()
    {
        this.xf -= this.velX;
    }

    public void goRight()
    {
        this.xf += this.velX;
    }

    public void move(double dTime)
    {
        if(this.xi < this.xf){
            this.xi += 300 * dTime;
            if(this.xf > Jogo.getLargura() + raio){
                this.xi -= Jogo.getLargura();
                this.xf -= Jogo.getLargura();
            }
        }
        if(this.xi > this.xf){
            this.xi -= 300 * dTime;
            if(this.xf <  - raio){
                this.xi += Jogo.getLargura();
                this.xf += Jogo.getLargura();
            }
        }

        if(this.yi < this.yf) this.yi += 300 * dTime;
        if(this.yi > this.yf) this.yi -= 300 * dTime;
    }

    public Hitbox getHitbox()
    {
        return new Hitbox(this.xi - raio, this.yi - raio, this.xi + raio, this.yi + raio);
    }

    public double getXi()
    {
        return xi;
    }

    public double getYi()
    {
        return yi;
    }

    public double getXf()
    {
        return xf;
    }

    public double getYf()
    {
        return yf;
    }

    public void setXi(double xi)
    {
        this.xi = xi;
    }

    public void setYi(double yi)
    {
        this.yi = yi;
    }
}
