/*

https://leetcode.com/problems/word-search/

Given an m x n board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where "adjacent" cells are horizontally 
or vertically neighboring. The same letter cell may not be used more than once.

*/

class Solution {
    
    static char[][] visited; 
    public boolean exist(char[][] board, String word) {
       visited  = new char[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(helper(board, word, 0, i, j))
                        return true;
                }
            }
        }
        
       return false;
        
    }
    
    public boolean helper(char[][] board, String word, int index, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
       
        if(visited[i][j] == 'x') return false;
        
        if(board[i][j] != word.charAt(index)) return false;
        
        visited[i][j] = 'x';
        
        if(index == word.length() - 1) return true;           
        
        boolean found = helper(board, word, index + 1, i + 1, j) || helper(board, word, index + 1, i - 1, j) ||
        
        helper(board, word, index + 1, i, j + 1) || helper(board, word, index + 1, i, j - 1);     
        
        visited[i][j] = '.';
        
        if(found) return true;
        
        return false;
        
        
    }
}
