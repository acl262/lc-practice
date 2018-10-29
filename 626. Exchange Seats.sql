#  MySQL
select 
    a.id,
    IFNULL(b.student, a.student) as student
    
from seat a
left join seat b
on (a.id % 2 = 1 and a.id+ 1= b.id)
or  (a.id % 2 = 0 and a.id -1 = b.id)
order by a.id
