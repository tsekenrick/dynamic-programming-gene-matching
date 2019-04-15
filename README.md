## Description

Professor Farnsworth has once again descended into a moronic battle of science and wits against his arch nemesis Professor Wernstrom, though this time it is a battle of honour on the basketball court. The Professor has decided to create a team of undefeatable mutants very unlike but not quite dissimilar to the ones he used to fight the Globetrotters to defend earths dignity. His diabolical scheme is to use the DNA of the best NBA players to manufacture the perfect team. But he wants to use players who have a varied expertise to make sure that each mutant is the best possible one for the team composition.

Help the Professor so that he is best able to analyze the sequence of any two players.

### Input Format

The input consists of two lines, where each sequence ***a*** and ***b*** are the DNA sequence of the players.

### Constraints

***1 <= |a|, |b| <= 3100***

### Output Format

First output the optimal score of aligning the two sequences. Then output an optimal alignment of the two sequences.

As in PS4.4, a scoring matrix is used to determine the score of an alignment. For this challenge, you are to use the following scoring matrix ***δ***:

* ***δ(-,x) = δ(x,-) = -2*** for any letter ***x***
* for all letters ***x,y***:***δ(x,y) = +3*** if ***x = y*** and ***δ(x,y) = -3*** if ***x != y***

### Sample Input 0

```
GAT
GT
```

### Sample Output 0

```
4
GAT
G-T
```

### Sample Input 1

```
ACGAGT
CAGCACT
```

### Sample Output 1

```
3
-A-CGAGT
CAGC-ACT
```

### Sample Input 2

```
GGACCCTTCG
GGATGCTTCG
```

### Sample Output 2

```
18
GGACCCTTCG
GGATGCTTCG
```

### Sample Input 3

```
ACGCCG
ACCACG
```

### Sample Output 3

```
11
ACGC-CG
AC-CACG
```
