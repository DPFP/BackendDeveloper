package JavaBasic.OOD.VIMEditor;

public interface Operator {
    void moveLeft(int n);
    void moveRight(int n);
    void replace(char c);
    void findToRight(char c);
    void findToLeft(char c);
}
