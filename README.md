# Kramers rule and rule of Sarrus matrix solver (sorta)

![Alt text](https://static.wikia.nocookie.net/superepicfailpedia/images/4/40/Kramer053.jpg/revision/latest?cb=20151211091254)

- Had to fit the matrix and its components into a 4x4 array (per teacher request)
  - The coefficients for \(x\), \(y\), and \(z\) are stored in a 3x3 section of the array.
  - The constants are stored in the first column of the array.
  - The determinant is located in the first row and column of the array.
  - The solution for \(dx\), \(dy\), \(dz\) are stored in the top row starting from the second column of the array.

- diagram of how items are stored in the matrix array:

| D  | dx | dy | dz |
|----|----|----|----|
| b  | x  | y  | z  |
| b  | x  | y  | z  |
| b  | x  | y  | z  |
