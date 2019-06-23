package tigerDogs;

public class Print {

    public static void print(int[][]arr) {
        //打印横坐标
        System.out.print("  ");
        for(int i = 0; i<5;i++){
            System.out.print(" " + i + " ");
        }
        //打印上边线
        System.out.println();
       /* System.out.println("----------------");*/
        for (int i = 0; i < 7; i++) {
            System.out.print(i + "|");
            for (int j = 0; j <5; j++) {
                if(arr[i][j]==-1)
                    System.out.print(arr[i][j] + " ");
                else
                    System.out.print(" "+arr[i][j] + " ");
            }
            //输出一列后就回车空格
            System.out.println();
        }
    }


}

