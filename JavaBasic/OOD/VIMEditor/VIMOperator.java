package JavaBasic.OOD.VIMEditor;

import JavaBasic.OOD.GameOfLife.ConsoleColors;

public class VIMOperator implements Operator{
    private int cursorIndex;
    private String line;
    private char lastCommand;

    public VIMOperator(String line) {
        this.cursorIndex = 0;
        this.line = line;
    }

    @Override
    public void moveLeft(int n) {
        if(cursorIndex - n < 0){
            cursorIndex = 0;
        }else{
            cursorIndex = cursorIndex - n;
        }
        System.out.println("Cursor now at index: " + cursorIndex );
        showCurrent();
    }

    @Override
    public void moveRight(int n) {
        if(cursorIndex + n > line.length() - 1){
            cursorIndex = line.length() - 1;
        }else{
            cursorIndex = cursorIndex + n;
        }
        System.out.println("Cursor now at index: " + cursorIndex );
        showCurrent();
    }

    @Override
    public void replace(char c) {
        line = line.substring(0,cursorIndex) + c + line.substring(cursorIndex+1);
        System.out.println("Current line after replace: " + line);
        showCurrent();
    }

    @Override
    public void findToRight(char c) {
        //set cursor to the place where c at
        //what happen if not found ? nothing change
        lastCommand = 'f';
        for(int i=cursorIndex; i<line.length(); i++){
            if(c == line.charAt(i)){
                cursorIndex = i;
                System.out.println("Find character to right " + c + " At " + cursorIndex);
                break;
            }
        }
        showCurrent();
    }

    @Override
    public void findToLeft(char c) {
        //set cursor to the place
        lastCommand = 'F';
        for(int i=cursorIndex; i>=0 ; i--){
            if(c == line.charAt(i)){
                cursorIndex = i;
                System.out.println("Find character to left " + c + " At " + cursorIndex);
                break;
            }
        }
        showCurrent();
    }

    //TODO add ;  (keep going for f/F)

    //TODO add ,  (reverse/Undo)

    //TODO handle # h/l (move cursor multiple # times)

    private void showCurrent(){
        for(int i =0;i<line.length(); i++){
            if(i == cursorIndex){
                System.out.print(ConsoleColors.GREEN_BACKGROUND_BRIGHT + line.charAt(i) + ConsoleColors.RESET);
            }else{
                System.out.print(line.charAt(i));
            }
        }
        System.out.println();
    }

}
