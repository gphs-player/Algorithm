package com.leo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * A*search algorithm
 * A 星寻路算法
 * 如图，A到达B，要穿越中间的障碍物，最优路径是什么
 * <p>
 * □ □ □ □ □ □ □
 * □ □ □ ※ □ □ □
 * □ A □ ※ □ B □
 * □ □ □ ※ □ □ □
 * □ □ □ □ □ □ □
 * <p>
 * <p>
 * 1.定义两个List：
 * openList:下一步可达的所有区域
 * closeList:已经走过的区域
 * <p>
 * 2.为每个区域定义三个属性：G(距离出发点的距离) H(距离终点的距离，不考虑障碍物) F(G+H)
 * <p>
 * 3.在openList中找出F值最小的元素，移出openList，加入closeList，表示此元素已经被检查过
 * <p>
 * 4.找出刚才放入closeList的元素可达的区域（例：上下左右），检查是否在openList或者closeList中，不在就加入openList
 * ，并计算相应的GHF值，把当前元素作为他们的父节点
 * <p>
 * 5.循环3步骤，直至终点出现在openList中
 */
public class A_Search {

    public static final int[][] MAZE = {
            {0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 1, 0, 0, 0,},
            {0, 0, 0, 1, 0, 0, 0,},
            {0, 0, 0, 1, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0,},
    };


    public static void main(String[] args) {

        Grid start = new Grid(2, 1);
        Grid end = new Grid(2, 5);
        Grid resultEnd = aStarSearch(start, end);
        System.out.println(resultEnd.toString());


        List<Grid> path = new ArrayList<>();
        while (resultEnd!= null){
            path.add(new Grid(resultEnd.x,resultEnd.y));
            resultEnd = resultEnd.parent;
        }
        for (int i = 0; i < MAZE.length; i++) {
            for (int j = 0; j < MAZE[0].length; j++) {
                if (containGrid(path,i,j)){
                    System.out.print("*, ");
                }else {
                    System.out.print(MAZE[i][j]+", ");
                }
            }
            System.out.println();
        }

    }

    public static Grid aStarSearch(Grid start, Grid end) {
        ArrayList<Grid> openList = new ArrayList<>();
        ArrayList<Grid> closeList = new ArrayList<>();
        openList.add(start);

        while (openList.size() > 0) {
            //找到openList中F值最小的点，进行定位
            Grid currentGrid = findMinGrid(openList);
            //将当前元素从openList中删除
            openList.remove(currentGrid);
            //添加到closeList
            closeList.add(currentGrid);
            List<Grid> neighbors = findNeighbors(currentGrid, openList, closeList);
            for (Grid neighbor : neighbors) {
                if (!openList.contains(neighbor)) {
                    neighbor.initGrid(currentGrid, end);
                    openList.add(neighbor);
                }
            }
            for (Grid grid : openList) {
                if (grid.x == end.x && grid.y == end.y) {
                    return grid;
                }
            }
        }
        return null;
    }

    //找到基于某点的所有可达区域
    private static List<Grid> findNeighbors(Grid currentGrid, ArrayList<Grid> openList, ArrayList<Grid> closeList) {
        List<Grid> gridList = new ArrayList<>();
        if (isValidGrid(currentGrid.x, currentGrid.y - 1, openList, closeList)) {
            gridList.add(new Grid(currentGrid.x, currentGrid.y - 1));
        }
        if (isValidGrid(currentGrid.x, currentGrid.y + 1, openList, closeList)) {
            gridList.add(new Grid(currentGrid.x, currentGrid.y + 1));
        }
        if (isValidGrid(currentGrid.x - 1, currentGrid.y, openList, closeList)) {
            gridList.add(new Grid(currentGrid.x - 1, currentGrid.y));
        }
        if (isValidGrid(currentGrid.x + 1, currentGrid.y, openList, closeList)) {
            gridList.add(new Grid(currentGrid.x + 1, currentGrid.y));
        }
        return gridList;
    }

    private static boolean isValidGrid(int x, int y, List<Grid> openList, List<Grid> closeList) {
        //检查界限
        if (x < 0 || x >= MAZE.length || y < 0 || y >= MAZE[0].length) {
            return false;
        }
        //检查障碍物
        if (MAZE[x][y] == 1) {
            return false;
        }
        //检查是否在openList和closeList中
        if (containGrid(openList, x, y)) {
            return false;
        }
        if (containGrid(closeList, x, y)) {
            return false;
        }

        return true;
    }

    private static boolean containGrid(List<Grid> list, int x, int y) {
        for (Grid grid : list) {
            if (grid.x == x && grid.y == y) {
                return true;
            }
        }
        return false;
    }

    //找到最小值
    private static Grid findMinGrid(ArrayList<Grid> openList) {
        Grid temp = openList.get(0);
        for (Grid grid : openList) {
            if (grid.f < temp.f ) {
                temp = grid;
            }
        }
        return temp;
    }


    static class Grid {
        int x;
        int y;
        int f;
        int g;
        int h;
        Grid parent;

        public Grid(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void initGrid(Grid parent, Grid end) {
            this.parent = parent;
            if (parent != null) {
                this.g = parent.g + 1;
            } else {
                this.g = 1;
            }
            this.h = Math.abs(this.x - end.x) + Math.abs(this.y - end.y);
            this.f = this.g + this.h;
        }

        @Override
        public String toString() {
            return "[" + x +", "+ y + "]";
        }
    }

}
