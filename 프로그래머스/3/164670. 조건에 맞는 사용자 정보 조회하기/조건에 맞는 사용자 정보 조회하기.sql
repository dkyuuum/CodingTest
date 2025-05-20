# select 
#     a.WRITER_ID, 
#     b.NICKNAME, 
#     concat(b.CITY, " ", b.STREET_ADDRESS1, b.STREET_ADDRESS2) as 전체주소, 
#     concat(SUBSTR(b.TLNO,1, 3), '-', SUBSTR(b.TLNO, 4, 4), '-', SUBSTR(b.TLNO, 8, 4)) AS 전화번호
# from USED_GOODS_BOARD a
#     join USED_GOODS_USER b
#     on a.WRITER_ID = b.USER_ID
# group by a.WRITER_ID, b.NICKNAME, 전체주소, 전화번호
# having count(a.WRITER_ID) >= 3
# order by b.USER_ID desc
select 
    b.USER_ID,
    b.NICKNAME,
    CONCAT(b.CITY, ' ', b.STREET_ADDRESS1, ' ', b.STREET_ADDRESS2) AS 전체주소,
    CONCAT(SUBSTR(b.TLNO, 1, 3), '-', SUBSTR(b.TLNO, 4, 4), '-', SUBSTR(b.TLNO, 8, 4)) AS 전화번호
from USED_GOODS_USER b
    join (
        select WRITER_ID
        from USED_GOODS_BOARD
        group by WRITER_ID
        having count(WRITER_ID) >= 3
    ) a 
    on a.WRITER_ID = b.USER_ID
order by a.WRITER_ID desc;