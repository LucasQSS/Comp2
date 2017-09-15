/*
 * Autor:Lucas de Queiroz Silva e Silva
 */



public class Carro
{
    private double x;
    private double y;
    private double vel;
    private Cor color = new Cor(Math.random(), Math.random(), Math.random());
    private int weight;
    private int height = 100;
    private Hitbox hitbox;

    public Carro(double x, double y, double vel, int weight)
    {
        this.x = x;
        this.y = y;
        this.vel = vel;
        this.weight = weight;

        this.hitbox = new Hitbox(this.x, this.y, this.x + this.weight, this.y + this.height);
    }

    public void draw(Tela canvas)
    {
        canvas.retangulo(this.x, this.y, this.weight, this.height, this.color);
    }

    public void move(double dTime)
    {
        this.x += this.vel * dTime;
        if(this.x >= Jogo.getLargura() + this.weight){
            this.x = - this.weight;
        }

        this.adjustHitbox();
    }

    public Hitbox getHitbox()
    {
        return this.hitbox;
    }

    private void adjustHitbox(){
        this.hitbox = new Hitbox(this.x, this.y, this.x + this.weight, this.y + this.height);
    }
}
