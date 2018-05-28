getCountWithName
===
select count(*) from user where 1=1
@if(!isEmpty(name)){
and name = #name#
@}

getCount
===
select count(*) from user

getFirstUser
===
select u.*,1 as role from user u order by id asc LIMIT 1


