-- 코드를 입력하세요
SELECT b.title, b.board_id, r.reply_id, r.writer_id, r.contents, DATE_FORMAT(r.created_date, "%Y-%m-%d") as created_date
FROM used_goods_board as b
    JOIN used_goods_reply as r
    ON b.board_id = r.board_id
WHERE b.created_date BETWEEN "2022-10-01" AND "2022-10-31"
ORDER BY CREATED_DATE, TITLE