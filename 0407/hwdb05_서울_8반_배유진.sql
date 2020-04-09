select ename, job, sal, loc
from emp, dept 
where loc='chicago';

select * from emp;
select empno, ename, job, deptno
from emp 
where empno not in (select mgr from emp);

select ename, job, mgr
from emp
where mgr in (select mgr from emp where ename = 'blake');

select * from emp
order by hiredate
limit 5;

select ename, job, dname
from emp, dept
where mgr in (select empno from emp where ename = 'jones');