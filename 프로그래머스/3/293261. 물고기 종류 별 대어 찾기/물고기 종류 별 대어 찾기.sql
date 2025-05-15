-- 코드를 작성해주세요
select fi.ID, fni.FISH_NAME, fi.LENGTH
from fish_info fi
    join fish_name_info fni
    on fi.fish_type = fni.fish_type
where fi.length = (
    select max(length)
    from fish_info
    where fish_type = fi.fish_type)
order by fi.ID