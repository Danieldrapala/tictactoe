package tictactoe;
import java.util.Scanner;

public class Main {
        char[][] actualMap = new char[3][3];
        Scanner myObj;
        
        public Main(Scanner myObj){
            this.myObj = myObj;
        }


        private void initMap(){
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                this.actualMap[i][j] = ' ';
             }
        }
        }
        
 
        
        private void updateMap(int row, int col, char player){
            this.actualMap[row-1][col-1] = player;
        }
        
        private void printBoard(){
            System.out.println();
            System.out.println("---------");
            for(int i=0; i<3; i++){
                System.out.println("| " + this.actualMap[i][0] +" "+ this.actualMap[i][1] + " " + this.actualMap[i][2] +" |");
            }
            System.out.println("---------");
        }
        
        public void progressUserInput(char player){
            boolean repeat = true;
            while(repeat){
                System.out.print("Enter the coordinates:");
                String playerMove = myObj.nextLine();
            
                int[] coordinates = new int[2];
                try{
                    System.out.println(playerMove.charAt(0)+" " + playerMove.charAt(2));
                    coordinates[0] = Integer.parseInt(String.valueOf(playerMove.charAt(0)));
                    coordinates[1] = Integer.parseInt(String.valueOf( playerMove.charAt(2)));
                    
                    if(coordinates[0] < 0 || coordinates[0] > 3 ||  coordinates[1] < 0 || coordinates[1] > 3){
                        System.out.println("Coordinates should be from 1 to 3!");
                        continue;
                    }
                    if(this.actualMap[coordinates[0]-1][coordinates[1]-1]==' ')
                    {
                        updateMap(coordinates[0],coordinates[1], player);
                        repeat = false;
                        continue;
                    }
                    else{
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                }
                catch(Exception ex){
                    System.out.println("You should enter numbers!");
                    continue;
                }
                
            }
        }
        
        private boolean checkWinCondition(char[][] map){
            int xs = 0;
        int os = 0;
        boolean impossible = false;
        boolean owin = false;
        boolean xwin = false;
        boolean draw = false;
    
        for(int i = 0; i < 3; i++){
            for(int j = 0; j<3; j++){
                if(map[i][j]=='O')
                    os++;
                if(map[i][j]=='X')
                    xs++;
        }
        }
        if (Math.abs(xs - os) > 1){
            impossible = true;
        }
        
        if(map[0][0] + map[0][1] + map[0][2] == 264 
        || map[0][0] + map[1][0] + map[2][0] == 264 
        || map[0][0] + map[1][1] + map[2][2] == 264
        || map[0][1] + map[1][1] + map[2][1] == 264 
        || map[0][2] + map[1][2] + map[2][2] == 264 
        || map[1][0] + map[1][1] + map[1][2] == 264
        || map[2][0] + map[2][1] + map[2][2] == 264 
        || map[0][2] + map[1][1] + map[2][0] == 264)
        {
            xwin = true;
        }
        if(map[0][0] + map[0][1] + map[0][2] == 237 
        || map[0][0] + map[1][0] + map[2][0] == 237 
        || map[0][0] + map[1][1] + map[2][2] == 237
        || map[0][1] + map[1][1] + map[2][1] == 237 
        || map[0][2] + map[1][2] + map[2][2] == 237 
        || map[1][0] + map[1][1] + map[1][2] == 237
        || map[2][0] + map[2][1] + map[2][2] == 237 
        || map[0][2] + map[1][1] + map[2][0] == 237)
        {
            owin = true;
        }
        
        if(os+xs==9){
            draw = true;
        }
        else{
            draw = false;
        }
        if(!impossible){
            if(xwin){       
                if(owin){
                    System.out.println("Impossible");
                    return true;
                }
                System.out.println("X wins");
                return true;
                }
            else {
                if(owin){
                    System.out.println("O wins");
                    return true;
                }
                else{
                    if(draw){
                        System.out.println("Draw");
                        
                    }
                    else{
                        return false;
                    }
                    return true;

                }
            }
        }
        else{
            System.out.println("Impossible");
            return true;
        }
        }
        

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        Main game = new Main(myObj);
        game.initMap();
        game.printBoard();
        boolean winner = false;
        char player = 'X';
        while(!winner){
            game.progressUserInput(player);
            game.printBoard();   
            player = player =='X' ? 'O' : 'X';   
            winner = game.checkWinCondition(game.actualMap);
        }

    }
}