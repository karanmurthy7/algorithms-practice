package leetcode.problems;

/*
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 * 
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
    	
    	char [] wordArray = word.toCharArray();
    	boolean output = false;
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board[0].length; j++) {
    			output = wordSearchHelper(board, i, j, 0, wordArray);
    			if (output)
    				return output;
    		}
    	}
        return output;
    }
    
	private boolean wordSearchHelper(char[][] board, int i, int j, int index, char[] wordArray) {
		if (index == wordArray.length)
			return true;
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
			return false;
		
		if (wordArray[index] != board[i][j])
			return false;
		
		board[i][j] ^= 256;
		boolean exist = wordSearchHelper(board, i, j + 1, index + 1, wordArray) ||
				wordSearchHelper(board, i + 1, j, index + 1, wordArray) ||
				wordSearchHelper(board, i, j - 1, index + 1, wordArray) ||
				wordSearchHelper(board, i - 1, j, index + 1, wordArray);
		board[i][j] ^= 256;
		return exist;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [][] board = {{'A', 'B', 'C', 'E'},
				{'S', 'F', 'C', 'S'},
				{'A', 'D', 'E', 'E'}};
		String word = "SEE";
		System.out.println(new WordSearch().exist(board, word));
		
	}

}
