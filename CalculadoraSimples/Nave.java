public class Nave implements App {
    double x, y;
    double dir;
    
    boolean arrastando;
    double x1, y1;
    
    public Nave(double _x, double _y) {
        x = _x;
        y = _y;
        dir = 0;
    }
    
    public String getTitulo() { return "Nave"; }
    
    public int getLargura() { return 800; }
    
    public int getAltura() { return 600; }
    
    public void tique(java.util.Set<String> teclas, double dt) {
        dir = dir + 0.4 * Math.PI * dt;
    }
    
    public void tecla(String tecla) {}
    
    public void desenhar(Tela t) {
        // (20,0)
        double x1 = 20 * Math.cos(dir) + x;
        double y1 = 20 * Math.sin(dir) + y;
        // (-12, -12)
        double x2 = -12 * Math.cos(dir) + 12 * Math.sin(dir) + x;
        double y2 = -12 * Math.cos(dir) - 12 * Math.sin(dir) + y;
        // (-12, 12)
        double x3 = -12 * Math.cos(dir) - 12 * Math.sin(dir) + x;
        double y3 = 12 * Math.cos(dir) - 12 * Math.sin(dir) + y;
        t.triangulo(x1, y1, x2, y2, x3, y3, Cor.BRANCO);
    }
    
    public void movimento(int x, int y) {}
    
    public void arrasto(int x, int y) {
        if(arrastando) {
            double dx = x - x1;
            double dy = y - y1;
            this.x = this.x + dx;
            this.y = this.y + dy;
            x1 = x;
            y1 = y;
        }
    }

    public void clique(int x, int y) {}
    
    public void aperto(int x, int y) {
        if(x < this.x + 12 && x > this.x - 12 &&
           y < this.y + 12 && y > this.y - 12) {
          arrastando = true;
          x1 = x;
          y1 = y;
        }
    }
    
    public void solta(int x, int y) {
        arrastando = false;
    }
    
}