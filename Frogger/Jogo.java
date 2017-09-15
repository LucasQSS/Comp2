/*
 * Autor:Lucas de Queiroz Silva e Silva
 */



import java.util.HashSet;

public class Jogo
{

    private Sapo kermit;
    private Carro[] rua1;
    private Carro[] rua2;
    private Carro[] rua3;
    private Carro[] rua4;
    private int vidas;
    private int pontos;
    private int pontosf;
    private boolean gameOver;

    public Jogo()
    {
        this.reset();

        this.rua1 = new Carro[2];
        this.rua2 = new Carro[1];
        this.rua3 = new Carro[3];
        this.rua4 = new Carro[3];

        for(int i = 0; i < rua1.length; i++){
            rua1[i] = new Carro((i * 275), 100, 150, 100);
        }

        for(int i = 0; i < rua2.length; i++){
            rua2[i] = new Carro((i * 175), 200, 350, 150);
        }

        for(int i = 0; i < rua3.length; i++){
            rua3[i] = new Carro((i * 175), 300, 100, 60);
        }

        for(int i = 0; i < rua4.length; i++){
            rua4[i] = new Carro((i * 175), 400, 135, 60);
        }
    }

    private void reset()
    {
        kermit = new Sapo(getLargura() / 2, getAltura() - getAltura() / 6 + Sapo.raio + 5, new Cor(0, 255, 0));
        gameOver = false;
        vidas = 3;
	pontosf = 0;
	pontos = 0;



    }

    public String getTitulo()
    {
        return "Frogger";
    }

    public static int getLargura()
    {
        return 800;
    }

    public static int getAltura()
    {
        return 600;
    }

    public void tique(HashSet<String> teclas, double dt)
    {

        if((kermit.getYf() != kermit.getYi() || kermit.getXf() != kermit.getXi()) && !gameOver)
            kermit.move(dt);

        if(gameOver){
            kermit.setXi(-666);
            kermit.setYi(-666);
        }

        Carro streets[][] = {this.rua1, this.rua2, this.rua3, this.rua4};
        for(Carro street[]: streets) {
            for (Carro car : street) {
                car.move(dt);
            }
        }

        this.checkCollideFrogCar();
	this.contaPontos();
    }

    private void checkCollideFrogCar()
    {
        Carro ruas[][] = {this.rua1, this.rua2, this.rua3, this.rua4};
        for(Carro rua[]: ruas){
            for(Carro car: rua){
                if(this.kermit.getHitbox().intersecao(car.getHitbox())){
                    this.vidas -= 1;
		    this.pontos = 0;
                    if(this.vidas < 0){
                        this.gameOver = true;
                    } else {
                        this.kermit = new Sapo(getLargura() / 2, getAltura() - getAltura() / 6 + Sapo.raio + 5, new Cor(0, 255, 0));
                    }
                }
            }
        }
    }

    private void contaPontos()
    {
	if(kermit.getYf() != kermit.getYi() && kermit.getYf() < kermit.raio + 20 && pontos%2 == 0)
	{
		pontos++;		
		pontosf++;
	}
	if(kermit.getYf() != kermit.getYi() && kermit.getYf() > (getAltura() - kermit.raio - 20) && pontos%2 != 0)
	{
		pontos++;
		pontosf++;
	}
    }

    public void desenhar(Tela tela)
    {
        tela.retangulo(0, 0, getLargura(), getAltura() / 6, new Cor(100, 100, 100));
        tela.retangulo(0, getAltura() - getAltura() / 6, getLargura(), getAltura() / 6, new Cor(100, 100, 100));
        tela.texto("" + this.pontosf, 20, getAltura() - getAltura() / 6 + 60, 60, new Cor(0, 0, 255));
	if(vidas > 0)
	{
		tela.texto("" + this.vidas, getLargura() - 60, getAltura() - getAltura() / 6 + 60, 60, new Cor(0, 0, 255));
	}
	else
	{
		tela.texto("0", getLargura() - 60, getAltura() - getAltura() / 6 + 60, 60, new Cor(0, 0, 255));
	}


        Carro streets[][] = {this.rua1, this.rua2, this.rua3, this.rua4};
        for(Carro street[] : streets){
            for(Carro car : street){
                car.draw(tela);
            }
        }

        if(gameOver)
	{ 
		tela.texto("Game Over", getLargura() / 2 - 290, getAltura() / 2, 90, new Cor(0, 0, 255));
		tela.texto("press enter to restart", getLargura() / 2 - 120, getAltura() - 10, 20, new Cor(0, 0, 255));
	}
       else kermit.draw(tela);
    }


    public void tecla(String tecla)
    {
        if (tecla.equals("left")) kermit.goLeft();
        if (tecla.equals("right")) kermit.goRight();
        if (tecla.equals("up")) kermit.goUp();
        if (tecla.equals("down")) kermit.goDown();

        if (tecla.equals("enter")) this.reset();
    }

    public static void main(String[] args)
    {
        new Motor(new Jogo());
    }
}
