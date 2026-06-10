-- 16. Unregistered Active Users
-- Find users who created an account in the last 30 days but haven’t registered for any events.

SELECT 
    u.user_id, 
    u.full_name, 
    u.email
FROM Users u
LEFT JOIN Registrations r ON u.user_id = r.user_id
WHERE u.registration_date >= DATE_SUB(CURDATE(), INTERVAL 30 DAY)
  AND r.registration_id IS NULL;
