use WideWorldImporters;
-- Ejecuta tu consulta
SET STATISTICS IO ON;
SET STATISTICS TIME ON;

select * from sales.Customers;
select * from sales.Orders;

-- Consulta comun para buscar una coincidencia con like
select 
    c.customername,
    o.orderid,
    o.orderdate,
    o.expecteddeliverydate,
    ol.stockitemid,
    si.stockitemname,
    ol.quantity,
    ol.unitprice,
    (ol.quantity * ol.unitprice) as linetotal
from sales.customers c
inner join sales.orders o on c.customerid = o.customerid
inner join sales.orderlines ol on o.orderid = ol.orderid
inner join warehouse.stockitems si on ol.stockitemid = si.stockitemid
where c.customername like '%tailspin%'  -- busca exactamente "tailspin"
   or si.stockitemname like '%usb%'  
order by o.expecteddeliverydate, c.customername;


-- Verificar instalacion del servicio de Búsqueda de Texto Completo
select SERVERPROPERTY('IsFullTextInstalled') as IsFullTextInstalled;

-- Crear el "CATALOGO" - como una CARPETA ESPECIAL
--    donde SQL Server guarda los indices de busqueda
if NOT EXISTS (select 1 from sys.fulltext_catalogs where name = 'FTCatalog')
begin
    create fulltext catalog FTCatalog as default;  -- Crea la carpeta especial
    print 'Catálogo de texto completo creado';  
end

-- Crea INDICE en Customers - Esto es como crear un "INDICE DE LIBRO" pero para texto
-- que indica donde esta las palabras importantes
if NOT EXISTS (select 1 from sys.fulltext_indexes where object_id = OBJECT_ID('Sales.Customers'))
begin
    create fulltext index on Sales.Customers (CustomerName) -- En qué columna buscar
    key index PK_Sales_Customers -- La llave primaria (como el indice del libro)
    with change_tracking auto; -- Que se actualice automaticamente
    print 'Índice de texto completo creado en Sales.Customers';
end

-- Para la tabla Warehouse.StockItems (en StockItemName)
if NOT EXISTS (select 1 from sys.fulltext_indexes where object_id = OBJECT_ID('Warehouse.StockItems'))
begin
    create fulltext index on Warehouse.StockItems (StockItemName)
    key index PK_Warehouse_StockItems
    with change_tracking auto;
    print 'Índice de texto completo creado en Warehouse.StockItems';
end

-- DECLARAR VARIABLE
-- Es como una cajita donde se guarda un valor para usarlo despues
-- Buscar un nombre
declare @SearchTerm nvarchar(100) = 'Tailspin';  -- Cajita llamada @SearchTerm con valor 'Tailspin'

select 
    c.CustomerName,
    o.OrderID,
    o.OrderDate,
    o.ExpectedDeliveryDate,
    ol.StockItemID,
    si.StockItemName,
    ol.Quantity,
    ol.UnitPrice,
    (ol.Quantity * ol.UnitPrice) as LineTotal
from sales.customers c
inner join freetexttable(sales.customers, customername, @searchterm) as ft on c.customerid = ft.[key]
-- freetexttable = funcion especial que busca en texto
-- sales.customers = tabla donde buscar
-- customername = columna donde buscar  
-- @searchterm = lo que quieres buscar ('tailspin')
-- ft = le pones un "alias" a la tabla temporal que devuelve
-- [key] = es la columna que contiene el id del registro encontrado
inner join sales.orders o on c.customerid = o.customerid
inner join sales.orderlines ol on o.orderid = ol.orderid
inner join warehouse.stockitems si on ol.stockitemid = si.stockitemid
order by o.expecteddeliverydate asc;

-- buscar productos por nombre
declare @searchterm nvarchar(100) = 'usb'; -- ejemplo de busqueda

select 
    c.customername,
    o.orderid,
    o.orderdate,
    o.expecteddeliverydate,
    ol.stockitemid,
    si.stockitemname,
    ol.quantity,
    ol.unitprice,
    (ol.quantity * ol.unitprice) as linetotal
from warehouse.stockitems si
inner join freetexttable(warehouse.stockitems, stockitemname, @searchterm) as ft on si.stockitemid = ft.[key]
inner join sales.orderlines ol on si.stockitemid = ol.stockitemid
inner join sales.orders o on ol.orderid = o.orderid
inner join sales.customers c on o.customerid = c.customerid
order by o.expecteddeliverydate asc;

-- buscar en nombres de clientes y productos
declare @customersearch nvarchar(100) = 'tailspin';
declare @productsearch nvarchar(100) = 'usb';

select 
    c.customername,
    o.orderid,
    o.orderdate,
    o.expecteddeliverydate,
    ol.stockitemid,
    si.stockitemname,
    ol.quantity,
    ol.unitprice,
    (ol.quantity * ol.unitprice) as linetotal
from sales.customers c
left join freetexttable(sales.customers, customername, @customersearch) as ftc on c.customerid = ftc.[key]
inner join sales.orders o on c.customerid = o.customerid
inner join sales.orderlines ol on o.orderid = ol.orderid
inner join warehouse.stockitems si on ol.stockitemid = si.stockitemid
left join freetexttable(warehouse.stockitems, stockitemname, @productsearch) as fts on si.stockitemid = fts.[key]
where c.customerid in (
    select [key] from freetexttable(sales.customers, customername, 'tailspin')
)
order by o.expecteddeliverydate;
