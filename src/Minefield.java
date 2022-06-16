
import java.util.Scanner;

public class Minefield{

    int[][] field;
    int n;

    public Minefield(int n)
    {
        this.n = n;
        this.field = new int[n][n];
    }

    public int[][] createField()
    {
        int i = 0, j = 0;
        for(; i < n; i+=1)
        {
            for(; j < n; j+=1)
            {
                this.field[i][j] = 0;
            }
        }

        return field;
    }

    public void printField(int[][] field)
    {
        for(int i = 0; i < this.n; i+=1)
        {
            for(int j = 0; j < this.n; j+=1)
            {
                if(this.field[i][j] == -1 || this.field[i][j] == 0)
                {
                    System.out.printf("*   ");
                }
                else if(this.field[i][j] == -2)
                {
                    System.out.printf("0   ");
                }
                else System.out.printf("%s   ", this.field[i][j]);
            }

            System.out.println();
        }

        System.out.println();
    }

    public void randomMines(int[][] field)
    {
        for(int i=0;i<this.n;i++){
            while(true){
                int a=(int)(Math.random() * this.n);
                int b=(int)(Math.random() * this.n);
                if(field[a][b]!=-1)
                {
                    field[a][b]= -1;
                    break;
                }
            }
        }    
    }

    public int numberOfMines(int row, int col)
    {
        int counter = 0;
        int left = col-1, right = col+1, up = row - 1, down = row + 1;

        if(left == -1);
        else if (this.field[row][left] == -1)
             counter += 1;

        if(right == this.n);
        else if(this.field[row][right] == -1)
        counter += 1;

        if(up==-1);
        else if(this.field[up][col] == -1)
        counter += 1;

        if(down==this.n);
        else if(this.field[down][col] == -1)
        counter += 1;

        if(down == this.n || left ==-1);
        else if(this.field[down][left] == -1)
        counter +=1;

        if(down == this.n || right == this.n);
        else if(this.field[down][right] == -1)
        counter += 1;

        if(up == -1 || left == -1);
        else if(this.field[up][left] == -1)
        counter += 1;

        if(up == -1 || right == this.n);
        else if(this.field[up][right] == -1)
        counter += 1;

        else this.field[row][col] = -2;
        this.field[row][col] = counter;
        return counter;
    }

    public boolean isContinue()
    {
        for(int i = 0; i < this.n ; i += 1)
        {
            for(int j = 0; j < this.n; j += 1)
            {
                if(this.field[i][j] == 0)
                    return true;
            }
        }

        return false;
    }

    public int run() 
    { 
        int inputR, inputC;
        Scanner in = new Scanner(System.in);

        field = createField();
        randomMines(field);
        printField(field);
    
  
        while(true)
        {  

        System.out.println("Enter row: ");
        inputR = in.nextInt();
        System.out.println("Enter col: ");
        inputC = in.nextInt();
        
        if(field[inputR][inputC] > 0 || field[inputR][inputC] == -1)
        {
            in.close();
            System.out.println("Game Over!");
            return 0;
        }
        numberOfMines(inputR, inputC);
        printField(field);
        if(!isContinue())
        {
            in.close();
            return 1;
        }
        }

        
    }
}
