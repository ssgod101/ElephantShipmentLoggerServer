-- add initial company data
INSERT INTO Company (name)
VALUES ('Team Elephant');
INSERT INTO Company (name)
VALUES ('Team BK');
INSERT INTO Company (name)
VALUES ('Hey Ya!!!');

-- add initial account data
INSERT INTO Account (Id, companyid, password, type, name, email, phonenumber, wage, wageunit, resetpassword)
VALUES ('derekackworth', 1, 'password', 'Owner', 'Derek Ackworth', 'd_ackworth@fanshaweonline.ca', '(555)555-5555', 45.2, '/Hour', false);
INSERT INTO Account (Id, companyid, password, type, name, email, phonenumber, wage, wageunit, resetpassword)
VALUES ('bijankhajavi', 2, 'password', 'Owner', 'Bijan Khajavi', 'b_khajavi@fanshaweonline.ca', '(555)555-5554', 46.2, '/Hour', false);
INSERT INTO Account (Id, companyid,warehouseid, password, type, name, email, phonenumber, wage, wageunit, resetpassword)
VALUES ('Administrator', 2,4, 'password', 'Administrator', 'Bijan"s Administrator', 'b_khajavi@fanshaweonline.ca', '(555)555-5554', 46.2, '/Hour', false);
INSERT INTO Account (Id, companyid, password, type, name, email, phonenumber, wage, wageunit, resetpassword)
VALUES ('miteshkumar', 3, 'password', 'Owner', 'Miteshkumar Chaudhary', 'm_chaudhary4@fanshaweonline.ca', '(555)555-5555', 60.0, '/Hour', false);

-- add a warehouse
INSERT INTO Warehouse (name, address, city, province, country, companyid)
VALUES ('Elephant Warehouse', '123 Elephant St.', 'London', 'Ontario', 'Canada', 1);
INSERT INTO Warehouse (name, address, city, province, country, companyid)
VALUES ('london Warehouse', '123 main St.', 'London', 'Ontario', 'Canada', 1);
INSERT INTO Warehouse (name, address, city, province, country, companyid)
VALUES ('toronto Warehouse', '123 et St.', 'London', 'Ontario', 'Canada', 1);
INSERT INTO Warehouse (name, address, city, province, country, companyid)
VALUES ('A Warehouse', '123 main St.', 'London', 'Ontario', 'Canada', 2);
INSERT INTO Warehouse (name, address, city, province, country, companyid)
VALUES ('B Warehouse', '123 et St.', 'Ahmedabad', 'Gujarat', 'India', 2);
INSERT INTO Warehouse (name, address, city, province, country, companyid)
VALUES ('C Warehouse', '125 et St.', 'London', 'Ontario', 'Canada', 2);
INSERT INTO Warehouse (name, address, city, province, country, companyid)
VALUES ('D Warehouse', '127 et St.', 'Ottowa', 'Ontario', 'Canada', 2);
INSERT INTO Warehouse (name, address, city, province, country, companyid)
VALUES ('Edmonton Warehouse', '130 est St.', 'Edmonton', 'Alberta', 'Canada', 2);
INSERT INTO Warehouse (name, address, city, province, country, companyid)
VALUES ('london ', '123 main St.', 'London', 'Ontario', 'Canada', 3);
INSERT INTO Warehouse (name, address, city, province, country, companyid)
VALUES ('Toronto ', '123 et St.', 'Toronto', 'Ontario', 'Canada', 3);

INSERT INTO rate(warehouseid, to_warehouseid, rate_per_cubic_feet, rate_per_kg)
VALUES (2,3,5,1);
INSERT INTO rate(warehouseid, to_warehouseid, rate_per_cubic_feet, rate_per_kg)
VALUES (2,1,10,2);

INSERT INTO Linked_companies(linkedid, companyid)
VALUES ( 1,2 );
INSERT INTO Linked_companies(linkedid, companyid)
VALUES ( 2,1 );

INSERT INTO Shipment(Id,companyid,paid,after_address,amount,begin_address,city_end,city_start,date_arrived,date_sent,description,gst,hazard_level,height,length,qrcode,qrcodetxt,receiver_name,sender_name,receiver_phone,sender_phone,vehicle_number,warehouse_fromid,warehouse_toid,weight,width)
values ( 'A', 1, true, 'bijans house', 113.00, 'ayhouse', 'toronto', 'london','2019-11-15', '2019-11-14', 'eletronics', 13.0, '1', 2, 2, 'b87stf87sdfgb87s8hs98h98shd', 'A', 'biajn', 'mitesh','(555)555-5555','(999)999-9999', 'A00A', 1, 3, 2, 2);
INSERT INTO Shipment(Id, companyid, paid,after_address,amount,begin_address,city_end,city_start,date_arrived,date_sent,description,gst,hazard_level,height,length,qrcode,qrcodetxt,receiver_name,sender_name,receiver_phone,sender_phone,vehicle_number,warehouse_fromid,warehouse_toid,weight,width)
values ( 'B', 1,  true, 'aijans house', 113.00, 'byhouse', 'toronto', 'london','2019-11-15', '2019-11-14', 'eletronics', 13.0, '1', 2, 2, 'b87stf87sdfgb87s8hs98h98shd', 'A', 'biajn', 'mitesh','(555)555-5555','(999)999-9999', 'A00A', 1, 3, 2, 2);
INSERT INTO Shipment(Id, companyid, paid,after_address,amount,begin_address,city_end,city_start,date_arrived,date_sent,description,gst,hazard_level,height,length,qrcode,qrcodetxt,receiver_name,sender_name,receiver_phone,sender_phone,vehicle_number,warehouse_fromid,warehouse_toid,weight,width)
values ( 'C', 1,  true, 'cijans house', 113.00, 'cyhouse', 'toronto', 'london','2019-11-15', '2019-11-14', 'eletronics', 13.0, '1', 2, 2, 'b87stf87sdfgb87s8hs98h98shd', 'A', 'biajn', 'mitesh','(555)555-5555','(999)999-9999', 'A00A', 1, 3, 2, 2);
INSERT INTO Shipment(Id, companyid, paid,after_address,amount,begin_address,city_end,city_start,date_arrived,date_sent,description,gst,hazard_level,height,length,qrcode,qrcodetxt,receiver_name,sender_name,receiver_phone,sender_phone,vehicle_number,warehouse_fromid,warehouse_toid,weight,width)
values ( 'D', 2,  true, 'dijans house', 113.00, 'dyhouse', 'toronto', 'london','2019-11-15', '2019-11-14', 'eletronics', 13.0, '1', 2, 2, 'b87stf87sdfgb87s8hs98h98shd', 'A', 'biajn', 'mitesh','(555)555-5555','(999)999-9999', 'A00A', 4, 3, 2, 2);
INSERT INTO Shipment(Id, companyid, paid,after_address,amount,begin_address,city_end,city_start,date_arrived,date_sent,description,gst,hazard_level,height,length,qrcode,qrcodetxt,receiver_name,sender_name,receiver_phone,sender_phone,vehicle_number,warehouse_fromid,warehouse_toid,weight,width)
values ( 'D1', 2,  true, 'd1ijans house', 113.00, 'dyhouse', 'toronto', 'london','2019-11-15', '2019-11-14', 'eletronics', 13.0, '1', 2, 2, 'b87stf87sdfgb87s8hs98h98shd', 'A', 'biajn', 'mitesh','(555)555-5555','(999)999-9999', 'A00A', 5, 3, 2, 2);
INSERT INTO Shipment(Id, companyid, paid,after_address,amount,begin_address,city_end,city_start,date_arrived,date_sent,description,gst,hazard_level,height,length,qrcode,qrcodetxt,receiver_name,sender_name,receiver_phone,sender_phone,vehicle_number,warehouse_fromid,warehouse_toid,weight,width)
values ( 'D2', 2,  true, 'd2ijans house', 113.00, 'dyhouse', 'toronto', 'london','2019-11-15', '2019-11-14', 'eletronics', 13.0, '1', 2, 2, 'b87stf87sdfgb87s8hs98h98shd', 'A', 'biajn', 'mitesh','(555)555-5555','(999)999-9999', 'A00A', 6, 3, 2, 2);
INSERT INTO Shipment(Id, companyid, paid,after_address,amount,begin_address,city_end,city_start,date_arrived,date_sent,description,gst,hazard_level,height,length,qrcode,qrcodetxt,receiver_name,sender_name,receiver_phone,sender_phone,vehicle_number,warehouse_fromid,warehouse_toid,weight,width)
values ( 'E', 3,  true, 'eijans house', 113.00, 'eyhouse', 'toronto', 'london','2019-11-15', '2019-11-14', 'eletronics', 13.0, '1', 2, 2, 'b87stf87sdfgb87s8hs98h98shd', 'A', 'biajn', 'mitesh','(555)555-5555','(999)999-9999', 'A00A', 9, 3, 2, 2);
INSERT INTO Shipment(Id, companyid, paid,after_address,amount,begin_address,city_end,city_start,date_arrived,date_sent,description,gst,hazard_level,height,length,qrcode,qrcodetxt,receiver_name,sender_name,receiver_phone,sender_phone,vehicle_number,warehouse_fromid,warehouse_toid,weight,width)
values ( 'F', 3,  true, 'fijans house', 113.00, 'fyhouse', 'toronto', 'london','2019-11-15', '2019-11-14', 'eletronics', 13.0, '1', 2, 2, 'b87stf87sdfgb87s8hs98h98shd', 'A', 'biajn', 'mitesh','(555)555-5555','(999)999-9999', 'A00A', 9, 3, 2, 2);
INSERT INTO Shipment(Id, companyid, paid,after_address,amount,begin_address,city_end,city_start,date_arrived,date_sent,description,gst,hazard_level,height,length,qrcode,qrcodetxt,receiver_name,sender_name,receiver_phone,sender_phone,vehicle_number,warehouse_fromid,warehouse_toid,weight,width)
values ( 'G', 3,  true, 'gijans house', 113.00, 'gyhouse', 'toronto', 'london','2019-11-15', '2019-11-14', 'eletronics', 13.0, '1', 2, 2, 'b87stf87sdfgb87s8hs98h98shd', 'A', 'biajn', 'mitesh','(555)555-5555','(999)999-9999', 'A00A', 10, 3, 2, 2);


INSERT INTO Products(shipmentid, name, qty, price, length, width, height, weight)
values ('A', 'alienwareA', 1, 113.0, 2, 2, 2, 2 );

INSERT INTO Track_Events( shipmentid, time, date, reached, current_warehouse,current_warehouseid)
values  ( 'A' ,current_time, current_date,false,'london',2);
INSERT INTO Track_Events( shipmentid, time, date, reached, current_warehouse,current_warehouseid)
values  ( 'E' ,current_time, current_date,false,'london',3);
INSERT INTO Track_Events( shipmentid, time, date, reached, current_warehouse,current_warehouseid)
values  ( 'F' ,current_time, current_date,false,'london',3);

/*INSERT INTO Notification(companyid, companyid_from, company_from, message, resolved, accepted, date_sent)
VALUES ( 2, 3, 'Team DK', 'Team DK has sent a link request to your company.', false, false, current_date );*/
INSERT INTO Notification(companyid, companyid_from, company_from, message, resolved, accepted, date_sent)
VALUES ( 3, 1, 'Team Elephant', 'Team Elephant has sent a link request to your company.', false, false, current_date );
