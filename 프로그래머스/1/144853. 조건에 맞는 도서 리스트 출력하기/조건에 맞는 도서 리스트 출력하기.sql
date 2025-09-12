-- 코드를 입력하세요
SELECT book_id, DATE_FORMAT(published_date, '%Y-%m-%d') as published_date
FROM book
WHERE (published_date between '2021-01-01' and '2021-12-31') and category = '인문'
ORDER BY published_date