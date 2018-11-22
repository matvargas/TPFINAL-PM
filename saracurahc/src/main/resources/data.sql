-- Insert speciality data

insert into speciality
values(1, 'Clínico Geral');

insert into speciality
values(2, 'Cardiologista');

insert into speciality
values(3, 'Fonoaudiólogo');

insert into speciality
values(4, 'Neurologista');

insert into speciality
values(5, 'Ortopedista');

insert into speciality
values(6, 'Oftalmologista');

insert into speciality
values(7, 'Otorrinolaringologista');

insert into speciality
values(8, 'Dermatologista');

insert into speciality
values(9, 'Reumatologista');

-- Insert Doctors data

insert into doctor
values(1, 'Doutor Leão', 'Clínico Geral');

insert into doctor
values(2, 'Doutor Girafa', 'Cardiologista');

insert into doctor
values(3, 'Doutor Sapo', 'Fonoaudiólogo');

insert into doctor
values(4, 'Doutor Agrião', 'Neurologista');

insert into doctor
values(5, 'Doutor Alface', 'Ortopedista');

insert into doctor
values(6, 'Doutor Pimplolho', 'Oftalmologista');

insert into doctor
values(7, 'Doutor Jeep', 'Otorrinolaringologista');

insert into doctor
values(8, 'Doutor Abelha', 'Dermatologista');

insert into doctor
values(9, 'Doutor Algodão', 'Reumatologista');

insert into doctor
values(10, 'Doutor Cachorro', 'Reumatologista');

insert into doctor
values(11, 'Doutor Rato', 'Dermatologista');

insert into doctor
values(12, 'Doutor Macaco', 'Otorrinolaringologista');

insert into doctor
values(13, 'Doutor Águia', 'Oftalmologista');

insert into doctor
values(14, 'Doutor Daciolo', 'Ortopedista');

-- Populate Event Types

insert into event_type
values(1, 'Agendamento');

insert into event_type
values(2, 'Exame de Imagem');

-- Populate Events

insert into event(doctor_associated, type, title, beginDate, endDate)
values(1, 1, 'Consulta Médica', '2018-11-24T13:00:00', '2018-11-24T13:20:00');

insert into event(doctor_associated, type, title, beginDate, endDate)
values(1, 1, 'Consulta Médica', '2018-11-24T13:20:00', '2018-11-24T13:40:00');

insert into event(doctor_associated, type, title, beginDate, endDate)
values(1, 1, 'Consulta Médica', '2018-11-24T13:40:00', '2018-11-24T14:00:00');

insert into event(doctor_associated, type, title, beginDate, endDate)
values(1, 1, 'Consulta Médica', '2018-11-24T14:00:00', '2018-11-24T14:20:00');

insert into event(doctor_associated, type, title, beginDate, endDate)
values(1, 1, 'Consulta Médica', '2018-11-24T14:20:00', '2018-11-24T14:40:00');

insert into event(doctor_associated, type, title, beginDate, endDate)
values(1, 1, 'Consulta Médica', '2018-11-24T14:40:00', '2018-11-24T15:00:00');

insert into event(doctor_associated, type, title, beginDate, endDate)
values(1, 1, 'Consulta Médica', '2018-11-24T15:00:00', '2018-11-24T15:20:00');

insert into event(doctor_associated, type, title, beginDate, endDate)
values(1, 1, 'Consulta Médica', '2018-11-24T15:20:00', '2018-11-24T15:40:00');

insert into event(doctor_associated, type, title, beginDate, endDate)
values(1, 1, 'Consulta Médica', '2018-11-24T15:40:00', '2018-11-24T16:00:00');

insert into event(doctor_associated, type, title, beginDate, endDate)
values(1, 1, 'Consulta Médica', '2018-11-24T16:00:00', '2018-11-24T16:20:00');