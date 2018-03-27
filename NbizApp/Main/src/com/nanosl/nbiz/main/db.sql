-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 29, 2017 at 11:29 AM
-- Server version: 5.7.20-0ubuntu0.16.04.1
-- PHP Version: 7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+05:30";

--
-- Database: `eis`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `balance` double DEFAULT NULL,
  `bank_code` varchar(255) NOT NULL,
  `account_no` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bank`
--

CREATE TABLE `bank` (
  `code` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `canceled_invoice`
--

CREATE TABLE `canceled_invoice` (
  `inv_no` varchar(255) NOT NULL,
  `amount` double DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `inv_time` datetime DEFAULT NULL,
  `operator` varchar(255) DEFAULT NULL,
  `received_amount` double DEFAULT NULL,
  `customer_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `canceled_invoice_has_item`
--

CREATE TABLE `canceled_invoice_has_item` (
  `discount` double DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `canceled_invoice_inv_no` varchar(255) NOT NULL,
  `item_code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `cash_box`
--

CREATE TABLE `cash_box` (
  `id` varchar(255) NOT NULL,
  `balance` double DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `cash_log`
--

CREATE TABLE `cash_log` (
  `amount` double DEFAULT NULL,
  `box_balance` double DEFAULT NULL,
  `entity` varchar(255) DEFAULT NULL,
  `entity_id` longblob,
  `cash_box_id` varchar(255) NOT NULL,
  `log_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `collection_receipt`
--

CREATE TABLE `collection_receipt` (
  `receipt_number` varchar(255) NOT NULL,
  `amount` double DEFAULT NULL,
  `amount_in_cash` double DEFAULT NULL,
  `collected_time` datetime DEFAULT NULL,
  `operator` varchar(255) DEFAULT NULL,
  `customer_code` varchar(255) DEFAULT NULL,
  `sale_invoice_inv_no` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE `company` (
  `code` varchar(255) NOT NULL,
  `address_city` varchar(255) DEFAULT NULL,
  `address_number` varchar(255) DEFAULT NULL,
  `address_street` varchar(255) DEFAULT NULL,
  `contact_one` varchar(255) DEFAULT NULL,
  `contact_two` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `slogan_one` varchar(255) DEFAULT NULL,
  `slogan_two` varchar(255) DEFAULT NULL,
  `svat` varchar(255) DEFAULT NULL,
  `vat` varchar(255) DEFAULT NULL,
  `web` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `config`
--

CREATE TABLE `config` (
  `config_key` varchar(255) NOT NULL,
  `config_value` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `code` varchar(255) NOT NULL,
  `credit` double DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `fixedLine` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `operator` varchar(255) DEFAULT NULL,
  `person_nic` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `damage_notes`
--

CREATE TABLE `damage_notes` (
  `operator` varchar(255) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `date_Time` datetime NOT NULL,
  `item_code` varchar(255) NOT NULL,
  `employee_code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `damage_stock`
--

CREATE TABLE `damage_stock` (
  `item_code` varchar(255) NOT NULL,
  `quantity` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `code` varchar(255) NOT NULL,
  `Fixed_Line` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `source` int(11) DEFAULT NULL,
  `employee_position_code` varchar(255) DEFAULT NULL,
  `person_nic` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee_has_root_area`
--

CREATE TABLE `employee_has_root_area` (
  `employee_code` varchar(255) NOT NULL,
  `root_area_code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee_position`
--

CREATE TABLE `employee_position` (
  `code` varchar(255) NOT NULL,
  `description` longtext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `expenses`
--

CREATE TABLE `expenses` (
  `paid_time` datetime NOT NULL,
  `amount` double DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `expenses_type_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `expenses_type`
--

CREATE TABLE `expenses_type` (
  `code` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `find`
--

CREATE TABLE `find` (
  `ID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `fix`
--

CREATE TABLE `fix` (
  `fix_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `general`
--

CREATE TABLE `general` (
  `id` int(11) NOT NULL,
  `invoice_no` varchar(255) DEFAULT NULL,
  `profitPresentage` double DEFAULT NULL,
  `quotation_no` varchar(255) DEFAULT NULL,
  `receipt_no` varchar(255) DEFAULT NULL,
  `strike` int(11) DEFAULT NULL,
  `strikeRate` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `issued_cash`
--

CREATE TABLE `issued_cash` (
  `issued_time` datetime NOT NULL,
  `amount` double DEFAULT NULL,
  `operator` varchar(255) DEFAULT NULL,
  `bank_code` varchar(255) DEFAULT NULL,
  `purchase_invoice_supplier_code` varchar(255) DEFAULT NULL,
  `purchase_invoice_inv_no` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `issued_cheque`
--

CREATE TABLE `issued_cheque` (
  `cheque_number` varchar(255) NOT NULL,
  `amount` double DEFAULT NULL,
  `banking_date` date DEFAULT NULL,
  `issued_date` datetime DEFAULT NULL,
  `operator` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `account_account_no` varchar(255) DEFAULT NULL,
  `account_bank_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `issued_cheque_has_purchase_invoice`
--

CREATE TABLE `issued_cheque_has_purchase_invoice` (
  `issued_cheque_cheque_number` varchar(255) NOT NULL,
  `purchase_invoice_inv_no` varchar(255) NOT NULL,
  `purchase_invoice_supplier_code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `code` varchar(255) NOT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `customerProfitPersantage` double DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `itemRefresh` int(11) DEFAULT NULL,
  `operator` varchar(255) DEFAULT NULL,
  `packSize` int(11) DEFAULT NULL,
  `profitPersantage` double DEFAULT NULL,
  `qkey` int(11) DEFAULT NULL,
  `retailProfitPersantage` double DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `item_type_type` varchar(255) DEFAULT NULL,
  `supplier_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `item_category`
--

CREATE TABLE `item_category` (
  `category` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `item_has_price`
--

CREATE TABLE `item_has_price` (
  `price` double DEFAULT NULL,
  `units` int(11) DEFAULT NULL,
  `price_type_type` varchar(255) NOT NULL,
  `item_code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `item_type`
--

CREATE TABLE `item_type` (
  `type` varchar(255) NOT NULL,
  `item_category_category` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `last_code`
--

CREATE TABLE `last_code` (
  `type` varchar(255) NOT NULL,
  `code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `list_types`
--

CREATE TABLE `list_types` (
  `code` varchar(255) NOT NULL,
  `type` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `loan`
--

CREATE TABLE `loan` (
  `code` varchar(255) NOT NULL,
  `amount` double DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `interest_paid` double DEFAULT NULL,
  `interest_rate` double DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `paid` double DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `term_amount` double DEFAULT NULL,
  `bank_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `menu` varchar(255) NOT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `menu_item`
--

CREATE TABLE `menu_item` (
  `status` int(11) DEFAULT NULL,
  `menu_menu` varchar(255) NOT NULL,
  `menu_item` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `old_price`
--

CREATE TABLE `old_price` (
  `new_price` double DEFAULT NULL,
  `old_price` double DEFAULT NULL,
  `item_code` varchar(255) NOT NULL,
  `change_date` datetime NOT NULL,
  `item_has_price_price_type_type` varchar(255) DEFAULT NULL,
  `item_has_price_item_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `operator`
--

CREATE TABLE `operator` (
  `username` varchar(255) NOT NULL,
  `created_By` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `power` int(11) DEFAULT NULL,
  `employee_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `operator_deleted`
--

CREATE TABLE `operator_deleted` (
  `deleted_date` datetime NOT NULL,
  `created_By` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `deleted_by` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `power` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `employee_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `operator_has_view_panel`
--

CREATE TABLE `operator_has_view_panel` (
  `operator_username` varchar(255) NOT NULL,
  `view_panel_view_panel` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `optional_component`
--

CREATE TABLE `optional_component` (
  `status` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `view_panel_view_panel` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `nic` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `operator` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `price_list`
--

CREATE TABLE `price_list` (
  `item_code` varchar(255) NOT NULL,
  `cost_Pack` double DEFAULT NULL,
  `cost_Unit` double DEFAULT NULL,
  `selling_Pack` double DEFAULT NULL,
  `selling_Unit` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `price_type`
--

CREATE TABLE `price_type` (
  `type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `purchase_invoice`
--

CREATE TABLE `purchase_invoice` (
  `amount` double DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `inv_date` date DEFAULT NULL,
  `operator` varchar(255) DEFAULT NULL,
  `inv_no` varchar(255) NOT NULL,
  `supplier_code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `purchase_invoice_has_item`
--

CREATE TABLE `purchase_invoice_has_item` (
  `cost` double DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `free_quantity` double DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `purchase_invoice_inv_no` varchar(255) NOT NULL,
  `item_code` varchar(255) NOT NULL,
  `purchase_invoice_supplier_code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `quotation`
--

CREATE TABLE `quotation` (
  `quotation_no` varchar(255) NOT NULL,
  `amount` double DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `employee_code` varchar(255) DEFAULT NULL,
  `operator` varchar(255) DEFAULT NULL,
  `printed` int(11) DEFAULT NULL,
  `quotation_time` datetime DEFAULT NULL,
  `customer_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `quotation_has_item`
--

CREATE TABLE `quotation_has_item` (
  `cost` double DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `quotation_quotation_no` varchar(255) NOT NULL,
  `item_code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `rep_sale`
--

CREATE TABLE `rep_sale` (
  `loaded` double DEFAULT NULL,
  `loaded_Bundles` double DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `remaining` double DEFAULT NULL,
  `remaining_Bundles` double DEFAULT NULL,
  `item_code` varchar(255) NOT NULL,
  `sale_date` date NOT NULL,
  `employee_code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `rep_sale_value`
--

CREATE TABLE `rep_sale_value` (
  `amount` double DEFAULT NULL,
  `sale_date` datetime NOT NULL,
  `employee_code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `rep_stock_change`
--

CREATE TABLE `rep_stock_change` (
  `actual_quantity` double DEFAULT NULL,
  `old_quantity` double DEFAULT NULL,
  `operator` varchar(255) DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `item_code` varchar(255) NOT NULL,
  `change_date` date NOT NULL,
  `employee_code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `root_area`
--

CREATE TABLE `root_area` (
  `code` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sale_cash`
--

CREATE TABLE `sale_cash` (
  `collection_receipt_receipt_number` varchar(255) NOT NULL,
  `amount` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sale_cheque`
--

CREATE TABLE `sale_cheque` (
  `amount` double DEFAULT NULL,
  `banking_date` date DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `bank_code` varchar(255) NOT NULL,
  `cheque_number` varchar(255) NOT NULL,
  `collection_receipt_receipt_number` varchar(255) NOT NULL,
  `account_account_no` varchar(255) DEFAULT NULL,
  `account_bank_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sale_invoice`
--

CREATE TABLE `sale_invoice` (
  `inv_no` varchar(255) NOT NULL,
  `amount` double DEFAULT NULL,
  `card_number` varchar(255) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `initial_payment` double DEFAULT NULL,
  `inv_time` datetime DEFAULT NULL,
  `number_of_terms` int(11) DEFAULT NULL,
  `operator` varchar(255) DEFAULT NULL,
  `paid_by_credit_card` double DEFAULT NULL,
  `printed` int(11) DEFAULT NULL,
  `received_amount` double DEFAULT NULL,
  `term_amount` double DEFAULT NULL,
  `customer_code` varchar(255) DEFAULT NULL,
  `employee_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sale_invoice_has_item`
--

CREATE TABLE `sale_invoice_has_item` (
  `cost` double DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `item_code` varchar(255) NOT NULL,
  `sale_invoice_inv_no` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sr_sales_payments`
--

CREATE TABLE `sr_sales_payments` (
  `amount` double DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `settled_Amount` double DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `payment_date` date NOT NULL,
  `employee_code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sr_stock`
--

CREATE TABLE `sr_stock` (
  `bundles` double DEFAULT NULL,
  `pack_price` double DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `unit_price` double DEFAULT NULL,
  `item_code` varchar(255) NOT NULL,
  `employee_code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `item_code` varchar(255) NOT NULL,
  `bundles` double DEFAULT NULL,
  `min_limit` double DEFAULT NULL,
  `quantity` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `stock_change`
--

CREATE TABLE `stock_change` (
  `actual_quantity` double DEFAULT NULL,
  `old_quantity` double DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `stock_change_summery_change_date` datetime NOT NULL,
  `item_code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `stock_change_summery`
--

CREATE TABLE `stock_change_summery` (
  `change_date` datetime NOT NULL,
  `deferent` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `stock_transfer`
--

CREATE TABLE `stock_transfer` (
  `quantity` double DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `item_code` varchar(255) NOT NULL,
  `transfer_date` datetime NOT NULL,
  `employee_code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sub_dealer`
--

CREATE TABLE `sub_dealer` (
  `code` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `owner` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `town_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `code` varchar(255) NOT NULL,
  `address_Number` varchar(255) DEFAULT NULL,
  `address_Street` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `fixed_Line` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `svat` varchar(255) DEFAULT NULL,
  `vat` varchar(255) DEFAULT NULL,
  `town_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `supplier_has_bank`
--

CREATE TABLE `supplier_has_bank` (
  `account_number` varchar(255) DEFAULT NULL,
  `bank_code` varchar(255) NOT NULL,
  `supplier_code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `svat`
--

CREATE TABLE `svat` (
  `serial_number` int(11) NOT NULL,
  `ending_month` date DEFAULT NULL,
  `issued_date` datetime DEFAULT NULL,
  `purchasing_amount` double DEFAULT NULL,
  `svat_amount` double DEFAULT NULL,
  `supplier_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `term`
--

CREATE TABLE `term` (
  `amount` double DEFAULT NULL,
  `interest_amount` double DEFAULT NULL,
  `paid_date` datetime DEFAULT NULL,
  `premium_amount` double DEFAULT NULL,
  `receipt` varchar(255) NOT NULL,
  `loan_code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tool_bar_button`
--

CREATE TABLE `tool_bar_button` (
  `component_name` varchar(255) NOT NULL,
  `button_text` varchar(255) DEFAULT NULL,
  `icon_path` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `town`
--

CREATE TABLE `town` (
  `code` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `root_area_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `view_panel`
--

CREATE TABLE `view_panel` (
  `view_panel` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`bank_code`,`account_no`);

--
-- Indexes for table `bank`
--
ALTER TABLE `bank`
  ADD PRIMARY KEY (`code`);

--
-- Indexes for table `canceled_invoice`
--
ALTER TABLE `canceled_invoice`
  ADD PRIMARY KEY (`inv_no`),
  ADD KEY `FK_canceled_invoice_customer_code` (`customer_code`);

--
-- Indexes for table `canceled_invoice_has_item`
--
ALTER TABLE `canceled_invoice_has_item`
  ADD PRIMARY KEY (`canceled_invoice_inv_no`,`item_code`),
  ADD KEY `FK_canceled_invoice_has_item_item_code` (`item_code`);

--
-- Indexes for table `cash_box`
--
ALTER TABLE `cash_box`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cash_log`
--
ALTER TABLE `cash_log`
  ADD PRIMARY KEY (`cash_box_id`,`log_time`);

--
-- Indexes for table `collection_receipt`
--
ALTER TABLE `collection_receipt`
  ADD PRIMARY KEY (`receipt_number`),
  ADD KEY `FK_collection_receipt_customer_code` (`customer_code`),
  ADD KEY `FK_collection_receipt_sale_invoice_inv_no` (`sale_invoice_inv_no`);

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`code`);

--
-- Indexes for table `config`
--
ALTER TABLE `config`
  ADD PRIMARY KEY (`config_key`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`code`),
  ADD KEY `FK_customer_person_nic` (`person_nic`);

--
-- Indexes for table `damage_notes`
--
ALTER TABLE `damage_notes`
  ADD PRIMARY KEY (`date_Time`,`item_code`,`employee_code`),
  ADD KEY `FK_damage_notes_item_code` (`item_code`),
  ADD KEY `FK_damage_notes_employee_code` (`employee_code`);

--
-- Indexes for table `damage_stock`
--
ALTER TABLE `damage_stock`
  ADD PRIMARY KEY (`item_code`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`code`),
  ADD KEY `FK_employee_employee_position_code` (`employee_position_code`),
  ADD KEY `FK_employee_person_nic` (`person_nic`);

--
-- Indexes for table `employee_has_root_area`
--
ALTER TABLE `employee_has_root_area`
  ADD PRIMARY KEY (`employee_code`,`root_area_code`),
  ADD KEY `FK_employee_has_root_area_root_area_code` (`root_area_code`);

--
-- Indexes for table `employee_position`
--
ALTER TABLE `employee_position`
  ADD PRIMARY KEY (`code`);

--
-- Indexes for table `expenses`
--
ALTER TABLE `expenses`
  ADD PRIMARY KEY (`paid_time`),
  ADD KEY `FK_expenses_expenses_type_code` (`expenses_type_code`);

--
-- Indexes for table `expenses_type`
--
ALTER TABLE `expenses_type`
  ADD PRIMARY KEY (`code`);

--
-- Indexes for table `find`
--
ALTER TABLE `find`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `fix`
--
ALTER TABLE `fix`
  ADD PRIMARY KEY (`fix_id`);

--
-- Indexes for table `general`
--
ALTER TABLE `general`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `issued_cash`
--
ALTER TABLE `issued_cash`
  ADD PRIMARY KEY (`issued_time`),
  ADD KEY `FK_issued_cash_bank_code` (`bank_code`),
  ADD KEY `FK_issued_cash_purchase_invoice_inv_no` (`purchase_invoice_inv_no`,`purchase_invoice_supplier_code`);

--
-- Indexes for table `issued_cheque`
--
ALTER TABLE `issued_cheque`
  ADD PRIMARY KEY (`cheque_number`),
  ADD KEY `FK_issued_cheque_account_bank_code` (`account_bank_code`,`account_account_no`);

--
-- Indexes for table `issued_cheque_has_purchase_invoice`
--
ALTER TABLE `issued_cheque_has_purchase_invoice`
  ADD PRIMARY KEY (`issued_cheque_cheque_number`,`purchase_invoice_inv_no`,`purchase_invoice_supplier_code`),
  ADD KEY `issuedchequehaspurchaseinvoicepurchaseinvoiceinvno` (`purchase_invoice_inv_no`,`purchase_invoice_supplier_code`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`code`),
  ADD KEY `FK_item_supplier_code` (`supplier_code`),
  ADD KEY `FK_item_item_type_type` (`item_type_type`);

--
-- Indexes for table `item_category`
--
ALTER TABLE `item_category`
  ADD PRIMARY KEY (`category`);

--
-- Indexes for table `item_has_price`
--
ALTER TABLE `item_has_price`
  ADD PRIMARY KEY (`price_type_type`,`item_code`),
  ADD KEY `FK_item_has_price_item_code` (`item_code`);

--
-- Indexes for table `item_type`
--
ALTER TABLE `item_type`
  ADD PRIMARY KEY (`type`);

--
-- Indexes for table `last_code`
--
ALTER TABLE `last_code`
  ADD PRIMARY KEY (`type`);

--
-- Indexes for table `list_types`
--
ALTER TABLE `list_types`
  ADD PRIMARY KEY (`code`);

--
-- Indexes for table `loan`
--
ALTER TABLE `loan`
  ADD PRIMARY KEY (`code`),
  ADD KEY `FK_loan_bank_code` (`bank_code`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`menu`);

--
-- Indexes for table `menu_item`
--
ALTER TABLE `menu_item`
  ADD PRIMARY KEY (`menu_menu`,`menu_item`);

--
-- Indexes for table `old_price`
--
ALTER TABLE `old_price`
  ADD PRIMARY KEY (`item_code`,`change_date`),
  ADD KEY `FK_old_price_item_has_price_price_type_type` (`item_has_price_price_type_type`,`item_has_price_item_code`);

--
-- Indexes for table `operator`
--
ALTER TABLE `operator`
  ADD PRIMARY KEY (`username`),
  ADD KEY `FK_operator_employee_code` (`employee_code`);

--
-- Indexes for table `operator_deleted`
--
ALTER TABLE `operator_deleted`
  ADD PRIMARY KEY (`deleted_date`),
  ADD KEY `FK_operator_deleted_employee_code` (`employee_code`);

--
-- Indexes for table `operator_has_view_panel`
--
ALTER TABLE `operator_has_view_panel`
  ADD PRIMARY KEY (`operator_username`,`view_panel_view_panel`),
  ADD KEY `FK_operator_has_view_panel_view_panel_view_panel` (`view_panel_view_panel`);

--
-- Indexes for table `optional_component`
--
ALTER TABLE `optional_component`
  ADD PRIMARY KEY (`name`,`view_panel_view_panel`),
  ADD KEY `FK_optional_component_view_panel_view_panel` (`view_panel_view_panel`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`nic`);

--
-- Indexes for table `price_list`
--
ALTER TABLE `price_list`
  ADD PRIMARY KEY (`item_code`);

--
-- Indexes for table `price_type`
--
ALTER TABLE `price_type`
  ADD PRIMARY KEY (`type`);

--
-- Indexes for table `purchase_invoice`
--
ALTER TABLE `purchase_invoice`
  ADD PRIMARY KEY (`inv_no`,`supplier_code`),
  ADD KEY `FK_purchase_invoice_supplier_code` (`supplier_code`);

--
-- Indexes for table `purchase_invoice_has_item`
--
ALTER TABLE `purchase_invoice_has_item`
  ADD PRIMARY KEY (`purchase_invoice_inv_no`,`item_code`,`purchase_invoice_supplier_code`),
  ADD KEY `purchase_invoice_has_item_purchase_invoice_inv_no` (`purchase_invoice_inv_no`,`purchase_invoice_supplier_code`),
  ADD KEY `FK_purchase_invoice_has_item_item_code` (`item_code`);

--
-- Indexes for table `quotation`
--
ALTER TABLE `quotation`
  ADD PRIMARY KEY (`quotation_no`),
  ADD KEY `FK_quotation_customer_code` (`customer_code`);

--
-- Indexes for table `quotation_has_item`
--
ALTER TABLE `quotation_has_item`
  ADD PRIMARY KEY (`quotation_quotation_no`,`item_code`),
  ADD KEY `FK_quotation_has_item_item_code` (`item_code`);

--
-- Indexes for table `rep_sale`
--
ALTER TABLE `rep_sale`
  ADD PRIMARY KEY (`item_code`,`sale_date`,`employee_code`),
  ADD KEY `FK_rep_sale_employee_code` (`employee_code`);

--
-- Indexes for table `rep_sale_value`
--
ALTER TABLE `rep_sale_value`
  ADD PRIMARY KEY (`sale_date`,`employee_code`),
  ADD KEY `FK_rep_sale_value_employee_code` (`employee_code`);

--
-- Indexes for table `rep_stock_change`
--
ALTER TABLE `rep_stock_change`
  ADD PRIMARY KEY (`item_code`,`change_date`,`employee_code`),
  ADD KEY `FK_rep_stock_change_employee_code` (`employee_code`);

--
-- Indexes for table `root_area`
--
ALTER TABLE `root_area`
  ADD PRIMARY KEY (`code`);

--
-- Indexes for table `sale_cash`
--
ALTER TABLE `sale_cash`
  ADD PRIMARY KEY (`collection_receipt_receipt_number`);

--
-- Indexes for table `sale_cheque`
--
ALTER TABLE `sale_cheque`
  ADD PRIMARY KEY (`bank_code`,`cheque_number`,`collection_receipt_receipt_number`),
  ADD KEY `FK_sale_cheque_account_bank_code` (`account_bank_code`,`account_account_no`),
  ADD KEY `FK_sale_cheque_collection_receipt_receipt_number` (`collection_receipt_receipt_number`);

--
-- Indexes for table `sale_invoice`
--
ALTER TABLE `sale_invoice`
  ADD PRIMARY KEY (`inv_no`),
  ADD KEY `FK_sale_invoice_customer_code` (`customer_code`),
  ADD KEY `FK_sale_invoice_employee_code` (`employee_code`);

--
-- Indexes for table `sale_invoice_has_item`
--
ALTER TABLE `sale_invoice_has_item`
  ADD PRIMARY KEY (`item_code`,`sale_invoice_inv_no`),
  ADD KEY `FK_sale_invoice_has_item_sale_invoice_inv_no` (`sale_invoice_inv_no`);

--
-- Indexes for table `sr_sales_payments`
--
ALTER TABLE `sr_sales_payments`
  ADD PRIMARY KEY (`payment_date`,`employee_code`),
  ADD KEY `FK_sr_sales_payments_employee_code` (`employee_code`);

--
-- Indexes for table `sr_stock`
--
ALTER TABLE `sr_stock`
  ADD PRIMARY KEY (`item_code`,`employee_code`),
  ADD KEY `FK_sr_stock_employee_code` (`employee_code`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`item_code`);

--
-- Indexes for table `stock_change`
--
ALTER TABLE `stock_change`
  ADD PRIMARY KEY (`stock_change_summery_change_date`,`item_code`),
  ADD KEY `FK_stock_change_item_code` (`item_code`);

--
-- Indexes for table `stock_change_summery`
--
ALTER TABLE `stock_change_summery`
  ADD PRIMARY KEY (`change_date`);

--
-- Indexes for table `stock_transfer`
--
ALTER TABLE `stock_transfer`
  ADD PRIMARY KEY (`item_code`,`transfer_date`,`employee_code`),
  ADD KEY `FK_stock_transfer_employee_code` (`employee_code`);

--
-- Indexes for table `sub_dealer`
--
ALTER TABLE `sub_dealer`
  ADD PRIMARY KEY (`code`),
  ADD KEY `FK_sub_dealer_town_code` (`town_code`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`code`),
  ADD KEY `FK_supplier_town_code` (`town_code`);

--
-- Indexes for table `supplier_has_bank`
--
ALTER TABLE `supplier_has_bank`
  ADD PRIMARY KEY (`bank_code`,`supplier_code`),
  ADD KEY `FK_supplier_has_bank_supplier_code` (`supplier_code`);

--
-- Indexes for table `svat`
--
ALTER TABLE `svat`
  ADD PRIMARY KEY (`serial_number`),
  ADD KEY `FK_svat_supplier_code` (`supplier_code`);

--
-- Indexes for table `term`
--
ALTER TABLE `term`
  ADD PRIMARY KEY (`receipt`,`loan_code`),
  ADD KEY `FK_term_loan_code` (`loan_code`);

--
-- Indexes for table `tool_bar_button`
--
ALTER TABLE `tool_bar_button`
  ADD PRIMARY KEY (`component_name`);

--
-- Indexes for table `town`
--
ALTER TABLE `town`
  ADD PRIMARY KEY (`code`),
  ADD KEY `FK_town_root_area_code` (`root_area_code`);

--
-- Indexes for table `view_panel`
--
ALTER TABLE `view_panel`
  ADD PRIMARY KEY (`view_panel`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `general`
--
ALTER TABLE `general`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `FK_account_bank_code` FOREIGN KEY (`bank_code`) REFERENCES `bank` (`code`);

--
-- Constraints for table `canceled_invoice`
--
ALTER TABLE `canceled_invoice`
  ADD CONSTRAINT `FK_canceled_invoice_customer_code` FOREIGN KEY (`customer_code`) REFERENCES `customer` (`code`);

--
-- Constraints for table `canceled_invoice_has_item`
--
ALTER TABLE `canceled_invoice_has_item`
  ADD CONSTRAINT `FK_canceled_invoice_has_item_item_code` FOREIGN KEY (`item_code`) REFERENCES `item` (`code`),
  ADD CONSTRAINT `canceled_invoice_has_item_canceled_invoice_inv_no` FOREIGN KEY (`canceled_invoice_inv_no`) REFERENCES `canceled_invoice` (`inv_no`);

--
-- Constraints for table `cash_log`
--
ALTER TABLE `cash_log`
  ADD CONSTRAINT `FK_cash_log_cash_box_id` FOREIGN KEY (`cash_box_id`) REFERENCES `cash_box` (`id`);

--
-- Constraints for table `collection_receipt`
--
ALTER TABLE `collection_receipt`
  ADD CONSTRAINT `FK_collection_receipt_customer_code` FOREIGN KEY (`customer_code`) REFERENCES `customer` (`code`),
  ADD CONSTRAINT `FK_collection_receipt_sale_invoice_inv_no` FOREIGN KEY (`sale_invoice_inv_no`) REFERENCES `sale_invoice` (`inv_no`);

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `FK_customer_person_nic` FOREIGN KEY (`person_nic`) REFERENCES `person` (`nic`);

--
-- Constraints for table `damage_notes`
--
ALTER TABLE `damage_notes`
  ADD CONSTRAINT `FK_damage_notes_employee_code` FOREIGN KEY (`employee_code`) REFERENCES `employee` (`code`),
  ADD CONSTRAINT `FK_damage_notes_item_code` FOREIGN KEY (`item_code`) REFERENCES `item` (`code`);

--
-- Constraints for table `damage_stock`
--
ALTER TABLE `damage_stock`
  ADD CONSTRAINT `FK_damage_stock_item_code` FOREIGN KEY (`item_code`) REFERENCES `item` (`code`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `FK_employee_employee_position_code` FOREIGN KEY (`employee_position_code`) REFERENCES `employee_position` (`code`),
  ADD CONSTRAINT `FK_employee_person_nic` FOREIGN KEY (`person_nic`) REFERENCES `person` (`nic`);

--
-- Constraints for table `employee_has_root_area`
--
ALTER TABLE `employee_has_root_area`
  ADD CONSTRAINT `FK_employee_has_root_area_employee_code` FOREIGN KEY (`employee_code`) REFERENCES `employee` (`code`),
  ADD CONSTRAINT `FK_employee_has_root_area_root_area_code` FOREIGN KEY (`root_area_code`) REFERENCES `root_area` (`code`);

--
-- Constraints for table `expenses`
--
ALTER TABLE `expenses`
  ADD CONSTRAINT `FK_expenses_expenses_type_code` FOREIGN KEY (`expenses_type_code`) REFERENCES `expenses_type` (`code`);

--
-- Constraints for table `issued_cash`
--
ALTER TABLE `issued_cash`
  ADD CONSTRAINT `FK_issued_cash_bank_code` FOREIGN KEY (`bank_code`) REFERENCES `bank` (`code`),
  ADD CONSTRAINT `FK_issued_cash_purchase_invoice_inv_no` FOREIGN KEY (`purchase_invoice_inv_no`,`purchase_invoice_supplier_code`) REFERENCES `purchase_invoice` (`inv_no`, `supplier_code`);

--
-- Constraints for table `issued_cheque`
--
ALTER TABLE `issued_cheque`
  ADD CONSTRAINT `FK_issued_cheque_account_bank_code` FOREIGN KEY (`account_bank_code`,`account_account_no`) REFERENCES `account` (`bank_code`, `account_no`);

--
-- Constraints for table `issued_cheque_has_purchase_invoice`
--
ALTER TABLE `issued_cheque_has_purchase_invoice`
  ADD CONSTRAINT `issuedchequehaspurchaseinvoicepurchaseinvoiceinvno` FOREIGN KEY (`purchase_invoice_inv_no`,`purchase_invoice_supplier_code`) REFERENCES `purchase_invoice` (`inv_no`, `supplier_code`),
  ADD CONSTRAINT `ssedchequehaspurchaseinvoicessedchequechequenumber` FOREIGN KEY (`issued_cheque_cheque_number`) REFERENCES `issued_cheque` (`cheque_number`);

--
-- Constraints for table `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `FK_item_item_type_type` FOREIGN KEY (`item_type_type`) REFERENCES `item_type` (`type`),
  ADD CONSTRAINT `FK_item_supplier_code` FOREIGN KEY (`supplier_code`) REFERENCES `supplier` (`code`);

--
-- Constraints for table `item_has_price`
--
ALTER TABLE `item_has_price`
  ADD CONSTRAINT `FK_item_has_price_item_code` FOREIGN KEY (`item_code`) REFERENCES `item` (`code`),
  ADD CONSTRAINT `FK_item_has_price_price_type_type` FOREIGN KEY (`price_type_type`) REFERENCES `price_type` (`type`);

--
-- Constraints for table `loan`
--
ALTER TABLE `loan`
  ADD CONSTRAINT `FK_loan_bank_code` FOREIGN KEY (`bank_code`) REFERENCES `bank` (`code`);

--
-- Constraints for table `menu_item`
--
ALTER TABLE `menu_item`
  ADD CONSTRAINT `FK_menu_item_menu_menu` FOREIGN KEY (`menu_menu`) REFERENCES `menu` (`menu`);

--
-- Constraints for table `old_price`
--
ALTER TABLE `old_price`
  ADD CONSTRAINT `FK_old_price_item_code` FOREIGN KEY (`item_code`) REFERENCES `item` (`code`),
  ADD CONSTRAINT `FK_old_price_item_has_price_price_type_type` FOREIGN KEY (`item_has_price_price_type_type`,`item_has_price_item_code`) REFERENCES `item_has_price` (`price_type_type`, `item_code`);

--
-- Constraints for table `operator`
--
ALTER TABLE `operator`
  ADD CONSTRAINT `FK_operator_employee_code` FOREIGN KEY (`employee_code`) REFERENCES `employee` (`code`);

--
-- Constraints for table `operator_deleted`
--
ALTER TABLE `operator_deleted`
  ADD CONSTRAINT `FK_operator_deleted_employee_code` FOREIGN KEY (`employee_code`) REFERENCES `employee` (`code`);

--
-- Constraints for table `operator_has_view_panel`
--
ALTER TABLE `operator_has_view_panel`
  ADD CONSTRAINT `FK_operator_has_view_panel_operator_username` FOREIGN KEY (`operator_username`) REFERENCES `operator` (`username`),
  ADD CONSTRAINT `FK_operator_has_view_panel_view_panel_view_panel` FOREIGN KEY (`view_panel_view_panel`) REFERENCES `view_panel` (`view_panel`);

--
-- Constraints for table `optional_component`
--
ALTER TABLE `optional_component`
  ADD CONSTRAINT `FK_optional_component_view_panel_view_panel` FOREIGN KEY (`view_panel_view_panel`) REFERENCES `view_panel` (`view_panel`);

--
-- Constraints for table `price_list`
--
ALTER TABLE `price_list`
  ADD CONSTRAINT `FK_price_list_item_code` FOREIGN KEY (`item_code`) REFERENCES `item` (`code`);

--
-- Constraints for table `purchase_invoice`
--
ALTER TABLE `purchase_invoice`
  ADD CONSTRAINT `FK_purchase_invoice_supplier_code` FOREIGN KEY (`supplier_code`) REFERENCES `supplier` (`code`);

--
-- Constraints for table `purchase_invoice_has_item`
--
ALTER TABLE `purchase_invoice_has_item`
  ADD CONSTRAINT `FK_purchase_invoice_has_item_item_code` FOREIGN KEY (`item_code`) REFERENCES `item` (`code`),
  ADD CONSTRAINT `purchase_invoice_has_item_purchase_invoice_inv_no` FOREIGN KEY (`purchase_invoice_inv_no`,`purchase_invoice_supplier_code`) REFERENCES `purchase_invoice` (`inv_no`, `supplier_code`);

--
-- Constraints for table `quotation`
--
ALTER TABLE `quotation`
  ADD CONSTRAINT `FK_quotation_customer_code` FOREIGN KEY (`customer_code`) REFERENCES `customer` (`code`);

--
-- Constraints for table `quotation_has_item`
--
ALTER TABLE `quotation_has_item`
  ADD CONSTRAINT `FK_quotation_has_item_item_code` FOREIGN KEY (`item_code`) REFERENCES `item` (`code`),
  ADD CONSTRAINT `FK_quotation_has_item_quotation_quotation_no` FOREIGN KEY (`quotation_quotation_no`) REFERENCES `quotation` (`quotation_no`);

--
-- Constraints for table `rep_sale`
--
ALTER TABLE `rep_sale`
  ADD CONSTRAINT `FK_rep_sale_employee_code` FOREIGN KEY (`employee_code`) REFERENCES `employee` (`code`),
  ADD CONSTRAINT `FK_rep_sale_item_code` FOREIGN KEY (`item_code`) REFERENCES `item` (`code`);

--
-- Constraints for table `rep_sale_value`
--
ALTER TABLE `rep_sale_value`
  ADD CONSTRAINT `FK_rep_sale_value_employee_code` FOREIGN KEY (`employee_code`) REFERENCES `employee` (`code`);

--
-- Constraints for table `rep_stock_change`
--
ALTER TABLE `rep_stock_change`
  ADD CONSTRAINT `FK_rep_stock_change_employee_code` FOREIGN KEY (`employee_code`) REFERENCES `employee` (`code`),
  ADD CONSTRAINT `FK_rep_stock_change_item_code` FOREIGN KEY (`item_code`) REFERENCES `item` (`code`);

--
-- Constraints for table `sale_cash`
--
ALTER TABLE `sale_cash`
  ADD CONSTRAINT `FK_sale_cash_collection_receipt_receipt_number` FOREIGN KEY (`collection_receipt_receipt_number`) REFERENCES `collection_receipt` (`receipt_number`);

--
-- Constraints for table `sale_cheque`
--
ALTER TABLE `sale_cheque`
  ADD CONSTRAINT `FK_sale_cheque_account_bank_code` FOREIGN KEY (`account_bank_code`,`account_account_no`) REFERENCES `account` (`bank_code`, `account_no`),
  ADD CONSTRAINT `FK_sale_cheque_bank_code` FOREIGN KEY (`bank_code`) REFERENCES `bank` (`code`),
  ADD CONSTRAINT `FK_sale_cheque_collection_receipt_receipt_number` FOREIGN KEY (`collection_receipt_receipt_number`) REFERENCES `collection_receipt` (`receipt_number`);

--
-- Constraints for table `sale_invoice`
--
ALTER TABLE `sale_invoice`
  ADD CONSTRAINT `FK_sale_invoice_customer_code` FOREIGN KEY (`customer_code`) REFERENCES `customer` (`code`),
  ADD CONSTRAINT `FK_sale_invoice_employee_code` FOREIGN KEY (`employee_code`) REFERENCES `employee` (`code`);

--
-- Constraints for table `sale_invoice_has_item`
--
ALTER TABLE `sale_invoice_has_item`
  ADD CONSTRAINT `FK_sale_invoice_has_item_item_code` FOREIGN KEY (`item_code`) REFERENCES `item` (`code`),
  ADD CONSTRAINT `FK_sale_invoice_has_item_sale_invoice_inv_no` FOREIGN KEY (`sale_invoice_inv_no`) REFERENCES `sale_invoice` (`inv_no`);

--
-- Constraints for table `sr_sales_payments`
--
ALTER TABLE `sr_sales_payments`
  ADD CONSTRAINT `FK_sr_sales_payments_employee_code` FOREIGN KEY (`employee_code`) REFERENCES `employee` (`code`);

--
-- Constraints for table `sr_stock`
--
ALTER TABLE `sr_stock`
  ADD CONSTRAINT `FK_sr_stock_employee_code` FOREIGN KEY (`employee_code`) REFERENCES `employee` (`code`),
  ADD CONSTRAINT `FK_sr_stock_item_code` FOREIGN KEY (`item_code`) REFERENCES `item` (`code`);

--
-- Constraints for table `stock`
--
ALTER TABLE `stock`
  ADD CONSTRAINT `FK_stock_item_code` FOREIGN KEY (`item_code`) REFERENCES `item` (`code`);

--
-- Constraints for table `stock_change`
--
ALTER TABLE `stock_change`
  ADD CONSTRAINT `FK_stock_change_item_code` FOREIGN KEY (`item_code`) REFERENCES `item` (`code`),
  ADD CONSTRAINT `FK_stock_change_stock_change_summery_change_date` FOREIGN KEY (`stock_change_summery_change_date`) REFERENCES `stock_change_summery` (`change_date`);

--
-- Constraints for table `stock_transfer`
--
ALTER TABLE `stock_transfer`
  ADD CONSTRAINT `FK_stock_transfer_employee_code` FOREIGN KEY (`employee_code`) REFERENCES `employee` (`code`),
  ADD CONSTRAINT `FK_stock_transfer_item_code` FOREIGN KEY (`item_code`) REFERENCES `item` (`code`);

--
-- Constraints for table `sub_dealer`
--
ALTER TABLE `sub_dealer`
  ADD CONSTRAINT `FK_sub_dealer_town_code` FOREIGN KEY (`town_code`) REFERENCES `town` (`code`);

--
-- Constraints for table `supplier`
--
ALTER TABLE `supplier`
  ADD CONSTRAINT `FK_supplier_town_code` FOREIGN KEY (`town_code`) REFERENCES `town` (`code`);

--
-- Constraints for table `supplier_has_bank`
--
ALTER TABLE `supplier_has_bank`
  ADD CONSTRAINT `FK_supplier_has_bank_bank_code` FOREIGN KEY (`bank_code`) REFERENCES `bank` (`code`),
  ADD CONSTRAINT `FK_supplier_has_bank_supplier_code` FOREIGN KEY (`supplier_code`) REFERENCES `supplier` (`code`);

--
-- Constraints for table `svat`
--
ALTER TABLE `svat`
  ADD CONSTRAINT `FK_svat_supplier_code` FOREIGN KEY (`supplier_code`) REFERENCES `supplier` (`code`);

--
-- Constraints for table `term`
--
ALTER TABLE `term`
  ADD CONSTRAINT `FK_term_loan_code` FOREIGN KEY (`loan_code`) REFERENCES `loan` (`code`);

--
-- Constraints for table `town`
--
ALTER TABLE `town`
  ADD CONSTRAINT `FK_town_root_area_code` FOREIGN KEY (`root_area_code`) REFERENCES `root_area` (`code`);
