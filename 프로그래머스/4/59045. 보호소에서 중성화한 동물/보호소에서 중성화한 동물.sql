# select a.ANIMAL_ID, a.ANIMAL_TYPE, a.NAME	
# from ANIMAL_INS a
#     join ANIMAL_OUTS b
#     on a.ANIMAL_ID = b.ANIMAL_ID
# where 
#     a.SEX_UPON_INTAKE like "Intact%"
#     and
#     (b.SEX_UPON_OUTCOME like "Neutered%"
#     or
#     b.SEX_UPON_OUTCOME like "Spayed%")
# order by a.ANIMAL_ID

SELECT a.ANIMAL_ID, a.ANIMAL_TYPE, a.NAME
FROM ANIMAL_INS a
JOIN ANIMAL_OUTS b ON a.ANIMAL_ID = b.ANIMAL_ID
WHERE 
    INSTR(a.SEX_UPON_INTAKE, 'Intact') > 0
    AND b.SEX_UPON_OUTCOME REGEXP 'Neutered|Spayed'
ORDER BY a.ANIMAL_ID;
