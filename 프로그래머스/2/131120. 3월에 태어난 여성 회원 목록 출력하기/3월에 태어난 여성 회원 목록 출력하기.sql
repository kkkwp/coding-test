-- 코드를 입력하세요
SELECT member_id, member_name, gender, DATE_FORMAT(date_of_birth, '%Y-%m-%d') as date_of_birth
FROM member_profile
WHERE date_of_birth like '%-03-%' and gender = 'W' and tlno is not null
ORDER BY member_id