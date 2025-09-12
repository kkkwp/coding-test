-- 코드를 입력하세요
SELECT count(*) as users
FROM user_info
WHERE (joined between '2021-01-01' and '2021-12-31') and (age between 20 and 29) 