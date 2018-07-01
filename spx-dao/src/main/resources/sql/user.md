cols
===
    id,name,password,salt,email,mobile,reg_time

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
select #use("cols")# from user order by id asc LIMIT 1

getByCondition
===
* 根据条件获取数据

select #use("cols")# from user  where  #use("condition")#

condition
===

	1 = 1  
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(name)){
	 and name=#name#
	@}
	@if(!isEmpty(password)){
	 and password=#password#
	@}
	@if(!isEmpty(salt)){
	 and salt=#salt#
	@}
	@if(!isEmpty(email)){
	 and email=#email#
	@}
	@if(!isEmpty(mobile)){
	 and mobile=#mobile#
	@}
	@if(!isEmpty(regTime)){
	 and reg_time=#regTime#
	@}
