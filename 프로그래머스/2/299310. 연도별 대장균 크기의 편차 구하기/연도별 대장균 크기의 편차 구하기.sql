-- 코드를 작성해주세요
select year(differentiation_date) as YEAR, 
    (select max(size_of_colony) 
     from ecoli_data 
     where year(differentiation_date) = YEAR) - size_of_colony as YEAR_DEV,
    ID
from ecoli_data
order by YEAR, YEAR_DEV