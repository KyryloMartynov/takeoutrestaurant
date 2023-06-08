select dish.name,portion,price,category.name from dish,category where category_id=category.id;

DROP FUNCTION IF EXISTS `insert_dish_in_cart`;
DELIMITER //
CREATE FUNCTION insert_dish_in_cart(id_order int unsigned,id_dish int unsigned)
RETURNS bool
BEGIN
insert into order_has_dish value(id_order,id_dish);
return true;
END//
DELIMITER ;

Тригер:
DELIMITER //
create trigger order_has_dish_insert
after insert on `order_has_dish`
for each row begin
update `order` set price=price+(select price from dish where id= new.dish_id) where id=new.order_id;
end//
DELIMITER ;

select name,portion,price from dish where id in(select dish_id from order_has_dish where order_id =@orderId);

DROP procedure IF EXISTS `delete_dish_from_cart`;
DELIMITER //
CREATE PROCEDURE `delete_dish_from_cart`(in id_order int unsigned,in id_dish int unsigned)
BEGIN
delete from order_has_dish where order_id = id_order and dish_id=id_dish;
END//
DELIMITER ;


DELIMITER //
create trigger order_has_dish_delete
after delete on `order_has_dish`
for each row begin
update `order` set price=price-(select price from dish where id= old.dish_id) where id=old.order_id;
end//
DELIMITER ;

DROP procedure IF EXISTS `cancel_order`;
DELIMITER //
CREATE PROCEDURE `cancel_order`(in id_order int unsigned)
BEGIN
update `order` set `status`="Cancel" where id=id_order;
END//
DELIMITER ;


DELIMITER //
create trigger order_cancelled
after update on `order_has_dish`
for each row begin
if(old.`status`!=new.`status`) then
delete from order_has_dish where order_id = new.id;
end if;
end//
DELIMITER ;


select `order`.id,price,date,create_date,name from `order`,client where  client.id = client_id and `status` = "new";

select `order`.id, `order`.price, date,create_date, client.name, telephone, address, dish.name,portion, dish.price
from `order` join client on (client.id=client_id)
join order_has_dish on (`order`.id=order_id)
join dish on (`dish`.id=dish_id)
where `order`.id=@orderId;
