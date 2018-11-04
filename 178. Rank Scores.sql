/* Write your PL/SQL query statement below */

select round(score, 2) Score,

dense_Rank() over ( order by Score desc) Rank

from Scores;
