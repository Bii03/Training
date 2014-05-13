SET SQL_SAFE_UPDATES=0;
update ex2.salariat set Salariu=1.1*Salariu where idSalariat in (select Salariat from ex2.departament_employees);