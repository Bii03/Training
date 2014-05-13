create table ex2.departament_employees as (select idSalariat as Salariat, count(idSalariat)   
as NumarDeAngajatiInDepartament from ex2.departament inner join ex2.salariat on ex2.departament.idDepartament = ex2.salariat.Departament_idDepartament  
group by ex2.salariat.Departament_idDepartament having count(idSalariat)=1);