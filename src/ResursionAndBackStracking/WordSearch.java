package ResursionAndBackStracking;


/// 79. Word Search
/// Source : https://leetcode.com/problems/word-search/description/
///
/// 回溯法
/// 时间复杂度: O(m*n*m*n)
/// 空间复杂度: O(m*n)
public class WordSearch {

    private int d[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int m, n;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        if (board == null || word == null)
            throw new IllegalArgumentException("board or word can not be null!");

        m = board.length;
        if (m == 0)
            throw new IllegalArgumentException("board can not be empty.");
        n = board[0].length;
        if (n == 0)
            throw new IllegalArgumentException("board can not be empty.");

        visited = new boolean[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (searchWord(board, word, 0, i, j))
                    return true;

        return false;
    }

    //注意区间
    private boolean inArea(int x, int y) {
        return (0<=x && x<m)
                && (0<=y && y<n);
    }

    // 从board[startx][starty]开始, 寻找word[index...word.size())
    private boolean searchWord(char[][] board, String word, int index,
                               int startx, int starty) {

        //assert(inArea(startx,starty));
        if (index == word.length() - 1)//匹配到尾部
            return board[startx][starty] == word.charAt(index);

        //包含该位置的字符，记录使用该字符，尝试向四周继续查找
        if (board[startx][starty] == word.charAt(index)) {
            //使用该元素
            visited[startx][starty] = true;
            // 从startx, starty出发,向四个方向寻
            for (int[] i : d) {
                int newx = startx + i[0];
                int newy = starty + i[1];
                //如果在新坐标在区域内，且没有被访问过，则开始递归；
                if (inArea(newx, newy) && !visited[newx][newy] &&
                        searchWord(board, word, index + 1, newx, newy))
                    //遇到答案，直接返回；
                    return true;
            }
            //没有找到，回溯释放该元素
            visited[startx][starty] = false;
        }
        return false;
    }

    public static void main(String args[]) {

        char[][] b1 = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};

        String words[] = {"ABCCED", "SEE", "ABCB"};
        for (int i = 0; i < words.length; i++)
            if ((new WordSearch()).exist(b1, words[i]))
                System.out.println("found " + words[i]);
            else
                System.out.println("can not found " + words[i]);

        // ---

        char[][] b2 = {{'A'}};
        if ((new WordSearch()).exist(b2, "AB"))
            System.out.println("found AB");
        else
            System.out.println("can not found AB");
    }
}
