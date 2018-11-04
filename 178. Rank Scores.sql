/* Write your PL/SQL query statement below */
-- select ROUND(sc.Score,2) Score, dense_rank() over (order by Score desc) Rank from Scores sc

-- select ROUND(sc.Score, 2 ) Score, 

-- dense_rank() over (order by Score desc) Rank from Scores sc


-- select Score,

-- dense_rank() over(order by Score desc) Rank

-- from scores

-- select Score, dense_Rank() over(order by Score desc) as Rank from Scores;

-- select ROUND(sc.Score,2) Score, dense_rank() over (order by Score desc) Rank from Scores sc

-- select Round(score, 2) Score,

-- dense_rank() over(order by Score desc) Rank

-- from Scores



select round(score, 2) Score,

dense_Rank() over ( order by Score desc) Rank

from Scores;
