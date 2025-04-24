# Kramers rule and rule of sarrus matrix solver (sorta)
![Alt text](https://m.media-amazon.com/images/M/MV5BMzI1OWNiNWYtNzA2NS00Mzk5LWE3ZGUtMGNkM2ViODBjYzJiXkEyXkFqcGdeQXVyMzQ3Nzk5MTU@._V1_.jpg)

- had to fit the matrix and its components into a 4x4 array (per teacher request)
  - the coefficients for x,y,z are stored in a 3x3 section of the array
  - the constants are stored in the first column of the array
  - the determinant is located in the first row and column of the array
  - the solution for dx, dy, dz are stored in the top row starting from the second column of the array

[D][dx][dy][dz] 
[b][x][y][z] 
[b][x][y][z] 
[b][x][y][z] 
