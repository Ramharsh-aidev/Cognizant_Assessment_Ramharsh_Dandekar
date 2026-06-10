-- 17. Multi-Session Speakers
-- Identify speakers who are handling more than one session across all events.

SELECT 
    speaker_name, 
    COUNT(session_id) AS total_sessions_handled
FROM Sessions
GROUP BY speaker_name
HAVING total_sessions_handled > 1;
