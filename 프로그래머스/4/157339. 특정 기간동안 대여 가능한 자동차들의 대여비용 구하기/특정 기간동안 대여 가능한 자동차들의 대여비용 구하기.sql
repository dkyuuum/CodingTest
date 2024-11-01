SELECT a.CAR_ID, a.CAR_TYPE, 
    CASE 
        WHEN a.CAR_TYPE = '세단' THEN ROUND(a.DAILY_FEE * (1 - b.DISCOUNT_RATE / 100) * 30)
        WHEN a.CAR_TYPE = 'SUV' THEN ROUND(a.DAILY_FEE * (1 - b.DISCOUNT_RATE / 100) * 30)
    END AS FEE
FROM CAR_RENTAL_COMPANY_CAR a
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN b 
    ON a.CAR_TYPE = b.CAR_TYPE
    AND (b.CAR_TYPE = '세단' OR b.CAR_TYPE = 'SUV')
    AND b.DURATION_TYPE = '30일 이상'
LEFT JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY c 
    ON a.CAR_ID = c.CAR_ID
    AND (c.START_DATE <= '2022-11-30' AND c.END_DATE >= '2022-11-01')
WHERE c.CAR_ID IS NULL 
  AND (a.DAILY_FEE * 30) BETWEEN 500000 AND 2000000
ORDER BY FEE DESC, a.CAR_TYPE ASC, a.CAR_ID DESC;
