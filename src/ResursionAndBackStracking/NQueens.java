package ResursionAndBackStracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/// 51. N-Queens
/// https://leetcode.com/problems/n-queens/description/
/// 时间复杂度: O(n^n)
/// 空间复杂度: O(n)
public class NQueens {

    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;
    private ArrayList<List<String>> res;

    public List<List<String>> solveNQueens(int n) {

        res = new ArrayList<>();
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];

        LinkedList<Integer> row = new LinkedList<>();
        putQueen(n, 0, row);

        return res;
    }

    // 尝试在一个n皇后问题中, 摆放第index行的皇后位置
    private void putQueen(int n, int index, LinkedList<Integer> row){

        if(index == n){
            res.add(generateBoard(n, row));
            return;
        }

        // 尝试将第index行的皇后摆放在第i列
        for(int i = 0 ; i < n ; i ++) {
            int curDia1 = index + i;
            int curDia2 = index - i + n - 1;
            if(!col[i] && !dia1[curDia1] && !dia2[curDia2]){
                row.addLast(i);
                col[i] = true;
                dia1[curDia1] = true;
                dia2[curDia2] = true;
                putQueen(n, index + 1, row);
                col[i] = false;
                dia1[curDia1] = false;
                dia2[curDia2] = false;
                row.removeLast();
            }
        }

    }

    private List<String> generateBoard(int n, LinkedList<Integer> row){

        assert row.size() == n;

        ArrayList<String> board = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++){
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[row.get(i)] = 'Q';
            board.add(new String(charArray));
        }
        return board;
    }

    private static void printBoard(List<String> board){
        for(String s: board)
            System.out.println(s);
        System.out.println();
    }

    public static void main(String[] args) {

        int n = 4;
        List<List<String>> res = (new NQueens()).solveNQueens(n);
        for(List<String> board: res)
            printBoard(board);
    }
}
