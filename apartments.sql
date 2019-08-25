SELECT * FROM (
SELECT TenantApartments.TenantID, Tenants.TenantName, COUNT(TenantApartments.ApartmentID) as apt_count  
FROM TenantApartments
JOIN Tenants
ON Tenants.TenantID = TenantApartments.TenantID
GROUP BY Tenants.TenantName, TenantApartments.TenantID) t
WHERE t.apt_count > 1;

SELECT Tenants.TenantID, Tenants.TenantName 
FROM Tenants
JOIN (
SELECT TenantApartments.TenantID
FROM TenantApartments
GROUP BY (TenantApartments.TenantID)
HAVING COUNT(TenantApartments.ApartmentID) > 1) t
ON Tenants.TenantID = t.TenantID;

SELECT Buildings.BuildingID, IFNULL(num_requests,0) as Num_Requests
FROM Buildings
LEFT JOIN
(SELECT Apartments.BuildingID, count(*) as num_requests
FROM Requests
JOIN Apartments
ON Requests.ApartmentID = Apartments.ApartmentID
WHERE Requests.Status = "Open"
GROUP BY Apartments.BuildingID) c
ON Buildings.BuildingID = c.BuildingID;

SET SQL_SAFE_UPDATES = 0;
UPDATE Requests
SET
Status = "Closed"
WHERE Requests.ApartmentID IN (
	SELECT ApartmentID
    FROM Apartments
    WHERE Apartments.BuildingID = 7665
);

select * from requests;










