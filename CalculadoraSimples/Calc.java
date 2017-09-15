public interface Calc {
    void digito(int i);
    void soma();
    void sub();
    void mult();
    void div();
    void igual();
    void reset();
    void setObservador(ObservadorBigInteger obs);
    void memRecall();
    void memPlus();
    void memSub();
    void memClear();
}