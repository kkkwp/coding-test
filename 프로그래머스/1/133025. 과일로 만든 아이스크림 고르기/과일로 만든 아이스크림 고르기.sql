-- 코드를 입력하세요
SELECT f.flavor
FROM FIRST_HALF as f
    JOIN ICECREAM_INFO as i
    ON f.flavor = i.flavor
WHERE f.total_order > 3000 and i.ingredient_type = "fruit_based"