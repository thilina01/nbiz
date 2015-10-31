-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Table `bank`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank` (
  `code` VARCHAR(30) NOT NULL,
  `name` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `person` (
  `nic` VARCHAR(10) NOT NULL,
  `name` VARCHAR(250) NULL,
  `address` VARCHAR(150) NULL,
  `city` VARCHAR(60) NULL,
  `mobile` VARCHAR(10) NULL,
  `personcol` VARCHAR(45) NULL,
  `operator` VARCHAR(15) NULL,
  PRIMARY KEY (`nic`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `customer` (
  `code` VARCHAR(10) NOT NULL,
  `fixedLine` VARCHAR(10) NULL DEFAULT NULL,
  `fax` VARCHAR(10) NULL DEFAULT NULL,
  `notes` VARCHAR(200) NULL DEFAULT NULL,
  `operator` VARCHAR(15) NULL,
  `person_nic` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`code`),
  INDEX `fk_customer_person1_idx` (`person_nic` ASC),
  CONSTRAINT `fk_customer_person1`
    FOREIGN KEY (`person_nic`)
    REFERENCES `person` (`nic`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `root_area`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `root_area` (
  `code` VARCHAR(10) NOT NULL,
  `name` VARCHAR(100) NULL,
  PRIMARY KEY (`code`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `town`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `town` (
  `code` VARCHAR(30) NOT NULL,
  `name` VARCHAR(100) NULL DEFAULT NULL,
  `root_area_code` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`code`),
  INDEX `fk_town_root_area1` (`root_area_code` ASC),
  CONSTRAINT `fk_town_root_area1`
    FOREIGN KEY (`root_area_code`)
    REFERENCES `root_area` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `supplier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supplier` (
  `code` VARCHAR(10) NOT NULL,
  `name` VARCHAR(150) NULL DEFAULT NULL,
  `address_Number` VARCHAR(50) NULL DEFAULT NULL,
  `address_Street` VARCHAR(60) NULL DEFAULT NULL,
  `city` VARCHAR(60) NULL DEFAULT NULL,
  `mobile` VARCHAR(10) NULL DEFAULT NULL,
  `fixed_Line` VARCHAR(10) NULL DEFAULT NULL,
  `fax` VARCHAR(10) NULL DEFAULT NULL,
  `svat` VARCHAR(60) NULL DEFAULT NULL,
  `vat` VARCHAR(60) NULL DEFAULT NULL,
  `notes` VARCHAR(255) NULL DEFAULT NULL,
  `town_code` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`code`),
  INDEX `fk_supplier_town1` (`town_code` ASC),
  CONSTRAINT `fk_supplier_town1`
    FOREIGN KEY (`town_code`)
    REFERENCES `town` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

-- -----------------------------------------------------
-- Table `svat`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `svat` (
  `serial_number` INT NOT NULL,
  `svat_amount` DOUBLE NULL,
  `purchasing_amount` DOUBLE NULL,
  `issued_date` DATETIME NULL,
  `ending_month` DATE NULL,
  `supplier_code` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`serial_number`),
  INDEX `fk_svat_supplier1_idx` (`supplier_code` ASC),
  CONSTRAINT `fk_svat_supplier1`
    FOREIGN KEY (`supplier_code`)
    REFERENCES `eis`.`supplier` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `item_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `item_type` (
  `type` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`type`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `item` (
  `code` VARCHAR(10) NOT NULL,
  `description` VARCHAR(150) NULL DEFAULT NULL,
  `brand` VARCHAR(60) NULL DEFAULT NULL,
  `packSize` INT(4) NULL DEFAULT NULL,
  `itemRefresh` INT(1) NULL DEFAULT NULL,
  `profitPersantage` DOUBLE NULL DEFAULT '0',
  `customerProfitPersantage` DOUBLE NULL DEFAULT NULL,
  `retailProfitPersantage` DOUBLE NULL DEFAULT NULL,
  `supplier_code` VARCHAR(10) NOT NULL,
  `operator` VARCHAR(15) NULL,
  `item_type_type` VARCHAR(20) NOT NULL,
  `status` INT NULL,
  `qkey` INT NULL,
  PRIMARY KEY (`code`),
  INDEX `fk_item_supplier` (`supplier_code` ASC),
  INDEX `fk_item_item_type1_idx` (`item_type_type` ASC),
  CONSTRAINT `fk_item_supplier`
    FOREIGN KEY (`supplier_code`)
    REFERENCES `supplier` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_item_type1`
    FOREIGN KEY (`item_type_type`)
    REFERENCES `item_type` (`type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `employee_position`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `employee_position` (
  `code` VARCHAR(10) NOT NULL,
  `description` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `employee` (
  `code` VARCHAR(15) NOT NULL,
  `Fixed_Line` VARCHAR(10) NULL DEFAULT NULL,
  `notes` VARCHAR(255) NULL DEFAULT NULL,
  `source` INT(1) NULL DEFAULT NULL,
  `employee_position_code` VARCHAR(10) NOT NULL,
  `person_nic` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`code`),
  INDEX `code` (`code` ASC),
  INDEX `fk_employee_employee_position1` (`employee_position_code` ASC),
  INDEX `fk_employee_person1_idx` (`person_nic` ASC),
  CONSTRAINT `fk_employee_employee_position1`
    FOREIGN KEY (`employee_position_code`)
    REFERENCES `employee_position` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_employee_person1`
    FOREIGN KEY (`person_nic`)
    REFERENCES `person` (`nic`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `damage_notes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `damage_notes` (
  `quantity` DOUBLE NULL DEFAULT NULL,
  `reason` VARCHAR(150) NULL DEFAULT NULL,
  `date_Time` DATETIME NOT NULL,
  `item_code` VARCHAR(10) NOT NULL,
  `employee_code` VARCHAR(15) NOT NULL,
  `operator` VARCHAR(15) NULL,
  `rate` DOUBLE NULL,
  PRIMARY KEY (`date_Time`, `item_code`, `employee_code`),
  INDEX `fk_damage_notes_item1` (`item_code` ASC),
  INDEX `fk_damage_notes_employee1` (`employee_code` ASC),
  CONSTRAINT `fk_damage_notes_item1`
    FOREIGN KEY (`item_code`)
    REFERENCES `item` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_damage_notes_employee1`
    FOREIGN KEY (`employee_code`)
    REFERENCES `employee` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `damage_stock`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `damage_stock` (
  `quantity` DOUBLE NULL DEFAULT NULL,
  `item_code` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`item_code`),
  INDEX `fk_damage_stock_item1` (`item_code` ASC),
  CONSTRAINT `fk_damage_stock_item1`
    FOREIGN KEY (`item_code`)
    REFERENCES `item` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `general`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `general` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `profitPresentage` DOUBLE NULL DEFAULT NULL,
  `strike` INT(1) NULL DEFAULT NULL,
  `strikeRate` DOUBLE NULL DEFAULT NULL,
  `invoice_no` VARCHAR(45) NULL,
  `receipt_no` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `last_code`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `last_code` (
  `type` VARCHAR(50) NOT NULL,
  `code` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`type`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `list_types`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `list_types` (
  `code` VARCHAR(255) NOT NULL,
  `type` INT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `operator`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `operator` (
  `username` VARCHAR(15) NOT NULL,
  `password` VARCHAR(25) NULL DEFAULT NULL,
  `power` INT(1) NULL DEFAULT NULL,
  `created_By` VARCHAR(15) NULL DEFAULT NULL,
  `created_date` DATETIME NULL,
  `employee_code` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`username`),
  INDEX `fk_operator_employee1` (`employee_code` ASC),
  CONSTRAINT `fk_operator_employee1`
    FOREIGN KEY (`employee_code`)
    REFERENCES `employee` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `purchase_invoice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `purchase_invoice` (
  `inv_no` VARCHAR(20) NOT NULL,
  `supplier_code` VARCHAR(10) NOT NULL,
  `inv_date` DATE NULL DEFAULT NULL,
  `amount` DOUBLE NULL DEFAULT 0,
  `credit` DOUBLE NULL DEFAULT 0,
  `discount` DOUBLE NULL DEFAULT 0,
  `operator` VARCHAR(15) NULL,
  PRIMARY KEY (`inv_no`, `supplier_code`),
  INDEX `fk_purchase_invoice_supplier1` (`supplier_code` ASC),
  CONSTRAINT `fk_purchase_invoice_supplier1`
    FOREIGN KEY (`supplier_code`)
    REFERENCES `supplier` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `rep_sale`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rep_sale` (
  `sale_date` DATE NOT NULL,
  `item_code` VARCHAR(10) NOT NULL,
  `employee_code` VARCHAR(15) NOT NULL,
  `loaded` DOUBLE NULL DEFAULT NULL,
  `remaining` DOUBLE NULL DEFAULT NULL,
  `rate` DOUBLE NULL DEFAULT NULL,
  `loaded_Bundles` DOUBLE NULL DEFAULT NULL,
  `remaining_Bundles` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`sale_date`, `item_code`, `employee_code`),
  INDEX `fk_sr_date_sale_item1` (`item_code` ASC),
  INDEX `fk_sr_date_sale_employee1` (`employee_code` ASC),
  CONSTRAINT `fk_sr_date_sale_item1`
    FOREIGN KEY (`item_code`)
    REFERENCES `item` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sr_date_sale_employee1`
    FOREIGN KEY (`employee_code`)
    REFERENCES `employee` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sr_sales_payments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sr_sales_payments` (
  `payment_date` DATE NOT NULL,
  `amount` DOUBLE NULL DEFAULT NULL,
  `status` INT(11) NULL DEFAULT NULL,
  `settled_Amount` DOUBLE NULL DEFAULT NULL,
  `notes` VARCHAR(255) NULL DEFAULT NULL,
  `employee_code` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`employee_code`, `payment_date`),
  INDEX `fk_sr_sales_payments_employee1` (`employee_code` ASC),
  CONSTRAINT `fk_sr_sales_payments_employee1`
    FOREIGN KEY (`employee_code`)
    REFERENCES `employee` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sr_stock`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sr_stock` (
  `employee_code` VARCHAR(15) NOT NULL,
  `item_code` VARCHAR(10) NOT NULL,
  `quantity` DOUBLE NULL DEFAULT NULL,
  `bundles` DOUBLE NULL DEFAULT NULL,
  `pack_price` DOUBLE NULL,
  `unit_price` DOUBLE NULL,
  PRIMARY KEY (`employee_code`, `item_code`),
  INDEX `fk_sr_stock_item1` (`item_code` ASC),
  INDEX `fk_sr_stock_employee1` (`employee_code` ASC),
  CONSTRAINT `fk_sr_stock_item1`
    FOREIGN KEY (`item_code`)
    REFERENCES `item` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sr_stock_employee1`
    FOREIGN KEY (`employee_code`)
    REFERENCES `employee` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `stock`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock` (
  `quantity` DOUBLE NULL DEFAULT 0,
  `bundles` DOUBLE NULL DEFAULT 0,
  `item_code` VARCHAR(10) NOT NULL,
  `min_limit` DOUBLE NULL,
  PRIMARY KEY (`item_code`),
  INDEX `fk_stock_item1` (`item_code` ASC),
  CONSTRAINT `fk_stock_item1`
    FOREIGN KEY (`item_code`)
    REFERENCES `item` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `view_panel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `view_panel` (
  `view_panel` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`view_panel`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `operator_has_view_panel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `operator_has_view_panel` (
  `operator_username` VARCHAR(15) NOT NULL,
  `view_panel_view_panel` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`operator_username`, `view_panel_view_panel`),
  INDEX `fk_operator_has_view_panel_view_panel1` (`view_panel_view_panel` ASC),
  INDEX `fk_operator_has_view_panel_operator1` (`operator_username` ASC),
  CONSTRAINT `fk_operator_has_view_panel_operator1`
    FOREIGN KEY (`operator_username`)
    REFERENCES `operator` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_operator_has_view_panel_view_panel1`
    FOREIGN KEY (`view_panel_view_panel`)
    REFERENCES `view_panel` (`view_panel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `purchase_invoice_has_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `purchase_invoice_has_item` (
  `purchase_invoice_inv_no` VARCHAR(20) NOT NULL,
  `purchase_invoice_supplier_code` VARCHAR(10) NOT NULL,
  `item_code` VARCHAR(10) NOT NULL,
  `quantity` DOUBLE NULL DEFAULT 0,
  `cost` DOUBLE NULL DEFAULT 0,
  `discount` DOUBLE NULL DEFAULT 0,
  PRIMARY KEY (`purchase_invoice_inv_no`, `purchase_invoice_supplier_code`, `item_code`),
  INDEX `fk_purchase_invoice_has_item_item1` (`item_code` ASC),
  INDEX `fk_purchase_invoice_has_item_purchase_invoice1` (`purchase_invoice_inv_no` ASC, `purchase_invoice_supplier_code` ASC),
  CONSTRAINT `fk_purchase_invoice_has_item_purchase_invoice1`
    FOREIGN KEY (`purchase_invoice_inv_no` , `purchase_invoice_supplier_code`)
    REFERENCES `purchase_invoice` (`inv_no` , `supplier_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_purchase_invoice_has_item_item1`
    FOREIGN KEY (`item_code`)
    REFERENCES `item` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `stock_transfer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_transfer` (
  `employee_code` VARCHAR(15) NOT NULL,
  `item_code` VARCHAR(10) NOT NULL,
  `quantity` DOUBLE NULL,
  `transfer_date` DATETIME NOT NULL,
  `rate` DOUBLE NULL,
  PRIMARY KEY (`employee_code`, `item_code`, `transfer_date`),
  INDEX `fk_employee_has_item_item1` (`item_code` ASC),
  INDEX `fk_employee_has_item_employee1` (`employee_code` ASC),
  CONSTRAINT `fk_employee_has_item_employee1`
    FOREIGN KEY (`employee_code`)
    REFERENCES `employee` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_employee_has_item_item1`
    FOREIGN KEY (`item_code`)
    REFERENCES `item` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `rep_sale_value`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rep_sale_value` (
  `sale_date` DATETIME NOT NULL,
  `amount` DOUBLE NULL,
  `employee_code` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`sale_date`, `employee_code`),
  INDEX `fk_rep_sale_value_employee1` (`employee_code` ASC),
  CONSTRAINT `fk_rep_sale_value_employee1`
    FOREIGN KEY (`employee_code`)
    REFERENCES `employee` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `stock_change_summery`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_change_summery` (
  `deferent` DOUBLE NULL,
  `change_date` DATETIME NOT NULL,
  PRIMARY KEY (`change_date`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `stock_change`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_change` (
  `old_quantity` DOUBLE NULL,
  `actual_quantity` DOUBLE NULL,
  `rate` DOUBLE NULL,
  `item_code` VARCHAR(10) NOT NULL,
  `stock_change_summery_change_date` DATETIME NOT NULL,
  PRIMARY KEY (`item_code`, `stock_change_summery_change_date`),
  INDEX `fk_stock_change_stock_change_summery1` (`stock_change_summery_change_date` ASC),
  CONSTRAINT `fk_stock_change_item1`
    FOREIGN KEY (`item_code`)
    REFERENCES `item` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_stock_change_stock_change_summery1`
    FOREIGN KEY (`stock_change_summery_change_date`)
    REFERENCES `stock_change_summery` (`change_date`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `price_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `price_type` (
  `type` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`type`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `item_has_price`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `item_has_price` (
  `item_code` VARCHAR(10) NOT NULL,
  `price_type_type` VARCHAR(20) NOT NULL,
  `price` DOUBLE NOT NULL,
  `units` INT NOT NULL,
  PRIMARY KEY (`item_code`, `price_type_type`),
  INDEX `fk_item_has_price_type_price_type1_idx` (`price_type_type` ASC),
  INDEX `fk_item_has_price_type_item1_idx` (`item_code` ASC),
  CONSTRAINT `fk_item_has_price_type_item1`
    FOREIGN KEY (`item_code`)
    REFERENCES `item` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_has_price_type_price_type1`
    FOREIGN KEY (`price_type_type`)
    REFERENCES `price_type` (`type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `old_price`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `old_price` (
  `change_date` DATETIME NOT NULL,
  `old_price` DOUBLE NULL,
  `new_price` DOUBLE NULL,
  `item_has_price_item_code` VARCHAR(10) NOT NULL,
  `item_has_price_price_type_type` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`change_date`, `item_has_price_item_code`, `item_has_price_price_type_type`),
  INDEX `fk_old_price_item_has_price1_idx` (`item_has_price_item_code` ASC, `item_has_price_price_type_type` ASC),
  CONSTRAINT `fk_old_price_item_has_price1`
    FOREIGN KEY (`item_has_price_item_code` , `item_has_price_price_type_type`)
    REFERENCES `item_has_price` (`item_code` , `price_type_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sale_invoice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sale_invoice` (
  `inv_no` VARCHAR(20) NOT NULL,
  `inv_time` DATETIME NULL DEFAULT NULL,
  `amount` DOUBLE NULL DEFAULT 0,
  `customer_code` VARCHAR(10) NOT NULL,
  `received_amount` DOUBLE NULL DEFAULT 0,
  `discount` DOUBLE NULL DEFAULT 0,
  `credit` DOUBLE NULL DEFAULT 0,
  `printed` INT(2) NULL DEFAULT 0,
  `operator` VARCHAR(15) NULL,
  `employee_code` VARCHAR(15) NOT NULL,
  `card_number` VARCHAR(10) NULL,
  `customer_name` VARCHAR(150) NULL,
  `initial_payment` DOUBLE NULL,
  `number_of_terms` INT NULL,
  `paid_by_credit_card` DOUBLE NULL,
  `term_amount` DOUBLE NULL,
  PRIMARY KEY (`inv_no`),
  INDEX `fk_sale_invoice_customer1` (`customer_code` ASC),
  INDEX `fk_sale_invoice_employee1_idx` (`employee_code` ASC),
  UNIQUE INDEX `card_number_UNIQUE` (`card_number` ASC),
  CONSTRAINT `fk_sale_invoice_customer10`
    FOREIGN KEY (`customer_code`)
    REFERENCES `customer` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sale_invoice_employee1`
    FOREIGN KEY (`employee_code`)
    REFERENCES `employee` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `collection_receipt`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `collection_receipt` (
  `receipt_number` VARCHAR(15) NOT NULL,
  `sale_invoice_inv_no` VARCHAR(20) NOT NULL,
  `collected_time` DATETIME NULL,
  `operator` VARCHAR(15) NULL,
  `amount` DOUBLE NULL,
  PRIMARY KEY (`receipt_number`),
  INDEX `fk_collection_receipt_sale_invoice1` (`sale_invoice_inv_no` ASC),
  CONSTRAINT `fk_collection_receipt_sale_invoice1`
    FOREIGN KEY (`sale_invoice_inv_no`)
    REFERENCES `sale_invoice` (`inv_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sale_cheque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sale_cheque` (
  `cheque_number` VARCHAR(30) NOT NULL,
  `bank_code` VARCHAR(30) NOT NULL,
  `amount` DOUBLE NULL DEFAULT '0',
  `banking_date` DATE NULL DEFAULT NULL,
  `status` INT(1) NULL DEFAULT '0',
  `collection_receipt_receipt_number` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`cheque_number`, `bank_code`, `collection_receipt_receipt_number`),
  INDEX `fk_sale_cheque_bank1` (`bank_code` ASC),
  INDEX `fk_sale_cheque_collection_receipt1` (`collection_receipt_receipt_number` ASC),
  CONSTRAINT `fk_sale_cheque_bank10`
    FOREIGN KEY (`bank_code`)
    REFERENCES `bank` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sale_cheque_collection_receipt1`
    FOREIGN KEY (`collection_receipt_receipt_number`)
    REFERENCES `collection_receipt` (`receipt_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sale_invoice_has_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sale_invoice_has_item` (
  `sale_invoice_inv_no` VARCHAR(20) NOT NULL,
  `item_code` VARCHAR(10) NOT NULL,
  `rate` DOUBLE NULL DEFAULT '0',
  `quantity` DOUBLE NULL DEFAULT '0',
  `discount` DOUBLE NULL DEFAULT '0',
  `cost` DOUBLE NULL,
  PRIMARY KEY (`sale_invoice_inv_no`, `item_code`),
  INDEX `fk_sale_invoice_has_item_sale_invoice1` (`sale_invoice_inv_no` ASC),
  INDEX `fk_sale_invoice_has_item_item1` (`item_code` ASC),
  CONSTRAINT `fk_sale_invoice_has_item_item10`
    FOREIGN KEY (`item_code`)
    REFERENCES `item` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sale_invoice_has_item_sale_invoice10`
    FOREIGN KEY (`sale_invoice_inv_no`)
    REFERENCES `sale_invoice` (`inv_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sale_cash`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sale_cash` (
  `amount` DOUBLE NULL DEFAULT '0',
  `collection_receipt_receipt_number` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`collection_receipt_receipt_number`),
  CONSTRAINT `fk_sale_cash_collection_receipt1`
    FOREIGN KEY (`collection_receipt_receipt_number`)
    REFERENCES `collection_receipt` (`receipt_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `expenses_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `expenses_type` (
  `code` VARCHAR(10) NOT NULL,
  `description` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `expenses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `expenses` (
  `amount` DOUBLE NULL DEFAULT 0,
  `notes` VARCHAR(255) NULL DEFAULT NULL,
  `paid_time` DATETIME NOT NULL,
  `expenses_type_code` VARCHAR(10) NOT NULL,
  INDEX `fk_expenses_expenses_type1` (`expenses_type_code` ASC),
  PRIMARY KEY (`paid_time`),
  CONSTRAINT `fk_expenses_expenses_type10`
    FOREIGN KEY (`expenses_type_code`)
    REFERENCES `expenses_type` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `issued_cheque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `issued_cheque` (
  `cheque_number` VARCHAR(30) NOT NULL,
  `issued_date` DATETIME NULL DEFAULT NULL,
  `banking_date` DATE NULL DEFAULT NULL,
  `amount` DOUBLE NULL DEFAULT '0',
  `status` INT(1) NULL DEFAULT NULL,
  `bank_code` VARCHAR(30) NOT NULL,
  `operator` VARCHAR(15) NULL,
  PRIMARY KEY (`cheque_number`),
  INDEX `fk_issued_cheque_bank1` (`bank_code` ASC),
  CONSTRAINT `fk_issued_cheque_bank1`
    FOREIGN KEY (`bank_code`)
    REFERENCES `bank` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `issued_cash`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `issued_cash` (
  `amount` DOUBLE NOT NULL DEFAULT '0',
  `issued_time` DATETIME NOT NULL,
  `purchase_invoice_inv_no` VARCHAR(20) NOT NULL,
  `purchase_invoice_supplier_code` VARCHAR(10) NOT NULL,
  `bank_code` VARCHAR(30) NOT NULL,
  `operator` VARCHAR(15) NULL,
  PRIMARY KEY (`issued_time`),
  INDEX `fk_issued_cash_purchase_invoice1` (`purchase_invoice_inv_no` ASC, `purchase_invoice_supplier_code` ASC),
  INDEX `fk_issued_cash_bank1` (`bank_code` ASC),
  CONSTRAINT `fk_issued_cash_purchase_invoice10`
    FOREIGN KEY (`purchase_invoice_inv_no` , `purchase_invoice_supplier_code`)
    REFERENCES `purchase_invoice` (`inv_no` , `supplier_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_issued_cash_bank1`
    FOREIGN KEY (`bank_code`)
    REFERENCES `bank` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sub_dealer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sub_dealer` (
  `code` VARCHAR(10) NOT NULL,
  `name` VARCHAR(100) NULL,
  `owner` VARCHAR(100) NULL,
  `address` VARCHAR(50) NULL,
  `street` VARCHAR(50) NULL,
  `contact` VARCHAR(10) NULL,
  `town_code` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`code`),
  INDEX `fk_sub_dealer_town1` (`town_code` ASC),
  CONSTRAINT `fk_sub_dealer_town1`
    FOREIGN KEY (`town_code`)
    REFERENCES `town` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `employee_has_root_area`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `employee_has_root_area` (
  `employee_code` VARCHAR(15) NOT NULL,
  `root_area_code` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`employee_code`, `root_area_code`),
  INDEX `fk_employee_has_root_area_root_area1` (`root_area_code` ASC),
  INDEX `fk_employee_has_root_area_employee1` (`employee_code` ASC),
  CONSTRAINT `fk_employee_has_root_area_employee1`
    FOREIGN KEY (`employee_code`)
    REFERENCES `employee` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_employee_has_root_area_root_area1`
    FOREIGN KEY (`root_area_code`)
    REFERENCES `root_area` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `rep_stock_change`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rep_stock_change` (
  `old_quantity` DOUBLE NULL,
  `actual_quantity` DOUBLE NULL,
  `rate` DOUBLE NULL,
  `item_code` VARCHAR(10) NOT NULL,
  `change_date` DATE NOT NULL,
  `employee_code` VARCHAR(15) NOT NULL,
  `operator` VARCHAR(15) NULL,
  PRIMARY KEY (`item_code`, `employee_code`, `change_date`),
  INDEX `fk_rep_stock_change_employee1` (`employee_code` ASC),
  CONSTRAINT `fk_rep_stock_change_item1`
    FOREIGN KEY (`item_code`)
    REFERENCES `item` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rep_stock_change_employee1`
    FOREIGN KEY (`employee_code`)
    REFERENCES `employee` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `company` (
  `code` VARCHAR(20) NOT NULL,
  `Name` VARCHAR(45) NULL,
  `slogan_one` VARCHAR(100) NULL,
  `slogan_two` VARCHAR(100) NULL,
  `address_number` VARCHAR(60) NULL,
  `address_street` VARCHAR(60) NULL,
  `address_city` VARCHAR(60) NULL,
  `contact_one` VARCHAR(10) NULL,
  `contact_two` VARCHAR(10) NULL,
  `fax` VARCHAR(10) NULL,
  `email` VARCHAR(100) NULL,
  `web` VARCHAR(100) NULL,
  PRIMARY KEY (`code`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `operator_deleted`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `operator_deleted` (
  `username` VARCHAR(15) NOT NULL,
  `password` VARCHAR(25) NULL DEFAULT NULL,
  `power` INT(1) NULL DEFAULT NULL,
  `created_By` VARCHAR(15) NULL DEFAULT NULL,
  `created_date` DATETIME NULL,
  `deleted_by` VARCHAR(15) NULL,
  `deleted_date` DATETIME NOT NULL,
  `employee_code` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`deleted_date`),
  INDEX `fk_operator_deleted_employee1` (`employee_code` ASC),
  CONSTRAINT `fk_operator_deleted_employee1`
    FOREIGN KEY (`employee_code`)
    REFERENCES `employee` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `supplier_has_bank`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supplier_has_bank` (
  `supplier_code` VARCHAR(10) NOT NULL,
  `bank_code` VARCHAR(30) NOT NULL,
  `account_number` VARCHAR(30) NULL,
  PRIMARY KEY (`supplier_code`, `bank_code`),
  INDEX `fk_supplier_has_bank_bank1` (`bank_code` ASC),
  INDEX `fk_supplier_has_bank_supplier1` (`supplier_code` ASC),
  CONSTRAINT `fk_supplier_has_bank_supplier1`
    FOREIGN KEY (`supplier_code`)
    REFERENCES `supplier` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_supplier_has_bank_bank1`
    FOREIGN KEY (`bank_code`)
    REFERENCES `bank` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `menu` (
  `menu` VARCHAR(100) NOT NULL,
  `status` INT(1) NULL,
  PRIMARY KEY (`menu`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `menu_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `menu_item` (
  `menu_menu` VARCHAR(100) NOT NULL,
  `menu_item` VARCHAR(100) NOT NULL,
  `status` INT(1) NULL,
  PRIMARY KEY (`menu_menu`, `menu_item`),
  INDEX `fk_menu_item_menu1` (`menu_menu` ASC),
  CONSTRAINT `fk_menu_item_menu1`
    FOREIGN KEY (`menu_menu`)
    REFERENCES `menu` (`menu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `canceled_invoice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `canceled_invoice` (
  `inv_no` VARCHAR(20) NOT NULL,
  `inv_time` DATETIME NULL DEFAULT NULL,
  `amount` DOUBLE NULL DEFAULT '0',
  `customer_code` VARCHAR(10) NOT NULL,
  `received_amount` DOUBLE NULL DEFAULT '0',
  `discount` DOUBLE NULL DEFAULT '0',
  `credit` DOUBLE NULL DEFAULT '0',
  `operator` VARCHAR(15) NULL,
  PRIMARY KEY (`inv_no`),
  INDEX `fk_sale_invoice_customer1` (`customer_code` ASC),
  CONSTRAINT `fk_sale_invoice_customer100`
    FOREIGN KEY (`customer_code`)
    REFERENCES `customer` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `canceled_invoice_has_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `canceled_invoice_has_item` (
  `canceled_invoice_inv_no` VARCHAR(20) NOT NULL,
  `item_code` VARCHAR(10) NOT NULL,
  `rate` DOUBLE NULL,
  `quantity` DOUBLE NULL,
  `discount` DOUBLE NULL,
  PRIMARY KEY (`canceled_invoice_inv_no`, `item_code`),
  INDEX `fk_canceled_invoice_has_item_item1` (`item_code` ASC),
  INDEX `fk_canceled_invoice_has_item_canceled_invoice1` (`canceled_invoice_inv_no` ASC),
  CONSTRAINT `fk_canceled_invoice_has_item_canceled_invoice1`
    FOREIGN KEY (`canceled_invoice_inv_no`)
    REFERENCES `canceled_invoice` (`inv_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_canceled_invoice_has_item_item1`
    FOREIGN KEY (`item_code`)
    REFERENCES `item` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `location` (
  `id` VARCHAR(20) NOT NULL,
  `name` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `item_has_location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `item_has_location` (
  `item_code` VARCHAR(10) NOT NULL,
  `location_id` VARCHAR(20) NOT NULL,
  `quantity` DOUBLE NULL,
  `bundles` DOUBLE NULL,
  PRIMARY KEY (`item_code`, `location_id`),
  INDEX `fk_item_has_location_location1_idx` (`location_id` ASC),
  INDEX `fk_item_has_location_item1_idx` (`item_code` ASC),
  CONSTRAINT `fk_item_has_location_item1`
    FOREIGN KEY (`item_code`)
    REFERENCES `item` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_has_location_location1`
    FOREIGN KEY (`location_id`)
    REFERENCES `location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `optional_component`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `optional_component` (
  `name` VARCHAR(100) NOT NULL,
  `status` INT NULL,
  `view_panel_view_panel` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`name`, `view_panel_view_panel`),
  INDEX `fk_optional_component_view_panel1_idx` (`view_panel_view_panel` ASC),
  CONSTRAINT `fk_optional_component_view_panel1`
    FOREIGN KEY (`view_panel_view_panel`)
    REFERENCES `view_panel` (`view_panel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `issued_cheque_has_purchase_invoice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `issued_cheque_has_purchase_invoice` (
  `issued_cheque_cheque_number` VARCHAR(30) NOT NULL,
  `purchase_invoice_inv_no` VARCHAR(20) NOT NULL,
  `purchase_invoice_supplier_code` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`issued_cheque_cheque_number`, `purchase_invoice_inv_no`, `purchase_invoice_supplier_code`),
  INDEX `fk_issued_cheque_has_purchase_invoice_purchase_invoice1_idx` (`purchase_invoice_inv_no` ASC, `purchase_invoice_supplier_code` ASC),
  INDEX `fk_issued_cheque_has_purchase_invoice_issued_cheque1_idx` (`issued_cheque_cheque_number` ASC),
  CONSTRAINT `fk_issued_cheque_has_purchase_invoice_issued_cheque1`
    FOREIGN KEY (`issued_cheque_cheque_number`)
    REFERENCES `issued_cheque` (`cheque_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_issued_cheque_has_purchase_invoice_purchase_invoice1`
    FOREIGN KEY (`purchase_invoice_inv_no` , `purchase_invoice_supplier_code`)
    REFERENCES `purchase_invoice` (`inv_no` , `supplier_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `tool_bar_button`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tool_bar_button` (
  `component_name` VARCHAR(150) NOT NULL,
  `button_text` VARCHAR(45) NULL,
  `icon_path` VARCHAR(1000) NULL,
  `status` INT NULL,
  PRIMARY KEY (`component_name`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
