package com.zcr.recursion;

/**
 * @author zcr
 * @date 2019/7/6-20:24
 */
public class MiGong {

    public static void main(String[] args) {
        //先创建一个二维数组模拟迷宫
        //地图
        int[][] map = new int[8][7];
        //使用1表示墙
        //上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
       /* 测试回溯的用法
       map[1][2] = 1;
        map[2][2] = 1;*/
        //输出地图
        System.out.println("地图情况：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        //使用递归回溯给小球找路
        //setWay(map, 1, 1);
        setWay2(map,1,1);
        //输出新的地图，小球走过，并标识过的递归
        System.out.println("小球走过，并标识过的地图情况：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    //使用递归回溯来给小球找路
    //说明
    //1.map表示地图
    //2.i,j表示从地图中哪个位置出发(1,1)
    //3.如果小球能到map[6][5]，则说明通路找到
    //4.约定：当map[i][j]为0时，表示该点没有走过，为1时代表墙，为2时表示通路可以走，为3表示该位置已经走过但是走不通
    //5.在走迷宫时，需要确定一个策略（方法） 先走下-》右-》上-》左，如果该点走不通，再回溯

    /**
     * @param map 表示地图
     * @param i   表示从哪个位置开始找
     * @param j
     * @return 如果找到通路，返回true；否则返回false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            //通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) {
                //如果当前这个点还没有走过
                //按照策略走
                //在走之前先把这个点置为2，假定该点是可以走通的
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {//向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {//向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {//向上走
                    return true;
                } else if (setWay(map, i, j - 1)) {//向左走
                    return true;
                } else {
                    //说明该点走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else {//如果map[i][j]！=0，可能是1,2,3
                return false;
            }
        }
    }

    //修改找路的策略，改成上-》右-》下-》左
    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            //通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) {
                //如果当前这个点还没有走过
                //按照策略走
                //在走之前先把这个点置为2，假定该点是可以走通的
                map[i][j] = 2;
                if (setWay2(map, i - 1, j)) {//向上走
                    return true;
                } else if (setWay2(map, i, j + 1)) {//向右走
                    return true;
                } else if (setWay2(map, i + 1, j)) {//向下走
                    return true;
                } else if (setWay2(map, i, j - 1)) {//向左走
                    return true;
                } else {
                    //说明该点走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else {//如果map[i][j]！=0，可能是1,2,3
                return false;
            }
        }
    }
}