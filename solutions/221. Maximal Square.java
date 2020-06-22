class Solution 
{
    public int maximalSquare(char[][] matrix)
    {
        int row = matrix.length;
        if(row == 0) return 0;
        int col = matrix[0].length;
        int mat[][] = new int[row][col];
        for(int i=0;i<row;i++) //convert to int
            for (int j=0;j<col;j++)
                mat[i][j] = matrix[i][j] - '0';
        
        int maxSq = 0;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(i == 0 || j == 0) 
                    maxSq = Math.max(maxSq, mat[i][j]);
                else if(mat[i][j] == 1) 
                {
                    int val = Math.min(mat[i-1][j-1], mat[i-1][j]);
                    val = Math.min(val, mat[i][j-1]);
                    mat[i][j] = Math.max(mat[i][j], val+1);
                    maxSq = Math.max(mat[i][j], maxSq);
                }
            }
        }        
        return maxSq*maxSq;
    }
}