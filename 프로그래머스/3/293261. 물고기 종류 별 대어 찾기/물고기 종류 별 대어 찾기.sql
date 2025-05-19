select a.ID, b.FISH_NAME, a.LENGTH
from FISH_INFO a
join FISH_NAME_INFO b on a.FISH_TYPE = b.FISH_TYPE
where a.LENGTH in (
    select distinct max(LENGTH)
    from FISH_INFO
    where FISH_TYPE = A.FISH_TYPE
)
order by a.ID;
