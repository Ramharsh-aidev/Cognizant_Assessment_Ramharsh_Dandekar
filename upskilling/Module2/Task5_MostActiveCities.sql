-- 5. Most Active Cities
-- List the top 5 cities with the highest number of distinct user registrations.

SELECT 
    u.city, 
    COUNT(DISTINCT r.user_id) AS distinct_registered_users
FROM Users u
JOIN Registrations r ON u.user_id = r.user_id
GROUP BY u.city
ORDER BY distinct_registered_users DESC
LIMIT 5;
